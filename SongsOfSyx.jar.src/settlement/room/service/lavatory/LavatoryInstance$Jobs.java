/*     */ package settlement.room.service.lavatory;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import settlement.room.main.ROOMA;
/*     */ import settlement.room.main.furnisher.FurnisherItemTile;
/*     */ import settlement.room.main.job.JobPositions;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Jobs
/*     */   extends JobPositions<LavatoryInstance>
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   
/*     */   public Jobs(LavatoryInstance ins) {
/* 152 */     super(ins);
/*     */   }
/*     */ 
/*     */   
/*     */   protected SETT_JOB get(int tx, int ty) {
/* 157 */     Lavatory t = Lavatory.get(tx, ty);
/* 158 */     if (t == null)
/* 159 */       return null; 
/* 160 */     return t.job;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean isAndInit(int tx, int ty) {
/* 165 */     FurnisherItemTile it = (FurnisherItemTile)(SETT.ROOMS()).fData.tile.get(tx, ty);
/* 166 */     if (it != null) {
/* 167 */       int d = it.data();
/* 168 */       (SETT.ROOMS()).data.set((ROOMA)this.ins, tx, ty, d);
/* 169 */       if (d == 32768)
/*     */       {
/* 171 */         return true;
/*     */       }
/*     */     } 
/*     */     
/* 175 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\lavatory\LavatoryInstance$Jobs.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */