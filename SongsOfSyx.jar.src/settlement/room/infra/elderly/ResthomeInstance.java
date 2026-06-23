/*     */ package settlement.room.infra.elderly;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.job.JOBMANAGER_HASER;
/*     */ import settlement.misc.job.JOB_MANAGER;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.TmpArea;
/*     */ import settlement.room.main.job.JobIterator;
/*     */ import settlement.room.main.util.RoomInit;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import util.GUTIL;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ final class ResthomeInstance extends RoomInstance implements JOBMANAGER_HASER {
/*     */   private static final long serialVersionUID = 1L;
/*     */   final Jobs jobs;
/*     */   
/*     */   protected ResthomeInstance(ROOM_RESTHOME blueprint, TmpArea area, RoomInit init) {
/*  24 */     super(blueprint, area, init);
/*     */     
/*  26 */     int work = 0;
/*  27 */     int open = 0;
/*     */     
/*  29 */     GUTIL.coos().set(0);
/*     */     
/*  31 */     for (COORDINATE c : body()) {
/*  32 */       if (is(c)) {
/*  33 */         if ((SETT.ROOMS()).fData.tileData.get(c) != 0) {
/*  34 */           blueprint.job.set(this, c.x(), c.y());
/*  35 */           work++; continue;
/*     */         } 
/*  37 */         if ((SETT.ROOMS()).fData.availability.get(c) == AVAILABILITY.ROOM) {
/*  38 */           GUTIL.coos().set(open).set(c);
/*  39 */           open++;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/*  44 */     int am = (int)blueprint.constructor.stations.get(this);
/*  45 */     am -= work;
/*  46 */     if (am > open) {
/*  47 */       am = open;
/*     */     }
/*  49 */     GUTIL.coos().shuffle(am);
/*     */     
/*  51 */     for (int i = 0; i < am; i++) {
/*  52 */       blueprint.job.set(this, GUTIL.coos().set(i).x(), GUTIL.coos().set(i).y());
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*  57 */     this.jobs = new Jobs(this);
/*  58 */     this.jobs.randomize();
/*  59 */     this.jobs.setAlwaysNewJob();
/*  60 */     employees().neededSet(am + work);
/*  61 */     employees().maxSet(am + work);
/*     */ 
/*     */ 
/*     */     
/*  65 */     activate();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean render(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator i) {
/*  71 */     i.lit();
/*  72 */     return super.render(r, shadowBatch, i);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void updateAction(double updateInterval, boolean day) {
/*  77 */     this.jobs.searchAgain();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void activateAction() {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected void deactivateAction() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public JOB_MANAGER getWork() {
/*  92 */     return (JOB_MANAGER)this.jobs;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dispose() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public ROOM_RESTHOME blueprintI() {
/* 102 */     return (ROOM_RESTHOME)blueprint();
/*     */   }
/*     */ 
/*     */   
/*     */   static class Jobs
/*     */     extends JobIterator
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */ 
/*     */     
/*     */     public Jobs(ResthomeInstance ins) {
/* 113 */       super(ins);
/*     */     }
/*     */ 
/*     */     
/*     */     protected SETT_JOB init(int tx, int ty) {
/* 118 */       return ((ROOM_RESTHOME)ins().blueprintI()).job.get(tx, ty);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\elderly\ResthomeInstance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */