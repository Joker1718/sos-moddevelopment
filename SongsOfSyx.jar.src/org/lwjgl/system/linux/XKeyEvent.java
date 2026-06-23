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
/*     */ public class XKeyEvent
/*     */   extends Struct<XKeyEvent>
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
/*     */   public static final int STATE;
/*     */   public static final int KEYCODE;
/*     */   public static final int SAME_SCREEN;
/*     */   
/*     */   static {
/*  66 */     Struct.Layout layout = __struct(new Struct.Member[] { 
/*  67 */           __member(4), 
/*  68 */           __member(CLONG_SIZE), 
/*  69 */           __member(4), 
/*  70 */           __member(POINTER_SIZE), 
/*  71 */           __member(CLONG_SIZE), 
/*  72 */           __member(CLONG_SIZE), 
/*  73 */           __member(CLONG_SIZE), 
/*  74 */           __member(CLONG_SIZE), 
/*  75 */           __member(4), 
/*  76 */           __member(4), 
/*  77 */           __member(4), 
/*  78 */           __member(4), 
/*  79 */           __member(4), 
/*  80 */           __member(4), 
/*  81 */           __member(4) });
/*     */ 
/*     */     
/*  84 */     SIZEOF = layout.getSize();
/*  85 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  87 */     TYPE = layout.offsetof(0);
/*  88 */     SERIAL = layout.offsetof(1);
/*  89 */     SEND_EVENT = layout.offsetof(2);
/*  90 */     DISPLAY = layout.offsetof(3);
/*  91 */     WINDOW = layout.offsetof(4);
/*  92 */     ROOT = layout.offsetof(5);
/*  93 */     SUBWINDOW = layout.offsetof(6);
/*  94 */     TIME = layout.offsetof(7);
/*  95 */     X = layout.offsetof(8);
/*  96 */     Y = layout.offsetof(9);
/*  97 */     X_ROOT = layout.offsetof(10);
/*  98 */     Y_ROOT = layout.offsetof(11);
/*  99 */     STATE = layout.offsetof(12);
/* 100 */     KEYCODE = layout.offsetof(13);
/* 101 */     SAME_SCREEN = layout.offsetof(14);
/*     */   }
/*     */   
/*     */   protected XKeyEvent(long address, ByteBuffer container) {
/* 105 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected XKeyEvent create(long address, ByteBuffer container) {
/* 110 */     return new XKeyEvent(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XKeyEvent(ByteBuffer container) {
/* 120 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/* 124 */     return SIZEOF;
/*     */   }
/*     */   public int type() {
/* 127 */     return ntype(address());
/*     */   } @NativeType("unsigned long")
/*     */   public long serial() {
/* 130 */     return nserial(address());
/*     */   } @NativeType("Bool")
/*     */   public boolean send_event() {
/* 133 */     return (nsend_event(address()) != 0);
/*     */   } @NativeType("Display *")
/*     */   public long display() {
/* 136 */     return ndisplay(address());
/*     */   } @NativeType("Window")
/*     */   public long window() {
/* 139 */     return nwindow(address());
/*     */   } @NativeType("Window")
/*     */   public long root() {
/* 142 */     return nroot(address());
/*     */   } @NativeType("Window")
/*     */   public long subwindow() {
/* 145 */     return nsubwindow(address());
/*     */   } @NativeType("Time")
/*     */   public long time() {
/* 148 */     return ntime(address());
/*     */   } public int x() {
/* 150 */     return nx(address());
/*     */   } public int y() {
/* 152 */     return ny(address());
/*     */   } public int x_root() {
/* 154 */     return nx_root(address());
/*     */   } public int y_root() {
/* 156 */     return ny_root(address());
/*     */   } @NativeType("unsigned int")
/*     */   public int state() {
/* 159 */     return nstate(address());
/*     */   } @NativeType("unsigned int")
/*     */   public int keycode() {
/* 162 */     return nkeycode(address());
/*     */   } @NativeType("Bool")
/*     */   public boolean same_screen() {
/* 165 */     return (nsame_screen(address()) != 0);
/*     */   }
/*     */   public XKeyEvent type(int value) {
/* 168 */     ntype(address(), value); return this;
/*     */   } public XKeyEvent serial(@NativeType("unsigned long") long value) {
/* 170 */     nserial(address(), value); return this;
/*     */   } public XKeyEvent send_event(@NativeType("Bool") boolean value) {
/* 172 */     nsend_event(address(), value ? 1 : 0); return this;
/*     */   } public XKeyEvent display(@NativeType("Display *") long value) {
/* 174 */     ndisplay(address(), value); return this;
/*     */   } public XKeyEvent window(@NativeType("Window") long value) {
/* 176 */     nwindow(address(), value); return this;
/*     */   } public XKeyEvent root(@NativeType("Window") long value) {
/* 178 */     nroot(address(), value); return this;
/*     */   } public XKeyEvent subwindow(@NativeType("Window") long value) {
/* 180 */     nsubwindow(address(), value); return this;
/*     */   } public XKeyEvent time(@NativeType("Time") long value) {
/* 182 */     ntime(address(), value); return this;
/*     */   } public XKeyEvent x(int value) {
/* 184 */     nx(address(), value); return this;
/*     */   } public XKeyEvent y(int value) {
/* 186 */     ny(address(), value); return this;
/*     */   } public XKeyEvent x_root(int value) {
/* 188 */     nx_root(address(), value); return this;
/*     */   } public XKeyEvent y_root(int value) {
/* 190 */     ny_root(address(), value); return this;
/*     */   } public XKeyEvent state(@NativeType("unsigned int") int value) {
/* 192 */     nstate(address(), value); return this;
/*     */   } public XKeyEvent keycode(@NativeType("unsigned int") int value) {
/* 194 */     nkeycode(address(), value); return this;
/*     */   } public XKeyEvent same_screen(@NativeType("Bool") boolean value) {
/* 196 */     nsame_screen(address(), value ? 1 : 0); return this;
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
/*     */   public XKeyEvent set(int type, long serial, boolean send_event, long display, long window, long root, long subwindow, long time, int x, int y, int x_root, int y_root, int state, int keycode, boolean same_screen) {
/* 216 */     type(type);
/* 217 */     serial(serial);
/* 218 */     send_event(send_event);
/* 219 */     display(display);
/* 220 */     window(window);
/* 221 */     root(root);
/* 222 */     subwindow(subwindow);
/* 223 */     time(time);
/* 224 */     x(x);
/* 225 */     y(y);
/* 226 */     x_root(x_root);
/* 227 */     y_root(y_root);
/* 228 */     state(state);
/* 229 */     keycode(keycode);
/* 230 */     same_screen(same_screen);
/*     */     
/* 232 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XKeyEvent set(XKeyEvent src) {
/* 243 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 244 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XKeyEvent malloc() {
/* 251 */     return new XKeyEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XKeyEvent calloc() {
/* 256 */     return new XKeyEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XKeyEvent create() {
/* 261 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 262 */     return new XKeyEvent(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XKeyEvent create(long address) {
/* 267 */     return new XKeyEvent(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XKeyEvent createSafe(long address) {
/* 272 */     return (address == 0L) ? null : new XKeyEvent(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 281 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 290 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 299 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 300 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 310 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 315 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XKeyEvent malloc(MemoryStack stack) {
/* 324 */     return new XKeyEvent(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XKeyEvent calloc(MemoryStack stack) {
/* 333 */     return new XKeyEvent(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 343 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 353 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int ntype(long struct) {
/* 359 */     return MemoryUtil.memGetInt(struct + TYPE);
/*     */   } public static long nserial(long struct) {
/* 361 */     return MemoryUtil.memGetCLong(struct + SERIAL);
/*     */   } public static int nsend_event(long struct) {
/* 363 */     return MemoryUtil.memGetInt(struct + SEND_EVENT);
/*     */   } public static long ndisplay(long struct) {
/* 365 */     return MemoryUtil.memGetAddress(struct + DISPLAY);
/*     */   } public static long nwindow(long struct) {
/* 367 */     return MemoryUtil.memGetCLong(struct + WINDOW);
/*     */   } public static long nroot(long struct) {
/* 369 */     return MemoryUtil.memGetCLong(struct + ROOT);
/*     */   } public static long nsubwindow(long struct) {
/* 371 */     return MemoryUtil.memGetCLong(struct + SUBWINDOW);
/*     */   } public static long ntime(long struct) {
/* 373 */     return MemoryUtil.memGetCLong(struct + TIME);
/*     */   } public static int nx(long struct) {
/* 375 */     return MemoryUtil.memGetInt(struct + X);
/*     */   } public static int ny(long struct) {
/* 377 */     return MemoryUtil.memGetInt(struct + Y);
/*     */   } public static int nx_root(long struct) {
/* 379 */     return MemoryUtil.memGetInt(struct + X_ROOT);
/*     */   } public static int ny_root(long struct) {
/* 381 */     return MemoryUtil.memGetInt(struct + Y_ROOT);
/*     */   } public static int nstate(long struct) {
/* 383 */     return MemoryUtil.memGetInt(struct + STATE);
/*     */   } public static int nkeycode(long struct) {
/* 385 */     return MemoryUtil.memGetInt(struct + KEYCODE);
/*     */   } public static int nsame_screen(long struct) {
/* 387 */     return MemoryUtil.memGetInt(struct + SAME_SCREEN);
/*     */   }
/*     */   public static void ntype(long struct, int value) {
/* 390 */     MemoryUtil.memPutInt(struct + TYPE, value);
/*     */   } public static void nserial(long struct, long value) {
/* 392 */     MemoryUtil.memPutCLong(struct + SERIAL, value);
/*     */   } public static void nsend_event(long struct, int value) {
/* 394 */     MemoryUtil.memPutInt(struct + SEND_EVENT, value);
/*     */   } public static void ndisplay(long struct, long value) {
/* 396 */     MemoryUtil.memPutAddress(struct + DISPLAY, Checks.check(value));
/*     */   } public static void nwindow(long struct, long value) {
/* 398 */     MemoryUtil.memPutCLong(struct + WINDOW, value);
/*     */   } public static void nroot(long struct, long value) {
/* 400 */     MemoryUtil.memPutCLong(struct + ROOT, value);
/*     */   } public static void nsubwindow(long struct, long value) {
/* 402 */     MemoryUtil.memPutCLong(struct + SUBWINDOW, value);
/*     */   } public static void ntime(long struct, long value) {
/* 404 */     MemoryUtil.memPutCLong(struct + TIME, value);
/*     */   } public static void nx(long struct, int value) {
/* 406 */     MemoryUtil.memPutInt(struct + X, value);
/*     */   } public static void ny(long struct, int value) {
/* 408 */     MemoryUtil.memPutInt(struct + Y, value);
/*     */   } public static void nx_root(long struct, int value) {
/* 410 */     MemoryUtil.memPutInt(struct + X_ROOT, value);
/*     */   } public static void ny_root(long struct, int value) {
/* 412 */     MemoryUtil.memPutInt(struct + Y_ROOT, value);
/*     */   } public static void nstate(long struct, int value) {
/* 414 */     MemoryUtil.memPutInt(struct + STATE, value);
/*     */   } public static void nkeycode(long struct, int value) {
/* 416 */     MemoryUtil.memPutInt(struct + KEYCODE, value);
/*     */   } public static void nsame_screen(long struct, int value) {
/* 418 */     MemoryUtil.memPutInt(struct + SAME_SCREEN, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long struct) {
/* 426 */     Checks.check(MemoryUtil.memGetAddress(struct + DISPLAY));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<XKeyEvent, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 434 */     private static final XKeyEvent ELEMENT_FACTORY = XKeyEvent.create(-1L);
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
/* 446 */       super(container, container.remaining() / XKeyEvent.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 450 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 454 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 459 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 464 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected XKeyEvent getElementFactory() {
/* 469 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     public int type() {
/* 473 */       return XKeyEvent.ntype(address());
/*     */     } @NativeType("unsigned long")
/*     */     public long serial() {
/* 476 */       return XKeyEvent.nserial(address());
/*     */     } @NativeType("Bool")
/*     */     public boolean send_event() {
/* 479 */       return (XKeyEvent.nsend_event(address()) != 0);
/*     */     } @NativeType("Display *")
/*     */     public long display() {
/* 482 */       return XKeyEvent.ndisplay(address());
/*     */     } @NativeType("Window")
/*     */     public long window() {
/* 485 */       return XKeyEvent.nwindow(address());
/*     */     } @NativeType("Window")
/*     */     public long root() {
/* 488 */       return XKeyEvent.nroot(address());
/*     */     } @NativeType("Window")
/*     */     public long subwindow() {
/* 491 */       return XKeyEvent.nsubwindow(address());
/*     */     } @NativeType("Time")
/*     */     public long time() {
/* 494 */       return XKeyEvent.ntime(address());
/*     */     } public int x() {
/* 496 */       return XKeyEvent.nx(address());
/*     */     } public int y() {
/* 498 */       return XKeyEvent.ny(address());
/*     */     } public int x_root() {
/* 500 */       return XKeyEvent.nx_root(address());
/*     */     } public int y_root() {
/* 502 */       return XKeyEvent.ny_root(address());
/*     */     } @NativeType("unsigned int")
/*     */     public int state() {
/* 505 */       return XKeyEvent.nstate(address());
/*     */     } @NativeType("unsigned int")
/*     */     public int keycode() {
/* 508 */       return XKeyEvent.nkeycode(address());
/*     */     } @NativeType("Bool")
/*     */     public boolean same_screen() {
/* 511 */       return (XKeyEvent.nsame_screen(address()) != 0);
/*     */     }
/*     */     public Buffer type(int value) {
/* 514 */       XKeyEvent.ntype(address(), value); return this;
/*     */     } public Buffer serial(@NativeType("unsigned long") long value) {
/* 516 */       XKeyEvent.nserial(address(), value); return this;
/*     */     } public Buffer send_event(@NativeType("Bool") boolean value) {
/* 518 */       XKeyEvent.nsend_event(address(), value ? 1 : 0); return this;
/*     */     } public Buffer display(@NativeType("Display *") long value) {
/* 520 */       XKeyEvent.ndisplay(address(), value); return this;
/*     */     } public Buffer window(@NativeType("Window") long value) {
/* 522 */       XKeyEvent.nwindow(address(), value); return this;
/*     */     } public Buffer root(@NativeType("Window") long value) {
/* 524 */       XKeyEvent.nroot(address(), value); return this;
/*     */     } public Buffer subwindow(@NativeType("Window") long value) {
/* 526 */       XKeyEvent.nsubwindow(address(), value); return this;
/*     */     } public Buffer time(@NativeType("Time") long value) {
/* 528 */       XKeyEvent.ntime(address(), value); return this;
/*     */     } public Buffer x(int value) {
/* 530 */       XKeyEvent.nx(address(), value); return this;
/*     */     } public Buffer y(int value) {
/* 532 */       XKeyEvent.ny(address(), value); return this;
/*     */     } public Buffer x_root(int value) {
/* 534 */       XKeyEvent.nx_root(address(), value); return this;
/*     */     } public Buffer y_root(int value) {
/* 536 */       XKeyEvent.ny_root(address(), value); return this;
/*     */     } public Buffer state(@NativeType("unsigned int") int value) {
/* 538 */       XKeyEvent.nstate(address(), value); return this;
/*     */     } public Buffer keycode(@NativeType("unsigned int") int value) {
/* 540 */       XKeyEvent.nkeycode(address(), value); return this;
/*     */     } public Buffer same_screen(@NativeType("Bool") boolean value) {
/* 542 */       XKeyEvent.nsame_screen(address(), value ? 1 : 0); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\XKeyEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */