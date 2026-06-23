/*     */ package settlement.room.food.orchard;
/*     */ 
/*     */ import game.boosting.Boostable;
/*     */ import game.time.TIME;
/*     */ import game.time.TIMECYCLE;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import init.resources.RES_AMOUNT;
/*     */ import init.type.TERRAINS;
/*     */ import java.io.IOException;
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
/*     */ import snake2d.util.MATH;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import view.sett.ui.room.UIRoomModule;
/*     */ import world.map.regions.Region;
/*     */ import world.map.regions.RegionInfo;
/*     */ 
/*     */ public class ROOM_ORCHARD extends RoomBlueprintIns<Instance> implements INDUSTRY_HASER, RoomIrrigated.ROOM_IRRIGATED {
/*  39 */   static final double TILES_PER_WORKER = TIME.workSeconds() / (45.0D + TIME.workSecondsWalkNext());
/*     */   
/*     */   public static final String type = "ORCHARD";
/*     */   final Constructor constructor;
/*     */   final Industry productionData;
/*     */   final LIST<Industry> indus;
/*     */   final OTile tile;
/*     */   public final RES_AMOUNT auxRes;
/*  47 */   private byte year = -1;
/*     */   public final Time time;
/*  49 */   public final double AmountPerTile = TIME.years().bitConversion((TIMECYCLE)TIME.days()) / TILES_PER_WORKER;
/*     */   
/*     */   public ROOM_ORCHARD(RoomInitData data, String key, RoomCategorySub cat, int index) throws IOException {
/*  52 */     super(index, data, key, cat);
/*     */     
/*  54 */     this.constructor = new Constructor(this, data);
/*  55 */     pushBo(data.data(), "ORCHARD", true);
/*     */     
/*  57 */     RoomBoost mo = WeatherMoisture.makeBoost();
/*     */     
/*  59 */     this.productionData = new Industry((RoomBlueprintImp)this, data.data(), bonus());
/*  60 */     this.productionData.roomBoosts.add(this.constructor.fertility);
/*  61 */     this.productionData.roomBoosts.add(mo);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  70 */     this.indus = (LIST<Industry>)new ArrayList(this.productionData);
/*  71 */     this.time = new Time(data);
/*  72 */     this.auxRes = (RES_AMOUNT)new RES_AMOUNT.Abs((RESOURCE)RESOURCES.map().read("EXTRA_RESOURCE", data.data()), data.data().i("EXTRA_RESOURCE_AMOUNT"));
/*  73 */     this.tile = new OTile(this);
/*     */ 
/*     */     
/*  76 */     double ibonus = 1.0D;
/*     */     
/*  78 */     double period = TIME.years().bitConversion((TIMECYCLE)TIME.days()) - 1.0D;
/*  79 */     double degrade = 1.0D - ((IndustryResource)this.productionData.outs().get(0)).resource.degradeSpeed() / 2.0D * period;
/*  80 */     double consumption = 1.0D;
/*     */     
/*  82 */     double res = 0.0D;
/*     */     
/*  84 */     for (int i = 0; i < period; i++) {
/*  85 */       res += consumption;
/*  86 */       res /= degrade;
/*     */     } 
/*     */     
/*  89 */     ibonus = res / period * consumption;
/*  90 */     ibonus = (int)(ibonus * 100.0D) / 100.0D;
/*  91 */     ibonus += 0.025D;
/*     */ 
/*     */     
/*  94 */     this.irri = new RoomIrrigated(this, this.bonus, 0.75D, ibonus)
/*     */       {
/*     */         public double needed(AREA area)
/*     */         {
/*  98 */           return area.area();
/*     */         }
/*     */ 
/*     */         
/*     */         protected double irrigation(RoomInstance ins) {
/* 103 */           return ((Instance)ins).irri;
/*     */         }
/*     */       };
/*     */   }
/*     */   private final RoomIrrigated irri;
/*     */   
/*     */   OTile tile(int tx, int ty) {
/* 110 */     return this.tile.get(tx, ty);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void update(double ds) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public Furnisher constructor() {
/* 121 */     return this.constructor;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public SFinderRoomService service(int tx, int ty) {
/* 127 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void saveP(FilePutter saveFile) {
/* 132 */     this.productionData.save(saveFile);
/* 133 */     saveFile.b(this.year);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void loadP(FileGetter saveFile) throws IOException {
/* 138 */     this.productionData.load(saveFile);
/* 139 */     this.year = saveFile.b();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clearP() {
/* 144 */     this.productionData.clear();
/* 145 */     this.year = -1;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean degrades() {
/* 150 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void appendView(LISTE<UIRoomModule> mm) {
/* 155 */     mm.add((new Gui(this)).make());
/*     */   }
/*     */ 
/*     */   
/*     */   public LIST<Industry> industries() {
/* 160 */     return this.indus;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean industryIgnoreUI() {
/* 165 */     return true;
/*     */   }
/*     */   
/*     */   public boolean event(int tx, int ty, double severity) {
/* 169 */     Instance ins = (Instance)this.getter.get(tx, ty);
/* 170 */     if (ins != null) {
/* 171 */       return ins.event();
/*     */     }
/* 173 */     return false;
/*     */   }
/*     */   
/*     */   public static class Time {
/*     */     public final int DAYS_TILL_GROWTH;
/*     */     public final int ripeDay;
/*     */     public final int deadDay;
/* 180 */     public final int days = (int)TIME.years().bitConversion((TIMECYCLE)TIME.days());
/*     */     
/*     */     Time(RoomInitData data) {
/* 183 */       this.DAYS_TILL_GROWTH = data.data().i("DAYS_TILL_GROWTH", 8, 1024);
/* 184 */       this.ripeDay = (int)(this.days * data.data().d("RIPE_AT_PART_OF_YEAR", 0.0D, 1.0D));
/* 185 */       this.deadDay = MATH.mod(this.ripeDay + 3, this.days);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isRipe() {
/* 191 */       return isRipe(dayI());
/*     */     }
/*     */     
/*     */     public boolean isRipe(double day) {
/* 195 */       return MATH.isWithin(day, this.ripeDay, this.deadDay);
/*     */     }
/*     */     
/*     */     public boolean isDeadDay() {
/* 199 */       return (dayI() == this.deadDay);
/*     */     }
/*     */     
/*     */     public double fruit() {
/* 203 */       return fruit(day());
/*     */     }
/*     */ 
/*     */     
/*     */     private double fruit(double day) {
/* 208 */       double rd = (this.ripeDay + this.days - 2);
/* 209 */       double dd = (this.deadDay + this.days - 1);
/* 210 */       if (this.deadDay < this.ripeDay) {
/* 211 */         dd += TIME.years().bitConversion((TIMECYCLE)TIME.days());
/*     */       }
/*     */       
/* 214 */       double di = day + this.days;
/*     */       
/* 216 */       if (di > rd) {
/* 217 */         if (di < dd)
/* 218 */           return CLAMP.d(0.5D * (di - rd), 0.0D, 1.0D); 
/* 219 */         if (di > dd)
/* 220 */           return CLAMP.d(1.0D - di - dd, 0.0D, 1.0D); 
/* 221 */         return 1.0D;
/*     */       } 
/* 223 */       return 0.0D;
/*     */     }
/*     */     
/*     */     public double day() {
/* 227 */       return TIME.years().bitPartOf() * TIME.years().bitConversion((TIMECYCLE)TIME.days());
/*     */     }
/*     */     
/*     */     public int dayI() {
/* 231 */       return (int)day();
/*     */     }
/*     */     
/*     */     public int daysTillHarvest() {
/* 235 */       return MATH.distance(dayI(), this.ripeDay, this.days);
/*     */     }
/*     */     
/*     */     public int daysTillHarvest(int nextTreeDays) {
/* 239 */       int day = TIME.days().bitCurrent();
/* 240 */       day += nextTreeDays;
/* 241 */       int dy = (int)TIME.years().bitConversion((TIMECYCLE)TIME.days());
/* 242 */       int dday = day % dy;
/* 243 */       return day + MATH.distance(dday, this.ripeDay, this.days);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public RoomIrrigated irrigation() {
/* 250 */     return this.irri;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\food\orchard\ROOM_ORCHARD.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */