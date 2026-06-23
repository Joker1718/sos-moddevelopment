/*     */ package settlement.room.industry.module.consumption;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.faction.FResources;
/*     */ import init.resources.RESOURCE;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.room.industry.module.IndustryResource;
/*     */ import settlement.room.industry.module.IndustryUtil;
/*     */ import settlement.room.industry.module.ROOM_IDATA_INSTANCE;
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
/*     */ public final class IndustryResourceIn
/*     */   extends IndustryResource
/*     */ {
/*     */   public IndustryResourceIn(DataOSimple<ROOM_IDATA_INSTANCE> data, RESOURCE res, double rate, double AI, double AIRate) {
/* 141 */     super(data, paramRoomConsumptionAbs.allIns.size(), res, rate, AI, AIRate);
/* 142 */     paramRoomConsumptionAbs.allIns.add(this);
/* 143 */     paramRoomConsumptionAbs.inMap[this.resource.index()] = this;
/* 144 */     paramRoomConsumptionAbs.allRes.add(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public int inc(ROOM_IDATA_INSTANCE r, double amount, boolean record) {
/* 149 */     int old = (int)this.day.getD(r);
/* 150 */     this.day.incD(r, amount);
/* 151 */     int now = (int)this.day.getD(r);
/* 152 */     int d = now - old;
/* 153 */     if (record)
/* 154 */       GAME.player().res().inc(this.resource, FResources.RTYPE.PRODUCED, -d); 
/* 155 */     this.year.inc(r, d);
/* 156 */     this.history.inc(d);
/* 157 */     return d;
/*     */   }
/*     */ 
/*     */   
/*     */   protected double getEffort(Humanoid skill, ROOM_IDATA_INSTANCE r, double workSeconds) {
/* 162 */     return IndustryUtil.calcConsumptionRate(this.rateSeconds * workSeconds, skill, (RoomInstance)r, RoomConsumptionAbs.this);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\industry\module\consumption\RoomConsumptionAbs$IndustryResourceIn.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */