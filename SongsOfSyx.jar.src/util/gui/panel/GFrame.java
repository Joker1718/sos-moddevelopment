/*    */ package util.gui.panel;
/*    */ 
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.datatypes.RECTANGLE;
/*    */ import snake2d.util.datatypes.RECTANGLEE;
/*    */ import snake2d.util.datatypes.Rec;
/*    */ import snake2d.util.datatypes.RecFacade;
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import snake2d.util.sprite.TextureCoords;
/*    */ import util.colors.GCOLOR;
/*    */ 
/*    */ public class GFrame extends RENDEROBJ.RenderImp implements RENDEROBJ {
/*    */   public static final int MARGIN = 3;
/* 15 */   private Rec bounds = new Rec();
/*    */   
/*    */   public GFrame(RECTANGLE body) {
/* 18 */     frame(body);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Rec body() {
/* 24 */     return this.bounds;
/*    */   }
/*    */   
/*    */   public void frame(RECTANGLE body) {
/* 28 */     this.bounds.setDim((body.width() + 6), (body.height() + 6));
/* 29 */     this.bounds.centerIn(body);
/*    */   }
/*    */ 
/*    */   
/*    */   public void render(SPRITE_RENDERER r, float ds) {
/* 34 */     render(r, ds, (RECTANGLE)this.bounds);
/*    */   }
/*    */   
/*    */   public static void render(SPRITE_RENDERER r, float ds, RECTANGLE b) {
/* 38 */     render(r, b.x1(), b.x2(), b.y1(), b.y2());
/*    */   }
/*    */ 
/*    */   
/*    */   public static void render(int MARGIN, SPRITE_RENDERER r, int x1, int x2, int y1, int y2) {
/* 43 */     x1 -= MARGIN;
/* 44 */     x2 += MARGIN;
/* 45 */     y1 -= MARGIN;
/* 46 */     y2 += MARGIN;
/* 47 */     GCOLOR.UI().borderH(r, x1, x2, y1, y2);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static void render(SPRITE_RENDERER r, int x1, int x2, int y1, int y2) {
/* 53 */     render(3, r, x1, x2, y1, y2);
/*    */   }
/*    */ 
/*    */   
/*    */   public static SPRITE separator(final int width) {
/* 58 */     return new SPRITE()
/*    */       {
/*    */         public int width()
/*    */         {
/* 62 */           return width;
/*    */         }
/*    */ 
/*    */         
/*    */         public int height() {
/* 67 */           return 16;
/*    */         }
/*    */ 
/*    */ 
/*    */ 
/*    */         
/*    */         public void renderTextured(TextureCoords texture, int X1, int X2, int Y1, int Y2) {}
/*    */ 
/*    */ 
/*    */         
/*    */         public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 78 */           GCOLOR.UI().borderH(r, X1, X2, Y1 + height() / 2 - 1, Y1 + height() / 2 + 2);
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\gui\panel\GFrame.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */