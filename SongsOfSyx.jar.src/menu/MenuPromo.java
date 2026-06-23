/*     */ package menu;
/*     */ 
/*     */ import init.constant.C;
/*     */ import init.paths.PATHS;
/*     */ import init.settings.S;
/*     */ import init.sprite.UI.UI;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.nio.file.Path;
/*     */ import snake2d.CORE;
/*     */ import snake2d.CORE_STATE;
/*     */ import snake2d.Displays;
/*     */ import snake2d.KEYCODES;
/*     */ import snake2d.KeyBoard;
/*     */ import snake2d.MButt;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SETTINGS;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.file.JsonE;
/*     */ import snake2d.util.file.SnakeImage;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.light.AmbientLight;
/*     */ import snake2d.util.light.Fire;
/*     */ import snake2d.util.light.PointLight;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.misc.ERROR_HANDLER;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ import snake2d.util.sprite.text.StringInputSprite;
/*     */ import util.data.DOUBLE;
/*     */ import util.data.INT;
/*     */ import util.error.ErrorHandler;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.slider.GTarget;
/*     */ import util.spritecomposer.ComposerDests;
/*     */ import util.spritecomposer.ComposerSources;
/*     */ import util.spritecomposer.ComposerThings;
/*     */ import util.spritecomposer.ComposerUtil;
/*     */ import util.spritecomposer.Initer;
/*     */ import view.keyboard.KEYS;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MenuPromo
/*     */   extends CORE_STATE
/*     */ {
/*     */   private TILE_SHEET background;
/*     */   private final int ttX;
/*     */   private final int ttY;
/*  58 */   int offX = 0;
/*  59 */   int offY = 0;
/*     */   
/*  61 */   private final ArrayListGrower<PointLight> lights = new ArrayListGrower();
/*  62 */   private final ArrayListGrower<AmbientLight> alights = new ArrayListGrower();
/*     */   
/*     */   private final GuiSection sec;
/*  65 */   private final int scale = 1; private final StringInputSprite in; Coo old; boolean pressed;
/*     */   int lastSavePress;
/*     */   
/*     */   public static void main(String[] args) {
/*  69 */     CORE.init((ERROR_HANDLER)new ErrorHandler());
/*     */     
/*  71 */     SETTINGS setting = new SETTINGS()
/*     */       {
/*     */         public boolean windowFloating()
/*     */         {
/*  75 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean vsyncAdaptive() {
/*  80 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public String openALDevice() {
/*  85 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public int monitor() {
/*  90 */           return 0;
/*     */         }
/*     */ 
/*     */         
/*     */         public String getWindowName() {
/*  95 */           return "promo";
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean getVSynchEnabled() {
/* 100 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public String getScreenshotFolder() {
/* 105 */           return String.valueOf((PATHS.local()).SCREENSHOT.get()) + String.valueOf((PATHS.local()).SCREENSHOT.get());
/*     */         }
/*     */ 
/*     */         
/*     */         public int getRenderMode() {
/* 110 */           return 1;
/*     */         }
/*     */ 
/*     */         
/*     */         public int getPointSize() {
/* 115 */           return 1;
/*     */         }
/*     */ 
/*     */         
/*     */         public int getNativeWidth() {
/* 120 */           return 1920;
/*     */         }
/*     */ 
/*     */         
/*     */         public int getNativeHeight() {
/* 125 */           return 1080;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean getLinearFiltering() {
/* 130 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public String getIconFolder() {
/* 136 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean getFitToScreen() {
/* 141 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public Displays.DisplayMode display() {
/* 146 */           return new Displays.DisplayMode(getNativeWidth(), getNativeHeight(), 60, false);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean decoratedWindow() {
/* 152 */           return false;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean debugMode() {
/* 158 */           return false;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean autoIconify() {
/* 164 */           return false;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean windowFullFull() {
/* 170 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public int FPS() {
/* 175 */           return -1;
/*     */         }
/*     */       };
/* 178 */     S.get().make();
/* 179 */     CORE.create(setting);
/* 180 */     CORE.getInput().getMouse().showCusor(false);
/* 181 */     PATHS.init(new String[0], null, false);
/* 182 */     CORE.start(new CORE_STATE.Constructor()
/*     */         {
/*     */           public CORE_STATE getState() {
/* 185 */             return new MenuPromo();
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static AmbientLight ambient() {
/* 282 */     return (new AmbientLight()).b(1.0D).g(1.0D).b(1.0D);
/*     */   }
/*     */   
/*     */   private void save(int i) {
/* 286 */     JsonE[] jl = new JsonE[this.lights.size()];
/* 287 */     int ii = 0;
/*     */     
/* 289 */     for (PointLight l : this.lights) {
/* 290 */       JsonE e = new JsonE();
/* 291 */       e.add("X", l.x());
/* 292 */       e.add("Y", l.y());
/* 293 */       e.add("Z", l.cz());
/* 294 */       e.add("RA", l.getRadius());
/* 295 */       e.add("F", l.getFalloff());
/* 296 */       e.add("R", l.getRed());
/* 297 */       e.add("G", l.getGreen());
/* 298 */       e.add("B", l.getBlue());
/* 299 */       jl[ii++] = e;
/*     */     } 
/*     */     
/* 302 */     JsonE[] ja = new JsonE[this.alights.size()];
/* 303 */     ii = 0;
/*     */     
/* 305 */     for (AmbientLight l : this.alights) {
/* 306 */       JsonE e = new JsonE();
/* 307 */       e.add("D", l.getDir());
/* 308 */       e.add("T", l.getTilt());
/* 309 */       e.add("R", l.r());
/* 310 */       e.add("G", l.g());
/* 311 */       e.add("B", l.b());
/* 312 */       ja[ii++] = e;
/*     */     } 
/*     */     
/* 315 */     JsonE res = new JsonE();
/*     */     
/* 317 */     res.add("POINT", jl);
/* 318 */     res.add("AMBI", ja);
/*     */ 
/*     */     
/* 321 */     Path p = (PATHS.local()).LOGS.get().resolve("PROMO" + i + ".txt");
/* 322 */     System.out.println(p);
/* 323 */     res.save(p);
/*     */   }
/*     */ 
/*     */   
/*     */   private void load(int i) {
/* 328 */     if (!(PATHS.local()).LOGS.exists("PROMO" + i)) {
/* 329 */       System.out.println("nay");
/*     */       
/*     */       return;
/*     */     } 
/* 333 */     Json jj = new Json((PATHS.local()).LOGS.gets("PROMO" + i));
/*     */     
/* 335 */     this.lights.clear(); byte b; int j;
/*     */     Json[] arrayOfJson;
/* 337 */     for (j = (arrayOfJson = jj.jsons("POINT")).length, b = 0; b < j; ) { Json json = arrayOfJson[b];
/* 338 */       PointLight p = new PointLight();
/* 339 */       p.xSet(json.d("X"));
/* 340 */       p.ySet(json.d("Y"));
/* 341 */       p.setZ((int)json.d("Z"));
/* 342 */       p.setRadius(json.i("RA"));
/* 343 */       p.setFalloff((float)json.d("F"));
/* 344 */       p.setRed(json.d("R"));
/* 345 */       p.setGreen(json.d("G"));
/* 346 */       p.setBlue(json.d("B"));
/* 347 */       this.lights.add(p);
/*     */       b++; }
/*     */     
/* 350 */     this.alights.clear();
/* 351 */     for (j = (arrayOfJson = jj.jsons("AMBI")).length, b = 0; b < j; ) { Json json = arrayOfJson[b];
/* 352 */       AmbientLight p = new AmbientLight();
/* 353 */       p.setDir(json.d("D"));
/* 354 */       p.setTilt(json.d("T"));
/* 355 */       p.r(json.d("R"));
/* 356 */       p.g(json.d("G"));
/* 357 */       p.b(json.d("B"));
/* 358 */       this.alights.add(p);
/*     */       b++; }
/*     */   
/*     */   }
/*     */   
/* 363 */   private MenuPromo() { this.old = new Coo();
/* 364 */     this.pressed = false;
/* 365 */     this.lastSavePress = -1; final Path ss = (new File((new File(System.getProperty("user.dir"))).getParent().toString() + (new File(System.getProperty("user.dir"))).getParent().toString() + "Tools" + File.separator + "mural" + File.separator + "Result.png")).toPath(); System.out.println(ss.toString()); (new CORE.GlJob() { public void doJob() { (new Initer() { public void createAssets() throws IOException { COORDINATE dim = SnakeImage.dim(ss); final int tx = (dim.x() - 24) / 64; final int ty = (dim.y() - 12) / 32; (MenuPromo.null.access$0(MenuPromo.null.this)).background = (new ComposerThings.ITileSheet(ss, dim.x(), dim.y()) { protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d) { s.full.init(0, 0, 1, 1, tx, ty, d.s32); s.full.paste(true); return d.s32.save(1); } }
/*     */                   ).get(); } }
/*     */             ).get("menuPromo", PATHS.textureSize(), 0); } }
/*     */       ).perform(); KEYS.init(); COORDINATE dim = SnakeImage.dim(ss); this.ttX = dim.x() / 64; this.ttY = dim.y() / 32; this.sec = new GuiSection(); this.sec.add((RENDEROBJ)new Sec()); this.sec.addRightC(4, (RENDEROBJ)new Sec2()); this.in = new StringInputSprite(100, (UI.FONT()).H1); Fire torch1 = new Fire(7.0D); Fire torch2 = new Fire(7.0D); PointLight torch3 = new PointLight(); PointLight torch4 = new PointLight(); torch1.set(-662.0D, 921.0D); torch1.setZ(130); torch1.setRadius(1902); torch1.setFalloff(2.0F); torch2.set(2188.0D, 862.0D); torch2.setZ(80); torch2.setRadius(2107); torch2.setFalloff(3.0F); torch3.set(864.0D, -257.0D); torch3.setZ(73); torch3.setRadius(1808); torch3.setFalloff(1.17F); torch3.setRed(1.5D).setGreen(1.5D).setBlue(1.5D); torch4.set(904.0D, 1660.0D); torch4.setZ(-173); torch4.setRadius(3739); torch4.setFalloff(4.63F); torch4.setRed(3.5D).setGreen(3.0D).setBlue(2.0D); torch4.set(974.0D, 24.0D); torch4.setZ(53); torch4.setRadius(1741); torch4.setFalloff(2.2F); torch4.setRed(1.0D).setGreen(1.0D).setBlue(1.5D); this.lights.add(torch1);
/* 369 */     this.alights.add(ambient()); } public void update(float ds, double slow) { this.sec.hover((COORDINATE)CORE.getInput().getMouse().getCoo());
/*     */     
/* 371 */     if (this.pressed) {
/* 372 */       this.pressed = MButt.RIGHT.isDown();
/* 373 */       if (this.pressed) {
/* 374 */         this.offX += CORE.getInput().getMouse().getCoo().x() - this.old.x();
/* 375 */         this.offY += CORE.getInput().getMouse().getCoo().y() - this.old.y();
/* 376 */         this.old.set((COORDINATE)CORE.getInput().getMouse().getCoo());
/*     */       }
/*     */     
/* 379 */     } else if (MButt.RIGHT.isDown()) {
/* 380 */       this.pressed = true;
/* 381 */       this.old.set((COORDINATE)CORE.getInput().getMouse().getCoo());
/*     */     } 
/*     */     
/* 384 */     if (CORE.getInput().getKeyboard().isPressed(257)) {
/* 385 */       int ii = 0;
/* 386 */       for (PointLight l : this.lights) {
/* 387 */         System.out.println(ii++);
/* 388 */         System.out.println("x: " + l.x());
/* 389 */         System.out.println("y: " + l.y());
/* 390 */         System.out.println("z: " + l.cz());
/* 391 */         System.out.println("ra: " + l.getRadius());
/* 392 */         System.out.println("f: " + l.getFalloff());
/* 393 */         System.out.println("rgb: " + l.getRed() + " " + l.getGreen() + " " + l.getBlue());
/*     */       } 
/*     */     } 
/*     */     
/* 397 */     if (CORE.getInput().getKeyboard().isPressed(256)) {
/* 398 */       CORE.annihilate();
/*     */     }
/*     */     
/* 401 */     if (CORE.getInput().getKeyboard().isPressed(341)) {
/* 402 */       int i = 0; byte b; int j, arrayOfInt[];
/* 403 */       for (j = (arrayOfInt = KEYCODES.KEY_NUMS).length, b = 0; b < j; ) { int k = arrayOfInt[b];
/* 404 */         if (k != this.lastSavePress && CORE.getInput().getKeyboard().isPressed(k)) {
/* 405 */           save(i);
/* 406 */           this.lastSavePress = k;
/*     */         } 
/* 408 */         i++; b++; }
/*     */     
/* 410 */     } else if (CORE.getInput().getKeyboard().isPressed(340)) {
/* 411 */       int i = 0; byte b; int j, arrayOfInt[];
/* 412 */       for (j = (arrayOfInt = KEYCODES.KEY_NUMS).length, b = 0; b < j; ) { int k = arrayOfInt[b];
/* 413 */         if (k != this.lastSavePress && CORE.getInput().getKeyboard().isPressed(k)) {
/* 414 */           load(i);
/* 415 */           this.lastSavePress = k;
/*     */         } 
/* 417 */         i++; b++; }
/*     */     
/*     */     } else {
/* 420 */       this.lastSavePress = -1;
/*     */     }  }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void keyPush(LIST<KeyBoard.KeyEvent> keys, boolean hasCleared) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(Renderer r, float ds) {
/* 435 */     CORE.renderer().newLayer(false, 0);
/* 436 */     this.sec.render((SPRITE_RENDERER)r, ds);
/*     */     
/* 438 */     if (this.in.text().length() != 0) {
/*     */ 
/*     */ 
/*     */       
/* 442 */       AmbientLight.Strongmoonlight.register(0, 1920, 0, 1080);
/* 443 */       this.in.render((SPRITE_RENDERER)r, 100, 50);
/*     */       
/* 445 */       CORE.renderer().newLayer(false, 0);
/* 446 */       AmbientLight.full.register(C.DIM());
/* 447 */       COLOR.GREEN100.render((SPRITE_RENDERER)r, 100, 100 + this.in.width(), 50, 50 + this.in.height());
/*     */     } 
/*     */ 
/*     */     
/* 451 */     CORE.renderer().newLayer(false, 0);
/*     */     
/* 453 */     CORE.renderer().shadeLight(true);
/* 454 */     CORE.renderer().shadowDepthDefault();
/*     */     
/* 456 */     byte full = -1;
/* 457 */     for (PointLight l : this.lights) {
/* 458 */       l.register(full, full, full, full);
/*     */     }
/*     */     
/* 461 */     for (AmbientLight l : this.alights) {
/* 462 */       l.register(0, 1920, 0, 1080);
/*     */     }
/*     */     
/* 465 */     int ti = 0;
/*     */     
/* 467 */     for (int y = 0; y < this.ttY; y++) {
/* 468 */       for (int x = 0; x < this.ttX; x++) {
/* 469 */         this.background.render((SPRITE_RENDERER)r, ti, x * 32 * 1 + this.offX, y * 32 * 1 + this.offY);
/* 470 */         ti++;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void mouseClick(MButt button) {
/* 479 */     this.sec.click();
/*     */   }
/*     */   
/*     */   private class Sec
/*     */     extends GuiSection
/*     */   {
/* 485 */     INT.IntImp current = new INT.IntImp()
/*     */       {
/*     */         public int max() {
/* 488 */           return (MenuPromo.Sec.access$0(MenuPromo.Sec.this)).lights.size() - 1;
/*     */         }
/*     */ 
/*     */         
/*     */         public int get() {
/* 493 */           return CLAMP.i(super.get(), min(), max());
/*     */         }
/*     */ 
/*     */         
/*     */         public int min() {
/* 498 */           return 0;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*     */     public Sec() {
/* 504 */       add((RENDEROBJ)new GButt.ButtPanel("new")
/*     */           {
/*     */             protected void clickA() {
/* 507 */               PointLight l = new PointLight();
/* 508 */               l.setRed(1.0D);
/* 509 */               l.setGreen(1.0D);
/* 510 */               l.setBlue(1.0D);
/* 511 */               l.set(C.DIM().cX(), C.DIM().cY());
/* 512 */               l.setZ(20);
/* 513 */               l.setRadius(100);
/* 514 */               (MenuPromo.Sec.access$0(MenuPromo.Sec.this)).lights.add(l);
/* 515 */               MenuPromo.Sec.this.current.i = (MenuPromo.Sec.access$0(MenuPromo.Sec.this)).lights.size() - 1;
/*     */             }
/*     */           });
/*     */       
/* 519 */       addDown(4, (RENDEROBJ)new GTarget(100, false, true, (INT.INTE)this.current));
/*     */       
/* 521 */       addDown(4, (RENDEROBJ)new MenuPromo.Slider("X", new INT.INTE()
/*     */             {
/*     */               public int min()
/*     */               {
/* 525 */                 return -2000;
/*     */               }
/*     */ 
/*     */               
/*     */               public int max() {
/* 530 */                 return C.DIM().x2() + 2000;
/*     */               }
/*     */ 
/*     */               
/*     */               public int get() {
/* 535 */                 return ((PointLight)(MenuPromo.Sec.access$0(MenuPromo.Sec.this)).lights.get(MenuPromo.Sec.this.current.i)).x();
/*     */               }
/*     */ 
/*     */               
/*     */               public void set(int t) {
/* 540 */                 ((PointLight)(MenuPromo.Sec.access$0(MenuPromo.Sec.this)).lights.get(MenuPromo.Sec.this.current.i)).set(t, ((PointLight)(MenuPromo.Sec.access$0(MenuPromo.Sec.this)).lights.get(MenuPromo.Sec.this.current.i)).y());
/*     */               }
/*     */             }));
/*     */       
/* 544 */       addDown(4, (RENDEROBJ)new MenuPromo.Slider("Y", new INT.INTE()
/*     */             {
/*     */               public int min()
/*     */               {
/* 548 */                 return -2000;
/*     */               }
/*     */ 
/*     */               
/*     */               public int max() {
/* 553 */                 return C.DIM().x2() + 2000;
/*     */               }
/*     */ 
/*     */               
/*     */               public int get() {
/* 558 */                 return ((PointLight)(MenuPromo.Sec.access$0(MenuPromo.Sec.this)).lights.get(MenuPromo.Sec.this.current.i)).y();
/*     */               }
/*     */ 
/*     */               
/*     */               public void set(int t) {
/* 563 */                 ((PointLight)(MenuPromo.Sec.access$0(MenuPromo.Sec.this)).lights.get(MenuPromo.Sec.this.current.i)).set(((PointLight)(MenuPromo.Sec.access$0(MenuPromo.Sec.this)).lights.get(MenuPromo.Sec.this.current.i)).x(), t);
/*     */               }
/*     */             }));
/*     */       
/* 567 */       addDown(4, (RENDEROBJ)new MenuPromo.Slider("Z", new INT.INTE()
/*     */             {
/*     */               public int min()
/*     */               {
/* 571 */                 return -1000;
/*     */               }
/*     */ 
/*     */               
/*     */               public int max() {
/* 576 */                 return 1000;
/*     */               }
/*     */ 
/*     */               
/*     */               public int get() {
/* 581 */                 return (int)((PointLight)(MenuPromo.Sec.access$0(MenuPromo.Sec.this)).lights.get(MenuPromo.Sec.this.current.i)).cz();
/*     */               }
/*     */ 
/*     */               
/*     */               public void set(int t) {
/* 586 */                 ((PointLight)(MenuPromo.Sec.access$0(MenuPromo.Sec.this)).lights.get(MenuPromo.Sec.this.current.i)).setZ(t);
/*     */               }
/*     */             }));
/*     */       
/* 590 */       addDown(4, (RENDEROBJ)new MenuPromo.Slider("FOFF", new INT.INTE()
/*     */             {
/*     */               public int min()
/*     */               {
/* 594 */                 return 1;
/*     */               }
/*     */ 
/*     */               
/*     */               public int max() {
/* 599 */                 return 1000;
/*     */               }
/*     */ 
/*     */               
/*     */               public int get() {
/* 604 */                 return (int)(((PointLight)(MenuPromo.Sec.access$0(MenuPromo.Sec.this)).lights.get(MenuPromo.Sec.this.current.i)).getFalloff() * 100.0F);
/*     */               }
/*     */ 
/*     */               
/*     */               public void set(int t) {
/* 609 */                 ((PointLight)(MenuPromo.Sec.access$0(MenuPromo.Sec.this)).lights.get(MenuPromo.Sec.this.current.i)).setFalloff((float)(t / 100.0D));
/*     */               }
/*     */             }));
/*     */       
/* 613 */       addDown(4, (RENDEROBJ)new MenuPromo.Slider("RAD", new INT.INTE()
/*     */             {
/*     */               public int min()
/*     */               {
/* 617 */                 return 10;
/*     */               }
/*     */ 
/*     */               
/*     */               public int max() {
/* 622 */                 return 10000;
/*     */               }
/*     */ 
/*     */               
/*     */               public int get() {
/* 627 */                 return ((PointLight)(MenuPromo.Sec.access$0(MenuPromo.Sec.this)).lights.get(MenuPromo.Sec.this.current.i)).getRadius();
/*     */               }
/*     */ 
/*     */               
/*     */               public void set(int t) {
/* 632 */                 ((PointLight)(MenuPromo.Sec.access$0(MenuPromo.Sec.this)).lights.get(MenuPromo.Sec.this.current.i)).setRadius(t);
/*     */               }
/*     */             }));
/*     */       
/* 636 */       addDown(4, (RENDEROBJ)new MenuPromo.Slider("R", new INT.INTE()
/*     */             {
/*     */               public int min()
/*     */               {
/* 640 */                 return 0;
/*     */               }
/*     */ 
/*     */               
/*     */               public int max() {
/* 645 */                 return 1000;
/*     */               }
/*     */ 
/*     */               
/*     */               public int get() {
/* 650 */                 return (int)(((PointLight)(MenuPromo.Sec.access$0(MenuPromo.Sec.this)).lights.get(MenuPromo.Sec.this.current.i)).getRed() * 100.0F);
/*     */               }
/*     */ 
/*     */               
/*     */               public void set(int t) {
/* 655 */                 ((PointLight)(MenuPromo.Sec.access$0(MenuPromo.Sec.this)).lights.get(MenuPromo.Sec.this.current.i)).setRed(t / 100.0D);
/*     */               }
/*     */             }));
/*     */       
/* 659 */       addDown(4, (RENDEROBJ)new MenuPromo.Slider("G", new INT.INTE()
/*     */             {
/*     */               public int min()
/*     */               {
/* 663 */                 return 0;
/*     */               }
/*     */ 
/*     */               
/*     */               public int max() {
/* 668 */                 return 1000;
/*     */               }
/*     */ 
/*     */               
/*     */               public int get() {
/* 673 */                 return (int)(((PointLight)(MenuPromo.Sec.access$0(MenuPromo.Sec.this)).lights.get(MenuPromo.Sec.this.current.i)).getGreen() * 100.0F);
/*     */               }
/*     */ 
/*     */               
/*     */               public void set(int t) {
/* 678 */                 ((PointLight)(MenuPromo.Sec.access$0(MenuPromo.Sec.this)).lights.get(MenuPromo.Sec.this.current.i)).setGreen(t / 100.0D);
/*     */               }
/*     */             }));
/*     */       
/* 682 */       addDown(4, (RENDEROBJ)new MenuPromo.Slider("B", new INT.INTE()
/*     */             {
/*     */               public int min()
/*     */               {
/* 686 */                 return 0;
/*     */               }
/*     */ 
/*     */               
/*     */               public int max() {
/* 691 */                 return 1000;
/*     */               }
/*     */ 
/*     */               
/*     */               public int get() {
/* 696 */                 return (int)(((PointLight)(MenuPromo.Sec.access$0(MenuPromo.Sec.this)).lights.get(MenuPromo.Sec.this.current.i)).getBlue() * 100.0F);
/*     */               }
/*     */ 
/*     */               
/*     */               public void set(int t) {
/* 701 */                 ((PointLight)(MenuPromo.Sec.access$0(MenuPromo.Sec.this)).lights.get(MenuPromo.Sec.this.current.i)).setBlue(t / 100.0D);
/*     */               }
/*     */             }));
/*     */       
/* 705 */       body().centerIn(C.DIM());
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void render(SPRITE_RENDERER r, float ds) {
/* 711 */       if (CORE.getInput().getKeyboard().isPressed(340)) {
/* 712 */         AmbientLight.full.register(C.DIM());
/* 713 */         COLOR.WHITE10.render(r, (RECTANGLE)body(), 8);
/* 714 */         super.render(r, ds);
/* 715 */         COLOR.GREEN100.render(r, CORE.getInput().getMouse().getCoo().x(), CORE.getInput().getMouse().getCoo().y());
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private class Sec2
/*     */     extends GuiSection
/*     */   {
/* 726 */     INT.IntImp current = new INT.IntImp()
/*     */       {
/*     */         public int max() {
/* 729 */           return (MenuPromo.Sec2.access$0(MenuPromo.Sec2.this)).alights.size() - 1;
/*     */         }
/*     */ 
/*     */         
/*     */         public int get() {
/* 734 */           return CLAMP.i(super.get(), min(), max());
/*     */         }
/*     */ 
/*     */         
/*     */         public int min() {
/* 739 */           return 0;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*     */     public Sec2() {
/* 745 */       add((RENDEROBJ)new GButt.ButtPanel("new")
/*     */           {
/*     */             protected void clickA() {
/* 748 */               AmbientLight l = MenuPromo.ambient();
/* 749 */               (MenuPromo.Sec2.access$0(MenuPromo.Sec2.this)).alights.add(l);
/* 750 */               MenuPromo.Sec2.this.current.i = (MenuPromo.Sec2.access$0(MenuPromo.Sec2.this)).lights.size() - 1;
/*     */             }
/*     */           });
/*     */       
/* 754 */       addDown(4, (RENDEROBJ)new GButt.ButtPanel("delete")
/*     */           {
/*     */             protected void clickA() {
/* 757 */               if ((MenuPromo.Sec2.access$0(MenuPromo.Sec2.this)).alights.size() > 0) {
/* 758 */                 (MenuPromo.Sec2.access$0(MenuPromo.Sec2.this)).alights.remove(MenuPromo.Sec2.this.current.get());
/* 759 */                 MenuPromo.Sec2.this.current.inc(-1);
/*     */               } 
/*     */             }
/*     */           });
/*     */       
/* 764 */       addDown(4, (RENDEROBJ)new GTarget(100, false, true, (INT.INTE)this.current));
/*     */       
/* 766 */       addDown(4, (RENDEROBJ)new MenuPromo.Slider("DEG", new INT.INTE()
/*     */             {
/*     */               public int min()
/*     */               {
/* 770 */                 return 0;
/*     */               }
/*     */ 
/*     */               
/*     */               public int max() {
/* 775 */                 return 360;
/*     */               }
/*     */ 
/*     */               
/*     */               public int get() {
/* 780 */                 return (int)((AmbientLight)(MenuPromo.Sec2.access$0(MenuPromo.Sec2.this)).alights.get(MenuPromo.Sec2.this.current.i)).getDir();
/*     */               }
/*     */ 
/*     */ 
/*     */               
/*     */               public void set(int t) {
/* 786 */                 ((AmbientLight)(MenuPromo.Sec2.access$0(MenuPromo.Sec2.this)).alights.get(MenuPromo.Sec2.this.current.i)).setDir(t);
/*     */               }
/*     */             }));
/*     */       
/* 790 */       addDown(4, (RENDEROBJ)new MenuPromo.Slider("TILT", new INT.INTE()
/*     */             {
/*     */               public int min()
/*     */               {
/* 794 */                 return -90;
/*     */               }
/*     */ 
/*     */               
/*     */               public int max() {
/* 799 */                 return 90;
/*     */               }
/*     */ 
/*     */               
/*     */               public int get() {
/* 804 */                 return (int)((AmbientLight)(MenuPromo.Sec2.access$0(MenuPromo.Sec2.this)).alights.get(MenuPromo.Sec2.this.current.i)).getTilt();
/*     */               }
/*     */ 
/*     */               
/*     */               public void set(int t) {
/* 809 */                 ((AmbientLight)(MenuPromo.Sec2.access$0(MenuPromo.Sec2.this)).alights.get(MenuPromo.Sec2.this.current.i)).setTilt(t);
/*     */               }
/*     */             }));
/*     */       
/* 813 */       addDown(4, (RENDEROBJ)new MenuPromo.Slider("R", new INT.INTE()
/*     */             {
/*     */               public int min()
/*     */               {
/* 817 */                 return 0;
/*     */               }
/*     */ 
/*     */               
/*     */               public int max() {
/* 822 */                 return 1000;
/*     */               }
/*     */ 
/*     */               
/*     */               public int get() {
/* 827 */                 return (int)(((AmbientLight)(MenuPromo.Sec2.access$0(MenuPromo.Sec2.this)).alights.get(MenuPromo.Sec2.this.current.i)).r() * 100.0D);
/*     */               }
/*     */ 
/*     */               
/*     */               public void set(int t) {
/* 832 */                 ((AmbientLight)(MenuPromo.Sec2.access$0(MenuPromo.Sec2.this)).alights.get(MenuPromo.Sec2.this.current.i)).set(t / 100.0D, ((AmbientLight)(MenuPromo.Sec2.access$0(MenuPromo.Sec2.this)).alights.get(MenuPromo.Sec2.this.current.i)).g(), ((AmbientLight)(MenuPromo.Sec2.access$0(MenuPromo.Sec2.this)).alights.get(MenuPromo.Sec2.this.current.i)).b());
/*     */               }
/*     */             }));
/*     */       
/* 836 */       addDown(4, (RENDEROBJ)new MenuPromo.Slider("G", new INT.INTE()
/*     */             {
/*     */               public int min()
/*     */               {
/* 840 */                 return 0;
/*     */               }
/*     */ 
/*     */               
/*     */               public int max() {
/* 845 */                 return 1000;
/*     */               }
/*     */ 
/*     */               
/*     */               public int get() {
/* 850 */                 return (int)(((AmbientLight)(MenuPromo.Sec2.access$0(MenuPromo.Sec2.this)).alights.get(MenuPromo.Sec2.this.current.i)).g() * 100.0D);
/*     */               }
/*     */ 
/*     */               
/*     */               public void set(int t) {
/* 855 */                 ((AmbientLight)(MenuPromo.Sec2.access$0(MenuPromo.Sec2.this)).alights.get(MenuPromo.Sec2.this.current.i)).set(((AmbientLight)(MenuPromo.Sec2.access$0(MenuPromo.Sec2.this)).alights.get(MenuPromo.Sec2.this.current.i)).r(), t / 100.0D, ((AmbientLight)(MenuPromo.Sec2.access$0(MenuPromo.Sec2.this)).alights.get(MenuPromo.Sec2.this.current.i)).b());
/*     */               }
/*     */             }));
/*     */       
/* 859 */       addDown(4, (RENDEROBJ)new MenuPromo.Slider("B", new INT.INTE()
/*     */             {
/*     */               public int min()
/*     */               {
/* 863 */                 return 0;
/*     */               }
/*     */ 
/*     */               
/*     */               public int max() {
/* 868 */                 return 1000;
/*     */               }
/*     */ 
/*     */               
/*     */               public int get() {
/* 873 */                 return (int)(((AmbientLight)(MenuPromo.Sec2.access$0(MenuPromo.Sec2.this)).alights.get(MenuPromo.Sec2.this.current.i)).b() * 100.0D);
/*     */               }
/*     */ 
/*     */               
/*     */               public void set(int t) {
/* 878 */                 ((AmbientLight)(MenuPromo.Sec2.access$0(MenuPromo.Sec2.this)).alights.get(MenuPromo.Sec2.this.current.i)).set(((AmbientLight)(MenuPromo.Sec2.access$0(MenuPromo.Sec2.this)).alights.get(MenuPromo.Sec2.this.current.i)).r(), ((AmbientLight)(MenuPromo.Sec2.access$0(MenuPromo.Sec2.this)).alights.get(MenuPromo.Sec2.this.current.i)).g(), t / 100.0D);
/*     */               }
/*     */             }));
/*     */       
/* 882 */       body().centerIn(C.DIM());
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void render(SPRITE_RENDERER r, float ds) {
/* 888 */       if (CORE.getInput().getKeyboard().isPressed(341)) {
/* 889 */         AmbientLight.full.register(C.DIM());
/* 890 */         COLOR.WHITE10.render(r, (RECTANGLE)body(), 8);
/* 891 */         super.render(r, ds);
/* 892 */         COLOR.GREEN100.render(r, CORE.getInput().getMouse().getCoo().x(), CORE.getInput().getMouse().getCoo().y());
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   private class Slider
/*     */     extends CLICKABLE.ClickableAbs
/*     */   {
/*     */     private INT.INTE in;
/*     */     private final String name;
/*     */     
/*     */     Slider(String mame, INT.INTE in) {
/* 904 */       super(300, 32);
/* 905 */       this.in = in;
/* 906 */       this.name = mame;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void clickA() {
/* 912 */       int x = CORE.getInput().getMouse().getCoo().x();
/* 913 */       x -= body().x1();
/* 914 */       double d = x / body().width();
/*     */       
/* 916 */       d *= (this.in.max() - this.in.min());
/* 917 */       int a = (int)(d + this.in.min());
/* 918 */       a = CLAMP.i(a, this.in.min(), this.in.max());
/*     */       
/* 920 */       this.in.set(a);
/*     */     }
/*     */ 
/*     */     
/*     */     protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 925 */       if (isHovered && MButt.LEFT.isDown())
/* 926 */         clickA(); 
/* 927 */       (isHovered ? COLOR.WHITE10 : COLOR.WHITE20).render(r, (RECTANGLE)body());
/* 928 */       (UI.FONT()).M.render(r, this.name, this.body.x1(), this.body.y1());
/* 929 */       int d = this.body.width() * (this.in.get() - this.in.min()) / (this.in.max() - this.in.min());
/* 930 */       COLOR.WHITE85.render(r, this.body.x1() + d - 2, this.body.x1() + d + 2, this.body.y1(), this.body.y2());
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\menu\MenuPromo.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */