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
/*     */ public class XGenericEventCookie
/*     */   extends Struct<XGenericEventCookie>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int TYPE;
/*     */   public static final int SERIAL;
/*     */   public static final int SEND_EVENT;
/*     */   public static final int DISPLAY;
/*     */   public static final int EXTENSION;
/*     */   public static final int EVTYPE;
/*     */   public static final int COOKIE;
/*     */   public static final int DATA;
/*     */   
/*     */   static {
/*  52 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  53 */           __member(4), 
/*  54 */           __member(CLONG_SIZE), 
/*  55 */           __member(4), 
/*  56 */           __member(POINTER_SIZE), 
/*  57 */           __member(4), 
/*  58 */           __member(4), 
/*  59 */           __member(4), 
/*  60 */           __member(POINTER_SIZE)
/*     */         });
/*     */     
/*  63 */     SIZEOF = layout.getSize();
/*  64 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  66 */     TYPE = layout.offsetof(0);
/*  67 */     SERIAL = layout.offsetof(1);
/*  68 */     SEND_EVENT = layout.offsetof(2);
/*  69 */     DISPLAY = layout.offsetof(3);
/*  70 */     EXTENSION = layout.offsetof(4);
/*  71 */     EVTYPE = layout.offsetof(5);
/*  72 */     COOKIE = layout.offsetof(6);
/*  73 */     DATA = layout.offsetof(7);
/*     */   }
/*     */   
/*     */   protected XGenericEventCookie(long address, ByteBuffer container) {
/*  77 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected XGenericEventCookie create(long address, ByteBuffer container) {
/*  82 */     return new XGenericEventCookie(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XGenericEventCookie(ByteBuffer container) {
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
/*     */   } public int extension() {
/* 110 */     return nextension(address());
/*     */   } public int evtype() {
/* 112 */     return nevtype(address());
/*     */   } @NativeType("unsigned int")
/*     */   public int cookie() {
/* 115 */     return ncookie(address());
/*     */   } @NativeType("void *")
/*     */   public ByteBuffer data(int capacity) {
/* 118 */     return ndata(address(), capacity);
/*     */   }
/*     */   public XGenericEventCookie type(int value) {
/* 121 */     ntype(address(), value); return this;
/*     */   } public XGenericEventCookie serial(@NativeType("unsigned long") long value) {
/* 123 */     nserial(address(), value); return this;
/*     */   } public XGenericEventCookie send_event(@NativeType("Bool") boolean value) {
/* 125 */     nsend_event(address(), value ? 1 : 0); return this;
/*     */   } public XGenericEventCookie display(@NativeType("Display *") long value) {
/* 127 */     ndisplay(address(), value); return this;
/*     */   } public XGenericEventCookie extension(int value) {
/* 129 */     nextension(address(), value); return this;
/*     */   } public XGenericEventCookie evtype(int value) {
/* 131 */     nevtype(address(), value); return this;
/*     */   } public XGenericEventCookie cookie(@NativeType("unsigned int") int value) {
/* 133 */     ncookie(address(), value); return this;
/*     */   } public XGenericEventCookie data(@NativeType("void *") ByteBuffer value) {
/* 135 */     ndata(address(), value); return this;
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
/*     */   public XGenericEventCookie set(int type, long serial, boolean send_event, long display, int extension, int evtype, int cookie, ByteBuffer data) {
/* 148 */     type(type);
/* 149 */     serial(serial);
/* 150 */     send_event(send_event);
/* 151 */     display(display);
/* 152 */     extension(extension);
/* 153 */     evtype(evtype);
/* 154 */     cookie(cookie);
/* 155 */     data(data);
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
/*     */   public XGenericEventCookie set(XGenericEventCookie src) {
/* 168 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 169 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XGenericEventCookie malloc() {
/* 176 */     return new XGenericEventCookie(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XGenericEventCookie calloc() {
/* 181 */     return new XGenericEventCookie(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XGenericEventCookie create() {
/* 186 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 187 */     return new XGenericEventCookie(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XGenericEventCookie create(long address) {
/* 192 */     return new XGenericEventCookie(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XGenericEventCookie createSafe(long address) {
/* 197 */     return (address == 0L) ? null : new XGenericEventCookie(address, null);
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
/*     */   public static XGenericEventCookie malloc(MemoryStack stack) {
/* 249 */     return new XGenericEventCookie(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XGenericEventCookie calloc(MemoryStack stack) {
/* 258 */     return new XGenericEventCookie(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
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
/*     */   } public static int nextension(long struct) {
/* 292 */     return MemoryUtil.memGetInt(struct + EXTENSION);
/*     */   } public static int nevtype(long struct) {
/* 294 */     return MemoryUtil.memGetInt(struct + EVTYPE);
/*     */   } public static int ncookie(long struct) {
/* 296 */     return MemoryUtil.memGetInt(struct + COOKIE);
/*     */   } public static ByteBuffer ndata(long struct, int capacity) {
/* 298 */     return MemoryUtil.memByteBuffer(MemoryUtil.memGetAddress(struct + DATA), capacity);
/*     */   }
/*     */   public static void ntype(long struct, int value) {
/* 301 */     MemoryUtil.memPutInt(struct + TYPE, value);
/*     */   } public static void nserial(long struct, long value) {
/* 303 */     MemoryUtil.memPutCLong(struct + SERIAL, value);
/*     */   } public static void nsend_event(long struct, int value) {
/* 305 */     MemoryUtil.memPutInt(struct + SEND_EVENT, value);
/*     */   } public static void ndisplay(long struct, long value) {
/* 307 */     MemoryUtil.memPutAddress(struct + DISPLAY, Checks.check(value));
/*     */   } public static void nextension(long struct, int value) {
/* 309 */     MemoryUtil.memPutInt(struct + EXTENSION, value);
/*     */   } public static void nevtype(long struct, int value) {
/* 311 */     MemoryUtil.memPutInt(struct + EVTYPE, value);
/*     */   } public static void ncookie(long struct, int value) {
/* 313 */     MemoryUtil.memPutInt(struct + COOKIE, value);
/*     */   } public static void ndata(long struct, ByteBuffer value) {
/* 315 */     MemoryUtil.memPutAddress(struct + DATA, MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long struct) {
/* 323 */     Checks.check(MemoryUtil.memGetAddress(struct + DISPLAY));
/* 324 */     Checks.check(MemoryUtil.memGetAddress(struct + DATA));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<XGenericEventCookie, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 332 */     private static final XGenericEventCookie ELEMENT_FACTORY = XGenericEventCookie.create(-1L);
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
/* 344 */       super(container, container.remaining() / XGenericEventCookie.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 348 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 352 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 357 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 362 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected XGenericEventCookie getElementFactory() {
/* 367 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     public int type() {
/* 371 */       return XGenericEventCookie.ntype(address());
/*     */     } @NativeType("unsigned long")
/*     */     public long serial() {
/* 374 */       return XGenericEventCookie.nserial(address());
/*     */     } @NativeType("Bool")
/*     */     public boolean send_event() {
/* 377 */       return (XGenericEventCookie.nsend_event(address()) != 0);
/*     */     } @NativeType("Display *")
/*     */     public long display() {
/* 380 */       return XGenericEventCookie.ndisplay(address());
/*     */     } public int extension() {
/* 382 */       return XGenericEventCookie.nextension(address());
/*     */     } public int evtype() {
/* 384 */       return XGenericEventCookie.nevtype(address());
/*     */     } @NativeType("unsigned int")
/*     */     public int cookie() {
/* 387 */       return XGenericEventCookie.ncookie(address());
/*     */     } @NativeType("void *")
/*     */     public ByteBuffer data(int capacity) {
/* 390 */       return XGenericEventCookie.ndata(address(), capacity);
/*     */     }
/*     */     public Buffer type(int value) {
/* 393 */       XGenericEventCookie.ntype(address(), value); return this;
/*     */     } public Buffer serial(@NativeType("unsigned long") long value) {
/* 395 */       XGenericEventCookie.nserial(address(), value); return this;
/*     */     } public Buffer send_event(@NativeType("Bool") boolean value) {
/* 397 */       XGenericEventCookie.nsend_event(address(), value ? 1 : 0); return this;
/*     */     } public Buffer display(@NativeType("Display *") long value) {
/* 399 */       XGenericEventCookie.ndisplay(address(), value); return this;
/*     */     } public Buffer extension(int value) {
/* 401 */       XGenericEventCookie.nextension(address(), value); return this;
/*     */     } public Buffer evtype(int value) {
/* 403 */       XGenericEventCookie.nevtype(address(), value); return this;
/*     */     } public Buffer cookie(@NativeType("unsigned int") int value) {
/* 405 */       XGenericEventCookie.ncookie(address(), value); return this;
/*     */     } public Buffer data(@NativeType("void *") ByteBuffer value) {
/* 407 */       XGenericEventCookie.ndata(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\XGenericEventCookie.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */