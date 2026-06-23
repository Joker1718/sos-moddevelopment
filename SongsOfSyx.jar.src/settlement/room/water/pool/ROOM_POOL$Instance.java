/*     */ package settlement.room.water.pool;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.util.FINDABLE;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.room.main.ROOMA;
/*     */ import settlement.room.main.ROOMS;
/*     */ import settlement.room.main.RoomBlueprint;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.RoomSingleton;
/*     */ import settlement.room.water.RoomPumpable;
/*     */ import snake2d.util.datatypes.COORDINATE;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Instance
/*     */   extends RoomSingleton
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private RoomPumpable pump;
/*     */   
/*     */   Instance(ROOMS m, RoomBlueprint p) {
/* 334 */     super(m, p);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 388 */     this.pump = new RoomPumpable()
/*     */       {
/*     */         protected int radius()
/*     */         {
/* 392 */           return 0;
/*     */         }
/*     */ 
/*     */         
/*     */         protected void pump(int tx, int ty, DIR d, int dirmask) {
/* 397 */           int da = (SETT.ROOMS()).extraBit.get(tx, ty);
/* 398 */           if ((da & 0x1) == 0) {
/* 399 */             da |= 0x1;
/* 400 */             (SETT.ROOMS()).extraBit.set(tx, ty, da);
/* 401 */             FINDABLE s = ROOM_POOL.Instance.this.blueprintI().fservice(tx, ty);
/* 402 */             if (s != null && s.findableReservedCanBe()) {
/* 403 */               (SETT.PATH()).finders.water.report(tx, ty, 1);
/*     */             }
/*     */           } 
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected void drain(int tx, int ty) {
/* 411 */           FINDABLE s = ROOM_POOL.Instance.this.blueprintI().fservice(tx, ty);
/* 412 */           if (s != null && s.findableReservedCanBe()) {
/* 413 */             (SETT.PATH()).finders.water.report(tx, ty, -1);
/*     */           }
/* 415 */           (SETT.ROOMS()).extraBit.set(tx, ty, 0);
/*     */         }
/*     */ 
/*     */         
/*     */         protected int dirmask(int tx, int ty) {
/* 420 */           return 0;
/*     */         }
/*     */ 
/*     */         
/*     */         protected boolean pumpsTo(int fromX, int fromY, int tx, int ty) {
/* 425 */           return ((SETT.ROOMS()).map.blueprint.get(tx, ty) == ROOM_POOL.Instance.this.blueprintI());
/*     */         }
/*     */ 
/*     */         
/*     */         public double irrigation(int tx, int ty) {
/* 430 */           return ((SETT.ROOMS()).extraBit.get(tx, ty) & 0x1);
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   protected Object readResolve() {
/*     */     return (blueprintI()).instance;
/*     */   }
/*     */   
/*     */   public ROOM_POOL blueprintI() {
/*     */     return (ROOM_POOL)blueprint();
/*     */   }
/*     */   
/*     */   public void updateTileDay(int tx, int ty) {}
/*     */   
/*     */   protected void removeAction(ROOMA ins) {
/*     */     for (COORDINATE c : ins.body()) {
/*     */       if (ins.is(c)) {
/*     */         (SETT.ROOMS()).extraBit.set(c, 0);
/*     */         RoomPumpable.reportChange(c.x(), c.y(), 0);
/*     */         if (((SETT.ROOMS()).extraBit.get(c.x(), c.y()) & 0x1) == 1) {
/*     */           FINDABLE s = blueprintI().fservice(c.x(), c.y());
/*     */           if (s != null && s.findableReservedCanBe())
/*     */             (SETT.PATH()).finders.water.report(c.x(), c.y(), -1); 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void addAction(ROOMA ins) {
/*     */     super.addAction(ins);
/*     */     for (COORDINATE c : ins.body()) {
/*     */       if (ins.is(c)) {
/*     */         (SETT.ROOMS()).extraBit.set(c, 0);
/*     */         RoomPumpable.reportChange(c.x(), c.y(), 0);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   protected AVAILABILITY getAvailability(int tile) {
/*     */     return AVAILABILITY.AVOID_PASS;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\water\pool\ROOM_POOL$Instance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */