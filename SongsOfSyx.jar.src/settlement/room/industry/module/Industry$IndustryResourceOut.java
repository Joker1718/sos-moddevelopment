/*     */ package settlement.room.industry.module;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.faction.FResources;
/*     */ import init.resources.RESOURCE;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import util.data.DataOSimple;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class IndustryResourceOut
/*     */   extends IndustryResource
/*     */ {
/*     */   IndustryResourceOut(DataOSimple<ROOM_IDATA_INSTANCE> data, RESOURCE res, double rate, double AIRate, double AIRecovery) {
/* 193 */     super(data, paramIndustry.outs.size(), res, rate, AIRate, AIRecovery);
/* 194 */     paramIndustry.outs.add(this);
/* 195 */     paramIndustry.outMap[this.resource.index()] = this;
/* 196 */     Industry.access$0(paramIndustry).add(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public int inc(ROOM_IDATA_INSTANCE r, double amount, boolean record) {
/* 201 */     if (!Double.isFinite(amount)) {
/* 202 */       GAME.Warn("" + amount);
/* 203 */       return 0;
/*     */     } 
/* 205 */     if (!Double.isFinite(this.day.getD(r))) {
/* 206 */       this.day.setD(r, 0.0D);
/*     */     }
/*     */     
/* 209 */     int old = (int)this.day.getD(r);
/* 210 */     this.day.incD(r, amount);
/* 211 */     int now = (int)this.day.getD(r);
/* 212 */     int d = now - old;
/* 213 */     if (d != 0) {
/* 214 */       if (record)
/* 215 */         GAME.player().res().inc(this.resource, FResources.RTYPE.PRODUCED, d); 
/* 216 */       this.year.inc(r, d);
/* 217 */       this.history.inc(d);
/* 218 */       (GAME.count()).CRAFTED.inc(1);
/*     */     } 
/* 220 */     return d;
/*     */   }
/*     */ 
/*     */   
/*     */   protected double getEffort(Humanoid skill, ROOM_IDATA_INSTANCE r, double workSeconds) {
/* 225 */     return IndustryUtil.calcProductionRate(this.rateSeconds * workSeconds, skill, Industry.this, (RoomInstance)r);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\industry\module\Industry$IndustryResourceOut.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */