/*     */ package view.world.ui.region;
/*     */ 
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GButt;
/*     */ import util.text.Dic;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ import world.region.building.RDBuilding;
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
/*     */   extends GuiSection
/*     */ {
/*     */   public void render(SPRITE_RENDERER r, float ds) {
/*  93 */     boolean hov = hoveredIs();
/*  94 */     GButt.ButtPanel.renderBG(r, true, false, hov, (RECTANGLE)body());
/*  95 */     GButt.ButtPanel.renderFrame(r, (RECTANGLE)body());
/*     */     
/*  97 */     PlayBuildings.this.activeButts.clearSloppy();
/*  98 */     for (int i = 0; i < (RD.BUILDINGS()).sorted.size(); i++) {
/*  99 */       RDBuilding b = (RDBuilding)(RD.BUILDINGS()).sorted.get(i);
/* 100 */       if (RD.BUILDINGS().tmp().level(b, (Region)g.get()) != 0) {
/* 101 */         PlayBuildings.this.activeButts.add(PlayBuildings.this.butts[i]);
/*     */       }
/*     */     } 
/* 104 */     if (PlayBuildings.this.activeButts.size() == 0) {
/* 105 */       (UI.icons()).m.building.renderC(r, (RECTANGLE)body());
/*     */     }
/*     */     
/* 108 */     super.render(r, ds);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean click() {
/* 113 */     PlayBuildings.this.build.pop((RECTANGLE)PlayBuildings.this.body());
/* 114 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 119 */     super.hoverInfoGet(text);
/* 120 */     if (text.emptyIs()) {
/* 121 */       text.title(Dic.¤¤Buildings);
/* 122 */       text.text(PlayBuildings.¤¤Click);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\region\PlayBuildings$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */