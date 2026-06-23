/*     */ package settlement.room.main.employment;
/*     */ 
/*     */ import init.type.WGROUP;
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import util.data.INT_O;
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
/*     */ public class GRoupInt
/*     */   implements INT_O.INT_OE<WGROUP>
/*     */ {
/*     */   private int total;
/* 199 */   private final int[] racePrio = Alloc.ii(WGROUP.all().size());
/*     */   private final int min;
/*     */   private final int max;
/*     */   
/*     */   public GRoupInt(int min, int max) {
/* 204 */     this.min = min;
/* 205 */     this.max = max;
/*     */   }
/*     */   
/*     */   void save(FilePutter file) {
/* 209 */     file.is(this.racePrio);
/* 210 */     file.i(this.total);
/*     */   }
/*     */   
/*     */   void load(FileGetter file) throws IOException {
/* 214 */     file.is(this.racePrio);
/* 215 */     this.total = file.i();
/*     */   }
/*     */   
/*     */   void clear() {
/* 219 */     Arrays.fill(this.racePrio, 0);
/* 220 */     this.total = 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int max(WGROUP t) {
/* 225 */     return this.max;
/*     */   }
/*     */ 
/*     */   
/*     */   public int min(WGROUP t) {
/* 230 */     return this.min;
/*     */   }
/*     */ 
/*     */   
/*     */   public int get(WGROUP t) {
/* 235 */     if (t == null)
/* 236 */       return this.total; 
/* 237 */     return this.racePrio[t.index()];
/*     */   }
/*     */ 
/*     */   
/*     */   public void set(WGROUP t, int i) {
/* 242 */     i = CLAMP.i(i, min(t), max(t));
/* 243 */     if (this.racePrio[t.index()] != i) {
/*     */       
/* 245 */       this.total -= this.racePrio[t.index()];
/* 246 */       this.racePrio[t.index()] = i;
/* 247 */       this.total += this.racePrio[t.index()];
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\employment\RoomEmployment$GRoupInt.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */