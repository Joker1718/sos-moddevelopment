/*     */ package settlement.tilemap.terrain;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.audio.AUDIO;
/*     */ import game.audio.SoundRace;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import settlement.main.SETT;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 167 */   private SoundRace sound = AUDIO.race("CLEAR_TREE");
/*     */ 
/*     */ 
/*     */   
/*     */   public RESOURCE clear1(int tx, int ty) {
/* 172 */     int a = (TForest.Tree.access$0(TForest.Tree.this)).amount.get(tx, ty);
/* 173 */     if (a > 0) {
/*     */       
/* 175 */       if (a == 1) {
/* 176 */         (SETT.TERRAIN()).DECOR_WOOD.placeFixed(tx, ty);
/* 177 */         return RESOURCES.WOOD();
/*     */       } 
/* 179 */       (TForest.Tree.access$0(TForest.Tree.this)).amount.increment(tx, ty, -1);
/*     */     } else {
/* 181 */       GAME.Notify("what??? " + tx + " " + ty + " " + a);
/*     */     } 
/*     */     
/* 184 */     (TForest.Tree.access$0(TForest.Tree.this)).clearAm += 0.25D;
/* 185 */     if ((TForest.Tree.access$0(TForest.Tree.this)).clearAm >= 1.0D) {
/* 186 */       return RESOURCES.WOOD();
/*     */     }
/* 188 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean can() {
/* 193 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int clearAll(int tx, int ty) {
/* 198 */     int a = (TForest.Tree.access$0(TForest.Tree.this)).amount.get(tx, ty);
/* 199 */     (SETT.TERRAIN()).NADA.placeFixed(tx, ty);
/* 200 */     return a;
/*     */   }
/*     */ 
/*     */   
/*     */   public SoundRace sound(int tx, int ty) {
/* 205 */     return this.sound;
/*     */   }
/*     */ 
/*     */   
/*     */   public double strength() {
/* 210 */     return super.strength() * 4.0D;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\terrain\TForest$Tree$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */