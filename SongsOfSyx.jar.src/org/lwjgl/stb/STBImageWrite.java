/*     */ package org.lwjgl.stb;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import org.lwjgl.PointerBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.MemoryStack;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class STBImageWrite
/*     */ {
/*     */   static {
/*  20 */     LibSTB.initialize();
/*     */   }
/*     */   protected STBImageWrite() {
/*  23 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("int")
/*     */   public static boolean stbi_write_png(@NativeType("char const *") ByteBuffer filename, int w, int h, int comp, @NativeType("void const *") ByteBuffer data, int stride_in_bytes) {
/*  34 */     if (Checks.CHECKS) {
/*  35 */       Checks.checkNT1(filename);
/*  36 */       Checks.check(data, ((stride_in_bytes != 0) ? stride_in_bytes : (w * comp)) * h);
/*     */     } 
/*  38 */     return (nstbi_write_png(MemoryUtil.memAddress(filename), w, h, comp, MemoryUtil.memAddress(data), stride_in_bytes) != 0);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("int")
/*     */   public static boolean stbi_write_png(@NativeType("char const *") CharSequence filename, int w, int h, int comp, @NativeType("void const *") ByteBuffer data, int stride_in_bytes) {
/*  44 */     if (Checks.CHECKS) {
/*  45 */       Checks.check(data, ((stride_in_bytes != 0) ? stride_in_bytes : (w * comp)) * h);
/*     */     }
/*  47 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/*  49 */       stack.nUTF8(filename, true);
/*  50 */       long filenameEncoded = stack.getPointerAddress();
/*  51 */       return (nstbi_write_png(filenameEncoded, w, h, comp, MemoryUtil.memAddress(data), stride_in_bytes) != 0);
/*     */     } finally {
/*  53 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("int *")
/*     */   private static IntBuffer stbi_write_png_compression_level() {
/*  63 */     long __result = nstbi_write_png_compression_level();
/*  64 */     return MemoryUtil.memIntBuffer(__result, 1);
/*     */   }
/*     */ 
/*     */   
/*  68 */   public static final IntBuffer stbi_write_png_compression_level = stbi_write_png_compression_level();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("int *")
/*     */   private static IntBuffer stbi_write_force_png_filter() {
/*  76 */     long __result = nstbi_write_force_png_filter();
/*  77 */     return MemoryUtil.memIntBuffer(__result, 1);
/*     */   }
/*     */ 
/*     */   
/*  81 */   public static final IntBuffer stbi_write_force_png_filter = stbi_write_force_png_filter();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("unsigned char * (*) (unsigned char *, int, int *, int) *")
/*     */   private static PointerBuffer stbi_zlib_compress() {
/*  89 */     long __result = nstbi_zlib_compress();
/*  90 */     return MemoryUtil.memPointerBuffer(__result, 1);
/*     */   }
/*     */ 
/*     */   
/*  94 */   public static final PointerBuffer stbi_zlib_compress = stbi_zlib_compress();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("int")
/*     */   public static boolean stbi_write_bmp(@NativeType("char const *") ByteBuffer filename, int w, int h, int comp, @NativeType("void const *") ByteBuffer data) {
/* 104 */     if (Checks.CHECKS) {
/* 105 */       Checks.checkNT1(filename);
/* 106 */       Checks.check(data, w * h * comp);
/*     */     } 
/* 108 */     return (nstbi_write_bmp(MemoryUtil.memAddress(filename), w, h, comp, MemoryUtil.memAddress(data)) != 0);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("int")
/*     */   public static boolean stbi_write_bmp(@NativeType("char const *") CharSequence filename, int w, int h, int comp, @NativeType("void const *") ByteBuffer data) {
/* 114 */     if (Checks.CHECKS) {
/* 115 */       Checks.check(data, w * h * comp);
/*     */     }
/* 117 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 119 */       stack.nUTF8(filename, true);
/* 120 */       long filenameEncoded = stack.getPointerAddress();
/* 121 */       return (nstbi_write_bmp(filenameEncoded, w, h, comp, MemoryUtil.memAddress(data)) != 0);
/*     */     } finally {
/* 123 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("int")
/*     */   public static boolean stbi_write_tga(@NativeType("char const *") ByteBuffer filename, int w, int h, int comp, @NativeType("void const *") ByteBuffer data) {
/* 135 */     if (Checks.CHECKS) {
/* 136 */       Checks.checkNT1(filename);
/* 137 */       Checks.check(data, w * h * comp);
/*     */     } 
/* 139 */     return (nstbi_write_tga(MemoryUtil.memAddress(filename), w, h, comp, MemoryUtil.memAddress(data)) != 0);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("int")
/*     */   public static boolean stbi_write_tga(@NativeType("char const *") CharSequence filename, int w, int h, int comp, @NativeType("void const *") ByteBuffer data) {
/* 145 */     if (Checks.CHECKS) {
/* 146 */       Checks.check(data, w * h * comp);
/*     */     }
/* 148 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 150 */       stack.nUTF8(filename, true);
/* 151 */       long filenameEncoded = stack.getPointerAddress();
/* 152 */       return (nstbi_write_tga(filenameEncoded, w, h, comp, MemoryUtil.memAddress(data)) != 0);
/*     */     } finally {
/* 154 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("int *")
/*     */   private static IntBuffer stbi_write_tga_with_rle() {
/* 164 */     long __result = nstbi_write_tga_with_rle();
/* 165 */     return MemoryUtil.memIntBuffer(__result, 1);
/*     */   }
/*     */ 
/*     */   
/* 169 */   public static final IntBuffer stbi_write_tga_with_rle = stbi_write_tga_with_rle();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("int")
/*     */   public static boolean stbi_write_hdr(@NativeType("char const *") ByteBuffer filename, int w, int h, int comp, @NativeType("float const *") FloatBuffer data) {
/* 179 */     if (Checks.CHECKS) {
/* 180 */       Checks.checkNT1(filename);
/* 181 */       Checks.check(data, w * h * comp);
/*     */     } 
/* 183 */     return (nstbi_write_hdr(MemoryUtil.memAddress(filename), w, h, comp, MemoryUtil.memAddress(data)) != 0);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("int")
/*     */   public static boolean stbi_write_hdr(@NativeType("char const *") CharSequence filename, int w, int h, int comp, @NativeType("float const *") FloatBuffer data) {
/* 189 */     if (Checks.CHECKS) {
/* 190 */       Checks.check(data, w * h * comp);
/*     */     }
/* 192 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 194 */       stack.nUTF8(filename, true);
/* 195 */       long filenameEncoded = stack.getPointerAddress();
/* 196 */       return (nstbi_write_hdr(filenameEncoded, w, h, comp, MemoryUtil.memAddress(data)) != 0);
/*     */     } finally {
/* 198 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("int")
/*     */   public static boolean stbi_write_jpg(@NativeType("char const *") ByteBuffer filename, int w, int h, int comp, @NativeType("void const *") ByteBuffer data, int quality) {
/* 210 */     if (Checks.CHECKS) {
/* 211 */       Checks.checkNT1(filename);
/* 212 */       Checks.check(data, w * h * comp);
/*     */     } 
/* 214 */     return (nstbi_write_jpg(MemoryUtil.memAddress(filename), w, h, comp, MemoryUtil.memAddress(data), quality) != 0);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("int")
/*     */   public static boolean stbi_write_jpg(@NativeType("char const *") CharSequence filename, int w, int h, int comp, @NativeType("void const *") ByteBuffer data, int quality) {
/* 220 */     if (Checks.CHECKS) {
/* 221 */       Checks.check(data, w * h * comp);
/*     */     }
/* 223 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 225 */       stack.nUTF8(filename, true);
/* 226 */       long filenameEncoded = stack.getPointerAddress();
/* 227 */       return (nstbi_write_jpg(filenameEncoded, w, h, comp, MemoryUtil.memAddress(data), quality) != 0);
/*     */     } finally {
/* 229 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("int")
/*     */   public static boolean stbi_write_png_to_func(@NativeType("stbi_write_func *") STBIWriteCallbackI func, @NativeType("void *") long context, int w, int h, int comp, @NativeType("void const *") ByteBuffer data, int stride_in_bytes) {
/* 241 */     if (Checks.CHECKS) {
/* 242 */       Checks.check(data, ((stride_in_bytes != 0) ? stride_in_bytes : (w * comp)) * h);
/*     */     }
/* 244 */     return (nstbi_write_png_to_func(func.address(), context, w, h, comp, MemoryUtil.memAddress(data), stride_in_bytes) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("int")
/*     */   public static boolean stbi_write_bmp_to_func(@NativeType("stbi_write_func *") STBIWriteCallbackI func, @NativeType("void *") long context, int w, int h, int comp, @NativeType("void const *") ByteBuffer data) {
/* 255 */     if (Checks.CHECKS) {
/* 256 */       Checks.check(data, w * h * comp);
/*     */     }
/* 258 */     return (nstbi_write_bmp_to_func(func.address(), context, w, h, comp, MemoryUtil.memAddress(data)) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("int")
/*     */   public static boolean stbi_write_tga_to_func(@NativeType("stbi_write_func *") STBIWriteCallbackI func, @NativeType("void *") long context, int w, int h, int comp, @NativeType("void const *") ByteBuffer data) {
/* 269 */     if (Checks.CHECKS) {
/* 270 */       Checks.check(data, w * h * comp);
/*     */     }
/* 272 */     return (nstbi_write_tga_to_func(func.address(), context, w, h, comp, MemoryUtil.memAddress(data)) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("int")
/*     */   public static boolean stbi_write_hdr_to_func(@NativeType("stbi_write_func *") STBIWriteCallbackI func, @NativeType("void *") long context, int w, int h, int comp, @NativeType("float const *") FloatBuffer data) {
/* 283 */     if (Checks.CHECKS) {
/* 284 */       Checks.check(data, w * h * comp);
/*     */     }
/* 286 */     return (nstbi_write_hdr_to_func(func.address(), context, w, h, comp, MemoryUtil.memAddress(data)) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int stbi_write_jpg_to_func(@NativeType("stbi_write_func *") STBIWriteCallbackI func, @NativeType("void *") long context, int w, int h, int comp, @NativeType("void const *") ByteBuffer data, int quality) {
/* 296 */     if (Checks.CHECKS) {
/* 297 */       Checks.check(data, w * h * comp);
/*     */     }
/* 299 */     return nstbi_write_jpg_to_func(func.address(), context, w, h, comp, MemoryUtil.memAddress(data), quality);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void stbi_flip_vertically_on_write(@NativeType("int") boolean flip_boolean) {
/* 309 */     nstbi_flip_vertically_on_write(flip_boolean ? 1 : 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("int")
/*     */   public static boolean stbi_write_hdr(@NativeType("char const *") ByteBuffer filename, int w, int h, int comp, @NativeType("float const *") float[] data) {
/* 318 */     if (Checks.CHECKS) {
/* 319 */       Checks.checkNT1(filename);
/* 320 */       Checks.check(data, w * h * comp);
/*     */     } 
/* 322 */     return (nstbi_write_hdr(MemoryUtil.memAddress(filename), w, h, comp, data) != 0);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("int")
/*     */   public static boolean stbi_write_hdr(@NativeType("char const *") CharSequence filename, int w, int h, int comp, @NativeType("float const *") float[] data) {
/* 328 */     if (Checks.CHECKS) {
/* 329 */       Checks.check(data, w * h * comp);
/*     */     }
/* 331 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 333 */       stack.nUTF8(filename, true);
/* 334 */       long filenameEncoded = stack.getPointerAddress();
/* 335 */       return (nstbi_write_hdr(filenameEncoded, w, h, comp, data) != 0);
/*     */     } finally {
/* 337 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("int")
/*     */   public static boolean stbi_write_hdr_to_func(@NativeType("stbi_write_func *") STBIWriteCallbackI func, @NativeType("void *") long context, int w, int h, int comp, @NativeType("float const *") float[] data) {
/* 347 */     if (Checks.CHECKS) {
/* 348 */       Checks.check(data, w * h * comp);
/*     */     }
/* 350 */     return (nstbi_write_hdr_to_func(func.address(), context, w, h, comp, data) != 0);
/*     */   }
/*     */   
/*     */   public static native int nstbi_write_png(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, int paramInt4);
/*     */   
/*     */   private static native long nstbi_write_png_compression_level();
/*     */   
/*     */   private static native long nstbi_write_force_png_filter();
/*     */   
/*     */   private static native long nstbi_zlib_compress();
/*     */   
/*     */   public static native int nstbi_write_bmp(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2);
/*     */   
/*     */   public static native int nstbi_write_tga(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2);
/*     */   
/*     */   private static native long nstbi_write_tga_with_rle();
/*     */   
/*     */   public static native int nstbi_write_hdr(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2);
/*     */   
/*     */   public static native int nstbi_write_jpg(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, int paramInt4);
/*     */   
/*     */   public static native int nstbi_write_png_to_func(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, long paramLong3, int paramInt4);
/*     */   
/*     */   public static native int nstbi_write_bmp_to_func(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, long paramLong3);
/*     */   
/*     */   public static native int nstbi_write_tga_to_func(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, long paramLong3);
/*     */   
/*     */   public static native int nstbi_write_hdr_to_func(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, long paramLong3);
/*     */   
/*     */   public static native int nstbi_write_jpg_to_func(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, long paramLong3, int paramInt4);
/*     */   
/*     */   public static native void nstbi_flip_vertically_on_write(int paramInt);
/*     */   
/*     */   public static native int nstbi_write_hdr(long paramLong, int paramInt1, int paramInt2, int paramInt3, float[] paramArrayOffloat);
/*     */   
/*     */   public static native int nstbi_write_hdr_to_func(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, float[] paramArrayOffloat);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\stb\STBImageWrite.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */