/*    */ package org.lwjgl.system.libc;
/*    */ 
/*    */ import java.nio.ByteBuffer;
/*    */ import org.lwjgl.system.Checks;
/*    */ import org.lwjgl.system.Library;
/*    */ import org.lwjgl.system.MemoryStack;
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
/*    */ public class LibCLocale
/*    */ {
/*    */   static {
/* 20 */     Library.initialize();
/*    */   }
/*    */   protected LibCLocale() {
/* 23 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 31 */   public static final int LC_ALL = LC_ALL();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 38 */   public static final int LC_COLLATE = LC_COLLATE();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 45 */   public static final int LC_CTYPE = LC_CTYPE();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 52 */   public static final int LC_MONETARY = LC_MONETARY();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 59 */   public static final int LC_NUMERIC = LC_NUMERIC();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 66 */   public static final int LC_TIME = LC_TIME();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @NativeType("char *")
/*    */   public static String setlocale(int category, @NativeType("char const *") ByteBuffer locale) {
/* 76 */     if (Checks.CHECKS) {
/* 77 */       Checks.checkNT1(locale);
/*    */     }
/* 79 */     long __result = nsetlocale(category, MemoryUtil.memAddress(locale));
/* 80 */     return MemoryUtil.memASCIISafe(__result);
/*    */   }
/*    */ 
/*    */   
/*    */   @NativeType("char *")
/*    */   public static String setlocale(int category, @NativeType("char const *") CharSequence locale) {
/* 86 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*    */     try {
/* 88 */       stack.nASCII(locale, true);
/* 89 */       long localeEncoded = stack.getPointerAddress();
/* 90 */       long __result = nsetlocale(category, localeEncoded);
/* 91 */       return MemoryUtil.memASCIISafe(__result);
/*    */     } finally {
/* 93 */       stack.setPointer(stackPointer);
/*    */     } 
/*    */   }
/*    */   
/*    */   private static native int LC_ALL();
/*    */   
/*    */   private static native int LC_COLLATE();
/*    */   
/*    */   private static native int LC_CTYPE();
/*    */   
/*    */   private static native int LC_MONETARY();
/*    */   
/*    */   private static native int LC_NUMERIC();
/*    */   
/*    */   private static native int LC_TIME();
/*    */   
/*    */   public static native long nsetlocale(int paramInt, long paramLong);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\libc\LibCLocale.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */