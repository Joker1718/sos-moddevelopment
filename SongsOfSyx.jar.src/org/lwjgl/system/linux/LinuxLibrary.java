/*    */ package org.lwjgl.system.linux;
/*    */ 
/*    */ import java.nio.ByteBuffer;
/*    */ import org.lwjgl.system.MemoryStack;
/*    */ import org.lwjgl.system.SharedLibrary;
/*    */ import org.lwjgl.system.SharedLibraryUtil;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class LinuxLibrary
/*    */   extends SharedLibrary.Default
/*    */ {
/*    */   public LinuxLibrary(String name) {
/* 20 */     this(name, loadLibrary(name));
/*    */   }
/*    */   
/*    */   public LinuxLibrary(String name, long handle) {
/* 24 */     super(name, handle);
/*    */   }
/*    */   
/*    */   private static long loadLibrary(String name) {
/*    */     long handle;
/* 29 */     try (MemoryStack stack = MemoryStack.stackPush()) {
/* 30 */       handle = DynamicLinkLoader.dlopen(stack.UTF8(name), 1);
/*    */     } 
/* 32 */     if (handle == 0L) {
/* 33 */       throw new UnsatisfiedLinkError("Failed to dynamically load library: " + name + "(error = " + DynamicLinkLoader.dlerror() + ")");
/*    */     }
/* 35 */     return handle;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getPath() {
/* 40 */     return SharedLibraryUtil.getLibraryPath(address());
/*    */   }
/*    */ 
/*    */   
/*    */   public long getFunctionAddress(ByteBuffer functionName) {
/* 45 */     return DynamicLinkLoader.dlsym(address(), functionName);
/*    */   }
/*    */ 
/*    */   
/*    */   public void free() {
/* 50 */     DynamicLinkLoader.dlclose(address());
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\LinuxLibrary.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */