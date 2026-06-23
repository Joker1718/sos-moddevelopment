/*     */ package view.sett.ui.minimap;
/*     */ 
/*     */ import init.constant.C;
/*     */ import snake2d.MButt;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import view.interrupter.InterManager;
/*     */ import view.interrupter.Interrupter;
/*     */ import view.keyboard.KEYS;
/*     */ import view.subview.GameWindow;
/*     */ 
/*     */ public class UIMinimapSett
/*     */   extends Interrupter {
/*     */   final UIMiniMapSettView view;
/*     */   final UIMinimapPanel map;
/*     */   
/*     */   public UIMinimapSett(InterManager i, int y1, GameWindow w, UIMinimapSettConfig config) {
/*  23 */     if (config == null)
/*  24 */       config = UIMinimapSettConfig.NORMAL; 
/*  25 */     this.config = config;
/*  26 */     desturberSet().persistantSet().pin();
/*  27 */     this.view = new UIMiniMapSettView(this, i, w, config);
/*     */     
/*  29 */     this.map = new UIMinimapPanel(w, config);
/*  30 */     this.map.body().moveX2(C.WIDTH());
/*  31 */     this.map.body().moveY1(y1);
/*     */     
/*  33 */     this.buttons = new UIMinimapPanelButts(this.view, this.map, w);
/*  34 */     this.buttons.section.body().moveX2(C.WIDTH());
/*  35 */     this.buttons.section.body().moveY1(this.map.body().y2());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  42 */     update(0.0F);
/*  43 */     show(i);
/*     */   }
/*     */   private final UIMinimapPanelButts buttons; public final UIMinimapSettConfig config;
/*     */   
/*     */   public int y2() {
/*  48 */     return this.buttons.section.body().y2();
/*     */   }
/*     */ 
/*     */   
/*     */   public void add() {}
/*     */ 
/*     */   
/*     */   public void open() {
/*  56 */     this.view.showMin();
/*     */   }
/*     */   
/*     */   public boolean openIs() {
/*  60 */     return this.view.isActivated();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void hoverTimer(GBox text) {
/*  66 */     this.buttons.section.hoverInfoGet((GUI_BOX)text);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean render(Renderer r, float ds) {
/*  72 */     this.map.render((SPRITE_RENDERER)r, ds);
/*  73 */     this.buttons.section.render((SPRITE_RENDERER)r, ds);
/*     */     
/*  75 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void mouseClick(MButt button) {
/*  80 */     if (button == MButt.LEFT) {
/*  81 */       this.map.click();
/*  82 */       this.buttons.section.click();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean hover(COORDINATE mCoo, boolean mouseHasMoved) {
/*  91 */     if (this.map.hover(mCoo) || this.buttons.section.hover(mCoo))
/*  92 */       return true; 
/*  93 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean update(float ds) {
/*  99 */     if ((KEYS.MAIN()).MINIMAP.consumeClick()) {
/* 100 */       this.view.show();
/*     */     }
/* 102 */     return true;
/*     */   }
/*     */   
/*     */   public UIMinimapPanelButts panel() {
/* 106 */     return this.buttons;
/*     */   }
/*     */   
/*     */   public static class Butt
/*     */     extends GButt.ButtPanel {
/*     */     public Butt(SPRITE icon) {
/* 112 */       super(icon);
/* 113 */       setDim(30, 26);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\minimap\UIMinimapSett.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */