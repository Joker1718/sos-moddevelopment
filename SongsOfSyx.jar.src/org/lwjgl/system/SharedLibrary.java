/*    */ package org.lwjgl.system;
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
/*    */ public interface SharedLibrary
/*    */   extends FunctionProvider, NativeResource, Pointer
/*    */ {
/*    */   String getName();
/*    */   
/*    */   String getPath();
/*    */   
/*    */   public static abstract class Default
/*    */     extends Pointer.Default
/*    */     implements SharedLibrary
/*    */   {
/*    */     private final String name;
/*    */     
/*    */     protected Default(String name, long handle) {
/* 27 */       super(handle);
/* 28 */       this.name = name;
/*    */     }
/*    */ 
/*    */     
/*    */     public String getName() {
/* 33 */       return this.name;
/*    */     }
/*    */   }
/*    */   
/*    */   public static abstract class Delegate
/*    */     implements SharedLibrary
/*    */   {
/*    */     protected final SharedLibrary library;
/*    */     
/*    */     protected Delegate(SharedLibrary library) {
/* 43 */       this.library = library;
/*    */     }
/*    */ 
/*    */     
/*    */     public String getName() {
/* 48 */       return this.library.getName();
/*    */     }
/*    */ 
/*    */ 
/*    */     
/*    */     public String getPath() {
/* 54 */       return this.library.getPath();
/*    */     }
/*    */ 
/*    */     
/*    */     public long address() {
/* 59 */       return this.library.address();
/*    */     }
/*    */ 
/*    */     
/*    */     public void free() {
/* 64 */       this.library.free();
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\SharedLibrary.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */