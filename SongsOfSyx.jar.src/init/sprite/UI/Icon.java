/*    */ package init.sprite.UI;
/*    */ 
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import snake2d.util.sprite.TILE_SHEET;
/*    */ import snake2d.util.sprite.TextureCoords;
/*    */ import util.spritecomposer.SpriteData;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Icon
/*    */   implements SPRITE
/*    */ {
/*    */   public static final int S = 16;
/*    */   public static final int M = 24;
/*    */   public static final int L = 32;
/*    */   public static final int HUGE = 64;
/*    */   public final int size;
/*    */   private final SPRITE sprite;
/*    */   public final SPRITE huge;
/*    */   public final SPRITE big;
/*    */   public final SPRITE small;
/*    */   public final SPRITE medium;
/*    */   
/*    */   public Icon(int size, SPRITE s) {
/* 29 */     this.size = size;
/* 30 */     this.sprite = s;
/* 31 */     this.big = (size == 32) ? this : (SPRITE)new SPRITE.Scaled(this, 32, 32);
/* 32 */     this.small = (size == 16) ? this : (SPRITE)new SPRITE.Scaled(this, 16, 16);
/* 33 */     this.medium = (size == 24) ? this : (SPRITE)new SPRITE.Scaled(this, 24, 24);
/* 34 */     this.huge = (size == 64) ? this : (SPRITE)new SPRITE.Scaled(this, 64, 64);
/*    */   }
/*    */   
/*    */   public Icon(SpriteData data) {
/* 38 */     this(data.width, (SPRITE)new SPRITE.SpriteImp(data.x1, data.x1 + data.width, data.y1, data.y1 + data.height, data.width, data.height));
/*    */   }
/*    */   
/*    */   public Icon(SPRITE sprite) {
/* 42 */     this(sprite.width(), sprite);
/*    */   }
/*    */   
/*    */   public Icon twin(SPRITE b) {
/* 46 */     return new Icon(this.size, (SPRITE)new SPRITE.Twin(this, b));
/*    */   }
/*    */ 
/*    */   
/*    */   public Icon createColored(COLOR color) {
/* 51 */     return new Icon(super.createColored(color));
/*    */   }
/*    */ 
/*    */   
/*    */   public Icon twin(SPRITE b, DIR align, int shadow) {
/* 56 */     return new Icon(this.size, super.twin(b, align, shadow));
/*    */   }
/*    */ 
/*    */   
/*    */   public int width() {
/* 61 */     return this.size;
/*    */   }
/*    */ 
/*    */   
/*    */   public int height() {
/* 66 */     return this.size;
/*    */   }
/*    */ 
/*    */   
/*    */   public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 71 */     this.sprite.render(r, X1, X2, Y1, Y2);
/*    */   }
/*    */ 
/*    */   
/*    */   public void renderTextured(TextureCoords other, int X1, int X2, int Y1, int Y2) {
/* 76 */     this.sprite.renderTextured(other, X1, X2, Y1, Y2);
/*    */   }
/*    */   
/*    */   static class IconSheet
/*    */     extends Icon {
/*    */     private final TILE_SHEET sheet;
/*    */     private final int tile;
/*    */     
/*    */     IconSheet(int size, TILE_SHEET sheet, int tile) {
/* 85 */       super(size, (SPRITE)new SPRITE.Imp(size, sheet, tile)
/*    */           {
/*    */             public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*    */             {
/* 89 */               sheet.render(r, tile, X1, X2, Y1, Y2);
/*    */             }
/*    */           });
/* 92 */       this.sheet = sheet;
/* 93 */       this.tile = tile;
/*    */     }
/*    */ 
/*    */     
/*    */     public TextureCoords texture() {
/* 98 */       return this.sheet.getTexture(this.tile);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\sprite\UI\Icon.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */