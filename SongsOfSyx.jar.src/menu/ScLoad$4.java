/*     */ package menu;
/*     */ 
/*     */ import game.battle.state.BattleState;
/*     */ import game.battle.state.BattleStateExiter;
/*     */ import game.battle.state.BattleStateResult;
/*     */ import game.save.GameLoader;
/*     */ import game.save.SaveFile;
/*     */ import init.paths.PATH;
/*     */ import init.sprite.UI.UI;
/*     */ import java.nio.file.Path;
/*     */ import snake2d.CORE;
/*     */ import snake2d.CORE_STATE;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import util.gui.misc.GText;
/*     */ import view.menu.MenuScreenLoad;
/*     */ import world.battle.spec.BATTLE_RESULT;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 174 */     super($anonymous0, $anonymous1, $anonymous2, $anonymous3);
/* 175 */     this.t = new GText((UI.FONT()).M, 128);
/*     */     
/* 177 */     this.t.setMaxWidth(800);
/* 178 */     this.t.setMultipleLines(true);
/*     */   }
/*     */   
/*     */   protected void load(final SaveFile f) {
/* 182 */     menu.start((CORE_STATE.Constructor)new GameLoader(f.path, new String[0])
/*     */         {
/*     */           public void doAfterSet() {
/* 185 */             super.doAfterSet();
/* 186 */             BattleState.setLoaded(new BattleStateExiter()
/*     */                 {
/*     */                   public void exit(BATTLE_RESULT res, int plosses, int elosses)
/*     */                   {
/* 190 */                     CORE.setCurrentState(new CORE_STATE.Constructor()
/*     */                         {
/*     */                           public CORE_STATE getState() {
/* 193 */                             return Menu.make();
/*     */                           }
/*     */                         },  );
/*     */                   }
/*     */ 
/*     */ 
/*     */ 
/*     */                   
/*     */                   public void afterExit(BattleStateResult res) {}
/* 202 */                 },  f.path, true);
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void renderInfo(SPRITE_RENDERER r, SaveFile file, RECTANGLE body, double ds) {
/* 210 */     this.t.clear().add((file.spec()).population).s().add('V').add('s').s().add((file.spec()).enemies);
/* 211 */     this.t.adjustWidth();
/* 212 */     this.t.renderCX(r, body.cX(), body.y1());
/*     */     
/* 214 */     this.t.set((file.spec()).desc);
/* 215 */     this.t.renderCX(r, body.cX(), body.y1() + 32);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void renderName(SPRITE_RENDERER r, SaveFile s, RECTANGLE body) {
/* 222 */     (UI.FONT()).H2.render(r, s.name, body.x1() + 64, body.y1() + (UI.FONT()).M.height() / 2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void back() {
/* 228 */     menu.switchScreen(menu.main);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\menu\ScLoad$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */