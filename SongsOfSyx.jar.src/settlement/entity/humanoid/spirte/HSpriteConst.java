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
/*     */ final class HSpriteConst
/*     */ {
/*  18 */   private static int i = 0;
/*     */   private static final int NR = 8;
/*  20 */   static final int IFEET_NONE = i++ * 8;
/*  21 */   static final int IFEET_RIGHT = i++ * 8;
/*  22 */   static final int IFEET_RIGHT2 = i++ * 8;
/*  23 */   static final int IFEET_LEFT = i++ * 8;
/*  24 */   static final int IFEET_LEFT2 = i++ * 8;
/*  25 */   static final int ITUNIC = i++ * 8;
/*  26 */   static final int ITORSO_STILL = i++ * 8;
/*  27 */   static final int ITORSO_RIGHT = i++ * 8;
/*  28 */   static final int ITORSO_RIGHT2 = i++ * 8;
/*  29 */   static final int ITORSO_RIGHT3 = i++ * 8;
/*  30 */   static final int ITORSO_LEFT = i++ * 8;
/*  31 */   static final int ITORSO_LEFT2 = i++ * 8;
/*  32 */   static final int ITORSO_LEFT3 = i++ * 8;
/*  33 */   static final int ITORSO_CARRY = i++ * 8;
/*  34 */   static final int ITORSO_OUT = i++ * 8;
/*  35 */   static final int ITORSO_OUT2 = i++ * 8;
/*     */   
/*  37 */   static final int IHEAD = i++ * 8;
/*  38 */   static final int ISHADOW = i++ * 8;
/*     */ 
/*     */   
/*  41 */   static final int[][] ITOOL = new int[][] {
/*  42 */       { 0, 8, 16
/*  43 */       }, { 0, 8, 16 } }; static final int HAMMER1;
/*     */   static final int HAMMER2;
/*     */   static final int HAMMER3;
/*  46 */   static final int[][] IWEAPON = new int[][] {
/*  47 */       { 0, 8, 16
/*  48 */       }, { 0, 8, 16 } }; static final int HAMMER4;
/*     */   static final int HAMMER5;
/*     */   
/*     */   static {
/*  52 */     i = 0;
/*     */ 
/*     */     
/*  55 */     HAMMER1 = i++;
/*  56 */     HAMMER2 = i++ * 8;
/*  57 */     HAMMER3 = i++ * 8;
/*  58 */     HAMMER4 = i++ * 8;
/*  59 */     HAMMER5 = i++ * 8;
/*  60 */     HAMMER6 = i++ * 8;
/*     */ 
/*     */ 
/*     */     
/*  64 */     TROLLY = new int[] { 0, 8, 16, 24 };
/*     */   }
/*     */   
/*     */   static final int HAMMER6;
/*     */   static final int[] TROLLY;
/*     */   
/*     */   public static void filth(Induvidual indu, int torse, int x, int y) {
/*  71 */     double am = STATS.NEEDS().grime(indu);
/*  72 */     texture((indu.race().appearance().sheet(indu)).sheet.sheet, (RACES.sprites()).grit, am, STATS.RAN().get(indu, 0), torse, x, y);
/*     */   }
/*     */   static final int SWORD1 = 0; static final int SWORD2 = 8; static final int SWORD3 = 16;
/*     */   public static void blood(Induvidual indu, int torse, int x, int y) {
/*  76 */     double am = (STATS.NEEDS()).INJURIES.COUNT.indu().getD(indu);
/*  77 */     (indu.race().appearance()).colors.blood.bind();
/*  78 */     texture((indu.race().appearance().sheet(indu)).sheet.sheet, (RACES.sprites()).blood, am, STATS.RAN().get(indu, 0), torse, x, y);
/*  79 */     COLOR.unbind();
/*     */   }
/*     */   
/*     */   private static void texture(TILE_SHEET sheet, TILE_SHEET ex, double am, long ran, int torse, int x, int y) {
/*  83 */     if (am == 0.0D)
/*     */       return; 
/*  85 */     int i = (int)(am * 7.0D) * 8;
/*  86 */     i = (int)(i + (ran & 0x7L));
/*  87 */     sheet.renderTextured(ex.getTexture(i), torse, x, y);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void water(Induvidual indu, int dir, int torso, int x, int y) {
/*  92 */     (indu.race().appearance().sheet(indu)).sheet.sheet.renderTextured((indu.race().appearance()).extra.water.getTexture(CLAY.exWATER[GAME.intervals().get05() & 0x3] + dir), torso, x, y);
/*     */   }
/*     */ 
/*     */   
/*     */   public static class CLAY
/*     */   {
/*     */     public static final int PANTS = i++ * 8;
/*     */     
/*     */     static final int TORSO = i++ * 8;
/*     */     
/*     */     static final int ARMS = i++ * 8;
/* 103 */     static int i = 0; static final int HEAD = i++ * 8; static final int SHADOW = i++ * 8;
/* 104 */     private static final int[] exWATER = new int[] { 0, 8, 16, 24 }; static final int off = -16; static final int offC = 64;
/*     */     static {
/*     */     
/*     */     }
/*     */     
/*     */     public static void filth(Induvidual indu, int dir, int x, int y) {
/* 110 */       double am = STATS.NEEDS().grime(indu);
/* 111 */       texture((indu.race().appearance().sheet(indu)).sheet.lay, (RACES.sprites()).Lgrit, am, STATS.RAN().get(indu, 0), dir, x, y);
/*     */     }
/*     */     
/*     */     public static void filth(Race race, boolean adult, double am, int dir, int ran, int x, int y) {
/* 115 */       texture(adult ? (race.appearance().adult()).sheet.lay : (race.appearance().child()).sheet.lay, (RACES.sprites()).Lgrit, am, ran, dir, x, y);
/*     */     }
/*     */     
/*     */     public static void blood(Induvidual indu, int dir, int x, int y) {
/* 119 */       double am = (STATS.NEEDS()).INJURIES.COUNT.indu().getD(indu);
/* 120 */       (indu.race().appearance()).colors.blood.bind();
/* 121 */       texture((indu.race().appearance().sheet(indu)).sheet.lay, (RACES.sprites()).Lblood, am, STATS.RAN().get(indu, 0), dir, x, y);
/* 122 */       COLOR.unbind();
/*     */     }
/*     */     
/*     */     private static void texture(TILE_SHEET sheet, TILE_SHEET ex, double am, long ran, int dir, int x, int y) {
/* 126 */       if (am == 0.0D)
/*     */         return; 
/* 128 */       int i = (int)(am * 7.0D) * 8;
/* 129 */       i = (int)(i + (ran & 0x7L));
/* 130 */       sheet.renderTextured(ex.getTexture(i), SHADOW + dir, x, y);
/*     */     }
/*     */ 
/*     */     
/*     */     public static void water(Induvidual indu, int dir, int x, int y) {
/* 135 */       (indu.race().appearance().sheet(indu)).sheet.lay.renderTextured((indu.race().appearance()).extra.Lwater.getTexture(exWATER[GAME.intervals().get05() & 0x3] + dir), SHADOW + dir, x, y);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\spirte\HSpriteConst.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */