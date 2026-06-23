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
/*     */ public class TOUCHINPUT
/*     */   extends Struct<TOUCHINPUT>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int X;
/*     */   public static final int Y;
/*     */   public static final int HSOURCE;
/*     */   public static final int DWID;
/*     */   public static final int DWFLAGS;
/*     */   public static final int DWMASK;
/*     */   public static final int DWTIME;
/*     */   public static final int DWEXTRAINFO;
/*     */   public static final int CXCONTACT;
/*     */   public static final int CYCONTACT;
/*     */   
/*     */   static {
/*  55 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  56 */           __member(4), 
/*  57 */           __member(4), 
/*  58 */           __member(POINTER_SIZE), 
/*  59 */           __member(4), 
/*  60 */           __member(4), 
/*  61 */           __member(4), 
/*  62 */           __member(4), 
/*  63 */           __member(POINTER_SIZE), 
/*  64 */           __member(4), 
/*  65 */           __member(4)
/*     */         });
/*     */     
/*  68 */     SIZEOF = layout.getSize();
/*  69 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  71 */     X = layout.offsetof(0);
/*  72 */     Y = layout.offsetof(1);
/*  73 */     HSOURCE = layout.offsetof(2);
/*  74 */     DWID = layout.offsetof(3);
/*  75 */     DWFLAGS = layout.offsetof(4);
/*  76 */     DWMASK = layout.offsetof(5);
/*  77 */     DWTIME = layout.offsetof(6);
/*  78 */     DWEXTRAINFO = layout.offsetof(7);
/*  79 */     CXCONTACT = layout.offsetof(8);
/*  80 */     CYCONTACT = layout.offsetof(9);
/*     */   }
/*     */   
/*     */   protected TOUCHINPUT(long address, ByteBuffer container) {
/*  84 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected TOUCHINPUT create(long address, ByteBuffer container) {
/*  89 */     return new TOUCHINPUT(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TOUCHINPUT(ByteBuffer container) {
/*  99 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/* 103 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("LONG")
/*     */   public int x() {
/* 107 */     return nx(address());
/*     */   } @NativeType("LONG")
/*     */   public int y() {
/* 110 */     return ny(address());
/*     */   } @NativeType("HANDLE")
/*     */   public long hSource() {
/* 113 */     return nhSource(address());
/*     */   } @NativeType("DWORD")
/*     */   public int dwID() {
/* 116 */     return ndwID(address());
/*     */   } @NativeType("DWORD")
/*     */   public int dwFlags() {
/* 119 */     return ndwFlags(address());
/*     */   } @NativeType("DWORD")
/*     */   public int dwMask() {
/* 122 */     return ndwMask(address());
/*     */   } @NativeType("DWORD")
/*     */   public int dwTime() {
/* 125 */     return ndwTime(address());
/*     */   } @NativeType("ULONG_PTR")
/*     */   public long dwExtraInfo() {
/* 128 */     return ndwExtraInfo(address());
/*     */   } @NativeType("DWORD")
/*     */   public int cxContact() {
/* 131 */     return ncxContact(address());
/*     */   } @NativeType("DWORD")
/*     */   public int cyContact() {
/* 134 */     return ncyContact(address());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static TOUCHINPUT malloc() {
/* 140 */     return new TOUCHINPUT(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static TOUCHINPUT calloc() {
/* 145 */     return new TOUCHINPUT(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static TOUCHINPUT create() {
/* 150 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 151 */     return new TOUCHINPUT(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static TOUCHINPUT create(long address) {
/* 156 */     return new TOUCHINPUT(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static TOUCHINPUT createSafe(long address) {
/* 161 */     return (address == 0L) ? null : new TOUCHINPUT(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 170 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 179 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 188 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 189 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 199 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 204 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static TOUCHINPUT malloc(MemoryStack stack) {
/* 213 */     return new TOUCHINPUT(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static TOUCHINPUT calloc(MemoryStack stack) {
/* 222 */     return new TOUCHINPUT(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 232 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 242 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nx(long struct) {
/* 248 */     return MemoryUtil.memGetInt(struct + X);
/*     */   } public static int ny(long struct) {
/* 250 */     return MemoryUtil.memGetInt(struct + Y);
/*     */   } public static long nhSource(long struct) {
/* 252 */     return MemoryUtil.memGetAddress(struct + HSOURCE);
/*     */   } public static int ndwID(long struct) {
/* 254 */     return MemoryUtil.memGetInt(struct + DWID);
/*     */   } public static int ndwFlags(long struct) {
/* 256 */     return MemoryUtil.memGetInt(struct + DWFLAGS);
/*     */   } public static int ndwMask(long struct) {
/* 258 */     return MemoryUtil.memGetInt(struct + DWMASK);
/*     */   } public static int ndwTime(long struct) {
/* 260 */     return MemoryUtil.memGetInt(struct + DWTIME);
/*     */   } public static long ndwExtraInfo(long struct) {
/* 262 */     return MemoryUtil.memGetAddress(struct + DWEXTRAINFO);
/*     */   } public static int ncxContact(long struct) {
/* 264 */     return MemoryUtil.memGetInt(struct + CXCONTACT);
/*     */   } public static int ncyContact(long struct) {
/* 266 */     return MemoryUtil.memGetInt(struct + CYCONTACT);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<TOUCHINPUT, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 273 */     private static final TOUCHINPUT ELEMENT_FACTORY = TOUCHINPUT.create(-1L);
/*     */ 
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
/* 285 */       super(container, container.remaining() / TOUCHINPUT.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 289 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 293 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 298 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 303 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected TOUCHINPUT getElementFactory() {
/* 308 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("LONG")
/*     */     public int x() {
/* 313 */       return TOUCHINPUT.nx(address());
/*     */     } @NativeType("LONG")
/*     */     public int y() {
/* 316 */       return TOUCHINPUT.ny(address());
/*     */     } @NativeType("HANDLE")
/*     */     public long hSource() {
/* 319 */       return TOUCHINPUT.nhSource(address());
/*     */     } @NativeType("DWORD")
/*     */     public int dwID() {
/* 322 */       return TOUCHINPUT.ndwID(address());
/*     */     } @NativeType("DWORD")
/*     */     public int dwFlags() {
/* 325 */       return TOUCHINPUT.ndwFlags(address());
/*     */     } @NativeType("DWORD")
/*     */     public int dwMask() {
/* 328 */       return TOUCHINPUT.ndwMask(address());
/*     */     } @NativeType("DWORD")
/*     */     public int dwTime() {
/* 331 */       return TOUCHINPUT.ndwTime(address());
/*     */     } @NativeType("ULONG_PTR")
/*     */     public long dwExtraInfo() {
/* 334 */       return TOUCHINPUT.ndwExtraInfo(address());
/*     */     } @NativeType("DWORD")
/*     */     public int cxContact() {
/* 337 */       return TOUCHINPUT.ncxContact(address());
/*     */     } @NativeType("DWORD")
/*     */     public int cyContact() {
/* 340 */       return TOUCHINPUT.ncyContact(address());
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\windows\TOUCHINPUT.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */