/*     */ package settlement.misc.util;
/*     */ 
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class Ray
/*     */ {
/*     */   private final COORDINATE[] coos;
/*     */   private final COORDINATE[] tileOff;
/*     */   private final double[] radius;
/*     */   private final double[] area;
/*     */   public final int index;
/*     */   
/*     */   Ray(Ray other, int index) {
/* 207 */     this.index = index;
/* 208 */     this.coos = other.coos;
/* 209 */     this.tileOff = other.tileOff;
/* 210 */     this.radius = other.radius;
/* 211 */     this.area = other.area;
/*     */   }
/*     */   
/*     */   Ray(int size) {
/* 215 */     this.coos = new COORDINATE[size];
/* 216 */     this.tileOff = new COORDINATE[size];
/* 217 */     this.radius = new double[size];
/* 218 */     this.area = new double[size];
/* 219 */     this.index = 0;
/*     */   }
/*     */   
/*     */   public COORDINATE first() {
/* 223 */     return this.coos[0];
/*     */   }
/*     */   
/*     */   public COORDINATE last() {
/* 227 */     return this.coos[this.coos.length - 1];
/*     */   }
/*     */   
/*     */   public int size() {
/* 231 */     return this.coos.length;
/*     */   }
/*     */   
/*     */   public COORDINATE get(int i) {
/* 235 */     return this.coos[i];
/*     */   }
/*     */   
/*     */   public COORDINATE[] coos() {
/* 239 */     return this.coos;
/*     */   }
/*     */   
/*     */   public double radius(int i) {
/* 243 */     return this.radius[i];
/*     */   }
/*     */   
/*     */   public double traverseArea(int i) {
/* 247 */     return 1.0D;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\mis\\util\TileRayTracer$Ray.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */