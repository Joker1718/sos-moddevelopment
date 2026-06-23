/*    */ package integrations;
/*    */ 
/*    */ final class RPCHandler
/*    */ {
/*    */   private static final long interval = 15000L;
/*    */   private final Rpcer[] rpcs;
/*  7 */   private long lastUpdate = 0L;
/*    */   
/*    */   RPCHandler(SteamClient steam) {
/* 10 */     if (INTEGRATIONS.steamRunning()) {
/*    */       
/* 12 */       this.rpcs = new Rpcer[] {
/* 13 */           new RPCDiscord(), 
/* 14 */           new SteamRPC(steam)
/*    */         };
/*    */     } else {
/* 17 */       this.rpcs = new Rpcer[] {
/* 18 */           new RPCDiscord() };
/*    */     } 
/*    */   }
/*    */   
/*    */   void dispose() {
/*    */     byte b;
/*    */     int i;
/*    */     Rpcer[] arrayOfRpcer;
/* 26 */     for (i = (arrayOfRpcer = this.rpcs).length, b = 0; b < i; ) { Rpcer rpc = arrayOfRpcer[b];
/* 27 */       rpc.dispose();
/*    */       b++; }
/*    */   
/*    */   }
/*    */   
/*    */   public void update(INTER_RPC rpc) {
/* 33 */     long now = System.currentTimeMillis();
/* 34 */     if (now - this.lastUpdate > 15000L) {
/* 35 */       String state = rpc.rpcTitle();
/* 36 */       String[] ds = rpc.rpcDetails();
/* 37 */       String details = "";
/* 38 */       boolean first = true; byte b; int i; String[] arrayOfString1;
/* 39 */       for (i = (arrayOfString1 = ds).length, b = 0; b < i; ) { String d = arrayOfString1[b];
/* 40 */         if (!first) {
/* 41 */           details = String.valueOf(details) + " | ";
/*    */         } else {
/* 43 */           first = false;
/*    */         } 
/* 45 */         details = String.valueOf(details) + d; b++; }
/*    */       
/*    */       Rpcer[] arrayOfRpcer;
/* 48 */       for (i = (arrayOfRpcer = this.rpcs).length, b = 0; b < i; ) { Rpcer p = arrayOfRpcer[b];
/* 49 */         p.update(state, details); b++; }
/*    */       
/* 51 */       this.lastUpdate = now;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\integrations\RPCHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */