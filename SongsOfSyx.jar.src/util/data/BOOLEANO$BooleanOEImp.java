/*    */ package util.data;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
/*    */ import snake2d.util.file.SAVABLE;
/*    */ import snake2d.util.sets.Bitmap1D;
/*    */ import snake2d.util.sets.INDEXED;
/*    */ import util.info.INFO;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BooleanOEImp<T extends INDEXED>
/*    */   implements BOOLEANO.BOOLEAN_OE<T>, SAVABLE
/*    */ {
/*    */   private final Bitmap1D data;
/*    */   public INFO info;
/*    */   private final boolean def;
/*    */   
/*    */   public BooleanOEImp(int size, boolean def) {
/* 44 */     this.data = new Bitmap1D(size, def);
/* 45 */     this.def = def;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean is(T t) {
/* 50 */     if (t == null) {
/* 51 */       for (int i = 0; i < this.data.size(); i++) {
/* 52 */         if (this.data.get(i))
/* 53 */           return true; 
/* 54 */       }  return false;
/*    */     } 
/* 56 */     return this.data.get(t.index());
/*    */   }
/*    */ 
/*    */   
/*    */   public BOOLEANO.BOOLEAN_OE<T> set(T t, boolean b) {
/* 61 */     if (t == null) {
/* 62 */       this.data.setAll(b);
/*    */     }
/* 64 */     this.data.set(t.index(), b);
/* 65 */     return this;
/*    */   }
/*    */ 
/*    */   
/*    */   public void save(FilePutter file) {
/* 70 */     this.data.save(file);
/*    */   }
/*    */ 
/*    */   
/*    */   public void load(FileGetter file) throws IOException {
/* 75 */     this.data.load(file);
/*    */   }
/*    */ 
/*    */   
/*    */   public void clear() {
/* 80 */     this.data.setAll(this.def);
/*    */   }
/*    */ 
/*    */   
/*    */   public INFO info() {
/* 85 */     return this.info;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\data\BOOLEANO$BooleanOEImp.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */