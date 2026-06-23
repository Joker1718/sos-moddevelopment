/*     */ package init.sprite.game;
/*     */ 
/*     */ import game.GAME;
/*     */ import init.paths.PATH;
/*     */ import init.paths.PATHS;
/*     */ import init.sprite.SPRITES;
/*     */ import java.io.IOException;
/*     */ import java.nio.file.Path;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import snake2d.Errors;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.file.SnakeImage;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
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
/*     */ public class cTex
/*     */   extends SheetType
/*     */ {
/*     */   cTex() {
/* 134 */     super("texture", 1, 22, 22, true);
/*     */   }
/*     */ 
/*     */   
/*     */   protected LIST<TILE_SHEET> make(String key, Json error) throws IOException {
/* 139 */     PATH pp = PATHS.SPRITE_GAME().getFolder(this.path);
/*     */     
/* 141 */     if (!pp.exists(key)) {
/* 142 */       if (error != null) {
/* 143 */         GAME.WarnLight(error.path());
/*     */       }
/* 145 */       GAME.WarnLight("The sprite file: " + key + " does not exist in the folder: " + String.valueOf(pp.get()));
/* 146 */       return (LIST<TILE_SHEET>)new ArrayList(DUMMY);
/*     */     } 
/*     */     
/* 149 */     Path p = pp.get(key);
/*     */     
/* 151 */     SnakeImage im = new SnakeImage(p);
/*     */     
/* 153 */     int iwidth = im.width / 2;
/* 154 */     int iheight = im.height;
/* 155 */     im.dispose();
/*     */     
/* 157 */     final int tilesX = (iwidth - 12) / 16;
/*     */     
/* 159 */     if (tilesX * 16 + 12 != iwidth) {
/* 160 */       throw new Errors.DataError("Image width does not work. resize", p);
/*     */     }
/* 162 */     final int tilesY = iheight / 28;
/* 163 */     if (tilesY * 28 != iheight) {
/* 164 */       throw new Errors.DataError("Image height does not work. resize", p);
/*     */     }
/*     */ 
/*     */     
/* 168 */     ArrayList<TILE_SHEET> res = new ArrayList(tilesY);
/*     */     
/* 170 */     for (int i = 0; i < tilesY; i++) {
/* 171 */       final int k = i;
/* 172 */       TILE_SHEET s = (new ComposerThings.ITileSheet()
/*     */         {
/*     */           protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */           {
/* 176 */             s.full.init(0, 0, 1, tilesY, tilesX, 1, d.s16);
/* 177 */             s.full.setVar(k).paste(true);
/* 178 */             return d.s16.saveGame();
/*     */           }
/* 180 */         }).get();
/* 181 */       res.add(s);
/*     */     } 
/* 183 */     return (LIST<TILE_SHEET>)res;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int tile(Sheet sheet, SheetData da, int data, int variation, int rotation) {
/* 190 */     variation &= 0xFFFF;
/* 191 */     int am = sheet.tiles;
/* 192 */     if (sheet.hasShadow) {
/* 193 */       am--;
/*     */     }
/* 195 */     variation = getVar(variation, am, da.circular);
/*     */     
/* 197 */     return variation % am;
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderOverlay(int x, int y, SPRITE_RENDERER r, AVAILABILITY a, int data, int rotation, boolean single) {
/* 202 */     if (a.player < 0.0D) {
/* 203 */       (SPRITES.cons()).BIG.filled.render(r, 0, x, y);
/* 204 */     } else if (a.from > 1.0D || a.player > AVAILABILITY.ROOM.player) {
/* 205 */       (SPRITES.cons()).BIG.dashedThick.render(r, 0, x, y);
/*     */     } else {
/* 207 */       (SPRITES.cons()).BIG.outline.render(r, 0, x, y);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public TILE_SHEET make(int amount, int y1) throws IOException {
/* 214 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\sprite\game\SheetType$cTex.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */