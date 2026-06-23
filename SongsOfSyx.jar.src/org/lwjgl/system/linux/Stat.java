/*    */ package org.lwjgl.system.linux;
/*    */ 
/*    */ import java.nio.ByteBuffer;
/*    */ import java.nio.IntBuffer;
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
/*    */ public class Stat
/*    */ {
/*    */   static {
/* 20 */     Library.initialize();
/*    */   }
/*    */   protected Stat() {
/* 23 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static int stat(@NativeType("int *") IntBuffer _errno, @NativeType("char const *") ByteBuffer __file, @NativeType("struct stat *") long __buf) {
/* 33 */     if (Checks.CHECKS) {
/* 34 */       Checks.checkSafe(_errno, 1);
/* 35 */       Checks.checkNT1(__file);
/* 36 */       Checks.check(__buf);
/*    */     } 
/* 38 */     return nstat(MemoryUtil.memAddressSafe(_errno), MemoryUtil.memAddress(__file), __buf);
/*    */   }
/*    */ 
/*    */   
/*    */   public static int stat(@NativeType("int *") IntBuffer _errno, @NativeType("char const *") CharSequence __file, @NativeType("struct stat *") long __buf) {
/* 43 */     if (Checks.CHECKS) {
/* 44 */       Checks.checkSafe(_errno, 1);
/* 45 */       Checks.check(__buf);
/*    */     } 
/* 47 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*    */     try {
/* 49 */       stack.nUTF8(__file, true);
/* 50 */       long __fileEncoded = stack.getPointerAddress();
/* 51 */       return nstat(MemoryUtil.memAddressSafe(_errno), __fileEncoded, __buf);
/*    */     } finally {
/* 53 */       stack.setPointer(stackPointer);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static int fstat(@NativeType("int *") IntBuffer _errno, int __fd, @NativeType("struct stat *") long __buf) {
/* 64 */     if (Checks.CHECKS) {
/* 65 */       Checks.checkSafe(_errno, 1);
/* 66 */       Checks.check(__buf);
/*    */     } 
/* 68 */     return nfstat(MemoryUtil.memAddressSafe(_errno), __fd, __buf);
/*    */   }
/*    */   
/*    */   public static native int nstat(long paramLong1, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native int nfstat(long paramLong1, int paramInt, long paramLong2);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\Stat.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */