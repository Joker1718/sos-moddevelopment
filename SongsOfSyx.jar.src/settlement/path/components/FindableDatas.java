/*     */ package settlement.path.components;
/*     */ 
/*     */ import init.resources.RESOURCE;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.animal.Animal;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.job.Job;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.util.FINDABLE;
/*     */ import settlement.misc.util.RESOURCE_TILE;
/*     */ import settlement.misc.util.TILE_STORAGE;
/*     */ import settlement.path.finders.SFinderFindable;
/*     */ import settlement.room.home.house.HomeInstance;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.thing.THINGS;
/*     */ import settlement.thing.ThingFindable;
/*     */ import settlement.thing.ThingsResources;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import util.GUTIL;
/*     */ import util.data.DataOSimple;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class FindableDatas
/*     */ {
/*     */   public final FindableDataRes resScattered;
/*     */   public final FindableDataRes resCrate;
/*     */   public final FindableDataRes resPriority;
/*     */   public final FindableDataRes storage;
/*     */   public final FindableDataRes maintenanceRes;
/*     */   public final FindableDataSingle maintenance;
/*     */   public final FindableDataRes jobs;
/*     */   public final LIST<FindableDataRes> RESSES;
/*     */   private final FindableDataSingle[] findable;
/*     */   public final FindableDataSingle job;
/*     */   public final FindableDataSingle jobHarvest;
/*     */   private final FindableDataSingle[] people;
/*     */   public final FindableDataSingle reservableAnimals;
/*     */   public final FindableDataHome home;
/*     */   public final LIST<FindableDataSingle> SINGLES;
/*     */   
/*     */   FindableDatas() {
/*  57 */     FindableData.datao = new DataOSimple<SComponent>()
/*     */       {
/*     */         protected long[] data(SComponent t)
/*     */         {
/*  61 */           return t.fdata;
/*     */         }
/*     */       };
/*     */     
/*  65 */     FindableData.all.clear();
/*  66 */     FindableDataSingle.all.clear();
/*  67 */     FindableDataRes.all.clear();
/*     */ 
/*     */     
/*  70 */     this.findable = new FindableDataSingle[SFinderFindable.all().size()];
/*  71 */     for (int i = 0; i < this.findable.length; i++) {
/*  72 */       this.findable[i] = new FindableDataSingle(((SFinderFindable)SFinderFindable.all().get(i)).name);
/*     */     }
/*     */     
/*  75 */     this.resScattered = new FindableDataRes("R");
/*  76 */     this.resCrate = new FindableDataRes("Crate");
/*  77 */     this.resPriority = new FindableDataRes("Prio");
/*  78 */     this.storage = new FindableDataRes("Store");
/*     */     
/*  80 */     this.maintenanceRes = new FindableDataRes("Ma");
/*  81 */     this.maintenance = new FindableDataSingle("Maintain");
/*  82 */     this.jobs = new FindableDataRes("jobs");
/*  83 */     this.job = new FindableDataSingle("Job");
/*     */     
/*  85 */     this.jobHarvest = new FindableDataSingle("Job Harvest");
/*  86 */     this.people = new FindableDataSingle[] {
/*  87 */         new FindableDataSingle("Friendlies"), 
/*  88 */         new FindableDataSingle("Enemies")
/*     */       };
/*  90 */     this.reservableAnimals = new FindableDataSingle("Animals");
/*  91 */     this.home = new FindableDataHome();
/*  92 */     this.RESSES = (LIST<FindableDataRes>)new ArrayList((Iterable)FindableDataRes.all);
/*  93 */     this.SINGLES = (LIST<FindableDataSingle>)new ArrayList((Iterable)FindableDataSingle.all);
/*     */   }
/*     */   
/*     */   public FindableDataSingle people(boolean friend) {
/*  97 */     return this.people[friend ? 0 : 1];
/*     */   }
/*     */ 
/*     */   
/*     */   FindableDataSingle service(SFinderFindable f) {
/* 102 */     return this.findable[f.index];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void initComponent0(SComp0 c, RECTANGLE tiles) {
/* 108 */     c.clearData();
/*     */ 
/*     */     
/* 111 */     int tx1 = tiles.x1() - ((tiles.x1() > 0) ? 1 : 0);
/* 112 */     int tx2 = tiles.x2() + ((tiles.x2() < SETT.TWIDTH) ? 1 : 0);
/* 113 */     int ty1 = tiles.y1() - ((tiles.y1() > 0) ? 1 : 0);
/* 114 */     int ty2 = tiles.y2() + ((tiles.y2() < SETT.THEIGHT) ? 1 : 0);
/*     */ 
/*     */     
/* 117 */     for (int y = ty1; y < ty2; y++) {
/* 118 */       for (int x = tx1; x < tx2; x++) {
/* 119 */         if (is(c, x, y)) {
/*     */ 
/*     */           
/* 122 */           for (THINGS.Thing t : SETT.THINGS().get(x, y)) {
/*     */             
/* 124 */             if (t instanceof ThingsResources.ScatteredResource) {
/* 125 */               ThingsResources.ScatteredResource rw = (ThingsResources.ScatteredResource)t;
/* 126 */               if (!rw.findableReservedCanBe())
/*     */                 continue; 
/* 128 */               this.resScattered.add(c, rw.resource()); continue;
/* 129 */             }  if (t instanceof ThingFindable) {
/* 130 */               ThingFindable ti = (ThingFindable)t;
/* 131 */               if (ti.findableReservedCanBe()) {
/* 132 */                 this.findable[(ti.finder()).index].add(c);
/*     */               }
/*     */             } 
/*     */           } 
/*     */ 
/*     */           
/* 138 */           for (ENTITY ent : SETT.ENTITIES().getAtTile(x, y)) {
/* 139 */             if (ent instanceof Humanoid) {
/* 140 */               Humanoid a = (Humanoid)ent;
/* 141 */               people(!a.indu().hostile()).add(c); continue;
/* 142 */             }  if (ent instanceof Animal && (
/* 143 */               (Animal)ent).huntReservable()) {
/* 144 */               this.reservableAnimals.add(c);
/*     */             }
/*     */           } 
/*     */           
/* 148 */           if ((SETT.PATH().finders()).water.getReservable(x, y) != null) {
/* 149 */             this.findable[(SETT.PATH().finders()).water.index].add(c);
/* 150 */           } else if ((SETT.PATH()).finders.indoor.getReservable(x, y) != null) {
/* 151 */             this.findable[(SETT.PATH().finders()).indoor.index].add(c);
/*     */           } 
/* 153 */           Job j = (Job)(SETT.JOBS()).getter.get(x, y);
/* 154 */           if (j != null && j.jobReserveCanBe()) {
/* 155 */             RESOURCE r = j.resourceCurrentlyNeeded();
/* 156 */             if (r != null) {
/* 157 */               this.jobs.add(c, j.resourceCurrentlyNeeded());
/* 158 */             } else if (j.needsRipe()) {
/* 159 */               this.jobHarvest.add(c);
/*     */             } else {
/* 161 */               this.job.add(c);
/*     */             } 
/*     */           } 
/*     */           
/* 165 */           if ((SETT.MAINTENANCE()).reservable.is(x, y)) {
/* 166 */             RESOURCE res = (RESOURCE)(SETT.MAINTENANCE()).resource.get(x, y);
/* 167 */             if (res != null) {
/* 168 */               this.maintenanceRes.add(c, res);
/*     */             } else {
/* 170 */               this.maintenance.add(c);
/*     */             } 
/*     */           } 
/*     */ 
/*     */           
/* 175 */           Room i = (SETT.ROOMS()).map.get(x, y);
/* 176 */           if (i != null) {
/*     */ 
/*     */ 
/*     */             
/* 180 */             SFinderFindable se = i.blueprint().service(x, y);
/*     */             
/* 182 */             if (se != null) {
/*     */               
/* 184 */               FINDABLE t = se.getReservable(x, y);
/*     */               
/* 186 */               if (t != null) {
/* 187 */                 this.findable[se.index].add(c);
/*     */               }
/*     */             } 
/*     */ 
/*     */             
/* 192 */             RESOURCE_TILE r = i.resourceTile(x, y);
/* 193 */             if (r != null && r.findableReservedCanBe() && 
/* 194 */               r.isFindable())
/*     */             {
/* 196 */               if (r.isPrio()) {
/* 197 */                 this.resPriority.add(c, r.resource());
/* 198 */               } else if (r.isStorage()) {
/* 199 */                 this.resCrate.add(c, r.resource());
/*     */               } else {
/* 201 */                 this.resScattered.add(c, r.resource());
/*     */               } 
/*     */             }
/*     */ 
/*     */ 
/*     */             
/* 207 */             TILE_STORAGE s = i.storage(x, y);
/* 208 */             if (s != null && s.storageIsFindable() && s.resource() != null && s.storageReservable() > 0) {
/* 209 */               this.storage.add(c, s.resource());
/*     */             }
/*     */ 
/*     */ 
/*     */             
/* 214 */             HomeInstance h = (HomeInstance)(SETT.ROOMS()).HOME.service.get(x, y);
/* 215 */             if (h != null && 
/* 216 */               h.availability() != null) {
/* 217 */               this.home.add(c, h.availability());
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void initComponentN(SCompN c) {
/* 229 */     c.clearData();
/* 230 */     c.edgeMask = 0;
/*     */     
/* 232 */     GUTIL.filler().init(this);
/* 233 */     GUTIL.filler().fill(c.centreX(), c.centreY());
/*     */     
/* 235 */     SComponentLevel l = (SComponentLevel)(SETT.PATH()).comps.all.get(c.level().level() - 1);
/*     */     
/* 237 */     while (GUTIL.filler().hasMore()) {
/* 238 */       COORDINATE coo = GUTIL.filler().poll();
/* 239 */       SComponent s = (SComponent)l.get(coo);
/* 240 */       c.edgeMask = (byte)(c.edgeMask | (s.hasEdge() ? 1 : 0));
/* 241 */       c.edgeMask = (byte)(c.edgeMask | (s.hasEntry() ? 2 : 0));
/* 242 */       for (FindableData d : FindableData.all) {
/* 243 */         if (d.get(s) > 0) {
/* 244 */           d.add(c);
/*     */         }
/*     */       } 
/*     */       
/* 248 */       SComponentEdge e = s.edgefirst();
/* 249 */       while (e != null) {
/* 250 */         if (e.to().superComp() == c) {
/* 251 */           GUTIL.filler().fill(e.to().centreX(), e.to().centreY());
/*     */         }
/* 253 */         e = e.next();
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 258 */     GUTIL.filler().done();
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean is(SComponent c, int tx, int ty) {
/* 263 */     for (DIR d : DIR.ORTHO) {
/* 264 */       if (c.is(tx, ty, d))
/* 265 */         return true; 
/* 266 */     }  return c.is(tx, ty);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\components\FindableDatas.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */