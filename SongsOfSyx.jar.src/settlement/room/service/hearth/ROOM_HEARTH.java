/*    */ package settlement.room.service.hearth;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import settlement.misc.util.FSERVICE;
/*    */ import settlement.path.finders.SFinderFindable;
/*    */ import settlement.path.finders.SFinderRoomService;
/*    */ import settlement.room.main.RoomBlueprintImp;
/*    */ import settlement.room.main.RoomBlueprintIns;
/*    */ import settlement.room.main.category.RoomCategorySub;
/*    */ import settlement.room.main.furnisher.Furnisher;
/*    */ import settlement.room.main.util.RoomInitData;
/*    */ import settlement.room.service.module.RoomService;
/*    */ import settlement.room.service.module.RoomServiceAccess;
/*    */ import settlement.room.service.module.RoomServiceNeed;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
/*    */ 
/*    */ public final class ROOM_HEARTH extends RoomBlueprintIns<HearthInstance> implements RoomServiceNeed.ROOM_SERVICE_NEED_HASER {
/*    */   final RoomServiceNeed data;
/*    */   final Constructor constructor;
/*    */   final Hearth bed;
/*    */   
/*    */   public ROOM_HEARTH(String key, int index, RoomInitData init, RoomCategorySub block) throws IOException {
/* 24 */     super(index, init, key, block);
/* 25 */     this.bed = new Hearth(this);
/* 26 */     this.data = new RoomServiceNeed((RoomBlueprintImp)this, init)
/*    */       {
/*    */         public FSERVICE service(int tx, int ty)
/*    */         {
/* 30 */           return ROOM_HEARTH.this.bed.get(tx, ty);
/*    */         }
/*    */       };
/* 33 */     this.constructor = new Constructor(this, init);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void update(double ds) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public Hearth bed(int tx, int ty) {
/* 43 */     return this.bed.get(tx, ty);
/*    */   }
/*    */ 
/*    */   
/*    */   public Furnisher constructor() {
/* 48 */     return this.constructor;
/*    */   }
/*    */ 
/*    */   
/*    */   public SFinderRoomService service(int tx, int ty) {
/* 53 */     return this.data.finder;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void saveP(FilePutter saveFile) {
/* 58 */     this.data.saver.save(saveFile);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void loadP(FileGetter saveFile) throws IOException {
/* 63 */     this.data.saver.load(saveFile);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void clearP() {
/* 68 */     this.data.saver.clear();
/*    */   }
/*    */ 
/*    */   
/*    */   public RoomServiceNeed service() {
/* 73 */     return this.data;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\hearth\ROOM_HEARTH.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */