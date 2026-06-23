/*     */ package settlement.entity.humanoid.spirte;
/*     */ 
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.race.appearence.RAddon;
/*     */ import init.race.appearence.RType;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.colls.StatsAppearance;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ import snake2d.util.sprite.TextureCoords;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class HCorpseRenderer
/*     */ {
/*  24 */   private static final COLOR decayC = (COLOR)new ColorImp(48, 24, 12);
/*  25 */   private static final ColorImp inter = new ColorImp();
/*     */ 
/*     */ 
/*     */   
/*     */   public static void renderSkelleton(Race race, boolean adult, int direction, boolean inWater, Renderer r, ShadowBatch s, int ran, int x, int y) {
/*  30 */     x -= 16;
/*  31 */     y -= 16;
/*  32 */     int dir = direction;
/*  33 */     if (inWater)
/*     */       return; 
/*  35 */     s.setHeight(2).setDistance2Ground(0.0D);
/*  36 */     TILE_SHEET sheet = race.appearance().skelleton(adult);
/*  37 */     int tile = 8 * (ran & 0x1) + dir;
/*  38 */     sheet.render((SPRITE_RENDERER)r, tile, x, y);
/*  39 */     sheet.render((SPRITE_RENDERER)s, tile, x, y);
/*  40 */     tile = 16 + 8 * (ran & 0x3) + dir;
/*  41 */     sheet.render((SPRITE_RENDERER)r, tile, x, y);
/*  42 */     sheet.render((SPRITE_RENDERER)s, tile, x, y);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void renderCorpse(Induvidual indu, int direction, boolean inWater, double decay, Renderer r, ShadowBatch s, int x, int y, int distToground) {
/*  51 */     x -= 16;
/*  52 */     y -= 16;
/*  53 */     int dir = direction;
/*     */ 
/*     */ 
/*     */     
/*  57 */     TILE_SHEET sheet = (indu.race().appearance().sheet(indu)).sheet.lay;
/*     */ 
/*     */     
/*  60 */     if (!inWater) {
/*  61 */       s.setHeight(3).setDistance2Ground(distToground);
/*  62 */       sheet.render((SPRITE_RENDERER)s, HSpriteConst.CLAY.SHADOW + dir, x, y);
/*     */     } 
/*     */     
/*  65 */     StatsAppearance ap = STATS.APPEARANCE();
/*  66 */     inter.interpolate(ap.colorLegs(indu), decayC, decay).bind();
/*  67 */     sheet.render((SPRITE_RENDERER)r, HSpriteConst.CLAY.PANTS + dir, x, y);
/*  68 */     inter.interpolate(ap.colorSkin(indu), decayC, decay).bind();
/*  69 */     sheet.render((SPRITE_RENDERER)r, HSpriteConst.CLAY.ARMS + dir, x, y);
/*  70 */     for (RAddon add : ((RType)(indu.race().appearance()).types.get(ap.gender.get(indu))).addonsBelow) {
/*  71 */       add.renderLaying(r, dir, x, y, indu, false, decayC, decay);
/*     */     }
/*  73 */     inter.bind();
/*  74 */     sheet.render((SPRITE_RENDERER)r, HSpriteConst.CLAY.HEAD + dir, x, y);
/*  75 */     inter.interpolate(ap.colorClothes(indu), decayC, decay).bind();
/*  76 */     sheet.render((SPRITE_RENDERER)r, HSpriteConst.CLAY.TORSO + dir, x, y);
/*     */     
/*  78 */     for (RAddon add : ((RType)(indu.race().appearance()).types.get(ap.gender.get(indu))).addonsAbove) {
/*  79 */       add.renderLaying(r, dir, x, y, indu, false, decayC, decay);
/*     */     }
/*  81 */     COLOR.unbind();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  89 */     OPACITY.O99.bind();
/*  90 */     inter.interpolate(COLOR.WHITE100, decayC, decay).bind();
/*     */     
/*  92 */     HSpriteConst.CLAY.blood(indu, dir, x, y);
/*  93 */     HSpriteConst.CLAY.filth(indu, dir, x, y);
/*     */     
/*  95 */     if (inWater) {
/*  96 */       HSpriteConst.CLAY.water(indu, dir, x, y);
/*     */     }
/*     */     
/*  99 */     OPACITY.unbind();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void renderDump(Race race, double decay, int dir, Renderer r, ShadowBatch s, int ran, int x, int y) {
/* 106 */     x -= 16;
/* 107 */     y -= 16;
/*     */ 
/*     */     
/* 110 */     TILE_SHEET sheet = (race.appearance().adult()).sheet.lay;
/*     */     
/* 112 */     s.setHeight(3).setDistance2Ground(0.0D);
/* 113 */     sheet.render((SPRITE_RENDERER)s, HSpriteConst.CLAY.SHADOW + dir, x, y);
/*     */     
/* 115 */     decayC.bind();
/* 116 */     sheet.render((SPRITE_RENDERER)r, HSpriteConst.CLAY.PANTS + dir, x, y);
/* 117 */     sheet.render((SPRITE_RENDERER)r, HSpriteConst.CLAY.ARMS + dir, x, y);
/* 118 */     sheet.render((SPRITE_RENDERER)r, HSpriteConst.CLAY.HEAD + dir, x, y);
/* 119 */     sheet.render((SPRITE_RENDERER)r, HSpriteConst.CLAY.TORSO + dir, x, y);
/* 120 */     COLOR.unbind();
/*     */     
/* 122 */     OPACITY.O99.bind();
/* 123 */     inter.interpolate(COLOR.WHITE100, decayC, decay).bind();
/*     */     
/* 125 */     HSpriteConst.CLAY.filth(race, true, decay, dir, ran, x, y);
/*     */     
/* 127 */     OPACITY.unbind();
/* 128 */     COLOR.unbind();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void renderGore(Induvidual indu, int direction, boolean inWater, double decay, Renderer r, ShadowBatch s, int x, int y) {
/* 136 */     int ran = STATS.RAN().get(indu, 16) & 0x7;
/*     */     
/* 138 */     x -= 16;
/* 139 */     y -= 16;
/* 140 */     int dir = direction;
/*     */     
/* 142 */     TILE_SHEET stencil = (RACES.sprites()).gore_stencil;
/*     */     
/* 144 */     COLOR blood = (indu.race().appearance()).colors.blood;
/*     */     
/* 146 */     TILE_SHEET sheet = (indu.race().appearance().sheet(indu)).sheet.lay;
/*     */ 
/*     */     
/* 149 */     if (!inWater) {
/* 150 */       s.setHeight(3).setDistance2Ground(0.0D);
/* 151 */       sheet.render((SPRITE_RENDERER)s, HSpriteConst.CLAY.SHADOW + dir, x, y);
/*     */     } 
/*     */     
/* 154 */     StatsAppearance ap = STATS.APPEARANCE();
/* 155 */     inter.interpolate(ap.colorLegs(indu), decayC, decay).bind();
/* 156 */     stencil.renderTextured(sheet.getTexture(HSpriteConst.CLAY.PANTS + dir), ran, x, y);
/*     */ 
/*     */     
/* 159 */     inter.interpolate(ap.colorSkin(indu), decayC, decay).bind();
/* 160 */     stencil.renderTextured(sheet.getTexture(HSpriteConst.CLAY.ARMS + dir), ran, x, y);
/* 161 */     stencil.renderTextured(sheet.getTexture(HSpriteConst.CLAY.HEAD + dir), ran, x, y);
/*     */     
/* 163 */     inter.interpolate(ap.colorClothes(indu), decayC, decay).bind();
/* 164 */     stencil.renderTextured(sheet.getTexture(HSpriteConst.CLAY.TORSO + dir), ran, x, y);
/*     */     
/* 166 */     for (RAddon add : ((RType)(indu.race().appearance()).types.get(ap.gender.get(indu))).addonsAbove) {
/* 167 */       add.renderLayingTextured(stencil, ran, r, dir, x, y, indu, false);
/*     */     }
/* 169 */     COLOR.unbind();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 175 */     inter.interpolate(blood, decayC, decay).bind();
/* 176 */     TextureCoords overlay = (RACES.sprites()).gore_overlay.getTexture(ran);
/* 177 */     sheet.renderTextured(overlay, HSpriteConst.CLAY.SHADOW + dir, x, y);
/*     */ 
/*     */ 
/*     */     
/* 181 */     HSpriteConst.CLAY.filth(indu, dir, x, y);
/*     */     
/* 183 */     if (inWater) {
/* 184 */       HSpriteConst.CLAY.water(indu, dir, x, y);
/*     */     }
/*     */     
/* 187 */     OPACITY.unbind();
/* 188 */     COLOR.unbind();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\spirte\HCorpseRenderer.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */