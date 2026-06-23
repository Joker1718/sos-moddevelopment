/*    */ package settlement.room.infra.hauler;
/*    */ 
/*    */ import util.keymap.MAPPED;
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
/*    */   extends HaulerTally.TallyData
/*    */ {
/*    */   null(HaulerTally paramHaulerTally2, CharSequence $anonymous0) {
/* 46 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   void set(HaulerInstance ins, int am) {
/* 50 */     super.set(ins, am);
/* 51 */     if (ins.resource() != null)
/* 52 */       HaulerTally.this.amountDay.set((MAPPED)ins.resource(), total(ins.resource())); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\hauler\HaulerTally$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */