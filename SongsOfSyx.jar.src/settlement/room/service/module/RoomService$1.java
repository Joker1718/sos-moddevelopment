/*    */ package settlement.room.service.module;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
/*    */ import snake2d.util.file.SAVABLE;
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
/*    */   implements SAVABLE
/*    */ {
/*    */   public void save(FilePutter file) {
/* 69 */     file.i(RoomService.this.available);
/* 70 */     file.i(RoomService.this.total);
/* 71 */     file.d(RoomService.this.load);
/* 72 */     file.d(RoomService.this.loadLast);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void load(FileGetter file) throws IOException {
/* 78 */     RoomService.this.available = file.i();
/* 79 */     RoomService.this.total = file.i();
/* 80 */     RoomService.this.load = file.d();
/* 81 */     RoomService.this.loadLast = file.d();
/*    */   }
/*    */ 
/*    */   
/*    */   public void clear() {
/* 86 */     RoomService.this.available = 0;
/* 87 */     RoomService.this.total = 0;
/* 88 */     RoomService.this.load = 0.0D;
/* 89 */     RoomService.this.loadLast = 0.0D;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\module\RoomService$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */