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
/*     */ 
/*     */ 
/*     */ @NativeType("struct io_uring_restriction")
/*     */ public class IOURingRestriction
/*     */   extends Struct<IOURingRestriction>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int OPCODE;
/*     */   public static final int REGISTER_OP;
/*     */   public static final int SQE_OP;
/*     */   public static final int SQE_FLAGS;
/*     */   public static final int RESV;
/*     */   public static final int RESV2;
/*     */   
/*     */   static {
/*  51 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  52 */           __member(2), 
/*  53 */           (Struct.Member)__union(new Struct.Member[] {
/*  54 */               __member(1), 
/*  55 */               __member(1), 
/*  56 */               __member(1)
/*     */             
/*  58 */             }), __member(1), 
/*  59 */           __array(4, 3)
/*     */         });
/*     */     
/*  62 */     SIZEOF = layout.getSize();
/*  63 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  65 */     OPCODE = layout.offsetof(0);
/*  66 */     REGISTER_OP = layout.offsetof(2);
/*  67 */     SQE_OP = layout.offsetof(3);
/*  68 */     SQE_FLAGS = layout.offsetof(4);
/*  69 */     RESV = layout.offsetof(5);
/*  70 */     RESV2 = layout.offsetof(6);
/*     */   }
/*     */   
/*     */   protected IOURingRestriction(long address, ByteBuffer container) {
/*  74 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected IOURingRestriction create(long address, ByteBuffer container) {
/*  79 */     return new IOURingRestriction(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingRestriction(ByteBuffer container) {
/*  89 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  93 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("__u16")
/*     */   public short opcode() {
/*  97 */     return nopcode(address());
/*     */   } @NativeType("__u8")
/*     */   public byte register_op() {
/* 100 */     return nregister_op(address());
/*     */   } @NativeType("__u8")
/*     */   public byte sqe_op() {
/* 103 */     return nsqe_op(address());
/*     */   } @NativeType("__u8")
/*     */   public byte sqe_flags() {
/* 106 */     return nsqe_flags(address());
/*     */   }
/*     */   public IOURingRestriction opcode(@NativeType("__u16") short value) {
/* 109 */     nopcode(address(), value); return this;
/*     */   } public IOURingRestriction register_op(@NativeType("__u8") byte value) {
/* 111 */     nregister_op(address(), value); return this;
/*     */   } public IOURingRestriction sqe_op(@NativeType("__u8") byte value) {
/* 113 */     nsqe_op(address(), value); return this;
/*     */   } public IOURingRestriction sqe_flags(@NativeType("__u8") byte value) {
/* 115 */     nsqe_flags(address(), value); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingRestriction set(IOURingRestriction src) {
/* 125 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 126 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingRestriction malloc() {
/* 133 */     return new IOURingRestriction(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingRestriction calloc() {
/* 138 */     return new IOURingRestriction(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingRestriction create() {
/* 143 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 144 */     return new IOURingRestriction(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingRestriction create(long address) {
/* 149 */     return new IOURingRestriction(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingRestriction createSafe(long address) {
/* 154 */     return (address == 0L) ? null : new IOURingRestriction(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 163 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 172 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 181 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 182 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 192 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 197 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingRestriction malloc(MemoryStack stack) {
/* 206 */     return new IOURingRestriction(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingRestriction calloc(MemoryStack stack) {
/* 215 */     return new IOURingRestriction(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 225 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 235 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static short nopcode(long struct) {
/* 241 */     return MemoryUtil.memGetShort(struct + OPCODE);
/*     */   } public static byte nregister_op(long struct) {
/* 243 */     return MemoryUtil.memGetByte(struct + REGISTER_OP);
/*     */   } public static byte nsqe_op(long struct) {
/* 245 */     return MemoryUtil.memGetByte(struct + SQE_OP);
/*     */   }
/* 247 */   public static byte nsqe_flags(long struct) { return MemoryUtil.memGetByte(struct + SQE_FLAGS); }
/* 248 */   public static byte nresv(long struct) { return MemoryUtil.memGetByte(struct + RESV); } public static IntBuffer nresv2(long struct) {
/* 249 */     return MemoryUtil.memIntBuffer(struct + RESV2, 3);
/*     */   } public static int nresv2(long struct, int index) {
/* 251 */     return MemoryUtil.memGetInt(struct + RESV2 + Checks.check(index, 3) * 4L);
/*     */   }
/*     */   
/*     */   public static void nopcode(long struct, short value) {
/* 255 */     MemoryUtil.memPutShort(struct + OPCODE, value);
/*     */   } public static void nregister_op(long struct, byte value) {
/* 257 */     MemoryUtil.memPutByte(struct + REGISTER_OP, value);
/*     */   } public static void nsqe_op(long struct, byte value) {
/* 259 */     MemoryUtil.memPutByte(struct + SQE_OP, value);
/*     */   }
/* 261 */   public static void nsqe_flags(long struct, byte value) { MemoryUtil.memPutByte(struct + SQE_FLAGS, value); } public static void nresv(long struct, byte value) {
/* 262 */     MemoryUtil.memPutByte(struct + RESV, value);
/*     */   } public static void nresv2(long struct, IntBuffer value) {
/* 264 */     if (Checks.CHECKS) Checks.checkGT(value, 3); 
/* 265 */     MemoryUtil.memCopy(MemoryUtil.memAddress(value), struct + RESV2, (value.remaining() * 4));
/*     */   }
/*     */   public static void nresv2(long struct, int index, int value) {
/* 268 */     MemoryUtil.memPutInt(struct + RESV2 + Checks.check(index, 3) * 4L, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<IOURingRestriction, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 276 */     private static final IOURingRestriction ELEMENT_FACTORY = IOURingRestriction.create(-1L);
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
/* 288 */       super(container, container.remaining() / IOURingRestriction.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 292 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 296 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 301 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 306 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected IOURingRestriction getElementFactory() {
/* 311 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("__u16")
/*     */     public short opcode() {
/* 316 */       return IOURingRestriction.nopcode(address());
/*     */     } @NativeType("__u8")
/*     */     public byte register_op() {
/* 319 */       return IOURingRestriction.nregister_op(address());
/*     */     } @NativeType("__u8")
/*     */     public byte sqe_op() {
/* 322 */       return IOURingRestriction.nsqe_op(address());
/*     */     } @NativeType("__u8")
/*     */     public byte sqe_flags() {
/* 325 */       return IOURingRestriction.nsqe_flags(address());
/*     */     }
/*     */     public Buffer opcode(@NativeType("__u16") short value) {
/* 328 */       IOURingRestriction.nopcode(address(), value); return this;
/*     */     } public Buffer register_op(@NativeType("__u8") byte value) {
/* 330 */       IOURingRestriction.nregister_op(address(), value); return this;
/*     */     } public Buffer sqe_op(@NativeType("__u8") byte value) {
/* 332 */       IOURingRestriction.nsqe_op(address(), value); return this;
/*     */     } public Buffer sqe_flags(@NativeType("__u8") byte value) {
/* 334 */       IOURingRestriction.nsqe_flags(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\liburing\IOURingRestriction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */