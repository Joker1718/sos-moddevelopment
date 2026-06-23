/*    */ package settlement.room.main.employment;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   implements SAVABLE
/*    */ {
/*    */   public void save(FilePutter file) {
/* 72 */     file.i(RoomEquips.this.ALL.size());
/* 73 */     for (RoomEquip t : RoomEquips.this.ALL) {
/* 74 */       t.saver.save(file);
/*    */     }
/*    */   }
/*    */   
/*    */   public void load(FileGetter file) throws IOException {
/* 79 */     int am = file.i();
/*    */     
/* 81 */     if (am != RoomEquips.this.ALL.size()) {
/* 82 */       for (int i = 0; i < am; i++) {
/* 83 */         ((RoomEquip)RoomEquips.this.ALL.get(0)).saver.load(file);
/*    */       }
/* 85 */       clear();
/*    */     } else {
/* 87 */       for (RoomEquip t : RoomEquips.this.ALL) {
/* 88 */         t.saver.load(file);
/*    */       }
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void clear() {
/* 95 */     for (RoomEquip t : RoomEquips.this.ALL)
/* 96 */       t.saver.clear(); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\employment\RoomEquips$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */