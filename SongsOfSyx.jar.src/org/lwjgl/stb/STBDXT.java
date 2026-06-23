/*    */ package org.lwjgl.stb;
/*    */ 
/*    */ import java.nio.ByteBuffer;
/*    */ import org.lwjgl.system.Checks;
/*    */ import org.lwjgl.system.MemoryUtil;
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class STBDXT
/*    */ {
/*    */   public static final int STB_DXT_NORMAL = 0;
/*    */   public static final int STB_DXT_DITHER = 1;
/*    */   public static final int STB_DXT_HIGHQUAL = 2;
/*    */   
/*    */   static {
/* 17 */     LibSTB.initialize();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected STBDXT() {
/* 25 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void stb_compress_dxt_block(@NativeType("unsigned char *") ByteBuffer dest, @NativeType("unsigned char const *") ByteBuffer src_rgba_four_bytes_per_pixel, @NativeType("int") boolean alpha, int mode) {
/* 35 */     if (Checks.CHECKS) {
/* 36 */       Checks.check(dest, alpha ? 16 : 8);
/* 37 */       Checks.check(src_rgba_four_bytes_per_pixel, 64);
/*    */     } 
/* 39 */     nstb_compress_dxt_block(MemoryUtil.memAddress(dest), MemoryUtil.memAddress(src_rgba_four_bytes_per_pixel), alpha ? 1 : 0, mode);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void stb_compress_bc4_block(@NativeType("unsigned char *") ByteBuffer dest, @NativeType("unsigned char const *") ByteBuffer src_r_one_byte_per_pixel) {
/* 49 */     if (Checks.CHECKS) {
/* 50 */       Checks.check(dest, 8);
/* 51 */       Checks.check(src_r_one_byte_per_pixel, 16);
/*    */     } 
/* 53 */     nstb_compress_bc4_block(MemoryUtil.memAddress(dest), MemoryUtil.memAddress(src_r_one_byte_per_pixel));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void stb_compress_bc5_block(@NativeType("unsigned char *") ByteBuffer dest, @NativeType("unsigned char const *") ByteBuffer src_rg_two_byte_per_pixel) {
/* 63 */     if (Checks.CHECKS) {
/* 64 */       Checks.check(dest, 16);
/* 65 */       Checks.check(src_rg_two_byte_per_pixel, 32);
/*    */     } 
/* 67 */     nstb_compress_bc5_block(MemoryUtil.memAddress(dest), MemoryUtil.memAddress(src_rg_two_byte_per_pixel));
/*    */   }
/*    */   
/*    */   public static native void nstb_compress_dxt_block(long paramLong1, long paramLong2, int paramInt1, int paramInt2);
/*    */   
/*    */   public static native void nstb_compress_bc4_block(long paramLong1, long paramLong2);
/*    */   
/*    */   public static native void nstb_compress_bc5_block(long paramLong1, long paramLong2);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\stb\STBDXT.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */