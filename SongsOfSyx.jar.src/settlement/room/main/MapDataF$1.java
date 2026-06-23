/*    */ package settlement.room.main;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import settlement.main.SETT;
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
/*    */ class null
/*    */   implements SAVABLE
/*    */ {
/*    */   public void save(FilePutter file) {
/* 53 */     file.bs(MapDataF.this.itemI);
/* 54 */     file.bs(MapDataF.this.tileI);
/* 55 */     file.bs(MapDataF.this.spriteDataI);
/* 56 */     file.bs(MapDataF.this.spriteDataI2);
/* 57 */     MapDataF.this.masterTileI.save(file);
/* 58 */     MapDataF.this.candleI.save(file);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void load(FileGetter file) throws IOException {
/* 64 */     file.bs(MapDataF.this.itemI);
/* 65 */     file.bs(MapDataF.this.tileI);
/* 66 */     file.bs(MapDataF.this.spriteDataI);
/* 67 */     file.bs(MapDataF.this.spriteDataI2);
/* 68 */     MapDataF.this.masterTileI.load(file);
/* 69 */     MapDataF.this.candleI.load(file);
/*    */   }
/*    */ 
/*    */   
/*    */   public void clear() {
/* 74 */     for (int i = 0; i < SETT.TAREA; i++) {
/* 75 */       MapDataF.this.itemI[i] = 0;
/* 76 */       MapDataF.this.tileI[i] = 0;
/*    */     } 
/* 78 */     MapDataF.this.masterTileI.setAll(false);
/* 79 */     MapDataF.this.candleI.setAll(false);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\MapDataF$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */