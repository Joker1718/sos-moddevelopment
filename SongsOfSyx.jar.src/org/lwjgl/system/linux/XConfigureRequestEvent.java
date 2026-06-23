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
/*     */ 
/*     */ 
/*     */ public class XConfigureRequestEvent
/*     */   extends Struct<XConfigureRequestEvent>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int TYPE;
/*     */   public static final int SERIAL;
/*     */   public static final int SEND_EVENT;
/*     */   public static final int DISPLAY;
/*     */   public static final int PARENT;
/*     */   public static final int WINDOW;
/*     */   public static final int X;
/*     */   public static final int Y;
/*     */   public static final int WIDTH;
/*     */   public static final int HEIGHT;
/*     */   public static final int BORDER_WIDTH;
/*     */   public static final int ABOVE;
/*     */   public static final int DETAIL;
/*     */   public static final int VALUE_MASK;
/*     */   
/*     */   static {
/*  64 */     Struct.Layout layout = __struct(new Struct.Member[] { 
/*  65 */           __member(4), 
/*  66 */           __member(CLONG_SIZE), 
/*  67 */           __member(4), 
/*  68 */           __member(POINTER_SIZE), 
/*  69 */           __member(CLONG_SIZE), 
/*  70 */           __member(CLONG_SIZE), 
/*  71 */           __member(4), 
/*  72 */           __member(4), 
/*  73 */           __member(4), 
/*  74 */           __member(4), 
/*  75 */           __member(4), 
/*  76 */           __member(CLONG_SIZE), 
/*  77 */           __member(4), 
/*  78 */           __member(CLONG_SIZE) });
/*     */ 
/*     */     
/*  81 */     SIZEOF = layout.getSize();
/*  82 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  84 */     TYPE = layout.offsetof(0);
/*  85 */     SERIAL = layout.offsetof(1);
/*  86 */     SEND_EVENT = layout.offsetof(2);
/*  87 */     DISPLAY = layout.offsetof(3);
/*  88 */     PARENT = layout.offsetof(4);
/*  89 */     WINDOW = layout.offsetof(5);
/*  90 */     X = layout.offsetof(6);
/*  91 */     Y = layout.offsetof(7);
/*  92 */     WIDTH = layout.offsetof(8);
/*  93 */     HEIGHT = layout.offsetof(9);
/*  94 */     BORDER_WIDTH = layout.offsetof(10);
/*  95 */     ABOVE = layout.offsetof(11);
/*  96 */     DETAIL = layout.offsetof(12);
/*  97 */     VALUE_MASK = layout.offsetof(13);
/*     */   }
/*     */   
/*     */   protected XConfigureRequestEvent(long address, ByteBuffer container) {
/* 101 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected XConfigureRequestEvent create(long address, ByteBuffer container) {
/* 106 */     return new XConfigureRequestEvent(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XConfigureRequestEvent(ByteBuffer container) {
/* 116 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/* 120 */     return SIZEOF;
/*     */   }
/*     */   public int type() {
/* 123 */     return ntype(address());
/*     */   } @NativeType("unsigned long")
/*     */   public long serial() {
/* 126 */     return nserial(address());
/*     */   } @NativeType("Bool")
/*     */   public boolean send_event() {
/* 129 */     return (nsend_event(address()) != 0);
/*     */   } @NativeType("Display *")
/*     */   public long display() {
/* 132 */     return ndisplay(address());
/*     */   } @NativeType("Window")
/*     */   public long parent() {
/* 135 */     return nparent(address());
/*     */   } @NativeType("Window")
/*     */   public long window() {
/* 138 */     return nwindow(address());
/*     */   } public int x() {
/* 140 */     return nx(address());
/*     */   } public int y() {
/* 142 */     return ny(address());
/*     */   } public int width() {
/* 144 */     return nwidth(address());
/*     */   } public int height() {
/* 146 */     return nheight(address());
/*     */   } public int border_width() {
/* 148 */     return nborder_width(address());
/*     */   } @NativeType("Window")
/*     */   public long above() {
/* 151 */     return nabove(address());
/*     */   } public int detail() {
/* 153 */     return ndetail(address());
/*     */   } @NativeType("unsigned long")
/*     */   public long value_mask() {
/* 156 */     return nvalue_mask(address());
/*     */   }
/*     */   public XConfigureRequestEvent type(int value) {
/* 159 */     ntype(address(), value); return this;
/*     */   } public XConfigureRequestEvent serial(@NativeType("unsigned long") long value) {
/* 161 */     nserial(address(), value); return this;
/*     */   } public XConfigureRequestEvent send_event(@NativeType("Bool") boolean value) {
/* 163 */     nsend_event(address(), value ? 1 : 0); return this;
/*     */   } public XConfigureRequestEvent display(@NativeType("Display *") long value) {
/* 165 */     ndisplay(address(), value); return this;
/*     */   } public XConfigureRequestEvent parent(@NativeType("Window") long value) {
/* 167 */     nparent(address(), value); return this;
/*     */   } public XConfigureRequestEvent window(@NativeType("Window") long value) {
/* 169 */     nwindow(address(), value); return this;
/*     */   } public XConfigureRequestEvent x(int value) {
/* 171 */     nx(address(), value); return this;
/*     */   } public XConfigureRequestEvent y(int value) {
/* 173 */     ny(address(), value); return this;
/*     */   } public XConfigureRequestEvent width(int value) {
/* 175 */     nwidth(address(), value); return this;
/*     */   } public XConfigureRequestEvent height(int value) {
/* 177 */     nheight(address(), value); return this;
/*     */   } public XConfigureRequestEvent border_width(int value) {
/* 179 */     nborder_width(address(), value); return this;
/*     */   } public XConfigureRequestEvent above(@NativeType("Window") long value) {
/* 181 */     nabove(address(), value); return this;
/*     */   } public XConfigureRequestEvent detail(int value) {
/* 183 */     ndetail(address(), value); return this;
/*     */   } public XConfigureRequestEvent value_mask(@NativeType("unsigned long") long value) {
/* 185 */     nvalue_mask(address(), value); return this;
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
/*     */ 
/*     */   
/*     */   public XConfigureRequestEvent set(int type, long serial, boolean send_event, long display, long parent, long window, int x, int y, int width, int height, int border_width, long above, int detail, long value_mask) {
/* 204 */     type(type);
/* 205 */     serial(serial);
/* 206 */     send_event(send_event);
/* 207 */     display(display);
/* 208 */     parent(parent);
/* 209 */     window(window);
/* 210 */     x(x);
/* 211 */     y(y);
/* 212 */     width(width);
/* 213 */     height(height);
/* 214 */     border_width(border_width);
/* 215 */     above(above);
/* 216 */     detail(detail);
/* 217 */     value_mask(value_mask);
/*     */     
/* 219 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XConfigureRequestEvent set(XConfigureRequestEvent src) {
/* 230 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 231 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XConfigureRequestEvent malloc() {
/* 238 */     return new XConfigureRequestEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XConfigureRequestEvent calloc() {
/* 243 */     return new XConfigureRequestEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XConfigureRequestEvent create() {
/* 248 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 249 */     return new XConfigureRequestEvent(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XConfigureRequestEvent create(long address) {
/* 254 */     return new XConfigureRequestEvent(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XConfigureRequestEvent createSafe(long address) {
/* 259 */     return (address == 0L) ? null : new XConfigureRequestEvent(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 268 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 277 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 286 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 287 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 297 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 302 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XConfigureRequestEvent malloc(MemoryStack stack) {
/* 311 */     return new XConfigureRequestEvent(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XConfigureRequestEvent calloc(MemoryStack stack) {
/* 320 */     return new XConfigureRequestEvent(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 330 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 340 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int ntype(long struct) {
/* 346 */     return MemoryUtil.memGetInt(struct + TYPE);
/*     */   } public static long nserial(long struct) {
/* 348 */     return MemoryUtil.memGetCLong(struct + SERIAL);
/*     */   } public static int nsend_event(long struct) {
/* 350 */     return MemoryUtil.memGetInt(struct + SEND_EVENT);
/*     */   } public static long ndisplay(long struct) {
/* 352 */     return MemoryUtil.memGetAddress(struct + DISPLAY);
/*     */   } public static long nparent(long struct) {
/* 354 */     return MemoryUtil.memGetCLong(struct + PARENT);
/*     */   } public static long nwindow(long struct) {
/* 356 */     return MemoryUtil.memGetCLong(struct + WINDOW);
/*     */   } public static int nx(long struct) {
/* 358 */     return MemoryUtil.memGetInt(struct + X);
/*     */   } public static int ny(long struct) {
/* 360 */     return MemoryUtil.memGetInt(struct + Y);
/*     */   } public static int nwidth(long struct) {
/* 362 */     return MemoryUtil.memGetInt(struct + WIDTH);
/*     */   } public static int nheight(long struct) {
/* 364 */     return MemoryUtil.memGetInt(struct + HEIGHT);
/*     */   } public static int nborder_width(long struct) {
/* 366 */     return MemoryUtil.memGetInt(struct + BORDER_WIDTH);
/*     */   } public static long nabove(long struct) {
/* 368 */     return MemoryUtil.memGetCLong(struct + ABOVE);
/*     */   } public static int ndetail(long struct) {
/* 370 */     return MemoryUtil.memGetInt(struct + DETAIL);
/*     */   } public static long nvalue_mask(long struct) {
/* 372 */     return MemoryUtil.memGetCLong(struct + VALUE_MASK);
/*     */   }
/*     */   public static void ntype(long struct, int value) {
/* 375 */     MemoryUtil.memPutInt(struct + TYPE, value);
/*     */   } public static void nserial(long struct, long value) {
/* 377 */     MemoryUtil.memPutCLong(struct + SERIAL, value);
/*     */   } public static void nsend_event(long struct, int value) {
/* 379 */     MemoryUtil.memPutInt(struct + SEND_EVENT, value);
/*     */   } public static void ndisplay(long struct, long value) {
/* 381 */     MemoryUtil.memPutAddress(struct + DISPLAY, Checks.check(value));
/*     */   } public static void nparent(long struct, long value) {
/* 383 */     MemoryUtil.memPutCLong(struct + PARENT, value);
/*     */   } public static void nwindow(long struct, long value) {
/* 385 */     MemoryUtil.memPutCLong(struct + WINDOW, value);
/*     */   } public static void nx(long struct, int value) {
/* 387 */     MemoryUtil.memPutInt(struct + X, value);
/*     */   } public static void ny(long struct, int value) {
/* 389 */     MemoryUtil.memPutInt(struct + Y, value);
/*     */   } public static void nwidth(long struct, int value) {
/* 391 */     MemoryUtil.memPutInt(struct + WIDTH, value);
/*     */   } public static void nheight(long struct, int value) {
/* 393 */     MemoryUtil.memPutInt(struct + HEIGHT, value);
/*     */   } public static void nborder_width(long struct, int value) {
/* 395 */     MemoryUtil.memPutInt(struct + BORDER_WIDTH, value);
/*     */   } public static void nabove(long struct, long value) {
/* 397 */     MemoryUtil.memPutCLong(struct + ABOVE, value);
/*     */   } public static void ndetail(long struct, int value) {
/* 399 */     MemoryUtil.memPutInt(struct + DETAIL, value);
/*     */   } public static void nvalue_mask(long struct, long value) {
/* 401 */     MemoryUtil.memPutCLong(struct + VALUE_MASK, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long struct) {
/* 409 */     Checks.check(MemoryUtil.memGetAddress(struct + DISPLAY));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<XConfigureRequestEvent, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 417 */     private static final XConfigureRequestEvent ELEMENT_FACTORY = XConfigureRequestEvent.create(-1L);
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
/* 429 */       super(container, container.remaining() / XConfigureRequestEvent.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 433 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 437 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 442 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 447 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected XConfigureRequestEvent getElementFactory() {
/* 452 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     public int type() {
/* 456 */       return XConfigureRequestEvent.ntype(address());
/*     */     } @NativeType("unsigned long")
/*     */     public long serial() {
/* 459 */       return XConfigureRequestEvent.nserial(address());
/*     */     } @NativeType("Bool")
/*     */     public boolean send_event() {
/* 462 */       return (XConfigureRequestEvent.nsend_event(address()) != 0);
/*     */     } @NativeType("Display *")
/*     */     public long display() {
/* 465 */       return XConfigureRequestEvent.ndisplay(address());
/*     */     } @NativeType("Window")
/*     */     public long parent() {
/* 468 */       return XConfigureRequestEvent.nparent(address());
/*     */     } @NativeType("Window")
/*     */     public long window() {
/* 471 */       return XConfigureRequestEvent.nwindow(address());
/*     */     } public int x() {
/* 473 */       return XConfigureRequestEvent.nx(address());
/*     */     } public int y() {
/* 475 */       return XConfigureRequestEvent.ny(address());
/*     */     } public int width() {
/* 477 */       return XConfigureRequestEvent.nwidth(address());
/*     */     } public int height() {
/* 479 */       return XConfigureRequestEvent.nheight(address());
/*     */     } public int border_width() {
/* 481 */       return XConfigureRequestEvent.nborder_width(address());
/*     */     } @NativeType("Window")
/*     */     public long above() {
/* 484 */       return XConfigureRequestEvent.nabove(address());
/*     */     } public int detail() {
/* 486 */       return XConfigureRequestEvent.ndetail(address());
/*     */     } @NativeType("unsigned long")
/*     */     public long value_mask() {
/* 489 */       return XConfigureRequestEvent.nvalue_mask(address());
/*     */     }
/*     */     public Buffer type(int value) {
/* 492 */       XConfigureRequestEvent.ntype(address(), value); return this;
/*     */     } public Buffer serial(@NativeType("unsigned long") long value) {
/* 494 */       XConfigureRequestEvent.nserial(address(), value); return this;
/*     */     } public Buffer send_event(@NativeType("Bool") boolean value) {
/* 496 */       XConfigureRequestEvent.nsend_event(address(), value ? 1 : 0); return this;
/*     */     } public Buffer display(@NativeType("Display *") long value) {
/* 498 */       XConfigureRequestEvent.ndisplay(address(), value); return this;
/*     */     } public Buffer parent(@NativeType("Window") long value) {
/* 500 */       XConfigureRequestEvent.nparent(address(), value); return this;
/*     */     } public Buffer window(@NativeType("Window") long value) {
/* 502 */       XConfigureRequestEvent.nwindow(address(), value); return this;
/*     */     } public Buffer x(int value) {
/* 504 */       XConfigureRequestEvent.nx(address(), value); return this;
/*     */     } public Buffer y(int value) {
/* 506 */       XConfigureRequestEvent.ny(address(), value); return this;
/*     */     } public Buffer width(int value) {
/* 508 */       XConfigureRequestEvent.nwidth(address(), value); return this;
/*     */     } public Buffer height(int value) {
/* 510 */       XConfigureRequestEvent.nheight(address(), value); return this;
/*     */     } public Buffer border_width(int value) {
/* 512 */       XConfigureRequestEvent.nborder_width(address(), value); return this;
/*     */     } public Buffer above(@NativeType("Window") long value) {
/* 514 */       XConfigureRequestEvent.nabove(address(), value); return this;
/*     */     } public Buffer detail(int value) {
/* 516 */       XConfigureRequestEvent.ndetail(address(), value); return this;
/*     */     } public Buffer value_mask(@NativeType("unsigned long") long value) {
/* 518 */       XConfigureRequestEvent.nvalue_mask(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\XConfigureRequestEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */