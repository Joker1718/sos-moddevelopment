/*     */ package view.sett.ui.minimap;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import init.constant.C;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.CORE;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.light.AmbientLight;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import util.colors.GCOLOR;
/*     */ import view.main.VIEW;
/*     */ import view.subview.GameWindow;
/*     */ 
/*     */ final class UIMinimapPanel
/*     */   extends CLICKABLE.ClickableAbs
/*     */ {
/*  25 */   private final int M = 3;
/*  26 */   private final int HEIGHT = 128;
/*     */   static final int WIDTH = 256;
/*  28 */   private final Rec tiles = new Rec(250.0D, 122.0D);
/*     */   
/*  30 */   private final Rec ents = new Rec(250.0D, 122.0D);
/*     */   private final GameWindow w;
/*  32 */   private final Coo lastClick = new Coo();
/*     */   private final UIMinimapSettConfig config;
/*     */   
/*     */   public UIMinimapPanel(GameWindow w, UIMinimapSettConfig config) {
/*  36 */     this.w = w;
/*  37 */     this.config = config;
/*  38 */     this.body.setDim(256.0D, 128.0D);
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
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/*  52 */     int cx = this.w.tiles().cX();
/*  53 */     int cy = this.w.tiles().cY();
/*     */     
/*  55 */     int x1 = cx - 128;
/*  56 */     int y1 = cy - 64;
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
/*  68 */     this.tiles.moveX1Y1(x1, y1);
/*     */     
/*  70 */     this.ents.moveX1Y1(x1, y1);
/*     */     
/*  72 */     CORE.renderer().newLayer(false, 0);
/*  73 */     AmbientLight.full.register((RECTANGLE)this.body);
/*     */ 
/*     */     
/*  76 */     for (int ty = this.ents.y1(); ty < this.ents.y2(); ty++) {
/*  77 */       for (int tx = this.ents.x1(); tx < this.ents.x2(); tx++) {
/*     */         
/*  79 */         ENTITY e = SETT.ENTITIES().getAtTileSingle(tx, ty);
/*  80 */         if (e != null) {
/*  81 */           COLOR c = this.config.col(e);
/*  82 */           if (c != null) {
/*  83 */             c.bind();
/*  84 */             int x = tx - this.ents.x1() + body().x1() + 3;
/*  85 */             int y = ty - this.ents.y1() + body().y1() + 3;
/*  86 */             CORE.renderer().renderParticle(x, y);
/*     */           } 
/*     */           
/*  89 */           tx = tx + 4 & 0xFFFFFFFC;
/*     */         } 
/*     */       } 
/*     */     } 
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
/* 105 */     COLOR.unbind();
/*     */     
/* 107 */     CORE.renderer().newLayer(true, 0);
/* 108 */     SETT.MINIMAP().render(r, body().x1() + 3, body().y1() + 3, (RECTANGLE)this.tiles);
/* 109 */     this.config.shade().bind();
/* 110 */     COLOR.BLACK.render(r, (RECTANGLE)this.body);
/* 111 */     OPACITY.unbind();
/*     */ 
/*     */     
/* 114 */     int w = this.w.tiles().width();
/* 115 */     int h = this.w.tiles().height();
/*     */ 
/*     */ 
/*     */     
/* 119 */     x1 = CLAMP.i(cx - w / 2 + body().x1() + 3 - this.tiles.x1(), body().x1() + 3, body().x2() - 3);
/* 120 */     y1 = CLAMP.i(cy - h / 2 + body().y1() + 3 - this.tiles.y1(), body().y1() + 3, body().y2() - 3);
/* 121 */     int x2 = CLAMP.i(x1 + w, body().x1() + 3, body().x2() - 3);
/* 122 */     int y2 = CLAMP.i(y1 + h, body().y1() + 3, body().y2() - 3);
/*     */     
/* 124 */     OPACITY.O25.bind();
/* 125 */     COLOR.WHITE100.render(r, x1, x2, y1, y2);
/* 126 */     OPACITY.unbind();
/*     */     
/* 128 */     CORE.renderer().newLayer(false, 0);
/*     */ 
/*     */     
/* 131 */     TIME.light().applyGuiLight(ds, C.DIM());
/* 132 */     GCOLOR.UI().borderH(r, (RECTANGLE)body(), 0);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 137 */     if (visableIs()) {
/* 138 */       int tx = VIEW.mouse().x() - 3 - body().x1() + this.tiles.x1();
/* 139 */       int ty = VIEW.mouse().y() - 3 - body().y1() + this.tiles.y1();
/* 140 */       this.w.centerAtTile(tx, ty);
/* 141 */       this.lastClick.set((COORDINATE)VIEW.mouse());
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\minimap\UIMinimapPanel.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */