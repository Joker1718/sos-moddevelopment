/*     */ package integrations;
/*     */ 
/*     */ import com.codedisaster.steamworks.SteamID;
/*     */ import com.codedisaster.steamworks.SteamLeaderboardEntriesHandle;
/*     */ import com.codedisaster.steamworks.SteamLeaderboardHandle;
/*     */ import com.codedisaster.steamworks.SteamResult;
/*     */ import com.codedisaster.steamworks.SteamUserStats;
/*     */ import com.codedisaster.steamworks.SteamUserStatsCallback;
/*     */ 
/*     */ final class SteamStats {
/*     */   private SteamUserStats stats;
/*     */   
/*  13 */   private SteamUserStatsCallback userStatsCallback = new SteamUserStatsCallback()
/*     */     {
/*     */       public void onUserStatsReceived(long gameId, SteamID steamIDUser, SteamResult result)
/*     */       {
/*  17 */         INTEGRATIONS.log("UserStats received!");
/*  18 */         INTEGRATIONS.log("GameID: " + gameId);
/*  19 */         INTEGRATIONS.log("UserID: " + steamIDUser);
/*  20 */         INTEGRATIONS.log("Result: " + result);
/*  21 */         SteamStats.this.statResult = result;
/*  22 */         SteamStats.this.numAchievements = SteamStats.this.stats.getNumAchievements();
/*  23 */         SteamStats.this.isInit = true;
/*     */       }
/*     */ 
/*     */       
/*     */       public void onUserStatsStored(long gameId, SteamResult result) {
/*  28 */         INTEGRATIONS.log("UserStats stored!");
/*  29 */         INTEGRATIONS.log("Result: " + result);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public void onUserStatsUnloaded(SteamID steamIDUser) {}
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public void onUserAchievementStored(long gameId, boolean isGroupAchievement, String achievementName, int curProgress, int maxProgress) {}
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public void onLeaderboardFindResult(SteamLeaderboardHandle leaderboard, boolean found) {}
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public void onLeaderboardScoresDownloaded(SteamLeaderboardHandle leaderboard, SteamLeaderboardEntriesHandle entries, int numEntries) {}
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public void onLeaderboardScoreUploaded(boolean success, SteamLeaderboardHandle leaderboard, int score, boolean scoreChanged, int globalRankNew, int globalRankPrevious) {}
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public void onGlobalStatsReceived(long gameId, SteamResult result) {}
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public void onNumberOfCurrentPlayersReceived(boolean arg0, int arg1) {}
/*     */     };
/*     */ 
/*     */ 
/*     */   
/*     */   private SteamResult statResult;
/*     */ 
/*     */   
/*     */   private volatile boolean isInit = false;
/*     */ 
/*     */   
/*     */   private int numAchievements;
/*     */ 
/*     */ 
/*     */   
/*     */   public SteamStats() {
/*  81 */     init();
/*     */   }
/*     */ 
/*     */   
/*     */   private void init() {
/*  86 */     INTEGRATIONS.log("Register Userstats ...");
/*  87 */     this.stats = new SteamUserStats(this.userStatsCallback);
/*  88 */     this.stats.requestCurrentStats();
/*  89 */     for (int i = 0; i < 5000; i++) {
/*  90 */       if (this.isInit)
/*     */         return; 
/*     */       try {
/*  93 */         Thread.sleep(1L);
/*  94 */       } catch (InterruptedException e) {
/*     */         
/*  96 */         e.printStackTrace();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void listAchievements() {
/* 103 */     INTEGRATIONS.log("Songs of Syx has " + this.numAchievements + " Achievements:");
/* 104 */     for (int i = 0; i < this.numAchievements; i++)
/* 105 */       INTEGRATIONS.log("Achievement " + i + ": " + this.stats.getAchievementName(i)); 
/*     */   }
/*     */   
/*     */   public void getStat(String name) {
/* 109 */     if (this.isInit) {
/* 110 */       for (int i = 0; i < 34; i++)
/* 111 */         INTEGRATIONS.log("Achievement Name: " + this.stats.getAchievementName(i)); 
/* 112 */       int value = 100;
/* 113 */       value = this.stats.getStatI(name, value);
/* 114 */       INTEGRATIONS.log("Stat " + name + " has the value of " + value);
/*     */     } else {
/* 116 */       INTEGRATIONS.log("SteamStats not properly initialized");
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean incStat(String name, int value) {
/* 121 */     if (this.isInit) {
/* 122 */       int oldValue = this.stats.getStatI(name, value);
/* 123 */       int newValue = oldValue + value;
/* 124 */       INTEGRATIONS.log("Increasing " + name + " by " + value + " to " + newValue);
/* 125 */       return this.stats.setStatI(name, oldValue + value);
/*     */     } 
/* 127 */     INTEGRATIONS.log("SteamStats not properly initialized");
/* 128 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean setStat(String name, int value) {
/* 133 */     if (this.isInit) {
/* 134 */       return this.stats.setStatI(name, value);
/*     */     }
/* 136 */     INTEGRATIONS.log("SteamStats not properly initialized");
/* 137 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setMaxStat(String name, int value) {
/* 143 */     if (this.isInit) {
/* 144 */       int oldValue = this.stats.getStatI(name, value);
/* 145 */       if (value > oldValue) {
/* 146 */         return this.stats.setStatI(name, value);
/*     */       }
/* 148 */       INTEGRATIONS.log("Trying to set a new highscore (" + value + ") for " + name + " but the old one is higher (" + oldValue + ")");
/* 149 */       return false;
/*     */     } 
/*     */     
/* 152 */     INTEGRATIONS.log("SteamStats not properly initialized");
/* 153 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getAchieved(String name) {
/* 158 */     boolean isAchieved = false;
/* 159 */     if (this.isInit) {
/* 160 */       isAchieved = this.stats.isAchieved(name, isAchieved);
/* 161 */       INTEGRATIONS.log("Achievement " + name + " achieved?  " + isAchieved);
/* 162 */       return isAchieved;
/*     */     } 
/* 164 */     INTEGRATIONS.log("SteamStats not properly initialized");
/* 165 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean indicateProgress(String name) {
/* 171 */     int curProgress = 0;
/* 172 */     int maxProgress = 0;
/* 173 */     boolean result = this.stats.indicateAchievementProgress(name, curProgress, maxProgress);
/* 174 */     INTEGRATIONS.log("Indicating progress for " + name + " (" + curProgress + "/" + maxProgress + ")");
/* 175 */     return result;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setAchieved(String name) {
/* 180 */     boolean isAchieved = false;
/* 181 */     if (this.isInit)
/* 182 */     { isAchieved = this.stats.isAchieved(name, isAchieved);
/* 183 */       if (!isAchieved) {
/* 184 */         this.stats.setAchievement(name);
/* 185 */         this.stats.storeStats();
/* 186 */         INTEGRATIONS.log("Unlocking Achievement " + name);
/*     */       } else {
/* 188 */         INTEGRATIONS.log("Trying to unlock Achievement " + name + " but it is already unlocked");
/*     */       }  }
/* 190 */     else { INTEGRATIONS.log("SteamStats not properly initialized"); }
/*     */   
/*     */   }
/*     */   
/*     */   public void storeStats() {
/* 195 */     INTEGRATIONS.log("Storing UserStats...");
/* 196 */     this.stats.storeStats();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void Reset(boolean achievementsToo) {
/* 202 */     this.stats.resetAllStats(achievementsToo);
/*     */   }
/*     */   
/*     */   public void dispose() {
/* 206 */     this.stats.dispose();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\integrations\SteamStats.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */