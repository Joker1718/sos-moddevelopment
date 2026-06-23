/*     */ package snake2d;
/*     */ 
/*     */ import java.nio.IntBuffer;
/*     */ import org.lwjgl.opengl.GL20;
/*     */ import snake2d.util.light.LIGHT_AMBIENT;
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
/*     */ class VboLightAmbient
/*     */   extends VboAbsExt
/*     */ {
/*     */   private boolean specialLayer;
/*     */   private final Shader shader;
/*     */   private final IntBuffer sBuff;
/*     */   private final VboSorter sorter;
/*     */   
/*     */   VboLightAmbient(SETTINGS sett) {
/*  28 */     super(4, 4096, new VboAbs.VboAttribute[] { new VboAbs.VboAttribute(3, 5126, false, 4), new VboAbs.VboAttribute(2, 5122, false, 2), new VboAbs.VboAttribute(3, 5126, false, 4), new VboAbs.VboAttribute(4, 5121, true, 1) });
/*     */     
/*  30 */     this.shader = new Shader(sett.getNativeWidth(), sett.getNativeHeight(), "LightAmbient", null, "LightAmbient");
/*  31 */     this.shader.setUniform1i("Tdiffuse", 2);
/*  32 */     this.shader.setUniform1i("Tnormal", 3);
/*  33 */     this.sBuff = this.buffer.asIntBuffer();
/*  34 */     this.sorter = new VboSorter(32 * this.MAX_ELEMENTS);
/*     */   }
/*     */ 
/*     */   
/*     */   void setNew() {
/*  39 */     if (this.specialLayer)
/*     */       return; 
/*  41 */     this.vTo[this.current] = this.count;
/*  42 */     this.current++;
/*  43 */     this.vFrom[this.current] = this.count;
/*     */   }
/*     */   
/*     */   void setNewButKeepLight() {
/*  47 */     if (this.specialLayer)
/*     */       return; 
/*  49 */     this.vTo[this.current] = this.count;
/*  50 */     this.current++;
/*  51 */     this.vFrom[this.current] = this.vFrom[this.current - 1];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void setNewFinal() {
/*  57 */     this.specialLayer = true;
/*  58 */     this.vTo[this.current] = this.count;
/*  59 */     this.current++;
/*  60 */     this.vFrom[this.current] = this.count;
/*     */   }
/*     */ 
/*     */   
/*     */   void flush() {
/*  65 */     this.sorter.fill(this.sBuff);
/*  66 */     this.buffer.position(this.sBuff.position() * 4);
/*     */     
/*  68 */     bind();
/*  69 */     upload();
/*  70 */     GlHelper.setBlendAdditative();
/*  71 */     GlHelper.enableDepthTest(true);
/*  72 */     GlHelper.setDepthTestLess();
/*  73 */     this.shader.bind();
/*  74 */     this.vTo[this.current] = this.count;
/*  75 */     for (int i = 0; i <= this.current; i++) {
/*     */       
/*  77 */       int fromI = this.vFrom[i];
/*  78 */       int toI = this.vTo[i];
/*  79 */       if (this.specialLayer && i == this.current) {
/*  80 */         GlHelper.Stencil.setLEQUALKeepOnFail(i);
/*     */       } else {
/*  82 */         GlHelper.Stencil.setEQUALKeepOnFail(i);
/*     */       } 
/*  84 */       if (toI > fromI) {
/*  85 */         flush(fromI, toI);
/*     */       }
/*     */     } 
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
/* 103 */     GL20.glUseProgram(0);
/* 104 */     GlHelper.enableDepthTest(false);
/* 105 */     GlHelper.setBlendNormal();
/* 106 */     clear();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void render(LIGHT_AMBIENT l, int x1, int x2, int y1, int y2, byte depth) {
/* 112 */     this.sorter.add(this.current, Float.floatToRawIntBits(l.x()));
/* 113 */     this.sorter.add(this.current, Float.floatToRawIntBits(l.y()));
/* 114 */     this.sorter.add(this.current, Float.floatToRawIntBits(l.z()));
/* 115 */     this.sorter.add(this.current, y2 << 16 | x1 & 0xFFFF);
/* 116 */     this.sorter.add(this.current, Float.floatToRawIntBits((float)l.r()));
/* 117 */     this.sorter.add(this.current, Float.floatToRawIntBits((float)l.g()));
/* 118 */     this.sorter.add(this.current, Float.floatToRawIntBits((float)l.b()));
/* 119 */     this.sorter.add(this.current, depth & 0xFF | 0xEFEFEF00);
/*     */     
/* 121 */     this.sorter.add(this.current, Float.floatToRawIntBits(l.x()));
/* 122 */     this.sorter.add(this.current, Float.floatToRawIntBits(l.y()));
/* 123 */     this.sorter.add(this.current, Float.floatToRawIntBits(l.z()));
/* 124 */     this.sorter.add(this.current, y2 << 16 | x2 & 0xFFFF);
/* 125 */     this.sorter.add(this.current, Float.floatToRawIntBits((float)l.r()));
/* 126 */     this.sorter.add(this.current, Float.floatToRawIntBits((float)l.g()));
/* 127 */     this.sorter.add(this.current, Float.floatToRawIntBits((float)l.b()));
/* 128 */     this.sorter.add(this.current, depth & 0xFF | 0xEFEFEF00);
/*     */     
/* 130 */     this.sorter.add(this.current, Float.floatToRawIntBits(l.x()));
/* 131 */     this.sorter.add(this.current, Float.floatToRawIntBits(l.y()));
/* 132 */     this.sorter.add(this.current, Float.floatToRawIntBits(l.z()));
/* 133 */     this.sorter.add(this.current, y1 << 16 | x1 & 0xFFFF);
/* 134 */     this.sorter.add(this.current, Float.floatToRawIntBits((float)l.r()));
/* 135 */     this.sorter.add(this.current, Float.floatToRawIntBits((float)l.g()));
/* 136 */     this.sorter.add(this.current, Float.floatToRawIntBits((float)l.b()));
/* 137 */     this.sorter.add(this.current, depth & 0xFF | 0xEFEFEF00);
/*     */     
/* 139 */     this.sorter.add(this.current, Float.floatToRawIntBits(l.x()));
/* 140 */     this.sorter.add(this.current, Float.floatToRawIntBits(l.y()));
/* 141 */     this.sorter.add(this.current, Float.floatToRawIntBits(l.z()));
/* 142 */     this.sorter.add(this.current, y1 << 16 | x2 & 0xFFFF);
/* 143 */     this.sorter.add(this.current, Float.floatToRawIntBits((float)l.r()));
/* 144 */     this.sorter.add(this.current, Float.floatToRawIntBits((float)l.g()));
/* 145 */     this.sorter.add(this.current, Float.floatToRawIntBits((float)l.b()));
/* 146 */     this.sorter.add(this.current, depth & 0xFF | 0xEFEFEF00);
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
/* 179 */     this.count++;
/*     */   }
/*     */ 
/*     */   
/*     */   public void dis() {
/* 184 */     this.shader.dis();
/* 185 */     super.dis();
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 190 */     this.current = 0;
/* 191 */     this.specialLayer = false;
/* 192 */     this.sorter.clear();
/* 193 */     super.clear();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2d\VboLightAmbient.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */