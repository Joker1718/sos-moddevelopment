/*     */ package settlement.room.food.farm;
/*     */ import game.boosting.Boostable;
/*     */ import game.time.TIME;
/*     */ import game.time.TIMECYCLE;
/*     */ import init.resources.Growable;
/*     */ import init.resources.RESOURCES;
/*     */ import init.type.TERRAINS;
/*     */ import java.io.IOException;
/*     */ import settlement.misc.util.RESOURCE_TILE;
/*     */ import settlement.misc.util.TILE_STORAGE;
/*     */ import settlement.path.finders.SFinderFindable;
/*     */ import settlement.path.finders.SFinderRoomService;
/*     */ import settlement.room.industry.module.INDUSTRY_HASER;
/*     */ import settlement.room.industry.module.Industry;
/*     */ import settlement.room.industry.module.IndustryRegion;
/*     */ import settlement.room.industry.module.IndustryResource;
/*     */ import settlement.room.industry.module.RoomBoost;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.category.RoomCategorySub;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import settlement.room.water.RoomIrrigated;
/*     */ import settlement.weather.WeatherMoisture;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import view.sett.ui.room.UIRoomModule;
/*     */ import world.map.regions.Region;
/*     */ import world.map.regions.RegionInfo;
/*     */ 
/*     */ public class ROOM_FARM extends RoomBlueprintIns<FarmInstance> implements INDUSTRY_HASER, RoomIrrigated.ROOM_IRRIGATED {
/*  37 */   static double WORKERPERTILE = TIME.workSeconds() / (4.0D + TIME.workSecondsWalkNext());
/*  38 */   static double WORKERPERTILEI = 1.0D / WORKERPERTILE;
/*     */   
/*     */   public final Growable crop;
/*     */   
/*     */   public static final String type = "FARM";
/*     */   
/*     */   final Constructor constructor;
/*     */   
/*     */   final Industry productionData;
/*     */   
/*     */   final LIST<Industry> indus;
/*     */   
/*     */   final Tile tile;
/*     */   
/*     */   final Time time;
/*  53 */   final double yearMul = TIME.years().bitSeconds() / (16 * TIME.secondsPerDay());
/*     */   private final RoomIrrigated irri;
/*     */   
/*     */   public ROOM_FARM(RoomInitData data, String key, RoomCategorySub cat, int index) throws IOException {
/*  57 */     super(index, data, key, cat);
/*  58 */     this.crop = (Growable)(RESOURCES.growable()).MAP.read(data.data());
/*     */     
/*  60 */     this.constructor = new Constructor(this, data);
/*  61 */     pushBo(data.data(), "FARM", true);
/*     */     
/*  63 */     RoomBoost mo = WeatherMoisture.makeBoost();
/*     */     
/*  65 */     this.productionData = new Industry((RoomBlueprintImp)this, data.data(), bonus());
/*  66 */     this.productionData.roomBoosts.add(this.constructor.fertility);
/*  67 */     this.productionData.roomBoosts.add(mo);
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
/*  78 */     this.indus = (LIST<Industry>)new ArrayList(this.productionData);
/*     */ 
/*     */     
/*  81 */     this.time = new Time(this);
/*  82 */     this.tile = new Tile(this);
/*     */ 
/*     */     
/*  85 */     double ibonus = 1.0D;
/*     */     
/*  87 */     double period = TIME.years().bitConversion((TIMECYCLE)TIME.days()) - 1.0D;
/*  88 */     double degrade = 1.0D - ((IndustryResource)this.productionData.outs().get(0)).resource.degradeSpeed() / 2.0D * period;
/*  89 */     double consumption = 1.0D;
/*     */     
/*  91 */     double res = 0.0D;
/*     */     
/*  93 */     for (int i = 0; i < period; i++) {
/*  94 */       res += consumption;
/*  95 */       res /= degrade;
/*     */     } 
/*     */     
/*  98 */     ibonus = res / period * consumption;
/*  99 */     ibonus = (int)(ibonus * 100.0D) / 100.0D;
/* 100 */     ibonus += 0.05D;
/*     */ 
/*     */ 
/*     */     
/* 104 */     this.irri = new RoomIrrigated(this, bonus(), 0.05D, ibonus)
/*     */       {
/*     */         public double needed(AREA area)
/*     */         {
/* 108 */           return area.area();
/*     */         }
/*     */ 
/*     */         
/*     */         protected double irrigation(RoomInstance ins) {
/* 113 */           return ((FarmInstance)ins).irri;
/*     */         }
/*     */       };
/*     */     
/* 117 */     this.degradeRate = 0.0D;
/*     */   }
/*     */   
/*     */   Tile tile(int tx, int ty) {
/* 121 */     return this.tile.get(tx, ty);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void update(double ds) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Furnisher constructor() {
/* 135 */     return this.constructor;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public SFinderRoomService service(int tx, int ty) {
/* 141 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void saveP(FilePutter saveFile) {
/* 146 */     this.productionData.save(saveFile);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void loadP(FileGetter saveFile) throws IOException {
/* 151 */     this.productionData.load(saveFile);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clearP() {
/* 156 */     this.productionData.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean degrades() {
/* 161 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void appendView(LISTE<UIRoomModule> mm) {
/* 166 */     mm.add((new Gui(this)).make());
/*     */   }
/*     */ 
/*     */   
/*     */   public LIST<Industry> industries() {
/* 171 */     return this.indus;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isGoodDayForEvent() {
/* 177 */     return (this.time.dayI() == this.time.dayEvent);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean industryIgnoreUI() {
/* 182 */     return true;
/*     */   }
/*     */   
/*     */   public boolean shouldReportWorkFailure() {
/* 186 */     return (this.time.dayI() != this.time.dayOffWork && this.time.dayI() != this.time.dayHarvest);
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomIrrigated irrigation() {
/* 191 */     return this.irri;
/*     */   }
/*     */   
/*     */   public double fer() {
/* 195 */     return getStat(this.constructor.fertility.index());
/*     */   }
/*     */   
/*     */   public RESOURCE_TILE toStore(int tx, int ty) {
/* 199 */     FarmInstance ins = (FarmInstance)get(tx, ty);
/* 200 */     if (ins == null) {
/* 201 */       return null;
/*     */     }
/* 203 */     return ins.getResTile();
/*     */   }
/*     */   
/*     */   public TILE_STORAGE toStoreTo(int tx, int ty) {
/* 207 */     FarmInstance ins = (FarmInstance)get(tx, ty);
/* 208 */     if (ins == null)
/* 209 */       return null; 
/* 210 */     return ins.getStoreTile();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\food\farm\ROOM_FARM.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */