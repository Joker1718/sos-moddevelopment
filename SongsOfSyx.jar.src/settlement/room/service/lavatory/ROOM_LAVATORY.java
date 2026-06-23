/*    */ package settlement.room.service.lavatory;
/*    */ 
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
/*    */ import settlement.room.main.job.ROOM_EMPLOY_AUTO;
/*    */ import settlement.room.main.util.RoomInitData;
/*    */ import settlement.room.service.module.RoomService;
/*    */ import settlement.room.service.module.RoomServiceAccess;
/*    */ import settlement.room.service.module.RoomServiceNeed;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
/*    */ 
/*    */ public final class ROOM_LAVATORY
/*    */   extends RoomBlueprintIns<LavatoryInstance> implements RoomServiceNeed.ROOM_SERVICE_NEED_HASER, ROOM_EMPLOY_AUTO {
/*    */   final RoomServiceNeed data;
/*    */   final Constructor constructor;
/*    */   
/*    */   public ROOM_LAVATORY(RoomInitData init, int typeIndex, String key, RoomCategorySub block) throws IOException {
/* 27 */     super(typeIndex, init, key, block);
/* 28 */     this.data = new RoomServiceNeed((RoomBlueprintImp)this, init)
/*    */       {
/*    */         public FSERVICE service(int tx, int ty)
/*    */         {
/* 32 */           return Lavatory.get(tx, ty);
/*    */         }
/*    */       };
/*    */     
/* 36 */     this.constructor = new Constructor(this, init);
/*    */   }
/*    */ 
/*    */   
/*    */   public Furnisher constructor() {
/* 41 */     return this.constructor;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void update(double ds) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public Lavatory getService(int tx, int ty) {
/* 51 */     return Lavatory.get(tx, ty);
/*    */   }
/*    */ 
/*    */   
/*    */   public SFinderRoomService service(int tx, int ty) {
/* 56 */     return this.data.finder;
/*    */   }
/*    */   
/*    */   public boolean isExtra(int tx, int ty) {
/* 60 */     if (is(tx, ty)) {
/* 61 */       int d = (SETT.ROOMS()).data.get(tx, ty);
/* 62 */       return ((d & 0x4000) == 16384);
/*    */     } 
/* 64 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void saveP(FilePutter saveFile) {
/* 69 */     this.data.saver.save(saveFile);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void loadP(FileGetter saveFile) throws IOException {
/* 74 */     this.data.saver.load(saveFile);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void clearP() {
/* 79 */     this.data.saver.clear();
/*    */   }
/*    */ 
/*    */   
/*    */   public RoomServiceNeed service() {
/* 84 */     return this.data;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean autoEmploy(Room r) {
/* 89 */     return ((LavatoryInstance)r).auto;
/*    */   }
/*    */ 
/*    */   
/*    */   public void autoEmploy(Room r, boolean b) {
/* 94 */     ((LavatoryInstance)r).auto = b;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\lavatory\ROOM_LAVATORY.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */