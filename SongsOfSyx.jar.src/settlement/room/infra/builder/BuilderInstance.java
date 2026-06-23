/*    */ package settlement.room.infra.builder;
/*    */ 
/*    */ import game.time.TIME;
/*    */ import settlement.main.SETT;
/*    */ import settlement.maintenance.ROOM_DEGRADER;
/*    */ import settlement.path.AVAILABILITY;
/*    */ import settlement.room.main.ROOMA;
/*    */ import settlement.room.main.RoomBlueprintIns;
/*    */ import settlement.room.main.RoomInstance;
/*    */ import settlement.room.main.TmpArea;
/*    */ import settlement.room.main.job.ROOM_RADIUS;
/*    */ import settlement.room.main.util.RoomInit;
/*    */ 
/*    */ final class BuilderInstance extends RoomInstance implements ROOM_RADIUS.ROOM_RADIUS_INSTANCE {
/* 15 */   byte radius = 32; private static final long serialVersionUID = 1L;
/* 16 */   byte failHour = -1;
/*    */   
/*    */   BuilderInstance(ROOM_BUILDER blueprint, TmpArea area, RoomInit init) {
/* 19 */     super(blueprint, area, init);
/* 20 */     (SETT.ROOMS()).data.set((ROOMA)this, mX(), mY(), 0);
/* 21 */     employees().maxSet(20);
/* 22 */     employees().neededSet(1);
/* 23 */     activate();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void activateAction() {}
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void deactivateAction() {}
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void updateAction(double updateInterval, boolean day) {
/* 40 */     this.failHour = (byte)(TIME.hours().bitCurrent() - 1);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void dispose() {}
/*    */ 
/*    */ 
/*    */   
/*    */   public ROOM_BUILDER blueprintI() {
/* 51 */     return (SETT.ROOMS()).BUILDER;
/*    */   }
/*    */ 
/*    */   
/*    */   protected AVAILABILITY getAvailability(int tile) {
/* 56 */     return AVAILABILITY.AVOID_PASS;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean destroyTileCan(int tx, int ty) {
/* 61 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ROOM_DEGRADER degrader(int tx, int ty) {
/* 67 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public int radius() {
/* 72 */     return this.radius;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean searching() {
/* 77 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public byte radiusRaw() {
/* 82 */     return this.radius;
/*    */   }
/*    */ 
/*    */   
/*    */   public void radiusRawSet(byte r) {
/* 87 */     this.radius = r;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\builder\BuilderInstance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */