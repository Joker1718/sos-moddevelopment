/*     */ package settlement.room.service.hygine.bath;
/*     */ 
/*     */ import game.boosting.Boostable;
/*     */ import java.io.IOException;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.util.FSERVICE;
/*     */ import settlement.path.finders.SFinderFindable;
/*     */ import settlement.path.finders.SFinderRoomService;
/*     */ import settlement.room.industry.module.INDUSTRY_HASER;
/*     */ import settlement.room.industry.module.Industry;
/*     */ import settlement.room.industry.module.IndustryResource;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.category.RoomCategorySub;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.job.ROOM_EMPLOY_AUTO;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import settlement.room.service.module.RoomService;
/*     */ import settlement.room.service.module.RoomServiceAccess;
/*     */ import settlement.room.service.module.RoomServiceNeed;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import view.sett.ui.room.UIRoomModule;
/*     */ 
/*     */ public final class ROOM_BATH
/*     */   extends RoomBlueprintIns<BathInstance>
/*     */   implements RoomServiceNeed.ROOM_SERVICE_NEED_HASER, INDUSTRY_HASER, ROOM_EMPLOY_AUTO
/*     */ {
/*     */   final RoomServiceNeed data;
/*     */   final Constructor constructor;
/*     */   final CharSequence sHeating;
/*     */   final CharSequence sHeatingDesc;
/*     */   
/*     */   public ROOM_BATH(String key, int index, RoomInitData init, RoomCategorySub block) throws IOException {
/*  46 */     super(index, init, key, block);
/*     */     
/*  48 */     this.data = new RoomServiceNeed((RoomBlueprintImp)this, init)
/*     */       {
/*     */         public FSERVICE service(int tx, int ty) {
/*  51 */           return Bath.init(tx, ty, ROOM_BATH.this);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  56 */     this.constructor = new Constructor(this, init);
/*  57 */     this.sHeating = init.text().text("HEATING");
/*  58 */     this.sHeatingDesc = init.text().text("HEATING_DESC");
/*  59 */     this.sHeatingProblem = init.text().text("HEATING_PROBLEM");
/*  60 */     this.sWaterProblem = init.text().text("WATER_PROBLEM");
/*  61 */     this.consumtion = new Industry((RoomBlueprintImp)this, init.data(), null)
/*     */       {
/*     */         public double consumptionRate(RoomInstance ins, Humanoid h, IndustryResource oo) {
/*  64 */           BathInstance i = (BathInstance)ins;
/*  65 */           if (ins.employees().employed() == 0)
/*  66 */             return 0.0D; 
/*  67 */           return oo.rate * i.service.total() / ins.employees().employed();
/*     */         }
/*     */       };
/*     */     
/*  71 */     this.indus = (LIST<Industry>)new ArrayList(this.consumtion);
/*  72 */     employment().countInputSet();
/*     */   }
/*     */   final CharSequence sHeatingProblem; final CharSequence sWaterProblem; final Industry consumtion; final LIST<Industry> indus;
/*     */   
/*     */   public Bath bath(int tx, int ty) {
/*  77 */     return Bath.init(tx, ty, this);
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
/*  88 */     return this.constructor;
/*     */   }
/*     */ 
/*     */   
/*     */   public SFinderRoomService service(int tx, int ty) {
/*  93 */     return this.data.finder;
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomServiceNeed service() {
/*  98 */     return this.data;
/*     */   }
/*     */   
/*     */   public static boolean isPool(int tx, int ty) {
/* 102 */     Room r = (SETT.ROOMS()).map.get(tx, ty);
/* 103 */     if (r != null && r instanceof BathInstance) {
/* 104 */       int d = (SETT.ROOMS()).data.get(tx, ty);
/* 105 */       return ((d & 0xE000) == 57344 && (d & 0x1) == 1);
/*     */     } 
/* 107 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isBench(int tx, int ty) {
/* 111 */     if (is(tx, ty)) {
/* 112 */       int d = (SETT.ROOMS()).data.get(tx, ty);
/* 113 */       return ((d & 0xE000) == 8192);
/*     */     } 
/* 115 */     return false;
/*     */   }
/*     */   
/*     */   public DIR getBenchDir(int tx, int ty) {
/* 119 */     if (!isBench(tx, ty))
/* 120 */       throw new RuntimeException(); 
/* 121 */     for (DIR d : DIR.ORTHO) {
/* 122 */       int da = (SETT.ROOMS()).data.get(tx, ty, d);
/* 123 */       if (da == 84)
/* 124 */         return d; 
/*     */     } 
/* 126 */     throw new RuntimeException();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void saveP(FilePutter file) {
/* 131 */     this.data.saver.save(file);
/* 132 */     this.consumtion.save(file);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void loadP(FileGetter saveFile) throws IOException {
/* 137 */     this.data.saver.load(saveFile);
/* 138 */     this.consumtion.load(saveFile);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clearP() {
/* 143 */     this.data.saver.clear();
/* 144 */     this.consumtion.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public void appendView(LISTE<UIRoomModule> mm) {
/* 149 */     mm.add((new Gui(this)).make());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public LIST<Industry> industries() {
/* 155 */     return this.indus;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean autoEmploy(Room r) {
/* 161 */     return ((BathInstance)r).auto;
/*     */   }
/*     */ 
/*     */   
/*     */   public void autoEmploy(Room r, boolean b) {
/* 166 */     ((BathInstance)r).auto = b;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public double industryFormatConsumptionRate(GText text, IndustryResource i, RoomInstance ins) {
/* 172 */     BathInstance uu = (BathInstance)ins;
/* 173 */     double n = i.rate * uu.service.total();
/* 174 */     GFORMAT.f0(text, -n);
/* 175 */     return n;
/*     */   }
/*     */   
/*     */   public void industryHoverConsumptionRate(GBox b, IndustryResource i, RoomInstance ins) {}
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\hygine\bath\ROOM_BATH.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */