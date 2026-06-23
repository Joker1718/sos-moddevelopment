/*     */ package org.lwjgl.system.linux.liburing;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.LongBuffer;
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
/*     */ @NativeType("struct io_uring_mem_region_reg")
/*     */ public class IOURingMemRegionReg
/*     */   extends Struct<IOURingMemRegionReg>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int REGION_UPTR;
/*     */   public static final int FLAGS;
/*     */   public static final int __RESV;
/*     */   
/*     */   static {
/*  43 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  44 */           __member(8), 
/*  45 */           __member(8), 
/*  46 */           __array(8, 2)
/*     */         });
/*     */     
/*  49 */     SIZEOF = layout.getSize();
/*  50 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  52 */     REGION_UPTR = layout.offsetof(0);
/*  53 */     FLAGS = layout.offsetof(1);
/*  54 */     __RESV = layout.offsetof(2);
/*     */   }
/*     */   
/*     */   protected IOURingMemRegionReg(long address, ByteBuffer container) {
/*  58 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected IOURingMemRegionReg create(long address, ByteBuffer container) {
/*  63 */     return new IOURingMemRegionReg(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingMemRegionReg(ByteBuffer container) {
/*  73 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  77 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("__u64")
/*     */   public long region_uptr() {
/*  81 */     return nregion_uptr(address());
/*     */   } @NativeType("__u64")
/*     */   public long flags() {
/*  84 */     return nflags(address());
/*     */   }
/*     */   public IOURingMemRegionReg region_uptr(@NativeType("__u64") long value) {
/*  87 */     nregion_uptr(address(), value); return this;
/*     */   } public IOURingMemRegionReg flags(@NativeType("__u64") long value) {
/*  89 */     nflags(address(), value); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingMemRegionReg set(long region_uptr, long flags) {
/*  96 */     region_uptr(region_uptr);
/*  97 */     flags(flags);
/*     */     
/*  99 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingMemRegionReg set(IOURingMemRegionReg src) {
/* 110 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 111 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingMemRegionReg malloc() {
/* 118 */     return new IOURingMemRegionReg(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingMemRegionReg calloc() {
/* 123 */     return new IOURingMemRegionReg(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingMemRegionReg create() {
/* 128 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 129 */     return new IOURingMemRegionReg(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingMemRegionReg create(long address) {
/* 134 */     return new IOURingMemRegionReg(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingMemRegionReg createSafe(long address) {
/* 139 */     return (address == 0L) ? null : new IOURingMemRegionReg(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 148 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 157 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 166 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 167 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 177 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 182 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingMemRegionReg malloc(MemoryStack stack) {
/* 191 */     return new IOURingMemRegionReg(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingMemRegionReg calloc(MemoryStack stack) {
/* 200 */     return new IOURingMemRegionReg(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 210 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 220 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nregion_uptr(long struct) {
/* 226 */     return MemoryUtil.memGetLong(struct + REGION_UPTR);
/*     */   }
/* 228 */   public static long nflags(long struct) { return MemoryUtil.memGetLong(struct + FLAGS); } public static LongBuffer n__resv(long struct) {
/* 229 */     return MemoryUtil.memLongBuffer(struct + __RESV, 2);
/*     */   } public static long n__resv(long struct, int index) {
/* 231 */     return MemoryUtil.memGetLong(struct + __RESV + Checks.check(index, 2) * 8L);
/*     */   }
/*     */   
/*     */   public static void nregion_uptr(long struct, long value) {
/* 235 */     MemoryUtil.memPutLong(struct + REGION_UPTR, value);
/*     */   } public static void nflags(long struct, long value) {
/* 237 */     MemoryUtil.memPutLong(struct + FLAGS, value);
/*     */   } public static void n__resv(long struct, LongBuffer value) {
/* 239 */     if (Checks.CHECKS) Checks.checkGT(value, 2); 
/* 240 */     MemoryUtil.memCopy(MemoryUtil.memAddress(value), struct + __RESV, (value.remaining() * 8));
/*     */   }
/*     */   public static void n__resv(long struct, int index, long value) {
/* 243 */     MemoryUtil.memPutLong(struct + __RESV + Checks.check(index, 2) * 8L, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<IOURingMemRegionReg, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 251 */     private static final IOURingMemRegionReg ELEMENT_FACTORY = IOURingMemRegionReg.create(-1L);
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
/* 263 */       super(container, container.remaining() / IOURingMemRegionReg.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 267 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 271 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 276 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 281 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected IOURingMemRegionReg getElementFactory() {
/* 286 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("__u64")
/*     */     public long region_uptr() {
/* 291 */       return IOURingMemRegionReg.nregion_uptr(address());
/*     */     } @NativeType("__u64")
/*     */     public long flags() {
/* 294 */       return IOURingMemRegionReg.nflags(address());
/*     */     }
/*     */     public Buffer region_uptr(@NativeType("__u64") long value) {
/* 297 */       IOURingMemRegionReg.nregion_uptr(address(), value); return this;
/*     */     } public Buffer flags(@NativeType("__u64") long value) {
/* 299 */       IOURingMemRegionReg.nflags(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\liburing\IOURingMemRegionReg.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */