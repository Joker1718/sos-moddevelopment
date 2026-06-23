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
/*     */ 
/*     */ public class XSelectionRequestEvent
/*     */   extends Struct<XSelectionRequestEvent>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int TYPE;
/*     */   public static final int SERIAL;
/*     */   public static final int SEND_EVENT;
/*     */   public static final int DISPLAY;
/*     */   public static final int OWNER;
/*     */   public static final int REQUESTOR;
/*     */   public static final int SELECTION;
/*     */   public static final int TARGET;
/*     */   public static final int PROPERTY;
/*     */   public static final int TIME;
/*     */   
/*     */   static {
/*  56 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  57 */           __member(4), 
/*  58 */           __member(CLONG_SIZE), 
/*  59 */           __member(4), 
/*  60 */           __member(POINTER_SIZE), 
/*  61 */           __member(CLONG_SIZE), 
/*  62 */           __member(CLONG_SIZE), 
/*  63 */           __member(CLONG_SIZE), 
/*  64 */           __member(CLONG_SIZE), 
/*  65 */           __member(CLONG_SIZE), 
/*  66 */           __member(CLONG_SIZE)
/*     */         });
/*     */     
/*  69 */     SIZEOF = layout.getSize();
/*  70 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  72 */     TYPE = layout.offsetof(0);
/*  73 */     SERIAL = layout.offsetof(1);
/*  74 */     SEND_EVENT = layout.offsetof(2);
/*  75 */     DISPLAY = layout.offsetof(3);
/*  76 */     OWNER = layout.offsetof(4);
/*  77 */     REQUESTOR = layout.offsetof(5);
/*  78 */     SELECTION = layout.offsetof(6);
/*  79 */     TARGET = layout.offsetof(7);
/*  80 */     PROPERTY = layout.offsetof(8);
/*  81 */     TIME = layout.offsetof(9);
/*     */   }
/*     */   
/*     */   protected XSelectionRequestEvent(long address, ByteBuffer container) {
/*  85 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected XSelectionRequestEvent create(long address, ByteBuffer container) {
/*  90 */     return new XSelectionRequestEvent(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSelectionRequestEvent(ByteBuffer container) {
/* 100 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/* 104 */     return SIZEOF;
/*     */   }
/*     */   public int type() {
/* 107 */     return ntype(address());
/*     */   } @NativeType("unsigned long")
/*     */   public long serial() {
/* 110 */     return nserial(address());
/*     */   } @NativeType("Bool")
/*     */   public boolean send_event() {
/* 113 */     return (nsend_event(address()) != 0);
/*     */   } @NativeType("Display *")
/*     */   public long display() {
/* 116 */     return ndisplay(address());
/*     */   } @NativeType("Window")
/*     */   public long owner() {
/* 119 */     return nowner(address());
/*     */   } @NativeType("Window")
/*     */   public long requestor() {
/* 122 */     return nrequestor(address());
/*     */   } @NativeType("Atom")
/*     */   public long selection() {
/* 125 */     return nselection(address());
/*     */   } @NativeType("Atom")
/*     */   public long target() {
/* 128 */     return ntarget(address());
/*     */   } @NativeType("Atom")
/*     */   public long property() {
/* 131 */     return nproperty(address());
/*     */   } @NativeType("Time")
/*     */   public long time() {
/* 134 */     return ntime(address());
/*     */   }
/*     */   public XSelectionRequestEvent type(int value) {
/* 137 */     ntype(address(), value); return this;
/*     */   } public XSelectionRequestEvent serial(@NativeType("unsigned long") long value) {
/* 139 */     nserial(address(), value); return this;
/*     */   } public XSelectionRequestEvent send_event(@NativeType("Bool") boolean value) {
/* 141 */     nsend_event(address(), value ? 1 : 0); return this;
/*     */   } public XSelectionRequestEvent display(@NativeType("Display *") long value) {
/* 143 */     ndisplay(address(), value); return this;
/*     */   } public XSelectionRequestEvent owner(@NativeType("Window") long value) {
/* 145 */     nowner(address(), value); return this;
/*     */   } public XSelectionRequestEvent requestor(@NativeType("Window") long value) {
/* 147 */     nrequestor(address(), value); return this;
/*     */   } public XSelectionRequestEvent selection(@NativeType("Atom") long value) {
/* 149 */     nselection(address(), value); return this;
/*     */   } public XSelectionRequestEvent target(@NativeType("Atom") long value) {
/* 151 */     ntarget(address(), value); return this;
/*     */   } public XSelectionRequestEvent property(@NativeType("Atom") long value) {
/* 153 */     nproperty(address(), value); return this;
/*     */   } public XSelectionRequestEvent time(@NativeType("Time") long value) {
/* 155 */     ntime(address(), value); return this;
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
/*     */   
/*     */   public XSelectionRequestEvent set(int type, long serial, boolean send_event, long display, long owner, long requestor, long selection, long target, long property, long time) {
/* 170 */     type(type);
/* 171 */     serial(serial);
/* 172 */     send_event(send_event);
/* 173 */     display(display);
/* 174 */     owner(owner);
/* 175 */     requestor(requestor);
/* 176 */     selection(selection);
/* 177 */     target(target);
/* 178 */     property(property);
/* 179 */     time(time);
/*     */     
/* 181 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSelectionRequestEvent set(XSelectionRequestEvent src) {
/* 192 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 193 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XSelectionRequestEvent malloc() {
/* 200 */     return new XSelectionRequestEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XSelectionRequestEvent calloc() {
/* 205 */     return new XSelectionRequestEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XSelectionRequestEvent create() {
/* 210 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 211 */     return new XSelectionRequestEvent(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XSelectionRequestEvent create(long address) {
/* 216 */     return new XSelectionRequestEvent(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XSelectionRequestEvent createSafe(long address) {
/* 221 */     return (address == 0L) ? null : new XSelectionRequestEvent(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 230 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 239 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 248 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 249 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 259 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 264 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XSelectionRequestEvent malloc(MemoryStack stack) {
/* 273 */     return new XSelectionRequestEvent(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XSelectionRequestEvent calloc(MemoryStack stack) {
/* 282 */     return new XSelectionRequestEvent(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 292 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 302 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int ntype(long struct) {
/* 308 */     return MemoryUtil.memGetInt(struct + TYPE);
/*     */   } public static long nserial(long struct) {
/* 310 */     return MemoryUtil.memGetCLong(struct + SERIAL);
/*     */   } public static int nsend_event(long struct) {
/* 312 */     return MemoryUtil.memGetInt(struct + SEND_EVENT);
/*     */   } public static long ndisplay(long struct) {
/* 314 */     return MemoryUtil.memGetAddress(struct + DISPLAY);
/*     */   } public static long nowner(long struct) {
/* 316 */     return MemoryUtil.memGetCLong(struct + OWNER);
/*     */   } public static long nrequestor(long struct) {
/* 318 */     return MemoryUtil.memGetCLong(struct + REQUESTOR);
/*     */   } public static long nselection(long struct) {
/* 320 */     return MemoryUtil.memGetCLong(struct + SELECTION);
/*     */   } public static long ntarget(long struct) {
/* 322 */     return MemoryUtil.memGetCLong(struct + TARGET);
/*     */   } public static long nproperty(long struct) {
/* 324 */     return MemoryUtil.memGetCLong(struct + PROPERTY);
/*     */   } public static long ntime(long struct) {
/* 326 */     return MemoryUtil.memGetCLong(struct + TIME);
/*     */   }
/*     */   public static void ntype(long struct, int value) {
/* 329 */     MemoryUtil.memPutInt(struct + TYPE, value);
/*     */   } public static void nserial(long struct, long value) {
/* 331 */     MemoryUtil.memPutCLong(struct + SERIAL, value);
/*     */   } public static void nsend_event(long struct, int value) {
/* 333 */     MemoryUtil.memPutInt(struct + SEND_EVENT, value);
/*     */   } public static void ndisplay(long struct, long value) {
/* 335 */     MemoryUtil.memPutAddress(struct + DISPLAY, Checks.check(value));
/*     */   } public static void nowner(long struct, long value) {
/* 337 */     MemoryUtil.memPutCLong(struct + OWNER, value);
/*     */   } public static void nrequestor(long struct, long value) {
/* 339 */     MemoryUtil.memPutCLong(struct + REQUESTOR, value);
/*     */   } public static void nselection(long struct, long value) {
/* 341 */     MemoryUtil.memPutCLong(struct + SELECTION, value);
/*     */   } public static void ntarget(long struct, long value) {
/* 343 */     MemoryUtil.memPutCLong(struct + TARGET, value);
/*     */   } public static void nproperty(long struct, long value) {
/* 345 */     MemoryUtil.memPutCLong(struct + PROPERTY, value);
/*     */   } public static void ntime(long struct, long value) {
/* 347 */     MemoryUtil.memPutCLong(struct + TIME, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long struct) {
/* 355 */     Checks.check(MemoryUtil.memGetAddress(struct + DISPLAY));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<XSelectionRequestEvent, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 363 */     private static final XSelectionRequestEvent ELEMENT_FACTORY = XSelectionRequestEvent.create(-1L);
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
/* 375 */       super(container, container.remaining() / XSelectionRequestEvent.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 379 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 383 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 388 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 393 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected XSelectionRequestEvent getElementFactory() {
/* 398 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     public int type() {
/* 402 */       return XSelectionRequestEvent.ntype(address());
/*     */     } @NativeType("unsigned long")
/*     */     public long serial() {
/* 405 */       return XSelectionRequestEvent.nserial(address());
/*     */     } @NativeType("Bool")
/*     */     public boolean send_event() {
/* 408 */       return (XSelectionRequestEvent.nsend_event(address()) != 0);
/*     */     } @NativeType("Display *")
/*     */     public long display() {
/* 411 */       return XSelectionRequestEvent.ndisplay(address());
/*     */     } @NativeType("Window")
/*     */     public long owner() {
/* 414 */       return XSelectionRequestEvent.nowner(address());
/*     */     } @NativeType("Window")
/*     */     public long requestor() {
/* 417 */       return XSelectionRequestEvent.nrequestor(address());
/*     */     } @NativeType("Atom")
/*     */     public long selection() {
/* 420 */       return XSelectionRequestEvent.nselection(address());
/*     */     } @NativeType("Atom")
/*     */     public long target() {
/* 423 */       return XSelectionRequestEvent.ntarget(address());
/*     */     } @NativeType("Atom")
/*     */     public long property() {
/* 426 */       return XSelectionRequestEvent.nproperty(address());
/*     */     } @NativeType("Time")
/*     */     public long time() {
/* 429 */       return XSelectionRequestEvent.ntime(address());
/*     */     }
/*     */     public Buffer type(int value) {
/* 432 */       XSelectionRequestEvent.ntype(address(), value); return this;
/*     */     } public Buffer serial(@NativeType("unsigned long") long value) {
/* 434 */       XSelectionRequestEvent.nserial(address(), value); return this;
/*     */     } public Buffer send_event(@NativeType("Bool") boolean value) {
/* 436 */       XSelectionRequestEvent.nsend_event(address(), value ? 1 : 0); return this;
/*     */     } public Buffer display(@NativeType("Display *") long value) {
/* 438 */       XSelectionRequestEvent.ndisplay(address(), value); return this;
/*     */     } public Buffer owner(@NativeType("Window") long value) {
/* 440 */       XSelectionRequestEvent.nowner(address(), value); return this;
/*     */     } public Buffer requestor(@NativeType("Window") long value) {
/* 442 */       XSelectionRequestEvent.nrequestor(address(), value); return this;
/*     */     } public Buffer selection(@NativeType("Atom") long value) {
/* 444 */       XSelectionRequestEvent.nselection(address(), value); return this;
/*     */     } public Buffer target(@NativeType("Atom") long value) {
/* 446 */       XSelectionRequestEvent.ntarget(address(), value); return this;
/*     */     } public Buffer property(@NativeType("Atom") long value) {
/* 448 */       XSelectionRequestEvent.nproperty(address(), value); return this;
/*     */     } public Buffer time(@NativeType("Time") long value) {
/* 450 */       XSelectionRequestEvent.ntime(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\XSelectionRequestEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */