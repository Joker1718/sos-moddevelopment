/*     */ package view.ui.top;
/*     */ import game.GAME;
/*     */ import game.battle.div.Div;
/*     */ import game.time.TIME;
/*     */ import init.constant.C;
/*     */ import init.constant.Config;
/*     */ import init.settings.S;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.MButt;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.color.OpacityImp;
/*     */ import snake2d.util.datatypes.BODY_HOLDER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Text;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import view.interrupter.InterManager;
/*     */ import view.interrupter.Interrupter;
/*     */ import view.keyboard.KEYS;
/*     */ import view.keyboard.KeyButt;
/*     */ import view.keyboard.KeyPage;
/*     */ import view.main.VIEW;
/*     */ import view.ui.advice.UIAdvice;
/*     */ import view.ui.log.UILog;
/*     */ import world.WORLD;
/*     */ 
/*     */ public class UIPanelTop extends Interrupter {
/*  45 */   public static final int WIDTH = C.WIDTH();
/*     */   
/*     */   public static final int HEIGHT = 51;
/*  48 */   private final GuiSection section = new GuiSection();
/*     */   private final GuiSection time;
/*  50 */   private final GuiSection right = new GuiSection();
/*     */   
/*     */   private final GuiSection noti;
/*  53 */   private static CharSequence ¤¤bView = "Toggle Battle Mode";
/*     */   
/*     */   static {
/*  56 */     D.ts(UIPanelTop.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public UIPanelTop(InterManager manager) {
/*  61 */     this(manager, false, false);
/*     */   }
/*     */ 
/*     */   
/*     */   public UIPanelTop(InterManager manager, boolean battleview, boolean battle) {
/*  66 */     pin();
/*  67 */     this.section.body().setDim(WIDTH, 51.0D);
/*  68 */     this.section.body().moveX2(C.WIDTH());
/*  69 */     this.section.body().moveY1(0.0D);
/*     */     
/*  71 */     this.time = SPRITES.specials().buildTimeThing(battleview);
/*  72 */     this.time.body().centerX((RECTANGLE)this.section.body());
/*  73 */     this.time.body().moveY1((battleview ? 6 : false));
/*     */ 
/*     */     
/*  76 */     if (!battleview && !battle) {
/*  77 */       this.noti = new UINotifications();
/*     */     } else {
/*     */       
/*  80 */       this.noti = new GuiSection();
/*     */     } 
/*  82 */     this.right.addRightC(0, sep());
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  87 */     this.right.addRightC(0, (RENDEROBJ)(new Butt((SPRITE)(SPRITES.icons()).l.book, 18)
/*     */         {
/*     */           public void clickA() {
/*  90 */             (VIEW.UI()).wiki.activate();
/*     */           }
/*  92 */         }).hoverInfoSet(WIKI.¤¤name));
/*  93 */     this.right.addRightC(0, (RENDEROBJ)(new Butt((SPRITE)(SPRITES.icons()).l.menu, 18)
/*     */         {
/*     */           public void clickA() {
/*  96 */             (VIEW.inters()).menu.show();
/*     */           }
/*  98 */         }).hoverInfoSet(Dic.¤¤Menu));
/*     */     
/* 100 */     this.right.body().centerIn((BODY_HOLDER)this.section);
/* 101 */     this.right.body().moveX2((C.WIDTH() - 4));
/* 102 */     this.right.body().moveY1(1.0D);
/*     */     
/* 104 */     this.section.add((RENDEROBJ)this.right);
/*     */     
/* 106 */     this.noti.body().moveX1Y1((C.DIM().width() / 2 + 100), 51.0D);
/*     */     
/* 108 */     show(manager);
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
/*     */   public boolean render(Renderer r, float ds) {
/* 121 */     manager().viewPort().moveY1(this.section.body().y2());
/* 122 */     if (manager().viewPort().y2() > C.HEIGHT()) {
/* 123 */       manager().viewPort().setHeight((C.HEIGHT() - this.section.body().height()));
/*     */     }
/*     */     
/* 126 */     (GCOLOR.UI()).panBG.render((SPRITE_RENDERER)r, (RECTANGLE)this.section.body());
/* 127 */     this.section.render((SPRITE_RENDERER)r, ds);
/* 128 */     GCOLOR.UI().border((SPRITE_RENDERER)r, 0, C.WIDTH(), this.section.body().y2() - 3, this.section.body().y2());
/*     */     
/* 130 */     this.time.render((SPRITE_RENDERER)r, ds);
/* 131 */     this.noti.render((SPRITE_RENDERER)r, ds);
/* 132 */     return true;
/*     */   }
/*     */   
/*     */   public void hide(boolean yes) {
/* 136 */     this.section.visableSet(yes);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean hover(COORDINATE mCoo, boolean mouseHasMoved) {
/* 141 */     return !((this.section.hover(mCoo) | this.time.hover(mCoo) | this.noti.hover(mCoo)) == 0 && !mCoo.touchesRec((BODY_HOLDER)this.section));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void mouseClick(MButt button) {
/* 146 */     if (button == MButt.LEFT) {
/* 147 */       this.section.click();
/* 148 */       this.time.click();
/* 149 */       this.noti.click();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void hoverTimer(GBox text) {
/* 155 */     this.section.hoverInfoGet((GUI_BOX)text);
/* 156 */     this.time.hoverInfoGet((GUI_BOX)text);
/* 157 */     this.noti.hoverInfoGet((GUI_BOX)text);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean update(float ds) {
/* 163 */     return true;
/*     */   }
/*     */   
/*     */   public static int y2() {
/* 167 */     return 46;
/*     */   }
/*     */   
/*     */   public static class Butt
/*     */     extends GButt.ButtPanel {
/*     */     public Butt(SPRITE label) {
/* 173 */       super(label);
/* 174 */       this.body.setHeight(51.0D);
/* 175 */       this.body.setWidth(36.0D);
/*     */     }
/*     */     
/*     */     public Butt(SPRITE label, int px) {
/* 179 */       super(label);
/* 180 */       this.body.setHeight(51.0D);
/* 181 */       this.body.setWidth((36 + px));
/*     */     }
/*     */   }
/*     */   
/*     */   public static CLICKABLE messages() {
/* 186 */     Butt butt = new Butt((SPRITE)(SPRITES.icons()).m.openscroll) {
/* 187 */         private Text nr = new Text((UI.FONT()).M, 10);
/*     */ 
/*     */ 
/*     */         
/*     */         protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 192 */           if (VIEW.b().isActive())
/*     */             return; 
/* 194 */           isActive = (VIEW.messages().size() > 0);
/*     */           
/* 196 */           isSelected = VIEW.messages().activated();
/*     */           
/* 198 */           if (VIEW.messages().unread() > 0) {
/* 199 */             bg(GCOLOR.UI().goodFlash());
/* 200 */             super.render(r, ds, isActive, isSelected, isHovered);
/* 201 */             this.nr.clear().add(VIEW.messages().unread()).adjustWidth();
/* 202 */             if (!isHovered && TIME.currentSecond() - VIEW.messages().currentSecond() < 3.0D) {
/* 203 */               COLOR.WHITE2WHITE.bind();
/* 204 */               bg(COLOR.BLUE2BLUE);
/*     */             } 
/*     */ 
/*     */             
/* 208 */             int x = body().x1() + (this.body.width() - this.nr.width()) / 2;
/* 209 */             int y = body().y1() + (this.body.height() - this.nr.height()) / 2;
/*     */             
/* 211 */             COLOR.WHITE100.bind();
/* 212 */             this.nr.render(r, x - 1, y - 1);
/* 213 */             COLOR.RED50.bind();
/* 214 */             this.nr.render(r, x, y);
/* 215 */             COLOR.unbind();
/*     */           } else {
/* 217 */             bgClear();
/* 218 */             super.render(r, ds, isActive, isSelected, isHovered);
/*     */           } 
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected void clickA() {
/* 225 */           if (!VIEW.b().isActive())
/* 226 */             (VIEW.inters()).messages.activate(); 
/*     */         }
/*     */       };
/* 229 */     butt.hoverInfoSet(Dic.¤¤Messages);
/* 230 */     return (CLICKABLE)butt;
/*     */   }
/*     */ 
/*     */   
/*     */   public static CLICKABLE advice() {
/* 235 */     GButt.ButtPanel b = UIAdvice.make();
/* 236 */     b.setDim(36, 51);
/* 237 */     return (CLICKABLE)b;
/*     */   }
/*     */   
/*     */   public void addLeft(GuiSection s) {
/* 241 */     s.body().moveX1(4.0D);
/* 242 */     s.body().centerY((RECTANGLE)this.section.body());
/* 243 */     this.section.add((RENDEROBJ)s);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addRight(GuiSection s) {
/* 253 */     s.body().moveX1((this.time.body().x2() + 32));
/* 254 */     s.body().centerY((RECTANGLE)this.section.body());
/* 255 */     this.section.add((RENDEROBJ)s);
/*     */   }
/*     */ 
/*     */   
/*     */   public void addRightRight(GuiSection s) {
/* 260 */     s.body().moveX2(this.right.body().x1());
/* 261 */     s.body().centerY((RECTANGLE)this.right.body());
/* 262 */     dev(s);
/* 263 */     this.right.addRelBody(0, DIR.W, (RENDEROBJ)s);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static RENDEROBJ sep() {
/* 269 */     return (RENDEROBJ)new RENDEROBJ.RenderImp(12, 38)
/*     */       {
/*     */         public void render(SPRITE_RENDERER r, float ds)
/*     */         {
/* 273 */           GCOLOR.UI().border().render(r, body().cX() - 1, body().cX(), body().y1(), body().y2());
/* 274 */           COLOR.WHITE05.render(r, body().cX(), body().cX() + 1, body().y1(), body().y2());
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   public static RENDEROBJ bToggle() {
/* 281 */     final ACTION a = new ACTION()
/*     */       {
/*     */         public void exe()
/*     */         {
/* 285 */           if (VIEW.s().isActive()) {
/* 286 */             (VIEW.s()).battle.activate();
/* 287 */           } else if ((VIEW.s()).battle.isActive()) {
/* 288 */             VIEW.s().activate();
/*     */           } 
/*     */         }
/*     */       };
/* 292 */     final OpacityImp opa = new OpacityImp(0);
/* 293 */     ColorImp colorImp1 = (new ColorImp(47, 20, 0)).shadeSelf(1.2D);
/* 294 */     final ColorImp active = new ColorImp(127, 40, 20);
/*     */     
/* 296 */     CLICKABLE c = (new GButt.ButtPanel((SPRITE)(SPRITES.icons()).l.battle) {
/* 297 */         int di = 0;
/*     */         boolean blink = false;
/*     */         boolean nextBlink = false;
/*     */         
/*     */         protected void clickA() {
/* 302 */           a.exe();
/*     */         }
/*     */ 
/*     */         
/*     */         protected void renAction() {
/* 307 */           selectedSet((VIEW.s()).battle.isActive());
/*     */         }
/*     */ 
/*     */         
/*     */         public void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 312 */           super.render(r, ds, isActive, isSelected, isHovered);
/*     */           
/* 314 */           if (this.di >= (Config.battle()).DIVISIONS_PER_ARMY) {
/* 315 */             this.blink = this.nextBlink;
/* 316 */             this.nextBlink = false;
/* 317 */             this.di = 0;
/*     */           } 
/*     */           
/* 320 */           if (((Div)GAME.ARMIES().player().divisions().get(this.di)).men() > 0 && ((Div)GAME.ARMIES().player().divisions().get(this.di)).settings().mustering()) {
/* 321 */             this.blink = true;
/* 322 */             this.nextBlink = true;
/*     */           } 
/*     */           
/* 325 */           this.di++;
/*     */           
/* 327 */           if (this.blink || (!isHovered && !isSelected && GAME.ARMIES().enemy().men() > 0) || SETT.INVADOR().invading()) {
/* 328 */             opa.set(0.25D + VIEW.renderSecond() % 0.75D);
/* 329 */             opa.bind();
/* 330 */             active.render(r, (RECTANGLE)this.body, -3);
/* 331 */             OPACITY.unbind();
/*     */           }
/*     */         
/*     */         }
/* 335 */       }).setDim(40, 48).bg((COLOR)colorImp1).hoverInfoSet(Dic.¤¤Battle);
/*     */     
/* 337 */     c = KeyButt.wrap(a, c, (KeyPage)KEYS.MAIN(), "enablebattle", ¤¤bView, ¤¤bView, 340, 66);
/*     */     
/* 339 */     return (RENDEROBJ)c;
/*     */   }
/*     */ 
/*     */   
/*     */   public static RENDEROBJ wLog() {
/* 344 */     Butt b = new Butt((SPRITE)(SPRITES.icons()).m.factions) {
/* 345 */         int current = WORLD.LOG().all().size();
/*     */ 
/*     */         
/*     */         protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 349 */           if (VIEW.b().isActive())
/*     */             return; 
/* 351 */           isActive = (WORLD.LOG().all().size() > this.current);
/*     */           
/* 353 */           isSelected = (VIEW.UI()).log.isActivated();
/* 354 */           super.render(r, ds, isActive, isSelected, isHovered);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected void clickA() {
/* 360 */           if (!VIEW.b().isActive()) {
/* 361 */             (VIEW.UI()).log.activate();
/* 362 */             this.current = WORLD.LOG().all().size();
/*     */           } 
/*     */         }
/*     */       };
/* 366 */     b.setDim(40, 48);
/* 367 */     b.hoverInfoSet(UILog.¤¤name);
/* 368 */     return (RENDEROBJ)b;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static RENDEROBJ vToggle() {
/* 374 */     final ColorImp cw = new ColorImp(0, 47, 20);
/* 375 */     final ColorImp cc = new ColorImp(0, 47, 47);
/*     */     
/* 377 */     final ACTION a = new ACTION()
/*     */       {
/*     */         public void exe()
/*     */         {
/* 381 */           if (VIEW.s().isActive()) {
/* 382 */             VIEW.world().activate();
/* 383 */           } else if (VIEW.world().isActive()) {
/* 384 */             VIEW.s().activate();
/*     */           } 
/*     */         }
/*     */       };
/* 388 */     Butt b = new Butt((SPRITE)(SPRITES.icons()).l.city, 18)
/*     */       {
/*     */         protected void clickA() {
/* 391 */           a.exe();
/*     */         }
/*     */ 
/*     */         
/*     */         protected void renAction() {
/* 396 */           replaceLabel(VIEW.s().isActive() ? (SPRITE)(SPRITES.icons()).l.world : (SPRITE)(SPRITES.icons()).l.city, DIR.C);
/* 397 */           bg(VIEW.s().isActive() ? cc : cw);
/* 398 */           selectedSet(false);
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/* 404 */     CLICKABLE c = KeyButt.wrap((CLICKABLE)b, (KEYS.MAIN()).SWAP);
/* 405 */     return (RENDEROBJ)c;
/*     */   }
/*     */   
/*     */   public static RENDEROBJ junk() {
/* 409 */     return (RENDEROBJ)(VIEW.UI()).manager.butt();
/*     */   }
/*     */   
/*     */   private void dev(GuiSection s) {
/* 413 */     if ((S.get()).developer)
/* 414 */       s.addRelBody(0, DIR.W, (RENDEROBJ)(new Butt((SPRITE)(SPRITES.icons()).s.cog)
/*     */           {
/*     */             protected void clickA() {
/* 417 */               (VIEW.inters()).debugpanel.show();
/*     */             }
/*     */ 
/*     */ 
/*     */             
/*     */             protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 423 */               selectedSet((VIEW.inters()).debugpanel.isActivated());
/* 424 */               super.render(r, ds, isActive, isSelected, isHovered);
/*     */             }
/* 426 */           }).hoverInfoSet("developer-tools")); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\top\UIPanelTop.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */