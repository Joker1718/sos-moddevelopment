/*     */ package settlement.entity.humanoid.ai.service;
/*     */ 
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.service.module.ROOM_SPECTATOR;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   private final int[] order;
/*     */   
/*     */   null(M_PlanSpectator paramM_PlanSpectator2) {
/*  84 */     this.order = new int[] { 0, 1, 2 };
/*     */   }
/*     */ 
/*     */   
/*     */   protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/*  89 */     if (!shouldMove(a, a.tc().x(), a.tc().y())) {
/*  90 */       return M_PlanSpectator.this.stand.set(a, d);
/*     */     }
/*     */     
/*  93 */     ROOM_SPECTATOR s = M_PlanSpectator.this.s(d);
/*  94 */     DIR dd = DIR.get(a.body().cX(), a.body().cY(), s.lookAt(d.planTile.x(), d.planTile.y())); byte b;
/*     */     int i, arrayOfInt[];
/*  96 */     for (i = (arrayOfInt = this.order).length, b = 0; b < i; ) { int j = arrayOfInt[b];
/*  97 */       dd = dd.next(j);
/*  98 */       int dx = a.tc().x() + dd.x();
/*  99 */       int dy = a.tc().y() + dd.y();
/* 100 */       if (M_PlanSpectator.this.isSpot(dx, dy) && 
/* 101 */         !shouldMove(a, dx, dy)) {
/* 102 */         return (AI.SUBS()).walkTo.cooFull(a, d, dx, dy);
/*     */       }
/*     */       
/*     */       b++; }
/*     */     
/* 107 */     return M_PlanSpectator.this.stand.set(a, d);
/*     */   }
/*     */   
/*     */   private boolean shouldMove(Humanoid a, int cx, int cy) {
/* 111 */     for (ENTITY e : SETT.ENTITIES().getAtTile(cx, cy)) {
/* 112 */       if (e != a && e instanceof Humanoid && e.speed.magnitude() == 0.0D)
/* 113 */         return true; 
/*     */     } 
/* 115 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 120 */     return M_PlanSpectator.this.stand.set(a, d);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\service\M_PlanSpectator$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */