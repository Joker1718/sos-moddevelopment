/*     */ package settlement.room.food.pasture;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.FResources;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.HCLASS_RACE;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.animal.Animal;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.maintenance.ROOM_DEGRADER;
/*     */ import settlement.misc.job.JOBMANAGER_HASER;
/*     */ import settlement.misc.job.JOB_MANAGER;
/*     */ import settlement.misc.util.RESOURCE_TILE;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.room.industry.module.Industry;
/*     */ import settlement.room.industry.module.IndustryRate;
/*     */ import settlement.room.industry.module.IndustryResource;
/*     */ import settlement.room.industry.module.IndustryUtil;
/*     */ import settlement.room.industry.module.ROOM_IDATA_INSTANCE;
/*     */ import settlement.room.industry.module.ROOM_PRODUCER_INSTANCE;
/*     */ import settlement.room.industry.module.RoomBoost;
/*     */ import settlement.room.main.ROOMA;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.TmpArea;
/*     */ import settlement.room.main.job.RoomResStorage;
/*     */ import settlement.room.main.util.RoomInit;
/*     */ import settlement.thing.ThingsCadavers;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ public final class PastureInstance
/*     */   extends RoomInstance implements JOBMANAGER_HASER, ROOM_PRODUCER_INSTANCE {
/*     */   static final double WORKERPERANIMAL = 0.15D;
/*     */   private static final long serialVersionUID = 1L;
/*     */   private final short depX;
/*     */   private final short depY;
/*     */   final short animalsMax;
/*     */   short animalsCurrent;
/*  50 */   short animalsCubs = 0;
/*     */   
/*     */   short animalsToFetch;
/*     */   
/*     */   boolean missingLivestock = false;
/*     */   
/*     */   boolean searchForLivestock = true;
/*     */   boolean auto = false;
/*     */   private long[] productionData;
/*     */   private float skillPrev;
/*     */   private float skill;
/*     */   float prodPrev;
/*     */   int work;
/*     */   final int workMax;
/*  64 */   float animalsToDie = 0.0F;
/*     */   
/*     */   float water;
/*  67 */   private short waterCount = 0;
/*     */   
/*     */   float waterN;
/*  70 */   private short industry = 0;
/*     */   
/*     */   PastureInstance(ROOM_PASTURE p, TmpArea area, RoomInit init) {
/*  73 */     super(p, area, init);
/*     */ 
/*     */     
/*  76 */     int dx = mX();
/*  77 */     int dy = mY();
/*  78 */     for (COORDINATE c : body()) {
/*  79 */       if (!is(c))
/*     */         continue; 
/*  81 */       if ((blueprintI()).s2.get(c.x(), c.y(), (ROOMA)this) != null) {
/*  82 */         dx = c.x();
/*  83 */         dy = c.y();
/*     */         break;
/*     */       } 
/*  86 */       this.water = (float)(this.water + (SETT.GROUND()).MOISTURE_TOT.get(c.x(), c.y()));
/*     */     } 
/*     */     
/*  89 */     this.depX = (short)dx;
/*  90 */     this.depY = (short)dy;
/*  91 */     this.animalsMax = (short)(int)Math.ceil((blueprintI()).constructor.ferarea.get(this) * p.ANIMALS_PER_TILE);
/*  92 */     this.animalsToFetch = this.animalsMax;
/*     */     
/*  94 */     this.workMax = (int)((blueprintI()).constructor.ferarea.get(this) * 0.015625D * (blueprintI()).jobsPerDay);
/*  95 */     this.skillPrev = (float)blueprintI().bonus().get((BOOSTABLE_O)HCLASS_RACE.clP(null, HCLASSES.CITIZEN()));
/*  96 */     double work = (blueprintI()).constructor.workers.get(this);
/*  97 */     employees().maxSet((int)Math.ceil(work) * 2);
/*  98 */     employees().neededSet((int)Math.ceil(work));
/*  99 */     this.productionData = industry().makeData();
/* 100 */     activate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void loadFix() {
/* 107 */     this.industry = (short)CLAMP.i(this.industry, 0, (blueprintI()).indus.size() - 1);
/* 108 */     this.productionData = industry().makeDataFix(this.productionData);
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateTileDay(int tx, int ty) {
/* 113 */     this.waterCount = (short)(this.waterCount + 1);
/* 114 */     this.waterN = (float)(this.waterN + (SETT.GROUND()).MOISTURE_TOT.get(tx, ty));
/* 115 */     if (this.waterCount >= area()) {
/*     */       
/* 117 */       this.water = this.waterN;
/* 118 */       this.waterCount = 0;
/* 119 */       this.waterN = 0.0F;
/*     */     } 
/*     */     
/* 122 */     super.updateTileDay(tx, ty);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateAction(double updateInterval, boolean day) {
/* 128 */     if (day) {
/*     */       
/* 130 */       int needed = neededWork(this.animalsCurrent);
/*     */       
/* 132 */       if (needed > 0) {
/*     */         
/* 134 */         double dskill = (this.skill / this.work);
/* 135 */         if (this.work == 0)
/* 136 */           this.skill = 1.0F; 
/* 137 */         this.skillPrev = (float)dskill;
/*     */         
/* 139 */         double produce = 1.0D;
/* 140 */         for (RoomBoost rr : ((Industry)(blueprintI()).indus.get(0)).boosts()) {
/* 141 */           produce *= rr.get(this);
/*     */         }
/*     */         
/* 144 */         produce(produce);
/*     */         
/* 146 */         double toDie = CLAMP.d(1.0D - this.work / needed, 0.0D, 1.0D) * this.animalsCurrent;
/* 147 */         int death = (int)Math.min(toDie, this.animalsToDie);
/* 148 */         if (death >= 1) {
/* 149 */           int kill = CLAMP.i(death, 0, this.animalsCurrent);
/* 150 */           kill(kill);
/*     */         } 
/* 152 */         this.animalsToDie = (float)toDie;
/*     */       } else {
/* 154 */         this.skillPrev = (float)blueprintI().bonus().get((BOOSTABLE_O)HCLASS_RACE.clP(null, HCLASSES.CITIZEN()));
/*     */       } 
/*     */       
/* 157 */       this.animalsToFetch = (short)(this.animalsMax - this.animalsCurrent);
/* 158 */       this.work = 0;
/* 159 */       this.skill = 0.0F;
/*     */     } 
/*     */ 
/*     */     
/* 163 */     this.searchForLivestock = true;
/*     */     
/* 165 */     industry().updateRoom((ROOM_IDATA_INSTANCE)this);
/*     */   }
/*     */   
/*     */   public int kill(int killAmount) {
/* 169 */     int kill = 0;
/* 170 */     if (killAmount > 0) {
/* 171 */       for (ENTITY e : SETT.ENTITIES().fillTiles(body())) {
/* 172 */         if (is(e.physics.tileC()) && 
/* 173 */           e instanceof Animal) {
/* 174 */           Animal a = (Animal)e;
/* 175 */           if (a.domesticated()) {
/* 176 */             ThingsCadavers.Cadaver c = a.slaugher();
/* 177 */             if (c != null) {
/* 178 */               c.makeSkelleton();
/*     */             }
/* 180 */             kill++;
/* 181 */             if (kill == killAmount) {
/*     */               break;
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/* 189 */     return kill;
/*     */   }
/*     */   
/*     */   boolean needsWork() {
/* 193 */     if (this.work >= this.workMax)
/* 194 */       return false; 
/* 195 */     if (this.animalsCurrent >= this.animalsMax)
/* 196 */       return (this.work < this.workMax); 
/* 197 */     int l = this.animalsCurrent + 2 + this.animalsMax - this.animalsCurrent - this.animalsToFetch;
/* 198 */     int needed = neededWork(l);
/* 199 */     return (this.work < needed);
/*     */   }
/*     */   
/*     */   int neededWork(int animals) {
/* 203 */     double dAnimals = CLAMP.d(animals, 0.0D, this.animalsMax) / this.animalsMax;
/* 204 */     int needed = (int)(dAnimals * this.workMax);
/* 205 */     return needed;
/*     */   }
/*     */   
/*     */   boolean hasLivestockFetch() {
/* 209 */     return (this.animalsToFetch > 0);
/*     */   }
/*     */   
/*     */   boolean consumeALivestockFetch() {
/* 213 */     if (this.animalsToFetch > 0) {
/* 214 */       this.animalsToFetch = (short)(this.animalsToFetch - 1);
/* 215 */       return true;
/*     */     } 
/* 217 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   void work(Humanoid skill, RESOURCE r, COORDINATE coo) {
/* 222 */     if (r == RESOURCES.LIVESTOCK()) {
/*     */       
/* 224 */       if (this.animalsCurrent < this.animalsMax) {
/* 225 */         FACTIONS.player().res().inc(r, FResources.RTYPE.PRODUCED, -1);
/* 226 */         Animal a = new Animal(coo.x() * 64 + 32, coo.y() * 64 + 32, (blueprintI()).species, null);
/* 227 */         if (a != null && !a.isRemoved()) {
/* 228 */           a.domesticate();
/* 229 */           this.animalsCubs = (short)(this.animalsCubs + 1);
/* 230 */           this.animalsCurrent = (short)(this.animalsCurrent + 1);
/*     */         } 
/*     */       } else {
/* 233 */         (SETT.THINGS()).resources.create(coo, r, 1);
/*     */       } 
/*     */     } else {
/* 236 */       this.work++;
/* 237 */       this.skill = (float)(this.skill + industry().bonus().get((BOOSTABLE_O)skill.indu()));
/* 238 */       (SETT.GRASS()).currentI.increment(coo, 1);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void produce(double produce) {
/* 245 */     if (produce < 0.0D || !Double.isFinite(produce))
/*     */       return; 
/* 247 */     int i = 0;
/* 248 */     for (IndustryResource r : industry().outs()) {
/* 249 */       int am = r.inc((ROOM_IDATA_INSTANCE)this, produce * r.rate);
/*     */       
/* 251 */       RoomResStorage s = dStorage((blueprintI()).st[i++]);
/* 252 */       while (am-- > 0 && s.hasRoom()) {
/* 253 */         s.deposit();
/*     */       }
/* 255 */       if (am > 0) {
/* 256 */         GAME.player().res().inc(r.resource, FResources.RTYPE.SPOILAGE, -am);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean render(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator it) {
/* 263 */     boolean ret = super.render(r, shadowBatch, it);
/* 264 */     (blueprintI()).constructor.renderFence((SPRITE_RENDERER)r, shadowBatch, it, 0.0D);
/* 265 */     return ret;
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
/*     */   private RoomResStorage dStorage(RoomResStorage s) {
/* 281 */     if (s == (blueprintI()).s2)
/* 282 */       return (blueprintI()).s2.get(this.depX, this.depY, (ROOMA)this); 
/* 283 */     for (int k = 0; k < DIR.ORTHO.size(); k++) {
/* 284 */       int dx = this.depX + ((DIR)DIR.ORTHO.get(k)).x();
/* 285 */       int dy = this.depY + ((DIR)DIR.ORTHO.get(k)).y();
/* 286 */       RoomResStorage d = s.get(dx, dy, (ROOMA)this);
/* 287 */       if (d != null)
/* 288 */         return d; 
/*     */     } 
/* 290 */     throw new RuntimeException();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dispose() {
/* 296 */     for (ENTITY e : SETT.ENTITIES().fillTiles(body())) {
/* 297 */       if (is(e.physics.tileC()) && 
/* 298 */         e instanceof Animal) {
/* 299 */         Animal a = (Animal)e;
/* 300 */         if (a.domesticated()) {
/* 301 */           (SETT.THINGS()).resources.create(e.physics.tileC(), RESOURCES.LIVESTOCK(), 1);
/* 302 */           a.helloMyNameIsInigoMontoyaYouKilledMyFatherPrepareToDie();
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 310 */     (blueprintI()).s2.get(this.depX, this.depY, (ROOMA)this).dispose();
/* 311 */     dStorage((blueprintI()).s1).dispose();
/* 312 */     dStorage((blueprintI()).s3).dispose();
/*     */   }
/*     */ 
/*     */   
/*     */   void slaughterAll() {
/* 317 */     double produce = 0.0D;
/* 318 */     for (ENTITY e : SETT.ENTITIES().fillTiles(body())) {
/* 319 */       if (is(e.physics.tileC()) && 
/* 320 */         e instanceof Animal) {
/* 321 */         Animal a = (Animal)e;
/* 322 */         boolean cub = a.cub();
/* 323 */         if (a.domesticated()) {
/* 324 */           ThingsCadavers.Cadaver c = a.slaugher();
/* 325 */           if (c != null) {
/* 326 */             c.makeSkelleton();
/*     */           }
/* 328 */           produce += blueprintI().slaughterAmount(cub, industry());
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 334 */     int i = 0;
/* 335 */     for (IndustryResource r : industry().outs()) {
/* 336 */       if (r.resource == RESOURCES.LIVESTOCK())
/*     */         continue; 
/* 338 */       int am = r.inc((ROOM_IDATA_INSTANCE)this, produce * r.rate);
/* 339 */       RoomResStorage s = dStorage((blueprintI()).st[i++]);
/* 340 */       while (am-- > 0 && s.hasRoom()) {
/* 341 */         s.deposit();
/*     */       }
/* 343 */       if (am > 0) {
/* 344 */         (SETT.THINGS()).resources.create(s.x(), s.y(), r.resource, am);
/*     */       }
/*     */     } 
/*     */     
/* 348 */     if (this.animalsCurrent != 0)
/* 349 */       GAME.Notify("" + this.animalsCurrent); 
/* 350 */     this.animalsCurrent = 0;
/* 351 */     this.animalsCubs = 0;
/* 352 */     this.animalsToFetch = this.animalsMax;
/* 353 */     this.work = 0;
/* 354 */     this.skill = 0.0F;
/* 355 */     this.animalsToDie = 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public void removeAnimal(boolean cub) {
/* 360 */     this.animalsCurrent = (short)(this.animalsCurrent - 1);
/* 361 */     if (cub && this.animalsCubs > 0)
/* 362 */       this.animalsCubs = (short)(this.animalsCubs - 1); 
/* 363 */     if (this.animalsCurrent < 0) {
/* 364 */       GAME.Notify("werid!");
/* 365 */       this.animalsCurrent = 0;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void reportAdult() {
/* 370 */     if (this.animalsCubs > 0) {
/* 371 */       this.animalsCubs = (short)(this.animalsCubs - 1);
/*     */     }
/*     */   }
/*     */   
/*     */   public JOB_MANAGER getWork() {
/* 376 */     return JobManager.init(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public ROOM_PASTURE blueprintI() {
/* 381 */     return (ROOM_PASTURE)blueprint();
/*     */   }
/*     */ 
/*     */   
/*     */   protected AVAILABILITY getAvailability(int tile) {
/* 386 */     int tx = tile % SETT.TWIDTH;
/* 387 */     int ty = tile / SETT.TWIDTH;
/* 388 */     if ((blueprintI()).constructor.isFence((ROOMA)this, tx, ty))
/* 389 */       return (blueprintI()).isIndoors ? AVAILABILITY.AVOID_PASS : AVAILABILITY.SOLID; 
/* 390 */     return super.getAvailability(tile);
/*     */   }
/*     */ 
/*     */   
/*     */   public void destroyTile(int tx, int ty) {
/* 395 */     super.destroyTile(tx, ty);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean destroyTileCan(int tx, int ty) {
/* 400 */     return ((getAvailability(tx + ty * SETT.TWIDTH)).player < 0.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   public ROOM_DEGRADER degrader(int tx, int ty) {
/* 405 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public RESOURCE_TILE resourceTile(int tx, int ty) {
/* 410 */     RoomResStorage roomResStorage = (blueprintI()).s1.get(tx, ty, (ROOMA)this);
/* 411 */     if (roomResStorage != null)
/* 412 */       return (RESOURCE_TILE)roomResStorage; 
/* 413 */     roomResStorage = (blueprintI()).s2.get(tx, ty, (ROOMA)this);
/* 414 */     if (roomResStorage != null)
/* 415 */       return (RESOURCE_TILE)roomResStorage; 
/* 416 */     return (RESOURCE_TILE)(blueprintI()).s3.get(tx, ty, (ROOMA)this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public long[] productionData() {
/* 422 */     return this.productionData;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   double skill() {
/* 428 */     if (this.work == 0)
/* 429 */       return this.skillPrev; 
/* 430 */     if (this.work < 5) {
/* 431 */       double d = this.work / 5.0D;
/* 432 */       return this.skillPrev * (1.0D - d) + this.skill * d / this.work;
/*     */     } 
/* 434 */     return (this.skill / this.work);
/*     */   }
/*     */   
/*     */   public int animalsCurrent() {
/* 438 */     return this.animalsCurrent;
/*     */   }
/*     */ 
/*     */   
/*     */   public double productionRate(RoomInstance ins, Humanoid h, Industry in, IndustryResource oo) {
/* 443 */     if (employees().employed() == 0)
/* 444 */       return 0.0D; 
/* 445 */     return oo.rate * IndustryUtil.roomBonus(this, (IndustryRate)in) / employees().employed();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setIndustry(int i) {
/* 450 */     (blueprintI()).s2.get(this.depX, this.depY, (ROOMA)this).dispose();
/* 451 */     dStorage((blueprintI()).s1).dispose();
/* 452 */     dStorage((blueprintI()).s3).dispose();
/* 453 */     Industry in = (Industry)blueprintI().industries().get(i);
/* 454 */     if (in == null)
/*     */       return; 
/* 456 */     this.productionData = in.makeData();
/* 457 */     this.industry = (short)i;
/*     */   }
/*     */ 
/*     */   
/*     */   public Industry industry() {
/* 462 */     return (Industry)blueprintI().industries().getC(industryI());
/*     */   }
/*     */ 
/*     */   
/*     */   public int industryI() {
/* 467 */     return this.industry;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\food\pasture\PastureInstance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */