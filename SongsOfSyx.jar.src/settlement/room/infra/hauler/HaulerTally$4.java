/*    */ package settlement.room.infra.hauler;
/*    */ 
/*    */ import init.resources.RESOURCE;
/*    */ import util.data.DOUBLE_O;
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
/*    */   implements DOUBLE_O<RESOURCE>
/*    */ {
/*    */   public double getD(RESOURCE t) {
/* 63 */     int sp = HaulerTally.this.space.total(t);
/* 64 */     if (sp == 0)
/* 65 */       return 1.0D; 
/* 66 */     double used = HaulerTally.this.amount.total(t);
/* 67 */     return used / sp;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\hauler\HaulerTally$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */