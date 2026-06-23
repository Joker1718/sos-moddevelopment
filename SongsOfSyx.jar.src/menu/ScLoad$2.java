/*     */ package menu;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.save.GameLoader;
/*     */ import game.save.SaveFile;
/*     */ import init.paths.PATH;
/*     */ import init.sprite.UI.UI;
/*     */ import java.nio.file.Path;
/*     */ import snake2d.CORE_STATE;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.sprite.text.Str;
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
/*     */ class null
/*     */   extends MenuScreenLoad
/*     */ {
/*     */   null(CharSequence $anonymous0, COLOR $anonymous1, boolean $anonymous2, PATH $anonymous3) {
/*  95 */     super($anonymous0, $anonymous1, $anonymous2, $anonymous3);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void load(SaveFile f) {
/* 101 */     menu.start((CORE_STATE.Constructor)new GameLoader(f.path, new String[0])
/*     */         {
/*     */           public void doAfterSet() {
/* 104 */             GAME.achieve(false);
/* 105 */             super.doAfterSet();
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*     */   protected void back() {
/* 112 */     menu.switchScreen(menu.main);
/*     */   }
/*     */   
/*     */   protected void renderInfo(SPRITE_RENDERER r, SaveFile file, RECTANGLE body, double ds) {
/* 116 */     int y1 = renderInfoGen(r, file, body);
/* 117 */     if (file.specReady() && (file.spec()).fubar) {
/* 118 */       renderInfoProb(r, file, body.x1(), y1);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void renderName(SPRITE_RENDERER r, SaveFile s, RECTANGLE body) {
/* 125 */     (UI.FONT()).H2.render(r, s.name, body.x1() + 64, body.y1());
/*     */     
/* 127 */     (UI.icons()).s.human.renderCY(r, body.x1() + 700, body.y1() + (UI.FONT()).M.height() / 2);
/* 128 */     Str.TMP.clear().add(s.pop);
/* 129 */     (UI.FONT()).M.render(r, (CharSequence)Str.TMP, body.x1() + 720, body.y1());
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\menu\ScLoad$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */