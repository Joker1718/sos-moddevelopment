/*     */ package view.ui.message;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Text;
/*     */ import util.gui.misc.GButt;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends GButt.Panel
/*     */ {
/*     */   private Text nr;
/*     */   
/*     */   null(SPRITE $anonymous0) {
/* 198 */     super($anonymous0);
/* 199 */     this.nr = new Text((UI.FONT()).M, 10);
/*     */   }
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 203 */     isActive = (Messages.this.all.size() > 0);
/* 204 */     activeSet(isActive);
/* 205 */     isSelected = Messages.this.list.isActivated();
/* 206 */     super.render(r, ds, isActive, isSelected, isHovered);
/*     */     
/* 208 */     if (Messages.this.unread > 0 && Messages.this.all.size() > 0) {
/* 209 */       this.nr.clear().add(Messages.this.unread).adjustWidth();
/* 210 */       if (!isHovered && TIME.currentSecond() - ((Message)Messages.this.all.last()).currentSecond < 3.0D) {
/* 211 */         COLOR.WHITE2WHITE.bind();
/* 212 */         int i = body().x1() + (this.body.width() - 24) / 2;
/* 213 */         int j = body().y1() + (this.body.height() - 24) / 2;
/* 214 */         (SPRITES.icons()).m.openscroll.render(r, i, j);
/*     */       } 
/*     */       
/* 217 */       int x = body().x1() + (this.body.width() - this.nr.width()) / 2;
/* 218 */       int y = body().y1() + (this.body.height() - this.nr.height()) / 2;
/* 219 */       COLOR.WHITE100.bind();
/* 220 */       this.nr.render(r, x - 1, y - 1);
/* 221 */       COLOR.RED50.bind();
/* 222 */       this.nr.render(r, x, y);
/* 223 */       COLOR.unbind();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 229 */     if (Messages.this.all.size() > 0)
/* 230 */       Messages.this.list.act(); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\message\Messages$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */