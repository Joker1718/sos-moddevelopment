/*     */ package game.battle.state;
/*     */ 
/*     */ import game.GAME;
/*     */ import init.constant.C;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.MButt;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import util.gui.misc.GBox;
/*     */ import view.battle.UIBattleResult;
/*     */ import view.interrupter.Interrupter;
/*     */ import view.main.VIEW;
/*     */ import view.sett.ui.minimap.UIMinimapSettConfig;
/*     */ import view.subview.GameWindow;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class ILiveConclude
/*     */   extends Interrupter
/*     */ {
/* 227 */   private final GameWindow window = new GameWindow(C.DIM(), SETT.PIXEL_BOUNDS, 0);
/*     */   private final GuiSection section;
/*     */   
/*     */   ILiveConclude(CharSequence title, final boolean retreat, final boolean win) {
/* 231 */     pin();
/* 232 */     persistantSet();
/*     */     
/* 234 */     this.section = (GuiSection)new UIBattleResult(title)
/*     */       {
/*     */         protected void close()
/*     */         {
/* 238 */           BattleState.ILiveConclude.this.hide();
/* 239 */           BattleState.ILiveConclude.access$1(BattleState.ILiveConclude.this).liveResolve(retreat, win);
/*     */         }
/*     */       };
/*     */     
/* 243 */     this.window.copy(VIEW.b().getWindow());
/* 244 */     GAME.BATTLE_THREADS().pause();
/* 245 */     (VIEW.inters()).manager.add(this);
/* 246 */     this.section.body().centerIn(C.DIM());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean hover(COORDINATE mCoo, boolean mouseHasMoved) {
/* 252 */     this.section.hover(mCoo);
/* 253 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void mouseClick(MButt button) {
/* 258 */     if (button == MButt.LEFT) {
/* 259 */       this.section.click();
/*     */     }
/*     */   }
/*     */   
/*     */   protected void hoverTimer(GBox text) {
/* 264 */     this.section.hoverInfoGet((GUI_BOX)text);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean render(Renderer r, float ds) {
/* 269 */     this.section.render((SPRITE_RENDERER)r, ds);
/* 270 */     GAME.s().render(r, ds, this.window, UIMinimapSettConfig.NORMAL);
/* 271 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean update(float ds) {
/* 276 */     GAME.SPEED.speedSet(1.0D);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 283 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\state\BattleState$ILiveConclude.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */