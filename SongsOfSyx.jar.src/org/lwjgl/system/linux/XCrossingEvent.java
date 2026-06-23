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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XCrossingEvent
/*     */   extends Struct<XCrossingEvent>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int TYPE;
/*     */   public static final int SERIAL;
/*     */   public static final int SEND_EVENT;
/*     */   public static final int DISPLAY;
/*     */   public static final int WINDOW;
/*     */   public static final int ROOT;
/*     */   public static final int SUBWINDOW;
/*     */   public static final int TIME;
/*     */   public static final int X;
/*     */   public static final int Y;
/*     */   public static final int X_ROOT;
/*     */   public static final int Y_ROOT;
/*     */   public static final int MODE;
/*     */   public static final int DETAIL;
/*     */   public static final int SAME_SCREEN;
/*     */   public static final int FOCUS;
/*     */   public static final int STATE;
/*     */   
/*     */   static {
/*  70 */     Struct.Layout layout = __struct(new Struct.Member[] { 
/*  71 */           __member(4), 
/*  72 */           __member(CLONG_SIZE), 
/*  73 */           __member(4), 
/*  74 */           __member(POINTER_SIZE), 
/*  75 */           __member(CLONG_SIZE), 
/*  76 */           __member(CLONG_SIZE), 
/*  77 */           __member(CLONG_SIZE), 
/*  78 */           __member(CLONG_SIZE), 
/*  79 */           __member(4), 
/*  80 */           __member(4), 
/*  81 */           __member(4), 
/*  82 */           __member(4), 
/*  83 */           __member(4), 
/*  84 */           __member(4), 
/*  85 */           __member(4), 
/*  86 */           __member(4), 
/*  87 */           __member(4) });
/*     */ 
/*     */     
/*  90 */     SIZEOF = layout.getSize();
/*  91 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  93 */     TYPE = layout.offsetof(0);
/*  94 */     SERIAL = layout.offsetof(1);
/*  95 */     SEND_EVENT = layout.offsetof(2);
/*  96 */     DISPLAY = layout.offsetof(3);
/*  97 */     WINDOW = layout.offsetof(4);
/*  98 */     ROOT = layout.offsetof(5);
/*  99 */     SUBWINDOW = layout.offsetof(6);
/* 100 */     TIME = layout.offsetof(7);
/* 101 */     X = layout.offsetof(8);
/* 102 */     Y = layout.offsetof(9);
/* 103 */     X_ROOT = layout.offsetof(10);
/* 104 */     Y_ROOT = layout.offsetof(11);
/* 105 */     MODE = layout.offsetof(12);
/* 106 */     DETAIL = layout.offsetof(13);
/* 107 */     SAME_SCREEN = layout.offsetof(14);
/* 108 */     FOCUS = layout.offsetof(15);
/* 109 */     STATE = layout.offsetof(16);
/*     */   }
/*     */   
/*     */   protected XCrossingEvent(long address, ByteBuffer container) {
/* 113 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected XCrossingEvent create(long address, ByteBuffer container) {
/* 118 */     return new XCrossingEvent(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XCrossingEvent(ByteBuffer container) {
/* 128 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/* 132 */     return SIZEOF;
/*     */   }
/*     */   public int type() {
/* 135 */     return ntype(address());
/*     */   } @NativeType("unsigned long")
/*     */   public long serial() {
/* 138 */     return nserial(address());
/*     */   } @NativeType("Bool")
/*     */   public boolean send_event() {
/* 141 */     return (nsend_event(address()) != 0);
/*     */   } @NativeType("Display *")
/*     */   public long display() {
/* 144 */     return ndisplay(address());
/*     */   } @NativeType("Window")
/*     */   public long window() {
/* 147 */     return nwindow(address());
/*     */   } @NativeType("Window")
/*     */   public long root() {
/* 150 */     return nroot(address());
/*     */   } @NativeType("Window")
/*     */   public long subwindow() {
/* 153 */     return nsubwindow(address());
/*     */   } @NativeType("Time")
/*     */   public long time() {
/* 156 */     return ntime(address());
/*     */   } public int x() {
/* 158 */     return nx(address());
/*     */   } public int y() {
/* 160 */     return ny(address());
/*     */   } public int x_root() {
/* 162 */     return nx_root(address());
/*     */   } public int y_root() {
/* 164 */     return ny_root(address());
/*     */   } public int mode() {
/* 166 */     return nmode(address());
/*     */   } public int detail() {
/* 168 */     return ndetail(address());
/*     */   } public int same_screen() {
/* 170 */     return nsame_screen(address());
/*     */   } public int focus() {
/* 172 */     return nfocus(address());
/*     */   } @NativeType("unsigned int")
/*     */   public int state() {
/* 175 */     return nstate(address());
/*     */   }
/*     */   public XCrossingEvent type(int value) {
/* 178 */     ntype(address(), value); return this;
/*     */   } public XCrossingEvent serial(@NativeType("unsigned long") long value) {
/* 180 */     nserial(address(), value); return this;
/*     */   } public XCrossingEvent send_event(@NativeType("Bool") boolean value) {
/* 182 */     nsend_event(address(), value ? 1 : 0); return this;
/*     */   } public XCrossingEvent display(@NativeType("Display *") long value) {
/* 184 */     ndisplay(address(), value); return this;
/*     */   } public XCrossingEvent window(@NativeType("Window") long value) {
/* 186 */     nwindow(address(), value); return this;
/*     */   } public XCrossingEvent root(@NativeType("Window") long value) {
/* 188 */     nroot(address(), value); return this;
/*     */   } public XCrossingEvent subwindow(@NativeType("Window") long value) {
/* 190 */     nsubwindow(address(), value); return this;
/*     */   } public XCrossingEvent time(@NativeType("Time") long value) {
/* 192 */     ntime(address(), value); return this;
/*     */   } public XCrossingEvent x(int value) {
/* 194 */     nx(address(), value); return this;
/*     */   } public XCrossingEvent y(int value) {
/* 196 */     ny(address(), value); return this;
/*     */   } public XCrossingEvent x_root(int value) {
/* 198 */     nx_root(address(), value); return this;
/*     */   } public XCrossingEvent y_root(int value) {
/* 200 */     ny_root(address(), value); return this;
/*     */   } public XCrossingEvent mode(int value) {
/* 202 */     nmode(address(), value); return this;
/*     */   } public XCrossingEvent detail(int value) {
/* 204 */     ndetail(address(), value); return this;
/*     */   } public XCrossingEvent same_screen(int value) {
/* 206 */     nsame_screen(address(), value); return this;
/*     */   } public XCrossingEvent focus(int value) {
/* 208 */     nfocus(address(), value); return this;
/*     */   } public XCrossingEvent state(@NativeType("unsigned int") int value) {
/* 210 */     nstate(address(), value); return this;
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
/*     */ 
/*     */ 
/*     */   
/*     */   public XCrossingEvent set(int type, long serial, boolean send_event, long display, long window, long root, long subwindow, long time, int x, int y, int x_root, int y_root, int mode, int detail, int same_screen, int focus, int state) {
/* 232 */     type(type);
/* 233 */     serial(serial);
/* 234 */     send_event(send_event);
/* 235 */     display(display);
/* 236 */     window(window);
/* 237 */     root(root);
/* 238 */     subwindow(subwindow);
/* 239 */     time(time);
/* 240 */     x(x);
/* 241 */     y(y);
/* 242 */     x_root(x_root);
/* 243 */     y_root(y_root);
/* 244 */     mode(mode);
/* 245 */     detail(detail);
/* 246 */     same_screen(same_screen);
/* 247 */     focus(focus);
/* 248 */     state(state);
/*     */     
/* 250 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XCrossingEvent set(XCrossingEvent src) {
/* 261 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 262 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XCrossingEvent malloc() {
/* 269 */     return new XCrossingEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XCrossingEvent calloc() {
/* 274 */     return new XCrossingEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XCrossingEvent create() {
/* 279 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 280 */     return new XCrossingEvent(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XCrossingEvent create(long address) {
/* 285 */     return new XCrossingEvent(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XCrossingEvent createSafe(long address) {
/* 290 */     return (address == 0L) ? null : new XCrossingEvent(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 299 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 308 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 317 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 318 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 328 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 333 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XCrossingEvent malloc(MemoryStack stack) {
/* 342 */     return new XCrossingEvent(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XCrossingEvent calloc(MemoryStack stack) {
/* 351 */     return new XCrossingEvent(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 361 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 371 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int ntype(long struct) {
/* 377 */     return MemoryUtil.memGetInt(struct + TYPE);
/*     */   } public static long nserial(long struct) {
/* 379 */     return MemoryUtil.memGetCLong(struct + SERIAL);
/*     */   } public static int nsend_event(long struct) {
/* 381 */     return MemoryUtil.memGetInt(struct + SEND_EVENT);
/*     */   } public static long ndisplay(long struct) {
/* 383 */     return MemoryUtil.memGetAddress(struct + DISPLAY);
/*     */   } public static long nwindow(long struct) {
/* 385 */     return MemoryUtil.memGetCLong(struct + WINDOW);
/*     */   } public static long nroot(long struct) {
/* 387 */     return MemoryUtil.memGetCLong(struct + ROOT);
/*     */   } public static long nsubwindow(long struct) {
/* 389 */     return MemoryUtil.memGetCLong(struct + SUBWINDOW);
/*     */   } public static long ntime(long struct) {
/* 391 */     return MemoryUtil.memGetCLong(struct + TIME);
/*     */   } public static int nx(long struct) {
/* 393 */     return MemoryUtil.memGetInt(struct + X);
/*     */   } public static int ny(long struct) {
/* 395 */     return MemoryUtil.memGetInt(struct + Y);
/*     */   } public static int nx_root(long struct) {
/* 397 */     return MemoryUtil.memGetInt(struct + X_ROOT);
/*     */   } public static int ny_root(long struct) {
/* 399 */     return MemoryUtil.memGetInt(struct + Y_ROOT);
/*     */   } public static int nmode(long struct) {
/* 401 */     return MemoryUtil.memGetInt(struct + MODE);
/*     */   } public static int ndetail(long struct) {
/* 403 */     return MemoryUtil.memGetInt(struct + DETAIL);
/*     */   } public static int nsame_screen(long struct) {
/* 405 */     return MemoryUtil.memGetInt(struct + SAME_SCREEN);
/*     */   } public static int nfocus(long struct) {
/* 407 */     return MemoryUtil.memGetInt(struct + FOCUS);
/*     */   } public static int nstate(long struct) {
/* 409 */     return MemoryUtil.memGetInt(struct + STATE);
/*     */   }
/*     */   public static void ntype(long struct, int value) {
/* 412 */     MemoryUtil.memPutInt(struct + TYPE, value);
/*     */   } public static void nserial(long struct, long value) {
/* 414 */     MemoryUtil.memPutCLong(struct + SERIAL, value);
/*     */   } public static void nsend_event(long struct, int value) {
/* 416 */     MemoryUtil.memPutInt(struct + SEND_EVENT, value);
/*     */   } public static void ndisplay(long struct, long value) {
/* 418 */     MemoryUtil.memPutAddress(struct + DISPLAY, Checks.check(value));
/*     */   } public static void nwindow(long struct, long value) {
/* 420 */     MemoryUtil.memPutCLong(struct + WINDOW, value);
/*     */   } public static void nroot(long struct, long value) {
/* 422 */     MemoryUtil.memPutCLong(struct + ROOT, value);
/*     */   } public static void nsubwindow(long struct, long value) {
/* 424 */     MemoryUtil.memPutCLong(struct + SUBWINDOW, value);
/*     */   } public static void ntime(long struct, long value) {
/* 426 */     MemoryUtil.memPutCLong(struct + TIME, value);
/*     */   } public static void nx(long struct, int value) {
/* 428 */     MemoryUtil.memPutInt(struct + X, value);
/*     */   } public static void ny(long struct, int value) {
/* 430 */     MemoryUtil.memPutInt(struct + Y, value);
/*     */   } public static void nx_root(long struct, int value) {
/* 432 */     MemoryUtil.memPutInt(struct + X_ROOT, value);
/*     */   } public static void ny_root(long struct, int value) {
/* 434 */     MemoryUtil.memPutInt(struct + Y_ROOT, value);
/*     */   } public static void nmode(long struct, int value) {
/* 436 */     MemoryUtil.memPutInt(struct + MODE, value);
/*     */   } public static void ndetail(long struct, int value) {
/* 438 */     MemoryUtil.memPutInt(struct + DETAIL, value);
/*     */   } public static void nsame_screen(long struct, int value) {
/* 440 */     MemoryUtil.memPutInt(struct + SAME_SCREEN, value);
/*     */   } public static void nfocus(long struct, int value) {
/* 442 */     MemoryUtil.memPutInt(struct + FOCUS, value);
/*     */   } public static void nstate(long struct, int value) {
/* 444 */     MemoryUtil.memPutInt(struct + STATE, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long struct) {
/* 452 */     Checks.check(MemoryUtil.memGetAddress(struct + DISPLAY));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<XCrossingEvent, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 460 */     private static final XCrossingEvent ELEMENT_FACTORY = XCrossingEvent.create(-1L);
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
/* 472 */       super(container, container.remaining() / XCrossingEvent.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 476 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 480 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 485 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 490 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected XCrossingEvent getElementFactory() {
/* 495 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     public int type() {
/* 499 */       return XCrossingEvent.ntype(address());
/*     */     } @NativeType("unsigned long")
/*     */     public long serial() {
/* 502 */       return XCrossingEvent.nserial(address());
/*     */     } @NativeType("Bool")
/*     */     public boolean send_event() {
/* 505 */       return (XCrossingEvent.nsend_event(address()) != 0);
/*     */     } @NativeType("Display *")
/*     */     public long display() {
/* 508 */       return XCrossingEvent.ndisplay(address());
/*     */     } @NativeType("Window")
/*     */     public long window() {
/* 511 */       return XCrossingEvent.nwindow(address());
/*     */     } @NativeType("Window")
/*     */     public long root() {
/* 514 */       return XCrossingEvent.nroot(address());
/*     */     } @NativeType("Window")
/*     */     public long subwindow() {
/* 517 */       return XCrossingEvent.nsubwindow(address());
/*     */     } @NativeType("Time")
/*     */     public long time() {
/* 520 */       return XCrossingEvent.ntime(address());
/*     */     } public int x() {
/* 522 */       return XCrossingEvent.nx(address());
/*     */     } public int y() {
/* 524 */       return XCrossingEvent.ny(address());
/*     */     } public int x_root() {
/* 526 */       return XCrossingEvent.nx_root(address());
/*     */     } public int y_root() {
/* 528 */       return XCrossingEvent.ny_root(address());
/*     */     } public int mode() {
/* 530 */       return XCrossingEvent.nmode(address());
/*     */     } public int detail() {
/* 532 */       return XCrossingEvent.ndetail(address());
/*     */     } public int same_screen() {
/* 534 */       return XCrossingEvent.nsame_screen(address());
/*     */     } public int focus() {
/* 536 */       return XCrossingEvent.nfocus(address());
/*     */     } @NativeType("unsigned int")
/*     */     public int state() {
/* 539 */       return XCrossingEvent.nstate(address());
/*     */     }
/*     */     public Buffer type(int value) {
/* 542 */       XCrossingEvent.ntype(address(), value); return this;
/*     */     } public Buffer serial(@NativeType("unsigned long") long value) {
/* 544 */       XCrossingEvent.nserial(address(), value); return this;
/*     */     } public Buffer send_event(@NativeType("Bool") boolean value) {
/* 546 */       XCrossingEvent.nsend_event(address(), value ? 1 : 0); return this;
/*     */     } public Buffer display(@NativeType("Display *") long value) {
/* 548 */       XCrossingEvent.ndisplay(address(), value); return this;
/*     */     } public Buffer window(@NativeType("Window") long value) {
/* 550 */       XCrossingEvent.nwindow(address(), value); return this;
/*     */     } public Buffer root(@NativeType("Window") long value) {
/* 552 */       XCrossingEvent.nroot(address(), value); return this;
/*     */     } public Buffer subwindow(@NativeType("Window") long value) {
/* 554 */       XCrossingEvent.nsubwindow(address(), value); return this;
/*     */     } public Buffer time(@NativeType("Time") long value) {
/* 556 */       XCrossingEvent.ntime(address(), value); return this;
/*     */     } public Buffer x(int value) {
/* 558 */       XCrossingEvent.nx(address(), value); return this;
/*     */     } public Buffer y(int value) {
/* 560 */       XCrossingEvent.ny(address(), value); return this;
/*     */     } public Buffer x_root(int value) {
/* 562 */       XCrossingEvent.nx_root(address(), value); return this;
/*     */     } public Buffer y_root(int value) {
/* 564 */       XCrossingEvent.ny_root(address(), value); return this;
/*     */     } public Buffer mode(int value) {
/* 566 */       XCrossingEvent.nmode(address(), value); return this;
/*     */     } public Buffer detail(int value) {
/* 568 */       XCrossingEvent.ndetail(address(), value); return this;
/*     */     } public Buffer same_screen(int value) {
/* 570 */       XCrossingEvent.nsame_screen(address(), value); return this;
/*     */     } public Buffer focus(int value) {
/* 572 */       XCrossingEvent.nfocus(address(), value); return this;
/*     */     } public Buffer state(@NativeType("unsigned int") int value) {
/* 574 */       XCrossingEvent.nstate(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\XCrossingEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */