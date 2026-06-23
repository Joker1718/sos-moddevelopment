/*     */ package view.world.panel;
/*     */ import game.GAME;
/*     */ import init.constant.C;
/*     */ import init.sprite.SPRITES;
/*     */ import snake2d.CORE;
/*     */ import snake2d.MButt;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.SUPER_SCREENSHOT;
/*     */ import snake2d.util.datatypes.BODY_HOLDER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.common.SuperSc;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import view.interrupter.InterManager;
/*     */ import view.interrupter.Interrupter;
/*     */ import view.keyboard.KEYS;
/*     */ import view.keyboard.KeyButt;
/*     */ import view.main.VIEW;
/*     */ import view.subview.GameWindow;
/*     */ import view.ui.top.UIPanelTop;
/*     */ import world.WORLD;
/*     */ 
/*     */ final class UIMinimap extends Interrupter {
/*  33 */   private final GuiSection buttons = new GuiSection(); private final UIMinimapW map;
/*     */   private boolean expanded = true;
/*     */   private final GameWindow window;
/*     */   
/*     */   public UIMinimap(UIPanelTop top, InterManager m, final GameWindow window, String saveKey) {
/*  38 */     this.window = window;
/*  39 */     pin();
/*  40 */     this.map = new UIMinimapW(window);
/*     */ 
/*     */ 
/*     */     
/*  44 */     if (top != null) {
/*  45 */       WorldHeatmaps worldHeatmaps = new WorldHeatmaps();
/*  46 */       this.buttons.addRight(0, (RENDEROBJ)worldHeatmaps);
/*     */     } 
/*     */     
/*  49 */     GButt.ButtPanel buttPanel4 = new GButt.ButtPanel((SPRITE)(SPRITES.icons()).s.camera)
/*     */       {
/*     */         protected void clickA() {
/*  52 */           CORE.getGraphics().makeScreenShot();
/*     */         }
/*     */       };
/*  55 */     CLICKABLE cLICKABLE3 = KeyButt.wrap((CLICKABLE)buttPanel4, (KEYS.MAIN()).SCREENSHOT);
/*  56 */     this.buttons.addRight(0, (RENDEROBJ)cLICKABLE3);
/*     */     
/*  58 */     GButt.ButtPanel buttPanel3 = new GButt.ButtPanel((SPRITE)(SPRITES.icons()).s.cameraBig, saveKey)
/*     */       {
/*     */         private final SuperSc sst;
/*     */ 
/*     */ 
/*     */         
/*     */         protected void clickA() {
/*  65 */           (VIEW.inters()).popup.show((RENDEROBJ)this.sst, (CLICKABLE)this, true);
/*     */         }
/*     */       };
/*  68 */     buttPanel3.hoverInfoSet(SuperSc.¤¤name);
/*  69 */     this.buttons.addRightC(8, (RENDEROBJ)buttPanel3);
/*     */     
/*  71 */     buttPanel3 = new GButt.ButtPanel((SPRITE)(SPRITES.icons()).s.magnifier)
/*     */       {
/*     */         protected void clickA() {
/*  74 */           if (window.zoomout() > 0) {
/*  75 */             window.setZoomout(window.zoomout() - 1);
/*     */           }
/*     */         }
/*     */         
/*     */         protected void renAction() {
/*  80 */           activeSet((window.zoomout() > 0));
/*     */         }
/*     */       };
/*  83 */     CLICKABLE cLICKABLE2 = KeyButt.wrap((CLICKABLE)buttPanel3, (KEYS.MAIN()).ZOOM_IN);
/*  84 */     this.buttons.addRightC(10, (RENDEROBJ)cLICKABLE2);
/*     */     
/*  86 */     GButt.ButtPanel buttPanel2 = new GButt.ButtPanel((SPRITE)(SPRITES.icons()).s.minifier)
/*     */       {
/*     */         protected void clickA() {
/*  89 */           if (window.zoomout() < 3) {
/*  90 */             window.setZoomout(window.zoomout() + 1);
/*     */           }
/*     */         }
/*     */         
/*     */         protected void renAction() {
/*  95 */           activeSet((window.zoomout() < 2));
/*     */         }
/*     */       };
/*  98 */     CLICKABLE cLICKABLE1 = KeyButt.wrap((CLICKABLE)buttPanel2, (KEYS.MAIN()).ZOOM_OUT);
/*  99 */     this.buttons.addRightC(0, (RENDEROBJ)cLICKABLE1);
/*     */     
/* 101 */     GButt.ButtPanel buttPanel1 = new GButt.ButtPanel((SPRITE)(SPRITES.icons()).s.arrowUp)
/*     */       {
/*     */         protected void clickA() {
/* 104 */           UIMinimap.this.expanded = !UIMinimap.this.expanded;
/*     */         }
/*     */         
/*     */         protected void renAction() {
/* 108 */           selectedSet(UIMinimap.this.expanded);
/*     */         }
/*     */       };
/* 111 */     this.buttons.addRightC(0, (RENDEROBJ)buttPanel1);
/*     */     
/* 113 */     RENDEROBJ.RenderImp renderImp = new RENDEROBJ.RenderImp(this.map.body().width(), 32)
/*     */       {
/*     */         public void render(SPRITE_RENDERER r, float ds)
/*     */         {
/* 117 */           (GCOLOR.UI()).panBG.render(r, (RECTANGLE)this.body);
/* 118 */           GCOLOR.UI().border(r, this.body.x1(), this.body.x1() + 3, this.body.y1(), this.body.y2());
/* 119 */           GCOLOR.UI().border(r, this.body.x1(), this.body.x2(), this.body.y2(), this.body.y2() + 3);
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 130 */     this.buttons.body().moveX2((C.WIDTH() - 4));
/* 131 */     this.buttons.body().moveY1(0.0D);
/* 132 */     renderImp.body().moveX2(C.WIDTH());
/* 133 */     renderImp.body().centerY((BODY_HOLDER)this.buttons);
/* 134 */     this.buttons.add((RENDEROBJ)renderImp);
/* 135 */     this.buttons.moveLastToBack();
/* 136 */     this.buttons.body().moveY1(((top == null) ? false : 51));
/*     */     
/* 138 */     this.map.body().moveY1(this.buttons.body().y2());
/* 139 */     this.map.body().moveX2(C.DIM().width());
/* 140 */     show(m);
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, GameWindow window) {
/* 145 */     this.buttons.render(r, 0.0F);
/*     */     
/* 147 */     if (!this.expanded) {
/*     */       return;
/*     */     }
/* 150 */     this.map.render(r, 0.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean hover(COORDINATE mCoo, boolean mouseHasMoved) {
/* 157 */     return this.buttons.hover(mCoo) | this.map.hover(mCoo);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void mouseClick(MButt button) {
/* 162 */     if (button != MButt.LEFT)
/*     */       return; 
/* 164 */     if (this.buttons.click())
/*     */       return; 
/* 166 */     if (this.expanded) {
/* 167 */       this.map.click();
/*     */     }
/*     */   }
/*     */   
/*     */   protected boolean render(Renderer r, float ds) {
/* 172 */     render((SPRITE_RENDERER)r, this.window);
/* 173 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean update(float ds) {
/* 179 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void hoverTimer(GBox text) {
/* 184 */     this.buttons.hoverInfoGet((GUI_BOX)text);
/*     */   }
/*     */   
/*     */   private static class Shot
/*     */     extends SUPER_SCREENSHOT {
/*     */     private final int zoomout;
/*     */     private final int winW;
/*     */     private final int winH;
/*     */     private Rec current;
/*     */     
/*     */     Shot(int scale, int zoomout) {
/* 195 */       super(scale);
/* 196 */       this.zoomout = zoomout;
/* 197 */       this.winW = C.WIDTH() << zoomout;
/* 198 */       this.winH = C.HEIGHT() << zoomout;
/* 199 */       this.current = new Rec(this.winW, this.winH);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean renderAndHasNext() {
/* 205 */       if (this.current.y1() >= WORLD.PHEIGHT()) {
/* 206 */         return false;
/*     */       }
/* 208 */       WORLD.OVERLAY().hide();
/* 209 */       boolean t = (WORLD.FOW()).toggled.is();
/* 210 */       (WORLD.FOW()).toggled.set(false);
/* 211 */       GAME.world().render(CORE.renderer(), 0.0F, this.zoomout, (RECTANGLE)this.current, 0, 0);
/* 212 */       this.current.incrX(this.winW);
/* 213 */       if (this.current.x1() >= WORLD.PWIDTH()) {
/* 214 */         this.current.incrY(this.winH);
/* 215 */         this.current.moveX1(0.0D);
/*     */       } 
/* 217 */       (WORLD.FOW()).toggled.set(t);
/* 218 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     public int getWidth() {
/* 223 */       return WORLD.PWIDTH() >> this.zoomout;
/*     */     }
/*     */ 
/*     */     
/*     */     public int getHeight() {
/* 228 */       return WORLD.PHEIGHT() >> this.zoomout;
/*     */     }
/*     */ 
/*     */     
/*     */     public void init() {
/* 233 */       this.current.set(0.0D, this.winW, 0.0D, this.winH);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\world\panel\UIMinimap.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */