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
/*     */ public class Visual
/*     */   extends Struct<Visual>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int EXT_DATA;
/*     */   public static final int VISUALID;
/*     */   public static final int CLASS;
/*     */   public static final int RED_MASK;
/*     */   public static final int GREEN_MASK;
/*     */   public static final int BLUE_MASK;
/*     */   public static final int BITS_PER_RGB;
/*     */   public static final int MAP_ENTRIES;
/*     */   
/*     */   static {
/*  51 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  52 */           __member(POINTER_SIZE), 
/*  53 */           __member(CLONG_SIZE), 
/*  54 */           __member(4), 
/*  55 */           __member(CLONG_SIZE), 
/*  56 */           __member(CLONG_SIZE), 
/*  57 */           __member(CLONG_SIZE), 
/*  58 */           __member(4), 
/*  59 */           __member(4)
/*     */         });
/*     */     
/*  62 */     SIZEOF = layout.getSize();
/*  63 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  65 */     EXT_DATA = layout.offsetof(0);
/*  66 */     VISUALID = layout.offsetof(1);
/*  67 */     CLASS = layout.offsetof(2);
/*  68 */     RED_MASK = layout.offsetof(3);
/*  69 */     GREEN_MASK = layout.offsetof(4);
/*  70 */     BLUE_MASK = layout.offsetof(5);
/*  71 */     BITS_PER_RGB = layout.offsetof(6);
/*  72 */     MAP_ENTRIES = layout.offsetof(7);
/*     */   }
/*     */   
/*     */   protected Visual(long address, ByteBuffer container) {
/*  76 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected Visual create(long address, ByteBuffer container) {
/*  81 */     return new Visual(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Visual(ByteBuffer container) {
/*  91 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  95 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("void *")
/*     */   public long ext_data() {
/*  99 */     return next_data(address());
/*     */   } @NativeType("VisualID")
/*     */   public long visualid() {
/* 102 */     return nvisualid(address());
/*     */   } public int class$() {
/* 104 */     return nclass$(address());
/*     */   } @NativeType("unsigned long")
/*     */   public long red_mask() {
/* 107 */     return nred_mask(address());
/*     */   } @NativeType("unsigned long")
/*     */   public long green_mask() {
/* 110 */     return ngreen_mask(address());
/*     */   } @NativeType("unsigned long")
/*     */   public long blue_mask() {
/* 113 */     return nblue_mask(address());
/*     */   } public int bits_per_rgb() {
/* 115 */     return nbits_per_rgb(address());
/*     */   } public int map_entries() {
/* 117 */     return nmap_entries(address());
/*     */   }
/*     */   public Visual ext_data(@NativeType("void *") long value) {
/* 120 */     next_data(address(), value); return this;
/*     */   } public Visual visualid(@NativeType("VisualID") long value) {
/* 122 */     nvisualid(address(), value); return this;
/*     */   } public Visual class$(int value) {
/* 124 */     nclass$(address(), value); return this;
/*     */   } public Visual red_mask(@NativeType("unsigned long") long value) {
/* 126 */     nred_mask(address(), value); return this;
/*     */   } public Visual green_mask(@NativeType("unsigned long") long value) {
/* 128 */     ngreen_mask(address(), value); return this;
/*     */   } public Visual blue_mask(@NativeType("unsigned long") long value) {
/* 130 */     nblue_mask(address(), value); return this;
/*     */   } public Visual bits_per_rgb(int value) {
/* 132 */     nbits_per_rgb(address(), value); return this;
/*     */   } public Visual map_entries(int value) {
/* 134 */     nmap_entries(address(), value); return this;
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
/*     */   public Visual set(long ext_data, long visualid, int class$, long red_mask, long green_mask, long blue_mask, int bits_per_rgb, int map_entries) {
/* 147 */     ext_data(ext_data);
/* 148 */     visualid(visualid);
/* 149 */     class$(class$);
/* 150 */     red_mask(red_mask);
/* 151 */     green_mask(green_mask);
/* 152 */     blue_mask(blue_mask);
/* 153 */     bits_per_rgb(bits_per_rgb);
/* 154 */     map_entries(map_entries);
/*     */     
/* 156 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Visual set(Visual src) {
/* 167 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 168 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Visual malloc() {
/* 175 */     return new Visual(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Visual calloc() {
/* 180 */     return new Visual(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Visual create() {
/* 185 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 186 */     return new Visual(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Visual create(long address) {
/* 191 */     return new Visual(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Visual createSafe(long address) {
/* 196 */     return (address == 0L) ? null : new Visual(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 205 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 214 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 223 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 224 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 234 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 239 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Visual malloc(MemoryStack stack) {
/* 248 */     return new Visual(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Visual calloc(MemoryStack stack) {
/* 257 */     return new Visual(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 267 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 277 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static long next_data(long struct) {
/* 283 */     return MemoryUtil.memGetAddress(struct + EXT_DATA);
/*     */   } public static long nvisualid(long struct) {
/* 285 */     return MemoryUtil.memGetCLong(struct + VISUALID);
/*     */   } public static int nclass$(long struct) {
/* 287 */     return MemoryUtil.memGetInt(struct + CLASS);
/*     */   } public static long nred_mask(long struct) {
/* 289 */     return MemoryUtil.memGetCLong(struct + RED_MASK);
/*     */   } public static long ngreen_mask(long struct) {
/* 291 */     return MemoryUtil.memGetCLong(struct + GREEN_MASK);
/*     */   } public static long nblue_mask(long struct) {
/* 293 */     return MemoryUtil.memGetCLong(struct + BLUE_MASK);
/*     */   } public static int nbits_per_rgb(long struct) {
/* 295 */     return MemoryUtil.memGetInt(struct + BITS_PER_RGB);
/*     */   } public static int nmap_entries(long struct) {
/* 297 */     return MemoryUtil.memGetInt(struct + MAP_ENTRIES);
/*     */   }
/*     */   public static void next_data(long struct, long value) {
/* 300 */     MemoryUtil.memPutAddress(struct + EXT_DATA, value);
/*     */   } public static void nvisualid(long struct, long value) {
/* 302 */     MemoryUtil.memPutCLong(struct + VISUALID, value);
/*     */   } public static void nclass$(long struct, int value) {
/* 304 */     MemoryUtil.memPutInt(struct + CLASS, value);
/*     */   } public static void nred_mask(long struct, long value) {
/* 306 */     MemoryUtil.memPutCLong(struct + RED_MASK, value);
/*     */   } public static void ngreen_mask(long struct, long value) {
/* 308 */     MemoryUtil.memPutCLong(struct + GREEN_MASK, value);
/*     */   } public static void nblue_mask(long struct, long value) {
/* 310 */     MemoryUtil.memPutCLong(struct + BLUE_MASK, value);
/*     */   } public static void nbits_per_rgb(long struct, int value) {
/* 312 */     MemoryUtil.memPutInt(struct + BITS_PER_RGB, value);
/*     */   } public static void nmap_entries(long struct, int value) {
/* 314 */     MemoryUtil.memPutInt(struct + MAP_ENTRIES, value);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<Visual, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 321 */     private static final Visual ELEMENT_FACTORY = Visual.create(-1L);
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
/* 333 */       super(container, container.remaining() / Visual.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 337 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 341 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 346 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 351 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Visual getElementFactory() {
/* 356 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("void *")
/*     */     public long ext_data() {
/* 361 */       return Visual.next_data(address());
/*     */     } @NativeType("VisualID")
/*     */     public long visualid() {
/* 364 */       return Visual.nvisualid(address());
/*     */     } public int class$() {
/* 366 */       return Visual.nclass$(address());
/*     */     } @NativeType("unsigned long")
/*     */     public long red_mask() {
/* 369 */       return Visual.nred_mask(address());
/*     */     } @NativeType("unsigned long")
/*     */     public long green_mask() {
/* 372 */       return Visual.ngreen_mask(address());
/*     */     } @NativeType("unsigned long")
/*     */     public long blue_mask() {
/* 375 */       return Visual.nblue_mask(address());
/*     */     } public int bits_per_rgb() {
/* 377 */       return Visual.nbits_per_rgb(address());
/*     */     } public int map_entries() {
/* 379 */       return Visual.nmap_entries(address());
/*     */     }
/*     */     public Buffer ext_data(@NativeType("void *") long value) {
/* 382 */       Visual.next_data(address(), value); return this;
/*     */     } public Buffer visualid(@NativeType("VisualID") long value) {
/* 384 */       Visual.nvisualid(address(), value); return this;
/*     */     } public Buffer class$(int value) {
/* 386 */       Visual.nclass$(address(), value); return this;
/*     */     } public Buffer red_mask(@NativeType("unsigned long") long value) {
/* 388 */       Visual.nred_mask(address(), value); return this;
/*     */     } public Buffer green_mask(@NativeType("unsigned long") long value) {
/* 390 */       Visual.ngreen_mask(address(), value); return this;
/*     */     } public Buffer blue_mask(@NativeType("unsigned long") long value) {
/* 392 */       Visual.nblue_mask(address(), value); return this;
/*     */     } public Buffer bits_per_rgb(int value) {
/* 394 */       Visual.nbits_per_rgb(address(), value); return this;
/*     */     } public Buffer map_entries(int value) {
/* 396 */       Visual.nmap_entries(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\Visual.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */