/*    */ package view.world.ui.region;
/*    */ 
/*    */ import game.GAME;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import snake2d.util.gui.GuiSection;
/*    */ import view.main.VIEW;
/*    */ import world.map.regions.Region;
/*    */ import world.region.RD;
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
/* 74 */     if (PlayBuildingsPop.this.g.get() != PlayBuildingsPop.this.current || VIEW.current() != VIEW.world())
/* 75 */       (VIEW.inters()).section.close(); 
/* 76 */     GAME.SPEED.tmpPause();
/* 77 */     RD.BUILDINGS().tmp(false, (Region)PlayBuildingsPop.this.g.get());
/* 78 */     super.render(r, ds);
/*    */   }
/*    */ 
/*    */   
/*    */   public void hoverInfoGet(GUI_BOX text) {
/* 83 */     RD.BUILDINGS().tmp(false, (Region)PlayBuildingsPop.this.g.get());
/* 84 */     super.hoverInfoGet(text);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\region\PlayBuildingsPop$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */