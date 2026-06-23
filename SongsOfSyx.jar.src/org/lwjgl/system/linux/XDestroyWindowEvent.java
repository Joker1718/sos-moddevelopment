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
/*     */ public class XDestroyWindowEvent
/*     */   extends Struct<XDestroyWindowEvent>
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
/*     */   
/*     */   static {
/*  48 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  49 */           __member(4), 
/*  50 */           __member(CLONG_SIZE), 
/*  51 */           __member(4), 
/*  52 */           __member(POINTER_SIZE), 
/*  53 */           __member(CLONG_SIZE), 
/*  54 */           __member(CLONG_SIZE)
/*     */         });
/*     */     
/*  57 */     SIZEOF = layout.getSize();
/*  58 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  60 */     TYPE = layout.offsetof(0);
/*  61 */     SERIAL = layout.offsetof(1);
/*  62 */     SEND_EVENT = layout.offsetof(2);
/*  63 */     DISPLAY = layout.offsetof(3);
/*  64 */     EVENT = layout.offsetof(4);
/*  65 */     WINDOW = layout.offsetof(5);
/*     */   }
/*     */   
/*     */   protected XDestroyWindowEvent(long address, ByteBuffer container) {
/*  69 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected XDestroyWindowEvent create(long address, ByteBuffer container) {
/*  74 */     return new XDestroyWindowEvent(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XDestroyWindowEvent(ByteBuffer container) {
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
/*     */   public long event() {
/* 103 */     return nevent(address());
/*     */   } @NativeType("Window")
/*     */   public long window() {
/* 106 */     return nwindow(address());
/*     */   }
/*     */   public XDestroyWindowEvent type(int value) {
/* 109 */     ntype(address(), value); return this;
/*     */   } public XDestroyWindowEvent serial(@NativeType("unsigned long") long value) {
/* 111 */     nserial(address(), value); return this;
/*     */   } public XDestroyWindowEvent send_event(@NativeType("Bool") boolean value) {
/* 113 */     nsend_event(address(), value ? 1 : 0); return this;
/*     */   } public XDestroyWindowEvent display(@NativeType("Display *") long value) {
/* 115 */     ndisplay(address(), value); return this;
/*     */   } public XDestroyWindowEvent event(@NativeType("Window") long value) {
/* 117 */     nevent(address(), value); return this;
/*     */   } public XDestroyWindowEvent window(@NativeType("Window") long value) {
/* 119 */     nwindow(address(), value); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XDestroyWindowEvent set(int type, long serial, boolean send_event, long display, long event, long window) {
/* 130 */     type(type);
/* 131 */     serial(serial);
/* 132 */     send_event(send_event);
/* 133 */     display(display);
/* 134 */     event(event);
/* 135 */     window(window);
/*     */     
/* 137 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XDestroyWindowEvent set(XDestroyWindowEvent src) {
/* 148 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 149 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XDestroyWindowEvent malloc() {
/* 156 */     return new XDestroyWindowEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XDestroyWindowEvent calloc() {
/* 161 */     return new XDestroyWindowEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XDestroyWindowEvent create() {
/* 166 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 167 */     return new XDestroyWindowEvent(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XDestroyWindowEvent create(long address) {
/* 172 */     return new XDestroyWindowEvent(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XDestroyWindowEvent createSafe(long address) {
/* 177 */     return (address == 0L) ? null : new XDestroyWindowEvent(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 186 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 195 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 204 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 205 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 215 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 220 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XDestroyWindowEvent malloc(MemoryStack stack) {
/* 229 */     return new XDestroyWindowEvent(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XDestroyWindowEvent calloc(MemoryStack stack) {
/* 238 */     return new XDestroyWindowEvent(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 248 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 258 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int ntype(long struct) {
/* 264 */     return MemoryUtil.memGetInt(struct + TYPE);
/*     */   } public static long nserial(long struct) {
/* 266 */     return MemoryUtil.memGetCLong(struct + SERIAL);
/*     */   } public static int nsend_event(long struct) {
/* 268 */     return MemoryUtil.memGetInt(struct + SEND_EVENT);
/*     */   } public static long ndisplay(long struct) {
/* 270 */     return MemoryUtil.memGetAddress(struct + DISPLAY);
/*     */   } public static long nevent(long struct) {
/* 272 */     return MemoryUtil.memGetCLong(struct + EVENT);
/*     */   } public static long nwindow(long struct) {
/* 274 */     return MemoryUtil.memGetCLong(struct + WINDOW);
/*     */   }
/*     */   public static void ntype(long struct, int value) {
/* 277 */     MemoryUtil.memPutInt(struct + TYPE, value);
/*     */   } public static void nserial(long struct, long value) {
/* 279 */     MemoryUtil.memPutCLong(struct + SERIAL, value);
/*     */   } public static void nsend_event(long struct, int value) {
/* 281 */     MemoryUtil.memPutInt(struct + SEND_EVENT, value);
/*     */   } public static void ndisplay(long struct, long value) {
/* 283 */     MemoryUtil.memPutAddress(struct + DISPLAY, Checks.check(value));
/*     */   } public static void nevent(long struct, long value) {
/* 285 */     MemoryUtil.memPutCLong(struct + EVENT, value);
/*     */   } public static void nwindow(long struct, long value) {
/* 287 */     MemoryUtil.memPutCLong(struct + WINDOW, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long struct) {
/* 295 */     Checks.check(MemoryUtil.memGetAddress(struct + DISPLAY));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<XDestroyWindowEvent, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 303 */     private static final XDestroyWindowEvent ELEMENT_FACTORY = XDestroyWindowEvent.create(-1L);
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
/* 315 */       super(container, container.remaining() / XDestroyWindowEvent.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 319 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 323 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 328 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 333 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected XDestroyWindowEvent getElementFactory() {
/* 338 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     public int type() {
/* 342 */       return XDestroyWindowEvent.ntype(address());
/*     */     } @NativeType("unsigned long")
/*     */     public long serial() {
/* 345 */       return XDestroyWindowEvent.nserial(address());
/*     */     } @NativeType("Bool")
/*     */     public boolean send_event() {
/* 348 */       return (XDestroyWindowEvent.nsend_event(address()) != 0);
/*     */     } @NativeType("Display *")
/*     */     public long display() {
/* 351 */       return XDestroyWindowEvent.ndisplay(address());
/*     */     } @NativeType("Window")
/*     */     public long event() {
/* 354 */       return XDestroyWindowEvent.nevent(address());
/*     */     } @NativeType("Window")
/*     */     public long window() {
/* 357 */       return XDestroyWindowEvent.nwindow(address());
/*     */     }
/*     */     public Buffer type(int value) {
/* 360 */       XDestroyWindowEvent.ntype(address(), value); return this;
/*     */     } public Buffer serial(@NativeType("unsigned long") long value) {
/* 362 */       XDestroyWindowEvent.nserial(address(), value); return this;
/*     */     } public Buffer send_event(@NativeType("Bool") boolean value) {
/* 364 */       XDestroyWindowEvent.nsend_event(address(), value ? 1 : 0); return this;
/*     */     } public Buffer display(@NativeType("Display *") long value) {
/* 366 */       XDestroyWindowEvent.ndisplay(address(), value); return this;
/*     */     } public Buffer event(@NativeType("Window") long value) {
/* 368 */       XDestroyWindowEvent.nevent(address(), value); return this;
/*     */     } public Buffer window(@NativeType("Window") long value) {
/* 370 */       XDestroyWindowEvent.nwindow(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\XDestroyWindowEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */