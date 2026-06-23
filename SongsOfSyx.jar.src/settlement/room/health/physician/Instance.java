/*     */ package settlement.room.health.physician;
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
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ final class Instance
/*     */   extends RoomInstance implements JOBMANAGER_HASER, ROOM_SERVICER {
/*     */   private static final long serialVersionUID = 1L;
/*     */   final JobPositions<Instance> jobs;
/*     */   
/*     */   protected Instance(ROOM_PHYSICIAN b, TmpArea area, RoomInit init) {
/*  25 */     super(b, area, init);
/*     */     
/*  27 */     this.jobs = new Jobs(this);
/*  28 */     this.jobs.setAlwaysNew();
/*  29 */     this.service = new RoomServiceInstance(this.jobs.size(), (RoomService)(blueprintI()).data);
/*  30 */     employees().maxSet((int)Math.ceil((blueprintI()).constructor.workers.get(this)));
/*  31 */     employees().neededSet(employees().max());
/*  32 */     activate();
/*     */   }
/*     */   final RoomServiceInstance service;
/*     */   boolean auto = true;
/*     */   
/*     */   protected boolean render(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator it) {
/*  38 */     it.lit();
/*  39 */     return super.render(r, shadowBatch, it);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void activateAction() {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void deactivateAction() {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateAction(double updateInterval, boolean day) {
/*  55 */     this.jobs.searchAgain();
/*  56 */     if (day) {
/*  57 */       this.service.updateDay();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public JOB_MANAGER getWork() {
/*  63 */     return (JOB_MANAGER)this.jobs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dispose() {
/*  70 */     for (COORDINATE c : body()) {
/*  71 */       if (is(c))
/*  72 */         (blueprintI()).s.dispose(this, c.x(), c.y()); 
/*     */     } 
/*  74 */     this.service.dispose((RoomService)(blueprintI()).data);
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomServiceInstance service() {
/*  79 */     return this.service;
/*     */   }
/*     */ 
/*     */   
/*     */   public double quality() {
/*  84 */     return ROOM_SERVICER.defQuality(this, (blueprintI()).constructor.quality.get(this));
/*     */   }
/*     */ 
/*     */   
/*     */   public ROOM_PHYSICIAN blueprintI() {
/*  89 */     return (ROOM_PHYSICIAN)blueprint();
/*     */   }
/*     */   
/*     */   private static class Jobs
/*     */     extends JobPositions<Instance> {
/*     */     private static final long serialVersionUID = 1L;
/*     */     
/*     */     public Jobs(Instance ins) {
/*  97 */       super(ins);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected boolean isAndInit(int tx, int ty) {
/* 103 */       return ((((Instance)this.ins).blueprintI()).s.getJ(tx, ty) != null);
/*     */     }
/*     */ 
/*     */     
/*     */     protected SETT_JOB get(int tx, int ty) {
/* 108 */       return (((Instance)this.ins).blueprintI()).s.getJ(tx, ty);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\health\physician\Instance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */