/*     */ package org.lwjgl.system.windows;
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
/*     */ public class PIXELFORMATDESCRIPTOR
/*     */   extends Struct<PIXELFORMATDESCRIPTOR>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int NSIZE;
/*     */   public static final int NVERSION;
/*     */   public static final int DWFLAGS;
/*     */   public static final int IPIXELTYPE;
/*     */   public static final int CCOLORBITS;
/*     */   public static final int CREDBITS;
/*     */   public static final int CREDSHIFT;
/*     */   public static final int CGREENBITS;
/*     */   public static final int CGREENSHIFT;
/*     */   public static final int CBLUEBITS;
/*     */   public static final int CBLUESHIFT;
/*     */   public static final int CALPHABITS;
/*     */   public static final int CALPHASHIFT;
/*     */   public static final int CACCUMBITS;
/*     */   public static final int CACCUMREDBITS;
/*     */   public static final int CACCUMGREENBITS;
/*     */   public static final int CACCUMBLUEBITS;
/*     */   public static final int CACCUMALPHABITS;
/*     */   public static final int CDEPTHBITS;
/*     */   public static final int CSTENCILBITS;
/*     */   public static final int CAUXBUFFERS;
/*     */   public static final int ILAYERTYPE;
/*     */   public static final int BRESERVED;
/*     */   public static final int DWLAYERMASK;
/*     */   public static final int DWVISIBLEMASK;
/*     */   public static final int DWDAMAGEMASK;
/*     */   
/*     */   static {
/*  87 */     Struct.Layout layout = __struct(new Struct.Member[] { 
/*  88 */           __member(2), 
/*  89 */           __member(2), 
/*  90 */           __member(4), 
/*  91 */           __member(1), 
/*  92 */           __member(1), 
/*  93 */           __member(1), 
/*  94 */           __member(1), 
/*  95 */           __member(1), 
/*  96 */           __member(1), 
/*  97 */           __member(1), 
/*  98 */           __member(1), 
/*  99 */           __member(1), 
/* 100 */           __member(1), 
/* 101 */           __member(1), 
/* 102 */           __member(1), 
/* 103 */           __member(1), 
/* 104 */           __member(1), 
/* 105 */           __member(1), 
/* 106 */           __member(1), 
/* 107 */           __member(1), 
/* 108 */           __member(1), 
/* 109 */           __member(1), 
/* 110 */           __member(1), 
/* 111 */           __member(4), 
/* 112 */           __member(4), 
/* 113 */           __member(4) });
/*     */ 
/*     */     
/* 116 */     SIZEOF = layout.getSize();
/* 117 */     ALIGNOF = layout.getAlignment();
/*     */     
/* 119 */     NSIZE = layout.offsetof(0);
/* 120 */     NVERSION = layout.offsetof(1);
/* 121 */     DWFLAGS = layout.offsetof(2);
/* 122 */     IPIXELTYPE = layout.offsetof(3);
/* 123 */     CCOLORBITS = layout.offsetof(4);
/* 124 */     CREDBITS = layout.offsetof(5);
/* 125 */     CREDSHIFT = layout.offsetof(6);
/* 126 */     CGREENBITS = layout.offsetof(7);
/* 127 */     CGREENSHIFT = layout.offsetof(8);
/* 128 */     CBLUEBITS = layout.offsetof(9);
/* 129 */     CBLUESHIFT = layout.offsetof(10);
/* 130 */     CALPHABITS = layout.offsetof(11);
/* 131 */     CALPHASHIFT = layout.offsetof(12);
/* 132 */     CACCUMBITS = layout.offsetof(13);
/* 133 */     CACCUMREDBITS = layout.offsetof(14);
/* 134 */     CACCUMGREENBITS = layout.offsetof(15);
/* 135 */     CACCUMBLUEBITS = layout.offsetof(16);
/* 136 */     CACCUMALPHABITS = layout.offsetof(17);
/* 137 */     CDEPTHBITS = layout.offsetof(18);
/* 138 */     CSTENCILBITS = layout.offsetof(19);
/* 139 */     CAUXBUFFERS = layout.offsetof(20);
/* 140 */     ILAYERTYPE = layout.offsetof(21);
/* 141 */     BRESERVED = layout.offsetof(22);
/* 142 */     DWLAYERMASK = layout.offsetof(23);
/* 143 */     DWVISIBLEMASK = layout.offsetof(24);
/* 144 */     DWDAMAGEMASK = layout.offsetof(25);
/*     */   }
/*     */   
/*     */   protected PIXELFORMATDESCRIPTOR(long address, ByteBuffer container) {
/* 148 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected PIXELFORMATDESCRIPTOR create(long address, ByteBuffer container) {
/* 153 */     return new PIXELFORMATDESCRIPTOR(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PIXELFORMATDESCRIPTOR(ByteBuffer container) {
/* 163 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/* 167 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("WORD")
/*     */   public short nSize() {
/* 171 */     return nnSize(address());
/*     */   } @NativeType("WORD")
/*     */   public short nVersion() {
/* 174 */     return nnVersion(address());
/*     */   } @NativeType("DWORD")
/*     */   public int dwFlags() {
/* 177 */     return ndwFlags(address());
/*     */   } @NativeType("BYTE")
/*     */   public byte iPixelType() {
/* 180 */     return niPixelType(address());
/*     */   } @NativeType("BYTE")
/*     */   public byte cColorBits() {
/* 183 */     return ncColorBits(address());
/*     */   } @NativeType("BYTE")
/*     */   public byte cRedBits() {
/* 186 */     return ncRedBits(address());
/*     */   } @NativeType("BYTE")
/*     */   public byte cRedShift() {
/* 189 */     return ncRedShift(address());
/*     */   } @NativeType("BYTE")
/*     */   public byte cGreenBits() {
/* 192 */     return ncGreenBits(address());
/*     */   } @NativeType("BYTE")
/*     */   public byte cGreenShift() {
/* 195 */     return ncGreenShift(address());
/*     */   } @NativeType("BYTE")
/*     */   public byte cBlueBits() {
/* 198 */     return ncBlueBits(address());
/*     */   } @NativeType("BYTE")
/*     */   public byte cBlueShift() {
/* 201 */     return ncBlueShift(address());
/*     */   } @NativeType("BYTE")
/*     */   public byte cAlphaBits() {
/* 204 */     return ncAlphaBits(address());
/*     */   } @NativeType("BYTE")
/*     */   public byte cAlphaShift() {
/* 207 */     return ncAlphaShift(address());
/*     */   } @NativeType("BYTE")
/*     */   public byte cAccumBits() {
/* 210 */     return ncAccumBits(address());
/*     */   } @NativeType("BYTE")
/*     */   public byte cAccumRedBits() {
/* 213 */     return ncAccumRedBits(address());
/*     */   } @NativeType("BYTE")
/*     */   public byte cAccumGreenBits() {
/* 216 */     return ncAccumGreenBits(address());
/*     */   } @NativeType("BYTE")
/*     */   public byte cAccumBlueBits() {
/* 219 */     return ncAccumBlueBits(address());
/*     */   } @NativeType("BYTE")
/*     */   public byte cAccumAlphaBits() {
/* 222 */     return ncAccumAlphaBits(address());
/*     */   } @NativeType("BYTE")
/*     */   public byte cDepthBits() {
/* 225 */     return ncDepthBits(address());
/*     */   } @NativeType("BYTE")
/*     */   public byte cStencilBits() {
/* 228 */     return ncStencilBits(address());
/*     */   } @NativeType("BYTE")
/*     */   public byte cAuxBuffers() {
/* 231 */     return ncAuxBuffers(address());
/*     */   } @NativeType("BYTE")
/*     */   public byte iLayerType() {
/* 234 */     return niLayerType(address());
/*     */   } @NativeType("BYTE")
/*     */   public byte bReserved() {
/* 237 */     return nbReserved(address());
/*     */   } @NativeType("DWORD")
/*     */   public int dwLayerMask() {
/* 240 */     return ndwLayerMask(address());
/*     */   } @NativeType("DWORD")
/*     */   public int dwVisibleMask() {
/* 243 */     return ndwVisibleMask(address());
/*     */   } @NativeType("DWORD")
/*     */   public int dwDamageMask() {
/* 246 */     return ndwDamageMask(address());
/*     */   }
/*     */   public PIXELFORMATDESCRIPTOR nSize(@NativeType("WORD") short value) {
/* 249 */     nnSize(address(), value); return this;
/*     */   } public PIXELFORMATDESCRIPTOR nVersion(@NativeType("WORD") short value) {
/* 251 */     nnVersion(address(), value); return this;
/*     */   } public PIXELFORMATDESCRIPTOR dwFlags(@NativeType("DWORD") int value) {
/* 253 */     ndwFlags(address(), value); return this;
/*     */   } public PIXELFORMATDESCRIPTOR iPixelType(@NativeType("BYTE") byte value) {
/* 255 */     niPixelType(address(), value); return this;
/*     */   } public PIXELFORMATDESCRIPTOR cColorBits(@NativeType("BYTE") byte value) {
/* 257 */     ncColorBits(address(), value); return this;
/*     */   } public PIXELFORMATDESCRIPTOR cRedBits(@NativeType("BYTE") byte value) {
/* 259 */     ncRedBits(address(), value); return this;
/*     */   } public PIXELFORMATDESCRIPTOR cRedShift(@NativeType("BYTE") byte value) {
/* 261 */     ncRedShift(address(), value); return this;
/*     */   } public PIXELFORMATDESCRIPTOR cGreenBits(@NativeType("BYTE") byte value) {
/* 263 */     ncGreenBits(address(), value); return this;
/*     */   } public PIXELFORMATDESCRIPTOR cGreenShift(@NativeType("BYTE") byte value) {
/* 265 */     ncGreenShift(address(), value); return this;
/*     */   } public PIXELFORMATDESCRIPTOR cBlueBits(@NativeType("BYTE") byte value) {
/* 267 */     ncBlueBits(address(), value); return this;
/*     */   } public PIXELFORMATDESCRIPTOR cBlueShift(@NativeType("BYTE") byte value) {
/* 269 */     ncBlueShift(address(), value); return this;
/*     */   } public PIXELFORMATDESCRIPTOR cAlphaBits(@NativeType("BYTE") byte value) {
/* 271 */     ncAlphaBits(address(), value); return this;
/*     */   } public PIXELFORMATDESCRIPTOR cAlphaShift(@NativeType("BYTE") byte value) {
/* 273 */     ncAlphaShift(address(), value); return this;
/*     */   } public PIXELFORMATDESCRIPTOR cAccumBits(@NativeType("BYTE") byte value) {
/* 275 */     ncAccumBits(address(), value); return this;
/*     */   } public PIXELFORMATDESCRIPTOR cAccumRedBits(@NativeType("BYTE") byte value) {
/* 277 */     ncAccumRedBits(address(), value); return this;
/*     */   } public PIXELFORMATDESCRIPTOR cAccumGreenBits(@NativeType("BYTE") byte value) {
/* 279 */     ncAccumGreenBits(address(), value); return this;
/*     */   } public PIXELFORMATDESCRIPTOR cAccumBlueBits(@NativeType("BYTE") byte value) {
/* 281 */     ncAccumBlueBits(address(), value); return this;
/*     */   } public PIXELFORMATDESCRIPTOR cAccumAlphaBits(@NativeType("BYTE") byte value) {
/* 283 */     ncAccumAlphaBits(address(), value); return this;
/*     */   } public PIXELFORMATDESCRIPTOR cDepthBits(@NativeType("BYTE") byte value) {
/* 285 */     ncDepthBits(address(), value); return this;
/*     */   } public PIXELFORMATDESCRIPTOR cStencilBits(@NativeType("BYTE") byte value) {
/* 287 */     ncStencilBits(address(), value); return this;
/*     */   } public PIXELFORMATDESCRIPTOR cAuxBuffers(@NativeType("BYTE") byte value) {
/* 289 */     ncAuxBuffers(address(), value); return this;
/*     */   } public PIXELFORMATDESCRIPTOR iLayerType(@NativeType("BYTE") byte value) {
/* 291 */     niLayerType(address(), value); return this;
/*     */   } public PIXELFORMATDESCRIPTOR bReserved(@NativeType("BYTE") byte value) {
/* 293 */     nbReserved(address(), value); return this;
/*     */   } public PIXELFORMATDESCRIPTOR dwLayerMask(@NativeType("DWORD") int value) {
/* 295 */     ndwLayerMask(address(), value); return this;
/*     */   } public PIXELFORMATDESCRIPTOR dwVisibleMask(@NativeType("DWORD") int value) {
/* 297 */     ndwVisibleMask(address(), value); return this;
/*     */   } public PIXELFORMATDESCRIPTOR dwDamageMask(@NativeType("DWORD") int value) {
/* 299 */     ndwDamageMask(address(), value); return this;
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
/*     */   public PIXELFORMATDESCRIPTOR set(short nSize, short nVersion, int dwFlags, byte iPixelType, byte cColorBits, byte cRedBits, byte cRedShift, byte cGreenBits, byte cGreenShift, byte cBlueBits, byte cBlueShift, byte cAlphaBits, byte cAlphaShift, byte cAccumBits, byte cAccumRedBits, byte cAccumGreenBits, byte cAccumBlueBits, byte cAccumAlphaBits, byte cDepthBits, byte cStencilBits, byte cAuxBuffers, byte iLayerType, byte bReserved, int dwLayerMask, int dwVisibleMask, int dwDamageMask) {
/* 330 */     nSize(nSize);
/* 331 */     nVersion(nVersion);
/* 332 */     dwFlags(dwFlags);
/* 333 */     iPixelType(iPixelType);
/* 334 */     cColorBits(cColorBits);
/* 335 */     cRedBits(cRedBits);
/* 336 */     cRedShift(cRedShift);
/* 337 */     cGreenBits(cGreenBits);
/* 338 */     cGreenShift(cGreenShift);
/* 339 */     cBlueBits(cBlueBits);
/* 340 */     cBlueShift(cBlueShift);
/* 341 */     cAlphaBits(cAlphaBits);
/* 342 */     cAlphaShift(cAlphaShift);
/* 343 */     cAccumBits(cAccumBits);
/* 344 */     cAccumRedBits(cAccumRedBits);
/* 345 */     cAccumGreenBits(cAccumGreenBits);
/* 346 */     cAccumBlueBits(cAccumBlueBits);
/* 347 */     cAccumAlphaBits(cAccumAlphaBits);
/* 348 */     cDepthBits(cDepthBits);
/* 349 */     cStencilBits(cStencilBits);
/* 350 */     cAuxBuffers(cAuxBuffers);
/* 351 */     iLayerType(iLayerType);
/* 352 */     bReserved(bReserved);
/* 353 */     dwLayerMask(dwLayerMask);
/* 354 */     dwVisibleMask(dwVisibleMask);
/* 355 */     dwDamageMask(dwDamageMask);
/*     */     
/* 357 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PIXELFORMATDESCRIPTOR set(PIXELFORMATDESCRIPTOR src) {
/* 368 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 369 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static PIXELFORMATDESCRIPTOR malloc() {
/* 376 */     return new PIXELFORMATDESCRIPTOR(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static PIXELFORMATDESCRIPTOR calloc() {
/* 381 */     return new PIXELFORMATDESCRIPTOR(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static PIXELFORMATDESCRIPTOR create() {
/* 386 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 387 */     return new PIXELFORMATDESCRIPTOR(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static PIXELFORMATDESCRIPTOR create(long address) {
/* 392 */     return new PIXELFORMATDESCRIPTOR(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static PIXELFORMATDESCRIPTOR createSafe(long address) {
/* 397 */     return (address == 0L) ? null : new PIXELFORMATDESCRIPTOR(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 406 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 415 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 424 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 425 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 435 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 440 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static PIXELFORMATDESCRIPTOR malloc(MemoryStack stack) {
/* 449 */     return new PIXELFORMATDESCRIPTOR(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static PIXELFORMATDESCRIPTOR calloc(MemoryStack stack) {
/* 458 */     return new PIXELFORMATDESCRIPTOR(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 468 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 478 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static short nnSize(long struct) {
/* 484 */     return MemoryUtil.memGetShort(struct + NSIZE);
/*     */   } public static short nnVersion(long struct) {
/* 486 */     return MemoryUtil.memGetShort(struct + NVERSION);
/*     */   } public static int ndwFlags(long struct) {
/* 488 */     return MemoryUtil.memGetInt(struct + DWFLAGS);
/*     */   } public static byte niPixelType(long struct) {
/* 490 */     return MemoryUtil.memGetByte(struct + IPIXELTYPE);
/*     */   } public static byte ncColorBits(long struct) {
/* 492 */     return MemoryUtil.memGetByte(struct + CCOLORBITS);
/*     */   } public static byte ncRedBits(long struct) {
/* 494 */     return MemoryUtil.memGetByte(struct + CREDBITS);
/*     */   } public static byte ncRedShift(long struct) {
/* 496 */     return MemoryUtil.memGetByte(struct + CREDSHIFT);
/*     */   } public static byte ncGreenBits(long struct) {
/* 498 */     return MemoryUtil.memGetByte(struct + CGREENBITS);
/*     */   } public static byte ncGreenShift(long struct) {
/* 500 */     return MemoryUtil.memGetByte(struct + CGREENSHIFT);
/*     */   } public static byte ncBlueBits(long struct) {
/* 502 */     return MemoryUtil.memGetByte(struct + CBLUEBITS);
/*     */   } public static byte ncBlueShift(long struct) {
/* 504 */     return MemoryUtil.memGetByte(struct + CBLUESHIFT);
/*     */   } public static byte ncAlphaBits(long struct) {
/* 506 */     return MemoryUtil.memGetByte(struct + CALPHABITS);
/*     */   } public static byte ncAlphaShift(long struct) {
/* 508 */     return MemoryUtil.memGetByte(struct + CALPHASHIFT);
/*     */   } public static byte ncAccumBits(long struct) {
/* 510 */     return MemoryUtil.memGetByte(struct + CACCUMBITS);
/*     */   } public static byte ncAccumRedBits(long struct) {
/* 512 */     return MemoryUtil.memGetByte(struct + CACCUMREDBITS);
/*     */   } public static byte ncAccumGreenBits(long struct) {
/* 514 */     return MemoryUtil.memGetByte(struct + CACCUMGREENBITS);
/*     */   } public static byte ncAccumBlueBits(long struct) {
/* 516 */     return MemoryUtil.memGetByte(struct + CACCUMBLUEBITS);
/*     */   } public static byte ncAccumAlphaBits(long struct) {
/* 518 */     return MemoryUtil.memGetByte(struct + CACCUMALPHABITS);
/*     */   } public static byte ncDepthBits(long struct) {
/* 520 */     return MemoryUtil.memGetByte(struct + CDEPTHBITS);
/*     */   } public static byte ncStencilBits(long struct) {
/* 522 */     return MemoryUtil.memGetByte(struct + CSTENCILBITS);
/*     */   } public static byte ncAuxBuffers(long struct) {
/* 524 */     return MemoryUtil.memGetByte(struct + CAUXBUFFERS);
/*     */   } public static byte niLayerType(long struct) {
/* 526 */     return MemoryUtil.memGetByte(struct + ILAYERTYPE);
/*     */   } public static byte nbReserved(long struct) {
/* 528 */     return MemoryUtil.memGetByte(struct + BRESERVED);
/*     */   } public static int ndwLayerMask(long struct) {
/* 530 */     return MemoryUtil.memGetInt(struct + DWLAYERMASK);
/*     */   } public static int ndwVisibleMask(long struct) {
/* 532 */     return MemoryUtil.memGetInt(struct + DWVISIBLEMASK);
/*     */   } public static int ndwDamageMask(long struct) {
/* 534 */     return MemoryUtil.memGetInt(struct + DWDAMAGEMASK);
/*     */   }
/*     */   public static void nnSize(long struct, short value) {
/* 537 */     MemoryUtil.memPutShort(struct + NSIZE, value);
/*     */   } public static void nnVersion(long struct, short value) {
/* 539 */     MemoryUtil.memPutShort(struct + NVERSION, value);
/*     */   } public static void ndwFlags(long struct, int value) {
/* 541 */     MemoryUtil.memPutInt(struct + DWFLAGS, value);
/*     */   } public static void niPixelType(long struct, byte value) {
/* 543 */     MemoryUtil.memPutByte(struct + IPIXELTYPE, value);
/*     */   } public static void ncColorBits(long struct, byte value) {
/* 545 */     MemoryUtil.memPutByte(struct + CCOLORBITS, value);
/*     */   } public static void ncRedBits(long struct, byte value) {
/* 547 */     MemoryUtil.memPutByte(struct + CREDBITS, value);
/*     */   } public static void ncRedShift(long struct, byte value) {
/* 549 */     MemoryUtil.memPutByte(struct + CREDSHIFT, value);
/*     */   } public static void ncGreenBits(long struct, byte value) {
/* 551 */     MemoryUtil.memPutByte(struct + CGREENBITS, value);
/*     */   } public static void ncGreenShift(long struct, byte value) {
/* 553 */     MemoryUtil.memPutByte(struct + CGREENSHIFT, value);
/*     */   } public static void ncBlueBits(long struct, byte value) {
/* 555 */     MemoryUtil.memPutByte(struct + CBLUEBITS, value);
/*     */   } public static void ncBlueShift(long struct, byte value) {
/* 557 */     MemoryUtil.memPutByte(struct + CBLUESHIFT, value);
/*     */   } public static void ncAlphaBits(long struct, byte value) {
/* 559 */     MemoryUtil.memPutByte(struct + CALPHABITS, value);
/*     */   } public static void ncAlphaShift(long struct, byte value) {
/* 561 */     MemoryUtil.memPutByte(struct + CALPHASHIFT, value);
/*     */   } public static void ncAccumBits(long struct, byte value) {
/* 563 */     MemoryUtil.memPutByte(struct + CACCUMBITS, value);
/*     */   } public static void ncAccumRedBits(long struct, byte value) {
/* 565 */     MemoryUtil.memPutByte(struct + CACCUMREDBITS, value);
/*     */   } public static void ncAccumGreenBits(long struct, byte value) {
/* 567 */     MemoryUtil.memPutByte(struct + CACCUMGREENBITS, value);
/*     */   } public static void ncAccumBlueBits(long struct, byte value) {
/* 569 */     MemoryUtil.memPutByte(struct + CACCUMBLUEBITS, value);
/*     */   } public static void ncAccumAlphaBits(long struct, byte value) {
/* 571 */     MemoryUtil.memPutByte(struct + CACCUMALPHABITS, value);
/*     */   } public static void ncDepthBits(long struct, byte value) {
/* 573 */     MemoryUtil.memPutByte(struct + CDEPTHBITS, value);
/*     */   } public static void ncStencilBits(long struct, byte value) {
/* 575 */     MemoryUtil.memPutByte(struct + CSTENCILBITS, value);
/*     */   } public static void ncAuxBuffers(long struct, byte value) {
/* 577 */     MemoryUtil.memPutByte(struct + CAUXBUFFERS, value);
/*     */   } public static void niLayerType(long struct, byte value) {
/* 579 */     MemoryUtil.memPutByte(struct + ILAYERTYPE, value);
/*     */   } public static void nbReserved(long struct, byte value) {
/* 581 */     MemoryUtil.memPutByte(struct + BRESERVED, value);
/*     */   } public static void ndwLayerMask(long struct, int value) {
/* 583 */     MemoryUtil.memPutInt(struct + DWLAYERMASK, value);
/*     */   } public static void ndwVisibleMask(long struct, int value) {
/* 585 */     MemoryUtil.memPutInt(struct + DWVISIBLEMASK, value);
/*     */   } public static void ndwDamageMask(long struct, int value) {
/* 587 */     MemoryUtil.memPutInt(struct + DWDAMAGEMASK, value);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<PIXELFORMATDESCRIPTOR, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 594 */     private static final PIXELFORMATDESCRIPTOR ELEMENT_FACTORY = PIXELFORMATDESCRIPTOR.create(-1L);
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
/* 606 */       super(container, container.remaining() / PIXELFORMATDESCRIPTOR.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 610 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 614 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 619 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 624 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected PIXELFORMATDESCRIPTOR getElementFactory() {
/* 629 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("WORD")
/*     */     public short nSize() {
/* 634 */       return PIXELFORMATDESCRIPTOR.nnSize(address());
/*     */     } @NativeType("WORD")
/*     */     public short nVersion() {
/* 637 */       return PIXELFORMATDESCRIPTOR.nnVersion(address());
/*     */     } @NativeType("DWORD")
/*     */     public int dwFlags() {
/* 640 */       return PIXELFORMATDESCRIPTOR.ndwFlags(address());
/*     */     } @NativeType("BYTE")
/*     */     public byte iPixelType() {
/* 643 */       return PIXELFORMATDESCRIPTOR.niPixelType(address());
/*     */     } @NativeType("BYTE")
/*     */     public byte cColorBits() {
/* 646 */       return PIXELFORMATDESCRIPTOR.ncColorBits(address());
/*     */     } @NativeType("BYTE")
/*     */     public byte cRedBits() {
/* 649 */       return PIXELFORMATDESCRIPTOR.ncRedBits(address());
/*     */     } @NativeType("BYTE")
/*     */     public byte cRedShift() {
/* 652 */       return PIXELFORMATDESCRIPTOR.ncRedShift(address());
/*     */     } @NativeType("BYTE")
/*     */     public byte cGreenBits() {
/* 655 */       return PIXELFORMATDESCRIPTOR.ncGreenBits(address());
/*     */     } @NativeType("BYTE")
/*     */     public byte cGreenShift() {
/* 658 */       return PIXELFORMATDESCRIPTOR.ncGreenShift(address());
/*     */     } @NativeType("BYTE")
/*     */     public byte cBlueBits() {
/* 661 */       return PIXELFORMATDESCRIPTOR.ncBlueBits(address());
/*     */     } @NativeType("BYTE")
/*     */     public byte cBlueShift() {
/* 664 */       return PIXELFORMATDESCRIPTOR.ncBlueShift(address());
/*     */     } @NativeType("BYTE")
/*     */     public byte cAlphaBits() {
/* 667 */       return PIXELFORMATDESCRIPTOR.ncAlphaBits(address());
/*     */     } @NativeType("BYTE")
/*     */     public byte cAlphaShift() {
/* 670 */       return PIXELFORMATDESCRIPTOR.ncAlphaShift(address());
/*     */     } @NativeType("BYTE")
/*     */     public byte cAccumBits() {
/* 673 */       return PIXELFORMATDESCRIPTOR.ncAccumBits(address());
/*     */     } @NativeType("BYTE")
/*     */     public byte cAccumRedBits() {
/* 676 */       return PIXELFORMATDESCRIPTOR.ncAccumRedBits(address());
/*     */     } @NativeType("BYTE")
/*     */     public byte cAccumGreenBits() {
/* 679 */       return PIXELFORMATDESCRIPTOR.ncAccumGreenBits(address());
/*     */     } @NativeType("BYTE")
/*     */     public byte cAccumBlueBits() {
/* 682 */       return PIXELFORMATDESCRIPTOR.ncAccumBlueBits(address());
/*     */     } @NativeType("BYTE")
/*     */     public byte cAccumAlphaBits() {
/* 685 */       return PIXELFORMATDESCRIPTOR.ncAccumAlphaBits(address());
/*     */     } @NativeType("BYTE")
/*     */     public byte cDepthBits() {
/* 688 */       return PIXELFORMATDESCRIPTOR.ncDepthBits(address());
/*     */     } @NativeType("BYTE")
/*     */     public byte cStencilBits() {
/* 691 */       return PIXELFORMATDESCRIPTOR.ncStencilBits(address());
/*     */     } @NativeType("BYTE")
/*     */     public byte cAuxBuffers() {
/* 694 */       return PIXELFORMATDESCRIPTOR.ncAuxBuffers(address());
/*     */     } @NativeType("BYTE")
/*     */     public byte iLayerType() {
/* 697 */       return PIXELFORMATDESCRIPTOR.niLayerType(address());
/*     */     } @NativeType("BYTE")
/*     */     public byte bReserved() {
/* 700 */       return PIXELFORMATDESCRIPTOR.nbReserved(address());
/*     */     } @NativeType("DWORD")
/*     */     public int dwLayerMask() {
/* 703 */       return PIXELFORMATDESCRIPTOR.ndwLayerMask(address());
/*     */     } @NativeType("DWORD")
/*     */     public int dwVisibleMask() {
/* 706 */       return PIXELFORMATDESCRIPTOR.ndwVisibleMask(address());
/*     */     } @NativeType("DWORD")
/*     */     public int dwDamageMask() {
/* 709 */       return PIXELFORMATDESCRIPTOR.ndwDamageMask(address());
/*     */     }
/*     */     public Buffer nSize(@NativeType("WORD") short value) {
/* 712 */       PIXELFORMATDESCRIPTOR.nnSize(address(), value); return this;
/*     */     } public Buffer nVersion(@NativeType("WORD") short value) {
/* 714 */       PIXELFORMATDESCRIPTOR.nnVersion(address(), value); return this;
/*     */     } public Buffer dwFlags(@NativeType("DWORD") int value) {
/* 716 */       PIXELFORMATDESCRIPTOR.ndwFlags(address(), value); return this;
/*     */     } public Buffer iPixelType(@NativeType("BYTE") byte value) {
/* 718 */       PIXELFORMATDESCRIPTOR.niPixelType(address(), value); return this;
/*     */     } public Buffer cColorBits(@NativeType("BYTE") byte value) {
/* 720 */       PIXELFORMATDESCRIPTOR.ncColorBits(address(), value); return this;
/*     */     } public Buffer cRedBits(@NativeType("BYTE") byte value) {
/* 722 */       PIXELFORMATDESCRIPTOR.ncRedBits(address(), value); return this;
/*     */     } public Buffer cRedShift(@NativeType("BYTE") byte value) {
/* 724 */       PIXELFORMATDESCRIPTOR.ncRedShift(address(), value); return this;
/*     */     } public Buffer cGreenBits(@NativeType("BYTE") byte value) {
/* 726 */       PIXELFORMATDESCRIPTOR.ncGreenBits(address(), value); return this;
/*     */     } public Buffer cGreenShift(@NativeType("BYTE") byte value) {
/* 728 */       PIXELFORMATDESCRIPTOR.ncGreenShift(address(), value); return this;
/*     */     } public Buffer cBlueBits(@NativeType("BYTE") byte value) {
/* 730 */       PIXELFORMATDESCRIPTOR.ncBlueBits(address(), value); return this;
/*     */     } public Buffer cBlueShift(@NativeType("BYTE") byte value) {
/* 732 */       PIXELFORMATDESCRIPTOR.ncBlueShift(address(), value); return this;
/*     */     } public Buffer cAlphaBits(@NativeType("BYTE") byte value) {
/* 734 */       PIXELFORMATDESCRIPTOR.ncAlphaBits(address(), value); return this;
/*     */     } public Buffer cAlphaShift(@NativeType("BYTE") byte value) {
/* 736 */       PIXELFORMATDESCRIPTOR.ncAlphaShift(address(), value); return this;
/*     */     } public Buffer cAccumBits(@NativeType("BYTE") byte value) {
/* 738 */       PIXELFORMATDESCRIPTOR.ncAccumBits(address(), value); return this;
/*     */     } public Buffer cAccumRedBits(@NativeType("BYTE") byte value) {
/* 740 */       PIXELFORMATDESCRIPTOR.ncAccumRedBits(address(), value); return this;
/*     */     } public Buffer cAccumGreenBits(@NativeType("BYTE") byte value) {
/* 742 */       PIXELFORMATDESCRIPTOR.ncAccumGreenBits(address(), value); return this;
/*     */     } public Buffer cAccumBlueBits(@NativeType("BYTE") byte value) {
/* 744 */       PIXELFORMATDESCRIPTOR.ncAccumBlueBits(address(), value); return this;
/*     */     } public Buffer cAccumAlphaBits(@NativeType("BYTE") byte value) {
/* 746 */       PIXELFORMATDESCRIPTOR.ncAccumAlphaBits(address(), value); return this;
/*     */     } public Buffer cDepthBits(@NativeType("BYTE") byte value) {
/* 748 */       PIXELFORMATDESCRIPTOR.ncDepthBits(address(), value); return this;
/*     */     } public Buffer cStencilBits(@NativeType("BYTE") byte value) {
/* 750 */       PIXELFORMATDESCRIPTOR.ncStencilBits(address(), value); return this;
/*     */     } public Buffer cAuxBuffers(@NativeType("BYTE") byte value) {
/* 752 */       PIXELFORMATDESCRIPTOR.ncAuxBuffers(address(), value); return this;
/*     */     } public Buffer iLayerType(@NativeType("BYTE") byte value) {
/* 754 */       PIXELFORMATDESCRIPTOR.niLayerType(address(), value); return this;
/*     */     } public Buffer bReserved(@NativeType("BYTE") byte value) {
/* 756 */       PIXELFORMATDESCRIPTOR.nbReserved(address(), value); return this;
/*     */     } public Buffer dwLayerMask(@NativeType("DWORD") int value) {
/* 758 */       PIXELFORMATDESCRIPTOR.ndwLayerMask(address(), value); return this;
/*     */     } public Buffer dwVisibleMask(@NativeType("DWORD") int value) {
/* 760 */       PIXELFORMATDESCRIPTOR.ndwVisibleMask(address(), value); return this;
/*     */     } public Buffer dwDamageMask(@NativeType("DWORD") int value) {
/* 762 */       PIXELFORMATDESCRIPTOR.ndwDamageMask(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\windows\PIXELFORMATDESCRIPTOR.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */