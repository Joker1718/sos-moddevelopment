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
/*    */ class null
/*    */   extends LSettings.LSettingInt
/*    */ {
/*    */   null(LSettings paramLSettings2, String $anonymous0, int $anonymous1, int $anonymous2) {
/* 55 */     super($anonymous0, $anonymous1, $anonymous2);
/*    */   }
/*    */   public int min() {
/* 58 */     return (int)(max() * 1280.0D / (Displays.current(LSettings.this.monitor.get())).width);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\launcher\LSettings$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */