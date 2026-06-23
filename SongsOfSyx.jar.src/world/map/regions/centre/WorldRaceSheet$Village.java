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
/*     */ import util.rendering.ShadowBatch;
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
/*     */ public final class Village
/*     */ {
/*     */   public final TILE_SHEET sheet;
/*     */   public final COLOR color;
/*     */   public static final int ranI = 31;
/*     */   
/*     */   public Village(PATH getter, Json json) throws IOException {
/* 111 */     String t = "VILLAGE";
/* 112 */     String f = json.value(t);
/* 113 */     String k = t + "_" + t;
/* 114 */     if (WorldRaceSheet.map.containsKey(k)) {
/* 115 */       this.sheet = (TILE_SHEET)WorldRaceSheet.map.get(k);
/*     */     } else {
/* 117 */       this.sheet = (new ComposerThings.ITileSheet(getter.getFolder("village").get(f), 460, 34)
/*     */         {
/*     */           protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */           {
/* 121 */             s.singles.init(0, 0, 1, 1, 16, 2, (ComposerDests.Dest)d.s8);
/* 122 */             s.singles.paste(true);
/* 123 */             return d.s8.saveGame();
/*     */           }
/* 125 */         }).get();
/* 126 */       WorldRaceSheet.map.put(k, this.sheet);
/*     */     } 
/* 128 */     this.color = (COLOR)new ColorImp(json, t + "_COLOR");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, ShadowBatch s, int ran, int x, int y) {
/* 135 */     ran &= 0x1F;
/* 136 */     this.color.bind();
/* 137 */     this.sheet.render(r, ran, x, y);
/* 138 */     s.setHeight(1).setDistance2Ground(0.0D);
/* 139 */     this.sheet.render((SPRITE_RENDERER)s, ran, x, y);
/* 140 */     COLOR.unbind();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\regions\centre\WorldRaceSheet$Village.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */