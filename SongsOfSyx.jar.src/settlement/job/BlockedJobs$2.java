/*     */ package settlement.job;
/*     */ 
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.misc.ACTION;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   implements ACTION
/*     */ {
/*     */   public void exe() {
/* 124 */     BlockedJobs.BlockedJob j = BlockedJobs.this.next();
/* 125 */     LOG.ln(j);
/* 126 */     if (j != null) {
/* 127 */       LOG.ln(String.valueOf(j.coo) + "  " + String.valueOf(j.coo));
/*     */       
/* 129 */       RBIT bb = j.jobResourceBitToFetch();
/* 130 */       RESOURCE res = null;
/* 131 */       if (bb != null) {
/* 132 */         for (RESOURCE r : RESOURCES.ALL()) {
/* 133 */           if (bb.has(r)) {
/* 134 */             res = r;
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       }
/* 139 */       if (j.jobReserveCanBe()) {
/* 140 */         j.jobReserve(res);
/*     */       }
/* 142 */       j.jobPerform(null, res, 1);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\job\BlockedJobs$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */