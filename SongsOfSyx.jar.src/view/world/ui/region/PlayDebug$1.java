/*    */ package view.world.ui.region;
/*    */ 
/*    */ import game.boosting.BSourceInfo;
/*    */ import util.gui.misc.GButt;
/*    */ import world.map.regions.Region;
/*    */ import world.region.RBooster;
/*    */ import world.region.building.RDBuildPoints;
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
/*    */   extends GButt.ButtPanel
/*    */ {
/*    */   null(CharSequence $anonymous0) {
/* 34 */     super($anonymous0);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void clickA() {
/* 39 */     (new RBooster(new BSourceInfo("cheat", null), 0.0D, 2500.0D, false) {
/* 40 */         final Region rr = (PlayDebug.null.access$0(PlayDebug.null.this)).reg;
/*    */ 
/*    */         
/*    */         protected double get(Region reg) {
/* 44 */           return ((reg == this.rr) ? true : false);
/*    */         }
/* 48 */       }).add(p.bo);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\region\PlayDebug$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */