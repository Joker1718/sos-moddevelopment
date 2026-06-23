/*     */ package settlement.room.infra.inn;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import game.tourism.Review;
/*     */ import settlement.misc.job.JOBMANAGER_HASER;
/*     */ import settlement.misc.job.JOB_MANAGER;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.TmpArea;
/*     */ import settlement.room.main.job.JobPositions;
/*     */ import settlement.room.main.util.RoomInit;
/*     */ import settlement.room.service.module.ROOM_SERVICER;
/*     */ import settlement.room.service.module.RoomServiceInstance;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ public final class InnInstance extends RoomInstance implements JOBMANAGER_HASER, ROOM_SERVICER {
/*     */   private static final long serialVersionUID = 1L;
/*     */   final Jobs jobs;
/*     */   static final double WORKER_PER_BED = 0.125D;
/*     */   boolean auto = false;
/*     */   int earnings;
/*     */   int earningsLast;
/*  27 */   byte year = (byte)TIME.years().bitsSinceStart();
/*     */   
/*     */   final RoomServiceInstance service;
/*     */   
/*  31 */   final Review[] reviews = new Review[] {
/*  32 */       new Review(), 
/*  33 */       new Review(), 
/*  34 */       new Review(), 
/*  35 */       new Review()
/*     */     };
/*     */   
/*     */   protected InnInstance(ROOM_INN b, TmpArea area, RoomInit init) {
/*  39 */     super(b, area, init);
/*  40 */     this.jobs = new Jobs(this);
/*  41 */     int total = (int)b.constructor.beds.get(this);
/*  42 */     employees().maxSet(2 * (int)Math.ceil(b.constructor.workers.get(this)));
/*  43 */     employees().neededSet((int)Math.ceil(b.constructor.workers.get(this)));
/*  44 */     this.service = new RoomServiceInstance(total, (blueprintI()).service);
/*  45 */     activate();
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean render(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator it) {
/*  50 */     it.lit();
/*  51 */     return super.render(r, shadowBatch, it);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean renderAbove(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator i) {
/*  56 */     super.renderAbove(r, shadowBatch, i);
/*  57 */     (blueprintI()).constructor.aboveR((SPRITE_RENDERER)r, shadowBatch, i, getDegrade());
/*  58 */     return false;
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
/*  73 */     this.jobs.searchAgain();
/*  74 */     if (this.year != (byte)TIME.years().bitCurrent()) {
/*  75 */       this.year = (byte)TIME.years().bitCurrent();
/*  76 */       this.earningsLast = this.earnings;
/*  77 */       this.earnings = 0;
/*     */     } 
/*  79 */     if (day) {
/*  80 */       this.service.updateDay();
/*     */     }
/*     */   }
/*     */   
/*     */   public JOB_MANAGER getWork() {
/*  85 */     return (JOB_MANAGER)this.jobs;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void dispose() {
/*  90 */     this.service.dispose((blueprintI()).service);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ROOM_INN blueprintI() {
/*  96 */     return (ROOM_INN)blueprint();
/*     */   }
/*     */   
/*     */   static class Jobs
/*     */     extends JobPositions<InnInstance> {
/*     */     private static final long serialVersionUID = 1L;
/*     */     
/*     */     public Jobs(InnInstance ins) {
/* 104 */       super(ins);
/*     */     }
/*     */ 
/*     */     
/*     */     protected SETT_JOB get(int tx, int ty) {
/* 109 */       ABed b = (((InnInstance)this.ins).blueprintI()).bed.init(tx, ty);
/* 110 */       if (b != null)
/* 111 */         return b.job; 
/* 112 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected boolean isAndInit(int tx, int ty) {
/* 118 */       return ((((InnInstance)this.ins).blueprintI()).bed.init(tx, ty) != null);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double quality() {
/* 126 */     return ROOM_SERVICER.defQuality(this, (blueprintI()).constructor.coziness.get(this));
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomServiceInstance service() {
/* 131 */     return this.service;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\inn\InnInstance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */