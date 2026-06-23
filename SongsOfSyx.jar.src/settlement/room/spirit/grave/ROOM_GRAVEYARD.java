/*    */ package settlement.room.spirit.grave;
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
/*    */ public final class ROOM_GRAVEYARD
/*    */   extends RoomBlueprintIns<GraveInstance> implements GraveData.GRAVE_DATA_HOLDER {
/*    */   private final GraveData data;
/*    */   final CGraveyard constructor;
/*    */   private final SFinderRoomService finder;
/*    */   
/*    */   public ROOM_GRAVEYARD(int typeIndex, String key, RoomInitData init, RoomCategorySub block, SFinderRoomService finder) throws IOException {
/* 23 */     super(typeIndex, init, key, block);
/* 24 */     this.data = new GraveData(this, init, 20)
/*    */       {
/*    */         public double respect(GraveInstance grave)
/*    */         {
/* 28 */           return ROOM_GRAVEYARD.this.constructor.respekk.get(grave);
/*    */         }
/*    */       };
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 35 */     this.constructor = new CGraveyard(this, init);
/*    */     
/* 37 */     this.finder = finder;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void update(double ds) {
/* 42 */     this.data.update(ds);
/*    */   }
/*    */ 
/*    */   
/*    */   public Furnisher constructor() {
/* 47 */     return this.constructor;
/*    */   }
/*    */ 
/*    */   
/*    */   public SFinderRoomService service(int tx, int ty) {
/* 52 */     return this.finder;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void saveP(FilePutter file) {
/* 57 */     this.data.save(file);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void loadP(FileGetter file) throws IOException {
/* 62 */     this.data.load(file);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void clearP() {
/* 67 */     this.data.clear();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void appendView(LISTE<UIRoomModule> mm) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public GraveData graveData() {
/* 77 */     return this.data;
/*    */   }
/*    */   
/*    */   public boolean isGraveHead(int tx, int ty) {
/* 81 */     return (is(tx, ty) && (SETT.ROOMS()).fData.tileData.get(tx, ty) == 2);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\spirit\grave\ROOM_GRAVEYARD.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */