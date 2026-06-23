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
/*     */ public class MOUSEINPUT
/*     */   extends Struct<MOUSEINPUT>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int DX;
/*     */   public static final int DY;
/*     */   public static final int MOUSEDATA;
/*     */   public static final int DWFLAGS;
/*     */   public static final int TIME;
/*     */   public static final int DWEXTRAINFO;
/*     */   
/*     */   static {
/*  47 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  48 */           __member(4), 
/*  49 */           __member(4), 
/*  50 */           __member(4), 
/*  51 */           __member(4), 
/*  52 */           __member(4), 
/*  53 */           __member(POINTER_SIZE)
/*     */         });
/*     */     
/*  56 */     SIZEOF = layout.getSize();
/*  57 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  59 */     DX = layout.offsetof(0);
/*  60 */     DY = layout.offsetof(1);
/*  61 */     MOUSEDATA = layout.offsetof(2);
/*  62 */     DWFLAGS = layout.offsetof(3);
/*  63 */     TIME = layout.offsetof(4);
/*  64 */     DWEXTRAINFO = layout.offsetof(5);
/*     */   }
/*     */   
/*     */   protected MOUSEINPUT(long address, ByteBuffer container) {
/*  68 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected MOUSEINPUT create(long address, ByteBuffer container) {
/*  73 */     return new MOUSEINPUT(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MOUSEINPUT(ByteBuffer container) {
/*  83 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  87 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("LONG")
/*     */   public int dx() {
/*  91 */     return ndx(address());
/*     */   } @NativeType("LONG")
/*     */   public int dy() {
/*  94 */     return ndy(address());
/*     */   } @NativeType("DWORD")
/*     */   public int mouseData() {
/*  97 */     return nmouseData(address());
/*     */   } @NativeType("DWORD")
/*     */   public int dwFlags() {
/* 100 */     return ndwFlags(address());
/*     */   } @NativeType("DWORD")
/*     */   public int time() {
/* 103 */     return ntime(address());
/*     */   } @NativeType("ULONG_PTR")
/*     */   public long dwExtraInfo() {
/* 106 */     return ndwExtraInfo(address());
/*     */   }
/*     */   public MOUSEINPUT dx(@NativeType("LONG") int value) {
/* 109 */     ndx(address(), value); return this;
/*     */   } public MOUSEINPUT dy(@NativeType("LONG") int value) {
/* 111 */     ndy(address(), value); return this;
/*     */   } public MOUSEINPUT mouseData(@NativeType("DWORD") int value) {
/* 113 */     nmouseData(address(), value); return this;
/*     */   } public MOUSEINPUT dwFlags(@NativeType("DWORD") int value) {
/* 115 */     ndwFlags(address(), value); return this;
/*     */   } public MOUSEINPUT time(@NativeType("DWORD") int value) {
/* 117 */     ntime(address(), value); return this;
/*     */   } public MOUSEINPUT dwExtraInfo(@NativeType("ULONG_PTR") long value) {
/* 119 */     ndwExtraInfo(address(), value); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MOUSEINPUT set(int dx, int dy, int mouseData, int dwFlags, int time, long dwExtraInfo) {
/* 130 */     dx(dx);
/* 131 */     dy(dy);
/* 132 */     mouseData(mouseData);
/* 133 */     dwFlags(dwFlags);
/* 134 */     time(time);
/* 135 */     dwExtraInfo(dwExtraInfo);
/*     */     
/* 137 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MOUSEINPUT set(MOUSEINPUT src) {
/* 148 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 149 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static MOUSEINPUT malloc() {
/* 156 */     return new MOUSEINPUT(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static MOUSEINPUT calloc() {
/* 161 */     return new MOUSEINPUT(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static MOUSEINPUT create() {
/* 166 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 167 */     return new MOUSEINPUT(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static MOUSEINPUT create(long address) {
/* 172 */     return new MOUSEINPUT(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static MOUSEINPUT createSafe(long address) {
/* 177 */     return (address == 0L) ? null : new MOUSEINPUT(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 186 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 195 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 204 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 205 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 215 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 220 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static MOUSEINPUT malloc(MemoryStack stack) {
/* 229 */     return new MOUSEINPUT(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static MOUSEINPUT calloc(MemoryStack stack) {
/* 238 */     return new MOUSEINPUT(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 248 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 258 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int ndx(long struct) {
/* 264 */     return MemoryUtil.memGetInt(struct + DX);
/*     */   } public static int ndy(long struct) {
/* 266 */     return MemoryUtil.memGetInt(struct + DY);
/*     */   } public static int nmouseData(long struct) {
/* 268 */     return MemoryUtil.memGetInt(struct + MOUSEDATA);
/*     */   } public static int ndwFlags(long struct) {
/* 270 */     return MemoryUtil.memGetInt(struct + DWFLAGS);
/*     */   } public static int ntime(long struct) {
/* 272 */     return MemoryUtil.memGetInt(struct + TIME);
/*     */   } public static long ndwExtraInfo(long struct) {
/* 274 */     return MemoryUtil.memGetAddress(struct + DWEXTRAINFO);
/*     */   }
/*     */   public static void ndx(long struct, int value) {
/* 277 */     MemoryUtil.memPutInt(struct + DX, value);
/*     */   } public static void ndy(long struct, int value) {
/* 279 */     MemoryUtil.memPutInt(struct + DY, value);
/*     */   } public static void nmouseData(long struct, int value) {
/* 281 */     MemoryUtil.memPutInt(struct + MOUSEDATA, value);
/*     */   } public static void ndwFlags(long struct, int value) {
/* 283 */     MemoryUtil.memPutInt(struct + DWFLAGS, value);
/*     */   } public static void ntime(long struct, int value) {
/* 285 */     MemoryUtil.memPutInt(struct + TIME, value);
/*     */   } public static void ndwExtraInfo(long struct, long value) {
/* 287 */     MemoryUtil.memPutAddress(struct + DWEXTRAINFO, value);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<MOUSEINPUT, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 294 */     private static final MOUSEINPUT ELEMENT_FACTORY = MOUSEINPUT.create(-1L);
/*     */ 
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
/* 306 */       super(container, container.remaining() / MOUSEINPUT.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 310 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 314 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 319 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 324 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected MOUSEINPUT getElementFactory() {
/* 329 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("LONG")
/*     */     public int dx() {
/* 334 */       return MOUSEINPUT.ndx(address());
/*     */     } @NativeType("LONG")
/*     */     public int dy() {
/* 337 */       return MOUSEINPUT.ndy(address());
/*     */     } @NativeType("DWORD")
/*     */     public int mouseData() {
/* 340 */       return MOUSEINPUT.nmouseData(address());
/*     */     } @NativeType("DWORD")
/*     */     public int dwFlags() {
/* 343 */       return MOUSEINPUT.ndwFlags(address());
/*     */     } @NativeType("DWORD")
/*     */     public int time() {
/* 346 */       return MOUSEINPUT.ntime(address());
/*     */     } @NativeType("ULONG_PTR")
/*     */     public long dwExtraInfo() {
/* 349 */       return MOUSEINPUT.ndwExtraInfo(address());
/*     */     }
/*     */     public Buffer dx(@NativeType("LONG") int value) {
/* 352 */       MOUSEINPUT.ndx(address(), value); return this;
/*     */     } public Buffer dy(@NativeType("LONG") int value) {
/* 354 */       MOUSEINPUT.ndy(address(), value); return this;
/*     */     } public Buffer mouseData(@NativeType("DWORD") int value) {
/* 356 */       MOUSEINPUT.nmouseData(address(), value); return this;
/*     */     } public Buffer dwFlags(@NativeType("DWORD") int value) {
/* 358 */       MOUSEINPUT.ndwFlags(address(), value); return this;
/*     */     } public Buffer time(@NativeType("DWORD") int value) {
/* 360 */       MOUSEINPUT.ntime(address(), value); return this;
/*     */     } public Buffer dwExtraInfo(@NativeType("ULONG_PTR") long value) {
/* 362 */       MOUSEINPUT.ndwExtraInfo(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\windows\MOUSEINPUT.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */