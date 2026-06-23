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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XGraphicsExposeEvent
/*     */   extends Struct<XGraphicsExposeEvent>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int TYPE;
/*     */   public static final int SERIAL;
/*     */   public static final int SEND_EVENT;
/*     */   public static final int DISPLAY;
/*     */   public static final int DRAWABLE;
/*     */   public static final int X;
/*     */   public static final int Y;
/*     */   public static final int WIDTH;
/*     */   public static final int HEIGHT;
/*     */   public static final int COUNT;
/*     */   public static final int MAJOR_CODE;
/*     */   public static final int MINOR_CODE;
/*     */   
/*     */   static {
/*  60 */     Struct.Layout layout = __struct(new Struct.Member[] { 
/*  61 */           __member(4), 
/*  62 */           __member(CLONG_SIZE), 
/*  63 */           __member(4), 
/*  64 */           __member(POINTER_SIZE), 
/*  65 */           __member(CLONG_SIZE), 
/*  66 */           __member(4), 
/*  67 */           __member(4), 
/*  68 */           __member(4), 
/*  69 */           __member(4), 
/*  70 */           __member(4), 
/*  71 */           __member(4), 
/*  72 */           __member(4) });
/*     */ 
/*     */     
/*  75 */     SIZEOF = layout.getSize();
/*  76 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  78 */     TYPE = layout.offsetof(0);
/*  79 */     SERIAL = layout.offsetof(1);
/*  80 */     SEND_EVENT = layout.offsetof(2);
/*  81 */     DISPLAY = layout.offsetof(3);
/*  82 */     DRAWABLE = layout.offsetof(4);
/*  83 */     X = layout.offsetof(5);
/*  84 */     Y = layout.offsetof(6);
/*  85 */     WIDTH = layout.offsetof(7);
/*  86 */     HEIGHT = layout.offsetof(8);
/*  87 */     COUNT = layout.offsetof(9);
/*  88 */     MAJOR_CODE = layout.offsetof(10);
/*  89 */     MINOR_CODE = layout.offsetof(11);
/*     */   }
/*     */   
/*     */   protected XGraphicsExposeEvent(long address, ByteBuffer container) {
/*  93 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected XGraphicsExposeEvent create(long address, ByteBuffer container) {
/*  98 */     return new XGraphicsExposeEvent(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XGraphicsExposeEvent(ByteBuffer container) {
/* 108 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/* 112 */     return SIZEOF;
/*     */   }
/*     */   public int type() {
/* 115 */     return ntype(address());
/*     */   } @NativeType("unsigned long")
/*     */   public long serial() {
/* 118 */     return nserial(address());
/*     */   } @NativeType("Bool")
/*     */   public boolean send_event() {
/* 121 */     return (nsend_event(address()) != 0);
/*     */   } @NativeType("Display *")
/*     */   public long display() {
/* 124 */     return ndisplay(address());
/*     */   } @NativeType("Drawable")
/*     */   public long drawable() {
/* 127 */     return ndrawable(address());
/*     */   } public int x() {
/* 129 */     return nx(address());
/*     */   } public int y() {
/* 131 */     return ny(address());
/*     */   } public int width() {
/* 133 */     return nwidth(address());
/*     */   } public int height() {
/* 135 */     return nheight(address());
/*     */   } public int count() {
/* 137 */     return ncount(address());
/*     */   } public int major_code() {
/* 139 */     return nmajor_code(address());
/*     */   } public int minor_code() {
/* 141 */     return nminor_code(address());
/*     */   }
/*     */   public XGraphicsExposeEvent type(int value) {
/* 144 */     ntype(address(), value); return this;
/*     */   } public XGraphicsExposeEvent serial(@NativeType("unsigned long") long value) {
/* 146 */     nserial(address(), value); return this;
/*     */   } public XGraphicsExposeEvent send_event(@NativeType("Bool") boolean value) {
/* 148 */     nsend_event(address(), value ? 1 : 0); return this;
/*     */   } public XGraphicsExposeEvent display(@NativeType("Display *") long value) {
/* 150 */     ndisplay(address(), value); return this;
/*     */   } public XGraphicsExposeEvent drawable(@NativeType("Drawable") long value) {
/* 152 */     ndrawable(address(), value); return this;
/*     */   } public XGraphicsExposeEvent x(int value) {
/* 154 */     nx(address(), value); return this;
/*     */   } public XGraphicsExposeEvent y(int value) {
/* 156 */     ny(address(), value); return this;
/*     */   } public XGraphicsExposeEvent width(int value) {
/* 158 */     nwidth(address(), value); return this;
/*     */   } public XGraphicsExposeEvent height(int value) {
/* 160 */     nheight(address(), value); return this;
/*     */   } public XGraphicsExposeEvent count(int value) {
/* 162 */     ncount(address(), value); return this;
/*     */   } public XGraphicsExposeEvent major_code(int value) {
/* 164 */     nmajor_code(address(), value); return this;
/*     */   } public XGraphicsExposeEvent minor_code(int value) {
/* 166 */     nminor_code(address(), value); return this;
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
/*     */ 
/*     */   
/*     */   public XGraphicsExposeEvent set(int type, long serial, boolean send_event, long display, long drawable, int x, int y, int width, int height, int count, int major_code, int minor_code) {
/* 183 */     type(type);
/* 184 */     serial(serial);
/* 185 */     send_event(send_event);
/* 186 */     display(display);
/* 187 */     drawable(drawable);
/* 188 */     x(x);
/* 189 */     y(y);
/* 190 */     width(width);
/* 191 */     height(height);
/* 192 */     count(count);
/* 193 */     major_code(major_code);
/* 194 */     minor_code(minor_code);
/*     */     
/* 196 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XGraphicsExposeEvent set(XGraphicsExposeEvent src) {
/* 207 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 208 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XGraphicsExposeEvent malloc() {
/* 215 */     return new XGraphicsExposeEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XGraphicsExposeEvent calloc() {
/* 220 */     return new XGraphicsExposeEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XGraphicsExposeEvent create() {
/* 225 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 226 */     return new XGraphicsExposeEvent(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XGraphicsExposeEvent create(long address) {
/* 231 */     return new XGraphicsExposeEvent(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XGraphicsExposeEvent createSafe(long address) {
/* 236 */     return (address == 0L) ? null : new XGraphicsExposeEvent(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 245 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 254 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 263 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 264 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 274 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 279 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XGraphicsExposeEvent malloc(MemoryStack stack) {
/* 288 */     return new XGraphicsExposeEvent(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XGraphicsExposeEvent calloc(MemoryStack stack) {
/* 297 */     return new XGraphicsExposeEvent(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 307 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 317 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int ntype(long struct) {
/* 323 */     return MemoryUtil.memGetInt(struct + TYPE);
/*     */   } public static long nserial(long struct) {
/* 325 */     return MemoryUtil.memGetCLong(struct + SERIAL);
/*     */   } public static int nsend_event(long struct) {
/* 327 */     return MemoryUtil.memGetInt(struct + SEND_EVENT);
/*     */   } public static long ndisplay(long struct) {
/* 329 */     return MemoryUtil.memGetAddress(struct + DISPLAY);
/*     */   } public static long ndrawable(long struct) {
/* 331 */     return MemoryUtil.memGetCLong(struct + DRAWABLE);
/*     */   } public static int nx(long struct) {
/* 333 */     return MemoryUtil.memGetInt(struct + X);
/*     */   } public static int ny(long struct) {
/* 335 */     return MemoryUtil.memGetInt(struct + Y);
/*     */   } public static int nwidth(long struct) {
/* 337 */     return MemoryUtil.memGetInt(struct + WIDTH);
/*     */   } public static int nheight(long struct) {
/* 339 */     return MemoryUtil.memGetInt(struct + HEIGHT);
/*     */   } public static int ncount(long struct) {
/* 341 */     return MemoryUtil.memGetInt(struct + COUNT);
/*     */   } public static int nmajor_code(long struct) {
/* 343 */     return MemoryUtil.memGetInt(struct + MAJOR_CODE);
/*     */   } public static int nminor_code(long struct) {
/* 345 */     return MemoryUtil.memGetInt(struct + MINOR_CODE);
/*     */   }
/*     */   public static void ntype(long struct, int value) {
/* 348 */     MemoryUtil.memPutInt(struct + TYPE, value);
/*     */   } public static void nserial(long struct, long value) {
/* 350 */     MemoryUtil.memPutCLong(struct + SERIAL, value);
/*     */   } public static void nsend_event(long struct, int value) {
/* 352 */     MemoryUtil.memPutInt(struct + SEND_EVENT, value);
/*     */   } public static void ndisplay(long struct, long value) {
/* 354 */     MemoryUtil.memPutAddress(struct + DISPLAY, Checks.check(value));
/*     */   } public static void ndrawable(long struct, long value) {
/* 356 */     MemoryUtil.memPutCLong(struct + DRAWABLE, value);
/*     */   } public static void nx(long struct, int value) {
/* 358 */     MemoryUtil.memPutInt(struct + X, value);
/*     */   } public static void ny(long struct, int value) {
/* 360 */     MemoryUtil.memPutInt(struct + Y, value);
/*     */   } public static void nwidth(long struct, int value) {
/* 362 */     MemoryUtil.memPutInt(struct + WIDTH, value);
/*     */   } public static void nheight(long struct, int value) {
/* 364 */     MemoryUtil.memPutInt(struct + HEIGHT, value);
/*     */   } public static void ncount(long struct, int value) {
/* 366 */     MemoryUtil.memPutInt(struct + COUNT, value);
/*     */   } public static void nmajor_code(long struct, int value) {
/* 368 */     MemoryUtil.memPutInt(struct + MAJOR_CODE, value);
/*     */   } public static void nminor_code(long struct, int value) {
/* 370 */     MemoryUtil.memPutInt(struct + MINOR_CODE, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long struct) {
/* 378 */     Checks.check(MemoryUtil.memGetAddress(struct + DISPLAY));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<XGraphicsExposeEvent, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 386 */     private static final XGraphicsExposeEvent ELEMENT_FACTORY = XGraphicsExposeEvent.create(-1L);
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
/* 398 */       super(container, container.remaining() / XGraphicsExposeEvent.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 402 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 406 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 411 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 416 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected XGraphicsExposeEvent getElementFactory() {
/* 421 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     public int type() {
/* 425 */       return XGraphicsExposeEvent.ntype(address());
/*     */     } @NativeType("unsigned long")
/*     */     public long serial() {
/* 428 */       return XGraphicsExposeEvent.nserial(address());
/*     */     } @NativeType("Bool")
/*     */     public boolean send_event() {
/* 431 */       return (XGraphicsExposeEvent.nsend_event(address()) != 0);
/*     */     } @NativeType("Display *")
/*     */     public long display() {
/* 434 */       return XGraphicsExposeEvent.ndisplay(address());
/*     */     } @NativeType("Drawable")
/*     */     public long drawable() {
/* 437 */       return XGraphicsExposeEvent.ndrawable(address());
/*     */     } public int x() {
/* 439 */       return XGraphicsExposeEvent.nx(address());
/*     */     } public int y() {
/* 441 */       return XGraphicsExposeEvent.ny(address());
/*     */     } public int width() {
/* 443 */       return XGraphicsExposeEvent.nwidth(address());
/*     */     } public int height() {
/* 445 */       return XGraphicsExposeEvent.nheight(address());
/*     */     } public int count() {
/* 447 */       return XGraphicsExposeEvent.ncount(address());
/*     */     } public int major_code() {
/* 449 */       return XGraphicsExposeEvent.nmajor_code(address());
/*     */     } public int minor_code() {
/* 451 */       return XGraphicsExposeEvent.nminor_code(address());
/*     */     }
/*     */     public Buffer type(int value) {
/* 454 */       XGraphicsExposeEvent.ntype(address(), value); return this;
/*     */     } public Buffer serial(@NativeType("unsigned long") long value) {
/* 456 */       XGraphicsExposeEvent.nserial(address(), value); return this;
/*     */     } public Buffer send_event(@NativeType("Bool") boolean value) {
/* 458 */       XGraphicsExposeEvent.nsend_event(address(), value ? 1 : 0); return this;
/*     */     } public Buffer display(@NativeType("Display *") long value) {
/* 460 */       XGraphicsExposeEvent.ndisplay(address(), value); return this;
/*     */     } public Buffer drawable(@NativeType("Drawable") long value) {
/* 462 */       XGraphicsExposeEvent.ndrawable(address(), value); return this;
/*     */     } public Buffer x(int value) {
/* 464 */       XGraphicsExposeEvent.nx(address(), value); return this;
/*     */     } public Buffer y(int value) {
/* 466 */       XGraphicsExposeEvent.ny(address(), value); return this;
/*     */     } public Buffer width(int value) {
/* 468 */       XGraphicsExposeEvent.nwidth(address(), value); return this;
/*     */     } public Buffer height(int value) {
/* 470 */       XGraphicsExposeEvent.nheight(address(), value); return this;
/*     */     } public Buffer count(int value) {
/* 472 */       XGraphicsExposeEvent.ncount(address(), value); return this;
/*     */     } public Buffer major_code(int value) {
/* 474 */       XGraphicsExposeEvent.nmajor_code(address(), value); return this;
/*     */     } public Buffer minor_code(int value) {
/* 476 */       XGraphicsExposeEvent.nminor_code(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\XGraphicsExposeEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */