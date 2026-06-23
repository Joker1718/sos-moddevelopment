/*     */ package org.lwjgl.system.linux.liburing;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @NativeType("struct io_sqring_offsets")
/*     */ public class IOSQRingOffsets
/*     */   extends Struct<IOSQRingOffsets>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int HEAD;
/*     */   public static final int TAIL;
/*     */   public static final int RING_MASK;
/*     */   public static final int RING_ENTRIES;
/*     */   public static final int FLAGS;
/*     */   public static final int DROPPED;
/*     */   public static final int ARRAY;
/*     */   public static final int RESV1;
/*     */   public static final int USER_ADDR;
/*     */   
/*     */   static {
/*  54 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  55 */           __member(4), 
/*  56 */           __member(4), 
/*  57 */           __member(4), 
/*  58 */           __member(4), 
/*  59 */           __member(4), 
/*  60 */           __member(4), 
/*  61 */           __member(4), 
/*  62 */           __member(4), 
/*  63 */           __member(8)
/*     */         });
/*     */     
/*  66 */     SIZEOF = layout.getSize();
/*  67 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  69 */     HEAD = layout.offsetof(0);
/*  70 */     TAIL = layout.offsetof(1);
/*  71 */     RING_MASK = layout.offsetof(2);
/*  72 */     RING_ENTRIES = layout.offsetof(3);
/*  73 */     FLAGS = layout.offsetof(4);
/*  74 */     DROPPED = layout.offsetof(5);
/*  75 */     ARRAY = layout.offsetof(6);
/*  76 */     RESV1 = layout.offsetof(7);
/*  77 */     USER_ADDR = layout.offsetof(8);
/*     */   }
/*     */   
/*     */   protected IOSQRingOffsets(long address, ByteBuffer container) {
/*  81 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected IOSQRingOffsets create(long address, ByteBuffer container) {
/*  86 */     return new IOSQRingOffsets(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOSQRingOffsets(ByteBuffer container) {
/*  96 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/* 100 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("__u32")
/*     */   public int head() {
/* 104 */     return nhead(address());
/*     */   } @NativeType("__u32")
/*     */   public int tail() {
/* 107 */     return ntail(address());
/*     */   } @NativeType("__u32")
/*     */   public int ring_mask() {
/* 110 */     return nring_mask(address());
/*     */   } @NativeType("__u32")
/*     */   public int ring_entries() {
/* 113 */     return nring_entries(address());
/*     */   } @NativeType("__u32")
/*     */   public int flags() {
/* 116 */     return nflags(address());
/*     */   } @NativeType("__u32")
/*     */   public int dropped() {
/* 119 */     return ndropped(address());
/*     */   } @NativeType("__u32")
/*     */   public int array() {
/* 122 */     return narray(address());
/*     */   } @NativeType("__u64")
/*     */   public long user_addr() {
/* 125 */     return nuser_addr(address());
/*     */   }
/*     */   public IOSQRingOffsets head(@NativeType("__u32") int value) {
/* 128 */     nhead(address(), value); return this;
/*     */   } public IOSQRingOffsets tail(@NativeType("__u32") int value) {
/* 130 */     ntail(address(), value); return this;
/*     */   } public IOSQRingOffsets ring_mask(@NativeType("__u32") int value) {
/* 132 */     nring_mask(address(), value); return this;
/*     */   } public IOSQRingOffsets ring_entries(@NativeType("__u32") int value) {
/* 134 */     nring_entries(address(), value); return this;
/*     */   } public IOSQRingOffsets flags(@NativeType("__u32") int value) {
/* 136 */     nflags(address(), value); return this;
/*     */   } public IOSQRingOffsets dropped(@NativeType("__u32") int value) {
/* 138 */     ndropped(address(), value); return this;
/*     */   } public IOSQRingOffsets array(@NativeType("__u32") int value) {
/* 140 */     narray(address(), value); return this;
/*     */   } public IOSQRingOffsets user_addr(@NativeType("__u64") long value) {
/* 142 */     nuser_addr(address(), value); return this;
/*     */   }
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
/*     */   public IOSQRingOffsets set(int head, int tail, int ring_mask, int ring_entries, int flags, int dropped, int array, long user_addr) {
/* 155 */     head(head);
/* 156 */     tail(tail);
/* 157 */     ring_mask(ring_mask);
/* 158 */     ring_entries(ring_entries);
/* 159 */     flags(flags);
/* 160 */     dropped(dropped);
/* 161 */     array(array);
/* 162 */     user_addr(user_addr);
/*     */     
/* 164 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOSQRingOffsets set(IOSQRingOffsets src) {
/* 175 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 176 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOSQRingOffsets malloc() {
/* 183 */     return new IOSQRingOffsets(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOSQRingOffsets calloc() {
/* 188 */     return new IOSQRingOffsets(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOSQRingOffsets create() {
/* 193 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 194 */     return new IOSQRingOffsets(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOSQRingOffsets create(long address) {
/* 199 */     return new IOSQRingOffsets(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOSQRingOffsets createSafe(long address) {
/* 204 */     return (address == 0L) ? null : new IOSQRingOffsets(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 213 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 222 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 231 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 232 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 242 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 247 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOSQRingOffsets malloc(MemoryStack stack) {
/* 256 */     return new IOSQRingOffsets(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOSQRingOffsets calloc(MemoryStack stack) {
/* 265 */     return new IOSQRingOffsets(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 275 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 285 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nhead(long struct) {
/* 291 */     return MemoryUtil.memGetInt(struct + HEAD);
/*     */   } public static int ntail(long struct) {
/* 293 */     return MemoryUtil.memGetInt(struct + TAIL);
/*     */   } public static int nring_mask(long struct) {
/* 295 */     return MemoryUtil.memGetInt(struct + RING_MASK);
/*     */   } public static int nring_entries(long struct) {
/* 297 */     return MemoryUtil.memGetInt(struct + RING_ENTRIES);
/*     */   } public static int nflags(long struct) {
/* 299 */     return MemoryUtil.memGetInt(struct + FLAGS);
/*     */   } public static int ndropped(long struct) {
/* 301 */     return MemoryUtil.memGetInt(struct + DROPPED);
/*     */   }
/* 303 */   public static int narray(long struct) { return MemoryUtil.memGetInt(struct + ARRAY); } public static int nresv1(long struct) {
/* 304 */     return MemoryUtil.memGetInt(struct + RESV1);
/*     */   } public static long nuser_addr(long struct) {
/* 306 */     return MemoryUtil.memGetLong(struct + USER_ADDR);
/*     */   }
/*     */   public static void nhead(long struct, int value) {
/* 309 */     MemoryUtil.memPutInt(struct + HEAD, value);
/*     */   } public static void ntail(long struct, int value) {
/* 311 */     MemoryUtil.memPutInt(struct + TAIL, value);
/*     */   } public static void nring_mask(long struct, int value) {
/* 313 */     MemoryUtil.memPutInt(struct + RING_MASK, value);
/*     */   } public static void nring_entries(long struct, int value) {
/* 315 */     MemoryUtil.memPutInt(struct + RING_ENTRIES, value);
/*     */   } public static void nflags(long struct, int value) {
/* 317 */     MemoryUtil.memPutInt(struct + FLAGS, value);
/*     */   } public static void ndropped(long struct, int value) {
/* 319 */     MemoryUtil.memPutInt(struct + DROPPED, value);
/*     */   }
/* 321 */   public static void narray(long struct, int value) { MemoryUtil.memPutInt(struct + ARRAY, value); } public static void nresv1(long struct, int value) {
/* 322 */     MemoryUtil.memPutInt(struct + RESV1, value);
/*     */   } public static void nuser_addr(long struct, long value) {
/* 324 */     MemoryUtil.memPutLong(struct + USER_ADDR, value);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<IOSQRingOffsets, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 331 */     private static final IOSQRingOffsets ELEMENT_FACTORY = IOSQRingOffsets.create(-1L);
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
/* 343 */       super(container, container.remaining() / IOSQRingOffsets.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 347 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 351 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 356 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 361 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected IOSQRingOffsets getElementFactory() {
/* 366 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("__u32")
/*     */     public int head() {
/* 371 */       return IOSQRingOffsets.nhead(address());
/*     */     } @NativeType("__u32")
/*     */     public int tail() {
/* 374 */       return IOSQRingOffsets.ntail(address());
/*     */     } @NativeType("__u32")
/*     */     public int ring_mask() {
/* 377 */       return IOSQRingOffsets.nring_mask(address());
/*     */     } @NativeType("__u32")
/*     */     public int ring_entries() {
/* 380 */       return IOSQRingOffsets.nring_entries(address());
/*     */     } @NativeType("__u32")
/*     */     public int flags() {
/* 383 */       return IOSQRingOffsets.nflags(address());
/*     */     } @NativeType("__u32")
/*     */     public int dropped() {
/* 386 */       return IOSQRingOffsets.ndropped(address());
/*     */     } @NativeType("__u32")
/*     */     public int array() {
/* 389 */       return IOSQRingOffsets.narray(address());
/*     */     } @NativeType("__u64")
/*     */     public long user_addr() {
/* 392 */       return IOSQRingOffsets.nuser_addr(address());
/*     */     }
/*     */     public Buffer head(@NativeType("__u32") int value) {
/* 395 */       IOSQRingOffsets.nhead(address(), value); return this;
/*     */     } public Buffer tail(@NativeType("__u32") int value) {
/* 397 */       IOSQRingOffsets.ntail(address(), value); return this;
/*     */     } public Buffer ring_mask(@NativeType("__u32") int value) {
/* 399 */       IOSQRingOffsets.nring_mask(address(), value); return this;
/*     */     } public Buffer ring_entries(@NativeType("__u32") int value) {
/* 401 */       IOSQRingOffsets.nring_entries(address(), value); return this;
/*     */     } public Buffer flags(@NativeType("__u32") int value) {
/* 403 */       IOSQRingOffsets.nflags(address(), value); return this;
/*     */     } public Buffer dropped(@NativeType("__u32") int value) {
/* 405 */       IOSQRingOffsets.ndropped(address(), value); return this;
/*     */     } public Buffer array(@NativeType("__u32") int value) {
/* 407 */       IOSQRingOffsets.narray(address(), value); return this;
/*     */     } public Buffer user_addr(@NativeType("__u64") long value) {
/* 409 */       IOSQRingOffsets.nuser_addr(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\liburing\IOSQRingOffsets.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */