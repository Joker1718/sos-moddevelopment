/*     */ package org.lwjgl.system.jawt;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import org.lwjgl.system.CustomBuffer;
/*     */ import org.lwjgl.system.MemoryUtil;
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
/*     */ @NativeType("struct JAWT_Win32DrawingSurfaceInfo")
/*     */ public class JAWTWin32DrawingSurfaceInfo
/*     */   extends Struct<JAWTWin32DrawingSurfaceInfo>
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int HWND;
/*     */   public static final int HBITMAP;
/*     */   public static final int PBITS;
/*     */   public static final int HDC;
/*     */   public static final int HPALETTE;
/*     */   
/*     */   static {
/*  48 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  49 */           (Struct.Member)__union(new Struct.Member[] {
/*  50 */               __member(POINTER_SIZE), 
/*  51 */               __member(POINTER_SIZE), 
/*  52 */               __member(POINTER_SIZE)
/*     */             
/*  54 */             }), __member(POINTER_SIZE), 
/*  55 */           __member(POINTER_SIZE)
/*     */         });
/*     */     
/*  58 */     SIZEOF = layout.getSize();
/*  59 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  61 */     HWND = layout.offsetof(1);
/*  62 */     HBITMAP = layout.offsetof(2);
/*  63 */     PBITS = layout.offsetof(3);
/*  64 */     HDC = layout.offsetof(4);
/*  65 */     HPALETTE = layout.offsetof(5);
/*     */   }
/*     */   
/*     */   protected JAWTWin32DrawingSurfaceInfo(long address, ByteBuffer container) {
/*  69 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected JAWTWin32DrawingSurfaceInfo create(long address, ByteBuffer container) {
/*  74 */     return new JAWTWin32DrawingSurfaceInfo(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JAWTWin32DrawingSurfaceInfo(ByteBuffer container) {
/*  84 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  88 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("HWND")
/*     */   public long hwnd() {
/*  92 */     return nhwnd(address());
/*     */   } @NativeType("HBITMAP")
/*     */   public long hbitmap() {
/*  95 */     return nhbitmap(address());
/*     */   } @NativeType("void *")
/*     */   public ByteBuffer pbits(int capacity) {
/*  98 */     return npbits(address(), capacity);
/*     */   } @NativeType("HDC")
/*     */   public long hdc() {
/* 101 */     return nhdc(address());
/*     */   } @NativeType("HPALETTE")
/*     */   public long hpalette() {
/* 104 */     return nhpalette(address());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static JAWTWin32DrawingSurfaceInfo create(long address) {
/* 110 */     return new JAWTWin32DrawingSurfaceInfo(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static JAWTWin32DrawingSurfaceInfo createSafe(long address) {
/* 115 */     return (address == 0L) ? null : new JAWTWin32DrawingSurfaceInfo(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 125 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 130 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nhwnd(long struct) {
/* 136 */     return MemoryUtil.memGetAddress(struct + HWND);
/*     */   } public static long nhbitmap(long struct) {
/* 138 */     return MemoryUtil.memGetAddress(struct + HBITMAP);
/*     */   } public static ByteBuffer npbits(long struct, int capacity) {
/* 140 */     return MemoryUtil.memByteBuffer(MemoryUtil.memGetAddress(struct + PBITS), capacity);
/*     */   } public static long nhdc(long struct) {
/* 142 */     return MemoryUtil.memGetAddress(struct + HDC);
/*     */   } public static long nhpalette(long struct) {
/* 144 */     return MemoryUtil.memGetAddress(struct + HPALETTE);
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<JAWTWin32DrawingSurfaceInfo, Buffer>
/*     */   {
/* 151 */     private static final JAWTWin32DrawingSurfaceInfo ELEMENT_FACTORY = JAWTWin32DrawingSurfaceInfo.create(-1L);
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
/* 163 */       super(container, container.remaining() / JAWTWin32DrawingSurfaceInfo.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 167 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 171 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 176 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 181 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected JAWTWin32DrawingSurfaceInfo getElementFactory() {
/* 186 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("HWND")
/*     */     public long hwnd() {
/* 191 */       return JAWTWin32DrawingSurfaceInfo.nhwnd(address());
/*     */     } @NativeType("HBITMAP")
/*     */     public long hbitmap() {
/* 194 */       return JAWTWin32DrawingSurfaceInfo.nhbitmap(address());
/*     */     } @NativeType("void *")
/*     */     public ByteBuffer pbits(int capacity) {
/* 197 */       return JAWTWin32DrawingSurfaceInfo.npbits(address(), capacity);
/*     */     } @NativeType("HDC")
/*     */     public long hdc() {
/* 200 */       return JAWTWin32DrawingSurfaceInfo.nhdc(address());
/*     */     } @NativeType("HPALETTE")
/*     */     public long hpalette() {
/* 203 */       return JAWTWin32DrawingSurfaceInfo.nhpalette(address());
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\jawt\JAWTWin32DrawingSurfaceInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */