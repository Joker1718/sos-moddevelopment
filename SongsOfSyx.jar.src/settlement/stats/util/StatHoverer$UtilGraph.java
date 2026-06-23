/*     */ package settlement.stats.util;
/*     */ 
/*     */ import init.race.Race;
/*     */ import init.type.HCLASS;
/*     */ import settlement.stats.stat.SETT_STATISTICS;
/*     */ import settlement.stats.stat.STAT;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.TextureCoords;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.table.GStaples;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class UtilGraph
/*     */   implements SPRITE
/*     */ {
/* 258 */   private final GStaples staples = new GStaples(32)
/*     */     {
/*     */       protected void hover(GBox box, int stapleI) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       protected double getValue(int stapleI) {
/* 268 */         int fromZero = 32 - stapleI - 1;
/* 269 */         if (!StatHoverer.UtilGraph.this.valuev && StatHoverer.UtilGraph.this.global instanceof STAT) {
/*     */           
/* 271 */           STAT s = (STAT)StatHoverer.UtilGraph.this.global;
/* 272 */           double m = s.standing.max(StatHoverer.UtilGraph.this.c, StatHoverer.UtilGraph.this.race);
/* 273 */           if (m <= 0.0D)
/* 274 */             return 0.0D; 
/* 275 */           if (s.standing().max(StatHoverer.UtilGraph.this.c, StatHoverer.UtilGraph.this.race, fromZero) > 0.0D) {
/* 276 */             return s.standing().get(StatHoverer.UtilGraph.this.c, StatHoverer.UtilGraph.this.race, StatHoverer.UtilGraph.this.global.data(StatHoverer.UtilGraph.this.c).getD(StatHoverer.UtilGraph.this.race, fromZero)) / m;
/*     */           }
/*     */         } 
/*     */         
/* 280 */         return StatHoverer.UtilGraph.this.global.data(StatHoverer.UtilGraph.this.c).getD(StatHoverer.UtilGraph.this.race, fromZero);
/*     */       }
/*     */ 
/*     */       
/*     */       protected void setColor(ColorImp col, int stapleI, double value) {
/* 285 */         int fromZero = 32 - stapleI - 1;
/*     */         
/* 287 */         if (!StatHoverer.UtilGraph.this.valuev && StatHoverer.UtilGraph.this.global instanceof STAT) {
/* 288 */           STAT s = (STAT)StatHoverer.UtilGraph.this.global;
/* 289 */           if (s.standing().max(StatHoverer.UtilGraph.this.c, StatHoverer.UtilGraph.this.race, fromZero) > 0.0D) {
/* 290 */             col.set((GCOLOR.UI()).NEUTRAL.normal);
/*     */             return;
/*     */           } 
/*     */         } 
/* 294 */         col.set(COLOR.WHITE65);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       protected void setColorBg(ColorImp col, int stapleI, double value) {
/* 300 */         col.set(COLOR.WHITE05);
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*     */   private SETT_STATISTICS global;
/*     */   private HCLASS c;
/*     */   private Race race;
/*     */   private boolean valuev;
/*     */   
/*     */   UtilGraph() {
/* 311 */     this.staples.body().setDim(250.0D, 64.0D);
/* 312 */     this.staples.normalize(false);
/*     */   }
/*     */   
/*     */   SPRITE init(HCLASS c, SETT_STATISTICS global, boolean isInt, Race race, boolean isValue) {
/* 316 */     this.valuev = isValue;
/* 317 */     this.c = c;
/* 318 */     this.global = global;
/* 319 */     this.race = race;
/* 320 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public int width() {
/* 325 */     return this.staples.body().width();
/*     */   }
/*     */ 
/*     */   
/*     */   public int height() {
/* 330 */     return this.staples.body().height();
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 335 */     this.staples.body().moveX1Y1(X1, Y1);
/* 336 */     this.staples.render(r, 0.0F);
/*     */   }
/*     */   
/*     */   public void renderTextured(TextureCoords texture, int X1, int X2, int Y1, int Y2) {}
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stat\\util\StatHoverer$UtilGraph.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */