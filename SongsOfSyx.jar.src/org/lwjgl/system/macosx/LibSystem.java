/*    */ package org.lwjgl.system.macosx;
/*    */ 
/*    */ import org.lwjgl.system.Library;
/*    */ import org.lwjgl.system.SharedLibrary;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class LibSystem
/*    */ {
/* 12 */   private static final SharedLibrary SYSTEM = Library.loadNative(LibSystem.class, "org.lwjgl", "System");
/*    */ 
/*    */   
/*    */   public static SharedLibrary getLibrary() {
/* 16 */     return SYSTEM;
/*    */   }
/*    */   
/*    */   private LibSystem() {
/* 20 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\macosx\LibSystem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */