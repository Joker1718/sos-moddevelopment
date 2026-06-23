/*    */ package cutscene;
/*    */ 
/*    */ import init.sprite.UI.UI;
/*    */ import java.io.IOException;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.color.OPACITY;
/*    */ import snake2d.util.color.OpacityImp;
/*    */ import snake2d.util.datatypes.RECTANGLE;
/*    */ import snake2d.util.file.Json;
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ 
/*    */ class Images
/*    */   extends RENDEROBJ.RenderImp {
/*    */   private final SPRITE[] ims;
/*    */   private double[] delays;
/* 18 */   private double time = 0.0D;
/*    */ 
/*    */   
/*    */   Images(Json json) throws IOException {
/* 22 */     Json[] js = json.jsons("IMAGES");
/*    */     
/* 24 */     this.ims = new SPRITE[js.length];
/* 25 */     this.delays = new double[js.length];
/*    */     
/* 27 */     for (int i = 0; i < this.ims.length; i++) {
/* 28 */       this.ims[i] = UI.image().get(js[i]);
/* 29 */       this.delays[i] = js[i].d("DELAY");
/*    */     } 
/*    */     
/* 32 */     int w = 0;
/* 33 */     int h = 0; byte b; int j;
/*    */     SPRITE[] arrayOfSPRITE;
/* 35 */     for (j = (arrayOfSPRITE = this.ims).length, b = 0; b < j; ) { SPRITE s = arrayOfSPRITE[b];
/* 36 */       w = Math.max(s.width(), w);
/* 37 */       h = Math.max(s.height(), h);
/*    */       b++; }
/*    */     
/* 40 */     this.body.setDim(w, h);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void render(SPRITE_RENDERER r, float ds) {
/* 47 */     SPRITE im = image();
/* 48 */     if (im != null)
/* 49 */       im.renderC(r, (RECTANGLE)this.body); 
/* 50 */     double op = 1.0D - op();
/*    */ 
/*    */ 
/*    */     
/* 54 */     OpacityImp.TMP.set(op);
/* 55 */     OpacityImp.TMP.bind();
/* 56 */     COLOR.BLACK.render(r, (RECTANGLE)this.body);
/* 57 */     OPACITY.unbind();
/* 58 */     this.time += ds;
/*    */   }
/*    */ 
/*    */   
/*    */   private SPRITE image() {
/* 63 */     for (int i = 0; i < this.delays.length; i++) {
/*    */       
/* 65 */       if (this.delays[i] > this.time) {
/* 66 */         if (i == 0)
/* 67 */           return null; 
/* 68 */         return this.ims[i - 1];
/*    */       } 
/*    */     } 
/* 71 */     return this.ims[this.ims.length - 1];
/*    */   }
/*    */   
/*    */   private double op() {
/* 75 */     if (this.time < 1.0D) {
/* 76 */       return this.time;
/*    */     }
/* 78 */     for (int i = 0; i < this.delays.length; i++) {
/*    */       
/* 80 */       double d = this.delays[i] - this.time;
/*    */       
/* 82 */       if (d > 0.0D && d < 1.0D)
/* 83 */         return d; 
/* 84 */       if (d > -1.0D && d < 0.0D) {
/* 85 */         return -d;
/*    */       }
/*    */     } 
/* 88 */     return 1.0D;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\cutscene\Images.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */