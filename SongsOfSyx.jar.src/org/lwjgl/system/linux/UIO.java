/*     */ package org.lwjgl.system.linux;
/*     */ 
/*     */ import java.nio.IntBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.Library;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ public class UIO {
/*     */   public static final int UIO_FASTIOV = 8;
/*     */   public static final int UIO_MAXIOV = 1024;
/*     */   public static final int RWF_HIPRI = 1;
/*     */   public static final int RWF_DSYNC = 2;
/*     */   public static final int RWF_SYNC = 4;
/*     */   public static final int RWF_NOWAIT = 8;
/*     */   public static final int RWF_APPEND = 16;
/*     */   
/*     */   static {
/*  19 */     Library.initialize();
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
/*     */   
/*     */   protected UIO() {
/*  33 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ssize_t")
/*     */   public static long readv(@NativeType("int *") IntBuffer _errno, int __fd, @NativeType("struct iovec const *") IOVec __iovec, int __count) {
/*  44 */     if (Checks.CHECKS) {
/*  45 */       Checks.checkSafe(_errno, 1);
/*     */     }
/*  47 */     return nreadv(MemoryUtil.memAddressSafe(_errno), __fd, __iovec.address(), __count);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ssize_t")
/*     */   public static long writev(@NativeType("int *") IntBuffer _errno, int __fd, @NativeType("struct iovec const *") IOVec __iovec, int __count) {
/*  58 */     if (Checks.CHECKS) {
/*  59 */       Checks.checkSafe(_errno, 1);
/*     */     }
/*  61 */     return nwritev(MemoryUtil.memAddressSafe(_errno), __fd, __iovec.address(), __count);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ssize_t")
/*     */   public static long preadv(@NativeType("int *") IntBuffer _errno, int __fd, @NativeType("struct iovec const *") IOVec __iovec, int __count, @NativeType("off_t") long __offset) {
/*  72 */     if (Checks.CHECKS) {
/*  73 */       Checks.checkSafe(_errno, 1);
/*     */     }
/*  75 */     return npreadv(MemoryUtil.memAddressSafe(_errno), __fd, __iovec.address(), __count, __offset);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ssize_t")
/*     */   public static long pwritev(@NativeType("int *") IntBuffer _errno, int __fd, @NativeType("struct iovec const *") IOVec __iovec, int __count, @NativeType("off_t") long __offset) {
/*  86 */     if (Checks.CHECKS) {
/*  87 */       Checks.checkSafe(_errno, 1);
/*     */     }
/*  89 */     return npwritev(MemoryUtil.memAddressSafe(_errno), __fd, __iovec.address(), __count, __offset);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ssize_t")
/*     */   public static long process_vm_readv(@NativeType("int *") IntBuffer _errno, @NativeType("pid_t") int __pid, @NativeType("struct iovec const *") IOVec __lvec, @NativeType("unsigned long int") long __liovcnt, @NativeType("struct iovec const *") IOVec __rvec, @NativeType("unsigned long int") long __riovcnt, @NativeType("unsigned long int") long __flags) {
/* 100 */     if (Checks.CHECKS) {
/* 101 */       Checks.checkSafe(_errno, 1);
/*     */     }
/* 103 */     return nprocess_vm_readv(MemoryUtil.memAddressSafe(_errno), __pid, __lvec.address(), __liovcnt, __rvec.address(), __riovcnt, __flags);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ssize_t")
/*     */   public static long process_vm_writev(@NativeType("int *") IntBuffer _errno, @NativeType("pid_t") int __pid, @NativeType("struct iovec const *") IOVec __lvec, @NativeType("unsigned long int") long __liovcnt, @NativeType("struct iovec const *") IOVec __rvec, @NativeType("unsigned long int") long __riovcnt, @NativeType("unsigned long int") long __flags) {
/* 114 */     if (Checks.CHECKS) {
/* 115 */       Checks.checkSafe(_errno, 1);
/*     */     }
/* 117 */     return nprocess_vm_writev(MemoryUtil.memAddressSafe(_errno), __pid, __lvec.address(), __liovcnt, __rvec.address(), __riovcnt, __flags);
/*     */   }
/*     */   
/*     */   public static native long nreadv(long paramLong1, int paramInt1, long paramLong2, int paramInt2);
/*     */   
/*     */   public static native long nwritev(long paramLong1, int paramInt1, long paramLong2, int paramInt2);
/*     */   
/*     */   public static native long npreadv(long paramLong1, int paramInt1, long paramLong2, int paramInt2, long paramLong3);
/*     */   
/*     */   public static native long npwritev(long paramLong1, int paramInt1, long paramLong2, int paramInt2, long paramLong3);
/*     */   
/*     */   public static native long nprocess_vm_readv(long paramLong1, int paramInt, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6);
/*     */   
/*     */   public static native long nprocess_vm_writev(long paramLong1, int paramInt, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\UIO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */