/*    */ package snake2d.util.sprite;
/*    */ 
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.datatypes.Coo;
/*    */ 
/*    */ public class SpriteWithOffset
/*    */   extends Coo implements SPRITE {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private final SPRITE a;
/*    */   
/*    */   public SpriteWithOffset(SPRITE s) {
/* 12 */     this.a = s;
/*    */   }
/*    */   
/*    */   public SpriteWithOffset(SPRITE s, int x, int y) {
/* 16 */     super(x, y);
/* 17 */     this.a = s;
/*    */   }
/*    */ 
/*    */   
/*    */   public int width() {
/* 22 */     return this.a.width();
/*    */   }
/*    */ 
/*    */   
/*    */   public int height() {
/* 27 */     return this.a.height();
/*    */   }
/*    */ 
/*    */   
/*    */   public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 32 */     X1 += x();
/* 33 */     Y1 += y();
/* 34 */     X2 += x();
/* 35 */     Y2 += y();
/* 36 */     this.a.render(r, X1, X2, Y1, Y2);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void renderTextured(TextureCoords other, int X1, int X2, int Y1, int Y2) {
/* 42 */     X1 += x();
/* 43 */     Y1 += y();
/* 44 */     X2 += x();
/* 45 */     Y2 += y();
/* 46 */     this.a.renderTextured(other, X1, X2, Y1, Y2);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\sprite\SpriteWithOffset.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */