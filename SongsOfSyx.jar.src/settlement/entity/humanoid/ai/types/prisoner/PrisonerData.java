/*     */ package settlement.entity.humanoid.ai.types.prisoner;
/*     */ 
/*     */ import init.type.CAUSE_ARRIVES;
/*     */ import init.type.CRIMES;
/*     */ import init.type.CRIME_PUNISHMENTS;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASSES;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIModules;
/*     */ import settlement.entity.humanoid.ai.main.HAI;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.bit.Bits;
/*     */ import util.data.GETTER_TRANS;
/*     */ import util.data.INT_O;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class PrisonerData
/*     */ {
/*     */   static PrisonerData self;
/*     */   public final INT_O.INT_OE<HAI> judged;
/*     */   public final INT_O.INT_OE<HAI> stocked;
/*     */   final INT_O.INT_OE<HAI> judgeWait;
/*     */   public final INT_O.INT_OE<HAI> prisonReported;
/*     */   public final GETTER_TRANS.GETTER_TRANSE<HAI, CRIME_PUNISHMENTS.PUNISHMENT> punishmentSet;
/*     */   public final INT_O.INT_OE<HAI> prisonTimeLeft;
/*     */   
/*     */   public PrisonerData() {
/*  34 */     self = this;
/*  35 */     this.judged = new Wrap(new Bits(1), (AIModules.data()).byte1);
/*  36 */     this.judgeWait = new Wrap(new Bits(6), (AIModules.data()).byte1);
/*  37 */     this.prisonReported = new Wrap(new Bits(8), (AIModules.data()).byte1);
/*  38 */     this.stocked = new Wrap(new Bits(48), (AIModules.data()).byte1);
/*     */     
/*  40 */     this.punishmentSet = new GETTER_TRANS.GETTER_TRANSE<HAI, CRIME_PUNISHMENTS.PUNISHMENT>() {
/*  41 */         PrisonerData.Wrap pp = new PrisonerData.Wrap(new Bits(255), (AIModules.data()).byte2);
/*     */         
/*     */         public CRIME_PUNISHMENTS.PUNISHMENT get(HAI f) {
/*  44 */           int i = this.pp.get(f);
/*  45 */           if (i == 0)
/*  46 */             return null; 
/*  47 */           return (CRIME_PUNISHMENTS.PUNISHMENT)CRIME_PUNISHMENTS.ALL().get(i - 1);
/*     */         }
/*     */ 
/*     */         
/*     */         public void set(HAI f, CRIME_PUNISHMENTS.PUNISHMENT t) {
/*  52 */           int i = (t == null) ? 0 : (t.index() + 1);
/*  53 */           this.pp.set(f, i);
/*     */         }
/*     */       };
/*  56 */     this.prisonTimeLeft = new Wrap(new Bits(255), (AIModules.data()).byte3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HCLASS clas(Induvidual i) {
/*  66 */     if ((STATS.LAW()).prisonerType.get(i) == CRIMES.WAR())
/*  67 */       return HCLASSES.OTHER(); 
/*  68 */     if ((STATS.POP()).COUNT.arrive.get(i) == CAUSE_ARRIVES.EMANCIPATED())
/*  69 */       return HCLASSES.SLAVE(); 
/*  70 */     return HCLASSES.CITIZEN();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void init(Humanoid a, AIManager d) {
/*  75 */     AI.modules().coo(d).set(0.0D, 0.0D);
/*  76 */     (AIModules.data()).byte1.set(d, 0);
/*  77 */     (AIModules.data()).byte2.set(d, 0);
/*  78 */     this.prisonTimeLeft.set(d, AIModule_Prisoner.PRISON_DAYS + 1);
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
/*     */   
/*     */   public void punish(Humanoid a, AIManager d, CRIME_PUNISHMENTS.PUNISHMENT dec) {
/*  95 */     STATS.LAW().punish(a.indu(), dec);
/*     */   }
/*     */   
/*     */   private static class Wrap
/*     */     implements INT_O.INT_OE<HAI> {
/*     */     private final Bits bits;
/*     */     private final INT_O.INT_OE<AIManager> data;
/*     */     
/*     */     Wrap(Bits bits, INT_O.INT_OE<AIManager> data) {
/* 104 */       this.bits = bits;
/* 105 */       this.data = data;
/*     */     }
/*     */ 
/*     */     
/*     */     public int get(HAI t) {
/* 110 */       return this.bits.get(this.data.get(t));
/*     */     }
/*     */ 
/*     */     
/*     */     public int min(HAI t) {
/* 115 */       return 0;
/*     */     }
/*     */ 
/*     */     
/*     */     public int max(HAI t) {
/* 120 */       return this.bits.mask;
/*     */     }
/*     */ 
/*     */     
/*     */     public void set(HAI t, int i) {
/* 125 */       int d = this.data.get(t);
/* 126 */       d = this.bits.set(d, i);
/* 127 */       this.data.set(t, d);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\types\prisoner\PrisonerData.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */