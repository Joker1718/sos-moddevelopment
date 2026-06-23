/*    */ package game;
/*    */ 
/*    */ import snake2d.util.sets.ArrayList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class GameDisposable
/*    */ {
/* 13 */   private static ArrayList<GameDisposable> initers = new ArrayList(180);
/*    */ 
/*    */   
/*    */   public GameDisposable() {
/* 17 */     initers.add(this);
/*    */   }
/*    */   
/*    */   protected abstract void dispose();
/*    */   
/*    */   static void disposeAll() {
/* 23 */     for (GameDisposable i : initers)
/* 24 */       i.dispose(); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\GameDisposable.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */