/*     */ package org.lwjgl.stb;
/*     */ 
/*     */ import java.nio.ByteBuffer;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class STBEasyFont
/*     */ {
/*     */   static {
/*  20 */     LibSTB.initialize();
/*     */   }
/*     */   protected STBEasyFont() {
/*  23 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int stb_easy_font_width(@NativeType("char *") ByteBuffer text) {
/*  33 */     if (Checks.CHECKS) {
/*  34 */       Checks.checkNT1(text);
/*     */     }
/*  36 */     return nstb_easy_font_width(MemoryUtil.memAddress(text));
/*     */   }
/*     */ 
/*     */   
/*     */   public static int stb_easy_font_width(@NativeType("char *") CharSequence text) {
/*  41 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/*  43 */       stack.nASCII(text, true);
/*  44 */       long textEncoded = stack.getPointerAddress();
/*  45 */       return nstb_easy_font_width(textEncoded);
/*     */     } finally {
/*  47 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int stb_easy_font_height(@NativeType("char *") ByteBuffer text) {
/*  58 */     if (Checks.CHECKS) {
/*  59 */       Checks.checkNT1(text);
/*     */     }
/*  61 */     return nstb_easy_font_height(MemoryUtil.memAddress(text));
/*     */   }
/*     */ 
/*     */   
/*     */   public static int stb_easy_font_height(@NativeType("char *") CharSequence text) {
/*  66 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/*  68 */       stack.nASCII(text, true);
/*  69 */       long textEncoded = stack.getPointerAddress();
/*  70 */       return nstb_easy_font_height(textEncoded);
/*     */     } finally {
/*  72 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int stb_easy_font_print(float x, float y, @NativeType("char *") ByteBuffer text, @NativeType("unsigned char *") ByteBuffer color, @NativeType("void *") ByteBuffer vertex_buffer) {
/*  83 */     if (Checks.CHECKS) {
/*  84 */       Checks.checkNT1(text);
/*  85 */       Checks.checkSafe(color, 4);
/*     */     } 
/*  87 */     return nstb_easy_font_print(x, y, MemoryUtil.memAddress(text), MemoryUtil.memAddressSafe(color), MemoryUtil.memAddress(vertex_buffer), vertex_buffer.remaining());
/*     */   }
/*     */ 
/*     */   
/*     */   public static int stb_easy_font_print(float x, float y, @NativeType("char *") CharSequence text, @NativeType("unsigned char *") ByteBuffer color, @NativeType("void *") ByteBuffer vertex_buffer) {
/*  92 */     if (Checks.CHECKS) {
/*  93 */       Checks.checkSafe(color, 4);
/*     */     }
/*  95 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/*  97 */       stack.nASCII(text, true);
/*  98 */       long textEncoded = stack.getPointerAddress();
/*  99 */       return nstb_easy_font_print(x, y, textEncoded, MemoryUtil.memAddressSafe(color), MemoryUtil.memAddress(vertex_buffer), vertex_buffer.remaining());
/*     */     } finally {
/* 101 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static native int nstb_easy_font_width(long paramLong);
/*     */   
/*     */   public static native int nstb_easy_font_height(long paramLong);
/*     */   
/*     */   public static native int nstb_easy_font_print(float paramFloat1, float paramFloat2, long paramLong1, long paramLong2, long paramLong3, int paramInt);
/*     */   
/*     */   public static native void stb_easy_font_spacing(float paramFloat);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\stb\STBEasyFont.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */