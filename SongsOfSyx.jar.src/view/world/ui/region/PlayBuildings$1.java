/*    */ package view.world.ui.region;
/*    */ 
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.datatypes.RECTANGLE;
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*    */ import util.data.GETTER;
/*    */ import world.map.regions.Region;
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
/*    */ class null
/*    */   extends HOVERABLE.HoverableAbs
/*    */ {
/*    */   null(int $anonymous0, int $anonymous1) {
/* 47 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   
/*    */   protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/* 51 */     PlayBuildings.this.build.render(bu, (Region)g.get(), (RECTANGLE)this.body, r, true, false, isHovered);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void hoverInfoGet(GUI_BOX text) {
/* 57 */     PlayBuildings.this.build.hover(bu, (Region)g.get(), text);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\region\PlayBuildings$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */