/*     */ package settlement.room.law.execution;
/*     */ 
/*     */ import settlement.path.finders.SFinderRoomService;
/*     */ import settlement.room.service.module.ROOM_ACTIVITY;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends ROOM_ACTIVITY
/*     */ {
/*  97 */   private Coo coo = new Coo();
/*     */ 
/*     */   
/*     */   public SFinderRoomService finder() {
/* 101 */     return ROOM_EXECTUTION.this.data;
/*     */   }
/*     */ 
/*     */   
/*     */   public COORDINATE lookAt(int sx, int sy) {
/* 106 */     this.coo.set((sx * 64 + 32), (sy * 64 + 32));
/* 107 */     return (COORDINATE)this.coo;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean is(int sx, int sy) {
/* 112 */     return ROOM_EXECTUTION.this.is(sx, sy);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean shouldCheer(int sx, int sy) {
/* 117 */     ExecutionStation.Client s = ROOM_EXECTUTION.this.stations.client(sx, sy);
/* 118 */     if (s != null) {
/* 119 */       return s.clientBeingExecuted();
/*     */     }
/* 121 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean shouldBoo(int sx, int sy) {
/* 126 */     ExecutionStation.Guard s = ROOM_EXECTUTION.this.stations.guard(sx, sy);
/* 127 */     if (s != null) {
/* 128 */       return s.shouldExecute();
/*     */     }
/* 130 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isActive(int sx, int sy) {
/* 135 */     ExecutionStation.Client s = ROOM_EXECTUTION.this.stations.client(sx, sy);
/* 136 */     return (s != null && s.clientPresent());
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\law\execution\ROOM_EXECTUTION$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */