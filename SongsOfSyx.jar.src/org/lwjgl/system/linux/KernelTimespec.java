/*     */ package org.lwjgl.system.linux;
/*     */ 
/*     */ import java.nio.ByteBuffer;
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
/*     */ @NativeType("struct __kernel_timespec")
/*     */ public class KernelTimespec
/*     */   extends Struct<KernelTimespec>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int TV_SEC;
/*     */   public static final int TV_NSEC;
/*     */   
/*     */   static {
/*  40 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  41 */           __member(8), 
/*  42 */           __member(8)
/*     */         });
/*     */     
/*  45 */     SIZEOF = layout.getSize();
/*  46 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  48 */     TV_SEC = layout.offsetof(0);
/*  49 */     TV_NSEC = layout.offsetof(1);
/*     */   }
/*     */   
/*     */   protected KernelTimespec(long address, ByteBuffer container) {
/*  53 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected KernelTimespec create(long address, ByteBuffer container) {
/*  58 */     return new KernelTimespec(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public KernelTimespec(ByteBuffer container) {
/*  68 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  72 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("int64_t")
/*     */   public long tv_sec() {
/*  76 */     return ntv_sec(address());
/*     */   } @NativeType("long long")
/*     */   public long tv_nsec() {
/*  79 */     return ntv_nsec(address());
/*     */   }
/*     */   public KernelTimespec tv_sec(@NativeType("int64_t") long value) {
/*  82 */     ntv_sec(address(), value); return this;
/*     */   } public KernelTimespec tv_nsec(@NativeType("long long") long value) {
/*  84 */     ntv_nsec(address(), value); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public KernelTimespec set(long tv_sec, long tv_nsec) {
/*  91 */     tv_sec(tv_sec);
/*  92 */     tv_nsec(tv_nsec);
/*     */     
/*  94 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public KernelTimespec set(KernelTimespec src) {
/* 105 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 106 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static KernelTimespec malloc() {
/* 113 */     return new KernelTimespec(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static KernelTimespec calloc() {
/* 118 */     return new KernelTimespec(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static KernelTimespec create() {
/* 123 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 124 */     return new KernelTimespec(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static KernelTimespec create(long address) {
/* 129 */     return new KernelTimespec(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static KernelTimespec createSafe(long address) {
/* 134 */     return (address == 0L) ? null : new KernelTimespec(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 143 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 152 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 161 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 162 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 172 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 177 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static KernelTimespec malloc(MemoryStack stack) {
/* 186 */     return new KernelTimespec(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static KernelTimespec calloc(MemoryStack stack) {
/* 195 */     return new KernelTimespec(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 205 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 215 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static long ntv_sec(long struct) {
/* 221 */     return MemoryUtil.memGetLong(struct + TV_SEC);
/*     */   } public static long ntv_nsec(long struct) {
/* 223 */     return MemoryUtil.memGetLong(struct + TV_NSEC);
/*     */   }
/*     */   public static void ntv_sec(long struct, long value) {
/* 226 */     MemoryUtil.memPutLong(struct + TV_SEC, value);
/*     */   } public static void ntv_nsec(long struct, long value) {
/* 228 */     MemoryUtil.memPutLong(struct + TV_NSEC, value);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<KernelTimespec, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 235 */     private static final KernelTimespec ELEMENT_FACTORY = KernelTimespec.create(-1L);
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
/* 247 */       super(container, container.remaining() / KernelTimespec.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 251 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 255 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 260 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 265 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected KernelTimespec getElementFactory() {
/* 270 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("int64_t")
/*     */     public long tv_sec() {
/* 275 */       return KernelTimespec.ntv_sec(address());
/*     */     } @NativeType("long long")
/*     */     public long tv_nsec() {
/* 278 */       return KernelTimespec.ntv_nsec(address());
/*     */     }
/*     */     public Buffer tv_sec(@NativeType("int64_t") long value) {
/* 281 */       KernelTimespec.ntv_sec(address(), value); return this;
/*     */     } public Buffer tv_nsec(@NativeType("long long") long value) {
/* 283 */       KernelTimespec.ntv_nsec(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\KernelTimespec.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */