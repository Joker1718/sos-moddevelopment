/*     */ package org.lwjgl.system.linux.liburing;
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
/*     */ @NativeType("struct io_uring_getevents_arg")
/*     */ public class IOURingGeteventsArg
/*     */   extends Struct<IOURingGeteventsArg>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int SIGMASK;
/*     */   public static final int SIGMASK_SZ;
/*     */   public static final int MIN_WAIT_USEC;
/*     */   public static final int TS;
/*     */   
/*     */   static {
/*  44 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  45 */           __member(8), 
/*  46 */           __member(4), 
/*  47 */           __member(4), 
/*  48 */           __member(8)
/*     */         });
/*     */     
/*  51 */     SIZEOF = layout.getSize();
/*  52 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  54 */     SIGMASK = layout.offsetof(0);
/*  55 */     SIGMASK_SZ = layout.offsetof(1);
/*  56 */     MIN_WAIT_USEC = layout.offsetof(2);
/*  57 */     TS = layout.offsetof(3);
/*     */   }
/*     */   
/*     */   protected IOURingGeteventsArg(long address, ByteBuffer container) {
/*  61 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected IOURingGeteventsArg create(long address, ByteBuffer container) {
/*  66 */     return new IOURingGeteventsArg(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingGeteventsArg(ByteBuffer container) {
/*  76 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  80 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("__u64")
/*     */   public long sigmask() {
/*  84 */     return nsigmask(address());
/*     */   } @NativeType("__u32")
/*     */   public int sigmask_sz() {
/*  87 */     return nsigmask_sz(address());
/*     */   } @NativeType("__u32")
/*     */   public int min_wait_usec() {
/*  90 */     return nmin_wait_usec(address());
/*     */   } @NativeType("__u64")
/*     */   public long ts() {
/*  93 */     return nts(address());
/*     */   }
/*     */   public IOURingGeteventsArg sigmask(@NativeType("__u64") long value) {
/*  96 */     nsigmask(address(), value); return this;
/*     */   } public IOURingGeteventsArg sigmask_sz(@NativeType("__u32") int value) {
/*  98 */     nsigmask_sz(address(), value); return this;
/*     */   } public IOURingGeteventsArg min_wait_usec(@NativeType("__u32") int value) {
/* 100 */     nmin_wait_usec(address(), value); return this;
/*     */   } public IOURingGeteventsArg ts(@NativeType("__u64") long value) {
/* 102 */     nts(address(), value); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingGeteventsArg set(long sigmask, int sigmask_sz, int min_wait_usec, long ts) {
/* 111 */     sigmask(sigmask);
/* 112 */     sigmask_sz(sigmask_sz);
/* 113 */     min_wait_usec(min_wait_usec);
/* 114 */     ts(ts);
/*     */     
/* 116 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingGeteventsArg set(IOURingGeteventsArg src) {
/* 127 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 128 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingGeteventsArg malloc() {
/* 135 */     return new IOURingGeteventsArg(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingGeteventsArg calloc() {
/* 140 */     return new IOURingGeteventsArg(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingGeteventsArg create() {
/* 145 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 146 */     return new IOURingGeteventsArg(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingGeteventsArg create(long address) {
/* 151 */     return new IOURingGeteventsArg(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingGeteventsArg createSafe(long address) {
/* 156 */     return (address == 0L) ? null : new IOURingGeteventsArg(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 165 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 174 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 183 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 184 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 194 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 199 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingGeteventsArg malloc(MemoryStack stack) {
/* 208 */     return new IOURingGeteventsArg(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingGeteventsArg calloc(MemoryStack stack) {
/* 217 */     return new IOURingGeteventsArg(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 227 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 237 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nsigmask(long struct) {
/* 243 */     return MemoryUtil.memGetLong(struct + SIGMASK);
/*     */   } public static int nsigmask_sz(long struct) {
/* 245 */     return MemoryUtil.memGetInt(struct + SIGMASK_SZ);
/*     */   } public static int nmin_wait_usec(long struct) {
/* 247 */     return MemoryUtil.memGetInt(struct + MIN_WAIT_USEC);
/*     */   } public static long nts(long struct) {
/* 249 */     return MemoryUtil.memGetLong(struct + TS);
/*     */   }
/*     */   public static void nsigmask(long struct, long value) {
/* 252 */     MemoryUtil.memPutLong(struct + SIGMASK, value);
/*     */   } public static void nsigmask_sz(long struct, int value) {
/* 254 */     MemoryUtil.memPutInt(struct + SIGMASK_SZ, value);
/*     */   } public static void nmin_wait_usec(long struct, int value) {
/* 256 */     MemoryUtil.memPutInt(struct + MIN_WAIT_USEC, value);
/*     */   } public static void nts(long struct, long value) {
/* 258 */     MemoryUtil.memPutLong(struct + TS, value);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<IOURingGeteventsArg, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 265 */     private static final IOURingGeteventsArg ELEMENT_FACTORY = IOURingGeteventsArg.create(-1L);
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
/* 277 */       super(container, container.remaining() / IOURingGeteventsArg.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 281 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 285 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 290 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 295 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected IOURingGeteventsArg getElementFactory() {
/* 300 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("__u64")
/*     */     public long sigmask() {
/* 305 */       return IOURingGeteventsArg.nsigmask(address());
/*     */     } @NativeType("__u32")
/*     */     public int sigmask_sz() {
/* 308 */       return IOURingGeteventsArg.nsigmask_sz(address());
/*     */     } @NativeType("__u32")
/*     */     public int min_wait_usec() {
/* 311 */       return IOURingGeteventsArg.nmin_wait_usec(address());
/*     */     } @NativeType("__u64")
/*     */     public long ts() {
/* 314 */       return IOURingGeteventsArg.nts(address());
/*     */     }
/*     */     public Buffer sigmask(@NativeType("__u64") long value) {
/* 317 */       IOURingGeteventsArg.nsigmask(address(), value); return this;
/*     */     } public Buffer sigmask_sz(@NativeType("__u32") int value) {
/* 319 */       IOURingGeteventsArg.nsigmask_sz(address(), value); return this;
/*     */     } public Buffer min_wait_usec(@NativeType("__u32") int value) {
/* 321 */       IOURingGeteventsArg.nmin_wait_usec(address(), value); return this;
/*     */     } public Buffer ts(@NativeType("__u64") long value) {
/* 323 */       IOURingGeteventsArg.nts(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\liburing\IOURingGeteventsArg.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */