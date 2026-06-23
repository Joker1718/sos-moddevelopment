/*     */ package settlement.entity.humanoid.ai.crime;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.time.TIME;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.CRIMES;
/*     */ import init.type.CRIME_PUNISHMENTS;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.HTYPE;
/*     */ import init.type.HTYPES;
/*     */ import init.type.HTYPE_RACE;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.HEvent;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIModule;
/*     */ import settlement.entity.humanoid.ai.main.AIModules;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.law.StatCrime;
/*     */ import snake2d.util.bit.Bits;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.INT_O;
/*     */ import util.text.D;
/*     */ import view.sett.IDebugPanelSett;
/*     */ 
/*     */ public final class AIModule_Crime extends AIModule {
/*  34 */   public final AIPLAN theft = (AIPLAN)new Theft("CrimeTheft", this);
/*  35 */   public final AIPLAN murder = (AIPLAN)new Murder("CrimeMurder", this);
/*  36 */   public final AIPLAN vandal = (AIPLAN)new Vandalism("CrimeVandal", this);
/*  37 */   public final AIPLAN flash = (AIPLAN)new Flasher("crimeFlash", this);
/*  38 */   public final AIPLAN disrespect = (AIPLAN)new Disrespect("crimeDisres", this);
/*  39 */   public final AIPLAN speech = (AIPLAN)new Disrespect("crimeSpeech", this);
/*  40 */   public final AIPLAN serial = (AIPLAN)new SerialKiller("crimeSerial");
/*     */   
/*  42 */   private final INT_O.INT_OE<AIManager> commitCrime = new wrap(new Bits(1));
/*  43 */   private final INT_O.INT_OE<AIManager> criminal = new wrap(new Bits(2));
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  48 */   private static CharSequence ¤¤name = "Mischief";
/*  49 */   private static CharSequence ¤¤desc = "Commit crimes";
/*     */   static {
/*  51 */     D.ts(AIModule_Crime.class);
/*     */   }
/*     */   
/*     */   private boolean debug = false;
/*     */   
/*     */   public AIModule_Crime() {
/*  57 */     super((SPRITE)(UI.icons()).s.law, ¤¤name, ¤¤desc);
/*  58 */     for (CRIMES.CRIME c : CRIMES.ALL())
/*  59 */       getPlan(c); 
/*  60 */     IDebugPanelSett.add("CRIMES_TEST_TOGGLE", new ACTION()
/*     */         {
/*     */           public void exe()
/*     */           {
/*  64 */             AIModule_Crime.this.debug = !AIModule_Crime.this.debug;
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public AIPLAN.AiPlanActivation getPlan(Humanoid a, AIManager d) {
/*  72 */     if ((GAME.events()).killer.theKiller() == a && (GAME.events()).killer.theKillerShouldKill()) {
/*  73 */       return this.serial.activate(a, d);
/*     */     }
/*  75 */     CRIMES.CRIME crime = (CRIMES.CRIME)(STATS.LAW()).prisonerType.get(a.indu());
/*     */     
/*  77 */     if (crime == CRIMES.PERSECUTED() || crime == CRIMES.S_PLEASURE()) {
/*  78 */       long m = 0L;
/*  79 */       Induvidual i = a.indu();
/*  80 */       for (CRIMES.CRIME c : CRIMES.all(i.clas())) {
/*  81 */         if (c.isCriminal())
/*  82 */           m += (long)(1024.0D * c.tyrrany(i.clas(), i.race())); 
/*     */       } 
/*  84 */       m = (long)((float)m * RND.rFloat());
/*  85 */       for (CRIMES.CRIME c : CRIMES.all(i.clas())) {
/*  86 */         if (c.isCriminal())
/*  87 */           m -= (long)(1024.0D * c.tyrrany(i.clas(), i.race())); 
/*  88 */         if (m <= 0L) {
/*     */           
/*  90 */           (STATS.LAW()).prisonerType.set(i, c);
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/*  97 */     return getPlan(crime).activate(a, d);
/*     */   }
/*     */ 
/*     */   
/*     */   private AIPLAN getPlan(CRIMES.CRIME crime) {
/* 102 */     if (crime == CRIMES.THEFT() || crime == CRIMES.S_THEFT())
/* 103 */       return this.theft; 
/* 104 */     if (crime == CRIMES.DISRESPECT() || crime == CRIMES.S_DISRESPECT())
/* 105 */       return this.disrespect; 
/* 106 */     if (crime == CRIMES.FLASHING())
/* 107 */       return this.flash; 
/* 108 */     if (crime == CRIMES.MURDER() || crime == CRIMES.S_MURDER())
/* 109 */       return this.murder; 
/* 110 */     if (crime == CRIMES.VANDALISM()) {
/* 111 */       return this.vandal;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 116 */     return this.speech;
/*     */   }
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
/*     */ 
/*     */ 
/*     */   
/*     */   protected void update(Humanoid a, AIManager d, boolean newDay, int byteDelta, int updateOfDay) {
/* 132 */     if ((updateOfDay & 0x3) == 0 && (STATS.MULTIPLIERS()).PROSECUTION.markIs(a)) {
/* 133 */       (SETT.ROOMS()).GUARD.reporter.reportCriminal(a);
/*     */     }
/*     */     
/* 136 */     if (a.indu().hType() == HTYPES.GUARD()) {
/*     */       return;
/*     */     }
/*     */     
/* 140 */     if (STATS.LAW().getCurfew().isSetForADay()) {
/* 141 */       this.commitCrime.set(d, 0);
/*     */     } else {
/*     */       
/* 144 */       if (this.debug) {
/* 145 */         this.commitCrime.setMax(d);
/*     */       }
/* 147 */       double r = (BOOSTABLES.BEHAVIOUR()).LAWFULNESS.get((BOOSTABLE_O)a.indu());
/*     */       
/* 149 */       if (a.indu().clas() == HCLASSES.CITIZEN()) {
/* 150 */         double pop = ((STATS.POP()).POP.data(HCLASSES.CITIZEN()).get(null) + 1);
/* 151 */         double guards = ((STATS.POP()).POP.type().get(HTYPE_RACE.get(a.race(), HTYPES.GUARD())) + 1);
/* 152 */         double dd = (pop + guards) / pop;
/* 153 */         r *= dd;
/*     */       } 
/*     */       
/* 156 */       if (r < 0.0D) {
/* 157 */         r = 0.0D;
/*     */       }
/* 159 */       r *= 1280.0D;
/* 160 */       r += 16.0D;
/*     */       
/* 162 */       if (RND.oneIn(r)) {
/* 163 */         this.commitCrime.setMax(d);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   void commitCrime(Humanoid a, AIManager d, boolean notify, CRIMES.CRIME crime) {
/* 170 */     ((StatCrime)(STATS.LAW()).crimes.get(crime.index())).commit(a.indu());
/* 171 */     (STATS.LAW()).prisonerType.set(a.indu(), crime);
/*     */ 
/*     */     
/* 174 */     if (notify && ((StatCrime)(STATS.LAW()).crimes.get(crime.index())).punishment(a.indu()) != CRIME_PUNISHMENTS.PARDON()) {
/* 175 */       (SETT.ROOMS()).GUARD.reporter.reportCriminal(a);
/* 176 */       notify(a);
/*     */     } 
/* 178 */     this.commitCrime.set(d, 0);
/* 179 */     this.criminal.set(d, 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean catchPrisoner(Humanoid a) {
/* 184 */     if ((STATS.MULTIPLIERS()).PROSECUTION.markIs(a)) {
/* 185 */       (STATS.LAW()).prisonerType.set(a.indu(), CRIMES.PERSECUTED());
/*     */     }
/* 187 */     CRIMES.CRIME c = (CRIMES.CRIME)(STATS.LAW()).prisonerType.get(a.indu());
/* 188 */     c.stat().catchh(a.indu());
/* 189 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getPriority(Humanoid a, AIManager d) {
/* 194 */     if ((GAME.events()).killer.theKiller() == a) {
/* 195 */       if ((GAME.events()).killer.theKillerShouldKill()) {
/* 196 */         return TIME.light().nightIs() ? 4 : 0;
/*     */       }
/* 198 */       return 0;
/*     */     } 
/* 200 */     if (this.commitCrime.isMax(d)) {
/* 201 */       return 6;
/*     */     }
/* 203 */     return 0;
/*     */   }
/*     */   
/*     */   public static void notify(Humanoid criminal) {
/* 207 */     for (ENTITY e : SETT.ENTITIES().getInProximity((ENTITY)criminal, 8)) {
/* 208 */       if (e instanceof Humanoid) {
/* 209 */         HEvent.Handler.notifyCrime((Humanoid)e, (ENTITY)criminal);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isCriminal(Humanoid a) {
/* 215 */     AIManager d = (AIManager)a.ai();
/* 216 */     if (a.indu().hostile())
/* 217 */       return true; 
/* 218 */     if ((STATS.MULTIPLIERS()).PROSECUTION.markIs(a) && ((StatCrime)(STATS.LAW()).crimes.get(CRIMES.PERSECUTED().index())).punishment(a.indu()) != CRIME_PUNISHMENTS.PARDON())
/* 219 */       return true; 
/* 220 */     if (this.criminal.get(d) > 0 && ((StatCrime)(STATS.LAW()).crimes.get(((CRIMES.CRIME)(STATS.LAW()).prisonerType.get(a.indu())).index())).punishment(a.indu()) != CRIME_PUNISHMENTS.PARDON())
/* 221 */       return true; 
/* 222 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void init(Humanoid a, AIManager d, HTYPE prev, HTYPE current) {
/* 228 */     this.commitCrime.set(d, 0);
/* 229 */     this.criminal.set(d, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void cancel(Humanoid a, AIManager d) {
/* 235 */     super.cancel(a, d);
/*     */   }
/*     */   
/*     */   private static class wrap
/*     */     implements INT_O.INT_OE<AIManager> {
/*     */     private final Bits bits;
/*     */     
/*     */     wrap(Bits bits) {
/* 243 */       this.bits = bits;
/*     */     }
/*     */ 
/*     */     
/*     */     public int get(AIManager t) {
/* 248 */       return this.bits.get((AIModules.data()).byte1.get(t));
/*     */     }
/*     */ 
/*     */     
/*     */     public int min(AIManager t) {
/* 253 */       return 0;
/*     */     }
/*     */ 
/*     */     
/*     */     public int max(AIManager t) {
/* 258 */       return this.bits.mask;
/*     */     }
/*     */ 
/*     */     
/*     */     public void set(AIManager t, int i) {
/* 263 */       int d = this.bits.set((AIModules.data()).byte1.get(t), i);
/* 264 */       (AIModules.data()).byte1.set(t, d);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\crime\AIModule_Crime.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */