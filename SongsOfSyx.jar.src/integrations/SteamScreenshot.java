/*    */ package integrations;
/*    */ 
/*    */ import com.codedisaster.steamworks.SteamResult;
/*    */ import com.codedisaster.steamworks.SteamScreenshotHandle;
/*    */ import com.codedisaster.steamworks.SteamScreenshots;
/*    */ import com.codedisaster.steamworks.SteamScreenshotsCallback;
/*    */ 
/*    */ final class SteamScreenshot
/*    */ {
/*    */   private SteamScreenshots ss;
/*    */   
/* 12 */   private SteamScreenshotsCallback ssCallback = new SteamScreenshotsCallback()
/*    */     {
/*    */       public void onScreenshotReady(SteamScreenshotHandle local, SteamResult result)
/*    */       {
/* 16 */         INTEGRATIONS.log("Screenshot saved on disk!");
/* 17 */         INTEGRATIONS.log("Result: " + result);
/*    */       }
/*    */ 
/*    */       
/*    */       public void onScreenshotRequested() {
/* 22 */         INTEGRATIONS.log("Steam wants to take a screenshot!");
/*    */       }
/*    */     };
/*    */ 
/*    */   
/*    */   public SteamScreenshot() {
/* 28 */     init();
/*    */   }
/*    */   
/*    */   private void init() {
/* 32 */     INTEGRATIONS.log("Register SteamScreenshot ...");
/* 33 */     this.ss = new SteamScreenshots(this.ssCallback);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void addScreenshot(String path, String thumbnailPath, int width, int height) {
/* 39 */     this.ss.addScreenshotToLibrary(path, thumbnailPath, width, height);
/*    */   }
/*    */   
/*    */   public void dispose() {
/* 43 */     this.ss.dispose();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\integrations\SteamScreenshot.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */