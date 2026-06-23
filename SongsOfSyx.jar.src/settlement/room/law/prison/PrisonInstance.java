/*     */ package settlement.room.law.prison;
/*     */ 
/*     */ import game.GAME;
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCES;
/*     */ import init.resources.ResGEat;
/*     */ import init.type.CAUSE_LEAVES;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.HEvent;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.types.prisoner.AIModule_Prisoner;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.job.JOBMANAGER_HASER;
/*     */ import settlement.misc.job.JOB_MANAGER;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import settlement.room.industry.module.Industry;
/*     */ import settlement.room.industry.module.ROOM_IDATA_INSTANCE;
/*     */ import settlement.room.industry.module.ROOM_PRODUCER_INSTANCE;
/*     */ import settlement.room.main.ROOMA;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.TmpArea;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.room.main.job.JobPositions;
/*     */ import settlement.room.main.util.RoomInit;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.util.bit.Bits;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ final class PrisonInstance
/*     */   extends RoomInstance
/*     */   implements JOBMANAGER_HASER, ROOM_PRODUCER_INSTANCE {
/*     */   private static final long serialVersionUID = 1L;
/*     */   final Jobs jobs;
/*  41 */   private short prisoners = 0;
/*     */   
/*  43 */   private static final Bits bprisoners = new Bits(15);
/*     */   private final short[] cellsXY;
/*  45 */   private short cellI = 0;
/*  46 */   final RBIT.RBITImp fetch = new RBIT.RBITImp();
/*     */   private long[] productionData;
/*  48 */   float riotChance = 1.0F;
/*     */   boolean hasWarned = false;
/*     */   
/*     */   protected PrisonInstance(ROOM_PRISON b, TmpArea area, RoomInit init) {
/*  52 */     super(b, area, init);
/*     */     
/*  54 */     int cells = 0;
/*  55 */     for (COORDINATE c : body()) {
/*  56 */       if (is(c)) {
/*  57 */         candle(c.x(), c.y());
/*  58 */         if ((SETT.ROOMS()).fData.tileData.get(c) == 1) {
/*  59 */           cells++;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  64 */     this.cellsXY = new short[cells * 2];
/*  65 */     cells = 0;
/*  66 */     for (COORDINATE c : body()) {
/*  67 */       if (is(c) && 
/*  68 */         (SETT.ROOMS()).fData.tileData.get(c) == 1) {
/*  69 */         this.cellsXY[cells++] = (short)c.x();
/*  70 */         this.cellsXY[cells++] = (short)c.y();
/*     */       } 
/*     */     } 
/*     */     
/*  74 */     this.productionData = (blueprintI()).indu.makeData();
/*  75 */     this.jobs = new Jobs(this);
/*     */     
/*  77 */     int am = (int)Math.ceil(b.constructor.guards.get(this));
/*  78 */     employees().maxSet(am);
/*  79 */     employees().neededSet(am);
/*     */     
/*  81 */     for (ResGEat e : RESOURCES.EDI().all()) {
/*  82 */       if (e.serve)
/*  83 */         this.fetch.or(e.resource); 
/*  84 */     }  activate();
/*  85 */     this.jobs.setAlwaysNew();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void loadFix() {
/*  91 */     this.productionData = (blueprintI()).indu.makeDataFix(this.productionData);
/*  92 */     this.jobs.setAlwaysNew();
/*  93 */     this.jobs.resNotFound.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   void candle(int tx, int ty) {
/*  98 */     if (SETT.LIGHTS().is(tx, ty)) {
/*  99 */       SETT.LIGHTS().remove(tx, ty);
/* 100 */       FurnisherItem it = (FurnisherItem)(SETT.ROOMS()).fData.item.get(tx, ty);
/*     */       
/* 102 */       for (DIR d : DIR.ORTHO) {
/* 103 */         if ((SETT.ROOMS()).fData.item.is(tx, ty, d, it)) {
/* 104 */           SETT.LIGHTS().candle(tx, ty, d.x() * 28, d.y() * 28);
/*     */           return;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public int prisoners() {
/* 112 */     return this.prisoners;
/*     */   }
/*     */   
/*     */   public int prisonersMax() {
/* 116 */     return (blueprintI()).constructor.PRISONERS_PER_CELL * this.cellsXY.length / 2;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean render(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator it) {
/* 121 */     it.lit();
/* 122 */     return super.render(r, shadowBatch, it);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void activateAction() {
/* 127 */     blueprintI().incPrisoners(this.prisoners, prisonersMax());
/*     */   } protected void deactivateAction() {
/*     */     byte b;
/*     */     int j;
/*     */     ENTITY[] arrayOfENTITY;
/* 132 */     for (j = (arrayOfENTITY = SETT.ENTITIES().getAllEnts()).length, b = 0; b < j; ) { ENTITY e = arrayOfENTITY[b];
/* 133 */       if (e != null && e instanceof Humanoid) {
/* 134 */         Humanoid h = (Humanoid)e;
/* 135 */         HEvent.Handler.removeRoom(h, this);
/*     */       } 
/*     */       b++; }
/*     */     
/* 139 */     for (int i = 0; i < this.cellsXY.length; i += 2) {
/* 140 */       this.cellI = (short)(this.cellI + 2);
/* 141 */       if (this.cellI >= this.cellsXY.length)
/* 142 */         this.cellI = 0; 
/* 143 */       int tx = this.cellsXY[this.cellI];
/* 144 */       int ty = this.cellsXY[this.cellI + 1];
/* 145 */       int data = (SETT.ROOMS()).data.get(tx, ty);
/* 146 */       data = bprisoners.set(data, 0);
/* 147 */       (SETT.ROOMS()).data.set((ROOMA)this, tx, ty, data);
/*     */     } 
/*     */     
/* 150 */     blueprintI().incPrisoners(-this.prisoners, -prisonersMax());
/* 151 */     this.prisoners = 0;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void updateAction(double updateInterval, boolean day) {
/* 156 */     (blueprintI()).indu.updateRoom((ROOM_IDATA_INSTANCE)this);
/* 157 */     this.jobs.searchAgain();
/* 158 */     if (day && prisoners() > 0) {
/*     */       
/* 160 */       float prev = this.riotChance;
/*     */       
/* 162 */       double v = employees().employed() / employees().max() - 1.0D;
/*     */ 
/*     */       
/* 165 */       RBIT.RBITImp.tmp.clearSet((RBIT)this.fetch);
/* 166 */       RBIT.RBITImp.tmp.xor((RBIT)this.jobs.resNotFound);
/* 167 */       if (RBIT.RBITImp.tmp.isClear()) {
/* 168 */         v--;
/*     */       }
/*     */       
/* 171 */       v /= 4.0D;
/*     */       
/* 173 */       if (v == 0.0D) {
/* 174 */         this.riotChance = 1.0F;
/*     */         
/*     */         return;
/*     */       } 
/*     */       
/* 179 */       this.riotChance = (float)(this.riotChance + v);
/* 180 */       this.riotChance = (float)CLAMP.d(this.riotChance, 0.0D, 1.0D);
/* 181 */       if (this.riotChance < 0.5D && this.riotChance < prev && !this.hasWarned) {
/* 182 */         Gui.mWarn(this);
/* 183 */         this.hasWarned = true;
/* 184 */       } else if (this.riotChance <= 0.0F) {
/* 185 */         Gui.m(this);
/* 186 */         this.hasWarned = false;
/* 187 */         this.riotChance = 1.0F; byte b; int i; ENTITY[] arrayOfENTITY;
/* 188 */         for (i = (arrayOfENTITY = SETT.ENTITIES().getAllEnts()).length, b = 0; b < i; ) { ENTITY e = arrayOfENTITY[b];
/* 189 */           if (e instanceof Humanoid) {
/* 190 */             Humanoid a = (Humanoid)e;
/* 191 */             if (AIModule_Prisoner.isPrisoner(a, this)) {
/* 192 */               STATS.LAW().escapeInc();
/* 193 */               a.kill(false, CAUSE_LEAVES.OTHER());
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
/*     */   public JOB_MANAGER getWork() {
/* 207 */     return (JOB_MANAGER)this.jobs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dispose() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public ROOM_PRISON blueprintI() {
/* 218 */     return (ROOM_PRISON)blueprint();
/*     */   }
/*     */   
/*     */   COORDINATE registerPrisoner(COORDINATE c) {
/* 222 */     if (this.prisoners >= prisonersMax())
/* 223 */       throw new RuntimeException(); 
/* 224 */     if (!active()) {
/* 225 */       throw new RuntimeException();
/*     */     }
/* 227 */     if (is(c) && (SETT.ROOMS()).fData.tileData.get(c) == 1) {
/*     */       
/* 229 */       int tx = c.x();
/* 230 */       int ty = c.y();
/* 231 */       int data = (SETT.ROOMS()).data.get(tx, ty);
/* 232 */       if (bprisoners.get(data) < (blueprintI()).constructor.PRISONERS_PER_CELL) {
/* 233 */         incPrisoner(tx, ty, 1);
/* 234 */         Coo.TMP.set(tx, ty);
/* 235 */         return (COORDINATE)Coo.TMP;
/*     */       } 
/*     */     } 
/*     */     
/* 239 */     int pris = 0;
/*     */     
/* 241 */     for (int i = 0; i < this.cellsXY.length; i += 2) {
/* 242 */       this.cellI = (short)(this.cellI + 2);
/* 243 */       if (this.cellI >= this.cellsXY.length)
/* 244 */         this.cellI = 0; 
/* 245 */       int tx = this.cellsXY[this.cellI];
/* 246 */       int ty = this.cellsXY[this.cellI + 1];
/* 247 */       int data = (SETT.ROOMS()).data.get(tx, ty);
/* 248 */       pris += bprisoners.get(data);
/* 249 */       if (bprisoners.get(data) < (blueprintI()).constructor.PRISONERS_PER_CELL) {
/* 250 */         incPrisoner(tx, ty, 1);
/* 251 */         Coo.TMP.set(tx, ty);
/* 252 */         return (COORDINATE)Coo.TMP;
/*     */       } 
/*     */     } 
/*     */     
/* 256 */     throw new RuntimeException("" + pris + " " + pris + " " + this.prisoners);
/*     */   }
/*     */   
/*     */   void incPrisoner(int tx, int ty, int am) {
/* 260 */     int data = (SETT.ROOMS()).data.get(tx, ty);
/* 261 */     if (am < 0) {
/* 262 */       if (bprisoners.get(data) + am < 0 || this.prisoners < 0) {
/*     */         return;
/*     */       }
/* 265 */     } else if (am > 0 && (
/* 266 */       bprisoners.get(data) + am > (blueprintI()).constructor.PRISONERS_PER_CELL || this.prisoners > prisonersMax())) {
/* 267 */       GAME.Error("prison " + ((this.prisoners > prisonersMax()) ? 1 : 0));
/*     */       
/*     */       return;
/*     */     } 
/* 271 */     this.prisoners = (short)(this.prisoners + am);
/* 272 */     data = bprisoners.inc(data, am);
/* 273 */     (SETT.ROOMS()).data.set((ROOMA)this, tx, ty, data);
/* 274 */     blueprintI().incPrisoners(am, 0);
/*     */   }
/*     */   
/*     */   void removePrisoner(int tx, int ty) {
/* 278 */     if (!is(tx, ty))
/*     */       return; 
/* 280 */     if ((SETT.ROOMS()).fData.tileData.get(tx, ty) != 1)
/*     */       return; 
/* 282 */     int data = (SETT.ROOMS()).data.get(tx, ty);
/* 283 */     if (bprisoners.get(data) == 0) {
/*     */       return;
/*     */     }
/* 286 */     incPrisoner(tx, ty, -1);
/*     */   }
/*     */   
/*     */   boolean isReserved(int tx, int ty) {
/* 290 */     if ((SETT.ROOMS()).fData.tileData.get(tx, ty) != 1)
/* 291 */       return false; 
/* 292 */     int data = (SETT.ROOMS()).data.get(tx, ty);
/* 293 */     if (bprisoners.get(data) == 0) {
/* 294 */       return false;
/*     */     }
/* 296 */     return true;
/*     */   }
/*     */   
/*     */   static class Jobs
/*     */     extends JobPositions<PrisonInstance> {
/*     */     private static final long serialVersionUID = 1L;
/*     */     
/*     */     public Jobs(PrisonInstance ins) {
/* 304 */       super(ins);
/* 305 */       setAlwaysNew();
/*     */     }
/*     */ 
/*     */     
/*     */     protected SETT_JOB get(int tx, int ty) {
/* 310 */       if (Food.init(tx, ty) != null) {
/* 311 */         return Food.init(tx, ty);
/*     */       }
/* 313 */       if (Latrine.init(tx, ty) != null)
/* 314 */         return Latrine.init(tx, ty); 
/* 315 */       if (Cell.init(tx, ty) != null)
/* 316 */         return Cell.init(tx, ty); 
/* 317 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     protected boolean isAndInit(int tx, int ty) {
/* 322 */       if (Food.init(tx, ty) != null)
/* 323 */         return true; 
/* 324 */       if (Latrine.init(tx, ty) != null)
/* 325 */         return true; 
/* 326 */       if (Cell.init(tx, ty) != null)
/* 327 */         return true; 
/* 328 */       return false;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long[] productionData() {
/* 336 */     return this.productionData;
/*     */   }
/*     */ 
/*     */   
/*     */   public Industry industry() {
/* 341 */     return (blueprintI()).indu;
/*     */   }
/*     */ 
/*     */   
/*     */   public int industryI() {
/* 346 */     return 0;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\law\prison\PrisonInstance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */