/*     */ package menu;
/*     */ 
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.data.INT;
/*     */ import util.gui.misc.GText;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ abstract class OptionLine
/*     */   extends GuiSection
/*     */ {
/*     */   private final CLICKABLE left;
/*     */   private final CLICKABLE right;
/* 176 */   private GText value = new GText((UI.FONT()).M, 16);
/*     */ 
/*     */   
/*     */   OptionLine(final INT.INTE ii, CharSequence l) {
/* 180 */     body().setWidth(550.0D);
/* 181 */     body().setHeight(1.0D);
/*     */ 
/*     */     
/* 184 */     GText label = new GText((UI.FONT()).H2, l);
/* 185 */     label.color(GUI.COLORS.unclickable);
/* 186 */     this.left = (CLICKABLE)new GUI.Button(GUI.getBigTexts("<<"))
/*     */       {
/*     */         protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered)
/*     */         {
/* 190 */           activeSet((ii.get() > ii.min()));
/* 191 */           super.render(r, ds, activeIs(), isSelected, isHovered);
/*     */         }
/*     */       };
/* 194 */     this.left.clickActionSet(new ACTION()
/*     */         {
/*     */           public void exe() {
/* 197 */             ii.inc(-1);
/*     */           }
/*     */         });
/*     */     
/* 201 */     add((RENDEROBJ)this.left, 275 - GUI.margin / 20 - this.left.body().width(), 0);
/*     */     
/* 203 */     this.right = (CLICKABLE)new GUI.Button(GUI.getBigTexts(">>"))
/*     */       {
/*     */         protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered)
/*     */         {
/* 207 */           activeSet((ii.get() < ii.max()));
/* 208 */           super.render(r, ds, activeIs(), isSelected, isHovered);
/*     */         }
/*     */       };
/* 211 */     this.right.clickActionSet(new ACTION()
/*     */         {
/*     */           public void exe() {
/* 214 */             ii.inc(1);
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 219 */     addRightC(GUI.margin / 10, (RENDEROBJ)this.right);
/*     */     
/* 221 */     addCentredY((SPRITE)label, this.left.body().x1() - label.width() - 7);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, float ds) {
/* 227 */     super.render(r, ds);
/*     */     
/* 229 */     Str.TMP.clear();
/* 230 */     this.value.clear();
/* 231 */     setValue(this.value);
/* 232 */     this.value.renderCY(r, this.right.body().x2() + 7, body().cY());
/* 233 */     GUI.COLORS.unclickable.bind();
/*     */     
/* 235 */     COLOR.unbind();
/*     */   }
/*     */   
/*     */   protected abstract void setValue(GText paramGText);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\menu\GUI$OptionLine.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */