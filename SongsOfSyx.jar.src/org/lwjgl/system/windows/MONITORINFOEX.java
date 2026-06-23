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
/*     */ public class MONITORINFOEX
/*     */   extends Struct<MONITORINFOEX>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int CBSIZE;
/*     */   public static final int RCMONITOR;
/*     */   public static final int RCWORK;
/*     */   public static final int DWFLAGS;
/*     */   public static final int SZDEVICE;
/*     */   
/*     */   static {
/*  45 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  46 */           __member(4), 
/*  47 */           __member(RECT.SIZEOF, RECT.ALIGNOF), 
/*  48 */           __member(RECT.SIZEOF, RECT.ALIGNOF), 
/*  49 */           __member(4), 
/*  50 */           __array(2, 32)
/*     */         });
/*     */     
/*  53 */     SIZEOF = layout.getSize();
/*  54 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  56 */     CBSIZE = layout.offsetof(0);
/*  57 */     RCMONITOR = layout.offsetof(1);
/*  58 */     RCWORK = layout.offsetof(2);
/*  59 */     DWFLAGS = layout.offsetof(3);
/*  60 */     SZDEVICE = layout.offsetof(4);
/*     */   }
/*     */   
/*     */   protected MONITORINFOEX(long address, ByteBuffer container) {
/*  64 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected MONITORINFOEX create(long address, ByteBuffer container) {
/*  69 */     return new MONITORINFOEX(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MONITORINFOEX(ByteBuffer container) {
/*  79 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  83 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("DWORD")
/*     */   public int cbSize() {
/*  87 */     return ncbSize(address());
/*     */   } public RECT rcMonitor() {
/*  89 */     return nrcMonitor(address());
/*     */   } public RECT rcWork() {
/*  91 */     return nrcWork(address());
/*     */   } @NativeType("DWORD")
/*     */   public int dwFlags() {
/*  94 */     return ndwFlags(address());
/*     */   } @NativeType("TCHAR[32]")
/*     */   public ByteBuffer szDevice() {
/*  97 */     return nszDevice(address());
/*     */   } @NativeType("TCHAR[32]")
/*     */   public String szDeviceString() {
/* 100 */     return nszDeviceString(address());
/*     */   }
/*     */   public MONITORINFOEX cbSize(@NativeType("DWORD") int value) {
/* 103 */     ncbSize(address(), value); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MONITORINFOEX set(MONITORINFOEX src) {
/* 113 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 114 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static MONITORINFOEX malloc() {
/* 121 */     return new MONITORINFOEX(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static MONITORINFOEX calloc() {
/* 126 */     return new MONITORINFOEX(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static MONITORINFOEX create() {
/* 131 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 132 */     return new MONITORINFOEX(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static MONITORINFOEX create(long address) {
/* 137 */     return new MONITORINFOEX(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static MONITORINFOEX createSafe(long address) {
/* 142 */     return (address == 0L) ? null : new MONITORINFOEX(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 151 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 160 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 169 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 170 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 180 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 185 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static MONITORINFOEX malloc(MemoryStack stack) {
/* 194 */     return new MONITORINFOEX(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static MONITORINFOEX calloc(MemoryStack stack) {
/* 203 */     return new MONITORINFOEX(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 213 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 223 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int ncbSize(long struct) {
/* 229 */     return MemoryUtil.memGetInt(struct + CBSIZE);
/*     */   } public static RECT nrcMonitor(long struct) {
/* 231 */     return RECT.create(struct + RCMONITOR);
/*     */   } public static RECT nrcWork(long struct) {
/* 233 */     return RECT.create(struct + RCWORK);
/*     */   } public static int ndwFlags(long struct) {
/* 235 */     return MemoryUtil.memGetInt(struct + DWFLAGS);
/*     */   } public static ByteBuffer nszDevice(long struct) {
/* 237 */     return MemoryUtil.memByteBuffer(struct + SZDEVICE, 64);
/*     */   } public static String nszDeviceString(long struct) {
/* 239 */     return MemoryUtil.memUTF16(struct + SZDEVICE);
/*     */   }
/*     */   public static void ncbSize(long struct, int value) {
/* 242 */     MemoryUtil.memPutInt(struct + CBSIZE, value);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<MONITORINFOEX, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 249 */     private static final MONITORINFOEX ELEMENT_FACTORY = MONITORINFOEX.create(-1L);
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
/* 261 */       super(container, container.remaining() / MONITORINFOEX.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 265 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 269 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 274 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 279 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected MONITORINFOEX getElementFactory() {
/* 284 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("DWORD")
/*     */     public int cbSize() {
/* 289 */       return MONITORINFOEX.ncbSize(address());
/*     */     } public RECT rcMonitor() {
/* 291 */       return MONITORINFOEX.nrcMonitor(address());
/*     */     } public RECT rcWork() {
/* 293 */       return MONITORINFOEX.nrcWork(address());
/*     */     } @NativeType("DWORD")
/*     */     public int dwFlags() {
/* 296 */       return MONITORINFOEX.ndwFlags(address());
/*     */     } @NativeType("TCHAR[32]")
/*     */     public ByteBuffer szDevice() {
/* 299 */       return MONITORINFOEX.nszDevice(address());
/*     */     } @NativeType("TCHAR[32]")
/*     */     public String szDeviceString() {
/* 302 */       return MONITORINFOEX.nszDeviceString(address());
/*     */     }
/*     */     public Buffer cbSize(@NativeType("DWORD") int value) {
/* 305 */       MONITORINFOEX.ncbSize(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\windows\MONITORINFOEX.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */