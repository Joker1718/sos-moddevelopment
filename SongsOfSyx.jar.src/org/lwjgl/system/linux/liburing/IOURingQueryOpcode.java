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
/*     */ @NativeType("struct io_uring_query_opcode")
/*     */ public class IOURingQueryOpcode
/*     */   extends Struct<IOURingQueryOpcode>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int NR_REQUEST_OPCODES;
/*     */   public static final int NR_REGISTER_OPCODES;
/*     */   public static final int FEATURE_FLAGS;
/*     */   public static final int RING_SETUP_FLAGS;
/*     */   public static final int ENTER_FLAGS;
/*     */   public static final int SQE_FLAGS;
/*     */   
/*     */   static {
/*  48 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  49 */           __member(4), 
/*  50 */           __member(4), 
/*  51 */           __member(8), 
/*  52 */           __member(8), 
/*  53 */           __member(8), 
/*  54 */           __member(8)
/*     */         });
/*     */     
/*  57 */     SIZEOF = layout.getSize();
/*  58 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  60 */     NR_REQUEST_OPCODES = layout.offsetof(0);
/*  61 */     NR_REGISTER_OPCODES = layout.offsetof(1);
/*  62 */     FEATURE_FLAGS = layout.offsetof(2);
/*  63 */     RING_SETUP_FLAGS = layout.offsetof(3);
/*  64 */     ENTER_FLAGS = layout.offsetof(4);
/*  65 */     SQE_FLAGS = layout.offsetof(5);
/*     */   }
/*     */   
/*     */   protected IOURingQueryOpcode(long address, ByteBuffer container) {
/*  69 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected IOURingQueryOpcode create(long address, ByteBuffer container) {
/*  74 */     return new IOURingQueryOpcode(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingQueryOpcode(ByteBuffer container) {
/*  84 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  88 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("__u32")
/*     */   public int nr_request_opcodes() {
/*  92 */     return nnr_request_opcodes(address());
/*     */   } @NativeType("__u32")
/*     */   public int nr_register_opcodes() {
/*  95 */     return nnr_register_opcodes(address());
/*     */   } @NativeType("__u64")
/*     */   public long feature_flags() {
/*  98 */     return nfeature_flags(address());
/*     */   } @NativeType("__u64")
/*     */   public long ring_setup_flags() {
/* 101 */     return nring_setup_flags(address());
/*     */   } @NativeType("__u64")
/*     */   public long enter_flags() {
/* 104 */     return nenter_flags(address());
/*     */   } @NativeType("__u64")
/*     */   public long sqe_flags() {
/* 107 */     return nsqe_flags(address());
/*     */   }
/*     */   public IOURingQueryOpcode nr_request_opcodes(@NativeType("__u32") int value) {
/* 110 */     nnr_request_opcodes(address(), value); return this;
/*     */   } public IOURingQueryOpcode nr_register_opcodes(@NativeType("__u32") int value) {
/* 112 */     nnr_register_opcodes(address(), value); return this;
/*     */   } public IOURingQueryOpcode feature_flags(@NativeType("__u64") long value) {
/* 114 */     nfeature_flags(address(), value); return this;
/*     */   } public IOURingQueryOpcode ring_setup_flags(@NativeType("__u64") long value) {
/* 116 */     nring_setup_flags(address(), value); return this;
/*     */   } public IOURingQueryOpcode enter_flags(@NativeType("__u64") long value) {
/* 118 */     nenter_flags(address(), value); return this;
/*     */   } public IOURingQueryOpcode sqe_flags(@NativeType("__u64") long value) {
/* 120 */     nsqe_flags(address(), value); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingQueryOpcode set(int nr_request_opcodes, int nr_register_opcodes, long feature_flags, long ring_setup_flags, long enter_flags, long sqe_flags) {
/* 131 */     nr_request_opcodes(nr_request_opcodes);
/* 132 */     nr_register_opcodes(nr_register_opcodes);
/* 133 */     feature_flags(feature_flags);
/* 134 */     ring_setup_flags(ring_setup_flags);
/* 135 */     enter_flags(enter_flags);
/* 136 */     sqe_flags(sqe_flags);
/*     */     
/* 138 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingQueryOpcode set(IOURingQueryOpcode src) {
/* 149 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 150 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingQueryOpcode malloc() {
/* 157 */     return new IOURingQueryOpcode(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingQueryOpcode calloc() {
/* 162 */     return new IOURingQueryOpcode(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingQueryOpcode create() {
/* 167 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 168 */     return new IOURingQueryOpcode(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingQueryOpcode create(long address) {
/* 173 */     return new IOURingQueryOpcode(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingQueryOpcode createSafe(long address) {
/* 178 */     return (address == 0L) ? null : new IOURingQueryOpcode(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 187 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 196 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 205 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 206 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 216 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 221 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingQueryOpcode malloc(MemoryStack stack) {
/* 230 */     return new IOURingQueryOpcode(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingQueryOpcode calloc(MemoryStack stack) {
/* 239 */     return new IOURingQueryOpcode(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 249 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 259 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nnr_request_opcodes(long struct) {
/* 265 */     return MemoryUtil.memGetInt(struct + NR_REQUEST_OPCODES);
/*     */   } public static int nnr_register_opcodes(long struct) {
/* 267 */     return MemoryUtil.memGetInt(struct + NR_REGISTER_OPCODES);
/*     */   } public static long nfeature_flags(long struct) {
/* 269 */     return MemoryUtil.memGetLong(struct + FEATURE_FLAGS);
/*     */   } public static long nring_setup_flags(long struct) {
/* 271 */     return MemoryUtil.memGetLong(struct + RING_SETUP_FLAGS);
/*     */   } public static long nenter_flags(long struct) {
/* 273 */     return MemoryUtil.memGetLong(struct + ENTER_FLAGS);
/*     */   } public static long nsqe_flags(long struct) {
/* 275 */     return MemoryUtil.memGetLong(struct + SQE_FLAGS);
/*     */   }
/*     */   public static void nnr_request_opcodes(long struct, int value) {
/* 278 */     MemoryUtil.memPutInt(struct + NR_REQUEST_OPCODES, value);
/*     */   } public static void nnr_register_opcodes(long struct, int value) {
/* 280 */     MemoryUtil.memPutInt(struct + NR_REGISTER_OPCODES, value);
/*     */   } public static void nfeature_flags(long struct, long value) {
/* 282 */     MemoryUtil.memPutLong(struct + FEATURE_FLAGS, value);
/*     */   } public static void nring_setup_flags(long struct, long value) {
/* 284 */     MemoryUtil.memPutLong(struct + RING_SETUP_FLAGS, value);
/*     */   } public static void nenter_flags(long struct, long value) {
/* 286 */     MemoryUtil.memPutLong(struct + ENTER_FLAGS, value);
/*     */   } public static void nsqe_flags(long struct, long value) {
/* 288 */     MemoryUtil.memPutLong(struct + SQE_FLAGS, value);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<IOURingQueryOpcode, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 295 */     private static final IOURingQueryOpcode ELEMENT_FACTORY = IOURingQueryOpcode.create(-1L);
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
/* 307 */       super(container, container.remaining() / IOURingQueryOpcode.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 311 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 315 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 320 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 325 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected IOURingQueryOpcode getElementFactory() {
/* 330 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("__u32")
/*     */     public int nr_request_opcodes() {
/* 335 */       return IOURingQueryOpcode.nnr_request_opcodes(address());
/*     */     } @NativeType("__u32")
/*     */     public int nr_register_opcodes() {
/* 338 */       return IOURingQueryOpcode.nnr_register_opcodes(address());
/*     */     } @NativeType("__u64")
/*     */     public long feature_flags() {
/* 341 */       return IOURingQueryOpcode.nfeature_flags(address());
/*     */     } @NativeType("__u64")
/*     */     public long ring_setup_flags() {
/* 344 */       return IOURingQueryOpcode.nring_setup_flags(address());
/*     */     } @NativeType("__u64")
/*     */     public long enter_flags() {
/* 347 */       return IOURingQueryOpcode.nenter_flags(address());
/*     */     } @NativeType("__u64")
/*     */     public long sqe_flags() {
/* 350 */       return IOURingQueryOpcode.nsqe_flags(address());
/*     */     }
/*     */     public Buffer nr_request_opcodes(@NativeType("__u32") int value) {
/* 353 */       IOURingQueryOpcode.nnr_request_opcodes(address(), value); return this;
/*     */     } public Buffer nr_register_opcodes(@NativeType("__u32") int value) {
/* 355 */       IOURingQueryOpcode.nnr_register_opcodes(address(), value); return this;
/*     */     } public Buffer feature_flags(@NativeType("__u64") long value) {
/* 357 */       IOURingQueryOpcode.nfeature_flags(address(), value); return this;
/*     */     } public Buffer ring_setup_flags(@NativeType("__u64") long value) {
/* 359 */       IOURingQueryOpcode.nring_setup_flags(address(), value); return this;
/*     */     } public Buffer enter_flags(@NativeType("__u64") long value) {
/* 361 */       IOURingQueryOpcode.nenter_flags(address(), value); return this;
/*     */     } public Buffer sqe_flags(@NativeType("__u64") long value) {
/* 363 */       IOURingQueryOpcode.nsqe_flags(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\liburing\IOURingQueryOpcode.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */