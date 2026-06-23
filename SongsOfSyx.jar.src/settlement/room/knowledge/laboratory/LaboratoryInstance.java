/*     */ package settlement.room.knowledge.laboratory;
/*     */ 
/*     */ import settlement.misc.job.JOBMANAGER_HASER;
/*     */ import settlement.misc.job.JOB_MANAGER;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import settlement.room.industry.module.ROOM_IDATA_INSTANCE;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.TmpArea;
/*     */ import settlement.room.main.job.JobPositions;
/*     */ import settlement.room.main.util.RoomInit;
/*     */ import snake2d.Renderer;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ final class LaboratoryInstance extends RoomInstance implements JOBMANAGER_HASER, ROOM_IDATA_INSTANCE {
/*     */   private static final long serialVersionUID = 1L;
/*     */   final Jobs jobs;
/*     */   private long[] pdata;
/*     */   
/*     */   protected LaboratoryInstance(ROOM_LABORATORY blueprint, TmpArea area, RoomInit init) {
/*  22 */     super(blueprint, area, init);
/*  23 */     this.pdata = blueprint.consumption().makeData();
/*  24 */     this.jobs = new Jobs(this);
/*     */     
/*  26 */     employees().neededSet((int)Math.ceil(blueprint.constructor.workers.get(this)));
/*  27 */     employees().maxSet(this.jobs.size());
/*     */     
/*  29 */     this.jobs.randomize();
/*     */     
/*  31 */     activate();
/*  32 */     (blueprintI()).data.incStations(this.jobs.size());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void loadFix() {
/*  38 */     this.pdata = blueprintI().consumption().makeDataFix(this.pdata);
/*     */   }
/*     */ 
/*     */   
/*     */   public long[] productionData() {
/*  43 */     return this.pdata;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean render(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator i) {
/*  50 */     i.lit();
/*  51 */     return super.render(r, shadowBatch, i);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void updateAction(double updateInterval, boolean day) {
/*  56 */     this.jobs.searchAgain();
/*  57 */     blueprintI().consumption().updateRoom(this);
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
/*     */   protected void dispose() {
/*  72 */     blueprintI().consumption().releaseResources(this, this);
/*  73 */     (blueprintI()).data.incStations(-this.jobs.size());
/*     */   }
/*     */ 
/*     */   
/*     */   public JOB_MANAGER getWork() {
/*  78 */     return (JOB_MANAGER)this.jobs;
/*     */   }
/*     */ 
/*     */   
/*     */   public ROOM_LABORATORY blueprintI() {
/*  83 */     return (ROOM_LABORATORY)blueprint();
/*     */   }
/*     */ 
/*     */   
/*     */   static class Jobs
/*     */     extends JobPositions<LaboratoryInstance>
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */ 
/*     */     
/*     */     public Jobs(LaboratoryInstance ins) {
/*  94 */       super(ins);
/*     */     }
/*     */ 
/*     */     
/*     */     protected SETT_JOB get(int tx, int ty) {
/*  99 */       return (((LaboratoryInstance)this.ins).blueprintI()).job.get(tx, ty);
/*     */     }
/*     */ 
/*     */     
/*     */     protected boolean isAndInit(int tx, int ty) {
/* 104 */       return ((((LaboratoryInstance)this.ins).blueprintI()).job.get(tx, ty) != null);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\knowledge\laboratory\LaboratoryInstance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */