/*     */ package settlement.environment;
/*     */ 
/*     */ import init.paths.PATH;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.tilemap.terrain.Terrain;
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
/*     */ class null
/*     */   extends SettEnvMap.SettEnv
/*     */ {
/*     */   null(LISTE<SettEnvMap.Updatable> $anonymous0, LISTE<SettEnvMap.SettEnv> $anonymous1, String $anonymous2, PATH $anonymous3, PATH $anonymous4, int $anonymous5, EUpdater $anonymous6) throws IOException {
/* 141 */     super($anonymous0, $anonymous1, $anonymous2, $anonymous3, $anonymous4, $anonymous5, $anonymous6);
/*     */   }
/*     */   public double radius() {
/* 144 */     return 0.5D;
/*     */   }
/*     */ 
/*     */   
/*     */   public double getBaseValue(int tx, int ty) {
/* 149 */     if ((SETT.ROOMS()).map.is(tx, ty)) {
/* 150 */       return 1.0D;
/*     */     }
/* 152 */     Terrain.TerrainTile t = SETT.TERRAIN().get(tx, ty);
/*     */     
/* 154 */     if (t.clearing().isStructure()) {
/* 155 */       return 1.0D;
/*     */     }
/*     */     
/* 158 */     if ((SETT.FLOOR()).getter.get(tx, ty) != null)
/* 159 */       return 1.0D; 
/* 160 */     return 0.0D;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\environment\SettEnvMap$5.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */