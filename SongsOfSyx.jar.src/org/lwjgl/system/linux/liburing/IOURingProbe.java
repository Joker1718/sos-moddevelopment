/*     */ package org.lwjgl.system.linux.liburing;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.util.function.Consumer;
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
/*     */ @NativeType("struct io_uring_probe")
/*     */ public class IOURingProbe
/*     */   extends Struct<IOURingProbe>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int LAST_OP;
/*     */   public static final int OPS_LEN;
/*     */   public static final int RESV;
/*     */   public static final int RESV2;
/*     */   public static final int OPS;
/*     */   
/*     */   static {
/*  47 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  48 */           __member(1), 
/*  49 */           __member(1), 
/*  50 */           __member(2), 
/*  51 */           __array(4, 3), 
/*  52 */           __array(IOURingProbeOp.SIZEOF, IOURingProbeOp.ALIGNOF, 0)
/*     */         });
/*     */     
/*  55 */     SIZEOF = layout.getSize();
/*  56 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  58 */     LAST_OP = layout.offsetof(0);
/*  59 */     OPS_LEN = layout.offsetof(1);
/*  60 */     RESV = layout.offsetof(2);
/*  61 */     RESV2 = layout.offsetof(3);
/*  62 */     OPS = layout.offsetof(4);
/*     */   }
/*     */   
/*     */   protected IOURingProbe(long address, ByteBuffer container) {
/*  66 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected IOURingProbe create(long address, ByteBuffer container) {
/*  71 */     return new IOURingProbe(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingProbe(ByteBuffer container) {
/*  81 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  85 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("__u8")
/*     */   public byte last_op() {
/*  89 */     return nlast_op(address());
/*     */   } @NativeType("__u8")
/*     */   public byte ops_len() {
/*  92 */     return nops_len(address());
/*     */   } @NativeType("struct io_uring_probe_op[0]")
/*     */   public IOURingProbeOp.Buffer ops() {
/*  95 */     return nops(address());
/*     */   } @NativeType("struct io_uring_probe_op")
/*     */   public IOURingProbeOp ops(int index) {
/*  98 */     return nops(address(), index);
/*     */   }
/*     */   public IOURingProbe last_op(@NativeType("__u8") byte value) {
/* 101 */     nlast_op(address(), value); return this;
/*     */   } public IOURingProbe ops_len(@NativeType("__u8") byte value) {
/* 103 */     nops_len(address(), value); return this;
/*     */   } public IOURingProbe ops(@NativeType("struct io_uring_probe_op[0]") IOURingProbeOp.Buffer value) {
/* 105 */     nops(address(), value); return this;
/*     */   } public IOURingProbe ops(int index, @NativeType("struct io_uring_probe_op") IOURingProbeOp value) {
/* 107 */     nops(address(), index, value); return this;
/*     */   } public IOURingProbe ops(Consumer<IOURingProbeOp.Buffer> consumer) {
/* 109 */     consumer.accept(ops()); return this;
/*     */   } public IOURingProbe ops(int index, Consumer<IOURingProbeOp> consumer) {
/* 111 */     consumer.accept(ops(index)); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingProbe set(byte last_op, byte ops_len, IOURingProbeOp.Buffer ops) {
/* 119 */     last_op(last_op);
/* 120 */     ops_len(ops_len);
/* 121 */     ops(ops);
/*     */     
/* 123 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingProbe set(IOURingProbe src) {
/* 134 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 135 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingProbe malloc() {
/* 142 */     return new IOURingProbe(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingProbe calloc() {
/* 147 */     return new IOURingProbe(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingProbe create() {
/* 152 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 153 */     return new IOURingProbe(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingProbe create(long address) {
/* 158 */     return new IOURingProbe(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingProbe createSafe(long address) {
/* 163 */     return (address == 0L) ? null : new IOURingProbe(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 172 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 181 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 190 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 191 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 201 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 206 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingProbe malloc(MemoryStack stack) {
/* 215 */     return new IOURingProbe(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingProbe calloc(MemoryStack stack) {
/* 224 */     return new IOURingProbe(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 234 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 244 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static byte nlast_op(long struct) {
/* 250 */     return MemoryUtil.memGetByte(struct + LAST_OP);
/*     */   }
/* 252 */   public static byte nops_len(long struct) { return MemoryUtil.memGetByte(struct + OPS_LEN); }
/* 253 */   public static short nresv(long struct) { return MemoryUtil.memGetShort(struct + RESV); } public static IntBuffer nresv2(long struct) {
/* 254 */     return MemoryUtil.memIntBuffer(struct + RESV2, 3);
/*     */   } public static int nresv2(long struct, int index) {
/* 256 */     return MemoryUtil.memGetInt(struct + RESV2 + Checks.check(index, 3) * 4L);
/*     */   }
/*     */   public static IOURingProbeOp.Buffer nops(long struct) {
/* 259 */     return IOURingProbeOp.create(struct + OPS, 0);
/*     */   }
/*     */   public static IOURingProbeOp nops(long struct, int index) {
/* 262 */     return IOURingProbeOp.create(struct + OPS + Checks.check(index, 0) * IOURingProbeOp.SIZEOF);
/*     */   }
/*     */   
/*     */   public static void nlast_op(long struct, byte value) {
/* 266 */     MemoryUtil.memPutByte(struct + LAST_OP, value);
/*     */   }
/* 268 */   public static void nops_len(long struct, byte value) { MemoryUtil.memPutByte(struct + OPS_LEN, value); } public static void nresv(long struct, short value) {
/* 269 */     MemoryUtil.memPutShort(struct + RESV, value);
/*     */   } public static void nresv2(long struct, IntBuffer value) {
/* 271 */     if (Checks.CHECKS) Checks.checkGT(value, 3); 
/* 272 */     MemoryUtil.memCopy(MemoryUtil.memAddress(value), struct + RESV2, (value.remaining() * 4));
/*     */   }
/*     */   public static void nresv2(long struct, int index, int value) {
/* 275 */     MemoryUtil.memPutInt(struct + RESV2 + Checks.check(index, 3) * 4L, value);
/*     */   }
/*     */   
/*     */   public static void nops(long struct, IOURingProbeOp.Buffer value) {
/* 279 */     if (Checks.CHECKS) Checks.checkGT((CustomBuffer)value, 0); 
/* 280 */     MemoryUtil.memCopy(value.address(), struct + OPS, (value.remaining() * IOURingProbeOp.SIZEOF));
/*     */   }
/*     */   
/*     */   public static void nops(long struct, int index, IOURingProbeOp value) {
/* 284 */     MemoryUtil.memCopy(value.address(), struct + OPS + Checks.check(index, 0) * IOURingProbeOp.SIZEOF, IOURingProbeOp.SIZEOF);
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<IOURingProbe, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 292 */     private static final IOURingProbe ELEMENT_FACTORY = IOURingProbe.create(-1L);
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
/* 304 */       super(container, container.remaining() / IOURingProbe.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 308 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 312 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 317 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 322 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected IOURingProbe getElementFactory() {
/* 327 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("__u8")
/*     */     public byte last_op() {
/* 332 */       return IOURingProbe.nlast_op(address());
/*     */     } @NativeType("__u8")
/*     */     public byte ops_len() {
/* 335 */       return IOURingProbe.nops_len(address());
/*     */     } @NativeType("struct io_uring_probe_op[0]")
/*     */     public IOURingProbeOp.Buffer ops() {
/* 338 */       return IOURingProbe.nops(address());
/*     */     } @NativeType("struct io_uring_probe_op")
/*     */     public IOURingProbeOp ops(int index) {
/* 341 */       return IOURingProbe.nops(address(), index);
/*     */     }
/*     */     public Buffer last_op(@NativeType("__u8") byte value) {
/* 344 */       IOURingProbe.nlast_op(address(), value); return this;
/*     */     } public Buffer ops_len(@NativeType("__u8") byte value) {
/* 346 */       IOURingProbe.nops_len(address(), value); return this;
/*     */     } public Buffer ops(@NativeType("struct io_uring_probe_op[0]") IOURingProbeOp.Buffer value) {
/* 348 */       IOURingProbe.nops(address(), value); return this;
/*     */     } public Buffer ops(int index, @NativeType("struct io_uring_probe_op") IOURingProbeOp value) {
/* 350 */       IOURingProbe.nops(address(), index, value); return this;
/*     */     } public Buffer ops(Consumer<IOURingProbeOp.Buffer> consumer) {
/* 352 */       consumer.accept(ops()); return this;
/*     */     } public Buffer ops(int index, Consumer<IOURingProbeOp> consumer) {
/* 354 */       consumer.accept(ops(index)); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\liburing\IOURingProbe.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */