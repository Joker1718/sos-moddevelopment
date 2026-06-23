/*    */ package settlement.room.food.cannibal;
/*    */ 
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
/*    */ class null
/*    */   extends RoomBits
/*    */ {
/*    */   null(COORDINATE $anonymous0, Bits $anonymous1) {
/* 21 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   
/*    */   protected void remove() {
/* 25 */     if (get() > 0) {
/* 26 */       Cage.this.ins.prisoners = (short)(Cage.this.ins.prisoners - 1);
/* 27 */       Cage.this.b.prisoners--;
/*    */     } 
/* 29 */     if (get() == 2) {
/* 30 */       Cage.this.ins.reservable = (short)(Cage.this.ins.reservable - 1);
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void add() {
/* 37 */     if (get() > 0) {
/* 38 */       Cage.this.ins.prisoners = (short)(Cage.this.ins.prisoners + 1);
/* 39 */       Cage.this.b.prisoners++;
/*    */     } 
/* 41 */     if (get() == 2)
/* 42 */       Cage.this.ins.reservable = (short)(Cage.this.ins.reservable + 1); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\food\cannibal\Cage$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */