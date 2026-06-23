/*    */ package init.race.appearence;
/*    */ 
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.color.OPACITY;
/*    */ import snake2d.util.misc.CLAMP;
/*    */ import snake2d.util.sprite.TILE_SHEET;
/*    */ 
/*    */ 
/*    */ class RaceFrameRaw
/*    */ {
/*    */   public final TILE_SHEET sheet;
/*    */   public final int offY;
/*    */   public static final int WIDTH = 40;
/*    */   public static final int HEIGHT = 40;
/*    */   private final int hh;
/*    */   private final RaceFrameMaker f;
/*    */   
/*    */   RaceFrameRaw(RaceFrameMaker f, TILE_SHEET sheet, int offY) {
/* 20 */     this.sheet = sheet;
/* 21 */     this.offY = offY;
/* 22 */     this.f = f;
/* 23 */     this.hh = sheet.tiles() / 5;
/*    */   }
/*    */ 
/*    */   
/*    */   public void render(SPRITE_RENDERER r, int X1, int Y1, int scale) {
/* 28 */     Y1 += this.offY * scale;
/*    */     
/* 30 */     int d = scale * 8;
/*    */     
/* 32 */     int i = 0;
/* 33 */     for (int y = 0; y < this.hh; y++) {
/* 34 */       for (int x = 0; x < 5; x++) {
/* 35 */         this.sheet.render(r, i++, X1 + x * d, X1 + x * d + d, Y1 + y * d, Y1 + y * d + d);
/*    */       }
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void renderOverlay(SPRITE_RENDERER r, int X1, int Y1, int scale, double blood, double grit, COLOR bloodC) {
/* 43 */     int bi = CLAMP.i((int)(blood * 4.0D), 0, 4) - 1;
/* 44 */     int gi = CLAMP.i((int)(grit * 4.0D), 0, 4) - 1;
/*    */     
/* 46 */     Y1 += this.offY * scale;
/*    */     
/* 48 */     int d = scale * 8;
/* 49 */     OPACITY.O99.bind();
/* 50 */     if (gi >= 0) {
/* 51 */       int i = 0;
/* 52 */       for (int y = 0; y < this.hh; y++) {
/* 53 */         for (int x = 0; x < 5; x++) {
/* 54 */           this.sheet.renderTextured(((RaceFrameRaw)this.f.grit.get(gi)).sheet.getTexture(i), i++, X1 + x * d, Y1 + y * d, scale);
/*    */         }
/*    */       } 
/*    */     } 
/*    */     
/* 59 */     if (bi >= 0) {
/* 60 */       bloodC.bind();
/* 61 */       int i = 0;
/* 62 */       for (int y = 0; y < this.hh; y++) {
/* 63 */         for (int x = 0; x < 5; x++) {
/* 64 */           this.sheet.renderTextured(((RaceFrameRaw)this.f.blood.get(bi)).sheet.getTexture(i), i++, X1 + x * d, Y1 + y * d, scale);
/*    */         }
/*    */       } 
/* 67 */       COLOR.unbind();
/*    */     } 
/* 69 */     OPACITY.unbind();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\race\appearence\RaceFrameRaw.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */