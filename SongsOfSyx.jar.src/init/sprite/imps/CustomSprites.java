/*    */ package init.sprite.imps;
/*    */ 
/*    */ import init.paths.PATHS;
/*    */ import java.io.IOException;
/*    */ import snake2d.util.file.Json;
/*    */ 
/*    */ 
/*    */ public class CustomSprites
/*    */ {
/*    */   public CustomSprites() throws IOException {
/* 11 */     Json j = new Json((PATHS.CONFIG()).init.gets("GameSprites"));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\sprite\imps\CustomSprites.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */