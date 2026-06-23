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
/*     */ public class XCirculateRequestEvent
/*     */   extends Struct<XCirculateRequestEvent>
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
/*     */   public static final int PLACE;
/*     */   
/*     */   static {
/*  50 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  51 */           __member(4), 
/*  52 */           __member(CLONG_SIZE), 
/*  53 */           __member(4), 
/*  54 */           __member(POINTER_SIZE), 
/*  55 */           __member(CLONG_SIZE), 
/*  56 */           __member(CLONG_SIZE), 
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
/*  67 */     PARENT = layout.offsetof(4);
/*  68 */     WINDOW = layout.offsetof(5);
/*  69 */     PLACE = layout.offsetof(6);
/*     */   }
/*     */   
/*     */   protected XCirculateRequestEvent(long address, ByteBuffer container) {
/*  73 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected XCirculateRequestEvent create(long address, ByteBuffer container) {
/*  78 */     return new XCirculateRequestEvent(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XCirculateRequestEvent(ByteBuffer container) {
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
/*     */   public long parent() {
/* 107 */     return nparent(address());
/*     */   } @NativeType("Window")
/*     */   public long window() {
/* 110 */     return nwindow(address());
/*     */   } public int place() {
/* 112 */     return nplace(address());
/*     */   }
/*     */   public XCirculateRequestEvent type(int value) {
/* 115 */     ntype(address(), value); return this;
/*     */   } public XCirculateRequestEvent serial(@NativeType("unsigned long") long value) {
/* 117 */     nserial(address(), value); return this;
/*     */   } public XCirculateRequestEvent send_event(@NativeType("Bool") boolean value) {
/* 119 */     nsend_event(address(), value ? 1 : 0); return this;
/*     */   } public XCirculateRequestEvent display(@NativeType("Display *") long value) {
/* 121 */     ndisplay(address(), value); return this;
/*     */   } public XCirculateRequestEvent parent(@NativeType("Window") long value) {
/* 123 */     nparent(address(), value); return this;
/*     */   } public XCirculateRequestEvent window(@NativeType("Window") long value) {
/* 125 */     nwindow(address(), value); return this;
/*     */   } public XCirculateRequestEvent place(int value) {
/* 127 */     nplace(address(), value); return this;
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
/*     */   public XCirculateRequestEvent set(int type, long serial, boolean send_event, long display, long parent, long window, int place) {
/* 139 */     type(type);
/* 140 */     serial(serial);
/* 141 */     send_event(send_event);
/* 142 */     display(display);
/* 143 */     parent(parent);
/* 144 */     window(window);
/* 145 */     place(place);
/*     */     
/* 147 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XCirculateRequestEvent set(XCirculateRequestEvent src) {
/* 158 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 159 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XCirculateRequestEvent malloc() {
/* 166 */     return new XCirculateRequestEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XCirculateRequestEvent calloc() {
/* 171 */     return new XCirculateRequestEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XCirculateRequestEvent create() {
/* 176 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 177 */     return new XCirculateRequestEvent(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XCirculateRequestEvent create(long address) {
/* 182 */     return new XCirculateRequestEvent(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XCirculateRequestEvent createSafe(long address) {
/* 187 */     return (address == 0L) ? null : new XCirculateRequestEvent(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 196 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 205 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 214 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 215 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 225 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 230 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XCirculateRequestEvent malloc(MemoryStack stack) {
/* 239 */     return new XCirculateRequestEvent(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XCirculateRequestEvent calloc(MemoryStack stack) {
/* 248 */     return new XCirculateRequestEvent(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 258 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 268 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int ntype(long struct) {
/* 274 */     return MemoryUtil.memGetInt(struct + TYPE);
/*     */   } public static long nserial(long struct) {
/* 276 */     return MemoryUtil.memGetCLong(struct + SERIAL);
/*     */   } public static int nsend_event(long struct) {
/* 278 */     return MemoryUtil.memGetInt(struct + SEND_EVENT);
/*     */   } public static long ndisplay(long struct) {
/* 280 */     return MemoryUtil.memGetAddress(struct + DISPLAY);
/*     */   } public static long nparent(long struct) {
/* 282 */     return MemoryUtil.memGetCLong(struct + PARENT);
/*     */   } public static long nwindow(long struct) {
/* 284 */     return MemoryUtil.memGetCLong(struct + WINDOW);
/*     */   } public static int nplace(long struct) {
/* 286 */     return MemoryUtil.memGetInt(struct + PLACE);
/*     */   }
/*     */   public static void ntype(long struct, int value) {
/* 289 */     MemoryUtil.memPutInt(struct + TYPE, value);
/*     */   } public static void nserial(long struct, long value) {
/* 291 */     MemoryUtil.memPutCLong(struct + SERIAL, value);
/*     */   } public static void nsend_event(long struct, int value) {
/* 293 */     MemoryUtil.memPutInt(struct + SEND_EVENT, value);
/*     */   } public static void ndisplay(long struct, long value) {
/* 295 */     MemoryUtil.memPutAddress(struct + DISPLAY, Checks.check(value));
/*     */   } public static void nparent(long struct, long value) {
/* 297 */     MemoryUtil.memPutCLong(struct + PARENT, value);
/*     */   } public static void nwindow(long struct, long value) {
/* 299 */     MemoryUtil.memPutCLong(struct + WINDOW, value);
/*     */   } public static void nplace(long struct, int value) {
/* 301 */     MemoryUtil.memPutInt(struct + PLACE, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long struct) {
/* 309 */     Checks.check(MemoryUtil.memGetAddress(struct + DISPLAY));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<XCirculateRequestEvent, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 317 */     private static final XCirculateRequestEvent ELEMENT_FACTORY = XCirculateRequestEvent.create(-1L);
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
/* 329 */       super(container, container.remaining() / XCirculateRequestEvent.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 333 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 337 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 342 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 347 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected XCirculateRequestEvent getElementFactory() {
/* 352 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     public int type() {
/* 356 */       return XCirculateRequestEvent.ntype(address());
/*     */     } @NativeType("unsigned long")
/*     */     public long serial() {
/* 359 */       return XCirculateRequestEvent.nserial(address());
/*     */     } @NativeType("Bool")
/*     */     public boolean send_event() {
/* 362 */       return (XCirculateRequestEvent.nsend_event(address()) != 0);
/*     */     } @NativeType("Display *")
/*     */     public long display() {
/* 365 */       return XCirculateRequestEvent.ndisplay(address());
/*     */     } @NativeType("Window")
/*     */     public long parent() {
/* 368 */       return XCirculateRequestEvent.nparent(address());
/*     */     } @NativeType("Window")
/*     */     public long window() {
/* 371 */       return XCirculateRequestEvent.nwindow(address());
/*     */     } public int place() {
/* 373 */       return XCirculateRequestEvent.nplace(address());
/*     */     }
/*     */     public Buffer type(int value) {
/* 376 */       XCirculateRequestEvent.ntype(address(), value); return this;
/*     */     } public Buffer serial(@NativeType("unsigned long") long value) {
/* 378 */       XCirculateRequestEvent.nserial(address(), value); return this;
/*     */     } public Buffer send_event(@NativeType("Bool") boolean value) {
/* 380 */       XCirculateRequestEvent.nsend_event(address(), value ? 1 : 0); return this;
/*     */     } public Buffer display(@NativeType("Display *") long value) {
/* 382 */       XCirculateRequestEvent.ndisplay(address(), value); return this;
/*     */     } public Buffer parent(@NativeType("Window") long value) {
/* 384 */       XCirculateRequestEvent.nparent(address(), value); return this;
/*     */     } public Buffer window(@NativeType("Window") long value) {
/* 386 */       XCirculateRequestEvent.nwindow(address(), value); return this;
/*     */     } public Buffer place(int value) {
/* 388 */       XCirculateRequestEvent.nplace(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\XCirculateRequestEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */