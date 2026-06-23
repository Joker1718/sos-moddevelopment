/*    */ package init.resources;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.nio.file.Path;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.sprite.TILE_SHEET;
/*    */ import util.spritecomposer.ComposerDests;
/*    */ import util.spritecomposer.ComposerSources;
/*    */ import util.spritecomposer.ComposerThings;
/*    */ import util.spritecomposer.ComposerUtil;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ final class Sprite
/*    */ {
/*    */   public final TILE_SHEET carry;
/*    */   public final TILE_SHEET lay;
/*    */   public final COLOR color;
/*    */   
/*    */   Sprite(Path path) throws IOException {
/* 22 */     this.carry = (new ComposerThings.ITileSheet(path, 244, 94)
/*    */       {
/*    */         
/*    */         protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*    */         {
/* 27 */           s.singles.init(0, 0, 1, 1, 1, 4, (ComposerDests.Dest)d.s16);
/*    */           
/* 29 */           s.singles.setSkip(0, 2).paste(3, true);
/* 30 */           return d.s16.saveGame();
/*    */         }
/* 32 */       }).get();
/*    */     
/* 34 */     this.color = (new ComposerThings.IColorSamplerSingle()
/*    */       {
/*    */         protected COLOR init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*    */         {
/* 38 */           s.singles.setSkip(2, 1);
/* 39 */           return s.singles.sample();
/*    */         }
/* 41 */       }).get();
/*    */     
/* 43 */     this.lay = (new ComposerThings.ITileSheet()
/*    */       {
/*    */         protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*    */         {
/* 47 */           s.singles.init(
/* 48 */               s.singles.body().x2(), 0, 
/* 49 */               1, 1, 
/* 50 */               4, 4, 
/* 51 */               (ComposerDests.Dest)d.s16);
/* 52 */           s.singles.paste(true);
/* 53 */           return d.s16.saveGame();
/*    */         }
/* 55 */       }).get();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   static class Util
/*    */   {
/*    */     public TILE_SHEET getMinable(Path path) throws IOException {
/* 63 */       return (new ComposerThings.ITileSheet(path, 364, 94)
/*    */         {
/*    */           protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*    */           {
/* 67 */             s.singles.init(0, 0, 1, 1, 8, 4, (ComposerDests.Dest)d.s16);
/* 68 */             s.singles.paste(true);
/* 69 */             return d.s16.saveGame();
/*    */           }
/* 71 */         }).get();
/*    */     }
/*    */     
/*    */     public TILE_SHEET getGrowable(Path path) throws IOException {
/* 75 */       return (new ComposerThings.ITileSheet(path, 364, 182)
/*    */         {
/*    */           protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*    */           {
/* 79 */             s.singles.init(0, 0, 1, 1, 8, 8, (ComposerDests.Dest)d.s16);
/* 80 */             s.singles.paste(true);
/* 81 */             return d.s16.saveGame();
/*    */           }
/* 83 */         }).get();
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\resources\Sprite.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */