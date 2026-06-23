/*    */ package view.sett.ui.room;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ import util.gui.table.GTableBuilder;
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
/*    */   extends GTableBuilder
/*    */ {
/*    */   public int nrOFEntries() {
/* 29 */     return (int)Math.ceil((SETT.ROOMS()).construction.instances() / ConstructionList.XX);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\ConstructionList$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */