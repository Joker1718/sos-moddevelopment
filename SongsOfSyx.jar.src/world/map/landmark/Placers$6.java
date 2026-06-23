/*     */ package world.map.landmark;
/*     */ 
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import view.subview.GameWindow;
/*     */ import view.tool.PLACER_TYPE;
/*     */ import view.tool.PlacableMulti;
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
/*     */   public void place(int tx, int ty, AREA area, PLACER_TYPE type) {
/* 134 */     ll.setter.set(tx, ty, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence isPlacable(int tx, int ty, AREA area, PLACER_TYPE type) {
/* 139 */     return (Placers.this.get() != null) ? null : E;
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateRegardless(GameWindow window, AREA selected) {
/* 144 */     overlay.hovered = Placers.this.get();
/*     */   }
/*     */ 
/*     */   
/*     */   public void placeInfo(GBox b, int oktiles, AREA a) {
/* 149 */     Placers.this.hover(b, oktiles, a);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\landmark\Placers$6.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */