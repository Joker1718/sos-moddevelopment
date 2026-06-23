/*     */ package view.menu;
/*     */ 
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.colors.GCOLOR;
/*     */ import view.keyboard.KEYS;
/*     */ import view.keyboard.Key;
/*     */ import view.keyboard.KeyPage;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class KeyCode
/*     */   extends CLICKABLE.ClickableAbs
/*     */ {
/*     */   private Key key;
/*     */   
/*     */   protected KeyCode() {
/* 181 */     this.body.setWidth(550.0D);
/* 182 */     this.body.setHeight((UI.FONT()).M.height());
/* 183 */     visableSet(false);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 188 */     if (this.key.rebindable) {
/* 189 */       KEYS.bind(this.key);
/*     */     }
/* 191 */     super.clickA();
/*     */   }
/*     */   
/*     */   void init(int i) {
/* 195 */     if (i < ((KeyPage)KEYS.pages().get(ScKeys.this.page)).all().size()) {
/* 196 */       visableSet(true);
/* 197 */       this.key = (Key)((KeyPage)KEYS.pages().get(ScKeys.this.page)).all().get(i);
/*     */     } else {
/* 199 */       visableSet(false);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hover(COORDINATE mCoo) {
/* 205 */     if (super.hover(mCoo)) {
/* 206 */       ScKeys.this.hoveredKey = this.key;
/* 207 */       return true;
/*     */     } 
/* 209 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 216 */     Str.TMP.clear();
/* 217 */     Str.TMP.add(this.key.name);
/*     */     
/* 219 */     isActive &= this.key.rebindable;
/*     */     
/* 221 */     if (!isActive) {
/* 222 */       (GCOLOR.T()).INACTIVE.bind();
/* 223 */     } else if (isHovered && isSelected) {
/* 224 */       (GCOLOR.T()).HOVER_SELECTED.bind();
/* 225 */     } else if (isHovered) {
/* 226 */       (GCOLOR.T()).HOVERED.bind();
/* 227 */     } else if (isSelected) {
/* 228 */       (GCOLOR.T()).SELECTED.bind();
/*     */     } else {
/* 230 */       (GCOLOR.T()).CLICKABLE.bind();
/* 231 */     }  (UI.FONT()).M.render(r, (CharSequence)Str.TMP, body().x1(), body().y1());
/* 232 */     (UI.FONT()).M.render(r, this.key.repr(), body().x1() + 200, body().y1());
/* 233 */     COLOR.unbind();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\menu\ScKeys$KeyCode.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */