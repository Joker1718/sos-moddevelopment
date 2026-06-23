/*     */ package integrations;
/*     */ 
/*     */ import com.codedisaster.steamworks.SteamException;
/*     */ 
/*     */ class INTEGRATIONS {
/*     */   private static volatile INTEGRATIONS I;
/*     */   private final RPCHandler handler;
/*     */   private final SteamClient steam;
/*     */   private final SteamStats stats;
/*     */   
/*     */   public static void init(boolean log, boolean achieve) {
/*  12 */     if (I != null) {
/*  13 */       throw new RuntimeException("Already inited");
/*     */     }
/*     */     try {
/*     */     
/*  17 */     } catch (Throwable e) {
/*  18 */       e.printStackTrace();
/*  19 */       I = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean logging = false;
/*     */ 
/*     */ 
/*     */   
/*     */   private INTEGRATIONS(boolean logging, boolean achieve) throws SteamException {
/*  31 */     INTEGRATIONS.logging = logging;
/*  32 */     I = this;
/*  33 */     this.steam = SteamClient.init();
/*     */     
/*  35 */     this.handler = new RPCHandler(this.steam);
/*  36 */     if (this.steam != null)
/*  37 */     { if (achieve) {
/*  38 */         this.stats = new SteamStats();
/*     */       } else {
/*  40 */         this.stats = null;
/*     */       }  }
/*  42 */     else { this.stats = null; }
/*     */ 
/*     */     
/*  45 */     log("INTEGRATION INITED");
/*  46 */     log("STEAM: " + steamRunning());
/*  47 */     log("DISCORD: true");
/*     */   }
/*     */ 
/*     */   
/*     */   public static void dispose() {
/*  52 */     if (I != null) {
/*  53 */       I.handler.dispose();
/*     */       
/*  55 */       if (I.steam != null) {
/*  56 */         if (I.stats != null)
/*  57 */           I.stats.dispose(); 
/*  58 */         I.steam.dispose();
/*     */       } 
/*  60 */       I = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void updateRPC(INTER_RPC rpc) {
/*  66 */     if (I != null) {
/*  67 */       I.handler.update(rpc);
/*     */     }
/*     */   }
/*     */   
/*     */   public static boolean steamRunning() {
/*  72 */     return (I != null && I.steam != null && I.steam.running());
/*     */   }
/*     */   
/*     */   public static boolean inited() {
/*  76 */     return (I != null);
/*     */   }
/*     */   
/*     */   static void log(Object object) {
/*  80 */     if (logging) {
/*  81 */       System.out.println("[INTEGRATIONS] " + object);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void achieve(String key, int value) {
/*  86 */     if (I != null && I.stats != null) {
/*  87 */       I.stats.setStat(key, value);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void achieve(String key) {
/*  92 */     if (I != null && I.stats != null) {
/*  93 */       I.stats.setAchieved(key);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reset() {
/*  98 */     if (I != null && I.stats != null)
/*     */     {
/* 100 */       I.stats.Reset(true);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void achieveInc(String key, int value) {
/* 105 */     if (I != null && I.stats != null) {
/* 106 */       I.stats.incStat(key, value);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void achivementsFlush() {
/* 111 */     if (I != null && I.stats != null)
/* 112 */       I.stats.storeStats(); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\integrations\INTEGRATIONS.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */