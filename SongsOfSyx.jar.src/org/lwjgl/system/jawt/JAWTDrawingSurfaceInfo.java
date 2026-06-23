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
/*     */ @NativeType("struct JAWT_DrawingSurfaceInfo")
/*     */ public class JAWTDrawingSurfaceInfo
/*     */   extends Struct<JAWTDrawingSurfaceInfo>
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int PLATFORMINFO;
/*     */   public static final int DS;
/*     */   public static final int BOUNDS;
/*     */   public static final int CLIPSIZE;
/*     */   public static final int CLIP;
/*     */   
/*     */   static {
/*  44 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  45 */           __member(POINTER_SIZE), 
/*  46 */           __member(POINTER_SIZE), 
/*  47 */           __member(JAWTRectangle.SIZEOF, JAWTRectangle.ALIGNOF), 
/*  48 */           __member(4), 
/*  49 */           __member(POINTER_SIZE)
/*     */         });
/*     */     
/*  52 */     SIZEOF = layout.getSize();
/*  53 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  55 */     PLATFORMINFO = layout.offsetof(0);
/*  56 */     DS = layout.offsetof(1);
/*  57 */     BOUNDS = layout.offsetof(2);
/*  58 */     CLIPSIZE = layout.offsetof(3);
/*  59 */     CLIP = layout.offsetof(4);
/*     */   }
/*     */   
/*     */   protected JAWTDrawingSurfaceInfo(long address, ByteBuffer container) {
/*  63 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected JAWTDrawingSurfaceInfo create(long address, ByteBuffer container) {
/*  68 */     return new JAWTDrawingSurfaceInfo(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JAWTDrawingSurfaceInfo(ByteBuffer container) {
/*  78 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  82 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("void *")
/*     */   public long platformInfo() {
/*  86 */     return nplatformInfo(address());
/*     */   } @NativeType("JAWT_DrawingSurface *")
/*     */   public JAWTDrawingSurface ds() {
/*  89 */     return nds(address());
/*     */   } @NativeType("JAWT_Rectangle")
/*     */   public JAWTRectangle bounds() {
/*  92 */     return nbounds(address());
/*     */   } @NativeType("jint")
/*     */   public int clipSize() {
/*  95 */     return nclipSize(address());
/*     */   } @NativeType("JAWT_Rectangle *")
/*     */   public JAWTRectangle.Buffer clip() {
/*  98 */     return nclip(address());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static JAWTDrawingSurfaceInfo create(long address) {
/* 104 */     return new JAWTDrawingSurfaceInfo(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static JAWTDrawingSurfaceInfo createSafe(long address) {
/* 109 */     return (address == 0L) ? null : new JAWTDrawingSurfaceInfo(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 119 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 124 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nplatformInfo(long struct) {
/* 130 */     return MemoryUtil.memGetAddress(struct + PLATFORMINFO);
/*     */   } public static JAWTDrawingSurface nds(long struct) {
/* 132 */     return JAWTDrawingSurface.create(MemoryUtil.memGetAddress(struct + DS));
/*     */   } public static JAWTRectangle nbounds(long struct) {
/* 134 */     return JAWTRectangle.create(struct + BOUNDS);
/*     */   } public static int nclipSize(long struct) {
/* 136 */     return MemoryUtil.memGetInt(struct + CLIPSIZE);
/*     */   } public static JAWTRectangle.Buffer nclip(long struct) {
/* 138 */     return JAWTRectangle.create(MemoryUtil.memGetAddress(struct + CLIP), nclipSize(struct));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<JAWTDrawingSurfaceInfo, Buffer>
/*     */   {
/* 145 */     private static final JAWTDrawingSurfaceInfo ELEMENT_FACTORY = JAWTDrawingSurfaceInfo.create(-1L);
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
/* 157 */       super(container, container.remaining() / JAWTDrawingSurfaceInfo.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 161 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 165 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 170 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 175 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected JAWTDrawingSurfaceInfo getElementFactory() {
/* 180 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("void *")
/*     */     public long platformInfo() {
/* 185 */       return JAWTDrawingSurfaceInfo.nplatformInfo(address());
/*     */     } @NativeType("JAWT_DrawingSurface *")
/*     */     public JAWTDrawingSurface ds() {
/* 188 */       return JAWTDrawingSurfaceInfo.nds(address());
/*     */     } @NativeType("JAWT_Rectangle")
/*     */     public JAWTRectangle bounds() {
/* 191 */       return JAWTDrawingSurfaceInfo.nbounds(address());
/*     */     } @NativeType("jint")
/*     */     public int clipSize() {
/* 194 */       return JAWTDrawingSurfaceInfo.nclipSize(address());
/*     */     } @NativeType("JAWT_Rectangle *")
/*     */     public JAWTRectangle.Buffer clip() {
/* 197 */       return JAWTDrawingSurfaceInfo.nclip(address());
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\jawt\JAWTDrawingSurfaceInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */