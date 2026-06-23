/*    */ package snake2d;
/*    */ 
/*    */ import org.lwjgl.opengl.GL11;
/*    */ import org.lwjgl.opengl.GL20;
/*    */ import snake2d.util.file.Alloc;
/*    */ import snake2d.util.sprite.TextureCoords;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class VboShadowPoints
/*    */   extends VboAbsExt
/*    */ {
/* 15 */   private final int[] fromStencil = Alloc.ii(255);
/*    */ 
/*    */ 
/*    */   
/*    */   private final Shader shader;
/*    */ 
/*    */ 
/*    */   
/*    */   public VboShadowPoints(SETTINGS sett) {
/* 24 */     super(0, 65536, new VboAbs.VboAttribute[] { new VboAbs.VboAttribute(2, 5122, false, 2), new VboAbs.VboAttribute(2, 5122, false, 2), new VboAbs.VboAttribute(2, 5123, 2), new VboAbs.VboAttribute(2, 5123, 2), new VboAbs.VboAttribute(4, 5121, true, 1) });
/*    */     
/* 26 */     this.shader = new Shader(sett.getNativeWidth(), sett.getNativeHeight(), "Shadow", "Shadow", "Shadow");
/* 27 */     this.shader.setUniform1i("sampler1", 0);
/*    */   }
/*    */   
/*    */   int setNewFinalOverride(int fromStencil) {
/* 31 */     this.vTo[this.current] = this.count;
/* 32 */     this.current++;
/* 33 */     this.vFrom[this.current] = this.count;
/* 34 */     this.fromStencil[this.current] = fromStencil;
/* 35 */     return this.current;
/*    */   }
/*    */ 
/*    */   
/*    */   void flush() {
/* 40 */     if (this.count != 0) {
/*    */ 
/*    */       
/* 43 */       bindAndUpload();
/* 44 */       GlHelper.enableDepthTest(true);
/* 45 */       GlHelper.setDepthTestAlways();
/* 46 */       GL11.glColorMask(false, false, false, false);
/* 47 */       this.shader.bind();
/* 48 */       int i = 0;
/* 49 */       this.vTo[this.current] = this.count;
/* 50 */       while (i <= this.current) {
/* 51 */         GlHelper.Stencil.setLESSKeepOnPass(this.fromStencil[i]);
/* 52 */         flush(this.vFrom[i], this.vTo[i]);
/* 53 */         i++;
/*    */       } 
/* 55 */       GL20.glUseProgram(0);
/* 56 */       GL11.glColorMask(true, true, true, true);
/* 57 */       GlHelper.enableDepthTest(false);
/*    */     } 
/* 59 */     clear();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void render(TextureCoords t, int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4, byte d, byte depth) {
/* 67 */     if (this.count >= this.MAX_ELEMENTS) {
/*    */       return;
/*    */     }
/*    */ 
/*    */ 
/*    */     
/* 73 */     this.buffer.putShort((short)x1).putShort((short)y1);
/* 74 */     this.buffer.putShort((short)x3).putShort((short)y3);
/* 75 */     this.buffer.putShort(t.x1).putShort(t.y1);
/* 76 */     this.buffer.putShort(t.x2).putShort(t.y2);
/* 77 */     this.buffer.put(d);
/* 78 */     this.buffer.put(depth);
/* 79 */     this.buffer.put(127);
/* 80 */     this.buffer.put(127);
/* 81 */     this.count++;
/*    */   }
/*    */ 
/*    */   
/*    */   public void dis() {
/* 86 */     this.shader.dis();
/* 87 */     super.dis();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2d\VboShadowPoints.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */