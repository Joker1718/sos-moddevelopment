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
/*     */ public class XConfigureEvent
/*     */   extends Struct<XConfigureEvent>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int TYPE;
/*     */   public static final int SERIAL;
/*     */   public static final int SEND_EVENT;
/*     */   public static final int DISPLAY;
/*     */   public static final int WINDOW;
/*     */   public static final int X;
/*     */   public static final int Y;
/*     */   public static final int WIDTH;
/*     */   public static final int HEIGHT;
/*     */   public static final int BORDER_WIDTH;
/*     */   public static final int ABOVE;
/*     */   public static final int OVERRIDE_REDIRECT;
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
/*  71 */           __member(CLONG_SIZE), 
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
/*  82 */     WINDOW = layout.offsetof(4);
/*  83 */     X = layout.offsetof(5);
/*  84 */     Y = layout.offsetof(6);
/*  85 */     WIDTH = layout.offsetof(7);
/*  86 */     HEIGHT = layout.offsetof(8);
/*  87 */     BORDER_WIDTH = layout.offsetof(9);
/*  88 */     ABOVE = layout.offsetof(10);
/*  89 */     OVERRIDE_REDIRECT = layout.offsetof(11);
/*     */   }
/*     */   
/*     */   protected XConfigureEvent(long address, ByteBuffer container) {
/*  93 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected XConfigureEvent create(long address, ByteBuffer container) {
/*  98 */     return new XConfigureEvent(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XConfigureEvent(ByteBuffer container) {
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
/*     */   public long window() {
/* 127 */     return nwindow(address());
/*     */   } public int x() {
/* 129 */     return nx(address());
/*     */   } public int y() {
/* 131 */     return ny(address());
/*     */   } public int width() {
/* 133 */     return nwidth(address());
/*     */   } public int height() {
/* 135 */     return nheight(address());
/*     */   } public int border_width() {
/* 137 */     return nborder_width(address());
/*     */   } @NativeType("Window")
/*     */   public long above() {
/* 140 */     return nabove(address());
/*     */   } @NativeType("Bool")
/*     */   public boolean override_redirect() {
/* 143 */     return (noverride_redirect(address()) != 0);
/*     */   }
/*     */   public XConfigureEvent type(int value) {
/* 146 */     ntype(address(), value); return this;
/*     */   } public XConfigureEvent serial(@NativeType("unsigned long") long value) {
/* 148 */     nserial(address(), value); return this;
/*     */   } public XConfigureEvent send_event(@NativeType("Bool") boolean value) {
/* 150 */     nsend_event(address(), value ? 1 : 0); return this;
/*     */   } public XConfigureEvent display(@NativeType("Display *") long value) {
/* 152 */     ndisplay(address(), value); return this;
/*     */   } public XConfigureEvent window(@NativeType("Window") long value) {
/* 154 */     nwindow(address(), value); return this;
/*     */   } public XConfigureEvent x(int value) {
/* 156 */     nx(address(), value); return this;
/*     */   } public XConfigureEvent y(int value) {
/* 158 */     ny(address(), value); return this;
/*     */   } public XConfigureEvent width(int value) {
/* 160 */     nwidth(address(), value); return this;
/*     */   } public XConfigureEvent height(int value) {
/* 162 */     nheight(address(), value); return this;
/*     */   } public XConfigureEvent border_width(int value) {
/* 164 */     nborder_width(address(), value); return this;
/*     */   } public XConfigureEvent above(@NativeType("Window") long value) {
/* 166 */     nabove(address(), value); return this;
/*     */   } public XConfigureEvent override_redirect(@NativeType("Bool") boolean value) {
/* 168 */     noverride_redirect(address(), value ? 1 : 0); return this;
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
/*     */   public XConfigureEvent set(int type, long serial, boolean send_event, long display, long window, int x, int y, int width, int height, int border_width, long above, boolean override_redirect) {
/* 185 */     type(type);
/* 186 */     serial(serial);
/* 187 */     send_event(send_event);
/* 188 */     display(display);
/* 189 */     window(window);
/* 190 */     x(x);
/* 191 */     y(y);
/* 192 */     width(width);
/* 193 */     height(height);
/* 194 */     border_width(border_width);
/* 195 */     above(above);
/* 196 */     override_redirect(override_redirect);
/*     */     
/* 198 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XConfigureEvent set(XConfigureEvent src) {
/* 209 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 210 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XConfigureEvent malloc() {
/* 217 */     return new XConfigureEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XConfigureEvent calloc() {
/* 222 */     return new XConfigureEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XConfigureEvent create() {
/* 227 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 228 */     return new XConfigureEvent(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XConfigureEvent create(long address) {
/* 233 */     return new XConfigureEvent(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XConfigureEvent createSafe(long address) {
/* 238 */     return (address == 0L) ? null : new XConfigureEvent(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 247 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 256 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 265 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 266 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 276 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 281 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XConfigureEvent malloc(MemoryStack stack) {
/* 290 */     return new XConfigureEvent(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XConfigureEvent calloc(MemoryStack stack) {
/* 299 */     return new XConfigureEvent(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 309 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 319 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int ntype(long struct) {
/* 325 */     return MemoryUtil.memGetInt(struct + TYPE);
/*     */   } public static long nserial(long struct) {
/* 327 */     return MemoryUtil.memGetCLong(struct + SERIAL);
/*     */   } public static int nsend_event(long struct) {
/* 329 */     return MemoryUtil.memGetInt(struct + SEND_EVENT);
/*     */   } public static long ndisplay(long struct) {
/* 331 */     return MemoryUtil.memGetAddress(struct + DISPLAY);
/*     */   } public static long nwindow(long struct) {
/* 333 */     return MemoryUtil.memGetCLong(struct + WINDOW);
/*     */   } public static int nx(long struct) {
/* 335 */     return MemoryUtil.memGetInt(struct + X);
/*     */   } public static int ny(long struct) {
/* 337 */     return MemoryUtil.memGetInt(struct + Y);
/*     */   } public static int nwidth(long struct) {
/* 339 */     return MemoryUtil.memGetInt(struct + WIDTH);
/*     */   } public static int nheight(long struct) {
/* 341 */     return MemoryUtil.memGetInt(struct + HEIGHT);
/*     */   } public static int nborder_width(long struct) {
/* 343 */     return MemoryUtil.memGetInt(struct + BORDER_WIDTH);
/*     */   } public static long nabove(long struct) {
/* 345 */     return MemoryUtil.memGetCLong(struct + ABOVE);
/*     */   } public static int noverride_redirect(long struct) {
/* 347 */     return MemoryUtil.memGetInt(struct + OVERRIDE_REDIRECT);
/*     */   }
/*     */   public static void ntype(long struct, int value) {
/* 350 */     MemoryUtil.memPutInt(struct + TYPE, value);
/*     */   } public static void nserial(long struct, long value) {
/* 352 */     MemoryUtil.memPutCLong(struct + SERIAL, value);
/*     */   } public static void nsend_event(long struct, int value) {
/* 354 */     MemoryUtil.memPutInt(struct + SEND_EVENT, value);
/*     */   } public static void ndisplay(long struct, long value) {
/* 356 */     MemoryUtil.memPutAddress(struct + DISPLAY, Checks.check(value));
/*     */   } public static void nwindow(long struct, long value) {
/* 358 */     MemoryUtil.memPutCLong(struct + WINDOW, value);
/*     */   } public static void nx(long struct, int value) {
/* 360 */     MemoryUtil.memPutInt(struct + X, value);
/*     */   } public static void ny(long struct, int value) {
/* 362 */     MemoryUtil.memPutInt(struct + Y, value);
/*     */   } public static void nwidth(long struct, int value) {
/* 364 */     MemoryUtil.memPutInt(struct + WIDTH, value);
/*     */   } public static void nheight(long struct, int value) {
/* 366 */     MemoryUtil.memPutInt(struct + HEIGHT, value);
/*     */   } public static void nborder_width(long struct, int value) {
/* 368 */     MemoryUtil.memPutInt(struct + BORDER_WIDTH, value);
/*     */   } public static void nabove(long struct, long value) {
/* 370 */     MemoryUtil.memPutCLong(struct + ABOVE, value);
/*     */   } public static void noverride_redirect(long struct, int value) {
/* 372 */     MemoryUtil.memPutInt(struct + OVERRIDE_REDIRECT, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long struct) {
/* 380 */     Checks.check(MemoryUtil.memGetAddress(struct + DISPLAY));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<XConfigureEvent, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 388 */     private static final XConfigureEvent ELEMENT_FACTORY = XConfigureEvent.create(-1L);
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
/* 400 */       super(container, container.remaining() / XConfigureEvent.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 404 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 408 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 413 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 418 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected XConfigureEvent getElementFactory() {
/* 423 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     public int type() {
/* 427 */       return XConfigureEvent.ntype(address());
/*     */     } @NativeType("unsigned long")
/*     */     public long serial() {
/* 430 */       return XConfigureEvent.nserial(address());
/*     */     } @NativeType("Bool")
/*     */     public boolean send_event() {
/* 433 */       return (XConfigureEvent.nsend_event(address()) != 0);
/*     */     } @NativeType("Display *")
/*     */     public long display() {
/* 436 */       return XConfigureEvent.ndisplay(address());
/*     */     } @NativeType("Window")
/*     */     public long window() {
/* 439 */       return XConfigureEvent.nwindow(address());
/*     */     } public int x() {
/* 441 */       return XConfigureEvent.nx(address());
/*     */     } public int y() {
/* 443 */       return XConfigureEvent.ny(address());
/*     */     } public int width() {
/* 445 */       return XConfigureEvent.nwidth(address());
/*     */     } public int height() {
/* 447 */       return XConfigureEvent.nheight(address());
/*     */     } public int border_width() {
/* 449 */       return XConfigureEvent.nborder_width(address());
/*     */     } @NativeType("Window")
/*     */     public long above() {
/* 452 */       return XConfigureEvent.nabove(address());
/*     */     } @NativeType("Bool")
/*     */     public boolean override_redirect() {
/* 455 */       return (XConfigureEvent.noverride_redirect(address()) != 0);
/*     */     }
/*     */     public Buffer type(int value) {
/* 458 */       XConfigureEvent.ntype(address(), value); return this;
/*     */     } public Buffer serial(@NativeType("unsigned long") long value) {
/* 460 */       XConfigureEvent.nserial(address(), value); return this;
/*     */     } public Buffer send_event(@NativeType("Bool") boolean value) {
/* 462 */       XConfigureEvent.nsend_event(address(), value ? 1 : 0); return this;
/*     */     } public Buffer display(@NativeType("Display *") long value) {
/* 464 */       XConfigureEvent.ndisplay(address(), value); return this;
/*     */     } public Buffer window(@NativeType("Window") long value) {
/* 466 */       XConfigureEvent.nwindow(address(), value); return this;
/*     */     } public Buffer x(int value) {
/* 468 */       XConfigureEvent.nx(address(), value); return this;
/*     */     } public Buffer y(int value) {
/* 470 */       XConfigureEvent.ny(address(), value); return this;
/*     */     } public Buffer width(int value) {
/* 472 */       XConfigureEvent.nwidth(address(), value); return this;
/*     */     } public Buffer height(int value) {
/* 474 */       XConfigureEvent.nheight(address(), value); return this;
/*     */     } public Buffer border_width(int value) {
/* 476 */       XConfigureEvent.nborder_width(address(), value); return this;
/*     */     } public Buffer above(@NativeType("Window") long value) {
/* 478 */       XConfigureEvent.nabove(address(), value); return this;
/*     */     } public Buffer override_redirect(@NativeType("Bool") boolean value) {
/* 480 */       XConfigureEvent.noverride_redirect(address(), value ? 1 : 0); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\XConfigureEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */