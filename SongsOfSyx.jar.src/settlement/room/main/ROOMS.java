/*     */ package settlement.room.main;
/*     */ 
/*     */ import game.boosting.BOOSTING;
/*     */ import game.boosting.Boostable;
/*     */ import game.debug.Profiler;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.util.FSERVICE;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.path.finders.SFinderRoomService;
/*     */ import settlement.room.food.cannibal.ROOM_CANNIBAL;
/*     */ import settlement.room.food.farm.ROOM_FARM;
/*     */ import settlement.room.food.fish.ROOM_FISHERY;
/*     */ import settlement.room.food.hunter.ROOM_HUNTER;
/*     */ import settlement.room.food.orchard.ROOM_ORCHARD;
/*     */ import settlement.room.food.pasture.ROOM_PASTURE;
/*     */ import settlement.room.health.asylum.ROOM_ASYLUM;
/*     */ import settlement.room.health.hospital.ROOM_HOSPITAL;
/*     */ import settlement.room.health.physician.ROOM_PHYSICIAN;
/*     */ import settlement.room.home.chamber.ROOM_CHAMBER;
/*     */ import settlement.room.home.house.ROOM_HOME;
/*     */ import settlement.room.industry.mine.ROOM_MINE;
/*     */ import settlement.room.industry.module.INDUSTRY_HASER;
/*     */ import settlement.room.industry.module.Industry;
/*     */ import settlement.room.industry.module.RoomIndustries;
/*     */ import settlement.room.industry.module.RoomProduction;
/*     */ import settlement.room.industry.refiner.ROOM_REFINER;
/*     */ import settlement.room.industry.woodcutter.ROOM_WOODCUTTER;
/*     */ import settlement.room.industry.workshop.ROOM_WORKSHOP;
/*     */ import settlement.room.infra.admin.ROOM_ADMIN;
/*     */ import settlement.room.infra.bench.ROOM_BENCH;
/*     */ import settlement.room.infra.builder.ROOM_BUILDER;
/*     */ import settlement.room.infra.elderly.ROOM_RESTHOME;
/*     */ import settlement.room.infra.embassy.ROOM_EMBASSY;
/*     */ import settlement.room.infra.export.ROOM_EXPORT;
/*     */ import settlement.room.infra.gate.ROOM_GATE;
/*     */ import settlement.room.infra.hauler.ROOM_HAULER;
/*     */ import settlement.room.infra.importt.ROOM_IMPORT;
/*     */ import settlement.room.infra.inn.ROOM_INN;
/*     */ import settlement.room.infra.janitor.ROOM_JANITOR;
/*     */ import settlement.room.infra.monument.ROOM_MONUMENTS;
/*     */ import settlement.room.infra.station.ROOM_STATION;
/*     */ import settlement.room.infra.stockpile.ROOM_STOCKPILE;
/*     */ import settlement.room.infra.transport.ROOM_TRANSPORT;
/*     */ import settlement.room.knowledge.laboratory.ROOM_LABORATORY;
/*     */ import settlement.room.knowledge.library.ROOM_LIBRARY;
/*     */ import settlement.room.knowledge.school.ROOM_SCHOOL;
/*     */ import settlement.room.knowledge.university.ROOM_UNIVERSITY;
/*     */ import settlement.room.law.court.ROOM_COURT;
/*     */ import settlement.room.law.execution.ROOM_EXECTUTION;
/*     */ import settlement.room.law.guard.ROOM_GUARD;
/*     */ import settlement.room.law.police.ROOM_POLICE;
/*     */ import settlement.room.law.prison.ROOM_PRISON;
/*     */ import settlement.room.law.stockade.ROOM_STOCKADE;
/*     */ import settlement.room.law.stocks.ROOM_STOCKS;
/*     */ import settlement.room.main.category.RoomCategories;
/*     */ import settlement.room.main.category.RoomCategorySub;
/*     */ import settlement.room.main.construction.CONSTRUCTION;
/*     */ import settlement.room.main.copy.ROOM_COPY;
/*     */ import settlement.room.main.employment.RoomEmployments;
/*     */ import settlement.room.main.job.ResourceUnderflow;
/*     */ import settlement.room.main.placement.PLACEMENT;
/*     */ import settlement.room.main.throne.THRONE;
/*     */ import settlement.room.main.util.Deleter;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import settlement.room.main.util.RoomIsolation;
/*     */ import settlement.room.main.util.RoomStats;
/*     */ import settlement.room.main.util.RoomUtil;
/*     */ import settlement.room.main.util.RoomsCreator;
/*     */ import settlement.room.military.artillery.ROOM_ARTILLERY;
/*     */ import settlement.room.military.supply.ROOM_SUPPLY;
/*     */ import settlement.room.military.training.archery.ROOM_ARCHERY;
/*     */ import settlement.room.military.training.barracks.ROOM_BARRACKS;
/*     */ import settlement.room.service.arena.grand.ROOM_ARENA;
/*     */ import settlement.room.service.arena.pit.ROOM_FIGHTPIT;
/*     */ import settlement.room.service.barber.ROOM_BARBER;
/*     */ import settlement.room.service.breeder.ROOM_BREEDER;
/*     */ import settlement.room.service.food.canteen.ROOM_CANTEEN;
/*     */ import settlement.room.service.food.eatery.ROOM_EATERY;
/*     */ import settlement.room.service.food.tavern.ROOM_TAVERN;
/*     */ import settlement.room.service.hearth.ROOM_HEARTH;
/*     */ import settlement.room.service.hygine.bath.ROOM_BATH;
/*     */ import settlement.room.service.hygine.well.ROOM_WELL;
/*     */ import settlement.room.service.lavatory.ROOM_LAVATORY;
/*     */ import settlement.room.service.market.ROOM_MARKET;
/*     */ import settlement.room.service.module.ROOM_SPECTATOR;
/*     */ import settlement.room.service.module.RoomServiceAccess;
/*     */ import settlement.room.service.nursery.ROOM_NURSERY;
/*     */ import settlement.room.service.pleasure.ROOM_PLEASURE;
/*     */ import settlement.room.service.speaker.ROOM_SPEAKER;
/*     */ import settlement.room.service.stage.ROOM_STAGE;
/*     */ import settlement.room.spirit.dump.ROOM_DUMP;
/*     */ import settlement.room.spirit.grave.GraveData;
/*     */ import settlement.room.spirit.grave.ROOM_GRAVEYARD;
/*     */ import settlement.room.spirit.grave.ROOM_TOMB;
/*     */ import settlement.room.spirit.temple.ROOM_TEMPLES;
/*     */ import settlement.room.water.ROOM_WATER;
/*     */ import settlement.room.water.pool.ROOM_POOL;
/*     */ import settlement.tilemap.TileMap;
/*     */ import snake2d.LOG;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.DIMENSION;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.Bitsmap2D;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import util.keymap.RMAPS;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class ROOMS
/*     */   extends TileMap.Resource
/*     */ {
/*     */   public static final String KEY = "ROOM";
/* 123 */   public final RoomsMap map = new RoomsMap();
/* 124 */   final MapRoomData.Data pData = new MapRoomData.Data();
/* 125 */   public final MapRoomData data = this.pData;
/* 126 */   public final Bitsmap2D extraBit = new Bitsmap2D(0, 2, (DIMENSION)SETT.TILE_BOUNDS);
/*     */   
/*     */   private final Updater updater;
/*     */   
/* 130 */   public final Deleter DELETE = new Deleter(this);
/* 131 */   public final RoomIsolation isolation = new RoomIsolation(this);
/* 132 */   final TmpArea tmpArea = new TmpArea(this);
/* 133 */   public final PLACEMENT placement = new PLACEMENT(this);
/* 134 */   public final CONSTRUCTION construction = new CONSTRUCTION(this);
/*     */   public final ROOM_COPY copy;
/* 136 */   public final MapDataF fData = new MapDataF(this);
/* 137 */   public final RoomCategories CATS = new RoomCategories(this);
/* 138 */   public final RoomStats stats = new RoomStats();
/* 139 */   public final RoomUtil util = new RoomUtil();
/* 140 */   private RoomInitData init = (new RoomInitData(this)).setType(null);
/*     */ 
/*     */   
/* 143 */   public final ROOM_STOCKPILE STOCKPILE = new ROOM_STOCKPILE(this.init, this.CATS.LOGISTICS);
/* 144 */   public final ROOM_EXPORT EXPORT = new ROOM_EXPORT(this.init, this.CATS.LOGISTICS);
/* 145 */   public final ROOM_IMPORT IMPORT = new ROOM_IMPORT(this.init, this.CATS.LOGISTICS);
/* 146 */   public final ROOM_SUPPLY SUPPLY = new ROOM_SUPPLY(this.init, this.CATS.MILITARY);
/* 147 */   public final ROOM_HAULER HAULER = new ROOM_HAULER(this.init, this.CATS.LOGISTICS);
/* 148 */   public final ROOM_TRANSPORT TRANSPORT = new ROOM_TRANSPORT(this.init, this.CATS.LOGISTICS);
/* 149 */   public final ROOM_STATION STATION = new ROOM_STATION(this.init, this.CATS.LOGISTICS);
/* 150 */   public final ROOM_JANITOR JANITOR = new ROOM_JANITOR(this.init, this.CATS.MAIN_INFRA.misc);
/* 151 */   public final ROOM_EMBASSY EMBASSY = new ROOM_EMBASSY(this.init, this.CATS.ADMIN);
/* 152 */   public final ROOM_DUMP DUMP = new ROOM_DUMP(this.init, this.CATS.SER_DEATH);
/* 153 */   public final ROOM_WOODCUTTER WOOD_CUTTER = new ROOM_WOODCUTTER(this.init, this.CATS.MAIN_INDUSTRY.misc);
/*     */   
/* 155 */   public final ROOM_CANNIBAL CANNIBAL = new ROOM_CANNIBAL(this.init, this.CATS.MAIN_INDUSTRY.misc);
/* 156 */   public final ROOM_WATER WATER = new ROOM_WATER(this.init, this.CATS.WATER);
/*     */   
/* 158 */   public final ROOM_STOCKADE STOCKADE = new ROOM_STOCKADE(this.init, this.CATS.LAW);
/* 159 */   public final ROOM_GUARD GUARD = new ROOM_GUARD(this.init, this.CATS.LAW);
/* 160 */   public final ROOM_PRISON PRISON = new ROOM_PRISON(this.init, this.CATS.LAW);
/* 161 */   public final ROOM_EXECTUTION EXECUTION = new ROOM_EXECTUTION(this.init, this.CATS.LAW);
/* 162 */   public final ROOM_POLICE POLICE = new ROOM_POLICE(this.init, this.CATS.LAW);
/* 163 */   public final ROOM_STOCKS STOCKS = new ROOM_STOCKS(this.init, this.CATS.LAW);
/* 164 */   public final ROOM_COURT COURT = new ROOM_COURT(this.init, this.CATS.LAW);
/* 165 */   public final THRONE THRONE = new THRONE(this.init, this.CATS.MAIN_INFRA.misc);
/* 166 */   public final ROOM_BUILDER BUILDER = new ROOM_BUILDER(this.init, this.CATS.MAIN_INFRA.misc);
/* 167 */   public final ROOM_HEARTH HEARTH = new ROOM_HEARTH("_HEARTH", 0, this.init, this.CATS.SER_HEALTH);
/* 168 */   public final ROOM_HOME HOME = new ROOM_HOME(this.init, this.CATS.SER_HOME);
/* 169 */   public final ROOM_CHAMBER CHAMBER = new ROOM_CHAMBER(this.init, this.CATS.SER_HOME);
/* 170 */   public final ROOM_ASYLUM ASYLUM = new ROOM_ASYLUM(this.init, this.CATS.SER_HEALTH);
/*     */   
/* 172 */   public final ROOM_HOSPITAL HOSPITAL = new ROOM_HOSPITAL(this.init, this.CATS.SER_HEALTH);
/* 173 */   public final ROOM_INN INN = new ROOM_INN(this.init, this.CATS.ADMIN);
/*     */   
/* 175 */   public final ROOM_MONUMENTS MONUMENTS = new ROOM_MONUMENTS(this.init, this.CATS);
/*     */   
/* 177 */   public final ROOM_BENCH BENCH = new ROOM_BENCH(this.init, this.CATS.DECOR);
/*     */   
/* 179 */   public final ResourceUnderflow resourceUnderflow = new ResourceUnderflow();
/*     */   
/* 181 */   public final LIST<ROOM_POOL> POOLS = (new RoomsCreator<ROOM_POOL>(this.init, "POOL", 
/* 182 */       this.CATS.WATER)
/*     */     {
/*     */       
/*     */       public ROOM_POOL create(String key, RoomInitData data, RoomCategorySub cat, int index) throws IOException
/*     */       {
/* 187 */         return new ROOM_POOL(index, data, key, cat);
/*     */       }
/* 189 */     }).all();
/*     */   
/* 191 */   public final LIST<ROOM_BARRACKS> BARRACKS = (new RoomsCreator<ROOM_BARRACKS>(this.init, "BARRACKS", 
/* 192 */       this.CATS.MILITARY)
/*     */     {
/*     */       
/*     */       public ROOM_BARRACKS create(String key, RoomInitData data, RoomCategorySub cat, int index) throws IOException
/*     */       {
/* 197 */         return new ROOM_BARRACKS(index, data, key);
/*     */       }
/* 199 */     }).all();
/*     */   
/* 201 */   public final LIST<ROOM_ARCHERY> ARCHERIES = (new RoomsCreator<ROOM_ARCHERY>(this.init, "ARCHERY", 
/* 202 */       this.CATS.MILITARY)
/*     */     {
/*     */       
/*     */       public ROOM_ARCHERY create(String key, RoomInitData data, RoomCategorySub cat, int index) throws IOException
/*     */       {
/* 207 */         return new ROOM_ARCHERY(index, data, key);
/*     */       }
/* 209 */     }).all();
/*     */ 
/*     */   
/* 212 */   public final LIST<ROOM_GATE> GATES = (new RoomsCreator<ROOM_GATE>(this.init, ROOM_GATE.type, 
/* 213 */       this.CATS.MILITARY)
/*     */     {
/*     */       
/*     */       public ROOM_GATE create(String key, RoomInitData data, RoomCategorySub cat, int index) throws IOException
/*     */       {
/* 218 */         return new ROOM_GATE(data, index, key, cat);
/*     */       }
/* 220 */     }).all();
/*     */   
/* 222 */   public final LIST<ROOM_ARTILLERY> ARTILLERY = (new RoomsCreator<ROOM_ARTILLERY>(this.init, "ARTILLERY", 
/* 223 */       this.CATS.MILITARY)
/*     */     {
/*     */       
/*     */       public ROOM_ARTILLERY create(String key, RoomInitData data, RoomCategorySub cat, int index) throws IOException
/*     */       {
/* 228 */         return new ROOM_ARTILLERY(index, data, key, cat);
/*     */       }
/* 230 */     }).all();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 235 */   public final LIST<ROOM_FISHERY> FISHERIES = (new RoomsCreator<ROOM_FISHERY>(this.init, "FISHERY", 
/* 236 */       this.CATS.FISH)
/*     */     {
/*     */       
/*     */       public ROOM_FISHERY create(String key, RoomInitData data, RoomCategorySub cat, int index) throws IOException
/*     */       {
/* 241 */         return new ROOM_FISHERY(data, key, index, cat);
/*     */       }
/* 243 */     }).all();
/*     */   
/* 245 */   public final LIST<ROOM_MINE> MINES = (new RoomsCreator<ROOM_MINE>(this.init, "MINE", 
/* 246 */       this.CATS.MINES)
/*     */     {
/*     */       public ROOM_MINE create(String key, RoomInitData data, RoomCategorySub cat, int index) throws IOException
/*     */       {
/* 250 */         return new ROOM_MINE(data, key, index, cat);
/*     */       }
/* 252 */     }).all();
/*     */ 
/*     */   
/* 255 */   public final LIST<ROOM_FARM> FARMS = (new RoomsCreator<ROOM_FARM>(this.init, "FARM", this.CATS.FARMS)
/*     */     {
/*     */       public ROOM_FARM create(String key, RoomInitData data, RoomCategorySub cat, int index) throws IOException
/*     */       {
/* 259 */         return new ROOM_FARM(data, key, cat, index);
/*     */       }
/* 262 */     }).all();
/*     */   
/* 264 */   public final LIST<ROOM_ORCHARD> ORCHARDS = (new RoomsCreator<ROOM_ORCHARD>(this.init, "ORCHARD", this.CATS.FARMS)
/*     */     {
/*     */       public ROOM_ORCHARD create(String key, RoomInitData data, RoomCategorySub cat, int index) throws IOException
/*     */       {
/* 268 */         return new ROOM_ORCHARD(data, key, cat, index);
/*     */       }
/* 271 */     }).all();
/*     */   
/* 273 */   public final LIST<ROOM_PASTURE> PASTURES = (new RoomsCreator<ROOM_PASTURE>(this.init, "PASTURE", this.CATS.HUSBANDRY)
/*     */     {
/*     */       public ROOM_PASTURE create(String key, RoomInitData data, RoomCategorySub cat, int index) throws IOException
/*     */       {
/* 277 */         return new ROOM_PASTURE(data, key, cat, index);
/*     */       }
/* 280 */     }).all();
/*     */   
/* 282 */   public final LIST<ROOM_HUNTER> HUNTERS = (new RoomsCreator<ROOM_HUNTER>(this.init, "HUNTER", this.CATS.MAIN_AGRIULTURE.misc)
/*     */     {
/*     */       public ROOM_HUNTER create(String key, RoomInitData data, RoomCategorySub cat, int index) throws IOException
/*     */       {
/* 286 */         return new ROOM_HUNTER(index, data, key, cat);
/*     */       }
/* 289 */     }).all();
/*     */   
/* 291 */   public final LIST<ROOM_REFINER> REFINERS = (new RoomsCreator<ROOM_REFINER>(this.init, "REFINER", 
/* 292 */       this.CATS.REFINERS)
/*     */     {
/*     */       public ROOM_REFINER create(String key, RoomInitData data, RoomCategorySub cat, int index) throws IOException
/*     */       {
/* 296 */         return new ROOM_REFINER(data, key, index, cat);
/*     */       }
/* 299 */     }).all();
/*     */   
/* 301 */   public final LIST<ROOM_WORKSHOP> WORKSHOPS = (new RoomsCreator<ROOM_WORKSHOP>(this.init, "WORKSHOP", 
/* 302 */       this.CATS.CRAFTING)
/*     */     {
/*     */       public ROOM_WORKSHOP create(String key, RoomInitData data, RoomCategorySub cat, int index) throws IOException
/*     */       {
/* 306 */         return new ROOM_WORKSHOP(index, data, key, cat);
/*     */       }
/* 309 */     }).all();
/*     */ 
/*     */   
/* 312 */   public final LIST<ROOM_SPEAKER> SPEAKERS = (new RoomsCreator<ROOM_SPEAKER>(this.init, "SPEAKER", 
/* 313 */       this.CATS.SER_ENTERTAIN)
/*     */     {
/*     */       public ROOM_SPEAKER create(String key, RoomInitData data, RoomCategorySub cat, int index) throws IOException {
/* 316 */         return new ROOM_SPEAKER(key, index, data, cat);
/*     */       }
/* 319 */     }).all();
/* 320 */   public final LIST<ROOM_STAGE> STAGES = (new RoomsCreator<ROOM_STAGE>(this.init, "STAGE", 
/* 321 */       this.CATS.SER_ENTERTAIN)
/*     */     {
/*     */       public ROOM_STAGE create(String key, RoomInitData data, RoomCategorySub cat, int index) throws IOException {
/* 324 */         return new ROOM_STAGE(key, index, data, cat);
/*     */       }
/* 327 */     }).all();
/* 328 */   public final LIST<ROOM_FIGHTPIT> FIGHTPITS = (new RoomsCreator<ROOM_FIGHTPIT>(this.init, "FIGHTPIT", 
/* 329 */       this.CATS.SER_ENTERTAIN)
/*     */     {
/*     */       public ROOM_FIGHTPIT create(String key, RoomInitData data, RoomCategorySub cat, int index) throws IOException {
/* 332 */         return new ROOM_FIGHTPIT(key, index, data, cat);
/*     */       }
/* 335 */     }).all();
/* 336 */   public final LIST<ROOM_ARENA> GARENAS = (new RoomsCreator<ROOM_ARENA>(this.init, "ARENAG", 
/* 337 */       this.CATS.SER_ENTERTAIN)
/*     */     {
/*     */       public ROOM_ARENA create(String key, RoomInitData data, RoomCategorySub cat, int index) throws IOException {
/* 340 */         return new ROOM_ARENA(key, index, data, cat);
/*     */       }
/* 343 */     }).all();
/* 344 */   public final LIST<ROOM_SPECTATOR.ROOM_SPECTATOR_HASER> ENTERTAINMENT = (new ArrayList(0)).join(this.SPEAKERS).join(this.STAGES).join(this.FIGHTPITS).join(this.GARENAS);
/*     */   
/* 346 */   public final SFinderRoomService graveServiceSpots = new SFinderRoomService("mourn")
/*     */     {
/*     */       public FSERVICE get(int tx, int ty)
/*     */       {
/* 350 */         RoomBlueprint p = (RoomBlueprint)ROOMS.this.map.blueprint.get(tx, ty);
/* 351 */         if (p != null && p instanceof GraveData.GRAVE_DATA_HOLDER)
/* 352 */           return ((GraveData.GRAVE_DATA_HOLDER)p).graveData().burrialService(tx, ty); 
/* 353 */         return null;
/*     */       }
/*     */     };
/* 356 */   public final LIST<ROOM_GRAVEYARD> GRAVEYARDS = (new RoomsCreator<ROOM_GRAVEYARD>(this.init, "GRAVEYARD", 
/* 357 */       this.CATS.SER_DEATH)
/*     */     {
/*     */       
/*     */       public ROOM_GRAVEYARD create(String key, RoomInitData data, RoomCategorySub cat, int index) throws IOException
/*     */       {
/* 362 */         return new ROOM_GRAVEYARD(index, key, data, cat, ROOMS.this.graveServiceSpots);
/*     */       }
/* 365 */     }).all();
/*     */   
/* 367 */   public final LIST<ROOM_TOMB> TOMBS = (new RoomsCreator<ROOM_TOMB>(this.init, "TOMB", 
/* 368 */       this.CATS.SER_DEATH)
/*     */     {
/*     */       public ROOM_TOMB create(String key, RoomInitData data, RoomCategorySub cat, int index) throws IOException
/*     */       {
/* 372 */         return new ROOM_TOMB(index, key, data, cat, ROOMS.this.graveServiceSpots);
/*     */       }
/* 375 */     }).all();
/*     */   
/* 377 */   public final LIST<GraveData.GRAVE_DATA_HOLDER> GRAVES = (new ArrayList(0)).join(this.GRAVEYARDS).join(this.TOMBS);
/*     */   
/* 379 */   public final ROOM_TEMPLES TEMPLES = new ROOM_TEMPLES(this, this.init);
/*     */   
/* 381 */   public final LIST<ROOM_CANTEEN> CANTEENS = (new RoomsCreator<ROOM_CANTEEN>(this.init, "CANTEEN", this.CATS.SER_CONSUMPTION)
/*     */     {
/*     */       public ROOM_CANTEEN create(String key, RoomInitData data, RoomCategorySub cat, int index) throws IOException
/*     */       {
/* 385 */         return new ROOM_CANTEEN(key, index, data, cat);
/*     */       }
/* 388 */     }).all();
/*     */   
/* 390 */   public final LIST<ROOM_EATERY> EATERIES = (new RoomsCreator<ROOM_EATERY>(this.init, "EATERY", this.CATS.SER_CONSUMPTION)
/*     */     {
/*     */       public ROOM_EATERY create(String key, RoomInitData data, RoomCategorySub cat, int index) throws IOException
/*     */       {
/* 394 */         return new ROOM_EATERY(key, index, data, cat);
/*     */       }
/* 397 */     }).all();
/*     */   
/* 399 */   public final LIST<RoomServiceAccess.ROOM_SERVICE_ACCESS_HASER> FOOD = (new ArrayList(0)).join(this.CANTEENS).join(this.EATERIES);
/*     */   
/* 401 */   public final LIST<ROOM_TAVERN> TAVERNS = (new RoomsCreator<ROOM_TAVERN>(this.init, "TAVERN", this.CATS.SER_CONSUMPTION)
/*     */     {
/*     */       public ROOM_TAVERN create(String key, RoomInitData data, RoomCategorySub cat, int index) throws IOException
/*     */       {
/* 405 */         return new ROOM_TAVERN(key, index, data, cat);
/*     */       }
/* 408 */     }).all();
/*     */   
/* 410 */   public final LIST<ROOM_BATH> BATHS = (new RoomsCreator<ROOM_BATH>(this.init, "BATH", this.CATS.SER_HEALTH)
/*     */     {
/*     */       public ROOM_BATH create(String key, RoomInitData data, RoomCategorySub cat, int index) throws IOException
/*     */       {
/* 414 */         return new ROOM_BATH(key, index, data, cat);
/*     */       }
/* 417 */     }).all();
/*     */   
/* 419 */   public final LIST<ROOM_WELL> WELLS = (new RoomsCreator<ROOM_WELL>(this.init, "WELL", this.CATS.SER_HEALTH)
/*     */     {
/*     */       public ROOM_WELL create(String key, RoomInitData data, RoomCategorySub cat, int index) throws IOException
/*     */       {
/* 423 */         return new ROOM_WELL(key, index, data, cat);
/*     */       }
/* 426 */     }).all();
/*     */   
/* 428 */   public final LIST<ROOM_BARBER> BARBERS = (new RoomsCreator<ROOM_BARBER>(this.init, "BARBER", this.CATS.SER_HEALTH)
/*     */     {
/*     */       public ROOM_BARBER create(String key, RoomInitData data, RoomCategorySub cat, int index) throws IOException
/*     */       {
/* 432 */         return new ROOM_BARBER(data, index, key, cat);
/*     */       }
/* 435 */     }).all();
/*     */   
/* 437 */   public final LIST<ROOM_PLEASURE> BROTHELS = (new RoomsCreator<ROOM_PLEASURE>(this.init, "PLEASURE", this.CATS.SER_ENTERTAIN)
/*     */     {
/*     */       public ROOM_PLEASURE create(String key, RoomInitData data, RoomCategorySub cat, int index) throws IOException
/*     */       {
/* 441 */         return new ROOM_PLEASURE(key, index, data, cat);
/*     */       }
/* 444 */     }).all();
/*     */   
/* 446 */   public final LIST<ROOM_MARKET> MARKET = (new RoomsCreator<ROOM_MARKET>(this.init, "MARKET", this.CATS.SER_CONSUMPTION)
/*     */     {
/*     */       public ROOM_MARKET create(String key, RoomInitData data, RoomCategorySub cat, int index) throws IOException
/*     */       {
/* 450 */         return new ROOM_MARKET(key, index, data, cat);
/*     */       }
/* 453 */     }).all();
/*     */   
/* 455 */   public final LIST<ROOM_LAVATORY> LAVATORIES = (new RoomsCreator<ROOM_LAVATORY>(this.init, "LAVATORY", this.CATS.SER_HEALTH)
/*     */     {
/*     */       public ROOM_LAVATORY create(String key, RoomInitData data, RoomCategorySub cat, int index) throws IOException
/*     */       {
/* 459 */         return new ROOM_LAVATORY(data, index, key, cat);
/*     */       }
/* 462 */     }).all();
/*     */   
/* 464 */   public final LIST<ROOM_PHYSICIAN> PHYSICIANS = (new RoomsCreator<ROOM_PHYSICIAN>(this.init, "PHYSICIAN", this.CATS.SER_HEALTH)
/*     */     {
/*     */       public ROOM_PHYSICIAN create(String key, RoomInitData data, RoomCategorySub cat, int index) throws IOException
/*     */       {
/* 468 */         return new ROOM_PHYSICIAN(key, index, data, cat);
/*     */       }
/* 471 */     }).all();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 480 */   public final LIST<ROOM_LABORATORY> LABORATORIES = (new RoomsCreator<ROOM_LABORATORY>(this.init, "LABORATORY", this.CATS.ADMIN)
/*     */     {
/*     */       public ROOM_LABORATORY create(String key, RoomInitData data, RoomCategorySub cat, int index) throws IOException
/*     */       {
/* 484 */         return new ROOM_LABORATORY(key, index, data, cat);
/*     */       }
/* 487 */     }).all();
/*     */   
/* 489 */   public final LIST<ROOM_LIBRARY> LIBRARIES = (new RoomsCreator<ROOM_LIBRARY>(this.init, "LIBRARY", this.CATS.ADMIN)
/*     */     {
/*     */       public ROOM_LIBRARY create(String key, RoomInitData data, RoomCategorySub cat, int index) throws IOException
/*     */       {
/* 493 */         return new ROOM_LIBRARY(key, index, data, cat);
/*     */       }
/* 496 */     }).all();
/*     */   
/* 498 */   public final LIST<ROOM_SCHOOL> SCHOOLS = (new RoomsCreator<ROOM_SCHOOL>(this.init, "SCHOOL", this.CATS.BREEDING)
/*     */     {
/*     */       public ROOM_SCHOOL create(String key, RoomInitData data, RoomCategorySub cat, int index) throws IOException
/*     */       {
/* 502 */         return new ROOM_SCHOOL(key, index, data, cat);
/*     */       }
/* 505 */     }).all();
/* 506 */   public final LIST<ROOM_UNIVERSITY> UNIVERSITIES = (new RoomsCreator<ROOM_UNIVERSITY>(this.init, "UNIVERSITY", this.CATS.ADMIN)
/*     */     {
/*     */       public ROOM_UNIVERSITY create(String key, RoomInitData data, RoomCategorySub cat, int index) throws IOException
/*     */       {
/* 510 */         return new ROOM_UNIVERSITY(key, index, data, cat);
/*     */       }
/* 513 */     }).all();
/* 514 */   public final LIST<ROOM_RESTHOME> RESTHOMES = (new RoomsCreator<ROOM_RESTHOME>(this.init, "RESTHOME", this.CATS.SER_HOME)
/*     */     {
/*     */       public ROOM_RESTHOME create(String key, RoomInitData data, RoomCategorySub cat, int index) throws IOException
/*     */       {
/* 518 */         return new ROOM_RESTHOME(key, index, data, cat);
/*     */       }
/* 521 */     }).all();
/*     */   
/* 523 */   public final LIST<ROOM_ADMIN> ADMINS = (new RoomsCreator<ROOM_ADMIN>(this.init, "ADMIN", this.CATS.ADMIN)
/*     */     {
/*     */       public ROOM_ADMIN create(String key, RoomInitData data, RoomCategorySub cat, int index) throws IOException
/*     */       {
/* 527 */         return new ROOM_ADMIN(key, index, data, cat);
/*     */       }
/* 530 */     }).all();
/*     */   
/* 532 */   public final LIST<ROOM_NURSERY> NURSERIES = (new RoomsCreator<ROOM_NURSERY>(this.init, "NURSERY", this.CATS.BREEDING)
/*     */     {
/*     */       public ROOM_NURSERY create(String key, RoomInitData data, RoomCategorySub cat, int index) throws IOException
/*     */       {
/* 536 */         return new ROOM_NURSERY(index, data, cat, key);
/*     */       }
/* 539 */     }).all();
/*     */   
/* 541 */   public final LIST<ROOM_BREEDER> BREEDERS = (new RoomsCreator<ROOM_BREEDER>(this.init, "BREEDER", this.CATS.BREEDING)
/*     */     {
/*     */       public ROOM_BREEDER create(String key, RoomInitData data, RoomCategorySub cat, int index) throws IOException
/*     */       {
/* 545 */         return new ROOM_BREEDER(index, data, cat, key);
/*     */       }
/* 548 */     }).all();
/*     */ 
/*     */   
/*     */   public final RoomEmployments employment;
/* 552 */   public final int AMOUNT_OF_BLUEPRINTS = RoomBlueprint.ALL.size();
/*     */ 
/*     */   
/*     */   public final BonusExperience exp;
/*     */   
/*     */   static ROOMSLookup lookup;
/*     */   
/*     */   public final RBonus bonus;
/*     */   
/*     */   public final RoomIndustries industries;
/*     */   
/*     */   public final RoomProduction PROD;
/*     */   
/* 565 */   public final RMAPS<RoomBlueprint> collection = new RMAPS("ROOM", (LIST)RoomBlueprint.ALL);
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
/*     */   public TileMap.SMinimapGetter miniC;
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
/*     */   
/*     */   protected void save(FilePutter file) {
/* 605 */     this.pData.save(file);
/* 606 */     this.fData.saver.save(file);
/* 607 */     this.map.saver.save(file);
/* 608 */     this.extraBit.save(file);
/* 609 */     this.updater.save(file);
/* 610 */     this.resourceUnderflow.save(file);
/*     */     
/* 612 */     file.i(RoomBlueprint.ALL.size());
/* 613 */     for (RoomBlueprint p : RoomBlueprint.ALL) {
/* 614 */       file.chars(p.key());
/* 615 */       int pos = file.getPosition();
/* 616 */       file.i(0);
/* 617 */       p.save(file);
/* 618 */       file.setAtPosition(pos, file.getPosition() - pos - 4);
/*     */     } 
/*     */     
/* 621 */     this.employment.saver.save(file);
/* 622 */     this.stats.save(file);
/* 623 */     this.exp.save(file);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void load(FileGetter file) throws IOException {
/* 629 */     this.pData.load(file);
/* 630 */     this.fData.saver.load(file);
/* 631 */     this.map.saver.load(file);
/* 632 */     this.extraBit.load(file);
/* 633 */     this.updater.load(file);
/* 634 */     this.resourceUnderflow.load(file);
/*     */ 
/*     */     
/* 637 */     int am = file.i();
/*     */     
/* 639 */     for (int i = 0; i < am; i++) {
/* 640 */       String key = file.chars();
/* 641 */       int le = file.i();
/* 642 */       int pos = file.getPosition();
/* 643 */       RoomBlueprint p = (RoomBlueprint)this.collection.tryGet(key);
/*     */       
/* 645 */       if (p == null) {
/* 646 */         LOG.ln("skipping " + key);
/* 647 */         file.setPosition(pos + le);
/*     */       } else {
/* 649 */         p.load(file);
/*     */         
/* 651 */         if (file.getPosition() - le != pos) {
/* 652 */           LOG.ln("room save corrupt: " + key);
/* 653 */           file.setPosition(pos + le);
/* 654 */           p.clear();
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 659 */     this.employment.saver.load(file);
/* 660 */     this.stats.load(file);
/* 661 */     this.exp.load(file);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void clearAll() {
/* 668 */     this.pData.clear();
/* 669 */     this.fData.saver.clear();
/* 670 */     this.map.saver.clear();
/* 671 */     this.extraBit.clear();
/* 672 */     this.resourceUnderflow.clear();
/* 673 */     this.employment.saver.clear();
/*     */     
/* 675 */     for (RoomBlueprint p : RoomBlueprint.ALL)
/* 676 */       p.clear(); 
/* 677 */     this.stats.clear();
/* 678 */     this.exp.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(Renderer r, ShadowBatch shadowBatch, RenderData data, int zoom) {
/* 683 */     shadowBatch.setHard();
/* 684 */     RenderData.RenderIterator i = data.onScreenTiles();
/*     */     
/* 686 */     while (i.has()) {
/* 687 */       Room room = this.map.get(i.tx(), i.ty());
/*     */       
/* 689 */       if (room != null)
/*     */       {
/* 691 */         if (room.render(r, shadowBatch, i)) {
/* 692 */           i.hiddenSet();
/*     */         }
/*     */       }
/*     */       
/* 696 */       i.next();
/*     */     } 
/*     */     
/* 699 */     shadowBatch.setSoft();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderAbove(Renderer r, ShadowBatch shadowBatch, RenderData data, int zoom) {
/* 705 */     shadowBatch.setHard();
/* 706 */     RenderData.RenderIterator i = data.onScreenTiles();
/*     */     
/* 708 */     while (i.has()) {
/*     */       
/* 710 */       Room room = this.map.get(i.tile());
/*     */       
/* 712 */       if (room != null)
/*     */       {
/* 714 */         if (room.renderAbove(r, shadowBatch, i)) {
/* 715 */           i.hiddenSet();
/*     */         }
/*     */       }
/*     */       
/* 719 */       i.next();
/*     */     } 
/*     */     
/* 722 */     shadowBatch.setSoft();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderAfterGround(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator it) {
/* 728 */     Room room = this.map.get(it.tile());
/* 729 */     if (room != null)
/*     */     {
/* 731 */       if (room.renderBelow(r, shadowBatch, it)) {
/* 732 */         it.hiddenSet();
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected void update(double ds, Profiler profiler) {
/* 739 */     profiler.logStart(RoomBlueprint.class);
/* 740 */     for (RoomBlueprint b : RoomBlueprint.ALL) {
/* 741 */       profiler.logStart(b.getClass());
/* 742 */       b.update(ds);
/* 743 */       profiler.logEnd(b.getClass());
/*     */     } 
/*     */     
/* 746 */     profiler.logEnd(RoomBlueprint.class);
/* 747 */     profiler.logStart(RoomEmployments.class);
/* 748 */     this.updater.update(ds);
/* 749 */     this.employment.update(ds);
/* 750 */     this.exp.update(ds);
/* 751 */     profiler.logEnd(RoomEmployments.class);
/*     */   }
/*     */   
/*     */   public AVAILABILITY getAvailability(int tx, int ty) {
/* 755 */     int t = tx + ty * SETT.TWIDTH;
/* 756 */     if (this.map.is(t))
/* 757 */       return this.map.get(t).getAvailability(t); 
/* 758 */     return null;
/*     */   }
/*     */   
/* 761 */   public ROOMS() throws IOException { this.miniC = new TileMap.SMinimapGetter()
/*     */       {
/*     */         public COLOR miniColorPimped(ColorImp origional, int tx, int ty, boolean northern, boolean southern)
/*     */         {
/* 765 */           Room r = ROOMS.this.map.getRaw(tx, ty);
/* 766 */           if (r != null)
/* 767 */             return r.blueprint().miniCPimped(origional, tx, ty, northern, southern); 
/* 768 */           return (COLOR)origional;
/*     */         }
/*     */ 
/*     */         
/*     */         public COLOR miniC(int tx, int ty) {
/* 773 */           Room r = ROOMS.this.map.getRaw(tx, ty);
/* 774 */           if (r != null)
/* 775 */             return r.blueprint().miniC(tx, ty); 
/* 776 */           return null; } }; this.industries = new RoomIndustries(this); int am = 0; for (RoomBlueprint b : all()) { if (b instanceof INDUSTRY_HASER) { INDUSTRY_HASER h = (INDUSTRY_HASER)b; am += h.industries().size(); }
/*     */        }
/*     */      ArrayList<Industry> hh = new ArrayList(am); for (RoomBlueprint b : all()) { if (b instanceof INDUSTRY_HASER) { INDUSTRY_HASER h = (INDUSTRY_HASER)b; for (Industry i : h.industries())
/*     */           hh.add(i);  }
/*     */        }
/* 781 */      lookup = new ROOMSLookup(this); this.employment = new RoomEmployments(this); this.exp = new BonusExperience(); this.copy = new ROOM_COPY(this); this.bonus = new RBonus(all()); this.PROD = new RoomProduction(this); this.updater = new Updater((LIST<RoomBlueprintIns<?>>)RoomBlueprintIns.INS); } public LIST<RoomBlueprint> all() { return (LIST<RoomBlueprint>)RoomBlueprint.ALL; }
/*     */ 
/*     */   
/*     */   public LIST<RoomBlueprintImp> imps() {
/* 785 */     return (LIST<RoomBlueprintImp>)RoomBlueprintImp.IMPS;
/*     */   }
/*     */   
/*     */   public LIST<RoomBlueprintIns<?>> ins() {
/* 789 */     return (LIST<RoomBlueprintIns<?>>)RoomBlueprintIns.INS;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void afterTick() {
/* 794 */     this.isolation.update();
/*     */   }
/*     */   
/*     */   public TmpArea tmpArea(Object user) {
/* 798 */     this.tmpArea.init(user);
/* 799 */     return this.tmpArea;
/*     */   }
/*     */   
/*     */   static final class ROOMSLookup
/*     */   {
/* 804 */     final KeyMap<RoomBlueprintImp> look = new KeyMap();
/* 805 */     final KeyMap<LinkedList<RoomBlueprintImp>> cats = new KeyMap();
/*     */ 
/*     */     
/*     */     ROOMSLookup(ROOMS rooms) {
/* 809 */       for (RoomBlueprintImp bi : rooms.imps()) {
/* 810 */         this.look.put(bi.key, bi);
/* 811 */         if (bi.type == null)
/*     */           continue; 
/* 813 */         if (!this.cats.containsKey(bi.type))
/* 814 */           this.cats.put(bi.type, new LinkedList()); 
/* 815 */         ((LinkedList)this.cats.get(bi.type)).add(bi);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static abstract class RoomResource
/*     */   {
/*     */     protected abstract void save(FilePutter param1FilePutter);
/*     */ 
/*     */     
/*     */     protected abstract void load(FileGetter param1FileGetter) throws IOException;
/*     */ 
/*     */     
/*     */     protected abstract void clear();
/*     */ 
/*     */     
/*     */     protected abstract void update(double param1Double);
/*     */   }
/*     */   
/*     */   public static final class RBonus
/*     */   {
/*     */     public final LIST<RoomBlueprintImp> all;
/* 838 */     private final RoomBlueprintImp[] map = new RoomBlueprintImp[BOOSTING.ALL().size()];
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public RoomBlueprintImp get(Boostable bo) {
/* 844 */       if (bo.index() >= this.map.length)
/* 845 */         return null; 
/* 846 */       return this.map[bo.index()];
/*     */     }
/*     */ 
/*     */     
/*     */     RBonus(LIST<RoomBlueprint> rooms) {
/* 851 */       LinkedList<RoomBlueprintImp> all = new LinkedList();
/*     */       
/* 853 */       for (RoomBlueprint p : rooms) {
/* 854 */         if (p instanceof RoomBlueprintImp) {
/* 855 */           RoomBlueprintImp b = (RoomBlueprintImp)p;
/* 856 */           if (b.bonus() != null) {
/* 857 */             this.map[b.bonus().index()] = b;
/* 858 */             all.add(b);
/*     */           } 
/*     */         } 
/*     */       } 
/* 862 */       this.all = (LIST<RoomBlueprintImp>)new ArrayList((Iterable)all);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\ROOMS.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */