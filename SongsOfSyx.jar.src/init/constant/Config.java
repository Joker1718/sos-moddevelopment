/*    */ package init.constant;
/*    */ 
/*    */ import init.INIT;
/*    */ import init.paths.PATHS;
/*    */ import snake2d.Errors;
/*    */ import snake2d.util.file.Json;
/*    */ 
/*    */ public final class Config
/*    */   extends INIT.InitResource
/*    */ {
/*    */   static {
/* 12 */     if (!PATHS.inited()) {
/* 13 */       throw new RuntimeException("paths must be inited first!");
/*    */     }
/*    */   }
/*    */   
/* 17 */   private static Json j = null;
/*    */   private static ConfigBattle BATTLE;
/*    */   private static ConfigSett SETT;
/*    */   private static ConfigWorld WORLD;
/*    */   
/*    */   public Config(INIT init) {
/* 23 */     super(init);
/* 24 */     if (!PATHS.inited()) {
/* 25 */       throw new RuntimeException("paths must be inited first!");
/*    */     }
/* 27 */     j = new Json((PATHS.CONFIG()).init.gets("Battle"));
/* 28 */     BATTLE = new ConfigBattle();
/* 29 */     j = new Json((PATHS.CONFIG()).init.gets("Sett"));
/* 30 */     SETT = new ConfigSett();
/* 31 */     j = new Json((PATHS.WORLD().folder("config")).init.gets("General"));
/* 32 */     WORLD = new ConfigWorld();
/*    */   }
/*    */   
/*    */   public static ConfigBattle battle() {
/* 36 */     return BATTLE;
/*    */   }
/*    */   
/*    */   public static ConfigSett sett() {
/* 40 */     return SETT;
/*    */   }
/*    */   
/*    */   public static ConfigWorld world() {
/* 44 */     return WORLD;
/*    */   }
/*    */   
/*    */   public static final class ConfigBattle
/*    */   {
/* 49 */     public final double MORALE_HOLDOUT = Config.j.d("MORALE_HOLDOUT", 0.0D, 10000.0D);
/* 50 */     public final int TRAINING_DEGRADE = Config.j.i("TRAINING_DEGRADE", 0, 50);
/* 51 */     public final int MEN_PER_DIVISION = Config.j.i("MEN_PER_DIVISION", 1, 255);
/* 52 */     public final int DIVISIONS_PER_ARMY = Config.j.i("DIVISIONS_PER_ARMY", 1, 126);
/* 53 */     public final int DIVISIONS_PER_BATTLE = this.DIVISIONS_PER_ARMY * 2;
/* 54 */     public final int MEN_PER_ARMY = this.MEN_PER_DIVISION * this.DIVISIONS_PER_ARMY;
/* 55 */     public final int REGION_MAX_DIVS = Config.j.i("REGION_MAX_DIVS", 0, 127);
/* 56 */     public final int REGION_MAX_MEN = this.REGION_MAX_DIVS * this.MEN_PER_DIVISION;
/* 57 */     public final double DAMAGE_REDUCTION = Config.j.d("DAMAGE_REDUCTION", 1.0D, 10000.0D);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static final class ConfigSett
/*    */   {
/* 68 */     public final double HAPPINESS_EXPONENT = Config.j.d("HAPPINESS_EXPONENT");
/* 69 */     public final int TOURIST_PER_YEAR_MAX = Config.j.i("TOURIST_PER_YEAR_MAX");
/* 70 */     public final double TOURIST_CRETIDS = Config.j.d("TOURIST_CRETIDS");
/* 71 */     public final int DIMENSION = Config.j.i("DIMENSION", 256, 16000);
/*    */     
/* 73 */     public final double POP_RAIDER_WORTH = Config.j.i("POP_RAIDER_WORTH", 1, 10000);
/* 74 */     public final int secondsPerHour = Config.j.i("SECONDS_PER_HOUR");
/* 75 */     public final int hoursPerDay = Config.j.i("HOURS_PER_DAY");
/*    */ 
/*    */     
/*    */     ConfigSett() {
/* 79 */       if (this.DIMENSION % 64 != 0) {
/* 80 */         throw new Errors.DataError("SETT DIMENSION MUST BE A MULTIPLE OF 64");
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   public static final class ConfigWorld
/*    */   {
/* 87 */     public final int POPULATION_CAPACITY_MAX = Config.j.i("POPULATION_CAPACITY_MAX", 1, 100000);
/* 88 */     public final int WORLD_SIZE = Config.j.i("TILE_DIMENSION", 128, 512);
/* 89 */     public final double FOREST_AMOUNT = Config.j.d("FOREST_AMOUNT", 0.0D, 1.0D);
/* 90 */     public final double REGION_SIZE = Config.j.i("REGION_SIZE", 0, 1000);
/*    */ 
/*    */ 
/*    */     
/*    */     public static Json json(String resource) {
/* 95 */       return new Json((PATHS.WORLD().folder("config")).init.gets(resource));
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\constant\Config.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */