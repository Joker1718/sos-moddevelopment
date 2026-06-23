/*     */ package org.lwjgl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.ByteOrder;
/*     */ import java.nio.CharBuffer;
/*     */ import java.nio.DoubleBuffer;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.nio.LongBuffer;
/*     */ import java.nio.ShortBuffer;
/*     */ import org.lwjgl.system.APIUtil;
/*     */ import org.lwjgl.system.CustomBuffer;
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
/*     */ 
/*     */ 
/*     */ public final class BufferUtils
/*     */ {
/*     */   public static ByteBuffer createByteBuffer(int capacity) {
/*  75 */     return ByteBuffer.allocateDirect(capacity).order(ByteOrder.nativeOrder());
/*     */   }
/*     */   
/*     */   static int getAllocationSize(int elements, int elementShift) {
/*  79 */     APIUtil.apiCheckAllocation(elements, APIUtil.apiGetBytes(elements, elementShift), 2147483647L);
/*  80 */     return elements << elementShift;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ShortBuffer createShortBuffer(int capacity) {
/*  91 */     return createByteBuffer(getAllocationSize(capacity, 1)).asShortBuffer();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static CharBuffer createCharBuffer(int capacity) {
/* 102 */     return createByteBuffer(getAllocationSize(capacity, 1)).asCharBuffer();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IntBuffer createIntBuffer(int capacity) {
/* 113 */     return createByteBuffer(getAllocationSize(capacity, 2)).asIntBuffer();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static LongBuffer createLongBuffer(int capacity) {
/* 124 */     return createByteBuffer(getAllocationSize(capacity, 3)).asLongBuffer();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static CLongBuffer createCLongBuffer(int capacity) {
/* 135 */     return CLongBuffer.allocateDirect(capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static FloatBuffer createFloatBuffer(int capacity) {
/* 146 */     return createByteBuffer(getAllocationSize(capacity, 2)).asFloatBuffer();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static DoubleBuffer createDoubleBuffer(int capacity) {
/* 157 */     return createByteBuffer(getAllocationSize(capacity, 3)).asDoubleBuffer();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static PointerBuffer createPointerBuffer(int capacity) {
/* 168 */     return PointerBuffer.allocateDirect(capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void zeroBuffer(ByteBuffer buffer) {
/* 178 */     MemoryUtil.memSet(buffer, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void zeroBuffer(ShortBuffer buffer) {
/* 185 */     MemoryUtil.memSet(buffer, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void zeroBuffer(CharBuffer buffer) {
/* 192 */     MemoryUtil.memSet(buffer, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void zeroBuffer(IntBuffer buffer) {
/* 199 */     MemoryUtil.memSet(buffer, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void zeroBuffer(FloatBuffer buffer) {
/* 206 */     MemoryUtil.memSet(buffer, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void zeroBuffer(LongBuffer buffer) {
/* 213 */     MemoryUtil.memSet(buffer, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void zeroBuffer(DoubleBuffer buffer) {
/* 220 */     MemoryUtil.memSet(buffer, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T extends CustomBuffer<T>> void zeroBuffer(T buffer) {
/* 227 */     MemoryUtil.memSet((CustomBuffer)buffer, 0);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\BufferUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */