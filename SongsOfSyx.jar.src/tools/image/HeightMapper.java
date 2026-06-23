/*    */ package tools.image;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.awt.image.BufferedImage;
/*    */ import snake2d.PathTile;
/*    */ import snake2d.PathUtilOnline;
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import snake2d.util.datatypes.Rec;
/*    */ import snake2d.util.misc.CLAMP;
/*    */ import snake2d.util.sets.LIST;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class HeightMapper
/*    */ {
/* 18 */   int ii = 50;
/*    */ 
/*    */ 
/*    */   
/*    */   public static void main(String[] args) {}
/*    */ 
/*    */   
/*    */   private HeightMapper(int start, String source, LIST<DIR> dirs) {
/* 26 */     BufferedImage s = Util.getImage(source);
/* 27 */     int w = s.getWidth();
/* 28 */     int h = s.getHeight();
/* 29 */     Rec rec = new Rec(w, h);
/*    */     
/* 31 */     BufferedImage d = Util.getImage(w, h);
/*    */     
/* 33 */     PathUtilOnline.Flooder f = (new PathUtilOnline(Math.max(w, h))).getFlooder();
/* 34 */     f.init(this);
/*    */     
/* 36 */     for (COORDINATE c : rec) {
/* 37 */       int alpha = (new Color(s.getRGB(c.x(), c.y()), true)).getAlpha();
/* 38 */       if (alpha == 0) {
/* 39 */         f.pushSloppy(c, 0.0D);
/*    */       }
/*    */     } 
/* 42 */     while (f.hasMore()) {
/* 43 */       PathTile t = f.pollSmallest();
/* 44 */       int alpha = (new Color(s.getRGB(t.x(), t.y()), true)).getAlpha();
/* 45 */       if (alpha != 0) {
/* 46 */         int r = (int)(start + t.getValue() * 4.0F);
/* 47 */         r = CLAMP.i(r, 0, 255);
/* 48 */         d.setRGB(t.x(), t.y(), (new Color(r, r, r, 255)).getRGB());
/*    */       } 
/*    */       
/* 51 */       for (DIR dir : dirs) {
/* 52 */         if (rec.holdsPoint((COORDINATE)t, dir)) {
/* 53 */           f.pushSmaller((COORDINATE)t, dir, t.getValue() + dir.tileDistance());
/*    */         }
/*    */       } 
/*    */     } 
/* 57 */     Util.saveImage(d, "heightFix");
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\tools\image\HeightMapper.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */