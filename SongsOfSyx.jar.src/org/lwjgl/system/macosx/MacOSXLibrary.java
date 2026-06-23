/*    */ package org.lwjgl.system.macosx;
/*    */ 
/*    */ import org.lwjgl.system.APIUtil;
/*    */ import org.lwjgl.system.SharedLibrary;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class MacOSXLibrary
/*    */   extends SharedLibrary.Default
/*    */ {
/*    */   protected MacOSXLibrary(String name, long handle) {
/* 15 */     super(name, handle);
/*    */   }
/*    */   
/*    */   public static MacOSXLibrary getWithIdentifier(String bundleID) {
/* 19 */     APIUtil.apiLog("Loading library: " + bundleID);
/* 20 */     MacOSXLibraryBundle lib = MacOSXLibraryBundle.getWithIdentifier(bundleID);
/* 21 */     APIUtil.apiLogMore("Success");
/* 22 */     return lib;
/*    */   }
/*    */   
/*    */   public static MacOSXLibrary create(String name) {
/* 26 */     return name.endsWith(".framework") ? 
/* 27 */       MacOSXLibraryBundle.create(name) : new MacOSXLibraryDL(name);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\macosx\MacOSXLibrary.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */