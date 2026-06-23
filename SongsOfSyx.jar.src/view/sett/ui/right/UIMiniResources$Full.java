/*     */ package view.sett.ui.right;
/*     */ 
/*     */ import init.constant.C;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.BODY_HOLDER;
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
/*     */ class Full
/*     */   extends GuiSection
/*     */ {
/*     */   private final INT.INTE t;
/*     */   
/*     */   Full(int y1) {
/* 162 */     RENDEROBJ row = UIMiniResources.big((RESOURCE)RESOURCES.ALL().get(0));
/* 163 */     int width = row.body().width() * 2;
/* 164 */     body().setDim((width + 6), (C.HEIGHT() - y1));
/* 165 */     body().moveY1(y1);
/* 166 */     int cats = 0;
/* 167 */     for (RESOURCE r : RESOURCES.ALL()) {
/* 168 */       if (r.category > cats)
/* 169 */         cats = r.category; 
/*     */     } 
/* 171 */     LinkedList<RENDEROBJ> rows = new LinkedList();
/*     */     
/* 173 */     GuiSection s = null;
/* 174 */     int cat = ((RESOURCE)RESOURCES.ALL().get(0)).category;
/*     */     
/* 176 */     for (RESOURCE r : RESOURCES.ALL()) {
/* 177 */       if (r.category != cat) {
/* 178 */         rows.add(new RENDEROBJ.RenderImp(width, 16)
/*     */             {
/*     */               public void render(SPRITE_RENDERER r, float ds) {
/* 181 */                 GCOLOR.UI().borderH(r, body().x1() + 4, body().x2() - 4, body().y1() + 7, body().y1() + 10);
/*     */               }
/*     */             });
/* 184 */         s = new GuiSection();
/* 185 */         rows.add(s);
/* 186 */         cat = r.category;
/*     */       } 
/*     */       
/* 189 */       if (s == null || s.elements().size() >= 2) {
/* 190 */         s = new GuiSection();
/* 191 */         rows.add(s);
/*     */       } 
/*     */       
/* 194 */       s.addRightC(0, UIMiniResources.big(r));
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
/* 206 */     y1 += 4;
/*     */     
/* 208 */     GButt.Glow glow = new GButt.Glow((UI.decor()).up)
/*     */       {
/*     */         protected void renAction() {
/* 211 */           activeSet((UIMiniResources.Full.this.t.get() > 0));
/*     */         }
/*     */         
/*     */         protected void clickA() {
/* 215 */           UIMiniResources.Full.this.t.inc(-1);
/*     */         }
/*     */       };
/*     */     
/* 219 */     glow.body().centerX((BODY_HOLDER)this);
/* 220 */     glow.body().moveY1(y1);
/* 221 */     add((RENDEROBJ)glow);
/*     */ 
/*     */     
/* 224 */     GScrollRows sc = new GScrollRows((Iterable)rows, C.HEIGHT() - getLastY2() - glow.body().height() - 6, 0, false);
/* 225 */     addDownC(0, (RENDEROBJ)sc.view());
/*     */     
/* 227 */     this.t = sc.target;
/*     */     
/* 229 */     glow = new GButt.Glow((UI.decor()).down)
/*     */       {
/*     */         protected void renAction() {
/* 232 */           activeSet((UIMiniResources.Full.this.t.get() != UIMiniResources.Full.this.t.max()));
/*     */         }
/*     */         
/*     */         protected void clickA() {
/* 236 */           UIMiniResources.Full.this.t.inc(1);
/*     */         }
/*     */       };
/* 239 */     addDownC(4, (RENDEROBJ)glow);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\right\UIMiniResources$Full.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */