/*     */ package view.menu;
/*     */ 
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.Scrollable;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import view.keyboard.KEYS;
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
/*     */ class Row
/*     */   extends GuiSection
/*     */   implements Scrollable.ScrollRow
/*     */ {
/*     */   private final ScKeys.KeyCode a;
/*     */   private final ScKeys.KeyCode b;
/*     */   
/*     */   Row() {
/* 161 */     this.a = new ScKeys.KeyCode(paramScKeys);
/* 162 */     this.b = new ScKeys.KeyCode(paramScKeys);
/* 163 */     add((RENDEROBJ)this.a);
/* 164 */     addRightC(20, (RENDEROBJ)this.b);
/*     */   }
/*     */ 
/*     */   
/*     */   public void init(int index) {
/* 169 */     this.a.init(index);
/* 170 */     this.b.init((int)(Math.ceil(((KeyPage)KEYS.pages().get(ScKeys.this.page)).all().size() / 2.0D) + index));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\menu\ScKeys$Row.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */