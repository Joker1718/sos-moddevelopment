/*     */ package world.region;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.INT;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.PLACER_TYPE;
/*     */ import view.tool.PlacableMulti;
/*     */ import world.WORLD;
/*     */ import world.map.regions.Region;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*  71 */     super($anonymous0, $anonymous1, $anonymous2);
/*     */   }
/*     */   
/*     */   public void place(int tx, int ty, AREA area, PLACER_TYPE type) {
/*  75 */     Region reg = (Region)(WORLD.REGIONS()).map.get(tx, ty);
/*  76 */     if (reg != null) {
/*  77 */       RD.setFaction(reg, FACTIONS.getByIndex(ii.get()), false);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence isPlacable(int tx, int ty, AREA area, PLACER_TYPE type) {
/*  83 */     Region reg = (Region)(WORLD.REGIONS()).map.get(tx, ty);
/*  84 */     if (reg != null) {
/*  85 */       return null;
/*     */     }
/*  87 */     return E;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean expandsTo(int fromX, int fromY, int toX, int toY) {
/*  92 */     Region reg = (Region)(WORLD.REGIONS()).map.get(fromX, fromY);
/*  93 */     return (reg != null && reg.is(toX, toY));
/*     */   }
/*     */ 
/*     */   
/*     */   public PLACABLE getUndo() {
/*  98 */     return undo;
/*     */   }
/*     */   
/*     */   public LIST<CLICKABLE> getAdditionalButt() {
/* 102 */     return (LIST<CLICKABLE>)butts;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\region\Placers$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */