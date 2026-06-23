/*     */ package world.battle;
/*     */ 
/*     */ import game.battle.state.BattleState;
/*     */ import game.battle.state.BattleStateExiter;
/*     */ import game.battle.state.BattleStateResult;
/*     */ import game.battle.state.BattleStateSpec;
/*     */ import init.constant.Config;
/*     */ import java.util.Arrays;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.file.Alloc;
/*     */ import view.main.VIEW;
/*     */ import world.army.AD;
/*     */ import world.army.ADSupplies;
/*     */ import world.army.WDIV;
/*     */ import world.battle.spec.BATTLE_RESULT;
/*     */ import world.battle.spec.WBattleResult;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class Manual
/*     */ {
/*     */   private final Side savedPlayer;
/*     */   private final Side savedEnemy;
/*     */   
/*     */   Manual(Side player, Side enemy) {
/* 347 */     this.savedPlayer = player.copy();
/* 348 */     this.savedEnemy = enemy.copy();
/* 349 */     BattleStateExiter res = new BattleStateExiter()
/*     */       {
/*     */         public void afterExit(BattleStateResult res)
/*     */         {
/* 353 */           ResolverPlayer.Manual.this.afterBattle(res);
/*     */         }
/*     */       };
/*     */     
/* 357 */     BattleState.setGenerate(res, new BattleSpecc(player, enemy));
/*     */   }
/*     */ 
/*     */   
/*     */   void afterBattle(final BattleStateResult res) {
/* 362 */     ResolverSide.RCount ecount = new ResolverSide.RCount();
/* 363 */     ResolverSide.RCount pcount = new ResolverSide.RCount();
/*     */     
/* 365 */     final ResolverSide ee = new ResolverSide();
/* 366 */     ee.init(this.savedEnemy, 0.0D);
/* 367 */     final ResolverSide pp = new ResolverSide();
/* 368 */     pp.init(this.savedPlayer, 0.0D);
/*     */ 
/*     */ 
/*     */     
/* 372 */     if (res.result == BATTLE_RESULT.VICTORY && ((ResolverSide.ResolverUnit)ee.us.get(0)).unit.a() != null) {
/* 373 */       COORDINATE c = Util.retTile(((ResolverSide.ResolverUnit)ee.us.get(0)).unit.a());
/* 374 */       if (c != null) {
/* 375 */         ee.retreatCoo.set(c);
/*     */       } else {
/* 377 */         Arrays.fill(res.enemySurvivors, 0);
/*     */       } 
/* 379 */     } else if (res.result != BATTLE_RESULT.VICTORY && ((ResolverSide.ResolverUnit)pp.us.get(0)).unit.a() != null) {
/* 380 */       COORDINATE c = Util.retTile(((ResolverSide.ResolverUnit)pp.us.get(0)).unit.a());
/* 381 */       if (c != null) {
/* 382 */         ee.retreatCoo.set(c);
/*     */       } else {
/* 384 */         for (int k = 0; k < res.playerSurvivors.length; k++) {
/* 385 */           res.playerSurvivors[k] = new settlement.stats.Induvidual[0];
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 390 */     int[] losses = Alloc.ii((Config.battle()).DIVISIONS_PER_ARMY);
/* 391 */     for (int i = 0; i < this.savedEnemy.divs(); i++) {
/* 392 */       losses[this.savedEnemy.ui(i)] = losses[this.savedEnemy.ui(i)] + this.savedEnemy.div(i).men() - res.enemySurvivors[i];
/*     */     }
/*     */     
/* 395 */     for (int j = 0; j < this.savedEnemy.us.size(); j++) {
/* 396 */       ((ResolverSide.ResolverUnit)ee.us.get(j)).count(ecount, losses[j], false);
/*     */     }
/*     */ 
/*     */     
/* 400 */     Arrays.fill(losses, 0);
/* 401 */     for (int di = 0; di < this.savedPlayer.divs(); di++) {
/* 402 */       if (this.savedPlayer.div(di) != null) {
/* 403 */         losses[this.savedPlayer.ui(di)] = losses[this.savedPlayer.ui(di)] + this.savedPlayer.div(di).men() - (res.playerSurvivors[di]).length;
/*     */       }
/*     */     } 
/* 406 */     for (int ui = 0; ui < this.savedPlayer.us.size(); ui++) {
/* 407 */       ((ResolverSide.ResolverUnit)pp.us.get(ui)).count(pcount, losses[ui], false);
/*     */     }
/*     */ 
/*     */     
/* 411 */     WBattleResult rr = new ResolverPlayer.Res(pp, ee, res.result, (res.result == BATTLE_RESULT.VICTORY) ? ecount : pcount)
/*     */       {
/*     */         public void accept(int[] enslave, int[] resources)
/*     */         {
/* 415 */           BattleListener.notify((res.result == BATTLE_RESULT.VICTORY) ? pp : ee, (res.result == BATTLE_RESULT.VICTORY) ? ee : pp);
/* 416 */           shipRetreat(enslave, resources);
/*     */           int i;
/* 418 */           for (i = 0; i < ResolverPlayer.Manual.this.savedEnemy.divs(); i++) {
/* 419 */             WDIV d = ResolverPlayer.Manual.this.savedEnemy.div(i);
/* 420 */             d.resolve(res.enemySurvivors[i]);
/*     */           } 
/*     */           
/* 423 */           for (i = 0; i < ResolverPlayer.Manual.this.savedPlayer.divs(); i++) {
/* 424 */             WDIV d = ResolverPlayer.Manual.this.savedPlayer.div(i);
/* 425 */             if (d != null) {
/* 426 */               d.resolve(res.playerSurvivors[i]);
/*     */             }
/*     */           } 
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/* 434 */     (VIEW.world()).UI.battle.result(rr, false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private class BattleSpecc
/*     */     extends BattleStateSpec
/*     */   {
/*     */     BattleSpecc(Side player, Side enemy) {
/* 443 */       set(player, this.player);
/* 444 */       set(enemy, this.enemy);
/*     */     }
/*     */     
/*     */     private void set(Side side, BattleStateSpec.SpecSide spec) {
/* 448 */       spec.wCoo.set(((Side.SideUnit)side.us.get(0)).x(), ((Side.SideUnit)side.us.get(0)).y());
/* 449 */       for (int i = 0; i < AD.supplies().arts().size(); i++) {
/* 450 */         spec.artillery[i] = ResolverPlayer.artillery((ADSupplies.ADArtillery)AD.supplies().arts().get(i), side);
/*     */       }
/* 452 */       spec.moraleBase = ResolverPlayer.morale(side);
/*     */       
/* 454 */       for (int di = 0; di < side.divs(); di++)
/* 455 */         spec.divs.add(side.div(di).generate()); 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\battle\ResolverPlayer$Manual.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */