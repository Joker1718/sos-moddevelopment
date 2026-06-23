/*    */ package world.battle.spec;
/*    */ 
/*    */ import game.faction.FACTIONS;
/*    */ import world.map.regions.Region;
/*    */ 
/*    */ 
/*    */ public abstract class WBattleSiege
/*    */   extends WBattleSpec
/*    */ {
/*    */   public Region besiged;
/*    */   public double fortifications;
/*    */   
/*    */   public void engage() {
/* 14 */     throw new RuntimeException();
/*    */   }
/*    */ 
/*    */   
/*    */   public static abstract class Result
/*    */   {
/*    */     public Region besiged;
/*    */ 
/*    */     
/*    */     public abstract void occupy(double param1Double1, double param1Double2, int[] param1ArrayOfint1, int[] param1ArrayOfint2);
/*    */     
/*    */     public static boolean canPuppet() {
/* 26 */       return FACTIONS.canActivateNext();
/*    */     }
/*    */     
/*    */     public abstract void abandon(double param1Double1, double param1Double2, int[] param1ArrayOfint1, int[] param1ArrayOfint2);
/*    */     
/*    */     public abstract void puppet(double param1Double1, double param1Double2, int[] param1ArrayOfint1, int[] param1ArrayOfint2);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\battle\spec\WBattleSiege.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */