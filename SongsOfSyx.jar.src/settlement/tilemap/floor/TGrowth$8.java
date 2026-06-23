/*     */ package settlement.tilemap.floor;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import settlement.tilemap.terrain.TGrowable;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.LISTE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends TGrowth.Grower
/*     */ {
/*     */   null(LISTE<TGrowth.Grower> $anonymous0) {
/* 209 */     super($anonymous0);
/*     */   }
/*     */ 
/*     */   
/*     */   void grow(int tx, int ty, double max) {
/* 214 */     if (max <= 0.0D)
/*     */       return; 
/* 216 */     if ((SETT.TERRAIN()).NADA.is(tx, ty) && RND.oneIn(16)) {
/* 217 */       g.placeFixed(tx, ty);
/*     */     }
/* 219 */     else if (g.is(tx, ty) && RND.oneIn(2)) {
/* 220 */       int s = g.size.get(tx, ty);
/* 221 */       if (TGrowth.this.max_amount.get(tx, ty) > s)
/* 222 */         g.size.increment(tx, ty, 1); 
/* 223 */       if (!(SETT.WEATHER()).growthRipe.cropsAreRipe()) {
/* 224 */         int am = g.resource.get(tx, ty);
/* 225 */         if (am < s) {
/* 226 */           am += 1 + (RND.oneIn(s) ? 0 : 1);
/* 227 */           g.resource.set(tx, ty, am);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public double currentAmount(int tx, int ty) {
/* 235 */     return g.size.DM.get(tx, ty);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRoots(int tx, int ty, double amount) {
/* 242 */     int am = CLAMP.i((int)(g.size.max * amount), 1, g.size.max);
/* 243 */     g.placeRaw(tx, ty);
/* 244 */     g.size.set(tx, ty, am);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\floor\TGrowth$8.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */