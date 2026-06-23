/*    */ package util.data;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
/*    */ import snake2d.util.file.SAVABLE;
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
/*    */ public class DoubleImp
/*    */   implements DOUBLE.DOUBLE_MUTABLE, SAVABLE
/*    */ {
/*    */   private double d;
/*    */   public INFO info;
/*    */   
/*    */   public double getD() {
/* 57 */     return this.d;
/*    */   }
/*    */ 
/*    */   
/*    */   public void save(FilePutter file) {
/* 62 */     file.d(this.d);
/*    */   }
/*    */ 
/*    */   
/*    */   public void load(FileGetter file) throws IOException {
/* 67 */     this.d = file.d();
/*    */   }
/*    */ 
/*    */   
/*    */   public void clear() {
/* 72 */     this.d = 0.0D;
/*    */   }
/*    */ 
/*    */   
/*    */   public DOUBLE.DOUBLE_MUTABLE setD(double d) {
/* 77 */     this.d = d;
/* 78 */     return this;
/*    */   }
/*    */ 
/*    */   
/*    */   public INFO info() {
/* 83 */     return this.info;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\data\DOUBLE$DoubleImp.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */