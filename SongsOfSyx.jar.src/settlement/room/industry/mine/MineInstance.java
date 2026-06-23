/*     */ package settlement.room.industry.mine;
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
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ final class MineInstance
/*     */   extends RoomInstance
/*     */   implements JOBMANAGER_HASER, ROOM_PRODUCER_INSTANCE
/*     */ {
/*     */   final JobPositions<MineInstance> jobs;
/*     */   private static final long serialVersionUID = -3170637142258642320L;
/*     */   private long[] pData;
/*     */   final short sx;
/*     */   final short sy;
/*  33 */   int workage = 0;
/*     */   boolean hasStorage = true;
/*     */   
/*     */   MineInstance(ROOM_MINE b, TmpArea area, RoomInit init) {
/*  37 */     super(b, area, init);
/*     */     
/*  39 */     int x = -1;
/*  40 */     int y = -1;
/*     */ 
/*     */ 
/*     */     
/*  44 */     for (COORDINATE c : body()) {
/*  45 */       if (is(c)) {
/*  46 */         if ((SETT.ROOMS()).fData.tileData.get(c) == 1) {
/*  47 */           (SETT.ROOMS()).data.set((ROOMA)this, c, Job.isWork.set(0)); continue;
/*  48 */         }  if ((SETT.ROOMS()).fData.tileData.get(c) == 2) {
/*  49 */           if (x == -1) {
/*  50 */             x = c.x();
/*  51 */             y = c.y();
/*     */           }  continue;
/*  53 */         }  if ((SETT.MINERALS()).getter.is(c, b.minable) && (SETT.ROOMS()).fData.item.get(c) == null) {
/*  54 */           (SETT.ROOMS()).data.set((ROOMA)this, c, Job.isWork.set(0));
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  62 */     if (x == -1 || y == -1)
/*  63 */       GAME.Error("" + x + " " + x); 
/*  64 */     this.sx = (short)x;
/*  65 */     this.sy = (short)y;
/*     */ 
/*     */     
/*  68 */     this.pData = b.productionData.makeData();
/*  69 */     this.jobs = new Jobs(this);
/*     */     
/*  71 */     this.jobs.randomize();
/*  72 */     int w = (int)Math.floor(b.constructor.workers.get(this));
/*  73 */     employees().maxSet(w);
/*  74 */     employees().neededSet(w);
/*  75 */     activate();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void loadFix() {
/*  80 */     this.pData = (blueprintI()).productionData.makeDataFix(this.pData);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean render(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator it) {
/*  85 */     return super.render(r, shadowBatch, it);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean renderBelow(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator i) {
/*  90 */     SETT.GROUND().renderMinerals(r, i.tile(), i.ran(), i.x(), i.y());
/*  91 */     return super.renderBelow(r, shadowBatch, i);
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
/* 109 */     (blueprintI()).productionData.updateRoom((ROOM_IDATA_INSTANCE)this);
/*     */     
/* 111 */     if (!active())
/*     */       return; 
/* 113 */     this.jobs.searchAgain();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dispose() {
/* 119 */     for (COORDINATE c : body()) {
/* 120 */       if ((blueprintI()).job.storage.get(c.x(), c.y(), (ROOMA)this) != null) {
/* 121 */         (blueprintI()).job.storage.dispose();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public JOB_MANAGER getWork() {
/* 128 */     return (JOB_MANAGER)this.jobs;
/*     */   }
/*     */ 
/*     */   
/*     */   public ROOM_MINE blueprintI() {
/* 133 */     return (ROOM_MINE)blueprint();
/*     */   }
/*     */ 
/*     */   
/*     */   public RESOURCE_TILE resourceTile(int tx, int ty) {
/* 138 */     return (RESOURCE_TILE)(blueprintI()).job.storage.get(tx, ty, (ROOMA)this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long[] productionData() {
/* 146 */     return this.pData;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Industry industry() {
/* 152 */     return (Industry)blueprintI().industries().get(0);
/*     */   }
/*     */   
/*     */   static class Jobs extends JobPositions<MineInstance> { private static final long serialVersionUID = 8423260307910904017L;
/*     */     
/*     */     public Jobs(MineInstance ins) {
/* 158 */       super(ins);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected boolean isAndInit(int tx, int ty) {
/* 164 */       return (get(tx, ty) != null);
/*     */     }
/*     */ 
/*     */     
/*     */     protected SETT_JOB get(int tx, int ty) {
/* 169 */       return (((MineInstance)this.ins).blueprintI()).job.init(tx, ty, (MineInstance)this.ins);
/*     */     } }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int industryI() {
/* 178 */     return 0;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\industry\mine\MineInstance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */