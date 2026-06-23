/*     */ package settlement.room.food.fish;
/*     */ 
/*     */ import init.type.TERRAINS;
/*     */ import java.io.IOException;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import settlement.path.finders.SFinderFindable;
/*     */ import settlement.path.finders.SFinderRoomService;
/*     */ import settlement.room.industry.module.INDUSTRY_HASER;
/*     */ import settlement.room.industry.module.Industry;
/*     */ import settlement.room.industry.module.IndustryRegion;
/*     */ import settlement.room.industry.module.IndustryResource;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.category.RoomCategorySub;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import view.sett.ui.room.UIRoomModule;
/*     */ import world.map.regions.Region;
/*     */ import world.map.regions.RegionInfo;
/*     */ 
/*     */ public class ROOM_FISHERY
/*     */   extends RoomBlueprintIns<FishInstance> implements INDUSTRY_HASER {
/*     */   public static final String type = "FISHERY";
/*     */   final Job job;
/*     */   final Industry productionData;
/*     */   final Constructor constructor;
/*     */   final LIST<Industry> indus;
/*     */   
/*     */   public ROOM_FISHERY(RoomInitData init, String key, int index, RoomCategorySub cat) throws IOException {
/*  38 */     super(index, init, key, cat);
/*     */ 
/*     */     
/*  41 */     this.constructor = new Constructor(init, this);
/*  42 */     pushBo(init.data(), "FISHERY", true);
/*     */ 
/*     */     
/*  45 */     this.productionData = new Industry(
/*  46 */         (RoomBlueprintImp)this, init.data(), 
/*  47 */         bonus());
/*  48 */     this.productionData.roomBoosts.add(this.constructor.efficiency);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  57 */     this.job = new Job(this);
/*  58 */     this.indus = (LIST<Industry>)new ArrayList(this.productionData);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Furnisher constructor() {
/*  65 */     return this.constructor;
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
/*  78 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void saveP(FilePutter saveFile) {
/*  83 */     this.productionData.save(saveFile);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void loadP(FileGetter saveFile) throws IOException {
/*  88 */     this.productionData.load(saveFile);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clearP() {
/*  93 */     this.productionData.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean makesDudesDirty() {
/*  98 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void appendView(LISTE<UIRoomModule> mm) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public LIST<Industry> industries() {
/* 108 */     return this.indus;
/*     */   }
/*     */ 
/*     */   
/*     */   public void performFishingTrip(Humanoid h, int tx, int ty, double time) {
/* 113 */     if (is(tx, ty)) {
/*     */       
/* 115 */       SETT_JOB s = this.job.init(tx, ty, (FishInstance)get(tx, ty));
/* 116 */       if (s != null)
/* 117 */         this.job.secretPerform(h, time); 
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean launchFishingExpedition(Humanoid h, int tx, int ty) {
/* 122 */     if (is(tx, ty) && 
/* 123 */       Job.isShip.is((SETT.ROOMS()).data.get(tx, ty))) {
/* 124 */       this.job.init(tx, ty, (FishInstance)get(tx, ty)).jobStartPerforming();
/* 125 */       if ((SETT.HALFENTS()).dingy.make(h, tx, ty, ((IndustryResource)((Industry)industries().get(0)).outs().get(0)).resource, ((FishInstance)get(tx, ty)).upgrade(), (DIR)DIR.ALL.get(Job.shipDir.get((SETT.ROOMS()).data.get(tx, ty))))) {
/* 126 */         return true;
/*     */       }
/*     */     } 
/* 129 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\food\fish\ROOM_FISHERY.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */