/*     */ package settlement.room.knowledge.university;
/*     */ 
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.time.TIME;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASSES;
/*     */ import java.io.IOException;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.finders.SFinderFindable;
/*     */ import settlement.path.finders.SFinderRoomService;
/*     */ import settlement.room.industry.module.RoomBoost;
/*     */ import settlement.room.knowledge.school.RoomEducationHelper;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.category.RoomCategorySub;
/*     */ import settlement.room.main.employment.RoomEmploymentSimple;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.colls.StatsEducation;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import util.data.BOOLEAN;
/*     */ import util.text.D;
/*     */ import view.sett.ui.room.UIRoomModule;
/*     */ 
/*     */ public final class ROOM_UNIVERSITY
/*     */   extends RoomBlueprintIns<UniversityInstance> {
/*     */   final UniversityConstructor constructor;
/*     */   public final double learningSpeed;
/*  35 */   final Job job = new Job(this);
/*     */   
/*     */   private final RoomEducationHelper helper;
/*     */   
/*  39 */   private static CharSequence ¤¤bonus = "Learning speed of";
/*     */   
/*     */   static {
/*  42 */     D.ts(ROOM_UNIVERSITY.class);
/*     */   }
/*     */   
/*  45 */   public final RoomEmploymentSimple.EmployerSimple emp = new RoomEmploymentSimple.EmployerSimple(employment());
/*     */   public BOOLEAN isTime;
/*     */   
/*  48 */   public ROOM_UNIVERSITY(String key, int index, RoomInitData init, RoomCategorySub block) throws IOException { super(index, init, key, block);
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
/* 100 */     this.isTime = new BOOLEAN() { public StatsEducation.AgeType type() { return (STATS.EDUCATION()).adult; } }
/*     */       ; this.constructor = new UniversityConstructor(this, init); this.learningSpeed = init.data().d("LEARNING_SPEED", 0.0D, 100.0D);
/*     */     clearP();
/*     */     pushBo(init.data(), this.info.name, String.valueOf(¤¤bonus) + ": " + String.valueOf(¤¤bonus), "UNIVERSITY", true);
/* 104 */     this.helper = new RoomEducationHelper(HCLASSES.CITIZEN(), this, new RoomBoost[] { (RoomBoost)this.constructor.quality }) { public boolean is() { return (TIME.days().bitPartOf() > ROOM_UNIVERSITY.this.employment().getShiftStart() && TIME.days().bitPartOf() < ROOM_UNIVERSITY.this.employment().getShiftStart() + Humanoid.WORK_PER_DAY); }
/*     */          }
/*     */       ; }
/*     */    protected void update(double ds) {} public SFinderRoomService service(int tx, int ty) {
/*     */     return null;
/*     */   } protected void saveP(FilePutter f) {} public double learningSpeed(RoomInstance i, BOOSTABLE_O h) {
/* 110 */     return this.helper.learningSpeed(i, h);
/*     */   }
/*     */   
/*     */   protected void loadP(FileGetter f) throws IOException {}
/*     */   protected void clearP() {}
/* 115 */   public boolean isLecturer(COORDINATE c) { return ((SETT.ROOMS()).fData.tileData.get(c) == 2); }
/*     */   public Furnisher constructor() { return this.constructor; } public void appendView(LISTE<UIRoomModule> mm) {
/*     */     this.helper.appendView(mm);
/*     */   } public DIR spotDir(COORDINATE c) {
/* 119 */     return (DIR)DIR.ORTHO.get((SETT.ROOMS()).fData.spriteData.get(c) & 0x3);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\knowledg\\university\ROOM_UNIVERSITY.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */