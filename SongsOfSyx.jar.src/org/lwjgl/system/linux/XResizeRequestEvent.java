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
/*     */ public class XResizeRequestEvent
/*     */   extends Struct<XResizeRequestEvent>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int TYPE;
/*     */   public static final int SERIAL;
/*     */   public static final int SEND_EVENT;
/*     */   public static final int DISPLAY;
/*     */   public static final int WINDOW;
/*     */   public static final int WIDTH;
/*     */   public static final int HEIGHT;
/*     */   
/*     */   static {
/*  50 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  51 */           __member(4), 
/*  52 */           __member(CLONG_SIZE), 
/*  53 */           __member(4), 
/*  54 */           __member(POINTER_SIZE), 
/*  55 */           __member(CLONG_SIZE), 
/*  56 */           __member(4), 
/*  57 */           __member(4)
/*     */         });
/*     */     
/*  60 */     SIZEOF = layout.getSize();
/*  61 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  63 */     TYPE = layout.offsetof(0);
/*  64 */     SERIAL = layout.offsetof(1);
/*  65 */     SEND_EVENT = layout.offsetof(2);
/*  66 */     DISPLAY = layout.offsetof(3);
/*  67 */     WINDOW = layout.offsetof(4);
/*  68 */     WIDTH = layout.offsetof(5);
/*  69 */     HEIGHT = layout.offsetof(6);
/*     */   }
/*     */   
/*     */   protected XResizeRequestEvent(long address, ByteBuffer container) {
/*  73 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected XResizeRequestEvent create(long address, ByteBuffer container) {
/*  78 */     return new XResizeRequestEvent(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XResizeRequestEvent(ByteBuffer container) {
/*  88 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  92 */     return SIZEOF;
/*     */   }
/*     */   public int type() {
/*  95 */     return ntype(address());
/*     */   } @NativeType("unsigned long")
/*     */   public long serial() {
/*  98 */     return nserial(address());
/*     */   } @NativeType("Bool")
/*     */   public boolean send_event() {
/* 101 */     return (nsend_event(address()) != 0);
/*     */   } @NativeType("Display *")
/*     */   public long display() {
/* 104 */     return ndisplay(address());
/*     */   } @NativeType("Window")
/*     */   public long window() {
/* 107 */     return nwindow(address());
/*     */   } public int width() {
/* 109 */     return nwidth(address());
/*     */   } public int height() {
/* 111 */     return nheight(address());
/*     */   }
/*     */   public XResizeRequestEvent type(int value) {
/* 114 */     ntype(address(), value); return this;
/*     */   } public XResizeRequestEvent serial(@NativeType("unsigned long") long value) {
/* 116 */     nserial(address(), value); return this;
/*     */   } public XResizeRequestEvent send_event(@NativeType("Bool") boolean value) {
/* 118 */     nsend_event(address(), value ? 1 : 0); return this;
/*     */   } public XResizeRequestEvent display(@NativeType("Display *") long value) {
/* 120 */     ndisplay(address(), value); return this;
/*     */   } public XResizeRequestEvent window(@NativeType("Window") long value) {
/* 122 */     nwindow(address(), value); return this;
/*     */   } public XResizeRequestEvent width(int value) {
/* 124 */     nwidth(address(), value); return this;
/*     */   } public XResizeRequestEvent height(int value) {
/* 126 */     nheight(address(), value); return this;
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
/*     */   public XResizeRequestEvent set(int type, long serial, boolean send_event, long display, long window, int width, int height) {
/* 138 */     type(type);
/* 139 */     serial(serial);
/* 140 */     send_event(send_event);
/* 141 */     display(display);
/* 142 */     window(window);
/* 143 */     width(width);
/* 144 */     height(height);
/*     */     
/* 146 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XResizeRequestEvent set(XResizeRequestEvent src) {
/* 157 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 158 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XResizeRequestEvent malloc() {
/* 165 */     return new XResizeRequestEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XResizeRequestEvent calloc() {
/* 170 */     return new XResizeRequestEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XResizeRequestEvent create() {
/* 175 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 176 */     return new XResizeRequestEvent(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XResizeRequestEvent create(long address) {
/* 181 */     return new XResizeRequestEvent(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XResizeRequestEvent createSafe(long address) {
/* 186 */     return (address == 0L) ? null : new XResizeRequestEvent(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 195 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 204 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 213 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 214 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 224 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 229 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XResizeRequestEvent malloc(MemoryStack stack) {
/* 238 */     return new XResizeRequestEvent(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XResizeRequestEvent calloc(MemoryStack stack) {
/* 247 */     return new XResizeRequestEvent(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 257 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 267 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int ntype(long struct) {
/* 273 */     return MemoryUtil.memGetInt(struct + TYPE);
/*     */   } public static long nserial(long struct) {
/* 275 */     return MemoryUtil.memGetCLong(struct + SERIAL);
/*     */   } public static int nsend_event(long struct) {
/* 277 */     return MemoryUtil.memGetInt(struct + SEND_EVENT);
/*     */   } public static long ndisplay(long struct) {
/* 279 */     return MemoryUtil.memGetAddress(struct + DISPLAY);
/*     */   } public static long nwindow(long struct) {
/* 281 */     return MemoryUtil.memGetCLong(struct + WINDOW);
/*     */   } public static int nwidth(long struct) {
/* 283 */     return MemoryUtil.memGetInt(struct + WIDTH);
/*     */   } public static int nheight(long struct) {
/* 285 */     return MemoryUtil.memGetInt(struct + HEIGHT);
/*     */   }
/*     */   public static void ntype(long struct, int value) {
/* 288 */     MemoryUtil.memPutInt(struct + TYPE, value);
/*     */   } public static void nserial(long struct, long value) {
/* 290 */     MemoryUtil.memPutCLong(struct + SERIAL, value);
/*     */   } public static void nsend_event(long struct, int value) {
/* 292 */     MemoryUtil.memPutInt(struct + SEND_EVENT, value);
/*     */   } public static void ndisplay(long struct, long value) {
/* 294 */     MemoryUtil.memPutAddress(struct + DISPLAY, Checks.check(value));
/*     */   } public static void nwindow(long struct, long value) {
/* 296 */     MemoryUtil.memPutCLong(struct + WINDOW, value);
/*     */   } public static void nwidth(long struct, int value) {
/* 298 */     MemoryUtil.memPutInt(struct + WIDTH, value);
/*     */   } public static void nheight(long struct, int value) {
/* 300 */     MemoryUtil.memPutInt(struct + HEIGHT, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long struct) {
/* 308 */     Checks.check(MemoryUtil.memGetAddress(struct + DISPLAY));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<XResizeRequestEvent, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 316 */     private static final XResizeRequestEvent ELEMENT_FACTORY = XResizeRequestEvent.create(-1L);
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
/* 328 */       super(container, container.remaining() / XResizeRequestEvent.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 332 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 336 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 341 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 346 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected XResizeRequestEvent getElementFactory() {
/* 351 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     public int type() {
/* 355 */       return XResizeRequestEvent.ntype(address());
/*     */     } @NativeType("unsigned long")
/*     */     public long serial() {
/* 358 */       return XResizeRequestEvent.nserial(address());
/*     */     } @NativeType("Bool")
/*     */     public boolean send_event() {
/* 361 */       return (XResizeRequestEvent.nsend_event(address()) != 0);
/*     */     } @NativeType("Display *")
/*     */     public long display() {
/* 364 */       return XResizeRequestEvent.ndisplay(address());
/*     */     } @NativeType("Window")
/*     */     public long window() {
/* 367 */       return XResizeRequestEvent.nwindow(address());
/*     */     } public int width() {
/* 369 */       return XResizeRequestEvent.nwidth(address());
/*     */     } public int height() {
/* 371 */       return XResizeRequestEvent.nheight(address());
/*     */     }
/*     */     public Buffer type(int value) {
/* 374 */       XResizeRequestEvent.ntype(address(), value); return this;
/*     */     } public Buffer serial(@NativeType("unsigned long") long value) {
/* 376 */       XResizeRequestEvent.nserial(address(), value); return this;
/*     */     } public Buffer send_event(@NativeType("Bool") boolean value) {
/* 378 */       XResizeRequestEvent.nsend_event(address(), value ? 1 : 0); return this;
/*     */     } public Buffer display(@NativeType("Display *") long value) {
/* 380 */       XResizeRequestEvent.ndisplay(address(), value); return this;
/*     */     } public Buffer window(@NativeType("Window") long value) {
/* 382 */       XResizeRequestEvent.nwindow(address(), value); return this;
/*     */     } public Buffer width(int value) {
/* 384 */       XResizeRequestEvent.nwidth(address(), value); return this;
/*     */     } public Buffer height(int value) {
/* 386 */       XResizeRequestEvent.nheight(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\XResizeRequestEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */