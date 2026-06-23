/*    */ package settlement.room.service.hygine.well;
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
/*    */ public final class ROOM_WELL extends RoomBlueprintIns<WellInstance> implements RoomServiceNeed.ROOM_SERVICE_NEED_HASER {
/*    */   final RoomServiceNeed data;
/*    */   final Constructor constructor;
/*    */   final Wash bed;
/*    */   
/*    */   public ROOM_WELL(String key, int index, RoomInitData init, RoomCategorySub block) throws IOException {
/* 24 */     super(index, init, key, block);
/* 25 */     this.bed = new Wash(this);
/* 26 */     this.data = new RoomServiceNeed((RoomBlueprintImp)this, init)
/*    */       {
/*    */         public FSERVICE service(int tx, int ty)
/*    */         {
/* 30 */           return ROOM_WELL.this.bed.get(tx, ty);
/*    */         }
/*    */ 
/*    */         
/*    */         public double totalMultiplier() {
/* 35 */           return super.totalMultiplier();
/*    */         }
/*    */       };
/*    */     
/* 39 */     this.constructor = new Constructor(this, init);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void update(double ds) {}
/*    */ 
/*    */   
/*    */   public Wash bed(int tx, int ty) {
/* 48 */     return this.bed.get(tx, ty);
/*    */   }
/*    */ 
/*    */   
/*    */   public Furnisher constructor() {
/* 53 */     return this.constructor;
/*    */   }
/*    */ 
/*    */   
/*    */   public SFinderRoomService service(int tx, int ty) {
/* 58 */     return this.data.finder;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void saveP(FilePutter saveFile) {
/* 63 */     this.data.saver.save(saveFile);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void loadP(FileGetter saveFile) throws IOException {
/* 68 */     this.data.saver.load(saveFile);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void clearP() {
/* 73 */     this.data.saver.clear();
/*    */   }
/*    */ 
/*    */   
/*    */   public RoomServiceNeed service() {
/* 78 */     return this.data;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean registersEnvironment() {
/* 83 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\hygine\well\ROOM_WELL.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */