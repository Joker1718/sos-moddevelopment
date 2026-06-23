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
/*     */ public class XGenericEvent
/*     */   extends Struct<XGenericEvent>
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
/*     */   
/*     */   static {
/*  48 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  49 */           __member(4), 
/*  50 */           __member(CLONG_SIZE), 
/*  51 */           __member(4), 
/*  52 */           __member(POINTER_SIZE), 
/*  53 */           __member(4), 
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
/*  64 */     EXTENSION = layout.offsetof(4);
/*  65 */     EVTYPE = layout.offsetof(5);
/*     */   }
/*     */   
/*     */   protected XGenericEvent(long address, ByteBuffer container) {
/*  69 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected XGenericEvent create(long address, ByteBuffer container) {
/*  74 */     return new XGenericEvent(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XGenericEvent(ByteBuffer container) {
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
/*     */   } public int extension() {
/* 102 */     return nextension(address());
/*     */   } public int evtype() {
/* 104 */     return nevtype(address());
/*     */   }
/*     */   public XGenericEvent type(int value) {
/* 107 */     ntype(address(), value); return this;
/*     */   } public XGenericEvent serial(@NativeType("unsigned long") long value) {
/* 109 */     nserial(address(), value); return this;
/*     */   } public XGenericEvent send_event(@NativeType("Bool") boolean value) {
/* 111 */     nsend_event(address(), value ? 1 : 0); return this;
/*     */   } public XGenericEvent display(@NativeType("Display *") long value) {
/* 113 */     ndisplay(address(), value); return this;
/*     */   } public XGenericEvent extension(int value) {
/* 115 */     nextension(address(), value); return this;
/*     */   } public XGenericEvent evtype(int value) {
/* 117 */     nevtype(address(), value); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XGenericEvent set(int type, long serial, boolean send_event, long display, int extension, int evtype) {
/* 128 */     type(type);
/* 129 */     serial(serial);
/* 130 */     send_event(send_event);
/* 131 */     display(display);
/* 132 */     extension(extension);
/* 133 */     evtype(evtype);
/*     */     
/* 135 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XGenericEvent set(XGenericEvent src) {
/* 146 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 147 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XGenericEvent malloc() {
/* 154 */     return new XGenericEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XGenericEvent calloc() {
/* 159 */     return new XGenericEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XGenericEvent create() {
/* 164 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 165 */     return new XGenericEvent(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XGenericEvent create(long address) {
/* 170 */     return new XGenericEvent(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XGenericEvent createSafe(long address) {
/* 175 */     return (address == 0L) ? null : new XGenericEvent(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 184 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 193 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 202 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 203 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 213 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 218 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XGenericEvent malloc(MemoryStack stack) {
/* 227 */     return new XGenericEvent(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XGenericEvent calloc(MemoryStack stack) {
/* 236 */     return new XGenericEvent(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 246 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 256 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int ntype(long struct) {
/* 262 */     return MemoryUtil.memGetInt(struct + TYPE);
/*     */   } public static long nserial(long struct) {
/* 264 */     return MemoryUtil.memGetCLong(struct + SERIAL);
/*     */   } public static int nsend_event(long struct) {
/* 266 */     return MemoryUtil.memGetInt(struct + SEND_EVENT);
/*     */   } public static long ndisplay(long struct) {
/* 268 */     return MemoryUtil.memGetAddress(struct + DISPLAY);
/*     */   } public static int nextension(long struct) {
/* 270 */     return MemoryUtil.memGetInt(struct + EXTENSION);
/*     */   } public static int nevtype(long struct) {
/* 272 */     return MemoryUtil.memGetInt(struct + EVTYPE);
/*     */   }
/*     */   public static void ntype(long struct, int value) {
/* 275 */     MemoryUtil.memPutInt(struct + TYPE, value);
/*     */   } public static void nserial(long struct, long value) {
/* 277 */     MemoryUtil.memPutCLong(struct + SERIAL, value);
/*     */   } public static void nsend_event(long struct, int value) {
/* 279 */     MemoryUtil.memPutInt(struct + SEND_EVENT, value);
/*     */   } public static void ndisplay(long struct, long value) {
/* 281 */     MemoryUtil.memPutAddress(struct + DISPLAY, Checks.check(value));
/*     */   } public static void nextension(long struct, int value) {
/* 283 */     MemoryUtil.memPutInt(struct + EXTENSION, value);
/*     */   } public static void nevtype(long struct, int value) {
/* 285 */     MemoryUtil.memPutInt(struct + EVTYPE, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long struct) {
/* 293 */     Checks.check(MemoryUtil.memGetAddress(struct + DISPLAY));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<XGenericEvent, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 301 */     private static final XGenericEvent ELEMENT_FACTORY = XGenericEvent.create(-1L);
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
/* 313 */       super(container, container.remaining() / XGenericEvent.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 317 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 321 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 326 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 331 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected XGenericEvent getElementFactory() {
/* 336 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     public int type() {
/* 340 */       return XGenericEvent.ntype(address());
/*     */     } @NativeType("unsigned long")
/*     */     public long serial() {
/* 343 */       return XGenericEvent.nserial(address());
/*     */     } @NativeType("Bool")
/*     */     public boolean send_event() {
/* 346 */       return (XGenericEvent.nsend_event(address()) != 0);
/*     */     } @NativeType("Display *")
/*     */     public long display() {
/* 349 */       return XGenericEvent.ndisplay(address());
/*     */     } public int extension() {
/* 351 */       return XGenericEvent.nextension(address());
/*     */     } public int evtype() {
/* 353 */       return XGenericEvent.nevtype(address());
/*     */     }
/*     */     public Buffer type(int value) {
/* 356 */       XGenericEvent.ntype(address(), value); return this;
/*     */     } public Buffer serial(@NativeType("unsigned long") long value) {
/* 358 */       XGenericEvent.nserial(address(), value); return this;
/*     */     } public Buffer send_event(@NativeType("Bool") boolean value) {
/* 360 */       XGenericEvent.nsend_event(address(), value ? 1 : 0); return this;
/*     */     } public Buffer display(@NativeType("Display *") long value) {
/* 362 */       XGenericEvent.ndisplay(address(), value); return this;
/*     */     } public Buffer extension(int value) {
/* 364 */       XGenericEvent.nextension(address(), value); return this;
/*     */     } public Buffer evtype(int value) {
/* 366 */       XGenericEvent.nevtype(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\XGenericEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */