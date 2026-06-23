/*     */ package view.ui.div;
/*     */ 
/*     */ import game.battle.div.Div;
/*     */ import game.battle.formation.DivFormation;
/*     */ import game.battle.thread.order.BattleOrderTask;
/*     */ import game.battle.thread.trajectory.BattleTrajectories;
/*     */ import game.battle.util.Copyable;
/*     */ import settlement.stats.equip.EquipRange;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends GStat
/*     */ {
/* 312 */   final BattleOrderTask task = new BattleOrderTask();
/*     */   
/*     */   public void update(GText text) {
/* 315 */     DivFormation forCurrent = ((Div)g.get()).position();
/* 316 */     if (!((Div)g.get()).settings().mustering()) {
/* 317 */       text.errorify().add(UIDivCardBattle.¤¤NotMuster);
/* 318 */     } else if (forCurrent.deployed() == 0) {
/* 319 */       text.warnify().add(UIDivCardBattle.¤¤NoPosition);
/*     */     } else {
/* 321 */       (((Div)g.get()).order()).task.get((Copyable)this.task);
/* 322 */       switch (this.task.task()) {
/*     */         case ATTACK_MELEE:
/* 324 */           text.add(UIDivCardBattle.¤¤Attacking);
/*     */           break;
/*     */         case MOVE:
/* 327 */           text.add(UIDivCardBattle.¤¤Moving);
/*     */           break;
/*     */         case STOP:
/* 330 */           if (((Div)g.get()).settings().ammo() != null && ((Div)g.get()).settings().fireAtWill() && BattleTrajectories.trajectories((Div)g.get()) > 0) {
/* 331 */             range((Div)g.get(), text); break;
/*     */           } 
/* 333 */           text.add(UIDivCardBattle.¤¤Standing);
/*     */           break;
/*     */         case ATTACK_RANGED:
/* 336 */           range((Div)g.get(), text);
/*     */           break;
/*     */         
/*     */         case null:
/* 340 */           text.add(UIDivCardBattle.¤¤Building);
/*     */           break;
/*     */         case CHARGE:
/* 343 */           text.add(UIDivCardBattle.¤¤Charging);
/*     */           break;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void range(Div div, GText text) {
/* 354 */     EquipRange rr = ((Div)g.get()).settings().ammo();
/* 355 */     if (rr != null && BattleTrajectories.trajectories((Div)g.get()) > 0) {
/* 356 */       double di = rr.drawInter((Div)g.get());
/* 357 */       if (di > 0.75D) {
/* 358 */         text.add(UIDivCardBattle.¤¤AFiring);
/* 359 */       } else if (di > 0.5D) {
/* 360 */         text.add(UIDivCardBattle.¤¤AAiming);
/*     */       } else {
/* 362 */         double tt = rr.projectile.reloadSeconds(rr.ref((Div)g.get())) / 2.0D;
/* 363 */         di *= 2.0D;
/* 364 */         di = 1.0D - di;
/* 365 */         text.add(UIDivCardBattle.¤¤AReloading);
/* 366 */         text.s().add(tt * di, 1).add('s');
/*     */       } 
/*     */     } else {
/*     */       
/* 370 */       text.add(UIDivCardBattle.¤¤AFiring);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\div\UIDivCardBattle$7.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */