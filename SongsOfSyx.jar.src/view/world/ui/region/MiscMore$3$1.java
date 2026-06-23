/*     */ package view.world.ui.region;
/*     */ 
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import util.data.GETTER;
/*     */ import world.region.building.RDBuilding;
/*     */ import world.region.building.RDBuildingLevel;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   extends HOVERABLE.HoverableAbs
/*     */ {
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/* 110 */     RDBuilding bu = (RDBuilding)buildings.get(k + ((Integer)ier.get()).intValue() * cols);
/* 111 */     if (bu != null) {
/* 112 */       ((RDBuildingLevel)bu.levels.get(bu.level.get(g.get()))).icon.render(r, (RECTANGLE)this.body);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 118 */     RDBuilding bu = (RDBuilding)buildings.get(k + ((Integer)ier.get()).intValue() * cols);
/* 119 */     if (bu != null) {
/* 120 */       RDBuildingLevel l = (RDBuildingLevel)bu.levels.get(bu.level.get(g.get()));
/* 121 */       text.title(l.name);
/* 122 */       text.text(bu.info.desc);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\region\MiscMore$3$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */