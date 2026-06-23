/*    */ package settlement.room.infra.janitor;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import settlement.path.finders.SFinderFindable;
/*    */ import settlement.path.finders.SFinderRoomService;
/*    */ import settlement.room.main.Room;
/*    */ import settlement.room.main.RoomBlueprintIns;
/*    */ import settlement.room.main.category.RoomCategorySub;
/*    */ import settlement.room.main.furnisher.Furnisher;
/*    */ import settlement.room.main.job.ROOM_EMPLOY_AUTO;
/*    */ import settlement.room.main.util.RoomInitData;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
/*    */ import snake2d.util.sets.LISTE;
/*    */ import view.sett.ui.room.UIRoomModule;
/*    */ 
/*    */ public final class ROOM_JANITOR
/*    */   extends RoomBlueprintIns<JanitorInstance> implements ROOM_EMPLOY_AUTO {
/* 19 */   final JM jm = new JM(this);
/*    */   public static final int radius = 150;
/*    */   final Constructor constructor;
/*    */   
/*    */   public ROOM_JANITOR(RoomInitData init, RoomCategorySub block) throws IOException {
/* 24 */     super(0, init, "_JANITOR", block);
/* 25 */     this.constructor = new Constructor(this, init);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void update(double ds) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public Furnisher constructor() {
/* 36 */     return this.constructor;
/*    */   }
/*    */ 
/*    */   
/*    */   public SFinderRoomService service(int tx, int ty) {
/* 41 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void saveP(FilePutter saveFile) {}
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void loadP(FileGetter saveFile) throws IOException {}
/*    */ 
/*    */ 
/*    */   
/*    */   protected void clearP() {}
/*    */ 
/*    */ 
/*    */   
/*    */   public void appendView(LISTE<UIRoomModule> mm) {
/* 61 */     mm.add((new Gui(this)).make());
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean autoEmploy(Room r) {
/* 66 */     return ((JanitorInstance)r).auto;
/*    */   }
/*    */ 
/*    */   
/*    */   public void autoEmploy(Room r, boolean b) {
/* 71 */     ((JanitorInstance)r).auto = b;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\janitor\ROOM_JANITOR.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */