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
/*     */ public class XGravityEvent
/*     */   extends Struct<XGravityEvent>
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
/*     */   public static final int X;
/*     */   public static final int Y;
/*     */   
/*     */   static {
/*  52 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  53 */           __member(4), 
/*  54 */           __member(CLONG_SIZE), 
/*  55 */           __member(4), 
/*  56 */           __member(POINTER_SIZE), 
/*  57 */           __member(CLONG_SIZE), 
/*  58 */           __member(CLONG_SIZE), 
/*  59 */           __member(4), 
/*  60 */           __member(4)
/*     */         });
/*     */     
/*  63 */     SIZEOF = layout.getSize();
/*  64 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  66 */     TYPE = layout.offsetof(0);
/*  67 */     SERIAL = layout.offsetof(1);
/*  68 */     SEND_EVENT = layout.offsetof(2);
/*  69 */     DISPLAY = layout.offsetof(3);
/*  70 */     EVENT = layout.offsetof(4);
/*  71 */     WINDOW = layout.offsetof(5);
/*  72 */     X = layout.offsetof(6);
/*  73 */     Y = layout.offsetof(7);
/*     */   }
/*     */   
/*     */   protected XGravityEvent(long address, ByteBuffer container) {
/*  77 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected XGravityEvent create(long address, ByteBuffer container) {
/*  82 */     return new XGravityEvent(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XGravityEvent(ByteBuffer container) {
/*  92 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  96 */     return SIZEOF;
/*     */   }
/*     */   public int type() {
/*  99 */     return ntype(address());
/*     */   } @NativeType("unsigned long")
/*     */   public long serial() {
/* 102 */     return nserial(address());
/*     */   } @NativeType("Bool")
/*     */   public boolean send_event() {
/* 105 */     return (nsend_event(address()) != 0);
/*     */   } @NativeType("Display *")
/*     */   public long display() {
/* 108 */     return ndisplay(address());
/*     */   } @NativeType("Window")
/*     */   public long event() {
/* 111 */     return nevent(address());
/*     */   } @NativeType("Window")
/*     */   public long window() {
/* 114 */     return nwindow(address());
/*     */   } public int x() {
/* 116 */     return nx(address());
/*     */   } public int y() {
/* 118 */     return ny(address());
/*     */   }
/*     */   public XGravityEvent type(int value) {
/* 121 */     ntype(address(), value); return this;
/*     */   } public XGravityEvent serial(@NativeType("unsigned long") long value) {
/* 123 */     nserial(address(), value); return this;
/*     */   } public XGravityEvent send_event(@NativeType("Bool") boolean value) {
/* 125 */     nsend_event(address(), value ? 1 : 0); return this;
/*     */   } public XGravityEvent display(@NativeType("Display *") long value) {
/* 127 */     ndisplay(address(), value); return this;
/*     */   } public XGravityEvent event(@NativeType("Window") long value) {
/* 129 */     nevent(address(), value); return this;
/*     */   } public XGravityEvent window(@NativeType("Window") long value) {
/* 131 */     nwindow(address(), value); return this;
/*     */   } public XGravityEvent x(int value) {
/* 133 */     nx(address(), value); return this;
/*     */   } public XGravityEvent y(int value) {
/* 135 */     ny(address(), value); return this;
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
/*     */   public XGravityEvent set(int type, long serial, boolean send_event, long display, long event, long window, int x, int y) {
/* 148 */     type(type);
/* 149 */     serial(serial);
/* 150 */     send_event(send_event);
/* 151 */     display(display);
/* 152 */     event(event);
/* 153 */     window(window);
/* 154 */     x(x);
/* 155 */     y(y);
/*     */     
/* 157 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XGravityEvent set(XGravityEvent src) {
/* 168 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 169 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XGravityEvent malloc() {
/* 176 */     return new XGravityEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XGravityEvent calloc() {
/* 181 */     return new XGravityEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XGravityEvent create() {
/* 186 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 187 */     return new XGravityEvent(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XGravityEvent create(long address) {
/* 192 */     return new XGravityEvent(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XGravityEvent createSafe(long address) {
/* 197 */     return (address == 0L) ? null : new XGravityEvent(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 206 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 215 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 224 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 225 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 235 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 240 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XGravityEvent malloc(MemoryStack stack) {
/* 249 */     return new XGravityEvent(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XGravityEvent calloc(MemoryStack stack) {
/* 258 */     return new XGravityEvent(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 268 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 278 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int ntype(long struct) {
/* 284 */     return MemoryUtil.memGetInt(struct + TYPE);
/*     */   } public static long nserial(long struct) {
/* 286 */     return MemoryUtil.memGetCLong(struct + SERIAL);
/*     */   } public static int nsend_event(long struct) {
/* 288 */     return MemoryUtil.memGetInt(struct + SEND_EVENT);
/*     */   } public static long ndisplay(long struct) {
/* 290 */     return MemoryUtil.memGetAddress(struct + DISPLAY);
/*     */   } public static long nevent(long struct) {
/* 292 */     return MemoryUtil.memGetCLong(struct + EVENT);
/*     */   } public static long nwindow(long struct) {
/* 294 */     return MemoryUtil.memGetCLong(struct + WINDOW);
/*     */   } public static int nx(long struct) {
/* 296 */     return MemoryUtil.memGetInt(struct + X);
/*     */   } public static int ny(long struct) {
/* 298 */     return MemoryUtil.memGetInt(struct + Y);
/*     */   }
/*     */   public static void ntype(long struct, int value) {
/* 301 */     MemoryUtil.memPutInt(struct + TYPE, value);
/*     */   } public static void nserial(long struct, long value) {
/* 303 */     MemoryUtil.memPutCLong(struct + SERIAL, value);
/*     */   } public static void nsend_event(long struct, int value) {
/* 305 */     MemoryUtil.memPutInt(struct + SEND_EVENT, value);
/*     */   } public static void ndisplay(long struct, long value) {
/* 307 */     MemoryUtil.memPutAddress(struct + DISPLAY, Checks.check(value));
/*     */   } public static void nevent(long struct, long value) {
/* 309 */     MemoryUtil.memPutCLong(struct + EVENT, value);
/*     */   } public static void nwindow(long struct, long value) {
/* 311 */     MemoryUtil.memPutCLong(struct + WINDOW, value);
/*     */   } public static void nx(long struct, int value) {
/* 313 */     MemoryUtil.memPutInt(struct + X, value);
/*     */   } public static void ny(long struct, int value) {
/* 315 */     MemoryUtil.memPutInt(struct + Y, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long struct) {
/* 323 */     Checks.check(MemoryUtil.memGetAddress(struct + DISPLAY));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<XGravityEvent, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 331 */     private static final XGravityEvent ELEMENT_FACTORY = XGravityEvent.create(-1L);
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
/* 343 */       super(container, container.remaining() / XGravityEvent.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 347 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 351 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 356 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 361 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected XGravityEvent getElementFactory() {
/* 366 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     public int type() {
/* 370 */       return XGravityEvent.ntype(address());
/*     */     } @NativeType("unsigned long")
/*     */     public long serial() {
/* 373 */       return XGravityEvent.nserial(address());
/*     */     } @NativeType("Bool")
/*     */     public boolean send_event() {
/* 376 */       return (XGravityEvent.nsend_event(address()) != 0);
/*     */     } @NativeType("Display *")
/*     */     public long display() {
/* 379 */       return XGravityEvent.ndisplay(address());
/*     */     } @NativeType("Window")
/*     */     public long event() {
/* 382 */       return XGravityEvent.nevent(address());
/*     */     } @NativeType("Window")
/*     */     public long window() {
/* 385 */       return XGravityEvent.nwindow(address());
/*     */     } public int x() {
/* 387 */       return XGravityEvent.nx(address());
/*     */     } public int y() {
/* 389 */       return XGravityEvent.ny(address());
/*     */     }
/*     */     public Buffer type(int value) {
/* 392 */       XGravityEvent.ntype(address(), value); return this;
/*     */     } public Buffer serial(@NativeType("unsigned long") long value) {
/* 394 */       XGravityEvent.nserial(address(), value); return this;
/*     */     } public Buffer send_event(@NativeType("Bool") boolean value) {
/* 396 */       XGravityEvent.nsend_event(address(), value ? 1 : 0); return this;
/*     */     } public Buffer display(@NativeType("Display *") long value) {
/* 398 */       XGravityEvent.ndisplay(address(), value); return this;
/*     */     } public Buffer event(@NativeType("Window") long value) {
/* 400 */       XGravityEvent.nevent(address(), value); return this;
/*     */     } public Buffer window(@NativeType("Window") long value) {
/* 402 */       XGravityEvent.nwindow(address(), value); return this;
/*     */     } public Buffer x(int value) {
/* 404 */       XGravityEvent.nx(address(), value); return this;
/*     */     } public Buffer y(int value) {
/* 406 */       XGravityEvent.ny(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\XGravityEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */