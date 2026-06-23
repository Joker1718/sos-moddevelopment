/*    */ package util.spritecomposer;
/*    */ 
/*    */ import java.nio.file.Path;
/*    */ import snake2d.Errors;
/*    */ import snake2d.util.file.SnakeImage;
/*    */ import snake2d.util.sprite.text.Font;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FontReader
/*    */ {
/* 12 */   private final int GREEN = 16711935;
/*    */   
/*    */   private final int glyphs;
/*    */ 
/*    */   
/*    */   public FontReader(String charset) {
/* 18 */     this.glyphs = charset.length();
/* 19 */     Font.setCharset(charset);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Font get(int x1, int y1, SnakeImage source, Path path, int trail) {
/* 25 */     int x = x1 + 1;
/* 26 */     int y = y1;
/*    */     
/* 28 */     if (source.rgb.get(x, y) != 16711935) {
/* 29 */       throw new Errors.DataError("error with font. Expecting full green at pixel: " + x + "," + y, path);
/*    */     }
/* 31 */     int height = 0;
/*    */     
/*    */     while (true) {
/* 34 */       if (y >= source.height - 1) {
/* 35 */         throw new Errors.DataError("unable to find height of font. Make sure surrounding edges are full green!", path);
/*    */       }
/* 37 */       y++;
/* 38 */       int col = source.rgb.get(x, y);
/* 39 */       if (col == 16711935) {
/* 40 */         height = y - y1 - 1;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */         
/* 47 */         Font.FontGlyph[] ggs = new Font.FontGlyph[this.glyphs]; int i;
/* 48 */         for (i = 0; i < ggs.length; i++) {
/* 49 */           ggs[i] = new Font.FontGlyph();
/*    */         }
/* 51 */         for (i = 0; i < this.glyphs; i++) {
/* 52 */           (ggs[i]).ty1 = (short)(y1 + 1);
/* 53 */           (ggs[i]).tx1 = (short)x;
/* 54 */           (ggs[i]).width = getWidth(x, y1 + 1, source, String.valueOf(path), i);
/* 55 */           x += (ggs[i]).width + 1;
/*    */         } 
/*    */         
/* 58 */         return new Font(ggs, height, 1.0D, trail);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private byte getWidth(int x1, int y1, SnakeImage source, String path, int glyph) {
/* 66 */     int w = 0;
/*    */     
/* 68 */     while (source.rgb.get(x1, y1) != 16711935) {
/* 69 */       if (w > 100)
/* 70 */         throw new Errors.DataError("unable to find width of gyph " + glyph + ". At pixel: " + x1 + "," + y1, path); 
/* 71 */       if (x1 >= source.width)
/* 72 */         throw new Errors.DataError("unable2 to find width of gyph " + glyph + ". At pixel: " + x1 + "," + y1, path); 
/* 73 */       w++;
/* 74 */       x1++;
/*    */     } 
/*    */     
/* 77 */     return (byte)w;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\spritecomposer\FontReader.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */