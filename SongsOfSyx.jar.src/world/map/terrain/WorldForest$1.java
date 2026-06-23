/*     */ package world.map.terrain;
/*     */ 
/*     */ import snake2d.util.map.MAP_DOUBLEE;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import world.WORLD;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   implements MAP_DOUBLEE
/*     */ {
/*  87 */   private final double amI = 0.3333333333333333D;
/*     */ 
/*     */   
/*     */   public double get(int tile) {
/*  91 */     return WorldForest.this.data.get(tile) * 0.3333333333333333D;
/*     */   }
/*     */ 
/*     */   
/*     */   public double get(int tx, int ty) {
/*  96 */     if (WORLD.IN_BOUNDS(tx, ty))
/*  97 */       return get(tx + ty * WORLD.TWIDTH()); 
/*  98 */     return 0.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public MAP_DOUBLEE set(int tile, double value) {
/* 103 */     WorldForest.this.data.set(tile, CLAMP.i((int)Math.ceil(value * 3.0D), 0, 3));
/* 104 */     WORLD.changeTile(tile % WORLD.TWIDTH(), tile / WORLD.TWIDTH());
/* 105 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public MAP_DOUBLEE set(int tx, int ty, double value) {
/* 110 */     if (WORLD.IN_BOUNDS(tx, ty))
/* 111 */       set(tx + ty * WORLD.TWIDTH(), value); 
/* 112 */     return this;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\terrain\WorldForest$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */