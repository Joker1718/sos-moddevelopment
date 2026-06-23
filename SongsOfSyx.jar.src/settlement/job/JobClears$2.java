/*     */ package settlement.job;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import settlement.overlay.Addable;
/*     */ import settlement.tilemap.terrain.Terrain;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.rendering.RenderData;
/*     */ import view.tool.PlacableMessages;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends JobClear
/*     */ {
/*     */   final Addable a;
/*     */   
/*     */   null(String $anonymous0, CharSequence $anonymous1, CharSequence $anonymous2, CharSequence $anonymous3, SPRITE $anonymous4) {
/* 130 */     super($anonymous0, $anonymous1, $anonymous2, $anonymous3, $anonymous4);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 137 */     this.a = new Addable(null, null, null, null, true, false)
/*     */       {
/*     */         
/*     */         public void renderBelow(Renderer r, RenderData.RenderIterator it)
/*     */         {
/* 142 */           double v = 0.0D;
/* 143 */           if ((SETT.JOBS()).getter.get(it.tile()) == null) {
/* 144 */             Terrain.TerrainTile t = SETT.TERRAIN().get(it.tile());
/* 145 */             if (t instanceof settlement.tilemap.terrain.TForest.Tree) {
/* 146 */               v = Math.max(v, 0.5D + 0.5D * (SETT.TERRAIN()).TREES.amount.get(it.tile()) / 4.0D);
/*     */             }
/*     */           } 
/*     */           
/* 150 */           renderUnder(v, r, it, false);
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected CharSequence problem(int tx, int ty, boolean overwrite) {
/* 158 */     if (super.problem(tx, ty, overwrite) != null)
/* 159 */       return super.problem(tx, ty, overwrite); 
/* 160 */     if (!(SETT.TERRAIN()).TREES.isTree(tx, ty)) {
/* 161 */       return PlacableMessages.¤¤TREE_MUST;
/*     */     }
/* 163 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   Addable overlay() {
/* 168 */     return this.a;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\job\JobClears$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */