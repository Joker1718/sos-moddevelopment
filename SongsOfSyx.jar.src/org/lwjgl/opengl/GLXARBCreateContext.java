/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import java.nio.IntBuffer;
/*    */ import org.lwjgl.system.Checks;
/*    */ import org.lwjgl.system.JNI;
/*    */ import org.lwjgl.system.MemoryUtil;
/*    */ import org.lwjgl.system.NativeType;
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
/*    */ public class GLXARBCreateContext
/*    */ {
/*    */   public static final int GLX_CONTEXT_MAJOR_VERSION_ARB = 8337;
/*    */   public static final int GLX_CONTEXT_MINOR_VERSION_ARB = 8338;
/*    */   public static final int GLX_CONTEXT_FLAGS_ARB = 8340;
/*    */   public static final int GLX_CONTEXT_DEBUG_BIT_ARB = 1;
/*    */   public static final int GLX_CONTEXT_FORWARD_COMPATIBLE_BIT_ARB = 2;
/*    */   
/*    */   protected GLXARBCreateContext() {
/* 30 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static long nglXCreateContextAttribsARB(long display, long config, long share_context, int direct, long attrib_list) {
/* 37 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXCreateContextAttribsARB;
/* 38 */     if (Checks.CHECKS) {
/* 39 */       Checks.check(__functionAddress);
/* 40 */       Checks.check(display);
/* 41 */       Checks.check(config);
/*    */     } 
/* 43 */     return JNI.callPPPPP(display, config, share_context, direct, attrib_list, __functionAddress);
/*    */   }
/*    */ 
/*    */   
/*    */   @NativeType("GLXContext")
/*    */   public static long glXCreateContextAttribsARB(@NativeType("Display *") long display, @NativeType("GLXFBConfig") long config, @NativeType("GLXContext") long share_context, @NativeType("Bool") boolean direct, @NativeType("int const *") IntBuffer attrib_list) {
/* 49 */     if (Checks.CHECKS) {
/* 50 */       Checks.checkNTSafe(attrib_list);
/*    */     }
/* 52 */     return nglXCreateContextAttribsARB(display, config, share_context, direct ? 1 : 0, MemoryUtil.memAddressSafe(attrib_list));
/*    */   }
/*    */ 
/*    */   
/*    */   @NativeType("GLXContext")
/*    */   public static long glXCreateContextAttribsARB(@NativeType("Display *") long display, @NativeType("GLXFBConfig") long config, @NativeType("GLXContext") long share_context, @NativeType("Bool") boolean direct, @NativeType("int const *") int[] attrib_list) {
/* 58 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXCreateContextAttribsARB;
/* 59 */     if (Checks.CHECKS) {
/* 60 */       Checks.check(__functionAddress);
/* 61 */       Checks.check(display);
/* 62 */       Checks.check(config);
/* 63 */       Checks.checkNTSafe(attrib_list);
/*    */     } 
/* 65 */     return JNI.callPPPPP(display, config, share_context, direct ? 1 : 0, attrib_list, __functionAddress);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\GLXARBCreateContext.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */