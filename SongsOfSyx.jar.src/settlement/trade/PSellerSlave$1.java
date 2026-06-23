/*    */ package settlement.trade;
/*    */ 
/*    */ import init.type.CAUSE_LEAVES;
/*    */ import init.type.HTYPES;
/*    */ import settlement.entity.EntityIterator;
/*    */ import settlement.entity.humanoid.Humanoid;
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
/*    */   extends EntityIterator.Humans
/*    */ {
/*    */   int aa;
/*    */   
/*    */   null(int paramInt) {
/* 85 */     this.aa = paramInt;
/*    */   }
/*    */   
/*    */   protected boolean processAndShouldBreakH(Humanoid h, int ie) {
/* 89 */     if (h.indu().hType() == HTYPES.SLAVE()) {
/* 90 */       h.kill(false, CAUSE_LEAVES.SOLD());
/* 91 */       this.aa--;
/*    */     } 
/* 93 */     return (this.aa > 0);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\trade\PSellerSlave$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */