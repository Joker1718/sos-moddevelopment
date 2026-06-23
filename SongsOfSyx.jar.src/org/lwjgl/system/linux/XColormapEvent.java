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
/*     */ public class XColormapEvent
/*     */   extends Struct<XColormapEvent>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int TYPE;
/*     */   public static final int SERIAL;
/*     */   public static final int SEND_EVENT;
/*     */   public static final int DISPLAY;
/*     */   public static final int WINDOW;
/*     */   public static final int COLORMAP;
/*     */   public static final int NEW;
/*     */   public static final int STATE;
/*     */   
/*     */   static {
/*  52 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  53 */           __member(4), 
/*  54 */           __member(CLONG_SIZE), 
/*  55 */           __member(4), 
/*  56 */           __member(POINTER_SIZE), 
/*  57 */           __member(CLONG_SIZE), 
/*  58 */           __member(CLONG_SIZE), 
/*  59 */           __member(4), 
/*  60 */           __member(4)
/*     */         });
/*     */     
/*  63 */     SIZEOF = layout.getSize();
/*  64 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  66 */     TYPE = layout.offsetof(0);
/*  67 */     SERIAL = layout.offsetof(1);
/*  68 */     SEND_EVENT = layout.offsetof(2);
/*  69 */     DISPLAY = layout.offsetof(3);
/*  70 */     WINDOW = layout.offsetof(4);
/*  71 */     COLORMAP = layout.offsetof(5);
/*  72 */     NEW = layout.offsetof(6);
/*  73 */     STATE = layout.offsetof(7);
/*     */   }
/*     */   
/*     */   protected XColormapEvent(long address, ByteBuffer container) {
/*  77 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected XColormapEvent create(long address, ByteBuffer container) {
/*  82 */     return new XColormapEvent(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XColormapEvent(ByteBuffer container) {
/*  92 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  96 */     return SIZEOF;
/*     */   }
/*     */   public int type() {
/*  99 */     return ntype(address());
/*     */   } @NativeType("unsigned long")
/*     */   public long serial() {
/* 102 */     return nserial(address());
/*     */   } @NativeType("Bool")
/*     */   public boolean send_event() {
/* 105 */     return (nsend_event(address()) != 0);
/*     */   } @NativeType("Display *")
/*     */   public long display() {
/* 108 */     return ndisplay(address());
/*     */   } @NativeType("Window")
/*     */   public long window() {
/* 111 */     return nwindow(address());
/*     */   } @NativeType("Colormap")
/*     */   public long colormap() {
/* 114 */     return ncolormap(address());
/*     */   } public int new$() {
/* 116 */     return nnew$(address());
/*     */   } public int state() {
/* 118 */     return nstate(address());
/*     */   }
/*     */   public XColormapEvent type(int value) {
/* 121 */     ntype(address(), value); return this;
/*     */   } public XColormapEvent serial(@NativeType("unsigned long") long value) {
/* 123 */     nserial(address(), value); return this;
/*     */   } public XColormapEvent send_event(@NativeType("Bool") boolean value) {
/* 125 */     nsend_event(address(), value ? 1 : 0); return this;
/*     */   } public XColormapEvent display(@NativeType("Display *") long value) {
/* 127 */     ndisplay(address(), value); return this;
/*     */   } public XColormapEvent window(@NativeType("Window") long value) {
/* 129 */     nwindow(address(), value); return this;
/*     */   } public XColormapEvent colormap(@NativeType("Colormap") long value) {
/* 131 */     ncolormap(address(), value); return this;
/*     */   } public XColormapEvent new$(int value) {
/* 133 */     nnew$(address(), value); return this;
/*     */   } public XColormapEvent state(int value) {
/* 135 */     nstate(address(), value); return this;
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
/*     */   public XColormapEvent set(int type, long serial, boolean send_event, long display, long window, long colormap, int new$, int state) {
/* 148 */     type(type);
/* 149 */     serial(serial);
/* 150 */     send_event(send_event);
/* 151 */     display(display);
/* 152 */     window(window);
/* 153 */     colormap(colormap);
/* 154 */     new$(new$);
/* 155 */     state(state);
/*     */     
/* 157 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XColormapEvent set(XColormapEvent src) {
/* 168 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 169 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XColormapEvent malloc() {
/* 176 */     return new XColormapEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XColormapEvent calloc() {
/* 181 */     return new XColormapEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XColormapEvent create() {
/* 186 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 187 */     return new XColormapEvent(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XColormapEvent create(long address) {
/* 192 */     return new XColormapEvent(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XColormapEvent createSafe(long address) {
/* 197 */     return (address == 0L) ? null : new XColormapEvent(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 206 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 215 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 224 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 225 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 235 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 240 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XColormapEvent malloc(MemoryStack stack) {
/* 249 */     return new XColormapEvent(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XColormapEvent calloc(MemoryStack stack) {
/* 258 */     return new XColormapEvent(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 268 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 278 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int ntype(long struct) {
/* 284 */     return MemoryUtil.memGetInt(struct + TYPE);
/*     */   } public static long nserial(long struct) {
/* 286 */     return MemoryUtil.memGetCLong(struct + SERIAL);
/*     */   } public static int nsend_event(long struct) {
/* 288 */     return MemoryUtil.memGetInt(struct + SEND_EVENT);
/*     */   } public static long ndisplay(long struct) {
/* 290 */     return MemoryUtil.memGetAddress(struct + DISPLAY);
/*     */   } public static long nwindow(long struct) {
/* 292 */     return MemoryUtil.memGetCLong(struct + WINDOW);
/*     */   } public static long ncolormap(long struct) {
/* 294 */     return MemoryUtil.memGetCLong(struct + COLORMAP);
/*     */   } public static int nnew$(long struct) {
/* 296 */     return MemoryUtil.memGetInt(struct + NEW);
/*     */   } public static int nstate(long struct) {
/* 298 */     return MemoryUtil.memGetInt(struct + STATE);
/*     */   }
/*     */   public static void ntype(long struct, int value) {
/* 301 */     MemoryUtil.memPutInt(struct + TYPE, value);
/*     */   } public static void nserial(long struct, long value) {
/* 303 */     MemoryUtil.memPutCLong(struct + SERIAL, value);
/*     */   } public static void nsend_event(long struct, int value) {
/* 305 */     MemoryUtil.memPutInt(struct + SEND_EVENT, value);
/*     */   } public static void ndisplay(long struct, long value) {
/* 307 */     MemoryUtil.memPutAddress(struct + DISPLAY, Checks.check(value));
/*     */   } public static void nwindow(long struct, long value) {
/* 309 */     MemoryUtil.memPutCLong(struct + WINDOW, value);
/*     */   } public static void ncolormap(long struct, long value) {
/* 311 */     MemoryUtil.memPutCLong(struct + COLORMAP, value);
/*     */   } public static void nnew$(long struct, int value) {
/* 313 */     MemoryUtil.memPutInt(struct + NEW, value);
/*     */   } public static void nstate(long struct, int value) {
/* 315 */     MemoryUtil.memPutInt(struct + STATE, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long struct) {
/* 323 */     Checks.check(MemoryUtil.memGetAddress(struct + DISPLAY));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<XColormapEvent, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 331 */     private static final XColormapEvent ELEMENT_FACTORY = XColormapEvent.create(-1L);
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
/* 343 */       super(container, container.remaining() / XColormapEvent.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 347 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 351 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 356 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 361 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected XColormapEvent getElementFactory() {
/* 366 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     public int type() {
/* 370 */       return XColormapEvent.ntype(address());
/*     */     } @NativeType("unsigned long")
/*     */     public long serial() {
/* 373 */       return XColormapEvent.nserial(address());
/*     */     } @NativeType("Bool")
/*     */     public boolean send_event() {
/* 376 */       return (XColormapEvent.nsend_event(address()) != 0);
/*     */     } @NativeType("Display *")
/*     */     public long display() {
/* 379 */       return XColormapEvent.ndisplay(address());
/*     */     } @NativeType("Window")
/*     */     public long window() {
/* 382 */       return XColormapEvent.nwindow(address());
/*     */     } @NativeType("Colormap")
/*     */     public long colormap() {
/* 385 */       return XColormapEvent.ncolormap(address());
/*     */     } public int new$() {
/* 387 */       return XColormapEvent.nnew$(address());
/*     */     } public int state() {
/* 389 */       return XColormapEvent.nstate(address());
/*     */     }
/*     */     public Buffer type(int value) {
/* 392 */       XColormapEvent.ntype(address(), value); return this;
/*     */     } public Buffer serial(@NativeType("unsigned long") long value) {
/* 394 */       XColormapEvent.nserial(address(), value); return this;
/*     */     } public Buffer send_event(@NativeType("Bool") boolean value) {
/* 396 */       XColormapEvent.nsend_event(address(), value ? 1 : 0); return this;
/*     */     } public Buffer display(@NativeType("Display *") long value) {
/* 398 */       XColormapEvent.ndisplay(address(), value); return this;
/*     */     } public Buffer window(@NativeType("Window") long value) {
/* 400 */       XColormapEvent.nwindow(address(), value); return this;
/*     */     } public Buffer colormap(@NativeType("Colormap") long value) {
/* 402 */       XColormapEvent.ncolormap(address(), value); return this;
/*     */     } public Buffer new$(int value) {
/* 404 */       XColormapEvent.nnew$(address(), value); return this;
/*     */     } public Buffer state(int value) {
/* 406 */       XColormapEvent.nstate(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\XColormapEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */