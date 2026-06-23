/*    */ package util.data;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
/*    */ import snake2d.util.file.SAVABLE;
/*    */ import util.info.INFO;
/*    */ 
/*    */ public interface BOOLEAN
/*    */ {
/*    */   boolean is();
/*    */   
/*    */   public static interface BOOLEAN_MUTABLE
/*    */     extends BOOLEAN
/*    */   {
/*    */     BOOLEAN_MUTABLE set(boolean param1Boolean);
/*    */     
/*    */     default BOOLEAN_MUTABLE toggle() {
/* 19 */       return set(!is());
/*    */     }
/*    */     
/*    */     default BOOLEAN_MUTABLE setOn() {
/* 23 */       return set(true);
/*    */     }
/*    */     
/*    */     default BOOLEAN_MUTABLE setOff() {
/* 27 */       return set(false);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public static class BOOLEANImp
/*    */     implements BOOLEAN_MUTABLE, SAVABLE
/*    */   {
/*    */     public boolean b;
/*    */     public INFO info;
/*    */     
/*    */     public BOOLEANImp() {}
/*    */     
/*    */     public BOOLEANImp(CharSequence name, CharSequence desc) {
/* 41 */       this.info = new INFO(name, desc);
/*    */     }
/*    */     
/*    */     public BOOLEANImp(boolean b) {
/* 45 */       this.b = b;
/*    */     }
/*    */ 
/*    */     
/*    */     public boolean is() {
/* 50 */       return this.b;
/*    */     }
/*    */ 
/*    */     
/*    */     public BOOLEAN.BOOLEAN_MUTABLE set(boolean b) {
/* 55 */       this.b = b;
/* 56 */       return this;
/*    */     }
/*    */ 
/*    */     
/*    */     public void save(FilePutter file) {
/* 61 */       file.bool(this.b);
/*    */     }
/*    */ 
/*    */     
/*    */     public void load(FileGetter file) throws IOException {
/* 66 */       this.b = file.bool();
/*    */     }
/*    */ 
/*    */     
/*    */     public void clear() {
/* 71 */       this.b = false;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\data\BOOLEAN.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */