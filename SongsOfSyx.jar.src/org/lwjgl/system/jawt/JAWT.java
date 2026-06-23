/*     */ package org.lwjgl.system.jawt;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import org.lwjgl.BufferUtils;
/*     */ import org.lwjgl.system.MemoryStack;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeResource;
/*     */ import org.lwjgl.system.NativeType;
/*     */ import org.lwjgl.system.Struct;
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
/*     */ public class JAWT
/*     */   extends Struct<JAWT>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int VERSION;
/*     */   public static final int GETDRAWINGSURFACE;
/*     */   public static final int FREEDRAWINGSURFACE;
/*     */   public static final int LOCK;
/*     */   public static final int UNLOCK;
/*     */   public static final int GETCOMPONENT;
/*     */   public static final int CREATEEMBEDDEDFRAME;
/*     */   public static final int SETBOUNDS;
/*     */   public static final int SYNTHESIZEWINDOWACTIVATION;
/*     */   
/*     */   static {
/*  53 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  54 */           __member(4), 
/*  55 */           __member(POINTER_SIZE), 
/*  56 */           __member(POINTER_SIZE), 
/*  57 */           __member(POINTER_SIZE), 
/*  58 */           __member(POINTER_SIZE), 
/*  59 */           __member(POINTER_SIZE), 
/*  60 */           __member(POINTER_SIZE), 
/*  61 */           __member(POINTER_SIZE), 
/*  62 */           __member(POINTER_SIZE)
/*     */         });
/*     */     
/*  65 */     SIZEOF = layout.getSize();
/*  66 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  68 */     VERSION = layout.offsetof(0);
/*  69 */     GETDRAWINGSURFACE = layout.offsetof(1);
/*  70 */     FREEDRAWINGSURFACE = layout.offsetof(2);
/*  71 */     LOCK = layout.offsetof(3);
/*  72 */     UNLOCK = layout.offsetof(4);
/*  73 */     GETCOMPONENT = layout.offsetof(5);
/*  74 */     CREATEEMBEDDEDFRAME = layout.offsetof(6);
/*  75 */     SETBOUNDS = layout.offsetof(7);
/*  76 */     SYNTHESIZEWINDOWACTIVATION = layout.offsetof(8);
/*     */   }
/*     */   
/*     */   protected JAWT(long address, ByteBuffer container) {
/*  80 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected JAWT create(long address, ByteBuffer container) {
/*  85 */     return new JAWT(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JAWT(ByteBuffer container) {
/*  95 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  99 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("jint")
/*     */   public int version() {
/* 103 */     return nversion(address());
/*     */   } @NativeType("void *")
/*     */   public long GetDrawingSurface() {
/* 106 */     return nGetDrawingSurface(address());
/*     */   } @NativeType("void *")
/*     */   public long FreeDrawingSurface() {
/* 109 */     return nFreeDrawingSurface(address());
/*     */   } @NativeType("void *")
/*     */   public long Lock() {
/* 112 */     return nLock(address());
/*     */   } @NativeType("void *")
/*     */   public long Unlock() {
/* 115 */     return nUnlock(address());
/*     */   } @NativeType("void *")
/*     */   public long GetComponent() {
/* 118 */     return nGetComponent(address());
/*     */   } @NativeType("void *")
/*     */   public long CreateEmbeddedFrame() {
/* 121 */     return nCreateEmbeddedFrame(address());
/*     */   } @NativeType("void *")
/*     */   public long SetBounds() {
/* 124 */     return nSetBounds(address());
/*     */   } @NativeType("void *")
/*     */   public long SynthesizeWindowActivation() {
/* 127 */     return nSynthesizeWindowActivation(address());
/*     */   }
/*     */   public JAWT version(@NativeType("jint") int value) {
/* 130 */     nversion(address(), value); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JAWT set(JAWT src) {
/* 140 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 141 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static JAWT malloc() {
/* 148 */     return new JAWT(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static JAWT calloc() {
/* 153 */     return new JAWT(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static JAWT create() {
/* 158 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 159 */     return new JAWT(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static JAWT create(long address) {
/* 164 */     return new JAWT(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static JAWT createSafe(long address) {
/* 169 */     return (address == 0L) ? null : new JAWT(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static JAWT malloc(MemoryStack stack) {
/* 178 */     return new JAWT(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static JAWT calloc(MemoryStack stack) {
/* 187 */     return new JAWT(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nversion(long struct) {
/* 193 */     return MemoryUtil.memGetInt(struct + VERSION);
/*     */   } public static long nGetDrawingSurface(long struct) {
/* 195 */     return MemoryUtil.memGetAddress(struct + GETDRAWINGSURFACE);
/*     */   } public static long nFreeDrawingSurface(long struct) {
/* 197 */     return MemoryUtil.memGetAddress(struct + FREEDRAWINGSURFACE);
/*     */   } public static long nLock(long struct) {
/* 199 */     return MemoryUtil.memGetAddress(struct + LOCK);
/*     */   } public static long nUnlock(long struct) {
/* 201 */     return MemoryUtil.memGetAddress(struct + UNLOCK);
/*     */   } public static long nGetComponent(long struct) {
/* 203 */     return MemoryUtil.memGetAddress(struct + GETCOMPONENT);
/*     */   } public static long nCreateEmbeddedFrame(long struct) {
/* 205 */     return MemoryUtil.memGetAddress(struct + CREATEEMBEDDEDFRAME);
/*     */   } public static long nSetBounds(long struct) {
/* 207 */     return MemoryUtil.memGetAddress(struct + SETBOUNDS);
/*     */   } public static long nSynthesizeWindowActivation(long struct) {
/* 209 */     return MemoryUtil.memGetAddress(struct + SYNTHESIZEWINDOWACTIVATION);
/*     */   }
/*     */   public static void nversion(long struct, int value) {
/* 212 */     MemoryUtil.memPutInt(struct + VERSION, value);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\jawt\JAWT.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */