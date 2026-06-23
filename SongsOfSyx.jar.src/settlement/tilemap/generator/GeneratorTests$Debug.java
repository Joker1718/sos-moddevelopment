/*     */ package settlement.tilemap.generator;
/*     */ 
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.color.OpacityImp;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.HeightMap;
/*     */ import util.data.DOUBLE;
/*     */ import util.gui.slider.GGaugeMutable;
/*     */ import view.interrupter.ISidePanel;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Debug
/*     */   extends ISidePanel
/*     */ {
/*  91 */   final int size = 128;
/*  92 */   final int scale = 4;
/*  93 */   HeightMap ferMap = new HeightMap(128, 128, 32, 2);
/*  94 */   final HeightMap height = new HeightMap(128, 128, 128, 4);
/*  95 */   double base2 = 1.0D;
/*  96 */   double base = 0.0D;
/*     */   
/*  98 */   private byte[][] res = new byte[128][128];
/*  99 */   private final OpacityImp o = new OpacityImp(0);
/*     */   
/*     */   Debug() {
/* 102 */     this.section.add((RENDEROBJ)new RENDEROBJ.RenderImp(512)
/*     */         {
/*     */           
/*     */           public void render(SPRITE_RENDERER r, float ds)
/*     */           {
/* 107 */             for (int y = 0; y < 128; y++) {
/* 108 */               for (int x = 0; x < 128; x++) {
/* 109 */                 int px = this.body.x1() + x * 4;
/* 110 */                 int py = this.body.y1() + y * 4;
/* 111 */                 GeneratorTests.Debug.this.o.set(GeneratorTests.Debug.this.res[y][x] & 0xFF);
/* 112 */                 GeneratorTests.Debug.this.o.bind();
/* 113 */                 COLOR.WHITE100.render(r, px, px + 4, py, py + 4);
/*     */               } 
/*     */             } 
/*     */             
/* 117 */             OPACITY.unbind();
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 124 */     GGaugeMutable g = new GGaugeMutable(new DOUBLE.DOUBLE_MUTABLE()
/*     */         {
/*     */           public double getD()
/*     */           {
/* 128 */             return GeneratorTests.Debug.this.base;
/*     */           }
/*     */ 
/*     */           
/*     */           public DOUBLE.DOUBLE_MUTABLE setD(double d) {
/* 133 */             GeneratorTests.Debug.this.base = d;
/* 134 */             GeneratorTests.Debug.this.fixbase();
/* 135 */             return this;
/*     */           }
/* 137 */         },  200);
/* 138 */     this.section.addDown(8, (RENDEROBJ)g);
/*     */     
/* 140 */     g = new GGaugeMutable(new DOUBLE.DOUBLE_MUTABLE()
/*     */         {
/*     */           public double getD()
/*     */           {
/* 144 */             return GeneratorTests.Debug.this.base2;
/*     */           }
/*     */ 
/*     */           
/*     */           public DOUBLE.DOUBLE_MUTABLE setD(double d) {
/* 149 */             GeneratorTests.Debug.this.base2 = d;
/* 150 */             GeneratorTests.Debug.this.fixbase2(GeneratorTests.Debug.this.base2);
/* 151 */             return this;
/*     */           }
/* 153 */         },  200);
/* 154 */     this.section.addDown(8, (RENDEROBJ)g);
/*     */     
/* 156 */     titleSet("");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void fixbase() {
/* 162 */     for (int y = 0; y < 128; y++) {
/* 163 */       for (int x = 0; x < 128; x++) {
/* 164 */         double f = this.ferMap.get(x, y);
/* 165 */         double h = this.height.get(x, y);
/* 166 */         this.base = CLAMP.d(this.base, 0.0D, 1.0D);
/* 167 */         f = GeneratorFertilityInit.get(this.base, f, h);
/* 168 */         this.res[y][x] = (byte)(int)(255.0D * CLAMP.d(f, 0.0D, 1.0D));
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void fixbase2(double base) {
/* 174 */     base *= 0.8D;
/*     */     
/* 176 */     for (int y = 0; y < 128; y++) {
/* 177 */       for (int x = 0; x < 128; x++) {
/* 178 */         double f = this.height.get(x, y);
/* 179 */         f = Math.pow(f, 1.0D + 8.0D * (1.0D - base));
/*     */ 
/*     */         
/* 182 */         f = CLAMP.d(base + f, 0.0D, 1.0D);
/* 183 */         f -= 0.2D * this.ferMap.get(x, y);
/* 184 */         this.res[y][x] = (byte)(int)(255.0D * CLAMP.d(f, 0.0D, 1.0D));
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\generator\GeneratorTests$Debug.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */