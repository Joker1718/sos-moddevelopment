/*     */ package settlement.tilemap.ground;
/*     */ 
/*     */ import init.resources.Minable;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import view.tool.PLACABLE;
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
/*     */ class null
/*     */   extends PlacableMulti
/*     */ {
/*     */   private final CharSequence name;
/*     */   
/*     */   public void place(int tx, int ty, AREA a, PLACER_TYPE t) {
/*     */     if (Minables.this.getter.is(tx, ty, m)) {
/*     */       Minables.this.amountD.increment(tx, ty, 0.1D);
/*     */     } else {
/*     */       Minables.this.getter.set(tx, ty, m);
/*     */     } 
/*     */   }
/*     */   
/*     */   null(CharSequence $anonymous0) {
/*  93 */     super($anonymous0);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 115 */     this.name = "mineral " + String.valueOf(paramMinable.resource.name);
/*     */   }
/*     */   public CharSequence name() {
/* 118 */     return this.name;
/*     */   }
/*     */ 
/*     */   
/*     */   public SPRITE getIcon() {
/* 123 */     return (SPRITE)m.resource.icon(); }
/*     */   public CharSequence isPlacable(int tx, int ty, AREA a, PLACER_TYPE t) { if (!SETT.IN_BOUNDS(tx, ty))
/*     */       return "";  if ((SETT.PATH()).solidity.is(tx, ty))
/*     */       return ""; 
/*     */     if ((SETT.ROOMS()).map.is(tx, ty))
/*     */       return ""; 
/* 129 */     return null; } public PLACABLE getUndo() { return undo; }
/*     */ 
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\ground\Minables$12.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */