/*     */ package settlement.room.water;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import settlement.overlay.Addable;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import util.GUTIL;
/*     */ import util.rendering.RenderData;
/*     */ import view.tool.ToolPlacer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Overlay
/*     */   extends Addable
/*     */ {
/*     */   public Overlay() {
/* 223 */     super(true, false);
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderBelow(Renderer r, RenderData.RenderIterator it) {
/* 228 */     if ((SETT.ROOMS()).construction.isser.is(it.tile()))
/*     */       return; 
/* 230 */     double d = (SETT.GROUND()).MOISTURE_TOT.get(it.tile());
/* 231 */     if (GUTIL.flooder().hasBeenPushed(it.tx(), it.ty())) {
/* 232 */       d += 2.0D * (1.0D - CLAMP.d(GUTIL.flooder().getValue(it.tx(), it.ty()) / 15.0D, 0.0D, 1.0D));
/*     */     }
/* 234 */     d = CLAMP.d(d, 0.0D, 1.0D);
/* 235 */     renderUnder(d, r, it, false);
/* 236 */     if (d > 0.75D) {
/* 237 */       d = (d - 0.75D) * 4.0D;
/* 238 */       renderPluses(d, r, it);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void initBelow(RenderData data) {
/* 245 */     for (COORDINATE c : data.tBounds()) {
/* 246 */       if (SETT.IN_BOUNDS(c)) {
/* 247 */         GUTIL.flooder().setValue2(c, 0.0D);
/*     */       }
/*     */     } 
/* 250 */     AREA a = ToolPlacer.area();
/* 251 */     if (a.area() == 0) {
/*     */       return;
/*     */     }
/* 254 */     GUTIL.flooder().init(this);
/*     */ 
/*     */     
/* 257 */     for (COORDINATE c : a.body()) {
/* 258 */       if (a.is(c) && c.distance(data.tBounds().cX(), data.tBounds().cY()) < (Math.max(data.tBounds().width() / 2, data.tBounds().height() / 2) + 18)) {
/* 259 */         GUTIL.flooder().pushSloppy(c, 0.0D);
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 265 */     while (GUTIL.flooder().hasMore()) {
/* 266 */       PathTile t = GUTIL.flooder().pollSmallest();
/* 267 */       if (t.getValue() >= 15.0F) {
/*     */         continue;
/*     */       }
/* 270 */       for (DIR d : DIR.ALL) {
/* 271 */         if (SETT.IN_BOUNDS((COORDINATE)t, d)) {
/* 272 */           GUTIL.flooder().pushSloppy((COORDINATE)t, d, t.getValue() + d.tileDistance());
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 277 */     super.initBelow(data);
/*     */   }
/*     */ 
/*     */   
/*     */   public void finishBelow() {
/* 282 */     GUTIL.flooder().done();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\water\Canal$Overlay.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */