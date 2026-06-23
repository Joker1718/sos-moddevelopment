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
/*     */ public class XCreateWindowEvent
/*     */   extends Struct<XCreateWindowEvent>
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
/*     */   public static final int OVERRIDE_REDIRECT;
/*     */   
/*     */   static {
/*  60 */     Struct.Layout layout = __struct(new Struct.Member[] { 
/*  61 */           __member(4), 
/*  62 */           __member(CLONG_SIZE), 
/*  63 */           __member(4), 
/*  64 */           __member(POINTER_SIZE), 
/*  65 */           __member(CLONG_SIZE), 
/*  66 */           __member(CLONG_SIZE), 
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
/*  82 */     PARENT = layout.offsetof(4);
/*  83 */     WINDOW = layout.offsetof(5);
/*  84 */     X = layout.offsetof(6);
/*  85 */     Y = layout.offsetof(7);
/*  86 */     WIDTH = layout.offsetof(8);
/*  87 */     HEIGHT = layout.offsetof(9);
/*  88 */     BORDER_WIDTH = layout.offsetof(10);
/*  89 */     OVERRIDE_REDIRECT = layout.offsetof(11);
/*     */   }
/*     */   
/*     */   protected XCreateWindowEvent(long address, ByteBuffer container) {
/*  93 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected XCreateWindowEvent create(long address, ByteBuffer container) {
/*  98 */     return new XCreateWindowEvent(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XCreateWindowEvent(ByteBuffer container) {
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
/*     */   } @NativeType("Window")
/*     */   public long parent() {
/* 127 */     return nparent(address());
/*     */   } @NativeType("Window")
/*     */   public long window() {
/* 130 */     return nwindow(address());
/*     */   } public int x() {
/* 132 */     return nx(address());
/*     */   } public int y() {
/* 134 */     return ny(address());
/*     */   } public int width() {
/* 136 */     return nwidth(address());
/*     */   } public int height() {
/* 138 */     return nheight(address());
/*     */   } public int border_width() {
/* 140 */     return nborder_width(address());
/*     */   } public int override_redirect() {
/* 142 */     return noverride_redirect(address());
/*     */   }
/*     */   public XCreateWindowEvent type(int value) {
/* 145 */     ntype(address(), value); return this;
/*     */   } public XCreateWindowEvent serial(@NativeType("unsigned long") long value) {
/* 147 */     nserial(address(), value); return this;
/*     */   } public XCreateWindowEvent send_event(@NativeType("Bool") boolean value) {
/* 149 */     nsend_event(address(), value ? 1 : 0); return this;
/*     */   } public XCreateWindowEvent display(@NativeType("Display *") long value) {
/* 151 */     ndisplay(address(), value); return this;
/*     */   } public XCreateWindowEvent parent(@NativeType("Window") long value) {
/* 153 */     nparent(address(), value); return this;
/*     */   } public XCreateWindowEvent window(@NativeType("Window") long value) {
/* 155 */     nwindow(address(), value); return this;
/*     */   } public XCreateWindowEvent x(int value) {
/* 157 */     nx(address(), value); return this;
/*     */   } public XCreateWindowEvent y(int value) {
/* 159 */     ny(address(), value); return this;
/*     */   } public XCreateWindowEvent width(int value) {
/* 161 */     nwidth(address(), value); return this;
/*     */   } public XCreateWindowEvent height(int value) {
/* 163 */     nheight(address(), value); return this;
/*     */   } public XCreateWindowEvent border_width(int value) {
/* 165 */     nborder_width(address(), value); return this;
/*     */   } public XCreateWindowEvent override_redirect(int value) {
/* 167 */     noverride_redirect(address(), value); return this;
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
/*     */   public XCreateWindowEvent set(int type, long serial, boolean send_event, long display, long parent, long window, int x, int y, int width, int height, int border_width, int override_redirect) {
/* 184 */     type(type);
/* 185 */     serial(serial);
/* 186 */     send_event(send_event);
/* 187 */     display(display);
/* 188 */     parent(parent);
/* 189 */     window(window);
/* 190 */     x(x);
/* 191 */     y(y);
/* 192 */     width(width);
/* 193 */     height(height);
/* 194 */     border_width(border_width);
/* 195 */     override_redirect(override_redirect);
/*     */     
/* 197 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XCreateWindowEvent set(XCreateWindowEvent src) {
/* 208 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 209 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XCreateWindowEvent malloc() {
/* 216 */     return new XCreateWindowEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XCreateWindowEvent calloc() {
/* 221 */     return new XCreateWindowEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XCreateWindowEvent create() {
/* 226 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 227 */     return new XCreateWindowEvent(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XCreateWindowEvent create(long address) {
/* 232 */     return new XCreateWindowEvent(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XCreateWindowEvent createSafe(long address) {
/* 237 */     return (address == 0L) ? null : new XCreateWindowEvent(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 246 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 255 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 264 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 265 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 275 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 280 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XCreateWindowEvent malloc(MemoryStack stack) {
/* 289 */     return new XCreateWindowEvent(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XCreateWindowEvent calloc(MemoryStack stack) {
/* 298 */     return new XCreateWindowEvent(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 308 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 318 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int ntype(long struct) {
/* 324 */     return MemoryUtil.memGetInt(struct + TYPE);
/*     */   } public static long nserial(long struct) {
/* 326 */     return MemoryUtil.memGetCLong(struct + SERIAL);
/*     */   } public static int nsend_event(long struct) {
/* 328 */     return MemoryUtil.memGetInt(struct + SEND_EVENT);
/*     */   } public static long ndisplay(long struct) {
/* 330 */     return MemoryUtil.memGetAddress(struct + DISPLAY);
/*     */   } public static long nparent(long struct) {
/* 332 */     return MemoryUtil.memGetCLong(struct + PARENT);
/*     */   } public static long nwindow(long struct) {
/* 334 */     return MemoryUtil.memGetCLong(struct + WINDOW);
/*     */   } public static int nx(long struct) {
/* 336 */     return MemoryUtil.memGetInt(struct + X);
/*     */   } public static int ny(long struct) {
/* 338 */     return MemoryUtil.memGetInt(struct + Y);
/*     */   } public static int nwidth(long struct) {
/* 340 */     return MemoryUtil.memGetInt(struct + WIDTH);
/*     */   } public static int nheight(long struct) {
/* 342 */     return MemoryUtil.memGetInt(struct + HEIGHT);
/*     */   } public static int nborder_width(long struct) {
/* 344 */     return MemoryUtil.memGetInt(struct + BORDER_WIDTH);
/*     */   } public static int noverride_redirect(long struct) {
/* 346 */     return MemoryUtil.memGetInt(struct + OVERRIDE_REDIRECT);
/*     */   }
/*     */   public static void ntype(long struct, int value) {
/* 349 */     MemoryUtil.memPutInt(struct + TYPE, value);
/*     */   } public static void nserial(long struct, long value) {
/* 351 */     MemoryUtil.memPutCLong(struct + SERIAL, value);
/*     */   } public static void nsend_event(long struct, int value) {
/* 353 */     MemoryUtil.memPutInt(struct + SEND_EVENT, value);
/*     */   } public static void ndisplay(long struct, long value) {
/* 355 */     MemoryUtil.memPutAddress(struct + DISPLAY, Checks.check(value));
/*     */   } public static void nparent(long struct, long value) {
/* 357 */     MemoryUtil.memPutCLong(struct + PARENT, value);
/*     */   } public static void nwindow(long struct, long value) {
/* 359 */     MemoryUtil.memPutCLong(struct + WINDOW, value);
/*     */   } public static void nx(long struct, int value) {
/* 361 */     MemoryUtil.memPutInt(struct + X, value);
/*     */   } public static void ny(long struct, int value) {
/* 363 */     MemoryUtil.memPutInt(struct + Y, value);
/*     */   } public static void nwidth(long struct, int value) {
/* 365 */     MemoryUtil.memPutInt(struct + WIDTH, value);
/*     */   } public static void nheight(long struct, int value) {
/* 367 */     MemoryUtil.memPutInt(struct + HEIGHT, value);
/*     */   } public static void nborder_width(long struct, int value) {
/* 369 */     MemoryUtil.memPutInt(struct + BORDER_WIDTH, value);
/*     */   } public static void noverride_redirect(long struct, int value) {
/* 371 */     MemoryUtil.memPutInt(struct + OVERRIDE_REDIRECT, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long struct) {
/* 379 */     Checks.check(MemoryUtil.memGetAddress(struct + DISPLAY));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<XCreateWindowEvent, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 387 */     private static final XCreateWindowEvent ELEMENT_FACTORY = XCreateWindowEvent.create(-1L);
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
/* 399 */       super(container, container.remaining() / XCreateWindowEvent.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 403 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 407 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 412 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 417 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected XCreateWindowEvent getElementFactory() {
/* 422 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     public int type() {
/* 426 */       return XCreateWindowEvent.ntype(address());
/*     */     } @NativeType("unsigned long")
/*     */     public long serial() {
/* 429 */       return XCreateWindowEvent.nserial(address());
/*     */     } @NativeType("Bool")
/*     */     public boolean send_event() {
/* 432 */       return (XCreateWindowEvent.nsend_event(address()) != 0);
/*     */     } @NativeType("Display *")
/*     */     public long display() {
/* 435 */       return XCreateWindowEvent.ndisplay(address());
/*     */     } @NativeType("Window")
/*     */     public long parent() {
/* 438 */       return XCreateWindowEvent.nparent(address());
/*     */     } @NativeType("Window")
/*     */     public long window() {
/* 441 */       return XCreateWindowEvent.nwindow(address());
/*     */     } public int x() {
/* 443 */       return XCreateWindowEvent.nx(address());
/*     */     } public int y() {
/* 445 */       return XCreateWindowEvent.ny(address());
/*     */     } public int width() {
/* 447 */       return XCreateWindowEvent.nwidth(address());
/*     */     } public int height() {
/* 449 */       return XCreateWindowEvent.nheight(address());
/*     */     } public int border_width() {
/* 451 */       return XCreateWindowEvent.nborder_width(address());
/*     */     } public int override_redirect() {
/* 453 */       return XCreateWindowEvent.noverride_redirect(address());
/*     */     }
/*     */     public Buffer type(int value) {
/* 456 */       XCreateWindowEvent.ntype(address(), value); return this;
/*     */     } public Buffer serial(@NativeType("unsigned long") long value) {
/* 458 */       XCreateWindowEvent.nserial(address(), value); return this;
/*     */     } public Buffer send_event(@NativeType("Bool") boolean value) {
/* 460 */       XCreateWindowEvent.nsend_event(address(), value ? 1 : 0); return this;
/*     */     } public Buffer display(@NativeType("Display *") long value) {
/* 462 */       XCreateWindowEvent.ndisplay(address(), value); return this;
/*     */     } public Buffer parent(@NativeType("Window") long value) {
/* 464 */       XCreateWindowEvent.nparent(address(), value); return this;
/*     */     } public Buffer window(@NativeType("Window") long value) {
/* 466 */       XCreateWindowEvent.nwindow(address(), value); return this;
/*     */     } public Buffer x(int value) {
/* 468 */       XCreateWindowEvent.nx(address(), value); return this;
/*     */     } public Buffer y(int value) {
/* 470 */       XCreateWindowEvent.ny(address(), value); return this;
/*     */     } public Buffer width(int value) {
/* 472 */       XCreateWindowEvent.nwidth(address(), value); return this;
/*     */     } public Buffer height(int value) {
/* 474 */       XCreateWindowEvent.nheight(address(), value); return this;
/*     */     } public Buffer border_width(int value) {
/* 476 */       XCreateWindowEvent.nborder_width(address(), value); return this;
/*     */     } public Buffer override_redirect(int value) {
/* 478 */       XCreateWindowEvent.noverride_redirect(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\XCreateWindowEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */