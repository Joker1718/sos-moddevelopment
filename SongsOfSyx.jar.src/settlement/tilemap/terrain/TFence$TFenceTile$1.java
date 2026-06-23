/*     */ package settlement.tilemap.terrain;
/*     */ 
/*     */ import game.audio.SoundRace;
/*     */ import init.resources.RESOURCE;
/*     */ import snake2d.util.rnd.RND;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends TerrainClearing
/*     */ {
/*     */   public RESOURCE clear1(int tx, int ty) {
/*  98 */     TFence.TFenceTile.this.shared.NADA.placeFixed(tx, ty);
/*  99 */     return RND.oneIn(3) ? TFence.TFenceTile.this.resource : null;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean can() {
/* 104 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int clearAll(int tx, int ty) {
/* 109 */     TFence.TFenceTile.this.shared.NADA.placeFixed(tx, ty);
/* 110 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public SoundRace sound(int tx, int ty) {
/* 115 */     return TFence.TFenceTile.this.sound;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEasilyCleared() {
/* 120 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isStructure() {
/* 125 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void destroy(int tx, int ty) {
/* 130 */     TFence.TFenceTile.this.shared.DESTROYED.place(tx, ty, TFence.TFenceTile.this, TFence.TFenceTile.this.getDia(tx, ty) ? 1 : 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public double strength() {
/* 135 */     return 640.0D;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\terrain\TFence$TFenceTile$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */