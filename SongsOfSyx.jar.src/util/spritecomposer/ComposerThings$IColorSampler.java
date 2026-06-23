/*     */ package util.spritecomposer;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.nio.file.Path;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class IColorSampler
/*     */ {
/*     */   protected IColorSampler() {}
/*     */   
/*     */   protected IColorSampler(Path path, int width, int height) throws IOException {
/* 337 */     Resources.c.setSource(path, width, height);
/*     */   }
/*     */   
/*     */   static COLOR save(int c) {
/* 341 */     int r = c >> 24 & 0xFF;
/* 342 */     int g = c >> 16 & 0xFF;
/* 343 */     int b = c >> 8 & 0xFF;
/* 344 */     Resources.p.i(r);
/* 345 */     Resources.p.i(g);
/* 346 */     Resources.p.i(b);
/* 347 */     return (COLOR)new ColorImp(r, g, b);
/*     */   }
/*     */ 
/*     */   
/*     */   public LIST<COLOR> get() throws IOException {
/* 352 */     if (Resources.g == null) {
/* 353 */       Resources.p.mark("color list");
/* 354 */       int j = init(Resources.c, Resources.sources, Resources.dests);
/* 355 */       Resources.p.i(j);
/* 356 */       ArrayList<COLOR> arrayList = new ArrayList(j);
/* 357 */       for (int k = 0; k < j; k++) {
/* 358 */         arrayList.add(next(k, Resources.c, Resources.sources, Resources.dests));
/*     */       }
/* 360 */       Resources.p.mark("list");
/* 361 */       return (LIST<COLOR>)arrayList;
/*     */     } 
/* 363 */     Resources.g.check("color list");
/* 364 */     int a = Resources.g.i();
/* 365 */     ArrayList<COLOR> res = new ArrayList(a);
/* 366 */     for (int i = 0; i < a; i++) {
/* 367 */       res.add(new ColorImp(Resources.g.i(), Resources.g.i(), Resources.g.i()));
/*     */     }
/* 369 */     Resources.g.check("list");
/* 370 */     return (LIST<COLOR>)res;
/*     */   }
/*     */   
/*     */   public LIST<COLOR> getHalf() throws IOException {
/* 374 */     if (Resources.g == null) {
/* 375 */       Resources.p.mark("color list");
/* 376 */       int j = init(Resources.c, Resources.sources, Resources.dests);
/* 377 */       Resources.p.i(j);
/* 378 */       ArrayList<COLOR> arrayList = new ArrayList(j);
/* 379 */       for (int k = 0; k < j; k++) {
/* 380 */         arrayList.add(next(k, Resources.c, Resources.sources, Resources.dests).shade(0.5D));
/*     */       }
/* 382 */       Resources.p.mark("list");
/* 383 */       return (LIST<COLOR>)arrayList;
/*     */     } 
/* 385 */     Resources.g.check("color list");
/* 386 */     int a = Resources.g.i();
/* 387 */     ArrayList<COLOR> res = new ArrayList(a);
/* 388 */     for (int i = 0; i < a; i++) {
/* 389 */       res.add(new ColorImp(Resources.g.i() / 2, Resources.g.i() / 2, Resources.g.i() / 2));
/*     */     }
/* 391 */     Resources.g.check("list");
/* 392 */     return (LIST<COLOR>)res;
/*     */   }
/*     */   
/*     */   protected abstract int init(ComposerUtil paramComposerUtil, ComposerSources paramComposerSources, ComposerDests paramComposerDests);
/*     */   
/*     */   protected abstract COLOR next(int paramInt, ComposerUtil paramComposerUtil, ComposerSources paramComposerSources, ComposerDests paramComposerDests);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\spritecomposer\ComposerThings$IColorSampler.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */