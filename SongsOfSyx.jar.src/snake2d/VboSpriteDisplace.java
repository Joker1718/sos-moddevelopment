/*    */ package snake2d;
/*    */ 
/*    */ import org.lwjgl.opengl.GL20;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.color.OPACITY;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class VboSpriteDisplace
/*    */   extends VboAbsExt
/*    */ {
/*    */   private final Shader shader;
/*    */   
/*    */   static VboSpriteDisplace getDeffered(SETTINGS sett) {
/* 19 */     Shader shader = new Shader(sett.getNativeWidth(), sett.getNativeHeight(), "Displace", "Displace", "Displace");
/* 20 */     shader.setUniform1i("sampler1", 0);
/* 21 */     shader.setUniform1i("sampler2", 1);
/* 22 */     return new VboSpriteDisplace(shader);
/*    */   }
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
/*    */   public VboSpriteDisplace(Shader shader) {
/* 35 */     super(0, 32768, new VboAbs.VboAttribute[] { new VboAbs.VboAttribute(2, 5122, false, 2), new VboAbs.VboAttribute(2, 5122, false, 2), new VboAbs.VboAttribute(2, 5126, false, 4), new VboAbs.VboAttribute(2, 5126, false, 4), new VboAbs.VboAttribute(2, 5123, 2), new VboAbs.VboAttribute(4, 5121, true, 1), new VboAbs.VboAttribute(1, 5126, false, 4) });
/*    */     
/* 37 */     this.shader = shader;
/*    */   }
/*    */ 
/*    */   
/*    */   int setNew() {
/* 42 */     this.vTo[this.current] = this.count;
/* 43 */     this.current++;
/* 44 */     this.vFrom[this.current] = this.count;
/* 45 */     return this.current;
/*    */   }
/*    */   
/*    */   void flush() {
/* 49 */     bindAndUpload();
/* 50 */     this.shader.bind();
/* 51 */     int i = 0;
/* 52 */     this.vTo[this.current] = this.count;
/* 53 */     while (i <= this.current) {
/* 54 */       if (this.vFrom[i] != this.vTo[i]) {
/* 55 */         GlHelper.Stencil.setEQUALKeepOnFail(i);
/* 56 */         flush(this.vFrom[i], this.vTo[i]);
/*    */       } 
/* 58 */       i++;
/*    */     } 
/* 60 */     clear();
/* 61 */     GL20.glUseProgram(0);
/*    */   }
/*    */ 
/*    */   
/*    */   void render(float tx1, float ty1, float dx1, float dy1, int w, int h, double scale, int x1, int x2, int y1, int y2, COLOR color, OPACITY opacity) {
/* 66 */     if (this.count >= this.MAX_ELEMENTS) {
/*    */       return;
/*    */     }
/*    */     
/* 70 */     this.buffer.putShort((short)x1).putShort((short)y1);
/* 71 */     this.buffer.putShort((short)x2).putShort((short)y2);
/* 72 */     this.buffer.putFloat(tx1).putFloat(ty1);
/* 73 */     this.buffer.putFloat(dx1).putFloat(dy1);
/* 74 */     this.buffer.putShort((short)w).putShort((short)h);
/* 75 */     this.buffer.put(color.red()).put(color.green()).put(color.blue()).put(opacity.get());
/* 76 */     this.buffer.putFloat((float)scale);
/*    */     
/* 78 */     this.count++;
/*    */   }
/*    */ 
/*    */   
/*    */   public void dis() {
/* 83 */     this.shader.dis();
/* 84 */     super.dis();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2d\VboSpriteDisplace.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */