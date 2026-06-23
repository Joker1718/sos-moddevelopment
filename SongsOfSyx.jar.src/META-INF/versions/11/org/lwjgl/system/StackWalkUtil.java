/*     */ package META-INF.versions.11.org.lwjgl.system;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.stream.Stream;
/*     */ import org.lwjgl.system.APIUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class StackWalkUtil
/*     */ {
/*  16 */   private static final StackWalker STACKWALKER = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE);
/*     */   
/*     */   static {
/*  19 */     APIUtil.apiLog("Java 11 stack walker enabled");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static StackTraceElement[] stackWalkArray(Object[] a) {
/*  26 */     return (StackTraceElement[])Arrays.<StackWalker.StackFrame>stream((StackWalker.StackFrame[])a)
/*  27 */       .map(StackWalker.StackFrame::toStackTraceElement)
/*  28 */       .toArray(x$0 -> new StackTraceElement[x$0]);
/*     */   }
/*     */   
/*     */   static Object stackWalkGetMethod(Class<?> after) {
/*  32 */     return STACKWALKER.walk(s -> {
/*     */           StackWalker.StackFrame frame;
/*     */           Iterator<StackWalker.StackFrame> iter = s.iterator();
/*     */           iter.next();
/*     */           iter.next();
/*     */           do {
/*     */             frame = iter.next();
/*     */           } while (frame.getDeclaringClass() == after && iter.hasNext());
/*     */           return frame;
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean isSameMethod(StackWalker.StackFrame a, StackWalker.StackFrame b) {
/*  47 */     return isSameMethod(a, b, b.getMethodName());
/*     */   }
/*     */   
/*     */   private static boolean isSameMethod(StackWalker.StackFrame a, StackWalker.StackFrame b, String methodName) {
/*  51 */     return (a.getDeclaringClass() == b.getDeclaringClass() && a
/*  52 */       .getMethodName().equals(methodName));
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean isAutoCloseable(StackWalker.StackFrame element, StackWalker.StackFrame pushed) {
/*  57 */     if (isSameMethod(element, pushed, "$closeResource")) {
/*  58 */       return true;
/*     */     }
/*     */ 
/*     */     
/*  62 */     if ("kotlin.jdk7.AutoCloseableKt".equals(element.getClassName()) && "closeFinally".equals(element.getMethodName())) {
/*  63 */       return true;
/*     */     }
/*     */     
/*  66 */     return false;
/*     */   }
/*     */   
/*     */   static Object stackWalkCheckPop(Class<?> after, Object pushedObj) {
/*  70 */     StackWalker.StackFrame pushed = (StackWalker.StackFrame)pushedObj;
/*     */     
/*  72 */     return StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE).walk(s -> {
/*     */           StackWalker.StackFrame element;
/*     */           Iterator<StackWalker.StackFrame> iter = s.iterator();
/*     */           iter.next();
/*     */           iter.next();
/*     */           do {
/*     */             element = iter.next();
/*     */           } while (element.getDeclaringClass() == after && iter.hasNext());
/*     */           if (isSameMethod(element, pushed)) {
/*     */             return null;
/*     */           }
/*     */           if (iter.hasNext() && isAutoCloseable(element, pushed)) {
/*     */             element = iter.next();
/*     */             if (isSameMethod(element, pushed)) {
/*     */               return null;
/*     */             }
/*     */           } 
/*     */           return element;
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static Object[] stackWalkGetTrace() {
/* 101 */     return StackWalker.getInstance()
/* 102 */       .<Object[]>walk(s -> (StackWalker.StackFrame[])s.skip(2L).dropWhile(()).toArray(()));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\META-INF\versions\11\org\lwjgl\system\StackWalkUtil.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */