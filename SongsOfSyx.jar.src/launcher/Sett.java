/*     */ package launcher;
/*     */ 
/*     */ import init.paths.PATHS;
/*     */ import snake2d.Displays;
/*     */ import snake2d.SETTINGS;
/*     */ 
/*     */ 
/*     */ 
/*     */ class Sett
/*     */   implements SETTINGS
/*     */ {
/*     */   public static final int WIDTH = 896;
/*     */   public static final int HEIGHT = 448;
/*     */   public static final int SCALE = 4;
/*  15 */   private final Displays.DisplayMode display = new Displays.DisplayMode(896, 448, 60, false);
/*     */ 
/*     */   
/*     */   public int getNativeWidth() {
/*  19 */     return 896;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getNativeHeight() {
/*  24 */     return 448;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getRenderMode() {
/*  29 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getWindowName() {
/*  34 */     return "SOS Launcher";
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getVSynchEnabled() {
/*  39 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getPointSize() {
/*  44 */     return 4;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getLinearFiltering() {
/*  49 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getIconFolder() {
/*  54 */     return PATHS.PATHS_BASE.ICON_FOLDER;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getFitToScreen() {
/*  59 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean decoratedWindow() {
/*  64 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public Displays.DisplayMode display() {
/*  69 */     return this.display;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean debugMode() {
/*  74 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getScreenshotFolder() {
/*  80 */     return String.valueOf((PATHS.local()).SCREENSHOT.get());
/*     */   }
/*     */ 
/*     */   
/*     */   public int monitor() {
/*  85 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public String openALDevice() {
/*  90 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean autoIconify() {
/*  96 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean windowFloating() {
/* 102 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean vsyncAdaptive() {
/* 107 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean windowFullFull() {
/* 113 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int FPS() {
/* 118 */     return -1;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\launcher\Sett.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */