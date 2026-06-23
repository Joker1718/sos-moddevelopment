/*    */ package view.world.panel;
/*    */ 
/*    */ import snake2d.SUPER_SCREENSHOT;
/*    */ import snake2d.util.gui.clickable.CLICKABLE;
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.gui.common.SuperSc;
/*    */ import util.gui.misc.GButt;
/*    */ import view.main.VIEW;
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
/*    */   extends GButt.ButtPanel
/*    */ {
/*    */   private final SuperSc sst;
/*    */   
/*    */   null(SPRITE $anonymous0, String paramString) {
/* 58 */     super($anonymous0);
/*    */     
/* 60 */     this.sst = new SuperSc("SUPER_WORLD", new SUPER_SCREENSHOT[] { new UIMinimap.Shot(2, 2), new UIMinimap.Shot(1, 2), new UIMinimap.Shot(1, 1) }paramString);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void clickA() {
/* 65 */     (VIEW.inters()).popup.show((RENDEROBJ)this.sst, (CLICKABLE)this, true);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\world\panel\UIMinimap$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */