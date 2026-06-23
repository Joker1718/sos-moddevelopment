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
/*     */ public class XPropertyEvent
/*     */   extends Struct<XPropertyEvent>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int TYPE;
/*     */   public static final int SERIAL;
/*     */   public static final int SEND_EVENT;
/*     */   public static final int DISPLAY;
/*     */   public static final int WINDOW;
/*     */   public static final int ATOM;
/*     */   public static final int TIME;
/*     */   public static final int STATE;
/*     */   
/*     */   static {
/*  52 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  53 */           __member(4), 
/*  54 */           __member(CLONG_SIZE), 
/*  55 */           __member(4), 
/*  56 */           __member(POINTER_SIZE), 
/*  57 */           __member(CLONG_SIZE), 
/*  58 */           __member(CLONG_SIZE), 
/*  59 */           __member(CLONG_SIZE), 
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
/*  71 */     ATOM = layout.offsetof(5);
/*  72 */     TIME = layout.offsetof(6);
/*  73 */     STATE = layout.offsetof(7);
/*     */   }
/*     */   
/*     */   protected XPropertyEvent(long address, ByteBuffer container) {
/*  77 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected XPropertyEvent create(long address, ByteBuffer container) {
/*  82 */     return new XPropertyEvent(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XPropertyEvent(ByteBuffer container) {
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
/*     */   } @NativeType("Atom")
/*     */   public long atom() {
/* 114 */     return natom(address());
/*     */   } @NativeType("Time")
/*     */   public long time() {
/* 117 */     return ntime(address());
/*     */   } public int state() {
/* 119 */     return nstate(address());
/*     */   }
/*     */   public XPropertyEvent type(int value) {
/* 122 */     ntype(address(), value); return this;
/*     */   } public XPropertyEvent serial(@NativeType("unsigned long") long value) {
/* 124 */     nserial(address(), value); return this;
/*     */   } public XPropertyEvent send_event(@NativeType("Bool") boolean value) {
/* 126 */     nsend_event(address(), value ? 1 : 0); return this;
/*     */   } public XPropertyEvent display(@NativeType("Display *") long value) {
/* 128 */     ndisplay(address(), value); return this;
/*     */   } public XPropertyEvent window(@NativeType("Window") long value) {
/* 130 */     nwindow(address(), value); return this;
/*     */   } public XPropertyEvent atom(@NativeType("Atom") long value) {
/* 132 */     natom(address(), value); return this;
/*     */   } public XPropertyEvent time(@NativeType("Time") long value) {
/* 134 */     ntime(address(), value); return this;
/*     */   } public XPropertyEvent state(int value) {
/* 136 */     nstate(address(), value); return this;
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
/*     */   public XPropertyEvent set(int type, long serial, boolean send_event, long display, long window, long atom, long time, int state) {
/* 149 */     type(type);
/* 150 */     serial(serial);
/* 151 */     send_event(send_event);
/* 152 */     display(display);
/* 153 */     window(window);
/* 154 */     atom(atom);
/* 155 */     time(time);
/* 156 */     state(state);
/*     */     
/* 158 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XPropertyEvent set(XPropertyEvent src) {
/* 169 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 170 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XPropertyEvent malloc() {
/* 177 */     return new XPropertyEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XPropertyEvent calloc() {
/* 182 */     return new XPropertyEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XPropertyEvent create() {
/* 187 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 188 */     return new XPropertyEvent(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XPropertyEvent create(long address) {
/* 193 */     return new XPropertyEvent(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XPropertyEvent createSafe(long address) {
/* 198 */     return (address == 0L) ? null : new XPropertyEvent(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 207 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 216 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 225 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 226 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 236 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 241 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XPropertyEvent malloc(MemoryStack stack) {
/* 250 */     return new XPropertyEvent(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XPropertyEvent calloc(MemoryStack stack) {
/* 259 */     return new XPropertyEvent(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 269 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 279 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int ntype(long struct) {
/* 285 */     return MemoryUtil.memGetInt(struct + TYPE);
/*     */   } public static long nserial(long struct) {
/* 287 */     return MemoryUtil.memGetCLong(struct + SERIAL);
/*     */   } public static int nsend_event(long struct) {
/* 289 */     return MemoryUtil.memGetInt(struct + SEND_EVENT);
/*     */   } public static long ndisplay(long struct) {
/* 291 */     return MemoryUtil.memGetAddress(struct + DISPLAY);
/*     */   } public static long nwindow(long struct) {
/* 293 */     return MemoryUtil.memGetCLong(struct + WINDOW);
/*     */   } public static long natom(long struct) {
/* 295 */     return MemoryUtil.memGetCLong(struct + ATOM);
/*     */   } public static long ntime(long struct) {
/* 297 */     return MemoryUtil.memGetCLong(struct + TIME);
/*     */   } public static int nstate(long struct) {
/* 299 */     return MemoryUtil.memGetInt(struct + STATE);
/*     */   }
/*     */   public static void ntype(long struct, int value) {
/* 302 */     MemoryUtil.memPutInt(struct + TYPE, value);
/*     */   } public static void nserial(long struct, long value) {
/* 304 */     MemoryUtil.memPutCLong(struct + SERIAL, value);
/*     */   } public static void nsend_event(long struct, int value) {
/* 306 */     MemoryUtil.memPutInt(struct + SEND_EVENT, value);
/*     */   } public static void ndisplay(long struct, long value) {
/* 308 */     MemoryUtil.memPutAddress(struct + DISPLAY, Checks.check(value));
/*     */   } public static void nwindow(long struct, long value) {
/* 310 */     MemoryUtil.memPutCLong(struct + WINDOW, value);
/*     */   } public static void natom(long struct, long value) {
/* 312 */     MemoryUtil.memPutCLong(struct + ATOM, value);
/*     */   } public static void ntime(long struct, long value) {
/* 314 */     MemoryUtil.memPutCLong(struct + TIME, value);
/*     */   } public static void nstate(long struct, int value) {
/* 316 */     MemoryUtil.memPutInt(struct + STATE, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long struct) {
/* 324 */     Checks.check(MemoryUtil.memGetAddress(struct + DISPLAY));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<XPropertyEvent, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 332 */     private static final XPropertyEvent ELEMENT_FACTORY = XPropertyEvent.create(-1L);
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
/* 344 */       super(container, container.remaining() / XPropertyEvent.SIZEOF);
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
/*     */     protected XPropertyEvent getElementFactory() {
/* 367 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     public int type() {
/* 371 */       return XPropertyEvent.ntype(address());
/*     */     } @NativeType("unsigned long")
/*     */     public long serial() {
/* 374 */       return XPropertyEvent.nserial(address());
/*     */     } @NativeType("Bool")
/*     */     public boolean send_event() {
/* 377 */       return (XPropertyEvent.nsend_event(address()) != 0);
/*     */     } @NativeType("Display *")
/*     */     public long display() {
/* 380 */       return XPropertyEvent.ndisplay(address());
/*     */     } @NativeType("Window")
/*     */     public long window() {
/* 383 */       return XPropertyEvent.nwindow(address());
/*     */     } @NativeType("Atom")
/*     */     public long atom() {
/* 386 */       return XPropertyEvent.natom(address());
/*     */     } @NativeType("Time")
/*     */     public long time() {
/* 389 */       return XPropertyEvent.ntime(address());
/*     */     } public int state() {
/* 391 */       return XPropertyEvent.nstate(address());
/*     */     }
/*     */     public Buffer type(int value) {
/* 394 */       XPropertyEvent.ntype(address(), value); return this;
/*     */     } public Buffer serial(@NativeType("unsigned long") long value) {
/* 396 */       XPropertyEvent.nserial(address(), value); return this;
/*     */     } public Buffer send_event(@NativeType("Bool") boolean value) {
/* 398 */       XPropertyEvent.nsend_event(address(), value ? 1 : 0); return this;
/*     */     } public Buffer display(@NativeType("Display *") long value) {
/* 400 */       XPropertyEvent.ndisplay(address(), value); return this;
/*     */     } public Buffer window(@NativeType("Window") long value) {
/* 402 */       XPropertyEvent.nwindow(address(), value); return this;
/*     */     } public Buffer atom(@NativeType("Atom") long value) {
/* 404 */       XPropertyEvent.natom(address(), value); return this;
/*     */     } public Buffer time(@NativeType("Time") long value) {
/* 406 */       XPropertyEvent.ntime(address(), value); return this;
/*     */     } public Buffer state(int value) {
/* 408 */       XPropertyEvent.nstate(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\XPropertyEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */