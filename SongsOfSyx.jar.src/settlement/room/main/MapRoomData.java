/*     */ package settlement.room.main;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.map.MAP_INT;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public interface MapRoomData
/*     */   extends MAP_INT
/*     */ {
/*     */   public static class Data
/*     */     implements MapRoomData, SAVABLE
/*     */   {
/*  23 */     private final int[] dataI = Alloc.ii(SETT.TAREA);
/*     */ 
/*     */     
/*     */     public void save(FilePutter file) {
/*  27 */       file.is(this.dataI);
/*     */     }
/*     */ 
/*     */     
/*     */     public void load(FileGetter file) throws IOException {
/*  32 */       file.is(this.dataI);
/*     */     }
/*     */ 
/*     */     
/*     */     public void clear() {
/*  37 */       Arrays.fill(this.dataI, 0);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int get(int tx, int ty) {
/*  43 */       if (SETT.IN_BOUNDS(tx, ty))
/*  44 */         return get(tx + ty * SETT.TWIDTH); 
/*  45 */       return 0;
/*     */     }
/*     */ 
/*     */     
/*     */     public int get(int tile) {
/*  50 */       return this.dataI[tile];
/*     */     }
/*     */ 
/*     */     
/*     */     public void set(ROOMA r, int tile, int value) {
/*  55 */       if (!r.is(tile))
/*  56 */         throw new RuntimeException(String.valueOf(r) + " " + String.valueOf(r) + " " + tile % SETT.TWIDTH + " " + tile / SETT.TWIDTH); 
/*  57 */       this.dataI[tile] = value;
/*     */     }
/*     */     
/*     */     void set(int tile, int value) {
/*  61 */       this.dataI[tile] = value;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   default void inc(ROOMA r, COORDINATE c, int value) {
/*  67 */     inc(r, c.x(), c.y(), value);
/*     */   }
/*     */   
/*     */   default void inc(ROOMA r, COORDINATE c, DIR d, int value) {
/*  71 */     inc(r, c.x() + d.x(), c.y() + d.y(), value);
/*     */   }
/*     */   
/*     */   default void inc(ROOMA r, int tx, int ty, int value) {
/*  75 */     if (SETT.IN_BOUNDS(tx, ty)) {
/*  76 */       inc(r, tx + ty * SETT.TWIDTH, value);
/*     */     }
/*     */   }
/*     */   
/*     */   default void inc(ROOMA r, int tx, int ty, DIR d, int value) {
/*  81 */     inc(r, tx + d.x(), ty + d.y(), value);
/*     */   }
/*     */   
/*     */   default void inc(ROOMA r, int tile, int value) {
/*  85 */     set(r, tile, get(tile) + value);
/*     */   }
/*     */   
/*     */   default void set(ROOMA r, COORDINATE c, int value) {
/*  89 */     set(r, c.x(), c.y(), value);
/*     */   }
/*     */   
/*     */   default void set(ROOMA r, COORDINATE c, DIR d, int value) {
/*  93 */     set(r, c.x() + d.x(), c.y() + d.y(), value);
/*     */   }
/*     */   
/*     */   default void set(ROOMA r, int tx, int ty, int value) {
/*  97 */     if (SETT.IN_BOUNDS(tx, ty)) {
/*  98 */       set(r, tx + ty * SETT.TWIDTH, value);
/*     */     }
/*     */   }
/*     */   
/*     */   default void set(ROOMA r, int tx, int ty, DIR d, int value) {
/* 103 */     set(r, tx + d.x(), ty + d.y(), value);
/*     */   }
/*     */   
/*     */   void set(ROOMA paramROOMA, int paramInt1, int paramInt2);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\MapRoomData.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */