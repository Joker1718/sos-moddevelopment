/*     */ package settlement.thing.projectiles;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import snake2d.util.file.Alloc;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 271 */     file.i(PData.this.activeLast);
/* 272 */     for (int i = 0; i < PData.this.activeLast; i++) {
/* 273 */       file.s(PData.this.type[i]);
/* 274 */       file.f(PData.this.ref[i]);
/* 275 */       file.i(PData.this.shooter[i]);
/*     */     } 
/* 277 */     int am = PData.this.activeLast * PData.SPACESIZE;
/* 278 */     for (int j = 0; j < am; j++) {
/* 279 */       file.f(PData.this.space[j]);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/* 286 */     PData.this.activeLast = file.i();
/* 287 */     int l = (int)Math.ceil((PData.this.activeLast + 1) / 32768.0D);
/* 288 */     PData.this.space = new float[l * 32768 * PData.SPACESIZE];
/* 289 */     PData.this.next = Alloc.ii(l * 32768);
/* 290 */     PData.this.type = new short[l * 32768];
/* 291 */     PData.this.ref = new float[l * 32768];
/* 292 */     PData.this.shooter = Alloc.ii(l * 32768);
/* 293 */     int MZ = Projectile.ALL.size();
/* 294 */     for (int i = 0; i < PData.this.activeLast; i++) {
/* 295 */       PData.this.type[i] = file.s();
/* 296 */       if (PData.this.type[i] >= MZ)
/* 297 */         PData.this.type[i] = (short)(MZ - 1); 
/* 298 */       PData.this.ref[i] = file.f();
/* 299 */       PData.this.shooter[i] = file.i();
/*     */     } 
/* 301 */     int am = PData.this.activeLast * PData.SPACESIZE; int j;
/* 302 */     for (j = 0; j < am; j++) {
/* 303 */       PData.this.space[j] = file.f();
/*     */     }
/* 305 */     Arrays.fill(PData.this.next, -1);
/* 306 */     for (j = 0; j < PData.this.last(); j++) {
/* 307 */       PData.this.map.add(j);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 313 */     PData.this.space = new float[32768 * PData.SPACESIZE];
/* 314 */     PData.this.next = Alloc.ii(32768);
/* 315 */     Arrays.fill(PData.this.next, -1);
/* 316 */     PData.this.type = new short[32768];
/* 317 */     PData.this.ref = new float[32768];
/* 318 */     PData.this.shooter = Alloc.ii(32768);
/* 319 */     Arrays.fill(PData.this.shooter, -1);
/* 320 */     PData.this.activeLast = 0;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\projectiles\PData$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */