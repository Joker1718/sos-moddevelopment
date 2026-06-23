/*     */ package settlement.room.health.asylum;
/*     */ 
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
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.room.main.job.JobPositions;
/*     */ import settlement.room.main.util.RoomInit;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ final class AsylumInstance extends RoomInstance implements JOBMANAGER_HASER, ROOM_PRODUCER_INSTANCE {
/*     */   private static final long serialVersionUID = 1L;
/*     */   final Jobs jobs;
/*     */   static final double WORKER_PER_BED = 0.125D;
/*     */   private final short[] cellsXY;
/*  30 */   private short cellI = 0;
/*     */   private long[] pData;
/*     */   private short used;
/*     */   
/*     */   protected AsylumInstance(ROOM_ASYLUM b, TmpArea area, RoomInit init) {
/*  35 */     super(b, area, init);
/*     */     
/*  37 */     int cells = 0;
/*  38 */     for (COORDINATE c : body()) {
/*  39 */       if (is(c)) {
/*  40 */         candle(c.x(), c.y());
/*  41 */         if ((SETT.ROOMS()).fData.tileData.get(c) == 1) {
/*  42 */           cells++;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  47 */     this.cellsXY = new short[cells * 2];
/*  48 */     cells = 0;
/*  49 */     for (COORDINATE c : body()) {
/*  50 */       if (is(c) && 
/*  51 */         (SETT.ROOMS()).fData.tileData.get(c) == 1) {
/*  52 */         this.cellsXY[cells++] = (short)c.x();
/*  53 */         this.cellsXY[cells++] = (short)c.y();
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  58 */     this.jobs = new Jobs(this);
/*  59 */     this.jobs.randomize();
/*  60 */     this.jobs.setAlwaysNew();
/*  61 */     this.pData = b.consumtion.makeData();
/*  62 */     employees().maxSet((int)Math.ceil(b.constructor.guards.get(this)));
/*  63 */     employees().neededSet((int)Math.ceil(b.constructor.guards.get(this)));
/*  64 */     activate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void loadFix() {
/*  71 */     this.pData = (blueprintI()).consumtion.makeDataFix(this.pData);
/*     */   }
/*     */ 
/*     */   
/*     */   void candle(int tx, int ty) {
/*  76 */     if (SETT.LIGHTS().is(tx, ty)) {
/*  77 */       SETT.LIGHTS().remove(tx, ty);
/*  78 */       FurnisherItem it = (FurnisherItem)(SETT.ROOMS()).fData.item.get(tx, ty);
/*     */       
/*  80 */       for (DIR d : DIR.ORTHO) {
/*  81 */         if ((SETT.ROOMS()).fData.item.is(tx, ty, d, it)) {
/*  82 */           SETT.LIGHTS().candle(tx, ty, d.x() * 28, d.y() * 28);
/*     */           return;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public int prisoners() {
/*  90 */     return this.used;
/*     */   }
/*     */   
/*     */   public int prisonersMax() {
/*  94 */     return this.cellsXY.length / 2;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean render(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator it) {
/*  99 */     it.lit();
/* 100 */     return super.render(r, shadowBatch, it);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void activateAction() {
/* 105 */     blueprintI().incPrisoners(this.used, prisonersMax());
/*     */   } protected void deactivateAction() {
/*     */     byte b;
/*     */     int j;
/*     */     ENTITY[] arrayOfENTITY;
/* 110 */     for (j = (arrayOfENTITY = SETT.ENTITIES().getAllEnts()).length, b = 0; b < j; ) { ENTITY e = arrayOfENTITY[b];
/* 111 */       if (e != null && e instanceof Humanoid) {
/* 112 */         Humanoid h = (Humanoid)e;
/* 113 */         HEvent.Handler.removeRoom(h, this);
/*     */       } 
/*     */       b++; }
/*     */     
/* 117 */     for (int i = 0; i < this.cellsXY.length; i += 2) {
/* 118 */       this.cellI = (short)(this.cellI + 2);
/* 119 */       if (this.cellI >= this.cellsXY.length)
/* 120 */         this.cellI = 0; 
/* 121 */       int tx = this.cellsXY[this.cellI];
/* 122 */       int ty = this.cellsXY[this.cellI + 1];
/* 123 */       Cell.init(tx, ty).reserveCancel();
/*     */     } 
/*     */     
/* 126 */     blueprintI().incPrisoners(-this.used, -prisonersMax());
/* 127 */     this.used = 0;
/*     */   }
/*     */   
/*     */   void inc(int delta) {
/* 131 */     this.used = (short)(this.used + delta);
/* 132 */     if (active()) {
/* 133 */       blueprintI().incPrisoners(delta, 0);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected void updateAction(double updateInterval, boolean day) {
/* 139 */     this.jobs.searchAgain();
/* 140 */     (blueprintI()).consumtion.updateRoom((ROOM_IDATA_INSTANCE)this);
/*     */   }
/*     */ 
/*     */   
/*     */   public JOB_MANAGER getWork() {
/* 145 */     return (JOB_MANAGER)this.jobs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dispose() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public ROOM_ASYLUM blueprintI() {
/* 156 */     return (ROOM_ASYLUM)blueprint();
/*     */   }
/*     */   
/*     */   COORDINATE registerPrisoner(Humanoid a) {
/* 160 */     if (this.used == prisonersMax())
/* 161 */       throw new RuntimeException(); 
/* 162 */     if (!active()) {
/* 163 */       throw new RuntimeException();
/*     */     }
/* 165 */     if (is(a.tc())) {
/* 166 */       Cell c = Cell.init(a.tc().x(), a.tc().y());
/* 167 */       if (c != null && !c.reservedIs()) {
/* 168 */         c.reserve();
/* 169 */         return (COORDINATE)c.coo;
/*     */       } 
/*     */     } 
/*     */     
/* 173 */     for (int i = 0; i < this.cellsXY.length; i += 2) {
/* 174 */       this.cellI = (short)(this.cellI + 2);
/* 175 */       if (this.cellI >= this.cellsXY.length)
/* 176 */         this.cellI = 0; 
/* 177 */       int tx = this.cellsXY[this.cellI];
/* 178 */       int ty = this.cellsXY[this.cellI + 1];
/* 179 */       Cell c = Cell.init(tx, ty);
/* 180 */       if (!c.reservedIs()) {
/* 181 */         c.reserve();
/* 182 */         return (COORDINATE)c.coo;
/*     */       } 
/*     */     } 
/* 185 */     throw new RuntimeException();
/*     */   }
/*     */   
/*     */   void removePrisoner(int tx, int ty) {
/* 189 */     Cell c = Cell.init(tx, ty);
/* 190 */     if (c == null)
/*     */       return; 
/* 192 */     c.reserveCancel();
/*     */   }
/*     */   
/*     */   boolean isReserved(int tx, int ty) {
/* 196 */     Cell c = Cell.init(tx, ty);
/* 197 */     return (c != null && c.reservedIs());
/*     */   }
/*     */   
/*     */   static class Jobs
/*     */     extends JobPositions<AsylumInstance> {
/*     */     private static final long serialVersionUID = 1L;
/*     */     
/*     */     public Jobs(AsylumInstance ins) {
/* 205 */       super(ins);
/*     */     }
/*     */ 
/*     */     
/*     */     protected SETT_JOB get(int tx, int ty) {
/* 210 */       if (Food.init(tx, ty) != null) {
/* 211 */         return Food.init(tx, ty);
/*     */       }
/* 213 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     protected boolean isAndInit(int tx, int ty) {
/* 218 */       if (Food.init(tx, ty) != null)
/* 219 */         return true; 
/* 220 */       return false;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long[] productionData() {
/* 228 */     return this.pData;
/*     */   }
/*     */ 
/*     */   
/*     */   public Industry industry() {
/* 233 */     return (Industry)blueprintI().industries().get(0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int industryI() {
/* 239 */     return 0;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\health\asylum\AsylumInstance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */