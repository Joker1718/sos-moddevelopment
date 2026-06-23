/*     */ package menu;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.VERSION;
/*     */ import game.battle.state.BattleState;
/*     */ import game.battle.state.BattleStateExiter;
/*     */ import game.battle.state.BattleStateResult;
/*     */ import game.save.GameLoader;
/*     */ import init.constant.C;
/*     */ import init.paths.PATHS;
/*     */ import init.settings.S;
/*     */ import init.sprite.UI.UI;
/*     */ import java.nio.file.Path;
/*     */ import snake2d.CORE;
/*     */ import snake2d.CORE_STATE;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GText;
/*     */ import util.text.D;
/*     */ import view.main.VIEW;
/*     */ import view.menu.MenuScreenLoad;
/*     */ import world.battle.spec.BATTLE_RESULT;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class ScMain
/*     */   implements SC
/*     */ {
/*     */   private final GuiSection first;
/*     */   private final GuiSection play;
/*     */   private final GuiSection load;
/*     */   private GuiSection current;
/*     */   private final RENDEROBJ.Sprite logo;
/*     */   private final Menu menu;
/*  42 */   private final GText version = new GText((UI.FONT()).H2, VERSION.VERSION_STRING);
/*     */   
/*     */   ScMain(Menu menu) {
/*  45 */     D.t(this);
/*  46 */     this.menu = menu;
/*  47 */     this.first = getFirst(menu);
/*  48 */     this.play = getPlay(menu);
/*  49 */     this.play.body().moveY1(this.first.body().y1());
/*  50 */     this.load = getLoad(menu);
/*  51 */     this.load.body().moveY1(this.first.body().y1());
/*     */     
/*  53 */     this.logo = new RENDEROBJ.Sprite((menu.res.s()).logo);
/*  54 */     this.logo.body().moveX2(GUI.left.x2());
/*  55 */     this.logo.body().centerY(GUI.left);
/*  56 */     this.logo.setColor(GUI.COLORS.menu);
/*     */ 
/*     */ 
/*     */     
/*  60 */     this.current = this.first;
/*     */   }
/*     */ 
/*     */   
/*  64 */   private static CharSequence ¤¤continue = "continue";
/*  65 */   private static CharSequence ¤¤quit = "quit";
/*  66 */   private static CharSequence ¤¤play = "play";
/*  67 */   private static CharSequence ¤¤editor = "editor";
/*  68 */   private static CharSequence ¤¤battle = "quick battle";
/*  69 */   private static CharSequence ¤¤load = "load";
/*  70 */   private static CharSequence ¤¤loadB = "debug battle";
/*  71 */   private static CharSequence ¤¤tutorial = "tutorial";
/*     */   
/*     */   static {
/*  74 */     D.ts(ScMain.class);
/*     */   }
/*     */ 
/*     */   
/*     */   private GuiSection getFirst(final Menu menu) {
/*  79 */     GuiSection current = new GuiSection();
/*     */ 
/*     */     
/*  82 */     CLICKABLE text = GUI.getNavButt(¤¤play);
/*  83 */     text.clickActionSet(new ACTION()
/*     */         {
/*     */           public void exe() {
/*  86 */             ScMain.this.switchNavigator(ScMain.this.play);
/*     */           }
/*     */         });
/*  89 */     current.addDown(0, (RENDEROBJ)text);
/*     */     
/*  91 */     if (!menu.load.hasSaves()) {
/*  92 */       GUI.Button button = new GUI.Button((UI.FONT()).H1.getText(¤¤tutorial))
/*     */         {
/*     */           protected void clickA()
/*     */           {
/*  96 */             menu.switchScreen(menu.campaigns);
/*     */           }
/*     */         };
/*  99 */       current.addDown(8, (RENDEROBJ)button);
/*     */     } else {
/*     */       
/* 102 */       GUI.Button button = new GUI.Button((UI.FONT()).H1.getText(¤¤continue))
/*     */         {
/*     */           protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered)
/*     */           {
/* 106 */             activeSet(menu.load.hasSaves());
/* 107 */             super.render(r, ds, isActive, isSelected, isHovered);
/*     */           }
/*     */ 
/*     */           
/*     */           protected void clickA() {
/* 112 */             if (menu.load.hasSaves())
/* 113 */               menu.load.loadSave(); 
/*     */           }
/*     */         };
/* 116 */       current.addDown(8, (RENDEROBJ)button);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 121 */     text = GUI.getNavButt(ScOptions.¤¤name);
/* 122 */     text.clickActionSet(new ACTION()
/*     */         {
/*     */           public void exe() {
/* 125 */             menu.switchScreen(menu.options);
/*     */           }
/*     */         });
/* 128 */     current.addDown(8, (RENDEROBJ)text);
/*     */     
/* 130 */     text = GUI.getNavButt(ScCredits.¤¤name);
/* 131 */     text.clickActionSet(new ACTION()
/*     */         {
/*     */           public void exe() {
/* 134 */             menu.switchScreen(menu.credits);
/*     */           }
/*     */         });
/* 137 */     current.addDown(8, (RENDEROBJ)text);
/*     */     
/* 139 */     text = GUI.getNavButt(¤¤quit);
/* 140 */     text.clickActionSet(new ACTION()
/*     */         {
/*     */           public void exe() {
/* 143 */             CORE.annihilate();
/*     */           }
/*     */         });
/* 146 */     current.addDown(8, (RENDEROBJ)text);
/*     */     
/* 148 */     current.body().moveX1(GUI.right.x1());
/* 149 */     current.body().centerY(GUI.right.y1(), GUI.right.y2());
/*     */     
/* 151 */     return current;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private GuiSection getLoad(final Menu menu) {
/* 157 */     GuiSection current = new GuiSection();
/*     */ 
/*     */ 
/*     */     
/* 161 */     CLICKABLE text = GUI.getNavButt(MenuScreenLoad.¤¤name);
/* 162 */     text.clickActionSet(new ACTION()
/*     */         {
/*     */           public void exe() {
/* 165 */             menu.switchScreen(menu.load);
/*     */           }
/*     */         });
/* 168 */     current.addDown(0, (RENDEROBJ)text);
/*     */     
/* 170 */     if ((S.get()).developer && PATHS.local().save().exists(BattleState.debugLoad)) {
/* 171 */       text = GUI.getNavButt(¤¤loadB);
/* 172 */       text.clickActionSet(new ACTION()
/*     */           {
/*     */             public void exe() {
/* 175 */               menu.start((CORE_STATE.Constructor)new GameLoader(PATHS.local().save().get(BattleState.debugLoad), new String[0])
/*     */                   {
/*     */                     public void doAfterSet()
/*     */                     {
/* 179 */                       BattleState.setLoaded(new BattleStateExiter()
/*     */                           {
/*     */                             public void afterExit(BattleStateResult res) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */                             
/*     */                             public void exit(BATTLE_RESULT res, int plosses, int elosses) {
/* 188 */                               CORE.setCurrentState(new CORE_STATE.Constructor()
/*     */                                   {
/*     */                                     public CORE_STATE getState() {
/* 191 */                                       return Menu.make();
/*     */                                     }
/*     */                                   }, 
/*     */                                 );
/*     */                             }
/* 196 */                           },  this.saveFile, true);
/*     */                     }
/*     */                   });
/*     */             }
/*     */           });
/*     */       
/* 202 */       current.addDown(8, (RENDEROBJ)text);
/*     */     }  byte b; int i;
/*     */     ScLoad[] arrayOfScLoad;
/* 205 */     for (i = (arrayOfScLoad = menu.loads).length, b = 0; b < i; ) { final ScLoad l = arrayOfScLoad[b];
/* 206 */       text = GUI.getNavButt(l.name);
/* 207 */       text.clickActionSet(new ACTION()
/*     */           {
/*     */             public void exe() {
/* 210 */               menu.switchScreen(l);
/*     */             }
/*     */           });
/* 213 */       if (!l.hasSaves())
/* 214 */         text.activeSet(false); 
/* 215 */       current.addDown(8, (RENDEROBJ)text);
/*     */       b++; }
/*     */     
/* 218 */     text = GUI.getBackArrow();
/* 219 */     text.clickActionSet(new ACTION()
/*     */         {
/*     */           public void exe() {
/* 222 */             ScMain.this.switchNavigator(ScMain.this.play);
/*     */           }
/*     */         });
/* 225 */     current.addDown(10, (RENDEROBJ)text);
/*     */     
/* 227 */     current.body().moveX1(GUI.right.x1());
/* 228 */     current.body().centerY(GUI.right);
/*     */     
/* 230 */     return current;
/*     */   }
/*     */ 
/*     */   
/*     */   private GuiSection getPlay(final Menu menu) {
/* 235 */     GuiSection current = new GuiSection();
/*     */ 
/*     */ 
/*     */     
/* 239 */     CLICKABLE text = GUI.getNavButt(¤¤load);
/* 240 */     text.clickActionSet(new ACTION()
/*     */         {
/*     */           public void exe() {
/* 243 */             ScMain.this.switchNavigator(ScMain.this.load);
/*     */           }
/*     */         });
/* 246 */     current.addDown(0, (RENDEROBJ)text);
/*     */     
/* 248 */     text = GUI.getNavButt(ScCampaign.¤¤name);
/* 249 */     text.clickActionSet(new ACTION()
/*     */         {
/*     */           public void exe() {
/* 252 */             menu.switchScreen(menu.campaigns);
/*     */           }
/*     */         });
/*     */     
/* 256 */     current.addDown(8, (RENDEROBJ)text);
/*     */     
/* 258 */     text = GUI.getNavButt(ScRandom.¤¤name);
/* 259 */     text.clickActionSet(new ACTION()
/*     */         {
/*     */           public void exe() {
/* 262 */             menu.switchScreen(menu.sandbox2);
/*     */           }
/*     */         });
/* 265 */     current.addDown(8, (RENDEROBJ)text);
/*     */     
/* 267 */     text = GUI.getNavButt(¤¤battle);
/* 268 */     text.clickActionSet(new ACTION()
/*     */         {
/*     */           public void exe() {
/* 271 */             menu.start(new CORE_STATE.Constructor()
/*     */                 {
/*     */                   public CORE_STATE getState()
/*     */                   {
/* 275 */                     VIEW vIEW = GAME.create(new String[0]);
/*     */                     
/* 277 */                     (VIEW.b()).editor.activate();
/*     */                     
/* 279 */                     return (CORE_STATE)vIEW;
/*     */                   }
/*     */                 });
/*     */           }
/*     */         });
/* 284 */     current.addDown(8, (RENDEROBJ)text);
/*     */     
/* 286 */     text = GUI.getNavButt(¤¤editor);
/* 287 */     text.clickActionSet(new ACTION()
/*     */         {
/*     */           public void exe() {
/* 290 */             menu.start(new CORE_STATE.Constructor()
/*     */                 {
/*     */                   public CORE_STATE getState()
/*     */                   {
/* 294 */                     VIEW vIEW = GAME.create(new String[0]);
/*     */                     
/* 296 */                     (VIEW.world()).editor.activate();
/*     */                     
/* 298 */                     return (CORE_STATE)vIEW;
/*     */                   }
/*     */                 });
/*     */           }
/*     */         });
/* 303 */     current.addDown(8, (RENDEROBJ)text);
/*     */     
/* 305 */     text = GUI.getBackArrow();
/* 306 */     text.clickActionSet(new ACTION()
/*     */         {
/*     */           public void exe() {
/* 309 */             ScMain.this.switchNavigator(ScMain.this.first);
/*     */           }
/*     */         });
/* 312 */     current.addDown(10, (RENDEROBJ)text);
/*     */     
/* 314 */     current.body().moveX1(GUI.right.x1());
/* 315 */     current.body().centerY(GUI.right);
/*     */     
/* 317 */     return current;
/*     */   }
/*     */   
/*     */   private void switchNavigator(GuiSection section) {
/* 321 */     this.current = section;
/* 322 */     this.current.hover((COORDINATE)this.menu.getMCoo());
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, float ds) {
/* 327 */     this.logo.render(r, ds);
/* 328 */     this.current.render(r, ds);
/* 329 */     this.version.render(r, C.DIM().x2() - 32 - this.version.width(), 32);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hover(COORDINATE mCoo) {
/* 334 */     return this.current.hover(mCoo);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean click() {
/* 339 */     return this.current.click();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean back(Menu menu) {
/* 344 */     if (this.current == this.load) {
/* 345 */       switchNavigator(this.play);
/* 346 */       return true;
/*     */     } 
/* 348 */     if (this.current != this.first) {
/* 349 */       switchNavigator(this.first);
/* 350 */       return true;
/*     */     } 
/* 352 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\menu\ScMain.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */