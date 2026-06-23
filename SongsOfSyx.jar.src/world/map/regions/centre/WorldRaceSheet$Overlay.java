/*     */ package world.map.regions.centre;
/*     */ 
/*     */ import init.paths.PATH;
/*     */ import java.io.IOException;
/*     */ import java.nio.file.Path;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ import util.spritecomposer.ComposerDests;
/*     */ import util.spritecomposer.ComposerSources;
/*     */ import util.spritecomposer.ComposerThings;
/*     */ import util.spritecomposer.ComposerUtil;
/*     */ import world.WRenContext;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class Overlay
/*     */ {
/*     */   public final TILE_SHEET sheet;
/*     */   public final COLOR color;
/*     */   public static final int maxSize = 3;
/*     */   
/*     */   public Overlay(PATH getter, Json json) throws IOException {
/* 152 */     String t = "OVERLAY";
/* 153 */     String f = json.value(t);
/* 154 */     String k = t + "_" + t;
/* 155 */     if (WorldRaceSheet.map.containsKey(k)) {
/* 156 */       this.sheet = (TILE_SHEET)WorldRaceSheet.map.get(k);
/*     */     } else {
/* 158 */       this.sheet = (new ComposerThings.ITileSheet(getter.getFolder("overlay").get(f), 236, 34)
/*     */         {
/*     */           protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */           {
/* 162 */             s.singles.init(0, 0, 1, 1, 8, 2, (ComposerDests.Dest)d.s8);
/* 163 */             s.singles.paste(true);
/* 164 */             return d.s8.saveGame();
/*     */           }
/* 166 */         }).get();
/* 167 */       WorldRaceSheet.map.put(k, this.sheet);
/*     */     } 
/* 169 */     this.color = (COLOR)new ColorImp(json, t + "_COLOR");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(WRenContext con, int ran, int x, int y) {
/* 176 */     this.color.bind();
/* 177 */     this.sheet.render(con.r, ran & 0xF, x, y);
/* 178 */     this.sheet.render((SPRITE_RENDERER)con.s, ran & 0xF, x, y);
/* 179 */     COLOR.unbind();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\regions\centre\WorldRaceSheet$Overlay.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */