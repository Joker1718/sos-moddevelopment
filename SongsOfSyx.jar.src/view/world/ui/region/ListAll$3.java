/*    */ package view.world.ui.region;
/*    */ 
/*    */ import game.faction.FACTIONS;
/*    */ import game.faction.Faction;
/*    */ import util.gui.misc.GText;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends GTableSorter.GTSort<Region>
/*    */ {
/*    */   null(CharSequence $anonymous0) {
/* 61 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   public int cmp(Region current, Region cmp) {
/* 65 */     return get(current) - get(cmp);
/*    */   }
/*    */   
/*    */   private int get(Region current) {
/* 69 */     int m = 1023 * FACTIONS.MAX();
/* 70 */     int res = current.index();
/*    */ 
/*    */ 
/*    */     
/* 74 */     Faction f = current.faction();
/* 75 */     if (f == null) {
/* 76 */       res += 3 * m;
/* 77 */     } else if (f != FACTIONS.player()) {
/* 78 */       res += m;
/* 79 */       res += 1023 * f.index();
/*    */     } 
/* 81 */     return res;
/*    */   }
/*    */   
/*    */   public void format(Region h, GText text) {}
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\region\ListAll$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */