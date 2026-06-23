/*     */ package settlement.room.industry.module.consumption;
/*     */ 
/*     */ import settlement.room.industry.module.ROOM_IDATA_INSTANCE;
/*     */ import snake2d.util.file.Json;
/*     */ import util.data.DataOSimple;
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
/*     */ class ExtraInfo
/*     */ {
/*     */   public final double boost;
/*     */   public final INT_O.INT_OE<ROOM_IDATA_INSTANCE> enabled;
/*     */   public final INT_O.INT_OE<ROOM_IDATA_INSTANCE> amount;
/*     */   public final INT_O.INT_OE<ROOM_IDATA_INSTANCE> reserved;
/*     */   
/*     */   ExtraInfo(Json j, DataOSimple<ROOM_IDATA_INSTANCE> data) {
/* 136 */     this.boost = j.d("BONUS", 0.0D, 1000.0D);
/* 137 */     data.getClass(); this.enabled = (INT_O.INT_OE<ROOM_IDATA_INSTANCE>)new DataOSimple.DataBit(data);
/* 138 */     data.getClass(); this.amount = (INT_O.INT_OE<ROOM_IDATA_INSTANCE>)new DataOSimple.DataInt(data);
/* 139 */     data.getClass(); this.reserved = (INT_O.INT_OE<ROOM_IDATA_INSTANCE>)new DataOSimple.DataShort(data);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\industry\module\consumption\RoomConsumption$ExtraInfo.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */