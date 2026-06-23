/*     */ package settlement.path.finders;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.util.FINDABLE;
/*     */ import settlement.path.path.SPath;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.water.pool.ROOM_POOL;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import util.GUTIL;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class SFinderWater
/*     */   extends SFinderFindable
/*     */ {
/*     */   SFinderWater() {
/*  20 */     super("water");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean findLand(COORDINATE start, SPath path, int maxDistance) {
/*  26 */     int tx = start.x();
/*  27 */     int ty = start.y();
/*  28 */     if (isLand(tx, ty)) {
/*  29 */       path.request(tx, ty, tx, ty, false);
/*  30 */       return path.isSuccessful();
/*     */     } 
/*     */     
/*  33 */     GUTIL.flooder().init(this);
/*  34 */     PathTile t = GUTIL.flooder().pushSloppy(tx, ty, 0.0D);
/*     */ 
/*     */     
/*  37 */     while (GUTIL.flooder().hasMore()) {
/*  38 */       t = GUTIL.flooder().pollSmallest();
/*  39 */       if (isLand(t.x(), t.y())) {
/*  40 */         GUTIL.flooder().done();
/*  41 */         path.setDirect(start.x(), start.y(), t.x(), t.y(), t, true);
/*  42 */         return true;
/*     */       } 
/*  44 */       if (t.getValue() > maxDistance) {
/*     */         continue;
/*     */       }
/*  47 */       for (DIR d : DIR.ALL) {
/*  48 */         double v = t.getValue();
/*  49 */         tx = t.x() + d.x();
/*  50 */         ty = t.y() + d.y();
/*     */         
/*  52 */         if (isLand(tx, ty) && (SETT.PATH()).coster.player.getCost(t.x(), t.y(), tx, ty) > 0.0D) {
/*  53 */           if ((SETT.PATH()).connectivity.is(tx, ty)) {
/*  54 */             GUTIL.flooder().pushSloppy(tx, ty, v + 1.0D, t); continue;
/*     */           } 
/*  56 */           GUTIL.flooder().pushSloppy(tx, ty, v + 100.0D, t); continue;
/*     */         } 
/*  58 */         if (isWater(tx, ty)) {
/*  59 */           GUTIL.flooder().pushSloppy(tx, ty, v + 1.0D, t);
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  65 */     GUTIL.flooder().done();
/*  66 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean isLand(int tx, int ty) {
/*  71 */     return (!isWater(tx, ty) && !(SETT.PATH()).solidity.is(tx, ty));
/*     */   }
/*     */   
/*     */   private boolean isWater(int tx, int ty) {
/*  75 */     return (SETT.ENTITIES()).submerged.is(tx, ty);
/*     */   }
/*     */   
/*     */   public FINDABLE get(int tx, int ty) {
/*  79 */     FINDABLE s = (FINDABLE)(SETT.TERRAIN()).WATER.service.get(tx, ty);
/*  80 */     if (s != null)
/*  81 */       return s; 
/*  82 */     Room r = (SETT.ROOMS()).map.get(tx, ty);
/*  83 */     if (r != null && r.blueprint() instanceof ROOM_POOL) {
/*  84 */       FINDABLE f = ((ROOM_POOL)r.blueprint()).fservice(tx, ty);
/*  85 */       if (f != null)
/*  86 */         return f; 
/*     */     } 
/*  88 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public FINDABLE getReservable(int tx, int ty) {
/*  93 */     FINDABLE f = get(tx, ty);
/*  94 */     if (f != null && f.findableReservedCanBe())
/*  95 */       return f; 
/*  96 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public FINDABLE getReserved(int tx, int ty) {
/* 101 */     FINDABLE f = get(tx, ty);
/* 102 */     if (f != null && f.findableReservedIs())
/* 103 */       return f; 
/* 104 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\finders\SFinderWater.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */