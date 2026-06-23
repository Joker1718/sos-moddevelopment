/*     */ package settlement.thing.pointlight;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.CORE;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.light.LIGHT_POINT;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ import snake2d.util.sprite.TextureCoords;
/*     */ 
/*     */ 
/*     */ 
/*     */ abstract class LightModel
/*     */ {
/*  20 */   static final LightModel candle = new LightModel(10, 0)
/*     */     {
/*     */       double flicker(LightModel.PointLight l, int radius)
/*     */       {
/*  24 */         l.offX = (int)(RND.rExpo() * RND.rInt0(7));
/*  25 */         l.offY = (int)(RND.rExpo() * RND.rInt0(7));
/*  26 */         double intense = 5.0D + Math.pow(RND.rFloat0(0.8D), 3.0D);
/*  27 */         l.r = intense * 1.7D;
/*  28 */         l.g = intense * 0.8D;
/*  29 */         l.b = intense * 0.4D;
/*  30 */         l.radius = radius - RND.rInt(8);
/*  31 */         l.falloff = 1.0D;
/*  32 */         l.z = (30 + RND.rInt0(5));
/*  33 */         return (0.03F + RND.rFloat(0.05000000074505806D));
/*     */       }
/*     */ 
/*     */       
/*     */       void renderSprite(int x1, int y1, int ran) {
/*  38 */         (SETT.LIGHTS()).sprites.candle.renderC((SPRITE_RENDERER)CORE.renderer(), ran & 0x7, x1, y1);
/*     */       }
/*     */ 
/*     */       
/*     */       void renderFlame(int tx, int ty, int x1, int y1, int ran) {
/*  43 */         flame(tx, ty, x1, y1, ran, (SETT.LIGHTS()).sprites.flame_small, 2);
/*     */       }
/*     */ 
/*     */       
/*     */       protected double intensity(int x, int y) {
/*  48 */         return super.intensity(x, y);
/*     */       }
/*     */     };
/*     */   
/*  52 */   static final LightModel torch = new LightModel(10, 1)
/*     */     {
/*     */       double flicker(LightModel.PointLight l, int radius)
/*     */       {
/*  56 */         l.offX = (int)(RND.rExpo() * RND.rInt0(7));
/*  57 */         l.offY = (int)(RND.rExpo() * RND.rInt0(7));
/*  58 */         double intense = (4.0F + RND.rExpo() * RND.rFloat0(0.800000011920929D));
/*  59 */         l.r = intense * 1.8D;
/*  60 */         l.g = intense * 0.9D;
/*  61 */         l.b = intense * 0.4D;
/*  62 */         l.radius = radius - RND.rInt(8);
/*  63 */         l.falloff = 1.0D;
/*  64 */         l.z = (30 + RND.rInt0(5));
/*  65 */         return 0.025D + RND.rFloat(0.05000000074505806D);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       void renderSprite(int x1, int y1, int ran) {}
/*     */ 
/*     */ 
/*     */       
/*     */       void renderFlame(int tx, int ty, int x1, int y1, int ran) {
/*  75 */         flame(tx, ty, x1, y1, ran, (SETT.LIGHTS()).sprites.flame_medium, 24);
/*     */       }
/*     */     };
/*     */   
/*  79 */   static final LightModel torch_big = new LightModel(12, 2)
/*     */     {
/*     */       double flicker(LightModel.PointLight l, int radius)
/*     */       {
/*  83 */         l.offX = (int)(RND.rExpo() * RND.rInt0(7));
/*  84 */         l.offY = (int)(RND.rExpo() * RND.rInt0(7));
/*  85 */         double intense = (4.0F + RND.rExpo() * RND.rFloat0(0.800000011920929D));
/*  86 */         l.r = intense * 1.8D;
/*  87 */         l.g = intense * 0.9D;
/*  88 */         l.b = intense * 0.3D;
/*  89 */         l.radius = radius;
/*  90 */         l.falloff = 1.0D;
/*  91 */         l.z = (30 + RND.rInt0(5));
/*  92 */         return 0.025D + RND.rFloat(0.05000000074505806D);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       void renderSprite(int x1, int y1, int ran) {}
/*     */ 
/*     */ 
/*     */       
/*     */       void renderFlame(int tx, int ty, int x1, int y1, int ran) {
/* 102 */         flame(tx, ty, x1, y1, ran, (SETT.LIGHTS()).sprites.flame_big, 48);
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */   
/* 108 */   static final LightModel fire = new LightModel(5, 3)
/*     */     {
/*     */       double flicker(LightModel.PointLight l, int radius)
/*     */       {
/* 112 */         l.offX = (int)(RND.rExpo() * RND.rInt0(7));
/* 113 */         l.offY = (int)(RND.rExpo() * RND.rInt0(7));
/* 114 */         double intense = 2.5D + Math.pow(RND.rFloat0(0.8D), 3.0D);
/* 115 */         l.r = intense * 1.7D;
/* 116 */         l.g = intense * 0.8D;
/* 117 */         l.b = intense * 0.3D;
/* 118 */         l.radius = radius;
/* 119 */         l.falloff = 1.0D;
/* 120 */         l.z = 15.0D;
/* 121 */         return (0.03F + RND.rFloat(0.05000000074505806D));
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       void renderSprite(int x1, int y1, int ran) {}
/*     */ 
/*     */ 
/*     */       
/*     */       void renderFlame(int tx, int ty, int cx, int cy, int ran) {
/* 132 */         flame(tx, ty, cx, cy, ran, (SETT.LIGHTS()).sprites.flame_big, 48);
/*     */       }
/*     */ 
/*     */       
/*     */       protected double intensity(int x, int y) {
/* 137 */         return 1.0D;
/*     */       }
/*     */     };
/*     */   
/* 141 */   static final LightModel mouse = new LightModel(15, 4)
/*     */     {
/*     */       double flicker(LightModel.PointLight l, int radius)
/*     */       {
/* 145 */         l.offX = (int)(RND.rExpo() * RND.rInt0(7));
/* 146 */         l.offY = (int)(RND.rExpo() * RND.rInt0(7));
/* 147 */         double intense = (5.0F + RND.rExpo() * RND.rFloat0(0.20000000298023224D));
/* 148 */         l.r = intense * 1.3D;
/* 149 */         l.g = intense * 0.7D;
/* 150 */         l.b = intense * 0.3D;
/* 151 */         l.radius = radius;
/* 152 */         l.falloff = 0.4D;
/* 153 */         l.z = 20.0D;
/* 154 */         return 0.025D + RND.rFloat(0.05000000074505806D);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       void renderSprite(int x1, int y1, int ran) {}
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       void renderFlame(int tx, int ty, int cx, int cy, int ran) {}
/*     */     };
/*     */ 
/*     */ 
/*     */   
/* 170 */   static final ArrayList<LightModel> all = new ArrayList((Object[])new LightModel[] { candle, torch, torch_big, fire, mouse }); private static final int RNDS = 64; private final int tileDiameter;
/*     */   
/*     */   static void flickerr(float ds) {
/* 173 */     for (LightModel m : all) {
/* 174 */       m.flicker(ds);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/* 179 */   private final PointLight[] lights = new PointLight[64];
/*     */   private final PointRayTracer tracer;
/*     */   private final int radius;
/*     */   final int index;
/*     */   
/*     */   private LightModel(int tileDiameter, int index) {
/* 185 */     this.index = index;
/* 186 */     if (tileDiameter % 2 == 0)
/* 187 */       tileDiameter++; 
/* 188 */     this.tracer = new PointRayTracer(tileDiameter);
/* 189 */     this.tileDiameter = tileDiameter;
/* 190 */     for (int i = 0; i < 64; i++) {
/* 191 */       this.lights[i] = new PointLight();
/*     */     }
/* 193 */     this.radius = tileDiameter * 64 / 2 - 32;
/*     */   }
/*     */   
/*     */   void flicker(float ds) {
/* 197 */     for (int i = 0; i < 64; i++) {
/* 198 */       (this.lights[i]).timer -= ds;
/* 199 */       if ((this.lights[i]).timer <= 0.0D)
/*     */       {
/* 201 */         (this.lights[i]).timer = flicker(this.lights[i], this.radius); } 
/*     */     } 
/*     */   }
/*     */   
/*     */   abstract double flicker(PointLight paramPointLight, int paramInt);
/*     */   
/*     */   abstract void renderSprite(int paramInt1, int paramInt2, int paramInt3);
/*     */   
/*     */   abstract void renderFlame(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
/*     */   
/*     */   void flame(int tx, int ty, int x1, int y1, int ran, TILE_SHEET flame, int sparks) {
/* 212 */     double wi = (SETT.WEATHER()).wind.getD();
/* 213 */     if (SETT.TERRAIN().get(tx, ty).roofIs())
/* 214 */       wi = 0.0D; 
/* 215 */     FireSparks.render(x1, y1, sparks, ran, wi);
/*     */     
/* 217 */     int w = flame.size() / 2;
/*     */ 
/*     */     
/* 220 */     flame.render((SPRITE_RENDERER)CORE.renderer(), ran & 0x7, x1 - w, y1 - w);
/*     */     
/* 222 */     x1 -= 32;
/* 223 */     y1 -= 32;
/*     */     
/* 225 */     OPACITY.O75.bind();
/*     */     
/* 227 */     TextureCoords c = (SETT.LIGHTS()).sprites.texture.get(ran >> 4 & 0x7, ran >> 5 & 0x7);
/* 228 */     TextureCoords d = (SETT.LIGHTS()).sprites.displacement.get(ran >> 4 & 0x7, ran >> 5 & 0x7);
/* 229 */     CORE.renderer().renderDisplaced(x1, x1 + 64, y1, y1 + 64, d, c);
/* 230 */     OPACITY.unbind();
/*     */   }
/*     */ 
/*     */   
/*     */   void register(Renderer r, int ran, int x, int y, int offx, int offy) {
/* 235 */     double i = intensity(x, y);
/*     */     
/* 237 */     if (i == 0.0D) {
/*     */       return;
/*     */     }
/* 240 */     renderFlame(x >> 6, y >> 6, x + offx, y + offy, ran);
/*     */     
/* 242 */     this.tracer.init(x, y);
/*     */     
/* 244 */     PointLight light = this.lights[ran & 0x2F];
/*     */     
/* 246 */     double lr = light.r;
/* 247 */     double lg = light.g;
/* 248 */     double lb = light.b;
/*     */ 
/*     */     
/* 251 */     light.r *= i;
/* 252 */     light.g *= i;
/* 253 */     light.b *= i;
/*     */     
/* 255 */     light.x = (x + offx);
/* 256 */     light.y = (y + offy);
/*     */     
/* 258 */     int sx = (x & 0xFFFFFFC0) + offx - this.tileDiameter / 2 * 64;
/* 259 */     int sy = (y & 0xFFFFFFC0) + offy - this.tileDiameter / 2 * 64;
/*     */     
/* 261 */     for (int ty = 0; ty < this.tileDiameter; ty++) {
/* 262 */       for (int tx = 0; tx < this.tileDiameter; tx++) {
/*     */         
/* 264 */         x = sx + tx * 64;
/* 265 */         y = sy + ty * 64;
/* 266 */         if (this.tracer.litIs(tx, ty)) {
/* 267 */           r.registerLight(
/* 268 */               light, 
/* 269 */               x, x + 64, 
/* 270 */               y, y + 64, 
/* 271 */               this.tracer.getSide(tx, ty, DIR.NE), 
/* 272 */               this.tracer.getSide(tx, ty, DIR.SE), 
/* 273 */               this.tracer.getSide(tx, ty, DIR.SW), 
/* 274 */               this.tracer.getSide(tx, ty, DIR.NW));
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 279 */     light.r = lr;
/* 280 */     light.g = lg;
/* 281 */     light.b = lb;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected double intensity(int x, int y) {
/* 287 */     double i = 1.0D;
/*     */     
/* 289 */     if (SETT.TERRAIN().get(x >> 6, y >> 6) == (SETT.TERRAIN()).CAVE) {
/* 290 */       if (TIME.light().dayIs()) {
/* 291 */         i *= 0.75D;
/* 292 */       } else if (TIME.light().partOfCircular() < 0.2D) {
/* 293 */         i *= 0.75D + 0.75D * TIME.light().partOfCircular() / 0.2D;
/*     */       } else {
/* 295 */         i *= 1.5D;
/*     */       } 
/* 297 */     } else if (SETT.TERRAIN().get(x >> 6, y >> 6).roofIs()) {
/* 298 */       if (TIME.light().dayIs()) {
/* 299 */         i *= 0.25D;
/* 300 */       } else if (TIME.light().partOfCircular() < 0.2D) {
/* 301 */         i *= 0.25D + TIME.light().partOfCircular() / 0.2D;
/*     */       } 
/* 303 */     } else if (TIME.light().partOfCircular() < 0.2D) {
/* 304 */       if (TIME.light().dayIs())
/* 305 */         return 0.0D; 
/* 306 */       i *= TIME.light().partOfCircular() / 0.2D;
/* 307 */     } else if (TIME.light().dayIs()) {
/* 308 */       return 0.0D;
/*     */     } 
/* 310 */     return i;
/*     */   }
/*     */   
/*     */   static class PointLight implements LIGHT_POINT {
/*     */     double r;
/*     */     double g;
/*     */     double b;
/*     */     
/*     */     PointLight() {
/* 319 */       this.rOff = (byte)RND.rInt(32);
/*     */     }
/*     */     double falloff; int radius; byte rOff; double x; double y; double z;
/*     */     double timer;
/*     */     int offX;
/*     */     int offY;
/*     */     
/*     */     public float getRed() {
/* 327 */       return (float)this.r;
/*     */     }
/*     */ 
/*     */     
/*     */     public float getGreen() {
/* 332 */       return (float)this.g;
/*     */     }
/*     */ 
/*     */     
/*     */     public float getBlue() {
/* 337 */       return (float)this.b;
/*     */     }
/*     */ 
/*     */     
/*     */     public float getFalloff() {
/* 342 */       return (float)this.falloff;
/*     */     }
/*     */ 
/*     */     
/*     */     public int getRadius() {
/* 347 */       return this.radius + this.rOff;
/*     */     }
/*     */ 
/*     */     
/*     */     public float cx() {
/* 352 */       return (float)(this.x + this.offX);
/*     */     }
/*     */ 
/*     */     
/*     */     public float cy() {
/* 357 */       return (float)(this.y + this.offY);
/*     */     }
/*     */ 
/*     */     
/*     */     public float cz() {
/* 362 */       return (float)this.z;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\pointlight\LightModel.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */