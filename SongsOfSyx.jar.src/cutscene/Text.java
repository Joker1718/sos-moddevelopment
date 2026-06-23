/*    */ package cutscene;
/*    */ 
/*    */ import init.sprite.UI.UI;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.light.AmbientLight;
/*    */ import snake2d.util.misc.CLAMP;
/*    */ import snake2d.util.sprite.text.Font;
/*    */ 
/*    */ final class Text
/*    */ {
/*    */   private final CharSequence[] rows;
/* 12 */   private final Font f = (UI.FONT()).M;
/*    */   private final int bheight;
/* 14 */   private final AmbientLight light = new AmbientLight();
/*    */   
/*    */   Text(int height, CharSequence tt) {
/* 17 */     this.rows = this.f.getRows(tt, 500);
/* 18 */     this.bheight = height;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void render(SPRITE_RENDERER r, int x1, int y11, double d, double blacken) {
/* 27 */     double height = (this.f.height() + 12);
/*    */     
/* 29 */     int virtualRows = (int)Math.ceil(this.bheight / height);
/* 30 */     int realRows = CLAMP.i(this.rows.length - 8, 0, this.rows.length);
/*    */     
/* 32 */     double y1 = (y11 + this.bheight) - height * 2.0D - d * height * (virtualRows + realRows); byte b; int i;
/*    */     CharSequence[] arrayOfCharSequence;
/* 34 */     for (i = (arrayOfCharSequence = this.rows).length, b = 0; b < i; ) { CharSequence row = arrayOfCharSequence[b];
/*    */       
/* 36 */       if (y1 > y11 && y1 + height <= (y11 + this.bheight)) {
/*    */ 
/*    */ 
/*    */         
/* 40 */         this.f.render(r, row, x1, (int)y1 + 3);
/*    */         
/* 42 */         double op = Math.min(Math.abs(y1 - y11), Math.abs(y1 + height - (y11 + this.bheight))) / height * 2.0D;
/* 43 */         op *= blacken;
/* 44 */         if (op < 1.0D) {
/*    */           
/* 46 */           this.light.Set(AmbientLight.Strongmoonlight, op);
/* 47 */           this.light.register(x1, x1 + 500, (int)y1, (int)(y1 + height));
/*    */ 
/*    */         
/*    */         }
/*    */         else {
/*    */ 
/*    */           
/* 54 */           AmbientLight.Strongmoonlight.register(x1, x1 + 500, (int)y1, (int)(y1 + height));
/*    */         } 
/*    */       } 
/*    */       
/* 58 */       y1 += height;
/*    */       b++; }
/*    */   
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\cutscene\Text.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */