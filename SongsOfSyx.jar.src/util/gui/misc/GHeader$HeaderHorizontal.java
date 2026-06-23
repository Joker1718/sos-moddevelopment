/*     */ package util.gui.misc;
/*     */ 
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.common.TITLEABLE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class HeaderHorizontal
/*     */   extends GHeader
/*     */ {
/*     */   private final SPRITE s;
/*     */   private final int fixedWidth;
/*     */   
/*     */   public HeaderHorizontal(CharSequence name, SPRITE s) {
/* 130 */     super(name, (s.height() <= 16) ? (UI.FONT()).S : (UI.FONT()).H2);
/* 131 */     this.s = s;
/* 132 */     this.body.setHeight(((this.text.height() > s.height()) ? this.text.height() : s.height()));
/* 133 */     this.body.setWidth((this.text.width() + 6 + s.width()));
/* 134 */     this.fixedWidth = -1;
/*     */   }
/*     */   
/*     */   public HeaderHorizontal(SPRITE name, SPRITE s) {
/* 138 */     super(name);
/* 139 */     this.s = s;
/* 140 */     this.body.setHeight(((this.text.height() > s.height()) ? this.text.height() : s.height()));
/* 141 */     this.body.setWidth((this.text.width() + 6 + s.width()));
/* 142 */     this.fixedWidth = -1;
/*     */   }
/*     */   
/*     */   public HeaderHorizontal(CharSequence name, SPRITE s, int width) {
/* 146 */     super(name, (s.height() <= 16) ? (UI.FONT()).S : (UI.FONT()).H2);
/* 147 */     this.s = s;
/* 148 */     this.body.setHeight(((this.text.height() > s.height()) ? this.text.height() : s.height()));
/* 149 */     this.body.setWidth((width + s.width()));
/* 150 */     this.fixedWidth = width;
/*     */   }
/*     */   
/*     */   public HeaderHorizontal(SPRITE name, SPRITE s, int width) {
/* 154 */     super(name);
/* 155 */     this.s = s;
/* 156 */     this.body.setHeight(((this.text.height() > s.height()) ? this.text.height() : s.height()));
/* 157 */     this.body.setWidth((width + 32));
/* 158 */     this.fixedWidth = width;
/*     */   }
/*     */   
/*     */   public HeaderHorizontal(CharSequence name, GStat s) {
/* 162 */     this((s.statText.getFont() == (UI.FONT()).M) ? (SPRITE)(new GText((UI.FONT()).H2, name)).lablify() : (SPRITE)(new GText((UI.FONT()).H2, name)).lablify(), (SPRITE)s);
/*     */   }
/*     */   
/*     */   public HeaderHorizontal(CharSequence name, GStat s, int width) {
/* 166 */     this((s.statText.getFont() == (UI.FONT()).M) ? (SPRITE)(new GText((UI.FONT()).H2, name)).lablify() : (SPRITE)(new GText((UI.FONT()).H2, name)).lablify(), (SPRITE)s, width);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/* 171 */     if (this.fixedWidth == -1) {
/* 172 */       this.body.setWidth((this.text.width() + 6 + this.s.width()));
/*     */     }
/* 174 */     int dy = (this.body.height() - this.text.height()) / 2;
/* 175 */     this.text.render(r, this.body.x1(), this.body.y1() + dy);
/* 176 */     dy = (this.body.height() - this.s.height()) / 2;
/* 177 */     int x1 = body().x1();
/* 178 */     if (this.fixedWidth == -1) {
/* 179 */       this.body.setWidth((6 + this.text.width() + this.s.width()));
/* 180 */       x1 += 6 + this.text.width();
/*     */     } else {
/* 182 */       this.body.setWidth((this.fixedWidth + this.s.width()));
/* 183 */       x1 += this.fixedWidth;
/*     */     } 
/*     */     
/* 186 */     this.s.render(r, x1, this.body.y1() + dy);
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 191 */     if (this.s instanceof TITLEABLE)
/* 192 */       ((TITLEABLE)this.s).hoverInfoGet((GBox)text); 
/* 193 */     super.hoverInfoGet(text);
/*     */   }
/*     */   
/*     */   public HeaderHorizontal increaseWidth(int am) {
/* 197 */     this.body.incrW(am);
/* 198 */     return this;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\gui\misc\GHeader$HeaderHorizontal.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */