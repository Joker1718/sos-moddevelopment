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
/* 48 */     if (g.get() == null) {
/* 49 */       return 0;
/*    */     }
/* 51 */     return ((Faction)g.get()).realm().regions();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\gui\common\UIPickerRegion$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */