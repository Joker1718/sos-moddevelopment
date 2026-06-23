/*    */ package world.map.regions;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
/*    */ import snake2d.util.file.SAVABLE;
/*    */ import snake2d.util.map.MAP_OBJECTE;
/*    */ import snake2d.util.sets.Bitsmap1D;
/*    */ import world.WORLD;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class RegionMap
/*    */   implements MAP_OBJECTE<Region>, SAVABLE
/*    */ {
/* 19 */   private final Bitsmap1D mapID = new Bitsmap1D(0, Integer.numberOfTrailingZeros(1024), WORLD.TAREA());
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Region get(int tile) {
/* 28 */     if (this.mapID.get(tile) == 0)
/* 29 */       return null; 
/* 30 */     return WORLD.REGIONS().getByIndex(this.mapID.get(tile) - 1);
/*    */   }
/*    */ 
/*    */   
/*    */   public Region get(int tx, int ty) {
/* 35 */     if (WORLD.IN_BOUNDS(tx, ty))
/* 36 */       return get(tx + ty * WORLD.TWIDTH()); 
/* 37 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public void set(int tile, Region object) {
/* 42 */     if (object == null) {
/* 43 */       this.mapID.set(tile, 0);
/*    */     } else {
/* 45 */       this.mapID.set(tile, object.index() + 1);
/* 46 */     }  (WORLD.REGIONS()).dirty = true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void set(int tx, int ty, Region object) {
/* 51 */     if (WORLD.IN_BOUNDS(tx, ty)) {
/* 52 */       set(tx + ty * WORLD.TWIDTH(), object);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void save(FilePutter file) {
/* 58 */     this.mapID.save(file);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void load(FileGetter file) throws IOException {
/* 64 */     this.mapID.load(file);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void clear() {
/* 70 */     this.mapID.clear();
/* 71 */     (WORLD.REGIONS()).dirty = true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\regions\RegionMap.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */