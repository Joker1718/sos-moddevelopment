/*     */ package snake2d;
/*     */ 
/*     */ import java.nio.IntBuffer;
/*     */ import org.lwjgl.opengl.GL20;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.sprite.TextureCoords;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class VboSprite
/*     */   extends VboAbs
/*     */ {
/*     */   private final Shader shader;
/*     */   private final IntBuffer sBuff;
/*     */   private final VboSorter sorter;
/*  22 */   private int layer = 0;
/*     */   
/*     */   static VboSprite getDebug(SETTINGS sett) {
/*  25 */     Shader shader = new Shader(sett.getNativeWidth(), sett.getNativeHeight(), "SpritePoint", "SpritePoint", "SpritePoint_debug");
/*  26 */     shader.setUniform1i("u_texture", 0);
/*  27 */     return new VboSprite(shader);
/*     */   }
/*     */   
/*     */   static VboSprite getDeffered(SETTINGS sett) {
/*  31 */     Shader shader = new Shader(sett.getNativeWidth(), sett.getNativeHeight(), "SpritePoint", "SpritePoint", "SpritePoint");
/*  32 */     shader.setUniform1i("sampler1", 0);
/*  33 */     shader.setUniform1i("sampler2", 1);
/*  34 */     return new VboSprite(shader);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public VboSprite(Shader shader) {
/*  45 */     super(0, 131072, new VboAbs.VboAttribute[] { new VboAbs.VboAttribute(2, 5122, false, 2), new VboAbs.VboAttribute(2, 5122, false, 2), new VboAbs.VboAttribute(2, 5123, 2), new VboAbs.VboAttribute(2, 5123, 2), new VboAbs.VboAttribute(2, 5123, 2), new VboAbs.VboAttribute(4, 5121, true, 1) });
/*     */     
/*  47 */     this.sorter = new VboSorter(this.MAX_ELEMENTS * 6);
/*  48 */     this.shader = shader;
/*  49 */     this.sBuff = this.buffer.asIntBuffer();
/*     */   }
/*     */   
/*     */   int setNew() {
/*  53 */     this.layer++;
/*  54 */     return this.layer;
/*     */   }
/*     */ 
/*     */   
/*     */   void flush() {
/*  59 */     bind();
/*  60 */     this.shader.bind();
/*  61 */     this.sBuff.position(0);
/*  62 */     VboSorter.Counts ss = this.sorter.fill(this.sBuff);
/*  63 */     this.buffer.position(this.sBuff.position() * 4);
/*  64 */     upload();
/*     */     
/*  66 */     for (int i = 0; i <= this.layer; i++) {
/*     */       
/*  68 */       int fromI = ss.from[i];
/*  69 */       int toI = ss.to[i];
/*  70 */       if (toI > fromI) {
/*  71 */         GlHelper.Stencil.setLEQUALreplaceOnPass(i);
/*  72 */         flush(fromI / 6, toI / 6);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  79 */     clear();
/*  80 */     GL20.glUseProgram(0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/*  85 */     this.sorter.clear();
/*  86 */     this.layer = 0;
/*  87 */     super.clear();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   final void render(TextureCoords t, int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4, COLOR color, OPACITY opacity) {
/*  93 */     render(t, t, x1, x2, y1, y2, color, opacity);
/*     */   }
/*     */   
/*     */   final void render(TextureCoords t, TextureCoords to, int x1, int x2, int y1, int y2, COLOR color, OPACITY opacity) {
/*  97 */     VboSorter sorter = this.sorter;
/*  98 */     sorter.add(this.layer, y1 << 16 | x1 & 0xFFFF);
/*  99 */     sorter.add(this.layer, y2 << 16 | x2 & 0xFFFF);
/* 100 */     sorter.add(this.layer, t.y1 << 16 | t.x1);
/* 101 */     sorter.add(this.layer, to.y1 << 16 | to.x1);
/* 102 */     sorter.add(this.layer, t.y2 - t.y1 << 16 | t.x2 - t.x1);
/* 103 */     sorter.add(this.layer, opacity.get() << 24 | (color.blue() & 0xFF) << 16 | (color.green() & 0xFF) << 8 | color.red() & 0xFF);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void dis() {
/* 109 */     this.shader.dis();
/* 110 */     super.dis();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2d\VboSprite.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */