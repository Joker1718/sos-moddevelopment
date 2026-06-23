/*    */ package util.data;
/*    */ 
/*    */ import init.sprite.UI.UI;
/*    */ import java.io.IOException;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
/*    */ import snake2d.util.file.SAVABLE;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.info.INFO;
/*    */ 
/*    */ public interface DOUBLE
/*    */ {
/*    */   double getD();
/*    */   
/*    */   public static interface DOUBLE_MUTABLE
/*    */     extends DOUBLE
/*    */   {
/*    */     default DOUBLE_MUTABLE incD(double d) {
/* 19 */       setD(getD() + d);
/* 20 */       return this;
/*    */     }
/*    */     
/*    */     DOUBLE_MUTABLE setD(double param1Double); }
/*    */   
/*    */   default INFO info() {
/* 26 */     return null;
/*    */   }
/*    */   
/*    */   public static abstract class DOUBLEI
/*    */     implements DOUBLE {
/*    */     private final INFO info;
/*    */     public final SPRITE icon;
/*    */     
/*    */     public DOUBLEI(CharSequence name, CharSequence desc) {
/* 35 */       this.info = new INFO(name, desc);
/* 36 */       this.icon = (SPRITE)(UI.icons()).s.cancel;
/*    */     }
/*    */     
/*    */     public DOUBLEI(CharSequence name, CharSequence desc, SPRITE icon) {
/* 40 */       this.info = new INFO(name, desc);
/* 41 */       this.icon = icon;
/*    */     }
/*    */ 
/*    */     
/*    */     public INFO info() {
/* 46 */       return this.info;
/*    */     }
/*    */   }
/*    */   
/*    */   public static class DoubleImp
/*    */     implements DOUBLE_MUTABLE, SAVABLE
/*    */   {
/*    */     private double d;
/*    */     public INFO info;
/*    */     
/*    */     public double getD() {
/* 57 */       return this.d;
/*    */     }
/*    */ 
/*    */     
/*    */     public void save(FilePutter file) {
/* 62 */       file.d(this.d);
/*    */     }
/*    */ 
/*    */     
/*    */     public void load(FileGetter file) throws IOException {
/* 67 */       this.d = file.d();
/*    */     }
/*    */ 
/*    */     
/*    */     public void clear() {
/* 72 */       this.d = 0.0D;
/*    */     }
/*    */ 
/*    */     
/*    */     public DOUBLE.DOUBLE_MUTABLE setD(double d) {
/* 77 */       this.d = d;
/* 78 */       return this;
/*    */     }
/*    */ 
/*    */     
/*    */     public INFO info() {
/* 83 */       return this.info;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\data\DOUBLE.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */