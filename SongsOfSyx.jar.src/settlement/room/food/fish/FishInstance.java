/*     */ package settlement.room.food.fish;
/*     */ 
/*     */ import game.GAME;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.job.JOBMANAGER_HASER;
/*     */ import settlement.misc.job.JOB_MANAGER;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import settlement.misc.util.RESOURCE_TILE;
/*     */ import settlement.room.industry.module.Industry;
/*     */ import settlement.room.industry.module.ROOM_IDATA_INSTANCE;
/*     */ import settlement.room.industry.module.ROOM_PRODUCER_INSTANCE;
/*     */ import settlement.room.main.ROOMA;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.TmpArea;
/*     */ import settlement.room.main.job.JobPositions;
/*     */ import settlement.room.main.util.RoomInit;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.rnd.RND;
/*     */ import util.GUTIL;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ final class FishInstance
/*     */   extends RoomInstance implements JOBMANAGER_HASER, ROOM_PRODUCER_INSTANCE {
/*     */   final Jobs jobs;
/*     */   private static final long serialVersionUID = -3170637142258642320L;
/*     */   private long[] pData;
/*     */   
/*     */   FishInstance(ROOM_FISHERY b, TmpArea area, RoomInit init) {
/*  34 */     super(b, area, init);
/*     */     
/*  36 */     BoatMaker.make(this);
/*     */     
/*  38 */     int x = -1;
/*  39 */     int y = -1;
/*  40 */     int w = 0;
/*     */     
/*  42 */     for (COORDINATE c : body()) {
/*  43 */       if (is(c) && 
/*  44 */         (SETT.ROOMS()).fData.tileData.get(c) != 1) {
/*     */         
/*  46 */         if ((SETT.ROOMS()).fData.tileData.get(c) == 2) {
/*  47 */           if (x == -1) {
/*  48 */             x = c.x();
/*  49 */             y = c.y();
/*     */           }  continue;
/*  51 */         }  if (!(SETT.TERRAIN()).WATER.SHALLOW.is(c) || 
/*  52 */           Job.isWork.is((SETT.ROOMS()).data.get(c)))
/*     */           continue; 
/*  54 */         if (w == 0) {
/*  55 */           (SETT.ROOMS()).data.set((ROOMA)this, c, Job.isWork.set(0));
/*  56 */           w += RND.rInt(2); continue;
/*     */         } 
/*  58 */         w--;
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  66 */     if (x == -1 || y == -1)
/*  67 */       GAME.Error("" + x + " " + x); 
/*  68 */     this.sx = (short)x;
/*  69 */     this.sy = (short)y;
/*     */ 
/*     */     
/*  72 */     this.pData = b.productionData.makeData();
/*  73 */     this.jobs = new Jobs(this);
/*     */     
/*  75 */     this.jobs.randomize();
/*  76 */     this.jobs.setAlwaysNew();
/*     */     
/*  78 */     employees().maxSet((int)(blueprintI()).constructor.workers.get(this));
/*  79 */     employees().neededSet((int)(blueprintI()).constructor.workers.get(this));
/*  80 */     activate();
/*     */   }
/*     */   final short sx; final short sy; boolean hasStorage = true;
/*     */   
/*     */   protected void loadFix() {
/*  85 */     super.loadFix();
/*  86 */     this.pData = (blueprintI()).productionData.makeDataFix(this.pData);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean render(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator it) {
/*  92 */     if (!(SETT.ROOMS()).fData.item.is(it.tile()))
/*     */     {
/*  94 */       if (Job.isWork.is((SETT.ROOMS()).data.get(it.tile())) && Job.isShip.is((SETT.ROOMS()).data.get(it.tile()))) {
/*     */         
/*  96 */         if (!Job.working((SETT.ROOMS()).data.get(it.tile()))) {
/*  97 */           (SETT.HALFENTS()).dingy.renderBoat(r, shadowBatch, it.x() + 32, it.y() + 32, (DIR)DIR.ALL.getC(it.ran()), GUTIL.ran2().get(it.tile()), upgrade());
/*     */         }
/*     */       } else {
/* 100 */         int d = (SETT.ROOMS()).fData.spriteData.get(it.tile());
/*     */ 
/*     */         
/* 103 */         if (d != 15) {
/* 104 */           (blueprintI()).constructor.sEdge.render((SPRITE_RENDERER)r, shadowBatch, d, it, 0.0D, false);
/* 105 */         } else if (!(SETT.TERRAIN()).WATER.is.is(it.tile()) && (GUTIL.ran2().get(it.tile()) & 0xF) == 0) {
/* 106 */           (blueprintI()).constructor.sMisc.render((SPRITE_RENDERER)r, shadowBatch, 0, it, 0.0D, false);
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
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
/* 131 */     (blueprintI()).productionData.updateRoom((ROOM_IDATA_INSTANCE)this);
/*     */     
/* 133 */     if (!active())
/*     */       return; 
/* 135 */     this.jobs.searchAgain();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dispose() {
/* 141 */     for (COORDINATE c : body()) {
/* 142 */       if ((blueprintI()).job.storage.get(c.x(), c.y(), (ROOMA)this) != null) {
/* 143 */         (blueprintI()).job.storage.dispose();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public JOB_MANAGER getWork() {
/* 150 */     return (JOB_MANAGER)this.jobs;
/*     */   }
/*     */ 
/*     */   
/*     */   public ROOM_FISHERY blueprintI() {
/* 155 */     return (ROOM_FISHERY)blueprint();
/*     */   }
/*     */ 
/*     */   
/*     */   public RESOURCE_TILE resourceTile(int tx, int ty) {
/* 160 */     return (RESOURCE_TILE)(blueprintI()).job.storage.get(tx, ty, (ROOMA)this);
/*     */   }
/*     */ 
/*     */   
/*     */   public Industry industry() {
/* 165 */     return (Industry)blueprintI().industries().get(0);
/*     */   }
/*     */ 
/*     */   
/*     */   public long[] productionData() {
/* 170 */     return this.pData;
/*     */   }
/*     */ 
/*     */   
/*     */   static class Jobs
/*     */     extends JobPositions<FishInstance>
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */ 
/*     */     
/*     */     public Jobs(FishInstance ins) {
/* 181 */       super(ins);
/*     */     }
/*     */ 
/*     */     
/*     */     protected boolean isAndInit(int tx, int ty) {
/* 186 */       return (get(tx, ty) != null);
/*     */     }
/*     */ 
/*     */     
/*     */     protected SETT_JOB get(int tx, int ty) {
/* 191 */       return (((FishInstance)this.ins).blueprintI()).job.init(tx, ty, (FishInstance)this.ins);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int industryI() {
/* 198 */     return 0;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\food\fish\FishInstance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */