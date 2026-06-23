/*     */ package settlement.room.service.food.tavern;
/*     */ 
/*     */ import settlement.misc.job.JOBMANAGER_HASER;
/*     */ import settlement.misc.job.JOB_MANAGER;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.TmpArea;
/*     */ import settlement.room.main.job.JobPositions;
/*     */ import settlement.room.main.util.RoomInit;
/*     */ import settlement.room.service.food.eatery.RoomDistribution;
/*     */ import settlement.room.service.module.ROOM_SERVICER;
/*     */ import settlement.room.service.module.RoomService;
/*     */ import settlement.room.service.module.RoomServiceInstance;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ final class TavernInstance
/*     */   extends RoomInstance implements JOBMANAGER_HASER, RoomDistribution.RoomDistributionIns {
/*     */   private static final long serialVersionUID = 1L;
/*     */   final RoomServiceInstance service;
/*     */   final Jobs jobs;
/*     */   final RoomDistribution.InstanceData distData;
/*     */   boolean auto = true;
/*     */   
/*     */   protected TavernInstance(ROOM_TAVERN b, TmpArea area, RoomInit init) {
/*  29 */     super(b, area, init);
/*     */     
/*  31 */     this.jobs = new Jobs(this);
/*  32 */     this.jobs.setAlwaysNew();
/*     */     
/*  34 */     int sers = 0;
/*  35 */     for (COORDINATE c : body()) {
/*  36 */       if (is(c) && b.service(c.x(), c.y()) != null) {
/*  37 */         sers++;
/*     */       }
/*     */     } 
/*  40 */     this.distData = b.dist.makeData(sers);
/*     */     
/*  42 */     this.service = new RoomServiceInstance(sers, (RoomService)(blueprintI()).serviceData);
/*     */     
/*  44 */     employees().maxSet((int)Math.ceil(this.jobs.size() / 2.0D));
/*  45 */     employees().neededSet((int)Math.ceil(this.jobs.size() / 4.0D));
/*  46 */     activate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean render(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator i) {
/*  55 */     i.lit();
/*  56 */     return super.render(r, shadowBatch, i);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateAction(double updateInterval, boolean day) {
/*  62 */     if (day)
/*  63 */       this.service.updateDay(); 
/*  64 */     this.jobs.searchAgain();
/*  65 */     this.distData.update(distributionNlueData());
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
/*  80 */     return (JOB_MANAGER)this.jobs;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void dispose() {
/*  85 */     distributionNlueData().dispose(this);
/*  86 */     this.service.dispose((RoomService)(blueprintI()).serviceData);
/*     */   }
/*     */ 
/*     */   
/*     */   public ROOM_TAVERN blueprintI() {
/*  91 */     return (ROOM_TAVERN)blueprint();
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomServiceInstance service() {
/*  96 */     return this.service;
/*     */   }
/*     */ 
/*     */   
/*     */   public double quality() {
/* 101 */     return ROOM_SERVICER.defQuality(this, (blueprintI()).constructor.coziness.get(this));
/*     */   }
/*     */   
/*     */   static class Jobs
/*     */     extends JobPositions<TavernInstance> {
/*     */     private static final long serialVersionUID = 1L;
/*     */     
/*     */     public Jobs(TavernInstance ins) {
/* 109 */       super(ins);
/*     */     }
/*     */ 
/*     */     
/*     */     protected SETT_JOB get(int tx, int ty) {
/* 114 */       return (((TavernInstance)this.ins).blueprintI()).dist.job(tx, ty);
/*     */     }
/*     */ 
/*     */     
/*     */     protected boolean isAndInit(int tx, int ty) {
/* 119 */       return ((((TavernInstance)this.ins).blueprintI()).dist.job(tx, ty) != null);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomDistribution.InstanceData distributionData() {
/* 125 */     return this.distData;
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomDistribution distributionNlueData() {
/* 130 */     return (blueprintI()).dist;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\food\tavern\TavernInstance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */