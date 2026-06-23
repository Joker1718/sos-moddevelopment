/*    */ package org.lwjgl.system.windows;
/*    */ 
/*    */ import java.nio.ByteBuffer;
/*    */ import java.nio.IntBuffer;
/*    */ import org.lwjgl.system.Library;
/*    */ import org.lwjgl.system.MemoryStack;
/*    */ import org.lwjgl.system.MemoryUtil;
/*    */ import org.lwjgl.system.SharedLibrary;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WindowsLibrary
/*    */   extends SharedLibrary.Default
/*    */ {
/*    */   public static final long HINSTANCE;
/*    */   
/*    */   static {
/* 24 */     try (MemoryStack stack = MemoryStack.stackPush()) {
/* 25 */       IntBuffer pi = stack.mallocInt(1);
/* 26 */       HINSTANCE = WinBase.GetModuleHandle(pi, stack.UTF16(Library.JNI_LIBRARY_NAME));
/* 27 */       if (HINSTANCE == 0L) {
/* 28 */         WindowsUtil.windowsThrowException("Failed to retrieve LWJGL module handle.", pi);
/*    */       }
/*    */     } 
/*    */   }
/*    */   
/*    */   public WindowsLibrary(String name) {
/* 34 */     this(name, loadLibrary(name));
/*    */   }
/*    */   
/*    */   public WindowsLibrary(String name, long handle) {
/* 38 */     super(name, handle);
/*    */   }
/*    */   
/*    */   private static long loadLibrary(String name) {
/*    */     long handle;
/* 43 */     try (MemoryStack stack = MemoryStack.stackPush()) {
/* 44 */       IntBuffer pi = stack.mallocInt(1);
/* 45 */       handle = WinBase.LoadLibrary(pi, stack.UTF16(name));
/* 46 */       if (handle == 0L) {
/* 47 */         throw new UnsatisfiedLinkError("Failed to load library: " + name + " (error code = " + pi.get(0) + ")");
/*    */       }
/*    */     } 
/* 50 */     return handle;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getPath() {
/* 55 */     int maxLen = 256;
/*    */     
/* 57 */     ByteBuffer buffer = MemoryUtil.memAlloc(maxLen);
/*    */     try {
/*    */       while (true) {
/*    */         int len, err;
/* 61 */         try (MemoryStack stack = MemoryStack.stackPush()) {
/* 62 */           IntBuffer pi = stack.mallocInt(1);
/* 63 */           len = WinBase.GetModuleFileName(pi, address(), buffer);
/* 64 */           err = pi.get(0);
/*    */         } 
/* 66 */         if (err == 0) {
/* 67 */           return (len == 0) ? null : MemoryUtil.memUTF16(buffer, len);
/*    */         }
/* 69 */         if (err != 122) {
/* 70 */           stack = null; return (String)stack;
/*    */         } 
/* 72 */         buffer = MemoryUtil.memRealloc(buffer, maxLen = maxLen * 3 / 2);
/*    */       } 
/*    */     } finally {
/* 75 */       MemoryUtil.memFree(buffer);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public long getFunctionAddress(ByteBuffer functionName) {
/* 81 */     return WinBase.GetProcAddress((IntBuffer)null, address(), functionName);
/*    */   }
/*    */ 
/*    */   
/*    */   public void free() {
/* 86 */     try (MemoryStack stack = MemoryStack.stackPush()) {
/* 87 */       IntBuffer pi = stack.mallocInt(1);
/* 88 */       if (!WinBase.FreeLibrary(pi, address()))
/* 89 */         WindowsUtil.windowsThrowException("Failed to unload library: " + getName(), pi); 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\windows\WindowsLibrary.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */