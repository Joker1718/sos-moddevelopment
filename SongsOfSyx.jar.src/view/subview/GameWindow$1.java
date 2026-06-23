/*    */ package view.subview;
/*    */ 
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ import snake2d.util.datatypes.Coo;
/*    */ import view.main.VIEW;
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
/*    */   extends GameWindow.SubMouse
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private boolean hasMoved;
/*    */   private Coo relative;
/*    */   
/*    */   null(GameWindow paramGameWindow2) {
/* 40 */     this.hasMoved = true;
/* 41 */     this.relative = new Coo();
/*    */   }
/*    */   
/*    */   protected void update() {
/* 45 */     this.relative.set((VIEW.mouse().x() << GameWindow.this.zoomout), (VIEW.mouse().y() << GameWindow.this.zoomout));
/* 46 */     int x = VIEW.mouse().x() - GameWindow.this.viewWindow.x1();
/* 47 */     int y = VIEW.mouse().y() - GameWindow.this.viewWindow.y1();
/*    */     
/* 49 */     x = GameWindow.this.pixels.x1() + (x << GameWindow.this.zoomout);
/* 50 */     y = GameWindow.this.pixels.y1() + (y << GameWindow.this.zoomout);
/*    */     
/* 52 */     if (y >= GameWindow.this.max.height()) {
/* 53 */       y = GameWindow.this.max.height() - 1;
/*    */     }
/* 55 */     if (x >= GameWindow.this.max.width())
/* 56 */       x = GameWindow.this.max.width() - 1; 
/* 57 */     if (x < 0)
/* 58 */       x = 0; 
/* 59 */     if (y < 0)
/* 60 */       y = 0; 
/* 61 */     this.hasMoved = set(x, y);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean hasMoved() {
/* 67 */     return this.hasMoved;
/*    */   }
/*    */ 
/*    */   
/*    */   public COORDINATE rel() {
/* 72 */     return (COORDINATE)this.relative;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\subview\GameWindow$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */