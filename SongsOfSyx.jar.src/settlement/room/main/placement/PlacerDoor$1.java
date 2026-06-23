/*    */ package settlement.room.main.placement;
/*    */ 
/*    */ import init.sprite.SPRITES;
/*    */ import snake2d.util.datatypes.AREA;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import view.tool.PLACER_TYPE;
/*    */ import view.tool.PlacableMulti;
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
/*    */   extends PlacableMulti
/*    */ {
/*    */   private SPRITE icon;
/*    */   
/*    */   null(CharSequence $anonymous0) {
/* 45 */     super($anonymous0);
/*    */     
/* 47 */     this.icon = (SPRITE)new SPRITE.Twin((SPRITE)(SPRITES.icons()).m.wall_opening, (SPRITE)(SPRITES.icons()).m.anti);
/*    */   }
/*    */   
/*    */   public void place(int tx, int ty, AREA a, PLACER_TYPE t) {
/* 51 */     if (PlacerDoor.this.removeWithoutHistory(tx, ty)) {
/* 52 */       PlacerDoor.this.history.placeDoor(tx, ty, -1);
/*    */     }
/*    */   }
/*    */   
/*    */   public CharSequence isPlacable(int tx, int ty, AREA area, PLACER_TYPE t) {
/* 57 */     if (!PlacerDoor.this.isEdge.is(tx, ty)) {
/* 58 */       return E;
/*    */     }
/* 60 */     if (!UtilWallPlacability.wallCanBe.is(tx, ty)) {
/* 61 */       return E;
/*    */     }
/* 63 */     if (!PlacerDoor.this.isOpening.is(tx, ty)) {
/* 64 */       return E;
/*    */     }
/* 66 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public SPRITE getIcon() {
/* 71 */     return this.icon;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\placement\PlacerDoor$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */