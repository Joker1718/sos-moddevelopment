/*    */ package snake2d.util.sprite;
/*    */ 
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.color.ColorImp;
/*    */ import snake2d.util.datatypes.RECTANGLE;
/*    */ 
/*    */ public class ChangeSprite
/*    */   implements SPRITE {
/*    */   private SPRITE s;
/* 11 */   private final ColorImp c = new ColorImp(COLOR.WHITE100);
/*    */ 
/*    */   
/*    */   public ChangeSprite() {}
/*    */ 
/*    */   
/*    */   public ChangeSprite(SPRITE s) {
/* 18 */     set(s);
/*    */   }
/*    */   
/*    */   public ChangeSprite(SPRITE s, COLOR c) {
/* 22 */     set(s);
/* 23 */     getColor().set(c);
/*    */   }
/*    */   
/*    */   public void set(SPRITE s) {
/* 27 */     this.s = s;
/*    */   }
/*    */   
/*    */   public ColorImp getColor() {
/* 31 */     return this.c;
/*    */   }
/*    */ 
/*    */   
/*    */   public int width() {
/* 36 */     return (this.s != null) ? this.s.width() : 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public int height() {
/* 41 */     return (this.s != null) ? this.s.height() : 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 46 */     if (this.s != null) {
/* 47 */       this.c.bind();
/* 48 */       this.s.render(r, X1, X2, Y1, Y2);
/* 49 */       COLOR.unbind();
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void render(SPRITE_RENDERER r, RECTANGLE rec) {
/* 56 */     if (this.s != null) {
/* 57 */       this.c.bind();
/* 58 */       this.s.render(r, rec);
/* 59 */       COLOR.unbind();
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void render(SPRITE_RENDERER r, int X1, int Y1) {
/* 66 */     if (this.s != null) {
/* 67 */       this.c.bind();
/* 68 */       this.s.render(r, X1, Y1);
/* 69 */       COLOR.unbind();
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void renderTextured(TextureCoords texture, int X1, int X2, int Y1, int Y2) {
/* 77 */     this.s.renderTextured(texture, X1, X2, Y1, Y2);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\sprite\ChangeSprite.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */