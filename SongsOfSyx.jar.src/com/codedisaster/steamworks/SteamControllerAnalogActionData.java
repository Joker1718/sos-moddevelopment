/*    */ package com.codedisaster.steamworks;
/*    */ 
/*    */ public class SteamControllerAnalogActionData
/*    */ {
/*    */   int mode;
/*    */   float x;
/*    */   float y;
/*    */   boolean active;
/*    */   
/*    */   public SteamController.SourceMode getMode() {
/* 11 */     return SteamController.SourceMode.byOrdinal(this.mode);
/*    */   }
/*    */   
/*    */   public float getX() {
/* 15 */     return this.x;
/*    */   }
/*    */   
/*    */   public float getY() {
/* 19 */     return this.y;
/*    */   }
/*    */   
/*    */   public boolean getActive() {
/* 23 */     return this.active;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\com\codedisaster\steamworks\SteamControllerAnalogActionData.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */