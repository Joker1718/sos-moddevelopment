/*     */ package view.world.ui.region;
/*     */ 
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import util.data.GETTER;
/*     */ import util.gui.table.GTableBuilder;
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
/*     */ class null
/*     */   extends GTableBuilder.GRowBuilder
/*     */ {
/*     */   public RENDEROBJ build(final GETTER<Integer> ier) {
/* 102 */     GuiSection s = new GuiSection();
/* 103 */     for (int i = 0; i < cols; i++) {
/* 104 */       final int k = i;
/* 105 */       s.addRightC(0, (RENDEROBJ)new HOVERABLE.HoverableAbs(32, 32)
/*     */           {
/*     */             
/*     */             protected void render(SPRITE_RENDERER r, float ds, boolean isHovered)
/*     */             {
/* 110 */               RDBuilding bu = (RDBuilding)buildings.get(k + ((Integer)ier.get()).intValue() * cols);
/* 111 */               if (bu != null) {
/* 112 */                 ((RDBuildingLevel)bu.levels.get(bu.level.get(g.get()))).icon.render(r, (RECTANGLE)this.body);
/*     */               }
/*     */             }
/*     */ 
/*     */             
/*     */             public void hoverInfoGet(GUI_BOX text) {
/* 118 */               RDBuilding bu = (RDBuilding)buildings.get(k + ((Integer)ier.get()).intValue() * cols);
/* 119 */               if (bu != null) {
/* 120 */                 RDBuildingLevel l = (RDBuildingLevel)bu.levels.get(bu.level.get(g.get()));
/* 121 */                 text.title(l.name);
/* 122 */                 text.text(bu.info.desc);
/*     */               } 
/*     */             }
/*     */           });
/*     */     } 
/*     */     
/* 128 */     return (RENDEROBJ)s;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\region\MiscMore$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */