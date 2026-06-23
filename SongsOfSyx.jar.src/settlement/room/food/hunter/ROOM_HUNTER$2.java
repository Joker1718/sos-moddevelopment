/*     */ package settlement.room.food.hunter;
/*     */ 
/*     */ import settlement.room.industry.module.RoomBoost;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import util.info.INFO;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   implements RoomBoost
/*     */ {
/*  82 */   INFO info = new INFO(ROOM_HUNTER.¤¤luck, ROOM_HUNTER.¤¤luckD);
/*     */   
/*     */   public INFO info() {
/*  85 */     return this.info;
/*     */   }
/*     */ 
/*     */   
/*     */   public double get(RoomInstance r) {
/*  90 */     return ROOM_HUNTER.this.luck;
/*     */   }
/*     */ 
/*     */   
/*     */   public double min() {
/*  95 */     return 0.6D;
/*     */   }
/*     */ 
/*     */   
/*     */   public double max() {
/* 100 */     return 1.4D;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\food\hunter\ROOM_HUNTER$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */