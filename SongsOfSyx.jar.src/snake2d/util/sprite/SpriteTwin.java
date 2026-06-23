/*    */ package snake2d.util.sprite;
/*    */ 
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ 
/*    */ 
/*    */ public class SpriteTwin
/*    */   implements SPRITE
/*    */ {
/*    */   private SPRITE a;
/*    */   private SPRITE b;
/*    */   private int offX;
/*    */   private int offY;
/*    */   
/*    */   public SpriteTwin() {}
/*    */   
/*    */   public SpriteTwin(SPRITE a, SPRITE b) {
/* 17 */     set(a, b);
/*    */   }
/*    */   
/*    */   public void set(SPRITE a, SPRITE b) {
/* 21 */     this.a = a;
/* 22 */     this.b = b;
/* 23 */     this.offX = (a.width() - b.width()) / 2;
/* 24 */     this.offY = (a.height() - b.height()) / 2;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int width() {
/* 30 */     return this.a.width();
/*    */   }
/*    */ 
/*    */   
/*    */   public int height() {
/* 35 */     return this.a.height();
/*    */   }
/*    */ 
/*    */   
/*    */   public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 40 */     if (this.a != null) {
/* 41 */       this.a.render(r, X1, X2, Y1, Y2);
/* 42 */       this.b.render(r, X1 + this.offX, X2 - this.offX, Y1 + this.offY, Y2 - this.offY);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void renderTextured(TextureCoords other, int X1, int X2, int Y1, int Y2) {
/* 48 */     if (this.a != null) {
/* 49 */       this.a.renderTextured(other, X1, X2, Y1, Y2);
/* 50 */       this.b.renderTextured(other, X1 + this.offX, X2 - this.offX, Y1 + this.offY, Y2 - this.offY);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\sprite\SpriteTwin.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */