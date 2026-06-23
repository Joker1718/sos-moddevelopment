/*     */ package org.lwjgl.stb;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import org.lwjgl.BufferUtils;
/*     */ import org.lwjgl.system.CustomBuffer;
/*     */ import org.lwjgl.system.MemoryStack;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeResource;
/*     */ import org.lwjgl.system.NativeType;
/*     */ import org.lwjgl.system.Struct;
/*     */ import org.lwjgl.system.StructBuffer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @NativeType("struct stbtt_fontinfo")
/*     */ public class STBTTFontinfo
/*     */   extends Struct<STBTTFontinfo>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   
/*     */   static {
/*  28 */     LibSTB.initialize();
/*     */     
/*  30 */     try (MemoryStack stack = MemoryStack.stackPush()) {
/*  31 */       IntBuffer offsets = stack.mallocInt(1);
/*  32 */       SIZEOF = offsets(MemoryUtil.memAddress(offsets));
/*  33 */       ALIGNOF = offsets.get(0);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected STBTTFontinfo(long address, ByteBuffer container) {
/*  40 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected STBTTFontinfo create(long address, ByteBuffer container) {
/*  45 */     return new STBTTFontinfo(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public STBTTFontinfo(ByteBuffer container) {
/*  55 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  59 */     return SIZEOF;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBTTFontinfo malloc() {
/*  65 */     return new STBTTFontinfo(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBTTFontinfo calloc() {
/*  70 */     return new STBTTFontinfo(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBTTFontinfo create() {
/*  75 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/*  76 */     return new STBTTFontinfo(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBTTFontinfo create(long address) {
/*  81 */     return new STBTTFontinfo(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBTTFontinfo createSafe(long address) {
/*  86 */     return (address == 0L) ? null : new STBTTFontinfo(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/*  95 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 104 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 113 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 114 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 124 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 129 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBTTFontinfo malloc(MemoryStack stack) {
/* 138 */     return new STBTTFontinfo(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBTTFontinfo calloc(MemoryStack stack) {
/* 147 */     return new STBTTFontinfo(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 157 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 167 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   private static native int offsets(long paramLong);
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<STBTTFontinfo, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 177 */     private static final STBTTFontinfo ELEMENT_FACTORY = STBTTFontinfo.create(-1L);
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
/*     */     public Buffer(ByteBuffer container) {
/* 189 */       super(container, container.remaining() / STBTTFontinfo.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 193 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 197 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 202 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 207 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected STBTTFontinfo getElementFactory() {
/* 212 */       return ELEMENT_FACTORY;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\stb\STBTTFontinfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */