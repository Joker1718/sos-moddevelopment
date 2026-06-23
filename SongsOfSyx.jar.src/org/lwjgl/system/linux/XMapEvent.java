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
/*     */ public class XMapEvent
/*     */   extends Struct<XMapEvent>
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
/*     */   public static final int OVERRIDE_REDIRECT;
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
/*  67 */     EVENT = layout.offsetof(4);
/*  68 */     WINDOW = layout.offsetof(5);
/*  69 */     OVERRIDE_REDIRECT = layout.offsetof(6);
/*     */   }
/*     */   
/*     */   protected XMapEvent(long address, ByteBuffer container) {
/*  73 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected XMapEvent create(long address, ByteBuffer container) {
/*  78 */     return new XMapEvent(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XMapEvent(ByteBuffer container) {
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
/*     */   public long event() {
/* 107 */     return nevent(address());
/*     */   } @NativeType("Window")
/*     */   public long window() {
/* 110 */     return nwindow(address());
/*     */   } public int override_redirect() {
/* 112 */     return noverride_redirect(address());
/*     */   }
/*     */   public XMapEvent type(int value) {
/* 115 */     ntype(address(), value); return this;
/*     */   } public XMapEvent serial(@NativeType("unsigned long") long value) {
/* 117 */     nserial(address(), value); return this;
/*     */   } public XMapEvent send_event(@NativeType("Bool") boolean value) {
/* 119 */     nsend_event(address(), value ? 1 : 0); return this;
/*     */   } public XMapEvent display(@NativeType("Display *") long value) {
/* 121 */     ndisplay(address(), value); return this;
/*     */   } public XMapEvent event(@NativeType("Window") long value) {
/* 123 */     nevent(address(), value); return this;
/*     */   } public XMapEvent window(@NativeType("Window") long value) {
/* 125 */     nwindow(address(), value); return this;
/*     */   } public XMapEvent override_redirect(int value) {
/* 127 */     noverride_redirect(address(), value); return this;
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
/*     */   public XMapEvent set(int type, long serial, boolean send_event, long display, long event, long window, int override_redirect) {
/* 139 */     type(type);
/* 140 */     serial(serial);
/* 141 */     send_event(send_event);
/* 142 */     display(display);
/* 143 */     event(event);
/* 144 */     window(window);
/* 145 */     override_redirect(override_redirect);
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
/*     */   public XMapEvent set(XMapEvent src) {
/* 158 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 159 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XMapEvent malloc() {
/* 166 */     return new XMapEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XMapEvent calloc() {
/* 171 */     return new XMapEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XMapEvent create() {
/* 176 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 177 */     return new XMapEvent(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XMapEvent create(long address) {
/* 182 */     return new XMapEvent(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XMapEvent createSafe(long address) {
/* 187 */     return (address == 0L) ? null : new XMapEvent(address, null);
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
/*     */   public static XMapEvent malloc(MemoryStack stack) {
/* 239 */     return new XMapEvent(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XMapEvent calloc(MemoryStack stack) {
/* 248 */     return new XMapEvent(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
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
/*     */   } public static long nevent(long struct) {
/* 282 */     return MemoryUtil.memGetCLong(struct + EVENT);
/*     */   } public static long nwindow(long struct) {
/* 284 */     return MemoryUtil.memGetCLong(struct + WINDOW);
/*     */   } public static int noverride_redirect(long struct) {
/* 286 */     return MemoryUtil.memGetInt(struct + OVERRIDE_REDIRECT);
/*     */   }
/*     */   public static void ntype(long struct, int value) {
/* 289 */     MemoryUtil.memPutInt(struct + TYPE, value);
/*     */   } public static void nserial(long struct, long value) {
/* 291 */     MemoryUtil.memPutCLong(struct + SERIAL, value);
/*     */   } public static void nsend_event(long struct, int value) {
/* 293 */     MemoryUtil.memPutInt(struct + SEND_EVENT, value);
/*     */   } public static void ndisplay(long struct, long value) {
/* 295 */     MemoryUtil.memPutAddress(struct + DISPLAY, Checks.check(value));
/*     */   } public static void nevent(long struct, long value) {
/* 297 */     MemoryUtil.memPutCLong(struct + EVENT, value);
/*     */   } public static void nwindow(long struct, long value) {
/* 299 */     MemoryUtil.memPutCLong(struct + WINDOW, value);
/*     */   } public static void noverride_redirect(long struct, int value) {
/* 301 */     MemoryUtil.memPutInt(struct + OVERRIDE_REDIRECT, value);
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
/*     */     extends StructBuffer<XMapEvent, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 317 */     private static final XMapEvent ELEMENT_FACTORY = XMapEvent.create(-1L);
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
/* 329 */       super(container, container.remaining() / XMapEvent.SIZEOF);
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
/*     */     protected XMapEvent getElementFactory() {
/* 352 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     public int type() {
/* 356 */       return XMapEvent.ntype(address());
/*     */     } @NativeType("unsigned long")
/*     */     public long serial() {
/* 359 */       return XMapEvent.nserial(address());
/*     */     } @NativeType("Bool")
/*     */     public boolean send_event() {
/* 362 */       return (XMapEvent.nsend_event(address()) != 0);
/*     */     } @NativeType("Display *")
/*     */     public long display() {
/* 365 */       return XMapEvent.ndisplay(address());
/*     */     } @NativeType("Window")
/*     */     public long event() {
/* 368 */       return XMapEvent.nevent(address());
/*     */     } @NativeType("Window")
/*     */     public long window() {
/* 371 */       return XMapEvent.nwindow(address());
/*     */     } public int override_redirect() {
/* 373 */       return XMapEvent.noverride_redirect(address());
/*     */     }
/*     */     public Buffer type(int value) {
/* 376 */       XMapEvent.ntype(address(), value); return this;
/*     */     } public Buffer serial(@NativeType("unsigned long") long value) {
/* 378 */       XMapEvent.nserial(address(), value); return this;
/*     */     } public Buffer send_event(@NativeType("Bool") boolean value) {
/* 380 */       XMapEvent.nsend_event(address(), value ? 1 : 0); return this;
/*     */     } public Buffer display(@NativeType("Display *") long value) {
/* 382 */       XMapEvent.ndisplay(address(), value); return this;
/*     */     } public Buffer event(@NativeType("Window") long value) {
/* 384 */       XMapEvent.nevent(address(), value); return this;
/*     */     } public Buffer window(@NativeType("Window") long value) {
/* 386 */       XMapEvent.nwindow(address(), value); return this;
/*     */     } public Buffer override_redirect(int value) {
/* 388 */       XMapEvent.noverride_redirect(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\XMapEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */