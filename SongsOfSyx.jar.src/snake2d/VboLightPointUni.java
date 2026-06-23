/*     */ package snake2d;
/*     */ 
/*     */ import org.lwjgl.opengl.GL20;
/*     */ 
/*     */ 
/*     */ 
/*     */ class VboLightPointUni
/*     */   extends VboAbsExt
/*     */ {
/*     */   public static final int MAX_ELEMENTS = 16384;
/*  11 */   private float[] lights = new float[1275];
/*  12 */   private final float inv = 0.003921569F;
/*     */   
/*     */   private final Shader shader;
/*     */   
/*     */   private boolean specialLayer;
/*     */   
/*     */   private final int uColor;
/*     */   
/*     */   private final int uShaded;
/*     */   
/*     */   private final int uFalloff;
/*     */   
/*     */   VboLightPointUni(SETTINGS sett) {
/*  25 */     super(0, 16384, new VboAbs.VboAttribute[] { new VboAbs.VboAttribute(4, 5122, false, 2) });
/*     */     
/*  27 */     this.shader = new Shader(sett.getNativeWidth(), sett.getNativeHeight(), "LightPointUni", "LightPointUni", "LightPointUni");
/*     */     
/*  29 */     this.shader.setUniform1i("Tdiffuse", 2);
/*  30 */     this.shader.setUniform1i("Tnormal", 3);
/*  31 */     this.uColor = this.shader.getUniformLocation("u_color");
/*  32 */     this.uShaded = this.shader.getUniformLocation("u_shaded");
/*  33 */     this.uFalloff = this.shader.getUniformLocation("falloff");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void upload(float r, float g, float b, float shaded, float falloff) {
/*  40 */     this.shader.setUniform(this.uShaded, shaded);
/*  41 */     this.shader.setUniform(this.uColor, r, g, b);
/*  42 */     this.shader.setUniform(this.uFalloff, falloff);
/*     */   }
/*     */   
/*     */   void setNew() {
/*  46 */     if (this.specialLayer)
/*     */       return; 
/*  48 */     this.vTo[this.current] = this.count;
/*  49 */     this.current++;
/*  50 */     this.vFrom[this.current] = this.count;
/*     */   }
/*     */   
/*     */   void setNewButKeepLight() {
/*  54 */     if (this.specialLayer)
/*     */       return; 
/*  56 */     this.vTo[this.current] = this.count;
/*  57 */     this.current++;
/*  58 */     this.vFrom[this.current] = this.vFrom[this.current - 1];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setNewFinal() {
/*  65 */     this.specialLayer = true;
/*  66 */     this.vTo[this.current] = this.count;
/*  67 */     this.current++;
/*  68 */     this.vFrom[this.current] = this.count;
/*     */   }
/*     */ 
/*     */   
/*     */   void flush() {
/*  73 */     bindAndUpload();
/*     */     
/*  75 */     GlHelper.setBlendAdditative();
/*  76 */     GlHelper.enableDepthTest(true);
/*  77 */     GlHelper.setDepthTestLess();
/*  78 */     this.shader.bind();
/*  79 */     int i = 0;
/*  80 */     this.vTo[this.current] = this.count;
/*  81 */     while (i <= this.current) {
/*  82 */       if (this.vFrom[i] == this.vTo[i]) {
/*  83 */         i++;
/*     */         continue;
/*     */       } 
/*  86 */       if (this.specialLayer && i == this.current) {
/*  87 */         GlHelper.Stencil.setLEQUALKeepOnFail(i);
/*     */       } else {
/*  89 */         GlHelper.Stencil.setEQUALKeepOnFail(i);
/*     */       } 
/*  91 */       int k = i * 5;
/*  92 */       upload(this.lights[k], this.lights[k + 1], this.lights[k + 2], this.lights[k + 3], this.lights[k + 4]);
/*  93 */       flush(this.vFrom[i], this.vTo[i]);
/*  94 */       i++;
/*     */     } 
/*  96 */     GL20.glUseProgram(0);
/*  97 */     GlHelper.enableDepthTest(false);
/*  98 */     GlHelper.setBlendNormal();
/*  99 */     clear();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void render(short x, short y, short z, short radius) {
/* 105 */     if (this.count >= 16384) {
/*     */       return;
/*     */     }
/* 108 */     this.buffer.putShort(x).putShort(y).putShort(z).putShort(radius);
/*     */     
/* 110 */     this.count++;
/*     */   }
/*     */ 
/*     */   
/*     */   void setLight(float radius, float red, float green, float blue, float falloff, byte depth) {
/* 115 */     int i = this.current * 5;
/* 116 */     this.lights[i] = red;
/* 117 */     this.lights[i + 1] = green;
/* 118 */     this.lights[i + 2] = blue;
/* 119 */     this.lights[i + 3] = (depth & 0xFF) * 0.003921569F;
/* 120 */     this.lights[i + 4] = falloff;
/*     */   }
/*     */ 
/*     */   
/*     */   public void dis() {
/* 125 */     this.shader.dis();
/* 126 */     super.dis();
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 131 */     this.current = 0;
/* 132 */     this.specialLayer = false;
/* 133 */     super.clear();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2d\VboLightPointUni.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */