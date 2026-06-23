/*    */ package com.codedisaster.steamworks;
/*    */ 
/*    */ public class SteamUGCQuery
/*    */   extends SteamNativeHandle {
/*    */   public SteamUGCQuery(long handle) {
/*  6 */     super(handle);
/*    */   }
/*    */   
/*    */   public boolean isValid() {
/* 10 */     return (this.handle != -1L);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\com\codedisaster\steamworks\SteamUGCQuery.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */