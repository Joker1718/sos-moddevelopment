/*     */ package org.lwjgl.system.libffi;
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
/*     */ @NativeType("struct ffi_closure")
/*     */ public class FFIClosure
/*     */   extends Struct<FFIClosure>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int CIF;
/*     */   public static final int FUN;
/*     */   public static final int USER_DATA;
/*     */   
/*     */   static {
/*  42 */     try (MemoryStack stack = MemoryStack.stackPush()) {
/*  43 */       IntBuffer offsets = stack.mallocInt(4);
/*  44 */       SIZEOF = offsets(MemoryUtil.memAddress(offsets));
/*     */       
/*  46 */       CIF = offsets.get(0);
/*  47 */       FUN = offsets.get(1);
/*  48 */       USER_DATA = offsets.get(2);
/*     */       
/*  50 */       ALIGNOF = offsets.get(3);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected FFIClosure(long address, ByteBuffer container) {
/*  57 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected FFIClosure create(long address, ByteBuffer container) {
/*  62 */     return new FFIClosure(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FFIClosure(ByteBuffer container) {
/*  72 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  76 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("ffi_cif *")
/*     */   public FFICIF cif() {
/*  80 */     return ncif(address());
/*     */   } @NativeType("void (*)(ffi_cif*,void*,void**,void*)")
/*     */   public long fun() {
/*  83 */     return nfun(address());
/*     */   } @NativeType("void *")
/*     */   public long user_data() {
/*  86 */     return nuser_data(address());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static FFIClosure malloc() {
/*  92 */     return new FFIClosure(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static FFIClosure calloc() {
/*  97 */     return new FFIClosure(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static FFIClosure create() {
/* 102 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 103 */     return new FFIClosure(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static FFIClosure create(long address) {
/* 108 */     return new FFIClosure(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static FFIClosure createSafe(long address) {
/* 113 */     return (address == 0L) ? null : new FFIClosure(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 122 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 131 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 140 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 141 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 151 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 156 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static FFIClosure malloc(MemoryStack stack) {
/* 165 */     return new FFIClosure(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static FFIClosure calloc(MemoryStack stack) {
/* 174 */     return new FFIClosure(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 184 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 194 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static FFICIF ncif(long struct) {
/* 200 */     return FFICIF.create(MemoryUtil.memGetAddress(struct + CIF));
/*     */   } public static long nfun(long struct) {
/* 202 */     return MemoryUtil.memGetAddress(struct + FUN);
/*     */   } public static long nuser_data(long struct) {
/* 204 */     return MemoryUtil.memGetAddress(struct + USER_DATA);
/*     */   }
/*     */   
/*     */   private static native int offsets(long paramLong);
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<FFIClosure, Buffer> implements NativeResource {
/* 211 */     private static final FFIClosure ELEMENT_FACTORY = FFIClosure.create(-1L);
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
/* 223 */       super(container, container.remaining() / FFIClosure.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 227 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 231 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 236 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 241 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected FFIClosure getElementFactory() {
/* 246 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("ffi_cif *")
/*     */     public FFICIF cif() {
/* 251 */       return FFIClosure.ncif(address());
/*     */     } @NativeType("void (*)(ffi_cif*,void*,void**,void*)")
/*     */     public long fun() {
/* 254 */       return FFIClosure.nfun(address());
/*     */     } @NativeType("void *")
/*     */     public long user_data() {
/* 257 */       return FFIClosure.nuser_data(address());
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\libffi\FFIClosure.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */