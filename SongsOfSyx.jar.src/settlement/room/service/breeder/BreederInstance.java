/*     */ package settlement.room.service.breeder;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.HEvent;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.job.JOBMANAGER_HASER;
/*     */ import settlement.misc.job.JOB_MANAGER;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import settlement.room.industry.module.Industry;
/*     */ import settlement.room.industry.module.ROOM_IDATA_INSTANCE;
/*     */ import settlement.room.industry.module.ROOM_PRODUCER_INSTANCE;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.TmpArea;
/*     */ import settlement.room.main.job.JobPositions;
/*     */ import settlement.room.main.util.RoomInit;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ final class BreederInstance extends RoomInstance implements ROOM_PRODUCER_INSTANCE, JOBMANAGER_HASER {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private final long[] pData;
/*     */   private final Jobs jobs;
/*  26 */   double kidsProduction = 0.0D;
/*     */   
/*     */   protected BreederInstance(ROOM_BREEDER blue, TmpArea area, RoomInit init) {
/*  29 */     super(blue, area, init);
/*  30 */     this.pData = blue.productionData.makeData();
/*     */     
/*  32 */     this.jobs = new Jobs(this);
/*     */     
/*  34 */     employees().maxSet(this.jobs.size());
/*  35 */     employees().neededSet((int)Math.ceil(blue.constructor.workers.get(this)));
/*     */     
/*  37 */     activate();
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean render(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator it) {
/*  42 */     it.lit();
/*  43 */     return super.render(r, shadowBatch, it);
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
/*  58 */     (blueprintI()).productionData.updateRoom((ROOM_IDATA_INSTANCE)this);
/*  59 */     this.jobs.searchAgain();
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateTileDay(int tx, int ty) {
/*  64 */     (blueprintI()).station.update(tx, ty);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void dispose() {
/*  69 */     for (COORDINATE c : body()) {
/*  70 */       if (is(c))
/*  71 */         (blueprintI()).station.dispose(c.x(), c.y()); 
/*     */     }  byte b; int i;
/*     */     ENTITY[] arrayOfENTITY;
/*  74 */     for (i = (arrayOfENTITY = SETT.ENTITIES().getAllEnts()).length, b = 0; b < i; ) { ENTITY e = arrayOfENTITY[b];
/*  75 */       if (e instanceof Humanoid) {
/*  76 */         Humanoid a = (Humanoid)e;
/*  77 */         HEvent.Handler.removeRoom(a, this);
/*     */       } 
/*     */       b++; }
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   public ROOM_BREEDER blueprintI() {
/*  85 */     return (ROOM_BREEDER)blueprint();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public long[] productionData() {
/*  91 */     return this.pData;
/*     */   }
/*     */ 
/*     */   
/*     */   public JobPositions<BreederInstance> getWork() {
/*  96 */     return this.jobs;
/*     */   }
/*     */ 
/*     */   
/*     */   public Industry industry() {
/* 101 */     return (Industry)blueprintI().industries().get(0);
/*     */   }
/*     */ 
/*     */   
/*     */   private static class Jobs
/*     */     extends JobPositions<BreederInstance>
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */ 
/*     */     
/*     */     public Jobs(BreederInstance ins) {
/* 112 */       super(ins);
/*     */     }
/*     */ 
/*     */     
/*     */     protected boolean isAndInit(int tx, int ty) {
/* 117 */       return (((BreederInstance)this.ins).blueprintI()).station.init(tx, ty);
/*     */     }
/*     */ 
/*     */     
/*     */     protected SETT_JOB get(int tx, int ty) {
/* 122 */       return (((BreederInstance)this.ins).blueprintI()).station.get(tx, ty);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int industryI() {
/* 130 */     return 0;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\breeder\BreederInstance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */