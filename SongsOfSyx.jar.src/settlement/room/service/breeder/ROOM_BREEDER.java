/*     */ package settlement.room.service.breeder;
/*     */ 
/*     */ import game.VERSION;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.type.HCLASSES;
/*     */ import java.io.IOException;
/*     */ import settlement.path.finders.SFinderFindable;
/*     */ import settlement.path.finders.SFinderRoomService;
/*     */ import settlement.room.industry.module.INDUSTRY_HASER;
/*     */ import settlement.room.industry.module.Industry;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.category.RoomCategorySub;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import settlement.stats.POP;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import view.sett.ui.room.UIRoomModule;
/*     */ 
/*     */ public final class ROOM_BREEDER
/*     */   extends RoomBlueprintIns<BreederInstance> implements INDUSTRY_HASER {
/*  27 */   public final String type = "NURSERY";
/*     */   final BreederConstructor constructor;
/*     */   final Industry productionData;
/*     */   final double PRODUCTION_SPEED_DAY;
/*     */   public final Race race;
/*  32 */   int limitTotal = 40000;
/*  33 */   int limitSpecies = 40000;
/*     */   
/*     */   final LIST<Industry> indus;
/*  36 */   final Station station = new Station(this);
/*     */   boolean prosecute = false;
/*     */   
/*     */   public ROOM_BREEDER(int index, RoomInitData init, RoomCategorySub block, String key) throws IOException {
/*  40 */     super(index, init, key, block);
/*  41 */     this.constructor = new BreederConstructor(this, init);
/*  42 */     pushBo(init.data(), "NURSERY", true);
/*  43 */     this.productionData = new Industry((RoomBlueprintImp)this, init.data(), bonus());
/*     */     
/*  45 */     this.productionData.roomBoosts.add(this.constructor.coziness);
/*     */     
/*  47 */     if (this.productionData.ins().size() == 0) {
/*  48 */       init.data().error("Nurseries must have an in-resource (food)", "INDUSTRY");
/*     */     }
/*  50 */     this.PRODUCTION_SPEED_DAY = 1.0D / init.data().i("INCUBATION_DAYS", 0, 127);
/*  51 */     this.race = (Race)RACES.map().read("RACE", init.data());
/*     */     
/*  53 */     this.indus = (LIST<Industry>)new ArrayList(this.productionData);
/*  54 */     employment().countInputSet();
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
/*  65 */     return this.constructor;
/*     */   }
/*     */ 
/*     */   
/*     */   public SFinderRoomService service(int tx, int ty) {
/*  70 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void saveP(FilePutter saveFile) {
/*  75 */     this.productionData.save(saveFile);
/*  76 */     saveFile.i(this.limitTotal);
/*  77 */     saveFile.i(this.limitSpecies);
/*  78 */     saveFile.bool(this.prosecute);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void loadP(FileGetter saveFile) throws IOException {
/*  83 */     this.productionData.load(saveFile);
/*  84 */     this.limitTotal = saveFile.i();
/*  85 */     this.limitSpecies = saveFile.i();
/*  86 */     if (!VERSION.versionIsBefore(71, 15)) {
/*  87 */       this.prosecute = saveFile.bool();
/*     */     }
/*     */   }
/*     */   
/*     */   protected void clearP() {
/*  92 */     this.productionData.clear();
/*  93 */     this.limitTotal = 40000;
/*  94 */     this.limitSpecies = 40000;
/*  95 */     this.prosecute = false;
/*     */   }
/*     */   
/*     */   public boolean canWork() {
/*  99 */     return (POP.next(HCLASSES.CITIZEN(), this.race) < this.limitSpecies && POP.next(null, null) < this.limitTotal);
/*     */   }
/*     */ 
/*     */   
/*     */   public void appendView(LISTE<UIRoomModule> mm) {
/* 104 */     mm.add((new Gui(this)).make());
/*     */   }
/*     */ 
/*     */   
/*     */   public LIST<Industry> industries() {
/* 109 */     return this.indus;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\breeder\ROOM_BREEDER.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */