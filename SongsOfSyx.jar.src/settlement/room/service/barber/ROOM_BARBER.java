/*    */ package settlement.room.service.barber;
/*    */ 
/*    */ import game.time.TIME;
/*    */ import java.io.IOException;
/*    */ import settlement.main.SETT;
/*    */ import settlement.misc.util.FSERVICE;
/*    */ import settlement.path.finders.SFinderFindable;
/*    */ import settlement.path.finders.SFinderRoomService;
/*    */ import settlement.room.main.Room;
/*    */ import settlement.room.main.RoomBlueprintImp;
/*    */ import settlement.room.main.RoomBlueprintIns;
/*    */ import settlement.room.main.category.RoomCategorySub;
/*    */ import settlement.room.main.furnisher.Furnisher;
/*    */ import settlement.room.main.furnisher.FurnisherItem;
/*    */ import settlement.room.main.job.ROOM_EMPLOY_AUTO;
/*    */ import settlement.room.main.util.RoomInitData;
/*    */ import settlement.room.service.module.RoomService;
/*    */ import settlement.room.service.module.RoomServiceAccess;
/*    */ import settlement.room.service.module.RoomServiceNeed;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
/*    */ 
/*    */ public final class ROOM_BARBER extends RoomBlueprintIns<Instance> implements RoomServiceNeed.ROOM_SERVICE_NEED_HASER, ROOM_EMPLOY_AUTO {
/*    */   public static final String TYPE = "BARBER";
/*    */   final RoomServiceNeed data;
/*    */   final Constructor constructor;
/*    */   final Tile ll;
/*    */   
/*    */   public ROOM_BARBER(RoomInitData init, int typeIndex, String key, RoomCategorySub block) throws IOException {
/* 31 */     super(typeIndex, init, key, block);
/* 32 */     this.data = new RoomServiceNeed((RoomBlueprintImp)this, init)
/*    */       {
/*    */         public FSERVICE service(int tx, int ty)
/*    */         {
/* 36 */           return ROOM_BARBER.this.ll.service(tx, ty);
/*    */         }
/*    */       };
/*    */     
/* 40 */     this.constructor = new Constructor(this, init);
/* 41 */     this.ll = new Tile(this, (int)(TIME.workSeconds() * init.data().d("WORK_TIME_IN_DAYS")));
/*    */   }
/*    */ 
/*    */   
/*    */   public Furnisher constructor() {
/* 46 */     return this.constructor;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void update(double ds) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public SFinderRoomService service(int tx, int ty) {
/* 57 */     return this.data.finder;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void saveP(FilePutter saveFile) {
/* 62 */     this.data.saver.save(saveFile);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void loadP(FileGetter saveFile) throws IOException {
/* 67 */     this.data.saver.load(saveFile);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void clearP() {
/* 72 */     this.data.saver.clear();
/*    */   }
/*    */ 
/*    */   
/*    */   public RoomServiceNeed service() {
/* 77 */     return this.data;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean autoEmploy(Room r) {
/* 82 */     return ((Instance)r).auto;
/*    */   }
/*    */ 
/*    */   
/*    */   public void autoEmploy(Room r, boolean b) {
/* 87 */     ((Instance)r).auto = b;
/*    */   }
/*    */   
/*    */   public DIR dir(int tx, int ty) {
/* 91 */     FurnisherItem it = (FurnisherItem)(SETT.ROOMS()).fData.item.get(tx, ty);
/* 92 */     if (it == null)
/* 93 */       return DIR.N; 
/* 94 */     return DIR.W.next(2 * it.rotation);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\barber\ROOM_BARBER.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */