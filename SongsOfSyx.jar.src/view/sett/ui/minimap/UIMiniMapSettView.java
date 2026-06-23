/*     */ package view.sett.ui.minimap;
/*     */ import game.GAME;
/*     */ import init.constant.C;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.MButt;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import util.gui.misc.GBox;
/*     */ import view.interrupter.InterManager;
/*     */ import view.interrupter.Interrupter;
/*     */ import view.keyboard.KEYS;
/*     */ import view.subview.GameWindow;
/*     */ 
/*     */ final class UIMiniMapSettView extends Interrupter {
/*  22 */   private final Rec absBounds = new Rec(C.DIM());
/*     */   
/*  24 */   private final GuiSection ss = new GuiSection();
/*  25 */   private final GameWindow window = (new GameWindow(C.DIM(), SETT.PIXEL_BOUNDS, 0)).setzoomoutMax(6);
/*     */   
/*     */   boolean hovered = false;
/*     */   
/*     */   private final UIMiniMapSettViewMap mini;
/*     */   
/*     */   private final GameWindow c;
/*     */   private final InterManager manager;
/*     */   
/*     */   public UIMiniMapSettView(UIMinimapSett m, InterManager i, GameWindow w, UIMinimapSettConfig config) {
/*  35 */     this.manager = i;
/*  36 */     persistantSet();
/*  37 */     int zoomout = 4;
/*  38 */     while (SETT.PIXEL_BOUNDS.width() >> zoomout > C.WIDTH() || SETT.PIXEL_BOUNDS.height() >> zoomout > C.HEIGHT())
/*  39 */       zoomout++; 
/*  40 */     if (zoomout > 6)
/*  41 */       zoomout = 6; 
/*  42 */     this.c = w;
/*  43 */     this.mini = new UIMiniMapSettViewMap(config);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  48 */     this.window.setZoomout(4);
/*  49 */     this.window.setzoomoutMax(zoomout);
/*     */ 
/*     */     
/*  52 */     config.addButtons(this.ss, w, m);
/*  53 */     this.ss.body().moveY1(30.0D);
/*  54 */     this.ss.body().moveX2((C.WIDTH() - 50));
/*     */   }
/*     */ 
/*     */   
/*     */   public void addButt(CLICKABLE c) {
/*  59 */     this.ss.addRightC(0, (RENDEROBJ)c);
/*  60 */     this.ss.body().moveY1(30.0D);
/*  61 */     this.ss.body().moveX2((C.WIDTH() - 50));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void hoverTimer(GBox text) {
/*  66 */     this.ss.hoverInfoGet((GUI_BOX)text);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean render(Renderer r, float ds) {
/*  71 */     this.ss.render((SPRITE_RENDERER)r, ds);
/*  72 */     this.mini.render(r, ds, this.window, (RECTANGLE)this.absBounds, (COORDINATE)this.window.pixel(), this.hovered);
/*  73 */     this.hovered = false;
/*     */     
/*  75 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void showMin() {
/*  80 */     this.window.setZoomout(4);
/*  81 */     show();
/*     */   }
/*     */ 
/*     */   
/*     */   public void show() {
/*  86 */     if (this.window.zoomout() < 4) {
/*  87 */       this.window.setZoomout(4);
/*  88 */       hide();
/*     */     } 
/*  90 */     this.window.setFromOther(this.c);
/*     */     
/*  92 */     show(this.manager);
/*     */   }
/*     */   
/*     */   public void showFull() {
/*  96 */     this.window.setZoomout(this.window.zoomoutmax());
/*  97 */     this.window.centerAt(this.c.pixels().cX(), this.c.pixels().cY());
/*  98 */     up();
/*     */     
/* 100 */     show(this.manager);
/*     */   }
/*     */ 
/*     */   
/*     */   public void hide() {
/* 105 */     super.hide();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void mouseClick(MButt button) {
/* 111 */     if (button == MButt.LEFT) {
/* 112 */       if (this.hovered) {
/* 113 */         this.window.zoomByMouse(4);
/* 114 */         this.c.setFromOther(this.window);
/* 115 */         hide();
/*     */       } else {
/* 117 */         this.ss.click();
/*     */       }
/*     */     
/* 120 */     } else if (button == MButt.RIGHT) {
/* 121 */       hide();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean hover(COORDINATE mCoo, boolean mouseHasMoved) {
/* 128 */     this.ss.hover(mCoo);
/* 129 */     this.hovered = (this.window.pixel().isWithinRec(SETT.PIXEL_BOUNDS) && !this.ss.hoveredIs());
/* 130 */     if (!this.ss.hoveredIs()) {
/* 131 */       this.window.hover();
/*     */     }
/* 133 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void deactivateAction() {}
/*     */ 
/*     */ 
/*     */   
/*     */   private void up() {
/* 143 */     this.mini.update();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean update(float ds) {
/* 150 */     if (this.window.zoomout() < 4) {
/* 151 */       this.c.setFromOther(this.window);
/* 152 */       hide();
/*     */     } 
/*     */     
/* 155 */     if ((KEYS.MAIN()).MINIMAP.consumeClick()) {
/* 156 */       hide();
/* 157 */       return true;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 163 */     GAME.SPEED.poll();
/*     */     
/* 165 */     this.window.update(ds);
/* 166 */     up();
/*     */     
/* 168 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\minimap\UIMiniMapSettView.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */