/*    */ package settlement.room.home.chamber;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import settlement.path.finders.SFinderFindable;
/*    */ import settlement.room.main.RoomBlueprintIns;
/*    */ import settlement.room.main.category.RoomCategorySub;
/*    */ import settlement.room.main.furnisher.Furnisher;
/*    */ import settlement.room.main.util.RoomInitData;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
/*    */ import snake2d.util.sets.LISTE;
/*    */ import view.sett.ui.room.UIRoomModule;
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class ROOM_CHAMBER
/*    */   extends RoomBlueprintIns<ChamberInstance>
/*    */ {
/*    */   final Constructor constructor;
/*    */   final Work work;
/*    */   
/*    */   public ROOM_CHAMBER(RoomInitData init, RoomCategorySub block) throws IOException {
/* 24 */     super(0, init, "_HOME_CHAMBER", block);
/* 25 */     this.work = new Work(this);
/* 26 */     this.constructor = new Constructor(this, init);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void update(double ds) {}
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Furnisher constructor() {
/* 38 */     return this.constructor;
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
/*    */   
/*    */   protected void clearP() {}
/*    */ 
/*    */ 
/*    */   
/*    */   public void appendView(LISTE<UIRoomModule> mm) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public int getSleepPixelX(int tx, int ty) {
/* 63 */     DIR d = ((DIR)DIR.ALL.get(((ChamberInstance)get(tx, ty)).sleepDir)).next(-1);
/* 64 */     int x = tx * 64 + 32;
/* 65 */     x += d.x() * 32;
/* 66 */     return x;
/*    */   }
/*    */   
/*    */   public int getSleepPixelY(int tx, int ty) {
/* 70 */     DIR d = ((DIR)DIR.ALL.get(((ChamberInstance)get(tx, ty)).sleepDir)).next(-1);
/* 71 */     int y = ty * 64 + 32;
/* 72 */     y += d.y() * 32;
/* 73 */     return y;
/*    */   }
/*    */   
/*    */   public DIR getSleepDir(int tx, int ty) {
/* 77 */     DIR d = ((DIR)DIR.ALL.get(((ChamberInstance)get(tx, ty)).sleepDir)).perpendicular();
/* 78 */     return d;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public SFinderFindable service(int tx, int ty) {
/* 84 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean degrades() {
/* 89 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\home\chamber\ROOM_CHAMBER.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */