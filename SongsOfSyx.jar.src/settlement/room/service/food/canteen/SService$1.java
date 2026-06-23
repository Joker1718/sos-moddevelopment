/*    */ package settlement.room.service.food.canteen;
/*    */ 
/*    */ import init.resources.RESOURCES;
/*    */ import snake2d.util.bit.Bits;
/*    */ import snake2d.util.misc.CLAMP;
/*    */ import util.data.DOUBLE;
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
/*    */ class null
/*    */   implements INT.INTE
/*    */ {
/* 23 */   private final Bits bits = new Bits(15);
/*    */ 
/*    */   
/*    */   public int min() {
/* 27 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public int max() {
/* 32 */     return CLAMP.i(3, 0, RESOURCES.EDI().all().size());
/*    */   }
/*    */ 
/*    */   
/*    */   public int get() {
/* 37 */     return this.bits.get(SService.this.data);
/*    */   }
/*    */ 
/*    */   
/*    */   public void set(int t) {
/* 42 */     SService.this.data = this.bits.set(SService.this.data, t);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\food\canteen\SService$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */