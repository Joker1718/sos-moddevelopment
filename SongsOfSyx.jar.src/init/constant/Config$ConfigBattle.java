/*    */ package init.constant;
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
/*    */ public final class ConfigBattle
/*    */ {
/* 49 */   public final double MORALE_HOLDOUT = Config.j.d("MORALE_HOLDOUT", 0.0D, 10000.0D);
/* 50 */   public final int TRAINING_DEGRADE = Config.j.i("TRAINING_DEGRADE", 0, 50);
/* 51 */   public final int MEN_PER_DIVISION = Config.j.i("MEN_PER_DIVISION", 1, 255);
/* 52 */   public final int DIVISIONS_PER_ARMY = Config.j.i("DIVISIONS_PER_ARMY", 1, 126);
/* 53 */   public final int DIVISIONS_PER_BATTLE = this.DIVISIONS_PER_ARMY * 2;
/* 54 */   public final int MEN_PER_ARMY = this.MEN_PER_DIVISION * this.DIVISIONS_PER_ARMY;
/* 55 */   public final int REGION_MAX_DIVS = Config.j.i("REGION_MAX_DIVS", 0, 127);
/* 56 */   public final int REGION_MAX_MEN = this.REGION_MAX_DIVS * this.MEN_PER_DIVISION;
/* 57 */   public final double DAMAGE_REDUCTION = Config.j.d("DAMAGE_REDUCTION", 1.0D, 10000.0D);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\constant\Config$ConfigBattle.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */