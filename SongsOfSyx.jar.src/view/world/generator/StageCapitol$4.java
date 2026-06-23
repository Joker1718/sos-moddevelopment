/*     */ package view.world.generator;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.sets.LIST;
/*     */ import util.gui.misc.GBox;
/*     */ import view.tool.PlacableFixedImp;
/*     */ import view.world.generator.tools.UIWorldToolCapitolPlaceInfo;
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
/*     */ class null
/*     */   extends PlacableFixedImp
/*     */ {
/*     */   final UIWorldToolCapitolPlaceInfo info;
/*     */   
/*     */   null(CharSequence $anonymous0, int $anonymous1, int $anonymous2) {
/*  86 */     super($anonymous0, $anonymous1, $anonymous2);
/*     */     
/*  88 */     this.info = new UIWorldToolCapitolPlaceInfo();
/*     */   }
/*     */   
/*     */   public int width() {
/*  92 */     return 3;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void place(int tx, int ty, int rx, int ry) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void afterPlaced(int tx1, int ty1) {
/* 103 */     int cx = tx1 + 1;
/* 104 */     int cy = ty1 + 1;
/* 105 */     stages.reset();
/* 106 */     StageCapitol.this.generate(cx, cy);
/* 107 */     stages.set();
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence placableWhole(int tx1, int ty1) {
/* 112 */     CharSequence p = WorldCentrePlacablity.terrain(tx1, ty1);
/* 113 */     if (p != null)
/* 114 */       return p; 
/* 115 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int height() {
/* 159 */     return 3;
/*     */   }
/*     */ 
/*     */   
/*     */   public LIST<CLICKABLE> getAdditionalButt() {
/* 164 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public CharSequence placable(int tx, int ty, int rx, int ry) {
/* 170 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void placeInfo(GBox b, int x1, int y1) {
/* 179 */     this.info.placeInfo(b, x1, y1, FACTIONS.player().race());
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\world\generator\StageCapitol$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */