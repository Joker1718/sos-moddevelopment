/*     */ package settlement.entity.humanoid.spirte;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.time.TIME;
/*     */ import init.race.appearence.RAddon;
/*     */ import init.race.appearence.RType;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.colls.StatsAppearance;
/*     */ import settlement.stats.equip.EquipRange;
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
/*     */ public final class HSprites
/*     */ {
/*  39 */   public static final HSprite STAND = new HSprite.Standing(0.0D, true, new int[] {
/*  40 */         HSpriteConst.ITORSO_STILL
/*     */       });
/*     */   
/*  43 */   public static final HSprite STAND_BABY = new HSprite.Standing(0.0D, true, new int[] { HSpriteConst.ITORSO_CARRY })
/*     */     {
/*     */       boolean baby(Induvidual in) {
/*  46 */         return false;
/*     */       }
/*     */ 
/*     */       
/*     */       protected void renderExtra(Induvidual a, DIR dir, Renderer r, ShadowBatch s, double timer, int x, int y) {
/*  51 */         int ss = (a.race().appearance().sheet(a)).sheet.sheet.size() / 2;
/*  52 */         int cx = x + ss;
/*  53 */         int cy = y + ss;
/*  54 */         int dx = cx + (int)((a.race()).physics.hitBoxsize() * 0.5D * dir.xN());
/*  55 */         int dy = cy + (int)((a.race()).physics.hitBoxsize() * 0.5D * dir.yN());
/*  56 */         a.race().appearance().renderBaby((SPRITE_RENDERER)r, dx, dy, dir.id(), STATS.RAN().get(a, 4));
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */   
/*  62 */   public static final HSprite CARRY = new HSprite.Standing(0.0D, true, new int[] {
/*  63 */         HSpriteConst.ITORSO_CARRY
/*     */       });
/*     */   
/*  66 */   public static final HSprite ARMS_OUT = new HSprite.Standing(0.0D, true, new int[] {
/*  67 */         HSpriteConst.ITORSO_OUT2
/*     */       });
/*     */   
/*  70 */   public static final HSprite MOVE = new HSprite.Standing(0.0D, true, new int[] {
/*  71 */         HSpriteConst.ITORSO_STILL, 
/*  72 */         HSpriteConst.ITORSO_RIGHT, 
/*  73 */         HSpriteConst.ITORSO_RIGHT2, 
/*  74 */         HSpriteConst.ITORSO_RIGHT, 
/*  75 */         HSpriteConst.ITORSO_STILL, 
/*  76 */         HSpriteConst.ITORSO_LEFT, 
/*  77 */         HSpriteConst.ITORSO_LEFT2, 
/*  78 */         HSpriteConst.ITORSO_LEFT
/*     */       })
/*     */     {
/*  81 */       private final double[] ex = new double[] {
/*  82 */           -0.5D, 
/*  83 */           0.5D, 
/*  84 */           1.0D, 
/*  85 */           0.5D, 
/*  86 */           -0.5D, 
/*  87 */           0.0D, 
/*  88 */           0.0D, 
/*  89 */           0.0D
/*     */         };
/*     */ 
/*     */       
/*     */       public void tick(Humanoid a, double ds) {
/*  94 */         a.spriteTimer = (float)(a.spriteTimer + ds * 20.0D * a.speed.magnitudeRelative());
/*     */       }
/*     */ 
/*     */       
/*     */       protected void renderExtra(Induvidual a, DIR dir, Renderer r, ShadowBatch s, double timer, int x, int y) {
/*  99 */         double i = this.ex[(int)timer];
/*     */         
/* 101 */         STATS.EQUIP().renderExtra(a, dir, r, s, i, x, y);
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 108 */   public static final HSprite THROW = new HSprite.Standing(0.0D, true, new int[] {
/* 109 */         HSpriteConst.ITORSO_STILL, 
/* 110 */         HSpriteConst.ITORSO_RIGHT, 
/* 111 */         HSpriteConst.ITORSO_RIGHT2
/*     */       })
/*     */     {
/*     */       public void tick(Humanoid a, double ds)
/*     */       {
/* 116 */         a.spriteTimer = (float)(a.spriteTimer + ds * 5.0D);
/*     */       }
/*     */     };
/*     */   
/* 120 */   public static final HSprite DRAG = new HSprite.Standing(0.0D, true, new int[] {
/* 121 */         HSpriteConst.ITORSO_RIGHT2
/*     */       })
/*     */     {
/*     */       public void tick(Humanoid a, double ds)
/*     */       {
/* 126 */         a.spriteTimer = (float)(a.spriteTimer + ds * 20.0D * a.speed.magnitudeRelative());
/*     */       }
/*     */       
/*     */       protected int getDir(Humanoid a, float timer) {
/* 130 */         return a.speed.dir().perpendicular().id();
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */   
/* 136 */   public static final HSprite MOVE_SWORD = new HSprite.Standing(0.0D, true, new int[] {
/* 137 */         HSpriteConst.ITORSO_STILL, 
/* 138 */         HSpriteConst.ITORSO_LEFT, 
/* 139 */         HSpriteConst.ITORSO_LEFT2, 
/* 140 */         HSpriteConst.ITORSO_LEFT
/*     */       })
/*     */     {
/* 143 */       private final int[] ex = new int[] {
/* 144 */           1, 
/* 145 */           2, 
/* 146 */           2, 
/* 147 */           1
/*     */         };
/*     */ 
/*     */       
/*     */       protected void renderExtra(Induvidual a, DIR dir, Renderer r, ShadowBatch s, double timer, int x, int y) {
/* 152 */         int i = this.ex[(int)timer];
/*     */         
/* 154 */         STATS.EQUIP().renderExtra(a, dir, r, s, this.ex[i], x, y);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public void tick(Humanoid a, double ds) {
/* 160 */         a.spriteTimer = (float)(a.spriteTimer + ds * 20.0D * a.speed.magnitudeRelative());
/*     */       }
/*     */     };
/*     */   
/* 164 */   public static final HSprite MOVE_SWORD_BACK = new HSprite.Standing(0.0D, true, new int[] {
/* 165 */         HSpriteConst.ITORSO_STILL, 
/* 166 */         HSpriteConst.ITORSO_LEFT, 
/* 167 */         HSpriteConst.ITORSO_LEFT2, 
/* 168 */         HSpriteConst.ITORSO_LEFT
/*     */       })
/*     */     {
/* 171 */       private final int[] ex = new int[] {
/* 172 */           1, 
/* 173 */           2, 
/* 174 */           2, 
/* 175 */           1
/*     */         };
/*     */ 
/*     */       
/*     */       protected void renderExtra(Induvidual a, DIR dir, Renderer r, ShadowBatch s, double timer, int x, int y) {
/* 180 */         int i = this.ex[(int)timer];
/*     */         
/* 182 */         STATS.EQUIP().renderExtra(a, dir, r, s, this.ex[i], x, y);
/*     */       }
/*     */ 
/*     */       
/*     */       public void tick(Humanoid a, double ds) {
/* 187 */         a.spriteTimer = (float)(a.spriteTimer + ds * 20.0D * a.speed.magnitudeRelative());
/*     */       }
/*     */ 
/*     */       
/*     */       protected int getDir(Humanoid a, float timer) {
/* 192 */         return a.speed.dir().perpendicular().id();
/*     */       }
/*     */     };
/*     */   
/* 196 */   public static final HSprite TOOL_BACK = new HSprite.Standing(8.0D, false, new int[] {
/* 197 */         HSpriteConst.ITORSO_RIGHT2, 
/* 198 */         HSpriteConst.ITORSO_RIGHT2, 
/* 199 */         HSpriteConst.ITORSO_RIGHT2, 
/* 200 */         HSpriteConst.ITORSO_RIGHT2, 
/* 201 */         HSpriteConst.ITORSO_RIGHT2, 
/* 202 */         HSpriteConst.ITORSO_RIGHT, 
/* 203 */         HSpriteConst.ITORSO_RIGHT, 
/* 204 */         HSpriteConst.ITORSO_STILL, 
/* 205 */         HSpriteConst.ITORSO_STILL
/*     */       })
/*     */     {
/* 208 */       private final int[] ex = new int[] {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 214 */           0, 0, 0, 0, 0, 1, 
/* 215 */           1, 
/* 216 */           2, 
/* 217 */           2
/*     */         };
/*     */ 
/*     */       
/*     */       protected void renderExtra(Induvidual a, DIR dir, Renderer r, ShadowBatch s, double timer, int x, int y) {
/* 222 */         int qual = 0;
/* 223 */         int i = this.ex[(int)timer];
/*     */         
/* 225 */         (a.race().appearance()).extra.tool.render((SPRITE_RENDERER)r, 
/* 226 */             dir.id() + HSpriteConst.ITOOL[qual][i], x, y);
/*     */       }
/*     */     };
/*     */   
/* 230 */   public static final HSprite TOOL_HIT = new HSprite.Standing(32.0D, false, new int[] { 
/* 231 */         HSpriteConst.ITORSO_STILL, 
/* 232 */         HSpriteConst.ITORSO_STILL, 
/* 233 */         HSpriteConst.ITORSO_STILL, 
/* 234 */         HSpriteConst.ITORSO_STILL, 
/* 235 */         HSpriteConst.ITORSO_STILL, 
/* 236 */         HSpriteConst.ITORSO_STILL, 
/* 237 */         HSpriteConst.ITORSO_STILL, 
/* 238 */         HSpriteConst.ITORSO_STILL, 
/* 239 */         HSpriteConst.ITORSO_STILL, 
/* 240 */         HSpriteConst.ITORSO_STILL, 
/* 241 */         HSpriteConst.ITORSO_STILL, 
/* 242 */         HSpriteConst.ITORSO_STILL, 
/* 243 */         HSpriteConst.ITORSO_STILL, 
/* 244 */         HSpriteConst.ITORSO_RIGHT, 
/* 245 */         HSpriteConst.ITORSO_RIGHT2 })
/*     */     {
/*     */       
/* 248 */       private final int[] ex = new int[] { 
/* 249 */           2, 
/* 250 */           2, 
/* 251 */           2, 
/* 252 */           2, 
/* 253 */           2, 
/* 254 */           2, 
/* 255 */           2, 
/* 256 */           2, 
/* 257 */           2, 
/* 258 */           2, 
/* 259 */           2, 
/* 260 */           2, 
/* 261 */           2, 
/* 262 */           1 };
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       protected void renderExtra(Induvidual a, DIR dir, Renderer r, ShadowBatch s, double timer, int x, int y) {
/* 268 */         int qual = 0;
/* 269 */         (a.race().appearance()).extra.tool.render((SPRITE_RENDERER)r, 
/* 270 */             dir.id() + HSpriteConst.ITOOL[qual][this.ex[(int)timer]], x, y);
/*     */       }
/*     */     };
/*     */   
/* 274 */   public static final HSprite BOX = new HSprite.Standing(5.0D, false, new int[] { 
/* 275 */         HSpriteConst.ITORSO_LEFT, 
/* 276 */         HSpriteConst.ITORSO_LEFT2, 
/* 277 */         HSpriteConst.ITORSO_LEFT3, 
/* 278 */         HSpriteConst.ITORSO_LEFT2, 
/* 279 */         HSpriteConst.ITORSO_LEFT, 
/* 280 */         HSpriteConst.ITORSO_STILL, 
/* 281 */         HSpriteConst.ITORSO_RIGHT, 
/* 282 */         HSpriteConst.ITORSO_RIGHT2, 
/* 283 */         HSpriteConst.ITORSO_RIGHT3, 
/* 284 */         HSpriteConst.ITORSO_RIGHT2, 
/* 285 */         HSpriteConst.ITORSO_RIGHT });
/*     */ 
/*     */   
/* 288 */   public static final HSprite STRANGLED = new HSprite.Standing(15.0D, false, new int[] {
/* 289 */         HSpriteConst.ITORSO_LEFT, 
/* 290 */         HSpriteConst.ITORSO_STILL, 
/* 291 */         HSpriteConst.ITORSO_RIGHT
/*     */       })
/*     */     {
/*     */       protected int getFeet(Induvidual a, double movementTimer, int dir, float ds)
/*     */       {
/* 296 */         int rt = (int)(TIME.currentSecond() * 15.0D);
/* 297 */         rt %= feets.length;
/* 298 */         if (rt < 0)
/* 299 */           rt = 0; 
/* 300 */         return feets[rt] + dir;
/*     */       }
/*     */     };
/*     */   
/* 304 */   public static final HSprite GRAB = new HSprite.Standing(10.0D, false, new int[] {
/* 305 */         HSpriteConst.ITORSO_LEFT2, 
/* 306 */         HSpriteConst.ITORSO_RIGHT2, 
/* 307 */         HSpriteConst.ITORSO_LEFT2, 
/* 308 */         HSpriteConst.ITORSO_RIGHT2, 
/* 309 */         HSpriteConst.ITORSO_LEFT2, 
/* 310 */         HSpriteConst.ITORSO_RIGHT2, 
/* 311 */         HSpriteConst.ITORSO_LEFT2, 
/* 312 */         HSpriteConst.ITORSO_RIGHT2, 
/* 313 */         HSpriteConst.ITORSO_LEFT2, 
/* 314 */         HSpriteConst.ITORSO_RIGHT2
/*     */       });
/*     */   
/* 317 */   public static final HSprite FIST = new HSprite.Standing(10.0D, false, new int[] { 
/* 318 */         HSpriteConst.ITORSO_STILL, 
/* 319 */         HSpriteConst.ITORSO_RIGHT, 
/* 320 */         HSpriteConst.ITORSO_RIGHT, 
/* 321 */         HSpriteConst.ITORSO_RIGHT, 
/* 322 */         HSpriteConst.ITORSO_RIGHT, 
/* 323 */         HSpriteConst.ITORSO_RIGHT2, 
/* 324 */         HSpriteConst.ITORSO_RIGHT3, 
/* 325 */         HSpriteConst.ITORSO_RIGHT2, 
/* 326 */         HSpriteConst.ITORSO_RIGHT3, 
/* 327 */         HSpriteConst.ITORSO_RIGHT2, 
/* 328 */         HSpriteConst.ITORSO_RIGHT3, 
/* 329 */         HSpriteConst.ITORSO_RIGHT2, 
/* 330 */         HSpriteConst.ITORSO_RIGHT, 
/* 331 */         HSpriteConst.ITORSO_RIGHT, 
/* 332 */         HSpriteConst.ITORSO_STILL });
/*     */ 
/*     */   
/* 335 */   public static final HSprite ARM_RIGHT = new HSprite.Standing(10.0D, false, new int[] {
/* 336 */         HSpriteConst.ITORSO_RIGHT2
/*     */       });
/*     */   
/* 339 */   public static final HSprite ARM_LEFT = new HSprite.Standing(10.0D, false, new int[] {
/* 340 */         HSpriteConst.ITORSO_LEFT
/*     */       });
/*     */   
/* 343 */   public static final HSprite ARM_LEFT2 = new HSprite.Standing(10.0D, false, new int[] {
/* 344 */         HSpriteConst.ITORSO_LEFT2
/*     */       });
/*     */   
/* 347 */   public static final HSprite ARM_LEFT3 = new HSprite.Standing(10.0D, false, new int[] {
/* 348 */         HSpriteConst.ITORSO_LEFT3
/*     */       });
/*     */   
/* 351 */   public static final HSprite ARM_RIGHT2 = new HSprite.Standing(10.0D, false, new int[] {
/* 352 */         HSpriteConst.ITORSO_RIGHT3
/*     */       });
/*     */ 
/*     */ 
/*     */   
/* 357 */   public static final HSprite DANCE = new HSprite.Standing(10.0D, false, new int[] {
/* 358 */         HSpriteConst.ITORSO_STILL, 
/* 359 */         HSpriteConst.ITORSO_RIGHT, 
/* 360 */         HSpriteConst.ITORSO_RIGHT2, 
/* 361 */         HSpriteConst.ITORSO_RIGHT, 
/* 362 */         HSpriteConst.ITORSO_STILL, 
/* 363 */         HSpriteConst.ITORSO_LEFT, 
/* 364 */         HSpriteConst.ITORSO_LEFT2, 
/* 365 */         HSpriteConst.ITORSO_LEFT
/*     */       });
/*     */   
/* 368 */   public static final HSprite DANCE_EXTRA = new HSprite.Standing(10.0D, false, new int[] { 
/* 369 */         HSpriteConst.ITORSO_STILL, 
/* 370 */         HSpriteConst.ITORSO_RIGHT, 
/* 371 */         HSpriteConst.ITORSO_RIGHT2, 
/* 372 */         HSpriteConst.ITORSO_RIGHT3, 
/* 373 */         HSpriteConst.ITORSO_RIGHT2, 
/* 374 */         HSpriteConst.ITORSO_RIGHT, 
/* 375 */         HSpriteConst.ITORSO_STILL, 
/* 376 */         HSpriteConst.ITORSO_LEFT, 
/* 377 */         HSpriteConst.ITORSO_LEFT2, 
/* 378 */         HSpriteConst.ITORSO_LEFT3, 
/* 379 */         HSpriteConst.ITORSO_LEFT2, 
/* 380 */         HSpriteConst.ITORSO_LEFT });
/*     */ 
/*     */   
/* 383 */   public static final HSprite WAVE = new HSprite.Standing(5.0D, false, new int[] {
/* 384 */         HSpriteConst.ITORSO_STILL, 
/* 385 */         HSpriteConst.ITORSO_OUT, 
/* 386 */         HSpriteConst.ITORSO_OUT2, 
/* 387 */         HSpriteConst.ITORSO_OUT
/*     */       });
/*     */   
/* 390 */   public static final HSprite SWORD_STAND = new HSprite.Standing(0.0D, false, new int[] { HSpriteConst.ITORSO_RIGHT })
/*     */     {
/*     */       
/*     */       protected void renderExtra(Induvidual a, DIR dir, Renderer r, ShadowBatch s, double timer, int x, int y)
/*     */       {
/* 395 */         STATS.EQUIP().renderExtra(a, dir, r, s, 1.0D, x, y);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public void render(Humanoid a, AIManager d, Renderer r, ShadowBatch s, float ds, int x, int y) {
/* 402 */         super.render(a, d, r, s, ds, x, y);
/*     */       }
/*     */     };
/*     */   
/* 406 */   public static final HSprite SWORD_STAND_SWAY = new HSprite.Standing(0.0D, false, new int[] { HSpriteConst.ITORSO_RIGHT })
/*     */     {
/*     */       
/*     */       protected void renderExtra(Induvidual a, DIR dir, Renderer r, ShadowBatch s, double timer, int x, int y)
/*     */       {
/* 411 */         STATS.EQUIP().renderExtra(a, dir, r, s, 1.0D, x, y);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public void render(Humanoid a, AIManager d, Renderer r, ShadowBatch s, float ds, int x, int y) {
/* 418 */         int ox = a.spriteoff & 0xB01111;
/* 419 */         int oy = a.spriteoff >> 4 & 0xB01111;
/* 420 */         x += ((GAME.intervals().get02() & 0x1F) > ox) ? 1 : 0;
/* 421 */         y += ((GAME.intervals().get02() & 0x1F) > oy) ? 1 : 0;
/*     */ 
/*     */         
/* 424 */         super.render(a, d, r, s, ds, x, y);
/*     */       }
/*     */     };
/*     */   
/* 428 */   public static final HSprite SWORD_STAB = new HSprite.Standing(10.0D, false, new int[] {
/* 429 */         HSpriteConst.ITORSO_STILL, 
/* 430 */         HSpriteConst.ITORSO_RIGHT, 
/* 431 */         HSpriteConst.ITORSO_RIGHT2, 
/* 432 */         HSpriteConst.ITORSO_RIGHT2, 
/* 433 */         HSpriteConst.ITORSO_RIGHT2, 
/* 434 */         HSpriteConst.ITORSO_RIGHT, 
/* 435 */         HSpriteConst.ITORSO_STILL, 
/* 436 */         HSpriteConst.ITORSO_STILL
/*     */       })
/*     */     {
/* 439 */       private final int[] ex = new int[] {
/*     */           
/* 441 */           0, 1, 
/* 442 */           2, 
/* 443 */           2, 
/* 444 */           2, 
/* 445 */           1
/*     */         };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       protected void renderExtra(Induvidual a, DIR dir, Renderer r, ShadowBatch s, double timer, int x, int y) {
/* 453 */         STATS.EQUIP().renderExtra(a, dir, r, s, this.ex[(int)timer], x, y);
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 460 */   public static final HSprite SWORD_OUT = new HSprite.Standing(10.0D, false, new int[] {
/* 461 */         HSpriteConst.ITORSO_STILL, 
/* 462 */         HSpriteConst.ITORSO_RIGHT, 
/* 463 */         HSpriteConst.ITORSO_RIGHT2, 
/* 464 */         HSpriteConst.ITORSO_RIGHT2
/*     */       })
/*     */     {
/* 467 */       private final int[] ex = new int[] {
/*     */           
/* 469 */           0, 1, 
/* 470 */           2, 
/* 471 */           2
/*     */         };
/*     */ 
/*     */ 
/*     */       
/*     */       protected void renderExtra(Induvidual a, DIR dir, Renderer r, ShadowBatch s, double timer, int x, int y) {
/* 477 */         STATS.EQUIP().renderExtra(a, dir, r, s, this.ex[(int)timer], x, y);
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 484 */   public static final HSprite SWORD_IN = new HSprite.Standing(10.0D, false, new int[] {
/* 485 */         HSpriteConst.ITORSO_RIGHT2, 
/* 486 */         HSpriteConst.ITORSO_RIGHT, 
/* 487 */         HSpriteConst.ITORSO_STILL, 
/* 488 */         HSpriteConst.ITORSO_STILL
/*     */       })
/*     */     {
/* 491 */       private final int[] ex = new int[] {
/* 492 */           2, 
/* 493 */           1
/*     */         };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       protected void renderExtra(Induvidual a, DIR dir, Renderer r, ShadowBatch s, double timer, int x, int y) {
/* 501 */         STATS.EQUIP().renderExtra(a, dir, r, s, this.ex[(int)timer], x, y);
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*     */   private static class Archer
/*     */     extends HSprite.Standing
/*     */   {
/*     */     private final double ff;
/*     */     
/*     */     private EquipRange bow;
/*     */     
/*     */     Archer(double ff, int... torsos) {
/* 514 */       super(0.0D, false, torsos);
/* 515 */       this.ff = ff;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected void renderExtra(Induvidual a, DIR dir, Renderer r, ShadowBatch s, double timer, int x, int y) {
/* 523 */       if (this.bow != null) {
/* 524 */         this.bow.sprite.render(a, (SPRITE_RENDERER)r, dir, this.ff, x, y, s);
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     public void render(Humanoid a, AIManager d, Renderer r, ShadowBatch s, float ds, int x, int y) {
/* 530 */       int ox = a.spriteoff & 0xB01111;
/* 531 */       int oy = a.spriteoff >> 4 & 0xB01111;
/* 532 */       x += ((GAME.intervals().get02() & 0x1F) > ox) ? 1 : 0;
/* 533 */       y += ((GAME.intervals().get02() & 0x1F) > oy) ? 1 : 0;
/* 534 */       this.bow = null;
/* 535 */       if (a.division() != null) {
/* 536 */         this.bow = a.division().settings().ammo();
/*     */       }
/*     */       
/* 539 */       super.render(a, d, r, s, ds, x, y);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/* 544 */   public static final HSprite ARCHER1 = new Archer(0.0D, new int[] { HSpriteConst.ITORSO_STILL });
/* 545 */   public static final HSprite ARCHER2 = new Archer(0.25D, new int[] { HSpriteConst.ITORSO_LEFT });
/* 546 */   public static final HSprite ARCHER3 = new Archer(0.5D, new int[] { HSpriteConst.ITORSO_LEFT2 });
/* 547 */   public static final HSprite ARCHER4 = new Archer(0.75D, new int[] { HSpriteConst.ITORSO_LEFT3 });
/*     */ 
/*     */   
/* 550 */   public static final HSprite SLEEP = new HSprite(10.0D, 0.1D)
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public void render(Humanoid a, AIManager d, Renderer r, ShadowBatch s, float ds, int x, int y)
/*     */       {
/* 558 */         int n = (STATS.POP()).NAKED.get(a.indu());
/* 559 */         (STATS.POP()).NAKED.set(a.indu(), 1);
/* 560 */         HSprites.LAY.render(a, d, r, s, ds, x, y);
/* 561 */         x -= 16;
/* 562 */         y -= 16;
/* 563 */         (STATS.POP()).NAKED.set(a.indu(), n);
/* 564 */         int dir = a.speed.dir().id();
/* 565 */         int k = dir + (a.spriteoff & 0x1) * 8;
/* 566 */         (a.race().appearance()).sleep.render((SPRITE_RENDERER)r, k, x, y);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public void tick(Humanoid a, double ds) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public void renderSimple(Humanoid a, AIManager ai, Renderer r, ShadowBatch shadows, float ds, int x, int y) {
/* 580 */         int n = (STATS.POP()).NAKED.get(a.indu());
/* 581 */         (STATS.POP()).NAKED.set(a.indu(), 1);
/* 582 */         HSprites.LAY.renderSimple(a, ai, r, shadows, ds, x, y);
/* 583 */         x -= 16;
/* 584 */         y -= 16;
/* 585 */         (STATS.POP()).NAKED.set(a.indu(), n);
/* 586 */         int dir = a.speed.dir().id();
/* 587 */         int k = dir + (a.spriteoff & 0x1) * 8;
/* 588 */         (a.race().appearance()).sleep.render((SPRITE_RENDERER)r, k, x, y);
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */   
/* 594 */   public static final HSprite LAY = new HSprite(10.0D, 0.1D)
/*     */     {
/*     */       
/*     */       public void render(Humanoid a, AIManager d, Renderer r, ShadowBatch s, float ds, int x, int y)
/*     */       {
/* 599 */         Induvidual in2 = a.indu();
/* 600 */         StatsAppearance ap = STATS.APPEARANCE();
/*     */         
/* 602 */         x -= 16;
/* 603 */         y -= 16;
/*     */         
/* 605 */         TILE_SHEET sheet = (a.race().appearance().sheet(in2)).sheet.lay;
/* 606 */         int dir = a.speed.dir().id();
/*     */         
/* 608 */         if (a.physics.getZ() != 0.0D) {
/* 609 */           int t = (int)a.spriteTimer;
/* 610 */           if (t > 8) {
/* 611 */             a.spriteTimer = 0.0F;
/* 612 */             t = 0;
/*     */           } 
/* 614 */           dir += t;
/* 615 */           dir &= 0x7;
/* 616 */           s.setHeight(0).setDistance2Ground(a.physics.getZ());
/* 617 */           sheet.render((SPRITE_RENDERER)s, HSpriteConst.CLAY.SHADOW + dir, x, y);
/* 618 */         } else if (!a.inWater) {
/* 619 */           s.setHeight(5).setDistance2Ground(0.0D);
/* 620 */           sheet.render((SPRITE_RENDERER)s, HSpriteConst.CLAY.SHADOW + dir, x, y);
/* 621 */           SETT.PARTICLES().renderDust(x + 64, y + 64, a.speed.magnitude());
/*     */         } 
/*     */         
/* 624 */         for (RAddon add : ((RType)(in2.race().appearance()).types.getC(ap.gender.get(in2))).addonsBelow) {
/* 625 */           add.renderLaying(r, dir, x, y, in2, false);
/*     */         }
/*     */         
/* 628 */         boolean naked = ((STATS.POP()).NAKED.get(in2) == 1);
/* 629 */         if (!naked) {
/* 630 */           ap.colorLegs(in2).bind();
/*     */         } else {
/* 632 */           ap.colorSkin(in2).bind();
/* 633 */         }  sheet.render((SPRITE_RENDERER)r, HSpriteConst.CLAY.PANTS + dir, x, y);
/* 634 */         ap.colorSkin(in2).bind();
/* 635 */         sheet.render((SPRITE_RENDERER)r, HSpriteConst.CLAY.ARMS + dir, x, y);
/* 636 */         sheet.render((SPRITE_RENDERER)r, HSpriteConst.CLAY.HEAD + dir, x, y);
/*     */         
/* 638 */         if (!naked) {
/* 639 */           ap.colorClothes(in2).bind();
/*     */         } else {
/* 641 */           ap.colorSkin(in2).bind();
/* 642 */         }  sheet.render((SPRITE_RENDERER)r, HSpriteConst.CLAY.TORSO + dir, x, y);
/*     */         
/* 644 */         for (RAddon add : ((RType)(in2.race().appearance()).types.getC(ap.gender.get(in2))).addonsAbove) {
/* 645 */           add.renderLaying(r, dir, x, y, in2, false);
/*     */         }
/* 647 */         COLOR.unbind();
/*     */         
/* 649 */         if (baby(a.indu())) {
/* 650 */           int cx = x + sheet.size() / 2;
/* 651 */           int cy = y + sheet.size() / 2;
/* 652 */           DIR dirr = (DIR)DIR.ALL.get(dir);
/* 653 */           int dx = cx;
/* 654 */           int dy = cy;
/* 655 */           in2.race().appearance().renderBaby((SPRITE_RENDERER)r, dx, dy, dirr.id(), STATS.RAN().get(in2, 4));
/*     */         } 
/*     */         
/* 658 */         OPACITY.O75.bind();
/*     */         
/* 660 */         if (a.inWater) {
/* 661 */           HSpriteConst.CLAY.water(in2, dir, x, y);
/*     */         } else {
/* 663 */           HSpriteConst.CLAY.blood(in2, dir, x, y);
/* 664 */           HSpriteConst.CLAY.filth(in2, dir, x, y);
/*     */         } 
/* 666 */         OPACITY.unbind();
/*     */       }
/*     */ 
/*     */       
/*     */       public void tick(Humanoid a, double ds) {
/* 671 */         if (a.physics.getZ() != 0.0D) {
/* 672 */           a.spriteTimer = (float)(a.spriteTimer + a.speed.magnitudeRelative() * ds * 15.0D);
/*     */         }
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public void renderSimple(Humanoid a, AIManager ai, Renderer r, ShadowBatch s, float ds, int x, int y) {
/* 679 */         Induvidual in2 = a.indu();
/* 680 */         StatsAppearance ap = STATS.APPEARANCE();
/*     */         
/* 682 */         x -= 16;
/* 683 */         y -= 16;
/*     */         
/* 685 */         TILE_SHEET sheet = (a.race().appearance().sheet(in2)).sheet.lay;
/* 686 */         int dir = a.speed.dir().id();
/*     */         
/* 688 */         if (a.physics.getZ() != 0.0D) {
/* 689 */           int t = (int)a.spriteTimer;
/* 690 */           if (t > 8) {
/* 691 */             a.spriteTimer = 0.0F;
/* 692 */             t = 0;
/*     */           } 
/* 694 */           dir += t;
/* 695 */           dir &= 0x7;
/* 696 */           s.setHeight(0).setDistance2Ground(a.physics.getZ());
/* 697 */           sheet.render((SPRITE_RENDERER)s, HSpriteConst.CLAY.SHADOW + dir, x, y);
/* 698 */         } else if (!a.inWater) {
/* 699 */           s.setHeight(5).setDistance2Ground(0.0D);
/* 700 */           sheet.render((SPRITE_RENDERER)s, HSpriteConst.CLAY.SHADOW + dir, x, y);
/* 701 */           SETT.PARTICLES().renderDust(x + 64, y + 64, a.speed.magnitude());
/*     */         } 
/*     */         
/* 704 */         boolean naked = ((STATS.POP()).NAKED.get(in2) == 1);
/* 705 */         if (!naked) {
/* 706 */           ap.colorLegs(in2).bind();
/*     */         } else {
/* 708 */           ap.colorSkin(in2).bind();
/* 709 */         }  sheet.render((SPRITE_RENDERER)r, HSpriteConst.CLAY.PANTS + dir, x, y);
/* 710 */         ap.colorSkin(in2).bind();
/* 711 */         sheet.render((SPRITE_RENDERER)r, HSpriteConst.CLAY.ARMS + dir, x, y);
/* 712 */         sheet.render((SPRITE_RENDERER)r, HSpriteConst.CLAY.HEAD + dir, x, y);
/* 713 */         if (!naked) {
/* 714 */           ap.colorClothes(in2).bind();
/*     */         } else {
/* 716 */           ap.colorSkin(in2).bind();
/* 717 */         }  sheet.render((SPRITE_RENDERER)r, HSpriteConst.CLAY.TORSO + dir, x, y);
/*     */         
/* 719 */         for (RAddon add : ((RType)(in2.race().appearance()).types.getC(ap.gender.get(in2))).addonsAbove) {
/* 720 */           add.renderLaying(r, dir, x, y, in2, false);
/*     */         }
/* 722 */         COLOR.unbind();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 729 */         COLOR.unbind();
/*     */         
/* 731 */         if (baby(a.indu())) {
/* 732 */           int cx = x + sheet.size() / 2;
/* 733 */           int cy = y + sheet.size() / 2;
/* 734 */           DIR dirr = (DIR)DIR.ALL.get(dir);
/* 735 */           int dx = cx;
/* 736 */           int dy = cy;
/* 737 */           in2.race().appearance().renderBaby((SPRITE_RENDERER)r, dx, dy, dirr.id(), STATS.RAN().get(in2, 4));
/*     */         } 
/*     */       }
/*     */ 
/*     */       
/*     */       boolean baby(Induvidual in) {
/* 743 */         return (in.hType().child() != null);
/*     */       }
/*     */     };
/*     */ 
/*     */   
/* 748 */   public static HSprite LAYOFF = new HSprite(10.0D, 0.1D)
/*     */     {
/*     */       
/*     */       public void render(Humanoid a, AIManager d, Renderer r, ShadowBatch s, float ds, int x, int y)
/*     */       {
/* 753 */         x += a.speed.dir().x() * -16;
/* 754 */         y += a.speed.dir().y() * -16;
/* 755 */         HSprites.LAY.render(a, d, r, s, ds, x, y);
/*     */       }
/*     */ 
/*     */       
/*     */       public void tick(Humanoid a, double ds) {
/* 760 */         HSprites.LAY.tick(a, ds);
/*     */       }
/*     */ 
/*     */       
/*     */       public void renderSimple(Humanoid a, AIManager ai, Renderer r, ShadowBatch shadows, float ds, int x, int y) {
/* 765 */         x += a.speed.dir().x() * -16;
/* 766 */         y += a.speed.dir().y() * -16;
/* 767 */         HSprites.LAY.renderSimple(a, ai, r, shadows, ds, x, y);
/*     */       }
/*     */     };
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\spirte\HSprites.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */