/*     */ package settlement.recipe;
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
/*     */ class null
/*     */   implements SAVABLE
/*     */ {
/*     */   public void save(FilePutter file) {
/*  89 */     file.i(RecipeRatesPlayer.this.boData.size());
/*  90 */     for (RecipeRatesPlayer.Data d : RecipeRatesPlayer.this.boData) {
/*  91 */       file.d(d.prev);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/*  97 */     int am = file.i();
/*  98 */     for (int i = 0; i < am; i++)
/*  99 */       ((RecipeRatesPlayer.Data)RecipeRatesPlayer.this.boData.getC(i)).prev = file.d(); 
/* 100 */     RecipeRatesPlayer.this.tt = 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 105 */     for (RecipeRatesPlayer.Data d : RecipeRatesPlayer.this.boData) {
/* 106 */       d.prev = -1.0D;
/* 107 */       d.am = 0;
/* 108 */       d.mul = 0.0D;
/*     */     } 
/* 110 */     RecipeRatesPlayer.this.tt = 0;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\recipe\RecipeRatesPlayer$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */