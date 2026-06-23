/*    */ package view.sett.ui.room.copy;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ import snake2d.util.datatypes.BODY_HOLDER;
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ import snake2d.util.datatypes.Coo;
/*    */ import snake2d.util.datatypes.RECTANGLE;
/*    */ import snake2d.util.datatypes.Rec;
/*    */ import snake2d.util.map.MAP_BOOLEAN;
/*    */ 
/*    */ final class Dest implements MAP_BOOLEAN, BODY_HOLDER {
/*    */   private final Source source;
/*    */   private int cx;
/*    */   private int cy;
/* 15 */   private Coo sourceCoo = new Coo();
/* 16 */   private int rot = 0;
/* 17 */   private Rec body = new Rec();
/*    */   
/*    */   Dest(Source source) {
/* 20 */     this.source = source;
/*    */   }
/*    */   
/*    */   void init(int cx, int cy, int rot) {
/* 24 */     this.body.clear();
/* 25 */     this.rot = rot;
/* 26 */     this.cx = cx;
/* 27 */     this.cy = cy;
/*    */     
/* 29 */     int width = this.source.area().width();
/* 30 */     int height = this.source.area().height();
/*    */     
/* 32 */     for (int i = 0; i < this.rot; i++) {
/* 33 */       int ox = width;
/* 34 */       width = height;
/* 35 */       height = ox;
/*    */     } 
/* 37 */     this.body.setDim((width + 1), (height + 1));
/* 38 */     this.body.moveC(cx, cy);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean is(int tile) {
/* 43 */     return is(tile % SETT.TWIDTH, tile / SETT.TWIDTH);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean is(int tx, int ty) {
/* 48 */     return this.source.is(transform(tx, ty));
/*    */   }
/*    */   
/*    */   public boolean sourceIs(int tx, int ty) {
/* 52 */     return this.source.is(tx, ty);
/*    */   }
/*    */   
/*    */   public boolean blocking(int tx, int ty) {
/* 56 */     return (SETT.PLACA()).solidityWill.is(transform(tx, ty));
/*    */   }
/*    */ 
/*    */   
/*    */   public COORDINATE transform(int tx, int ty) {
/* 61 */     int dx = tx - this.cx;
/* 62 */     int dy = ty - this.cy;
/*    */     
/* 64 */     for (int i = 0; i < this.rot; i++) {
/* 65 */       int ox = dx;
/* 66 */       dx = dy;
/* 67 */       dy = -ox;
/*    */     } 
/*    */     
/* 70 */     dx = this.source.area().cX() + dx;
/* 71 */     dy = this.source.area().cY() + dy;
/*    */     
/* 73 */     this.sourceCoo.set(dx, dy);
/* 74 */     return (COORDINATE)this.sourceCoo;
/*    */   }
/*    */ 
/*    */   
/*    */   public RECTANGLE body() {
/* 79 */     return (RECTANGLE)this.body;
/*    */   }
/*    */   
/*    */   public int rot() {
/* 83 */     return this.rot;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\copy\Dest.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */