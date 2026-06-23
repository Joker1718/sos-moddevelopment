/*     */ package settlement.room.knowledge.library;
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
/*     */ public final class ROOM_LIBRARY
/*     */   extends RoomBlueprintIns<LibraryInstance>
/*     */   implements AdminData.ROOM_ADMIN_HOLDER, RoomConsumption.ROOM_CONSUMPTION_HASER {
/*     */   public static final String type = "LIBRARY";
/*     */   public final AdminData data;
/*     */   private final RoomConsumption consumption;
/*     */   final ConsumptionJob job;
/*     */   final Constructor constructor;
/*     */   
/*  34 */   final BOOLEANCoo isJob = new BOOLEANCoo()
/*     */     {
/*     */       public boolean is(int tx, int ty)
/*     */       {
/*  38 */         return (SETT.ROOMS()).fData.tile.is(tx, ty, ROOM_LIBRARY.this.constructor.ww);
/*     */       }
/*     */     };
/*     */   
/*     */   public ROOM_LIBRARY(String key, int index, RoomInitData init, RoomCategorySub block) throws IOException {
/*  43 */     super(index, init, key, block);
/*     */     
/*  45 */     pushBo(init.data(), "LIBRARY", true);
/*  46 */     this.consumption = new RoomConsumption((RoomBlueprintImp)this, init.data(), this.bonus);
/*     */ 
/*     */     
/*  49 */     this.data = new AdminData(employmentExtra(), init.data(), bonus());
/*  50 */     this.job = new ConsumptionJob(this, this.consumption, 45, this.isJob)
/*     */       {
/*     */         protected void perform(double time, double skill)
/*     */         {
/*  54 */           ROOM_LIBRARY.this.data.perform(time, skill);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public DIR jobStandDir() {
/*  60 */           for (DIR d : DIR.ORTHO) {
/*  61 */             if ((SETT.ROOMS()).fData.sprite.get((COORDINATE)this.coo, d) == ROOM_LIBRARY.this.constructor.sStool)
/*  62 */               return d; 
/*     */           } 
/*  64 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean jobUseTool() {
/*  69 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean jobUseHands() {
/*  74 */           return false;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  79 */     this.constructor = new Constructor(this, init);
/*  80 */     this.consumption.roomBoosts.add(this.constructor.efficiency);
/*     */     
/*  82 */     employment().countInputSet();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void update(double ds) {
/*  87 */     this.data.update();
/*     */   }
/*     */ 
/*     */   
/*     */   public SFinderRoomService service(int tx, int ty) {
/*  92 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void saveP(FilePutter saveFile) {
/*  97 */     this.data.save(saveFile);
/*  98 */     this.consumption.save(saveFile);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void loadP(FileGetter saveFile) throws IOException {
/* 103 */     this.data.load(saveFile);
/* 104 */     this.consumption.load(saveFile);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void clearP() {
/* 110 */     this.data.clear();
/* 111 */     this.consumption.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public Furnisher constructor() {
/* 116 */     return this.constructor;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void appendView(LISTE<UIRoomModule> mm) {
/* 124 */     mm.add((new ConsumptionGui(this, this.consumption)).make());
/* 125 */     mm.add((new AdminData.Gui(this, this.data, (IndustryRate)this.consumption)).make());
/*     */   }
/*     */ 
/*     */   
/*     */   public AdminData admin() {
/* 130 */     return this.data;
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomConsumption consumption() {
/* 135 */     return this.consumption;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\knowledge\library\ROOM_LIBRARY.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */