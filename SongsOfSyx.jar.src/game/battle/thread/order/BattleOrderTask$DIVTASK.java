/*    */ package game.battle.thread.order;
/*    */ 
/*    */ import snake2d.util.sets.ArrayList;
/*    */ import snake2d.util.sets.LIST;
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
/*    */ public enum DIVTASK
/*    */ {
/* 21 */   STOP(false, false),
/* 22 */   MOVE(true, true),
/* 23 */   ATTACK_BUILDING(false, true),
/* 24 */   ATTACK_MELEE(false, true),
/* 25 */   ATTACK_RANGED(false, true),
/* 26 */   CHARGE(false, false);
/*    */   
/*    */   public final boolean showDest;
/*    */   public final boolean showPath;
/*    */   public static final LIST<DIVTASK> all;
/*    */   
/*    */   DIVTASK(boolean dest, boolean path) {
/* 33 */     this.showDest = dest;
/* 34 */     this.showPath = path;
/*    */   }
/*    */   static {
/* 37 */     all = (LIST<DIVTASK>)new ArrayList((Object[])values());
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\thread\order\BattleOrderTask$DIVTASK.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */