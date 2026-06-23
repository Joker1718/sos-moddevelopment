/*     */ package settlement.room.industry.woodcutter;
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
/*     */ import settlement.room.water.RoomPumpable;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.COORDINATEE;
/*     */ import util.GUTIL;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ final class Instance
/*     */   extends RoomInstance
/*     */   implements JOBMANAGER_HASER, ROOM_PRODUCER_INSTANCE {
/*     */   final JobPositions<Instance> jobs;
/*     */   private static final long serialVersionUID = -3170637142258642320L;
/*     */   private long[] pData;
/*  33 */   int workage = 0; final short sx; final short sy; boolean hasStorage = true;
/*     */   double irri;
/*     */   private double irriNext;
/*     */   private short irriI;
/*     */   
/*     */   Instance(ROOM_WOODCUTTER b, TmpArea area, RoomInit init) {
/*  39 */     super(b, area, init);
/*     */     
/*  41 */     int x = -1;
/*  42 */     int y = -1;
/*  43 */     int w = (int)(blueprintI()).constructor.workers.get(this);
/*  44 */     int ww = 0;
/*     */     
/*  46 */     GUTIL.coos().set(0);
/*  47 */     this.irri = 0.0D;
/*     */     
/*  49 */     for (COORDINATE c : body()) {
/*  50 */       if (is(c) && (SETT.PATH()).reachability.is(c)) {
/*     */ 
/*     */         
/*  53 */         if ((SETT.ROOMS()).fData.tileData.get(c) == 1) {
/*  54 */           b.job.mark(c.x(), c.y(), this);
/*  55 */         } else if ((SETT.ROOMS()).fData.tileData.get(c) == 2) {
/*  56 */           if (x == -1) {
/*  57 */             x = c.x();
/*  58 */             y = c.y();
/*     */           } 
/*  60 */         } else if ((SETT.ROOMS()).fData.tile.get(c) == null) {
/*  61 */           if ((SETT.TILE_MAP()).growth.type(c.x(), c.y()) == (SETT.TILE_MAP()).growth.tree) {
/*  62 */             b.job.mark(c.x(), c.y(), this);
/*  63 */             ww++;
/*     */           } else {
/*  65 */             GUTIL.coos().get().set(c);
/*  66 */             GUTIL.coos().inc();
/*     */           } 
/*     */         } 
/*     */         
/*  70 */         this.irri += (SETT.GROUND()).MOISTURE_TOT.get(c);
/*  71 */         RoomPumpable.reportChange(c.x(), c.y(), 0);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  80 */     int m = GUTIL.coos().getI();
/*  81 */     GUTIL.coos().shuffle(0, m);
/*  82 */     for (int i = 0; i < m; i++) {
/*  83 */       COORDINATEE cOORDINATEE = GUTIL.coos().set(i);
/*  84 */       if (ww < w * 4) {
/*  85 */         b.job.mark(cOORDINATEE.x(), cOORDINATEE.y(), this);
/*  86 */         ww++;
/*     */       } 
/*     */     } 
/*     */     
/*  90 */     for (COORDINATE c : body()) {
/*  91 */       if (is(c) && b.job.init(c.x(), c.y(), this) != null && !Job.isTreeCurrent(c.x(), c.y())) {
/*  92 */         (SETT.TERRAIN()).DECOR_WOOD.placeFixed(c.x(), c.y());
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  98 */     if (x == -1 || y == -1)
/*  99 */       GAME.Error("" + x + " " + x); 
/* 100 */     this.sx = (short)x;
/* 101 */     this.sy = (short)y;
/*     */ 
/*     */     
/* 104 */     this.pData = b.productionData.makeData();
/* 105 */     this.jobs = new Jobs(this);
/*     */     
/* 107 */     this.jobs.randomize();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 112 */     employees().maxSet(w);
/* 113 */     employees().neededSet(w);
/* 114 */     activate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void loadFix() {
/* 122 */     this.pData = industry().makeDataFix(this.pData);
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
/*     */   
/*     */   protected void deactivateAction() {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateAction(double updateInterval, boolean day) {
/* 141 */     (blueprintI()).productionData.updateRoom((ROOM_IDATA_INSTANCE)this);
/*     */     
/* 143 */     if (!active())
/*     */       return; 
/* 145 */     this.jobs.searchAgain();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dispose() {
/* 151 */     for (COORDINATE c : body()) {
/* 152 */       if ((blueprintI()).job.storage.get(c.x(), c.y(), (ROOMA)this) != null) {
/* 153 */         (blueprintI()).job.storage.dispose();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean renderAbove(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator i) {
/* 160 */     return super.renderAbove(r, shadowBatch, i);
/*     */   }
/*     */ 
/*     */   
/*     */   public JOB_MANAGER getWork() {
/* 165 */     return (JOB_MANAGER)this.jobs;
/*     */   }
/*     */ 
/*     */   
/*     */   public ROOM_WOODCUTTER blueprintI() {
/* 170 */     return (ROOM_WOODCUTTER)blueprint();
/*     */   }
/*     */ 
/*     */   
/*     */   public RESOURCE_TILE resourceTile(int tx, int ty) {
/* 175 */     return (RESOURCE_TILE)(blueprintI()).job.storage.get(tx, ty, (ROOMA)this);
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateTileDay(int tx, int ty) {
/* 180 */     (blueprintI()).job.update(tx, ty, this);
/* 181 */     if (this.irriI >= area()) {
/* 182 */       this.irriI = 0;
/* 183 */       this.irri = this.irriNext;
/* 184 */       this.irriNext = 0.0D;
/*     */     } 
/* 186 */     this.irriNext += (SETT.GROUND()).MOISTURE_TOT.get(tx, ty);
/* 187 */     this.irriI = (short)(this.irriI + 1);
/* 188 */     super.updateTileDay(tx, ty);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean render(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator it) {
/* 193 */     if (!(SETT.ROOMS()).fData.item.is(it.tile())) {
/* 194 */       int d = (SETT.ROOMS()).fData.spriteData.get(it.tile());
/* 195 */       if (d != 15) {
/* 196 */         (blueprintI()).constructor.sedge.render((SPRITE_RENDERER)r, shadowBatch, d, it, getDegrade(), false);
/*     */       }
/*     */     } 
/*     */     
/* 200 */     return super.render(r, shadowBatch, it);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public long[] productionData() {
/* 206 */     return this.pData;
/*     */   }
/*     */ 
/*     */   
/*     */   public Industry industry() {
/* 211 */     return (Industry)blueprintI().industries().get(0);
/*     */   }
/*     */   
/*     */   private static class Jobs extends JobPositions<Instance> { private static final long serialVersionUID = 8423260307910904017L;
/*     */     
/*     */     public Jobs(Instance ins) {
/* 217 */       super(ins);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected boolean isAndInit(int tx, int ty) {
/* 223 */       return (get(tx, ty) != null);
/*     */     }
/*     */ 
/*     */     
/*     */     protected SETT_JOB get(int tx, int ty) {
/* 228 */       return (((Instance)this.ins).blueprintI()).job.init(tx, ty, (Instance)this.ins);
/*     */     } }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int industryI() {
/* 237 */     return 0;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\industry\woodcutter\Instance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */