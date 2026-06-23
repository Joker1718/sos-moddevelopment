/*     */ package org.lwjgl.system.linux;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XErrorEvent
/*     */   extends Struct<XErrorEvent>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int TYPE;
/*     */   public static final int DISPLAY;
/*     */   public static final int RESOURCEID;
/*     */   public static final int SERIAL;
/*     */   public static final int ERROR_CODE;
/*     */   public static final int REQUEST_CODE;
/*     */   public static final int MINOR_CODE;
/*     */   
/*     */   static {
/*  50 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  51 */           __member(4), 
/*  52 */           __member(POINTER_SIZE), 
/*  53 */           __member(CLONG_SIZE), 
/*  54 */           __member(CLONG_SIZE), 
/*  55 */           __member(1), 
/*  56 */           __member(1), 
/*  57 */           __member(1)
/*     */         });
/*     */     
/*  60 */     SIZEOF = layout.getSize();
/*  61 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  63 */     TYPE = layout.offsetof(0);
/*  64 */     DISPLAY = layout.offsetof(1);
/*  65 */     RESOURCEID = layout.offsetof(2);
/*  66 */     SERIAL = layout.offsetof(3);
/*  67 */     ERROR_CODE = layout.offsetof(4);
/*  68 */     REQUEST_CODE = layout.offsetof(5);
/*  69 */     MINOR_CODE = layout.offsetof(6);
/*     */   }
/*     */   
/*     */   protected XErrorEvent(long address, ByteBuffer container) {
/*  73 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected XErrorEvent create(long address, ByteBuffer container) {
/*  78 */     return new XErrorEvent(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XErrorEvent(ByteBuffer container) {
/*  88 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  92 */     return SIZEOF;
/*     */   }
/*     */   public int type() {
/*  95 */     return ntype(address());
/*     */   } @NativeType("Display *")
/*     */   public long display() {
/*  98 */     return ndisplay(address());
/*     */   } @NativeType("XID")
/*     */   public long resourceid() {
/* 101 */     return nresourceid(address());
/*     */   } @NativeType("unsigned long")
/*     */   public long serial() {
/* 104 */     return nserial(address());
/*     */   } @NativeType("unsigned char")
/*     */   public byte error_code() {
/* 107 */     return nerror_code(address());
/*     */   } @NativeType("unsigned char")
/*     */   public byte request_code() {
/* 110 */     return nrequest_code(address());
/*     */   } @NativeType("unsigned char")
/*     */   public byte minor_code() {
/* 113 */     return nminor_code(address());
/*     */   }
/*     */   public XErrorEvent type(int value) {
/* 116 */     ntype(address(), value); return this;
/*     */   } public XErrorEvent display(@NativeType("Display *") long value) {
/* 118 */     ndisplay(address(), value); return this;
/*     */   } public XErrorEvent resourceid(@NativeType("XID") long value) {
/* 120 */     nresourceid(address(), value); return this;
/*     */   } public XErrorEvent serial(@NativeType("unsigned long") long value) {
/* 122 */     nserial(address(), value); return this;
/*     */   } public XErrorEvent error_code(@NativeType("unsigned char") byte value) {
/* 124 */     nerror_code(address(), value); return this;
/*     */   } public XErrorEvent request_code(@NativeType("unsigned char") byte value) {
/* 126 */     nrequest_code(address(), value); return this;
/*     */   } public XErrorEvent minor_code(@NativeType("unsigned char") byte value) {
/* 128 */     nminor_code(address(), value); return this;
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
/*     */   public XErrorEvent set(int type, long display, long resourceid, long serial, byte error_code, byte request_code, byte minor_code) {
/* 140 */     type(type);
/* 141 */     display(display);
/* 142 */     resourceid(resourceid);
/* 143 */     serial(serial);
/* 144 */     error_code(error_code);
/* 145 */     request_code(request_code);
/* 146 */     minor_code(minor_code);
/*     */     
/* 148 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XErrorEvent set(XErrorEvent src) {
/* 159 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 160 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XErrorEvent malloc() {
/* 167 */     return new XErrorEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XErrorEvent calloc() {
/* 172 */     return new XErrorEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XErrorEvent create() {
/* 177 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 178 */     return new XErrorEvent(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XErrorEvent create(long address) {
/* 183 */     return new XErrorEvent(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XErrorEvent createSafe(long address) {
/* 188 */     return (address == 0L) ? null : new XErrorEvent(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 197 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 206 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 215 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 216 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 226 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 231 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XErrorEvent malloc(MemoryStack stack) {
/* 240 */     return new XErrorEvent(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XErrorEvent calloc(MemoryStack stack) {
/* 249 */     return new XErrorEvent(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 259 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 269 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int ntype(long struct) {
/* 275 */     return MemoryUtil.memGetInt(struct + TYPE);
/*     */   } public static long ndisplay(long struct) {
/* 277 */     return MemoryUtil.memGetAddress(struct + DISPLAY);
/*     */   } public static long nresourceid(long struct) {
/* 279 */     return MemoryUtil.memGetCLong(struct + RESOURCEID);
/*     */   } public static long nserial(long struct) {
/* 281 */     return MemoryUtil.memGetCLong(struct + SERIAL);
/*     */   } public static byte nerror_code(long struct) {
/* 283 */     return MemoryUtil.memGetByte(struct + ERROR_CODE);
/*     */   } public static byte nrequest_code(long struct) {
/* 285 */     return MemoryUtil.memGetByte(struct + REQUEST_CODE);
/*     */   } public static byte nminor_code(long struct) {
/* 287 */     return MemoryUtil.memGetByte(struct + MINOR_CODE);
/*     */   }
/*     */   public static void ntype(long struct, int value) {
/* 290 */     MemoryUtil.memPutInt(struct + TYPE, value);
/*     */   } public static void ndisplay(long struct, long value) {
/* 292 */     MemoryUtil.memPutAddress(struct + DISPLAY, Checks.check(value));
/*     */   } public static void nresourceid(long struct, long value) {
/* 294 */     MemoryUtil.memPutCLong(struct + RESOURCEID, value);
/*     */   } public static void nserial(long struct, long value) {
/* 296 */     MemoryUtil.memPutCLong(struct + SERIAL, value);
/*     */   } public static void nerror_code(long struct, byte value) {
/* 298 */     MemoryUtil.memPutByte(struct + ERROR_CODE, value);
/*     */   } public static void nrequest_code(long struct, byte value) {
/* 300 */     MemoryUtil.memPutByte(struct + REQUEST_CODE, value);
/*     */   } public static void nminor_code(long struct, byte value) {
/* 302 */     MemoryUtil.memPutByte(struct + MINOR_CODE, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long struct) {
/* 310 */     Checks.check(MemoryUtil.memGetAddress(struct + DISPLAY));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<XErrorEvent, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 318 */     private static final XErrorEvent ELEMENT_FACTORY = XErrorEvent.create(-1L);
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
/* 330 */       super(container, container.remaining() / XErrorEvent.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 334 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 338 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 343 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 348 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected XErrorEvent getElementFactory() {
/* 353 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     public int type() {
/* 357 */       return XErrorEvent.ntype(address());
/*     */     } @NativeType("Display *")
/*     */     public long display() {
/* 360 */       return XErrorEvent.ndisplay(address());
/*     */     } @NativeType("XID")
/*     */     public long resourceid() {
/* 363 */       return XErrorEvent.nresourceid(address());
/*     */     } @NativeType("unsigned long")
/*     */     public long serial() {
/* 366 */       return XErrorEvent.nserial(address());
/*     */     } @NativeType("unsigned char")
/*     */     public byte error_code() {
/* 369 */       return XErrorEvent.nerror_code(address());
/*     */     } @NativeType("unsigned char")
/*     */     public byte request_code() {
/* 372 */       return XErrorEvent.nrequest_code(address());
/*     */     } @NativeType("unsigned char")
/*     */     public byte minor_code() {
/* 375 */       return XErrorEvent.nminor_code(address());
/*     */     }
/*     */     public Buffer type(int value) {
/* 378 */       XErrorEvent.ntype(address(), value); return this;
/*     */     } public Buffer display(@NativeType("Display *") long value) {
/* 380 */       XErrorEvent.ndisplay(address(), value); return this;
/*     */     } public Buffer resourceid(@NativeType("XID") long value) {
/* 382 */       XErrorEvent.nresourceid(address(), value); return this;
/*     */     } public Buffer serial(@NativeType("unsigned long") long value) {
/* 384 */       XErrorEvent.nserial(address(), value); return this;
/*     */     } public Buffer error_code(@NativeType("unsigned char") byte value) {
/* 386 */       XErrorEvent.nerror_code(address(), value); return this;
/*     */     } public Buffer request_code(@NativeType("unsigned char") byte value) {
/* 388 */       XErrorEvent.nrequest_code(address(), value); return this;
/*     */     } public Buffer minor_code(@NativeType("unsigned char") byte value) {
/* 390 */       XErrorEvent.nminor_code(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\XErrorEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */