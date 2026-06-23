/*    */ package settlement.room.food.orchard;
/*    */ 
/*    */ import settlement.room.main.ROOMA;
/*    */ import settlement.room.main.util.RoomBits;
/*    */ import snake2d.util.bit.Bits;
/*    */ import snake2d.util.datatypes.COORDINATE;
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
/*    */   extends RoomBits
/*    */ {
/*    */   null(COORDINATE $anonymous0, Bits $anonymous1) {
/* 39 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   
/*    */   public void set(int tx, int ty, ROOMA r, int t) {
/* 43 */     if (get() == OTile.this.IBIG.index) {
/* 44 */       OTile.this.ins.trees = (short)(OTile.this.ins.trees - 1);
/*    */     }
/* 46 */     super.set(tx, ty, r, t);
/* 47 */     if (t == OTile.this.IBIG.index)
/* 48 */       OTile.this.ins.trees = (short)(OTile.this.ins.trees + 1); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\food\orchard\OTile$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */