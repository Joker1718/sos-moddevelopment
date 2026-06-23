/*     */ package settlement.entity.humanoid.ai.types.insane;
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
/*     */   protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 120 */     return res(a, d);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 126 */     if (!AIModule_Insane.null.this.A.isreserved((COORDINATE)AI.modules().coo(d))) {
/* 127 */       return null;
/*     */     }
/* 129 */     if (d.planByte1 <= 0) {
/* 130 */       if (!(SETT.PATH()).connectivity.is(a.tc())) {
/* 131 */         return AIModule_Insane.null.this.unfuck.set(a, d);
/*     */       }
/* 133 */       AIModule_Insane.null.this.cancel(a, d);
/* 134 */       return null;
/*     */     } 
/*     */     
/* 137 */     if (!AIModule_Insane.null.this.A.isWithinCell(a.tc().x(), a.tc().y(), (COORDINATE)AI.modules().coo(d)))
/*     */     {
/* 139 */       return AIModule_Insane.null.this.walkToDoor.set(a, d);
/*     */     }
/*     */     
/* 142 */     if ((NEEDS.TYPES()).HUNGER.stat().getPrio(a.indu()) > 0 && 
/* 143 */       AIModule_Insane.null.this.A.eatFood((COORDINATE)AI.modules().coo(d))) {
/* 144 */       (NEEDS.TYPES()).HUNGER.stat().fix(a.indu());
/*     */     }
/*     */ 
/*     */     
/* 148 */     if (TIME.light().nightIs()) {
/* 149 */       return (AI.SUBS()).subSleep.activate(a, d);
/*     */     }
/*     */ 
/*     */     
/* 153 */     if (RND.oneIn(5)) {
/* 154 */       AISUB.AISubActivation s = AIModule_Insane.null.this.changeSpot.set(a, d);
/* 155 */       if (s != null)
/* 156 */         return s; 
/*     */     } 
/* 158 */     return (AIModule_Insane.null.access$0(AIModule_Insane.null.this)).crazySubsA[RND.rInt((AIModule_Insane.null.access$0(AIModule_Insane.null.this)).crazySubsA.length)].activate(a, d);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean con(Humanoid a, AIManager d) {
/* 163 */     return AIModule_Insane.null.this.A.isreserved((COORDINATE)AI.modules().coo(d));
/*     */   }
/*     */   
/*     */   public void can(Humanoid a, AIManager d) {}
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\types\insane\AIModule_Insane$1$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */