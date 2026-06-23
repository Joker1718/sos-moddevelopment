/*     */ package org.lwjgl.system.linux.liburing;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.IntBuffer;
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
/*     */ @NativeType("struct io_uring_query_hdr")
/*     */ public class IOURingQueryHdr
/*     */   extends Struct<IOURingQueryHdr>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int NEXT_ENTRY;
/*     */   public static final int QUERY_DATA;
/*     */   public static final int QUERY_OP;
/*     */   public static final int SIZE;
/*     */   public static final int RESULT;
/*     */   public static final int __RESV;
/*     */   
/*     */   static {
/*  49 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  50 */           __member(8), 
/*  51 */           __member(8), 
/*  52 */           __member(4), 
/*  53 */           __member(4), 
/*  54 */           __member(4), 
/*  55 */           __array(4, 3)
/*     */         });
/*     */     
/*  58 */     SIZEOF = layout.getSize();
/*  59 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  61 */     NEXT_ENTRY = layout.offsetof(0);
/*  62 */     QUERY_DATA = layout.offsetof(1);
/*  63 */     QUERY_OP = layout.offsetof(2);
/*  64 */     SIZE = layout.offsetof(3);
/*  65 */     RESULT = layout.offsetof(4);
/*  66 */     __RESV = layout.offsetof(5);
/*     */   }
/*     */   
/*     */   protected IOURingQueryHdr(long address, ByteBuffer container) {
/*  70 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected IOURingQueryHdr create(long address, ByteBuffer container) {
/*  75 */     return new IOURingQueryHdr(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingQueryHdr(ByteBuffer container) {
/*  85 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  89 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("__u64")
/*     */   public long next_entry() {
/*  93 */     return nnext_entry(address());
/*     */   } @NativeType("__u64")
/*     */   public long query_data() {
/*  96 */     return nquery_data(address());
/*     */   } @NativeType("__u32")
/*     */   public int query_op() {
/*  99 */     return nquery_op(address());
/*     */   } @NativeType("__u32")
/*     */   public int size() {
/* 102 */     return nsize(address());
/*     */   } @NativeType("__s32")
/*     */   public int result() {
/* 105 */     return nresult(address());
/*     */   }
/*     */   public IOURingQueryHdr next_entry(@NativeType("__u64") long value) {
/* 108 */     nnext_entry(address(), value); return this;
/*     */   } public IOURingQueryHdr query_data(@NativeType("__u64") long value) {
/* 110 */     nquery_data(address(), value); return this;
/*     */   } public IOURingQueryHdr query_op(@NativeType("__u32") int value) {
/* 112 */     nquery_op(address(), value); return this;
/*     */   } public IOURingQueryHdr size(@NativeType("__u32") int value) {
/* 114 */     nsize(address(), value); return this;
/*     */   } public IOURingQueryHdr result(@NativeType("__s32") int value) {
/* 116 */     nresult(address(), value); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingQueryHdr set(long next_entry, long query_data, int query_op, int size, int result) {
/* 126 */     next_entry(next_entry);
/* 127 */     query_data(query_data);
/* 128 */     query_op(query_op);
/* 129 */     size(size);
/* 130 */     result(result);
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
/*     */   public IOURingQueryHdr set(IOURingQueryHdr src) {
/* 143 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 144 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingQueryHdr malloc() {
/* 151 */     return new IOURingQueryHdr(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingQueryHdr calloc() {
/* 156 */     return new IOURingQueryHdr(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingQueryHdr create() {
/* 161 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 162 */     return new IOURingQueryHdr(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingQueryHdr create(long address) {
/* 167 */     return new IOURingQueryHdr(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingQueryHdr createSafe(long address) {
/* 172 */     return (address == 0L) ? null : new IOURingQueryHdr(address, null);
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
/*     */   public static IOURingQueryHdr malloc(MemoryStack stack) {
/* 224 */     return new IOURingQueryHdr(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingQueryHdr calloc(MemoryStack stack) {
/* 233 */     return new IOURingQueryHdr(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
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
/*     */   public static long nnext_entry(long struct) {
/* 259 */     return MemoryUtil.memGetLong(struct + NEXT_ENTRY);
/*     */   } public static long nquery_data(long struct) {
/* 261 */     return MemoryUtil.memGetLong(struct + QUERY_DATA);
/*     */   } public static int nquery_op(long struct) {
/* 263 */     return MemoryUtil.memGetInt(struct + QUERY_OP);
/*     */   } public static int nsize(long struct) {
/* 265 */     return MemoryUtil.memGetInt(struct + SIZE);
/*     */   }
/* 267 */   public static int nresult(long struct) { return MemoryUtil.memGetInt(struct + RESULT); } public static IntBuffer n__resv(long struct) {
/* 268 */     return MemoryUtil.memIntBuffer(struct + __RESV, 3);
/*     */   } public static int n__resv(long struct, int index) {
/* 270 */     return MemoryUtil.memGetInt(struct + __RESV + Checks.check(index, 3) * 4L);
/*     */   }
/*     */   
/*     */   public static void nnext_entry(long struct, long value) {
/* 274 */     MemoryUtil.memPutLong(struct + NEXT_ENTRY, value);
/*     */   } public static void nquery_data(long struct, long value) {
/* 276 */     MemoryUtil.memPutLong(struct + QUERY_DATA, value);
/*     */   } public static void nquery_op(long struct, int value) {
/* 278 */     MemoryUtil.memPutInt(struct + QUERY_OP, value);
/*     */   } public static void nsize(long struct, int value) {
/* 280 */     MemoryUtil.memPutInt(struct + SIZE, value);
/*     */   } public static void nresult(long struct, int value) {
/* 282 */     MemoryUtil.memPutInt(struct + RESULT, value);
/*     */   } public static void n__resv(long struct, IntBuffer value) {
/* 284 */     if (Checks.CHECKS) Checks.checkGT(value, 3); 
/* 285 */     MemoryUtil.memCopy(MemoryUtil.memAddress(value), struct + __RESV, (value.remaining() * 4));
/*     */   }
/*     */   public static void n__resv(long struct, int index, int value) {
/* 288 */     MemoryUtil.memPutInt(struct + __RESV + Checks.check(index, 3) * 4L, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<IOURingQueryHdr, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 296 */     private static final IOURingQueryHdr ELEMENT_FACTORY = IOURingQueryHdr.create(-1L);
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
/* 308 */       super(container, container.remaining() / IOURingQueryHdr.SIZEOF);
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
/*     */     protected IOURingQueryHdr getElementFactory() {
/* 331 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("__u64")
/*     */     public long next_entry() {
/* 336 */       return IOURingQueryHdr.nnext_entry(address());
/*     */     } @NativeType("__u64")
/*     */     public long query_data() {
/* 339 */       return IOURingQueryHdr.nquery_data(address());
/*     */     } @NativeType("__u32")
/*     */     public int query_op() {
/* 342 */       return IOURingQueryHdr.nquery_op(address());
/*     */     } @NativeType("__u32")
/*     */     public int size() {
/* 345 */       return IOURingQueryHdr.nsize(address());
/*     */     } @NativeType("__s32")
/*     */     public int result() {
/* 348 */       return IOURingQueryHdr.nresult(address());
/*     */     }
/*     */     public Buffer next_entry(@NativeType("__u64") long value) {
/* 351 */       IOURingQueryHdr.nnext_entry(address(), value); return this;
/*     */     } public Buffer query_data(@NativeType("__u64") long value) {
/* 353 */       IOURingQueryHdr.nquery_data(address(), value); return this;
/*     */     } public Buffer query_op(@NativeType("__u32") int value) {
/* 355 */       IOURingQueryHdr.nquery_op(address(), value); return this;
/*     */     } public Buffer size(@NativeType("__u32") int value) {
/* 357 */       IOURingQueryHdr.nsize(address(), value); return this;
/*     */     } public Buffer result(@NativeType("__s32") int value) {
/* 359 */       IOURingQueryHdr.nresult(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\liburing\IOURingQueryHdr.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */