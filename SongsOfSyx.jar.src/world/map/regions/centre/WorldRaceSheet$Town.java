/*    */ package world.map.regions.centre;
/*    */ 
/*    */ import init.paths.PATH;
/*    */ import java.io.IOException;
/*    */ import java.nio.file.Path;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.color.ColorImp;
/*    */ import snake2d.util.file.Json;
/*    */ import snake2d.util.misc.CLAMP;
/*    */ import snake2d.util.sprite.TILE_SHEET;
/*    */ import util.rendering.ShadowBatch;
/*    */ import util.spritecomposer.ComposerDests;
/*    */ import util.spritecomposer.ComposerSources;
/*    */ import util.spritecomposer.ComposerThings;
/*    */ import util.spritecomposer.ComposerUtil;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class Town
/*    */ {
/*    */   public final TILE_SHEET sheet;
/*    */   public final COLOR color;
/*    */   public static final int maxSize = 3;
/*    */   
/*    */   public Town(PATH getter, Json json) throws IOException {
/* 71 */     String t = "TOWN";
/* 72 */     String f = json.value(t);
/* 73 */     String k = t + "_" + t;
/* 74 */     if (WorldRaceSheet.map.containsKey(k)) {
/* 75 */       this.sheet = (TILE_SHEET)WorldRaceSheet.map.get(k);
/*    */     } else {
/* 77 */       this.sheet = (new ComposerThings.ITileSheet(getter.getFolder("town").get(f), 460, 62)
/*    */         {
/*    */           protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*    */           {
/* 81 */             s.singles.init(0, 0, 1, 1, 16, 4, (ComposerDests.Dest)d.s8);
/* 82 */             s.singles.paste(true);
/* 83 */             return d.s8.saveGame();
/*    */           }
/* 85 */         }).get();
/* 86 */       WorldRaceSheet.map.put(k, this.sheet);
/*    */     } 
/* 88 */     this.color = (COLOR)new ColorImp(json, t + "_COLOR");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void render(SPRITE_RENDERER r, ShadowBatch s, int size, int ran, int x, int y) {
/* 95 */     size = CLAMP.i(size, 0, 3);
/* 96 */     this.color.bind();
/* 97 */     this.sheet.render(r, 16 * size + (ran & 0xF), x, y);
/* 98 */     this.sheet.render((SPRITE_RENDERER)s, 16 * size + (ran & 0xF), x, y);
/* 99 */     COLOR.unbind();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\regions\centre\WorldRaceSheet$Town.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */