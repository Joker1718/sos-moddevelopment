/*    */ package integrations;
/*    */ 
/*    */ 
/*    */ public class SteamAchieve
/*    */ {
/*    */   public static final String RPC = "RPC";
/*    */   public static final String ACHIEVE = "ACHIEVE";
/*    */   public static final String ACHIEVE_NOT = "NOT_ACHIEVE";
/*    */   public static final String EXIT = "EXIT";
/*    */   public static final String SEP = "%%";
/*    */   
/*    */   public static void main(String[] achievements) {
/* 13 */     SteamClient steam = SteamClient.init();
/* 14 */     if (steam == null) {
/* 15 */       System.out.println("STEAM ACHIEVEMENTS COULD NOT BE INITED");
/*    */       
/*    */       return;
/*    */     } 
/*    */     
/* 20 */     SteamStats stats = new SteamStats();
/*    */     
/* 22 */     if (achievements.length == 0) {
/* 23 */       stats.Reset(true);
/*    */     } else {
/* 25 */       for (int i = 0; i < achievements.length; i++) {
/* 26 */         stats.setAchieved(achievements[i]);
/*    */       }
/* 28 */       stats.storeStats();
/*    */     } 
/*    */ 
/*    */     
/* 32 */     stats.dispose();
/* 33 */     steam.dispose();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\integrations\SteamAchieve.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */