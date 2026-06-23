/*     */ package settlement.entity.humanoid.spirte;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.time.TIME;
/*     */ import init.race.Race;
/*     */ import init.race.appearence.RAddon;
/*     */ import init.race.appearence.RExtras;
/*     */ import init.race.appearence.RType;
/*     */ import init.resources.RESOURCE;
/*     */ import settlement.entity.animal.AnimalSpecies;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.colls.StatsAppearance;
/*     */ import settlement.stats.equip.EquipBattle;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class HSprite
/*     */ {
/*     */   public final double time;
/*     */   public final double height;
/*     */   
/*     */   public void render(Induvidual in2, double spriteTimer, double movementTimer, boolean inWater, DIR dirr, RESOURCE carried, int resAm, Renderer r, ShadowBatch s, float ds, int x, int y) {}
/*     */   
/*     */   public void render(Humanoid a, AIManager d, Renderer r, ShadowBatch s, float ds, int x, int y) {}
/*     */   
/*     */   protected boolean isDone(Humanoid a) {
/*  57 */     return true;
/*     */   }
/*     */   
/*     */   public abstract void tick(Humanoid paramHumanoid, double paramDouble);
/*     */   
/*     */   HSprite(double time) {
/*  63 */     this(time, 1.0D);
/*     */   }
/*     */   
/*     */   HSprite(double time, double height) {
/*  67 */     this.time = time;
/*  68 */     this.height = height;
/*     */   }
/*     */   
/*     */   public abstract void renderSimple(Humanoid paramHumanoid, AIManager paramAIManager, Renderer paramRenderer, ShadowBatch paramShadowBatch, float paramFloat, int paramInt1, int paramInt2);
/*     */   
/*     */   static class Standing extends HSprite {
/*     */     private boolean carries;
/*  75 */     protected static final int[] feets = new int[] { HSpriteConst.IFEET_NONE, HSpriteConst.IFEET_RIGHT, HSpriteConst.IFEET_RIGHT2, HSpriteConst.IFEET_RIGHT, HSpriteConst.IFEET_NONE, HSpriteConst.IFEET_LEFT, HSpriteConst.IFEET_LEFT2, HSpriteConst.IFEET_LEFT }; private final int[] torsos;
/*  76 */     private static final int[] swim = new int[] { 
/*  77 */         HSpriteConst.ITORSO_STILL, HSpriteConst.ITORSO_LEFT, HSpriteConst.ITORSO_LEFT2, HSpriteConst.ITORSO_LEFT3, HSpriteConst.ITORSO_LEFT2, HSpriteConst.ITORSO_LEFT, HSpriteConst.ITORSO_STILL, HSpriteConst.ITORSO_RIGHT, HSpriteConst.ITORSO_RIGHT2, HSpriteConst.ITORSO_RIGHT3, HSpriteConst.ITORSO_RIGHT2, HSpriteConst.ITORSO_RIGHT };
/*     */     final double fps;
/*     */     
/*     */     Standing(double fps, boolean carries, int... torsos) {
/*  81 */       super((fps > 0.0D) ? (torsos.length / fps) : 0.0D);
/*  82 */       this.fps = fps;
/*  83 */       this.carries = carries;
/*  84 */       if (torsos.length == 0)
/*  85 */         throw new RuntimeException(); 
/*  86 */       this.torsos = torsos;
/*     */     }
/*     */     
/*     */     protected int getDir(Humanoid a, float timer) {
/*  90 */       return a.speed.dir().id();
/*     */     }
/*     */     
/*     */     protected int getFeet(Induvidual a, double movementTimer, int dir, float ds) {
/*  94 */       double s = movementTimer;
/*  95 */       if (s <= 0.0D)
/*  96 */         return HSpriteConst.IFEET_NONE + dir; 
/*  97 */       int rt = (int)movementTimer;
/*  98 */       rt %= feets.length;
/*  99 */       if (rt < 0)
/* 100 */         rt = 0; 
/* 101 */       return feets[rt] + dir;
/*     */     }
/*     */ 
/*     */     
/*     */     public void tick(Humanoid a, double ds) {
/* 106 */       a.spriteTimer = (float)(a.spriteTimer + ds * this.fps);
/*     */     }
/*     */ 
/*     */     
/*     */     protected boolean isDone(Humanoid a) {
/* 111 */       return (a.spriteTimer >= this.torsos.length);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void renderExtra(Induvidual a, DIR dir, Renderer r, ShadowBatch s, double timer, int x, int y) {}
/*     */ 
/*     */ 
/*     */     
/*     */     public void render(Induvidual in2, double spriteTimer, double movementTimer, boolean inWater, DIR dirr, RESOURCE carried, int resAm, Renderer r, ShadowBatch s, float ds, int x, int y) {
/* 121 */       StatsAppearance ap = STATS.APPEARANCE();
/*     */       
/* 123 */       spriteTimer = Math.abs(spriteTimer) % this.torsos.length;
/*     */       
/* 125 */       if (inWater) {
/* 126 */         renderWater(in2, dirr, r, s, ds, x, y);
/*     */         
/*     */         return;
/*     */       } 
/* 130 */       TILE_SHEET sp = (in2.race().appearance().sheet(in2)).sheet.sheet;
/* 131 */       RExtras ex = (in2.race().appearance()).extra;
/* 132 */       int dir = dirr.id();
/*     */       
/* 134 */       AnimalSpecies mount = null;
/* 135 */       for (EquipBattle b : (STATS.EQUIP()).mounts) {
/* 136 */         if (b.get(in2) > 0) {
/* 137 */           mount = b.mount;
/*     */         }
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 143 */       if (mount == null) {
/* 144 */         ap.colorLegs(in2).bind();
/* 145 */         int feet = getFeet(in2, movementTimer, dir, ds);
/* 146 */         if (feet >= 0) {
/* 147 */           sp.render((SPRITE_RENDERER)r, feet, x, y);
/*     */         }
/* 149 */         COLOR.unbind();
/*     */       } else {
/* 151 */         SETT.ANIMALS().renderMount(mount, (SPRITE_RENDERER)r, s, movementTimer / 4.0D, x + 48, y + 48, inWater, dir, STATS.RAN().get(in2, 4));
/*     */       } 
/*     */ 
/*     */       
/* 155 */       boolean ca = (this.carries && carried != null);
/*     */ 
/*     */       
/* 158 */       int torsot = this.torsos[(int)spriteTimer];
/* 159 */       if (mount != null) {
/* 160 */         torsot = HSpriteConst.ITORSO_CARRY;
/*     */       }
/*     */       
/* 163 */       int torso = ca ? HSpriteConst.ITORSO_CARRY : torsot;
/* 164 */       torso += dir;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 169 */       renderExtra(in2, dirr, r, s, spriteTimer, x, y);
/*     */ 
/*     */       
/* 172 */       OPACITY.unbind();
/* 173 */       ap.colorSkin(in2).bind();
/* 174 */       sp.render((SPRITE_RENDERER)r, torso, x, y);
/*     */       
/* 176 */       if ((STATS.POP()).NAKED.get(in2) == 0) {
/* 177 */         ap.colorClothes(in2).bind();
/* 178 */         sp.render((SPRITE_RENDERER)r, HSpriteConst.ITUNIC + dir, x, y);
/*     */       } 
/*     */       
/* 181 */       COLOR.unbind();
/*     */ 
/*     */ 
/*     */       
/* 185 */       if (ca) {
/* 186 */         RESOURCE w = carried;
/* 187 */         if (resAm > 4) {
/* 188 */           int cx = x + sp.size() / 2;
/* 189 */           int cy = y + sp.size() / 2;
/*     */           
/* 191 */           int dx = cx + (int)(sp.size() * 0.5D * dirr.xN());
/* 192 */           int dy = cy + (int)(sp.size() * 0.5D * dirr.yN());
/* 193 */           int ti = GAME.intervals().get05() & 0x3;
/* 194 */           ex.trolly.render((SPRITE_RENDERER)r, HSpriteConst.TROLLY[ti] + dir, dx - ex.trolly.size() / 2, dy - ex.trolly.size() / 2);
/* 195 */           s.setDistance2Ground(8.0D).setHeight(0);
/* 196 */           ex.trolly.render((SPRITE_RENDERER)s, HSpriteConst.TROLLY[ti] + dir, dx - ex.trolly.size() / 2, dy - ex.trolly.size() / 2);
/* 197 */           int am = resAm;
/* 198 */           if (am >= 8)
/* 199 */             am = 7; 
/* 200 */           w.renderLaying((SPRITE_RENDERER)r, dx - 32, dy - 32, 15, am);
/*     */         } else {
/* 202 */           w.renderCarried((SPRITE_RENDERER)r, x + (in2.race().appearance()).off + (in2.race()).physics.hitBoxsize() / 2, 
/* 203 */               y + (in2.race().appearance()).off + (in2.race()).physics.hitBoxsize() / 2, dirr);
/*     */         } 
/*     */       } 
/* 206 */       if (baby(in2)) {
/* 207 */         int cx = x + sp.size() / 2;
/* 208 */         int cy = y + sp.size() / 2;
/* 209 */         int dx = cx - (int)((in2.race()).physics.hitBoxsize() * 0.5D * dirr.xN());
/* 210 */         int dy = cy - (int)((in2.race()).physics.hitBoxsize() * 0.5D * dirr.yN());
/* 211 */         in2.race().appearance().renderBaby((SPRITE_RENDERER)r, dx, dy, dirr.id(), STATS.RAN().get(in2, 4));
/*     */       } 
/*     */       
/* 214 */       for (RAddon add : ((RType)(in2.race().appearance()).types.getC(ap.gender.get(in2))).addonsBelow) {
/* 215 */         add.renderStanding(r, dir, x, y, in2, false);
/*     */       }
/*     */ 
/*     */       
/* 219 */       ap.colorSkin(in2).bind();
/* 220 */       sp.render((SPRITE_RENDERER)r, dir + HSpriteConst.IHEAD, x, y);
/*     */ 
/*     */       
/* 223 */       for (RAddon add : ((RType)(in2.race().appearance()).types.getC(ap.gender.get(in2))).addonsAbove) {
/* 224 */         add.renderStanding(r, dir, x, y, in2, false);
/*     */       }
/*     */       
/* 227 */       COLOR.unbind();
/*     */ 
/*     */       
/* 230 */       OPACITY.O75.bind();
/* 231 */       HSpriteConst.filth(in2, torso, x, y);
/* 232 */       HSpriteConst.blood(in2, torso, x, y);
/*     */       
/* 234 */       OPACITY.unbind();
/*     */ 
/*     */       
/* 237 */       s.setHeight(10).setDistance2Ground(0.0D);
/* 238 */       (in2.race().appearance().sheet(in2)).sheet.sheet.render((SPRITE_RENDERER)s, dir + HSpriteConst.ISHADOW, x, y);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void render(Humanoid a, AIManager d, Renderer r, ShadowBatch s, float ds, int x, int y) {
/* 245 */       double sp = a.speed.magnitudeRelative();
/* 246 */       if (sp > 0.0D) {
/* 247 */         a.relTimer = (float)(a.relTimer + (ds * 14.0F) * sp);
/*     */       } else {
/* 249 */         a.relTimer = 0.0F;
/*     */       } 
/* 251 */       Induvidual in2 = a.indu();
/* 252 */       double spriteTimer = a.spriteTimer;
/* 253 */       double movementTimer = a.relTimer;
/* 254 */       boolean inWater = (a.inWater && a.physics.getZ() == 0.0D);
/* 255 */       DIR dirr = (DIR)DIR.ALL.get(getDir(a, a.spriteTimer));
/* 256 */       RESOURCE carried = d.resourceCarried();
/* 257 */       int resAm = d.resourceA();
/*     */       
/* 259 */       render(in2, spriteTimer, movementTimer, inWater, dirr, carried, resAm, r, s, ds, x, y);
/*     */     }
/*     */ 
/*     */     
/*     */     private void renderWater(Induvidual in2, DIR dirr, Renderer r, ShadowBatch s, float ds, int x, int y) {
/* 264 */       StatsAppearance ap = STATS.APPEARANCE();
/*     */       
/* 266 */       int tt = (int)(TIME.currentSecond() * 5.0D + STATS.RAN().get(in2, 6));
/* 267 */       tt &= 0xFF;
/* 268 */       tt %= swim.length;
/*     */ 
/*     */       
/* 271 */       TILE_SHEET sp = (in2.race().appearance().sheet(in2)).sheet.sheet;
/* 272 */       int dir = dirr.id();
/*     */       
/* 274 */       int torso = swim[tt];
/* 275 */       torso += dir;
/*     */ 
/*     */       
/* 278 */       ap.colorSkin(in2).bind();
/* 279 */       sp.render((SPRITE_RENDERER)r, torso, x, y);
/*     */       
/* 281 */       if ((STATS.POP()).NAKED.get(in2) == 0) {
/* 282 */         ap.colorClothes(in2).bind();
/* 283 */         sp.render((SPRITE_RENDERER)r, HSpriteConst.ITUNIC + dir, x, y);
/* 284 */         COLOR.unbind();
/*     */       } 
/*     */       
/* 287 */       for (RAddon add : ((RType)(in2.race().appearance()).types.getC(ap.gender.get(in2))).addonsBelow) {
/* 288 */         add.renderStanding(r, dir, x, y, in2, false);
/*     */       }
/*     */       
/* 291 */       if (baby(in2)) {
/* 292 */         int cx = x + sp.size() / 2;
/* 293 */         int cy = y + sp.size() / 2;
/* 294 */         int dx = cx - (int)((in2.race()).physics.hitBoxsize() * 0.5D * dirr.xN());
/* 295 */         int dy = cy - (int)((in2.race()).physics.hitBoxsize() * 0.5D * dirr.yN());
/* 296 */         in2.race().appearance().renderBaby((SPRITE_RENDERER)r, dx, dy, dirr.id(), STATS.RAN().get(in2, 4));
/*     */       } 
/*     */ 
/*     */       
/* 300 */       ap.colorSkin(in2).bind();
/* 301 */       sp.render((SPRITE_RENDERER)r, dir + HSpriteConst.IHEAD, x, y);
/*     */       
/* 303 */       for (RAddon add : ((RType)(in2.race().appearance()).types.getC(ap.gender.get(in2))).addonsAbove) {
/* 304 */         add.renderStanding(r, dir, x, y, in2, false);
/*     */       }
/* 306 */       COLOR.unbind();
/*     */       
/* 308 */       OPACITY.O75.bind();
/* 309 */       HSpriteConst.water(in2, dir, torso, x, y);
/* 310 */       OPACITY.unbind();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void renderSimple(Humanoid a, AIManager d, Renderer r, ShadowBatch s, float ds, int x, int y) {
/* 316 */       Induvidual in2 = a.indu();
/* 317 */       StatsAppearance ap = STATS.APPEARANCE();
/*     */       
/* 319 */       if (a.race().appearance() == null || a.race().appearance().sheet(in2) == null) {
/*     */         return;
/*     */       }
/* 322 */       a.spriteTimer = Math.abs(a.spriteTimer) % this.torsos.length;
/*     */       
/* 324 */       TILE_SHEET sp = (a.race().appearance().sheet(in2)).sheet.sheet;
/* 325 */       RExtras ex = (a.race().appearance()).extra;
/* 326 */       int dir = getDir(a, a.spriteTimer);
/*     */       
/* 328 */       AnimalSpecies mount = null;
/* 329 */       for (EquipBattle b : (STATS.EQUIP()).mounts) {
/* 330 */         if (b.get(in2) > 0) {
/* 331 */           mount = b.mount;
/*     */         }
/*     */       } 
/*     */       
/* 335 */       if (mount != null) {
/* 336 */         SETT.ANIMALS().renderMount(mount, (SPRITE_RENDERER)r, s, a.spriteTimer / 4.0D, x + 48, y + 48, false, dir, STATS.RAN().get(in2, 4));
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 341 */       boolean ca = (this.carries && d.resourceCarried() != null);
/* 342 */       int torsot = this.torsos[(int)a.spriteTimer];
/* 343 */       if (mount != null) {
/* 344 */         torsot = HSpriteConst.ITORSO_CARRY;
/*     */       }
/*     */       
/* 347 */       int torso = ca ? HSpriteConst.ITORSO_CARRY : torsot;
/* 348 */       torso += dir;
/*     */ 
/*     */       
/* 351 */       ap.colorSkin(in2).bind();
/*     */ 
/*     */       
/* 354 */       if ((STATS.POP()).NAKED.get(in2) == 0) {
/* 355 */         ap.colorClothes(in2).bind();
/*     */       }
/* 357 */       sp.render((SPRITE_RENDERER)r, torso, x, y);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 362 */       if (ca) {
/* 363 */         RESOURCE w = d.resourceCarried();
/* 364 */         if (d.resourceA() > 4) {
/* 365 */           int cx = x + sp.size() / 2;
/* 366 */           int cy = y + sp.size() / 2;
/*     */           
/* 368 */           int dx = cx + (int)(sp.size() * 0.5D * a.speed.dir().xN());
/* 369 */           int dy = cy + (int)(sp.size() * 0.5D * a.speed.dir().yN());
/* 370 */           int ti = GAME.intervals().get05() & 0x3;
/* 371 */           ex.trolly.render((SPRITE_RENDERER)r, HSpriteConst.TROLLY[ti] + dir, dx - ex.trolly.size() / 2, dy - ex.trolly.size() / 2);
/* 372 */           s.setDistance2Ground(8.0D).setHeight(0);
/* 373 */           ex.trolly.render((SPRITE_RENDERER)s, HSpriteConst.TROLLY[ti] + dir, dx - ex.trolly.size() / 2, dy - ex.trolly.size() / 2);
/* 374 */           int am = d.resourceA();
/* 375 */           if (am >= 8)
/* 376 */             am = 7; 
/* 377 */           w.renderLaying((SPRITE_RENDERER)r, dx - 32, dy - 32, 15, am);
/*     */         } 
/*     */       } 
/*     */       
/* 381 */       if (baby(in2)) {
/* 382 */         DIR dirr = (DIR)DIR.ALL.get(dir);
/* 383 */         int cx = x + sp.size() / 2;
/* 384 */         int cy = y + sp.size() / 2;
/* 385 */         int dx = cx - (int)((in2.race()).physics.hitBoxsize() * 0.5D * dirr.xN());
/* 386 */         int dy = cy - (int)((in2.race()).physics.hitBoxsize() * 0.5D * dirr.yN());
/* 387 */         in2.race().appearance().renderBaby((SPRITE_RENDERER)r, dx, dy, dirr.id(), STATS.RAN().get(in2, 4));
/*     */       } 
/*     */ 
/*     */       
/* 391 */       ap.colorSkin(in2).bind();
/* 392 */       sp.render((SPRITE_RENDERER)r, dir + HSpriteConst.IHEAD, x, y);
/*     */       
/* 394 */       for (RAddon add : ((RType)(in2.race().appearance()).types.getC(ap.gender.get(in2))).addonsAbove) {
/* 395 */         add.renderStanding(r, dir, x, y, in2, false);
/*     */       }
/*     */ 
/*     */       
/* 399 */       if (!a.inWater) {
/* 400 */         s.setHeight(10).setDistance2Ground(0.0D);
/* 401 */         (a.race().appearance().sheet(in2)).sheet.sheet.render((SPRITE_RENDERER)s, dir + HSpriteConst.ISHADOW, x, y);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     boolean baby(Induvidual in) {
/* 408 */       return (in.hType().child() != null);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void renderHead(SPRITE_RENDERER r, Race race, int gender, int dir, int ran, int cx, int cy) {
/* 415 */     StatsAppearance ap = STATS.APPEARANCE();
/* 416 */     TILE_SHEET sp = (race.appearance().sheet(gender)).sheet.sheet;
/* 417 */     ap.colorSkin(race, gender, ran).bind();
/* 418 */     cx += (64 - sp.size()) / 2;
/* 419 */     cy += (64 - sp.size()) / 2;
/* 420 */     sp.render(r, dir + HSpriteConst.IHEAD, cx, cy);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\spirte\HSprite.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */