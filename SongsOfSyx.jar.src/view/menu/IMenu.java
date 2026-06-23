/*     */ package view.menu;
/*     */ 
/*     */ import game.GAME;
/*     */ import init.constant.C;
/*     */ import init.sprite.UI.UI;
/*     */ import menu.Menu;
/*     */ import snake2d.CORE;
/*     */ import snake2d.CORE_STATE;
/*     */ import snake2d.MButt;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.BODY_HOLDER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Font;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import view.interrupter.InterManager;
/*     */ import view.interrupter.Interrupter;
/*     */ import view.keyboard.KEYS;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ 
/*     */ public class IMenu
/*     */   extends Interrupter
/*     */ {
/*     */   private final GuiSection main;
/*     */   private final GuiSection options;
/*     */   private final ScKeys keys;
/*  37 */   private static CharSequence ¤¤resume = "resume"; private GuiSection current; private final Font big; private final Font small; private final InterManager manager;
/*  38 */   private static CharSequence ¤¤quicksave = "quick-save";
/*  39 */   private static CharSequence ¤¤saveFirst = "save first?";
/*  40 */   private static CharSequence ¤¤options = "options";
/*  41 */   private static CharSequence ¤¤quitMenu = "quit to menu";
/*  42 */   private static CharSequence ¤¤exit = "exit";
/*  43 */   private static CharSequence ¤¤THEMENU = "THE MENU";
/*     */   
/*     */   static {
/*  46 */     D.ts(IMenu.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public IMenu(InterManager manager) {
/*  51 */     this.manager = manager;
/*  52 */     pin().desturberSet();
/*  53 */     this.big = (UI.FONT()).H1;
/*  54 */     this.small = (UI.FONT()).H2;
/*  55 */     this.keys = new ScKeys(this, this.big, this.small);
/*  56 */     this.main = new GuiSection()
/*     */       {
/*     */         public boolean click()
/*     */         {
/*  60 */           return super.click();
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  67 */     GButt.Glow glow = new GButt.Glow(this.big.getText(¤¤resume));
/*  68 */     glow.clickActionSet(new ACTION()
/*     */         {
/*     */           public void exe() {
/*  71 */             IMenu.this.hide();
/*     */           }
/*     */         });
/*  74 */     this.main.addDownC(10, (RENDEROBJ)glow);
/*     */     
/*  76 */     glow = new GButt.Glow(this.big.getText(¤¤quicksave))
/*     */       {
/*     */         protected void renAction()
/*     */         {
/*  80 */           activeSet(VIEW.canSave());
/*     */         }
/*     */ 
/*     */         
/*     */         protected void clickA() {
/*  85 */           GAME.saver().quicksave();
/*  86 */           IMenu.this.hide();
/*     */         }
/*     */       };
/*     */     
/*  90 */     this.main.addDownC(6, (RENDEROBJ)glow);
/*     */     
/*  92 */     glow = new GButt.Glow(this.big.getText(Dic.¤¤save))
/*     */       {
/*     */         protected void renAction() {
/*  95 */           activeSet(VIEW.canSave());
/*     */         }
/*     */ 
/*     */         
/*     */         protected void clickA() {
/* 100 */           IMenu.this.current = new IMenuSave(IMenu.this, IMenu.this.big, IMenu.this.small, null);
/*     */         }
/*     */       };
/* 103 */     this.main.addDownC(6, (RENDEROBJ)glow);
/*     */     
/* 105 */     glow = new GButt.Glow(this.big.getText(Dic.¤¤load));
/* 106 */     glow.clickActionSet(new ACTION() {
/* 107 */           IMenuLoad i = new IMenuLoad(IMenu.this);
/*     */           
/*     */           public void exe() {
/* 110 */             this.i.init();
/* 111 */             IMenu.this.current = this.i;
/*     */           }
/*     */         });
/* 114 */     this.main.addDownC(6, (RENDEROBJ)glow);
/*     */     
/* 116 */     glow = new GButt.Glow(this.big.getText(¤¤options));
/* 117 */     glow.clickActionSet(new ACTION()
/*     */         {
/*     */           public void exe() {
/* 120 */             IMenu.this.current = IMenu.this.options;
/*     */           }
/*     */         });
/* 123 */     this.main.addDownC(6, (RENDEROBJ)glow);
/*     */     
/* 125 */     glow = new GButt.Glow(this.big.getText(this.keys.¤¤nameBig));
/* 126 */     glow.clickActionSet(new ACTION()
/*     */         {
/*     */           public void exe() {
/* 129 */             IMenu.this.current = IMenu.this.keys.activate();
/*     */           }
/*     */         });
/* 132 */     this.main.addDownC(6, (RENDEROBJ)glow);
/*     */     
/* 134 */     final ACTION exit2Menu = new ACTION()
/*     */       {
/*     */         public void exe() {
/* 137 */           IMenu.this.exit2Menu();
/*     */         }
/*     */       };
/* 140 */     final ACTION exit = new ACTION()
/*     */       {
/*     */         public void exe() {
/* 143 */           CORE.annihilate();
/*     */         }
/*     */       };
/*     */     
/* 147 */     glow = new GButt.Glow(this.big.getText(¤¤quitMenu));
/* 148 */     glow.clickActionSet(new ACTION()
/*     */         {
/*     */           public void exe()
/*     */           {
/* 152 */             if (GAME.saver().getTimeSinceLastSave() < 5.0D || !VIEW.canSave()) {
/* 153 */               IMenu.this.exit2Menu();
/*     */             }
/*     */             
/* 156 */             GButt.Glow glow1 = new GButt.Glow(IMenu.this.big.getText(Dic.¤¤Yes));
/* 157 */             glow1.clickActionSet(new ACTION()
/*     */                 {
/*     */                   public void exe() {
/* 160 */                     (IMenu.null.access$0(IMenu.null.this)).current = new IMenuSave(IMenu.null.access$0(IMenu.null.this), (IMenu.null.access$0(IMenu.null.this)).big, (IMenu.null.access$0(IMenu.null.this)).small, exit2Menu);
/*     */                   }
/*     */                 });
/* 163 */             GButt.Glow glow2 = new GButt.Glow(IMenu.this.big.getText(Dic.¤¤No));
/* 164 */             glow2.clickActionSet(exit2Menu);
/*     */             
/* 166 */             (VIEW.inters()).fullScreen.activate(IMenu.¤¤saveFirst, COLOR.WHITE100, null, new GButt[] { (GButt)glow1, (GButt)glow2 });
/*     */           }
/*     */         });
/* 169 */     this.main.addDownC(6, (RENDEROBJ)glow);
/*     */     
/* 171 */     glow = new GButt.Glow(this.big.getText(¤¤exit));
/* 172 */     glow.clickActionSet(new ACTION()
/*     */         {
/*     */           public void exe()
/*     */           {
/* 176 */             if (!VIEW.canSave()) {
/* 177 */               exit.exe();
/*     */               
/*     */               return;
/*     */             } 
/* 181 */             if (GAME.saver().getTimeSinceLastSave() < 5.0D) {
/* 182 */               CORE.annihilate();
/*     */             }
/*     */             
/* 185 */             GButt.Glow glow1 = new GButt.Glow(IMenu.this.big.getText(Dic.¤¤Yes));
/* 186 */             glow1.clickActionSet(new ACTION()
/*     */                 {
/*     */                   public void exe() {
/* 189 */                     (IMenu.null.access$0(IMenu.null.this)).current = new IMenuSave(IMenu.null.access$0(IMenu.null.this), (IMenu.null.access$0(IMenu.null.this)).big, (IMenu.null.access$0(IMenu.null.this)).small, exit);
/*     */                   }
/*     */                 });
/* 192 */             GButt.Glow glow2 = new GButt.Glow(IMenu.this.big.getText(Dic.¤¤No));
/* 193 */             glow2.clickActionSet(exit);
/*     */             
/* 195 */             (VIEW.inters()).fullScreen.activate(IMenu.¤¤saveFirst, COLOR.WHITE100, null, new GButt[] { (GButt)glow1, (GButt)glow2 });
/*     */           }
/*     */         });
/* 198 */     this.main.addDownC(6, (RENDEROBJ)glow);
/*     */     
/* 200 */     this.main.body().centerIn(C.DIM());
/*     */     
/* 202 */     this.main.add(UI.decor().frame((RECTANGLE)this.main.body()));
/* 203 */     this.main.moveLastToBack();
/*     */ 
/*     */     
/* 206 */     RENDEROBJ o = UI.decor().getDecored(¤¤THEMENU);
/* 207 */     o.body().centerX((BODY_HOLDER)this.main);
/* 208 */     o.body().moveY2(this.main.body().y1());
/* 209 */     this.main.add(o);
/*     */ 
/*     */     
/* 212 */     this.current = this.main;
/*     */     
/* 214 */     this.options = new IMenuOptions(this, this.big, this.small);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void exit2Menu() {
/* 221 */     CORE.setCurrentState(new CORE_STATE.Constructor()
/*     */         {
/*     */           public CORE_STATE getState() {
/* 224 */             return (CORE_STATE)Menu.make();
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public void show() {
/* 230 */     show(this.manager);
/* 231 */     setMain();
/*     */   }
/*     */   
/*     */   void setMain() {
/* 235 */     this.current = this.main;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean hover(COORDINATE mCoo, boolean mouseHasMoved) {
/* 240 */     this.current.hover(mCoo);
/* 241 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void hoverTimer(GBox text) {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean render(Renderer r, float ds) {
/* 252 */     this.current.render((SPRITE_RENDERER)r, ds);
/* 253 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void mouseClick(MButt button) {
/* 258 */     if (button == MButt.LEFT) {
/* 259 */       this.current.click();
/* 260 */     } else if (button == MButt.RIGHT) {
/* 261 */       if (this.current != this.main) {
/* 262 */         this.current = this.main;
/*     */       } else {
/* 264 */         hide();
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   protected boolean update(float ds) {
/* 270 */     if ((KEYS.MAIN()).ESCAPE.consumeClick())
/* 271 */       hide(); 
/* 272 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\menu\IMenu.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */