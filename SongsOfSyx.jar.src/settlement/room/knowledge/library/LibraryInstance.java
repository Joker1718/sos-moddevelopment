/*     */ package settlement.room.knowledge.library;
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
/*     */ final class LibraryInstance extends RoomInstance implements JOBMANAGER_HASER, ROOM_IDATA_INSTANCE {
/*     */   private static final long serialVersionUID = 1L;
/*     */   final Jobs jobs;
/*     */   private long[] pdata;
/*     */   
/*     */   protected LibraryInstance(ROOM_LIBRARY blueprint, TmpArea area, RoomInit init) {
/*  22 */     super(blueprint, area, init);
/*  23 */     this.pdata = blueprint.consumption().makeData();
/*  24 */     this.jobs = new Jobs(this);
/*     */     
/*  26 */     employees().neededSet((int)Math.ceil(this.jobs.size()));
/*  27 */     employees().maxSet(this.jobs.size());
/*     */     
/*  29 */     this.jobs.randomize();
/*  30 */     activate();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void loadFix() {
/*  36 */     this.pdata = blueprintI().consumption().makeDataFix(this.pdata);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean render(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator i) {
/*  41 */     i.lit();
/*  42 */     return super.render(r, shadowBatch, i);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void updateAction(double updateInterval, boolean day) {
/*  47 */     blueprintI().consumption().updateRoom(this);
/*  48 */     this.jobs.searchAgain();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void activateAction() {
/*  53 */     (blueprintI()).data.incStations(this.jobs.size());
/*     */   }
/*     */ 
/*     */   
/*     */   protected void deactivateAction() {
/*  58 */     (blueprintI()).data.incStations(-this.jobs.size());
/*     */   }
/*     */ 
/*     */   
/*     */   public JOB_MANAGER getWork() {
/*  63 */     return (JOB_MANAGER)this.jobs;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void dispose() {
/*  68 */     blueprintI().consumption().releaseResources(this, this);
/*  69 */     (blueprintI()).data.incStations(-this.jobs.size());
/*     */   }
/*     */ 
/*     */   
/*     */   public ROOM_LIBRARY blueprintI() {
/*  74 */     return (ROOM_LIBRARY)blueprint();
/*     */   }
/*     */ 
/*     */   
/*     */   public long[] productionData() {
/*  79 */     return this.pdata;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static class Jobs
/*     */     extends JobPositions<LibraryInstance>
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */ 
/*     */     
/*     */     public Jobs(LibraryInstance ins) {
/*  91 */       super(ins);
/*     */     }
/*     */ 
/*     */     
/*     */     protected SETT_JOB get(int tx, int ty) {
/*  96 */       return (((LibraryInstance)this.ins).blueprintI()).job.get(tx, ty);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected boolean isAndInit(int tx, int ty) {
/* 102 */       return ((((LibraryInstance)this.ins).blueprintI()).job.get(tx, ty) != null);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\knowledge\library\LibraryInstance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */