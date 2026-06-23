/*    */ package util.spritecomposer;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import snake2d.util.file.FileGetter;
/*    */ 
/*    */ public class SpriteData
/*    */ {
/*    */   public final int x1;
/*    */   public final int y1;
/*    */   
/*    */   private SpriteData(int x1, int y1, int width, int height) {
/* 12 */     this.x1 = x1; this.y1 = y1; this.width = width; this.height = height;
/*    */   }
/*    */   public final int width; public final int height;
/*    */   static SpriteData save(int x1, int y1, int width, int height, int ts) {
/* 16 */     Resources.p.mark("sprite");
/* 17 */     Resources.p.i(x1);
/* 18 */     Resources.p.i(y1);
/* 19 */     Resources.p.i(width);
/* 20 */     Resources.p.i(height);
/* 21 */     Resources.p.i(ts);
/* 22 */     return new SpriteData(x1, y1, width, height);
/*    */   }
/*    */   
/*    */   static SpriteData read(FileGetter g) throws IOException {
/* 26 */     g.check("sprite");
/* 27 */     int x1 = g.i();
/* 28 */     int y1 = g.i();
/* 29 */     int width = g.i();
/* 30 */     int height = g.i();
/* 31 */     Optimizer.Tile t = Optimizer.get(g.i());
/* 32 */     return new SpriteData(x1, y1 + t.startY, width, height);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\spritecomposer\SpriteData.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */