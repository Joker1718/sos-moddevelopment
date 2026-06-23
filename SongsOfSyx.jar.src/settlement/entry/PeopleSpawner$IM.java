/*     */ package settlement.entry;
/*     */ 
/*     */ import init.type.HTYPE;
/*     */ import init.type.HTYPES;
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
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
/*     */ class IM
/*     */   implements SAVABLE, INT_O.INT_OE<HTYPE>
/*     */ {
/*     */   private int tot;
/* 176 */   private final int[] pam = Alloc.ii(HTYPES.ALL().size());
/*     */ 
/*     */   
/*     */   public void save(FilePutter file) {
/* 180 */     HTYPES.MAP().saver().save(this.pam, file);
/*     */   }
/*     */ 
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/* 185 */     HTYPES.MAP().loader().load(this.pam, file, 0);
/* 186 */     this.tot = 0; byte b; int i, arrayOfInt[];
/* 187 */     for (i = (arrayOfInt = this.pam).length, b = 0; b < i; ) { int j = arrayOfInt[b];
/* 188 */       this.tot += j;
/*     */       b++; }
/*     */   
/*     */   }
/*     */   public void clear() {
/* 193 */     this.tot = 0;
/* 194 */     Arrays.fill(this.pam, 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public int get(HTYPE t) {
/* 199 */     if (t == null)
/* 200 */       return this.tot; 
/* 201 */     return this.pam[t.index()];
/*     */   }
/*     */ 
/*     */   
/*     */   public int min(HTYPE t) {
/* 206 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int max(HTYPE t) {
/* 211 */     return Integer.MAX_VALUE;
/*     */   }
/*     */ 
/*     */   
/*     */   public void set(HTYPE t, int i) {
/* 216 */     this.tot -= this.pam[t.index()];
/* 217 */     this.pam[t.index()] = i;
/* 218 */     this.tot += this.pam[t.index()];
/*     */   }
/*     */   
/*     */   public int tot() {
/* 222 */     return this.tot;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entry\PeopleSpawner$IM.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */