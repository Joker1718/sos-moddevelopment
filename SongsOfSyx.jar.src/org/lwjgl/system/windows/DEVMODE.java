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
/*     */ public class DEVMODE
/*     */   extends Struct<DEVMODE>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int DMDEVICENAME;
/*     */   public static final int DMSPECVERSION;
/*     */   public static final int DMDRIVERVERSION;
/*     */   public static final int DMSIZE;
/*     */   public static final int DMDRIVEREXTRA;
/*     */   public static final int DMFIELDS;
/*     */   public static final int DMORIENTATION;
/*     */   public static final int DMPAPERSIZE;
/*     */   public static final int DMPAPERLENGTH;
/*     */   public static final int DMPAPERWIDTH;
/*     */   public static final int DMSCALE;
/*     */   public static final int DMCOPIES;
/*     */   public static final int DMDEFAULTSOURCE;
/*     */   public static final int DMPRINTQUALITY;
/*     */   public static final int DMPOSITION;
/*     */   public static final int DMDISPLAYORIENTATION;
/*     */   public static final int DMDISPLAYFIXEDOUTPUT;
/*     */   public static final int DMCOLOR;
/*     */   public static final int DMDUPLEX;
/*     */   public static final int DMYRESOLUTION;
/*     */   public static final int DMTTOPTION;
/*     */   public static final int DMCOLLATE;
/*     */   public static final int DMFORMNAME;
/*     */   public static final int DMLOGPIXELS;
/*     */   public static final int DMBITSPERPEL;
/*     */   public static final int DMPELSWIDTH;
/*     */   public static final int DMPELSHEIGHT;
/*     */   public static final int DMDISPLAYFLAGS;
/*     */   public static final int DMNUP;
/*     */   public static final int DMDISPLAYFREQUENCY;
/*     */   public static final int DMICMMETHOD;
/*     */   public static final int DMICMINTENT;
/*     */   public static final int DMMEDIATYPE;
/*     */   public static final int DMDITHERTYPE;
/*     */   public static final int DMRESERVED1;
/*     */   public static final int DMRESERVED2;
/*     */   public static final int DMPANNINGWIDTH;
/*     */   public static final int DMPANNINGHEIGHT;
/*     */   
/*     */   static {
/* 119 */     Struct.Layout layout = __struct(new Struct.Member[] { 
/* 120 */           __array(2, 32), 
/* 121 */           __member(2), 
/* 122 */           __member(2), 
/* 123 */           __member(2), 
/* 124 */           __member(2), 
/* 125 */           __member(4), 
/* 126 */           (Struct.Member)__union(new Struct.Member[] {
/* 127 */               (Struct.Member)__struct(new Struct.Member[] {
/* 128 */                   __member(2), 
/* 129 */                   __member(2), 
/* 130 */                   __member(2), 
/* 131 */                   __member(2), 
/* 132 */                   __member(2), 
/* 133 */                   __member(2), 
/* 134 */                   __member(2), 
/* 135 */                   __member(2)
/*     */                 
/* 137 */                 }), (Struct.Member)__struct(new Struct.Member[] {
/* 138 */                   __member(POINTL.SIZEOF, POINTL.ALIGNOF), 
/* 139 */                   __member(4), 
/* 140 */                   __member(4)
/*     */                 
/*     */                 })
/* 143 */             }), __member(2), 
/* 144 */           __member(2), 
/* 145 */           __member(2), 
/* 146 */           __member(2), 
/* 147 */           __member(2), 
/* 148 */           __array(2, 32), 
/* 149 */           __member(2), 
/* 150 */           __member(4), 
/* 151 */           __member(4), 
/* 152 */           __member(4), 
/* 153 */           (Struct.Member)__union(new Struct.Member[] {
/* 154 */               __member(4), 
/* 155 */               __member(4)
/*     */             
/* 157 */             }), __member(4), 
/* 158 */           __member(4), 
/* 159 */           __member(4), 
/* 160 */           __member(4), 
/* 161 */           __member(4), 
/* 162 */           __member(4), 
/* 163 */           __member(4), 
/* 164 */           __member(4), 
/* 165 */           __member(4) });
/*     */ 
/*     */     
/* 168 */     SIZEOF = layout.getSize();
/* 169 */     ALIGNOF = layout.getAlignment();
/*     */     
/* 171 */     DMDEVICENAME = layout.offsetof(0);
/* 172 */     DMSPECVERSION = layout.offsetof(1);
/* 173 */     DMDRIVERVERSION = layout.offsetof(2);
/* 174 */     DMSIZE = layout.offsetof(3);
/* 175 */     DMDRIVEREXTRA = layout.offsetof(4);
/* 176 */     DMFIELDS = layout.offsetof(5);
/* 177 */     DMORIENTATION = layout.offsetof(8);
/* 178 */     DMPAPERSIZE = layout.offsetof(9);
/* 179 */     DMPAPERLENGTH = layout.offsetof(10);
/* 180 */     DMPAPERWIDTH = layout.offsetof(11);
/* 181 */     DMSCALE = layout.offsetof(12);
/* 182 */     DMCOPIES = layout.offsetof(13);
/* 183 */     DMDEFAULTSOURCE = layout.offsetof(14);
/* 184 */     DMPRINTQUALITY = layout.offsetof(15);
/* 185 */     DMPOSITION = layout.offsetof(17);
/* 186 */     DMDISPLAYORIENTATION = layout.offsetof(18);
/* 187 */     DMDISPLAYFIXEDOUTPUT = layout.offsetof(19);
/* 188 */     DMCOLOR = layout.offsetof(20);
/* 189 */     DMDUPLEX = layout.offsetof(21);
/* 190 */     DMYRESOLUTION = layout.offsetof(22);
/* 191 */     DMTTOPTION = layout.offsetof(23);
/* 192 */     DMCOLLATE = layout.offsetof(24);
/* 193 */     DMFORMNAME = layout.offsetof(25);
/* 194 */     DMLOGPIXELS = layout.offsetof(26);
/* 195 */     DMBITSPERPEL = layout.offsetof(27);
/* 196 */     DMPELSWIDTH = layout.offsetof(28);
/* 197 */     DMPELSHEIGHT = layout.offsetof(29);
/* 198 */     DMDISPLAYFLAGS = layout.offsetof(31);
/* 199 */     DMNUP = layout.offsetof(32);
/* 200 */     DMDISPLAYFREQUENCY = layout.offsetof(33);
/* 201 */     DMICMMETHOD = layout.offsetof(34);
/* 202 */     DMICMINTENT = layout.offsetof(35);
/* 203 */     DMMEDIATYPE = layout.offsetof(36);
/* 204 */     DMDITHERTYPE = layout.offsetof(37);
/* 205 */     DMRESERVED1 = layout.offsetof(38);
/* 206 */     DMRESERVED2 = layout.offsetof(39);
/* 207 */     DMPANNINGWIDTH = layout.offsetof(40);
/* 208 */     DMPANNINGHEIGHT = layout.offsetof(41);
/*     */   }
/*     */   
/*     */   protected DEVMODE(long address, ByteBuffer container) {
/* 212 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected DEVMODE create(long address, ByteBuffer container) {
/* 217 */     return new DEVMODE(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DEVMODE(ByteBuffer container) {
/* 227 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/* 231 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("TCHAR[32]")
/*     */   public ByteBuffer dmDeviceName() {
/* 235 */     return ndmDeviceName(address());
/*     */   } @NativeType("TCHAR[32]")
/*     */   public String dmDeviceNameString() {
/* 238 */     return ndmDeviceNameString(address());
/*     */   } @NativeType("WORD")
/*     */   public short dmSpecVersion() {
/* 241 */     return ndmSpecVersion(address());
/*     */   } @NativeType("WORD")
/*     */   public short dmDriverVersion() {
/* 244 */     return ndmDriverVersion(address());
/*     */   } @NativeType("WORD")
/*     */   public short dmSize() {
/* 247 */     return ndmSize(address());
/*     */   } @NativeType("WORD")
/*     */   public short dmDriverExtra() {
/* 250 */     return ndmDriverExtra(address());
/*     */   } @NativeType("DWORD")
/*     */   public int dmFields() {
/* 253 */     return ndmFields(address());
/*     */   } public short dmOrientation() {
/* 255 */     return ndmOrientation(address());
/*     */   } public short dmPaperSize() {
/* 257 */     return ndmPaperSize(address());
/*     */   } public short dmPaperLength() {
/* 259 */     return ndmPaperLength(address());
/*     */   } public short dmPaperWidth() {
/* 261 */     return ndmPaperWidth(address());
/*     */   } public short dmScale() {
/* 263 */     return ndmScale(address());
/*     */   } public short dmCopies() {
/* 265 */     return ndmCopies(address());
/*     */   } public short dmDefaultSource() {
/* 267 */     return ndmDefaultSource(address());
/*     */   } public short dmPrintQuality() {
/* 269 */     return ndmPrintQuality(address());
/*     */   } public POINTL dmPosition() {
/* 271 */     return ndmPosition(address());
/*     */   } @NativeType("DWORD")
/*     */   public int dmDisplayOrientation() {
/* 274 */     return ndmDisplayOrientation(address());
/*     */   } @NativeType("DWORD")
/*     */   public int dmDisplayFixedOutput() {
/* 277 */     return ndmDisplayFixedOutput(address());
/*     */   } public short dmColor() {
/* 279 */     return ndmColor(address());
/*     */   } public short dmDuplex() {
/* 281 */     return ndmDuplex(address());
/*     */   } public short dmYResolution() {
/* 283 */     return ndmYResolution(address());
/*     */   } public short dmTTOption() {
/* 285 */     return ndmTTOption(address());
/*     */   } public short dmCollate() {
/* 287 */     return ndmCollate(address());
/*     */   } @NativeType("TCHAR[32]")
/*     */   public ByteBuffer dmFormName() {
/* 290 */     return ndmFormName(address());
/*     */   } @NativeType("TCHAR[32]")
/*     */   public String dmFormNameString() {
/* 293 */     return ndmFormNameString(address());
/*     */   } @NativeType("WORD")
/*     */   public short dmLogPixels() {
/* 296 */     return ndmLogPixels(address());
/*     */   } @NativeType("DWORD")
/*     */   public int dmBitsPerPel() {
/* 299 */     return ndmBitsPerPel(address());
/*     */   } @NativeType("DWORD")
/*     */   public int dmPelsWidth() {
/* 302 */     return ndmPelsWidth(address());
/*     */   } @NativeType("DWORD")
/*     */   public int dmPelsHeight() {
/* 305 */     return ndmPelsHeight(address());
/*     */   } @NativeType("DWORD")
/*     */   public int dmDisplayFlags() {
/* 308 */     return ndmDisplayFlags(address());
/*     */   } @NativeType("DWORD")
/*     */   public int dmNup() {
/* 311 */     return ndmNup(address());
/*     */   } @NativeType("DWORD")
/*     */   public int dmDisplayFrequency() {
/* 314 */     return ndmDisplayFrequency(address());
/*     */   } @NativeType("DWORD")
/*     */   public int dmICMMethod() {
/* 317 */     return ndmICMMethod(address());
/*     */   } @NativeType("DWORD")
/*     */   public int dmICMIntent() {
/* 320 */     return ndmICMIntent(address());
/*     */   } @NativeType("DWORD")
/*     */   public int dmMediaType() {
/* 323 */     return ndmMediaType(address());
/*     */   } @NativeType("DWORD")
/*     */   public int dmDitherType() {
/* 326 */     return ndmDitherType(address());
/*     */   } @NativeType("DWORD")
/*     */   public int dmReserved1() {
/* 329 */     return ndmReserved1(address());
/*     */   } @NativeType("DWORD")
/*     */   public int dmReserved2() {
/* 332 */     return ndmReserved2(address());
/*     */   } @NativeType("DWORD")
/*     */   public int dmPanningWidth() {
/* 335 */     return ndmPanningWidth(address());
/*     */   } @NativeType("DWORD")
/*     */   public int dmPanningHeight() {
/* 338 */     return ndmPanningHeight(address());
/*     */   }
/*     */   public DEVMODE dmSpecVersion(@NativeType("WORD") short value) {
/* 341 */     ndmSpecVersion(address(), value); return this;
/*     */   } public DEVMODE dmSize(@NativeType("WORD") short value) {
/* 343 */     ndmSize(address(), value); return this;
/*     */   } public DEVMODE dmDriverExtra(@NativeType("WORD") short value) {
/* 345 */     ndmDriverExtra(address(), value); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DEVMODE set(DEVMODE src) {
/* 355 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 356 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static DEVMODE malloc() {
/* 363 */     return new DEVMODE(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static DEVMODE calloc() {
/* 368 */     return new DEVMODE(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static DEVMODE create() {
/* 373 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 374 */     return new DEVMODE(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static DEVMODE create(long address) {
/* 379 */     return new DEVMODE(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static DEVMODE createSafe(long address) {
/* 384 */     return (address == 0L) ? null : new DEVMODE(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 393 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 402 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 411 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 412 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 422 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 427 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static DEVMODE malloc(MemoryStack stack) {
/* 436 */     return new DEVMODE(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static DEVMODE calloc(MemoryStack stack) {
/* 445 */     return new DEVMODE(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 455 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 465 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static ByteBuffer ndmDeviceName(long struct) {
/* 471 */     return MemoryUtil.memByteBuffer(struct + DMDEVICENAME, 64);
/*     */   } public static String ndmDeviceNameString(long struct) {
/* 473 */     return MemoryUtil.memUTF16(struct + DMDEVICENAME);
/*     */   } public static short ndmSpecVersion(long struct) {
/* 475 */     return MemoryUtil.memGetShort(struct + DMSPECVERSION);
/*     */   } public static short ndmDriverVersion(long struct) {
/* 477 */     return MemoryUtil.memGetShort(struct + DMDRIVERVERSION);
/*     */   } public static short ndmSize(long struct) {
/* 479 */     return MemoryUtil.memGetShort(struct + DMSIZE);
/*     */   } public static short ndmDriverExtra(long struct) {
/* 481 */     return MemoryUtil.memGetShort(struct + DMDRIVEREXTRA);
/*     */   } public static int ndmFields(long struct) {
/* 483 */     return MemoryUtil.memGetInt(struct + DMFIELDS);
/*     */   } public static short ndmOrientation(long struct) {
/* 485 */     return MemoryUtil.memGetShort(struct + DMORIENTATION);
/*     */   } public static short ndmPaperSize(long struct) {
/* 487 */     return MemoryUtil.memGetShort(struct + DMPAPERSIZE);
/*     */   } public static short ndmPaperLength(long struct) {
/* 489 */     return MemoryUtil.memGetShort(struct + DMPAPERLENGTH);
/*     */   } public static short ndmPaperWidth(long struct) {
/* 491 */     return MemoryUtil.memGetShort(struct + DMPAPERWIDTH);
/*     */   } public static short ndmScale(long struct) {
/* 493 */     return MemoryUtil.memGetShort(struct + DMSCALE);
/*     */   } public static short ndmCopies(long struct) {
/* 495 */     return MemoryUtil.memGetShort(struct + DMCOPIES);
/*     */   } public static short ndmDefaultSource(long struct) {
/* 497 */     return MemoryUtil.memGetShort(struct + DMDEFAULTSOURCE);
/*     */   } public static short ndmPrintQuality(long struct) {
/* 499 */     return MemoryUtil.memGetShort(struct + DMPRINTQUALITY);
/*     */   } public static POINTL ndmPosition(long struct) {
/* 501 */     return POINTL.create(struct + DMPOSITION);
/*     */   } public static int ndmDisplayOrientation(long struct) {
/* 503 */     return MemoryUtil.memGetInt(struct + DMDISPLAYORIENTATION);
/*     */   } public static int ndmDisplayFixedOutput(long struct) {
/* 505 */     return MemoryUtil.memGetInt(struct + DMDISPLAYFIXEDOUTPUT);
/*     */   } public static short ndmColor(long struct) {
/* 507 */     return MemoryUtil.memGetShort(struct + DMCOLOR);
/*     */   } public static short ndmDuplex(long struct) {
/* 509 */     return MemoryUtil.memGetShort(struct + DMDUPLEX);
/*     */   } public static short ndmYResolution(long struct) {
/* 511 */     return MemoryUtil.memGetShort(struct + DMYRESOLUTION);
/*     */   } public static short ndmTTOption(long struct) {
/* 513 */     return MemoryUtil.memGetShort(struct + DMTTOPTION);
/*     */   } public static short ndmCollate(long struct) {
/* 515 */     return MemoryUtil.memGetShort(struct + DMCOLLATE);
/*     */   } public static ByteBuffer ndmFormName(long struct) {
/* 517 */     return MemoryUtil.memByteBuffer(struct + DMFORMNAME, 64);
/*     */   } public static String ndmFormNameString(long struct) {
/* 519 */     return MemoryUtil.memUTF16(struct + DMFORMNAME);
/*     */   } public static short ndmLogPixels(long struct) {
/* 521 */     return MemoryUtil.memGetShort(struct + DMLOGPIXELS);
/*     */   } public static int ndmBitsPerPel(long struct) {
/* 523 */     return MemoryUtil.memGetInt(struct + DMBITSPERPEL);
/*     */   } public static int ndmPelsWidth(long struct) {
/* 525 */     return MemoryUtil.memGetInt(struct + DMPELSWIDTH);
/*     */   } public static int ndmPelsHeight(long struct) {
/* 527 */     return MemoryUtil.memGetInt(struct + DMPELSHEIGHT);
/*     */   } public static int ndmDisplayFlags(long struct) {
/* 529 */     return MemoryUtil.memGetInt(struct + DMDISPLAYFLAGS);
/*     */   } public static int ndmNup(long struct) {
/* 531 */     return MemoryUtil.memGetInt(struct + DMNUP);
/*     */   } public static int ndmDisplayFrequency(long struct) {
/* 533 */     return MemoryUtil.memGetInt(struct + DMDISPLAYFREQUENCY);
/*     */   } public static int ndmICMMethod(long struct) {
/* 535 */     return MemoryUtil.memGetInt(struct + DMICMMETHOD);
/*     */   } public static int ndmICMIntent(long struct) {
/* 537 */     return MemoryUtil.memGetInt(struct + DMICMINTENT);
/*     */   } public static int ndmMediaType(long struct) {
/* 539 */     return MemoryUtil.memGetInt(struct + DMMEDIATYPE);
/*     */   } public static int ndmDitherType(long struct) {
/* 541 */     return MemoryUtil.memGetInt(struct + DMDITHERTYPE);
/*     */   } public static int ndmReserved1(long struct) {
/* 543 */     return MemoryUtil.memGetInt(struct + DMRESERVED1);
/*     */   } public static int ndmReserved2(long struct) {
/* 545 */     return MemoryUtil.memGetInt(struct + DMRESERVED2);
/*     */   } public static int ndmPanningWidth(long struct) {
/* 547 */     return MemoryUtil.memGetInt(struct + DMPANNINGWIDTH);
/*     */   } public static int ndmPanningHeight(long struct) {
/* 549 */     return MemoryUtil.memGetInt(struct + DMPANNINGHEIGHT);
/*     */   }
/*     */   public static void ndmSpecVersion(long struct, short value) {
/* 552 */     MemoryUtil.memPutShort(struct + DMSPECVERSION, value);
/*     */   } public static void ndmSize(long struct, short value) {
/* 554 */     MemoryUtil.memPutShort(struct + DMSIZE, value);
/*     */   } public static void ndmDriverExtra(long struct, short value) {
/* 556 */     MemoryUtil.memPutShort(struct + DMDRIVEREXTRA, value);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<DEVMODE, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 563 */     private static final DEVMODE ELEMENT_FACTORY = DEVMODE.create(-1L);
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
/* 575 */       super(container, container.remaining() / DEVMODE.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 579 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 583 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 588 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 593 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected DEVMODE getElementFactory() {
/* 598 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("TCHAR[32]")
/*     */     public ByteBuffer dmDeviceName() {
/* 603 */       return DEVMODE.ndmDeviceName(address());
/*     */     } @NativeType("TCHAR[32]")
/*     */     public String dmDeviceNameString() {
/* 606 */       return DEVMODE.ndmDeviceNameString(address());
/*     */     } @NativeType("WORD")
/*     */     public short dmSpecVersion() {
/* 609 */       return DEVMODE.ndmSpecVersion(address());
/*     */     } @NativeType("WORD")
/*     */     public short dmDriverVersion() {
/* 612 */       return DEVMODE.ndmDriverVersion(address());
/*     */     } @NativeType("WORD")
/*     */     public short dmSize() {
/* 615 */       return DEVMODE.ndmSize(address());
/*     */     } @NativeType("WORD")
/*     */     public short dmDriverExtra() {
/* 618 */       return DEVMODE.ndmDriverExtra(address());
/*     */     } @NativeType("DWORD")
/*     */     public int dmFields() {
/* 621 */       return DEVMODE.ndmFields(address());
/*     */     } public short dmOrientation() {
/* 623 */       return DEVMODE.ndmOrientation(address());
/*     */     } public short dmPaperSize() {
/* 625 */       return DEVMODE.ndmPaperSize(address());
/*     */     } public short dmPaperLength() {
/* 627 */       return DEVMODE.ndmPaperLength(address());
/*     */     } public short dmPaperWidth() {
/* 629 */       return DEVMODE.ndmPaperWidth(address());
/*     */     } public short dmScale() {
/* 631 */       return DEVMODE.ndmScale(address());
/*     */     } public short dmCopies() {
/* 633 */       return DEVMODE.ndmCopies(address());
/*     */     } public short dmDefaultSource() {
/* 635 */       return DEVMODE.ndmDefaultSource(address());
/*     */     } public short dmPrintQuality() {
/* 637 */       return DEVMODE.ndmPrintQuality(address());
/*     */     } public POINTL dmPosition() {
/* 639 */       return DEVMODE.ndmPosition(address());
/*     */     } @NativeType("DWORD")
/*     */     public int dmDisplayOrientation() {
/* 642 */       return DEVMODE.ndmDisplayOrientation(address());
/*     */     } @NativeType("DWORD")
/*     */     public int dmDisplayFixedOutput() {
/* 645 */       return DEVMODE.ndmDisplayFixedOutput(address());
/*     */     } public short dmColor() {
/* 647 */       return DEVMODE.ndmColor(address());
/*     */     } public short dmDuplex() {
/* 649 */       return DEVMODE.ndmDuplex(address());
/*     */     } public short dmYResolution() {
/* 651 */       return DEVMODE.ndmYResolution(address());
/*     */     } public short dmTTOption() {
/* 653 */       return DEVMODE.ndmTTOption(address());
/*     */     } public short dmCollate() {
/* 655 */       return DEVMODE.ndmCollate(address());
/*     */     } @NativeType("TCHAR[32]")
/*     */     public ByteBuffer dmFormName() {
/* 658 */       return DEVMODE.ndmFormName(address());
/*     */     } @NativeType("TCHAR[32]")
/*     */     public String dmFormNameString() {
/* 661 */       return DEVMODE.ndmFormNameString(address());
/*     */     } @NativeType("WORD")
/*     */     public short dmLogPixels() {
/* 664 */       return DEVMODE.ndmLogPixels(address());
/*     */     } @NativeType("DWORD")
/*     */     public int dmBitsPerPel() {
/* 667 */       return DEVMODE.ndmBitsPerPel(address());
/*     */     } @NativeType("DWORD")
/*     */     public int dmPelsWidth() {
/* 670 */       return DEVMODE.ndmPelsWidth(address());
/*     */     } @NativeType("DWORD")
/*     */     public int dmPelsHeight() {
/* 673 */       return DEVMODE.ndmPelsHeight(address());
/*     */     } @NativeType("DWORD")
/*     */     public int dmDisplayFlags() {
/* 676 */       return DEVMODE.ndmDisplayFlags(address());
/*     */     } @NativeType("DWORD")
/*     */     public int dmNup() {
/* 679 */       return DEVMODE.ndmNup(address());
/*     */     } @NativeType("DWORD")
/*     */     public int dmDisplayFrequency() {
/* 682 */       return DEVMODE.ndmDisplayFrequency(address());
/*     */     } @NativeType("DWORD")
/*     */     public int dmICMMethod() {
/* 685 */       return DEVMODE.ndmICMMethod(address());
/*     */     } @NativeType("DWORD")
/*     */     public int dmICMIntent() {
/* 688 */       return DEVMODE.ndmICMIntent(address());
/*     */     } @NativeType("DWORD")
/*     */     public int dmMediaType() {
/* 691 */       return DEVMODE.ndmMediaType(address());
/*     */     } @NativeType("DWORD")
/*     */     public int dmDitherType() {
/* 694 */       return DEVMODE.ndmDitherType(address());
/*     */     } @NativeType("DWORD")
/*     */     public int dmReserved1() {
/* 697 */       return DEVMODE.ndmReserved1(address());
/*     */     } @NativeType("DWORD")
/*     */     public int dmReserved2() {
/* 700 */       return DEVMODE.ndmReserved2(address());
/*     */     } @NativeType("DWORD")
/*     */     public int dmPanningWidth() {
/* 703 */       return DEVMODE.ndmPanningWidth(address());
/*     */     } @NativeType("DWORD")
/*     */     public int dmPanningHeight() {
/* 706 */       return DEVMODE.ndmPanningHeight(address());
/*     */     }
/*     */     public Buffer dmSpecVersion(@NativeType("WORD") short value) {
/* 709 */       DEVMODE.ndmSpecVersion(address(), value); return this;
/*     */     } public Buffer dmSize(@NativeType("WORD") short value) {
/* 711 */       DEVMODE.ndmSize(address(), value); return this;
/*     */     } public Buffer dmDriverExtra(@NativeType("WORD") short value) {
/* 713 */       DEVMODE.ndmDriverExtra(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\windows\DEVMODE.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */