/*     */ package settlement.weather;
/*     */ 
/*     */ import settlement.main.SETT;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class SkyLayer
/*     */ {
/*     */   private int sqStartX;
/*     */   private int sqStartY;
/*     */   private int sqIX;
/*     */   private int sqIY;
/*     */   private int sqIW;
/*     */   private int sqIH;
/*     */   
/*     */   void init(RenderData data, int zoomout, int z, double skyzoom) {
/* 186 */     int skyX = (int)((data.gBounds().x1() + SETT.PWIDTH / 2) * skyzoom);
/* 187 */     int skyY = (int)((data.gBounds().y1() + SETT.PHEIGHT / 2) * skyzoom);
/*     */ 
/*     */     
/* 190 */     this.sqIX = skyX / WeatherDownfallRenderer.squareSize;
/* 191 */     this.sqIY = skyY / WeatherDownfallRenderer.squareSize;
/* 192 */     this.sqStartX = skyX % WeatherDownfallRenderer.squareSize;
/* 193 */     this.sqStartY = skyY % WeatherDownfallRenderer.squareSize;
/* 194 */     this.sqStartX = WeatherDownfallRenderer.ZoomLayer.absX1 - this.sqStartX;
/* 195 */     this.sqStartY = WeatherDownfallRenderer.ZoomLayer.absY1 - this.sqStartY;
/*     */ 
/*     */     
/* 198 */     this.sqIW = (int)Math.ceil((WeatherDownfallRenderer.squareSize / 2.0D + WeatherDownfallRenderer.ZoomLayer.absX2 - this.sqStartX) / WeatherDownfallRenderer.squareSize);
/* 199 */     this.sqIH = (int)Math.ceil((WeatherDownfallRenderer.squareSize / 2.0D + WeatherDownfallRenderer.ZoomLayer.absY2 - this.sqStartY) / WeatherDownfallRenderer.squareSize);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\weather\WeatherDownfallRenderer$SkyLayer.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */