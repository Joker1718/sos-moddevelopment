/*     */ package init.sprite.game;
/*     */ 
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.UICons;
/*     */ import java.io.IOException;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ import util.spritecomposer.ComposerDests;
/*     */ import util.spritecomposer.ComposerSources;
/*     */ import util.spritecomposer.ComposerThings;
/*     */ import util.spritecomposer.ComposerUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class cXxX
/*     */   extends SheetType
/*     */ {
/*     */   public final int size;
/*     */   
/*     */   cXxX(int size) {
/* 387 */     super("" + size + "x" + size, size * size, size * 16 + 12, size * 16 + 12, true);
/* 388 */     this.size = size;
/*     */   }
/*     */ 
/*     */   
/*     */   public TILE_SHEET make(final int w, final int y1) throws IOException {
/* 393 */     return (new ComposerThings.ITileSheet()
/*     */       {
/*     */         protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */         {
/* 397 */           s.combo.init(0, y1, w, 1, SheetType.cXxX.this.size, (ComposerDests.Dest)d.s16);
/* 398 */           for (int i = 0; i < w; i++) {
/* 399 */             s.combo.setVar(i).paste(3, true);
/*     */           }
/*     */           
/* 402 */           return d.s16.saveGame();
/*     */         }
/* 404 */       }).get();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int tile(Sheet sheet, SheetData da, int data, int variation, int rotation) {
/* 410 */     int t = data;
/* 411 */     int rot = rotation;
/*     */     
/* 413 */     int sizeSizeRot = this.sizeSize * (sheet.hasRotation ? 4 : 1);
/* 414 */     int vars = sheet.tiles / sizeSizeRot - (sheet.hasShadow ? 1 : 0);
/*     */     
/* 416 */     variation = getVar(variation, vars, da.circular);
/*     */ 
/*     */     
/* 419 */     t += variation * sizeSizeRot;
/*     */ 
/*     */     
/* 422 */     if (rotation >= 0 && sheet.hasRotation) {
/* 423 */       return t + rot * this.sizeSize;
/*     */     }
/* 425 */     return t;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderOverlay(int x, int y, SPRITE_RENDERER r, AVAILABILITY a, int data, int rotation, boolean single) {
/* 431 */     UICons c = (SPRITES.cons()).BIG.filled;
/* 432 */     if (a.player >= 0.0D)
/*     */     {
/* 434 */       if (a.from > 1.0D || a.player > AVAILABILITY.ROOM.player) {
/* 435 */         (SPRITES.cons()).BIG.dashedThick.render(r, 0, x, y);
/*     */       } else {
/* 437 */         (SPRITES.cons()).BIG.outline.render(r, 0, x, y);
/*     */       }  } 
/* 439 */     int m = 0;
/* 440 */     int dx = dx(data);
/* 441 */     int dy = dy(data);
/*     */     
/* 443 */     for (DIR d : DIR.ORTHO) {
/* 444 */       if (dx + d.x() >= 0 && dx + d.x() < this.size && dy + d.y() >= 0 && dy + d.y() < this.size) {
/* 445 */         m |= d.mask();
/*     */       }
/*     */     } 
/* 448 */     c.render(r, m, x, y);
/*     */     
/* 450 */     if (rotation >= 0) {
/*     */       
/* 452 */       COLOR.WHITE50.bind();
/* 453 */       Sheet ss = SPRITES.GAME().overlay(this);
/* 454 */       int t = tile(ss, SheetData.DUMMY, data & 0x3F, 0, rotation);
/* 455 */       ss.render(null, x, y, null, r, t, t, 0.0D);
/* 456 */       COLOR.unbind();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int dx(int data) {
/* 462 */     return (data & 0x3F) % this.size;
/*     */   }
/*     */   
/*     */   public int dy(int data) {
/* 466 */     return (data & 0x3F) / this.size;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\sprite\game\SheetType$cXxX.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */