/*     */ package settlement.job;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import settlement.overlay.Addable;
/*     */ import settlement.tilemap.terrain.TRock;
/*     */ import settlement.tilemap.terrain.Terrain;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.rendering.RenderData;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends Addable
/*     */ {
/*     */   public void renderBelow(Renderer r, RenderData.RenderIterator it) {
/*  91 */     double v = 0.0D;
/*  92 */     if ((SETT.JOBS()).getter.get(it.tile()) == null) {
/*  93 */       Terrain.TerrainTile t = SETT.TERRAIN().get(it.tile());
/*  94 */       if (t instanceof TRock) {
/*  95 */         TRock b = (TRock)t;
/*  96 */         b.getClass(); v = Math.max(v, 0.5D + 0.5D * b.amountGet(it.tx(), it.ty()) / 15.0D);
/*     */       } 
/*     */     } 
/*     */     
/* 100 */     renderUnder(v, r, it, false);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\job\JobClears$1$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */