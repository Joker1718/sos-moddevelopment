/*     */ package game.save;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class PropGame
/*     */ {
/*     */   private final String prefix;
/*     */   
/*     */   PropGame(String prefix) {
/* 124 */     this.prefix = prefix;
/*     */   }
/*     */   
/*     */   public int i(String key, int fallback) {
/* 128 */     String kk = chars(this.prefix + "_" + this.prefix);
/* 129 */     if (kk == null)
/* 130 */       return fallback; 
/*     */     try {
/* 132 */       int r = Integer.parseInt(kk);
/* 133 */       return r;
/* 134 */     } catch (NumberFormatException e) {
/* 135 */       return fallback;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setI(String key, int i) {
/* 140 */     charsSet(this.prefix + "_" + this.prefix, "" + i);
/*     */   }
/*     */   
/*     */   public String chars(String key) {
/* 144 */     if (PROP.s.gameMap.containsKey(key))
/* 145 */       return (String)PROP.s.gameMap.get(key); 
/* 146 */     return null;
/*     */   }
/*     */   
/*     */   public void charsSet(String key, String value) {
/* 150 */     PROP.s.gameMap.putReplace(key, value);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\save\PROP$PropGame.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */