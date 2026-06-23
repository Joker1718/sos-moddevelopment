/*     */ package init.settings;
/*     */ 
/*     */ import game.VERSION;
/*     */ import init.constant.C;
/*     */ import init.paths.PATHS;
/*     */ import launcher.LSettings;
/*     */ import snake2d.CORE;
/*     */ import snake2d.Displays;
/*     */ import snake2d.LOG;
/*     */ import snake2d.SETTINGS;
/*     */ import snake2d.SOUND_CORE;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.ArrayListResize;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.data.DOUBLE;
/*     */ import util.data.INT;
/*     */ import util.info.INFO;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class S
/*     */ {
/*     */   private static S s;
/*     */   
/*     */   public static S get() {
/*  33 */     if (s == null) {
/*  34 */       s = new S();
/*     */     }
/*  36 */     return s;
/*     */   }
/*     */   
/*  39 */   private final ArrayListResize<Setting> all = new ArrayListResize(128, 128);
/*  40 */   private final LSettings settings = new LSettings();
/*     */   
/*     */   public final boolean developer;
/*     */   public final boolean debug;
/*     */   public final Setting shadows;
/*     */   public final Setting particles;
/*     */   public final Setting graphics;
/*     */   public final Setting gore;
/*     */   public final Setting volumeMaster;
/*     */   public final Setting volumeSound;
/*     */   public final Setting volumeMusic;
/*     */   public final Setting volumeAmbience;
/*     */   public final LIST<Setting> audio;
/*     */   public final Setting muteUnfocused;
/*     */   public final Setting brightness;
/*     */   public final Setting autoSaveInterval;
/*     */   public final Setting autoSaveFiles;
/*     */   public final Setting scroll;
/*     */   public final Setting lightCycle;
/*     */   public final Setting uilightCycle;
/*     */   public final Setting downpour;
/*     */   
/*     */   private S() {
/*  63 */     s = this;
/*     */     
/*  65 */     D.gInit(this);
/*     */     
/*  67 */     CharSequence[] samount = { Dic.¤¤off, D.g("some"), D.g("lots") };
/*     */     
/*  69 */     this.developer = (this.settings.developer.get() == 1);
/*  70 */     this.debug = (this.settings.debug.get() == 1);
/*  71 */     this.shadows = get(this.settings.shadows, D.g("Shadow"), 
/*  72 */         D.g("ShadowD", "The amount of shadows in-game. Can decrease performance."), samount);
/*     */     
/*  74 */     this.particles = get(this.settings.particles, D.g("Particles"), 
/*  75 */         D.g("ParticlesD", "The amount of particles in-game. Can decrease performance."), samount);
/*     */     
/*  77 */     this.gore = get(this.settings.gore, D.g("Gore"), D.g("GoreD", "The amount of gore in-game. Can decrease performance."), 
/*  78 */         samount);
/*     */     
/*  80 */     this.volumeMaster = new Audio(SOUND_CORE.AUDIO_GAIN_TYPE.MASTER, (LISTE<Setting>)this.all, this.settings.volumeMaster, D.g("Volume-Master"), D.g("SoundD", "The master sound volume"));
/*  81 */     this.volumeSound = new Audio(SOUND_CORE.AUDIO_GAIN_TYPE.EFFECT, (LISTE<Setting>)this.all, this.settings.volumeSound, D.g("Volume-Effects"), D.g("EffectD", "The sound effects volume"));
/*  82 */     this.volumeAmbience = new Audio(SOUND_CORE.AUDIO_GAIN_TYPE.AMBIENCE, (LISTE<Setting>)this.all, this.settings.volumeAmbience, D.g("Volume-Ambience"), D.g("AmbienceD", "The ambience volume"));
/*  83 */     this.volumeMusic = new Audio(SOUND_CORE.AUDIO_GAIN_TYPE.MUSIC, (LISTE<Setting>)this.all, this.settings.volumeMusic, D.g("Volume-Music"), D.g("MusicD", "The music volume"));
/*  84 */     this.audio = (LIST<Setting>)new ArrayList((Object[])new Setting[] { this.volumeMaster, this.volumeSound, this.volumeAmbience, this.volumeMusic });
/*     */ 
/*     */     
/*  87 */     this.graphics = get(this.settings.detail, D.g("Graphics"), D.g("GraphicsD", "The amount of detail when rendering the map."), 
/*  88 */         new CharSequence[] { Dic.¤¤Low, Dic.¤¤High });
/*     */     
/*  90 */     this.muteUnfocused = new Setting((LISTE)this.all, this.settings.focusMute, D.g("Mute-Un-focused"), 
/*  91 */         D.g("Mute-UnfocusedD", "Will mute the game when game is un-focused"))
/*     */       {
/*     */         public int max() {
/*  94 */           return 1;
/*     */         }
/*     */ 
/*     */         
/*     */         public int min() {
/*  99 */           return 0;
/*     */         }
/*     */ 
/*     */         
/*     */         public void getValue(Str str) {
/* 104 */           str.clear().add((get() == 0) ? Dic.¤¤off : Dic.¤¤on);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void set(int t) {
/* 110 */           super.set(t);
/* 111 */           CORE.getSoundCore().setMuteOnFocus((t == 1));
/*     */         }
/*     */       };
/*     */     
/* 115 */     this.brightness = new SettingPerc((LISTE<Setting>)this.all, this.settings.brightness, D.g("Brightness"), 
/* 116 */         D.g("BrightnessD", "The brightness of the game."));
/*     */     
/* 118 */     this.lightCycle = get(this.settings.lightCycle, D.g("Day-cycle"), D.g("Day-cycleD", "Simulates the day and night cycle visually."), 
/* 119 */         new CharSequence[] { Dic.¤¤off, Dic.¤¤on });
/* 120 */     this.uilightCycle = get(this.settings.uiLightCycle, D.g("UI-Day-cycle"), D.g("UI-Day-cycleD", "Simulates the day and night cycle visually for the UI."), 
/* 121 */         new CharSequence[] { Dic.¤¤off, Dic.¤¤on });
/* 122 */     this.downpour = get(this.settings.downpour, D.g("Weather"), D.g("WeatherD", "Adds visual weather, such as rain and snow to the game."), 
/* 123 */         new CharSequence[] { Dic.¤¤off, Dic.¤¤on });
/*     */     
/* 125 */     final CharSequence min = D.g("{0} min");
/*     */     
/* 127 */     this.autoSaveInterval = new Setting((LISTE)this.all, this.settings.autoSaveInterval, D.g("Auto-Saving"), 
/* 128 */         D.g("Auto-SavingD", "How often the game will auto-save."))
/*     */       {
/*     */         public int max() {
/* 131 */           return 10;
/*     */         }
/*     */ 
/*     */         
/*     */         public void getValue(Str str) {
/* 136 */           if (get() == 0) {
/* 137 */             str.clear().add(Dic.¤¤off);
/*     */           } else {
/* 139 */             str.clear().add(min).insert(0, 1 + 2 * (max() - get()));
/*     */           } 
/*     */         }
/*     */       };
/* 143 */     this.autoSaveFiles = new Setting((LISTE)this.all, this.settings.autoSaveFiles, D.g("Auto-Save-Files"), 
/* 144 */         D.g("Auto-Save-FilesD", "How many auto save files that will be kept."))
/*     */       {
/*     */         public int max() {
/* 147 */           return 10;
/*     */         }
/*     */ 
/*     */         
/*     */         public int min() {
/* 152 */           return 1;
/*     */         }
/*     */ 
/*     */         
/*     */         public void getValue(Str str) {
/* 157 */           str.clear().add(get());
/*     */         }
/*     */       };
/*     */     
/* 161 */     this.scroll = new Setting((LISTE)this.all, this.settings.edgeScroll, D.g("Edge-Scrolling"), 
/* 162 */         D.g("Edge-ScrollingD", "Scroll maps by touching the edges."))
/*     */       {
/*     */         public int max() {
/* 165 */           return 1;
/*     */         }
/*     */ 
/*     */         
/*     */         public int min() {
/* 170 */           return 0;
/*     */         }
/*     */ 
/*     */         
/*     */         public void getValue(Str str) {
/* 175 */           str.clear().add((get() == 0) ? Dic.¤¤off : Dic.¤¤on);
/*     */         }
/*     */       };
/*     */     
/* 179 */     this.all.trim();
/*     */   }
/*     */   
/*     */   public LIST<Setting> all() {
/* 183 */     return (LIST<Setting>)this.all;
/*     */   }
/*     */   
/*     */   public boolean isNewVersion() {
/* 187 */     return (this.settings.version.get() != VERSION.VERSION);
/*     */   }
/*     */ 
/*     */   
/*     */   private Setting get(LSettings.LSettingInt s, CharSequence name, CharSequence desc, final CharSequence[] values) {
/* 192 */     return new Setting((LISTE)this.all, s, name, desc)
/*     */       {
/*     */         public int max()
/*     */         {
/* 196 */           return values.length - 1;
/*     */         }
/*     */ 
/*     */         
/*     */         public void getValue(Str str) {
/* 201 */           str.clear().add(values[get()]);
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   public void print() {
/* 207 */     LOG.ln("SETTINGS");
/* 208 */     for (Setting s : this.all) {
/* 209 */       Str.TMP.clear();
/* 210 */       s.getValue(Str.TMP);
/* 211 */       LOG.ln("   " + s.s.key + ": " + String.valueOf(Str.TMP));
/*     */     } 
/*     */   }
/*     */   
/*     */   public void revert() {
/* 216 */     for (Setting s : this.all) {
/* 217 */       s.s.set(s.s.defaultValue);
/*     */     }
/*     */   }
/*     */   
/*     */   public void applyRuntimeConfigs() {
/* 222 */     for (Setting s : this.audio) {
/* 223 */       Audio a = (Audio)s;
/* 224 */       CORE.getSoundCore().setGain(s.getD(), a.type);
/*     */     } 
/* 226 */     CORE.getSoundCore().setMuteOnFocus((this.muteUnfocused.get() == 1));
/*     */   }
/*     */   
/*     */   public static abstract class Setting
/*     */     extends INFO implements INT.INTE {
/*     */     protected final LSettings.LSettingInt s;
/*     */     
/*     */     Setting(LISTE<Setting> all, LSettings.LSettingInt s, CharSequence name, CharSequence desc) {
/* 234 */       super(name, desc);
/* 235 */       this.s = s;
/* 236 */       all.add(this);
/*     */     }
/*     */ 
/*     */     
/*     */     public int get() {
/* 241 */       return CLAMP.i(this.s.get(), min(), max());
/*     */     }
/*     */ 
/*     */     
/*     */     public int min() {
/* 246 */       return 0;
/*     */     }
/*     */ 
/*     */     
/*     */     public void set(int t) {
/* 251 */       this.s.set(t);
/*     */     }
/*     */     
/*     */     public abstract void getValue(Str param1Str);
/*     */   }
/*     */   
/*     */   private static class SettingPerc
/*     */     extends Setting
/*     */   {
/*     */     SettingPerc(LISTE<S.Setting> all, LSettings.LSettingInt s, CharSequence name, CharSequence desc) {
/* 261 */       super(all, s, name, desc);
/*     */     }
/*     */ 
/*     */     
/*     */     public int min() {
/* 266 */       return 0;
/*     */     }
/*     */ 
/*     */     
/*     */     public int max() {
/* 271 */       return 20;
/*     */     }
/*     */ 
/*     */     
/*     */     public void set(int t) {
/* 276 */       double d = t / 5.0D;
/* 277 */       d = CLAMP.d(d, min(), max());
/* 278 */       this.s.set(this.s.max() * t / max());
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int get() {
/* 284 */       return (int)(this.s.getD() * max());
/*     */     }
/*     */ 
/*     */     
/*     */     public void getValue(Str str) {
/* 289 */       str.clear().add((get() * 5)).add('%');
/*     */     }
/*     */   }
/*     */   
/*     */   private static class Audio
/*     */     extends SettingPerc
/*     */   {
/*     */     public final SOUND_CORE.AUDIO_GAIN_TYPE type;
/*     */     
/*     */     Audio(SOUND_CORE.AUDIO_GAIN_TYPE type, LISTE<S.Setting> all, LSettings.LSettingInt s, CharSequence name, CharSequence desc) {
/* 299 */       super(all, s, name, desc);
/* 300 */       this.type = type;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public SETTINGS make() {
/* 307 */     return new SETTINGS()
/*     */       {
/*     */         public String getWindowName()
/*     */         {
/* 311 */           return "Songs of Syx";
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean getVSynchEnabled() {
/* 316 */           return (S.this.settings.vsync.get() == 1);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean vsyncAdaptive() {
/* 321 */           return (S.this.settings.vsyncadapt.get() == 1);
/*     */         }
/*     */ 
/*     */         
/*     */         public String getScreenshotFolder() {
/* 326 */           return String.valueOf((PATHS.local()).SCREENSHOT.get()) + String.valueOf((PATHS.local()).SCREENSHOT.get());
/*     */         }
/*     */ 
/*     */         
/*     */         public int getRenderMode() {
/* 331 */           return S.this.settings.shading.get();
/*     */         }
/*     */ 
/*     */         
/*     */         public int getPointSize() {
/* 336 */           return 4;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean mutonfocus() {
/* 341 */           return (S.this.muteUnfocused.get() == 1);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public int getNativeWidth() {
/* 347 */           if (display() == null) {
/* 348 */             LOG.ln(Integer.valueOf(S.this.settings.screenMode.get()));
/* 349 */             LOG.ln(Integer.valueOf(S.this.settings.fullScreenDisplay.get()));
/* 350 */             LOG.ln(Integer.valueOf(S.this.settings.monitor.get()));
/*     */             
/* 352 */             for (int i = 0; i < Displays.monitors(); i++) {
/* 353 */               LOG.ln("M " + i + " " + String.valueOf(Displays.current(i)));
/* 354 */               for (int s = 0; s < Displays.available(i).size(); s++) {
/* 355 */                 LOG.ln("- " + s + " " + String.valueOf(Displays.available(i).get(s)));
/*     */               }
/*     */             } 
/*     */           } 
/*     */ 
/*     */           
/* 361 */           int w = nWidth();
/* 362 */           int h = nHeight();
/*     */           
/* 364 */           if (h < 768)
/* 365 */             h = 768; 
/* 366 */           if (w < 1280) {
/* 367 */             w = 1280;
/*     */           }
/* 369 */           double a = (w * h);
/* 370 */           double d = Math.pow(2700000.0D / a, 0.5D);
/*     */ 
/*     */ 
/*     */           
/* 374 */           if (a > 2700000.0D) {
/* 375 */             w = (int)(w * d);
/* 376 */             h = (int)(h * d);
/* 377 */             if (h < 768) {
/* 378 */               h = 768;
/* 379 */               w = 2700000 / h;
/*     */             } 
/*     */           } 
/*     */ 
/*     */ 
/*     */           
/* 385 */           w &= 0xFFFFFFFE;
/* 386 */           C.init(w, C.HEIGHT());
/* 387 */           return w;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public int getNativeHeight() {
/* 393 */           int w = nWidth();
/* 394 */           int h = nHeight();
/*     */           
/* 396 */           if (h < 768)
/* 397 */             h = 768; 
/* 398 */           if (w < 1280) {
/* 399 */             w = 1280;
/*     */           }
/* 401 */           double a = (w * h);
/* 402 */           double d = Math.pow(2700000.0D / a, 0.5D);
/*     */           
/* 404 */           if (a > 2700000.0D) {
/* 405 */             w = (int)(w * d);
/* 406 */             h = (int)(h * d);
/* 407 */             if (h < 768) {
/* 408 */               h = 768;
/* 409 */               w = 2700000 / h;
/*     */             } 
/*     */           } 
/* 412 */           h &= 0xFFFFFFFE;
/* 413 */           C.init(C.WIDTH(), h);
/* 414 */           return h;
/*     */         }
/*     */         
/*     */         private int nWidth() {
/* 418 */           if (S.this.settings.screenMode.get() == 2) {
/* 419 */             int w = (int)Math.ceil((Displays.current(monitor())).width * S.this.settings.windowWidth.getD());
/*     */             
/* 421 */             if (S.this.settings.developer.get() == 1 && S.this.settings.forcedHD.get() == 1) {
/* 422 */               w = 1920;
/*     */               
/* 424 */               if (w > (Displays.current(monitor())).width)
/* 425 */                 w = (Displays.current(monitor())).width; 
/*     */             } 
/* 427 */             return w;
/*     */           } 
/* 429 */           if (S.this.settings.screenMode.get() == 0) {
/* 430 */             return (int)Math.ceil((Displays.current(monitor())).width / (1.0D + S.this.settings.windowBorderLessScale.getD()));
/*     */           }
/* 432 */           return (display()).width;
/*     */         }
/*     */         
/*     */         private int nHeight() {
/* 436 */           if (S.this.settings.screenMode.get() == 2) {
/*     */             
/* 438 */             int w = (int)Math.ceil((Displays.current(monitor())).height * S.this.settings.windowHeight.getD());
/*     */             
/* 440 */             if (S.this.settings.developer.get() == 1 && S.this.settings.forcedHD.get() == 1) {
/* 441 */               w = 1080;
/*     */               
/* 443 */               if (w > (Displays.current(monitor())).height)
/* 444 */                 w = (Displays.current(monitor())).height; 
/*     */             } 
/* 446 */             return w;
/*     */           } 
/* 448 */           if (S.this.settings.screenMode.get() == 0)
/* 449 */             return (int)Math.ceil((Displays.current(monitor())).height / (1.0D + S.this.settings.windowBorderLessScale.getD())); 
/* 450 */           return (display()).height;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean getLinearFiltering() {
/* 455 */           return (S.this.settings.linear.get() == 1);
/*     */         }
/*     */ 
/*     */         
/*     */         public String getIconFolder() {
/* 460 */           return PATHS.PATHS_BASE.ICON_FOLDER;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean getFitToScreen() {
/* 465 */           if (S.this.settings.screenMode.get() == 0)
/* 466 */             return true; 
/* 467 */           if (S.this.settings.screenMode.get() == 2)
/* 468 */             return true; 
/* 469 */           if (S.this.settings.windowWidth.getD() == 1.0D && S.this.settings.windowHeight.getD() == 1.0D)
/* 470 */             return true; 
/* 471 */           return true;
/*     */         }
/*     */ 
/*     */         
/*     */         public Displays.DisplayMode display() {
/* 476 */           if (S.this.settings.screenMode.get() == 1) {
/* 477 */             if (S.this.settings.fullScreenDisplay.get() == -1) {
/* 478 */               Displays.DisplayMode d = Displays.current(monitor());
/* 479 */               return new Displays.DisplayMode(d.width, d.height, d.refresh, true);
/*     */             } 
/* 481 */             return (Displays.DisplayMode)Displays.available(monitor()).get(S.this.settings.fullScreenDisplay.get());
/*     */           } 
/*     */           
/* 484 */           if (S.this.settings.screenMode.get() == 0) {
/* 485 */             return Displays.current(monitor());
/*     */           }
/* 487 */           int width = nWidth();
/* 488 */           int height = nHeight();
/*     */           
/* 490 */           return new Displays.DisplayMode(width, height, (Displays.current(monitor())).refresh, false);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean decoratedWindow() {
/* 495 */           return (S.this.settings.decorated.get() == 1 && S.this.settings.screenMode.get() == 2);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean debugMode() {
/* 500 */           return S.this.debug;
/*     */         }
/*     */ 
/*     */         
/*     */         public int monitor() {
/* 505 */           int m = S.this.settings.monitor.get();
/* 506 */           return CLAMP.i(m, 0, Displays.monitors());
/*     */         }
/*     */ 
/*     */         
/*     */         public String openALDevice() {
/* 511 */           return S.this.settings.audiodevice.get();
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean autoIconify() {
/* 516 */           return (S.this.settings.winIconi.get() == 1);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean windowFloating() {
/* 521 */           return (S.this.settings.winFoat.get() == 1);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean windowFullFull() {
/* 526 */           return (S.this.settings.winFullFull.get() == 1);
/*     */         }
/*     */ 
/*     */         
/*     */         public int FPS() {
/* 531 */           int f = S.this.settings.FPS.get();
/* 532 */           if (f == 0)
/* 533 */             return -1; 
/* 534 */           return f;
/*     */         }
/*     */       };
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\settings\S.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */