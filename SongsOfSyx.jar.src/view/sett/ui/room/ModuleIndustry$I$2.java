/*     */ package view.sett.ui.room;
/*     */ 
/*     */ import game.time.TIMECYCLE;
/*     */ import settlement.room.industry.module.IndustryResource;
/*     */ import util.statistics.HISTORY_INT;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   implements HISTORY_INT
/*     */ {
/*     */   public TIMECYCLE time() {
/* 152 */     return os[0].history().time();
/*     */   }
/*     */ 
/*     */   
/*     */   public int historyRecords() {
/* 157 */     return os[0].history().historyRecords();
/*     */   }
/*     */ 
/*     */   
/*     */   public double getD(int fromZero) {
/* 162 */     return get(fromZero) / max();
/*     */   }
/*     */ 
/*     */   
/*     */   public int min() {
/* 167 */     return os[0].history().min();
/*     */   }
/*     */ 
/*     */   
/*     */   public int max() {
/* 172 */     return os[0].history().max();
/*     */   }
/*     */ 
/*     */   
/*     */   public int get(int fromZero) {
/* 177 */     int am = 0; byte b; int i; IndustryResource[] arrayOfIndustryResource;
/* 178 */     for (i = (arrayOfIndustryResource = os).length, b = 0; b < i; ) { IndustryResource industryResource = arrayOfIndustryResource[b];
/* 179 */       am += industryResource.history().get(fromZero); b++; }
/* 180 */      return am;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\ModuleIndustry$I$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */