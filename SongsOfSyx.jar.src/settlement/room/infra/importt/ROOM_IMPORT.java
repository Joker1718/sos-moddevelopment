/*    */ package settlement.room.infra.importt;
/*    */ 
/*    */ import init.resources.RESOURCE;
/*    */ import java.io.IOException;
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
/*    */ public final class ROOM_IMPORT
/*    */   extends RoomBlueprintIns<ImportInstance> {
/* 18 */   public final ImportTally tally = new ImportTally();
/* 19 */   final Crate crate = new Crate(this);
/*    */   final Constructor constructor;
/*    */   public final ImportThingy UNLOADER;
/*    */   
/*    */   public ROOM_IMPORT(RoomInitData init, RoomCategorySub cat) throws IOException {
/* 24 */     super(0, init, "_IMPORT", cat);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 62 */     this.UNLOADER = new ImportThingy(this, this.tally);
/*    */     this.constructor = new Constructor(this, init);
/*    */   }
/*    */   protected void update(double ds) {}
/* 66 */   public Furnisher constructor() { return this.constructor; } public SFinderRoomService service(int tx, int ty) { return null; } public void appendView(LISTE<UIRoomModule> mm) { mm.add((new Gui(this)).make()); }
/*    */   protected void saveP(FilePutter saveFile) { this.tally.saver.save(saveFile); }
/*    */   protected void loadP(FileGetter saveFile) throws IOException { this.tally.saver.load(saveFile); for (int i = 0; i < instancesSize(); i++)
/*    */       this.tally.count(((ImportInstance)getInstance(i)).resource(), ((ImportInstance)getInstance(i)).amount(), ((ImportInstance)getInstance(i)).capacity());  }
/* 70 */   protected void clearP() { this.tally.saver.clear(); } public int getBestPrice(RESOURCE res) { return 0; }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\importt\ROOM_IMPORT.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */