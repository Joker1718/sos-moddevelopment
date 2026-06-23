/*     */ package settlement.room.service.stage;
/*     */ 
/*     */ import settlement.misc.job.JOBMANAGER_HASER;
/*     */ import settlement.misc.job.JOB_MANAGER;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.TmpArea;
/*     */ import settlement.room.main.job.JobPositions;
/*     */ import settlement.room.main.util.RoomInit;
/*     */ import settlement.room.service.module.ROOM_SERVICER;
/*     */ import settlement.room.service.module.RoomService;
/*     */ import settlement.room.service.module.RoomServiceInstance;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ final class StageInstance extends RoomInstance implements JOBMANAGER_HASER, ROOM_SERVICER {
/*     */   private static final long serialVersionUID = 1L;
/*  22 */   final byte off = (byte)RND.rInt(64); final RoomServiceInstance service;
/*  23 */   private final Job job = new Job(this);
/*     */   
/*     */   private short workers;
/*  26 */   private short services = 0;
/*     */   
/*     */   protected StageInstance(ROOM_STAGE b, TmpArea area, RoomInit init) {
/*  29 */     super(b, area, init);
/*     */     
/*  31 */     this.service = new RoomServiceInstance((int)b.constructor.spectators.get(this), (RoomService)(blueprintI()).data);
/*     */     
/*  33 */     employees().maxSet(this.job.size());
/*  34 */     employees().neededSet(this.job.size());
/*  35 */     activate();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean render(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator it) {
/*  41 */     it.lit();
/*  42 */     return super.render(r, shadowBatch, it);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void updateAction(double updateInterval, boolean day) {
/*  47 */     if (active()) {
/*  48 */       if (employees().employed() == 0) {
/*  49 */         if (this.workers > 0) {
/*  50 */           this.workers = (short)(this.workers - 1);
/*  51 */           if (this.workers == 0) {
/*  52 */             setServices(0);
/*     */           }
/*     */         }
/*     */       
/*  56 */       } else if (this.workers < 10) {
/*  57 */         this.workers = 10;
/*  58 */         setServices(this.service.total());
/*     */       } 
/*     */     }
/*     */     
/*  62 */     if (day) {
/*  63 */       this.service.updateDay();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected void activateAction() {
/*  69 */     if (this.workers > 0) {
/*  70 */       setServices(this.service.total());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void deactivateAction() {
/*  77 */     setServices(0);
/*  78 */     this.workers = 0;
/*     */   }
/*     */   
/*     */   void incServices(int s) {
/*  82 */     if (this.workers > 0)
/*  83 */       setServices(this.services + s); 
/*     */   }
/*     */   
/*     */   boolean hasService() {
/*  87 */     return (this.workers > 0);
/*     */   }
/*     */   
/*     */   private void setServices(int s) {
/*  91 */     this.service.report((blueprintI()).work.service(body().cX(), body().cY()), (RoomService)(blueprintI()).data, -this.services, false);
/*  92 */     this.services = (short)CLAMP.i(s, 0, this.service.total());
/*  93 */     this.service.report((blueprintI()).work.service(body().cX(), body().cY()), (RoomService)(blueprintI()).data, this.services, true);
/*     */   }
/*     */   
/*     */   int services() {
/*  97 */     return this.services;
/*     */   }
/*     */ 
/*     */   
/*     */   public JOB_MANAGER getWork() {
/* 102 */     return (JOB_MANAGER)this.job;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void dispose() {
/* 107 */     this.service.dispose((RoomService)(blueprintI()).data);
/*     */   }
/*     */ 
/*     */   
/*     */   public ROOM_STAGE blueprintI() {
/* 112 */     return (ROOM_STAGE)blueprint();
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomServiceInstance service() {
/* 117 */     return this.service;
/*     */   }
/*     */ 
/*     */   
/*     */   public double quality() {
/* 122 */     return ROOM_SERVICER.defQuality(this, employees().employed() / employees().max());
/*     */   }
/*     */ 
/*     */   
/*     */   private static class Job
/*     */     extends JobPositions<StageInstance>
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */ 
/*     */     
/*     */     public Job(StageInstance ins) {
/* 133 */       super(ins);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected boolean isAndInit(int tx, int ty) {
/* 139 */       return ((((StageInstance)this.ins).blueprintI()).work.job(tx, ty) != null);
/*     */     }
/*     */ 
/*     */     
/*     */     protected SETT_JOB get(int tx, int ty) {
/* 144 */       return (((StageInstance)this.ins).blueprintI()).work.job(tx, ty);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\stage\StageInstance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */