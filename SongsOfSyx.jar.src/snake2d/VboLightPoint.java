/*     */ package snake2d;
/*     */ 
/*     */ import org.lwjgl.opengl.GL20;
/*     */ import snake2d.util.light.LIGHT_POINT;
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
/*     */ class VboLightPoint
/*     */   extends VboAbsExt
/*     */ {
/*     */   private boolean specialLayer;
/*     */   private final Shader shader;
/*     */   
/*     */   VboLightPoint(SETTINGS sett) {
/*  25 */     super(0, 30000, new VboAbs.VboAttribute[] { new VboAbs.VboAttribute(3, 5126, false, 4), new VboAbs.VboAttribute(2, 5122, false, 2), new VboAbs.VboAttribute(2, 5122, false, 2), new VboAbs.VboAttribute(4, 5126, false, 4), new VboAbs.VboAttribute(4, 5121, true, 1), new VboAbs.VboAttribute(1, 5126, false, 4), new VboAbs.VboAttribute(4, 5121, true, 1) });
/*     */     
/*  27 */     this.shader = new Shader(sett.getNativeWidth(), sett.getNativeHeight(), "LightPoint", "LightPoint", "LightPoint");
/*     */     
/*  29 */     this.shader.setUniform1i("Tdiffuse", 2);
/*  30 */     this.shader.setUniform1i("Tnormal", 3);
/*     */   }
/*     */   
/*     */   void setNew() {
/*  34 */     if (this.specialLayer)
/*     */       return; 
/*  36 */     this.vTo[this.current] = this.count;
/*  37 */     this.current++;
/*  38 */     this.vFrom[this.current] = this.count;
/*     */   }
/*     */   
/*     */   void setNewButKeepLight() {
/*  42 */     if (this.specialLayer)
/*     */       return; 
/*  44 */     this.vTo[this.current] = this.count;
/*  45 */     this.current++;
/*  46 */     this.vFrom[this.current] = this.vFrom[this.current - 1];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setNewFinal() {
/*  53 */     this.specialLayer = true;
/*  54 */     this.vTo[this.current] = this.count;
/*  55 */     this.current++;
/*  56 */     this.vFrom[this.current] = this.count;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void flush() {
/*  62 */     bindAndUpload();
/*     */     
/*  64 */     GlHelper.setBlendAdditative();
/*  65 */     GlHelper.enableDepthTest(true);
/*  66 */     GlHelper.setDepthTestLess();
/*  67 */     this.shader.bind();
/*  68 */     int i = 0;
/*  69 */     this.vTo[this.current] = this.count;
/*  70 */     while (i <= this.current) {
/*  71 */       if (this.specialLayer && i == this.current) {
/*  72 */         GlHelper.Stencil.setLEQUALKeepOnFail(i);
/*     */       } else {
/*  74 */         GlHelper.Stencil.setEQUALKeepOnFail(i);
/*     */       } 
/*  76 */       flush(this.vFrom[i], this.vTo[i]);
/*  77 */       i++;
/*     */     } 
/*  79 */     GL20.glUseProgram(0);
/*  80 */     GlHelper.enableDepthTest(false);
/*  81 */     GlHelper.setBlendNormal();
/*  82 */     clear();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void render(LIGHT_POINT l, float x, float y, float z, int radius, int x1, int x2, int y1, int y2, byte ne, byte se, byte sw, byte nw, byte depth) {
/*  89 */     if (this.count >= this.MAX_ELEMENTS) {
/*     */       return;
/*     */     }
/*     */     
/*  93 */     float d = l.getRadius();
/*  94 */     d /= radius;
/*     */     
/*  96 */     this.buffer.putFloat(x).putFloat(y).putFloat(l.cz());
/*  97 */     this.buffer.putShort((short)x1).putShort((short)y1).putShort((short)x2).putShort((short)y2);
/*     */     
/*  99 */     this.buffer.putFloat(l.getRed()).putFloat(l.getGreen()).putFloat(l.getBlue()).putFloat(l.getFalloff() * d);
/* 100 */     this.buffer.put(nw).put(ne).put(se).put(sw);
/* 101 */     this.buffer.putFloat(radius);
/* 102 */     this.buffer.put(depth);
/* 103 */     this.buffer.put(127).put(127).put(127);
/*     */     
/* 105 */     this.count++;
/*     */   }
/*     */ 
/*     */   
/*     */   public void dis() {
/* 110 */     this.shader.dis();
/* 111 */     super.dis();
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 116 */     this.current = 0;
/* 117 */     this.specialLayer = false;
/* 118 */     super.clear();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2d\VboLightPoint.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */