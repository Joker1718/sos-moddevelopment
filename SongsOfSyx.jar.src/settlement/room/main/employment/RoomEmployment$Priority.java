/*     */ package settlement.room.main.employment;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import util.data.DOUBLE;
/*     */ import util.data.INT;
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
/*     */ public class Priority
/*     */   implements INT.INTE
/*     */ {
/*     */   final RoomEmployment p;
/* 152 */   private int prio = 10;
/*     */   
/*     */   public Priority(RoomEmployment p) {
/* 155 */     this.p = p;
/*     */   }
/*     */   
/*     */   void save(FilePutter file) {
/* 159 */     file.i(this.prio);
/*     */   }
/*     */   
/*     */   void load(FileGetter file) throws IOException {
/* 163 */     this.prio = file.i();
/*     */   }
/*     */   
/*     */   void clear() {
/* 167 */     this.prio = 10;
/*     */   }
/*     */ 
/*     */   
/*     */   public int max() {
/* 172 */     return 30;
/*     */   }
/*     */ 
/*     */   
/*     */   public int min() {
/* 177 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int get() {
/* 182 */     return this.prio;
/*     */   }
/*     */ 
/*     */   
/*     */   public void set(int i) {
/* 187 */     i = CLAMP.i(i, min(), max());
/* 188 */     if (this.prio != i) {
/* 189 */       this.prio = i;
/* 190 */       (SETT.ROOMS()).employment.employer.updateAll();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\employment\RoomEmployment$Priority.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */