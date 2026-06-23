/*   */ package snake2d.util.misc;
/*   */ 
/*   */ 
/*   */ 
/*   */ public interface ACTION
/*   */ {
/* 7 */   public static final ACTION NOP = new ACTION() {
/*   */       public void exe() {}
/*   */     };
/*   */   
/*   */   void exe();
/*   */   
/*   */   public static interface ACTION_O<T> {
/*   */     void exe(T param1T);
/*   */   }
/*   */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\misc\ACTION.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */