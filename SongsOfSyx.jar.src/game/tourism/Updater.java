/*     */ package game.tourism;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.type.HTYPES;
/*     */ import java.io.IOException;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.colls.StatsNeeds;
/*     */ import settlement.stats.service.StatService;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.text.D;
/*     */ import util.updating.IUpdater;
/*     */ import view.sett.IDebugPanelSett;
/*     */ import view.ui.message.MessageText;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class Updater
/*     */   extends IUpdater
/*     */ {
/*     */   private final LIST<TRace> races;
/*  41 */   private int mI = 0;
/*  42 */   private static CharSequence ¤¤MessageFirst = "¤Our city is now impressive enough to attract our first tourist. A {RACE} pilgrim by the name of {NAME} has arrived. This particular tourist is looking for inn to stay, and wants to visit: {ATTRACTION} and {SERVICE}.";
/*  43 */   private final Coo entry = new Coo(-1.0D, -1.0D);
/*     */   
/*     */   static {
/*  46 */     D.ts(Updater.class);
/*     */   }
/*     */   
/*     */   Updater() {
/*  50 */     super(TOURISM.AMOUNT, (TIME.secondsPerDay() * 16));
/*  51 */     double tot = 0.0D;
/*     */     
/*  53 */     for (Race r : RACES.all()) {
/*  54 */       tot += (r.tourism()).occurence;
/*     */     }
/*     */     
/*  57 */     LinkedList<TRace> li = new LinkedList();
/*  58 */     for (Race r : RACES.all()) {
/*  59 */       if ((r.tourism()).occurence > 0.0D)
/*  60 */         li.add(new TRace(r, (r.tourism()).occurence / tot)); 
/*     */     } 
/*  62 */     this.races = (LIST<TRace>)new ArrayList((Iterable)li);
/*     */     
/*  64 */     IDebugPanelSett.add("TOURIST_SPAWN", new ACTION()
/*     */         {
/*     */           public void exe()
/*     */           {
/*  68 */             Race r = Updater.this.getRace();
/*  69 */             Humanoid h = Updater.this.pspawn(r, (RoomBlueprintIns)(r.tourism()).attractions.rnd());
/*  70 */             if (h == null) {
/*  71 */               LOG.ln("nope");
/*     */             } else {
/*  73 */               Updater.this.mess(h);
/*     */             } 
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void save(FilePutter file) {
/*  82 */     file.i(this.mI);
/*  83 */     super.save(file);
/*     */   }
/*     */ 
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/*  88 */     this.mI = file.i();
/*  89 */     super.load(file);
/*     */   }
/*     */ 
/*     */   
/*     */   private static class TRace
/*     */   {
/*     */     public final Race race;
/*     */     public final double occ;
/*     */     
/*     */     private TRace(Race race, double occ) {
/*  99 */       this.race = race;
/* 100 */       this.occ = occ;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void update(int index, double timeSinceLast) {
/* 108 */     double c = ((STATS.POP()).POP.data().get(null) - 500) / 40000.0D;
/*     */     
/* 110 */     c *= (0.25D + TOURISM.score()) * 1000.0D;
/*     */ 
/*     */     
/* 113 */     if (c < RND.rFloat()) {
/*     */       return;
/*     */     }
/*     */     
/* 117 */     if (!canAttract()) {
/*     */       return;
/*     */     }
/* 120 */     spawn();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double chance() {
/* 128 */     double chance = 0.0D;
/* 129 */     for (TRace r : this.races) {
/* 130 */       if (!TOURISM.permit(r.race))
/*     */         continue; 
/* 132 */       double att = 0.0D;
/* 133 */       for (RoomBlueprintIns<?> p : (r.race.tourism()).attractions) {
/* 134 */         att += p.employment().employed();
/*     */       }
/* 136 */       chance += r.occ * CLAMP.d(att / 1000.0D, 0.0D, 1.0D);
/*     */     } 
/* 138 */     double c = ((STATS.POP()).POP.data().get(null) - 500) / 500.0D;
/*     */     
/* 140 */     return chance * CLAMP.d(c, 0.0D, 1.0D);
/*     */   }
/*     */   
/*     */   private Race getRace() {
/* 144 */     double d = RND.rFloat() - 0.05D;
/* 145 */     for (TRace r : this.races) {
/* 146 */       d -= r.occ;
/* 147 */       if (d <= 0.0D) {
/* 148 */         return r.race;
/*     */       }
/*     */     } 
/* 151 */     return null;
/*     */   }
/*     */   
/*     */   private RoomBlueprintIns<?> getAttraction(Race race) {
/* 155 */     int em = 0;
/* 156 */     int most = 0;
/* 157 */     RoomBlueprintIns<?> best = null;
/* 158 */     int tot = 0;
/* 159 */     LIST<RoomBlueprintIns<?>> li = (race.tourism()).attractions;
/*     */     
/* 161 */     for (int bi = 0; bi < li.size(); bi++) {
/* 162 */       int e = ((RoomBlueprintIns)li.get(bi)).employment().employed();
/* 163 */       tot += e;
/* 164 */       if (e > 0) {
/* 165 */         em += e;
/* 166 */         if (e > most) {
/* 167 */           most = e;
/* 168 */           best = (RoomBlueprintIns)li.get(bi);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 173 */     if (most <= 0) {
/* 174 */       return null;
/*     */     }
/* 176 */     if (tot < 1000.0D * RND.rFloat()) {
/* 177 */       return null;
/*     */     }
/* 179 */     if ((em - most) / (race.tourism()).attractions.size() > RND.rInt(most)) {
/* 180 */       int other = (int)(RND.rFloat() * (em - most));
/* 181 */       for (int i = 0; i < li.size(); i++) {
/* 182 */         int e = ((RoomBlueprintIns)li.get(i)).employment().employed();
/* 183 */         if (e > 0) {
/* 184 */           other -= e;
/* 185 */           if (other <= 0)
/* 186 */             return (RoomBlueprintIns)li.get(i); 
/*     */         } 
/*     */       } 
/*     */     } 
/* 190 */     return best;
/*     */   }
/*     */   
/*     */   private boolean canAttract() {
/* 194 */     if (SETT.ENTRY().isClosed())
/* 195 */       return false; 
/* 196 */     COORDINATE c = (SETT.ENTRY()).points.randomReachable();
/* 197 */     if (c == null)
/* 198 */       return false; 
/* 199 */     this.entry.set(c);
/*     */     
/* 201 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private Humanoid spawn() {
/* 207 */     Race r = getRace();
/*     */     
/* 209 */     if (!TOURISM.permit(r)) {
/* 210 */       return null;
/*     */     }
/* 212 */     RoomBlueprintIns<?> a = getAttraction(r);
/*     */ 
/*     */     
/* 215 */     if (a != null) {
/* 216 */       Humanoid h = pspawn(r, a);
/* 217 */       if (h != null && this.mI < 2) {
/* 218 */         this.mI = 2;
/*     */         
/* 220 */         if (h != null) {
/* 221 */           mess(h);
/*     */         }
/*     */       } 
/* 224 */       return h;
/*     */     } 
/*     */ 
/*     */     
/* 228 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   private void mess(Humanoid h) {
/* 233 */     Str t = Str.TMP.clear().add(¤¤MessageFirst);
/* 234 */     t.insert("RACE", (h.race()).info.namePosessive);
/* 235 */     t.insert("NAME", STATS.APPEARANCE().name(h.indu()));
/* 236 */     t.insert("ATTRACTION", (attraction(h.indu())).info.name);
/* 237 */     t.insert("SERVICE", (TOURISM.service(h.indu())).name);
/*     */     
/* 239 */     (new MessageText((HTYPES.TOURIST()).names, (CharSequence)t)).send();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Humanoid pspawn(Race race, RoomBlueprintIns<?> blue) {
/* 248 */     if (!canAttract()) {
/* 249 */       return null;
/*     */     }
/*     */ 
/*     */     
/* 253 */     Humanoid h = new Humanoid(this.entry.x() * 64 + 32, this.entry.y() * 64 + 32, race, HTYPES.TOURIST(), null);
/*     */     
/* 255 */     if (h.isRemoved()) {
/* 256 */       return null;
/*     */     }
/* 258 */     (STATS.WORK()).profession.set(h.indu(), blue);
/* 259 */     StatService s = TOURISM.service(h.indu());
/* 260 */     if (s != null) {
/* 261 */       s.clearAccess(h.indu());
/*     */     }
/*     */     
/* 264 */     for (StatsNeeds.StatNeedNormal n : (STATS.NEEDS()).SNEEDS) {
/* 265 */       n.stat().indu().setD(h.indu(), 0.5D + RND.rFloat() * 0.5D);
/*     */     }
/*     */     
/* 268 */     TOURISM.self.history.inc(1);
/*     */     
/* 270 */     return h;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static RoomBlueprintIns<?> attraction(Induvidual indu) {
/* 276 */     RoomBlueprintImp r = (RoomBlueprintImp)(STATS.WORK()).profession.get(indu);
/* 277 */     if (r == null || !(r instanceof RoomBlueprintIns))
/* 278 */       return indu.race().tourism().getAttraction(0L); 
/* 279 */     return (RoomBlueprintIns)r;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\tourism\Updater.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */