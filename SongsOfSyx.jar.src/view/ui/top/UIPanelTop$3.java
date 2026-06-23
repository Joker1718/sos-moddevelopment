/*     */ package view.ui.top;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Text;
/*     */ import util.colors.GCOLOR;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   extends UIPanelTop.Butt
/*     */ {
/*     */   private Text nr;
/*     */   
/*     */   null(SPRITE $anonymous0) {
/* 186 */     super($anonymous0);
/* 187 */     this.nr = new Text((UI.FONT()).M, 10);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 192 */     if (VIEW.b().isActive())
/*     */       return; 
/* 194 */     isActive = (VIEW.messages().size() > 0);
/*     */     
/* 196 */     isSelected = VIEW.messages().activated();
/*     */     
/* 198 */     if (VIEW.messages().unread() > 0) {
/* 199 */       bg(GCOLOR.UI().goodFlash());
/* 200 */       super.render(r, ds, isActive, isSelected, isHovered);
/* 201 */       this.nr.clear().add(VIEW.messages().unread()).adjustWidth();
/* 202 */       if (!isHovered && TIME.currentSecond() - VIEW.messages().currentSecond() < 3.0D) {
/* 203 */         COLOR.WHITE2WHITE.bind();
/* 204 */         bg(COLOR.BLUE2BLUE);
/*     */       } 
/*     */ 
/*     */       
/* 208 */       int x = body().x1() + (this.body.width() - this.nr.width()) / 2;
/* 209 */       int y = body().y1() + (this.body.height() - this.nr.height()) / 2;
/*     */       
/* 211 */       COLOR.WHITE100.bind();
/* 212 */       this.nr.render(r, x - 1, y - 1);
/* 213 */       COLOR.RED50.bind();
/* 214 */       this.nr.render(r, x, y);
/* 215 */       COLOR.unbind();
/*     */     } else {
/* 217 */       bgClear();
/* 218 */       super.render(r, ds, isActive, isSelected, isHovered);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 225 */     if (!VIEW.b().isActive())
/* 226 */       (VIEW.inters()).messages.activate(); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\top\UIPanelTop$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */