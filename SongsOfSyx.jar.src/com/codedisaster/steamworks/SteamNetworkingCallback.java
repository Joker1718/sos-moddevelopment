package com.codedisaster.steamworks;

public interface SteamNetworkingCallback {
  void onP2PSessionConnectFail(SteamID paramSteamID, SteamNetworking.P2PSessionError paramP2PSessionError);
  
  void onP2PSessionRequest(SteamID paramSteamID);
}


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\com\codedisaster\steamworks\SteamNetworkingCallback.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */