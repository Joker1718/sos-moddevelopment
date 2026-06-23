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
/*    */ import snake2d.util.map.MAP_INTE;
/*    */ 
/*    */ public class Bitsmap2D
/*    */   implements MAP_INTE, BODY_HOLDER, SAVABLE
/*    */ {
/*    */   private final Bitsmap1D map;
/*    */   private final int width;
/*    */   private final Rec body;
/*    */   
/*    */   public Bitsmap2D(int outof, int bits, int width, int height) {
/* 21 */     this.body = new Rec(width, height);
/* 22 */     this.map = new Bitsmap1D(outof, bits, width * height);
/* 23 */     this.width = width;
/*    */   }
/*    */   
/*    */   public Bitsmap2D(int outof, int bits, DIMENSION body) {
/* 27 */     this.body = new Rec(body.width(), body.height());
/* 28 */     this.width = body.width();
/* 29 */     this.map = new Bitsmap1D(outof, bits, body.width() * body.height());
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int get(int tile) {
/* 35 */     return this.map.get(tile);
/*    */   }
/*    */ 
/*    */   
/*    */   public MAP_INTE set(int tile, int value) {
/* 40 */     this.map.set(tile, value);
/* 41 */     return this;
/*    */   }
/*    */ 
/*    */   
/*    */   public MAP_INTE set(int tx, int ty, int value) {
/* 46 */     if (this.body.holdsPoint(tx, ty))
/* 47 */       set(tx + ty * this.width, value); 
/* 48 */     return this;
/*    */   }
/*    */ 
/*    */   
/*    */   public int get(int tx, int ty) {
/* 53 */     if (!this.body.holdsPoint(tx, ty))
/* 54 */       return this.map.outof; 
/* 55 */     return get(tx + ty * this.width);
/*    */   }
/*    */ 
/*    */   
/*    */   public int max() {
/* 60 */     return this.map.maxValue();
/*    */   }
/*    */ 
/*    */   
/*    */   public void save(FilePutter file) {
/* 65 */     this.map.save(file);
/*    */   }
/*    */ 
/*    */   
/*    */   public void load(FileGetter file) throws IOException {
/* 70 */     this.map.load(file);
/*    */   }
/*    */ 
/*    */   
/*    */   public void clear() {
/* 75 */     this.map.clear();
/*    */   }
/*    */ 
/*    */   
/*    */   public RECTANGLE body() {
/* 80 */     return (RECTANGLE)this.body;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\sets\Bitsmap2D.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */