/*    */ package view.sett.ui.right;
/*    */ 
/*    */ import init.sprite.SPRITES;
/*    */ import settlement.main.SETT;
/*    */ import settlement.tilemap.SettMarks;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import view.main.VIEW;
/*    */ import view.tool.PlacableSingle;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/*    */   extends PlacableSingle
/*    */ {
/*    */   null(CharSequence $anonymous0) {
/* 64 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   public void placeFirst(int tx, int ty) {
/* 68 */     SettMarks.SettMark d = (SETT.TILE_MAP()).marks.make();
/* 69 */     if (d != null)
/* 70 */       d.set(tx, ty); 
/* 71 */     (VIEW.s()).tools.placer.deactivate();
/*    */   }
/*    */ 
/*    */   
/*    */   public CharSequence isPlacable(int tx, int ty) {
/* 76 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public SPRITE getIcon() {
/* 81 */     return (SPRITE)(SPRITES.icons()).m.crossair;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\right\UIMiniHotSpots$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */