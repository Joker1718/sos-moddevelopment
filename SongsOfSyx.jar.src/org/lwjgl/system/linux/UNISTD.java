/*    */ package org.lwjgl.system.linux;
/*    */ 
/*    */ import java.nio.ByteBuffer;
/*    */ import java.nio.IntBuffer;
/*    */ import org.lwjgl.system.Checks;
/*    */ import org.lwjgl.system.Library;
/*    */ import org.lwjgl.system.MemoryUtil;
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class UNISTD
/*    */ {
/*    */   public static final int _SC_OPEN_MAX = 4;
/*    */   public static final int _SC_PAGE_SIZE = 30;
/*    */   public static final int _SC_IOV_MAX = 60;
/*    */   
/*    */   static {
/* 19 */     Library.initialize();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected UNISTD() {
/* 27 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static int close(@NativeType("int *") IntBuffer _errno, int fd) {
/* 37 */     if (Checks.CHECKS) {
/* 38 */       Checks.checkSafe(_errno, 1);
/*    */     }
/* 40 */     return nclose(MemoryUtil.memAddressSafe(_errno), fd);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static long sysconf(@NativeType("int *") IntBuffer _errno, int name) {
/* 50 */     if (Checks.CHECKS) {
/* 51 */       Checks.checkSafe(_errno, 1);
/*    */     }
/* 53 */     return nsysconf(MemoryUtil.memAddressSafe(_errno), name);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @NativeType("ssize_t")
/*    */   public static long read(@NativeType("int *") IntBuffer _errno, int fd, @NativeType("void *") ByteBuffer buf) {
/* 64 */     if (Checks.CHECKS) {
/* 65 */       Checks.checkSafe(_errno, 1);
/*    */     }
/* 67 */     return nread(MemoryUtil.memAddressSafe(_errno), fd, MemoryUtil.memAddress(buf), buf.remaining());
/*    */   }
/*    */   
/*    */   public static native int nclose(long paramLong, int paramInt);
/*    */   
/*    */   public static native long nsysconf(long paramLong, int paramInt);
/*    */   
/*    */   public static native long nread(long paramLong1, int paramInt, long paramLong2, long paramLong3);
/*    */   
/*    */   @NativeType("pid_t")
/*    */   public static native int getpid();
/*    */   
/*    */   @NativeType("pid_t")
/*    */   public static native int getppid();
/*    */   
/*    */   @NativeType("pid_t")
/*    */   public static native int gettid();
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\UNISTD.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */