/*     */ package settlement.room.service.food.eatery;
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
/*     */ import settlement.room.service.module.ROOM_SERVICER;
/*     */ import settlement.room.service.module.RoomService;
/*     */ import settlement.room.service.module.RoomServiceInstance;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ final class EateryInstance
/*     */   extends RoomInstance implements JOBMANAGER_HASER, RoomDistribution.RoomDistributionIns {
/*     */   private static final long serialVersionUID = -7063521835843676015L;
/*     */   boolean autoE = true;
/*     */   private final JobIterator jobs;
/*     */   final RoomServiceInstance service;
/*     */   final RoomDistribution.InstanceData distData;
/*     */   
/*     */   EateryInstance(ROOM_EATERY p, TmpArea area, RoomInit init) {
/*  31 */     super(p, area, init);
/*     */     
/*  33 */     int maxAmount = 2 * (int)(blueprintI()).constructor.storage.get(this);
/*  34 */     this.distData = p.dist.makeData(maxAmount);
/*  35 */     this.jobs = new JobIterator(this)
/*     */       {
/*     */         private static final long serialVersionUID = 1L;
/*     */         
/*     */         protected SETT_JOB init(int tx, int ty) {
/*  40 */           return (EateryInstance.this.blueprintI()).dist.job(tx, ty);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  45 */     int m = 0;
/*  46 */     for (COORDINATE c : body()) {
/*  47 */       if (is(c) && (blueprintI()).constructor.isCrate(c.x(), c.y()))
/*  48 */         m++; 
/*     */     } 
/*  50 */     this.service = new RoomServiceInstance(m, (RoomService)(blueprintI()).service);
/*  51 */     employees().maxSet(m);
/*  52 */     employees().neededSet((int)Math.ceil((blueprintI()).constructor.workers.get(this)));
/*  53 */     activate();
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean render(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator it) {
/*  58 */     super.render(r, shadowBatch, it);
/*  59 */     it.lit();
/*  60 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void loadFix() {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateAction(double ds, boolean day) {
/*  70 */     if (day)
/*  71 */       this.service.updateDay(); 
/*  72 */     this.distData.update(distributionNlueData());
/*  73 */     this.jobs.searchAgain();
/*  74 */     if (!active() || employees().employed() <= 0) {
/*     */       return;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateTileDay(int tx, int ty) {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dispose() {
/*  87 */     distributionNlueData().dispose(this);
/*  88 */     this.service.dispose((RoomService)(blueprintI()).service);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ROOM_EATERY blueprintI() {
/*  94 */     return (ROOM_EATERY)blueprint();
/*     */   }
/*     */ 
/*     */   
/*     */   public RESOURCE_TILE resourceTile(int tx, int ty) {
/*  99 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public TILE_STORAGE storage(int tx, int ty) {
/* 104 */     return null;
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
/* 121 */     return (JOB_MANAGER)this.jobs;
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomServiceInstance service() {
/* 126 */     return this.service;
/*     */   }
/*     */ 
/*     */   
/*     */   public double quality() {
/* 131 */     return ROOM_SERVICER.defQuality(this, 1.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomState makeState(int tx, int ty, boolean broken) {
/* 136 */     return (RoomState)distributionNlueData().makeState(this, broken);
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomDistribution.InstanceData distributionData() {
/* 141 */     return this.distData;
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomDistribution distributionNlueData() {
/* 146 */     return (blueprintI()).dist;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\food\eatery\EateryInstance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */