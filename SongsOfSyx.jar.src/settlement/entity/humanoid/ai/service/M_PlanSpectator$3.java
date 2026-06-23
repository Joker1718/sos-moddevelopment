/*     */ package settlement.entity.humanoid.ai.service;
/*     */ 
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIModules;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.misc.util.FINDABLE;
/*     */ import settlement.room.service.module.ROOM_SPECTATOR;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.rnd.RND;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends M_PlanSpectator.R
/*     */ {
/*     */   null(M_PlanSpectator paramM_PlanSpectator2) {}
/*     */   
/*     */   protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 128 */     ROOM_SPECTATOR s = M_PlanSpectator.this.s(d);
/* 129 */     if (!s.is(d.planTile.x(), d.planTile.y())) {
/* 130 */       return null;
/*     */     }
/* 132 */     if (d.planByte1 <= 0) {
/* 133 */       if (!AIModules.current(d).moduleCanContinue(a, d) || RND.oneIn(5)) {
/* 134 */         can(a, d);
/* 135 */         return null;
/*     */       } 
/*     */     } else {
/*     */       
/* 139 */       FINDABLE f = (s.service()).finder.getReserved(d.planTile.x(), d.planTile.y());
/* 140 */       if (f == null) {
/* 141 */         f = (s.service()).finder.getReservable(d.planTile.x(), d.planTile.y());
/* 142 */         if (f == null) {
/* 143 */           d.planByte1 = (byte)(d.planByte1 - 3);
/*     */         } else {
/* 145 */           f.findableReserve();
/*     */         } 
/*     */       } 
/* 148 */       d.planByte1 = (byte)(d.planByte1 - 1);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 154 */     DIR dd = DIR.get(a.body().cX(), a.body().cY(), s.lookAt(d.planTile.x(), d.planTile.y()));
/* 155 */     if (RND.oneIn(5))
/* 156 */       dd = dd.next(RND.rInt0(1)); 
/* 157 */     a.speed.setDirCurrent(dd);
/*     */     
/* 159 */     if (s.shouldCheer(d.planTile.x(), d.planTile.y())) {
/* 160 */       return M_PlanSpectator.this.cheer.set(a, d);
/*     */     }
/*     */     
/* 163 */     if (s.shouldBoo(d.planTile.x(), d.planTile.y())) {
/* 164 */       return M_PlanSpectator.this.boo.set(a, d);
/*     */     }
/*     */ 
/*     */     
/* 168 */     return (AI.SUBS()).STAND.activateTime(a, d, 10);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 174 */     return M_PlanSpectator.this.move.set(a, d);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\service\M_PlanSpectator$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */