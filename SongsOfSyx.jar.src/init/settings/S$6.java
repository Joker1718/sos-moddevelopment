/*     */ package init.settings;
/*     */ 
/*     */ import init.constant.C;
/*     */ import init.paths.PATHS;
/*     */ import snake2d.Displays;
/*     */ import snake2d.LOG;
/*     */ import snake2d.SETTINGS;
/*     */ import snake2d.util.misc.CLAMP;
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
/*     */   public String getWindowName() {
/* 311 */     return "Songs of Syx";
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getVSynchEnabled() {
/* 316 */     return (S.this.settings.vsync.get() == 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean vsyncAdaptive() {
/* 321 */     return (S.this.settings.vsyncadapt.get() == 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getScreenshotFolder() {
/* 326 */     return String.valueOf((PATHS.local()).SCREENSHOT.get()) + String.valueOf((PATHS.local()).SCREENSHOT.get());
/*     */   }
/*     */ 
/*     */   
/*     */   public int getRenderMode() {
/* 331 */     return S.this.settings.shading.get();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getPointSize() {
/* 336 */     return 4;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean mutonfocus() {
/* 341 */     return (S.this.muteUnfocused.get() == 1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getNativeWidth() {
/* 347 */     if (display() == null) {
/* 348 */       LOG.ln(Integer.valueOf(S.this.settings.screenMode.get()));
/* 349 */       LOG.ln(Integer.valueOf(S.this.settings.fullScreenDisplay.get()));
/* 350 */       LOG.ln(Integer.valueOf(S.this.settings.monitor.get()));
/*     */       
/* 352 */       for (int i = 0; i < Displays.monitors(); i++) {
/* 353 */         LOG.ln("M " + i + " " + String.valueOf(Displays.current(i)));
/* 354 */         for (int s = 0; s < Displays.available(i).size(); s++) {
/* 355 */           LOG.ln("- " + s + " " + String.valueOf(Displays.available(i).get(s)));
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 361 */     int w = nWidth();
/* 362 */     int h = nHeight();
/*     */     
/* 364 */     if (h < 768)
/* 365 */       h = 768; 
/* 366 */     if (w < 1280) {
/* 367 */       w = 1280;
/*     */     }
/* 369 */     double a = (w * h);
/* 370 */     double d = Math.pow(2700000.0D / a, 0.5D);
/*     */ 
/*     */ 
/*     */     
/* 374 */     if (a > 2700000.0D) {
/* 375 */       w = (int)(w * d);
/* 376 */       h = (int)(h * d);
/* 377 */       if (h < 768) {
/* 378 */         h = 768;
/* 379 */         w = 2700000 / h;
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 385 */     w &= 0xFFFFFFFE;
/* 386 */     C.init(w, C.HEIGHT());
/* 387 */     return w;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getNativeHeight() {
/* 393 */     int w = nWidth();
/* 394 */     int h = nHeight();
/*     */     
/* 396 */     if (h < 768)
/* 397 */       h = 768; 
/* 398 */     if (w < 1280) {
/* 399 */       w = 1280;
/*     */     }
/* 401 */     double a = (w * h);
/* 402 */     double d = Math.pow(2700000.0D / a, 0.5D);
/*     */     
/* 404 */     if (a > 2700000.0D) {
/* 405 */       w = (int)(w * d);
/* 406 */       h = (int)(h * d);
/* 407 */       if (h < 768) {
/* 408 */         h = 768;
/* 409 */         w = 2700000 / h;
/*     */       } 
/*     */     } 
/* 412 */     h &= 0xFFFFFFFE;
/* 413 */     C.init(C.WIDTH(), h);
/* 414 */     return h;
/*     */   }
/*     */   
/*     */   private int nWidth() {
/* 418 */     if (S.this.settings.screenMode.get() == 2) {
/* 419 */       int w = (int)Math.ceil((Displays.current(monitor())).width * S.this.settings.windowWidth.getD());
/*     */       
/* 421 */       if (S.this.settings.developer.get() == 1 && S.this.settings.forcedHD.get() == 1) {
/* 422 */         w = 1920;
/*     */         
/* 424 */         if (w > (Displays.current(monitor())).width)
/* 425 */           w = (Displays.current(monitor())).width; 
/*     */       } 
/* 427 */       return w;
/*     */     } 
/* 429 */     if (S.this.settings.screenMode.get() == 0) {
/* 430 */       return (int)Math.ceil((Displays.current(monitor())).width / (1.0D + S.this.settings.windowBorderLessScale.getD()));
/*     */     }
/* 432 */     return (display()).width;
/*     */   }
/*     */   
/*     */   private int nHeight() {
/* 436 */     if (S.this.settings.screenMode.get() == 2) {
/*     */       
/* 438 */       int w = (int)Math.ceil((Displays.current(monitor())).height * S.this.settings.windowHeight.getD());
/*     */       
/* 440 */       if (S.this.settings.developer.get() == 1 && S.this.settings.forcedHD.get() == 1) {
/* 441 */         w = 1080;
/*     */         
/* 443 */         if (w > (Displays.current(monitor())).height)
/* 444 */           w = (Displays.current(monitor())).height; 
/*     */       } 
/* 446 */       return w;
/*     */     } 
/* 448 */     if (S.this.settings.screenMode.get() == 0)
/* 449 */       return (int)Math.ceil((Displays.current(monitor())).height / (1.0D + S.this.settings.windowBorderLessScale.getD())); 
/* 450 */     return (display()).height;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getLinearFiltering() {
/* 455 */     return (S.this.settings.linear.get() == 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getIconFolder() {
/* 460 */     return PATHS.PATHS_BASE.ICON_FOLDER;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getFitToScreen() {
/* 465 */     if (S.this.settings.screenMode.get() == 0)
/* 466 */       return true; 
/* 467 */     if (S.this.settings.screenMode.get() == 2)
/* 468 */       return true; 
/* 469 */     if (S.this.settings.windowWidth.getD() == 1.0D && S.this.settings.windowHeight.getD() == 1.0D)
/* 470 */       return true; 
/* 471 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public Displays.DisplayMode display() {
/* 476 */     if (S.this.settings.screenMode.get() == 1) {
/* 477 */       if (S.this.settings.fullScreenDisplay.get() == -1) {
/* 478 */         Displays.DisplayMode d = Displays.current(monitor());
/* 479 */         return new Displays.DisplayMode(d.width, d.height, d.refresh, true);
/*     */       } 
/* 481 */       return (Displays.DisplayMode)Displays.available(monitor()).get(S.this.settings.fullScreenDisplay.get());
/*     */     } 
/*     */     
/* 484 */     if (S.this.settings.screenMode.get() == 0) {
/* 485 */       return Displays.current(monitor());
/*     */     }
/* 487 */     int width = nWidth();
/* 488 */     int height = nHeight();
/*     */     
/* 490 */     return new Displays.DisplayMode(width, height, (Displays.current(monitor())).refresh, false);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean decoratedWindow() {
/* 495 */     return (S.this.settings.decorated.get() == 1 && S.this.settings.screenMode.get() == 2);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean debugMode() {
/* 500 */     return S.this.debug;
/*     */   }
/*     */ 
/*     */   
/*     */   public int monitor() {
/* 505 */     int m = S.this.settings.monitor.get();
/* 506 */     return CLAMP.i(m, 0, Displays.monitors());
/*     */   }
/*     */ 
/*     */   
/*     */   public String openALDevice() {
/* 511 */     return S.this.settings.audiodevice.get();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean autoIconify() {
/* 516 */     return (S.this.settings.winIconi.get() == 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean windowFloating() {
/* 521 */     return (S.this.settings.winFoat.get() == 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean windowFullFull() {
/* 526 */     return (S.this.settings.winFullFull.get() == 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public int FPS() {
/* 531 */     int f = S.this.settings.FPS.get();
/* 532 */     if (f == 0)
/* 533 */       return -1; 
/* 534 */     return f;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\settings\S$6.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */