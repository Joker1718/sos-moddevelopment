/*     */ package org.lwjgl.system.linux.liburing;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.LongBuffer;
/*     */ import org.lwjgl.BufferUtils;
/*     */ import org.lwjgl.system.Checks;
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
/*     */ 
/*     */ 
/*     */ @NativeType("struct io_uring_region_desc")
/*     */ public class IOUringRegionDesc
/*     */   extends Struct<IOUringRegionDesc>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int USER_ADDR;
/*     */   public static final int SIZE;
/*     */   public static final int FLAGS;
/*     */   public static final int ID;
/*     */   public static final int MMAP_OFFSET;
/*     */   public static final int __RESV;
/*     */   
/*     */   static {
/*  49 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  50 */           __member(8), 
/*  51 */           __member(8), 
/*  52 */           __member(4), 
/*  53 */           __member(4), 
/*  54 */           __member(8), 
/*  55 */           __array(8, 4)
/*     */         });
/*     */     
/*  58 */     SIZEOF = layout.getSize();
/*  59 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  61 */     USER_ADDR = layout.offsetof(0);
/*  62 */     SIZE = layout.offsetof(1);
/*  63 */     FLAGS = layout.offsetof(2);
/*  64 */     ID = layout.offsetof(3);
/*  65 */     MMAP_OFFSET = layout.offsetof(4);
/*  66 */     __RESV = layout.offsetof(5);
/*     */   }
/*     */   
/*     */   protected IOUringRegionDesc(long address, ByteBuffer container) {
/*  70 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected IOUringRegionDesc create(long address, ByteBuffer container) {
/*  75 */     return new IOUringRegionDesc(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOUringRegionDesc(ByteBuffer container) {
/*  85 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  89 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("__u64")
/*     */   public long user_addr() {
/*  93 */     return nuser_addr(address());
/*     */   } @NativeType("__u64")
/*     */   public long size() {
/*  96 */     return nsize(address());
/*     */   } @NativeType("__u32")
/*     */   public int flags() {
/*  99 */     return nflags(address());
/*     */   } @NativeType("__u32")
/*     */   public int id() {
/* 102 */     return nid(address());
/*     */   } @NativeType("__u64")
/*     */   public long mmap_offset() {
/* 105 */     return nmmap_offset(address());
/*     */   }
/*     */   public IOUringRegionDesc user_addr(@NativeType("__u64") long value) {
/* 108 */     nuser_addr(address(), value); return this;
/*     */   } public IOUringRegionDesc size(@NativeType("__u64") long value) {
/* 110 */     nsize(address(), value); return this;
/*     */   } public IOUringRegionDesc flags(@NativeType("__u32") int value) {
/* 112 */     nflags(address(), value); return this;
/*     */   } public IOUringRegionDesc id(@NativeType("__u32") int value) {
/* 114 */     nid(address(), value); return this;
/*     */   } public IOUringRegionDesc mmap_offset(@NativeType("__u64") long value) {
/* 116 */     nmmap_offset(address(), value); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOUringRegionDesc set(long user_addr, long size, int flags, int id, long mmap_offset) {
/* 126 */     user_addr(user_addr);
/* 127 */     size(size);
/* 128 */     flags(flags);
/* 129 */     id(id);
/* 130 */     mmap_offset(mmap_offset);
/*     */     
/* 132 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOUringRegionDesc set(IOUringRegionDesc src) {
/* 143 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 144 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOUringRegionDesc malloc() {
/* 151 */     return new IOUringRegionDesc(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOUringRegionDesc calloc() {
/* 156 */     return new IOUringRegionDesc(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOUringRegionDesc create() {
/* 161 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 162 */     return new IOUringRegionDesc(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOUringRegionDesc create(long address) {
/* 167 */     return new IOUringRegionDesc(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOUringRegionDesc createSafe(long address) {
/* 172 */     return (address == 0L) ? null : new IOUringRegionDesc(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 181 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 190 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 199 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 200 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 210 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 215 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOUringRegionDesc malloc(MemoryStack stack) {
/* 224 */     return new IOUringRegionDesc(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOUringRegionDesc calloc(MemoryStack stack) {
/* 233 */     return new IOUringRegionDesc(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 243 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 253 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nuser_addr(long struct) {
/* 259 */     return MemoryUtil.memGetLong(struct + USER_ADDR);
/*     */   } public static long nsize(long struct) {
/* 261 */     return MemoryUtil.memGetLong(struct + SIZE);
/*     */   } public static int nflags(long struct) {
/* 263 */     return MemoryUtil.memGetInt(struct + FLAGS);
/*     */   } public static int nid(long struct) {
/* 265 */     return MemoryUtil.memGetInt(struct + ID);
/*     */   }
/* 267 */   public static long nmmap_offset(long struct) { return MemoryUtil.memGetLong(struct + MMAP_OFFSET); } public static LongBuffer n__resv(long struct) {
/* 268 */     return MemoryUtil.memLongBuffer(struct + __RESV, 4);
/*     */   } public static long n__resv(long struct, int index) {
/* 270 */     return MemoryUtil.memGetLong(struct + __RESV + Checks.check(index, 4) * 8L);
/*     */   }
/*     */   
/*     */   public static void nuser_addr(long struct, long value) {
/* 274 */     MemoryUtil.memPutLong(struct + USER_ADDR, value);
/*     */   } public static void nsize(long struct, long value) {
/* 276 */     MemoryUtil.memPutLong(struct + SIZE, value);
/*     */   } public static void nflags(long struct, int value) {
/* 278 */     MemoryUtil.memPutInt(struct + FLAGS, value);
/*     */   } public static void nid(long struct, int value) {
/* 280 */     MemoryUtil.memPutInt(struct + ID, value);
/*     */   } public static void nmmap_offset(long struct, long value) {
/* 282 */     MemoryUtil.memPutLong(struct + MMAP_OFFSET, value);
/*     */   } public static void n__resv(long struct, LongBuffer value) {
/* 284 */     if (Checks.CHECKS) Checks.checkGT(value, 4); 
/* 285 */     MemoryUtil.memCopy(MemoryUtil.memAddress(value), struct + __RESV, (value.remaining() * 8));
/*     */   }
/*     */   public static void n__resv(long struct, int index, long value) {
/* 288 */     MemoryUtil.memPutLong(struct + __RESV + Checks.check(index, 4) * 8L, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<IOUringRegionDesc, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 296 */     private static final IOUringRegionDesc ELEMENT_FACTORY = IOUringRegionDesc.create(-1L);
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
/* 308 */       super(container, container.remaining() / IOUringRegionDesc.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 312 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 316 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 321 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 326 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected IOUringRegionDesc getElementFactory() {
/* 331 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("__u64")
/*     */     public long user_addr() {
/* 336 */       return IOUringRegionDesc.nuser_addr(address());
/*     */     } @NativeType("__u64")
/*     */     public long size() {
/* 339 */       return IOUringRegionDesc.nsize(address());
/*     */     } @NativeType("__u32")
/*     */     public int flags() {
/* 342 */       return IOUringRegionDesc.nflags(address());
/*     */     } @NativeType("__u32")
/*     */     public int id() {
/* 345 */       return IOUringRegionDesc.nid(address());
/*     */     } @NativeType("__u64")
/*     */     public long mmap_offset() {
/* 348 */       return IOUringRegionDesc.nmmap_offset(address());
/*     */     }
/*     */     public Buffer user_addr(@NativeType("__u64") long value) {
/* 351 */       IOUringRegionDesc.nuser_addr(address(), value); return this;
/*     */     } public Buffer size(@NativeType("__u64") long value) {
/* 353 */       IOUringRegionDesc.nsize(address(), value); return this;
/*     */     } public Buffer flags(@NativeType("__u32") int value) {
/* 355 */       IOUringRegionDesc.nflags(address(), value); return this;
/*     */     } public Buffer id(@NativeType("__u32") int value) {
/* 357 */       IOUringRegionDesc.nid(address(), value); return this;
/*     */     } public Buffer mmap_offset(@NativeType("__u64") long value) {
/* 359 */       IOUringRegionDesc.nmmap_offset(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\liburing\IOUringRegionDesc.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */