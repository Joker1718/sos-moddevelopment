/*     */ package launcher;
/*     */ 
/*     */ import game.VERSION;
/*     */ import init.paths.PATHS;
/*     */ import java.io.IOException;
/*     */ import snake2d.CORE;
/*     */ import snake2d.CORE_STATE;
/*     */ import snake2d.KeyBoard;
/*     */ import snake2d.MButt;
/*     */ import snake2d.PreLoader;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.misc.ERROR_HANDLER;
/*     */ import snake2d.util.sets.LIST;
/*     */ import util.error.ErrorHandler;
/*     */ import util.spritecomposer.Initer;
/*     */ import util.text.D;
/*     */ 
/*     */ public class Launcher extends CORE_STATE {
/*     */   static boolean startGame = false;
/*     */   RES res;
/*     */   final GUI g;
/*     */   private final BG bg;
/*     */   
/*     */   void reboot() {
/*  29 */     CORE.renderer().clear();
/*  30 */     CORE.swapAndPoll();
/*  31 */     CORE.setCurrentState(new CORE_STATE.Constructor()
/*     */         {
/*     */           public CORE_STATE getState() {
/*  34 */             return new Launcher(false);
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public static void main(String[] args) {
/*  40 */     boolean selectLang = !(PATHS.local()).SETTINGS.exists("LauncherSettings");
/*  41 */     LSettings settings = new LSettings();
/*     */     
/*  43 */     if (!PATHS.PATHS_BASE.langs().existsFolder(settings.lang.get()))
/*     */     {
/*  45 */       selectLang = true;
/*     */     }
/*  47 */     CORE.init((ERROR_HANDLER)new ErrorHandler());
/*  48 */     CORE.create(new Sett());
/*  49 */     final boolean l = selectLang;
/*  50 */     CORE.start(new CORE_STATE.Constructor()
/*     */         {
/*     */           public CORE_STATE getState()
/*     */           {
/*  54 */             PreLoader.exit();
/*  55 */             return new Launcher(l);
/*     */           }
/*     */         });
/*  58 */     if (!startGame)
/*  59 */       System.exit(1); 
/*  60 */     System.exit(0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  66 */   private COORDINATE mCoo = (COORDINATE)new Coo();
/*  67 */   final LSettings s = new LSettings();
/*     */   
/*     */   private GuiSection current;
/*     */   private final ScreenMain main;
/*     */   private final ScreenSetting setts;
/*     */   private final ScreenMods mods;
/*     */   private final ScreenInfo info;
/*     */   private final ScreenLog log;
/*     */   private final ScreenLang lang;
/*     */   
/*     */   private Launcher(boolean selectLang) {
/*  78 */     PATHS.init(new String[0], (this.s.lang.get().length() > 0) ? this.s.lang.get() : null, false);
/*  79 */     D.init();
/*  80 */     (new CORE.GlJob()
/*     */       {
/*     */         public void doJob() {
/*  83 */           (new Initer()
/*     */             {
/*     */               public void createAssets() throws IOException
/*     */               {
/*  87 */                 (Launcher.null.access$0(Launcher.null.this)).res = new RES();
/*     */               }
/*  89 */             }).get("launcher", 1024, 0);
/*     */         }
/*  91 */       }).perform();
/*     */     
/*  93 */     this.g = new GUI(this.res);
/*     */     
/*  95 */     this.bg = new BG(this.res);
/*  96 */     this.log = new ScreenLog(this);
/*  97 */     this.lang = new ScreenLang(this, true);
/*  98 */     this.main = new ScreenMain(this, this.lang);
/*  99 */     this.info = new ScreenInfo(this);
/* 100 */     this.mods = new ScreenMods(this);
/* 101 */     this.setts = new ScreenSetting(this);
/* 102 */     this.current = this.main;
/*     */     
/* 104 */     if (selectLang) {
/* 105 */       this.current = new ScreenLang(this, false);
/*     */     }
/* 107 */     else if (this.s.version.get() != VERSION.VERSION) {
/* 108 */       this.s.save();
/* 109 */       this.current = this.log;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void mouseClick(MButt button) {
/* 118 */     if (button == MButt.LEFT) {
/* 119 */       this.current.click();
/* 120 */     } else if (button == MButt.RIGHT) {
/* 121 */       setMain();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void update(float ds, double slow) {
/* 127 */     this.bg.update(ds);
/* 128 */     hover((COORDINATE)CORE.getInput().getMouse().getCoo(), false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(Renderer r, float ds) {
/* 134 */     this.bg.render((SPRITE_RENDERER)r, ds);
/*     */     
/* 136 */     this.current.render((SPRITE_RENDERER)r, ds);
/* 137 */     this.bg.renderClouds((SPRITE_RENDERER)r, ds);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setInfo() {
/* 145 */     this.current = this.info;
/* 146 */     this.current.hover(this.mCoo);
/*     */   }
/*     */   
/*     */   void setMain() {
/* 150 */     this.current = this.main;
/* 151 */     this.current.hover(this.mCoo);
/*     */   }
/*     */   
/*     */   void setSetts() {
/* 155 */     this.current = this.setts;
/* 156 */     this.current.hover(this.mCoo);
/*     */   }
/*     */   
/*     */   void setMods() {
/* 160 */     this.current = this.mods;
/* 161 */     this.current.hover(this.mCoo);
/*     */   }
/*     */   
/*     */   void setLang() {
/* 165 */     this.current = this.lang;
/* 166 */     this.current.hover(this.mCoo);
/*     */   }
/*     */   
/*     */   void setModWarning() {
/* 170 */     this.current = new ScreenModWarning(this);
/* 171 */     this.current.hover(this.mCoo);
/*     */   }
/*     */   
/*     */   void setLog() {
/* 175 */     this.current = this.log;
/* 176 */     this.current.hover(this.mCoo);
/*     */   }
/*     */   
/*     */   public void hover(COORDINATE mCoo, boolean mouseHasMoved) {
/* 180 */     this.mCoo = mCoo;
/* 181 */     this.current.hover(mCoo);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void keyPush(LIST<KeyBoard.KeyEvent> keys, boolean hasCleared) {
/* 187 */     for (KeyBoard.KeyEvent c : keys) {
/* 188 */       if (CORE.getInput().getKeyboard().isPressed(341) && c.code() == 88)
/* 189 */         throw new RuntimeException("creating debugging info. Please send this to the developer if you're having issues"); 
/* 190 */       if (c.code() == 256) {
/* 191 */         startGame = false;
/* 192 */         CORE.annihilate();
/*     */         return;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\launcher\Launcher.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */