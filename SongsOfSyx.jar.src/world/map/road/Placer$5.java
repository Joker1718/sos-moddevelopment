/*     */ package world.map.road;
/*     */ 
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.PLACER_TYPE;
/*     */ import view.tool.PlacableMulti;
/*     */ import world.WORLD;
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
/*     */   extends PlacableMulti
/*     */ {
/*     */   null(CharSequence $anonymous0, CharSequence $anonymous1, SPRITE $anonymous2) {
/* 130 */     super($anonymous0, $anonymous1, $anonymous2);
/*     */   }
/*     */   
/*     */   public CharSequence isPlacable(int tx, int ty, AREA area, PLACER_TYPE type) {
/* 134 */     if (WORLD.ROADS().is(tx, ty)) {
/* 135 */       return null;
/*     */     }
/* 137 */     return E;
/*     */   }
/*     */ 
/*     */   
/*     */   public void place(int tx, int ty, AREA area, PLACER_TYPE type) {
/* 142 */     (WORLD.ROADS()).minified.set(tx, ty, true);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public PLACABLE getUndo() {
/* 148 */     return (PLACABLE)roadMiniUndo;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\road\Placer$5.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */