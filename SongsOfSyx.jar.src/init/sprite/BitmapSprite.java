/*    */ package init.sprite;
/*    */ 
/*    */ import java.nio.file.Path;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.color.OPACITY;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import snake2d.util.file.SnakeImage;
/*    */ import snake2d.util.sets.Bitmap2D;
/*    */ 
/*    */ public class BitmapSprite
/*    */   extends Bitmap2D
/*    */ {
/*    */   public static final int WIDTH = 12;
/*    */   public static final int HEIGHT = 12;
/*    */   public static final int AREA = 144;
/*    */   
/*    */   public BitmapSprite() {
/* 19 */     super(12, 12, false);
/*    */   }
/*    */   
/*    */   public void paint(Bitmap2D data) {
/* 23 */     for (int y = 0; y < 12; y++) {
/* 24 */       for (int x = 0; x < 12; x++) {
/* 25 */         set(x, y, data.is(x, y));
/*    */       }
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void scaled(SPRITE_RENDERER r, int sx, int sy, int scale, COLOR foreground, COLOR borderN, COLOR borderS) {
/* 32 */     OPACITY.O99.bind();
/* 33 */     int hs = scale / 2;
/*    */     
/* 35 */     for (int y = -1; y <= 12; y++) {
/* 36 */       for (int x = -1; x <= 12; x++) {
/* 37 */         if (is(x, y)) {
/* 38 */           foreground.render(r, sx + x * scale, sx + x * scale + scale, sy + y * scale, 
/* 39 */               sy + y * scale + scale);
/*    */         } else {
/* 41 */           for (DIR d : DIR.ORTHO) {
/* 42 */             if (is(x, y, d)) {
/* 43 */               int dx = hs * (1 + d.x()) / 2;
/* 44 */               int dy = hs * (1 + d.y()) / 2;
/* 45 */               COLOR c = (d.x() < 0 || d.y() < 0) ? borderN : borderS;
/* 46 */               c.render(r, sx + x * scale + dx, sx + x * scale + dx + hs * (1 + Math.abs(d.y())), 
/* 47 */                   sy + y * scale + dy, sy + y * scale + dy + hs * (1 + Math.abs(d.x())));
/*    */             } 
/*    */           } 
/*    */           
/* 51 */           for (DIR d : DIR.NORTHO) {
/* 52 */             if (is(x, y, d)) {
/* 53 */               int dx = hs * (1 + d.x()) / 2;
/* 54 */               int dy = hs * (1 + d.y()) / 2;
/* 55 */               COLOR c = (d.x() < 0 || d.y() < 0) ? borderN : borderS;
/* 56 */               c.render(r, sx + x * scale + dx, sx + x * scale + dx + hs, sy + y * scale + dy, 
/* 57 */                   sy + y * scale + dy + hs);
/*    */             } 
/*    */           } 
/*    */         } 
/*    */       } 
/*    */     } 
/*    */     
/* 64 */     OPACITY.unbind();
/*    */   }
/*    */   
/*    */   public static Bitmap2D[] read(Path path) {
/* 68 */     SnakeImage im = new SnakeImage(path);
/* 69 */     int w = (im.width - 2) / 14;
/* 70 */     int h = (im.height - 2) / 14;
/*    */     
/* 72 */     Bitmap2D[] datas = new Bitmap2D[w * h];
/* 73 */     for (int i = 0; i < datas.length; i++) {
/* 74 */       datas[i] = new Bitmap2D(12, 12, false);
/*    */     }
/* 76 */     int di = 0;
/* 77 */     for (int fy = 0; fy < h; fy++) {
/* 78 */       for (int fx = 0; fx < w; fx++) {
/* 79 */         int sx = 2 + fx * 14;
/* 80 */         int sy = 2 + fy * 14;
/* 81 */         for (int y = 0; y < 12; y++) {
/* 82 */           for (int x = 0; x < 12; x++) {
/* 83 */             int px = sx + x;
/* 84 */             int py = sy + y;
/* 85 */             if ((im.rgb.get(px, py) >> 8 & 0xFFFFFF) == 0) {
/* 86 */               datas[di].set(x, y, true);
/*    */             }
/*    */           } 
/*    */         } 
/*    */         
/* 91 */         di++;
/*    */       } 
/*    */     } 
/* 94 */     im.dispose();
/*    */     
/* 96 */     return datas;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\sprite\BitmapSprite.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */