/*     */ package settlement.job;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import settlement.overlay.Addable;
/*     */ import settlement.tilemap.terrain.TRock;
/*     */ import settlement.tilemap.terrain.Terrain;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.rendering.RenderData;
/*     */ import view.subview.GameWindow;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   final Addable a;
/*     */   
/*     */   null(CharSequence $anonymous0, CharSequence $anonymous1, SPRITE $anonymous2) {
/* 173 */     super($anonymous0, $anonymous1, $anonymous2);
/*     */ 
/*     */ 
/*     */     
/* 177 */     this.a = new Addable(null, null, null, null, true, false)
/*     */       {
/*     */         
/*     */         public void renderBelow(Renderer r, RenderData.RenderIterator it)
/*     */         {
/* 182 */           double v = 0.0D;
/* 183 */           if ((SETT.JOBS()).getter.get(it.tile()) == null) {
/* 184 */             Terrain.TerrainTile t = SETT.TERRAIN().get(it.tile());
/* 185 */             if (t instanceof TRock) {
/* 186 */               TRock b = (TRock)t;
/* 187 */               b.getClass(); v = Math.max(v, 0.5D + 0.5D * b.amountGet(it.tx(), it.ty()) / 15.0D);
/*     */             } 
/* 189 */             if (t instanceof settlement.tilemap.terrain.TForest.Tree) {
/* 190 */               v = Math.max(v, 0.5D + 0.5D * (SETT.TERRAIN()).TREES.amount.get(it.tile()) / 4.0D);
/*     */             }
/*     */           } 
/*     */ 
/*     */           
/* 195 */           renderUnder(v, r, it, false);
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void place(int tx, int ty, AREA a, PLACER_TYPE t) {
/* 203 */     if (JobClears.this.wood.problem(tx, ty, false) == null) {
/* 204 */       Placer.place(tx, ty, JobClears.this.wood);
/* 205 */     } else if (JobClears.this.stone.problem(tx, ty, false) == null) {
/* 206 */       Placer.place(tx, ty, JobClears.this.stone);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public CharSequence isPlacable(int tx, int ty, AREA a, PLACER_TYPE t) {
/* 213 */     if (JobClears.this.wood.placer().isPlacable(tx, ty, a, t) == null) {
/* 214 */       return null;
/*     */     }
/* 216 */     if (JobClears.this.stone.placer().isPlacable(tx, ty, a, t) == null) {
/* 217 */       return null;
/*     */     }
/* 219 */     if (JobClears.this.wood.placer().isPlacable(tx, ty, a, t) != null) {
/* 220 */       return JobClears.this.wood.placer().isPlacable(tx, ty, a, t);
/*     */     }
/* 222 */     if (JobClears.this.stone.placer().isPlacable(tx, ty, a, t) != null) {
/* 223 */       return JobClears.this.stone.placer().isPlacable(tx, ty, a, t);
/*     */     }
/* 225 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public PLACABLE getUndo() {
/* 230 */     return (PLACABLE)(SETT.JOBS()).tool_clear;
/*     */   }
/*     */ 
/*     */   
/*     */   public LIST<CLICKABLE> getAdditionalButt() {
/* 235 */     return (LIST<CLICKABLE>)JobClears.this.butts;
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateRegardless(GameWindow window, AREA selected) {
/* 240 */     JobClears.this.currentOverlay = this.a;
/* 241 */     if (JobClears.this.overlay)
/* 242 */       this.a.add(); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\job\JobClears$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */