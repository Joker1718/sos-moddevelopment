/*    */ package init.sprite.game;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.color.OPACITY;
/*    */ import snake2d.util.sprite.TILE_SHEET;
/*    */ import snake2d.util.sprite.TextureCoords;
/*    */ import util.rendering.RenderData;
/*    */ import util.rendering.ShadowBatch;
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
/*    */ public class Imp
/*    */   extends Sheet
/*    */ {
/*    */   public final TILE_SHEET sheet;
/*    */   private final int varSize;
/*    */   
/*    */   public Imp(SheetType type, TILE_SHEET sheet, boolean rotates) {
/* 36 */     super(sheet.tiles(), rotates & type.defRotates, shadow(sheet, type.sizeSize * ((rotates & type.defRotates) ? 4 : 1)));
/* 37 */     this.sheet = sheet;
/* 38 */     this.varSize = type.sizeSize * ((rotates & type.defRotates) ? 4 : 1);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   static boolean shadow(TILE_SHEET sheet, int size) {
/* 44 */     int i = sheet.tiles() / size;
/* 45 */     return (i > 1 && (i & 0x1) == 1);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void render(SheetData da, int x, int y, RenderData.RenderIterator it, SPRITE_RENDERER sr, int tile, int random, double degrade) {
/* 51 */     this.sheet.render(sr, tile, x, y);
/* 52 */     if (degrade > 0.05D) {
/* 53 */       OPACITY.O99.bind();
/* 54 */       this.sheet.renderTextured((SETT.ROOMS()).util.filth.texture(degrade, it.ran()), tile, x, y);
/* 55 */       OPACITY.unbind();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void renderShadow(SheetData da, int x, int y, RenderData.RenderIterator it, ShadowBatch shadow, int tile, int random) {
/* 61 */     if (da.shadowLength > 0 || da.shadowHeight > 0) {
/* 62 */       shadow.setHeight(da.shadowLength).setDistance2Ground(da.shadowHeight);
/* 63 */       int t = tile;
/* 64 */       if (this.hasShadow) {
/* 65 */         t = this.sheet.tiles() - this.varSize;
/* 66 */         t += tile % this.varSize;
/*    */       } 
/* 68 */       this.sheet.render((SPRITE_RENDERER)shadow, t, x, y);
/*    */     } 
/*    */   }
/*    */   
/*    */   public TILE_SHEET sheet() {
/* 73 */     return this.sheet;
/*    */   }
/*    */ 
/*    */   
/*    */   public TextureCoords texture(int tile) {
/* 78 */     return this.sheet.getTexture(tile);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\sprite\game\Sheet$Imp.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */