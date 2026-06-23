/*     */ package view.ui.advice;
/*     */ 
/*     */ import settlement.stats.POP;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import view.main.VIEW;
/*     */ import view.ui.message.MessageText;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends GButt.ButtPanel
/*     */ {
/*     */   null(SPRITE $anonymous0) {
/* 162 */     super($anonymous0);
/*     */   }
/*     */   
/*     */   protected void clickA() {
/* 166 */     (VIEW.inters()).popup.show((RENDEROBJ)a, (CLICKABLE)this);
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 171 */     GBox b = (GBox)text;
/*     */     
/* 173 */     b.title(UIAdvice.¤¤name);
/* 174 */     for (UIAdvice.Entry e : a.all) {
/* 175 */       if (e.toggled() && 
/* 176 */         e.is()) {
/* 177 */         b.error((CharSequence)e.bad);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 190 */     super.render(r, ds, isActive, isSelected, isHovered);
/* 191 */     if (UIAdvice.silence)
/*     */       return; 
/* 193 */     boolean has = false;
/* 194 */     for (UIAdvice.Entry e : a.all) {
/* 195 */       if (e.toggled() && e.is()) {
/*     */         
/* 197 */         OPACITY.O25TO100.bind();
/* 198 */         COLOR.REDISH.renderFrame(r, (RECTANGLE)this.body, -4, 4);
/*     */ 
/*     */ 
/*     */         
/* 202 */         OPACITY.unbind();
/* 203 */         has = true;
/*     */         break;
/*     */       } 
/*     */     } 
/* 207 */     if (has && POP.pop() > 500 && 
/* 208 */       !a.hasAdvice) {
/* 209 */       a.hasAdvice = true;
/* 210 */       (new MessageText(UIAdvice.¤¤mAdvice, UIAdvice.¤¤mAdviceD)).send();
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 216 */     UIAdvice.sendResettle(a);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\advice\UIAdvice$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */