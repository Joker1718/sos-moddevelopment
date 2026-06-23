/*     */ package view.world.ui.battle;
/*     */ 
/*     */ import init.constant.Config;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GMeter;
/*     */ import world.battle.spec.WBattleSide;
/*     */ import world.battle.spec.WBattleUnit;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends HOVERABLE.HoverableAbs
/*     */ {
/*     */   private final GETTER<WBattleSide> g;
/*     */   private final GETTER<Integer> ier;
/*     */   private final GMeter.GMeterCol col;
/*     */   
/*     */   Row(GETTER<WBattleSide> g, GETTER<Integer> ier, GMeter.GMeterCol col) {
/* 270 */     super(300, 24);
/* 271 */     this.g = g;
/* 272 */     this.ier = ier;
/* 273 */     this.col = col;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/* 279 */     WBattleUnit u = u();
/* 280 */     if (u == null)
/*     */       return; 
/* 282 */     u.icon().renderCY(r, this.body.x1(), this.body.cY());
/*     */     
/* 284 */     int X1 = this.body.x1() + 24 + 4;
/* 285 */     int WI = this.body.x2() - X1 - 8;
/*     */ 
/*     */     
/* 288 */     double dmen = Math.sqrt(u.men() / (Config.battle()).MEN_PER_ARMY);
/* 289 */     int X2 = (int)(X1 + WI * dmen);
/*     */     
/* 291 */     int losses = 0;
/*     */     
/* 293 */     if (Battle.this.hovRetreat)
/* 294 */       losses = u.lossesRetreat(); 
/* 295 */     if (Battle.this.hovAuto) {
/* 296 */       losses = u.losses();
/*     */     }
/*     */     
/* 299 */     double d = (u.men() - losses) / u.men();
/*     */     
/* 301 */     GMeter.render(r, this.col, d, X1, X2, this.body.y1() + 2, this.body.y2() - 2);
/*     */     
/* 303 */     GMeter.renderDelta(r, 1.0D, d, X1, X2, this.body.y1() + 2, this.body.y2() - 2, this.col);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 315 */     WBattleUnit u = u();
/* 316 */     if (u == null)
/*     */       return; 
/* 318 */     u.hover(text);
/* 319 */     super.hoverInfoGet(text);
/*     */     
/* 321 */     if (u.defences() >= 1.0D) {
/* 322 */       GBox b = (GBox)text;
/* 323 */       b.sep();
/* 324 */       b.text(Battle.¤¤defence);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private WBattleUnit u() {
/* 330 */     WBattleSide s = (WBattleSide)this.g.get();
/* 331 */     if (s == null)
/* 332 */       return null; 
/* 333 */     int ui = (this.ier == null) ? 0 : (((Integer)this.ier.get()).intValue() + 1);
/* 334 */     WBattleUnit u = (WBattleUnit)s.units().get(ui);
/* 335 */     if (u == null)
/* 336 */       return null; 
/* 337 */     return u;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\battle\Battle$Row.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */