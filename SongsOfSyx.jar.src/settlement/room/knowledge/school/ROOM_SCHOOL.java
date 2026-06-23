/*     */ package settlement.room.knowledge.school;
/*     */ import game.boosting.Boostable;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.NEED;
/*     */ import java.io.IOException;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.misc.util.FSERVICE;
/*     */ import settlement.path.finders.SFinderFindable;
/*     */ import settlement.path.finders.SFinderRoomService;
/*     */ import settlement.room.industry.module.INDUSTRY_HASER;
/*     */ import settlement.room.industry.module.Industry;
/*     */ import settlement.room.industry.module.IndustryResource;
/*     */ import settlement.room.industry.module.RoomBoost;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.category.RoomCategorySub;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import settlement.room.service.module.RoomService;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.colls.StatsEducation;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import view.sett.ui.room.UIRoomModule;
/*     */ 
/*     */ public final class ROOM_SCHOOL extends RoomBlueprintIns<SchoolInstance> implements INDUSTRY_HASER, RoomService.ROOM_SERVICE_HASER {
/*  36 */   final SchoolStation station = new SchoolStation(this); final Industry industry; final SchoolConstructor constructor;
/*     */   final RoomService service;
/*     */   final LIST<Industry> indus;
/*     */   private final RoomEducationHelper helper;
/*     */   
/*     */   public ROOM_SCHOOL(String key, int index, RoomInitData init, RoomCategorySub block) throws IOException {
/*  42 */     super(index, init, key, block);
/*  43 */     this.service = new RoomService((RoomBlueprintImp)this, init, null)
/*     */       {
/*     */         public FSERVICE service(int tx, int ty)
/*     */         {
/*  47 */           return ROOM_SCHOOL.this.station.service(tx, ty);
/*     */         }
/*     */       };
/*  50 */     pushBo(init.data(), this.type, true);
/*  51 */     this.constructor = new SchoolConstructor(this, init);
/*     */     
/*  53 */     this.helper = new RoomEducationHelper(HCLASSES.OTHER(), this, new RoomBoost[] { (RoomBoost)this.constructor.quality })
/*     */       {
/*     */         public StatsEducation.AgeType type()
/*     */         {
/*  57 */           return (STATS.EDUCATION()).child;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  62 */     this.industry = new Industry((RoomBlueprintImp)this, init.data(), null)
/*     */       {
/*     */         public double consumptionRate(RoomInstance ins, Humanoid h, IndustryResource oo)
/*     */         {
/*  66 */           if (ins.employees().employed() == 0)
/*  67 */             return 0.0D; 
/*  68 */           double d = oo.rate * ROOM_SCHOOL.this.service.load() * ROOM_SCHOOL.this.service.total() / ins.employees().employed();
/*  69 */           return d;
/*     */         }
/*     */       };
/*     */     
/*  73 */     employment().countInputSet();
/*     */     
/*  75 */     this.indus = (LIST<Industry>)new ArrayList(this.industry);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void update(double ds) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public SFinderRoomService service(int tx, int ty) {
/*  85 */     return this.service.finder;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void saveP(FilePutter saveFile) {
/*  90 */     this.service.saver.save(saveFile);
/*  91 */     this.industry.save(saveFile);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void loadP(FileGetter saveFile) throws IOException {
/*  96 */     this.service.saver.load(saveFile);
/*  97 */     this.industry.load(saveFile);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clearP() {
/* 102 */     this.service.saver.clear();
/* 103 */     this.industry.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public Furnisher constructor() {
/* 108 */     return this.constructor;
/*     */   }
/*     */ 
/*     */   
/*     */   public void appendView(LISTE<UIRoomModule> mm) {
/* 113 */     this.helper.appendView(mm);
/*     */   }
/*     */ 
/*     */   
/*     */   public LIST<Industry> industries() {
/* 118 */     return this.indus;
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomService service() {
/* 123 */     return this.service;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DIR childDir(int sx, int sy) {
/* 132 */     return this.station.serviceDir(sx, sy);
/*     */   }
/*     */   
/*     */   public double learningSpeed(Humanoid student, int tx, int ty) {
/* 136 */     return this.helper.learningSpeed(student, tx, ty);
/*     */   }
/*     */ 
/*     */   
/*     */   public double industryFormatConsumptionRate(GText text, IndustryResource i, RoomInstance ins) {
/* 141 */     SchoolInstance sc = (SchoolInstance)ins;
/*     */     
/* 143 */     double d = i.rate * sc.service().load() * sc.service().total();
/* 144 */     GFORMAT.f0(text, -d);
/* 145 */     return d;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\knowledge\school\ROOM_SCHOOL.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */