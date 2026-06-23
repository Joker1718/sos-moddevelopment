/*    */ package view.world.ui.region;
/*    */ 
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.gui.GuiSection;
/*    */ import snake2d.util.sets.ArrayList;
/*    */ import util.data.GETTER;
/*    */ import world.region.RD;
/*    */ import world.region.building.RDBuilding;
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
/*    */   extends GuiSection
/*    */ {
/*    */   public void render(SPRITE_RENDERER r, float ds) {
/* 80 */     buildings.clear();
/* 81 */     for (RDBuilding bu : (RD.BUILDINGS()).all) {
/* 82 */       if (bu.level.get(g.get()) > 0)
/* 83 */         buildings.add(bu); 
/*    */     } 
/* 85 */     super.render(r, ds);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\region\MiscMore$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */