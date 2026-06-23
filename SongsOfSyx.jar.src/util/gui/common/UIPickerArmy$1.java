/*    */ package util.gui.common;
/*    */ 
/*    */ import game.faction.Faction;
/*    */ import util.data.GETTER;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends GTableBuilder
/*    */ {
/*    */   public int nrOFEntries() {
/* 34 */     if (g.get() == null)
/* 35 */       return 0; 
/* 36 */     return ((Faction)g.get()).armies().all().size();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\gui\common\UIPickerArmy$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */