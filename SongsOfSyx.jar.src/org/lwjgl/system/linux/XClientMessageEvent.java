/*     */ package org.lwjgl.system.linux;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.ShortBuffer;
/*     */ import org.lwjgl.BufferUtils;
/*     */ import org.lwjgl.CLongBuffer;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XClientMessageEvent
/*     */   extends Struct<XClientMessageEvent>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int TYPE;
/*     */   public static final int SERIAL;
/*     */   public static final int SEND_EVENT;
/*     */   public static final int DISPLAY;
/*     */   public static final int WINDOW;
/*     */   public static final int MESSAGE_TYPE;
/*     */   public static final int FORMAT;
/*     */   public static final int DATA;
/*     */   public static final int DATA_B;
/*     */   public static final int DATA_S;
/*     */   public static final int DATA_L;
/*     */   
/*     */   static {
/*  59 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  60 */           __member(4), 
/*  61 */           __member(CLONG_SIZE), 
/*  62 */           __member(4), 
/*  63 */           __member(POINTER_SIZE), 
/*  64 */           __member(CLONG_SIZE), 
/*  65 */           __member(CLONG_SIZE), 
/*  66 */           __member(4), 
/*  67 */           (Struct.Member)__struct(new Struct.Member[] {
/*  68 */               __array(1, 20), 
/*  69 */               __array(2, 10), 
/*  70 */               __array(CLONG_SIZE, 5)
/*     */             })
/*     */         });
/*     */     
/*  74 */     SIZEOF = layout.getSize();
/*  75 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  77 */     TYPE = layout.offsetof(0);
/*  78 */     SERIAL = layout.offsetof(1);
/*  79 */     SEND_EVENT = layout.offsetof(2);
/*  80 */     DISPLAY = layout.offsetof(3);
/*  81 */     WINDOW = layout.offsetof(4);
/*  82 */     MESSAGE_TYPE = layout.offsetof(5);
/*  83 */     FORMAT = layout.offsetof(6);
/*  84 */     DATA = layout.offsetof(7);
/*  85 */     DATA_B = layout.offsetof(8);
/*  86 */     DATA_S = layout.offsetof(9);
/*  87 */     DATA_L = layout.offsetof(10);
/*     */   }
/*     */   
/*     */   protected XClientMessageEvent(long address, ByteBuffer container) {
/*  91 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected XClientMessageEvent create(long address, ByteBuffer container) {
/*  96 */     return new XClientMessageEvent(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XClientMessageEvent(ByteBuffer container) {
/* 106 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/* 110 */     return SIZEOF;
/*     */   }
/*     */   public int type() {
/* 113 */     return ntype(address());
/*     */   } @NativeType("unsigned long")
/*     */   public long serial() {
/* 116 */     return nserial(address());
/*     */   } @NativeType("Bool")
/*     */   public boolean send_event() {
/* 119 */     return (nsend_event(address()) != 0);
/*     */   } @NativeType("Display *")
/*     */   public long display() {
/* 122 */     return ndisplay(address());
/*     */   } @NativeType("Window")
/*     */   public long window() {
/* 125 */     return nwindow(address());
/*     */   } @NativeType("Atom")
/*     */   public long message_type() {
/* 128 */     return nmessage_type(address());
/*     */   } public int format() {
/* 130 */     return nformat(address());
/*     */   } @NativeType("char[20]")
/*     */   public ByteBuffer data_b() {
/* 133 */     return ndata_b(address());
/*     */   } @NativeType("char")
/*     */   public byte data_b(int index) {
/* 136 */     return ndata_b(address(), index);
/*     */   } @NativeType("short[10]")
/*     */   public ShortBuffer data_s() {
/* 139 */     return ndata_s(address());
/*     */   } public short data_s(int index) {
/* 141 */     return ndata_s(address(), index);
/*     */   } @NativeType("long[5]")
/*     */   public CLongBuffer data_l() {
/* 144 */     return ndata_l(address());
/*     */   } public long data_l(int index) {
/* 146 */     return ndata_l(address(), index);
/*     */   }
/*     */   public XClientMessageEvent type(int value) {
/* 149 */     ntype(address(), value); return this;
/*     */   } public XClientMessageEvent serial(@NativeType("unsigned long") long value) {
/* 151 */     nserial(address(), value); return this;
/*     */   } public XClientMessageEvent send_event(@NativeType("Bool") boolean value) {
/* 153 */     nsend_event(address(), value ? 1 : 0); return this;
/*     */   } public XClientMessageEvent display(@NativeType("Display *") long value) {
/* 155 */     ndisplay(address(), value); return this;
/*     */   } public XClientMessageEvent window(@NativeType("Window") long value) {
/* 157 */     nwindow(address(), value); return this;
/*     */   } public XClientMessageEvent message_type(@NativeType("Atom") long value) {
/* 159 */     nmessage_type(address(), value); return this;
/*     */   } public XClientMessageEvent format(int value) {
/* 161 */     nformat(address(), value); return this;
/*     */   } public XClientMessageEvent data_b(@NativeType("char[20]") ByteBuffer value) {
/* 163 */     ndata_b(address(), value); return this;
/*     */   } public XClientMessageEvent data_b(int index, @NativeType("char") byte value) {
/* 165 */     ndata_b(address(), index, value); return this;
/*     */   } public XClientMessageEvent data_s(@NativeType("short[10]") ShortBuffer value) {
/* 167 */     ndata_s(address(), value); return this;
/*     */   } public XClientMessageEvent data_s(int index, short value) {
/* 169 */     ndata_s(address(), index, value); return this;
/*     */   } public XClientMessageEvent data_l(@NativeType("long[5]") CLongBuffer value) {
/* 171 */     ndata_l(address(), value); return this;
/*     */   } public XClientMessageEvent data_l(int index, long value) {
/* 173 */     ndata_l(address(), index, value); return this;
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
/*     */ 
/*     */   
/*     */   public XClientMessageEvent set(int type, long serial, boolean send_event, long display, long window, long message_type, int format, ByteBuffer data_b, ShortBuffer data_s, CLongBuffer data_l) {
/* 188 */     type(type);
/* 189 */     serial(serial);
/* 190 */     send_event(send_event);
/* 191 */     display(display);
/* 192 */     window(window);
/* 193 */     message_type(message_type);
/* 194 */     format(format);
/* 195 */     data_b(data_b);
/* 196 */     data_s(data_s);
/* 197 */     data_l(data_l);
/*     */     
/* 199 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XClientMessageEvent set(XClientMessageEvent src) {
/* 210 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 211 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XClientMessageEvent malloc() {
/* 218 */     return new XClientMessageEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XClientMessageEvent calloc() {
/* 223 */     return new XClientMessageEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XClientMessageEvent create() {
/* 228 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 229 */     return new XClientMessageEvent(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XClientMessageEvent create(long address) {
/* 234 */     return new XClientMessageEvent(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XClientMessageEvent createSafe(long address) {
/* 239 */     return (address == 0L) ? null : new XClientMessageEvent(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 248 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 257 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 266 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 267 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 277 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 282 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XClientMessageEvent malloc(MemoryStack stack) {
/* 291 */     return new XClientMessageEvent(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XClientMessageEvent calloc(MemoryStack stack) {
/* 300 */     return new XClientMessageEvent(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 310 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 320 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int ntype(long struct) {
/* 326 */     return MemoryUtil.memGetInt(struct + TYPE);
/*     */   } public static long nserial(long struct) {
/* 328 */     return MemoryUtil.memGetCLong(struct + SERIAL);
/*     */   } public static int nsend_event(long struct) {
/* 330 */     return MemoryUtil.memGetInt(struct + SEND_EVENT);
/*     */   } public static long ndisplay(long struct) {
/* 332 */     return MemoryUtil.memGetAddress(struct + DISPLAY);
/*     */   } public static long nwindow(long struct) {
/* 334 */     return MemoryUtil.memGetCLong(struct + WINDOW);
/*     */   } public static long nmessage_type(long struct) {
/* 336 */     return MemoryUtil.memGetCLong(struct + MESSAGE_TYPE);
/*     */   } public static int nformat(long struct) {
/* 338 */     return MemoryUtil.memGetInt(struct + FORMAT);
/*     */   } public static ByteBuffer ndata_b(long struct) {
/* 340 */     return MemoryUtil.memByteBuffer(struct + DATA_B, 20);
/*     */   }
/*     */   public static byte ndata_b(long struct, int index) {
/* 343 */     return MemoryUtil.memGetByte(struct + DATA_B + Checks.check(index, 20) * 1L);
/*     */   }
/*     */   public static ShortBuffer ndata_s(long struct) {
/* 346 */     return MemoryUtil.memShortBuffer(struct + DATA_S, 10);
/*     */   }
/*     */   public static short ndata_s(long struct, int index) {
/* 349 */     return MemoryUtil.memGetShort(struct + DATA_S + Checks.check(index, 10) * 2L);
/*     */   }
/*     */   public static CLongBuffer ndata_l(long struct) {
/* 352 */     return MemoryUtil.memCLongBuffer(struct + DATA_L, 5);
/*     */   }
/*     */   public static long ndata_l(long struct, int index) {
/* 355 */     return MemoryUtil.memGetCLong(struct + DATA_L + Checks.check(index, 5) * CLONG_SIZE);
/*     */   }
/*     */   
/*     */   public static void ntype(long struct, int value) {
/* 359 */     MemoryUtil.memPutInt(struct + TYPE, value);
/*     */   } public static void nserial(long struct, long value) {
/* 361 */     MemoryUtil.memPutCLong(struct + SERIAL, value);
/*     */   } public static void nsend_event(long struct, int value) {
/* 363 */     MemoryUtil.memPutInt(struct + SEND_EVENT, value);
/*     */   } public static void ndisplay(long struct, long value) {
/* 365 */     MemoryUtil.memPutAddress(struct + DISPLAY, Checks.check(value));
/*     */   } public static void nwindow(long struct, long value) {
/* 367 */     MemoryUtil.memPutCLong(struct + WINDOW, value);
/*     */   } public static void nmessage_type(long struct, long value) {
/* 369 */     MemoryUtil.memPutCLong(struct + MESSAGE_TYPE, value);
/*     */   } public static void nformat(long struct, int value) {
/* 371 */     MemoryUtil.memPutInt(struct + FORMAT, value);
/*     */   }
/*     */   public static void ndata_b(long struct, ByteBuffer value) {
/* 374 */     if (Checks.CHECKS) Checks.checkGT(value, 20); 
/* 375 */     MemoryUtil.memCopy(MemoryUtil.memAddress(value), struct + DATA_B, (value.remaining() * 1));
/*     */   }
/*     */   
/*     */   public static void ndata_b(long struct, int index, byte value) {
/* 379 */     MemoryUtil.memPutByte(struct + DATA_B + Checks.check(index, 20) * 1L, value);
/*     */   }
/*     */   
/*     */   public static void ndata_s(long struct, ShortBuffer value) {
/* 383 */     if (Checks.CHECKS) Checks.checkGT(value, 10); 
/* 384 */     MemoryUtil.memCopy(MemoryUtil.memAddress(value), struct + DATA_S, (value.remaining() * 2));
/*     */   }
/*     */   
/*     */   public static void ndata_s(long struct, int index, short value) {
/* 388 */     MemoryUtil.memPutShort(struct + DATA_S + Checks.check(index, 10) * 2L, value);
/*     */   }
/*     */   
/*     */   public static void ndata_l(long struct, CLongBuffer value) {
/* 392 */     if (Checks.CHECKS) Checks.checkGT((CustomBuffer)value, 5); 
/* 393 */     MemoryUtil.memCopy(MemoryUtil.memAddress((CustomBuffer)value), struct + DATA_L, (value.remaining() * CLONG_SIZE));
/*     */   }
/*     */   
/*     */   public static void ndata_l(long struct, int index, long value) {
/* 397 */     MemoryUtil.memPutCLong(struct + DATA_L + Checks.check(index, 5) * CLONG_SIZE, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long struct) {
/* 406 */     Checks.check(MemoryUtil.memGetAddress(struct + DISPLAY));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<XClientMessageEvent, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 414 */     private static final XClientMessageEvent ELEMENT_FACTORY = XClientMessageEvent.create(-1L);
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
/* 426 */       super(container, container.remaining() / XClientMessageEvent.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 430 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 434 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 439 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 444 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected XClientMessageEvent getElementFactory() {
/* 449 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     public int type() {
/* 453 */       return XClientMessageEvent.ntype(address());
/*     */     } @NativeType("unsigned long")
/*     */     public long serial() {
/* 456 */       return XClientMessageEvent.nserial(address());
/*     */     } @NativeType("Bool")
/*     */     public boolean send_event() {
/* 459 */       return (XClientMessageEvent.nsend_event(address()) != 0);
/*     */     } @NativeType("Display *")
/*     */     public long display() {
/* 462 */       return XClientMessageEvent.ndisplay(address());
/*     */     } @NativeType("Window")
/*     */     public long window() {
/* 465 */       return XClientMessageEvent.nwindow(address());
/*     */     } @NativeType("Atom")
/*     */     public long message_type() {
/* 468 */       return XClientMessageEvent.nmessage_type(address());
/*     */     } public int format() {
/* 470 */       return XClientMessageEvent.nformat(address());
/*     */     } @NativeType("char[20]")
/*     */     public ByteBuffer data_b() {
/* 473 */       return XClientMessageEvent.ndata_b(address());
/*     */     } @NativeType("char")
/*     */     public byte data_b(int index) {
/* 476 */       return XClientMessageEvent.ndata_b(address(), index);
/*     */     } @NativeType("short[10]")
/*     */     public ShortBuffer data_s() {
/* 479 */       return XClientMessageEvent.ndata_s(address());
/*     */     } public short data_s(int index) {
/* 481 */       return XClientMessageEvent.ndata_s(address(), index);
/*     */     } @NativeType("long[5]")
/*     */     public CLongBuffer data_l() {
/* 484 */       return XClientMessageEvent.ndata_l(address());
/*     */     } public long data_l(int index) {
/* 486 */       return XClientMessageEvent.ndata_l(address(), index);
/*     */     }
/*     */     public Buffer type(int value) {
/* 489 */       XClientMessageEvent.ntype(address(), value); return this;
/*     */     } public Buffer serial(@NativeType("unsigned long") long value) {
/* 491 */       XClientMessageEvent.nserial(address(), value); return this;
/*     */     } public Buffer send_event(@NativeType("Bool") boolean value) {
/* 493 */       XClientMessageEvent.nsend_event(address(), value ? 1 : 0); return this;
/*     */     } public Buffer display(@NativeType("Display *") long value) {
/* 495 */       XClientMessageEvent.ndisplay(address(), value); return this;
/*     */     } public Buffer window(@NativeType("Window") long value) {
/* 497 */       XClientMessageEvent.nwindow(address(), value); return this;
/*     */     } public Buffer message_type(@NativeType("Atom") long value) {
/* 499 */       XClientMessageEvent.nmessage_type(address(), value); return this;
/*     */     } public Buffer format(int value) {
/* 501 */       XClientMessageEvent.nformat(address(), value); return this;
/*     */     } public Buffer data_b(@NativeType("char[20]") ByteBuffer value) {
/* 503 */       XClientMessageEvent.ndata_b(address(), value); return this;
/*     */     } public Buffer data_b(int index, @NativeType("char") byte value) {
/* 505 */       XClientMessageEvent.ndata_b(address(), index, value); return this;
/*     */     } public Buffer data_s(@NativeType("short[10]") ShortBuffer value) {
/* 507 */       XClientMessageEvent.ndata_s(address(), value); return this;
/*     */     } public Buffer data_s(int index, short value) {
/* 509 */       XClientMessageEvent.ndata_s(address(), index, value); return this;
/*     */     } public Buffer data_l(@NativeType("long[5]") CLongBuffer value) {
/* 511 */       XClientMessageEvent.ndata_l(address(), value); return this;
/*     */     } public Buffer data_l(int index, long value) {
/* 513 */       XClientMessageEvent.ndata_l(address(), index, value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\XClientMessageEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */