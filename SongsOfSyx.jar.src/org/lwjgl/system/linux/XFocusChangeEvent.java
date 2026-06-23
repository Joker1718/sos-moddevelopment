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
/*     */ public class XFocusChangeEvent
/*     */   extends Struct<XFocusChangeEvent>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int TYPE;
/*     */   public static final int SERIAL;
/*     */   public static final int SEND_EVENT;
/*     */   public static final int DISPLAY;
/*     */   public static final int WINDOW;
/*     */   public static final int MODE;
/*     */   public static final int DETAIL;
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
/*  68 */     MODE = layout.offsetof(5);
/*  69 */     DETAIL = layout.offsetof(6);
/*     */   }
/*     */   
/*     */   protected XFocusChangeEvent(long address, ByteBuffer container) {
/*  73 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected XFocusChangeEvent create(long address, ByteBuffer container) {
/*  78 */     return new XFocusChangeEvent(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XFocusChangeEvent(ByteBuffer container) {
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
/*     */   } public int mode() {
/* 109 */     return nmode(address());
/*     */   } public int detail() {
/* 111 */     return ndetail(address());
/*     */   }
/*     */   public XFocusChangeEvent type(int value) {
/* 114 */     ntype(address(), value); return this;
/*     */   } public XFocusChangeEvent serial(@NativeType("unsigned long") long value) {
/* 116 */     nserial(address(), value); return this;
/*     */   } public XFocusChangeEvent send_event(@NativeType("Bool") boolean value) {
/* 118 */     nsend_event(address(), value ? 1 : 0); return this;
/*     */   } public XFocusChangeEvent display(@NativeType("Display *") long value) {
/* 120 */     ndisplay(address(), value); return this;
/*     */   } public XFocusChangeEvent window(@NativeType("Window") long value) {
/* 122 */     nwindow(address(), value); return this;
/*     */   } public XFocusChangeEvent mode(int value) {
/* 124 */     nmode(address(), value); return this;
/*     */   } public XFocusChangeEvent detail(int value) {
/* 126 */     ndetail(address(), value); return this;
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
/*     */   public XFocusChangeEvent set(int type, long serial, boolean send_event, long display, long window, int mode, int detail) {
/* 138 */     type(type);
/* 139 */     serial(serial);
/* 140 */     send_event(send_event);
/* 141 */     display(display);
/* 142 */     window(window);
/* 143 */     mode(mode);
/* 144 */     detail(detail);
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
/*     */   public XFocusChangeEvent set(XFocusChangeEvent src) {
/* 157 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 158 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XFocusChangeEvent malloc() {
/* 165 */     return new XFocusChangeEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XFocusChangeEvent calloc() {
/* 170 */     return new XFocusChangeEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XFocusChangeEvent create() {
/* 175 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 176 */     return new XFocusChangeEvent(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XFocusChangeEvent create(long address) {
/* 181 */     return new XFocusChangeEvent(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XFocusChangeEvent createSafe(long address) {
/* 186 */     return (address == 0L) ? null : new XFocusChangeEvent(address, null);
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
/*     */   public static XFocusChangeEvent malloc(MemoryStack stack) {
/* 238 */     return new XFocusChangeEvent(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XFocusChangeEvent calloc(MemoryStack stack) {
/* 247 */     return new XFocusChangeEvent(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
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
/*     */   } public static int nmode(long struct) {
/* 283 */     return MemoryUtil.memGetInt(struct + MODE);
/*     */   } public static int ndetail(long struct) {
/* 285 */     return MemoryUtil.memGetInt(struct + DETAIL);
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
/*     */   } public static void nmode(long struct, int value) {
/* 298 */     MemoryUtil.memPutInt(struct + MODE, value);
/*     */   } public static void ndetail(long struct, int value) {
/* 300 */     MemoryUtil.memPutInt(struct + DETAIL, value);
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
/*     */     extends StructBuffer<XFocusChangeEvent, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 316 */     private static final XFocusChangeEvent ELEMENT_FACTORY = XFocusChangeEvent.create(-1L);
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
/* 328 */       super(container, container.remaining() / XFocusChangeEvent.SIZEOF);
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
/*     */     protected XFocusChangeEvent getElementFactory() {
/* 351 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     public int type() {
/* 355 */       return XFocusChangeEvent.ntype(address());
/*     */     } @NativeType("unsigned long")
/*     */     public long serial() {
/* 358 */       return XFocusChangeEvent.nserial(address());
/*     */     } @NativeType("Bool")
/*     */     public boolean send_event() {
/* 361 */       return (XFocusChangeEvent.nsend_event(address()) != 0);
/*     */     } @NativeType("Display *")
/*     */     public long display() {
/* 364 */       return XFocusChangeEvent.ndisplay(address());
/*     */     } @NativeType("Window")
/*     */     public long window() {
/* 367 */       return XFocusChangeEvent.nwindow(address());
/*     */     } public int mode() {
/* 369 */       return XFocusChangeEvent.nmode(address());
/*     */     } public int detail() {
/* 371 */       return XFocusChangeEvent.ndetail(address());
/*     */     }
/*     */     public Buffer type(int value) {
/* 374 */       XFocusChangeEvent.ntype(address(), value); return this;
/*     */     } public Buffer serial(@NativeType("unsigned long") long value) {
/* 376 */       XFocusChangeEvent.nserial(address(), value); return this;
/*     */     } public Buffer send_event(@NativeType("Bool") boolean value) {
/* 378 */       XFocusChangeEvent.nsend_event(address(), value ? 1 : 0); return this;
/*     */     } public Buffer display(@NativeType("Display *") long value) {
/* 380 */       XFocusChangeEvent.ndisplay(address(), value); return this;
/*     */     } public Buffer window(@NativeType("Window") long value) {
/* 382 */       XFocusChangeEvent.nwindow(address(), value); return this;
/*     */     } public Buffer mode(int value) {
/* 384 */       XFocusChangeEvent.nmode(address(), value); return this;
/*     */     } public Buffer detail(int value) {
/* 386 */       XFocusChangeEvent.ndetail(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\XFocusChangeEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */