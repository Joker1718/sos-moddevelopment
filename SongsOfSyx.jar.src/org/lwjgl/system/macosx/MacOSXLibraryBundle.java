/*    */ package org.lwjgl.system.macosx;
/*    */ 
/*    */ import java.nio.ByteBuffer;
/*    */ import org.lwjgl.system.Checks;
/*    */ import org.lwjgl.system.MemoryStack;
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
/*    */ public class MacOSXLibraryBundle
/*    */   extends MacOSXLibrary
/*    */ {
/*    */   public MacOSXLibraryBundle(String name, long bundleRef) {
/* 21 */     super(name, bundleRef);
/*    */   }
/*    */   
/*    */   public static MacOSXLibraryBundle getWithIdentifier(String bundleID) {
/* 25 */     long filePath = 0L;
/* 26 */     try (MemoryStack stack = MemoryStack.stackPush()) {
/* 27 */       filePath = CString2CFString(stack.UTF8(bundleID), 134217984);
/*    */       
/* 29 */       long bundleRef = CoreFoundation.CFBundleGetBundleWithIdentifier(filePath);
/* 30 */       if (bundleRef == 0L) {
/* 31 */         throw new UnsatisfiedLinkError("Failed to retrieve bundle with identifier: " + bundleID);
/*    */       }
/*    */       
/* 34 */       CoreFoundation.CFRetain(bundleRef);
/* 35 */       return new MacOSXLibraryBundle(bundleID, bundleRef);
/*    */     } finally {
/* 37 */       if (filePath != 0L) {
/* 38 */         CoreFoundation.CFRelease(filePath);
/*    */       }
/*    */     } 
/*    */   }
/*    */   
/*    */   public static MacOSXLibraryBundle create(String path) {
/* 44 */     long filePath = 0L;
/* 45 */     long url = 0L;
/* 46 */     try (MemoryStack stack = MemoryStack.stackPush()) {
/* 47 */       filePath = CString2CFString(stack.UTF8(path), 134217984);
/* 48 */       url = Checks.check(CoreFoundation.CFURLCreateWithFileSystemPath(0L, filePath, 0L, true));
/*    */       
/* 50 */       long bundleRef = CoreFoundation.CFBundleCreate(0L, url);
/* 51 */       if (bundleRef == 0L) {
/* 52 */         throw new UnsatisfiedLinkError("Failed to create bundle: " + path);
/*    */       }
/*    */       
/* 55 */       return new MacOSXLibraryBundle(path, bundleRef);
/*    */     } finally {
/* 57 */       if (url != 0L) {
/* 58 */         CoreFoundation.CFRelease(url);
/*    */       }
/* 60 */       if (filePath != 0L) {
/* 61 */         CoreFoundation.CFRelease(filePath);
/*    */       }
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public String getPath() {
/* 68 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public long getFunctionAddress(ByteBuffer functionName) {
/* 73 */     long nameRef = CString2CFString(functionName, 1536);
/*    */     try {
/* 75 */       return CoreFoundation.CFBundleGetFunctionPointerForName(address(), nameRef);
/*    */     } finally {
/* 77 */       CoreFoundation.CFRelease(nameRef);
/*    */     } 
/*    */   }
/*    */   
/*    */   private static long CString2CFString(ByteBuffer name, int encoding) {
/* 82 */     return Checks.check(CoreFoundation.CFStringCreateWithCStringNoCopy(0L, name, encoding, CoreFoundation.kCFAllocatorNull));
/*    */   }
/*    */ 
/*    */   
/*    */   public void free() {
/* 87 */     CoreFoundation.CFRelease(address());
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\macosx\MacOSXLibraryBundle.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */