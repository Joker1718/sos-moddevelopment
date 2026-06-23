/*    */ package settlement.room.water;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import settlement.main.SETT;
/*    */ import settlement.path.finders.SFinderFindable;
/*    */ import settlement.path.finders.SFinderRoomService;
/*    */ import settlement.room.main.RoomBlueprintIns;
/*    */ import settlement.room.main.category.RoomCategorySub;
/*    */ import settlement.room.main.furnisher.Furnisher;
/*    */ import settlement.room.main.util.RoomInitData;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
/*    */ import snake2d.util.sets.LISTE;
/*    */ import view.sett.ui.room.UIRoomModule;
/*    */ 
/*    */ final class ROOM_PUMP
/*    */   extends RoomBlueprintIns<PumpInstance> {
/*    */   final PumpJob job;
/*    */   final PumpConstructor constructor;
/*    */   
/*    */   public ROOM_PUMP(RoomInitData init, RoomCategorySub cat) throws IOException {
/* 22 */     super(0, init, "_WATERPUMP", cat);
/*    */     
/* 24 */     this.constructor = new PumpConstructor(this, init);
/* 25 */     this.job = new PumpJob(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public void appendView(LISTE<UIRoomModule> mm) {
/* 30 */     mm.add((new PumpGui(this)).make());
/*    */   }
/*    */ 
/*    */   
/*    */   protected void update(double ds) {
/* 35 */     (SETT.ROOMS()).WATER.updater.update(ds);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public SFinderRoomService service(int tx, int ty) {
/* 42 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void saveP(FilePutter saveFile) {
/* 47 */     (SETT.ROOMS()).WATER.updater.saver.save(saveFile);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void loadP(FileGetter saveFile) throws IOException {
/* 52 */     (SETT.ROOMS()).WATER.updater.saver.load(saveFile);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void clearP() {
/* 57 */     (SETT.ROOMS()).WATER.updater.saver.clear();
/*    */   }
/*    */ 
/*    */   
/*    */   public Furnisher constructor() {
/* 62 */     return this.constructor;
/*    */   }
/*    */   
/*    */   boolean isCanalConnection(int tx, int ty) {
/* 66 */     return (is(tx, ty) && (SETT.ROOMS()).fData.tile.get(tx, ty) == this.constructor.ou);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\water\ROOM_PUMP.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */