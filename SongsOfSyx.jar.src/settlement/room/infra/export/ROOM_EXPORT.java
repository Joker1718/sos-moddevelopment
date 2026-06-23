/*     */ package settlement.room.infra.export;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import init.resources.RESOURCE;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
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
/*     */ public final class ROOM_EXPORT
/*     */   extends RoomBlueprintIns<ExportInstance> implements ROOM_RADIUS.ROOM_RADIUSE, ROOM_EMPLOY_AUTO {
/*  23 */   public final ExportTally tally = new ExportTally();
/*  24 */   public final ExportFetcher FETCHER = new ExportFetcher(this, this.tally);
/*     */   
/*     */   final Constructor constructor;
/*  27 */   private final Crate crate = new Crate(this);
/*     */   
/*     */   public ROOM_EXPORT(RoomInitData data, RoomCategorySub cat) throws IOException {
/*  30 */     super(0, data, "_EXPORT", cat);
/*     */     
/*  32 */     this.constructor = new Constructor(this, data);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void update(double ds) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public Crate crate(int tx, int ty) {
/*  42 */     return this.crate.get(tx, ty);
/*     */   }
/*     */ 
/*     */   
/*     */   public Furnisher constructor() {
/*  47 */     return this.constructor;
/*     */   }
/*     */ 
/*     */   
/*     */   public SFinderRoomService service(int tx, int ty) {
/*  52 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void saveP(FilePutter saveFile) {
/*  57 */     this.tally.saver.save(saveFile);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void loadP(FileGetter saveFile) throws IOException {
/*  62 */     this.tally.saver.load(saveFile);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clearP() {
/*  67 */     this.tally.saver.clear();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void appendView(LISTE<UIRoomModule> mm) {
/*  74 */     mm.add((new Gui(this)).make());
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean autoEmploy(Room r) {
/*  79 */     return ((ExportInstance)r).auto;
/*     */   }
/*     */ 
/*     */   
/*     */   public void autoEmploy(Room r, boolean b) {
/*  84 */     if (r instanceof ExportInstance) {
/*  85 */       ((ExportInstance)r).auto = b;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ROOM_RADIUS.ROOM_RADIUS_INSTANCE radiusInstance(Room t) {
/*  93 */     return (ExportInstance)t;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int prioFetchAmount(RESOURCE res) {
/*  99 */     int cap = ((SETT.ROOMS()).STOCKPILE.tally()).space.total(res);
/* 100 */     return (int)(cap * (FACTIONS.player().seller(res.tr())).limit.getD());
/*     */   }
/*     */   
/*     */   public int prioFetchAvailable(RESOURCE res) {
/* 104 */     return ((SETT.ROOMS()).STOCKPILE.tally()).amountReservable.get(res) - prioFetchAmount(res);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\export\ROOM_EXPORT.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */