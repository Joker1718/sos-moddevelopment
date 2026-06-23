/*     */ package settlement.room.industry.refiner;
/*     */ 
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
/*     */ final class RefinerInstance
/*     */   extends RoomInstance implements JOBMANAGER_HASER, ROOM_PRODUCER_INSTANCE {
/*     */   JobPositions<RefinerInstance> jobs;
/*     */   private static final long serialVersionUID = -3170637142258642320L;
/*     */   private long[] pData;
/*  29 */   short WI = 0; boolean hasStorage = true; final short sx; final short sy;
/*  30 */   private short industry = -1;
/*     */ 
/*     */   
/*     */   RefinerInstance(ROOM_REFINER b, TmpArea area, RoomInit init) {
/*  34 */     super(b, area, init);
/*  35 */     setIndustry(0);
/*  36 */     int x = -1;
/*  37 */     int y = -1;
/*     */     
/*  39 */     for (COORDINATE c : body()) {
/*  40 */       if (is(c) && 
/*  41 */         (SETT.ROOMS()).fData.tileData.get(c) == 2 && 
/*  42 */         x == -1) {
/*  43 */         x = c.x();
/*  44 */         y = c.y();
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  50 */     if (x == -1 || y == -1)
/*  51 */       GAME.Error("" + x + " " + x); 
/*  52 */     this.sx = (short)x;
/*  53 */     this.sy = (short)y;
/*     */     
/*  55 */     this.jobs = new Jobs(this);
/*     */ 
/*     */     
/*  58 */     employees().maxSet(this.jobs.size());
/*  59 */     employees().neededSet(this.jobs.size());
/*  60 */     activate();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void loadFix() {
/*  65 */     this.pData = industry().makeDataFix(this.pData);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Industry industry() {
/*  71 */     return (Industry)(blueprintI()).indus.get(this.industry);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIndustry(int i) {
/*  78 */     if (i == this.industry) {
/*     */       return;
/*     */     }
/*  81 */     Industry in = (Industry)blueprintI().industries().get(i);
/*  82 */     this.pData = in.makeData();
/*     */ 
/*     */     
/*  85 */     if (this.industry != -1) {
/*     */       
/*  87 */       for (COORDINATE c : body()) {
/*  88 */         if (!is(c))
/*     */           continue; 
/*  90 */         if ((blueprintI()).job.FETCH.get(c.x(), c.y(), this) != null)
/*  91 */           (blueprintI()).job.FETCH.dispose(); 
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
/* 104 */     this.industry = (byte)i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean render(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator it) {
/* 112 */     it.lit();
/* 113 */     return super.render(r, shadowBatch, it);
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
/* 131 */     industry().updateRoom((ROOM_IDATA_INSTANCE)this);
/*     */     
/* 133 */     if (!active())
/*     */       return; 
/* 135 */     this.jobs.searchAgain();
/* 136 */     updateIndustryLocks();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dispose() {
/* 143 */     for (COORDINATE c : body()) {
/* 144 */       if (!is(c))
/*     */         continue; 
/* 146 */       if ((blueprintI()).job.storage.get(c.x(), c.y(), (ROOMA)this) != null) {
/* 147 */         (blueprintI()).job.storage.dispose(); continue;
/* 148 */       }  if ((blueprintI()).job.FETCH.get(c.x(), c.y(), this) != null) {
/* 149 */         (blueprintI()).job.FETCH.dispose();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public JOB_MANAGER getWork() {
/* 156 */     return (JOB_MANAGER)this.jobs;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ROOM_REFINER blueprintI() {
/* 162 */     return (ROOM_REFINER)blueprint();
/*     */   }
/*     */ 
/*     */   
/*     */   public RESOURCE_TILE resourceTile(int tx, int ty) {
/* 167 */     return (RESOURCE_TILE)(blueprintI()).job.storage.get(tx, ty, (ROOMA)this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long[] productionData() {
/* 175 */     return this.pData;
/*     */   }
/*     */   
/*     */   static class Jobs
/*     */     extends JobPositions<RefinerInstance> {
/*     */     private static final long serialVersionUID = 8423260307910904017L;
/*     */     
/*     */     public Jobs(RefinerInstance ins) {
/* 183 */       super(ins);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected boolean isAndInit(int tx, int ty) {
/* 189 */       (SETT.ROOMS()).data.set((ROOMA)this.ins, tx, ty, 0);
/* 190 */       return (get(tx, ty) != null);
/*     */     }
/*     */ 
/*     */     
/*     */     protected SETT_JOB get(int tx, int ty) {
/* 195 */       return (((RefinerInstance)this.ins).blueprintI()).job.init(tx, ty, (RefinerInstance)this.ins);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int industryI() {
/* 203 */     return this.industry;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\industry\refiner\RefinerInstance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */