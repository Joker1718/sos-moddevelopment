/*     */ package settlement.entity.humanoid.ai.types.prisoner;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import init.type.NEEDS;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.rnd.RND;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   extends AIPLAN.PLANRES.Resumer
/*     */ {
/*     */   null(AIPLAN.PLANRES paramPLANRES, CharSequence $anonymous0) {
/*  65 */     super(paramPLANRES, $anonymous0);
/*     */   }
/*     */ 
/*     */   
/*     */   protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/*  70 */     return (AI.SUBS()).STAND.activateRndDir(a, d);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/*  76 */     if (d.planByte1 <= 0) {
/*  77 */       if (!(SETT.PATH()).connectivity.is(a.tc())) {
/*  78 */         return Prison.this.unfuck.set(a, d);
/*     */       }
/*  80 */       if ((AIModule_Prisoner.DATA()).prisonTimeLeft.get(d) == 0) {
/*  81 */         return Prison.this.free.set(a, d);
/*     */       }
/*     */       
/*  84 */       return null;
/*     */     } 
/*  86 */     d.planByte1 = (byte)(d.planByte1 - 1);
/*     */     
/*  88 */     if (!Prison.this.b.isWithinCell(a.tc().x(), a.tc().y(), (COORDINATE)AI.modules().coo(d))) {
/*  89 */       return Prison.this.walkToDoor.set(a, d);
/*     */     }
/*     */     
/*  92 */     if ((NEEDS.TYPES()).HUNGER.stat().getPrio(a.indu()) > 0) {
/*  93 */       AISUB.AISubActivation s = unfuck(Prison.this.eat, a, d);
/*  94 */       if (s != null) {
/*  95 */         return s;
/*     */       }
/*     */     } 
/*  98 */     if (TIME.light().nightIs()) {
/*     */       
/* 100 */       AISUB.AISubActivation s = Prison.this.sleep.set(a, d);
/* 101 */       if (s != null) {
/* 102 */         return s;
/*     */       }
/*     */     } 
/*     */     
/* 106 */     if (RND.oneIn(5))
/*     */     {
/* 108 */       if (RND.oneIn(8)) {
/* 109 */         AISUB.AISubActivation s = unfuck(Prison.this.poop, a, d);
/* 110 */         if (s != null)
/* 111 */           return s; 
/*     */       } else {
/* 113 */         AISUB.AISubActivation s = Prison.this.changeSpot.set(a, d);
/* 114 */         if (s != null) {
/* 115 */           return s;
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 121 */     return (AI.SUBS()).STAND.activateRndDir(a, d);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean con(Humanoid a, AIManager d) {
/* 126 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void can(Humanoid a, AIManager d) {}
/*     */ 
/*     */ 
/*     */   
/*     */   private AISUB.AISubActivation unfuck(AIPLAN.PLANRES.Resumer res, Humanoid a, AIManager d) {
/* 136 */     if (!(SETT.PATH()).connectivity.is(a.tc())) {
/* 137 */       return Prison.this.unfuck.set(a, d);
/*     */     }
/* 139 */     return res.set(a, d);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\types\prisoner\Prison$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */