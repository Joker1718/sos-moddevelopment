/*     */ package view.sett.ui.right;
/*     */ 
/*     */ import init.constant.C;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.INT;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.table.GScrollRows;
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
/*     */ class Mini
/*     */   extends GuiSection
/*     */ {
/*     */   private final INT.INTE t;
/*     */   
/*     */   Mini(int y1) {
/*  86 */     RENDEROBJ row = UIMiniResources.mini((RESOURCE)RESOURCES.ALL().get(0));
/*  87 */     int width = row.body().width();
/*  88 */     body().moveY1(y1);
/*  89 */     int cats = 0;
/*  90 */     for (RESOURCE r : RESOURCES.ALL()) {
/*  91 */       if (r.category > cats)
/*  92 */         cats = r.category; 
/*     */     } 
/*  94 */     LinkedList<RENDEROBJ> rows = new LinkedList();
/*     */     
/*  96 */     int cat = ((RESOURCE)RESOURCES.ALL().get(0)).category;
/*     */     
/*  98 */     for (RESOURCE r : RESOURCES.ALL()) {
/*  99 */       if (r.category != cat) {
/* 100 */         rows.add(new RENDEROBJ.RenderImp(width, 16)
/*     */             {
/*     */               public void render(SPRITE_RENDERER r, float ds) {
/* 103 */                 GCOLOR.UI().borderH(r, body().x1() + 4, body().x2() - 4, body().y1() + 7, body().y1() + 10);
/*     */               }
/*     */             });
/* 106 */         cat = r.category;
/*     */       } 
/*     */       
/* 109 */       rows.add(UIMiniResources.mini(r));
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 115 */     body().setDim((width + 6), (C.HEIGHT() - y1));
/*     */ 
/*     */     
/* 118 */     y1 += 4;
/*     */     
/* 120 */     GButt.Glow glow = new GButt.Glow((UI.decor()).up)
/*     */       {
/*     */         protected void renAction() {
/* 123 */           activeSet((UIMiniResources.Mini.this.t.get() > 0));
/*     */         }
/*     */         
/*     */         protected void clickA() {
/* 127 */           UIMiniResources.Mini.this.t.inc(-1);
/*     */         }
/*     */       };
/* 130 */     glow.body().moveCX((body().cX() + 2));
/* 131 */     glow.body().moveY1(y1);
/* 132 */     add((RENDEROBJ)glow);
/*     */ 
/*     */     
/* 135 */     GScrollRows sc = new GScrollRows((Iterable)rows, C.HEIGHT() - getLastY2() - glow.body().height() - 8, 0, false);
/* 136 */     addDownC(0, (RENDEROBJ)sc.view());
/*     */     
/* 138 */     this.t = sc.target;
/*     */     
/* 140 */     glow = new GButt.Glow((UI.decor()).down)
/*     */       {
/*     */         protected void renAction() {
/* 143 */           activeSet((UIMiniResources.Mini.this.t.get() != UIMiniResources.Mini.this.t.max()));
/*     */         }
/*     */         
/*     */         protected void clickA() {
/* 147 */           UIMiniResources.Mini.this.t.inc(1);
/*     */         }
/*     */       };
/* 150 */     addDownC(4, (RENDEROBJ)glow);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\right\UIMiniResources$Mini.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */