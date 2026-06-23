/*     */ package settlement.room.infra.embassy;
/*     */ 
/*     */ import java.io.Serializable;
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
/*     */ final class EmbassyInstance
/*     */   extends RoomInstance
/*     */   implements JOBMANAGER_HASER, ROOM_IDATA_INSTANCE {
/*     */   private static final long serialVersionUID = 1L;
/*     */   final Jobs jobs;
/*     */   private long[] pdata;
/*     */   
/*     */   protected EmbassyInstance(ROOM_EMBASSY blueprint, TmpArea area, RoomInit init) {
/*  25 */     super(blueprint, area, init);
/*  26 */     this.jobs = new Jobs(this);
/*     */     
/*  28 */     employees().neededSet((int)Math.ceil(this.jobs.size()));
/*  29 */     employees().maxSet(this.jobs.size());
/*     */ 
/*     */     
/*  32 */     blueprint.data.incStations(this.jobs.size());
/*  33 */     this.pdata = blueprintI().consumption().makeData();
/*  34 */     activate();
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean render(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator i) {
/*  39 */     i.lit();
/*  40 */     return super.render(r, shadowBatch, i);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void updateAction(double updateInterval, boolean day) {
/*  45 */     this.jobs.searchAgain();
/*  46 */     blueprintI().consumption().updateRoom(this);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void loadFix() {
/*  51 */     this.pdata = blueprintI().consumption().makeDataFix(this.pdata);
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
/*  68 */     return (JOB_MANAGER)this.jobs;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void dispose() {
/*  73 */     (blueprintI()).data.incStations(-this.jobs.size());
/*  74 */     blueprintI().consumption().releaseResources(this, this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ROOM_EMBASSY blueprintI() {
/*  82 */     return (ROOM_EMBASSY)blueprint();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static class Jobs
/*     */     extends JobPositions<EmbassyInstance>
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */ 
/*     */ 
/*     */     
/*     */     public Jobs(EmbassyInstance ins) {
/*  95 */       super(ins);
/*     */     }
/*     */ 
/*     */     
/*     */     protected SETT_JOB get(int tx, int ty) {
/* 100 */       return (((EmbassyInstance)this.ins).blueprintI()).job.get(tx, ty);
/*     */     }
/*     */ 
/*     */     
/*     */     protected boolean isAndInit(int tx, int ty) {
/* 105 */       return ((((EmbassyInstance)this.ins).blueprintI()).job.get(tx, ty) != null);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long[] productionData() {
/* 116 */     return this.pdata;
/*     */   }
/*     */   
/*     */   static class Res
/*     */     implements Serializable
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */     public int reserved;
/*     */     public int current;
/*     */     public boolean unreachable;
/*     */     public boolean disabled;
/*     */     
/*     */     Res() {
/* 129 */       this.unreachable = false;
/* 130 */       this.disabled = true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\embassy\EmbassyInstance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */