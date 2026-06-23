/*     */ package settlement.stats.colls;
/*     */ 
/*     */ import init.race.Race;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.HTYPES;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.StatsInit;
/*     */ import settlement.stats.stat.STATData;
/*     */ import util.data.INT_O;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends STATData
/*     */ {
/*     */   null(String $anonymous0, String $anonymous1, StatsInit $anonymous2, INT_O.INT_OE<Induvidual> $anonymous3) {
/* 334 */     super($anonymous0, $anonymous1, $anonymous2, $anonymous3);
/*     */   }
/*     */   
/*     */   public int pdivider(HCLASS c, Race r, int daysback) {
/* 338 */     if (c == HCLASSES.SLAVE())
/* 339 */       return STATS.POP().pop(r, HTYPES.SLAVE(), daysback); 
/* 340 */     return STATS.POP().pop(r, HTYPES.STUDENT(), daysback) + STATS.POP().pop(r, HTYPES.RECRUIT(), daysback) + STATS.POP().pop(r, HTYPES.GUARD(), daysback) + STATS.POP().pop(r, HTYPES.SUBJECT(), daysback);
/*     */   }
/*     */ 
/*     */   
/*     */   public void addPrivate(Induvidual i) {
/* 345 */     RoomInstance ins = StatsWork.Work.this.get(i);
/*     */ 
/*     */     
/* 348 */     if (ins != null) {
/* 349 */       if (i.hType() == HTYPES.RETIREE()) {
/* 350 */         (StatsWork.Work.access$2(StatsWork.Work.this)).fRetvalues[i.popCL().index()] = (StatsWork.Work.access$2(StatsWork.Work.this)).fRetvalues[i.popCL().index()] + (int)(i.race().pref().getWork(ins.blueprintI().employment()) * 256.0D);
/*     */       } else {
/* 352 */         (StatsWork.Work.access$2(StatsWork.Work.this)).fvalues[i.popCL().index()] = (StatsWork.Work.access$2(StatsWork.Work.this)).fvalues[i.popCL().index()] + (int)(i.race().pref().getWork(ins.blueprintI().employment()) * 256.0D);
/* 353 */       }  (StatsWork.Work.access$2(StatsWork.Work.this)).health.inc(i.hType(), i.race(), (int)((ins.blueprintI().employment()).healthFactor * 256.0D), -1);
/*     */     } else {
/* 355 */       StatsWork.Work.this.data.set(i, 0);
/*     */     } 
/* 357 */     super.addPrivate(i);
/*     */   }
/*     */ 
/*     */   
/*     */   public void removePrivate(Induvidual i) {
/* 362 */     RoomInstance ins = StatsWork.Work.this.get(i);
/* 363 */     if (ins != null) {
/* 364 */       if (i.hType() == HTYPES.RETIREE()) {
/* 365 */         (StatsWork.Work.access$2(StatsWork.Work.this)).fRetvalues[i.popCL().index()] = (StatsWork.Work.access$2(StatsWork.Work.this)).fRetvalues[i.popCL().index()] - (int)(i.race().pref().getWork(ins.blueprintI().employment()) * 256.0D);
/*     */       } else {
/* 367 */         (StatsWork.Work.access$2(StatsWork.Work.this)).fvalues[i.popCL().index()] = (StatsWork.Work.access$2(StatsWork.Work.this)).fvalues[i.popCL().index()] - (int)(i.race().pref().getWork(ins.blueprintI().employment()) * 256.0D);
/* 368 */       }  (StatsWork.Work.access$2(StatsWork.Work.this)).health.inc(i.hType(), i.race(), -((int)((StatsWork.Work.this.get(i).blueprintI().employment()).healthFactor * 256.0D)), -1);
/*     */     } 
/*     */ 
/*     */     
/* 372 */     super.removePrivate(i);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\colls\StatsWork$Work$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */