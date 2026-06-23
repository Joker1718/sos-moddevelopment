/*    */ package util.spritecomposer;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.nio.file.Path;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.sprite.TILE_SHEET;
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
/*    */ 
/*    */ public abstract class ITileSheet
/*    */ {
/*    */   protected ITileSheet() {}
/*    */   
/*    */   protected ITileSheet(Path path, int width, int height) throws IOException {
/* 60 */     Resources.c.setSource(path, width, height);
/*    */   }
/*    */   
/*    */   static TILE_SHEET save(int scale, int tileSize, int startTile, int tiles, int tilesX) {
/* 64 */     Resources.p.mark("sheet");
/* 65 */     Resources.p.i(scale);
/* 66 */     Resources.p.i(tileSize);
/* 67 */     Resources.p.i(startTile);
/* 68 */     Resources.p.i(tiles);
/* 69 */     Resources.p.i(tilesX);
/* 70 */     return new TIleSheetPow2(scale, tileSize, startTile, tilesX, tiles);
/*    */   }
/*    */   
/*    */   private static TILE_SHEET read(FileGetter g) throws IOException {
/* 74 */     g.check("sheet");
/* 75 */     int scale = g.i();
/* 76 */     int tileSize = g.i();
/* 77 */     int startTile = g.i();
/* 78 */     int tiles = g.i();
/* 79 */     int tilesX = g.i();
/* 80 */     return new TIleSheetPow2(scale, tileSize, startTile, tilesX, tiles);
/*    */   }
/*    */   
/*    */   public TILE_SHEET get() throws IOException {
/* 84 */     if (Resources.g == null) {
/* 85 */       TILE_SHEET s = init(Resources.c, Resources.sources, Resources.dests);
/* 86 */       if (s == null) {
/* 87 */         save(1, 8, 0, 0, 0);
/*    */       }
/* 89 */       return s;
/*    */     } 
/* 91 */     return read(Resources.g);
/*    */   }
/*    */   
/*    */   protected abstract TILE_SHEET init(ComposerUtil paramComposerUtil, ComposerSources paramComposerSources, ComposerDests paramComposerDests);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\spritecomposer\ComposerThings$ITileSheet.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */