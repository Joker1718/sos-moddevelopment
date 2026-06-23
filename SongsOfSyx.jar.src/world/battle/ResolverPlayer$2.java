/*     */ package world.battle;
/*     */ 
/*     */ import view.main.VIEW;
/*     */ import world.battle.spec.BATTLE_RESULT;
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
/*     */ class null
/*     */   extends WBattleSpec
/*     */ {
/*     */   null() {
/*  92 */     this.victory = (paramResolverSide1.powerBalance > paramResolverSide2.powerBalance);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void retreat() {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void engage() {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void auto() {
/* 109 */     ResolverPlayer.this.tmp.clear();
/*     */     
/* 111 */     pp.count(ResolverPlayer.this.cPlayer.clear(), Resolver.autoValue(pp), false);
/* 112 */     ee.count(ResolverPlayer.this.cEnemy.clear(), Resolver.autoValue(ee), false);
/*     */     
/* 114 */     final BATTLE_RESULT res = (pp.powerBalance > ee.powerBalance) ? BATTLE_RESULT.VICTORY : BATTLE_RESULT.DEFEAT;
/*     */     
/* 116 */     if (res == BATTLE_RESULT.DEFEAT) {
/* 117 */       ((ResolverSide.ResolverUnit)pp.us.get(0)).count(ResolverPlayer.this.cPlayer.clear(), 1.0D, false);
/*     */     }
/*     */ 
/*     */     
/* 121 */     ResolverPlayer.Res rr = new ResolverPlayer.Res(pp, ee, res, (res == BATTLE_RESULT.VICTORY) ? ResolverPlayer.this.cEnemy : ResolverPlayer.this.cPlayer)
/*     */       {
/*     */         public void accept(int[] enslave, int[] resources)
/*     */         {
/* 125 */           BattleListener.notify((res == BATTLE_RESULT.VICTORY) ? pp : ee, (res == BATTLE_RESULT.VICTORY) ? ee : pp);
/* 126 */           shipRetreat(enslave, resources);
/* 127 */           pp.extract(Resolver.autoValue(pp));
/* 128 */           ee.extract(Resolver.autoValue(ee));
/*     */         }
/*     */       };
/*     */     
/* 132 */     (VIEW.world()).UI.battle.result(rr, false);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\battle\ResolverPlayer$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */