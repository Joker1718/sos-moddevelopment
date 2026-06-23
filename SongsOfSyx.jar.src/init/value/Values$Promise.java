/*    */ package init.value;
/*    */ 
/*    */ import game.GAME;
/*    */ import snake2d.LOG;
/*    */ import snake2d.util.misc.ACTION;
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
/*    */ class Promise
/*    */   implements ACTION
/*    */ {
/*    */   public final String key;
/*    */   public final String path;
/*    */   
/*    */   Promise(String key, String path) {
/* 61 */     this.key = key;
/* 62 */     this.path = path;
/*    */   }
/*    */ 
/*    */   
/*    */   public void exe() {
/* 67 */     if (Values.this.mommy.get(this.key) == null) {
/* 68 */       if (!Values.this.mommy.hasSpewed) {
/* 69 */         GAME.Warn(this.path + this.path + "no value named : " + System.lineSeparator() + " available: " + this.key + System.lineSeparator());
/*    */       } else {
/* 71 */         LOG.ln("no value: " + this.key + "path: " + this.path);
/*    */       } 
/* 73 */       Values.this.mommy.hasSpewed = true;
/*    */     } else {
/*    */       
/* 76 */       Values.this.all.add(Values.this.mommy.get(this.key));
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\value\Values$Promise.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */