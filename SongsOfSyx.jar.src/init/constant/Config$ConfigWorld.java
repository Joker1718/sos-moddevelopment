/*    */ package init.constant;
/*    */ 
/*    */ import init.paths.PATHS;
/*    */ import snake2d.util.file.Json;
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
/*    */ public final class ConfigWorld
/*    */ {
/* 87 */   public final int POPULATION_CAPACITY_MAX = Config.j.i("POPULATION_CAPACITY_MAX", 1, 100000);
/* 88 */   public final int WORLD_SIZE = Config.j.i("TILE_DIMENSION", 128, 512);
/* 89 */   public final double FOREST_AMOUNT = Config.j.d("FOREST_AMOUNT", 0.0D, 1.0D);
/* 90 */   public final double REGION_SIZE = Config.j.i("REGION_SIZE", 0, 1000);
/*    */ 
/*    */ 
/*    */   
/*    */   public static Json json(String resource) {
/* 95 */     return new Json((PATHS.WORLD().folder("config")).init.gets(resource));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\constant\Config$ConfigWorld.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */