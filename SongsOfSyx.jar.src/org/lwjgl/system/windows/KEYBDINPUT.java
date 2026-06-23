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
/*     */ public class KEYBDINPUT
/*     */   extends Struct<KEYBDINPUT>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int WVK;
/*     */   public static final int WSCAN;
/*     */   public static final int DWFLAGS;
/*     */   public static final int TIME;
/*     */   public static final int DWEXTRAINFO;
/*     */   
/*     */   static {
/*  45 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  46 */           __member(2), 
/*  47 */           __member(2), 
/*  48 */           __member(4), 
/*  49 */           __member(4), 
/*  50 */           __member(POINTER_SIZE)
/*     */         });
/*     */     
/*  53 */     SIZEOF = layout.getSize();
/*  54 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  56 */     WVK = layout.offsetof(0);
/*  57 */     WSCAN = layout.offsetof(1);
/*  58 */     DWFLAGS = layout.offsetof(2);
/*  59 */     TIME = layout.offsetof(3);
/*  60 */     DWEXTRAINFO = layout.offsetof(4);
/*     */   }
/*     */   
/*     */   protected KEYBDINPUT(long address, ByteBuffer container) {
/*  64 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected KEYBDINPUT create(long address, ByteBuffer container) {
/*  69 */     return new KEYBDINPUT(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public KEYBDINPUT(ByteBuffer container) {
/*  79 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  83 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("WORD")
/*     */   public short wVk() {
/*  87 */     return nwVk(address());
/*     */   } @NativeType("WORD")
/*     */   public short wScan() {
/*  90 */     return nwScan(address());
/*     */   } @NativeType("DWORD")
/*     */   public int dwFlags() {
/*  93 */     return ndwFlags(address());
/*     */   } @NativeType("DWORD")
/*     */   public int time() {
/*  96 */     return ntime(address());
/*     */   } @NativeType("ULONG_PTR")
/*     */   public long dwExtraInfo() {
/*  99 */     return ndwExtraInfo(address());
/*     */   }
/*     */   public KEYBDINPUT wVk(@NativeType("WORD") short value) {
/* 102 */     nwVk(address(), value); return this;
/*     */   } public KEYBDINPUT wScan(@NativeType("WORD") short value) {
/* 104 */     nwScan(address(), value); return this;
/*     */   } public KEYBDINPUT dwFlags(@NativeType("DWORD") int value) {
/* 106 */     ndwFlags(address(), value); return this;
/*     */   } public KEYBDINPUT time(@NativeType("DWORD") int value) {
/* 108 */     ntime(address(), value); return this;
/*     */   } public KEYBDINPUT dwExtraInfo(@NativeType("ULONG_PTR") long value) {
/* 110 */     ndwExtraInfo(address(), value); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public KEYBDINPUT set(short wVk, short wScan, int dwFlags, int time, long dwExtraInfo) {
/* 120 */     wVk(wVk);
/* 121 */     wScan(wScan);
/* 122 */     dwFlags(dwFlags);
/* 123 */     time(time);
/* 124 */     dwExtraInfo(dwExtraInfo);
/*     */     
/* 126 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public KEYBDINPUT set(KEYBDINPUT src) {
/* 137 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 138 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static KEYBDINPUT malloc() {
/* 145 */     return new KEYBDINPUT(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static KEYBDINPUT calloc() {
/* 150 */     return new KEYBDINPUT(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static KEYBDINPUT create() {
/* 155 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 156 */     return new KEYBDINPUT(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static KEYBDINPUT create(long address) {
/* 161 */     return new KEYBDINPUT(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static KEYBDINPUT createSafe(long address) {
/* 166 */     return (address == 0L) ? null : new KEYBDINPUT(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 175 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 184 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 193 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 194 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 204 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 209 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static KEYBDINPUT malloc(MemoryStack stack) {
/* 218 */     return new KEYBDINPUT(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static KEYBDINPUT calloc(MemoryStack stack) {
/* 227 */     return new KEYBDINPUT(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 237 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 247 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static short nwVk(long struct) {
/* 253 */     return MemoryUtil.memGetShort(struct + WVK);
/*     */   } public static short nwScan(long struct) {
/* 255 */     return MemoryUtil.memGetShort(struct + WSCAN);
/*     */   } public static int ndwFlags(long struct) {
/* 257 */     return MemoryUtil.memGetInt(struct + DWFLAGS);
/*     */   } public static int ntime(long struct) {
/* 259 */     return MemoryUtil.memGetInt(struct + TIME);
/*     */   } public static long ndwExtraInfo(long struct) {
/* 261 */     return MemoryUtil.memGetAddress(struct + DWEXTRAINFO);
/*     */   }
/*     */   public static void nwVk(long struct, short value) {
/* 264 */     MemoryUtil.memPutShort(struct + WVK, value);
/*     */   } public static void nwScan(long struct, short value) {
/* 266 */     MemoryUtil.memPutShort(struct + WSCAN, value);
/*     */   } public static void ndwFlags(long struct, int value) {
/* 268 */     MemoryUtil.memPutInt(struct + DWFLAGS, value);
/*     */   } public static void ntime(long struct, int value) {
/* 270 */     MemoryUtil.memPutInt(struct + TIME, value);
/*     */   } public static void ndwExtraInfo(long struct, long value) {
/* 272 */     MemoryUtil.memPutAddress(struct + DWEXTRAINFO, value);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<KEYBDINPUT, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 279 */     private static final KEYBDINPUT ELEMENT_FACTORY = KEYBDINPUT.create(-1L);
/*     */ 
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
/* 291 */       super(container, container.remaining() / KEYBDINPUT.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 295 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 299 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 304 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 309 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected KEYBDINPUT getElementFactory() {
/* 314 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("WORD")
/*     */     public short wVk() {
/* 319 */       return KEYBDINPUT.nwVk(address());
/*     */     } @NativeType("WORD")
/*     */     public short wScan() {
/* 322 */       return KEYBDINPUT.nwScan(address());
/*     */     } @NativeType("DWORD")
/*     */     public int dwFlags() {
/* 325 */       return KEYBDINPUT.ndwFlags(address());
/*     */     } @NativeType("DWORD")
/*     */     public int time() {
/* 328 */       return KEYBDINPUT.ntime(address());
/*     */     } @NativeType("ULONG_PTR")
/*     */     public long dwExtraInfo() {
/* 331 */       return KEYBDINPUT.ndwExtraInfo(address());
/*     */     }
/*     */     public Buffer wVk(@NativeType("WORD") short value) {
/* 334 */       KEYBDINPUT.nwVk(address(), value); return this;
/*     */     } public Buffer wScan(@NativeType("WORD") short value) {
/* 336 */       KEYBDINPUT.nwScan(address(), value); return this;
/*     */     } public Buffer dwFlags(@NativeType("DWORD") int value) {
/* 338 */       KEYBDINPUT.ndwFlags(address(), value); return this;
/*     */     } public Buffer time(@NativeType("DWORD") int value) {
/* 340 */       KEYBDINPUT.ntime(address(), value); return this;
/*     */     } public Buffer dwExtraInfo(@NativeType("ULONG_PTR") long value) {
/* 342 */       KEYBDINPUT.ndwExtraInfo(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\windows\KEYBDINPUT.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */