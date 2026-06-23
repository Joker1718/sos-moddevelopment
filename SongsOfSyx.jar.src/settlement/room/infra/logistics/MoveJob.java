/*     */ package settlement.room.infra.logistics;
/*     */ 
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.util.RESOURCE_TILE;
/*     */ import settlement.misc.util.TILE_STORAGE;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ 
/*     */ 
/*     */ public final class MoveJob
/*     */ {
/*  16 */   public static final MoveJob TMP = new MoveJob();
/*  17 */   private static final RBIT.RBITImp tmp = new RBIT.RBITImp();
/*  18 */   public final Coo source = new Coo();
/*  19 */   public final Coo dest = new Coo();
/*     */   public RESOURCE res;
/*     */   public int maxAm;
/*     */   public boolean stored;
/*     */   public boolean prio;
/*     */   
/*     */   public static interface ROOM_MOVEJOBBER
/*     */   {
/*     */     MoveJob moveJob(Humanoid param1Humanoid);
/*     */   }
/*     */   
/*     */   public static interface ROOM_MOVE_DEST
/*     */   {
/*     */     TILE_STORAGE destCrate(RBIT param1RBIT, int param1Int1, int param1Int2, int param1Int3);
/*     */     
/*     */     default TILE_STORAGE fetchToCrate(RESOURCE res, int desiredAm) {
/*  35 */       return destCrate(res.bit, 1, -1, -1);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     RBIT destSpaceMask();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     double storedD(RESOURCE param1RESOURCE);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     RBIT moveCapacity();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void cancel() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public static MoveJob fetch(RoomInstance ins, ROOM_MOVE_DEST accepter, int am, int radius, int ox, int oy, RBIT scatterd, RBIT stored) {
/*  62 */     if (scatterd.isClear() && stored.isClear()) {
/*  63 */       return null;
/*     */     }
/*  65 */     am = CLAMP.i(am, 1, 100);
/*     */     
/*  67 */     RESOURCE_TILE t = RESOURCE_TILE.GETTER.reservable(scatterd, stored, RBIT.NONE, ox, oy);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  74 */     if (t == null) {
/*  75 */       t = (SETT.PATH()).finders.resource.find(scatterd, stored, RBIT.NONE, ins, radius);
/*     */     }
/*  77 */     if (t == null) {
/*  78 */       return null;
/*     */     }
/*  80 */     TMP.source.set(t.x(), t.y());
/*     */     
/*  82 */     RESOURCE r = t.resource();
/*  83 */     TMP.stored = t.isStorage();
/*  84 */     TMP.prio = t.isPrio();
/*  85 */     TMP.res = r;
/*     */     
/*  87 */     tmp.clearSet(r.bit);
/*     */     
/*  89 */     TILE_STORAGE c = accepter.fetchToCrate(r, am);
/*     */     
/*  91 */     if (c == null) {
/*  92 */       return null;
/*     */     }
/*     */     
/*  95 */     am = Math.min(c.storageReservable(), am);
/*  96 */     if (am <= 0) {
/*  97 */       throw new RuntimeException();
/*     */     }
/*  99 */     TMP.maxAm = am;
/* 100 */     TMP.dest.set(c.x(), c.y());
/* 101 */     return TMP;
/*     */   }
/*     */   
/*     */   public static interface ROOM_MOVE_SOURCE {
/*     */     RESOURCE_TILE sourceCrate(RBIT param1RBIT, int param1Int1, int param1Int2, int param1Int3, double param1Double);
/*     */     
/*     */     RBIT sourceAmountMask();
/*     */     
/*     */     RBIT moveCapacity();
/*     */     
/*     */     int moveCapacityAm(RESOURCE param1RESOURCE);
/*     */     
/*     */     double storedD(RESOURCE param1RESOURCE);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\logistics\MoveJob.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */