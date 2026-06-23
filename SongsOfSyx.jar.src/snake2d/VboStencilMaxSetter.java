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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class VboStencilMaxSetter
/*    */   extends VboAbsExt
/*    */ {
/* 20 */   private final int[] fromStencil = Alloc.ii(255);
/*    */ 
/*    */ 
/*    */   
/*    */   private final Shader shader;
/*    */ 
/*    */ 
/*    */   
/*    */   public VboStencilMaxSetter(SETTINGS sett) {
/* 29 */     super(0, 65536, new VboAbs.VboAttribute[] { new VboAbs.VboAttribute(2, 5122, false, 2), new VboAbs.VboAttribute(2, 5122, false, 2), new VboAbs.VboAttribute(2, 5123, 2), new VboAbs.VboAttribute(2, 5123, 2), new VboAbs.VboAttribute(4, 5121, true, 1) });
/*    */     
/* 31 */     this.shader = new Shader(sett.getNativeWidth(), sett.getNativeHeight(), "Shadow", "Shadow", "Shadow");
/* 32 */     this.shader.setUniform1i("sampler1", 0);
/*    */   }
/*    */   
/*    */   int setNewFinalOverride(int fromStencil) {
/* 36 */     this.vTo[this.current] = this.count;
/* 37 */     this.current++;
/* 38 */     this.vFrom[this.current] = this.count;
/* 39 */     this.fromStencil[this.current] = fromStencil;
/* 40 */     return this.current;
/*    */   }
/*    */ 
/*    */   
/*    */   void flush() {
/* 45 */     if (this.count != 0) {
/*    */ 
/*    */       
/* 48 */       bindAndUpload();
/* 49 */       GlHelper.enableDepthTest(false);
/* 50 */       GlHelper.setDepthTestAlways();
/* 51 */       GL11.glColorMask(false, false, false, false);
/* 52 */       this.shader.bind();
/* 53 */       int i = 0;
/* 54 */       this.vTo[this.current] = this.count;
/* 55 */       while (i <= this.current) {
/* 56 */         GL11.glStencilFunc(515, this.fromStencil[i], -1);
/* 57 */         GL11.glStencilOp(7680, 7680, 5386);
/*    */         
/* 59 */         flush(this.vFrom[i], this.vTo[i]);
/* 60 */         i++;
/*    */       } 
/* 62 */       GL20.glUseProgram(0);
/* 63 */       GL11.glColorMask(true, true, true, true);
/*    */     } 
/* 65 */     clear();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void render(TextureCoords t, int x1, int y1, int x2, int y2, int stencil) {
/* 72 */     if (this.count >= this.MAX_ELEMENTS) {
/*    */       return;
/*    */     }
/*    */ 
/*    */ 
/*    */     
/* 78 */     this.buffer.putShort((short)x1).putShort((short)y1);
/* 79 */     this.buffer.putShort((short)x2).putShort((short)y2);
/* 80 */     this.buffer.putShort(t.x1).putShort(t.y1);
/* 81 */     this.buffer.putShort(t.x2).putShort(t.y2);
/* 82 */     this.buffer.put(127);
/* 83 */     this.buffer.put(127);
/* 84 */     this.buffer.put(127);
/* 85 */     this.buffer.put(127);
/* 86 */     this.count++;
/*    */   }
/*    */ 
/*    */   
/*    */   public void dis() {
/* 91 */     this.shader.dis();
/* 92 */     super.dis();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2d\VboStencilMaxSetter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */