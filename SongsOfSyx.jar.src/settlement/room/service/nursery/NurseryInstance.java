/*     */ package settlement.room.service.nursery;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.job.JOBMANAGER_HASER;
/*     */ import settlement.misc.job.JOB_MANAGER;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.TmpArea;
/*     */ import settlement.room.main.job.JobPositions;
/*     */ import settlement.room.main.util.RoomInit;
/*     */ import settlement.room.service.module.ROOM_SERVICER;
/*     */ import settlement.room.service.module.RoomServiceInstance;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import util.GUTIL;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ final class NurseryInstance extends RoomInstance implements JOBMANAGER_HASER, ROOM_SERVICER {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private final Jobs jobs;
/*     */   private final RoomServiceInstance service;
/*     */   
/*     */   protected NurseryInstance(ROOM_NURSERY blue, TmpArea area, RoomInit init) {
/*  26 */     super(blue, area, init);
/*     */     
/*  28 */     GUTIL.coos().set(0);
/*     */     
/*  30 */     for (COORDINATE c : body()) {
/*  31 */       if (!is(c))
/*     */         continue; 
/*  33 */       if ((SETT.ROOMS()).fData.tileData.get(c) == 1) {
/*  34 */         blue.ss.init(this, c.x(), c.y()); continue;
/*  35 */       }  if ((SETT.ROOMS()).fData.tileData.get(c) == 2) {
/*  36 */         GUTIL.coos().get().set(c);
/*  37 */         GUTIL.coos().inc();
/*     */       } 
/*     */     } 
/*     */     
/*  41 */     int carps = GUTIL.coos().getI();
/*  42 */     int cc = (int)Math.round(GUTIL.coos().getI() * 0.25D);
/*  43 */     GUTIL.coos().shuffle(carps);
/*  44 */     for (int i = 0; i < cc; i++) {
/*  45 */       GUTIL.coos().set(i);
/*  46 */       blue.ss.init(this, GUTIL.coos().get().x(), GUTIL.coos().get().y());
/*     */     } 
/*     */ 
/*     */     
/*  50 */     this.jobs = new Jobs(this);
/*     */     
/*  52 */     employees().maxSet(this.jobs.size());
/*  53 */     employees().neededSet((int)Math.ceil(blue.constructor.workers.get(this)));
/*  54 */     this.service = new RoomServiceInstance(this.jobs.size(), blue.service());
/*  55 */     System.out.println(this.jobs.size());
/*  56 */     activate();
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean render(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator it) {
/*  61 */     it.lit();
/*  62 */     return super.render(r, shadowBatch, it);
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
/*     */   protected void updateAction(double updateInterval, boolean day) {
/*  77 */     this.jobs.searchAgain();
/*  78 */     if (day) {
/*  79 */       this.service.updateDay();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateTileDay(int tx, int ty) {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dispose() {
/*  90 */     this.service.dispose((blueprintI()).service);
/*     */   }
/*     */   
/*     */   public ROOM_NURSERY blueprintI() {
/*  94 */     return (ROOM_NURSERY)blueprint();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public JobPositions<NurseryInstance> getWork() {
/* 100 */     return this.jobs;
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomServiceInstance service() {
/* 105 */     return this.service;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public double quality() {
/* 111 */     return ROOM_SERVICER.defQuality(this, 1.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   private static class Jobs
/*     */     extends JobPositions<NurseryInstance>
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */ 
/*     */     
/*     */     public Jobs(NurseryInstance ins) {
/* 122 */       super(ins);
/*     */     }
/*     */ 
/*     */     
/*     */     protected boolean isAndInit(int tx, int ty) {
/* 127 */       if (((NurseryInstance)this.ins).is(tx, ty))
/* 128 */         return ((((NurseryInstance)this.ins).blueprintI()).ss.job(tx, ty) != null); 
/* 129 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     protected SETT_JOB get(int tx, int ty) {
/* 134 */       if (((NurseryInstance)this.ins).is(tx, ty))
/* 135 */         return (((NurseryInstance)this.ins).blueprintI()).ss.job(tx, ty); 
/* 136 */       return null;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\nursery\NurseryInstance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */