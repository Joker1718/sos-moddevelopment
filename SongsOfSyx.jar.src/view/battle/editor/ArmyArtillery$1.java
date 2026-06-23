/*    */ package view.battle.editor;
/*    */ 
/*    */ import util.data.DOUBLE;
/*    */ import util.data.GETTER;
/*    */ import util.data.INT;
/*    */ import world.army.ADSupplies;
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
/*    */ class null
/*    */   implements INT.INTE
/*    */ {
/*    */   public int min() {
/* 24 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public int max() {
/* 29 */     return 40;
/*    */   }
/*    */ 
/*    */   
/*    */   public int get() {
/* 34 */     return ((ArmySide)current.get()).artillery[a.index()];
/*    */   }
/*    */ 
/*    */   
/*    */   public void set(int t) {
/* 39 */     ((ArmySide)current.get()).artillery[a.index()] = t;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\battle\editor\ArmyArtillery$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */