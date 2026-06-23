/*    */ package settlement.room.spirit.grave;
/*    */ 
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
/*    */ public final class ROOM_TOMB
/*    */   extends RoomBlueprintIns<GraveInstance> implements GraveData.GRAVE_DATA_HOLDER {
/*    */   private final GraveData data;
/*    */   private final CTomb constructor;
/*    */   private final SFinderRoomService finder;
/*    */   
/*    */   public ROOM_TOMB(int typeIndex, String key, RoomInitData init, RoomCategorySub block, SFinderRoomService finder) throws IOException {
/* 22 */     super(typeIndex, init, key, block);
/* 23 */     this.data = new GraveData(this, init, 40)
/*    */       {
/*    */         public double respect(GraveInstance grave)
/*    */         {
/* 27 */           return ROOM_TOMB.this.constructor.respekk.get(grave);
/*    */         }
/*    */       };
/*    */ 
/*    */     
/* 32 */     this.constructor = new CTomb(this, init);
/*    */     
/* 34 */     this.finder = finder;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void update(double ds) {
/* 39 */     this.data.update(ds);
/*    */   }
/*    */ 
/*    */   
/*    */   public Furnisher constructor() {
/* 44 */     return this.constructor;
/*    */   }
/*    */ 
/*    */   
/*    */   public SFinderRoomService service(int tx, int ty) {
/* 49 */     return this.finder;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void saveP(FilePutter file) {
/* 54 */     this.data.save(file);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void loadP(FileGetter file) throws IOException {
/* 59 */     this.data.load(file);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void clearP() {
/* 64 */     this.data.clear();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void appendView(LISTE<UIRoomModule> mm) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public GraveData graveData() {
/* 74 */     return this.data;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\spirit\grave\ROOM_TOMB.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */