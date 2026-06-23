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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Spec
/*     */   extends WBattleSpec
/*     */ {
/*     */   private ResolverSide pp;
/*     */   private ResolverSide ee;
/*     */   
/*     */   void init(ResolverSide pp, ResolverSide ee) {
/* 280 */     this.pp = pp;
/* 281 */     this.ee = ee;
/* 282 */     this.player = pp;
/* 283 */     this.enemy = ee;
/* 284 */     this.victory = (pp.powerBalance > ee.powerBalance);
/*     */   }
/*     */ 
/*     */   
/*     */   public void retreat() {
/* 289 */     ResolverPlayer.this.tmp.clear();
/* 290 */     final double losses = Resolver.retreatValue(this.pp);
/* 291 */     ((ResolverSide.ResolverUnit)this.pp.us.get(0)).count(ResolverPlayer.this.tmp.clear(), losses, false);
/* 292 */     ResolverPlayer.Res rr = new ResolverPlayer.Res(this.pp, this.ee, BATTLE_RESULT.RETREAT, ResolverPlayer.this.tmp)
/*     */       {
/*     */         public void accept(int[] enslave, int[] resources)
/*     */         {
/* 296 */           BattleListener.notify(ResolverPlayer.Spec.this.ee, ResolverPlayer.Spec.this.pp);
/* 297 */           shipRetreat(enslave, resources);
/* 298 */           if (ResolverPlayer.Spec.this.pp.retreatCoo.x() >= 0 && ((Side.SideUnit)ResolverPlayer.Spec.this.pp.side.us.get(0)).a() != null) {
/* 299 */             ((Side.SideUnit)ResolverPlayer.Spec.this.pp.side.us.get(0)).a().teleport(ResolverPlayer.Spec.this.pp.retreatCoo.x(), ResolverPlayer.Spec.this.pp.retreatCoo.y());
/*     */           }
/* 301 */           ResolverPlayer.Spec.this.pp.extract(losses);
/*     */         }
/*     */       };
/*     */     
/* 305 */     (VIEW.world()).UI.battle.result(rr, false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void engage() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void auto() {
/* 315 */     ResolverPlayer.this.tmp.clear();
/* 316 */     this.pp.clear().count(ResolverPlayer.this.cPlayer.clear(), Resolver.autoValue(this.pp), false);
/* 317 */     this.ee.clear().count(ResolverPlayer.this.cEnemy.clear(), Resolver.autoValue(this.ee), false);
/*     */     
/* 319 */     final BATTLE_RESULT res = (this.pp.powerBalance > this.ee.powerBalance) ? BATTLE_RESULT.VICTORY : BATTLE_RESULT.DEFEAT;
/*     */     
/* 321 */     ResolverPlayer.Res rr = new ResolverPlayer.Res(this.pp, this.ee, res, (res == BATTLE_RESULT.VICTORY) ? ResolverPlayer.this.cEnemy : ResolverPlayer.this.cPlayer)
/*     */       {
/*     */         public void accept(int[] enslave, int[] resources)
/*     */         {
/* 325 */           BattleListener.notify((res == BATTLE_RESULT.VICTORY) ? ResolverPlayer.Spec.this.pp : ResolverPlayer.Spec.this.ee, (res == BATTLE_RESULT.VICTORY) ? ResolverPlayer.Spec.this.ee : ResolverPlayer.Spec.this.pp);
/* 326 */           shipRetreat(enslave, resources);
/*     */           
/* 328 */           ResolverPlayer.Spec.this.pp.clear().extract(Resolver.autoValue(ResolverPlayer.Spec.this.pp));
/* 329 */           ResolverPlayer.Spec.this.ee.clear().extract(Resolver.autoValue(ResolverPlayer.Spec.this.ee));
/*     */         }
/*     */       };
/*     */     
/* 333 */     (VIEW.world()).UI.battle.result(rr, false);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\battle\ResolverPlayer$Spec.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */