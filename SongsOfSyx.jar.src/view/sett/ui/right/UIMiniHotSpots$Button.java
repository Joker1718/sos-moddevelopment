/*     */ package view.sett.ui.right;
/*     */ 
/*     */ import settlement.tilemap.SettMarks;
/*     */ import snake2d.MButt;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import util.gui.misc.GBox;
/*     */ import view.main.VIEW;
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
/*     */ final class Button
/*     */   extends CLICKABLE.ClickableAbs
/*     */ {
/*     */   private SettMarks.SettMark d;
/*     */   
/*     */   Button(int i) {
/*  91 */     this.body.setWidth(36.0D).setHeight(32.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/*  96 */     COLOR.WHITE25.render(r, body().x1(), this.body.x2(), body().y1(), this.body.y1() + 1);
/*  97 */     UIMiniHotSpots.this.colorImp.set((COLOR)this.d.color);
/*  98 */     if (isHovered || isSelected)
/*  99 */       UIMiniHotSpots.this.colorImp.shadeSelf(1.5D); 
/* 100 */     UIMiniHotSpots.this.colorImp.render(r, body().x1(), this.body.x2(), body().y1(), this.body.y2() - 1);
/* 101 */     COLOR.WHITE25.render(r, body().x1(), this.body.x2(), body().y2() - 1, this.body.y2());
/*     */     
/* 103 */     if (isHovered || isSelected) {
/* 104 */       COLOR.WHITE15.render(r, body().x1(), body().x2(), body().y1() + 6, body().y2() - 6);
/*     */     } else {
/* 106 */       COLOR.WHITE10.render(r, body().x1(), body().x2(), body().y1() + 6, body().y2() - 6);
/*     */     } 
/* 108 */     if (this.d.name.length() > 0) {
/* 109 */       UIMiniHotSpots.this.text.clear();
/* 110 */       UIMiniHotSpots.this.text.add((CharSequence)this.d.name, 0, 2);
/* 111 */       UIMiniHotSpots.this.text.adjustWidth();
/* 112 */       UIMiniHotSpots.this.text.renderC(r, (RECTANGLE)this.body);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   void set(SettMarks.SettMark d) {
/* 118 */     this.d = d;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 123 */     if (MButt.RIGHT.isDown()) {
/* 124 */       UIMiniHotSpots.this.panel.init(this.d);
/* 125 */       (VIEW.inters()).popup.show((RENDEROBJ)UIMiniHotSpots.this.panel, (CLICKABLE)this);
/*     */     } 
/* 127 */     UIMiniHotSpots.this.window.centererTile.set((COORDINATE)this.d.tile);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 133 */     GBox b = (GBox)text;
/* 134 */     b.textLL((CharSequence)this.d.name);
/* 135 */     b.text(UIMiniHotSpots.¤¤setExp);
/* 136 */     super.hoverInfoGet(text);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\right\UIMiniHotSpots$Button.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */