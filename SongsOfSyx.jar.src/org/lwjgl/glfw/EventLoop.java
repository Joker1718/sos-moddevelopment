/*    */ package org.lwjgl.glfw;
/*    */ 
/*    */ import org.lwjgl.system.Configuration;
/*    */ import org.lwjgl.system.JNI;
/*    */ import org.lwjgl.system.Platform;
/*    */ import org.lwjgl.system.macosx.LibC;
/*    */ import org.lwjgl.system.macosx.ObjCRuntime;
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
/*    */ final class EventLoop
/*    */ {
/*    */   static void check() {
/* 30 */     if (Platform.get() == Platform.MACOSX && !isMainThread())
/*    */     {
/* 32 */       throw new IllegalStateException(
/* 33 */           isJavaStartedOnFirstThread() ? "GLFW may only be used on the main thread. This check may be disabled with Configuration.GLFW_CHECK_THREAD0." : "GLFW may only be used on the main thread and that thread must be the first thread in the process. Please run the JVM with -XstartOnFirstThread. This check may be disabled with Configuration.GLFW_CHECK_THREAD0.");
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private static boolean isMainThread() {
/* 42 */     if (!((Boolean)Configuration.GLFW_CHECK_THREAD0.get(Boolean.valueOf(true))).booleanValue() || ((String)Configuration.GLFW_LIBRARY_NAME.get("")).contains("glfw_async")) {
/* 43 */       return true;
/*    */     }
/*    */     
/* 46 */     long objc_msgSend = ObjCRuntime.getLibrary().getFunctionAddress("objc_msgSend");
/*    */     
/* 48 */     long NSThread = ObjCRuntime.objc_getClass("NSThread");
/* 49 */     long currentThread = JNI.invokePPP(NSThread, ObjCRuntime.sel_getUid("currentThread"), objc_msgSend);
/*    */     
/* 51 */     return JNI.invokePPZ(currentThread, ObjCRuntime.sel_getUid("isMainThread"), objc_msgSend);
/*    */   }
/*    */   
/*    */   private static boolean isJavaStartedOnFirstThread() {
/* 55 */     return "1".equals(System.getenv().get("JAVA_STARTED_ON_FIRST_THREAD_" + LibC.getpid()));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\glfw\EventLoop.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */