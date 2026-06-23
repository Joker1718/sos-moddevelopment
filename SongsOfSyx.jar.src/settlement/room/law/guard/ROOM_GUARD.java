/*     */ package settlement.room.law.guard;
/*     */ 
/*     */ import game.battle.div.Div;
/*     */ import init.constant.Config;
/*     */ import java.io.IOException;
/*     */ import settlement.misc.util.FSERVICE;
/*     */ import settlement.path.finders.SFinderFindable;
/*     */ import settlement.path.finders.SFinderRoomService;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.category.RoomCategorySub;
/*     */ import settlement.room.main.employment.RoomEmploymentSimple;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.sets.Bitmap1D;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import util.data.BOOLEANO;
/*     */ import util.info.INFO;
/*     */ import util.text.D;
/*     */ import view.sett.ui.room.UIRoomModule;
/*     */ 
/*     */ public final class ROOM_GUARD
/*     */   extends RoomBlueprintIns<GuardInstance> {
/*  25 */   private static CharSequence ¤¤guard = "Active Duty";
/*  26 */   private static CharSequence ¤¤guardD = "When a division is on active duty, the soldiers will become guards who actively protects your city against crime, and instills order and law.";
/*     */   
/*     */   static {
/*  29 */     D.ts(ROOM_GUARD.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public static final int maxRadius = 90;
/*     */   
/*     */   final SFinderRoomService finder;
/*     */   
/*     */   final Constructor constructor;
/*  38 */   final Service service = new Service(this);
/*     */   
/*  40 */   public final RoomEmploymentSimple.EmployerSimple emp = new RoomEmploymentSimple.EmployerSimple(employment());
/*     */   
/*  42 */   public final Patrols patrols = new Patrols();
/*  43 */   public final GuardPower power = new GuardPower();
/*  44 */   public final CrimeReporter reporter = new CrimeReporter(this);
/*     */   
/*  46 */   private final Bitmap1D guardMode = new Bitmap1D((Config.battle()).DIVISIONS_PER_ARMY, false);
/*     */   public BOOLEANO.BOOLEAN_OE<Div> activeDuty;
/*     */   
/*     */   public ROOM_GUARD(RoomInitData init, RoomCategorySub block) throws IOException {
/*  50 */     super(0, init, "_GUARD", block);
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
/* 112 */     this.activeDuty = new BOOLEANO.BOOLEAN_OE<Div>()
/*     */       {
/* 114 */         private final INFO info = new INFO(ROOM_GUARD.¤¤guard, ROOM_GUARD.¤¤guardD);
/*     */ 
/*     */         
/*     */         public boolean is(Div t) {
/* 118 */           return ROOM_GUARD.this.guardMode.get(t.indexArmy());
/*     */         }
/*     */ 
/*     */         
/*     */         public BOOLEANO.BOOLEAN_OE<Div> set(Div t, boolean b) {
/* 123 */           ROOM_GUARD.this.guardMode.set(t.indexArmy(), b);
/* 124 */           return this;
/*     */         }
/*     */ 
/*     */         
/*     */         public INFO info() {
/* 129 */           return this.info;
/*     */         }
/*     */       };
/*     */     this.finder = new SFinderRoomService("Guards") {
/*     */         public FSERVICE get(int tx, int ty) {
/*     */           GuardInstance ins = (GuardInstance)ROOM_GUARD.this.getter.get(tx, ty);
/*     */           if (ins != null && ins.body().cX() == tx && ins.body().cY() == ty)
/*     */             return ROOM_GUARD.this.service.get(ins); 
/*     */           return null;
/*     */         }
/*     */       };
/*     */     this.constructor = new Constructor(this, init);
/*     */   }
/*     */   
/*     */   protected void update(double ds) {
/*     */     this.patrols.update(ds);
/*     */   }
/*     */   
/*     */   public Furnisher constructor() {
/*     */     return this.constructor;
/*     */   }
/*     */   
/*     */   public SFinderRoomService service(int tx, int ty) {
/*     */     return this.finder;
/*     */   }
/*     */   
/*     */   protected void saveP(FilePutter saveFile) {
/*     */     this.guardMode.save(saveFile);
/*     */     this.power.save(saveFile);
/*     */     this.patrols.save(saveFile);
/*     */     this.reporter.save(saveFile);
/*     */   }
/*     */   
/*     */   protected void loadP(FileGetter saveFile) throws IOException {
/*     */     this.guardMode.load(saveFile);
/*     */     this.power.load(saveFile);
/*     */     this.patrols.load(saveFile);
/*     */     this.reporter.load(saveFile);
/*     */   }
/*     */   
/*     */   protected void clearP() {
/*     */     this.guardMode.clear();
/*     */     this.power.clear();
/*     */     this.patrols.clear();
/*     */     this.reporter.clear();
/*     */   }
/*     */   
/*     */   public void appendView(LISTE<UIRoomModule> mm) {
/*     */     mm.add((new Gui(this)).make());
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\law\guard\ROOM_GUARD.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */