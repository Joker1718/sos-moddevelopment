/*    */ package launcher;
/*    */ 
/*    */ import snake2d.Displays;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends LSettings.LSettingInt
/*    */ {
/*    */   null(LSettings paramLSettings2, String $anonymous0, int $anonymous1, int $anonymous2) {
/* 61 */     super($anonymous0, $anonymous1, $anonymous2);
/*    */   }
/*    */   public int min() {
/* 64 */     return (int)(max() * 768.0D / (Displays.current(LSettings.this.monitor.get())).height);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\launcher\LSettings$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */