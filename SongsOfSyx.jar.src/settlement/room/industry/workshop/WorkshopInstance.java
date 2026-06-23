/*     */ package settlement.room.industry.workshop;
/*     */ import game.GAME;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.job.JOBMANAGER_HASER;
/*     */ import settlement.misc.job.JOB_MANAGER;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import settlement.misc.util.RESOURCE_TILE;
/*     */ import settlement.room.industry.module.Industry;
/*     */ import settlement.room.industry.module.IndustryResource;
/*     */ import settlement.room.industry.module.ROOM_IDATA_INSTANCE;
/*     */ import settlement.room.industry.module.ROOM_PRODUCER_INSTANCE;
/*     */ import settlement.room.main.ROOMA;
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
/*     */ final class WorkshopInstance extends RoomInstance implements JOBMANAGER_HASER, ROOM_PRODUCER_INSTANCE {
/*     */   JobPositions<WorkshopInstance> jobs;
/*     */   private static final long serialVersionUID = -3170637142258642320L;
/*     */   private long[] pData;
/*     */   boolean hasStorage = true;
/*     */   final short sx;
/*     */   final short sy;
/*  30 */   short WI = 0;
/*  31 */   private short industry = -1;
/*     */ 
/*     */   
/*     */   WorkshopInstance(ROOM_WORKSHOP b, TmpArea area, RoomInit init) {
/*  35 */     super(b, area, init);
/*  36 */     setIndustry(0);
/*  37 */     int x = -1;
/*  38 */     int y = -1;
/*     */     
/*  40 */     for (COORDINATE c : body()) {
/*  41 */       if (is(c) && 
/*  42 */         (SETT.ROOMS()).fData.tileData.get(c) == 2 && 
/*  43 */         x == -1) {
/*  44 */         x = c.x();
/*  45 */         y = c.y();
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  51 */     if (x == -1 || y == -1)
/*  52 */       GAME.Error("" + x + " " + x); 
/*  53 */     this.sx = (short)x;
/*  54 */     this.sy = (short)y;
/*     */     
/*  56 */     this.jobs = new Jobs(this);
/*     */ 
/*     */     
/*  59 */     employees().maxSet(this.jobs.size());
/*  60 */     employees().neededSet(this.jobs.size());
/*  61 */     activate();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Industry industry() {
/*  67 */     return (Industry)(blueprintI()).indus.get(this.industry);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIndustry(int i) {
/*  74 */     if (i == this.industry) {
/*     */       return;
/*     */     }
/*  77 */     Industry in = (Industry)blueprintI().industries().get(i);
/*  78 */     if (in == null)
/*     */       return; 
/*  80 */     this.pData = in.makeData();
/*     */ 
/*     */     
/*  83 */     if (this.industry != -1) {
/*     */       
/*  85 */       for (COORDINATE c : body()) {
/*  86 */         if (!is(c))
/*     */           continue; 
/*  88 */         if ((SETT.ROOMS()).fData.tileData.is(c.x(), c.y(), 3) && 
/*  89 */           (blueprintI()).job.FETCH.get(c.x(), c.y(), this) != null) {
/*  90 */           (blueprintI()).job.FETCH.dispose();
/*     */         }
/*     */       } 
/*  93 */       if (((IndustryResource)((Industry)(blueprintI()).indus.get(this.industry)).outs().get(0)).resource != ((IndustryResource)((Industry)(blueprintI()).indus.get(i)).outs().get(0)).resource) {
/*  94 */         this.hasStorage = true;
/*  95 */         for (COORDINATE c : body()) {
/*  96 */           if (!is(c))
/*     */             continue; 
/*  98 */           if ((blueprintI()).job.storage.get(c.x(), c.y(), (ROOMA)this) != null)
/*  99 */             (blueprintI()).job.storage.dispose(); 
/*     */         } 
/*     */       } 
/* 102 */       this.jobs.searchAgain();
/*     */     } 
/* 104 */     this.WI = 0;
/* 105 */     this.industry = (byte)i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean render(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator it) {
/* 113 */     it.lit();
/* 114 */     return super.render(r, shadowBatch, it);
/*     */   }
/*     */ 
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
/*     */   protected void updateAction(double updateInterval, boolean day) {
/* 132 */     industry().updateRoom((ROOM_IDATA_INSTANCE)this);
/*     */     
/* 134 */     if (!active())
/*     */       return; 
/* 136 */     this.jobs.searchAgain();
/* 137 */     updateIndustryLocks();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dispose() {
/* 144 */     for (COORDINATE c : body()) {
/* 145 */       if (!is(c))
/*     */         continue; 
/* 147 */       if ((blueprintI()).job.storage.get(c.x(), c.y(), (ROOMA)this) != null) {
/* 148 */         (blueprintI()).job.storage.dispose(); continue;
/* 149 */       }  if ((blueprintI()).job.FETCH.get(c.x(), c.y(), this) != null) {
/* 150 */         (blueprintI()).job.FETCH.dispose();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public JOB_MANAGER getWork() {
/* 157 */     return (JOB_MANAGER)this.jobs;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ROOM_WORKSHOP blueprintI() {
/* 163 */     return (ROOM_WORKSHOP)blueprint();
/*     */   }
/*     */ 
/*     */   
/*     */   public RESOURCE_TILE resourceTile(int tx, int ty) {
/* 168 */     return (RESOURCE_TILE)(blueprintI()).job.storage.get(tx, ty, (ROOMA)this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long[] productionData() {
/* 176 */     return this.pData;
/*     */   }
/*     */   
/*     */   static class Jobs
/*     */     extends JobPositions<WorkshopInstance> {
/*     */     private static final long serialVersionUID = 8423260307910904017L;
/*     */     
/*     */     public Jobs(WorkshopInstance ins) {
/* 184 */       super(ins);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected boolean isAndInit(int tx, int ty) {
/* 190 */       (SETT.ROOMS()).data.set((ROOMA)this.ins, tx, ty, 0);
/* 191 */       return (get(tx, ty) != null);
/*     */     }
/*     */ 
/*     */     
/*     */     protected SETT_JOB get(int tx, int ty) {
/* 196 */       return (((WorkshopInstance)this.ins).blueprintI()).job.init(tx, ty, (WorkshopInstance)this.ins);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int industryI() {
/* 204 */     return this.industry;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\industry\workshop\WorkshopInstance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */