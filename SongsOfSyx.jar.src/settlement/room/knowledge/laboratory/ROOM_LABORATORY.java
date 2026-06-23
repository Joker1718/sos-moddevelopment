/*     */ package settlement.room.knowledge.laboratory;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.finders.SFinderFindable;
/*     */ import settlement.path.finders.SFinderRoomService;
/*     */ import settlement.room.industry.module.IndustryRate;
/*     */ import settlement.room.industry.module.consumption.ConsumptionGui;
/*     */ import settlement.room.industry.module.consumption.ConsumptionJob;
/*     */ import settlement.room.industry.module.consumption.RoomConsumption;
/*     */ import settlement.room.infra.admin.AdminData;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.category.RoomCategorySub;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import util.data.BOOLEANCoo;
/*     */ import view.sett.ui.room.UIRoomModule;
/*     */ 
/*     */ public final class ROOM_LABORATORY extends RoomBlueprintIns<LaboratoryInstance> implements AdminData.ROOM_ADMIN_HOLDER, RoomConsumption.ROOM_CONSUMPTION_HASER {
/*     */   public static final String type = "LABORATORY";
/*     */   public final AdminData data;
/*     */   private final RoomConsumption consumption;
/*     */   final ConsumptionJob job;
/*     */   final Constructor constructor;
/*     */   
/*  32 */   final BOOLEANCoo isJob = new BOOLEANCoo()
/*     */     {
/*     */       public boolean is(int tx, int ty)
/*     */       {
/*  36 */         return ((SETT.ROOMS()).fData.tileData.get(tx, ty) == 1);
/*     */       }
/*     */     };
/*     */   public ROOM_LABORATORY(String key, int index, RoomInitData init, RoomCategorySub block) throws IOException {
/*  40 */     super(index, init, key, block);
/*     */     
/*  42 */     pushBo(init.data(), "LABORATORY", true);
/*  43 */     this.consumption = new RoomConsumption((RoomBlueprintImp)this, init.data(), this.bonus);
/*     */     
/*  45 */     this.data = new AdminData(employmentExtra(), init.data(), bonus());
/*  46 */     this.job = new ConsumptionJob(this, this.consumption, 45, this.isJob)
/*     */       {
/*     */         protected void perform(double time, double skill)
/*     */         {
/*  50 */           ROOM_LABORATORY.this.data.perform(time, skill);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public DIR jobStandDir() {
/*  56 */           for (int di = 0; di < DIR.ORTHO.size(); di++) {
/*  57 */             if (this.ins.is((COORDINATE)this.coo, (DIR)DIR.ORTHO.get(di)) && (SETT.ROOMS()).fData.sprite.is((COORDINATE)this.coo, (DIR)DIR.ORTHO.get(di), ROOM_LABORATORY.this.constructor.schair))
/*  58 */               return (DIR)DIR.ORTHO.get(di); 
/*     */           } 
/*  60 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean jobUseTool() {
/*  65 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean jobUseHands() {
/*  70 */           return false;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  75 */     this.constructor = new Constructor(this, init);
/*     */ 
/*     */     
/*  78 */     employment().countInputSet();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void update(double ds) {
/*  84 */     this.data.update();
/*     */   }
/*     */ 
/*     */   
/*     */   public SFinderRoomService service(int tx, int ty) {
/*  89 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void saveP(FilePutter saveFile) {
/*  94 */     this.data.save(saveFile);
/*  95 */     this.consumption.save(saveFile);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void loadP(FileGetter saveFile) throws IOException {
/* 100 */     this.data.load(saveFile);
/* 101 */     this.consumption.load(saveFile);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clearP() {
/* 106 */     this.data.clear();
/* 107 */     this.consumption.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public Furnisher constructor() {
/* 112 */     return this.constructor;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void appendView(LISTE<UIRoomModule> mm) {
/* 118 */     mm.add((new ConsumptionGui(this, this.consumption)).make());
/* 119 */     mm.add((new AdminData.Gui(this, this.data, (IndustryRate)this.consumption)).make());
/*     */   }
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
/*     */   public AdminData admin() {
/* 134 */     return this.data;
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomConsumption consumption() {
/* 139 */     return this.consumption;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\knowledge\laboratory\ROOM_LABORATORY.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */