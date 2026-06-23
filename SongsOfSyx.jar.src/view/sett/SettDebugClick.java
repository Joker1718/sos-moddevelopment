/*    */ package view.sett;
/*    */ 
/*    */ import game.GameDisposable;
/*    */ import snake2d.util.sets.LinkedList;
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class SettDebugClick
/*    */ {
/* 10 */   static LinkedList<SettDebugClick> all = new LinkedList();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public abstract boolean debug(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void add() {
/* 25 */     all.add(this);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\sett\SettDebugClick.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */