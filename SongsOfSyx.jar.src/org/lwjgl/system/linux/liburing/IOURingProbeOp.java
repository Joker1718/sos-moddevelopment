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
/*     */ @NativeType("struct io_uring_probe_op")
/*     */ public class IOURingProbeOp
/*     */   extends Struct<IOURingProbeOp>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int OP;
/*     */   public static final int RESV;
/*     */   public static final int FLAGS;
/*     */   public static final int RESV2;
/*     */   
/*     */   static {
/*  44 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  45 */           __member(1), 
/*  46 */           __member(1), 
/*  47 */           __member(2), 
/*  48 */           __member(4)
/*     */         });
/*     */     
/*  51 */     SIZEOF = layout.getSize();
/*  52 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  54 */     OP = layout.offsetof(0);
/*  55 */     RESV = layout.offsetof(1);
/*  56 */     FLAGS = layout.offsetof(2);
/*  57 */     RESV2 = layout.offsetof(3);
/*     */   }
/*     */   
/*     */   protected IOURingProbeOp(long address, ByteBuffer container) {
/*  61 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected IOURingProbeOp create(long address, ByteBuffer container) {
/*  66 */     return new IOURingProbeOp(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingProbeOp(ByteBuffer container) {
/*  76 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  80 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("__u8")
/*     */   public byte op() {
/*  84 */     return nop(address());
/*     */   } @NativeType("__u16")
/*     */   public short flags() {
/*  87 */     return nflags(address());
/*     */   }
/*     */   public IOURingProbeOp op(@NativeType("__u8") byte value) {
/*  90 */     nop(address(), value); return this;
/*     */   } public IOURingProbeOp flags(@NativeType("__u16") short value) {
/*  92 */     nflags(address(), value); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingProbeOp set(byte op, short flags) {
/*  99 */     op(op);
/* 100 */     flags(flags);
/*     */     
/* 102 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingProbeOp set(IOURingProbeOp src) {
/* 113 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 114 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingProbeOp malloc() {
/* 121 */     return new IOURingProbeOp(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingProbeOp calloc() {
/* 126 */     return new IOURingProbeOp(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingProbeOp create() {
/* 131 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 132 */     return new IOURingProbeOp(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingProbeOp create(long address) {
/* 137 */     return new IOURingProbeOp(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingProbeOp createSafe(long address) {
/* 142 */     return (address == 0L) ? null : new IOURingProbeOp(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 151 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 160 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 169 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 170 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 180 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 185 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingProbeOp malloc(MemoryStack stack) {
/* 194 */     return new IOURingProbeOp(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingProbeOp calloc(MemoryStack stack) {
/* 203 */     return new IOURingProbeOp(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 213 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 223 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static byte nop(long struct) {
/* 229 */     return MemoryUtil.memGetByte(struct + OP); } public static byte nresv(long struct) {
/* 230 */     return MemoryUtil.memGetByte(struct + RESV);
/*     */   }
/* 232 */   public static short nflags(long struct) { return MemoryUtil.memGetShort(struct + FLAGS); } public static int nresv2(long struct) {
/* 233 */     return MemoryUtil.memGetInt(struct + RESV2);
/*     */   }
/*     */   
/* 236 */   public static void nop(long struct, byte value) { MemoryUtil.memPutByte(struct + OP, value); } public static void nresv(long struct, byte value) {
/* 237 */     MemoryUtil.memPutByte(struct + RESV, value);
/*     */   }
/* 239 */   public static void nflags(long struct, short value) { MemoryUtil.memPutShort(struct + FLAGS, value); } public static void nresv2(long struct, int value) {
/* 240 */     MemoryUtil.memPutInt(struct + RESV2, value);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<IOURingProbeOp, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 247 */     private static final IOURingProbeOp ELEMENT_FACTORY = IOURingProbeOp.create(-1L);
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
/* 259 */       super(container, container.remaining() / IOURingProbeOp.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 263 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 267 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 272 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 277 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected IOURingProbeOp getElementFactory() {
/* 282 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("__u8")
/*     */     public byte op() {
/* 287 */       return IOURingProbeOp.nop(address());
/*     */     } @NativeType("__u16")
/*     */     public short flags() {
/* 290 */       return IOURingProbeOp.nflags(address());
/*     */     }
/*     */     public Buffer op(@NativeType("__u8") byte value) {
/* 293 */       IOURingProbeOp.nop(address(), value); return this;
/*     */     } public Buffer flags(@NativeType("__u16") short value) {
/* 295 */       IOURingProbeOp.nflags(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\liburing\IOURingProbeOp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */