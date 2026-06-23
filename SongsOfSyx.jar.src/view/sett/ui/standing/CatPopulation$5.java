/*     */ package view.sett.ui.standing;
/*     */ 
/*     */ import game.boosting.BOOSTABLES;
/*     */ import init.race.Race;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GText;
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
/*     */ class null
/*     */   extends GStaples
/*     */ {
/*     */   double demoMax;
/*     */   
/*     */   null(int $anonymous0) {
/* 199 */     super($anonymous0);
/*     */   }
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/* 203 */     this.demoMax = 0.0D;
/* 204 */     for (int i = 0; i < STATS.POP().demography().historyRecords(); i++) {
/* 205 */       if (STATS.POP().demography().getD(CatPopulation.this.race.get(), i) > this.demoMax)
/* 206 */         this.demoMax = STATS.POP().demography().getD(CatPopulation.this.race.get(), i); 
/* 207 */     }  super.render(r, ds, isHovered);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void hover(GBox text, int stapleI) {
/* 212 */     int k = stapleI;
/* 213 */     text.title((STATS.POP().demography().info()).name);
/* 214 */     if (CatPopulation.this.race.get() != null) {
/* 215 */       GText gText = text.text();
/* 216 */       gText.add(CatPopulation.¤¤age);
/* 217 */       double da = ((Race)CatPopulation.this.race.get()).bvalue((BOOSTABLES.PHYSICS()).DEATH_AGE);
/*     */ 
/*     */       
/* 220 */       int from = (int)(k * da / (STATS.POP().demography().historyRecords() - 1));
/* 221 */       gText.insert(0, from);
/*     */       
/* 223 */       if (k == STATS.POP().demography().historyRecords() - 1) {
/* 224 */         gText.insert(1, '+');
/*     */       } else {
/* 226 */         int to = (int)((k + 1) * da) / (STATS.POP().demography().historyRecords() - 1);
/* 227 */         gText.insert(1, to);
/*     */       } 
/*     */       
/* 230 */       gText.insert(2, (int)STATS.POP().demography().getD(CatPopulation.this.race.get(), k));
/* 231 */       text.add((SPRITE)gText);
/*     */       
/* 233 */       text.NL(8);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected double getValue(int stapleI) {
/* 245 */     int k = stapleI;
/* 246 */     double am = STATS.POP().demography().getD(CatPopulation.this.race.get(), k);
/* 247 */     if (this.demoMax > 0.0D) {
/* 248 */       am /= this.demoMax;
/*     */     }
/* 250 */     return am;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void setColor(ColorImp c, int stapleI, double value) {
/* 255 */     c.set((GCOLOR.UI()).SOSO.hovered);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\standing\CatPopulation$5.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */