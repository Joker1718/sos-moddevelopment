/*     */ package settlement.tilemap.terrain;
/*     */ 
/*     */ import game.audio.SoundRace;
/*     */ import init.resources.RESOURCE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   public boolean can() {
/*  78 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean needs() {
/*  83 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public RESOURCE clear1(int tx, int ty) {
/*  88 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canDestroy(int tx, int ty) {
/*  93 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void destroy(int tx, int ty) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public double strength() {
/* 104 */     return 0.0D;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int clearAll(int tx, int ty) {
/* 111 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public SoundRace sound(int tx, int ty) {
/* 116 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isStructure() {
/* 121 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEasilyCleared() {
/* 126 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\terrain\TerrainClearing$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */