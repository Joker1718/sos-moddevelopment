/*     */ package settlement.room.law.stockade;
/*     */ 
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCES;
/*     */ import init.resources.ResGEat;
/*     */ import init.type.CAUSE_LEAVES;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.HEvent;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.types.prisoner.AIModule_Prisoner;
/*     */ import settlement.main.SETT;
/*     */ import settlement.maintenance.ROOM_DEGRADER;
/*     */ import settlement.misc.job.JOBMANAGER_HASER;
/*     */ import settlement.misc.job.JOB_MANAGER;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import settlement.misc.util.RESOURCE_TILE;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.room.industry.module.Industry;
/*     */ import settlement.room.industry.module.ROOM_IDATA_INSTANCE;
/*     */ import settlement.room.industry.module.ROOM_PRODUCER_INSTANCE;
/*     */ import settlement.room.main.ROOMA;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.TmpArea;
/*     */ import settlement.room.main.job.JobPositions;
/*     */ import settlement.room.main.util.RoomInit;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ final class StockInstance extends RoomInstance implements JOBMANAGER_HASER, ROOM_PRODUCER_INSTANCE {
/*     */   private static final long serialVersionUID = 1L;
/*     */   final short prisonersMax;
/*     */   short prisonersCurrent;
/*  38 */   final RBIT.RBITImp fetch = new RBIT.RBITImp();
/*     */   private long[] productionData;
/*     */   final Jobs jobs;
/*  41 */   float riotChance = 1.0F;
/*     */   boolean hasWarned = false;
/*     */   
/*     */   StockInstance(ROOM_STOCKADE p, TmpArea area, RoomInit init) {
/*  45 */     super(p, area, init);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  51 */     this.prisonersMax = (short)(int)Math.ceil((blueprintI()).constructor.prisoners.get(this));
/*  52 */     double work = (blueprintI()).constructor.workers.get(this);
/*  53 */     employees().maxSet((int)Math.ceil(work));
/*  54 */     employees().neededSet((int)Math.ceil(work));
/*  55 */     this.productionData = (blueprintI()).indu.makeData();
/*  56 */     this.jobs = new Jobs(this);
/*  57 */     for (ResGEat e : RESOURCES.EDI().all()) {
/*  58 */       if (e.serve)
/*  59 */         this.fetch.or(e.resource); 
/*  60 */     }  activate();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void loadFix() {
/*  66 */     this.productionData = (blueprintI()).indu.makeDataFix(this.productionData);
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateTileDay(int tx, int ty) {
/*  71 */     super.updateTileDay(tx, ty);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateAction(double updateInterval, boolean day) {
/*  77 */     (blueprintI()).indu.updateRoom((ROOM_IDATA_INSTANCE)this);
/*  78 */     this.jobs.searchAgain();
/*  79 */     if (day && this.prisonersCurrent > 0) {
/*     */       
/*  81 */       float prev = this.riotChance;
/*     */       
/*  83 */       double v = 2.0D * employees().employed() / employees().max() - 1.0D;
/*  84 */       v /= 2.0D;
/*     */       
/*  86 */       if (!this.jobs.resNotFound.isClear())
/*  87 */         v--; 
/*  88 */       this.riotChance = (float)(this.riotChance + v);
/*  89 */       this.riotChance = (float)CLAMP.d(this.riotChance, 0.0D, 1.0D);
/*  90 */       if (this.riotChance < 0.5D && this.riotChance < prev && !this.hasWarned) {
/*  91 */         Gui.mWarn(this);
/*  92 */         this.hasWarned = true;
/*  93 */       } else if (this.riotChance <= 0.0F) {
/*  94 */         Gui.m(this);
/*  95 */         this.hasWarned = false;
/*  96 */         this.riotChance = 1.0F; byte b; int i; ENTITY[] arrayOfENTITY;
/*  97 */         for (i = (arrayOfENTITY = SETT.ENTITIES().getAllEnts()).length, b = 0; b < i; ) { ENTITY e = arrayOfENTITY[b];
/*  98 */           if (e instanceof Humanoid) {
/*  99 */             Humanoid a = (Humanoid)e;
/* 100 */             if (AIModule_Prisoner.isPrisoner(a, this)) {
/* 101 */               STATS.LAW().escapeInc();
/* 102 */               a.kill(false, CAUSE_LEAVES.OTHER());
/*     */             } 
/*     */           } 
/*     */           b++; }
/*     */       
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean render(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator it) {
/* 117 */     boolean ret = super.render(r, shadowBatch, it);
/* 118 */     (blueprintI()).constructor.renderFence((SPRITE_RENDERER)r, shadowBatch, it, 0.0D, true);
/* 119 */     return ret;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void activateAction() {
/* 124 */     (blueprintI()).prisoners += this.prisonersCurrent;
/* 125 */     (blueprintI()).prisonersMax += this.prisonersMax;
/*     */   }
/*     */   
/*     */   protected void deactivateAction() {
/*     */     byte b;
/*     */     int i;
/*     */     ENTITY[] arrayOfENTITY;
/* 132 */     for (i = (arrayOfENTITY = SETT.ENTITIES().getAllEnts()).length, b = 0; b < i; ) { ENTITY e = arrayOfENTITY[b];
/* 133 */       if (e != null && e instanceof Humanoid) {
/* 134 */         Humanoid h = (Humanoid)e;
/* 135 */         HEvent.Handler.removeRoom(h, this);
/*     */       }  b++; }
/*     */     
/* 138 */     (blueprintI()).prisoners -= this.prisonersCurrent;
/* 139 */     (blueprintI()).prisonersMax -= this.prisonersMax;
/* 140 */     this.prisonersCurrent = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dispose() {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JOB_MANAGER getWork() {
/* 153 */     return (JOB_MANAGER)this.jobs;
/*     */   }
/*     */ 
/*     */   
/*     */   public ROOM_STOCKADE blueprintI() {
/* 158 */     return (ROOM_STOCKADE)blueprint();
/*     */   }
/*     */ 
/*     */   
/*     */   protected AVAILABILITY getAvailability(int tile) {
/* 163 */     int tx = tile % SETT.TWIDTH;
/* 164 */     int ty = tile / SETT.TWIDTH;
/* 165 */     if ((blueprintI()).constructor.isFence((ROOMA)this, tx, ty))
/* 166 */       return AVAILABILITY.SOLID; 
/* 167 */     return super.getAvailability(tile);
/*     */   }
/*     */ 
/*     */   
/*     */   public void destroyTile(int tx, int ty) {
/* 172 */     super.destroyTile(tx, ty);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean destroyTileCan(int tx, int ty) {
/* 177 */     return ((getAvailability(tx + ty * SETT.TWIDTH)).player < 0.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   public ROOM_DEGRADER degrader(int tx, int ty) {
/* 182 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public RESOURCE_TILE resourceTile(int tx, int ty) {
/* 187 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public long[] productionData() {
/* 193 */     return this.productionData;
/*     */   }
/*     */ 
/*     */   
/*     */   public Industry industry() {
/* 198 */     return (blueprintI()).indu;
/*     */   }
/*     */ 
/*     */   
/*     */   public int industryI() {
/* 203 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   static class Jobs
/*     */     extends JobPositions<StockInstance>
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */ 
/*     */     
/*     */     public Jobs(StockInstance ins) {
/* 214 */       super(ins);
/* 215 */       setAlwaysNew();
/*     */     }
/*     */ 
/*     */     
/*     */     protected boolean isAndInit(int tx, int ty) {
/* 220 */       return (get(tx, ty) != null);
/*     */     }
/*     */ 
/*     */     
/*     */     protected SETT_JOB get(int tx, int ty) {
/* 225 */       return (((StockInstance)this.ins).blueprintI()).job.job(tx, ty);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\law\stockade\StockInstance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */