/*     */ package menu;
/*     */ 
/*     */ import init.paths.PATHS;
/*     */ import snake2d.Displays;
/*     */ import snake2d.SETTINGS;
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
/*     */ class null
/*     */   implements SETTINGS
/*     */ {
/*     */   public boolean windowFloating() {
/*  75 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean vsyncAdaptive() {
/*  80 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public String openALDevice() {
/*  85 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public int monitor() {
/*  90 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getWindowName() {
/*  95 */     return "promo";
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getVSynchEnabled() {
/* 100 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getScreenshotFolder() {
/* 105 */     return String.valueOf((PATHS.local()).SCREENSHOT.get()) + String.valueOf((PATHS.local()).SCREENSHOT.get());
/*     */   }
/*     */ 
/*     */   
/*     */   public int getRenderMode() {
/* 110 */     return 1;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getPointSize() {
/* 115 */     return 1;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getNativeWidth() {
/* 120 */     return 1920;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getNativeHeight() {
/* 125 */     return 1080;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getLinearFiltering() {
/* 130 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getIconFolder() {
/* 136 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getFitToScreen() {
/* 141 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public Displays.DisplayMode display() {
/* 146 */     return new Displays.DisplayMode(getNativeWidth(), getNativeHeight(), 60, false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean decoratedWindow() {
/* 152 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean debugMode() {
/* 158 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean autoIconify() {
/* 164 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean windowFullFull() {
/* 170 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int FPS() {
/* 175 */     return -1;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\menu\MenuPromo$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */