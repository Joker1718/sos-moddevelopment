/*     */ package settlement.entity.animal;
/*     */ 
/*     */ import game.GAME;
/*     */ import init.resources.RESOURCE;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ abstract class Sprite
/*     */ {
/*     */   static final int NR = 8;
/*     */   public static final int bstanding = 0;
/*     */   public static final int bwalk1 = 8;
/*     */   public static final int bwalk2 = 16;
/*     */   public static final int standing = 24;
/*     */   public static final int walk1 = 32;
/*     */   public static final int walk2 = 40;
/*     */   public static final int laying = 48;
/*     */   public static final int eating = 56;
/*     */   public static final int bodypart1 = 64;
/*     */   public static final int bodypart2 = 72;
/*     */   public static final int rotten = 80;
/*     */   public static final int bones = 88;
/*  32 */   public static final int[] WATER = new int[] { 0, 8, 16, 24 };
/*     */   private static TILE_SHEET water() {
/*  34 */     return (TILE_SHEET)(SETT.ANIMALS()).sprites.texture_water.get(0);
/*     */   }
/*     */   
/*  37 */   public static final int[] BLOOD = new int[] { 0, 8, 16, 24, 32 };
/*     */   static TILE_SHEET blood() {
/*  39 */     return (SETT.ANIMALS()).sprites.texture_blood;
/*     */   }
/*     */   final float height;
/*     */   private Sprite(float h) {
/*  43 */     this.height = h;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  50 */   static final Sprite STAND_STILL = new Sprite(1.0F)
/*     */     {
/*     */       public int getDir(Animal a, float ds) {
/*  53 */         return a.speed.dir().id();
/*     */       }
/*     */ 
/*     */       
/*     */       protected int getRow(Animal a, float ds) {
/*  58 */         if (a.isBaby())
/*  59 */           return 0; 
/*  60 */         return 24;
/*     */       }
/*     */     };
/*  63 */   static final Sprite MOVE = new Sprite(1.0F) {
/*  64 */       private final int[] rows = new int[] { 24, 32, 40 };
/*  65 */       private final float fps = 25.0F;
/*     */       
/*     */       public int getDir(Animal a, float ds) {
/*  68 */         return a.speed.dir().id();
/*     */       }
/*     */       
/*     */       protected int getRow(Animal a, float ds) {
/*  72 */         if (a.speed.magnitude() == 0.0D) {
/*  73 */           if (a.isBaby()) {
/*  74 */             return 0;
/*     */           }
/*  76 */           return 24;
/*  77 */         }  float t = a.spriteTimer = (float)(a.spriteTimer + (25.0F * ds) * a.speed.magnitudeRelative());
/*  78 */         if (t >= this.rows.length) {
/*  79 */           t = 0.0F;
/*  80 */           a.spriteTimer = 0.0F;
/*     */         } 
/*  82 */         if (a.isBaby())
/*  83 */           return this.rows[(int)t] - 24; 
/*  84 */         return this.rows[(int)t];
/*     */       }
/*     */     };
/*  87 */   static final Sprite LAYING_STILL = new Sprite(0.5F)
/*     */     {
/*     */       public int getDir(Animal a, float ds) {
/*  90 */         return a.speed.dir().id();
/*     */       }
/*     */       
/*     */       protected int getRow(Animal a, float ds) {
/*  94 */         if (a.isBaby())
/*  95 */           return 0; 
/*  96 */         return 48;
/*     */       }
/*     */     };
/*     */   
/* 100 */   static final Sprite EATING = new Sprite(1.0F) {
/* 101 */       private final int[] st = new int[] { 24, 56 };
/* 102 */       private final float fps = 8.0F;
/*     */       
/*     */       public int getDir(Animal a, float ds) {
/* 105 */         return a.speed.dir().id();
/*     */       }
/*     */       
/*     */       protected int getRow(Animal a, float ds) {
/* 109 */         float t = a.spriteTimer += 8.0F * ds;
/* 110 */         if (t >= this.st.length) {
/* 111 */           t = 0.0F;
/* 112 */           a.spriteTimer = 0.0F;
/*     */         } 
/* 114 */         if (a.isBaby())
/* 115 */           return 0; 
/* 116 */         return this.st[(int)t];
/*     */       }
/*     */     };
/* 119 */   static final Sprite LAYING_SPIN = new Sprite(0.5F)
/*     */     {
/*     */       public int getDir(Animal a, float ds) {
/* 122 */         int t = (int)(a.spriteTimer += ds * 25.0F);
/* 123 */         if (t > 8) {
/* 124 */           a.spriteTimer = 0.0F;
/* 125 */           t = 0;
/*     */         } 
/* 127 */         return t;
/*     */       }
/*     */ 
/*     */       
/*     */       protected int getRow(Animal a, float ds) {
/* 132 */         if (a.isBaby())
/* 133 */           return 0; 
/* 134 */         return 48;
/*     */       }
/*     */     };
/*     */   protected abstract int getDir(Animal paramAnimal, float paramFloat);
/*     */   
/*     */   protected void render(Animal a, boolean hovered, Renderer r, ShadowBatch s, float ds, int offsetX, int offsetY) {
/* 140 */     int x = a.body().x1() + offsetX - a.species().spriteOff();
/* 141 */     int y = a.body().y1() + offsetY - a.species().spriteOff();
/* 142 */     int nr = 0;
/*     */     
/* 144 */     if (hovered) {
/* 145 */       COLOR.WHITE2WHITE.bind();
/*     */     } else {
/* 147 */       a.color.bind();
/*     */     } 
/*     */     
/* 150 */     int row = getRow(a, ds);
/* 151 */     int dir = getDir(a, ds);
/*     */     
/* 153 */     TILE_SHEET sheet = (a.species()).sheet;
/*     */     
/* 155 */     nr += row + dir;
/* 156 */     sheet.render((SPRITE_RENDERER)r, nr, x, y);
/* 157 */     COLOR.unbind();
/*     */ 
/*     */     
/* 160 */     if (a.damage > 0.0F) {
/* 161 */       float h = a.damage;
/* 162 */       if (h >= 1.0F)
/* 163 */         h = 0.99F; 
/* 164 */       int bloodI = (int)(h * BLOOD.length);
/* 165 */       OPACITY.O99.bind();
/* 166 */       sheet.renderTextured(blood().getTexture(BLOOD[bloodI]), nr, x, y);
/* 167 */       OPACITY.unbind();
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 172 */     if (a.inWater && a.physics.getZ() == 0.0D) {
/* 173 */       int i = GAME.intervals().get05() % WATER.length;
/* 174 */       sheet.renderTextured(water().getTexture(WATER[i] + dir), nr, x, y);
/*     */     } else {
/* 176 */       s.setDistance2Ground(a.physics.getZ());
/* 177 */       int h = (int)(a.physics.getHeight() * this.height);
/* 178 */       if (a.isBaby())
/* 179 */         h /= 2; 
/* 180 */       s.setHeight(h);
/* 181 */       sheet.render((SPRITE_RENDERER)s, nr, x, y);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected abstract int getRow(Animal paramAnimal, float paramFloat);
/*     */   
/*     */   public static void renderCorpse(AnimalSpecies s, Renderer r, ShadowBatch shadows, float ds, int x, int y, int state, int rot, int ran, double statef, COLOR decay) {
/* 188 */     TILE_SHEET sheet = s.sheet;
/*     */     
/* 190 */     shadows.setHeight(2).setDistance2Ground(0.0D);
/* 191 */     if (state == 0) {
/* 192 */       int t = 64;
/* 193 */       if ((ran & 0x1) == 1) {
/* 194 */         t += 8;
/*     */       }
/* 196 */       t += rot;
/* 197 */       sheet.render((SPRITE_RENDERER)r, t, x, y);
/* 198 */       sheet.render((SPRITE_RENDERER)shadows, t, x, y);
/* 199 */     } else if (state == 1) {
/* 200 */       int t = 48 + rot;
/* 201 */       sheet.render((SPRITE_RENDERER)r, t, x, y);
/* 202 */       sheet.render((SPRITE_RENDERER)shadows, t, x, y);
/* 203 */       int bloodI = (int)(statef * BLOOD.length);
/*     */       
/* 205 */       if (bloodI > 0) {
/* 206 */         OPACITY.O99.bind();
/* 207 */         sheet.renderTextured(blood().getTexture(BLOOD[bloodI - 1]), t, x, y);
/* 208 */         OPACITY.unbind();
/*     */       } 
/* 210 */     } else if (state == 2) {
/* 211 */       decay.bind();
/* 212 */       int t = 80 + rot;
/* 213 */       sheet.render((SPRITE_RENDERER)r, t, x, y);
/* 214 */       sheet.render((SPRITE_RENDERER)shadows, t, x, y);
/* 215 */       COLOR.unbind();
/*     */     }
/* 217 */     else if (state == 3) {
/* 218 */       int t = 88 + rot;
/* 219 */       sheet.render((SPRITE_RENDERER)r, t, x, y);
/* 220 */       sheet.render((SPRITE_RENDERER)shadows, t, x, y);
/*     */     } else {
/* 222 */       throw new RuntimeException();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 228 */   private static int[] cWalk = new int[] {
/* 229 */       24, 32, 40
/*     */     };
/*     */ 
/*     */   
/*     */   static void renderCaravan(SPRITE_RENDERER r, ShadowBatch s, double movement, int cx, int cy, RESOURCE res, int resAmount, boolean inWater, int dir, int ran) {
/* 234 */     AnimalSpecies sp = (AnimalSpecies)(SETT.ANIMALS()).caravans.getC(ran & 0xFF);
/*     */     
/* 236 */     renderMount(sp, r, s, movement, cx, cy, inWater, dir, ran);
/*     */     
/* 238 */     if (res != null) {
/* 239 */       (SETT.ANIMALS()).sprites.crate.renderC(r, dir, cx, cy);
/*     */     }
/* 241 */     if (res != null && resAmount > 0) {
/* 242 */       res.renderLaying(r, cx - 32, cy - 32, 0, resAmount);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static void renderMount(AnimalSpecies sp, SPRITE_RENDERER r, ShadowBatch s, double movement, int cx, int cy, boolean inWater, int dir, int ran) {
/* 249 */     int nr = 0;
/*     */     
/* 251 */     int row = cWalk[(int)(movement * cWalk.length) % cWalk.length];
/* 252 */     nr += row + dir;
/* 253 */     sp.sheet.renderC(r, nr, cx, cy);
/*     */     
/* 255 */     if (inWater) {
/* 256 */       int i = GAME.intervals().get05() % WATER.length;
/* 257 */       int x1 = cx - sp.sheet.size() / 2;
/* 258 */       int y1 = cy - sp.sheet.size() / 2;
/* 259 */       OPACITY.O99.bind();
/* 260 */       sp.sheet.renderTextured(water().getTexture(WATER[i] + dir), nr, x1, y1);
/* 261 */       OPACITY.unbind();
/*     */     } else {
/* 263 */       s.setDistance2Ground(0.0D);
/* 264 */       s.setHeight(2);
/* 265 */       sp.sheet.renderC((SPRITE_RENDERER)s, nr, cx, cy);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\animal\Sprite.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */