/*     */ package settlement.room.military.supply;
/*     */ 
/*     */ import game.GAME;
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import java.io.IOException;
/*     */ import settlement.path.finders.SFinderFindable;
/*     */ import settlement.path.finders.SFinderRoomService;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.category.RoomCategorySub;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.job.ROOM_EMPLOY_AUTO;
/*     */ import settlement.room.main.job.ROOM_RADIUS;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import view.sett.ui.room.UIRoomModule;
/*     */ 
/*     */ public final class ROOM_SUPPLY
/*     */   extends RoomBlueprintIns<SupplyInstance> implements ROOM_RADIUS, ROOM_EMPLOY_AUTO {
/*     */   public static final int STORAGE = 80;
/*     */   final Constructor constructor;
/*  26 */   final Crate crate = new Crate(this);
/*  27 */   final Cache cache = new Cache(this);
/*  28 */   public final SupplyTally tally = new SupplyTally(this); final RESOURCE liveStock;
/*     */   private int upI;
/*     */   private RBIT.RBITImp hh;
/*     */   
/*  32 */   public ROOM_SUPPLY(RoomInitData init, RoomCategorySub cat) throws IOException { super(0, init, "_MILITARY_SUPPLY", cat);
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
/* 147 */     this.upI = -1;
/* 148 */     this.hh = new RBIT.RBITImp();
/*     */     this.constructor = new Constructor(this, init);
/*     */     this.liveStock = (RESOURCE)RESOURCES.map().read("LIVESTOCK", init.data()); } public boolean has(RESOURCE res) {
/* 151 */     if (this.upI == GAME.updateI()) {
/* 152 */       return this.hh.has(res);
/*     */     }
/* 154 */     this.upI = GAME.updateI();
/* 155 */     for (int i = 0; i < instancesSize(); i++) {
/* 156 */       this.hh.or(((SupplyInstance)getInstance(i)).allowed());
/*     */     }
/* 158 */     return this.hh.has(res);
/*     */   }
/*     */   
/*     */   protected void update(double ds) {}
/*     */   
/*     */   public Furnisher constructor() {
/*     */     return this.constructor;
/*     */   }
/*     */   
/*     */   public SFinderRoomService service(int tx, int ty) {
/*     */     return null;
/*     */   }
/*     */   
/*     */   protected void saveP(FilePutter saveFile) {
/*     */     this.cache.save(saveFile);
/*     */   }
/*     */   
/*     */   protected void loadP(FileGetter saveFile) throws IOException {
/*     */     this.cache.clear();
/*     */     this.tally.clear();
/*     */     for (SupplyInstance ins : all())
/*     */       this.tally.init(ins); 
/*     */     this.cache.load(saveFile);
/*     */   }
/*     */   
/*     */   protected void clearP() {
/*     */     this.cache.clear();
/*     */     this.tally.clear();
/*     */     this.cache.clear();
/*     */   }
/*     */   
/*     */   public boolean degrades() {
/*     */     return false;
/*     */   }
/*     */   
/*     */   public void appendView(LISTE<UIRoomModule> mm) {
/*     */     mm.add((new Gui(this)).make());
/*     */   }
/*     */   
/*     */   public boolean autoEmploy(Room r) {
/*     */     return ((SupplyInstance)r).auto;
/*     */   }
/*     */   
/*     */   public void autoEmploy(Room r, boolean b) {
/*     */     ((SupplyInstance)r).auto = b;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\military\supply\ROOM_SUPPLY.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */