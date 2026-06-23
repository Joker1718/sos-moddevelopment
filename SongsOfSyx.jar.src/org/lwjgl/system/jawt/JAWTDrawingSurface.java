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
/*     */ @NativeType("struct JAWT_DrawingSurface")
/*     */ public class JAWTDrawingSurface
/*     */   extends Struct<JAWTDrawingSurface>
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int ENV;
/*     */   public static final int TARGET;
/*     */   public static final int LOCK;
/*     */   public static final int GETDRAWINGSURFACEINFO;
/*     */   public static final int FREEDRAWINGSURFACEINFO;
/*     */   public static final int UNLOCK;
/*     */   
/*     */   static {
/*  46 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  47 */           __member(POINTER_SIZE), 
/*  48 */           __member(POINTER_SIZE), 
/*  49 */           __member(POINTER_SIZE), 
/*  50 */           __member(POINTER_SIZE), 
/*  51 */           __member(POINTER_SIZE), 
/*  52 */           __member(POINTER_SIZE)
/*     */         });
/*     */     
/*  55 */     SIZEOF = layout.getSize();
/*  56 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  58 */     ENV = layout.offsetof(0);
/*  59 */     TARGET = layout.offsetof(1);
/*  60 */     LOCK = layout.offsetof(2);
/*  61 */     GETDRAWINGSURFACEINFO = layout.offsetof(3);
/*  62 */     FREEDRAWINGSURFACEINFO = layout.offsetof(4);
/*  63 */     UNLOCK = layout.offsetof(5);
/*     */   }
/*     */   
/*     */   protected JAWTDrawingSurface(long address, ByteBuffer container) {
/*  67 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected JAWTDrawingSurface create(long address, ByteBuffer container) {
/*  72 */     return new JAWTDrawingSurface(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JAWTDrawingSurface(ByteBuffer container) {
/*  82 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  86 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("JNIEnv *")
/*     */   public long env() {
/*  90 */     return nenv(address());
/*     */   } @NativeType("jobject")
/*     */   public long target() {
/*  93 */     return ntarget(address());
/*     */   } @NativeType("void *")
/*     */   public long Lock() {
/*  96 */     return nLock(address());
/*     */   } @NativeType("void *")
/*     */   public long GetDrawingSurfaceInfo() {
/*  99 */     return nGetDrawingSurfaceInfo(address());
/*     */   } @NativeType("void *")
/*     */   public long FreeDrawingSurfaceInfo() {
/* 102 */     return nFreeDrawingSurfaceInfo(address());
/*     */   } @NativeType("void *")
/*     */   public long Unlock() {
/* 105 */     return nUnlock(address());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static JAWTDrawingSurface create(long address) {
/* 111 */     return new JAWTDrawingSurface(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static JAWTDrawingSurface createSafe(long address) {
/* 116 */     return (address == 0L) ? null : new JAWTDrawingSurface(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 126 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 131 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nenv(long struct) {
/* 137 */     return MemoryUtil.memGetAddress(struct + ENV);
/*     */   } public static long ntarget(long struct) {
/* 139 */     return MemoryUtil.memGetAddress(struct + TARGET);
/*     */   } public static long nLock(long struct) {
/* 141 */     return MemoryUtil.memGetAddress(struct + LOCK);
/*     */   } public static long nGetDrawingSurfaceInfo(long struct) {
/* 143 */     return MemoryUtil.memGetAddress(struct + GETDRAWINGSURFACEINFO);
/*     */   } public static long nFreeDrawingSurfaceInfo(long struct) {
/* 145 */     return MemoryUtil.memGetAddress(struct + FREEDRAWINGSURFACEINFO);
/*     */   } public static long nUnlock(long struct) {
/* 147 */     return MemoryUtil.memGetAddress(struct + UNLOCK);
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<JAWTDrawingSurface, Buffer>
/*     */   {
/* 154 */     private static final JAWTDrawingSurface ELEMENT_FACTORY = JAWTDrawingSurface.create(-1L);
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
/* 166 */       super(container, container.remaining() / JAWTDrawingSurface.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 170 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 174 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 179 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 184 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected JAWTDrawingSurface getElementFactory() {
/* 189 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("JNIEnv *")
/*     */     public long env() {
/* 194 */       return JAWTDrawingSurface.nenv(address());
/*     */     } @NativeType("jobject")
/*     */     public long target() {
/* 197 */       return JAWTDrawingSurface.ntarget(address());
/*     */     } @NativeType("void *")
/*     */     public long Lock() {
/* 200 */       return JAWTDrawingSurface.nLock(address());
/*     */     } @NativeType("void *")
/*     */     public long GetDrawingSurfaceInfo() {
/* 203 */       return JAWTDrawingSurface.nGetDrawingSurfaceInfo(address());
/*     */     } @NativeType("void *")
/*     */     public long FreeDrawingSurfaceInfo() {
/* 206 */       return JAWTDrawingSurface.nFreeDrawingSurfaceInfo(address());
/*     */     } @NativeType("void *")
/*     */     public long Unlock() {
/* 209 */       return JAWTDrawingSurface.nUnlock(address());
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\jawt\JAWTDrawingSurface.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */