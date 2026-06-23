/*     */ package world.battle;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import view.main.VIEW;
/*     */ import world.battle.spec.BATTLE_RESULT;
/*     */ import world.battle.spec.WBattleSiege;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends WBattleSiege
/*     */ {
/*     */   public void auto() {
/* 160 */     ResolverPlayer.this.tmp.clear();
/* 161 */     pp.count(ResolverPlayer.this.cPlayer.clear(), Resolver.autoValue(pp), false);
/* 162 */     ee.count(ResolverPlayer.this.cEnemy.clear(), Resolver.autoValue(ee), false);
/* 163 */     final BATTLE_RESULT res = (pp.powerBalance > ee.powerBalance) ? BATTLE_RESULT.VICTORY : BATTLE_RESULT.DEFEAT;
/*     */     
/* 165 */     ResolverPlayer.Res rr = new ResolverPlayer.Res(pp, ee, res, (res == BATTLE_RESULT.VICTORY) ? ResolverPlayer.this.cEnemy : ResolverPlayer.this.cPlayer)
/*     */       {
/*     */         public void accept(int[] enslave, int[] resources)
/*     */         {
/* 169 */           BattleListener.notify((res == BATTLE_RESULT.VICTORY) ? pp : ee, (res == BATTLE_RESULT.VICTORY) ? ee : pp);
/* 170 */           shipRetreat(enslave, resources);
/* 171 */           pp.extract(Resolver.autoValue(pp));
/* 172 */           ee.extract(Resolver.autoValue(ee));
/*     */           
/* 174 */           if (res == BATTLE_RESULT.VICTORY) {
/* 175 */             (ResolverPlayer.null.access$0(ResolverPlayer.null.this)).conq.init(((ResolverSide.ResolverUnit)ee.us.get(0)).unit.r(), pp.side, ee.side);
/* 176 */             (VIEW.world()).UI.battle.result((ResolverPlayer.null.access$0(ResolverPlayer.null.this)).conq);
/*     */           } 
/*     */         }
/*     */       };
/*     */     
/* 181 */     (VIEW.world()).UI.battle.result(rr, false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void retreat() {
/* 187 */     for (Side.SideUnit u : pp.side.us) {
/* 188 */       if (u.a() != null && u.a().faction() == FACTIONS.player())
/* 189 */         u.a().stop(); 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\battle\ResolverPlayer$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */