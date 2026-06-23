/*     */ package snake2d;
/*     */ 
/*     */ import java.nio.IntBuffer;
/*     */ import org.lwjgl.opengl.GL20;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.sprite.TextureCoords;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class VboSpriteOpti
/*     */   extends VboAbsExt
/*     */ {
/*     */   private final Shader shader;
/*     */   private final int[] opti;
/*     */   private int optiI;
/*     */   private final IntBuffer sBuff;
/*     */   
/*     */   static VboSpriteOpti getDebug(SETTINGS sett) {
/*  25 */     Shader shader = new Shader(sett.getNativeWidth(), sett.getNativeHeight(), "SpritePoint", "SpritePoint", "SpritePoint_debug");
/*  26 */     shader.setUniform1i("u_texture", 0);
/*  27 */     return new VboSpriteOpti(shader);
/*     */   }
/*     */   
/*     */   static VboSpriteOpti getDeffered(SETTINGS sett) {
/*  31 */     Shader shader = new Shader(sett.getNativeWidth(), sett.getNativeHeight(), "SpritePoint", "SpritePoint", "SpritePoint");
/*  32 */     shader.setUniform1i("sampler1", 0);
/*  33 */     shader.setUniform1i("sampler2", 1);
/*  34 */     return new VboSpriteOpti(shader);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public VboSpriteOpti(Shader shader) {
/*  45 */     super(0, 131072, new VboAbs.VboAttribute[] { new VboAbs.VboAttribute(2, 5122, false, 2), new VboAbs.VboAttribute(2, 5122, false, 2), new VboAbs.VboAttribute(2, 5123, 2), new VboAbs.VboAttribute(2, 5123, 2), new VboAbs.VboAttribute(2, 5123, 2), new VboAbs.VboAttribute(4, 5121, true, 1) });
/*     */     
/*  47 */     this.shader = shader;
/*  48 */     this.opti = Alloc.ii(this.MAX_ELEMENTS * 6);
/*  49 */     this.sBuff = this.buffer.asIntBuffer();
/*     */   }
/*     */   
/*     */   int setNew() {
/*  53 */     this.vTo[this.current] = this.count;
/*  54 */     this.current++;
/*  55 */     this.vFrom[this.current] = this.count;
/*  56 */     return this.current;
/*     */   }
/*     */ 
/*     */   
/*     */   void flush() {
/*  61 */     if (this.count == 0) {
/*  62 */       clear();
/*     */       
/*     */       return;
/*     */     } 
/*  66 */     int off = 0;
/*  67 */     bind();
/*  68 */     this.shader.bind();
/*  69 */     this.vTo[this.current] = this.count;
/*  70 */     while (this.count > 0) {
/*  71 */       int am = this.count;
/*  72 */       if (am > 4096) {
/*  73 */         am = 4096;
/*     */       }
/*  75 */       this.sBuff.put(this.opti, off * 6, am * 6);
/*  76 */       this.buffer.position(this.sBuff.position() * 4);
/*  77 */       this.sBuff.clear();
/*  78 */       this.optiI = 0;
/*  79 */       upload();
/*  80 */       this.shader.bind();
/*     */ 
/*     */       
/*  83 */       for (int i = 0; i <= this.current; i++) {
/*  84 */         int f = this.vFrom[i] - off;
/*  85 */         int t = this.vTo[i] - off;
/*  86 */         if (t >= 0) {
/*     */           
/*  88 */           if (f < 0)
/*  89 */             f = 0; 
/*  90 */           if (t > f) {
/*     */ 
/*     */             
/*  93 */             GlHelper.Stencil.setLEQUALreplaceOnPass(i);
/*  94 */             flush(f, t);
/*     */           } 
/*     */         } 
/*  97 */       }  off += am;
/*  98 */       this.count -= am;
/*     */     } 
/*     */     
/* 101 */     clear();
/* 102 */     GL20.glUseProgram(0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 107 */     this.optiI = 0;
/* 108 */     super.clear();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   final void render(TextureCoords t, int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4, COLOR color, OPACITY opacity) {
/* 114 */     render(t, t, x1, x2, y1, y2, color, opacity);
/*     */   }
/*     */   
/*     */   final void render(TextureCoords t, TextureCoords to, int x1, int x2, int y1, int y2, COLOR color, OPACITY opacity) {
/* 118 */     if (this.count >= this.MAX_ELEMENTS) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 123 */     this.opti[this.optiI] = y1 << 16 | x1 & 0xFFFF;
/* 124 */     this.opti[this.optiI + 1] = y2 << 16 | x2 & 0xFFFF;
/*     */     
/* 126 */     this.opti[this.optiI + 2] = t.y1 << 16 | t.x1;
/* 127 */     this.opti[this.optiI + 3] = to.y1 << 16 | to.x1;
/*     */     
/* 129 */     this.opti[this.optiI + 4] = t.y2 - t.y1 << 16 | t.x2 - t.x1;
/*     */     
/* 131 */     this.opti[this.optiI + 5] = opacity.get() << 24 | (color.blue() & 0xFF) << 16 | (color.green() & 0xFF) << 8 | color.red() & 0xFF;
/*     */ 
/*     */     
/* 134 */     this.optiI += 6;
/* 135 */     this.count++;
/*     */   }
/*     */ 
/*     */   
/*     */   public void dis() {
/* 140 */     this.shader.dis();
/* 141 */     super.dis();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2d\VboSpriteOpti.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */