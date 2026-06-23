/*    */ package view.battle.editor;
/*    */ 
/*    */ import game.battle.util.DIV_SPEC;
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
/*    */ import util.data.GETTER;
/*    */ import util.gui.table.GMatrixDraggable;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends GMatrixDraggable
/*    */ {
/*    */   null(int $anonymous0, int $anonymous1, int $anonymous2, int $anonymous3) {
/* 42 */     super($anonymous0, $anonymous1, $anonymous2, $anonymous3);
/*    */   }
/*    */   
/*    */   public int nrOFEntries() {
/* 46 */     return ((ArmySide)current.get()).divs.size();
/*    */   }
/*    */ 
/*    */   
/*    */   public RENDEROBJ get(int i, int columnI) {
/* 51 */     ((ArmyDivs.RDiv)ArmyDivs.this.all.get(i)).div = (DIV_SPEC)((ArmySide)current.get()).divs.get(i);
/*    */     
/* 53 */     return (RENDEROBJ)ArmyDivs.this.all.get(i);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void move(int oldI, int newI) {
/* 59 */     DIV_SPEC after = (DIV_SPEC)((ArmySide)current.get()).divs.get(newI);
/* 60 */     DIV_SPEC dd = (DIV_SPEC)((ArmySide)current.get()).divs.removeOrdered(oldI);
/* 61 */     if (dd == null)
/*    */       return; 
/* 63 */     int ii = ((ArmySide)current.get()).divs.indexOf(after);
/* 64 */     ((ArmySide)current.get()).divs.insert(ii, dd);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\battle\editor\ArmyDivs$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */