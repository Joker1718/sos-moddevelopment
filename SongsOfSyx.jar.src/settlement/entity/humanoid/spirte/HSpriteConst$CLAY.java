/*     */ package settlement.entity.humanoid.spirte;
/*     */ 
/*     */ import game.GAME;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CLAY
/*     */ {
/*  97 */   static int i = 0;
/*  98 */   public static final int PANTS = i++ * 8;
/*  99 */   static final int TORSO = i++ * 8;
/* 100 */   static final int ARMS = i++ * 8;
/* 101 */   static final int HEAD = i++ * 8; private static final int[] exWATER;
/* 102 */   static final int SHADOW = i++ * 8; static {
/* 103 */     i = 0;
/* 104 */     exWATER = new int[] { 0, 8, 16, 24 };
/*     */   }
/*     */   static final int off = -16;
/*     */   static final int offC = 64;
/*     */   
/*     */   public static void filth(Induvidual indu, int dir, int x, int y) {
/* 110 */     double am = STATS.NEEDS().grime(indu);
/* 111 */     texture((indu.race().appearance().sheet(indu)).sheet.lay, (RACES.sprites()).Lgrit, am, STATS.RAN().get(indu, 0), dir, x, y);
/*     */   }
/*     */   
/*     */   public static void filth(Race race, boolean adult, double am, int dir, int ran, int x, int y) {
/* 115 */     texture(adult ? (race.appearance().adult()).sheet.lay : (race.appearance().child()).sheet.lay, (RACES.sprites()).Lgrit, am, ran, dir, x, y);
/*     */   }
/*     */   
/*     */   public static void blood(Induvidual indu, int dir, int x, int y) {
/* 119 */     double am = (STATS.NEEDS()).INJURIES.COUNT.indu().getD(indu);
/* 120 */     (indu.race().appearance()).colors.blood.bind();
/* 121 */     texture((indu.race().appearance().sheet(indu)).sheet.lay, (RACES.sprites()).Lblood, am, STATS.RAN().get(indu, 0), dir, x, y);
/* 122 */     COLOR.unbind();
/*     */   }
/*     */   
/*     */   private static void texture(TILE_SHEET sheet, TILE_SHEET ex, double am, long ran, int dir, int x, int y) {
/* 126 */     if (am == 0.0D)
/*     */       return; 
/* 128 */     int i = (int)(am * 7.0D) * 8;
/* 129 */     i = (int)(i + (ran & 0x7L));
/* 130 */     sheet.renderTextured(ex.getTexture(i), SHADOW + dir, x, y);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void water(Induvidual indu, int dir, int x, int y) {
/* 135 */     (indu.race().appearance().sheet(indu)).sheet.lay.renderTextured((indu.race().appearance()).extra.Lwater.getTexture(exWATER[GAME.intervals().get05() & 0x3] + dir), SHADOW + dir, x, y);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\spirte\HSpriteConst$CLAY.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */