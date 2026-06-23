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
/*     */ public class XSelectionClearEvent
/*     */   extends Struct<XSelectionClearEvent>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int TYPE;
/*     */   public static final int SERIAL;
/*     */   public static final int SEND_EVENT;
/*     */   public static final int DISPLAY;
/*     */   public static final int WINDOW;
/*     */   public static final int SELECTION;
/*     */   public static final int TIME;
/*     */   
/*     */   static {
/*  50 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  51 */           __member(4), 
/*  52 */           __member(CLONG_SIZE), 
/*  53 */           __member(4), 
/*  54 */           __member(POINTER_SIZE), 
/*  55 */           __member(CLONG_SIZE), 
/*  56 */           __member(CLONG_SIZE), 
/*  57 */           __member(CLONG_SIZE)
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
/*  68 */     SELECTION = layout.offsetof(5);
/*  69 */     TIME = layout.offsetof(6);
/*     */   }
/*     */   
/*     */   protected XSelectionClearEvent(long address, ByteBuffer container) {
/*  73 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected XSelectionClearEvent create(long address, ByteBuffer container) {
/*  78 */     return new XSelectionClearEvent(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSelectionClearEvent(ByteBuffer container) {
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
/*     */   } @NativeType("Atom")
/*     */   public long selection() {
/* 110 */     return nselection(address());
/*     */   } @NativeType("Time")
/*     */   public long time() {
/* 113 */     return ntime(address());
/*     */   }
/*     */   public XSelectionClearEvent type(int value) {
/* 116 */     ntype(address(), value); return this;
/*     */   } public XSelectionClearEvent serial(@NativeType("unsigned long") long value) {
/* 118 */     nserial(address(), value); return this;
/*     */   } public XSelectionClearEvent send_event(@NativeType("Bool") boolean value) {
/* 120 */     nsend_event(address(), value ? 1 : 0); return this;
/*     */   } public XSelectionClearEvent display(@NativeType("Display *") long value) {
/* 122 */     ndisplay(address(), value); return this;
/*     */   } public XSelectionClearEvent window(@NativeType("Window") long value) {
/* 124 */     nwindow(address(), value); return this;
/*     */   } public XSelectionClearEvent selection(@NativeType("Atom") long value) {
/* 126 */     nselection(address(), value); return this;
/*     */   } public XSelectionClearEvent time(@NativeType("Time") long value) {
/* 128 */     ntime(address(), value); return this;
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
/*     */   public XSelectionClearEvent set(int type, long serial, boolean send_event, long display, long window, long selection, long time) {
/* 140 */     type(type);
/* 141 */     serial(serial);
/* 142 */     send_event(send_event);
/* 143 */     display(display);
/* 144 */     window(window);
/* 145 */     selection(selection);
/* 146 */     time(time);
/*     */     
/* 148 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSelectionClearEvent set(XSelectionClearEvent src) {
/* 159 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 160 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XSelectionClearEvent malloc() {
/* 167 */     return new XSelectionClearEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XSelectionClearEvent calloc() {
/* 172 */     return new XSelectionClearEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XSelectionClearEvent create() {
/* 177 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 178 */     return new XSelectionClearEvent(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XSelectionClearEvent create(long address) {
/* 183 */     return new XSelectionClearEvent(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XSelectionClearEvent createSafe(long address) {
/* 188 */     return (address == 0L) ? null : new XSelectionClearEvent(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 197 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 206 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 215 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 216 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 226 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 231 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XSelectionClearEvent malloc(MemoryStack stack) {
/* 240 */     return new XSelectionClearEvent(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XSelectionClearEvent calloc(MemoryStack stack) {
/* 249 */     return new XSelectionClearEvent(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 259 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 269 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int ntype(long struct) {
/* 275 */     return MemoryUtil.memGetInt(struct + TYPE);
/*     */   } public static long nserial(long struct) {
/* 277 */     return MemoryUtil.memGetCLong(struct + SERIAL);
/*     */   } public static int nsend_event(long struct) {
/* 279 */     return MemoryUtil.memGetInt(struct + SEND_EVENT);
/*     */   } public static long ndisplay(long struct) {
/* 281 */     return MemoryUtil.memGetAddress(struct + DISPLAY);
/*     */   } public static long nwindow(long struct) {
/* 283 */     return MemoryUtil.memGetCLong(struct + WINDOW);
/*     */   } public static long nselection(long struct) {
/* 285 */     return MemoryUtil.memGetCLong(struct + SELECTION);
/*     */   } public static long ntime(long struct) {
/* 287 */     return MemoryUtil.memGetCLong(struct + TIME);
/*     */   }
/*     */   public static void ntype(long struct, int value) {
/* 290 */     MemoryUtil.memPutInt(struct + TYPE, value);
/*     */   } public static void nserial(long struct, long value) {
/* 292 */     MemoryUtil.memPutCLong(struct + SERIAL, value);
/*     */   } public static void nsend_event(long struct, int value) {
/* 294 */     MemoryUtil.memPutInt(struct + SEND_EVENT, value);
/*     */   } public static void ndisplay(long struct, long value) {
/* 296 */     MemoryUtil.memPutAddress(struct + DISPLAY, Checks.check(value));
/*     */   } public static void nwindow(long struct, long value) {
/* 298 */     MemoryUtil.memPutCLong(struct + WINDOW, value);
/*     */   } public static void nselection(long struct, long value) {
/* 300 */     MemoryUtil.memPutCLong(struct + SELECTION, value);
/*     */   } public static void ntime(long struct, long value) {
/* 302 */     MemoryUtil.memPutCLong(struct + TIME, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long struct) {
/* 310 */     Checks.check(MemoryUtil.memGetAddress(struct + DISPLAY));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<XSelectionClearEvent, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 318 */     private static final XSelectionClearEvent ELEMENT_FACTORY = XSelectionClearEvent.create(-1L);
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
/* 330 */       super(container, container.remaining() / XSelectionClearEvent.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 334 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 338 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 343 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 348 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected XSelectionClearEvent getElementFactory() {
/* 353 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     public int type() {
/* 357 */       return XSelectionClearEvent.ntype(address());
/*     */     } @NativeType("unsigned long")
/*     */     public long serial() {
/* 360 */       return XSelectionClearEvent.nserial(address());
/*     */     } @NativeType("Bool")
/*     */     public boolean send_event() {
/* 363 */       return (XSelectionClearEvent.nsend_event(address()) != 0);
/*     */     } @NativeType("Display *")
/*     */     public long display() {
/* 366 */       return XSelectionClearEvent.ndisplay(address());
/*     */     } @NativeType("Window")
/*     */     public long window() {
/* 369 */       return XSelectionClearEvent.nwindow(address());
/*     */     } @NativeType("Atom")
/*     */     public long selection() {
/* 372 */       return XSelectionClearEvent.nselection(address());
/*     */     } @NativeType("Time")
/*     */     public long time() {
/* 375 */       return XSelectionClearEvent.ntime(address());
/*     */     }
/*     */     public Buffer type(int value) {
/* 378 */       XSelectionClearEvent.ntype(address(), value); return this;
/*     */     } public Buffer serial(@NativeType("unsigned long") long value) {
/* 380 */       XSelectionClearEvent.nserial(address(), value); return this;
/*     */     } public Buffer send_event(@NativeType("Bool") boolean value) {
/* 382 */       XSelectionClearEvent.nsend_event(address(), value ? 1 : 0); return this;
/*     */     } public Buffer display(@NativeType("Display *") long value) {
/* 384 */       XSelectionClearEvent.ndisplay(address(), value); return this;
/*     */     } public Buffer window(@NativeType("Window") long value) {
/* 386 */       XSelectionClearEvent.nwindow(address(), value); return this;
/*     */     } public Buffer selection(@NativeType("Atom") long value) {
/* 388 */       XSelectionClearEvent.nselection(address(), value); return this;
/*     */     } public Buffer time(@NativeType("Time") long value) {
/* 390 */       XSelectionClearEvent.ntime(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\XSelectionClearEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */