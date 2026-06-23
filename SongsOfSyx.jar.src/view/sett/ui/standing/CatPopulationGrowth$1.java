/*    */ package view.sett.ui.standing;
/*    */ 
/*    */ import init.race.Race;
/*    */ import init.type.HCLASSES;
/*    */ import init.type.HCLASS_RACE;
/*    */ import settlement.main.SETT;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.datatypes.RECTANGLE;
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import snake2d.util.gui.GuiSection;
/*    */ import util.gui.misc.GButt;
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
/* 79 */     GButt.ButtPanel.renderBG(r, (CatPopulationGrowth.this.cl == HCLASSES.CITIZEN()), false, hoveredIs(), (RECTANGLE)body());
/* 80 */     super.render(r, ds);
/* 81 */     GButt.ButtPanel.renderFrame(r, (RECTANGLE)body());
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void hoverInfoGet(GUI_BOX text) {
/* 87 */     super.hoverInfoGet(text);
/* 88 */     if (text.emptyIs())
/* 89 */       SETT.ENTRY().immi().hoverImmigrants(text, HCLASS_RACE.clP((Race)CatPopulationGrowth.this.race.get(), CatPopulationGrowth.this.cl)); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\standing\CatPopulationGrowth$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */