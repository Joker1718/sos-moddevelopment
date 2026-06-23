/*     */ package view.menu;
/*     */ 
/*     */ import game.VERSION;
/*     */ import game.save.SaveFile;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.clickable.Scrollable;
/*     */ import snake2d.util.sprite.text.Font;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ abstract class Savebutt
/*     */   extends CLICKABLE.ClickableAbs
/*     */   implements Scrollable.ScrollRow
/*     */ {
/* 272 */   private static GText version = new GText((UI.FONT()).M, 16);
/* 273 */   int index = -1;
/*     */   
/*     */   public Savebutt() {
/* 276 */     this.body.setWidth(1000.0D);
/* 277 */     this.body.setHeight(28.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   public void init(int index) {
/* 282 */     this.index = index;
/*     */   }
/*     */   
/*     */   private Font font() {
/* 286 */     return (UI.FONT()).H2;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 292 */     SaveFile s = save(this.index);
/*     */     
/* 294 */     if (s == null) {
/*     */       return;
/*     */     }
/* 297 */     version.clear();
/* 298 */     version.add(VERSION.versionMajor(s.version));
/* 299 */     version.add('.');
/* 300 */     version.add(VERSION.versionMinor(s.version));
/* 301 */     if (71 != VERSION.versionMajor(s.version)) {
/* 302 */       COLOR.RED100.bind();
/* 303 */     } else if (s.problem() != null) {
/* 304 */       COLOR.YELLOW100.bind();
/*     */     }
/* 306 */     else if (selected(this.index)) {
/* 307 */       (GCOLOR.T()).SELECTED.bind();
/* 308 */     } else if (isHovered) {
/* 309 */       (GCOLOR.T()).HOVERED.bind();
/*     */     } 
/*     */     
/* 312 */     font().render(r, (CharSequence)version, body().x1(), body().y1());
/*     */     
/* 314 */     if (selected(this.index)) {
/* 315 */       (GCOLOR.T()).SELECTED.bind();
/* 316 */     } else if (isHovered) {
/* 317 */       (GCOLOR.T()).HOVERED.bind();
/*     */     } else {
/* 319 */       (GCOLOR.T()).CLICKABLE.bind();
/*     */     } 
/*     */     
/* 322 */     font().render(r, s.name, body().x1() + 60, body().y1());
/*     */ 
/*     */     
/* 325 */     version.clear().add('p').s();
/* 326 */     GFORMAT.i(version, s.pop);
/* 327 */     font().render(r, (CharSequence)version, body().x1() + 740, body().y1());
/*     */     
/* 329 */     font().render(r, s.ago, body().x1() + 820, body().y1());
/* 330 */     COLOR.unbind();
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 335 */     SaveFile s = save(this.index);
/* 336 */     if (s != null) {
/* 337 */       CharSequence p = s.problem();
/* 338 */       if (p != null)
/* 339 */         ((GBox)text).error(p); 
/*     */     } 
/*     */   }
/*     */   
/*     */   protected abstract boolean selected(int paramInt);
/*     */   
/*     */   protected abstract SaveFile save(int paramInt);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\menu\IMenuSave$Savebutt.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */