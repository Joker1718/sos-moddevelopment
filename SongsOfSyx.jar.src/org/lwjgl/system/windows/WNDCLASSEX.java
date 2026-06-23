/*     */ package org.lwjgl.system.windows;
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
/*     */ 
/*     */ 
/*     */ public class WNDCLASSEX
/*     */   extends Struct<WNDCLASSEX>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int CBSIZE;
/*     */   public static final int STYLE;
/*     */   public static final int LPFNWNDPROC;
/*     */   public static final int CBCLSEXTRA;
/*     */   public static final int CBWNDEXTRA;
/*     */   public static final int HINSTANCE;
/*     */   public static final int HICON;
/*     */   public static final int HCURSOR;
/*     */   public static final int HBRBACKGROUND;
/*     */   public static final int LPSZMENUNAME;
/*     */   public static final int LPSZCLASSNAME;
/*     */   public static final int HICONSM;
/*     */   
/*     */   static {
/*  60 */     Struct.Layout layout = __struct(new Struct.Member[] { 
/*  61 */           __member(4), 
/*  62 */           __member(4), 
/*  63 */           __member(POINTER_SIZE), 
/*  64 */           __member(4), 
/*  65 */           __member(4), 
/*  66 */           __member(POINTER_SIZE), 
/*  67 */           __member(POINTER_SIZE), 
/*  68 */           __member(POINTER_SIZE), 
/*  69 */           __member(POINTER_SIZE), 
/*  70 */           __member(POINTER_SIZE), 
/*  71 */           __member(POINTER_SIZE), 
/*  72 */           __member(POINTER_SIZE) });
/*     */ 
/*     */     
/*  75 */     SIZEOF = layout.getSize();
/*  76 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  78 */     CBSIZE = layout.offsetof(0);
/*  79 */     STYLE = layout.offsetof(1);
/*  80 */     LPFNWNDPROC = layout.offsetof(2);
/*  81 */     CBCLSEXTRA = layout.offsetof(3);
/*  82 */     CBWNDEXTRA = layout.offsetof(4);
/*  83 */     HINSTANCE = layout.offsetof(5);
/*  84 */     HICON = layout.offsetof(6);
/*  85 */     HCURSOR = layout.offsetof(7);
/*  86 */     HBRBACKGROUND = layout.offsetof(8);
/*  87 */     LPSZMENUNAME = layout.offsetof(9);
/*  88 */     LPSZCLASSNAME = layout.offsetof(10);
/*  89 */     HICONSM = layout.offsetof(11);
/*     */   }
/*     */   
/*     */   protected WNDCLASSEX(long address, ByteBuffer container) {
/*  93 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected WNDCLASSEX create(long address, ByteBuffer container) {
/*  98 */     return new WNDCLASSEX(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public WNDCLASSEX(ByteBuffer container) {
/* 108 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/* 112 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("UINT")
/*     */   public int cbSize() {
/* 116 */     return ncbSize(address());
/*     */   } @NativeType("UINT")
/*     */   public int style() {
/* 119 */     return nstyle(address());
/*     */   } @NativeType("WNDPROC")
/*     */   public WindowProc lpfnWndProc() {
/* 122 */     return nlpfnWndProc(address());
/*     */   } public int cbClsExtra() {
/* 124 */     return ncbClsExtra(address());
/*     */   } public int cbWndExtra() {
/* 126 */     return ncbWndExtra(address());
/*     */   } @NativeType("HINSTANCE")
/*     */   public long hInstance() {
/* 129 */     return nhInstance(address());
/*     */   } @NativeType("HICON")
/*     */   public long hIcon() {
/* 132 */     return nhIcon(address());
/*     */   } @NativeType("HCURSOR")
/*     */   public long hCursor() {
/* 135 */     return nhCursor(address());
/*     */   } @NativeType("HBRUSH")
/*     */   public long hbrBackground() {
/* 138 */     return nhbrBackground(address());
/*     */   } @NativeType("LPCTSTR")
/*     */   public ByteBuffer lpszMenuName() {
/* 141 */     return nlpszMenuName(address());
/*     */   } @NativeType("LPCTSTR")
/*     */   public String lpszMenuNameString() {
/* 144 */     return nlpszMenuNameString(address());
/*     */   } @NativeType("LPCTSTR")
/*     */   public ByteBuffer lpszClassName() {
/* 147 */     return nlpszClassName(address());
/*     */   } @NativeType("LPCTSTR")
/*     */   public String lpszClassNameString() {
/* 150 */     return nlpszClassNameString(address());
/*     */   } @NativeType("HICON")
/*     */   public long hIconSm() {
/* 153 */     return nhIconSm(address());
/*     */   }
/*     */   public WNDCLASSEX cbSize(@NativeType("UINT") int value) {
/* 156 */     ncbSize(address(), value); return this;
/*     */   } public WNDCLASSEX style(@NativeType("UINT") int value) {
/* 158 */     nstyle(address(), value); return this;
/*     */   } public WNDCLASSEX lpfnWndProc(@NativeType("WNDPROC") WindowProcI value) {
/* 160 */     nlpfnWndProc(address(), value); return this;
/*     */   } public WNDCLASSEX cbClsExtra(int value) {
/* 162 */     ncbClsExtra(address(), value); return this;
/*     */   } public WNDCLASSEX cbWndExtra(int value) {
/* 164 */     ncbWndExtra(address(), value); return this;
/*     */   } public WNDCLASSEX hInstance(@NativeType("HINSTANCE") long value) {
/* 166 */     nhInstance(address(), value); return this;
/*     */   } public WNDCLASSEX hIcon(@NativeType("HICON") long value) {
/* 168 */     nhIcon(address(), value); return this;
/*     */   } public WNDCLASSEX hCursor(@NativeType("HCURSOR") long value) {
/* 170 */     nhCursor(address(), value); return this;
/*     */   } public WNDCLASSEX hbrBackground(@NativeType("HBRUSH") long value) {
/* 172 */     nhbrBackground(address(), value); return this;
/*     */   } public WNDCLASSEX lpszMenuName(@NativeType("LPCTSTR") ByteBuffer value) {
/* 174 */     nlpszMenuName(address(), value); return this;
/*     */   } public WNDCLASSEX lpszClassName(@NativeType("LPCTSTR") ByteBuffer value) {
/* 176 */     nlpszClassName(address(), value); return this;
/*     */   } public WNDCLASSEX hIconSm(@NativeType("HICON") long value) {
/* 178 */     nhIconSm(address(), value); return this;
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
/*     */   public WNDCLASSEX set(int cbSize, int style, WindowProcI lpfnWndProc, int cbClsExtra, int cbWndExtra, long hInstance, long hIcon, long hCursor, long hbrBackground, ByteBuffer lpszMenuName, ByteBuffer lpszClassName, long hIconSm) {
/* 195 */     cbSize(cbSize);
/* 196 */     style(style);
/* 197 */     lpfnWndProc(lpfnWndProc);
/* 198 */     cbClsExtra(cbClsExtra);
/* 199 */     cbWndExtra(cbWndExtra);
/* 200 */     hInstance(hInstance);
/* 201 */     hIcon(hIcon);
/* 202 */     hCursor(hCursor);
/* 203 */     hbrBackground(hbrBackground);
/* 204 */     lpszMenuName(lpszMenuName);
/* 205 */     lpszClassName(lpszClassName);
/* 206 */     hIconSm(hIconSm);
/*     */     
/* 208 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public WNDCLASSEX set(WNDCLASSEX src) {
/* 219 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 220 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static WNDCLASSEX malloc() {
/* 227 */     return new WNDCLASSEX(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static WNDCLASSEX calloc() {
/* 232 */     return new WNDCLASSEX(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static WNDCLASSEX create() {
/* 237 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 238 */     return new WNDCLASSEX(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static WNDCLASSEX create(long address) {
/* 243 */     return new WNDCLASSEX(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static WNDCLASSEX createSafe(long address) {
/* 248 */     return (address == 0L) ? null : new WNDCLASSEX(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 257 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 266 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 275 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 276 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 286 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 291 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static WNDCLASSEX malloc(MemoryStack stack) {
/* 300 */     return new WNDCLASSEX(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static WNDCLASSEX calloc(MemoryStack stack) {
/* 309 */     return new WNDCLASSEX(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 319 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 329 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int ncbSize(long struct) {
/* 335 */     return MemoryUtil.memGetInt(struct + CBSIZE);
/*     */   } public static int nstyle(long struct) {
/* 337 */     return MemoryUtil.memGetInt(struct + STYLE);
/*     */   } public static WindowProc nlpfnWndProc(long struct) {
/* 339 */     return WindowProc.create(MemoryUtil.memGetAddress(struct + LPFNWNDPROC));
/*     */   } public static int ncbClsExtra(long struct) {
/* 341 */     return MemoryUtil.memGetInt(struct + CBCLSEXTRA);
/*     */   } public static int ncbWndExtra(long struct) {
/* 343 */     return MemoryUtil.memGetInt(struct + CBWNDEXTRA);
/*     */   } public static long nhInstance(long struct) {
/* 345 */     return MemoryUtil.memGetAddress(struct + HINSTANCE);
/*     */   } public static long nhIcon(long struct) {
/* 347 */     return MemoryUtil.memGetAddress(struct + HICON);
/*     */   } public static long nhCursor(long struct) {
/* 349 */     return MemoryUtil.memGetAddress(struct + HCURSOR);
/*     */   } public static long nhbrBackground(long struct) {
/* 351 */     return MemoryUtil.memGetAddress(struct + HBRBACKGROUND);
/*     */   } public static ByteBuffer nlpszMenuName(long struct) {
/* 353 */     return MemoryUtil.memByteBufferNT2Safe(MemoryUtil.memGetAddress(struct + LPSZMENUNAME));
/*     */   } public static String nlpszMenuNameString(long struct) {
/* 355 */     return MemoryUtil.memUTF16Safe(MemoryUtil.memGetAddress(struct + LPSZMENUNAME));
/*     */   } public static ByteBuffer nlpszClassName(long struct) {
/* 357 */     return MemoryUtil.memByteBufferNT2(MemoryUtil.memGetAddress(struct + LPSZCLASSNAME));
/*     */   } public static String nlpszClassNameString(long struct) {
/* 359 */     return MemoryUtil.memUTF16(MemoryUtil.memGetAddress(struct + LPSZCLASSNAME));
/*     */   } public static long nhIconSm(long struct) {
/* 361 */     return MemoryUtil.memGetAddress(struct + HICONSM);
/*     */   }
/*     */   public static void ncbSize(long struct, int value) {
/* 364 */     MemoryUtil.memPutInt(struct + CBSIZE, value);
/*     */   } public static void nstyle(long struct, int value) {
/* 366 */     MemoryUtil.memPutInt(struct + STYLE, value);
/*     */   } public static void nlpfnWndProc(long struct, WindowProcI value) {
/* 368 */     MemoryUtil.memPutAddress(struct + LPFNWNDPROC, value.address());
/*     */   } public static void ncbClsExtra(long struct, int value) {
/* 370 */     MemoryUtil.memPutInt(struct + CBCLSEXTRA, value);
/*     */   } public static void ncbWndExtra(long struct, int value) {
/* 372 */     MemoryUtil.memPutInt(struct + CBWNDEXTRA, value);
/*     */   } public static void nhInstance(long struct, long value) {
/* 374 */     MemoryUtil.memPutAddress(struct + HINSTANCE, value);
/*     */   } public static void nhIcon(long struct, long value) {
/* 376 */     MemoryUtil.memPutAddress(struct + HICON, value);
/*     */   } public static void nhCursor(long struct, long value) {
/* 378 */     MemoryUtil.memPutAddress(struct + HCURSOR, value);
/*     */   } public static void nhbrBackground(long struct, long value) {
/* 380 */     MemoryUtil.memPutAddress(struct + HBRBACKGROUND, value);
/*     */   }
/*     */   public static void nlpszMenuName(long struct, ByteBuffer value) {
/* 383 */     if (Checks.CHECKS) Checks.checkNT2Safe(value); 
/* 384 */     MemoryUtil.memPutAddress(struct + LPSZMENUNAME, MemoryUtil.memAddressSafe(value));
/*     */   }
/*     */   
/*     */   public static void nlpszClassName(long struct, ByteBuffer value) {
/* 388 */     if (Checks.CHECKS) Checks.checkNT2(value); 
/* 389 */     MemoryUtil.memPutAddress(struct + LPSZCLASSNAME, MemoryUtil.memAddress(value));
/*     */   }
/*     */   public static void nhIconSm(long struct, long value) {
/* 392 */     MemoryUtil.memPutAddress(struct + HICONSM, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long struct) {
/* 400 */     Checks.check(MemoryUtil.memGetAddress(struct + LPFNWNDPROC));
/* 401 */     Checks.check(MemoryUtil.memGetAddress(struct + LPSZCLASSNAME));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<WNDCLASSEX, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 409 */     private static final WNDCLASSEX ELEMENT_FACTORY = WNDCLASSEX.create(-1L);
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
/* 421 */       super(container, container.remaining() / WNDCLASSEX.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 425 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 429 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 434 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 439 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected WNDCLASSEX getElementFactory() {
/* 444 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("UINT")
/*     */     public int cbSize() {
/* 449 */       return WNDCLASSEX.ncbSize(address());
/*     */     } @NativeType("UINT")
/*     */     public int style() {
/* 452 */       return WNDCLASSEX.nstyle(address());
/*     */     } @NativeType("WNDPROC")
/*     */     public WindowProc lpfnWndProc() {
/* 455 */       return WNDCLASSEX.nlpfnWndProc(address());
/*     */     } public int cbClsExtra() {
/* 457 */       return WNDCLASSEX.ncbClsExtra(address());
/*     */     } public int cbWndExtra() {
/* 459 */       return WNDCLASSEX.ncbWndExtra(address());
/*     */     } @NativeType("HINSTANCE")
/*     */     public long hInstance() {
/* 462 */       return WNDCLASSEX.nhInstance(address());
/*     */     } @NativeType("HICON")
/*     */     public long hIcon() {
/* 465 */       return WNDCLASSEX.nhIcon(address());
/*     */     } @NativeType("HCURSOR")
/*     */     public long hCursor() {
/* 468 */       return WNDCLASSEX.nhCursor(address());
/*     */     } @NativeType("HBRUSH")
/*     */     public long hbrBackground() {
/* 471 */       return WNDCLASSEX.nhbrBackground(address());
/*     */     } @NativeType("LPCTSTR")
/*     */     public ByteBuffer lpszMenuName() {
/* 474 */       return WNDCLASSEX.nlpszMenuName(address());
/*     */     } @NativeType("LPCTSTR")
/*     */     public String lpszMenuNameString() {
/* 477 */       return WNDCLASSEX.nlpszMenuNameString(address());
/*     */     } @NativeType("LPCTSTR")
/*     */     public ByteBuffer lpszClassName() {
/* 480 */       return WNDCLASSEX.nlpszClassName(address());
/*     */     } @NativeType("LPCTSTR")
/*     */     public String lpszClassNameString() {
/* 483 */       return WNDCLASSEX.nlpszClassNameString(address());
/*     */     } @NativeType("HICON")
/*     */     public long hIconSm() {
/* 486 */       return WNDCLASSEX.nhIconSm(address());
/*     */     }
/*     */     public Buffer cbSize(@NativeType("UINT") int value) {
/* 489 */       WNDCLASSEX.ncbSize(address(), value); return this;
/*     */     } public Buffer style(@NativeType("UINT") int value) {
/* 491 */       WNDCLASSEX.nstyle(address(), value); return this;
/*     */     } public Buffer lpfnWndProc(@NativeType("WNDPROC") WindowProcI value) {
/* 493 */       WNDCLASSEX.nlpfnWndProc(address(), value); return this;
/*     */     } public Buffer cbClsExtra(int value) {
/* 495 */       WNDCLASSEX.ncbClsExtra(address(), value); return this;
/*     */     } public Buffer cbWndExtra(int value) {
/* 497 */       WNDCLASSEX.ncbWndExtra(address(), value); return this;
/*     */     } public Buffer hInstance(@NativeType("HINSTANCE") long value) {
/* 499 */       WNDCLASSEX.nhInstance(address(), value); return this;
/*     */     } public Buffer hIcon(@NativeType("HICON") long value) {
/* 501 */       WNDCLASSEX.nhIcon(address(), value); return this;
/*     */     } public Buffer hCursor(@NativeType("HCURSOR") long value) {
/* 503 */       WNDCLASSEX.nhCursor(address(), value); return this;
/*     */     } public Buffer hbrBackground(@NativeType("HBRUSH") long value) {
/* 505 */       WNDCLASSEX.nhbrBackground(address(), value); return this;
/*     */     } public Buffer lpszMenuName(@NativeType("LPCTSTR") ByteBuffer value) {
/* 507 */       WNDCLASSEX.nlpszMenuName(address(), value); return this;
/*     */     } public Buffer lpszClassName(@NativeType("LPCTSTR") ByteBuffer value) {
/* 509 */       WNDCLASSEX.nlpszClassName(address(), value); return this;
/*     */     } public Buffer hIconSm(@NativeType("HICON") long value) {
/* 511 */       WNDCLASSEX.nhIconSm(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\windows\WNDCLASSEX.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */