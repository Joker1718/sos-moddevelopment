/*    */ package settlement.room.military.training;
/*    */ 
/*    */ import settlement.room.main.RoomInstance;
/*    */ import util.data.DOUBLE;
/*    */ import util.data.GETTER;
/*    */ import util.data.INT;
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
/*    */   implements INT.INTE
/*    */ {
/*    */   public int min() {
/* 50 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public int max() {
/* 55 */     return ((RoomInstance)getter.get()).employees().max();
/*    */   }
/*    */ 
/*    */   
/*    */   public int get() {
/* 60 */     return ((RoomInstance)getter.get()).employees().target();
/*    */   }
/*    */ 
/*    */   
/*    */   public void set(int t) {
/* 65 */     ((RoomInstance)getter.get()).employees().neededSet(t);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\military\training\Gui$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */