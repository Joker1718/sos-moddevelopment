/*     */ package org.lwjgl.glfw;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import java.lang.reflect.Field;
/*     */ import java.util.Map;
/*     */ import org.lwjgl.system.APIUtil;
/*     */ import org.lwjgl.system.Callback;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class GLFWErrorCallback
/*     */   extends Callback
/*     */   implements GLFWErrorCallbackI
/*     */ {
/*     */   public static GLFWErrorCallback create(long functionPointer) {
/*  28 */     GLFWErrorCallbackI instance = (GLFWErrorCallbackI)Callback.get(functionPointer);
/*  29 */     return (instance instanceof GLFWErrorCallback) ? (GLFWErrorCallback)instance : new Container(functionPointer, instance);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static GLFWErrorCallback createSafe(long functionPointer) {
/*  36 */     return (functionPointer == 0L) ? null : create(functionPointer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static GLFWErrorCallback create(GLFWErrorCallbackI instance) {
/*  41 */     return (instance instanceof GLFWErrorCallback) ? (GLFWErrorCallback)instance : new Container(instance
/*     */         
/*  43 */         .address(), instance);
/*     */   }
/*     */   
/*     */   protected GLFWErrorCallback() {
/*  47 */     super(DESCRIPTOR);
/*     */   }
/*     */   
/*     */   GLFWErrorCallback(long functionPointer) {
/*  51 */     super(functionPointer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getDescription(long description) {
/*  64 */     return MemoryUtil.memUTF8(description);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static GLFWErrorCallback createPrint() {
/*  73 */     return createPrint(APIUtil.DEBUG_STREAM);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static GLFWErrorCallback createPrint(final PrintStream stream) {
/*  84 */     return new GLFWErrorCallback()
/*     */       {
/*     */         private Map<Integer, String> ERROR_CODES;
/*     */         
/*     */         public void invoke(int error, long description) {
/*  89 */           String msg = getDescription(description);
/*     */           
/*  91 */           StringBuilder sb = new StringBuilder(512);
/*  92 */           sb
/*  93 */             .append("[LWJGL] ")
/*  94 */             .append(this.ERROR_CODES.get(Integer.valueOf(error)))
/*  95 */             .append(" error\n")
/*  96 */             .append("\tDescription : ")
/*  97 */             .append(msg)
/*  98 */             .append("\n")
/*  99 */             .append("\tStacktrace  :\n");
/*     */           
/* 101 */           StackTraceElement[] stack = Thread.currentThread().getStackTrace();
/* 102 */           for (int i = 4; i < stack.length; i++) {
/* 103 */             sb.append("\t\t");
/* 104 */             sb.append(stack[i]);
/* 105 */             sb.append("\n");
/*     */           } 
/*     */           
/* 108 */           stream.print(sb);
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static GLFWErrorCallback createThrow() {
/* 119 */     return new GLFWErrorCallback()
/*     */       {
/*     */         public void invoke(int error, long description) {
/* 122 */           throw new IllegalStateException(String.format("GLFW error [0x%X]: %s", new Object[] { Integer.valueOf(error), getDescription(description) }));
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   public GLFWErrorCallback set() {
/* 129 */     GLFW.glfwSetErrorCallback(this);
/* 130 */     return this;
/*     */   }
/*     */   
/*     */   private static final class Container
/*     */     extends GLFWErrorCallback {
/*     */     private final GLFWErrorCallbackI delegate;
/*     */     
/*     */     Container(long functionPointer, GLFWErrorCallbackI delegate) {
/* 138 */       super(functionPointer);
/* 139 */       this.delegate = delegate;
/*     */     }
/*     */ 
/*     */     
/*     */     public void invoke(int error, long description) {
/* 144 */       this.delegate.invoke(error, description);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\glfw\GLFWErrorCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */