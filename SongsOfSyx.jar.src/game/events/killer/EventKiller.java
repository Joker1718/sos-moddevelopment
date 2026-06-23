/*     */ package game.events.killer;
/*     */ 
/*     */ import game.events.EVENTS;
/*     */ import game.time.TIME;
/*     */ import init.paths.PATH;
/*     */ import init.paths.PATHS;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.type.CAUSE_LEAVES;
/*     */ import init.type.CRIMES;
/*     */ import init.type.CRIME_PUNISHMENTS;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.HTYPES;
/*     */ import java.io.IOException;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.types.prisoner.AIModule_Prisoner;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.thing.ThingsCorpses;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import util.data.DOUBLE;
/*     */ import view.sett.IDebugPanelSett;
/*     */ 
/*     */ public final class EventKiller
/*     */   extends EVENTS.EventResource
/*     */ {
/*  38 */   private final Messenger messages = new Messenger();
/*  39 */   private final Messenger.Data mData = new Messenger.Data();
/*  40 */   private static final double interval = (TIME.secondsPerDay() * 16 * 24);
/*     */   private final LIST<KillerType> killerTypes;
/*     */   private int[] typeShuffle;
/*  43 */   private DOUBLE.DoubleImp timer = new DOUBLE.DoubleImp();
/*     */   
/*  45 */   private int type = 0;
/*     */   private int day;
/*     */   private boolean dormant;
/*  48 */   private int killerID = -1;
/*  49 */   private int suspect = -1;
/*  50 */   private int victimRace = -1;
/*     */   private int victims;
/*     */   private double rate;
/*  53 */   private static double rateSpeed = 1.0D / (TIME.secondsPerDay() * 8);
/*     */   
/*     */   public EventKiller() {
/*  56 */     super("KILLER");
/*  57 */     LinkedList<KillerType> ks = new LinkedList();
/*  58 */     PATH pp = PATHS.TEXT_MISC().getFolder("serialKiller"); byte b; int i; String[] arrayOfString;
/*  59 */     for (i = (arrayOfString = pp.getFiles()).length, b = 0; b < i; ) { String k = arrayOfString[b];
/*  60 */       ks.add(new KillerType(new Json(pp.gets(k)))); b++; }
/*     */     
/*  62 */     this.killerTypes = (LIST<KillerType>)new ArrayList((Iterable)ks);
/*  63 */     this.typeShuffle = Alloc.ii(this.killerTypes.size());
/*  64 */     shuffle();
/*     */     
/*  66 */     clear();
/*     */     
/*  68 */     IDebugPanelSett.add("Event Serial killer", new ACTION()
/*     */         {
/*     */           public void exe()
/*     */           {
/*  72 */             EventKiller.this.init();
/*  73 */             if (EventKiller.this.theKiller() == null)
/*  74 */               LOG.ln("nay"); 
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   private void shuffle() {
/*     */     int i;
/*  81 */     for (i = 0; i < this.typeShuffle.length; i++) {
/*  82 */       this.typeShuffle[i] = i;
/*     */     }
/*  84 */     for (i = 0; i < this.typeShuffle.length; i++) {
/*  85 */       int i2 = RND.rInt(this.typeShuffle.length);
/*  86 */       int v = this.typeShuffle[i];
/*  87 */       this.typeShuffle[i] = this.typeShuffle[i2];
/*  88 */       this.typeShuffle[i2] = v;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void save(FilePutter file) {
/*  94 */     this.timer.save(file);
/*  95 */     file.i(this.type);
/*  96 */     file.i(this.day);
/*  97 */     file.bool(this.dormant);
/*  98 */     file.i(this.killerID);
/*  99 */     file.i(this.suspect);
/* 100 */     file.i(this.victimRace);
/* 101 */     file.i(this.victims);
/* 102 */     file.d(this.rate);
/* 103 */     file.isE(this.typeShuffle);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void load(FileGetter file) throws IOException {
/* 108 */     this.timer.load(file);
/* 109 */     this.type = file.i();
/* 110 */     this.day = file.i();
/* 111 */     this.dormant = file.bool();
/* 112 */     this.killerID = file.i();
/* 113 */     this.suspect = file.i();
/* 114 */     this.victimRace = file.i();
/* 115 */     this.victims = file.i();
/* 116 */     this.rate = file.d();
/* 117 */     if (!file.isE(this.typeShuffle))
/* 118 */       shuffle(); 
/* 119 */     this.type = CLAMP.i(this.type, 0, this.killerTypes.size());
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clear() {
/* 124 */     reset();
/* 125 */     this.rate = 0.0D;
/*     */   }
/*     */   
/*     */   private void reset() {
/* 129 */     this.dormant = true;
/* 130 */     this.suspect = -1;
/* 131 */     this.victims = 0;
/* 132 */     this.timer.setD(interval);
/* 133 */     this.timer.incD(interval * 0.5D * RND.rFloat());
/*     */   }
/*     */   
/*     */   private void init() {
/* 137 */     this.killerID = Util.pickKiller();
/* 138 */     this.victimRace = Util.pickRace();
/* 139 */     this.victims = 0;
/* 140 */     this.rate = 0.0D;
/* 141 */     this.suspect = -1;
/*     */     
/* 143 */     this.type++;
/* 144 */     this.type %= this.typeShuffle.length;
/* 145 */     this.timer.setD(-1.0D);
/* 146 */     if (theKiller() == null) {
/* 147 */       reset();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void update(double ds) {
/* 154 */     if (this.timer.getD() > 0.0D) {
/* 155 */       if (ds > 0.0D)
/* 156 */         this.timer.incD(-ds); 
/* 157 */       if (this.timer.getD() < 0.0D) {
/* 158 */         if ((SETT.ROOMS()).PRISON.instancesSize() > 0) {
/* 159 */           init();
/*     */         } else {
/* 161 */           reset();
/*     */         } 
/*     */       }
/*     */       
/* 165 */       if (this.rate > 0.0D) {
/* 166 */         this.rate -= ds * rateSpeed;
/* 167 */         this.rate = CLAMP.d(this.rate, 0.0D, 1.0D);
/* 168 */         if (this.rate <= 0.0D) {
/* 169 */           setData(null);
/* 170 */           this.messages.over(this.mData);
/*     */         } 
/*     */       } 
/*     */       
/*     */       return;
/*     */     } 
/* 176 */     if (this.suspect != -1 && 
/* 177 */       this.day != TIME.days().bitsSinceStart()) {
/* 178 */       ENTITY e = SETT.ENTITIES().getByID(this.suspect);
/* 179 */       if (e != null && e instanceof Humanoid) {
/* 180 */         if (theKiller() == e) {
/* 181 */           setData(null);
/* 182 */           (STATS.LAW()).prisonerType.set(this.mData.suspect.indu(), CRIMES.MURDER());
/* 183 */           this.mData.suspect.HTypeSet(HTYPES.PRISONER(), CAUSE_LEAVES.PUNISHED(), null);
/* 184 */           this.messages.caught(this.mData);
/*     */           
/* 186 */           (AIModule_Prisoner.DATA()).punishmentSet.set(((Humanoid)e).ai(), CRIME_PUNISHMENTS.EXECUTE());
/* 187 */           clear();
/*     */         } else {
/* 189 */           this.rate += 0.2D;
/* 190 */           this.rate = CLAMP.d(this.rate, 0.0D, 1.0D);
/* 191 */           setData(null);
/* 192 */           this.messages.fail(this.mData);
/* 193 */           this.suspect = -1;
/*     */         } 
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 199 */     if (theKiller() == null) {
/* 200 */       reset(); return;
/*     */     } 
/* 202 */     if (theKiller().indu().hType() == HTYPES.PRISONER()) {
/* 203 */       setData(null);
/* 204 */       this.messages.caught(this.mData);
/* 205 */       (AIModule_Prisoner.DATA()).punishmentSet.set(theKiller().ai(), CRIME_PUNISHMENTS.EXECUTE());
/* 206 */       clear();
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 211 */     if (this.day != TIME.days().bitsSinceStart()) {
/* 212 */       this.dormant = !RND.oneIn(3);
/* 213 */       this.day = TIME.days().bitsSinceStart();
/*     */     } 
/*     */     
/* 216 */     this.rate = this.victims / (type()).messages.length;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public KillerType type() {
/* 223 */     return (KillerType)this.killerTypes.get(this.typeShuffle[this.type]);
/*     */   }
/*     */ 
/*     */   
/*     */   public Humanoid theKiller() {
/* 228 */     if (this.killerID == -1)
/* 229 */       return null; 
/* 230 */     ENTITY e = SETT.ENTITIES().getByID(this.killerID);
/* 231 */     if (e instanceof Humanoid) {
/* 232 */       Humanoid a = (Humanoid)e;
/* 233 */       if (a.indu().clas() == HCLASSES.CITIZEN() || a.indu().hType() == HTYPES.PRISONER())
/* 234 */         return a; 
/*     */     } 
/* 236 */     return null;
/*     */   }
/*     */   
/*     */   public boolean theKillerShouldKill() {
/* 240 */     return !this.dormant;
/*     */   }
/*     */   
/*     */   public Race victimRace() {
/* 244 */     if (this.victimRace == -1)
/* 245 */       return null; 
/* 246 */     return (Race)RACES.all().get(this.victimRace);
/*     */   }
/*     */   
/*     */   public int murders() {
/* 250 */     return this.victims;
/*     */   }
/*     */   
/*     */   public void setSuspect(int suspect) {
/* 254 */     this.suspect = suspect;
/* 255 */     this.day = TIME.days().bitsSinceStart();
/*     */   }
/*     */   
/*     */   int suspect() {
/* 259 */     return this.suspect;
/*     */   }
/*     */   
/*     */   public void reportKill(ThingsCorpses.Corpse corpse) {
/* 263 */     this.victims++;
/* 264 */     this.dormant = true;
/* 265 */     if (this.victims > (type()).messages.length) {
/* 266 */       reset();
/*     */       
/*     */       return;
/*     */     } 
/* 270 */     if (this.victims == (type()).messages.length / 2) {
/* 271 */       int suspect = this.killerID;
/* 272 */       if (RND.rBoolean())
/* 273 */         suspect = Util.pickKiller(); 
/* 274 */       if (suspect != -1) {
/*     */         
/* 276 */         setData(corpse);
/* 277 */         this.mData.suspect = (Humanoid)SETT.ENTITIES().getByID(suspect);
/* 278 */         this.messages.murderSuspect(this.mData);
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/* 283 */     setData(corpse);
/* 284 */     this.messages.murder(this.mData);
/*     */     
/* 286 */     this.rate = (this.victims - 1) / ((type()).messages.length - 1);
/* 287 */     if (this.victims >= (type()).messages.length) {
/* 288 */       reset();
/*     */     }
/*     */   }
/*     */   
/*     */   void setData(ThingsCorpses.Corpse corpse) {
/* 293 */     this.mData.killer = theKiller();
/* 294 */     this.mData.type = type();
/* 295 */     this.mData.murders = this.victims;
/* 296 */     this.mData.race = victimRace();
/* 297 */     this.mData.suspect = this.mData.killer;
/* 298 */     this.mData.victim = corpse;
/*     */   }
/*     */   
/*     */   public double rate() {
/* 302 */     return this.rate;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\events\killer\EventKiller.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */