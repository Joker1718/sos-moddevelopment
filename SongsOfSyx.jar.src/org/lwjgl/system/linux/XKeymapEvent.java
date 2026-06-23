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
/*     */ public class XKeymapEvent
/*     */   extends Struct<XKeymapEvent>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int TYPE;
/*     */   public static final int SERIAL;
/*     */   public static final int SEND_EVENT;
/*     */   public static final int DISPLAY;
/*     */   public static final int WINDOW;
/*     */   public static final int KEY_VECTOR;
/*     */   
/*     */   static {
/*  48 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  49 */           __member(4), 
/*  50 */           __member(CLONG_SIZE), 
/*  51 */           __member(4), 
/*  52 */           __member(POINTER_SIZE), 
/*  53 */           __member(CLONG_SIZE), 
/*  54 */           __array(1, 32)
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
/*  65 */     KEY_VECTOR = layout.offsetof(5);
/*     */   }
/*     */   
/*     */   protected XKeymapEvent(long address, ByteBuffer container) {
/*  69 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected XKeymapEvent create(long address, ByteBuffer container) {
/*  74 */     return new XKeymapEvent(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XKeymapEvent(ByteBuffer container) {
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
/*     */   } @NativeType("char[32]")
/*     */   public ByteBuffer key_vector() {
/* 106 */     return nkey_vector(address());
/*     */   } @NativeType("char")
/*     */   public byte key_vector(int index) {
/* 109 */     return nkey_vector(address(), index);
/*     */   }
/*     */   public XKeymapEvent type(int value) {
/* 112 */     ntype(address(), value); return this;
/*     */   } public XKeymapEvent serial(@NativeType("unsigned long") long value) {
/* 114 */     nserial(address(), value); return this;
/*     */   } public XKeymapEvent send_event(@NativeType("Bool") boolean value) {
/* 116 */     nsend_event(address(), value ? 1 : 0); return this;
/*     */   } public XKeymapEvent display(@NativeType("Display *") long value) {
/* 118 */     ndisplay(address(), value); return this;
/*     */   } public XKeymapEvent window(@NativeType("Window") long value) {
/* 120 */     nwindow(address(), value); return this;
/*     */   } public XKeymapEvent key_vector(@NativeType("char[32]") ByteBuffer value) {
/* 122 */     nkey_vector(address(), value); return this;
/*     */   } public XKeymapEvent key_vector(int index, @NativeType("char") byte value) {
/* 124 */     nkey_vector(address(), index, value); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XKeymapEvent set(int type, long serial, boolean send_event, long display, long window, ByteBuffer key_vector) {
/* 135 */     type(type);
/* 136 */     serial(serial);
/* 137 */     send_event(send_event);
/* 138 */     display(display);
/* 139 */     window(window);
/* 140 */     key_vector(key_vector);
/*     */     
/* 142 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XKeymapEvent set(XKeymapEvent src) {
/* 153 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 154 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XKeymapEvent malloc() {
/* 161 */     return new XKeymapEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XKeymapEvent calloc() {
/* 166 */     return new XKeymapEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XKeymapEvent create() {
/* 171 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 172 */     return new XKeymapEvent(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XKeymapEvent create(long address) {
/* 177 */     return new XKeymapEvent(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XKeymapEvent createSafe(long address) {
/* 182 */     return (address == 0L) ? null : new XKeymapEvent(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 191 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 200 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 209 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 210 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 220 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 225 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XKeymapEvent malloc(MemoryStack stack) {
/* 234 */     return new XKeymapEvent(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XKeymapEvent calloc(MemoryStack stack) {
/* 243 */     return new XKeymapEvent(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 253 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 263 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int ntype(long struct) {
/* 269 */     return MemoryUtil.memGetInt(struct + TYPE);
/*     */   } public static long nserial(long struct) {
/* 271 */     return MemoryUtil.memGetCLong(struct + SERIAL);
/*     */   } public static int nsend_event(long struct) {
/* 273 */     return MemoryUtil.memGetInt(struct + SEND_EVENT);
/*     */   } public static long ndisplay(long struct) {
/* 275 */     return MemoryUtil.memGetAddress(struct + DISPLAY);
/*     */   } public static long nwindow(long struct) {
/* 277 */     return MemoryUtil.memGetCLong(struct + WINDOW);
/*     */   } public static ByteBuffer nkey_vector(long struct) {
/* 279 */     return MemoryUtil.memByteBuffer(struct + KEY_VECTOR, 32);
/*     */   }
/*     */   public static byte nkey_vector(long struct, int index) {
/* 282 */     return MemoryUtil.memGetByte(struct + KEY_VECTOR + Checks.check(index, 32) * 1L);
/*     */   }
/*     */   
/*     */   public static void ntype(long struct, int value) {
/* 286 */     MemoryUtil.memPutInt(struct + TYPE, value);
/*     */   } public static void nserial(long struct, long value) {
/* 288 */     MemoryUtil.memPutCLong(struct + SERIAL, value);
/*     */   } public static void nsend_event(long struct, int value) {
/* 290 */     MemoryUtil.memPutInt(struct + SEND_EVENT, value);
/*     */   } public static void ndisplay(long struct, long value) {
/* 292 */     MemoryUtil.memPutAddress(struct + DISPLAY, Checks.check(value));
/*     */   } public static void nwindow(long struct, long value) {
/* 294 */     MemoryUtil.memPutCLong(struct + WINDOW, value);
/*     */   }
/*     */   public static void nkey_vector(long struct, ByteBuffer value) {
/* 297 */     if (Checks.CHECKS) Checks.checkGT(value, 32); 
/* 298 */     MemoryUtil.memCopy(MemoryUtil.memAddress(value), struct + KEY_VECTOR, (value.remaining() * 1));
/*     */   }
/*     */   
/*     */   public static void nkey_vector(long struct, int index, byte value) {
/* 302 */     MemoryUtil.memPutByte(struct + KEY_VECTOR + Checks.check(index, 32) * 1L, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long struct) {
/* 311 */     Checks.check(MemoryUtil.memGetAddress(struct + DISPLAY));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<XKeymapEvent, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 319 */     private static final XKeymapEvent ELEMENT_FACTORY = XKeymapEvent.create(-1L);
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
/* 331 */       super(container, container.remaining() / XKeymapEvent.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 335 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 339 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 344 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 349 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected XKeymapEvent getElementFactory() {
/* 354 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     public int type() {
/* 358 */       return XKeymapEvent.ntype(address());
/*     */     } @NativeType("unsigned long")
/*     */     public long serial() {
/* 361 */       return XKeymapEvent.nserial(address());
/*     */     } @NativeType("Bool")
/*     */     public boolean send_event() {
/* 364 */       return (XKeymapEvent.nsend_event(address()) != 0);
/*     */     } @NativeType("Display *")
/*     */     public long display() {
/* 367 */       return XKeymapEvent.ndisplay(address());
/*     */     } @NativeType("Window")
/*     */     public long window() {
/* 370 */       return XKeymapEvent.nwindow(address());
/*     */     } @NativeType("char[32]")
/*     */     public ByteBuffer key_vector() {
/* 373 */       return XKeymapEvent.nkey_vector(address());
/*     */     } @NativeType("char")
/*     */     public byte key_vector(int index) {
/* 376 */       return XKeymapEvent.nkey_vector(address(), index);
/*     */     }
/*     */     public Buffer type(int value) {
/* 379 */       XKeymapEvent.ntype(address(), value); return this;
/*     */     } public Buffer serial(@NativeType("unsigned long") long value) {
/* 381 */       XKeymapEvent.nserial(address(), value); return this;
/*     */     } public Buffer send_event(@NativeType("Bool") boolean value) {
/* 383 */       XKeymapEvent.nsend_event(address(), value ? 1 : 0); return this;
/*     */     } public Buffer display(@NativeType("Display *") long value) {
/* 385 */       XKeymapEvent.ndisplay(address(), value); return this;
/*     */     } public Buffer window(@NativeType("Window") long value) {
/* 387 */       XKeymapEvent.nwindow(address(), value); return this;
/*     */     } public Buffer key_vector(@NativeType("char[32]") ByteBuffer value) {
/* 389 */       XKeymapEvent.nkey_vector(address(), value); return this;
/*     */     } public Buffer key_vector(int index, @NativeType("char") byte value) {
/* 391 */       XKeymapEvent.nkey_vector(address(), index, value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\XKeymapEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */