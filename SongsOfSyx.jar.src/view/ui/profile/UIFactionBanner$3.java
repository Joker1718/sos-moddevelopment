/*    */ package view.ui.profile;
/*    */ 
/*    */ import game.faction.FBanner;
/*    */ import snake2d.util.color.ColorImp;
/*    */ import util.gui.misc.GColorPicker;
/*    */ import world.WORLD;
/*    */ import world.map.regions.Region;
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
/*    */   extends GColorPicker
/*    */ {
/*    */   null(boolean $anonymous0, CharSequence $anonymous1) {
/* 68 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */ 
/*    */   
/*    */   public ColorImp color() {
/* 73 */     return b.colorBG();
/*    */   }
/*    */ 
/*    */   
/*    */   public void change() {
/* 78 */     for (Region r : UIFactionBanner.this.f.realm().all())
/* 79 */       WORLD.MINIMAP().updateRegion(r); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\profile\UIFactionBanner$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */