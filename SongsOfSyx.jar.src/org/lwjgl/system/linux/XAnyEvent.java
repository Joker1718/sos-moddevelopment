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
/*     */ public class XAnyEvent
/*     */   extends Struct<XAnyEvent>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int TYPE;
/*     */   public static final int SERIAL;
/*     */   public static final int SEND_EVENT;
/*     */   public static final int DISPLAY;
/*     */   public static final int WINDOW;
/*     */   
/*     */   static {
/*  46 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  47 */           __member(4), 
/*  48 */           __member(CLONG_SIZE), 
/*  49 */           __member(4), 
/*  50 */           __member(POINTER_SIZE), 
/*  51 */           __member(CLONG_SIZE)
/*     */         });
/*     */     
/*  54 */     SIZEOF = layout.getSize();
/*  55 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  57 */     TYPE = layout.offsetof(0);
/*  58 */     SERIAL = layout.offsetof(1);
/*  59 */     SEND_EVENT = layout.offsetof(2);
/*  60 */     DISPLAY = layout.offsetof(3);
/*  61 */     WINDOW = layout.offsetof(4);
/*     */   }
/*     */   
/*     */   protected XAnyEvent(long address, ByteBuffer container) {
/*  65 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected XAnyEvent create(long address, ByteBuffer container) {
/*  70 */     return new XAnyEvent(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XAnyEvent(ByteBuffer container) {
/*  80 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  84 */     return SIZEOF;
/*     */   }
/*     */   public int type() {
/*  87 */     return ntype(address());
/*     */   } @NativeType("unsigned long")
/*     */   public long serial() {
/*  90 */     return nserial(address());
/*     */   } @NativeType("Bool")
/*     */   public boolean send_event() {
/*  93 */     return (nsend_event(address()) != 0);
/*     */   } @NativeType("Display *")
/*     */   public long display() {
/*  96 */     return ndisplay(address());
/*     */   } @NativeType("Window")
/*     */   public long window() {
/*  99 */     return nwindow(address());
/*     */   }
/*     */   public XAnyEvent type(int value) {
/* 102 */     ntype(address(), value); return this;
/*     */   } public XAnyEvent serial(@NativeType("unsigned long") long value) {
/* 104 */     nserial(address(), value); return this;
/*     */   } public XAnyEvent send_event(@NativeType("Bool") boolean value) {
/* 106 */     nsend_event(address(), value ? 1 : 0); return this;
/*     */   } public XAnyEvent display(@NativeType("Display *") long value) {
/* 108 */     ndisplay(address(), value); return this;
/*     */   } public XAnyEvent window(@NativeType("Window") long value) {
/* 110 */     nwindow(address(), value); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XAnyEvent set(int type, long serial, boolean send_event, long display, long window) {
/* 120 */     type(type);
/* 121 */     serial(serial);
/* 122 */     send_event(send_event);
/* 123 */     display(display);
/* 124 */     window(window);
/*     */     
/* 126 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XAnyEvent set(XAnyEvent src) {
/* 137 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 138 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XAnyEvent malloc() {
/* 145 */     return new XAnyEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XAnyEvent calloc() {
/* 150 */     return new XAnyEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XAnyEvent create() {
/* 155 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 156 */     return new XAnyEvent(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XAnyEvent create(long address) {
/* 161 */     return new XAnyEvent(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XAnyEvent createSafe(long address) {
/* 166 */     return (address == 0L) ? null : new XAnyEvent(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 175 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 184 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 193 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 194 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 204 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 209 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XAnyEvent malloc(MemoryStack stack) {
/* 218 */     return new XAnyEvent(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XAnyEvent calloc(MemoryStack stack) {
/* 227 */     return new XAnyEvent(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 237 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 247 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int ntype(long struct) {
/* 253 */     return MemoryUtil.memGetInt(struct + TYPE);
/*     */   } public static long nserial(long struct) {
/* 255 */     return MemoryUtil.memGetCLong(struct + SERIAL);
/*     */   } public static int nsend_event(long struct) {
/* 257 */     return MemoryUtil.memGetInt(struct + SEND_EVENT);
/*     */   } public static long ndisplay(long struct) {
/* 259 */     return MemoryUtil.memGetAddress(struct + DISPLAY);
/*     */   } public static long nwindow(long struct) {
/* 261 */     return MemoryUtil.memGetCLong(struct + WINDOW);
/*     */   }
/*     */   public static void ntype(long struct, int value) {
/* 264 */     MemoryUtil.memPutInt(struct + TYPE, value);
/*     */   } public static void nserial(long struct, long value) {
/* 266 */     MemoryUtil.memPutCLong(struct + SERIAL, value);
/*     */   } public static void nsend_event(long struct, int value) {
/* 268 */     MemoryUtil.memPutInt(struct + SEND_EVENT, value);
/*     */   } public static void ndisplay(long struct, long value) {
/* 270 */     MemoryUtil.memPutAddress(struct + DISPLAY, Checks.check(value));
/*     */   } public static void nwindow(long struct, long value) {
/* 272 */     MemoryUtil.memPutCLong(struct + WINDOW, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long struct) {
/* 280 */     Checks.check(MemoryUtil.memGetAddress(struct + DISPLAY));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<XAnyEvent, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 288 */     private static final XAnyEvent ELEMENT_FACTORY = XAnyEvent.create(-1L);
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
/* 300 */       super(container, container.remaining() / XAnyEvent.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 304 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 308 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 313 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 318 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected XAnyEvent getElementFactory() {
/* 323 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     public int type() {
/* 327 */       return XAnyEvent.ntype(address());
/*     */     } @NativeType("unsigned long")
/*     */     public long serial() {
/* 330 */       return XAnyEvent.nserial(address());
/*     */     } @NativeType("Bool")
/*     */     public boolean send_event() {
/* 333 */       return (XAnyEvent.nsend_event(address()) != 0);
/*     */     } @NativeType("Display *")
/*     */     public long display() {
/* 336 */       return XAnyEvent.ndisplay(address());
/*     */     } @NativeType("Window")
/*     */     public long window() {
/* 339 */       return XAnyEvent.nwindow(address());
/*     */     }
/*     */     public Buffer type(int value) {
/* 342 */       XAnyEvent.ntype(address(), value); return this;
/*     */     } public Buffer serial(@NativeType("unsigned long") long value) {
/* 344 */       XAnyEvent.nserial(address(), value); return this;
/*     */     } public Buffer send_event(@NativeType("Bool") boolean value) {
/* 346 */       XAnyEvent.nsend_event(address(), value ? 1 : 0); return this;
/*     */     } public Buffer display(@NativeType("Display *") long value) {
/* 348 */       XAnyEvent.ndisplay(address(), value); return this;
/*     */     } public Buffer window(@NativeType("Window") long value) {
/* 350 */       XAnyEvent.nwindow(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\XAnyEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */