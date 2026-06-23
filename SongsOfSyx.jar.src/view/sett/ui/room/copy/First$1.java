/*    */ package view.sett.ui.room.copy;
/*    */ 
/*    */ import settlement.main.SETT;
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
/*    */   null(CharSequence $anonymous0, CharSequence $anonymous1, SPRITE $anonymous2) {
/* 53 */     super($anonymous0, $anonymous1, $anonymous2);
/*    */   }
/*    */   
/*    */   public void place(int tx, int ty, AREA area, PLACER_TYPE type) {
/* 57 */     First.this.source.set(tx, ty, false);
/*    */   }
/*    */ 
/*    */   
/*    */   public CharSequence isPlacable(int tx, int ty, AREA area, PLACER_TYPE type) {
/* 62 */     if (First.this.source.is(tx, ty))
/* 63 */       return null; 
/* 64 */     return E;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean expandsTo(int fromX, int fromY, int toX, int toY) {
/* 69 */     return (First.this.source.is(fromX, fromY) && (SETT.ROOMS()).copy.copier.canCopy(fromX, fromY) && (SETT.ROOMS()).map.get(fromX, fromY).isSame(fromX, fromY, toX, toY));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\copy\First$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */