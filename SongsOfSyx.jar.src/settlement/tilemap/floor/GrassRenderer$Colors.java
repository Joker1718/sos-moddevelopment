/*     */ package settlement.tilemap.floor;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import util.spritecomposer.ComposerDests;
/*     */ import util.spritecomposer.ComposerSources;
/*     */ import util.spritecomposer.ComposerThings;
/*     */ import util.spritecomposer.ComposerUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class Colors
/*     */ {
/*     */   private static final int RAN = 4;
/* 222 */   private final COLOR[][] c_base = new COLOR[15][4];
/* 223 */   private final ColorImp[][] c_current = new ColorImp[15][4];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final COLOR dry;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final COLOR winter;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final ColorImp tmp;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private COLOR get(int c, int ran) {
/* 289 */     return (COLOR)this.c_current[c][ran & 0x3];
/*     */   }
/*     */   
/*     */   void update(double ds) {
/* 293 */     double m = (SETT.WEATHER()).moisture.getD();
/* 294 */     if (m < 0.25D) {
/* 295 */       m = 0.05D;
/* 296 */     } else if (m < 0.5D) {
/* 297 */       m -= 0.25D;
/* 298 */       m /= 0.25D;
/* 299 */       m = CLAMP.d(m, 0.05D, 1.0D);
/*     */     } else {
/* 301 */       m = 1.0D;
/*     */     } 
/* 303 */     set(m, 1.0D - (SETT.WEATHER()).growth.getD());
/*     */   }
/*     */   
/* 306 */   Colors() throws IOException { this.tmp = new ColorImp(); COLOR fertile = (new ComposerThings.IColorSamplerSingle() { protected COLOR init(ComposerUtil c, ComposerSources s, ComposerDests d) { s.full.init(0, 0, 1, 1, 8, 1, d.s24); return s.full.sample(); } }
/*     */       ).getHalf(); COLOR infertile = (new ComposerThings.IColorSamplerSingle() { protected COLOR init(ComposerUtil c, ComposerSources s, ComposerDests d) { s.full.setSkip(1, 1); return s.full.sample(); } }
/*     */       ).getHalf(); this.dry = (new ComposerThings.IColorSamplerSingle() { protected COLOR init(ComposerUtil c, ComposerSources s, ComposerDests d) { s.full.setSkip(1, 2); return s.full.sample(); } }
/* 309 */       ).getHalf(); this.winter = (new ComposerThings.IColorSamplerSingle() { protected COLOR init(ComposerUtil c, ComposerSources s, ComposerDests d) { s.full.setSkip(1, 3); return s.full.sample(); } }).getHalf(); int skip = 5; ColorImp[] arrayOfColorImp = COLOR.interpolate(infertile, fertile, 11); for (int i = 0; i < 15; i++) { ColorImp colorImp = arrayOfColorImp[CLAMP.i(i - skip, 0, i)]; this.c_base[i][0] = (COLOR)colorImp; this.c_current[i][0] = new ColorImp(this.c_base[i][0]); for (int k = 1; k < 4; k++) { this.c_base[i][k] = (COLOR)colorImp.shade(RND.rFloat1(0.05D)); this.c_current[i][k] = new ColorImp(this.c_base[i][k]); }  }  } private void set(double moist, double winter) { for (int a = 0; a < 15; a++) {
/* 310 */       for (int b = 0; b < 4; b++) {
/* 311 */         this.tmp.interpolate(this.dry, this.c_base[a][b], moist);
/* 312 */         this.c_current[a][b].interpolate((COLOR)this.tmp, this.winter, winter * 0.75D);
/*     */       } 
/*     */     }  }
/*     */ 
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\floor\GrassRenderer$Colors.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */