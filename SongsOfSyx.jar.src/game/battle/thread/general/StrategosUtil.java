/*    */ package game.battle.thread.general;
/*    */ 
/*    */ import game.GAME;
/*    */ import game.battle.Army;
/*    */ import game.battle.formation.DivDeployer;
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.main.throne.THRONE;
/*    */ import snake2d.PathUtilOnline;
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ 
/*    */ public final class StrategosUtil
/*    */ {
/* 13 */   public final PathUtilOnline flooder = new PathUtilOnline(SETT.TWIDTH);
/* 14 */   public final DivDeployer deployer = new DivDeployer(this.flooder);
/* 15 */   public final UtilDeployer divDeployer = new UtilDeployer(this);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public COORDINATE getDestCoo() {
/* 22 */     return THRONE.coo();
/*    */   }
/*    */   
/*    */   public Army getArmy() {
/* 26 */     return GAME.ARMIES().enemy();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\thread\general\StrategosUtil.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */