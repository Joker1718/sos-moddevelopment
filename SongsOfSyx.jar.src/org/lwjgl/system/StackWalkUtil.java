/*     */ package org.lwjgl.system;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Objects;
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
/*     */ final class StackWalkUtil
/*     */ {
/*     */   static StackTraceElement[] stackWalkArray(Object[] a) {
/*  22 */     return (StackTraceElement[])a;
/*     */   }
/*     */   
/*     */   static Object stackWalkGetMethod(Class<?> after) {
/*  26 */     StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
/*     */     
/*  28 */     for (int i = 3; i < stackTrace.length; i++) {
/*  29 */       if (!stackTrace[i].getClassName().startsWith(after.getName())) {
/*  30 */         return stackTrace[i];
/*     */       }
/*     */     } 
/*     */     
/*  34 */     throw new IllegalStateException();
/*     */   }
/*     */   
/*     */   private static boolean isSameMethod(StackTraceElement a, StackTraceElement b) {
/*  38 */     return isSameMethod(a, b, b.getMethodName());
/*     */   }
/*     */   
/*     */   private static boolean isSameMethod(StackTraceElement a, StackTraceElement b, String methodName) {
/*  42 */     return (a.getMethodName().equals(methodName) && a
/*  43 */       .getClassName().equals(b.getClassName()) && 
/*  44 */       Objects.equals(a.getFileName(), b.getFileName()));
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean isAutoCloseable(StackTraceElement element, StackTraceElement pushed) {
/*  49 */     if (isSameMethod(element, pushed, "$closeResource")) {
/*  50 */       return true;
/*     */     }
/*     */ 
/*     */     
/*  54 */     if ("closeFinally".equals(element.getMethodName()) && "AutoCloseable.kt".equals(element.getFileName())) {
/*  55 */       return true;
/*     */     }
/*     */     
/*  58 */     return false;
/*     */   }
/*     */   
/*     */   static Object stackWalkCheckPop(Class<?> after, Object pushedObj) {
/*  62 */     StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
/*     */     
/*  64 */     for (int i = 3; i < stackTrace.length; ) {
/*  65 */       StackTraceElement element = stackTrace[i];
/*  66 */       if (element.getClassName().startsWith(after.getName())) {
/*     */         i++;
/*     */         continue;
/*     */       } 
/*  70 */       StackTraceElement pushed = (StackTraceElement)pushedObj;
/*  71 */       if (isSameMethod(element, pushed)) {
/*  72 */         return null;
/*     */       }
/*     */       
/*  75 */       if (isAutoCloseable(element, pushed) && i + 1 < stackTrace.length) {
/*     */ 
/*     */ 
/*     */         
/*  79 */         element = stackTrace[i + 1];
/*  80 */         if (isSameMethod(pushed, stackTrace[i + 1])) {
/*  81 */           return null;
/*     */         }
/*     */       } 
/*     */       
/*  85 */       return element;
/*     */     } 
/*     */     
/*  88 */     throw new IllegalStateException();
/*     */   }
/*     */   
/*     */   static Object[] stackWalkGetTrace() {
/*  92 */     StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
/*     */     
/*  94 */     int i = 3;
/*  95 */     for (; i < stackTrace.length && 
/*  96 */       stackTrace[i].getClassName().startsWith("org.lwjgl.system.Memory"); i++);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 101 */     return Arrays.copyOfRange((Object[])stackTrace, i, stackTrace.length);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\StackWalkUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */