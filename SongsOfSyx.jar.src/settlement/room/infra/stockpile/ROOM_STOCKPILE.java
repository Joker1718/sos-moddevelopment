/*     */ package settlement.room.infra.stockpile;
/*     */ 
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import init.resources.RESOURCE;
/*     */ import java.io.IOException;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.finders.SFinderFindable;
/*     */ import settlement.path.finders.SFinderRoomService;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.category.RoomCategorySub;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.job.ROOM_EMPLOY_AUTO;
/*     */ import settlement.room.main.job.ROOM_RADIUS;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import util.text.D;
/*     */ import view.sett.ui.room.UIRoomModule;
/*     */ 
/*     */ public final class ROOM_STOCKPILE
/*     */   extends RoomBlueprintIns<StockpileInstance> implements ROOM_RADIUS.ROOM_RADIUSE, ROOM_EMPLOY_AUTO {
/*     */   public static final int MIN_CARRY = 7;
/*  29 */   private final StockpileTally tally = new StockpileTally();
/*     */   
/*     */   final Constructor constructor;
/*     */   
/*  33 */   final Crate crate = new Crate(this);
/*  34 */   private static CharSequence ¤¤bname = "¤Carry Capacity";
/*  35 */   private static CharSequence ¤¤bdesc = "¤Carry Capacity of all logistics workers.";
/*     */   
/*  37 */   final Organiser org = new Organiser(this);
/*     */   
/*     */   static {
/*  40 */     D.ts(ROOM_STOCKPILE.class);
/*     */   }
/*     */   
/*     */   public ROOM_STOCKPILE(RoomInitData init, RoomCategorySub cat) throws IOException {
/*  44 */     super(0, init, "_STOCKPILE", cat);
/*  45 */     this.constructor = new Constructor(this, init);
/*  46 */     pushBo(init.data(), ¤¤bname, ¤¤bdesc, null, false, 10.0D);
/*     */   }
/*     */ 
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
/*     */   
/*     */   public Furnisher constructor() {
/*  61 */     return this.constructor;
/*     */   }
/*     */ 
/*     */   
/*     */   public SFinderRoomService service(int tx, int ty) {
/*  66 */     return null;
/*     */   }
/*     */   
/*     */   public StockpileTally tally() {
/*  70 */     return this.tally;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void saveP(FilePutter saveFile) {
/*  75 */     this.tally.saver.save(saveFile);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void loadP(FileGetter saveFile) throws IOException {
/*  80 */     this.tally.clear();
/*  81 */     for (StockpileInstance ins : all()) {
/*  82 */       this.tally.init(ins);
/*     */     }
/*  84 */     this.tally.saver.load(saveFile);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clearP() {
/*  89 */     this.tally.clear();
/*  90 */     this.tally.saver.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public void appendView(LISTE<UIRoomModule> mm) {
/*  95 */     mm.add((new Gui(this)).make());
/*     */   }
/*     */   
/*     */   public int crates() {
/*  99 */     int am = 0;
/* 100 */     for (StockpileInstance ins : all())
/* 101 */       am += ins.crates.size(); 
/* 102 */     return am;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean autoEmploy(Room r) {
/* 108 */     return ((StockpileInstance)r).autoE;
/*     */   }
/*     */ 
/*     */   
/*     */   public void autoEmploy(Room r, boolean b) {
/* 113 */     ((StockpileInstance)r).autoE = b;
/*     */   }
/*     */   
/*     */   public int carryCap(Humanoid skill) {
/* 117 */     double dam = this.bonus.get((BOOSTABLE_O)skill.indu());
/* 118 */     int am = (int)dam;
/* 119 */     am += (RND.rFloat() < dam - am) ? 1 : 0;
/* 120 */     am = CLAMP.i(am, 1, 100);
/* 121 */     return am;
/*     */   }
/*     */   
/*     */   public RoomInstance getInstance(int wI, RESOURCE res) {
/* 125 */     StockpileInstance ins = (StockpileInstance)getInstance(wI);
/*     */     
/* 127 */     if (ins != null && ((SETT.ROOMS()).STOCKPILE.tally()).crates.get(res, ins) > 0) {
/* 128 */       return ins;
/*     */     }
/* 130 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public ROOM_RADIUS.ROOM_RADIUS_INSTANCE radiusInstance(Room t) {
/* 135 */     return (StockpileInstance)t;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\stockpile\ROOM_STOCKPILE.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */