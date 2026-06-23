/*    */ package settlement.room.health.physician;
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
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
/*    */ import snake2d.util.sets.LISTE;
/*    */ import view.sett.ui.room.UIRoomModule;
/*    */ 
/*    */ public final class ROOM_PHYSICIAN
/*    */   extends RoomBlueprintIns<Instance> implements RoomServiceNeed.ROOM_SERVICE_NEED_HASER, ROOM_EMPLOY_AUTO {
/*    */   final Constructor constructor;
/*    */   
/*    */   public ROOM_PHYSICIAN(String key, int typeI, RoomInitData init, RoomCategorySub block) throws IOException {
/* 29 */     super(typeI, init, key, block);
/* 30 */     this.s = new Service(this);
/* 31 */     this.data = new RoomServiceNeed((RoomBlueprintImp)this, init)
/*    */       {
/*    */         public FSERVICE service(int tx, int ty)
/*    */         {
/* 35 */           return ROOM_PHYSICIAN.this.s.getS(tx, ty);
/*    */         }
/*    */       };
/*    */     
/* 39 */     this.constructor = new Constructor(this, init);
/*    */   }
/*    */ 
/*    */   
/*    */   final RoomServiceNeed data;
/*    */   final Service s;
/*    */   
/*    */   protected void update(double ds) {}
/*    */   
/*    */   public Furnisher constructor() {
/* 49 */     return this.constructor;
/*    */   }
/*    */ 
/*    */   
/*    */   public void appendView(LISTE<UIRoomModule> mm) {
/* 54 */     mm.add((new Gui(this)).make());
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
/*    */   public DIR getLayDir(int sx, int sy) {
/* 78 */     return (DIR)DIR.ORTHO.getC((SETT.ROOMS()).fData.spriteData.get(sx, sy) & 0x3);
/*    */   }
/*    */ 
/*    */   
/*    */   public RoomServiceNeed service() {
/* 83 */     return this.data;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean autoEmploy(Room r) {
/* 88 */     return ((Instance)r).auto;
/*    */   }
/*    */ 
/*    */   
/*    */   public void autoEmploy(Room r, boolean b) {
/* 93 */     ((Instance)r).auto = b;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\health\physician\ROOM_PHYSICIAN.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */