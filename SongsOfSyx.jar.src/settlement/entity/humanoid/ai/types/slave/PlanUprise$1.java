/*    */ package settlement.entity.humanoid.ai.types.slave;
/*    */ 
/*    */ import game.GAME;
/*    */ import init.resources.RBIT;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AI;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*    */ import settlement.entity.humanoid.ai.main.AISUB;
/*    */ import settlement.stats.STATS;
/*    */ import settlement.stats.equip.Equip;
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
/*    */   final RBIT.RBITImp bits;
/*    */   
/*    */   null(AIPLAN.PLANRES paramPLANRES, CharSequence $anonymous0) {
/* 38 */     super(paramPLANRES, $anonymous0);
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
/*    */     
/* 51 */     this.bits = new RBIT.RBITImp();
/*    */   }
/*    */   
/*    */   protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 55 */     if (d.resourceCarried() != null) {
/* 56 */       for (Equip e : STATS.EQUIP().allE()) {
/* 57 */         if (e.resource() == d.resourceCarried()) {
/* 58 */           e.stat().indu().inc(a.indu(), 1);
/*    */         }
/*    */       } 
/* 61 */       d.resourceCarriedSet(null);
/*    */     } 
/*    */     
/* 64 */     this.bits.clear();
/* 65 */     for (Equip e : STATS.EQUIP().BATTLE_ALL()) {
/* 66 */       if (e.stat().indu().getD(a.indu()) < 0.3D) {
/* 67 */         this.bits.or(e.resource());
/*    */       }
/*    */     } 
/* 70 */     if (!this.bits.isClear()) {
/* 71 */       AISUB.AISubActivation s = (AI.SUBS()).walkTo.resource(a, d, (RBIT)this.bits);
/* 72 */       if (s != null) {
/* 73 */         return s;
/*    */       }
/*    */     } 
/* 76 */     return PlanUprise.this.path.set(a, d);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean con(Humanoid a, AIManager d) {
/* 81 */     return (GAME.events()).uprising.spots.confirmUpriser(d.planByte3); }
/*    */   protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) { int i = (GAME.events()).uprising.spots.signUpUpriserPositionByte(a);
/*    */     if (i < 0)
/*    */       return null; 
/*    */     d.planByte3 = (byte)i;
/* 86 */     return res(a, d); } public void can(Humanoid a, AIManager d) { (GAME.events()).uprising.spots.cancelUpriser(a, d.planByte3, false); }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\types\slave\PlanUprise$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */