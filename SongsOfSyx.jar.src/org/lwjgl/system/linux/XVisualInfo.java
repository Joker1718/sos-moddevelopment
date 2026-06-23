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
/*     */ public class XVisualInfo
/*     */   extends Struct<XVisualInfo>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int VISUAL;
/*     */   public static final int VISUALID;
/*     */   public static final int SCREEN;
/*     */   public static final int DEPTH;
/*     */   public static final int CLASS;
/*     */   public static final int RED_MASK;
/*     */   public static final int GREEN_MASK;
/*     */   public static final int BLUE_MASK;
/*     */   public static final int COLORMAP_SIZE;
/*     */   public static final int BITS_PER_RGB;
/*     */   
/*     */   static {
/*  56 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  57 */           __member(POINTER_SIZE), 
/*  58 */           __member(CLONG_SIZE), 
/*  59 */           __member(4), 
/*  60 */           __member(4), 
/*  61 */           __member(4), 
/*  62 */           __member(CLONG_SIZE), 
/*  63 */           __member(CLONG_SIZE), 
/*  64 */           __member(CLONG_SIZE), 
/*  65 */           __member(4), 
/*  66 */           __member(4)
/*     */         });
/*     */     
/*  69 */     SIZEOF = layout.getSize();
/*  70 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  72 */     VISUAL = layout.offsetof(0);
/*  73 */     VISUALID = layout.offsetof(1);
/*  74 */     SCREEN = layout.offsetof(2);
/*  75 */     DEPTH = layout.offsetof(3);
/*  76 */     CLASS = layout.offsetof(4);
/*  77 */     RED_MASK = layout.offsetof(5);
/*  78 */     GREEN_MASK = layout.offsetof(6);
/*  79 */     BLUE_MASK = layout.offsetof(7);
/*  80 */     COLORMAP_SIZE = layout.offsetof(8);
/*  81 */     BITS_PER_RGB = layout.offsetof(9);
/*     */   }
/*     */   
/*     */   protected XVisualInfo(long address, ByteBuffer container) {
/*  85 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected XVisualInfo create(long address, ByteBuffer container) {
/*  90 */     return new XVisualInfo(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XVisualInfo(ByteBuffer container) {
/* 100 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/* 104 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("Visual *")
/*     */   public Visual visual() {
/* 108 */     return nvisual(address());
/*     */   } @NativeType("VisualID")
/*     */   public long visualid() {
/* 111 */     return nvisualid(address());
/*     */   } public int screen() {
/* 113 */     return nscreen(address());
/*     */   } public int depth() {
/* 115 */     return ndepth(address());
/*     */   } public int class$() {
/* 117 */     return nclass$(address());
/*     */   } @NativeType("unsigned long")
/*     */   public long red_mask() {
/* 120 */     return nred_mask(address());
/*     */   } @NativeType("unsigned long")
/*     */   public long green_mask() {
/* 123 */     return ngreen_mask(address());
/*     */   } @NativeType("unsigned long")
/*     */   public long blue_mask() {
/* 126 */     return nblue_mask(address());
/*     */   } public int colormap_size() {
/* 128 */     return ncolormap_size(address());
/*     */   } public int bits_per_rgb() {
/* 130 */     return nbits_per_rgb(address());
/*     */   }
/*     */   public XVisualInfo visual(@NativeType("Visual *") Visual value) {
/* 133 */     nvisual(address(), value); return this;
/*     */   } public XVisualInfo visualid(@NativeType("VisualID") long value) {
/* 135 */     nvisualid(address(), value); return this;
/*     */   } public XVisualInfo screen(int value) {
/* 137 */     nscreen(address(), value); return this;
/*     */   } public XVisualInfo depth(int value) {
/* 139 */     ndepth(address(), value); return this;
/*     */   } public XVisualInfo class$(int value) {
/* 141 */     nclass$(address(), value); return this;
/*     */   } public XVisualInfo red_mask(@NativeType("unsigned long") long value) {
/* 143 */     nred_mask(address(), value); return this;
/*     */   } public XVisualInfo green_mask(@NativeType("unsigned long") long value) {
/* 145 */     ngreen_mask(address(), value); return this;
/*     */   } public XVisualInfo blue_mask(@NativeType("unsigned long") long value) {
/* 147 */     nblue_mask(address(), value); return this;
/*     */   } public XVisualInfo colormap_size(int value) {
/* 149 */     ncolormap_size(address(), value); return this;
/*     */   } public XVisualInfo bits_per_rgb(int value) {
/* 151 */     nbits_per_rgb(address(), value); return this;
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
/*     */   public XVisualInfo set(Visual visual, long visualid, int screen, int depth, int class$, long red_mask, long green_mask, long blue_mask, int colormap_size, int bits_per_rgb) {
/* 166 */     visual(visual);
/* 167 */     visualid(visualid);
/* 168 */     screen(screen);
/* 169 */     depth(depth);
/* 170 */     class$(class$);
/* 171 */     red_mask(red_mask);
/* 172 */     green_mask(green_mask);
/* 173 */     blue_mask(blue_mask);
/* 174 */     colormap_size(colormap_size);
/* 175 */     bits_per_rgb(bits_per_rgb);
/*     */     
/* 177 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XVisualInfo set(XVisualInfo src) {
/* 188 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 189 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XVisualInfo malloc() {
/* 196 */     return new XVisualInfo(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XVisualInfo calloc() {
/* 201 */     return new XVisualInfo(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XVisualInfo create() {
/* 206 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 207 */     return new XVisualInfo(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XVisualInfo create(long address) {
/* 212 */     return new XVisualInfo(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XVisualInfo createSafe(long address) {
/* 217 */     return (address == 0L) ? null : new XVisualInfo(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 226 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 235 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 244 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 245 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 255 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 260 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XVisualInfo malloc(MemoryStack stack) {
/* 269 */     return new XVisualInfo(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XVisualInfo calloc(MemoryStack stack) {
/* 278 */     return new XVisualInfo(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 288 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 298 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Visual nvisual(long struct) {
/* 304 */     return Visual.create(MemoryUtil.memGetAddress(struct + VISUAL));
/*     */   } public static long nvisualid(long struct) {
/* 306 */     return MemoryUtil.memGetCLong(struct + VISUALID);
/*     */   } public static int nscreen(long struct) {
/* 308 */     return MemoryUtil.memGetInt(struct + SCREEN);
/*     */   } public static int ndepth(long struct) {
/* 310 */     return MemoryUtil.memGetInt(struct + DEPTH);
/*     */   } public static int nclass$(long struct) {
/* 312 */     return MemoryUtil.memGetInt(struct + CLASS);
/*     */   } public static long nred_mask(long struct) {
/* 314 */     return MemoryUtil.memGetCLong(struct + RED_MASK);
/*     */   } public static long ngreen_mask(long struct) {
/* 316 */     return MemoryUtil.memGetCLong(struct + GREEN_MASK);
/*     */   } public static long nblue_mask(long struct) {
/* 318 */     return MemoryUtil.memGetCLong(struct + BLUE_MASK);
/*     */   } public static int ncolormap_size(long struct) {
/* 320 */     return MemoryUtil.memGetInt(struct + COLORMAP_SIZE);
/*     */   } public static int nbits_per_rgb(long struct) {
/* 322 */     return MemoryUtil.memGetInt(struct + BITS_PER_RGB);
/*     */   }
/*     */   public static void nvisual(long struct, Visual value) {
/* 325 */     MemoryUtil.memPutAddress(struct + VISUAL, value.address());
/*     */   } public static void nvisualid(long struct, long value) {
/* 327 */     MemoryUtil.memPutCLong(struct + VISUALID, value);
/*     */   } public static void nscreen(long struct, int value) {
/* 329 */     MemoryUtil.memPutInt(struct + SCREEN, value);
/*     */   } public static void ndepth(long struct, int value) {
/* 331 */     MemoryUtil.memPutInt(struct + DEPTH, value);
/*     */   } public static void nclass$(long struct, int value) {
/* 333 */     MemoryUtil.memPutInt(struct + CLASS, value);
/*     */   } public static void nred_mask(long struct, long value) {
/* 335 */     MemoryUtil.memPutCLong(struct + RED_MASK, value);
/*     */   } public static void ngreen_mask(long struct, long value) {
/* 337 */     MemoryUtil.memPutCLong(struct + GREEN_MASK, value);
/*     */   } public static void nblue_mask(long struct, long value) {
/* 339 */     MemoryUtil.memPutCLong(struct + BLUE_MASK, value);
/*     */   } public static void ncolormap_size(long struct, int value) {
/* 341 */     MemoryUtil.memPutInt(struct + COLORMAP_SIZE, value);
/*     */   } public static void nbits_per_rgb(long struct, int value) {
/* 343 */     MemoryUtil.memPutInt(struct + BITS_PER_RGB, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long struct) {
/* 351 */     Checks.check(MemoryUtil.memGetAddress(struct + VISUAL));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<XVisualInfo, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 359 */     private static final XVisualInfo ELEMENT_FACTORY = XVisualInfo.create(-1L);
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
/* 371 */       super(container, container.remaining() / XVisualInfo.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 375 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 379 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 384 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 389 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected XVisualInfo getElementFactory() {
/* 394 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("Visual *")
/*     */     public Visual visual() {
/* 399 */       return XVisualInfo.nvisual(address());
/*     */     } @NativeType("VisualID")
/*     */     public long visualid() {
/* 402 */       return XVisualInfo.nvisualid(address());
/*     */     } public int screen() {
/* 404 */       return XVisualInfo.nscreen(address());
/*     */     } public int depth() {
/* 406 */       return XVisualInfo.ndepth(address());
/*     */     } public int class$() {
/* 408 */       return XVisualInfo.nclass$(address());
/*     */     } @NativeType("unsigned long")
/*     */     public long red_mask() {
/* 411 */       return XVisualInfo.nred_mask(address());
/*     */     } @NativeType("unsigned long")
/*     */     public long green_mask() {
/* 414 */       return XVisualInfo.ngreen_mask(address());
/*     */     } @NativeType("unsigned long")
/*     */     public long blue_mask() {
/* 417 */       return XVisualInfo.nblue_mask(address());
/*     */     } public int colormap_size() {
/* 419 */       return XVisualInfo.ncolormap_size(address());
/*     */     } public int bits_per_rgb() {
/* 421 */       return XVisualInfo.nbits_per_rgb(address());
/*     */     }
/*     */     public Buffer visual(@NativeType("Visual *") Visual value) {
/* 424 */       XVisualInfo.nvisual(address(), value); return this;
/*     */     } public Buffer visualid(@NativeType("VisualID") long value) {
/* 426 */       XVisualInfo.nvisualid(address(), value); return this;
/*     */     } public Buffer screen(int value) {
/* 428 */       XVisualInfo.nscreen(address(), value); return this;
/*     */     } public Buffer depth(int value) {
/* 430 */       XVisualInfo.ndepth(address(), value); return this;
/*     */     } public Buffer class$(int value) {
/* 432 */       XVisualInfo.nclass$(address(), value); return this;
/*     */     } public Buffer red_mask(@NativeType("unsigned long") long value) {
/* 434 */       XVisualInfo.nred_mask(address(), value); return this;
/*     */     } public Buffer green_mask(@NativeType("unsigned long") long value) {
/* 436 */       XVisualInfo.ngreen_mask(address(), value); return this;
/*     */     } public Buffer blue_mask(@NativeType("unsigned long") long value) {
/* 438 */       XVisualInfo.nblue_mask(address(), value); return this;
/*     */     } public Buffer colormap_size(int value) {
/* 440 */       XVisualInfo.ncolormap_size(address(), value); return this;
/*     */     } public Buffer bits_per_rgb(int value) {
/* 442 */       XVisualInfo.nbits_per_rgb(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\XVisualInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */