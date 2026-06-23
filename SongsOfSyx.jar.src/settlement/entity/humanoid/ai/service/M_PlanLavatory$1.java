/*    */ package settlement.entity.humanoid.ai.service;
/*    */ 
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AI;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*    */ import settlement.entity.humanoid.ai.main.AISTATE;
/*    */ import settlement.entity.humanoid.ai.main.AISUB;
/*    */ import settlement.room.service.lavatory.Lavatory;
/*    */ import snake2d.util.rnd.RND;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends AIPLAN.PLANRES.Resumer
/*    */ {
/*    */   private final AISUB sub;
/*    */   
/*    */   null(AIPLAN.PLANRES paramPLANRES, CharSequence $anonymous0) {
/* 28 */     super(paramPLANRES, $anonymous0);
/*    */     
/* 30 */     this.sub = (AISUB)new AISUB.Simple("taking a dump")
/*    */       {
/*    */         protected AISTATE resume(Humanoid a, AIManager d) {
/* 33 */           d.subByte = (byte)(d.subByte + 1);
/*    */           
/* 35 */           if (d.subByte > 4 + RND.rInt(5)) {
/* 36 */             return null;
/*    */           }
/* 38 */           if ((M_PlanLavatory.null.access$0(M_PlanLavatory.null.this).blue(d).service()).usageSound != null && RND.oneIn(2)) {
/* 39 */             (M_PlanLavatory.null.access$0(M_PlanLavatory.null.this).blue(d).service()).usageSound.rnd(a);
/*    */           }
/* 41 */           return (AI.STATES()).STAND.activate(a, d, 5.0D);
/*    */         }
/*    */       };
/*    */   }
/*    */   
/*    */   protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 47 */     Lavatory l = M_PlanLavatory.this.get(a, d);
/* 48 */     a.speed.setDirCurrent(l.getDir());
/* 49 */     return this.sub.activate(a, d);
/*    */   }
/*    */ 
/*    */   
/*    */   protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 54 */     M_PlanLavatory.this.get(a, d).consume();
/* 55 */     return M_PlanLavatory.this.walk2Water.set(a, d);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean con(Humanoid a, AIManager d) {
/* 60 */     Lavatory lavatory = M_PlanLavatory.this.get(a, d);
/* 61 */     return (lavatory != null && lavatory.findableReservedIs());
/*    */   }
/*    */ 
/*    */   
/*    */   public void can(Humanoid a, AIManager d) {
/* 66 */     Lavatory lavatory = M_PlanLavatory.this.get(a, d);
/* 67 */     if (lavatory != null)
/* 68 */       lavatory.findableReserveCancel(); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\service\M_PlanLavatory$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */