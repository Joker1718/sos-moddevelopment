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
/*     */ 
/*     */ public class XSelectionEvent
/*     */   extends Struct<XSelectionEvent>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int TYPE;
/*     */   public static final int SERIAL;
/*     */   public static final int SEND_EVENT;
/*     */   public static final int DISPLAY;
/*     */   public static final int REQUESTOR;
/*     */   public static final int SELECTION;
/*     */   public static final int TARGET;
/*     */   public static final int PROPERTY;
/*     */   public static final int TIME;
/*     */   
/*     */   static {
/*  54 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  55 */           __member(4), 
/*  56 */           __member(CLONG_SIZE), 
/*  57 */           __member(4), 
/*  58 */           __member(POINTER_SIZE), 
/*  59 */           __member(CLONG_SIZE), 
/*  60 */           __member(CLONG_SIZE), 
/*  61 */           __member(CLONG_SIZE), 
/*  62 */           __member(CLONG_SIZE), 
/*  63 */           __member(CLONG_SIZE)
/*     */         });
/*     */     
/*  66 */     SIZEOF = layout.getSize();
/*  67 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  69 */     TYPE = layout.offsetof(0);
/*  70 */     SERIAL = layout.offsetof(1);
/*  71 */     SEND_EVENT = layout.offsetof(2);
/*  72 */     DISPLAY = layout.offsetof(3);
/*  73 */     REQUESTOR = layout.offsetof(4);
/*  74 */     SELECTION = layout.offsetof(5);
/*  75 */     TARGET = layout.offsetof(6);
/*  76 */     PROPERTY = layout.offsetof(7);
/*  77 */     TIME = layout.offsetof(8);
/*     */   }
/*     */   
/*     */   protected XSelectionEvent(long address, ByteBuffer container) {
/*  81 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected XSelectionEvent create(long address, ByteBuffer container) {
/*  86 */     return new XSelectionEvent(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSelectionEvent(ByteBuffer container) {
/*  96 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/* 100 */     return SIZEOF;
/*     */   }
/*     */   public int type() {
/* 103 */     return ntype(address());
/*     */   } @NativeType("unsigned long")
/*     */   public long serial() {
/* 106 */     return nserial(address());
/*     */   } @NativeType("Bool")
/*     */   public boolean send_event() {
/* 109 */     return (nsend_event(address()) != 0);
/*     */   } @NativeType("Display *")
/*     */   public long display() {
/* 112 */     return ndisplay(address());
/*     */   } @NativeType("Window")
/*     */   public long requestor() {
/* 115 */     return nrequestor(address());
/*     */   } @NativeType("Atom")
/*     */   public long selection() {
/* 118 */     return nselection(address());
/*     */   } @NativeType("Atom")
/*     */   public long target() {
/* 121 */     return ntarget(address());
/*     */   } @NativeType("Atom")
/*     */   public long property() {
/* 124 */     return nproperty(address());
/*     */   } @NativeType("Time")
/*     */   public long time() {
/* 127 */     return ntime(address());
/*     */   }
/*     */   public XSelectionEvent type(int value) {
/* 130 */     ntype(address(), value); return this;
/*     */   } public XSelectionEvent serial(@NativeType("unsigned long") long value) {
/* 132 */     nserial(address(), value); return this;
/*     */   } public XSelectionEvent send_event(@NativeType("Bool") boolean value) {
/* 134 */     nsend_event(address(), value ? 1 : 0); return this;
/*     */   } public XSelectionEvent display(@NativeType("Display *") long value) {
/* 136 */     ndisplay(address(), value); return this;
/*     */   } public XSelectionEvent requestor(@NativeType("Window") long value) {
/* 138 */     nrequestor(address(), value); return this;
/*     */   } public XSelectionEvent selection(@NativeType("Atom") long value) {
/* 140 */     nselection(address(), value); return this;
/*     */   } public XSelectionEvent target(@NativeType("Atom") long value) {
/* 142 */     ntarget(address(), value); return this;
/*     */   } public XSelectionEvent property(@NativeType("Atom") long value) {
/* 144 */     nproperty(address(), value); return this;
/*     */   } public XSelectionEvent time(@NativeType("Time") long value) {
/* 146 */     ntime(address(), value); return this;
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
/*     */   
/*     */   public XSelectionEvent set(int type, long serial, boolean send_event, long display, long requestor, long selection, long target, long property, long time) {
/* 160 */     type(type);
/* 161 */     serial(serial);
/* 162 */     send_event(send_event);
/* 163 */     display(display);
/* 164 */     requestor(requestor);
/* 165 */     selection(selection);
/* 166 */     target(target);
/* 167 */     property(property);
/* 168 */     time(time);
/*     */     
/* 170 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSelectionEvent set(XSelectionEvent src) {
/* 181 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 182 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XSelectionEvent malloc() {
/* 189 */     return new XSelectionEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XSelectionEvent calloc() {
/* 194 */     return new XSelectionEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XSelectionEvent create() {
/* 199 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 200 */     return new XSelectionEvent(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XSelectionEvent create(long address) {
/* 205 */     return new XSelectionEvent(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XSelectionEvent createSafe(long address) {
/* 210 */     return (address == 0L) ? null : new XSelectionEvent(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 219 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 228 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 237 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 238 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 248 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 253 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XSelectionEvent malloc(MemoryStack stack) {
/* 262 */     return new XSelectionEvent(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XSelectionEvent calloc(MemoryStack stack) {
/* 271 */     return new XSelectionEvent(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 281 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 291 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int ntype(long struct) {
/* 297 */     return MemoryUtil.memGetInt(struct + TYPE);
/*     */   } public static long nserial(long struct) {
/* 299 */     return MemoryUtil.memGetCLong(struct + SERIAL);
/*     */   } public static int nsend_event(long struct) {
/* 301 */     return MemoryUtil.memGetInt(struct + SEND_EVENT);
/*     */   } public static long ndisplay(long struct) {
/* 303 */     return MemoryUtil.memGetAddress(struct + DISPLAY);
/*     */   } public static long nrequestor(long struct) {
/* 305 */     return MemoryUtil.memGetCLong(struct + REQUESTOR);
/*     */   } public static long nselection(long struct) {
/* 307 */     return MemoryUtil.memGetCLong(struct + SELECTION);
/*     */   } public static long ntarget(long struct) {
/* 309 */     return MemoryUtil.memGetCLong(struct + TARGET);
/*     */   } public static long nproperty(long struct) {
/* 311 */     return MemoryUtil.memGetCLong(struct + PROPERTY);
/*     */   } public static long ntime(long struct) {
/* 313 */     return MemoryUtil.memGetCLong(struct + TIME);
/*     */   }
/*     */   public static void ntype(long struct, int value) {
/* 316 */     MemoryUtil.memPutInt(struct + TYPE, value);
/*     */   } public static void nserial(long struct, long value) {
/* 318 */     MemoryUtil.memPutCLong(struct + SERIAL, value);
/*     */   } public static void nsend_event(long struct, int value) {
/* 320 */     MemoryUtil.memPutInt(struct + SEND_EVENT, value);
/*     */   } public static void ndisplay(long struct, long value) {
/* 322 */     MemoryUtil.memPutAddress(struct + DISPLAY, Checks.check(value));
/*     */   } public static void nrequestor(long struct, long value) {
/* 324 */     MemoryUtil.memPutCLong(struct + REQUESTOR, value);
/*     */   } public static void nselection(long struct, long value) {
/* 326 */     MemoryUtil.memPutCLong(struct + SELECTION, value);
/*     */   } public static void ntarget(long struct, long value) {
/* 328 */     MemoryUtil.memPutCLong(struct + TARGET, value);
/*     */   } public static void nproperty(long struct, long value) {
/* 330 */     MemoryUtil.memPutCLong(struct + PROPERTY, value);
/*     */   } public static void ntime(long struct, long value) {
/* 332 */     MemoryUtil.memPutCLong(struct + TIME, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long struct) {
/* 340 */     Checks.check(MemoryUtil.memGetAddress(struct + DISPLAY));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<XSelectionEvent, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 348 */     private static final XSelectionEvent ELEMENT_FACTORY = XSelectionEvent.create(-1L);
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
/* 360 */       super(container, container.remaining() / XSelectionEvent.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 364 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 368 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 373 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 378 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected XSelectionEvent getElementFactory() {
/* 383 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     public int type() {
/* 387 */       return XSelectionEvent.ntype(address());
/*     */     } @NativeType("unsigned long")
/*     */     public long serial() {
/* 390 */       return XSelectionEvent.nserial(address());
/*     */     } @NativeType("Bool")
/*     */     public boolean send_event() {
/* 393 */       return (XSelectionEvent.nsend_event(address()) != 0);
/*     */     } @NativeType("Display *")
/*     */     public long display() {
/* 396 */       return XSelectionEvent.ndisplay(address());
/*     */     } @NativeType("Window")
/*     */     public long requestor() {
/* 399 */       return XSelectionEvent.nrequestor(address());
/*     */     } @NativeType("Atom")
/*     */     public long selection() {
/* 402 */       return XSelectionEvent.nselection(address());
/*     */     } @NativeType("Atom")
/*     */     public long target() {
/* 405 */       return XSelectionEvent.ntarget(address());
/*     */     } @NativeType("Atom")
/*     */     public long property() {
/* 408 */       return XSelectionEvent.nproperty(address());
/*     */     } @NativeType("Time")
/*     */     public long time() {
/* 411 */       return XSelectionEvent.ntime(address());
/*     */     }
/*     */     public Buffer type(int value) {
/* 414 */       XSelectionEvent.ntype(address(), value); return this;
/*     */     } public Buffer serial(@NativeType("unsigned long") long value) {
/* 416 */       XSelectionEvent.nserial(address(), value); return this;
/*     */     } public Buffer send_event(@NativeType("Bool") boolean value) {
/* 418 */       XSelectionEvent.nsend_event(address(), value ? 1 : 0); return this;
/*     */     } public Buffer display(@NativeType("Display *") long value) {
/* 420 */       XSelectionEvent.ndisplay(address(), value); return this;
/*     */     } public Buffer requestor(@NativeType("Window") long value) {
/* 422 */       XSelectionEvent.nrequestor(address(), value); return this;
/*     */     } public Buffer selection(@NativeType("Atom") long value) {
/* 424 */       XSelectionEvent.nselection(address(), value); return this;
/*     */     } public Buffer target(@NativeType("Atom") long value) {
/* 426 */       XSelectionEvent.ntarget(address(), value); return this;
/*     */     } public Buffer property(@NativeType("Atom") long value) {
/* 428 */       XSelectionEvent.nproperty(address(), value); return this;
/*     */     } public Buffer time(@NativeType("Time") long value) {
/* 430 */       XSelectionEvent.ntime(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\XSelectionEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */