/*     */ package settlement.weather;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   implements SAVABLE
/*     */ {
/*     */   public void save(FilePutter file) {
/* 102 */     file.d(RainEvent.this.downfall);
/* 103 */     file.d(RainEvent.this.time);
/* 104 */     file.d(RainEvent.this.thunder);
/* 105 */     file.d(RainEvent.this.cloud);
/* 106 */     file.d(RainEvent.this.timeToNext);
/* 107 */     file.d(RainEvent.this.droughtNext);
/* 108 */     file.d(RainEvent.this.droughtLength);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/* 114 */     RainEvent.this.downfall = file.d();
/* 115 */     RainEvent.this.time = file.d();
/* 116 */     RainEvent.this.thunder = file.d();
/* 117 */     RainEvent.this.cloud = file.d();
/* 118 */     RainEvent.this.timeToNext = file.d();
/* 119 */     RainEvent.this.droughtNext = file.d();
/* 120 */     RainEvent.this.droughtLength = file.d();
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 125 */     RainEvent.this.time = 0.0D;
/* 126 */     RainEvent.this.setNextRain();
/* 127 */     RainEvent.this.setNextDrought(5);
/* 128 */     RainEvent.this.timeToNext /= 2.0D;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\weather\RainEvent$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */