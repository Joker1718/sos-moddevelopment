/*     */ package settlement.room.infra.admin;
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
/*     */ final class AdminInstance extends RoomInstance implements JOBMANAGER_HASER, ROOM_IDATA_INSTANCE {
/*     */   private static final long serialVersionUID = 1L;
/*     */   final Jobs jobs;
/*     */   private long[] pdata;
/*     */   
/*     */   protected AdminInstance(ROOM_ADMIN blueprint, TmpArea area, RoomInit init) {
/*  22 */     super(blueprint, area, init);
/*  23 */     this.jobs = new Jobs(this);
/*     */     
/*  25 */     employees().neededSet(this.jobs.size());
/*  26 */     employees().maxSet(this.jobs.size());
/*     */     
/*  28 */     this.jobs.randomize();
/*  29 */     this.pdata = blueprint.consumption().makeData();
/*  30 */     activate();
/*  31 */     blueprint.data.incStations(this.jobs.size());
/*     */   }
/*     */ 
/*     */   
/*     */   protected void loadFix() {
/*  36 */     this.pdata = blueprintI().consumption().makeDataFix(this.pdata);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean render(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator i) {
/*  46 */     i.lit();
/*  47 */     return super.render(r, shadowBatch, i);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void updateAction(double updateInterval, boolean day) {
/*  52 */     blueprintI().consumption().updateRoom(this);
/*  53 */     this.jobs.searchAgain();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void activateAction() {
/*  58 */     (blueprintI()).data.incStations(this.jobs.size());
/*     */   }
/*     */ 
/*     */   
/*     */   protected void deactivateAction() {
/*  63 */     (blueprintI()).data.incStations(-this.jobs.size());
/*     */   }
/*     */ 
/*     */   
/*     */   public JOB_MANAGER getWork() {
/*  68 */     return (JOB_MANAGER)this.jobs;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void dispose() {
/*  73 */     blueprintI().consumption().releaseResources(this, this);
/*  74 */     (blueprintI()).data.incStations(-this.jobs.size());
/*     */   }
/*     */ 
/*     */   
/*     */   public ROOM_ADMIN blueprintI() {
/*  79 */     return (ROOM_ADMIN)blueprint();
/*     */   }
/*     */ 
/*     */   
/*     */   public long[] productionData() {
/*  84 */     return this.pdata;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static class Jobs
/*     */     extends JobPositions<AdminInstance>
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */ 
/*     */ 
/*     */     
/*     */     public Jobs(AdminInstance ins) {
/*  97 */       super(ins);
/*     */     }
/*     */ 
/*     */     
/*     */     protected SETT_JOB get(int tx, int ty) {
/* 102 */       return (((AdminInstance)this.ins).blueprintI()).job.get(tx, ty);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected boolean isAndInit(int tx, int ty) {
/* 113 */       return ((((AdminInstance)this.ins).blueprintI()).job.get(tx, ty) != null);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\admin\AdminInstance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */