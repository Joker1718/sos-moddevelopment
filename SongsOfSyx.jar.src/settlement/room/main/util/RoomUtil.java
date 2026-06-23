/*    */ package settlement.room.main.util;
/*    */ 
/*    */ import init.paths.PATHS;
/*    */ import java.io.IOException;
/*    */ import java.nio.file.Path;
/*    */ import snake2d.util.sprite.TILE_SHEET;
/*    */ import snake2d.util.sprite.TextureCoords;
/*    */ import util.spritecomposer.ComposerDests;
/*    */ import util.spritecomposer.ComposerSources;
/*    */ import util.spritecomposer.ComposerThings;
/*    */ import util.spritecomposer.ComposerUtil;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RoomUtil
/*    */ {
/* 19 */   public final FilthTexture filth = new FilthTexture();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static final class FilthTexture
/*    */   {
/* 31 */     private final TILE_SHEET sheet = (new ComposerThings.ITileSheet(PATHS.SPRITE_SETTLEMENT().getFolder("map").get("Filth"), 536, 140)
/*    */       {
/*    */         protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*    */         {
/* 35 */           s.full.init(0, 0, 1, 1, 16, 8, d.s16);
/* 36 */           s.full.paste(true);
/* 37 */           return d.s16.saveGame();
/*    */         }
/* 39 */       }).get();
/*    */ 
/*    */     
/*    */     public TextureCoords texture(double amount, int ran) {
/* 43 */       int i = (int)(amount * 7.0D) * 16;
/* 44 */       i += ran & 0xF;
/* 45 */       return this.sheet.getTexture(i);
/*    */     }
/*    */     
/*    */     private static final int vars = 16;
/*    */     private static final int amounts = 8;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\mai\\util\RoomUtil.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */