/*    */ package launcher;
/*    */ 
/*    */ import snake2d.Displays;
/*    */ import snake2d.util.misc.CLAMP;
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
/* 68 */     super($anonymous0, $anonymous1, $anonymous2);
/*    */   }
/*    */ 
/*    */   
/*    */   public int max() {
/* 73 */     double dh = (Displays.current(LSettings.this.monitor.get())).height / 768.0D;
/* 74 */     double dv = (Displays.current(LSettings.this.monitor.get())).width / 1280.0D;
/* 75 */     double d = Math.min(dh, dv);
/* 76 */     d--;
/* 77 */     return (int)CLAMP.d(d / 0.05D, 0.0D, 100.0D);
/*    */   }
/*    */ 
/*    */   
/*    */   public double getD() {
/* 82 */     return get() * 0.05D;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\launcher\LSettings$5.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */