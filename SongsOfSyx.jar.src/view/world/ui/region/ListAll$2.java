/*    */ package view.world.ui.region;
/*    */ 
/*    */ import util.gui.table.GTableSorter;
/*    */ import world.map.regions.Region;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends GTableSorter.GTFilter<Region>
/*    */ {
/*    */   null(CharSequence $anonymous0) {
/* 53 */     super($anonymous0);
/*    */   }
/*    */   public boolean passes(Region h) {
/* 56 */     return h.info.name().startsWithIgnoreCase((CharSequence)ListAll.this.s.text());
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\region\ListAll$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */