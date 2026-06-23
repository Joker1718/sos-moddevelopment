/*     */ package view.sett.ui.bottom;
/*     */ 
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.BODY_HOLDER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
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
/*     */ class Holder
/*     */   extends CLICKABLE.ClickableAbs
/*     */ {
/*     */   private final CLICKABLE other;
/*     */   private final String name;
/*     */   
/*     */   Holder(CLICKABLE other, CharSequence name) {
/* 139 */     this.body.set((BODY_HOLDER)other);
/* 140 */     this.other = other;
/* 141 */     this.name = String.valueOf(name).toUpperCase();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 147 */     int x1 = this.other.body().x1();
/* 148 */     int y1 = this.other.body().y1();
/* 149 */     this.other.body().moveX1Y1(body().x1(), body().y1());
/* 150 */     this.other.render(r, ds);
/* 151 */     this.other.body().moveX1Y1(x1, y1);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hover(COORDINATE mCoo) {
/* 156 */     int x1 = this.other.body().x1();
/* 157 */     int y1 = this.other.body().y1();
/* 158 */     this.other.body().moveX1Y1(body().x1(), body().y1());
/* 159 */     this.other.hover(mCoo);
/* 160 */     this.other.body().moveX1Y1(x1, y1);
/* 161 */     return super.hover(mCoo);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean click() {
/* 166 */     if (super.click()) {
/* 167 */       (VIEW.inters()).popup.close();
/* 168 */       this.other.click();
/* 169 */       return true;
/*     */     } 
/* 171 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 176 */     this.other.hoverInfoGet(text);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\bottom\SearchToolPanel$Holder.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */