/*     */ package settlement.room.military.training;
/*     */ 
/*     */ import game.GameDisposable;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.BoostSpecs;
/*     */ import init.sprite.UI.Icon;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.HCLASS_RACE;
/*     */ import java.io.IOException;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.path.finders.SFinderFindable;
/*     */ import settlement.room.industry.module.IndustryUtil;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.employment.RoomEmploymentSimple;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.colls.StatsBattle;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.info.INFO;
/*     */ import util.text.D;
/*     */ import view.sett.ui.room.UIRoomModule;
/*     */ 
/*     */ public abstract class ROOM_M_TRAINER<T extends RoomInstance> extends RoomBlueprintIns<T> {
/*  32 */   private static final ArrayListGrower<ROOM_M_TRAINER<?>> all = new ArrayListGrower();
/*     */ 
/*     */   
/*  35 */   private static CharSequence ¤¤Speed = "¤Speed of:";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static {
/*  46 */     D.ts(ROOM_M_TRAINER.class);
/*     */   }
/*     */   
/*  49 */   int trainingLimit = 10000;
/*     */   public final int INDEX_TRAINING;
/*     */   public final int TRAINING_DAYS;
/*     */   public final double TRAINING_RATE;
/*  53 */   public final RoomEmploymentSimple.EmployerSimple emp = new RoomEmploymentSimple.EmployerSimple(employment());
/*     */   
/*     */   public BoostSpecs boosters;
/*     */   
/*     */   public final INFO tInfo;
/*     */   public final SPRITE divIcon;
/*     */   public final LIST<ColorImp> divCols;
/*     */   
/*     */   protected ROOM_M_TRAINER(int typeIndex, RoomInitData data, String key) throws IOException {
/*  62 */     super(typeIndex, data, key, data.m.CATS.MILITARY);
/*  63 */     this.tInfo = new INFO(data.text().json("TRAINING"));
/*     */     
/*  65 */     CharSequence name = this.info.name;
/*  66 */     CharSequence desc = String.valueOf(¤¤Speed) + " " + String.valueOf(¤¤Speed);
/*     */     
/*  68 */     Json d = data.data().json("TRAINING");
/*     */     
/*  70 */     pushBo(d, name, desc, this.type, true);
/*     */ 
/*     */     
/*  73 */     this.TRAINING_DAYS = d.i("FULL_TRAINING_IN_DAYS");
/*     */     
/*  75 */     this.INDEX_TRAINING = all.add(this);
/*  76 */     this.TRAINING_RATE = 1.0D / this.TRAINING_DAYS;
/*  77 */     this.boosters = new BoostSpecs(this.info.name, (SPRITE)this.icon, false);
/*  78 */     this.boosters.read(d, null);
/*     */     
/*  80 */     Json json = data.data().json("DIV_SPRITE");
/*     */     
/*  82 */     this.divIcon = (SPRITE)UI.icons().get(json, (Icon)(UI.icons()).s.cancel);
/*  83 */     this.divCols = ColorImp.cols(json);
/*     */   }
/*     */   
/*     */   public StatsBattle.StatTraining training() {
/*  87 */     return (StatsBattle.StatTraining)(STATS.BATTLE()).TRAINING_ALL.get(this.INDEX_TRAINING);
/*     */   }
/*     */   
/*     */   public static double basicTrainingTimedays() {
/*  91 */     return 10.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public void train(Humanoid a, RoomInstance room, double delta) {
/*  96 */     double b = delta * IndustryUtil.roomBonus(room, null);
/*  97 */     b *= bonus().get((BOOSTABLE_O)a.indu());
/*     */     
/*  99 */     if (!(STATS.BATTLE()).basicTraining.isMax(a.indu())) {
/*     */ 
/*     */       
/* 102 */       (STATS.BATTLE()).basicTraining.incFraction(a.indu(), delta * (STATS.BATTLE()).basicTraining.max(a.indu()) * 0.1D);
/*     */     }
/*     */     else {
/*     */       
/* 106 */       b *= this.TRAINING_RATE;
/* 107 */       training().inc(a.indu(), b);
/*     */     } 
/*     */   }
/*     */   
/*     */   public int trainingDays() {
/* 112 */     return (int)Math.ceil(this.TRAINING_DAYS / bonus().get((BOOSTABLE_O)HCLASS_RACE.clP(null, null)));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void saveP(FilePutter f) {
/* 118 */     f.i(this.trainingLimit);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void loadP(FileGetter f) throws IOException {
/* 124 */     this.trainingLimit = f.i();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void clearP() {
/* 131 */     this.trainingLimit = 10000;
/*     */   }
/*     */   
/*     */   public int limit() {
/* 135 */     return this.trainingLimit;
/*     */   }
/*     */ 
/*     */   
/*     */   public SFinderFindable service(int tx, int ty) {
/* 140 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void update(double ds) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void appendView(LISTE<UIRoomModule> mm) {
/* 151 */     mm.add(new Gui(this));
/*     */   }
/*     */   
/*     */   public static LIST<ROOM_M_TRAINER<?>> ALL() {
/* 155 */     return (LIST<ROOM_M_TRAINER<?>>)all;
/*     */   }
/*     */   
/*     */   public int employable() {
/* 159 */     int e = this.emp.employable();
/* 160 */     int l = this.trainingLimit - employment().employed();
/* 161 */     return Math.min(e, l);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\military\training\ROOM_M_TRAINER.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */