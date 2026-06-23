/*    */ package world.battle.spec;
/*    */ 
/*    */ import game.faction.FACTIONS;
/*    */ import world.map.regions.Region;
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
/*    */ public abstract class Result
/*    */ {
/*    */   public Region besiged;
/*    */   
/*    */   public abstract void occupy(double paramDouble1, double paramDouble2, int[] paramArrayOfint1, int[] paramArrayOfint2);
/*    */   
/*    */   public abstract void abandon(double paramDouble1, double paramDouble2, int[] paramArrayOfint1, int[] paramArrayOfint2);
/*    */   
/*    */   public abstract void puppet(double paramDouble1, double paramDouble2, int[] paramArrayOfint1, int[] paramArrayOfint2);
/*    */   
/*    */   public static boolean canPuppet() {
/* 26 */     return FACTIONS.canActivateNext();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\battle\spec\WBattleSiege$Result.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */