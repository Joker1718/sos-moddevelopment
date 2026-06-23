/*     */ package snake2d;
/*     */ 
/*     */ import org.lwjgl.opengl.GL20;
/*     */ 
/*     */ 
/*     */ 
/*     */ class VboTileLight
/*     */   extends VboAbsExt
/*     */ {
/*     */   public static final int MAX_ELEMENTS = 16384;
/*  11 */   private float[] lights = new float[1785];
/*  12 */   private final float inv = 0.003921569F;
/*     */   
/*     */   private final Shader shader;
/*     */   
/*     */   private boolean specialLayer;
/*     */   
/*     */   private final int uTilt;
/*     */   
/*     */   private final int uColor;
/*     */   private final int uDepth;
/*     */   
/*     */   public VboTileLight(SETTINGS sett) {
/*  24 */     super(0, 16384, new VboAbs.VboAttribute[] { new VboAbs.VboAttribute(2, 5122, false, 2), new VboAbs.VboAttribute(4, 5121, true, 1), new VboAbs.VboAttribute(2, 5122, false, 2) });
/*     */ 
/*     */ 
/*     */     
/*  28 */     this.shader = new Shader(sett.getNativeWidth(), sett.getNativeHeight(), "LightTile", "LightTile", "LightTile");
/*     */     
/*  30 */     this.shader.setUniform1i("Tdiffuse", 2);
/*  31 */     this.shader.setUniform1i("Tnormal", 3);
/*     */     
/*  33 */     this.uTilt = this.shader.getUniformLocation("v_tilt");
/*  34 */     this.uColor = this.shader.getUniformLocation("v_color");
/*  35 */     this.uDepth = this.shader.getUniformLocation("u_depth");
/*     */   }
/*     */ 
/*     */   
/*     */   void upload(float r, float g, float b, float x, float y, float z, float depth) {
/*  40 */     this.shader.setUniform(this.uColor, r, g, b);
/*  41 */     this.shader.setUniform(this.uTilt, x, y, z);
/*  42 */     this.shader.setUniform(this.uDepth, depth);
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
/*  91 */       int k = i * 7;
/*  92 */       upload(this.lights[k], this.lights[k + 1], this.lights[k + 2], this.lights[k + 3], this.lights[k + 4], this.lights[k + 5], 
/*  93 */           this.lights[k + 6]);
/*  94 */       flush(this.vFrom[i], this.vTo[i]);
/*  95 */       i++;
/*     */     } 
/*  97 */     GL20.glUseProgram(0);
/*  98 */     GlHelper.enableDepthTest(false);
/*  99 */     GlHelper.setBlendNormal();
/* 100 */     clear();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/* 106 */     super.clear();
/* 107 */     this.specialLayer = false;
/*     */   }
/*     */ 
/*     */   
/*     */   void render(int x1, int y1, int dim, byte nw, byte ne, byte se, byte sw) {
/* 112 */     if (this.count >= 16384) {
/*     */       return;
/*     */     }
/*     */     
/* 116 */     this.buffer.putShort((short)x1).putShort((short)y1);
/* 117 */     this.buffer.put(nw).put(ne).put(se).put(sw);
/* 118 */     this.buffer.putShort((short)dim);
/* 119 */     this.buffer.put(127).put(127);
/*     */     
/* 121 */     this.count++;
/*     */   }
/*     */   
/*     */   void setLight(float red, float green, float blue, float x, float y, float z, byte depth) {
/* 125 */     int i = this.current * 7;
/* 126 */     this.lights[i] = red;
/* 127 */     this.lights[i + 1] = green;
/* 128 */     this.lights[i + 2] = blue;
/* 129 */     this.lights[i + 3] = x;
/* 130 */     this.lights[i + 4] = y;
/* 131 */     this.lights[i + 5] = z;
/* 132 */     this.lights[i + 6] = (depth & 0xFF) * 0.003921569F;
/*     */   }
/*     */ 
/*     */   
/*     */   public void dis() {
/* 137 */     this.shader.dis();
/* 138 */     super.dis();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2d\VboTileLight.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */