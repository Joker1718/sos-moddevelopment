/*    */ package snake2d.util.sprite;
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
/*    */ public class TextureCoords
/*    */ {
/*    */   public short x1;
/*    */   public short x2;
/*    */   public short y1;
/*    */   public short y2;
/* 18 */   public static final TextureCoords Texture = new TextureCoords();
/* 19 */   public static final TextureCoords Normal = new TextureCoords();
/*    */   
/*    */   public TextureCoords get(int x1, int y1, int width, int height) {
/* 22 */     this.x1 = (short)x1; this.x2 = (short)(x1 + width); this.y1 = (short)y1; this.y2 = (short)(y1 + height);
/* 23 */     return this;
/*    */   }
/*    */   public TextureCoords get(TextureCoords other) {
/* 26 */     this.x1 = other.x1; this.x2 = other.x2; this.y1 = other.y1; this.y2 = other.y2;
/* 27 */     return this;
/*    */   }
/*    */   
/*    */   public int width() {
/* 31 */     return this.x2 - this.x1;
/*    */   }
/*    */   
/*    */   public int height() {
/* 35 */     return this.y2 - this.y1;
/*    */   }
/*    */   
/*    */   public TextureCoords(int x1, int x2, int y1, int y2) {
/* 39 */     this.x1 = (short)x1;
/* 40 */     this.y1 = (short)y1;
/* 41 */     this.x2 = (short)x2;
/* 42 */     this.y2 = (short)y2;
/*    */   }
/*    */   
/*    */   public TextureCoords() {}
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\sprite\TextureCoords.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */