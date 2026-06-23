/*     */ package settlement.tilemap.floor;
/*     */ 
/*     */ import snake2d.util.sets.Bitsmap1D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends Bitsmap1D
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   
/*     */   null(int $anonymous0, int $anonymous1, int $anonymous2) {
/*  98 */     super($anonymous0, $anonymous1, $anonymous2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void set(int index, int value) {
/* 107 */     Floors.Floor f = (Floors.Floor)Floors.this.getter.get(index);
/* 108 */     if (f != null)
/* 109 */       f.amount--; 
/* 110 */     super.set(index, value);
/* 111 */     f = (Floors.Floor)Floors.this.getter.get(index);
/* 112 */     if (f != null)
/* 113 */       f.amount++; 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\floor\Floors$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */