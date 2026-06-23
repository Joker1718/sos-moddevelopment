/*    */ package world.battle.spec;
/*    */ 
/*    */ import init.race.RACES;
/*    */ import init.resources.RESOURCES;
/*    */ import snake2d.util.file.Alloc;
/*    */ 
/*    */ 
/*    */ public abstract class WBattleResult
/*    */ {
/*    */   public WBattleSide player;
/*    */   public WBattleSide enemy;
/*    */   public BATTLE_RESULT result;
/* 13 */   public int[] capturedRaces = Alloc.ii(RACES.all().size());
/* 14 */   public int[] lostResources = Alloc.ii(RESOURCES.ALL().size());
/*    */   
/*    */   public abstract void accept(int[] paramArrayOfint1, int[] paramArrayOfint2);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\battle\spec\WBattleResult.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */