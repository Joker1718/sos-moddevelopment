/*    */ package launcher;
/*    */ 
/*    */ import snake2d.Displays;
/*    */ import snake2d.util.sets.LIST;
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
/* 44 */     super($anonymous0, $anonymous1, $anonymous2);
/*    */   }
/*    */   
/*    */   public int max() {
/* 48 */     LIST<Displays.DisplayMode> dis = Displays.available(LSettings.this.monitor.get());
/* 49 */     if (dis == null || dis.size() == 0)
/* 50 */       return 0; 
/* 51 */     return dis.size() - 1;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\launcher\LSettings$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */