/*     */ package world.map.regions;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import view.subview.GameWindow;
/*     */ import view.tool.PlacableFixedImp;
/*     */ import view.world.generator.tools.UIWorldToolCapitolPlaceInfo;
/*     */ import world.WORLD;
/*     */ import world.map.regions.centre.WorldCentrePlacablity;
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
/*     */   extends PlacableFixedImp
/*     */ {
/*     */   final UIWorldToolCapitolPlaceInfo info;
/*     */   
/*     */   null(CharSequence $anonymous0, int $anonymous1, int $anonymous2, CharSequence $anonymous3, SPRITE $anonymous4) {
/* 268 */     super($anonymous0, $anonymous1, $anonymous2, $anonymous3, $anonymous4);
/*     */ 
/*     */ 
/*     */     
/* 272 */     this.info = new UIWorldToolCapitolPlaceInfo();
/*     */   }
/*     */ 
/*     */   
/*     */   public int width() {
/* 277 */     return 3;
/*     */   }
/*     */ 
/*     */   
/*     */   public void place(int tx, int ty, int rx, int ry) {
/* 282 */     if (rx == 0 && ry == 0)
/* 283 */       clear(); 
/* 284 */     (WORLD.REGIONS()).pmap.set(tx, ty, WORLD.REGIONS().getByIndex(0));
/* 285 */     if (rx == 1 && ry == 1) {
/* 286 */       (WORLD.REGIONS().getByIndex(0)).info.centreSet(tx, ty);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int height() {
/* 294 */     return 3;
/*     */   }
/*     */ 
/*     */   
/*     */   public LIST<CLICKABLE> getAdditionalButt() {
/* 299 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence placable(int tx, int ty, int rx, int ry) {
/* 304 */     if (rx == 0 && ry == 0)
/* 305 */       return WorldCentrePlacablity.terrain(tx, ty); 
/* 306 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void placeInfo(GBox b, int x1, int y1) {
/* 311 */     this.info.placeInfo(b, x1, y1, FACTIONS.player().race());
/*     */   }
/*     */   
/*     */   public void clear() {
/* 315 */     for (COORDINATE c : WORLD.TBOUNDS()) {
/* 316 */       if ((WORLD.REGIONS()).map.get(c) == WORLD.REGIONS().getByIndex(0)) {
/* 317 */         (WORLD.REGIONS()).pmap.set(c, (Object)null);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void updateRegardless(GameWindow window) {
/* 323 */     hov.hovered = null;
/* 324 */     hov.add();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\regions\Placer$9.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */