/*    */ package game.battle.thread.order;
/*    */ 
/*    */ import game.battle.formation.DivFormationImp;
/*    */ import game.battle.util.DIV_SPEC;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends BattleOrderUpdater.Plan.STATE
/*    */ {
/*    */   null(BattleOrderUpdater.Plan paramPlan, String $anonymous0) {
/* 34 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   void update(int gameMillis) {
/* 38 */     if (PlanCharge.this.t.div.fixIfNeeded(PlanCharge.prev)) {
/* 39 */       PlanCharge.nextPos = PlanCharge.prev;
/*    */     }
/* 41 */     PlanCharge.this.timer2.set(PlanCharge.m, 0);
/* 42 */     PlanCharge.this.timer.set(PlanCharge.m, 0);
/* 43 */     if (PlanCharge.this.inPosition() < (PlanCharge.prev.deployed() - PlanCharge.unreachable) / 2) {
/*    */       return;
/*    */     }
/* 46 */     PlanCharge.this.charge.set();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   boolean setAction() {
/* 54 */     if (PlanCharge.prev.deployed() > 0) {
/* 55 */       PlanCharge.dest.copy(PlanCharge.prev);
/* 56 */       PlanCharge.order.dest.set(PlanCharge.dest);
/* 57 */     } else if (PlanCharge.current.deployed() > 0) {
/* 58 */       int xx = 0;
/* 59 */       int yy = 0;
/* 60 */       for (int i = 0; i < PlanCharge.current.deployed(); i++) {
/* 61 */         xx += PlanCharge.current.tile(i).x();
/* 62 */         yy += PlanCharge.current.tile(i).y();
/*    */       } 
/*    */       
/* 65 */       xx /= PlanCharge.current.deployed();
/* 66 */       yy /= PlanCharge.current.deployed();
/* 67 */       int min = Integer.MAX_VALUE;
/* 68 */       int f = -1;
/* 69 */       for (int j = 0; j < PlanCharge.current.deployed(); j++) {
/* 70 */         int k = Math.abs(PlanCharge.current.tile(j).x() - xx) + Math.abs(PlanCharge.current.tile(j).y() - yy);
/* 71 */         if (k < min) {
/* 72 */           min = k;
/* 73 */           f = j;
/*    */         } 
/*    */       } 
/*    */       
/* 77 */       if (f == -1) {
/* 78 */         PlanCharge.task.stop(PlanCharge.div);
/* 79 */         PlanCharge.order.task.set(PlanCharge.task);
/* 80 */         return false;
/*    */       } 
/*    */ 
/*    */       
/* 84 */       DivFormationImp d = PlanCharge.this.t.deployer.deployCentre((DIV_SPEC)PlanCharge.div.info, PlanCharge.current.deployed(), (PlanCharge.div.settings()).formation, PlanCharge.current.pixel(f).x(), PlanCharge.current.pixel(f).y(), 1.0D, 0.0D, 5, PlanCharge.a);
/* 85 */       if (d == null) {
/* 86 */         PlanCharge.task.stop(PlanCharge.div);
/* 87 */         PlanCharge.order.task.set(PlanCharge.task);
/* 88 */         return false;
/*    */       } 
/* 90 */       PlanCharge.dest.copy(d);
/*    */     } 
/*    */     
/* 93 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\thread\order\PlanCharge$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */