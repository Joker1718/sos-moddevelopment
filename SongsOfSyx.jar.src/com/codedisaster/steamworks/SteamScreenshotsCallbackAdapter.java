/*    */ package com.codedisaster.steamworks;
/*    */ 
/*    */ public class SteamScreenshotsCallbackAdapter
/*    */   extends SteamCallbackAdapter<SteamScreenshotsCallback>
/*    */ {
/*    */   SteamScreenshotsCallbackAdapter(SteamScreenshotsCallback callback) {
/*  7 */     super(callback);
/*    */   }
/*    */   
/*    */   void onScreenshotReady(int local, int result) {
/* 11 */     this.callback.onScreenshotReady(new SteamScreenshotHandle(local), SteamResult.byValue(result));
/*    */   }
/*    */   
/*    */   void onScreenshotRequested() {
/* 15 */     this.callback.onScreenshotRequested();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\com\codedisaster\steamworks\SteamScreenshotsCallbackAdapter.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */