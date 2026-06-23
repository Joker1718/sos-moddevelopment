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
/*     */ final class DrainInstance
/*     */   extends RoomSingleton
/*     */ {
/* 188 */   private static int radius = 10;
/* 189 */   private final Pump pump = new Pump();
/*     */ 
/*     */   
/*     */   private static final long serialVersionUID = 1L;
/*     */   
/* 194 */   private static final transient RoomAreaWrapper wrap = new RoomAreaWrapper();
/*     */   
/*     */   DrainInstance(ROOMS m, RoomBlueprint p) {
/* 197 */     super(m, p);
/*     */   }
/*     */ 
/*     */   
/*     */   protected Object readResolve() {
/* 202 */     return (blueprintI()).instance;
/*     */   }
/*     */ 
/*     */   
/*     */   public Drain blueprintI() {
/* 207 */     return (Drain)blueprint();
/*     */   }
/*     */ 
/*     */   
/*     */   public ROOM_DEGRADER degrader(int tx, int ty) {
/* 212 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateTileDay(int tx, int ty) {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected void removeAction(ROOMA ins) {
/* 222 */     super.removeAction(ins);
/* 223 */     RoomPumpable.reportChange(ins.mX(), ins.mY(), radius);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void addAction(ROOMA ins) {
/* 228 */     super.removeAction(ins);
/* 229 */     RoomPumpable.reportChange(ins.mX(), ins.mY(), radius);
/*     */   }
/*     */   
/*     */   private class Pump
/*     */     extends RoomPumpable
/*     */   {
/*     */     protected void drain(int tx, int ty) {
/* 236 */       Drain.DrainInstance.wrap.init((Room)Drain.DrainInstance.this, tx, ty);
/* 237 */       (SETT.ROOMS()).data.set(Drain.DrainInstance.wrap.area(), tx, ty, 0);
/* 238 */       Drain.DrainInstance.wrap.done();
/*     */     }
/*     */ 
/*     */     
/*     */     protected void pump(int tx, int ty, DIR d, int dirmask) {
/* 243 */       Drain.DrainInstance.wrap.init((Room)Drain.DrainInstance.this, tx, ty);
/* 244 */       int da = (SETT.ROOMS()).data.get(tx, ty);
/* 245 */       da |= d.mask();
/* 246 */       (SETT.ROOMS()).data.set(Drain.DrainInstance.wrap.area(), tx, ty, da);
/* 247 */       Drain.DrainInstance.wrap.done();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected int dirmask(int tx, int ty) {
/* 253 */       return (SETT.ROOMS()).data.get(tx, ty) & 0xF;
/*     */     }
/*     */ 
/*     */     
/*     */     protected int radius() {
/* 258 */       return Drain.DrainInstance.radius;
/*     */     }
/*     */ 
/*     */     
/*     */     protected boolean pumpsTo(int fromX, int fromY, int tx, int ty) {
/* 263 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     public double irrigation(int tx, int ty) {
/* 268 */       return (((SETT.ROOMS()).data.get(tx, ty) == 0) ? false : true);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\water\Drain$DrainInstance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */