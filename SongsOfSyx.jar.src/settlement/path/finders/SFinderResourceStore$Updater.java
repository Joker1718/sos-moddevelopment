/*     */ package settlement.path.finders;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.components.SCompNLevel;
/*     */ import settlement.path.components.SComponent;
/*     */ import snake2d.util.sets.Bitmap1D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class Updater
/*     */ {
/* 156 */   private final Bitmap1D tryShort = new Bitmap1D(32767, false);
/*     */   
/* 158 */   private final double speed = 0.015625D;
/* 159 */   double ci = 0.0D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void update(double ds) {
/* 166 */     int old = (int)this.ci;
/* 167 */     int max = ((SCompNLevel)(SETT.PATH()).comps.levels.get(0)).componentsMax();
/* 168 */     if (max <= 0)
/*     */       return; 
/* 170 */     this.ci += ds * max * 0.015625D;
/* 171 */     int now = (int)this.ci;
/* 172 */     int delt = old - now;
/*     */     
/* 174 */     if (this.ci >= max) {
/* 175 */       this.ci -= max;
/*     */     }
/*     */     
/* 178 */     for (int k = 0; k <= delt; k++) {
/* 179 */       int i = k + old;
/* 180 */       i %= max;
/* 181 */       this.tryShort.set(i, false);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean tryShort(int tx, int ty) {
/* 187 */     SComponent c = ((SCompNLevel)(SETT.PATH()).comps.levels.get(0)).get(tx, ty);
/* 188 */     if (c == null)
/* 189 */       return false; 
/* 190 */     if (this.tryShort.get(c.index()))
/* 191 */       return false; 
/* 192 */     return true;
/*     */   }
/*     */   
/*     */   public void failShort(int tx, int ty) {
/* 196 */     SComponent c = ((SCompNLevel)(SETT.PATH()).comps.levels.get(0)).get(tx, ty);
/* 197 */     if (c == null)
/*     */       return; 
/* 199 */     this.tryShort.set(c.index(), true);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\finders\SFinderResourceStore$Updater.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */