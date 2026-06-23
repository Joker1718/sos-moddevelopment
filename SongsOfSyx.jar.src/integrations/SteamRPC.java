/*    */ package integrations;
/*    */ 
/*    */ import com.codedisaster.steamworks.SteamFriends;
/*    */ import com.codedisaster.steamworks.SteamFriendsCallback;
/*    */ import com.codedisaster.steamworks.SteamID;
/*    */ import com.codedisaster.steamworks.SteamResult;
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
/*    */ final class SteamRPC
/*    */   extends Rpcer
/*    */ {
/*    */   private final SteamFriends friends;
/*    */   private final SteamClient steam;
/*    */   private SteamFriendsCallback friendsCallback;
/*    */   
/*    */   public SteamRPC(SteamClient steam) {
/* 40 */     this.friendsCallback = new SteamFriendsCallback() {
/*    */         public void onSetPersonaNameResponse(boolean success, boolean localSuccess, SteamResult result) {}
/*    */         
/*    */         public void onPersonaStateChange(SteamID steamID, SteamFriends.PersonaChange change) {}
/*    */         
/*    */         public void onGameOverlayActivated(boolean active) {}
/*    */         
/*    */         public void onGameLobbyJoinRequested(SteamID steamIDLobby, SteamID steamIDFriend) {}
/*    */         
/*    */         public void onAvatarImageLoaded(SteamID steamID, int image, int width, int height) {}
/*    */         
/*    */         public void onFriendRichPresenceUpdate(SteamID steamIDFriend, int appID) {}
/*    */         
/*    */         public void onGameRichPresenceJoinRequested(SteamID steamIDFriend, String connect) {}
/*    */         
/*    */         public void onGameServerChangeRequested(String server, String password) {}
/*    */       };
/*    */     this.steam = steam;
/*    */     this.friends = new SteamFriends(this.friendsCallback);
/*    */   }
/*    */   
/*    */   protected void dispose() {
/*    */     this.friends.dispose();
/*    */   }
/*    */   
/*    */   public void update(String state, String details) {
/*    */     if (this.steam.running())
/*    */       try {
/*    */         if (details != null) {
/*    */           this.friends.setRichPresence("text", String.valueOf(state) + " | " + details);
/*    */         } else {
/*    */           this.friends.setRichPresence("text", state);
/*    */         } 
/*    */         this.friends.setRichPresence("steam_display", "#StatusFull");
/*    */       } catch (Exception e) {
/*    */         e.printStackTrace();
/*    */         throw new RuntimeException("Something is wrong with RPC. Please uncheck RPC in the launcher and see if it helps.");
/*    */       }  
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\integrations\SteamRPC.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */