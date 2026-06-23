/*    */ package settlement.room.main;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.util.Arrays;
/*    */ import settlement.main.SETT;
/*    */ import snake2d.util.file.Alloc;
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
/*    */ public class Data
/*    */   implements MapRoomData, SAVABLE
/*    */ {
/* 23 */   private final int[] dataI = Alloc.ii(SETT.TAREA);
/*    */ 
/*    */   
/*    */   public void save(FilePutter file) {
/* 27 */     file.is(this.dataI);
/*    */   }
/*    */ 
/*    */   
/*    */   public void load(FileGetter file) throws IOException {
/* 32 */     file.is(this.dataI);
/*    */   }
/*    */ 
/*    */   
/*    */   public void clear() {
/* 37 */     Arrays.fill(this.dataI, 0);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int get(int tx, int ty) {
/* 43 */     if (SETT.IN_BOUNDS(tx, ty))
/* 44 */       return get(tx + ty * SETT.TWIDTH); 
/* 45 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public int get(int tile) {
/* 50 */     return this.dataI[tile];
/*    */   }
/*    */ 
/*    */   
/*    */   public void set(ROOMA r, int tile, int value) {
/* 55 */     if (!r.is(tile))
/* 56 */       throw new RuntimeException(String.valueOf(r) + " " + String.valueOf(r) + " " + tile % SETT.TWIDTH + " " + tile / SETT.TWIDTH); 
/* 57 */     this.dataI[tile] = value;
/*    */   }
/*    */   
/*    */   void set(int tile, int value) {
/* 61 */     this.dataI[tile] = value;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\MapRoomData$Data.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */