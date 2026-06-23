/*    */ package view.world.ui.region;
/*    */ 
/*    */ import game.faction.FACTIONS;
/*    */ import util.gui.table.GTableSorter;
/*    */ import world.WORLD;
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
/*    */ class null
/*    */   extends GTableSorter<Region>
/*    */ {
/*    */   null(int $anonymous0) {
/* 41 */     super($anonymous0);
/*    */   }
/*    */   protected Region getUnsorted(int index) {
/* 44 */     Region f = WORLD.REGIONS().getByIndex(index);
/* 45 */     if (f.info.area() > 0 && (f.faction() != FACTIONS.player() || !f.capitol()))
/* 46 */       return f; 
/* 47 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\region\ListAll$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */