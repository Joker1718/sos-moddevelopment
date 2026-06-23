/*     */ package settlement.room.main.util;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.ROOMA;
/*     */ import settlement.room.main.Room;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
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
/*     */ public class RoomWrap
/*     */   implements ROOMA
/*     */ {
/* 120 */   private Rec body = new Rec();
/*     */   
/*     */   private Room room;
/*     */   private int mx;
/*     */   
/*     */   public boolean init(Room r, int x, int y) {
/* 126 */     if (this.room != r || !is(x, y)) {
/* 127 */       this.room = r;
/* 128 */       this.mx = r.mX(x, y);
/* 129 */       this.my = r.mY(x, y);
/* 130 */       this.body.moveX1Y1(r.x1(this.mx, this.my), r.y1(this.mx, this.my));
/* 131 */       this.body.setDim(r.width(this.mx, this.my), r.height(this.mx, this.my));
/* 132 */       this.area = r.area(this.mx, this.my);
/* 133 */       return true;
/*     */     } 
/* 135 */     return false;
/*     */   }
/*     */   private int my; private int area;
/*     */   
/*     */   public RECTANGLE body() {
/* 140 */     return (RECTANGLE)this.body;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean is(int tile) {
/* 145 */     return is(tile % SETT.TWIDTH, tile / SETT.TWIDTH);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean is(int tx, int ty) {
/* 150 */     return ((SETT.ROOMS()).map.get(tx, ty) == this.room && this.room.isSame(this.mx, this.my, tx, ty));
/*     */   }
/*     */ 
/*     */   
/*     */   public int area() {
/* 155 */     return this.area;
/*     */   }
/*     */ 
/*     */   
/*     */   public int index() {
/* 160 */     return this.room.index();
/*     */   }
/*     */ 
/*     */   
/*     */   public int mX() {
/* 165 */     return this.mx;
/*     */   }
/*     */ 
/*     */   
/*     */   public int mY() {
/* 170 */     return this.my;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\mai\\util\RoomAreaWrapper$RoomWrap.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */