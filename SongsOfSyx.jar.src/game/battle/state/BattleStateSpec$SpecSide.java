/*    */ package game.battle.state;
/*    */ 
/*    */ import game.battle.util.DivGeneration;
/*    */ import init.constant.Config;
/*    */ import snake2d.util.datatypes.Coo;
/*    */ import snake2d.util.file.Alloc;
/*    */ import snake2d.util.sets.ArrayList;
/*    */ import world.army.AD;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SpecSide
/*    */ {
/* 16 */   public final Coo wCoo = new Coo();
/* 17 */   public final int[] artillery = Alloc.ii(AD.supplies().arts().size());
/*    */   public double moraleBase;
/* 19 */   public ArrayList<DivGeneration> divs = new ArrayList((Config.battle()).DIVISIONS_PER_ARMY);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\state\BattleStateSpec$SpecSide.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */