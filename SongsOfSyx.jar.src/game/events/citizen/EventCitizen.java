/*     */ package game.events.citizen;
/*     */ 
/*     */ import game.VERSION;
/*     */ import game.events.EVENTS;
/*     */ import game.time.TIME;
/*     */ import game.time.TIMECYCLE;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.type.HCLASSES;
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.standing.STANDINGS;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import util.text.D;
/*     */ import view.sett.IDebugPanelSett;
/*     */ import view.ui.message.MessageText;
/*     */ 
/*     */ public final class EventCitizen
/*     */   extends EVENTS.EventResource {
/*     */   public static final double breakPoint = 0.85D;
/*  31 */   private static CharSequence ¤¤riotWarning = "¤Ungrateful plebs!";
/*  32 */   private static CharSequence ¤¤riotWarningD = "¤Rumour has it that your citizens are grinding their teeth in frustration over what they claim is your incompetent rule. If nothing is done in time, a riot might follow! Try to increase their loyalty immediately.";
/*     */   
/*  34 */   private static CharSequence ¤¤emigration = "¤Low loyalty!";
/*  35 */   private static CharSequence ¤¤emigrationD = "¤Some plebeians are displeased with your rule. As a result, they are packing their bags to leave. We must try to improve the loyalty of our plebeians, else we risk ever greater displays of dissatisfaction.";
/*     */ 
/*     */   
/*     */   static {
/*  39 */     D.ts(EventCitizen.class);
/*     */   }
/*     */   
/*     */   private boolean hasSentWarning = false;
/*  43 */   private final double timerD = 15.0D;
/*  44 */   private double timer = 15.0D;
/*  45 */   private double count = 5.0D;
/*  46 */   private int warmup = 3;
/*  47 */   private final double countD = 15.0D / TIME.secondsPerDay();
/*     */   
/*     */   private boolean emigrate;
/*  50 */   private final double emmiCountD = 100.0D / TIME.secondsPerDay() * TIME.years().bitConversion((TIMECYCLE)TIME.days());
/*  51 */   private final double[] emmiCount = new double[RACES.all().size()];
/*     */   
/*  53 */   private final EventCitizenEmmigrate emmi = new EventCitizenEmmigrate();
/*  54 */   private final EventCitizenStrike strike = new EventCitizenStrike();
/*  55 */   private final EventCitizenRiot riot = new EventCitizenRiot();
/*  56 */   private final EventCitizenRace brawl = new EventCitizenRace();
/*  57 */   private final EventCitizenRel rel = new EventCitizenRel();
/*     */   
/*  59 */   private final SMALL_EVENT[] all = new SMALL_EVENT[] {
/*  60 */       this.emmi, this.strike, this.brawl, this.rel
/*     */     };
/*     */   
/*  63 */   private final SMALL_EVENT[] tmp = new SMALL_EVENT[this.all.length];
/*     */   
/*  65 */   private final int[] amounts = Alloc.ii(RACES.all().size());
/*     */   
/*     */   public EventCitizen() {
/*  68 */     super("CITIZEN");
/*  69 */     clear();
/*     */     
/*  71 */     IDebugPanelSett.add("Event: Emmigration2", new ACTION()
/*     */         {
/*     */           public void exe()
/*     */           {
/*  75 */             double total = 0.0D;
/*  76 */             for (Race r : RACES.all()) {
/*  77 */               int a = EventCitizen.this.getAmount(r);
/*  78 */               total += a;
/*  79 */               EventCitizen.this.amounts[r.index()] = a;
/*     */             } 
/*     */ 
/*     */             
/*  83 */             double c = total / (STATS.POP()).POP.data(HCLASSES.CITIZEN()).get(null);
/*     */             
/*  85 */             if (c == 0.0D) {
/*  86 */               LOG.ln("nay!");
/*     */             } else {
/*  88 */               Race r = EventCitizen.this.getRace(total);
/*  89 */               EventCitizen.this.emmi.event(EventCitizen.this.amounts[r.index], r);
/*     */             } 
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void save(FilePutter file) {
/*  98 */     file.d(this.timer);
/*  99 */     file.d(this.count);
/* 100 */     file.bool(this.emigrate);
/* 101 */     file.bool(this.hasSentWarning);
/* 102 */     file.i(this.warmup); byte b; int i; SMALL_EVENT[] arrayOfSMALL_EVENT;
/* 103 */     for (i = (arrayOfSMALL_EVENT = this.all).length, b = 0; b < i; ) { SMALL_EVENT e = arrayOfSMALL_EVENT[b];
/* 104 */       e.save(file); b++; }
/*     */     
/* 106 */     this.riot.save(file);
/* 107 */     RACES.map().saver().save(this.emmiCount, file);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void load(FileGetter file) throws IOException {
/* 113 */     this.timer = file.d();
/* 114 */     this.count = file.d();
/* 115 */     this.emigrate = file.bool();
/* 116 */     this.hasSentWarning = file.bool();
/* 117 */     this.warmup = file.i(); byte b; int i; SMALL_EVENT[] arrayOfSMALL_EVENT;
/* 118 */     for (i = (arrayOfSMALL_EVENT = this.all).length, b = 0; b < i; ) { SMALL_EVENT e = arrayOfSMALL_EVENT[b];
/* 119 */       e.load(file); b++; }
/*     */     
/* 121 */     this.riot.load(file);
/* 122 */     if (!VERSION.versionIsBefore(71, 10)) {
/* 123 */       RACES.map().loader().load(this.emmiCount, file, 0.0D);
/*     */     }
/*     */   }
/*     */   
/*     */   protected void clear() {
/* 128 */     this.emigrate = true;
/* 129 */     this.hasSentWarning = false;
/* 130 */     this.timer = 15.0D;
/* 131 */     this.count = 2.0D; byte b; int i; SMALL_EVENT[] arrayOfSMALL_EVENT;
/* 132 */     for (i = (arrayOfSMALL_EVENT = this.all).length, b = 0; b < i; ) { SMALL_EVENT e = arrayOfSMALL_EVENT[b];
/* 133 */       e.clear(); b++; }
/*     */     
/* 135 */     this.warmup = 3;
/* 136 */     Arrays.fill(this.emmiCount, 0.0D);
/* 137 */     this.riot.clear();
/* 138 */     shuffleSmall();
/*     */   }
/*     */   private void shuffleSmall() {
/*     */     int i;
/* 142 */     for (i = 0; i < this.all.length; i++) {
/* 143 */       this.tmp[i] = this.all[i];
/*     */     }
/* 145 */     for (i = 0; i < this.tmp.length; i++) {
/* 146 */       int ri = RND.rInt(this.tmp.length);
/* 147 */       SMALL_EVENT o = this.tmp[i];
/* 148 */       this.tmp[i] = this.tmp[ri];
/* 149 */       this.tmp[ri] = o;
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean shouldEmigrate(Humanoid h) {
/* 154 */     return shouldEmigrate(h.race());
/*     */   }
/*     */   
/*     */   public boolean shouldEmigrate(Race r) {
/* 158 */     return this.emmi.shouldEmigrate(r);
/*     */   }
/*     */   
/*     */   public void emigrate(Humanoid h) {
/* 162 */     this.emmi.emigrate(h);
/*     */   }
/*     */   
/*     */   public boolean onStrike(Humanoid h) {
/* 166 */     return this.strike.isStriking(h);
/*     */   }
/*     */   
/*     */   public boolean shouldBrawl(Humanoid a, Humanoid b) {
/* 170 */     if (a.indu().clas() == HCLASSES.CITIZEN() && b.indu().clas() == HCLASSES.CITIZEN())
/* 171 */       return !(!this.brawl.isAtOdds(a, b) && !this.rel.isAtOdds(a, b)); 
/* 172 */     return false;
/*     */   }
/*     */   protected void update(double ds) {
/*     */     byte b;
/*     */     int i;
/*     */     SMALL_EVENT[] arrayOfSMALL_EVENT;
/* 178 */     for (i = (arrayOfSMALL_EVENT = this.all).length, b = 0; b < i; ) { SMALL_EVENT e = arrayOfSMALL_EVENT[b];
/* 179 */       e.update(ds); b++; }
/*     */     
/* 181 */     this.riot.update(ds);
/*     */     
/* 183 */     this.timer -= ds;
/* 184 */     if (this.timer > 0.0D) {
/*     */       return;
/*     */     }
/* 187 */     this.timer += 15.0D;
/*     */     
/* 189 */     if ((STATS.POP()).POP.data().get(null) < 15) {
/*     */       return;
/*     */     }
/* 192 */     double total = 0.0D;
/* 193 */     double biggest = 0.0D;
/* 194 */     for (Race r : RACES.all()) {
/* 195 */       int a = getAmount(r);
/* 196 */       if (a > 0 && !SETT.ENTRY().isClosed()) {
/* 197 */         this.emmiCount[r.index()] = this.emmiCount[r.index()] + 15.0D * this.emmiCountD;
/* 198 */         int ee = (int)this.emmiCount[r.index()];
/*     */         
/* 200 */         if (ee > 0) {
/* 201 */           this.emmi.inc(ee, r);
/* 202 */           this.emmiCount[r.index()] = this.emmiCount[r.index()] - ee;
/*     */           
/* 204 */           if (!this.hasSentWarning) {
/* 205 */             (new MessageText(¤¤emigration)).paragraph(¤¤emigrationD).send();
/* 206 */             this.hasSentWarning = true;
/*     */           } 
/* 208 */           a -= ee;
/* 209 */           if (a < 0)
/* 210 */             a = 0; 
/*     */         } 
/*     */       } else {
/* 213 */         this.emmiCount[r.index()] = 0.0D;
/*     */       } 
/*     */ 
/*     */       
/* 217 */       total += a;
/* 218 */       this.amounts[r.index()] = a;
/* 219 */       int pop = (STATS.POP()).POP.data(HCLASSES.CITIZEN()).get(r);
/* 220 */       if (pop > 0) {
/* 221 */         biggest = Math.max(biggest, a / pop);
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 227 */     if (total == 0.0D || biggest <= 0.0D) {
/* 228 */       if (this.count < 1.0D) {
/* 229 */         this.count += this.countD;
/* 230 */         this.count = CLAMP.d(this.count, 0.0D, 1.0D);
/*     */       } 
/*     */     } else {
/*     */       
/* 234 */       double c = biggest;
/*     */       
/* 236 */       double old = this.count;
/* 237 */       biggest = Math.pow(c, 0.8D);
/* 238 */       this.count -= c * this.countD;
/* 239 */       if (this.count >= 0.25D) {
/*     */         return;
/*     */       }
/* 242 */       if (this.emigrate) {
/* 243 */         if (old > 0.25D) {
/* 244 */           Race r = getRace(total);
/* 245 */           shuffleSmall(); byte b1; int j; SMALL_EVENT[] arrayOfSMALL_EVENT1;
/* 246 */           for (j = (arrayOfSMALL_EVENT1 = this.tmp).length, b1 = 0; b1 < j; ) { SMALL_EVENT e = arrayOfSMALL_EVENT1[b1];
/* 247 */             if (e.event(this.amounts[r.index], r)) {
/* 248 */               addCount(0.2D + 0.5D * total / (1 + (STATS.POP()).POP.data(HCLASSES.CITIZEN()).get(null)));
/* 249 */               STANDINGS.emergency(HCLASSES.CITIZEN(), (2 * TIME.secondsPerDay())); return;
/*     */             } 
/*     */             b1++; }
/*     */           
/* 253 */           this.emigrate = false;
/* 254 */           (new MessageText(¤¤riotWarning, ¤¤riotWarningD)).send();
/*     */         }
/*     */       
/* 257 */       } else if (this.count <= 0.0D) {
/* 258 */         this.emigrate = !RND.oneIn(3);
/* 259 */         this.riot.riot(this.amounts);
/* 260 */         addCount(1.0D + total / (1 + (STATS.POP()).POP.data(HCLASSES.CITIZEN()).get(null)));
/*     */         return;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void addCount(double am) {
/* 271 */     this.warmup--;
/* 272 */     if (this.warmup < 1)
/* 273 */       this.warmup = 1; 
/* 274 */     this.count += this.warmup * am;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private Race getRace(double total) {
/* 280 */     total *= RND.rFloat(); int i;
/* 281 */     for (i = 0; i < RACES.all().size(); i++) {
/* 282 */       total -= this.amounts[i];
/* 283 */       if (total <= 0.0D && this.amounts[i] > 0)
/* 284 */         return (Race)RACES.all().get(i); 
/*     */     } 
/* 286 */     for (i = 0; i < RACES.all().size(); i++) {
/* 287 */       if (this.amounts[i] > 0)
/* 288 */         return (Race)RACES.all().get(i); 
/*     */     } 
/* 290 */     return (Race)RACES.all().get(0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private int getAmount(Race r) {
/* 296 */     double m = Math.max((STANDINGS.CITIZEN()).loyalty.getD(r), (STANDINGS.CITIZEN()).loyaltyTarget.getD(r));
/* 297 */     if (m >= 0.85D) {
/* 298 */       return 0;
/*     */     }
/*     */     
/* 301 */     m = 1.0D - m / 0.85D;
/*     */     
/* 303 */     double dPop = (STATS.POP()).POP.data().get(null);
/* 304 */     dPop = 0.1D + 0.9D * CLAMP.d(dPop / 600.0D, 0.0D, 1.0D);
/*     */ 
/*     */     
/* 307 */     m *= dPop;
/* 308 */     int pop = (STATS.POP()).POP.data(HCLASSES.CITIZEN()).get(r);
/*     */     
/* 310 */     int rebels = (int)(pop * m);
/*     */     
/* 312 */     return CLAMP.i(rebels, 0, pop);
/*     */   }
/*     */   
/*     */   static interface SMALL_EVENT extends SAVABLE {
/*     */     boolean event(int param1Int, Race param1Race);
/*     */     
/*     */     void update(double param1Double);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\events\citizen\EventCitizen.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */