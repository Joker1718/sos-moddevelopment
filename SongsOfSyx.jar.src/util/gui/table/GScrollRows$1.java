/*    */ package util.gui.table;
/*    */ 
/*    */ import snake2d.MButt;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.gui.GuiSection;
/*    */ 
/*    */ 
/*    */ 
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
/* 22 */     if (hoveredIs()) {
/* 23 */       double d = MButt.clearWheelSpin();
/* 24 */       if (d > 0.0D) {
/* 25 */         GScrollRows.this.first--;
/* 26 */       } else if (d < 0.0D) {
/* 27 */         GScrollRows.this.first++;
/*    */       } 
/*    */     } 
/* 30 */     GScrollRows.this.init();
/* 31 */     super.render(r, ds);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\gui\table\GScrollRows$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */