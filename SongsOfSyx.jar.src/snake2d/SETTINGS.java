/*    */ package snake2d;
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
/*    */ public interface SETTINGS
/*    */ {
/*    */   boolean getVSynchEnabled();
/*    */   
/*    */   int getNativeWidth();
/*    */   
/*    */   int getNativeHeight();
/*    */   
/*    */   boolean getFitToScreen();
/*    */   
/*    */   int getPointSize();
/*    */   
/*    */   boolean getLinearFiltering();
/*    */   
/*    */   int getRenderMode();
/*    */   
/*    */   String getWindowName();
/*    */   
/*    */   String getIconFolder();
/*    */   
/*    */   String getScreenshotFolder();
/*    */   
/*    */   default boolean mutonfocus() {
/* 62 */     return true;
/*    */   }
/*    */   
/*    */   boolean decoratedWindow();
/*    */   
/*    */   int monitor();
/*    */   
/*    */   Displays.DisplayMode display();
/*    */   
/*    */   boolean debugMode();
/*    */   
/*    */   String openALDevice();
/*    */   
/*    */   boolean vsyncAdaptive();
/*    */   
/*    */   boolean windowFloating();
/*    */   
/*    */   boolean autoIconify();
/*    */   
/*    */   boolean windowFullFull();
/*    */   
/*    */   int FPS();
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2d\SETTINGS.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */