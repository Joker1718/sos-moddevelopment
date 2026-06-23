/*    */ package snake2d.util.sets;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import snake2d.util.datatypes.BODY_HOLDER;
/*    */ import snake2d.util.datatypes.DIMENSION;
/*    */ import snake2d.util.datatypes.RECTANGLE;
/*    */ import snake2d.util.datatypes.Rec;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
/*    */ import snake2d.util.file.SAVABLE;
/*    */ import snake2d.util.map.MAP_BOOLEANE;
/*    */ 
/*    */ public class Bitmap2D
/*    */   implements MAP_BOOLEANE, BODY_HOLDER, SAVABLE {
/*    */   private final Bitmap1D data;
/*    */   private final boolean outof;
/*    */   private final Rec body;
/*    */   private final int width;
/*    */   
/*    */   public Bitmap2D(int width, int height, boolean outof) {
/* 21 */     this.body = new Rec(width, height);
/* 22 */     this.data = new Bitmap1D(width * height, outof);
/* 23 */     this.width = width;
/* 24 */     this.outof = outof;
/*    */   }
/*    */   
/*    */   public Bitmap2D(DIMENSION body, boolean outof) {
/* 28 */     this.body = new Rec(body.width(), body.height());
/* 29 */     this.width = body.width();
/* 30 */     this.data = new Bitmap1D(body.width() * body.height(), outof);
/* 31 */     this.outof = outof;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean is(int tile) {
/* 36 */     return this.data.get(tile);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean is(int tx, int ty) {
/* 41 */     if (this.body.holdsPoint(tx, ty))
/* 42 */       return this.data.get(tx + ty * this.width); 
/* 43 */     return this.outof;
/*    */   }
/*    */ 
/*    */   
/*    */   public MAP_BOOLEANE set(int tile, boolean value) {
/* 48 */     this.data.set(tile, value);
/* 49 */     return this;
/*    */   }
/*    */ 
/*    */   
/*    */   public MAP_BOOLEANE set(int tx, int ty, boolean value) {
/* 54 */     if (this.body.holdsPoint(tx, ty))
/* 55 */       set(tx + ty * this.width, value); 
/* 56 */     return this;
/*    */   }
/*    */ 
/*    */   
/*    */   public RECTANGLE body() {
/* 61 */     return (RECTANGLE)this.body;
/*    */   }
/*    */ 
/*    */   
/*    */   public void save(FilePutter file) {
/* 66 */     this.data.save(file);
/*    */   }
/*    */ 
/*    */   
/*    */   public void load(FileGetter file) throws IOException {
/* 71 */     this.data.load(file);
/*    */   }
/*    */ 
/*    */   
/*    */   public void clear() {
/* 76 */     this.data.clear();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\sets\Bitmap2D.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */