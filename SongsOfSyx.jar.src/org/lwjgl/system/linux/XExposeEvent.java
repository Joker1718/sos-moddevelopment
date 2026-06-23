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
/*     */ public class XExposeEvent
/*     */   extends Struct<XExposeEvent>
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
/*     */   public static final int COUNT;
/*     */   
/*     */   static {
/*  56 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  57 */           __member(4), 
/*  58 */           __member(CLONG_SIZE), 
/*  59 */           __member(4), 
/*  60 */           __member(POINTER_SIZE), 
/*  61 */           __member(CLONG_SIZE), 
/*  62 */           __member(4), 
/*  63 */           __member(4), 
/*  64 */           __member(4), 
/*  65 */           __member(4), 
/*  66 */           __member(4)
/*     */         });
/*     */     
/*  69 */     SIZEOF = layout.getSize();
/*  70 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  72 */     TYPE = layout.offsetof(0);
/*  73 */     SERIAL = layout.offsetof(1);
/*  74 */     SEND_EVENT = layout.offsetof(2);
/*  75 */     DISPLAY = layout.offsetof(3);
/*  76 */     WINDOW = layout.offsetof(4);
/*  77 */     X = layout.offsetof(5);
/*  78 */     Y = layout.offsetof(6);
/*  79 */     WIDTH = layout.offsetof(7);
/*  80 */     HEIGHT = layout.offsetof(8);
/*  81 */     COUNT = layout.offsetof(9);
/*     */   }
/*     */   
/*     */   protected XExposeEvent(long address, ByteBuffer container) {
/*  85 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected XExposeEvent create(long address, ByteBuffer container) {
/*  90 */     return new XExposeEvent(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XExposeEvent(ByteBuffer container) {
/* 100 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/* 104 */     return SIZEOF;
/*     */   }
/*     */   public int type() {
/* 107 */     return ntype(address());
/*     */   } @NativeType("unsigned long")
/*     */   public long serial() {
/* 110 */     return nserial(address());
/*     */   } @NativeType("Bool")
/*     */   public boolean send_event() {
/* 113 */     return (nsend_event(address()) != 0);
/*     */   } @NativeType("Display *")
/*     */   public long display() {
/* 116 */     return ndisplay(address());
/*     */   } @NativeType("Window")
/*     */   public long window() {
/* 119 */     return nwindow(address());
/*     */   } public int x() {
/* 121 */     return nx(address());
/*     */   } public int y() {
/* 123 */     return ny(address());
/*     */   } public int width() {
/* 125 */     return nwidth(address());
/*     */   } public int height() {
/* 127 */     return nheight(address());
/*     */   } public int count() {
/* 129 */     return ncount(address());
/*     */   }
/*     */   public XExposeEvent type(int value) {
/* 132 */     ntype(address(), value); return this;
/*     */   } public XExposeEvent serial(@NativeType("unsigned long") long value) {
/* 134 */     nserial(address(), value); return this;
/*     */   } public XExposeEvent send_event(@NativeType("Bool") boolean value) {
/* 136 */     nsend_event(address(), value ? 1 : 0); return this;
/*     */   } public XExposeEvent display(@NativeType("Display *") long value) {
/* 138 */     ndisplay(address(), value); return this;
/*     */   } public XExposeEvent window(@NativeType("Window") long value) {
/* 140 */     nwindow(address(), value); return this;
/*     */   } public XExposeEvent x(int value) {
/* 142 */     nx(address(), value); return this;
/*     */   } public XExposeEvent y(int value) {
/* 144 */     ny(address(), value); return this;
/*     */   } public XExposeEvent width(int value) {
/* 146 */     nwidth(address(), value); return this;
/*     */   } public XExposeEvent height(int value) {
/* 148 */     nheight(address(), value); return this;
/*     */   } public XExposeEvent count(int value) {
/* 150 */     ncount(address(), value); return this;
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
/*     */   public XExposeEvent set(int type, long serial, boolean send_event, long display, long window, int x, int y, int width, int height, int count) {
/* 165 */     type(type);
/* 166 */     serial(serial);
/* 167 */     send_event(send_event);
/* 168 */     display(display);
/* 169 */     window(window);
/* 170 */     x(x);
/* 171 */     y(y);
/* 172 */     width(width);
/* 173 */     height(height);
/* 174 */     count(count);
/*     */     
/* 176 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XExposeEvent set(XExposeEvent src) {
/* 187 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 188 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XExposeEvent malloc() {
/* 195 */     return new XExposeEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XExposeEvent calloc() {
/* 200 */     return new XExposeEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XExposeEvent create() {
/* 205 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 206 */     return new XExposeEvent(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XExposeEvent create(long address) {
/* 211 */     return new XExposeEvent(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XExposeEvent createSafe(long address) {
/* 216 */     return (address == 0L) ? null : new XExposeEvent(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 225 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 234 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 243 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 244 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 254 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 259 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XExposeEvent malloc(MemoryStack stack) {
/* 268 */     return new XExposeEvent(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XExposeEvent calloc(MemoryStack stack) {
/* 277 */     return new XExposeEvent(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 287 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 297 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int ntype(long struct) {
/* 303 */     return MemoryUtil.memGetInt(struct + TYPE);
/*     */   } public static long nserial(long struct) {
/* 305 */     return MemoryUtil.memGetCLong(struct + SERIAL);
/*     */   } public static int nsend_event(long struct) {
/* 307 */     return MemoryUtil.memGetInt(struct + SEND_EVENT);
/*     */   } public static long ndisplay(long struct) {
/* 309 */     return MemoryUtil.memGetAddress(struct + DISPLAY);
/*     */   } public static long nwindow(long struct) {
/* 311 */     return MemoryUtil.memGetCLong(struct + WINDOW);
/*     */   } public static int nx(long struct) {
/* 313 */     return MemoryUtil.memGetInt(struct + X);
/*     */   } public static int ny(long struct) {
/* 315 */     return MemoryUtil.memGetInt(struct + Y);
/*     */   } public static int nwidth(long struct) {
/* 317 */     return MemoryUtil.memGetInt(struct + WIDTH);
/*     */   } public static int nheight(long struct) {
/* 319 */     return MemoryUtil.memGetInt(struct + HEIGHT);
/*     */   } public static int ncount(long struct) {
/* 321 */     return MemoryUtil.memGetInt(struct + COUNT);
/*     */   }
/*     */   public static void ntype(long struct, int value) {
/* 324 */     MemoryUtil.memPutInt(struct + TYPE, value);
/*     */   } public static void nserial(long struct, long value) {
/* 326 */     MemoryUtil.memPutCLong(struct + SERIAL, value);
/*     */   } public static void nsend_event(long struct, int value) {
/* 328 */     MemoryUtil.memPutInt(struct + SEND_EVENT, value);
/*     */   } public static void ndisplay(long struct, long value) {
/* 330 */     MemoryUtil.memPutAddress(struct + DISPLAY, Checks.check(value));
/*     */   } public static void nwindow(long struct, long value) {
/* 332 */     MemoryUtil.memPutCLong(struct + WINDOW, value);
/*     */   } public static void nx(long struct, int value) {
/* 334 */     MemoryUtil.memPutInt(struct + X, value);
/*     */   } public static void ny(long struct, int value) {
/* 336 */     MemoryUtil.memPutInt(struct + Y, value);
/*     */   } public static void nwidth(long struct, int value) {
/* 338 */     MemoryUtil.memPutInt(struct + WIDTH, value);
/*     */   } public static void nheight(long struct, int value) {
/* 340 */     MemoryUtil.memPutInt(struct + HEIGHT, value);
/*     */   } public static void ncount(long struct, int value) {
/* 342 */     MemoryUtil.memPutInt(struct + COUNT, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long struct) {
/* 350 */     Checks.check(MemoryUtil.memGetAddress(struct + DISPLAY));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<XExposeEvent, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 358 */     private static final XExposeEvent ELEMENT_FACTORY = XExposeEvent.create(-1L);
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
/* 370 */       super(container, container.remaining() / XExposeEvent.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 374 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 378 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 383 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 388 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected XExposeEvent getElementFactory() {
/* 393 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     public int type() {
/* 397 */       return XExposeEvent.ntype(address());
/*     */     } @NativeType("unsigned long")
/*     */     public long serial() {
/* 400 */       return XExposeEvent.nserial(address());
/*     */     } @NativeType("Bool")
/*     */     public boolean send_event() {
/* 403 */       return (XExposeEvent.nsend_event(address()) != 0);
/*     */     } @NativeType("Display *")
/*     */     public long display() {
/* 406 */       return XExposeEvent.ndisplay(address());
/*     */     } @NativeType("Window")
/*     */     public long window() {
/* 409 */       return XExposeEvent.nwindow(address());
/*     */     } public int x() {
/* 411 */       return XExposeEvent.nx(address());
/*     */     } public int y() {
/* 413 */       return XExposeEvent.ny(address());
/*     */     } public int width() {
/* 415 */       return XExposeEvent.nwidth(address());
/*     */     } public int height() {
/* 417 */       return XExposeEvent.nheight(address());
/*     */     } public int count() {
/* 419 */       return XExposeEvent.ncount(address());
/*     */     }
/*     */     public Buffer type(int value) {
/* 422 */       XExposeEvent.ntype(address(), value); return this;
/*     */     } public Buffer serial(@NativeType("unsigned long") long value) {
/* 424 */       XExposeEvent.nserial(address(), value); return this;
/*     */     } public Buffer send_event(@NativeType("Bool") boolean value) {
/* 426 */       XExposeEvent.nsend_event(address(), value ? 1 : 0); return this;
/*     */     } public Buffer display(@NativeType("Display *") long value) {
/* 428 */       XExposeEvent.ndisplay(address(), value); return this;
/*     */     } public Buffer window(@NativeType("Window") long value) {
/* 430 */       XExposeEvent.nwindow(address(), value); return this;
/*     */     } public Buffer x(int value) {
/* 432 */       XExposeEvent.nx(address(), value); return this;
/*     */     } public Buffer y(int value) {
/* 434 */       XExposeEvent.ny(address(), value); return this;
/*     */     } public Buffer width(int value) {
/* 436 */       XExposeEvent.nwidth(address(), value); return this;
/*     */     } public Buffer height(int value) {
/* 438 */       XExposeEvent.nheight(address(), value); return this;
/*     */     } public Buffer count(int value) {
/* 440 */       XExposeEvent.ncount(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\XExposeEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */