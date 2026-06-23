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
/*     */ 
/*     */ @NativeType("struct statx_timestamp")
/*     */ public class StatxTimestamp
/*     */   extends Struct<StatxTimestamp>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int TV_SEC;
/*     */   public static final int TV_NSEC;
/*     */   public static final int __RESERVED;
/*     */   
/*     */   static {
/*  42 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  43 */           __member(8), 
/*  44 */           __member(4), 
/*  45 */           __member(4)
/*     */         });
/*     */     
/*  48 */     SIZEOF = layout.getSize();
/*  49 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  51 */     TV_SEC = layout.offsetof(0);
/*  52 */     TV_NSEC = layout.offsetof(1);
/*  53 */     __RESERVED = layout.offsetof(2);
/*     */   }
/*     */   
/*     */   protected StatxTimestamp(long address, ByteBuffer container) {
/*  57 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected StatxTimestamp create(long address, ByteBuffer container) {
/*  62 */     return new StatxTimestamp(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public StatxTimestamp(ByteBuffer container) {
/*  72 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  76 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("__s64")
/*     */   public long tv_sec() {
/*  80 */     return ntv_sec(address());
/*     */   } @NativeType("__u32")
/*     */   public int tv_nsec() {
/*  83 */     return ntv_nsec(address());
/*     */   }
/*     */   public StatxTimestamp tv_sec(@NativeType("__s64") long value) {
/*  86 */     ntv_sec(address(), value); return this;
/*     */   } public StatxTimestamp tv_nsec(@NativeType("__u32") int value) {
/*  88 */     ntv_nsec(address(), value); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public StatxTimestamp set(long tv_sec, int tv_nsec) {
/*  95 */     tv_sec(tv_sec);
/*  96 */     tv_nsec(tv_nsec);
/*     */     
/*  98 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public StatxTimestamp set(StatxTimestamp src) {
/* 109 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 110 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static StatxTimestamp malloc() {
/* 117 */     return new StatxTimestamp(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static StatxTimestamp calloc() {
/* 122 */     return new StatxTimestamp(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static StatxTimestamp create() {
/* 127 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 128 */     return new StatxTimestamp(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static StatxTimestamp create(long address) {
/* 133 */     return new StatxTimestamp(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static StatxTimestamp createSafe(long address) {
/* 138 */     return (address == 0L) ? null : new StatxTimestamp(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 147 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 156 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 165 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 166 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 176 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 181 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static StatxTimestamp malloc(MemoryStack stack) {
/* 190 */     return new StatxTimestamp(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static StatxTimestamp calloc(MemoryStack stack) {
/* 199 */     return new StatxTimestamp(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 209 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 219 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static long ntv_sec(long struct) {
/* 225 */     return MemoryUtil.memGetLong(struct + TV_SEC);
/*     */   }
/* 227 */   public static int ntv_nsec(long struct) { return MemoryUtil.memGetInt(struct + TV_NSEC); } public static int n__reserved(long struct) {
/* 228 */     return MemoryUtil.memGetInt(struct + __RESERVED);
/*     */   }
/*     */   public static void ntv_sec(long struct, long value) {
/* 231 */     MemoryUtil.memPutLong(struct + TV_SEC, value);
/*     */   }
/* 233 */   public static void ntv_nsec(long struct, int value) { MemoryUtil.memPutInt(struct + TV_NSEC, value); } public static void n__reserved(long struct, int value) {
/* 234 */     MemoryUtil.memPutInt(struct + __RESERVED, value);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<StatxTimestamp, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 241 */     private static final StatxTimestamp ELEMENT_FACTORY = StatxTimestamp.create(-1L);
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
/* 253 */       super(container, container.remaining() / StatxTimestamp.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 257 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 261 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 266 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 271 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected StatxTimestamp getElementFactory() {
/* 276 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("__s64")
/*     */     public long tv_sec() {
/* 281 */       return StatxTimestamp.ntv_sec(address());
/*     */     } @NativeType("__u32")
/*     */     public int tv_nsec() {
/* 284 */       return StatxTimestamp.ntv_nsec(address());
/*     */     }
/*     */     public Buffer tv_sec(@NativeType("__s64") long value) {
/* 287 */       StatxTimestamp.ntv_sec(address(), value); return this;
/*     */     } public Buffer tv_nsec(@NativeType("__u32") int value) {
/* 289 */       StatxTimestamp.ntv_nsec(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\StatxTimestamp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */