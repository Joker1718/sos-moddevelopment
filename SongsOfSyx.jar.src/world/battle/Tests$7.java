/*     */ package world.battle;
/*     */ 
/*     */ import game.battle.state.BattleState;
/*     */ import game.battle.state.BattleStateExiter;
/*     */ import game.battle.state.BattleStateResult;
/*     */ import game.battle.state.BattleStateSpec;
/*     */ import game.battle.util.DivGeneration;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import view.main.VIEW;
/*     */ import world.army.AD;
/*     */ import world.army.ADSupplies;
/*     */ import world.battle.spec.BATTLE_RESULT;
/*     */ import world.battle.spec.WBattleResult;
/*     */ import world.battle.spec.WBattleSpec;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends WBattleSpec
/*     */ {
/*     */   public void retreat() {
/* 307 */     WBattleResult res = new WBattleResult()
/*     */       {
/*     */         public void accept(int[] enslave, int[] resources) {}
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 317 */     res.player = this.player;
/* 318 */     res.enemy = this.enemy;
/* 319 */     res.result = BATTLE_RESULT.RETREAT;
/* 320 */     Tests.this.init(res, this.player, -1);
/* 321 */     (VIEW.world()).UI.battle.result(res, false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void engage() {
/* 327 */     BattleStateSpec s = new BattleStateSpec();
/* 328 */     s.player = new BattleStateSpec.SpecSide();
/* 329 */     s.player.divs = new ArrayList(1 + RND.rInt(25)); int i;
/* 330 */     for (i = 0; i < s.player.artillery.length; i++) {
/* 331 */       s.player.artillery[i] = this.player.artillery((ADSupplies.ADArtillery)AD.supplies().arts().get(i));
/*     */     }
/*     */     
/* 334 */     s.player.moraleBase = 1.0D;
/* 335 */     s.player.wCoo.set(this.player.coo());
/* 336 */     for (i = 0; i < s.player.divs.max(); i++)
/* 337 */       s.player.divs.add(DivGeneration.rnd()); 
/* 338 */     s.enemy = new BattleStateSpec.SpecSide();
/* 339 */     s.enemy.divs = new ArrayList(1 + RND.rInt(25));
/* 340 */     for (i = 0; i < s.player.artillery.length; i++) {
/* 341 */       s.player.artillery[i] = this.player.artillery((ADSupplies.ADArtillery)AD.supplies().arts().get(i));
/*     */     }
/*     */     
/* 344 */     for (i = 0; i < s.player.artillery.length; i++) {
/* 345 */       s.enemy.artillery[i] = this.enemy.artillery((ADSupplies.ADArtillery)AD.supplies().arts().get(i));
/*     */     }
/*     */     
/* 348 */     s.enemy.moraleBase = 1.0D;
/* 349 */     s.enemy.wCoo.set(this.enemy.coo());
/* 350 */     while (s.enemy.divs.hasRoom()) {
/* 351 */       s.enemy.divs.add(DivGeneration.rnd());
/*     */     }
/* 353 */     BattleStateExiter res = new BattleStateExiter()
/*     */       {
/*     */         public void afterExit(BattleStateResult res) {}
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 362 */     BattleState.setGenerate(res, s);
/*     */   }
/*     */ 
/*     */   
/*     */   public void auto() {
/* 367 */     WBattleResult res = new WBattleResult()
/*     */       {
/*     */         public void accept(int[] enslave, int[] resources) {}
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 377 */     if (!this.victory) {
/* 378 */       Tests.this.init(res, this.player, -1);
/*     */     } else {
/* 380 */       Tests.this.init(res, this.enemy, 1);
/* 381 */     }  res.player = this.player;
/* 382 */     res.enemy = this.enemy;
/* 383 */     res.result = RND.rBoolean() ? BATTLE_RESULT.VICTORY : (RND.rBoolean() ? BATTLE_RESULT.DEFEAT : BATTLE_RESULT.RETREAT);
/* 384 */     (VIEW.world()).UI.battle.result(res, RND.rBoolean());
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\battle\Tests$7.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */