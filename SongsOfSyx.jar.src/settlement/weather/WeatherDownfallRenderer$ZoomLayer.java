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
/*     */ class ZoomLayer
/*     */ {
/*     */   private static int absX1;
/*     */   private static int absY1;
/*     */   private static int absX2;
/*     */   private static int absY2;
/*     */   private static int gx1;
/*     */   private static int gy1;
/*     */   
/*     */   static void init(RenderData data, int zoomout, int z) {
/* 154 */     absX1 = data.absBounds().x1() >> zoomout << z;
/* 155 */     absY1 = data.absBounds().y1() >> zoomout << z;
/* 156 */     absX2 = data.absBounds().x2() >> zoomout << z;
/* 157 */     absY2 = data.absBounds().y2() >> zoomout << z;
/*     */ 
/*     */     
/* 160 */     gx1 = data.gBounds().x1() - data.absBounds().x1();
/* 161 */     gy1 = data.gBounds().y1() - data.absBounds().y1();
/*     */     
/* 163 */     if (data.gBounds().x1() < 0) {
/* 164 */       absX1 += -(data.gBounds().x1() >> zoomout << z);
/*     */     }
/* 166 */     if (data.gBounds().y1() < 0) {
/* 167 */       absY1 += -(data.gBounds().y1() >> zoomout << z);
/*     */     }
/* 169 */     if (data.gBounds().x2() > SETT.PWIDTH) {
/* 170 */       absX2 -= data.gBounds().x2() - SETT.PWIDTH >> zoomout << z;
/*     */     }
/* 172 */     if (data.gBounds().y2() > SETT.PHEIGHT)
/* 173 */       absY2 -= data.gBounds().y2() - SETT.PHEIGHT >> zoomout << z; 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\weather\WeatherDownfallRenderer$ZoomLayer.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */