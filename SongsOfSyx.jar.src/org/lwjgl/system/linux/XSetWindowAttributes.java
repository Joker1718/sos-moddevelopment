/*     */ package org.lwjgl.system.linux;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import org.lwjgl.BufferUtils;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XSetWindowAttributes
/*     */   extends Struct<XSetWindowAttributes>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int BACKGROUND_PIXMAP;
/*     */   public static final int BACKGROUND_PIXEL;
/*     */   public static final int BORDER_PIXMAP;
/*     */   public static final int BORDER_PIXEL;
/*     */   public static final int BIT_GRAVITY;
/*     */   public static final int WIN_GRAVITY;
/*     */   public static final int BACKING_STORE;
/*     */   public static final int BACKING_PLANES;
/*     */   public static final int BACKING_PIXEL;
/*     */   public static final int SAVE_UNDER;
/*     */   public static final int EVENT_MASK;
/*     */   public static final int DO_NOT_PROPAGATE_MASK;
/*     */   public static final int OVERRIDE_REDIRECT;
/*     */   public static final int COLORMAP;
/*     */   public static final int CURSOR;
/*     */   
/*     */   static {
/*  65 */     Struct.Layout layout = __struct(new Struct.Member[] { 
/*  66 */           __member(CLONG_SIZE), 
/*  67 */           __member(CLONG_SIZE), 
/*  68 */           __member(CLONG_SIZE), 
/*  69 */           __member(CLONG_SIZE), 
/*  70 */           __member(4), 
/*  71 */           __member(4), 
/*  72 */           __member(4), 
/*  73 */           __member(CLONG_SIZE), 
/*  74 */           __member(CLONG_SIZE), 
/*  75 */           __member(4), 
/*  76 */           __member(CLONG_SIZE), 
/*  77 */           __member(CLONG_SIZE), 
/*  78 */           __member(4), 
/*  79 */           __member(CLONG_SIZE), 
/*  80 */           __member(CLONG_SIZE) });
/*     */ 
/*     */     
/*  83 */     SIZEOF = layout.getSize();
/*  84 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  86 */     BACKGROUND_PIXMAP = layout.offsetof(0);
/*  87 */     BACKGROUND_PIXEL = layout.offsetof(1);
/*  88 */     BORDER_PIXMAP = layout.offsetof(2);
/*  89 */     BORDER_PIXEL = layout.offsetof(3);
/*  90 */     BIT_GRAVITY = layout.offsetof(4);
/*  91 */     WIN_GRAVITY = layout.offsetof(5);
/*  92 */     BACKING_STORE = layout.offsetof(6);
/*  93 */     BACKING_PLANES = layout.offsetof(7);
/*  94 */     BACKING_PIXEL = layout.offsetof(8);
/*  95 */     SAVE_UNDER = layout.offsetof(9);
/*  96 */     EVENT_MASK = layout.offsetof(10);
/*  97 */     DO_NOT_PROPAGATE_MASK = layout.offsetof(11);
/*  98 */     OVERRIDE_REDIRECT = layout.offsetof(12);
/*  99 */     COLORMAP = layout.offsetof(13);
/* 100 */     CURSOR = layout.offsetof(14);
/*     */   }
/*     */   
/*     */   protected XSetWindowAttributes(long address, ByteBuffer container) {
/* 104 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected XSetWindowAttributes create(long address, ByteBuffer container) {
/* 109 */     return new XSetWindowAttributes(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSetWindowAttributes(ByteBuffer container) {
/* 119 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/* 123 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("Pixmap")
/*     */   public long background_pixmap() {
/* 127 */     return nbackground_pixmap(address());
/*     */   } @NativeType("unsigned long")
/*     */   public long background_pixel() {
/* 130 */     return nbackground_pixel(address());
/*     */   } @NativeType("Pixmap")
/*     */   public long border_pixmap() {
/* 133 */     return nborder_pixmap(address());
/*     */   } @NativeType("unsigned long")
/*     */   public long border_pixel() {
/* 136 */     return nborder_pixel(address());
/*     */   } public int bit_gravity() {
/* 138 */     return nbit_gravity(address());
/*     */   } public int win_gravity() {
/* 140 */     return nwin_gravity(address());
/*     */   } public int backing_store() {
/* 142 */     return nbacking_store(address());
/*     */   } @NativeType("unsigned long")
/*     */   public long backing_planes() {
/* 145 */     return nbacking_planes(address());
/*     */   } @NativeType("unsigned long")
/*     */   public long backing_pixel() {
/* 148 */     return nbacking_pixel(address());
/*     */   } @NativeType("Bool")
/*     */   public boolean save_under() {
/* 151 */     return (nsave_under(address()) != 0);
/*     */   } public long event_mask() {
/* 153 */     return nevent_mask(address());
/*     */   } public long do_not_propagate_mask() {
/* 155 */     return ndo_not_propagate_mask(address());
/*     */   } @NativeType("Bool")
/*     */   public boolean override_redirect() {
/* 158 */     return (noverride_redirect(address()) != 0);
/*     */   } @NativeType("Colormap")
/*     */   public long colormap() {
/* 161 */     return ncolormap(address());
/*     */   } @NativeType("Cursor")
/*     */   public long cursor() {
/* 164 */     return ncursor(address());
/*     */   }
/*     */   public XSetWindowAttributes background_pixmap(@NativeType("Pixmap") long value) {
/* 167 */     nbackground_pixmap(address(), value); return this;
/*     */   } public XSetWindowAttributes background_pixel(@NativeType("unsigned long") long value) {
/* 169 */     nbackground_pixel(address(), value); return this;
/*     */   } public XSetWindowAttributes border_pixmap(@NativeType("Pixmap") long value) {
/* 171 */     nborder_pixmap(address(), value); return this;
/*     */   } public XSetWindowAttributes border_pixel(@NativeType("unsigned long") long value) {
/* 173 */     nborder_pixel(address(), value); return this;
/*     */   } public XSetWindowAttributes bit_gravity(int value) {
/* 175 */     nbit_gravity(address(), value); return this;
/*     */   } public XSetWindowAttributes win_gravity(int value) {
/* 177 */     nwin_gravity(address(), value); return this;
/*     */   } public XSetWindowAttributes backing_store(int value) {
/* 179 */     nbacking_store(address(), value); return this;
/*     */   } public XSetWindowAttributes backing_planes(@NativeType("unsigned long") long value) {
/* 181 */     nbacking_planes(address(), value); return this;
/*     */   } public XSetWindowAttributes backing_pixel(@NativeType("unsigned long") long value) {
/* 183 */     nbacking_pixel(address(), value); return this;
/*     */   } public XSetWindowAttributes save_under(@NativeType("Bool") boolean value) {
/* 185 */     nsave_under(address(), value ? 1 : 0); return this;
/*     */   } public XSetWindowAttributes event_mask(long value) {
/* 187 */     nevent_mask(address(), value); return this;
/*     */   } public XSetWindowAttributes do_not_propagate_mask(long value) {
/* 189 */     ndo_not_propagate_mask(address(), value); return this;
/*     */   } public XSetWindowAttributes override_redirect(@NativeType("Bool") boolean value) {
/* 191 */     noverride_redirect(address(), value ? 1 : 0); return this;
/*     */   } public XSetWindowAttributes colormap(@NativeType("Colormap") long value) {
/* 193 */     ncolormap(address(), value); return this;
/*     */   } public XSetWindowAttributes cursor(@NativeType("Cursor") long value) {
/* 195 */     ncursor(address(), value); return this;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSetWindowAttributes set(long background_pixmap, long background_pixel, long border_pixmap, long border_pixel, int bit_gravity, int win_gravity, int backing_store, long backing_planes, long backing_pixel, boolean save_under, long event_mask, long do_not_propagate_mask, boolean override_redirect, long colormap, long cursor) {
/* 215 */     background_pixmap(background_pixmap);
/* 216 */     background_pixel(background_pixel);
/* 217 */     border_pixmap(border_pixmap);
/* 218 */     border_pixel(border_pixel);
/* 219 */     bit_gravity(bit_gravity);
/* 220 */     win_gravity(win_gravity);
/* 221 */     backing_store(backing_store);
/* 222 */     backing_planes(backing_planes);
/* 223 */     backing_pixel(backing_pixel);
/* 224 */     save_under(save_under);
/* 225 */     event_mask(event_mask);
/* 226 */     do_not_propagate_mask(do_not_propagate_mask);
/* 227 */     override_redirect(override_redirect);
/* 228 */     colormap(colormap);
/* 229 */     cursor(cursor);
/*     */     
/* 231 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSetWindowAttributes set(XSetWindowAttributes src) {
/* 242 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 243 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XSetWindowAttributes malloc() {
/* 250 */     return new XSetWindowAttributes(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XSetWindowAttributes calloc() {
/* 255 */     return new XSetWindowAttributes(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XSetWindowAttributes create() {
/* 260 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 261 */     return new XSetWindowAttributes(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XSetWindowAttributes create(long address) {
/* 266 */     return new XSetWindowAttributes(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XSetWindowAttributes createSafe(long address) {
/* 271 */     return (address == 0L) ? null : new XSetWindowAttributes(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 280 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 289 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 298 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 299 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 309 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 314 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XSetWindowAttributes malloc(MemoryStack stack) {
/* 323 */     return new XSetWindowAttributes(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XSetWindowAttributes calloc(MemoryStack stack) {
/* 332 */     return new XSetWindowAttributes(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 342 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 352 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nbackground_pixmap(long struct) {
/* 358 */     return MemoryUtil.memGetCLong(struct + BACKGROUND_PIXMAP);
/*     */   } public static long nbackground_pixel(long struct) {
/* 360 */     return MemoryUtil.memGetCLong(struct + BACKGROUND_PIXEL);
/*     */   } public static long nborder_pixmap(long struct) {
/* 362 */     return MemoryUtil.memGetCLong(struct + BORDER_PIXMAP);
/*     */   } public static long nborder_pixel(long struct) {
/* 364 */     return MemoryUtil.memGetCLong(struct + BORDER_PIXEL);
/*     */   } public static int nbit_gravity(long struct) {
/* 366 */     return MemoryUtil.memGetInt(struct + BIT_GRAVITY);
/*     */   } public static int nwin_gravity(long struct) {
/* 368 */     return MemoryUtil.memGetInt(struct + WIN_GRAVITY);
/*     */   } public static int nbacking_store(long struct) {
/* 370 */     return MemoryUtil.memGetInt(struct + BACKING_STORE);
/*     */   } public static long nbacking_planes(long struct) {
/* 372 */     return MemoryUtil.memGetCLong(struct + BACKING_PLANES);
/*     */   } public static long nbacking_pixel(long struct) {
/* 374 */     return MemoryUtil.memGetCLong(struct + BACKING_PIXEL);
/*     */   } public static int nsave_under(long struct) {
/* 376 */     return MemoryUtil.memGetInt(struct + SAVE_UNDER);
/*     */   } public static long nevent_mask(long struct) {
/* 378 */     return MemoryUtil.memGetCLong(struct + EVENT_MASK);
/*     */   } public static long ndo_not_propagate_mask(long struct) {
/* 380 */     return MemoryUtil.memGetCLong(struct + DO_NOT_PROPAGATE_MASK);
/*     */   } public static int noverride_redirect(long struct) {
/* 382 */     return MemoryUtil.memGetInt(struct + OVERRIDE_REDIRECT);
/*     */   } public static long ncolormap(long struct) {
/* 384 */     return MemoryUtil.memGetCLong(struct + COLORMAP);
/*     */   } public static long ncursor(long struct) {
/* 386 */     return MemoryUtil.memGetCLong(struct + CURSOR);
/*     */   }
/*     */   public static void nbackground_pixmap(long struct, long value) {
/* 389 */     MemoryUtil.memPutCLong(struct + BACKGROUND_PIXMAP, value);
/*     */   } public static void nbackground_pixel(long struct, long value) {
/* 391 */     MemoryUtil.memPutCLong(struct + BACKGROUND_PIXEL, value);
/*     */   } public static void nborder_pixmap(long struct, long value) {
/* 393 */     MemoryUtil.memPutCLong(struct + BORDER_PIXMAP, value);
/*     */   } public static void nborder_pixel(long struct, long value) {
/* 395 */     MemoryUtil.memPutCLong(struct + BORDER_PIXEL, value);
/*     */   } public static void nbit_gravity(long struct, int value) {
/* 397 */     MemoryUtil.memPutInt(struct + BIT_GRAVITY, value);
/*     */   } public static void nwin_gravity(long struct, int value) {
/* 399 */     MemoryUtil.memPutInt(struct + WIN_GRAVITY, value);
/*     */   } public static void nbacking_store(long struct, int value) {
/* 401 */     MemoryUtil.memPutInt(struct + BACKING_STORE, value);
/*     */   } public static void nbacking_planes(long struct, long value) {
/* 403 */     MemoryUtil.memPutCLong(struct + BACKING_PLANES, value);
/*     */   } public static void nbacking_pixel(long struct, long value) {
/* 405 */     MemoryUtil.memPutCLong(struct + BACKING_PIXEL, value);
/*     */   } public static void nsave_under(long struct, int value) {
/* 407 */     MemoryUtil.memPutInt(struct + SAVE_UNDER, value);
/*     */   } public static void nevent_mask(long struct, long value) {
/* 409 */     MemoryUtil.memPutCLong(struct + EVENT_MASK, value);
/*     */   } public static void ndo_not_propagate_mask(long struct, long value) {
/* 411 */     MemoryUtil.memPutCLong(struct + DO_NOT_PROPAGATE_MASK, value);
/*     */   } public static void noverride_redirect(long struct, int value) {
/* 413 */     MemoryUtil.memPutInt(struct + OVERRIDE_REDIRECT, value);
/*     */   } public static void ncolormap(long struct, long value) {
/* 415 */     MemoryUtil.memPutCLong(struct + COLORMAP, value);
/*     */   } public static void ncursor(long struct, long value) {
/* 417 */     MemoryUtil.memPutCLong(struct + CURSOR, value);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<XSetWindowAttributes, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 424 */     private static final XSetWindowAttributes ELEMENT_FACTORY = XSetWindowAttributes.create(-1L);
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
/* 436 */       super(container, container.remaining() / XSetWindowAttributes.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 440 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 444 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 449 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 454 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected XSetWindowAttributes getElementFactory() {
/* 459 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("Pixmap")
/*     */     public long background_pixmap() {
/* 464 */       return XSetWindowAttributes.nbackground_pixmap(address());
/*     */     } @NativeType("unsigned long")
/*     */     public long background_pixel() {
/* 467 */       return XSetWindowAttributes.nbackground_pixel(address());
/*     */     } @NativeType("Pixmap")
/*     */     public long border_pixmap() {
/* 470 */       return XSetWindowAttributes.nborder_pixmap(address());
/*     */     } @NativeType("unsigned long")
/*     */     public long border_pixel() {
/* 473 */       return XSetWindowAttributes.nborder_pixel(address());
/*     */     } public int bit_gravity() {
/* 475 */       return XSetWindowAttributes.nbit_gravity(address());
/*     */     } public int win_gravity() {
/* 477 */       return XSetWindowAttributes.nwin_gravity(address());
/*     */     } public int backing_store() {
/* 479 */       return XSetWindowAttributes.nbacking_store(address());
/*     */     } @NativeType("unsigned long")
/*     */     public long backing_planes() {
/* 482 */       return XSetWindowAttributes.nbacking_planes(address());
/*     */     } @NativeType("unsigned long")
/*     */     public long backing_pixel() {
/* 485 */       return XSetWindowAttributes.nbacking_pixel(address());
/*     */     } @NativeType("Bool")
/*     */     public boolean save_under() {
/* 488 */       return (XSetWindowAttributes.nsave_under(address()) != 0);
/*     */     } public long event_mask() {
/* 490 */       return XSetWindowAttributes.nevent_mask(address());
/*     */     } public long do_not_propagate_mask() {
/* 492 */       return XSetWindowAttributes.ndo_not_propagate_mask(address());
/*     */     } @NativeType("Bool")
/*     */     public boolean override_redirect() {
/* 495 */       return (XSetWindowAttributes.noverride_redirect(address()) != 0);
/*     */     } @NativeType("Colormap")
/*     */     public long colormap() {
/* 498 */       return XSetWindowAttributes.ncolormap(address());
/*     */     } @NativeType("Cursor")
/*     */     public long cursor() {
/* 501 */       return XSetWindowAttributes.ncursor(address());
/*     */     }
/*     */     public Buffer background_pixmap(@NativeType("Pixmap") long value) {
/* 504 */       XSetWindowAttributes.nbackground_pixmap(address(), value); return this;
/*     */     } public Buffer background_pixel(@NativeType("unsigned long") long value) {
/* 506 */       XSetWindowAttributes.nbackground_pixel(address(), value); return this;
/*     */     } public Buffer border_pixmap(@NativeType("Pixmap") long value) {
/* 508 */       XSetWindowAttributes.nborder_pixmap(address(), value); return this;
/*     */     } public Buffer border_pixel(@NativeType("unsigned long") long value) {
/* 510 */       XSetWindowAttributes.nborder_pixel(address(), value); return this;
/*     */     } public Buffer bit_gravity(int value) {
/* 512 */       XSetWindowAttributes.nbit_gravity(address(), value); return this;
/*     */     } public Buffer win_gravity(int value) {
/* 514 */       XSetWindowAttributes.nwin_gravity(address(), value); return this;
/*     */     } public Buffer backing_store(int value) {
/* 516 */       XSetWindowAttributes.nbacking_store(address(), value); return this;
/*     */     } public Buffer backing_planes(@NativeType("unsigned long") long value) {
/* 518 */       XSetWindowAttributes.nbacking_planes(address(), value); return this;
/*     */     } public Buffer backing_pixel(@NativeType("unsigned long") long value) {
/* 520 */       XSetWindowAttributes.nbacking_pixel(address(), value); return this;
/*     */     } public Buffer save_under(@NativeType("Bool") boolean value) {
/* 522 */       XSetWindowAttributes.nsave_under(address(), value ? 1 : 0); return this;
/*     */     } public Buffer event_mask(long value) {
/* 524 */       XSetWindowAttributes.nevent_mask(address(), value); return this;
/*     */     } public Buffer do_not_propagate_mask(long value) {
/* 526 */       XSetWindowAttributes.ndo_not_propagate_mask(address(), value); return this;
/*     */     } public Buffer override_redirect(@NativeType("Bool") boolean value) {
/* 528 */       XSetWindowAttributes.noverride_redirect(address(), value ? 1 : 0); return this;
/*     */     } public Buffer colormap(@NativeType("Colormap") long value) {
/* 530 */       XSetWindowAttributes.ncolormap(address(), value); return this;
/*     */     } public Buffer cursor(@NativeType("Cursor") long value) {
/* 532 */       XSetWindowAttributes.ncursor(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\XSetWindowAttributes.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */