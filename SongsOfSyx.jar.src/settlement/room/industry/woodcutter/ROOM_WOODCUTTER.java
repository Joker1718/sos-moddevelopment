/*     */ package settlement.room.industry.woodcutter;
/*     */ 
/*     */ import game.boosting.Boostable;
/*     */ import init.type.TERRAINS;
/*     */ import java.io.IOException;
/*     */ import settlement.path.finders.SFinderFindable;
/*     */ import settlement.path.finders.SFinderRoomService;
/*     */ import settlement.room.industry.module.INDUSTRY_HASER;
/*     */ import settlement.room.industry.module.Industry;
/*     */ import settlement.room.industry.module.IndustryRegion;
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
/*     */ 
/*     */ public class ROOM_WOODCUTTER
/*     */   extends RoomBlueprintIns<Instance> implements INDUSTRY_HASER, RoomIrrigated.ROOM_IRRIGATED {
/*     */   final Job job;
/*     */   final Industry productionData;
/*     */   final Constructor constructor;
/*     */   final LIST<Industry> indus;
/*     */   final RoomIrrigated irrigation;
/*     */   
/*     */   public ROOM_WOODCUTTER(RoomInitData init, RoomCategorySub cat) throws IOException {
/*  37 */     super(0, init, "_WOODCUTTER", cat);
/*     */ 
/*     */     
/*  40 */     this.constructor = new Constructor(init, this);
/*  41 */     pushBo(init.data(), null, true);
/*     */ 
/*     */     
/*  44 */     this.productionData = new Industry((RoomBlueprintImp)this, init.data(), bonus());
/*  45 */     this.productionData.roomBoosts.add(this.constructor.efficiency);
/*     */     
/*  47 */     this.productionData.roomBoosts.add(WeatherMoisture.makeBoost());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  56 */     this.job = new Job(this, init.data().i("STORAGE", 8, 500));
/*  57 */     this.indus = (LIST<Industry>)new ArrayList(this.productionData);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  62 */     this.irrigation = new RoomIrrigated(this, this.bonus, 0.75D, 1.05D)
/*     */       {
/*     */         public double needed(AREA area)
/*     */         {
/*  66 */           return area.area();
/*     */         }
/*     */ 
/*     */         
/*     */         protected double irrigation(RoomInstance ins) {
/*  71 */           return ((Instance)ins).irri;
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Furnisher constructor() {
/*  79 */     return this.constructor;
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
/*     */   public SFinderRoomService service(int tx, int ty) {
/*  92 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void saveP(FilePutter saveFile) {
/*  97 */     this.productionData.save(saveFile);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void loadP(FileGetter saveFile) throws IOException {
/* 102 */     this.productionData.load(saveFile);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clearP() {
/* 107 */     this.productionData.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean makesDudesDirty() {
/* 112 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void appendView(LISTE<UIRoomModule> mm) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public LIST<Industry> industries() {
/* 122 */     return this.indus;
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomIrrigated irrigation() {
/* 127 */     return this.irrigation;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\industry\woodcutter\ROOM_WOODCUTTER.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */