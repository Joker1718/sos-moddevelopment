/*     */ package settlement.room.service.market;
/*     */ 
/*     */ import settlement.misc.job.JOBMANAGER_HASER;
/*     */ import settlement.misc.job.JOB_MANAGER;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import settlement.misc.util.RESOURCE_TILE;
/*     */ import settlement.misc.util.TILE_STORAGE;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.TmpArea;
/*     */ import settlement.room.main.job.JobIterator;
/*     */ import settlement.room.main.util.RoomInit;
/*     */ import settlement.room.main.util.RoomState;
/*     */ import settlement.room.service.food.eatery.RoomDistribution;
/*     */ import settlement.room.service.module.ROOM_SERVICER;
/*     */ import settlement.room.service.module.RoomService;
/*     */ import settlement.room.service.module.RoomServiceInstance;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ final class MarketInstance
/*     */   extends RoomInstance
/*     */   implements JOBMANAGER_HASER, RoomDistribution.RoomDistributionIns
/*     */ {
/*     */   private static final long serialVersionUID = -7063521835843676015L;
/*     */   boolean autoE = true;
/*     */   private final JobIterator jobs;
/*     */   final RoomServiceInstance service;
/*     */   final RoomDistribution.InstanceData distData;
/*     */   
/*     */   MarketInstance(ROOM_MARKET p, TmpArea area, RoomInit init) {
/*  34 */     super(p, area, init);
/*     */     
/*  36 */     int maxAmount = (int)(blueprintI()).constructor.storage.get(this);
/*  37 */     this.jobs = new JobIterator(this)
/*     */       {
/*     */         private static final long serialVersionUID = 1L;
/*     */         
/*     */         protected SETT_JOB init(int tx, int ty) {
/*  42 */           return (MarketInstance.this.blueprintI()).dist.job(tx, ty);
/*     */         }
/*     */       };
/*  45 */     this.jobs.setAlwaysNewJob();
/*     */     
/*  47 */     int m = 0;
/*  48 */     for (COORDINATE c : body()) {
/*  49 */       if (is(c) && (blueprintI()).constructor.isCrate(c.x(), c.y())) {
/*  50 */         m++;
/*     */       }
/*     */     } 
/*  53 */     this.service = new RoomServiceInstance(m, (RoomService)(blueprintI()).service);
/*  54 */     employees().maxSet(m);
/*  55 */     employees().neededSet((int)Math.ceil((blueprintI()).constructor.workers.get(this)));
/*  56 */     this.distData = p.dist.makeData(maxAmount);
/*  57 */     activate();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean render(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator it) {
/*  63 */     super.render(r, shadowBatch, it);
/*  64 */     it.lit();
/*  65 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void updateAction(double ds, boolean day) {
/*  70 */     if (day)
/*  71 */       this.service.updateDay(); 
/*  72 */     this.jobs.searchAgain();
/*  73 */     if (!active() || employees().employed() <= 0) {
/*     */       return;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dispose() {
/*  84 */     this.service.dispose((RoomService)(blueprintI()).service);
/*  85 */     distributionNlueData().dispose(this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ROOM_MARKET blueprintI() {
/*  91 */     return (ROOM_MARKET)blueprint();
/*     */   }
/*     */ 
/*     */   
/*     */   public RESOURCE_TILE resourceTile(int tx, int ty) {
/*  96 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public TILE_STORAGE storage(int tx, int ty) {
/* 101 */     return null;
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
/*     */   
/*     */   public JOB_MANAGER getWork() {
/* 118 */     return (JOB_MANAGER)this.jobs;
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomServiceInstance service() {
/* 123 */     return this.service;
/*     */   }
/*     */ 
/*     */   
/*     */   public double quality() {
/* 128 */     return ROOM_SERVICER.defQuality(this, 1.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomState makeState(int tx, int ty, boolean broken) {
/* 133 */     return (RoomState)distributionNlueData().makeState(this, broken);
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomDistribution.InstanceData distributionData() {
/* 138 */     return this.distData;
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomDistribution distributionNlueData() {
/* 143 */     return (blueprintI()).dist;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\market\MarketInstance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */