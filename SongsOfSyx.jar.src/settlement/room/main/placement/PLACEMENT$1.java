/*    */ package settlement.room.main.placement;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import settlement.path.finders.SFinderFindable;
/*    */ import settlement.path.finders.SFinderRoomService;
/*    */ import settlement.room.main.RoomBlueprint;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.color.ColorImp;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends RoomBlueprint
/*    */ {
/*    */   null(String $anonymous0) {
/* 38 */     super($anonymous0);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void update(double ds) {
/* 44 */     PLACEMENT.this.placer.update(ds);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public SFinderRoomService service(int tx, int ty) {
/* 50 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void save(FilePutter saveFile) {}
/*    */ 
/*    */ 
/*    */   
/*    */   protected void load(FileGetter saveFile) throws IOException {
/* 61 */     PLACEMENT.this.placer.load();
/* 62 */     PLACEMENT.this.placer.structure.read();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void clear() {
/* 68 */     PLACEMENT.this.placer.init(null, 0);
/*    */   }
/*    */ 
/*    */   
/*    */   public COLOR miniC(int tx, int ty) {
/* 73 */     return COLOR.BLUE50;
/*    */   }
/*    */ 
/*    */   
/*    */   public COLOR miniCPimped(ColorImp origional, int tx, int ty, boolean northern, boolean southern) {
/* 78 */     return (COLOR)origional;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\placement\PLACEMENT$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */