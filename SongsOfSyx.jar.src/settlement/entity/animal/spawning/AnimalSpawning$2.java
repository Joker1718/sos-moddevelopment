/*    */ package settlement.entity.animal.spawning;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.util.Arrays;
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
/* 64 */     for (AnimalSpawnSpot s : AnimalSpawning.this.spots)
/* 65 */       s.save(file); 
/* 66 */     AnimalSpawning.this.uper.save(file);
/* 67 */     (SETT.ANIMALS()).map.saver().save(AnimalSpawning.this.killed, file);
/*    */   }
/*    */ 
/*    */   
/*    */   public void load(FileGetter file) throws IOException {
/* 72 */     clear();
/* 73 */     for (AnimalSpawnSpot s : AnimalSpawning.this.spots) {
/* 74 */       s.load(file);
/* 75 */       AnimalSpawning.this.max += s.max();
/*    */     } 
/* 77 */     AnimalSpawning.this.uper.load(file);
/* 78 */     (SETT.ANIMALS()).map.loader().load(AnimalSpawning.this.killed, file, 0.0D);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void clear() {
/* 84 */     for (AnimalSpawnSpot s : AnimalSpawning.this.spots)
/* 85 */       s.clear(); 
/* 86 */     AnimalSpawning.this.uper.clear();
/* 87 */     AnimalSpawning.this.max = 0;
/* 88 */     Arrays.fill(AnimalSpawning.this.killed, 0.0D);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\animal\spawning\AnimalSpawning$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */