/*     */ package settlement.room.service.barber;
/*     */ 
/*     */ import settlement.misc.job.JOBMANAGER_HASER;
/*     */ import settlement.misc.job.JOB_MANAGER;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import settlement.misc.util.FSERVICE;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.TmpArea;
/*     */ import settlement.room.main.job.JobPositions;
/*     */ import settlement.room.main.util.RoomInit;
/*     */ import settlement.room.service.module.ROOM_SERVICER;
/*     */ import settlement.room.service.module.RoomService;
/*     */ import settlement.room.service.module.RoomServiceInstance;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ final class Instance extends RoomInstance implements JOBMANAGER_HASER, ROOM_SERVICER {
/*     */   private static final long serialVersionUID = 1L;
/*     */   final Jobs jobs;
/*     */   final RoomServiceInstance service;
/*     */   boolean auto = true;
/*     */   
/*     */   protected Instance(ROOM_BARBER blueprint, TmpArea area, RoomInit init) {
/*  27 */     super(blueprint, area, init);
/*  28 */     this.jobs = new Jobs(this);
/*     */     
/*  30 */     this.service = new RoomServiceInstance(this.jobs.size(), (RoomService)(blueprintI()).data);
/*     */     
/*  32 */     employees().maxSet(this.jobs.size());
/*  33 */     employees().neededSet((int)Math.ceil(blueprint.constructor.workers.get(this)));
/*  34 */     activate();
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean render(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator i) {
/*  39 */     i.lit();
/*  40 */     return super.render(r, shadowBatch, i);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void updateAction(double updateInterval, boolean day) {
/*  45 */     if (day)
/*  46 */       this.service.updateDay(); 
/*  47 */     this.jobs.searchAgain();
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
/*  62 */     return (JOB_MANAGER)this.jobs;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void dispose() {
/*  67 */     for (int i = 0; i < this.jobs.size(); i++) {
/*  68 */       COORDINATE c = this.jobs.get(i);
/*  69 */       FSERVICE s = (blueprintI()).ll.service(c.x(), c.y());
/*  70 */       if (s.findableReservedCanBe()) {
/*  71 */         s.findableReserve();
/*     */       }
/*     */     } 
/*  74 */     this.service.dispose((RoomService)(blueprintI()).data);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ROOM_BARBER blueprintI() {
/*  80 */     return (ROOM_BARBER)blueprint();
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomServiceInstance service() {
/*  85 */     return this.service;
/*     */   }
/*     */ 
/*     */   
/*     */   public double quality() {
/*  90 */     return ROOM_SERVICER.defQuality(this, (blueprintI()).constructor.quality.get(this));
/*     */   }
/*     */   
/*     */   static class Jobs
/*     */     extends JobPositions<Instance> {
/*     */     private static final long serialVersionUID = 1L;
/*     */     
/*     */     public Jobs(Instance ins) {
/*  98 */       super(ins);
/*     */     }
/*     */ 
/*     */     
/*     */     protected SETT_JOB get(int tx, int ty) {
/* 103 */       return (((Instance)this.ins).blueprintI()).ll.job(tx, ty);
/*     */     }
/*     */ 
/*     */     
/*     */     protected boolean isAndInit(int tx, int ty) {
/* 108 */       return ((((Instance)this.ins).blueprintI()).ll.job(tx, ty) != null);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\barber\Instance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */