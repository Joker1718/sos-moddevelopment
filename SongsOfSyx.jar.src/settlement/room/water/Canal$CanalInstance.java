/*     */ package settlement.room.water;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import settlement.maintenance.ROOM_DEGRADER;
/*     */ import settlement.room.main.ROOMA;
/*     */ import settlement.room.main.ROOMS;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomBlueprint;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.RoomSingleton;
/*     */ import settlement.room.main.util.RoomAreaWrapper;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class CanalInstance
/*     */   extends RoomSingleton
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/* 294 */   private static final transient RoomAreaWrapper wrap = new RoomAreaWrapper();
/*     */   
/*     */   CanalInstance(ROOMS m, RoomBlueprint p) {
/* 297 */     super(m, p);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 334 */     this.pump = new RoomPumpable()
/*     */       {
/*     */         public void drain(int tx, int ty)
/*     */         {
/* 338 */           Canal.CanalInstance.wrap.init((Room)Canal.CanalInstance.this, tx, ty);
/* 339 */           (SETT.ROOMS()).data.set(Canal.CanalInstance.wrap.area(), tx, ty, 0);
/* 340 */           Canal.CanalInstance.wrap.done();
/*     */         }
/*     */ 
/*     */         
/*     */         public void pump(int tx, int ty, DIR d, int dirmask) {
/* 345 */           Canal.CanalInstance.wrap.init((Room)Canal.CanalInstance.this, tx, ty);
/* 346 */           int da = (SETT.ROOMS()).data.get(tx, ty);
/* 347 */           da |= d.mask();
/* 348 */           (SETT.ROOMS()).data.set(Canal.CanalInstance.wrap.area(), tx, ty, da);
/* 349 */           Canal.CanalInstance.wrap.done();
/* 350 */           if ((dirmask & 0xF) != (dirmask(tx, ty) & 0xF)) {
/* 351 */             (SETT.ENV()).map.setChanged(tx, ty, (SETT.ENV()).map.WATER_SWEET);
/*     */           }
/*     */         }
/*     */ 
/*     */         
/*     */         protected void pumpFail(int tx, int ty, int dirmask) {
/* 357 */           if (dirmask != 0) {
/* 358 */             (SETT.ENV()).map.setChanged(tx, ty);
/*     */           }
/*     */         }
/*     */         
/*     */         public int dirmask(int tx, int ty) {
/* 363 */           return (SETT.ROOMS()).data.get(tx, ty) & 0xF;
/*     */         }
/*     */ 
/*     */         
/*     */         public int radius() {
/* 368 */           return 0;
/*     */         }
/*     */ 
/*     */         
/*     */         protected boolean pumpsTo(int fromX, int fromY, int tx, int ty) {
/* 373 */           return true;
/*     */         }
/*     */ 
/*     */         
/*     */         public double irrigation(int tx, int ty) {
/* 378 */           return (((SETT.ROOMS()).data.get(tx, ty) == 0) ? false : true);
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   private RoomPumpable pump;
/*     */   
/*     */   protected Object readResolve() {
/*     */     return (blueprintI()).instance;
/*     */   }
/*     */   
/*     */   public Canal blueprintI() {
/*     */     return (Canal)blueprint();
/*     */   }
/*     */   
/*     */   public ROOM_DEGRADER degrader(int tx, int ty) {
/*     */     return null;
/*     */   }
/*     */   
/*     */   public void updateTileDay(int tx, int ty) {}
/*     */   
/*     */   protected void removeAction(ROOMA ins) {
/*     */     super.removeAction(ins);
/*     */     RoomPumpable.reportChange(ins.mX(), ins.mY(), 0);
/*     */   }
/*     */   
/*     */   protected void addAction(ROOMA ins) {
/*     */     super.removeAction(ins);
/*     */     RoomPumpable.reportChange(ins.mX(), ins.mY(), 0);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\water\Canal$CanalInstance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */