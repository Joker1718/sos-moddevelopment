/*     */ package settlement.job;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.throne.THRONE;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.PathUtilOnline;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import util.GUTIL;
/*     */ import util.updating.IUpdater;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends IUpdater
/*     */ {
/*     */   null(int $anonymous0, double $anonymous1) {
/*  41 */     super($anonymous0, $anonymous1);
/*     */   }
/*     */   
/*     */   protected void update(int i, double timeSinceLast) {
/*  45 */     if (BlockedJobs.this.free.size() == 0) {
/*     */       return;
/*     */     }
/*  48 */     Job job = (Job)(SETT.JOBS()).getter.get(i);
/*  49 */     if (job == null) {
/*     */       return;
/*     */     }
/*  52 */     if (job instanceof JobClear) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/*  57 */     int tx = i % SETT.TWIDTH;
/*  58 */     int ty = i / SETT.THEIGHT;
/*  59 */     if ((SETT.PATH()).reachability.is(tx, ty)) {
/*     */       return;
/*     */     }
/*  62 */     if ((SETT.JOBS()).state.get(tx, ty) == StateManager.State.DORMANT) {
/*     */       return;
/*     */     }
/*  65 */     if (job.jobResourceBitToFetch() != null && !job.jobResourceBitToFetch().isClear() && !(SETT.PATH()).finders.resource.has(THRONE.coo().x(), THRONE.coo().y(), job.jobResourceBitToFetch())) {
/*     */       return;
/*     */     }
/*  68 */     for (BlockedJobs.BlockedJob j : BlockedJobs.this.active) {
/*  69 */       if (j.blocked.isSameAs(tx, ty)) {
/*     */         return;
/*     */       }
/*     */     } 
/*  73 */     PathUtilOnline.Flooder f = GUTIL.flooder();
/*     */     
/*  75 */     f.init(this);
/*  76 */     f.pushSloppy(tx, ty, 0.0D);
/*  77 */     while (f.hasMore()) {
/*  78 */       PathTile t = GUTIL.flooder().pollSmallest();
/*     */       
/*  80 */       if (t.getValue() > 16.0F) {
/*     */         break;
/*     */       }
/*  83 */       if ((SETT.PATH()).reachability.is((COORDINATE)t)) {
/*  84 */         BlockedJobs.BlockedJob j = (BlockedJobs.BlockedJob)BlockedJobs.this.free.removeLast();
/*  85 */         j.blocked.set(tx, ty);
/*  86 */         j.coo.set((COORDINATE)t);
/*  87 */         BlockedJobs.this.active.add(j);
/*  88 */         f.done();
/*     */         
/*     */         return;
/*     */       } 
/*  92 */       for (DIR d : DIR.ALL) {
/*  93 */         if (SETT.IN_BOUNDS((COORDINATE)t, d)) {
/*  94 */           f.pushSmaller((COORDINATE)t, d, t.getValue() + d.tileDistance());
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 101 */     f.done();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\job\BlockedJobs$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */