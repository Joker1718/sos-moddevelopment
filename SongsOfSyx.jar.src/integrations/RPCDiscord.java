/*    */ package integrations;
/*    */ 
/*    */ import club.minnced.discord.rpc.DiscordEventHandlers;
/*    */ import club.minnced.discord.rpc.DiscordRPC;
/*    */ import club.minnced.discord.rpc.DiscordRichPresence;
/*    */ 
/*    */ 
/*    */ 
/*    */ class RPCDiscord
/*    */   extends Rpcer
/*    */ {
/* 12 */   private DiscordRPC rpcLib = DiscordRPC.INSTANCE;
/* 13 */   private long startTime = System.currentTimeMillis() / 1000L; public RPCDiscord() {
/* 14 */     String applicationId = "618471189722955807";
/* 15 */     String steamId = "";
/* 16 */     DiscordEventHandlers handlers = new DiscordEventHandlers();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 25 */     this.rpcLib.Discord_Initialize(applicationId, handlers, true, steamId);
/*    */   }
/*    */ 
/*    */   
/*    */   public void update(String state, String details) {
/* 30 */     DiscordRichPresence discordPresence = new DiscordRichPresence();
/* 31 */     discordPresence.state = state;
/* 32 */     discordPresence.details = details;
/* 33 */     discordPresence.startTimestamp = this.startTime;
/* 34 */     discordPresence.smallImageKey = "city4";
/* 35 */     this.rpcLib.Discord_UpdatePresence(discordPresence);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void dispose() {
/* 41 */     this.rpcLib.Discord_Shutdown();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\integrations\RPCDiscord.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */