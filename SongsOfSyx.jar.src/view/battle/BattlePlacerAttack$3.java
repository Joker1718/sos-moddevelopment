/*     */ package view.battle;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.div.Div;
/*     */ import game.battle.util.Copyable;
/*     */ import init.sprite.SPRITES;
/*     */ import settlement.room.military.artillery.ArtilleryInstance;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends BattlePlacerAttack.Target
/*     */ {
/*     */   private int cx;
/*     */   private int cy;
/*     */   
/*     */   null(BattlePlacerAttack paramBattlePlacerAttack2) {}
/*     */   
/*     */   boolean set() {
/* 374 */     if ((BattlePlacerAttack.this.melees || BattlePlacerAttack.this.archers || BattlePlacerAttack.this.artillery) && 
/* 375 */       (GAME.ARMIES()).map.attackable.is((COORDINATE)BattlePlacerAttack.this.w.tile(), GAME.ARMIES().player())) {
/* 376 */       this.cx = BattlePlacerAttack.this.w.tile().x() * 64 + 32;
/* 377 */       this.cy = BattlePlacerAttack.this.w.tile().y() * 64 + 32;
/* 378 */       return true;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 383 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   CharSequence name() {
/* 388 */     if (BattlePlacerAttack.this.melees || BattlePlacerAttack.this.archers) {
/* 389 */       return BattlePlacerAttack.¤¤AttackBuilding;
/*     */     }
/* 391 */     return BattlePlacerAttack.¤¤BombardBuilding;
/*     */   }
/*     */ 
/*     */   
/*     */   void problem(GBox b) {
/* 396 */     BattlePlacerAttack.this.artilleryProb(this.cx, this.cy, false, b);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void click() {
/* 402 */     for (Div dd : BattlePlacerAttack.this.s.selection()) {
/* 403 */       BattlePlacerAttack.this.task.attack(this.cx >> 6, this.cy >> 6, dd);
/* 404 */       (dd.order()).task.set((Copyable)BattlePlacerAttack.this.task);
/*     */     } 
/* 406 */     if (BattlePlacerAttack.this.artillery) {
/* 407 */       for (ArtilleryInstance ins : BattlePlacerAttack.this.s.artillery.selection()) {
/* 408 */         if (ins.testTarget(this.cx, this.cy, BattlePlacerAttack.this.traj, false) == null) {
/* 409 */           ins.targetCooSet(this.cx, this.cy, false, true);
/*     */         }
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void render(Renderer r, ShadowBatch shadowBatch, RenderData data) {
/* 418 */     COLOR.RED100.bind();
/*     */     
/* 420 */     if ((BattlePlacerAttack.this.melees || BattlePlacerAttack.this.archers) && BattlePlacerAttack.this.artillery) {
/* 421 */       VIEW.mouse().setReplacement(((int)VIEW.renderSecond() * 2 % 2 == 1) ? (SPRITE)(SPRITES.icons()).m.bow : (SPRITE)(SPRITES.icons()).m.sword);
/* 422 */     } else if (BattlePlacerAttack.this.melees || BattlePlacerAttack.this.archers) {
/* 423 */       VIEW.mouse().setReplacement((SPRITE)(SPRITES.icons()).m.sword);
/*     */     } else {
/* 425 */       VIEW.mouse().setReplacement((SPRITE)(SPRITES.icons()).m.bow);
/*     */     } 
/* 427 */     int p = BattlePlacerAttack.this.artilleryProblem(this.cx, this.cy, false);
/* 428 */     if (p == 0) {
/* 429 */       VIEW.mouse().setReplacement((SPRITE)(SPRITES.icons()).m.cancel);
/*     */       return;
/*     */     } 
/* 432 */     if (p == 1) {
/* 433 */       COLOR.ORANGE100.bind();
/*     */     }
/*     */     
/* 436 */     int x1 = this.cx - data.offX1();
/* 437 */     int y1 = this.cy - data.offY1();
/* 438 */     (SPRITES.cons()).BIG.dots.renderCentered((SPRITE_RENDERER)r, 0, x1, y1);
/* 439 */     COLOR.unbind();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\battle\BattlePlacerAttack$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */