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
/*     */ public class XReparentEvent
/*     */   extends Struct<XReparentEvent>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int TYPE;
/*     */   public static final int SERIAL;
/*     */   public static final int SEND_EVENT;
/*     */   public static final int DISPLAY;
/*     */   public static final int EVENT;
/*     */   public static final int WINDOW;
/*     */   public static final int PARENT;
/*     */   public static final int X;
/*     */   public static final int Y;
/*     */   public static final int OVERRIDE_REDIRECT;
/*     */   
/*     */   static {
/*  56 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  57 */           __member(4), 
/*  58 */           __member(CLONG_SIZE), 
/*  59 */           __member(4), 
/*  60 */           __member(POINTER_SIZE), 
/*  61 */           __member(CLONG_SIZE), 
/*  62 */           __member(CLONG_SIZE), 
/*  63 */           __member(CLONG_SIZE), 
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
/*  76 */     EVENT = layout.offsetof(4);
/*  77 */     WINDOW = layout.offsetof(5);
/*  78 */     PARENT = layout.offsetof(6);
/*  79 */     X = layout.offsetof(7);
/*  80 */     Y = layout.offsetof(8);
/*  81 */     OVERRIDE_REDIRECT = layout.offsetof(9);
/*     */   }
/*     */   
/*     */   protected XReparentEvent(long address, ByteBuffer container) {
/*  85 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected XReparentEvent create(long address, ByteBuffer container) {
/*  90 */     return new XReparentEvent(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XReparentEvent(ByteBuffer container) {
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
/*     */   public long event() {
/* 119 */     return nevent(address());
/*     */   } @NativeType("Window")
/*     */   public long window() {
/* 122 */     return nwindow(address());
/*     */   } @NativeType("Window")
/*     */   public long parent() {
/* 125 */     return nparent(address());
/*     */   } public int x() {
/* 127 */     return nx(address());
/*     */   } public int y() {
/* 129 */     return ny(address());
/*     */   } public int override_redirect() {
/* 131 */     return noverride_redirect(address());
/*     */   }
/*     */   public XReparentEvent type(int value) {
/* 134 */     ntype(address(), value); return this;
/*     */   } public XReparentEvent serial(@NativeType("unsigned long") long value) {
/* 136 */     nserial(address(), value); return this;
/*     */   } public XReparentEvent send_event(@NativeType("Bool") boolean value) {
/* 138 */     nsend_event(address(), value ? 1 : 0); return this;
/*     */   } public XReparentEvent display(@NativeType("Display *") long value) {
/* 140 */     ndisplay(address(), value); return this;
/*     */   } public XReparentEvent event(@NativeType("Window") long value) {
/* 142 */     nevent(address(), value); return this;
/*     */   } public XReparentEvent window(@NativeType("Window") long value) {
/* 144 */     nwindow(address(), value); return this;
/*     */   } public XReparentEvent parent(@NativeType("Window") long value) {
/* 146 */     nparent(address(), value); return this;
/*     */   } public XReparentEvent x(int value) {
/* 148 */     nx(address(), value); return this;
/*     */   } public XReparentEvent y(int value) {
/* 150 */     ny(address(), value); return this;
/*     */   } public XReparentEvent override_redirect(int value) {
/* 152 */     noverride_redirect(address(), value); return this;
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
/*     */   public XReparentEvent set(int type, long serial, boolean send_event, long display, long event, long window, long parent, int x, int y, int override_redirect) {
/* 167 */     type(type);
/* 168 */     serial(serial);
/* 169 */     send_event(send_event);
/* 170 */     display(display);
/* 171 */     event(event);
/* 172 */     window(window);
/* 173 */     parent(parent);
/* 174 */     x(x);
/* 175 */     y(y);
/* 176 */     override_redirect(override_redirect);
/*     */     
/* 178 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XReparentEvent set(XReparentEvent src) {
/* 189 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 190 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XReparentEvent malloc() {
/* 197 */     return new XReparentEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XReparentEvent calloc() {
/* 202 */     return new XReparentEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XReparentEvent create() {
/* 207 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 208 */     return new XReparentEvent(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XReparentEvent create(long address) {
/* 213 */     return new XReparentEvent(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XReparentEvent createSafe(long address) {
/* 218 */     return (address == 0L) ? null : new XReparentEvent(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 227 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 236 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 245 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 246 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 256 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 261 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XReparentEvent malloc(MemoryStack stack) {
/* 270 */     return new XReparentEvent(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XReparentEvent calloc(MemoryStack stack) {
/* 279 */     return new XReparentEvent(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 289 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 299 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int ntype(long struct) {
/* 305 */     return MemoryUtil.memGetInt(struct + TYPE);
/*     */   } public static long nserial(long struct) {
/* 307 */     return MemoryUtil.memGetCLong(struct + SERIAL);
/*     */   } public static int nsend_event(long struct) {
/* 309 */     return MemoryUtil.memGetInt(struct + SEND_EVENT);
/*     */   } public static long ndisplay(long struct) {
/* 311 */     return MemoryUtil.memGetAddress(struct + DISPLAY);
/*     */   } public static long nevent(long struct) {
/* 313 */     return MemoryUtil.memGetCLong(struct + EVENT);
/*     */   } public static long nwindow(long struct) {
/* 315 */     return MemoryUtil.memGetCLong(struct + WINDOW);
/*     */   } public static long nparent(long struct) {
/* 317 */     return MemoryUtil.memGetCLong(struct + PARENT);
/*     */   } public static int nx(long struct) {
/* 319 */     return MemoryUtil.memGetInt(struct + X);
/*     */   } public static int ny(long struct) {
/* 321 */     return MemoryUtil.memGetInt(struct + Y);
/*     */   } public static int noverride_redirect(long struct) {
/* 323 */     return MemoryUtil.memGetInt(struct + OVERRIDE_REDIRECT);
/*     */   }
/*     */   public static void ntype(long struct, int value) {
/* 326 */     MemoryUtil.memPutInt(struct + TYPE, value);
/*     */   } public static void nserial(long struct, long value) {
/* 328 */     MemoryUtil.memPutCLong(struct + SERIAL, value);
/*     */   } public static void nsend_event(long struct, int value) {
/* 330 */     MemoryUtil.memPutInt(struct + SEND_EVENT, value);
/*     */   } public static void ndisplay(long struct, long value) {
/* 332 */     MemoryUtil.memPutAddress(struct + DISPLAY, Checks.check(value));
/*     */   } public static void nevent(long struct, long value) {
/* 334 */     MemoryUtil.memPutCLong(struct + EVENT, value);
/*     */   } public static void nwindow(long struct, long value) {
/* 336 */     MemoryUtil.memPutCLong(struct + WINDOW, value);
/*     */   } public static void nparent(long struct, long value) {
/* 338 */     MemoryUtil.memPutCLong(struct + PARENT, value);
/*     */   } public static void nx(long struct, int value) {
/* 340 */     MemoryUtil.memPutInt(struct + X, value);
/*     */   } public static void ny(long struct, int value) {
/* 342 */     MemoryUtil.memPutInt(struct + Y, value);
/*     */   } public static void noverride_redirect(long struct, int value) {
/* 344 */     MemoryUtil.memPutInt(struct + OVERRIDE_REDIRECT, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long struct) {
/* 352 */     Checks.check(MemoryUtil.memGetAddress(struct + DISPLAY));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<XReparentEvent, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 360 */     private static final XReparentEvent ELEMENT_FACTORY = XReparentEvent.create(-1L);
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
/* 372 */       super(container, container.remaining() / XReparentEvent.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 376 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 380 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 385 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 390 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected XReparentEvent getElementFactory() {
/* 395 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     public int type() {
/* 399 */       return XReparentEvent.ntype(address());
/*     */     } @NativeType("unsigned long")
/*     */     public long serial() {
/* 402 */       return XReparentEvent.nserial(address());
/*     */     } @NativeType("Bool")
/*     */     public boolean send_event() {
/* 405 */       return (XReparentEvent.nsend_event(address()) != 0);
/*     */     } @NativeType("Display *")
/*     */     public long display() {
/* 408 */       return XReparentEvent.ndisplay(address());
/*     */     } @NativeType("Window")
/*     */     public long event() {
/* 411 */       return XReparentEvent.nevent(address());
/*     */     } @NativeType("Window")
/*     */     public long window() {
/* 414 */       return XReparentEvent.nwindow(address());
/*     */     } @NativeType("Window")
/*     */     public long parent() {
/* 417 */       return XReparentEvent.nparent(address());
/*     */     } public int x() {
/* 419 */       return XReparentEvent.nx(address());
/*     */     } public int y() {
/* 421 */       return XReparentEvent.ny(address());
/*     */     } public int override_redirect() {
/* 423 */       return XReparentEvent.noverride_redirect(address());
/*     */     }
/*     */     public Buffer type(int value) {
/* 426 */       XReparentEvent.ntype(address(), value); return this;
/*     */     } public Buffer serial(@NativeType("unsigned long") long value) {
/* 428 */       XReparentEvent.nserial(address(), value); return this;
/*     */     } public Buffer send_event(@NativeType("Bool") boolean value) {
/* 430 */       XReparentEvent.nsend_event(address(), value ? 1 : 0); return this;
/*     */     } public Buffer display(@NativeType("Display *") long value) {
/* 432 */       XReparentEvent.ndisplay(address(), value); return this;
/*     */     } public Buffer event(@NativeType("Window") long value) {
/* 434 */       XReparentEvent.nevent(address(), value); return this;
/*     */     } public Buffer window(@NativeType("Window") long value) {
/* 436 */       XReparentEvent.nwindow(address(), value); return this;
/*     */     } public Buffer parent(@NativeType("Window") long value) {
/* 438 */       XReparentEvent.nparent(address(), value); return this;
/*     */     } public Buffer x(int value) {
/* 440 */       XReparentEvent.nx(address(), value); return this;
/*     */     } public Buffer y(int value) {
/* 442 */       XReparentEvent.ny(address(), value); return this;
/*     */     } public Buffer override_redirect(int value) {
/* 444 */       XReparentEvent.noverride_redirect(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\XReparentEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */