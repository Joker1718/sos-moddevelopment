/*    */ package init.sprite;
/*    */ 
/*    */ import init.paths.PATH;
/*    */ import init.paths.PATHS;
/*    */ import java.io.IOException;
/*    */ import java.nio.file.Path;
/*    */ import snake2d.util.sprite.TileTexture;
/*    */ import util.spritecomposer.ComposerDests;
/*    */ import util.spritecomposer.ComposerSources;
/*    */ import util.spritecomposer.ComposerTexturer;
/*    */ import util.spritecomposer.ComposerThings;
/*    */ import util.spritecomposer.ComposerUtil;
/*    */ import util.spritecomposer.SpriteData;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class Textures
/*    */ {
/*    */   public final TileTexture dis_big;
/*    */   public final TileTexture dis_small;
/*    */   public final TileTexture dis_tiny;
/*    */   public final TileTexture fire;
/*    */   public final TileTexture water;
/*    */   public final TileTexture bumps;
/*    */   public final TileTexture dots;
/*    */   public final TileTexture dis_low;
/*    */   
/*    */   Textures() throws IOException {
/* 32 */     PATH path = PATHS.SPRITE().getFolder("textures");
/*    */     
/* 34 */     this.dots = get(path.get("Dots"));
/* 35 */     this.dis_low = get(path.get("Displacement_low"));
/* 36 */     this.dis_big = get(path.get("Displacement_Big"));
/* 37 */     this.dis_small = get(path.get("Displacement_small"));
/* 38 */     this.dis_tiny = get(path.get("Displacement_tiny"));
/* 39 */     this.bumps = get(path.get("Bumps"));
/* 40 */     this.water = get(path.get("Water"));
/* 41 */     this.fire = get(path.get("Fire"));
/*    */   }
/*    */ 
/*    */   
/*    */   private static TileTexture get(Path path) throws IOException {
/* 46 */     return (new ComposerThings.ITileTexture(8, 8, path, 280, 140)
/*    */       {
/*    */         
/*    */         protected SpriteData init(ComposerUtil c, ComposerSources s, ComposerDests d, ComposerTexturer t)
/*    */         {
/* 51 */           return t.paste(0, 0, 8, 8);
/*    */         }
/* 53 */       }).get();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\sprite\Textures.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */