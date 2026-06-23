/*     */ package settlement.environment;
/*     */ 
/*     */ import init.paths.PATH;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
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
/*     */ class null
/*     */   extends SettEnvMap.SettEnv
/*     */ {
/*     */   null(LISTE<SettEnvMap.Updatable> $anonymous0, LISTE<SettEnvMap.SettEnv> $anonymous1, String $anonymous2, PATH $anonymous3, PATH $anonymous4, int $anonymous5, EUpdater $anonymous6) throws IOException {
/* 112 */     super($anonymous0, $anonymous1, $anonymous2, $anonymous3, $anonymous4, $anonymous5, $anonymous6);
/*     */   }
/*     */   
/*     */   public double getCost(int toX, int toY) {
/* 116 */     return 1.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public double get(int tile) {
/* 121 */     return 1.0D - super.get(tile);
/*     */   }
/*     */ 
/*     */   
/*     */   public double getBaseValue(int tx, int ty) {
/* 126 */     return (((SETT.PATH()).availability.get(tx, ty)).tileCollide ? true : false);
/*     */   }
/*     */ 
/*     */   
/*     */   public double radius() {
/* 131 */     return 0.5D;
/*     */   }
/*     */ 
/*     */   
/*     */   double getRadius(int tx, int ty) {
/* 136 */     return 0.5D;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\environment\SettEnvMap$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */