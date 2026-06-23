/*    */ package integrations;
/*    */ 
/*    */ import com.codedisaster.steamworks.SteamAPI;
/*    */ import com.codedisaster.steamworks.SteamException;
/*    */ import com.codedisaster.steamworks.SteamUtils;
/*    */ import com.codedisaster.steamworks.SteamUtilsCallback;
/*    */ 
/*    */ final class SteamClient {
/*    */   private static final long interval = 5000L;
/*    */   
/* 11 */   private SteamUtilsCallback clUtilsCallback = new SteamUtilsCallback()
/*    */     {
/*    */       public void onSteamShutdown() {}
/*    */     };
/*    */   
/*    */   private SteamUtils clientUtils;
/*    */   private final Thread Callbacker;
/*    */   private volatile boolean die = false;
/*    */   
/*    */   private SteamClient() {
/* 21 */     this.clientUtils = new SteamUtils(this.clUtilsCallback);
/*    */ 
/*    */     
/* 24 */     this.Callbacker = new Thread(new Runnable() {
/* 25 */           long last = 0L;
/* 26 */           Thread t = Thread.currentThread();
/*    */ 
/*    */           
/*    */           public void run() {
/* 30 */             while (!SteamClient.this.die && this.t.isAlive() && SteamAPI.isSteamRunning()) {
/* 31 */               long now = System.currentTimeMillis();
/*    */               
/* 33 */               if (now - this.last > 5000L) {
/* 34 */                 SteamAPI.runCallbacks();
/* 35 */                 this.last = now;
/*    */               } 
/*    */               try {
/* 38 */                 Thread.sleep(1000L);
/* 39 */               } catch (InterruptedException interruptedException) {}
/*    */             } 
/*    */           }
/*    */         });
/*    */ 
/*    */ 
/*    */     
/* 46 */     this.Callbacker.setName("steam callback");
/* 47 */     this.Callbacker.start();
/*    */   }
/*    */   
/*    */   void dispose() {
/* 51 */     this.die = true;
/* 52 */     this.Callbacker.interrupt();
/*    */     try {
/* 54 */       this.Callbacker.join(5000L);
/* 55 */     } catch (InterruptedException interruptedException) {}
/*    */ 
/*    */     
/* 58 */     this.clientUtils.dispose();
/* 59 */     SteamAPI.shutdown();
/*    */   }
/*    */   
/*    */   static SteamClient init() {
/*    */     try {
/* 64 */       SteamAPI.loadLibraries();
/*    */       
/* 66 */       if (SteamAPI.init() && SteamAPI.isSteamRunning()) {
/* 67 */         return new SteamClient();
/*    */       }
/* 69 */     } catch (SteamException e) {
/* 70 */       e.printStackTrace();
/*    */     } 
/* 72 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean running() {
/* 78 */     return SteamAPI.isSteamRunning();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\integrations\SteamClient.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */