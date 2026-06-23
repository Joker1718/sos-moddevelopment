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
/*     */ @NativeType("struct JAWT_X11DrawingSurfaceInfo")
/*     */ public class JAWTX11DrawingSurfaceInfo
/*     */   extends Struct<JAWTX11DrawingSurfaceInfo>
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int DRAWABLE;
/*     */   public static final int DISPLAY;
/*     */   public static final int VISUALID;
/*     */   public static final int COLORMAPID;
/*     */   public static final int DEPTH;
/*     */   
/*     */   static {
/*  44 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  45 */           __member(CLONG_SIZE), 
/*  46 */           __member(POINTER_SIZE), 
/*  47 */           __member(CLONG_SIZE), 
/*  48 */           __member(CLONG_SIZE), 
/*  49 */           __member(4)
/*     */         });
/*     */     
/*  52 */     SIZEOF = layout.getSize();
/*  53 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  55 */     DRAWABLE = layout.offsetof(0);
/*  56 */     DISPLAY = layout.offsetof(1);
/*  57 */     VISUALID = layout.offsetof(2);
/*  58 */     COLORMAPID = layout.offsetof(3);
/*  59 */     DEPTH = layout.offsetof(4);
/*     */   }
/*     */   
/*     */   protected JAWTX11DrawingSurfaceInfo(long address, ByteBuffer container) {
/*  63 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected JAWTX11DrawingSurfaceInfo create(long address, ByteBuffer container) {
/*  68 */     return new JAWTX11DrawingSurfaceInfo(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JAWTX11DrawingSurfaceInfo(ByteBuffer container) {
/*  78 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  82 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("Drawable")
/*     */   public long drawable() {
/*  86 */     return ndrawable(address());
/*     */   } @NativeType("Display *")
/*     */   public long display() {
/*  89 */     return ndisplay(address());
/*     */   } @NativeType("VisualID")
/*     */   public long visualID() {
/*  92 */     return nvisualID(address());
/*     */   } @NativeType("Colormap")
/*     */   public long colormapID() {
/*  95 */     return ncolormapID(address());
/*     */   } public int depth() {
/*  97 */     return ndepth(address());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static JAWTX11DrawingSurfaceInfo create(long address) {
/* 103 */     return new JAWTX11DrawingSurfaceInfo(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static JAWTX11DrawingSurfaceInfo createSafe(long address) {
/* 108 */     return (address == 0L) ? null : new JAWTX11DrawingSurfaceInfo(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 118 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 123 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static long ndrawable(long struct) {
/* 129 */     return MemoryUtil.memGetCLong(struct + DRAWABLE);
/*     */   } public static long ndisplay(long struct) {
/* 131 */     return MemoryUtil.memGetAddress(struct + DISPLAY);
/*     */   } public static long nvisualID(long struct) {
/* 133 */     return MemoryUtil.memGetCLong(struct + VISUALID);
/*     */   } public static long ncolormapID(long struct) {
/* 135 */     return MemoryUtil.memGetCLong(struct + COLORMAPID);
/*     */   } public static int ndepth(long struct) {
/* 137 */     return MemoryUtil.memGetInt(struct + DEPTH);
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<JAWTX11DrawingSurfaceInfo, Buffer>
/*     */   {
/* 144 */     private static final JAWTX11DrawingSurfaceInfo ELEMENT_FACTORY = JAWTX11DrawingSurfaceInfo.create(-1L);
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
/* 156 */       super(container, container.remaining() / JAWTX11DrawingSurfaceInfo.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 160 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 164 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 169 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 174 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected JAWTX11DrawingSurfaceInfo getElementFactory() {
/* 179 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("Drawable")
/*     */     public long drawable() {
/* 184 */       return JAWTX11DrawingSurfaceInfo.ndrawable(address());
/*     */     } @NativeType("Display *")
/*     */     public long display() {
/* 187 */       return JAWTX11DrawingSurfaceInfo.ndisplay(address());
/*     */     } @NativeType("VisualID")
/*     */     public long visualID() {
/* 190 */       return JAWTX11DrawingSurfaceInfo.nvisualID(address());
/*     */     } @NativeType("Colormap")
/*     */     public long colormapID() {
/* 193 */       return JAWTX11DrawingSurfaceInfo.ncolormapID(address());
/*     */     } public int depth() {
/* 195 */       return JAWTX11DrawingSurfaceInfo.ndepth(address());
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\jawt\JAWTX11DrawingSurfaceInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */