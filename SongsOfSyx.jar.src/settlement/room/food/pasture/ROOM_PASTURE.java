/*     */ package settlement.room.food.pasture;
/*     */ 
/*     */ import game.boosting.BoostSpec;
/*     */ import game.boosting.Boostable;
/*     */ import game.time.TIME;
/*     */ import init.resources.RESOURCE;
/*     */ import init.type.CLIMATE;
/*     */ import java.io.IOException;
/*     */ import settlement.entity.animal.AnimalSpecies;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.finders.SFinderFindable;
/*     */ import settlement.path.finders.SFinderRoomService;
/*     */ import settlement.room.industry.module.INDUSTRY_HASER;
/*     */ import settlement.room.industry.module.Industry;
/*     */ import settlement.room.industry.module.IndustryRegion;
/*     */ import settlement.room.industry.module.IndustryResource;
/*     */ import settlement.room.industry.module.IndustryUtil;
/*     */ import settlement.room.industry.module.RoomBoost;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.category.RoomCategorySub;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.job.ROOM_EMPLOY_AUTO;
/*     */ import settlement.room.main.job.RoomResStorage;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import settlement.room.water.RoomIrrigated;
/*     */ import settlement.weather.WeatherMoisture;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import util.data.DOUBLE_O;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.info.INFO;
/*     */ import util.text.Dic;
/*     */ import view.sett.ui.room.UIRoomModule;
/*     */ import world.map.regions.Region;
/*     */ import world.map.regions.RegionInfo;
/*     */ 
/*     */ public final class ROOM_PASTURE
/*     */   extends RoomBlueprintIns<PastureInstance>
/*     */   implements INDUSTRY_HASER, ROOM_EMPLOY_AUTO, RoomIrrigated.ROOM_IRRIGATED {
/*     */   public static final String type = "PASTURE";
/*     */   final Constructor constructor;
/*  52 */   final int jobsPerDay = TIME.getWorkPerDay(20.0D);
/*  53 */   final double capacityPerDay = 0.5D;
/*     */   
/*     */   public final AnimalSpecies species;
/*     */   final LIST<Industry> indus;
/*     */   final double ANIMALS_PER_TILE;
/*     */   static final double WORKERS_PER_TILE = 0.015625D;
/*     */   private final RoomIrrigated irri;
/*     */   public final boolean isIndoors;
/*     */   
/*  62 */   final RoomResStorage s1 = new RoomResStorage(3000)
/*     */     {
/*     */       public RESOURCE resource() {
/*  65 */         if (this.ins instanceof PastureInstance) {
/*  66 */           PastureInstance p = (PastureInstance)this.ins;
/*  67 */           if (p.industry().outs().size() > 0) {
/*  68 */             return ((IndustryResource)p.industry().outs().get(0)).resource;
/*     */           }
/*  70 */           return ((IndustryResource)p.industry().outs().get(0)).resource;
/*     */         } 
/*  72 */         return ((IndustryResource)((Industry)ROOM_PASTURE.this.indus.get(0)).outs().get(0)).resource;
/*     */       }
/*     */ 
/*     */       
/*     */       protected boolean is(int tx, int ty) {
/*  77 */         return ((SETT.ROOMS()).fData.tileData.get(tx, ty) == 100);
/*     */       }
/*     */     };
/*     */   
/*  81 */   final RoomResStorage s2 = new RoomResStorage(3000)
/*     */     {
/*     */       public RESOURCE resource() {
/*  84 */         if (this.ins instanceof PastureInstance) {
/*  85 */           PastureInstance p = (PastureInstance)this.ins;
/*  86 */           if (p.industry().outs().size() > 1) {
/*  87 */             return ((IndustryResource)p.industry().outs().get(1)).resource;
/*     */           }
/*  89 */           return ((IndustryResource)p.industry().outs().get(0)).resource;
/*     */         } 
/*  91 */         return ((IndustryResource)((Industry)ROOM_PASTURE.this.indus.get(0)).outs().get(0)).resource;
/*     */       }
/*     */ 
/*     */       
/*     */       protected boolean is(int tx, int ty) {
/*  96 */         return ((SETT.ROOMS()).fData.tileData.get(tx, ty) == 200);
/*     */       }
/*     */     };
/*     */   
/* 100 */   final RoomResStorage s3 = new RoomResStorage(3000)
/*     */     {
/*     */       public RESOURCE resource() {
/* 103 */         if (this.ins instanceof PastureInstance) {
/* 104 */           PastureInstance p = (PastureInstance)this.ins;
/* 105 */           if (p.industry().outs().size() > 2) {
/* 106 */             return ((IndustryResource)p.industry().outs().get(2)).resource;
/*     */           }
/* 108 */           return ((IndustryResource)p.industry().outs().get(0)).resource;
/*     */         } 
/* 110 */         return ((IndustryResource)((Industry)ROOM_PASTURE.this.indus.get(0)).outs().get(0)).resource;
/*     */       }
/*     */ 
/*     */       
/*     */       protected boolean is(int tx, int ty) {
/* 115 */         return ((SETT.ROOMS()).fData.tileData.get(tx, ty) == 300);
/*     */       }
/*     */     };
/*     */   
/* 119 */   final RoomResStorage[] st = new RoomResStorage[] {
/* 120 */       this.s1, this.s2, this.s3
/*     */     };
/*     */   
/*     */   public ROOM_PASTURE(RoomInitData data, String key, RoomCategorySub cat, int index) throws IOException {
/* 124 */     super(index, data, key, cat);
/*     */     
/* 126 */     this.species = (AnimalSpecies)(SETT.ANIMALS()).map.read(data.data());
/*     */     
/* 128 */     this.ANIMALS_PER_TILE = CLAMP.d(2.5D / (this.species.mass() + 10.0D), 0.0D, 0.1111111111111111D);
/*     */     
/* 130 */     this.isIndoors = data.data().bool("INDOORS", false);
/*     */     
/* 132 */     this.constructor = this.isIndoors ? new ConstructorIndoor(this, data) : new ConstructorOutdoor(this, data);
/* 133 */     pushBo(data.data(), "PASTURE", true);
/* 134 */     ArrayListGrower<RoomBoost> bbs = new ArrayListGrower();
/* 135 */     bbs.add(this.constructor.efficiency);
/* 136 */     bbs.add(new RoomBoost()
/*     */         {
/* 138 */           INFO info = new INFO(Dic.¤¤Capacity, Dic.¤¤Capacity);
/*     */ 
/*     */           
/*     */           public INFO info() {
/* 142 */             return this.info;
/*     */           }
/*     */ 
/*     */           
/*     */           public double get(RoomInstance r) {
/* 147 */             return ROOM_PASTURE.this.constructor.ferarea.get(r) * 0.015625D;
/*     */           }
/*     */         });
/* 150 */     bbs.add(new RoomBoost()
/*     */         {
/* 152 */           INFO info = new INFO(Gui.¤¤Skill, Gui.¤¤SkillD);
/*     */ 
/*     */           
/*     */           public INFO info() {
/* 156 */             return this.info;
/*     */           }
/*     */ 
/*     */           
/*     */           public double get(RoomInstance r) {
/* 161 */             PastureInstance p = (PastureInstance)r;
/* 162 */             return p.skill();
/*     */           }
/*     */         });
/* 165 */     bbs.add(new RoomBoost()
/*     */         {
/* 167 */           INFO info = new INFO(Gui.¤¤Animals, Gui.¤¤Animals);
/*     */ 
/*     */           
/*     */           public INFO info() {
/* 171 */             return this.info;
/*     */           }
/*     */ 
/*     */           
/*     */           public double get(RoomInstance r) {
/* 176 */             PastureInstance p = (PastureInstance)r;
/* 177 */             return p.animalsCurrent / p.animalsMax;
/*     */           }
/*     */         });
/* 180 */     bbs.add(new RoomBoost()
/*     */         {
/* 182 */           INFO info = new INFO(Gui.¤¤Adults, Gui.¤¤Adults);
/*     */ 
/*     */           
/*     */           public INFO info() {
/* 186 */             return this.info;
/*     */           }
/*     */ 
/*     */           
/*     */           public double get(RoomInstance r) {
/* 191 */             PastureInstance p = (PastureInstance)r;
/* 192 */             if (p.animalsCurrent <= 0)
/* 193 */               return 0.0D; 
/* 194 */             double an = (p.animalsCurrent - p.animalsCubs);
/* 195 */             an = CLAMP.d(an, 0.0D, p.animalsCurrent);
/* 196 */             an /= p.animalsCurrent;
/* 197 */             return 0.1D + 0.9D * an;
/*     */           }
/*     */         });
/* 200 */     bbs.add(new RoomBoost()
/*     */         {
/* 202 */           INFO info = new INFO(Gui.¤¤Tending, Gui.¤¤Tending);
/*     */ 
/*     */           
/*     */           public INFO info() {
/* 206 */             return this.info;
/*     */           }
/*     */ 
/*     */           
/*     */           public double get(RoomInstance r) {
/* 211 */             PastureInstance p = (PastureInstance)r;
/* 212 */             if (p.animalsCurrent == 0) {
/* 213 */               return 1.0D;
/*     */             }
/* 215 */             return 1.0D - p.animalsToDie / p.animalsCurrent;
/*     */           }
/*     */         });
/*     */     
/* 219 */     if (this.isIndoors) {
/* 220 */       bbs.add(new RoomBoost()
/*     */           {
/* 222 */             INFO info = new INFO(Dic.¤¤Isolation, Dic.¤¤Isolation);
/*     */ 
/*     */             
/*     */             public INFO info() {
/* 226 */               return this.info;
/*     */             }
/*     */ 
/*     */             
/*     */             public double get(RoomInstance r) {
/* 231 */               return r.isolation(r.mX(), r.mY());
/*     */             }
/*     */           });
/*     */     } else {
/* 235 */       bbs.add(WeatherMoisture.makeBoost());
/*     */     } 
/*     */     
/* 238 */     RoomBoost[] bos = new RoomBoost[bbs.size()];
/* 239 */     for (int i = 0; i < bos.length; i++) {
/* 240 */       bos[i] = (RoomBoost)bbs.get(i);
/*     */     }
/*     */     
/* 243 */     DOUBLE_O<Region> gg = new DOUBLE_O<Region>()
/*     */       {
/*     */         public double getD(Region t)
/*     */         {
/* 247 */           return 0.5D + 0.5D * RegionInfo.vArea().getAi(t);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 252 */     this.indus = Industry.createIndustries((RoomBlueprintImp)this, data, bos, bonus(), gg);
/*     */     
/* 254 */     for (Industry industry : this.indus) {
/* 255 */       if (industry.outs().size() > 3)
/* 256 */         data.data().error("Can't declare more than 3 output in industry!", ""); 
/* 257 */       if (industry.ins().size() > 0) {
/* 258 */         data.data().error("Can't declare inputs to a pasture industry", "");
/*     */       }
/*     */     } 
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 279 */     this.irri = new RoomIrrigated(this, this.bonus, 0.5D, 1.075D)
/*     */       {
/*     */         public double needed(AREA area)
/*     */         {
/* 283 */           return area.area();
/*     */         }
/*     */ 
/*     */         
/*     */         protected double irrigation(RoomInstance ins) {
/* 288 */           return ((PastureInstance)ins).water;
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public double slaughterAmount(boolean cub, Industry ins) {
/* 296 */     return 8.0D * (cub ? 0.25D : 1.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void update(double ds) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public SFinderRoomService service(int tx, int ty) {
/* 307 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void saveP(FilePutter saveFile) {
/* 312 */     IndustryUtil.save(saveFile, this.indus);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void loadP(FileGetter saveFile) throws IOException {
/* 317 */     IndustryUtil.load(saveFile, this.indus);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clearP() {
/* 322 */     IndustryUtil.clear(this.indus);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean degrades() {
/* 327 */     return false;
/*     */   }
/*     */   
/*     */   public static boolean isGate(int tx, int ty) {
/* 331 */     return ((SETT.ROOMS()).map.blueprint.get(tx, ty) instanceof ROOM_PASTURE && (SETT.ROOMS()).fData.tile.is(tx, ty));
/*     */   }
/*     */ 
/*     */   
/*     */   public Furnisher constructor() {
/* 336 */     return this.constructor;
/*     */   }
/*     */ 
/*     */   
/*     */   public void appendView(LISTE<UIRoomModule> mm) {
/* 341 */     mm.add((new Gui(this)).make());
/*     */   }
/*     */ 
/*     */   
/*     */   public LIST<Industry> industries() {
/* 346 */     return this.indus;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isAvailable(CLIMATE c) {
/* 351 */     for (BoostSpec s : c.boosters.all()) {
/* 352 */       if (s.boostable == bonus() && s.booster.isMul && s.booster.min() == 0.0D)
/* 353 */         return false; 
/*     */     } 
/* 355 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean autoEmploy(Room r) {
/* 360 */     return ((PastureInstance)r).auto;
/*     */   }
/*     */ 
/*     */   
/*     */   public void autoEmploy(Room r, boolean b) {
/* 365 */     ((PastureInstance)r).auto = b;
/*     */   }
/*     */ 
/*     */   
/*     */   public double degradeRate() {
/* 370 */     return 0.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public double industryFormatProductionRate(GText text, IndustryResource i, RoomInstance ins) {
/* 375 */     double prod = i.rate;
/*     */     
/* 377 */     for (RoomBoost bb : ((Industry)this.indus.get(0)).boosts()) {
/* 378 */       prod *= bb.get(ins);
/*     */     }
/* 380 */     text.add('+');
/* 381 */     GFORMAT.f(text, prod);
/* 382 */     return prod;
/*     */   }
/*     */ 
/*     */   
/*     */   public void industryHoverProductionRate(GBox b, IndustryResource i, RoomInstance ins) {
/* 387 */     Gui.industryHoverProductionRate(b, i, ins);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double industryFormatProductionRateEmpl(GText text, IndustryResource i, RoomInstance ins) {
/* 394 */     text.clear();
/* 395 */     double prod = i.rate;
/*     */     
/* 397 */     for (RoomBoost bb : ((Industry)this.indus.get(0)).boosts()) {
/* 398 */       prod *= bb.get(ins);
/*     */     }
/* 400 */     return prod;
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomIrrigated irrigation() {
/* 405 */     return this.irri;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\food\pasture\ROOM_PASTURE.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */