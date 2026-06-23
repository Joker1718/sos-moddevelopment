/*     */ package snake2d;
/*     */ 
/*     */ import org.lwjgl.opengl.GL11;
/*     */ import org.lwjgl.opengl.GL20;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.file.Alloc;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class VboParticles
/*     */   extends VboAbsExt
/*     */ {
/*  18 */   private final byte byteZero = 0;
/*  19 */   private final byte byteFull = -1;
/*  20 */   private final int[] size = Alloc.ii(255);
/*     */   private final Shader shader;
/*     */   
/*     */   static VboParticles getDebug(SETTINGS sett) {
/*  24 */     Shader shader = new Shader(sett.getNativeWidth(), sett.getNativeHeight(), "Particle_debug", null, "Particle_debug");
/*  25 */     return new VboParticles(shader);
/*     */   }
/*     */   
/*     */   static VboParticles getForTexture(int width, int height) {
/*  29 */     Shader shader = new Shader(width - 0.5D, height + 0.5D, "Particle_texture", null, "Particle_texture");
/*  30 */     return new VboParticles(shader);
/*     */   }
/*     */   
/*     */   static VboParticles getDeffered(SETTINGS sett) {
/*  34 */     Shader shader = new Shader(sett.getNativeWidth(), sett.getNativeHeight(), "Particle", null, "Particle");
/*  35 */     return new VboParticles(shader);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public VboParticles(Shader shader) {
/*  42 */     super(0, 131072, new VboAbs.VboAttribute[] { new VboAbs.VboAttribute(2, 5122, false, 2), new VboAbs.VboAttribute(4, 5121, true, 1), new VboAbs.VboAttribute(4, 5121, true, 1) });
/*     */     
/*  44 */     this.shader = shader;
/*  45 */     this.size[0] = 1;
/*     */   }
/*     */ 
/*     */   
/*     */   void setNew(int pointSize) {
/*  50 */     this.vTo[this.current] = this.count;
/*  51 */     this.current++;
/*  52 */     this.vFrom[this.current] = this.count;
/*  53 */     this.size[this.current] = pointSize;
/*     */   }
/*     */ 
/*     */   
/*     */   final void flush(int pointSize) {
/*  58 */     bindAndUpload();
/*  59 */     this.shader.bind();
/*  60 */     int i = 0;
/*  61 */     this.vTo[this.current] = this.count;
/*  62 */     while (i <= this.current) {
/*  63 */       if (this.vFrom[i] != this.vTo[i]) {
/*  64 */         GlHelper.Stencil.setLEQUALreplaceOnPass(i);
/*  65 */         flush(this.vFrom[i], this.vTo[i], this.size[i]);
/*     */       } 
/*  67 */       i++;
/*     */     } 
/*  69 */     clear(pointSize);
/*  70 */     GL20.glUseProgram(0);
/*     */   }
/*     */ 
/*     */   
/*     */   public int count() {
/*  75 */     return this.buffer.position();
/*     */   }
/*     */   
/*     */   private void flush(int from, int to, int size) {
/*  79 */     if (size < 1)
/*  80 */       throw new RuntimeException(); 
/*  81 */     GL11.glPointSize(size);
/*  82 */     GL11.glDrawElements(0, to - from, 5125, (from * 4));
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear(int pointSize) {
/*  87 */     clear();
/*  88 */     this.size[this.current] = pointSize;
/*     */   }
/*     */   
/*     */   public void render(short x, short y, byte nX, byte nY, byte nZ, byte nA, COLOR color, OPACITY opacity) {
/*  92 */     if (this.count >= this.MAX_ELEMENTS) {
/*     */       return;
/*     */     }
/*     */     
/*  96 */     this.buffer.putShort(x).putShort(y);
/*  97 */     this.buffer.put(nX).put(nY).put(nZ).put(nA);
/*  98 */     this.buffer.put(color.red()).put(color.green()).put(color.blue()).put(opacity.get());
/*     */     
/* 100 */     this.count++;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(short x, short y, byte red, byte green, byte blue) {
/* 106 */     if (this.count >= this.MAX_ELEMENTS) {
/*     */       return;
/*     */     }
/*     */     
/* 110 */     this.buffer.putShort(x).putShort(y);
/* 111 */     this.buffer.put((byte)0).put((byte)0).put((byte)0).put((byte)0);
/* 112 */     this.buffer.put(red).put(green).put(blue).put((byte)-1);
/*     */     
/* 114 */     this.count++;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void dis() {
/* 121 */     this.shader.dis();
/* 122 */     super.dis();
/*     */   }
/*     */   
/*     */   public void dis(boolean leaveIndexArrayTheFuckAlone) {
/* 126 */     this.shader.dis();
/* 127 */     super.dis();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2d\VboParticles.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */