/*     */ package settlement.room.infra.admin;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.finders.SFinderFindable;
/*     */ import settlement.path.finders.SFinderRoomService;
/*     */ import settlement.room.industry.module.IndustryRate;
/*     */ import settlement.room.industry.module.consumption.ConsumptionGui;
/*     */ import settlement.room.industry.module.consumption.ConsumptionJob;
/*     */ import settlement.room.industry.module.consumption.RoomConsumption;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
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
/*     */ public final class ROOM_ADMIN
/*     */   extends RoomBlueprintIns<AdminInstance> implements RoomConsumption.ROOM_CONSUMPTION_HASER, AdminData.ROOM_ADMIN_HOLDER {
/*     */   public static final String type = "ADMIN";
/*     */   public final AdminData data;
/*     */   final ConsumptionJob job;
/*     */   private final RoomConsumption consumption;
/*     */   final Constructor constructor;
/*     */   
/*  33 */   final BOOLEANCoo isJob = new BOOLEANCoo()
/*     */     {
/*     */       public boolean is(int tx, int ty)
/*     */       {
/*  37 */         return (SETT.ROOMS()).fData.tile.is(tx, ty, ROOM_ADMIN.this.constructor.ww);
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*     */   public ROOM_ADMIN(String key, int index, RoomInitData init, RoomCategorySub block) throws IOException {
/*  43 */     super(index, init, key, block);
/*     */ 
/*     */     
/*  46 */     this.constructor = new Constructor(this, init);
/*  47 */     pushBo(init.data(), "ADMIN", true);
/*  48 */     this.consumption = new RoomConsumption((RoomBlueprintImp)this, init.data(), this.bonus);
/*  49 */     this.data = new AdminData(employmentExtra(), init.data(), bonus());
/*     */     
/*  51 */     this.consumption.roomBoosts.add(this.constructor.efficiency);
/*     */ 
/*     */     
/*  54 */     this.job = new ConsumptionJob(this, this.consumption, 45, this.isJob)
/*     */       {
/*     */         protected void perform(double time, double skill)
/*     */         {
/*  58 */           ROOM_ADMIN.this.data.perform(time, skill);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public DIR jobStandDir() {
/*  64 */           for (DIR d : DIR.ORTHO) {
/*  65 */             if (this.ins.is((COORDINATE)this.coo, d) && (SETT.ROOMS()).fData.tileData.get((COORDINATE)this.coo, d) == 3)
/*  66 */               return d; 
/*     */           } 
/*  68 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean jobUseTool() {
/*  73 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean jobUseHands() {
/*  78 */           return false;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  83 */     employment().countInputSet();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void saveP(FilePutter f) {
/*  88 */     this.data.save(f);
/*  89 */     this.consumption.save(f);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void loadP(FileGetter f) throws IOException {
/*  94 */     this.data.load(f);
/*  95 */     this.consumption.load(f);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clearP() {
/* 100 */     this.data.clear();
/* 101 */     this.consumption.clear();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void update(double ds) {
/* 107 */     this.data.update();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public SFinderRoomService service(int tx, int ty) {
/* 113 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Furnisher constructor() {
/* 120 */     return this.constructor;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void appendView(LISTE<UIRoomModule> mm) {
/* 126 */     mm.add((new ConsumptionGui(this, this.consumption)).make());
/* 127 */     mm.add((new AdminData.Gui<>(this, this.data, (IndustryRate)this.consumption)).make());
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomConsumption consumption() {
/* 132 */     return this.consumption;
/*     */   }
/*     */ 
/*     */   
/*     */   public AdminData admin() {
/* 137 */     return this.data;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\admin\ROOM_ADMIN.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */