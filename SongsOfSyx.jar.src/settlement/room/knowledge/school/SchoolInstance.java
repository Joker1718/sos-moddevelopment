/*     */ package settlement.room.knowledge.school;
/*     */ 
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.misc.job.JOBMANAGER_HASER;
/*     */ import settlement.misc.job.JOB_MANAGER;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import settlement.room.industry.module.Industry;
/*     */ import settlement.room.industry.module.IndustryResource;
/*     */ import settlement.room.industry.module.ROOM_IDATA_INSTANCE;
/*     */ import settlement.room.industry.module.ROOM_PRODUCER_INSTANCE;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.TmpArea;
/*     */ import settlement.room.main.job.JobPositions;
/*     */ import settlement.room.main.util.RoomInit;
/*     */ import settlement.room.service.module.ROOM_SERVICER;
/*     */ import settlement.room.service.module.RoomServiceInstance;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ final class SchoolInstance
/*     */   extends RoomInstance implements JOBMANAGER_HASER, ROOM_PRODUCER_INSTANCE, ROOM_SERVICER {
/*     */   private static final long serialVersionUID = 1L;
/*     */   final Jobs jobs;
/*     */   
/*     */   protected SchoolInstance(ROOM_SCHOOL blueprint, TmpArea area, RoomInit init) {
/*  29 */     super(blueprint, area, init);
/*  30 */     this.jobs = new Jobs(this);
/*  31 */     this.service = new RoomServiceInstance(this.jobs.size(), blueprint.service);
/*     */     
/*  33 */     employees().neededSet((int)Math.ceil((this.jobs.size() / 8)));
/*  34 */     employees().maxSet((int)Math.ceil((this.jobs.size() / 3)));
/*  35 */     this.jobs.randomize();
/*  36 */     this.pdata = blueprint.industry.makeData();
/*  37 */     activate();
/*     */   }
/*     */   private long[] pdata; private final RoomServiceInstance service;
/*     */   
/*     */   protected void loadFix() {
/*  42 */     this.pdata = industry().makeDataFix(this.pdata);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean render(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator i) {
/*  47 */     i.lit();
/*  48 */     return super.render(r, shadowBatch, i);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void updateAction(double updateInterval, boolean day) {
/*  53 */     (blueprintI()).industry.updateRoom((ROOM_IDATA_INSTANCE)this);
/*  54 */     if (day)
/*  55 */       this.service.updateDay(); 
/*  56 */     this.jobs.searchAgain();
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
/*  71 */     return (JOB_MANAGER)this.jobs;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void dispose() {
/*  76 */     for (COORDINATE c : body()) {
/*  77 */       if (is(c)) {
/*  78 */         (blueprintI()).station.dispose(c.x(), c.y());
/*     */       }
/*     */     } 
/*  81 */     this.service.dispose((blueprintI()).service);
/*     */   }
/*     */ 
/*     */   
/*     */   public ROOM_SCHOOL blueprintI() {
/*  86 */     return (ROOM_SCHOOL)blueprint();
/*     */   }
/*     */ 
/*     */   
/*     */   public long[] productionData() {
/*  91 */     return this.pdata;
/*     */   }
/*     */ 
/*     */   
/*     */   public Industry industry() {
/*  96 */     return (Industry)blueprintI().industries().get(0);
/*     */   }
/*     */ 
/*     */   
/*     */   static class Jobs
/*     */     extends JobPositions<SchoolInstance>
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */ 
/*     */     
/*     */     public Jobs(SchoolInstance ins) {
/* 107 */       super(ins);
/*     */     }
/*     */ 
/*     */     
/*     */     protected SETT_JOB get(int tx, int ty) {
/* 112 */       return (((SchoolInstance)this.ins).blueprintI()).station.job(tx, ty);
/*     */     }
/*     */ 
/*     */     
/*     */     protected boolean isAndInit(int tx, int ty) {
/* 117 */       return ((((SchoolInstance)this.ins).blueprintI()).station.job(tx, ty) != null);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public RoomServiceInstance service() {
/* 124 */     return this.service;
/*     */   }
/*     */ 
/*     */   
/*     */   public double quality() {
/* 129 */     return ROOM_SERVICER.defQuality(this, (blueprintI()).constructor.quality.get(this));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int industryI() {
/* 135 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public double productionRate(RoomInstance ins, Humanoid h, Industry in, IndustryResource oo) {
/* 140 */     double d = this.service.load() * this.service.total();
/* 141 */     return d;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\knowledge\school\SchoolInstance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */