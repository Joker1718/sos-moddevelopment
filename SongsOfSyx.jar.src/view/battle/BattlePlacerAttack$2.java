/*     */ package view.battle;
/*     */ 
/*     */ import game.battle.div.Div;
/*     */ import game.battle.util.Copyable;
/*     */ import init.sprite.SPRITES;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.room.military.artillery.ArtilleryInstance;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
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
/*     */ class null
/*     */   extends BattlePlacerAttack.Target
/*     */ {
/*     */   private Room r;
/*     */   private int cx;
/*     */   private int cy;
/*     */   
/*     */   null(BattlePlacerAttack paramBattlePlacerAttack2) {}
/*     */   
/*     */   boolean set() {
/* 286 */     if (BattlePlacerAttack.this.melees || BattlePlacerAttack.this.archers || BattlePlacerAttack.this.artillery) {
/* 287 */       this.r = (Room)(SETT.ROOMS()).map.get((COORDINATE)BattlePlacerAttack.this.w.tile());
/* 288 */       if (this.r != null) {
/* 289 */         FurnisherItem it = (FurnisherItem)(SETT.ROOMS()).fData.item.get((COORDINATE)BattlePlacerAttack.this.w.tile());
/* 290 */         if (it != null) {
/* 291 */           COORDINATE c = (SETT.ROOMS()).fData.itemX1Y1((COORDINATE)BattlePlacerAttack.this.w.tile(), Coo.TMP);
/* 292 */           this.cx = c.x() * 64 + it.width() * 64 / 2;
/* 293 */           this.cy = c.y() * 64 + it.height() * 64 / 2;
/* 294 */           return true;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 300 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   CharSequence name() {
/* 305 */     if (BattlePlacerAttack.this.melees || BattlePlacerAttack.this.archers) {
/* 306 */       return BattlePlacerAttack.¤¤AttackBuilding;
/*     */     }
/* 308 */     return BattlePlacerAttack.¤¤BombardBuilding;
/*     */   }
/*     */ 
/*     */   
/*     */   void problem(GBox b) {
/* 313 */     BattlePlacerAttack.this.artilleryProb(this.cx, this.cy, false, b);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void click() {
/* 320 */     for (Div dd : BattlePlacerAttack.this.s.selection()) {
/* 321 */       BattlePlacerAttack.this.task.attack(this.cx / 64, this.cy / 64, dd);
/* 322 */       (dd.order()).task.set((Copyable)BattlePlacerAttack.this.task);
/*     */     } 
/* 324 */     if (BattlePlacerAttack.this.artillery) {
/* 325 */       for (ArtilleryInstance ins : BattlePlacerAttack.this.s.artillery.selection()) {
/* 326 */         if (ins.testTarget(this.cx, this.cy, BattlePlacerAttack.this.traj, false) == null) {
/* 327 */           ins.targetCooSet(this.cx, this.cy, false, true);
/*     */         }
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void render(Renderer r, ShadowBatch shadowBatch, RenderData data) {
/* 336 */     COLOR.RED100.bind();
/*     */     
/* 338 */     if ((BattlePlacerAttack.this.melees || BattlePlacerAttack.this.archers) && BattlePlacerAttack.this.artillery) {
/* 339 */       VIEW.mouse().setReplacement(((int)VIEW.renderSecond() * 2 % 2 == 1) ? (SPRITE)(SPRITES.icons()).m.bow : (SPRITE)(SPRITES.icons()).m.sword);
/* 340 */     } else if (BattlePlacerAttack.this.melees || BattlePlacerAttack.this.archers) {
/* 341 */       VIEW.mouse().setReplacement((SPRITE)(SPRITES.icons()).m.sword);
/*     */     } else {
/* 343 */       VIEW.mouse().setReplacement((SPRITE)(SPRITES.icons()).m.bow);
/*     */     } 
/*     */ 
/*     */     
/* 347 */     int p = BattlePlacerAttack.this.artilleryProblem(this.cx, this.cy, false);
/* 348 */     if (p == 0) {
/* 349 */       VIEW.mouse().setReplacement((SPRITE)(SPRITES.icons()).m.cancel);
/*     */       return;
/*     */     } 
/* 352 */     if (p == 1) {
/* 353 */       COLOR.ORANGE100.bind();
/*     */     }
/* 355 */     FurnisherItem it = (FurnisherItem)(SETT.ROOMS()).fData.item.get((COORDINATE)BattlePlacerAttack.this.w.tile());
/* 356 */     if (it != null) {
/* 357 */       COORDINATE c = (SETT.ROOMS()).fData.itemX1Y1((COORDINATE)BattlePlacerAttack.this.w.tile(), Coo.TMP);
/* 358 */       int x1 = c.x() * 64 - data.offX1();
/* 359 */       int y1 = c.y() * 64 - data.offY1();
/* 360 */       (SPRITES.cons()).BIG.outline.renderBox((SPRITE_RENDERER)r, x1, y1, it.width() * 64, it.height() * 64);
/* 361 */       COLOR.unbind();
/*     */       return;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\battle\BattlePlacerAttack$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */