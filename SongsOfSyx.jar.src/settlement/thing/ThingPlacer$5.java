/*     */ package settlement.thing;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.sets.LISTE;
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
/*     */ class null
/*     */   extends PlacableMulti
/*     */ {
/*     */   null(CharSequence $anonymous0) {
/* 114 */     super($anonymous0);
/*     */   }
/*     */   
/*     */   public void place(int tx, int ty, AREA area, PLACER_TYPE type) {
/* 118 */     LISTE<THINGS.Thing> lISTE = SETT.THINGS().get(tx, ty);
/* 119 */     if (!lISTE.isEmpty()) {
/* 120 */       ((THINGS.Thing)lISTE.get(0)).remove();
/*     */     }
/*     */   }
/*     */   
/*     */   public CharSequence isPlacable(int tx, int ty, AREA a, PLACER_TYPE type) {
/* 125 */     LISTE<THINGS.Thing> lISTE = SETT.THINGS().get(tx, ty);
/* 126 */     if (lISTE.isEmpty())
/* 127 */       return ""; 
/* 128 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\ThingPlacer$5.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */