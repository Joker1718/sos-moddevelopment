/*    */ package settlement.environment;
/*    */ 
/*    */ import init.paths.PATH;
/*    */ import java.io.IOException;
/*    */ import settlement.main.SETT;
/*    */ import snake2d.util.sets.LISTE;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends SettEnvMap.SettEnv
/*    */ {
/*    */   null(LISTE<SettEnvMap.Updatable> $anonymous0, LISTE<SettEnvMap.SettEnv> $anonymous1, String $anonymous2, PATH $anonymous3, PATH $anonymous4, int $anonymous5, EUpdater $anonymous6) throws IOException {
/* 91 */     super($anonymous0, $anonymous1, $anonymous2, $anonymous3, $anonymous4, $anonymous5, $anonymous6);
/*    */   }
/*    */   
/*    */   public double getCost(int toX, int toY) {
/* 95 */     if (SETT.LIGHTS().los().get(toX, toY).blocksEnv(toX, toY))
/* 96 */       return 8.0D; 
/* 97 */     if (SETT.TERRAIN().get(toX, toY).roofIs())
/* 98 */       return 3.0D; 
/* 99 */     return 1.0D;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\environment\SettEnvMap$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */