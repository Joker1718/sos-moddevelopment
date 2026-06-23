/*     */ package launcher;
/*     */ 
/*     */ import snake2d.Displays;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.SoundDevices;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import snake2d.util.sprite.text.Text;
/*     */ import util.text.D;
/*     */ 
/*     */ class ScreenSetting
/*     */   extends GuiSection {
/*     */   private final Launcher l;
/*     */   private final GuiSection fullScreen;
/*     */   private final GuiSection windowed;
/*     */   private final GuiSection borderless;
/*     */   
/*     */   ScreenSetting(final Launcher l) {
/*  28 */     D.gInit(this);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  33 */     this.fullScreen = new GuiSection()
/*     */       {
/*     */         public void render(SPRITE_RENDERER r, float ds) {
/*  36 */           visableSet((ScreenSetting.this.l.s.screenMode.get() == 1));
/*  37 */           if (visableIs())
/*  38 */             super.render(r, ds); 
/*     */         }
/*     */       };
/*  41 */     this.windowed = new GuiSection()
/*     */       {
/*     */         public void render(SPRITE_RENDERER r, float ds)
/*     */         {
/*  45 */           visableSet((ScreenSetting.this.l.s.screenMode.get() == 2));
/*  46 */           if (visableIs())
/*  47 */             super.render(r, ds); 
/*     */         }
/*     */       };
/*  50 */     this.borderless = new GuiSection()
/*     */       {
/*     */         public void render(SPRITE_RENDERER r, float ds)
/*     */         {
/*  54 */           visableSet((ScreenSetting.this.l.s.screenMode.get() == 0));
/*  55 */           if (visableIs()) {
/*  56 */             super.render(r, ds);
/*     */           }
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  65 */     this.hoverInfo = new Str(200);
/*     */ 
/*     */ 
/*     */     
/*  69 */     this.l = l;
/*  70 */     int x1 = 40;
/*     */     
/*  72 */     CharSequence sback = D.g("Back");
/*     */ 
/*     */ 
/*     */     
/*  76 */     GuiSection guiSection1 = new GuiSection();
/*  77 */     int i = 0;
/*  78 */     int cols = 5;
/*  79 */     int wi = 170;
/*  80 */     int hi = 52;
/*     */     
/*  82 */     CheckBox checkBox2 = new CheckBox(l.s.debug, D.g("Debug"), D.g("debugD", "Starts the game in debug mode and will print extra information and diagnostics when enabled at the cost of performance. Helpful when modding."));
/*  83 */     guiSection1.addGridD((RENDEROBJ)checkBox2, i++, cols, wi, hi, DIR.NW);
/*     */     
/*  85 */     checkBox2 = new CheckBox(l.s.developer, D.g("Developer"), D.g("DeveloperD", "Enables powerful tools in game that can be used to test things, or cheat."));
/*  86 */     guiSection1.addGridD((RENDEROBJ)checkBox2, i++, cols, wi, hi, DIR.NW);
/*     */ 
/*     */     
/*  89 */     checkBox2 = new CheckBox(l.s.linear, D.g("Linear"), D.g("LinearD", "Enables linear filtering when the game is scaled."));
/*  90 */     guiSection1.addGridD((RENDEROBJ)checkBox2, i++, cols, wi, hi, DIR.NW);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  97 */     checkBox2 = new CheckBox(l.s.shading, D.g("Shading"), D.g("ShadingD", "Use normal maps and dynamic lightening"));
/*  98 */     guiSection1.addGridD((RENDEROBJ)checkBox2, i++, cols, wi, hi, DIR.NW);
/*     */     
/* 100 */     checkBox2 = new CheckBox(l.s.vsync, D.g("VSync"), D.g("VSyncD", "Enables vsync to reduce screen tearing. Can cause conflicts with NVidia GSync in which case it's recommended to turn that off."));
/* 101 */     guiSection1.addGridD((RENDEROBJ)checkBox2, i++, cols, wi, hi, DIR.NW);
/*     */     
/* 103 */     checkBox2 = new CheckBox(l.s.vsyncadapt, D.g("VSync-Adapt"), D.g("VSyncAD", "Enables vsync that adapts to the current refresh rate. Only supported on some GPUs"));
/* 104 */     guiSection1.addGridD((RENDEROBJ)checkBox2, i++, cols, wi, hi, DIR.NW);
/*     */     
/* 106 */     checkBox2 = new CheckBox(l.s.winIconi, D.g("Iconify"), D.g("IconifyD", "If full screen is selected, allow the window to iconify if it loses focus. When using multiple monitors, this should be turned off."));
/* 107 */     guiSection1.addGridD((RENDEROBJ)checkBox2, i++, cols, wi, hi, DIR.NW);
/*     */     
/* 109 */     checkBox2 = new CheckBox(l.s.winFullFull, D.g("W-Fix"), D.g("MFixD", "A possible fix for borderless window and tabbing out if you have multiple monitors."));
/* 110 */     guiSection1.addGridD((RENDEROBJ)checkBox2, i++, cols, wi, hi, DIR.NW);
/*     */     
/* 112 */     checkBox2 = new CheckBox(l.s.winFoat, D.g("W-Float"), D.g("WFloatD", "Determines how the window floats on top of other applications. Might work different on different configurations."));
/* 113 */     guiSection1.addGridD((RENDEROBJ)checkBox2, i++, cols, wi, hi, DIR.NW);
/*     */     
/* 115 */     checkBox2 = new CheckBox(l.s.easy, D.g("UI-Easy"), D.g("UI-EasyD", "Only works with the default english language. Replaces the fonts with open sans, and tweaks UI colors to make things more clear."));
/* 116 */     guiSection1.addGridD((RENDEROBJ)checkBox2, i++, cols, wi, hi, DIR.NW);
/*     */     
/* 118 */     final CharSequence none = D.g("none");
/* 119 */     final CharSequence def = D.g("default");
/*     */     
/* 121 */     SPRITE.Imp imp2 = new SPRITE.Imp(250, l.res.font.height() + 12)
/*     */       {
/*     */         Text t;
/*     */         
/*     */         CharSequence a;
/*     */ 
/*     */         
/*     */         public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 129 */           this.t.clear().add(this.a).add(':').s();
/* 130 */           this.t.add(get());
/* 131 */           this.t.setMaxWidth(250);
/* 132 */           this.t.setMultipleLines(false);
/* 133 */           this.t.adjustWidth();
/* 134 */           this.t.renderC(r, X1 + (X2 - X1) / 2, Y1 + (Y2 - Y1) / 2);
/*     */         }
/*     */         
/*     */         private CharSequence get() {
/* 138 */           String a = l.s.audiodevice.get();
/* 139 */           if (a == null)
/* 140 */             return none; 
/* 141 */           if (a.isEmpty()) {
/* 142 */             return def;
/*     */           }
/* 144 */           for (String s : SoundDevices.get()) {
/* 145 */             if (s.equalsIgnoreCase(a)) {
/* 146 */               return s;
/*     */             }
/*     */           } 
/*     */           
/* 150 */           if (SoundDevices.get().size() > 0) {
/* 151 */             return (CharSequence)SoundDevices.get().get(0);
/*     */           }
/* 153 */           return none;
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 160 */     GUI.Button button2 = new GUI.Button((SPRITE)imp2)
/*     */       {
/*     */         protected void clickA()
/*     */         {
/* 164 */           GuiSection mFullScreens = new GuiSection();
/* 165 */           final GUI.ScrollBox content = new GUI.ScrollBox(348);
/*     */           
/* 167 */           CLICKABLE up = (new GUI.BSprite(l.res.arrowUpDown[0])).clickActionSet(new ACTION()
/*     */               {
/*     */                 public void exe() {
/* 170 */                   content.scrollUp();
/*     */                 }
/*     */               });
/* 173 */           mFullScreens.add((RENDEROBJ)up);
/*     */ 
/*     */           
/* 176 */           CLICKABLE down = (new GUI.BSprite(l.res.arrowUpDown[1])).clickActionSet(new ACTION()
/*     */               {
/*     */                 public void exe() {
/* 179 */                   content.scrollDown();
/*     */                 }
/*     */               });
/* 182 */           down.body().moveY2(328.0D);
/*     */           
/* 184 */           mFullScreens.add((RENDEROBJ)down);
/* 185 */           content.addNavButts(up, down);
/* 186 */           content.body().moveX1Y1(30.0D, 0.0D);
/*     */           
/* 188 */           content.add((HOVERABLE)(new GUI.BText(l.res, none)).clickActionSet(new ACTION()
/*     */                 {
/*     */                   public void exe() {
/* 191 */                     l.s.audiodevice.set((String)null);
/* 192 */                     (ScreenSetting.null.access$0(ScreenSetting.null.this)).message = null;
/*     */                   }
/*     */                 }));
/*     */           
/* 196 */           content.add((HOVERABLE)(new GUI.BText(l.res, def)).clickActionSet(new ACTION()
/*     */                 {
/*     */                   public void exe() {
/* 199 */                     l.s.audiodevice.set("");
/* 200 */                     (ScreenSetting.null.access$0(ScreenSetting.null.this)).message = null;
/*     */                   }
/*     */                 }));
/*     */           
/* 204 */           for (String s : SoundDevices.get()) {
/* 205 */             content.add((HOVERABLE)(new GUI.BText(l.res, s)).clickActionSet(new ACTION()
/*     */                   {
/*     */                     public void exe() {
/* 208 */                       l.s.audiodevice.set(s);
/* 209 */                       (ScreenSetting.null.access$0(ScreenSetting.null.this)).message = null;
/*     */                     }
/*     */                   }));
/*     */           } 
/*     */           
/* 214 */           mFullScreens.add((RENDEROBJ)content);
/*     */           
/* 216 */           GUI.BText bText = new GUI.BText(l.res, D.g("Back"))
/*     */             {
/*     */               protected void clickA() {
/* 219 */                 (ScreenSetting.null.access$0(ScreenSetting.null.this)).message = null;
/*     */               }
/*     */             };
/*     */ 
/*     */           
/* 224 */           bText.body().moveX1(80.0D);
/* 225 */           bText.body().moveY1((mFullScreens.getLastY2() + 10));
/* 226 */           mFullScreens.add((RENDEROBJ)bText);
/* 227 */           mFullScreens.body().centerX(0.0D, 896.0D);
/* 228 */           mFullScreens.body().centerY(0.0D, 448.0D);
/*     */           
/* 230 */           ScreenSetting.this.message = mFullScreens;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean hover(COORDINATE mCoo) {
/* 235 */           if (super.hover(mCoo) && this.hoverInfo != null) {
/* 236 */             ScreenSetting.this.hoverInfo.add(this.hoverInfo);
/* 237 */             return true;
/*     */           } 
/* 239 */           return false;
/*     */         }
/*     */       };
/* 242 */     button2.hoverInfoSet(D.g("audioD", "What audio device to use. If empty, the game can not find a device with openal support. Try fiddling with headphones and jacks if you have a problem."));
/*     */     
/* 244 */     guiSection1.addGridD((RENDEROBJ)button2, i++, cols, wi, hi, DIR.NW);
/* 245 */     i++;
/*     */ 
/*     */     
/* 248 */     final CharSequence screen = D.g("screen");
/*     */     
/* 250 */     imp2 = new SPRITE.Imp(250, l.res.font.height() + 12)
/*     */       {
/*     */         Text t;
/*     */         
/*     */         CharSequence a;
/*     */ 
/*     */         
/*     */         public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 258 */           this.t.clear().add(this.a).add(':').s();
/* 259 */           this.t.add(get());
/* 260 */           this.t.setMaxWidth(250);
/* 261 */           this.t.setMultipleLines(false);
/* 262 */           this.t.adjustWidth();
/* 263 */           this.t.renderC(r, X1 + (X2 - X1) / 2, Y1 + (Y2 - Y1) / 2);
/*     */         }
/*     */         
/*     */         private CharSequence get() {
/* 267 */           int fps = l.s.FPS.get();
/* 268 */           if (fps == 0)
/* 269 */             return screen; 
/* 270 */           return (CharSequence)Str.TMP.clear().add(fps);
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/* 276 */     button2 = new GUI.Button((SPRITE)imp2)
/*     */       {
/*     */         
/*     */         protected void clickA()
/*     */         {
/* 281 */           int fps = l.s.FPS.get();
/* 282 */           if (fps == 0) {
/* 283 */             fps = 40;
/*     */           } else {
/* 285 */             fps += 20;
/* 286 */             if (fps > l.s.FPS.max())
/* 287 */               fps = 0; 
/*     */           } 
/* 289 */           l.s.FPS.set(fps);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean hover(COORDINATE mCoo) {
/* 294 */           if (super.hover(mCoo) && this.hoverInfo != null) {
/* 295 */             ScreenSetting.this.hoverInfo.add(this.hoverInfo);
/* 296 */             return true;
/*     */           } 
/* 298 */           return false;
/*     */         }
/*     */       };
/* 301 */     button2.hoverInfoSet(D.g("fpsD", "Sets a manual FPS cap on the game. Might interfere with Vsync."));
/*     */     
/* 303 */     guiSection1.addGridD((RENDEROBJ)button2, i++, cols, wi, hi, DIR.NW);
/* 304 */     i++;
/*     */ 
/*     */     
/* 307 */     add((RENDEROBJ)guiSection1, 0, 0);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 315 */     guiSection1 = new GuiSection();
/*     */ 
/*     */     
/* 318 */     Multi multi3 = new Multi(this, l.s.screenMode, D.g("Screen"), D.g("ScreedD", "The type of display to be created for the game."), 200) {
/* 319 */         int i = -1;
/*     */ 
/*     */         
/*     */         public void render(SPRITE_RENDERER r, float ds) {
/* 323 */           if (this.i != l.s.monitor.get()) {
/* 324 */             this.i = l.s.monitor.get();
/* 325 */             ScreenSetting.this.settResolutions();
/*     */           } 
/* 327 */           super.render(r, ds);
/*     */         }
/*     */         
/* 330 */         private CharSequence[] vs = new CharSequence[] {
/* 331 */             D.g("Borderless"), 
/* 332 */             D.g("Full"), 
/* 333 */             D.g("Windowed")
/*     */           };
/*     */ 
/*     */         
/*     */         public void setValue(Text v, LSettings.LSettingInt s) {
/* 338 */           v.add(this.vs[s.get()]);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 343 */     guiSection1.add((RENDEROBJ)multi3);
/*     */     
/* 345 */     multi3 = new Multi(this, l.s.monitor, D.g("Monitor"), D.g("MonitorD", "Which monitor to start the game in.")) {
/* 346 */         int i = -1;
/*     */ 
/*     */         
/*     */         public void render(SPRITE_RENDERER r, float ds) {
/* 350 */           if (this.i != l.s.monitor.get()) {
/* 351 */             this.i = l.s.monitor.get();
/* 352 */             ScreenSetting.this.settResolutions();
/*     */           } 
/* 354 */           super.render(r, ds);
/*     */         }
/*     */       };
/*     */     
/* 358 */     guiSection1.addRightC(16, (RENDEROBJ)multi3);
/*     */     
/* 360 */     guiSection1.addRelBody(8, DIR.S, (SPRITE)new SPRITE.Imp(800, 2)
/*     */         {
/*     */           public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */           {
/* 364 */             COLOR.WHITE65.render(r, 40, X2, Y1, Y2);
/*     */           }
/*     */         });
/*     */     
/* 368 */     addRelBody(8, DIR.S, (RENDEROBJ)guiSection1);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 373 */     SPRITE.Imp imp1 = new SPRITE.Imp(400, l.res.font.height() + 12)
/*     */       {
/*     */         Text t;
/*     */         
/*     */         CharSequence a;
/*     */         
/*     */         public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 380 */           this.t.clear().add(this.a).add(':').s();
/*     */           
/* 382 */           Displays.DisplayMode d = (Displays.DisplayMode)Displays.available(l.s.monitor.get()).get(l.s.fullScreenDisplay.get());
/* 383 */           this.t.add(d.width).add(' ').add('x').add(' ').add(d.height).add(' ').add('@').add(d.refresh).add('H').add('z');
/* 384 */           this.t.adjustWidth();
/* 385 */           this.t.renderC(r, X1 + (X2 - X1) / 2, Y1 + (Y2 - Y1) / 2);
/*     */         }
/*     */       };
/*     */     
/* 389 */     GUI.Button button1 = new GUI.Button((SPRITE)imp1)
/*     */       {
/*     */         protected void clickA()
/*     */         {
/* 393 */           ScreenSetting.this.message = ScreenSetting.this.mFullScreens;
/*     */         }
/*     */       };
/* 396 */     button1.hoverInfoSet(D.g("ResolutionD", "What resolution to use in full screen mode"));
/*     */ 
/*     */     
/* 399 */     this.fullScreen.addRightC(32, (RENDEROBJ)button1);
/*     */ 
/*     */     
/* 402 */     this.fullScreen.body().moveY1((getLastY2() + 16));
/* 403 */     this.fullScreen.body().moveX1(40.0D);
/*     */     
/* 405 */     add((RENDEROBJ)this.fullScreen);
/*     */     
/* 407 */     this.mFullScreens = new GuiSection();
/* 408 */     this.content = new GUI.ScrollBox(348);
/*     */     
/* 410 */     CLICKABLE up = (new GUI.BSprite(l.res.arrowUpDown[0])).clickActionSet(new ACTION()
/*     */         {
/*     */           public void exe() {
/* 413 */             ScreenSetting.this.content.scrollUp();
/*     */           }
/*     */         });
/* 416 */     this.mFullScreens.add((RENDEROBJ)up);
/*     */ 
/*     */     
/* 419 */     CLICKABLE down = (new GUI.BSprite(l.res.arrowUpDown[1])).clickActionSet(new ACTION()
/*     */         {
/*     */           public void exe() {
/* 422 */             ScreenSetting.this.content.scrollDown();
/*     */           }
/*     */         });
/* 425 */     down.body().moveY2(328.0D);
/*     */     
/* 427 */     this.mFullScreens.add((RENDEROBJ)down);
/* 428 */     this.content.addNavButts(up, down);
/* 429 */     this.content.body().moveX1Y1(30.0D, 0.0D);
/* 430 */     this.mFullScreens.add((RENDEROBJ)this.content);
/*     */     
/* 432 */     GUI.BText bText = new GUI.BText(l.res, sback)
/*     */       {
/*     */         protected void clickA() {
/* 435 */           ScreenSetting.this.message = null;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 440 */     bText.body().moveX1(80.0D);
/* 441 */     bText.body().moveY1((this.mFullScreens.getLastY2() + 10));
/* 442 */     this.mFullScreens.add((RENDEROBJ)bText);
/* 443 */     this.mFullScreens.body().centerX(0.0D, 896.0D);
/* 444 */     this.mFullScreens.body().centerY(0.0D, 448.0D);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 452 */     Multi multi2 = new Multi(this, l.s.windowWidth, D.g("Width"), D.g("widthD", "The width of the window"))
/*     */       {
/*     */         public void setValue(Text v, LSettings.LSettingInt s)
/*     */         {
/* 456 */           v.add((int)(s.getD() * 100.0D));
/* 457 */           v.add('%');
/*     */         }
/*     */       };
/* 460 */     this.windowed.add((RENDEROBJ)multi2);
/* 461 */     multi2 = new Multi(this, 
/* 462 */         l.s.windowHeight, D.g("Height"), D.g("HeightD", "The height of the window"))
/*     */       {
/*     */         public void setValue(Text v, LSettings.LSettingInt s) {
/* 465 */           v.add((int)(s.getD() * 100.0D));
/* 466 */           v.add('%');
/*     */         }
/*     */       };
/* 469 */     this.windowed.addDown(0, (RENDEROBJ)multi2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 475 */     this.windowed.body().moveY1(getLastY1());
/* 476 */     this.windowed.body().moveX1(40.0D);
/*     */     
/* 478 */     CheckBox checkBox1 = new CheckBox(l.s.decorated, D.g("Borders"), D.g("BorderD", "Use borders and system decoration on the window"));
/* 479 */     this.windowed.addRelBody(16, DIR.E, (RENDEROBJ)checkBox1);
/*     */     
/* 481 */     checkBox1 = new CheckBox(this, l.s.forcedHD, "HD", "Forced HD resolution")
/*     */       {
/*     */         
/*     */         protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered)
/*     */         {
/* 486 */           if (l.s.developer.get() == 0)
/*     */             return; 
/* 488 */           super.render(r, ds, isActive, isSelected, isHovered);
/*     */         }
/*     */       };
/*     */     
/* 492 */     this.windowed.addRelBody(16, DIR.E, (RENDEROBJ)checkBox1);
/*     */ 
/*     */     
/* 495 */     add((RENDEROBJ)this.windowed);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 500 */     Multi multi1 = new Multi(this, l.s.windowBorderLessScale, D.g("Scale"), D.g("ScaleD", "The scale of the game. Choose a bigger scale if the game is too small for you."))
/*     */       {
/*     */         public void setValue(Text v, LSettings.LSettingInt s)
/*     */         {
/* 504 */           v.add((int)(100.0D + s.getD() * 100.0D));
/* 505 */           v.add('%');
/*     */         }
/*     */       };
/* 508 */     this.borderless.add((RENDEROBJ)multi1);
/*     */     
/* 510 */     this.borderless.body().moveY1(getLastY1());
/* 511 */     this.borderless.body().moveX1(40.0D);
/*     */ 
/*     */     
/* 514 */     add((RENDEROBJ)this.borderless);
/*     */ 
/*     */ 
/*     */     
/* 518 */     GuiSection s = new GuiSection();
/* 519 */     s.body().setWidth(896.0D);
/*     */ 
/*     */     
/* 522 */     CLICKABLE b = (new GUI.BText(l.res, sback)).clickActionSet(new ACTION()
/*     */         {
/*     */           public void exe() {
/* 525 */             ScreenSetting.this.exit();
/*     */           }
/*     */         });
/* 528 */     b.body().moveX2(880.0D);
/* 529 */     s.add((RENDEROBJ)b);
/*     */     
/* 531 */     b = (new GUI.BText(l.res, D.g("Reset"))).clickActionSet(new ACTION()
/*     */         {
/*     */           public void exe() {
/* 534 */             l.s.setDefault();
/*     */           }
/*     */         });
/* 537 */     b.body().moveX2((s.getLastX1() - 8));
/* 538 */     s.add((RENDEROBJ)b);
/* 539 */     s.addCentredY((RENDEROBJ)new GUI.Header(l.res, D.g("Settings")), 16);
/*     */ 
/*     */     
/* 542 */     addRelBody(16, DIR.N, (RENDEROBJ)s);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 550 */     body().centerIn(0.0D, 896.0D, 0.0D, 448.0D);
/* 551 */     body().moveY1(16.0D);
/* 552 */     settResolutions();
/*     */   }
/*     */   
/*     */   private final GUI.ScrollBox content;
/*     */   private GuiSection message;
/*     */   private final GuiSection mFullScreens;
/*     */   private Str hoverInfo;
/*     */   
/*     */   private CLICKABLE resButt(final int i) {
/* 561 */     Displays.DisplayMode d = (Displays.DisplayMode)Displays.available(this.l.s.monitor.get()).get(i);
/*     */     
/* 563 */     COLOR c = COLOR.WHITE100;
/* 564 */     if (d.width < 1280) {
/* 565 */       c = COLOR.RED100;
/* 566 */     } else if (d.height < 768) {
/* 567 */       c = COLOR.RED100;
/*     */     } else {
/* 569 */       double a = (d.width * d.height);
/* 570 */       if (a > 2700000.0D) {
/* 571 */         c = COLOR.ORANGE100;
/*     */       }
/*     */     } 
/* 574 */     final COLOR c2 = c;
/*     */     
/* 576 */     return (CLICKABLE)new GUI.BText(this.l.res, ((Displays.DisplayMode)Displays.available(this.l.s.monitor.get()).get(i)).toString())
/*     */       {
/*     */         protected void clickA()
/*     */         {
/* 580 */           ScreenSetting.this.l.s.fullScreenDisplay.set(i);
/* 581 */           ScreenSetting.this.message = null;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 587 */           c2.bind();
/* 588 */           super.render(r, ds, isActive, isSelected, isHovered);
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void settResolutions() {
/* 597 */     this.content.clear();
/* 598 */     for (int i = 0; i < Displays.available(this.l.s.monitor.get()).size(); i++) {
/* 599 */       CLICKABLE bb = resButt(i);
/* 600 */       this.content.add((HOVERABLE)bb);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void exit() {
/* 605 */     this.message = null;
/*     */     
/* 607 */     this.l.setMain();
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, float ds) {
/* 612 */     OPACITY.O75.bind();
/* 613 */     COLOR.BLACK.render(r, 0, 896, 0, 448);
/* 614 */     OPACITY.unbind();
/* 615 */     super.render(r, ds);
/* 616 */     if (this.hoverInfo.length() != 0) {
/* 617 */       GUI.c_label.bind();
/* 618 */       this.l.res.font.render(r, (CharSequence)this.hoverInfo, 16, 368, 864, 1.0D);
/* 619 */       this.hoverInfo.clear();
/*     */     } 
/* 621 */     if (this.message != null) {
/* 622 */       OPACITY.O75.bind();
/* 623 */       COLOR.BLACK.render(r, 0, 896, 0, 448);
/* 624 */       OPACITY.unbind();
/* 625 */       this.message.render(r, ds);
/*     */     } 
/* 627 */     COLOR.unbind();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hover(COORDINATE mCoo) {
/* 632 */     if (this.message != null) {
/* 633 */       return this.message.hover(mCoo);
/*     */     }
/* 635 */     return super.hover(mCoo);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean click() {
/* 641 */     if (this.message != null) {
/* 642 */       return this.message.click();
/*     */     }
/* 644 */     return super.click();
/*     */   }
/*     */   
/*     */   private class CheckBox
/*     */     extends GUI.BText {
/*     */     private final LSettings.LSettingInt b;
/*     */     
/*     */     CheckBox(LSettings.LSettingInt b, CharSequence name, CharSequence desc) {
/* 652 */       super(ScreenSetting.this.l.res, name, 150);
/* 653 */       this.b = b;
/* 654 */       hoverInfoSet(desc);
/*     */     }
/*     */ 
/*     */     
/*     */     protected void clickA() {
/* 659 */       this.b.set(this.b.get() + 1 & 0x1);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 666 */       isSelected = (this.b.get() == 1);
/* 667 */       super.render(r, ds, isActive, isSelected, isHovered);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean hover(COORDINATE mCoo) {
/* 673 */       if (super.hover(mCoo) && this.hoverInfo != null) {
/* 674 */         ScreenSetting.this.hoverInfo.add(this.hoverInfo);
/* 675 */         return true;
/*     */       } 
/* 677 */       return false;
/*     */     }
/*     */   }
/*     */   
/*     */   private class Multi
/*     */     extends GuiSection
/*     */   {
/*     */     private final SPRITE s;
/* 685 */     private final Text value = new Text(ScreenSetting.this.l.res.font, 100);
/* 686 */     private final CLICKABLE left = (CLICKABLE)new GUI.BSprite(ScreenSetting.this.l.res.arrowLR[0])
/*     */       {
/*     */         protected void clickA() {
/* 689 */           ScreenSetting.Multi.this.b.inc(-1);
/*     */         }
/*     */ 
/*     */         
/*     */         protected void renAction() {
/* 694 */           activeSet((ScreenSetting.Multi.this.b.get() > ScreenSetting.Multi.this.b.min()));
/*     */         }
/*     */       };
/* 697 */     private final CLICKABLE right = (CLICKABLE)new GUI.BSprite(ScreenSetting.this.l.res.arrowLR[1])
/*     */       {
/*     */         protected void clickA() {
/* 700 */           ScreenSetting.Multi.this.b.inc(1);
/*     */         }
/*     */ 
/*     */         
/*     */         protected void renAction() {
/* 705 */           activeSet((ScreenSetting.Multi.this.b.get() < ScreenSetting.Multi.this.b.max()));
/*     */         }
/*     */       };
/*     */     
/*     */     private final LSettings.LSettingInt b;
/*     */     private int width;
/*     */     private CharSequence desc;
/*     */     
/*     */     Multi(LSettings.LSettingInt b, CharSequence name, CharSequence desc) {
/* 714 */       this(b, name, desc, 100);
/*     */     }
/*     */     
/*     */     Multi(LSettings.LSettingInt b, CharSequence name, CharSequence desc, int w) {
/* 718 */       this.b = b;
/* 719 */       this.s = (SPRITE)new Text(ScreenSetting.this.l.res.font, name);
/* 720 */       add(this.s, 0, 0);
/* 721 */       hoverInfoSet(desc);
/* 722 */       this.desc = desc;
/* 723 */       this.width = 180;
/* 724 */       addRightCAbs(120, (RENDEROBJ)this.left);
/* 725 */       addRightC(this.width, (RENDEROBJ)this.right);
/*     */     }
/*     */ 
/*     */     
/*     */     public void render(SPRITE_RENDERER r, float ds) {
/* 730 */       this.value.clear();
/* 731 */       setValue(this.value, this.b);
/* 732 */       this.value.adjustWidth();
/* 733 */       int dx = (this.width - this.value.width()) / 2;
/* 734 */       this.value.renderCY(r, this.left.body().x2() + dx, body().cY());
/* 735 */       super.render(r, ds);
/*     */     }
/*     */     
/*     */     public void setValue(Text v, LSettings.LSettingInt s) {
/* 739 */       v.add(s.get());
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean hover(COORDINATE mCoo) {
/* 744 */       if (super.hover(mCoo)) {
/* 745 */         ScreenSetting.this.hoverInfo.add(this.desc);
/* 746 */         return true;
/*     */       } 
/* 748 */       return false;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\launcher\ScreenSetting.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */