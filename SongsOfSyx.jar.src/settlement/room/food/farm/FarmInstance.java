/*     */ package settlement.room.food.farm;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import game.time.TIMECYCLE;
/*     */ import init.resources.RESOURCE;
/*     */ import settlement.entity.animal.ANIMAL_ROOM_RUINER;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.maintenance.ROOM_DEGRADER;
/*     */ import settlement.misc.job.JOBMANAGER_HASER;
/*     */ import settlement.misc.job.JOB_MANAGER;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import settlement.misc.util.RESOURCE_TILE;
/*     */ import settlement.misc.util.TILE_STORAGE;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.room.industry.module.Industry;
/*     */ import settlement.room.industry.module.IndustryResource;
/*     */ import settlement.room.industry.module.ROOM_IDATA_INSTANCE;
/*     */ import settlement.room.industry.module.ROOM_PRODUCER_INSTANCE;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.TmpArea;
/*     */ import settlement.room.main.construction.ConstructionInit;
/*     */ import settlement.room.main.job.JobIterator;
/*     */ import settlement.room.main.util.RoomInit;
/*     */ import snake2d.LOG;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ final class FarmInstance
/*     */   extends RoomInstance implements JOBMANAGER_HASER, ROOM_PRODUCER_INSTANCE, ANIMAL_ROOM_RUINER {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private long[] produceData;
/*  37 */   final Tile.IData tData = new Tile.IData(this);
/*     */   
/*  39 */   public double irri = 0.0D;
/*  40 */   private double irriNext = 0.0D;
/*  41 */   private short irriI = 0;
/*     */   
/*  43 */   short resX = 0;
/*  44 */   short resY = 0;
/*  45 */   short stoX = 0;
/*  46 */   short stoY = 0;
/*     */   
/*     */   boolean resTimeout = false;
/*     */   boolean storeTimeout = false;
/*     */   boolean isHarvest = false;
/*  51 */   private final JobIterator jobmanager = new JobIterator(this)
/*     */     {
/*     */       private static final long serialVersionUID = 1L;
/*     */       
/*     */       protected SETT_JOB init(int tx, int ty) {
/*  56 */         return FarmInstance.this.blueprintI().tile(tx, ty).job();
/*     */       }
/*     */     };
/*     */   
/*     */   FarmInstance(ROOM_FARM p, TmpArea area, RoomInit init) {
/*  61 */     super(p, area, init);
/*     */     
/*  63 */     for (COORDINATE c : body()) {
/*  64 */       if (is(c)) {
/*  65 */         this.irri += (SETT.GROUND()).MOISTURE_TOT.get(c);
/*  66 */         p.tile(c.x(), c.y()).init(c, this);
/*     */       } 
/*     */     } 
/*     */     
/*  70 */     double w = Math.ceil(p.constructor.workers.get(this));
/*  71 */     int jobs = (int)Math.ceil(w);
/*  72 */     employees().maxSet((int)(jobs * 1.5D));
/*  73 */     employees().neededSet(jobs);
/*  74 */     this.produceData = p.productionData.makeData();
/*  75 */     activate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void loadFix() {
/*  84 */     this.produceData = (blueprintI()).productionData.makeDataFix(this.produceData);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateAction(double updateInterval, boolean day) {
/*  90 */     (blueprintI()).productionData.updateRoom((ROOM_IDATA_INSTANCE)this);
/*     */     
/*  92 */     if (day) {
/*  93 */       this.jobmanager.searchAgain();
/*  94 */       this.tData.updateDay();
/*  95 */       this.storeTimeout = false;
/*  96 */       if (!this.tData.shouldStore()) {
/*  97 */         this.resTimeout = false;
/*  98 */         this.isHarvest = false;
/*  99 */       } else if (!this.isHarvest) {
/* 100 */         this.isHarvest = true;
/* 101 */         this.resTimeout = false;
/* 102 */         this.storeTimeout = false;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean renderBelow(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator i) {
/* 112 */     blueprintI().tile(i.tx(), i.ty()).renderTill((SPRITE_RENDERER)r, shadowBatch, i);
/* 113 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean render(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator it) {
/* 118 */     blueprintI().tile(it.tx(), it.ty()).render((SPRITE_RENDERER)r, shadowBatch, it);
/* 119 */     return false;
/*     */   }
/*     */   
/*     */   public RESOURCE getCrop() {
/* 123 */     return (blueprintI()).crop.resource;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canBeGraced(int tx, int ty) {
/* 128 */     return blueprintI().tile(tx, ty).destroyTileCan();
/*     */   }
/*     */ 
/*     */   
/*     */   public void grace(int tx, int ty) {
/* 133 */     blueprintI().tile(tx, ty).destroyTile();
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
/*     */   protected void dispose() {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JOB_MANAGER getWork() {
/* 156 */     return (JOB_MANAGER)this.jobmanager;
/*     */   }
/*     */ 
/*     */   
/*     */   public ROOM_FARM blueprintI() {
/* 161 */     return (ROOM_FARM)blueprint();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean acceptsWork() {
/* 166 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected AVAILABILITY getAvailability(int tile) {
/* 171 */     return AVAILABILITY.ROOM;
/*     */   }
/*     */ 
/*     */   
/*     */   public void destroyTile(int tx, int ty) {
/* 176 */     if (destroyTileCan(tx, ty)) {
/* 177 */       blueprintI().tile(tx, ty).destroyTile();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean destroyTileCan(int tx, int ty) {
/* 183 */     return blueprintI().tile(tx, ty).destroyTileCan();
/*     */   }
/*     */ 
/*     */   
/*     */   public ROOM_DEGRADER degrader(int tx, int ty) {
/* 188 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public long[] productionData() {
/* 193 */     return this.produceData;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Industry industry() {
/* 199 */     return (Industry)blueprintI().industries().get(0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int industryI() {
/* 206 */     return 0;
/*     */   }
/*     */   
/*     */   public void changeTo(ROOM_FARM f) {
/* 210 */     ConstructionInit init = new ConstructionInit(0, f.constructor, null, 0, makeState(mX(), mY(), true));
/* 211 */     TmpArea a = remove(mX(), mY(), false, this, true);
/*     */     
/* 213 */     (SETT.ROOMS()).construction.createClean(a, init);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateTileDay(int tx, int ty) {
/* 219 */     blueprintI().tile(tx, ty).updateDay();
/* 220 */     if (this.irriI >= area()) {
/* 221 */       this.irri = this.irriNext;
/* 222 */       this.irriNext = 0.0D;
/* 223 */       this.irriI = 0;
/*     */     } 
/* 225 */     this.irriI = (short)(this.irriI + 1);
/* 226 */     this.irriNext += (SETT.GROUND()).MOISTURE_TOT.get(tx, ty);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public double productionRate(RoomInstance ins, Humanoid h, Industry in, IndustryResource oo) {
/* 232 */     if (employees().employed() == 0)
/* 233 */       return 0.0D; 
/* 234 */     return Util.prospect((FarmInstance)ins) / employees().employed() * TIME.years().bitConversion((TIMECYCLE)TIME.days());
/*     */   }
/*     */ 
/*     */   
/*     */   public RESOURCE_TILE getResTile() {
/* 239 */     if (!this.jobmanager.hasSearchedAll())
/* 240 */       return null; 
/* 241 */     if (this.resTimeout || this.storeTimeout)
/* 242 */       return null; 
/* 243 */     if (!this.tData.shouldStore()) {
/* 244 */       return null;
/*     */     }
/*     */     
/* 247 */     if (!is(this.resX, this.resY)) {
/* 248 */       this.resX = (short)body().x1();
/* 249 */       this.resY = (short)body().y1();
/*     */     } 
/*     */     
/* 252 */     for (int dy = 0; dy < body().height(); dy++) {
/* 253 */       for (int dx = 0; dx < body().width(); dx++) {
/*     */         
/* 255 */         RESOURCE_TILE rr = RESOURCE_TILE.GETTER.reservable(((IndustryResource)industry().outs().get(0)).resource, false, false, this.resX, this.resY);
/* 256 */         if (rr != null) {
/* 257 */           return rr;
/*     */         }
/* 259 */         this.resX = (short)(this.resX + 1);
/* 260 */         if (this.resX >= body().x2()) {
/* 261 */           this.resX = (short)body().x1();
/* 262 */           this.resY = (short)(this.resY + 1);
/* 263 */           if (this.resY >= body().y2()) {
/* 264 */             this.resY = (short)body().y1();
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/* 269 */     this.resTimeout = true;
/* 270 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public TILE_STORAGE getStoreTile() {
/* 275 */     if (this.storeTimeout)
/* 276 */       return null; 
/* 277 */     if (!this.tData.shouldStore()) {
/* 278 */       return null;
/*     */     }
/* 280 */     TILE_STORAGE s = (TILE_STORAGE)(SETT.PATH()).finders.storage.getter.get(this.stoX, this.stoY);
/* 281 */     if (s != null && s.storageReservable() > 0 && s.resource() == ((IndustryResource)industry().outs().get(0)).resource) {
/* 282 */       return s;
/*     */     }
/* 284 */     COORDINATE cc = (SETT.PATH()).finders.storage.reserve(mX(), mY(), ((IndustryResource)industry().outs().get(0)).resource, 103);
/*     */     
/* 286 */     if (cc != null) {
/* 287 */       this.stoX = (short)cc.x();
/* 288 */       this.stoY = (short)cc.y();
/* 289 */       s = (TILE_STORAGE)(SETT.PATH()).finders.storage.getter.get(this.stoX, this.stoY);
/* 290 */       s.storageUnreserve(1);
/* 291 */       return s;
/*     */     } 
/*     */     
/* 294 */     this.storeTimeout = true;
/* 295 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void main(String[] args) {
/* 302 */     double period = 15.0D;
/* 303 */     double degrade = 1.0D - 0.25D / period;
/* 304 */     double consumption = 4.0D;
/*     */     
/* 306 */     double res = 0.0D;
/*     */     
/* 308 */     for (int i = 0; i < 16; i++) {
/* 309 */       res += consumption;
/* 310 */       res /= degrade;
/*     */     } 
/*     */     
/* 313 */     LOG.ln(Double.valueOf(res / period * consumption));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\food\farm\FarmInstance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */