/*    */ package settlement.room.infra.transport;
/*    */ 
/*    */ import init.resources.RESOURCE;
/*    */ import java.io.IOException;
/*    */ import settlement.path.finders.SFinderFindable;
/*    */ import settlement.path.finders.SFinderRoomService;
/*    */ import settlement.room.main.Room;
/*    */ import settlement.room.main.RoomBlueprintIns;
/*    */ import settlement.room.main.category.RoomCategorySub;
/*    */ import settlement.room.main.furnisher.Furnisher;
/*    */ import settlement.room.main.job.ROOM_EMPLOY_AUTO;
/*    */ import settlement.room.main.job.ROOM_RADIUS;
/*    */ import settlement.room.main.util.RoomInitData;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
/*    */ import snake2d.util.sets.LISTE;
/*    */ import view.sett.ui.room.UIRoomModule;
/*    */ 
/*    */ public final class ROOM_TRANSPORT
/*    */   extends RoomBlueprintIns<TransportInstance> implements ROOM_RADIUS.ROOM_RADIUSE, ROOM_EMPLOY_AUTO {
/*    */   public static final int MAX_LOAD = 400;
/*    */   public static final int MAX_EMPLOYEES = 16;
/*    */   final Constructor constructor;
/* 24 */   final Job job = new Job(this);
/*    */   
/*    */   public ROOM_TRANSPORT(RoomInitData init, RoomCategorySub cat) throws IOException {
/* 27 */     super(0, init, "_TRANSPORT", cat);
/* 28 */     this.constructor = new Constructor(this, init);
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
/* 39 */     return this.constructor;
/*    */   }
/*    */ 
/*    */   
/*    */   public SFinderRoomService service(int tx, int ty) {
/* 44 */     return null;
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
/* 64 */     mm.add((new Gui(this)).make());
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean autoEmploy(Room r) {
/* 69 */     return ((TransportInstance)r).auto;
/*    */   }
/*    */ 
/*    */   
/*    */   public void autoEmploy(Room r, boolean b) {
/* 74 */     ((TransportInstance)r).auto = b;
/*    */   }
/*    */ 
/*    */   
/*    */   public ROOM_RADIUS.ROOM_RADIUS_INSTANCE radiusInstance(Room t) {
/* 79 */     return (TransportInstance)t;
/*    */   }
/*    */   
/*    */   public boolean hasActive(RESOURCE res) {
/* 83 */     return true;
/*    */   }
/*    */   
/*    */   public void endDelivery(short startTx, short startTy, RESOURCE res, int amount, int distance) {
/* 87 */     TransportInstance ins = (TransportInstance)get(startTx, startTy);
/* 88 */     if (ins != null) {
/* 89 */       ins.finishDeliveryJob(amount);
/*    */     }
/* 91 */     ins.reportMoved(distance);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\transport\ROOM_TRANSPORT.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */