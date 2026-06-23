/*    */ package settlement.path;
/*    */ 
/*    */ import util.updating.TileUpdater;
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
/*    */ class null
/*    */   extends TileUpdater
/*    */ {
/*    */   null(int $anonymous0, int $anonymous1, double $anonymous2) {
/* 36 */     super($anonymous0, $anonymous1, $anonymous2);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void update(int tx, int ty, int i, double timeSinceLast) {
/* 41 */     if (PlayerHuristics.this.counts[i] != 0)
/* 42 */       PlayerHuristics.this.counts[i] = (byte)((PlayerHuristics.this.counts[i] & 0xFF) / 16); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\PlayerHuristics$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */