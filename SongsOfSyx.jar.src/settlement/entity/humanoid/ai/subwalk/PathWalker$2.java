/*     */ package settlement.entity.humanoid.ai.subwalk;
/*     */ 
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AISTATE;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
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
/*     */ class null
/*     */   extends AISUB.Resumable.Resumer
/*     */ {
/*     */   null(AISUB.Resumable paramResumable) {
/*  95 */     super(paramResumable);
/*     */   }
/*     */   
/*     */   public AISTATE res(Humanoid a, AIManager d) {
/*  99 */     int dy = d.path.destY() * 64 + 32 - a.body().cY();
/* 100 */     int dx = d.path.destX() * 64 + 32 - a.body().cX();
/* 101 */     a.speed.setDirCurrent(DIR.get(dx, dy));
/* 102 */     return PathWalker.this.wait.set(a, d);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean success(Humanoid a, AIManager d) {
/* 107 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public AISTATE setAction(Humanoid a, AIManager d) {
/* 113 */     int x2 = d.path.getSettCX();
/* 114 */     int y2 = d.path.getSettCY();
/* 115 */     int dd = (64 - a.body().width() - 2) / 2;
/* 116 */     if (d.path.isFull()) {
/* 117 */       if (dd > 3)
/* 118 */         dd = 3; 
/* 119 */       x2 += RND.rInt0(dd);
/* 120 */       y2 += RND.rInt0(dd);
/*     */     } else {
/*     */       
/* 123 */       int dy = d.path.destY() - d.path.y();
/* 124 */       int dx = d.path.destX() - d.path.x();
/* 125 */       x2 += dx * dd;
/* 126 */       y2 += dy * dd;
/*     */     } 
/*     */     
/* 129 */     return (AI.STATES()).WALK2.free(a, d, x2, y2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void can(Humanoid a, AIManager d) {
/* 134 */     PathWalker.this.abort(a, d);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\subwalk\PathWalker$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */