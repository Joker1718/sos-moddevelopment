/*     */ package settlement.tilemap.terrain;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.audio.AUDIO;
/*     */ import game.audio.SoundRace;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 149 */   private final SoundRace sound = AUDIO.race("CLEAR_MOUNTAIN");
/*     */ 
/*     */   
/*     */   public RESOURCE clear1(int tx, int ty) {
/* 153 */     if (!TMountain.this.is(tx, ty)) {
/* 154 */       GAME.Notify("" + tx + " " + tx);
/* 155 */       return null;
/*     */     } 
/* 157 */     int a = TMountain.this.resourceGet(TMountain.this.shared.data.get(tx, ty));
/* 158 */     RESOURCE res = (a % 4 == 0) ? RESOURCES.STONE() : null;
/* 159 */     a--;
/* 160 */     if (a < 0) {
/* 161 */       TMountain.this.shared.CAVE.placeFixed(tx, ty);
/* 162 */       return res;
/*     */     } 
/* 164 */     a = TMountain.this.resourceSet(TMountain.this.shared.data.get(tx, ty), a);
/* 165 */     TMountain.this.shared.data.set(tx, ty, a);
/*     */     
/* 167 */     return res;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean can() {
/* 172 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int clearAll(int tx, int ty) {
/* 177 */     int a = 1 + TMountain.this.resourceGet(TMountain.this.shared.data.get(tx, ty)) / 4;
/* 178 */     TMountain.this.shared.CAVE.placeFixed(tx, ty);
/* 179 */     return a;
/*     */   }
/*     */ 
/*     */   
/*     */   public SoundRace sound(int tx, int ty) {
/* 184 */     return this.sound;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isStructure() {
/* 189 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canDestroy(int tx, int ty) {
/* 194 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void destroy(int tx, int ty) {
/* 199 */     TMountain.this.shared.CAVE.placeFixed(tx, ty);
/*     */   }
/*     */ 
/*     */   
/*     */   public double strength() {
/* 204 */     return 64000.0D;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\terrain\TMountain$5.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */