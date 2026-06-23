/*    */ package settlement.room.spirit.shrine;
/*    */ 
/*    */ import init.religion.RELIGIONS;
/*    */ import init.religion.Religion;
/*    */ import init.type.NEED;
/*    */ import init.type.NEEDS;
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
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
/*    */ 
/*    */ public final class ROOM_SHRINE
/*    */   extends RoomBlueprintIns<ShrineInstance> implements RoomService.ROOM_SERVICE_HASER {
/*    */   public final Religion religion;
/*    */   final RoomService data;
/*    */   final Constructor constructor;
/*    */   final Service bed;
/*    */   
/*    */   public ROOM_SHRINE(String key, int index, RoomInitData init, RoomCategorySub block) throws IOException {
/* 28 */     super(index, init, key, block);
/*    */     
/* 30 */     this.religion = (Religion)RELIGIONS.MAP().read(init.data());
/* 31 */     this.bed = new Service(this);
/* 32 */     this.data = new RoomService((RoomBlueprintImp)this, init, (NEEDS.TYPES()).SHRINE)
/*    */       {
/*    */         public FSERVICE service(int tx, int ty)
/*    */         {
/* 36 */           return ROOM_SHRINE.this.bed.get(tx, ty);
/*    */         }
/*    */       };
/* 39 */     this.constructor = new Constructor(this, init);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void update(double ds) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public Service bed(int tx, int ty) {
/* 49 */     return this.bed.get(tx, ty);
/*    */   }
/*    */ 
/*    */   
/*    */   public Furnisher constructor() {
/* 54 */     return this.constructor;
/*    */   }
/*    */ 
/*    */   
/*    */   public SFinderRoomService service(int tx, int ty) {
/* 59 */     return this.data.finder;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void saveP(FilePutter saveFile) {
/* 64 */     this.data.saver.save(saveFile);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void loadP(FileGetter saveFile) throws IOException {
/* 69 */     this.data.saver.load(saveFile);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void clearP() {
/* 74 */     this.data.saver.clear();
/*    */   }
/*    */ 
/*    */   
/*    */   public RoomService service() {
/* 79 */     return this.data;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\spirit\shrine\ROOM_SHRINE.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */