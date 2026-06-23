/*     */ package menu;
/*     */ 
/*     */ import game.save.GameLoader;
/*     */ import game.save.SaveFile;
/*     */ import init.paths.PATH;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.CORE_STATE;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import util.gui.misc.GText;
/*     */ import view.menu.MenuScreenLoad;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends MenuScreenLoad
/*     */ {
/*     */   GText t;
/*     */   
/*     */   null(CharSequence $anonymous0, COLOR $anonymous1, boolean $anonymous2, PATH $anonymous3) {
/* 137 */     super($anonymous0, $anonymous1, $anonymous2, $anonymous3);
/*     */     
/* 139 */     this.t = new GText((UI.FONT()).M, 128);
/*     */     
/* 141 */     this.t.setMaxWidth(800);
/* 142 */     this.t.setMultipleLines(true);
/*     */   }
/*     */   
/*     */   protected void load(SaveFile f) {
/* 146 */     menu.start((CORE_STATE.Constructor)new GameLoader(f.path, new String[0]));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void back() {
/* 151 */     menu.switchScreen(menu.main);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void renderInfo(SPRITE_RENDERER r, SaveFile file, RECTANGLE body, double ds) {
/* 156 */     this.t.set((file.spec()).desc);
/* 157 */     this.t.renderC(r, body);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void renderName(SPRITE_RENDERER r, SaveFile s, RECTANGLE body) {
/* 164 */     (UI.FONT()).H2.render(r, s.name, body.x1() + 64, body.y1() + (UI.FONT()).M.height() / 2);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\menu\ScLoad$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */