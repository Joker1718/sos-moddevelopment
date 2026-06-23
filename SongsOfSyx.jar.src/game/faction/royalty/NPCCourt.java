/*     */ package game.faction.royalty;
/*     */ 
/*     */ import game.GameDisposable;
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.npc.NPCResource;
/*     */ import game.time.TIME;
/*     */ import init.race.Race;
/*     */ import init.sprite.UI.UI;
/*     */ import java.io.IOException;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.text.D;
/*     */ import world.WORLD;
/*     */ import world.region.RD;
/*     */ import world.region.pop.RDRace;
/*     */ 
/*     */ public final class NPCCourt
/*     */   extends NPCResource {
/*     */   public static final int MAX = 4;
/*  32 */   private final King king = new King(this);
/*  33 */   final ArrayList<Royalty> all = new ArrayList(4);
/*     */   public final FactionNPC faction;
/*  35 */   private double addT = 0.0D;
/*     */   
/*  37 */   private static CharSequence ¤¤sucession = "{0} ascends the throne of {1}, succeeding the old leader, {2}.";
/*     */   
/*     */   static {
/*  40 */     D.ts(NPCCourt.class);
/*     */   }
/*     */   
/*     */   public NPCCourt(FactionNPC faction, LISTE<NPCResource> all) {
/*  44 */     super(all);
/*  45 */     this.faction = faction;
/*     */   }
/*     */   
/*     */   public LIST<Royalty> all() {
/*  49 */     return (LIST<Royalty>)this.all;
/*     */   }
/*     */   
/*     */   public King king() {
/*  53 */     return this.king;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected SAVABLE saver() {
/*  59 */     return new SAVABLE()
/*     */       {
/*     */ 
/*     */         
/*     */         public void save(FilePutter file)
/*     */         {
/*  65 */           file.i(NPCCourt.this.all.size());
/*  66 */           for (Royalty r : NPCCourt.this.all) {
/*  67 */             r.save(file);
/*     */           }
/*  69 */           NPCCourt.this.king.save(file);
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void load(FileGetter file) throws IOException {
/*  77 */           int k = file.i();
/*  78 */           NPCCourt.this.all.clear();
/*  79 */           for (int i = 0; i < k; i++) {
/*  80 */             NPCCourt.this.all.add(new Royalty(NPCCourt.this, file));
/*     */           }
/*  82 */           NPCCourt.this.king.load(NPCCourt.this, file);
/*     */         }
/*     */ 
/*     */         
/*     */         public void clear() {
/*  87 */           NPCCourt.this.all.clear();
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   protected void update(FactionNPC faction, double seconds) {
/*  94 */     this.addT += seconds;
/*  95 */     if (this.addT > TIME.secondsPerDay()) {
/*  96 */       for (int j = 0; j < this.all.size(); j++) {
/*  97 */         Royalty r = (Royalty)this.all.get(j);
/*  98 */         (STATS.POP()).age.DAYS.inc(r.induvidual, 1);
/*     */       } 
/*     */       
/* 101 */       this.addT -= TIME.secondsPerDay();
/* 102 */       if (RND.oneIn(16)) {
/* 103 */         addSuccessor();
/*     */       }
/*     */     } 
/* 106 */     for (int i = 0; i < this.all.size(); i++) {
/* 107 */       Royalty r = (Royalty)this.all.get(i);
/* 108 */       r.update(seconds);
/* 109 */       if (TIME.days().bitsSinceStart() > r.deathDay) {
/* 110 */         kill(r);
/* 111 */         i--;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addSuccessor() {
/* 119 */     if (!this.all.hasRoom())
/*     */       return; 
/* 121 */     Royalty r = newSuccessor((this.king.roy()).induvidual.race());
/* 122 */     int i = this.all.size();
/* 123 */     this.all.add(r);
/* 124 */     for (RoyaltyEventListener l : RoyaltyEventListener.all) {
/* 125 */       l.change(i, r, null);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private Royalty newSuccessor(Race roy) {
/* 132 */     double tot = 0.0D;
/* 133 */     for (RDRace r : (RD.RACES()).all) {
/* 134 */       double d = roy.pref().race(roy);
/* 135 */       if (r.race == roy)
/* 136 */         d += ((RD.RACES()).all.size() * 16) - (12 * (RD.RACES()).all.size()) * (BOOSTABLES.NOBLE()).TOLERANCE.get((BOOSTABLE_O)(this.king.roy()).induvidual); 
/* 137 */       d *= r.pop.faction().get(this.faction);
/* 138 */       tot += d;
/*     */     } 
/* 140 */     tot *= RND.rFloat();
/* 141 */     for (RDRace r : (RD.RACES()).all) {
/* 142 */       double d = roy.pref().race(roy);
/* 143 */       if (r.race == roy)
/* 144 */         d += ((RD.RACES()).all.size() * 16) - (12 * (RD.RACES()).all.size()) * (BOOSTABLES.NOBLE()).TOLERANCE.get((BOOSTABLE_O)(this.king.roy()).induvidual); 
/* 145 */       d *= r.pop.faction().get(this.faction);
/* 146 */       tot -= d;
/* 147 */       if (tot <= 0.0D)
/* 148 */         return new Royalty(this, r.race); 
/*     */     } 
/* 150 */     return new Royalty(this, roy);
/*     */   }
/*     */ 
/*     */   
/*     */   void kill(Royalty r) {
/* 155 */     (STATS.APPEARANCE()).dead.indu().set(r.induvidual, 1);
/*     */     
/* 157 */     int si = r.successionI();
/*     */     
/* 159 */     CharSequence oldKing = String.valueOf(this.king.name);
/*     */ 
/*     */     
/* 162 */     for (int i = si; i < this.all.size(); i++) {
/* 163 */       for (RoyaltyEventListener l : RoyaltyEventListener.all)
/* 164 */         l.change(i, (Royalty)this.all.get(i), (i + 1 < this.all.size()) ? (Royalty)this.all.get(i + 1) : null); 
/*     */     } 
/* 166 */     this.all.removeOrdered(si);
/* 167 */     if (si == 0) {
/*     */       
/* 169 */       if (this.all.size() == 0) {
/* 170 */         Royalty rn = new Royalty(this, r.induvidual.race());
/* 171 */         this.all.add(rn);
/* 172 */         for (RoyaltyEventListener l : RoyaltyEventListener.all) {
/* 173 */           l.change(1, null, rn);
/*     */         }
/*     */       } 
/* 176 */       this.king.init();
/*     */       
/* 178 */       CharSequence newKing = String.valueOf(this.king.name);
/*     */       
/* 180 */       Str.TMP.clear().add(¤¤sucession);
/* 181 */       Str.TMP.insert(0, newKing);
/* 182 */       Str.TMP.insert(1, (CharSequence)this.faction.name);
/* 183 */       Str.TMP.insert(2, oldKing);
/* 184 */       WORLD.LOG().log(null, (Faction)this.faction, (UI.icons()).s.crown, (CharSequence)Str.TMP, this.faction.cx(), this.faction.cy());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void generate(RDRace race, FactionNPC faction, boolean fromScratch) {
/* 194 */     this.all.clear();
/* 195 */     this.all.add(new Royalty(this, race.race));
/* 196 */     while (this.all.hasRoom())
/* 197 */       addSuccessor(); 
/* 198 */     this.king.init();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void init() {
/* 205 */     if (this.all.size() == 0)
/* 206 */       this.all.add(new Royalty(this, ((RDRace)(RD.RACES()).all.get(0)).race)); 
/*     */   }
/*     */   
/*     */   public void promote(Royalty roy, boolean message) {
/* 210 */     if (!this.all.contains(roy))
/* 211 */       throw new RuntimeException(); 
/* 212 */     int i = this.all.indexOf(roy);
/* 213 */     for (RoyaltyEventListener l : RoyaltyEventListener.all)
/* 214 */       l.change(1, (Royalty)this.all.get(1), roy); 
/* 215 */     for (RoyaltyEventListener l : RoyaltyEventListener.all)
/* 216 */       l.change(i, roy, (Royalty)this.all.get(i)); 
/* 217 */     this.all.swap(1, i);
/*     */   }
/*     */   
/*     */   public Race race() {
/* 221 */     if (this.king.roy() == null)
/* 222 */       return FACTIONS.player().race(); 
/* 223 */     return (this.king.roy()).induvidual.race();
/*     */   }
/*     */   
/*     */   public static abstract class RoyaltyEventListener
/*     */   {
/* 228 */     private static ArrayListGrower<RoyaltyEventListener> all = new ArrayListGrower();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected RoyaltyEventListener() {
/* 240 */       all.add(this);
/*     */     }
/*     */     
/*     */     public abstract void change(int param1Int, Royalty param1Royalty1, Royalty param1Royalty2);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\royalty\NPCCourt.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */