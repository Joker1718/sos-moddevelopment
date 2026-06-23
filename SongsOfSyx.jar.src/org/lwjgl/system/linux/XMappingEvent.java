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
/*     */ public class XMappingEvent
/*     */   extends Struct<XMappingEvent>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int TYPE;
/*     */   public static final int SERIAL;
/*     */   public static final int SEND_EVENT;
/*     */   public static final int DISPLAY;
/*     */   public static final int WINDOW;
/*     */   public static final int REQUEST;
/*     */   public static final int FIRST_KEYCODE;
/*     */   public static final int COUNT;
/*     */   
/*     */   static {
/*  52 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  53 */           __member(4), 
/*  54 */           __member(CLONG_SIZE), 
/*  55 */           __member(4), 
/*  56 */           __member(POINTER_SIZE), 
/*  57 */           __member(CLONG_SIZE), 
/*  58 */           __member(4), 
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
/*  70 */     WINDOW = layout.offsetof(4);
/*  71 */     REQUEST = layout.offsetof(5);
/*  72 */     FIRST_KEYCODE = layout.offsetof(6);
/*  73 */     COUNT = layout.offsetof(7);
/*     */   }
/*     */   
/*     */   protected XMappingEvent(long address, ByteBuffer container) {
/*  77 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected XMappingEvent create(long address, ByteBuffer container) {
/*  82 */     return new XMappingEvent(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XMappingEvent(ByteBuffer container) {
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
/*     */   public long window() {
/* 111 */     return nwindow(address());
/*     */   } public int request() {
/* 113 */     return nrequest(address());
/*     */   } public int first_keycode() {
/* 115 */     return nfirst_keycode(address());
/*     */   } public int count() {
/* 117 */     return ncount(address());
/*     */   }
/*     */   public XMappingEvent type(int value) {
/* 120 */     ntype(address(), value); return this;
/*     */   } public XMappingEvent serial(@NativeType("unsigned long") long value) {
/* 122 */     nserial(address(), value); return this;
/*     */   } public XMappingEvent send_event(@NativeType("Bool") boolean value) {
/* 124 */     nsend_event(address(), value ? 1 : 0); return this;
/*     */   } public XMappingEvent display(@NativeType("Display *") long value) {
/* 126 */     ndisplay(address(), value); return this;
/*     */   } public XMappingEvent window(@NativeType("Window") long value) {
/* 128 */     nwindow(address(), value); return this;
/*     */   } public XMappingEvent request(int value) {
/* 130 */     nrequest(address(), value); return this;
/*     */   } public XMappingEvent first_keycode(int value) {
/* 132 */     nfirst_keycode(address(), value); return this;
/*     */   } public XMappingEvent count(int value) {
/* 134 */     ncount(address(), value); return this;
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
/*     */   public XMappingEvent set(int type, long serial, boolean send_event, long display, long window, int request, int first_keycode, int count) {
/* 147 */     type(type);
/* 148 */     serial(serial);
/* 149 */     send_event(send_event);
/* 150 */     display(display);
/* 151 */     window(window);
/* 152 */     request(request);
/* 153 */     first_keycode(first_keycode);
/* 154 */     count(count);
/*     */     
/* 156 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XMappingEvent set(XMappingEvent src) {
/* 167 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 168 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XMappingEvent malloc() {
/* 175 */     return new XMappingEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XMappingEvent calloc() {
/* 180 */     return new XMappingEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XMappingEvent create() {
/* 185 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 186 */     return new XMappingEvent(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XMappingEvent create(long address) {
/* 191 */     return new XMappingEvent(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XMappingEvent createSafe(long address) {
/* 196 */     return (address == 0L) ? null : new XMappingEvent(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 205 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 214 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 223 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 224 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 234 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 239 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XMappingEvent malloc(MemoryStack stack) {
/* 248 */     return new XMappingEvent(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XMappingEvent calloc(MemoryStack stack) {
/* 257 */     return new XMappingEvent(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 267 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 277 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int ntype(long struct) {
/* 283 */     return MemoryUtil.memGetInt(struct + TYPE);
/*     */   } public static long nserial(long struct) {
/* 285 */     return MemoryUtil.memGetCLong(struct + SERIAL);
/*     */   } public static int nsend_event(long struct) {
/* 287 */     return MemoryUtil.memGetInt(struct + SEND_EVENT);
/*     */   } public static long ndisplay(long struct) {
/* 289 */     return MemoryUtil.memGetAddress(struct + DISPLAY);
/*     */   } public static long nwindow(long struct) {
/* 291 */     return MemoryUtil.memGetCLong(struct + WINDOW);
/*     */   } public static int nrequest(long struct) {
/* 293 */     return MemoryUtil.memGetInt(struct + REQUEST);
/*     */   } public static int nfirst_keycode(long struct) {
/* 295 */     return MemoryUtil.memGetInt(struct + FIRST_KEYCODE);
/*     */   } public static int ncount(long struct) {
/* 297 */     return MemoryUtil.memGetInt(struct + COUNT);
/*     */   }
/*     */   public static void ntype(long struct, int value) {
/* 300 */     MemoryUtil.memPutInt(struct + TYPE, value);
/*     */   } public static void nserial(long struct, long value) {
/* 302 */     MemoryUtil.memPutCLong(struct + SERIAL, value);
/*     */   } public static void nsend_event(long struct, int value) {
/* 304 */     MemoryUtil.memPutInt(struct + SEND_EVENT, value);
/*     */   } public static void ndisplay(long struct, long value) {
/* 306 */     MemoryUtil.memPutAddress(struct + DISPLAY, Checks.check(value));
/*     */   } public static void nwindow(long struct, long value) {
/* 308 */     MemoryUtil.memPutCLong(struct + WINDOW, value);
/*     */   } public static void nrequest(long struct, int value) {
/* 310 */     MemoryUtil.memPutInt(struct + REQUEST, value);
/*     */   } public static void nfirst_keycode(long struct, int value) {
/* 312 */     MemoryUtil.memPutInt(struct + FIRST_KEYCODE, value);
/*     */   } public static void ncount(long struct, int value) {
/* 314 */     MemoryUtil.memPutInt(struct + COUNT, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long struct) {
/* 322 */     Checks.check(MemoryUtil.memGetAddress(struct + DISPLAY));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<XMappingEvent, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 330 */     private static final XMappingEvent ELEMENT_FACTORY = XMappingEvent.create(-1L);
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
/* 342 */       super(container, container.remaining() / XMappingEvent.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 346 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 350 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 355 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 360 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected XMappingEvent getElementFactory() {
/* 365 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     public int type() {
/* 369 */       return XMappingEvent.ntype(address());
/*     */     } @NativeType("unsigned long")
/*     */     public long serial() {
/* 372 */       return XMappingEvent.nserial(address());
/*     */     } @NativeType("Bool")
/*     */     public boolean send_event() {
/* 375 */       return (XMappingEvent.nsend_event(address()) != 0);
/*     */     } @NativeType("Display *")
/*     */     public long display() {
/* 378 */       return XMappingEvent.ndisplay(address());
/*     */     } @NativeType("Window")
/*     */     public long window() {
/* 381 */       return XMappingEvent.nwindow(address());
/*     */     } public int request() {
/* 383 */       return XMappingEvent.nrequest(address());
/*     */     } public int first_keycode() {
/* 385 */       return XMappingEvent.nfirst_keycode(address());
/*     */     } public int count() {
/* 387 */       return XMappingEvent.ncount(address());
/*     */     }
/*     */     public Buffer type(int value) {
/* 390 */       XMappingEvent.ntype(address(), value); return this;
/*     */     } public Buffer serial(@NativeType("unsigned long") long value) {
/* 392 */       XMappingEvent.nserial(address(), value); return this;
/*     */     } public Buffer send_event(@NativeType("Bool") boolean value) {
/* 394 */       XMappingEvent.nsend_event(address(), value ? 1 : 0); return this;
/*     */     } public Buffer display(@NativeType("Display *") long value) {
/* 396 */       XMappingEvent.ndisplay(address(), value); return this;
/*     */     } public Buffer window(@NativeType("Window") long value) {
/* 398 */       XMappingEvent.nwindow(address(), value); return this;
/*     */     } public Buffer request(int value) {
/* 400 */       XMappingEvent.nrequest(address(), value); return this;
/*     */     } public Buffer first_keycode(int value) {
/* 402 */       XMappingEvent.nfirst_keycode(address(), value); return this;
/*     */     } public Buffer count(int value) {
/* 404 */       XMappingEvent.ncount(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\XMappingEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */