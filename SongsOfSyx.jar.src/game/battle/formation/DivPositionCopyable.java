/*    */ package game.battle.formation;
/*    */ 
/*    */ import game.battle.util.Copyable;
/*    */ import init.constant.Config;
/*    */ 
/*    */ public class DivPositionCopyable
/*    */   extends DivPositionImp implements Copyable<DivPositionCopyable> {
/*    */   public DivPositionCopyable() {
/*  9 */     super((Config.battle()).MEN_PER_DIVISION);
/*    */   }
/*    */ 
/*    */   
/*    */   public void copy(DivPositionCopyable pos) {
/* 14 */     copyposition(pos);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\formation\DivPositionCopyable.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */