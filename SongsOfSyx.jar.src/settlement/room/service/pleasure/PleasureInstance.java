/*     */ package settlement.room.service.pleasure;
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
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ final class PleasureInstance extends RoomInstance implements JOBMANAGER_HASER, ROOM_SERVICER {
/*     */   private static final long serialVersionUID = 1L;
/*     */   final Jobs jobs;
/*     */   boolean auto = false;
/*     */   final RoomServiceInstance service;
/*     */   
/*     */   protected PleasureInstance(ROOM_PLEASURE b, TmpArea area, RoomInit init) {
/*  26 */     super(b, area, init);
/*  27 */     this.jobs = new Jobs(this);
/*  28 */     int total = this.jobs.size();
/*  29 */     employees().maxSet(this.jobs.size());
/*  30 */     employees().neededSet(this.jobs.size());
/*  31 */     this.service = new RoomServiceInstance(total, (RoomService)(blueprintI()).service);
/*  32 */     activate();
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean render(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator it) {
/*  37 */     it.lit();
/*  38 */     return super.render(r, shadowBatch, it);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean renderAbove(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator i) {
/*  43 */     super.renderAbove(r, shadowBatch, i);
/*  44 */     (blueprintI()).constructor.aboveR((SPRITE_RENDERER)r, shadowBatch, i, getDegrade());
/*  45 */     return false;
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
/*     */   protected void updateAction(double updateInterval, boolean day) {
/*  60 */     this.jobs.searchAgain();
/*  61 */     if (day) {
/*  62 */       this.service.updateDay();
/*     */     }
/*     */   }
/*     */   
/*     */   public JOB_MANAGER getWork() {
/*  67 */     return (JOB_MANAGER)this.jobs;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void dispose() {
/*  72 */     this.service.dispose((RoomService)(blueprintI()).service);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ROOM_PLEASURE blueprintI() {
/*  78 */     return (ROOM_PLEASURE)blueprint();
/*     */   }
/*     */   
/*     */   static class Jobs
/*     */     extends JobPositions<PleasureInstance> {
/*     */     private static final long serialVersionUID = 1L;
/*     */     
/*     */     public Jobs(PleasureInstance ins) {
/*  86 */       super(ins);
/*     */     }
/*     */ 
/*     */     
/*     */     protected SETT_JOB get(int tx, int ty) {
/*  91 */       ABed b = (((PleasureInstance)this.ins).blueprintI()).bed.init(tx, ty);
/*  92 */       if (b != null)
/*  93 */         return b.job; 
/*  94 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected boolean isAndInit(int tx, int ty) {
/* 100 */       return (((PleasureInstance)this.ins).is(tx, ty) && (((PleasureInstance)this.ins).blueprintI()).bed.init(tx, ty) != null);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double quality() {
/* 108 */     return ROOM_SERVICER.defQuality(this, (blueprintI()).constructor.coziness.get(this));
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomServiceInstance service() {
/* 113 */     return this.service;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\pleasure\PleasureInstance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */