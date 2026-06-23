/*     */ package settlement.room.food.orchard;
/*     */ 
/*     */ import settlement.entity.animal.ANIMAL_ROOM_RUINER;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.maintenance.ROOM_DEGRADER;
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
/*     */ import settlement.room.main.construction.ConstructionInit;
/*     */ import settlement.room.main.job.JobIterator;
/*     */ import settlement.room.main.job.RoomResStorage;
/*     */ import settlement.room.main.util.RoomInit;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.rnd.RND;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class Instance
/*     */   extends RoomInstance
/*     */   implements JOBMANAGER_HASER, ROOM_PRODUCER_INSTANCE, ANIMAL_ROOM_RUINER
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private long[] produceData;
/*     */   private double skill;
/*     */   private double skillPrev;
/*     */   private int skillI;
/*     */   public final float base;
/*  43 */   private byte sdx = 0; public float irri; private float irriNext; private short irriI; short trees; final short treesTotal; private final short ssx; private final short ssy;
/*  44 */   private byte sdy = 0;
/*     */   
/*  46 */   private final JobIterator jobmanager = new JobIterator(this)
/*     */     {
/*     */       private static final long serialVersionUID = 1L;
/*     */       
/*     */       protected SETT_JOB init(int tx, int ty) {
/*  51 */         OTile t = Instance.this.blueprintI().tile(tx, ty);
/*  52 */         if (t != null)
/*  53 */           return t.job(); 
/*  54 */         return null;
/*     */       }
/*     */     };
/*     */   
/*     */   Instance(ROOM_ORCHARD p, TmpArea area, RoomInit init) {
/*  59 */     super(p, area, init);
/*  60 */     double t = 0.0D;
/*  61 */     int ssx = -1;
/*  62 */     int ssy = 0;
/*  63 */     for (COORDINATE c : body()) {
/*  64 */       if (is(c)) {
/*  65 */         if (ssx == -1 && p.constructor.storage.get(c.x(), c.y(), (ROOMA)this) != null) {
/*  66 */           ssx = c.x();
/*  67 */           ssy = c.y();
/*  68 */           (SETT.ROOMS()).data.set((ROOMA)this, c, 0);
/*  69 */           p.constructor.storage.get(c.x(), c.y(), (ROOMA)this).dispose();
/*     */         } 
/*  71 */         this.irri = (float)(this.irri + (SETT.GROUND()).MOISTURE_TOT.get(c));
/*  72 */         if (p.tile.init(c.x(), c.y(), this)) {
/*  73 */           t++;
/*     */         }
/*     */       } 
/*     */     } 
/*  77 */     if (ssx == -1)
/*  78 */       throw new RuntimeException(); 
/*  79 */     this.ssx = (short)ssx;
/*  80 */     this.ssy = (short)ssy;
/*  81 */     this.treesTotal = (short)(int)t;
/*  82 */     this.base = (float)(t / ROOM_ORCHARD.TILES_PER_WORKER);
/*  83 */     int jobs = (int)Math.ceil(this.base);
/*  84 */     employees().maxSet((int)(jobs * 1.25D));
/*  85 */     employees().neededSet(jobs);
/*  86 */     this.produceData = p.productionData.makeData();
/*  87 */     activate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void loadFix() {
/*  94 */     this.produceData = (blueprintI()).productionData.makeDataFix(this.produceData);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateAction(double updateInterval, boolean day) {
/* 101 */     (blueprintI()).productionData.updateRoom((ROOM_IDATA_INSTANCE)this);
/*     */     
/* 103 */     if (day) {
/* 104 */       this.jobmanager.searchAgain();
/*     */       
/* 106 */       if ((blueprintI()).time.isDeadDay()) {
/* 107 */         this.skillPrev = skill();
/* 108 */         this.skill = 0.0D;
/* 109 */         this.skillI = 0;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void deposit(int am) {
/* 117 */     if (am == 0)
/*     */       return; 
/* 119 */     for (int i = 0; i < 4; i++) {
/* 120 */       RoomResStorage s = (blueprintI()).constructor.storage.get(this.ssx + this.sdx, this.ssy + this.sdy, (ROOMA)this);
/* 121 */       if (s == null) {
/* 122 */         System.out.println("" + this.ssx + " " + this.ssx + " " + this.sdx + " " + this.ssy);
/*     */         return;
/*     */       } 
/* 125 */       this.sdx = (byte)(this.sdx + 1);
/* 126 */       if (this.sdx >= 2) {
/* 127 */         this.sdx = 0;
/* 128 */         this.sdy = (byte)(this.sdy + 1);
/* 129 */         if (this.sdy >= 2)
/* 130 */           this.sdy = 0; 
/*     */       } 
/* 132 */       am -= s.deposit(am);
/* 133 */       if (am <= 0) {
/*     */         return;
/*     */       }
/*     */     } 
/*     */     
/* 138 */     (SETT.THINGS()).resources.create(this.ssx, this.ssy, ((IndustryResource)industry().outs().get(0)).resource, am);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean canRemoveAndRemoveAction(int tx, int ty, boolean scatter, Object obj, boolean forced) {
/* 144 */     if (scatter) {
/* 145 */       for (COORDINATE c : body()) {
/* 146 */         if (is(c)) {
/* 147 */           OTile t = (blueprintI()).tile.getM(c.x(), c.y());
/* 148 */           if (t != null) {
/* 149 */             t.chop();
/*     */           }
/*     */         } 
/*     */       } 
/*     */     }
/* 154 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean render(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator it) {
/* 159 */     int d = (SETT.ROOMS()).fData.spriteData2.get(it.tile());
/* 160 */     if (d != 0) {
/* 161 */       (blueprintI()).constructor.sEdge.render((SPRITE_RENDERER)r, shadowBatch, d, it, 0.0D, false);
/*     */     }
/*     */     
/* 164 */     return super.render(r, shadowBatch, it);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canBeGraced(int tx, int ty) {
/* 169 */     OTile t = blueprintI().tile(tx, ty);
/* 170 */     return (t != null && t.destroyTileCan());
/*     */   }
/*     */ 
/*     */   
/*     */   public void grace(int tx, int ty) {
/* 175 */     blueprintI().tile(tx, ty).destroyTile();
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
/*     */   protected void dispose() {
/* 192 */     for (COORDINATE c : body()) {
/* 193 */       if ((blueprintI()).constructor.storage.get(c.x(), c.y(), (ROOMA)this) != null) {
/* 194 */         (blueprintI()).constructor.storage.get(c.x(), c.y(), (ROOMA)this).dispose();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public JOB_MANAGER getWork() {
/* 201 */     return (JOB_MANAGER)this.jobmanager;
/*     */   }
/*     */ 
/*     */   
/*     */   public ROOM_ORCHARD blueprintI() {
/* 206 */     return (ROOM_ORCHARD)blueprint();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean acceptsWork() {
/* 211 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void destroyTile(int tx, int ty) {
/* 216 */     if (destroyTileCan(tx, ty)) {
/* 217 */       blueprintI().tile(tx, ty).destroyTile();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean destroyTileCan(int tx, int ty) {
/* 223 */     OTile t = blueprintI().tile(tx, ty);
/* 224 */     return (t != null && t.destroyTileCan());
/*     */   }
/*     */ 
/*     */   
/*     */   public ROOM_DEGRADER degrader(int tx, int ty) {
/* 229 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public long[] productionData() {
/* 234 */     return this.produceData;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Industry industry() {
/* 240 */     return (Industry)blueprintI().industries().get(0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int industryI() {
/* 247 */     return 0;
/*     */   }
/*     */   
/*     */   public void incSkill(double skill) {
/* 251 */     this.skill += skill;
/* 252 */     this.skillI++;
/*     */   }
/*     */   
/*     */   public void changeTo(ROOM_ORCHARD f) {
/* 256 */     ConstructionInit init = new ConstructionInit(0, f.constructor, null, 0, makeState(mX(), mY(), false));
/* 257 */     TmpArea a = remove(mX(), mY(), false, this, true);
/*     */     
/* 259 */     (SETT.ROOMS()).construction.createClean(a, init);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateTileDay(int tx, int ty) {
/* 266 */     OTile t = blueprintI().tile(tx, ty);
/* 267 */     if (t != null) {
/* 268 */       t.updateDay();
/*     */     }
/* 270 */     if (this.irriI >= area()) {
/* 271 */       this.irri = this.irriNext;
/* 272 */       this.irriNext = 0.0F;
/* 273 */       this.irriI = 0;
/*     */     } 
/* 275 */     this.irriI = (short)(this.irriI + 1);
/* 276 */     this.irriNext = (float)(this.irriNext + (SETT.GROUND()).MOISTURE_TOT.get(tx, ty));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RESOURCE_TILE resourceTile(int tx, int ty) {
/* 283 */     return (RESOURCE_TILE)(blueprintI()).constructor.storage.get(tx, ty, (ROOMA)this);
/*     */   }
/*     */ 
/*     */   
/*     */   public double skill() {
/* 288 */     if (this.skillI == 0)
/* 289 */       return this.skillPrev; 
/* 290 */     return this.skill / this.skillI;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean event() {
/* 295 */     boolean ff = false;
/* 296 */     for (COORDINATE c : body()) {
/* 297 */       if (is(c) && RND.rBoolean()) {
/* 298 */         OTile t = (blueprintI()).tile.getM(c.x(), c.y());
/* 299 */         if (t != null) {
/* 300 */           ff |= t.kill();
/*     */         }
/*     */       } 
/*     */     } 
/* 304 */     return ff;
/*     */   }
/*     */ 
/*     */   
/*     */   public double productionRate(RoomInstance ins, Humanoid h, Industry in, IndustryResource oo) {
/* 309 */     return super.productionRate(ins, h, in, oo) * this.trees / this.treesTotal;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\food\orchard\Instance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */