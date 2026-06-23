/*     */ package util.gui.misc;
/*     */ 
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Text;
/*     */ import util.colors.GCOLOR;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Glow
/*     */   extends GButt
/*     */ {
/*     */   protected final SPRITE bg;
/* 168 */   private COLOR normal = COLOR.WHITE100;
/*     */   
/*     */   public Glow(SPRITE label) {
/* 171 */     this(label, (SPRITE)null);
/* 172 */     this.body.setHeight((this.body.height() + 6));
/* 173 */     this.body.incrW(4.0D);
/*     */   }
/*     */   
/*     */   public Glow(CharSequence text) {
/* 177 */     this((SPRITE)new Text((UI.FONT()).S, text));
/* 178 */     this.body.setHeight((this.body.height() + 6));
/*     */   }
/*     */   
/*     */   public Glow(SPRITE label, SPRITE bg) {
/* 182 */     super(label);
/* 183 */     this.body.setWidth(label.width());
/* 184 */     this.body.setHeight(label.height());
/* 185 */     if (bg != null) {
/* 186 */       if (bg.width() > this.body.width())
/* 187 */         this.body.setWidth(bg.width()); 
/* 188 */       if (bg.height() > this.body.height())
/* 189 */         this.body.setHeight(bg.height()); 
/*     */     } 
/* 191 */     this.bg = bg;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 197 */     renAction();
/* 198 */     int x = this.body.x1();
/* 199 */     int y = this.body.y1();
/* 200 */     if (this.bg != null) {
/* 201 */       this.bg.render(r, x, y);
/* 202 */       x += (this.body.width() - this.label.width()) / 2;
/*     */     } 
/*     */     
/* 205 */     if (!isActive) {
/* 206 */       (GCOLOR.T()).INACTIVE.bind();
/* 207 */     } else if (isSelected && isHovered) {
/* 208 */       (GCOLOR.T()).HOVER_SELECTED.bind();
/* 209 */     } else if (isSelected) {
/* 210 */       (GCOLOR.T()).SELECTED.bind();
/* 211 */     } else if (isHovered) {
/* 212 */       (GCOLOR.T()).HOVERED.bind();
/*     */     } else {
/* 214 */       this.normal.bind();
/* 215 */     }  y += (this.body.height() - this.label.height()) / 2;
/* 216 */     this.label.render(r, x, y);
/* 217 */     COLOR.unbind();
/*     */   }
/*     */ 
/*     */   
/*     */   public void color(COLOR color) {
/* 222 */     this.normal = color;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\gui\misc\GButt$Glow.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */