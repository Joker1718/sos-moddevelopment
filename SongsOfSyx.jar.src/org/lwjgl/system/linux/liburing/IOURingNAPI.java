/*     */ package org.lwjgl.system.linux.liburing;
/*     */ 
/*     */ import java.nio.ByteBuffer;
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
/*     */ @NativeType("struct io_uring_napi")
/*     */ public class IOURingNAPI
/*     */   extends Struct<IOURingNAPI>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int BUSY_POLL_TO;
/*     */   public static final int PREFER_BUSY_POLL;
/*     */   public static final int PAD;
/*     */   public static final int RESV;
/*     */   
/*     */   static {
/*  45 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  46 */           __member(4), 
/*  47 */           __member(1), 
/*  48 */           __array(1, 3), 
/*  49 */           __member(8)
/*     */         });
/*     */     
/*  52 */     SIZEOF = layout.getSize();
/*  53 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  55 */     BUSY_POLL_TO = layout.offsetof(0);
/*  56 */     PREFER_BUSY_POLL = layout.offsetof(1);
/*  57 */     PAD = layout.offsetof(2);
/*  58 */     RESV = layout.offsetof(3);
/*     */   }
/*     */   
/*     */   protected IOURingNAPI(long address, ByteBuffer container) {
/*  62 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected IOURingNAPI create(long address, ByteBuffer container) {
/*  67 */     return new IOURingNAPI(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingNAPI(ByteBuffer container) {
/*  77 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  81 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("__u32")
/*     */   public int busy_poll_to() {
/*  85 */     return nbusy_poll_to(address());
/*     */   } @NativeType("__u8")
/*     */   public byte prefer_busy_poll() {
/*  88 */     return nprefer_busy_poll(address());
/*     */   }
/*     */   public IOURingNAPI busy_poll_to(@NativeType("__u32") int value) {
/*  91 */     nbusy_poll_to(address(), value); return this;
/*     */   } public IOURingNAPI prefer_busy_poll(@NativeType("__u8") byte value) {
/*  93 */     nprefer_busy_poll(address(), value); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingNAPI set(int busy_poll_to, byte prefer_busy_poll) {
/* 100 */     busy_poll_to(busy_poll_to);
/* 101 */     prefer_busy_poll(prefer_busy_poll);
/*     */     
/* 103 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingNAPI set(IOURingNAPI src) {
/* 114 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 115 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingNAPI malloc() {
/* 122 */     return new IOURingNAPI(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingNAPI calloc() {
/* 127 */     return new IOURingNAPI(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingNAPI create() {
/* 132 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 133 */     return new IOURingNAPI(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingNAPI create(long address) {
/* 138 */     return new IOURingNAPI(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingNAPI createSafe(long address) {
/* 143 */     return (address == 0L) ? null : new IOURingNAPI(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 152 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 161 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 170 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 171 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 181 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 186 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingNAPI malloc(MemoryStack stack) {
/* 195 */     return new IOURingNAPI(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingNAPI calloc(MemoryStack stack) {
/* 204 */     return new IOURingNAPI(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 214 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 224 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nbusy_poll_to(long struct) {
/* 230 */     return MemoryUtil.memGetInt(struct + BUSY_POLL_TO);
/*     */   }
/* 232 */   public static byte nprefer_busy_poll(long struct) { return MemoryUtil.memGetByte(struct + PREFER_BUSY_POLL); } public static ByteBuffer npad(long struct) {
/* 233 */     return MemoryUtil.memByteBuffer(struct + PAD, 3);
/*     */   } public static byte npad(long struct, int index) {
/* 235 */     return MemoryUtil.memGetByte(struct + PAD + Checks.check(index, 3) * 1L);
/*     */   } public static long nresv(long struct) {
/* 237 */     return MemoryUtil.memGetLong(struct + RESV);
/*     */   }
/*     */   public static void nbusy_poll_to(long struct, int value) {
/* 240 */     MemoryUtil.memPutInt(struct + BUSY_POLL_TO, value);
/*     */   } public static void nprefer_busy_poll(long struct, byte value) {
/* 242 */     MemoryUtil.memPutByte(struct + PREFER_BUSY_POLL, value);
/*     */   } public static void npad(long struct, ByteBuffer value) {
/* 244 */     if (Checks.CHECKS) Checks.checkGT(value, 3); 
/* 245 */     MemoryUtil.memCopy(MemoryUtil.memAddress(value), struct + PAD, (value.remaining() * 1));
/*     */   }
/*     */   public static void npad(long struct, int index, byte value) {
/* 248 */     MemoryUtil.memPutByte(struct + PAD + Checks.check(index, 3) * 1L, value);
/*     */   } public static void nresv(long struct, long value) {
/* 250 */     MemoryUtil.memPutLong(struct + RESV, value);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<IOURingNAPI, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 257 */     private static final IOURingNAPI ELEMENT_FACTORY = IOURingNAPI.create(-1L);
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
/* 269 */       super(container, container.remaining() / IOURingNAPI.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 273 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 277 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 282 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 287 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected IOURingNAPI getElementFactory() {
/* 292 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("__u32")
/*     */     public int busy_poll_to() {
/* 297 */       return IOURingNAPI.nbusy_poll_to(address());
/*     */     } @NativeType("__u8")
/*     */     public byte prefer_busy_poll() {
/* 300 */       return IOURingNAPI.nprefer_busy_poll(address());
/*     */     }
/*     */     public Buffer busy_poll_to(@NativeType("__u32") int value) {
/* 303 */       IOURingNAPI.nbusy_poll_to(address(), value); return this;
/*     */     } public Buffer prefer_busy_poll(@NativeType("__u8") byte value) {
/* 305 */       IOURingNAPI.nprefer_busy_poll(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\liburing\IOURingNAPI.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */