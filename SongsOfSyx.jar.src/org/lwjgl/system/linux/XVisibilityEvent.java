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
/*     */ public class XVisibilityEvent
/*     */   extends Struct<XVisibilityEvent>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int TYPE;
/*     */   public static final int SERIAL;
/*     */   public static final int SEND_EVENT;
/*     */   public static final int DISPLAY;
/*     */   public static final int WINDOW;
/*     */   public static final int STATE;
/*     */   
/*     */   static {
/*  48 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  49 */           __member(4), 
/*  50 */           __member(CLONG_SIZE), 
/*  51 */           __member(4), 
/*  52 */           __member(POINTER_SIZE), 
/*  53 */           __member(CLONG_SIZE), 
/*  54 */           __member(4)
/*     */         });
/*     */     
/*  57 */     SIZEOF = layout.getSize();
/*  58 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  60 */     TYPE = layout.offsetof(0);
/*  61 */     SERIAL = layout.offsetof(1);
/*  62 */     SEND_EVENT = layout.offsetof(2);
/*  63 */     DISPLAY = layout.offsetof(3);
/*  64 */     WINDOW = layout.offsetof(4);
/*  65 */     STATE = layout.offsetof(5);
/*     */   }
/*     */   
/*     */   protected XVisibilityEvent(long address, ByteBuffer container) {
/*  69 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected XVisibilityEvent create(long address, ByteBuffer container) {
/*  74 */     return new XVisibilityEvent(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XVisibilityEvent(ByteBuffer container) {
/*  84 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  88 */     return SIZEOF;
/*     */   }
/*     */   public int type() {
/*  91 */     return ntype(address());
/*     */   } @NativeType("unsigned long")
/*     */   public long serial() {
/*  94 */     return nserial(address());
/*     */   } @NativeType("Bool")
/*     */   public boolean send_event() {
/*  97 */     return (nsend_event(address()) != 0);
/*     */   } @NativeType("Display *")
/*     */   public long display() {
/* 100 */     return ndisplay(address());
/*     */   } @NativeType("Window")
/*     */   public long window() {
/* 103 */     return nwindow(address());
/*     */   } public int state() {
/* 105 */     return nstate(address());
/*     */   }
/*     */   public XVisibilityEvent type(int value) {
/* 108 */     ntype(address(), value); return this;
/*     */   } public XVisibilityEvent serial(@NativeType("unsigned long") long value) {
/* 110 */     nserial(address(), value); return this;
/*     */   } public XVisibilityEvent send_event(@NativeType("Bool") boolean value) {
/* 112 */     nsend_event(address(), value ? 1 : 0); return this;
/*     */   } public XVisibilityEvent display(@NativeType("Display *") long value) {
/* 114 */     ndisplay(address(), value); return this;
/*     */   } public XVisibilityEvent window(@NativeType("Window") long value) {
/* 116 */     nwindow(address(), value); return this;
/*     */   } public XVisibilityEvent state(int value) {
/* 118 */     nstate(address(), value); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XVisibilityEvent set(int type, long serial, boolean send_event, long display, long window, int state) {
/* 129 */     type(type);
/* 130 */     serial(serial);
/* 131 */     send_event(send_event);
/* 132 */     display(display);
/* 133 */     window(window);
/* 134 */     state(state);
/*     */     
/* 136 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XVisibilityEvent set(XVisibilityEvent src) {
/* 147 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 148 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XVisibilityEvent malloc() {
/* 155 */     return new XVisibilityEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XVisibilityEvent calloc() {
/* 160 */     return new XVisibilityEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XVisibilityEvent create() {
/* 165 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 166 */     return new XVisibilityEvent(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XVisibilityEvent create(long address) {
/* 171 */     return new XVisibilityEvent(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XVisibilityEvent createSafe(long address) {
/* 176 */     return (address == 0L) ? null : new XVisibilityEvent(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 185 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 194 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 203 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 204 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 214 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 219 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XVisibilityEvent malloc(MemoryStack stack) {
/* 228 */     return new XVisibilityEvent(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XVisibilityEvent calloc(MemoryStack stack) {
/* 237 */     return new XVisibilityEvent(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 247 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 257 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int ntype(long struct) {
/* 263 */     return MemoryUtil.memGetInt(struct + TYPE);
/*     */   } public static long nserial(long struct) {
/* 265 */     return MemoryUtil.memGetCLong(struct + SERIAL);
/*     */   } public static int nsend_event(long struct) {
/* 267 */     return MemoryUtil.memGetInt(struct + SEND_EVENT);
/*     */   } public static long ndisplay(long struct) {
/* 269 */     return MemoryUtil.memGetAddress(struct + DISPLAY);
/*     */   } public static long nwindow(long struct) {
/* 271 */     return MemoryUtil.memGetCLong(struct + WINDOW);
/*     */   } public static int nstate(long struct) {
/* 273 */     return MemoryUtil.memGetInt(struct + STATE);
/*     */   }
/*     */   public static void ntype(long struct, int value) {
/* 276 */     MemoryUtil.memPutInt(struct + TYPE, value);
/*     */   } public static void nserial(long struct, long value) {
/* 278 */     MemoryUtil.memPutCLong(struct + SERIAL, value);
/*     */   } public static void nsend_event(long struct, int value) {
/* 280 */     MemoryUtil.memPutInt(struct + SEND_EVENT, value);
/*     */   } public static void ndisplay(long struct, long value) {
/* 282 */     MemoryUtil.memPutAddress(struct + DISPLAY, Checks.check(value));
/*     */   } public static void nwindow(long struct, long value) {
/* 284 */     MemoryUtil.memPutCLong(struct + WINDOW, value);
/*     */   } public static void nstate(long struct, int value) {
/* 286 */     MemoryUtil.memPutInt(struct + STATE, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long struct) {
/* 294 */     Checks.check(MemoryUtil.memGetAddress(struct + DISPLAY));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<XVisibilityEvent, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 302 */     private static final XVisibilityEvent ELEMENT_FACTORY = XVisibilityEvent.create(-1L);
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
/* 314 */       super(container, container.remaining() / XVisibilityEvent.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 318 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 322 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 327 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 332 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected XVisibilityEvent getElementFactory() {
/* 337 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     public int type() {
/* 341 */       return XVisibilityEvent.ntype(address());
/*     */     } @NativeType("unsigned long")
/*     */     public long serial() {
/* 344 */       return XVisibilityEvent.nserial(address());
/*     */     } @NativeType("Bool")
/*     */     public boolean send_event() {
/* 347 */       return (XVisibilityEvent.nsend_event(address()) != 0);
/*     */     } @NativeType("Display *")
/*     */     public long display() {
/* 350 */       return XVisibilityEvent.ndisplay(address());
/*     */     } @NativeType("Window")
/*     */     public long window() {
/* 353 */       return XVisibilityEvent.nwindow(address());
/*     */     } public int state() {
/* 355 */       return XVisibilityEvent.nstate(address());
/*     */     }
/*     */     public Buffer type(int value) {
/* 358 */       XVisibilityEvent.ntype(address(), value); return this;
/*     */     } public Buffer serial(@NativeType("unsigned long") long value) {
/* 360 */       XVisibilityEvent.nserial(address(), value); return this;
/*     */     } public Buffer send_event(@NativeType("Bool") boolean value) {
/* 362 */       XVisibilityEvent.nsend_event(address(), value ? 1 : 0); return this;
/*     */     } public Buffer display(@NativeType("Display *") long value) {
/* 364 */       XVisibilityEvent.ndisplay(address(), value); return this;
/*     */     } public Buffer window(@NativeType("Window") long value) {
/* 366 */       XVisibilityEvent.nwindow(address(), value); return this;
/*     */     } public Buffer state(int value) {
/* 368 */       XVisibilityEvent.nstate(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\XVisibilityEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */