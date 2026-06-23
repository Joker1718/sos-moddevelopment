/*     */ package settlement.room.infra.embassy;
/*     */ 
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BSourceInfo;
/*     */ import game.boosting.BoosterImp;
/*     */ import game.faction.player.Player;
/*     */ import init.type.HCLASS_RACE;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.finders.SFinderFindable;
/*     */ import settlement.path.finders.SFinderRoomService;
/*     */ import settlement.room.industry.module.IndustryRate;
/*     */ import settlement.room.industry.module.IndustryResource;
/*     */ import settlement.room.industry.module.consumption.ConsumptionGui;
/*     */ import settlement.room.industry.module.consumption.ConsumptionJob;
/*     */ import settlement.room.industry.module.consumption.RoomConsumption;
/*     */ import settlement.room.infra.admin.AdminData;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.category.RoomCategorySub;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import util.data.BOOLEANCoo;
/*     */ import util.text.D;
/*     */ import view.sett.ui.room.UIRoomModule;
/*     */ 
/*     */ public final class ROOM_EMBASSY
/*     */   extends RoomBlueprintIns<EmbassyInstance> implements AdminData.ROOM_ADMIN_HOLDER, RoomConsumption.ROOM_CONSUMPTION_HASER {
/*     */   final ConsumptionJob job;
/*     */   final Constructor constructor;
/*     */   private final RoomConsumption consumption;
/*     */   final AdminData data;
/*     */   
/*  38 */   final BOOLEANCoo isJob = new BOOLEANCoo()
/*     */     {
/*     */       public boolean is(int tx, int ty)
/*     */       {
/*  42 */         return ((SETT.ROOMS()).fData.tileData.get(tx, ty) == 3);
/*     */       }
/*     */     };
/*     */   
/*     */   public ROOM_EMBASSY(RoomInitData init, RoomCategorySub block) throws IOException {
/*  47 */     super(0, init, "_EMBASSY", block);
/*     */ 
/*     */     
/*  50 */     pushBo(init.data(), this.type, true);
/*  51 */     this.constructor = new Constructor(this, init);
/*     */ 
/*     */     
/*  54 */     this.consumption = new RoomConsumption((RoomBlueprintImp)this, init.data(), this.bonus);
/*  55 */     this.consumption.roomBoosts.add(this.constructor.efficiency);
/*     */     
/*  57 */     this.job = new ConsumptionJob(this, this.consumption, 45, this.isJob)
/*     */       {
/*     */         protected void perform(double time, double skill)
/*     */         {
/*  61 */           ROOM_EMBASSY.this.data.perform(time, skill);
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean jobUseTool() {
/*  68 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean jobUseHands() {
/*  73 */           return RND.rBoolean();
/*     */         }
/*     */       };
/*     */     
/*  77 */     this.data = new AdminData(employmentExtra(), init.data(), bonus());
/*     */     
/*  79 */     double max = 1.0E7D;
/*  80 */     double maxI = 1.0E-7D;
/*  81 */     (new BoosterImp(new BSourceInfo(this.info.names, (iconBig()).small), 0.0D, 1.0E7D, false)
/*     */       {
/*     */         public double vGet(Player f)
/*     */         {
/*  85 */           return ROOM_EMBASSY.this.data.value() * 1.0E-7D;
/*     */         }
/*     */ 
/*     */         
/*     */         public double vGet(HCLASS_RACE reg) {
/*  90 */           return ROOM_EMBASSY.this.data.value() * 1.0E-7D;
/*     */         }
/*  94 */       }).add((BOOSTABLES.CIVICS()).DIPLOMACY);
/*     */     
/*  96 */     employment().countInputSet();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void update(double ds) {
/* 101 */     this.data.update();
/*     */   }
/*     */ 
/*     */   
/*     */   public SFinderRoomService service(int tx, int ty) {
/* 106 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void saveP(FilePutter saveFile) {
/* 111 */     this.data.save(saveFile);
/* 112 */     this.consumption.save(saveFile);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void loadP(FileGetter saveFile) throws IOException {
/* 117 */     this.data.load(saveFile);
/* 118 */     this.consumption.load(saveFile);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void clearP() {
/* 124 */     this.data.clear();
/* 125 */     this.consumption.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public Furnisher constructor() {
/* 130 */     return this.constructor;
/*     */   }
/*     */   
/* 133 */   static CharSequence ¤¤target = "¤The estimated amount of diplomacy points that will be produced.";
/*     */   
/*     */   static {
/* 136 */     D.ts(ROOM_EMBASSY.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public void appendView(LISTE<UIRoomModule> mm) {
/* 141 */     mm.add((new ConsumptionGui(this, this.consumption)).make());
/* 142 */     mm.add((new AdminData.Gui(this, this.data, (IndustryRate)this.consumption, (BOOSTABLES.CIVICS()).DIPLOMACY.name, ¤¤target)).make());
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
/*     */   int maxRes(int ri, EmbassyInstance ins) {
/* 206 */     return (int)(4.0D * Math.ceil(((IndustryResource)this.consumption.ins().get(ri)).rate * ins.jobs.size()));
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RoomConsumption consumption() {
/* 228 */     return this.consumption;
/*     */   }
/*     */ 
/*     */   
/*     */   public AdminData admin() {
/* 233 */     return this.data;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\embassy\ROOM_EMBASSY.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */