/*     */ package settlement.room.main.util;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.ROOMA;
/*     */ import snake2d.util.datatypes.RECTANGLE;
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
/*     */   implements ROOMA
/*     */ {
/*     */   public RECTANGLE body() {
/*  80 */     return (RECTANGLE)RoomAreaWrapper.this.body;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean is(int tile) {
/*  85 */     return is(tile % SETT.TWIDTH, tile / SETT.TWIDTH);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean is(int tx, int ty) {
/*  90 */     return (RoomAreaWrapper.this.room != null && (SETT.ROOMS()).map.get(tx, ty) == RoomAreaWrapper.this.room && RoomAreaWrapper.this.room.isSame(RoomAreaWrapper.this.mx, RoomAreaWrapper.this.my, tx, ty));
/*     */   }
/*     */ 
/*     */   
/*     */   public int area() {
/*  95 */     return RoomAreaWrapper.this.area;
/*     */   }
/*     */ 
/*     */   
/*     */   public int index() {
/* 100 */     return RoomAreaWrapper.this.room.index();
/*     */   }
/*     */ 
/*     */   
/*     */   public int mX() {
/* 105 */     return RoomAreaWrapper.this.mx;
/*     */   }
/*     */ 
/*     */   
/*     */   public int mY() {
/* 110 */     return RoomAreaWrapper.this.my;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\mai\\util\RoomAreaWrapper$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */