/*    */ package settlement.room.spirit.dump;
/*    */ 
/*    */ import init.type.NEED;
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
/*    */ import settlement.thing.ThingsCorpses;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
/*    */ import util.text.D;
/*    */ 
/*    */ public class ROOM_DUMP extends RoomBlueprintIns<DumpInstance> implements RoomService.ROOM_SERVICE_HASER {
/*    */   final Constructor constructor;
/*    */   final RoomService service;
/* 22 */   public static CharSequence ¤¤RemoveProblem = "¤This resting place still holds the dead and can not be removed. Deactivate the room and allow the corpses to decompose peacefully. Current cadavers: {0}. Days until clear: {1}.";
/*    */   
/*    */   static {
/* 25 */     D.ts(ROOM_DUMP.class);
/*    */   }
/*    */   
/*    */   public ROOM_DUMP(RoomInitData data, RoomCategorySub cat) throws IOException {
/* 29 */     super(0, data, "_DUMP_CORPSE", cat);
/* 30 */     this.constructor = new Constructor(this, data);
/* 31 */     this.service = new RoomService((RoomBlueprintImp)this, data, null)
/*    */       {
/*    */         public FSERVICE service(int tx, int ty)
/*    */         {
/* 35 */           return Dump.get(tx, ty);
/*    */         }
/*    */       };
/*    */   }
/*    */ 
/*    */   
/*    */   protected void saveP(FilePutter saveFile) {
/* 42 */     this.service.saver.save(saveFile);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void loadP(FileGetter saveFile) throws IOException {
/* 48 */     this.service.saver.load(saveFile);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void clearP() {
/* 54 */     this.service.saver.clear();
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
/* 65 */     return this.service.finder;
/*    */   }
/*    */ 
/*    */   
/*    */   public RoomService service() {
/* 70 */     return this.service;
/*    */   }
/*    */ 
/*    */   
/*    */   public Furnisher constructor() {
/* 75 */     return this.constructor;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void burry(ThingsCorpses.Corpse corpse, int tx, int ty) {
/* 81 */     Dump.get(tx, ty).burry(corpse);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\spirit\dump\ROOM_DUMP.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */