/*    */ package menu;
/*    */ 
/*    */ import init.paths.PATHS;
/*    */ import java.io.IOException;
/*    */ import snake2d.CORE;
/*    */ import util.spritecomposer.Initer;
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
/*    */ class null
/*    */   extends CORE.GlJob
/*    */ {
/*    */   public void doJob() {
/* 41 */     (new Initer()
/*    */       {
/*    */         
/*    */         public void createAssets() throws IOException
/*    */         {
/* 46 */           (RESOURCES.null.access$0(RESOURCES.null.this)).s = new RESOURCES.RSprites();
/*    */         }
/* 49 */       }).get("menu", PATHS.textureSize(), 0);
/* 50 */     RESOURCES.this.sound = new RESOURCES.RSound();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\menu\RESOURCES$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */