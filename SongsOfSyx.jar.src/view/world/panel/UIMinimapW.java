/*    */ package view.world.panel;
/*    */ 
/*    */ import snake2d.MButt;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.color.OPACITY;
/*    */ import snake2d.util.datatypes.RECTANGLE;
/*    */ import snake2d.util.datatypes.Rec;
/*    */ import snake2d.util.gui.clickable.CLICKABLE;
/*    */ import util.colors.GCOLOR;
/*    */ import view.main.VIEW;
/*    */ import view.subview.GameWindow;
/*    */ import world.WORLD;
/*    */ import world.WorldMinimap;
/*    */ 
/*    */ 
/*    */ public final class UIMinimapW
/*    */   extends CLICKABLE.ClickableAbs
/*    */ {
/* 20 */   private final WorldMinimap map = WORLD.MINIMAP();
/*    */   private boolean clicked = false;
/*    */   private final GameWindow window;
/* 23 */   private Rec inner = new Rec(256.0D, 256.0D);
/*    */   
/*    */   public UIMinimapW(GameWindow window) {
/* 26 */     this.window = window;
/* 27 */     this.body.setDim(262.0D, 262.0D);
/*    */   }
/*    */ 
/*    */   
/*    */   private void move(GameWindow window) {
/* 32 */     this.clicked = true;
/* 33 */     int x1 = (int)((VIEW.mouse().x() - body().x1()) * (WORLD.PWIDTH() / 256));
/* 34 */     int y1 = (int)((VIEW.mouse().y() - body().y1()) * (WORLD.PHEIGHT() / 256));
/* 35 */     window.centerAt(x1, y1);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void clickA() {
/* 40 */     move(this.window);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 45 */     this.inner.centerIn((RECTANGLE)body());
/* 46 */     Rec rec = this.inner;
/* 47 */     GCOLOR.UI().borderH(r, (RECTANGLE)body(), 0);
/*    */ 
/*    */ 
/*    */     
/* 51 */     this.map.render(r, rec.x1(), rec.y1());
/*    */ 
/*    */ 
/*    */     
/* 55 */     this.clicked = (this.clicked && MButt.LEFT.isDown());
/* 56 */     if (this.clicked) {
/* 57 */       move(this.window);
/*    */     }
/* 59 */     int x1 = rec.x1() + (int)((256 * this.window.pixels().cX()) / WORLD.PWIDTH());
/* 60 */     int y1 = rec.y1() + (int)((256 * this.window.pixels().cY()) / WORLD.PHEIGHT());
/*    */     
/* 62 */     int miniW = 256 * this.window.pixels().width() / WORLD.PWIDTH();
/* 63 */     int miniH = 256 * this.window.pixels().height() / WORLD.PHEIGHT();
/*    */     
/* 65 */     x1 -= miniW / 2;
/* 66 */     y1 -= miniH / 2;
/*    */     
/* 68 */     int x2 = x1 + miniW;
/* 69 */     int y2 = y1 + miniH;
/*    */     
/* 71 */     if (x1 < rec.x1()) {
/* 72 */       x1 = rec.x1();
/*    */     }
/*    */     
/* 75 */     if (y1 < rec.y1()) {
/* 76 */       y1 = rec.y1();
/*    */     }
/*    */     
/* 79 */     if (y2 > rec.y2()) {
/* 80 */       y2 = rec.y2();
/*    */     }
/*    */     
/* 83 */     if (x2 > rec.x2()) {
/* 84 */       x2 = rec.x2();
/*    */     }
/*    */     
/* 87 */     OPACITY.O75.bind();
/* 88 */     COLOR.BLACK.render(r, x1, x1 + 1, y1, y2);
/* 89 */     COLOR.WHITE100.render(r, x1 + 1, x1 + 2, y1, y2);
/* 90 */     COLOR.BLACK.render(r, x2 - 1, x2, y1, y2);
/* 91 */     COLOR.WHITE100.render(r, x2 - 2, x2 - 1, y1, y2);
/* 92 */     COLOR.BLACK.render(r, x1, x2, y1, y1 + 1);
/* 93 */     COLOR.WHITE100.render(r, x1 + 1, x2 - 1, y1 + 1, y1 + 2);
/* 94 */     COLOR.BLACK.render(r, x1, x2, y2 - 1, y2);
/* 95 */     COLOR.WHITE100.render(r, x1 + 1, x2 - 1, y2 - 2, y2 - 1);
/* 96 */     OPACITY.O25.bind();
/* 97 */     COLOR.BLACK.render(r, x1 + 2, x2 - 2, y1 + 2, y2 - 2);
/* 98 */     OPACITY.unbind();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\world\panel\UIMinimapW.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */