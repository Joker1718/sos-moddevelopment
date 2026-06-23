/*     */ package org.lwjgl.system.linux;
/*     */ 
/*     */ import java.nio.ByteBuffer;
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
/*     */ 
/*     */ 
/*     */ @NativeType("union epoll_data_t")
/*     */ public class EpollData
/*     */   extends Struct<EpollData>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int PTR;
/*     */   public static final int FD;
/*     */   public static final int U32;
/*     */   public static final int U64;
/*     */   
/*     */   static {
/*  45 */     Struct.Layout layout = __union(new Struct.Member[] {
/*  46 */           __member(POINTER_SIZE), 
/*  47 */           __member(4), 
/*  48 */           __member(4), 
/*  49 */           __member(8)
/*     */         });
/*     */     
/*  52 */     SIZEOF = layout.getSize();
/*  53 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  55 */     PTR = layout.offsetof(0);
/*  56 */     FD = layout.offsetof(1);
/*  57 */     U32 = layout.offsetof(2);
/*  58 */     U64 = layout.offsetof(3);
/*     */   }
/*     */   
/*     */   protected EpollData(long address, ByteBuffer container) {
/*  62 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected EpollData create(long address, ByteBuffer container) {
/*  67 */     return new EpollData(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EpollData(ByteBuffer container) {
/*  77 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  81 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("void *")
/*     */   public long ptr() {
/*  85 */     return nptr(address());
/*     */   } public int fd() {
/*  87 */     return nfd(address());
/*     */   } @NativeType("uint32_t")
/*     */   public int u32() {
/*  90 */     return nu32(address());
/*     */   } @NativeType("uint64_t")
/*     */   public long u64() {
/*  93 */     return nu64(address());
/*     */   }
/*     */   public EpollData ptr(@NativeType("void *") long value) {
/*  96 */     nptr(address(), value); return this;
/*     */   } public EpollData fd(int value) {
/*  98 */     nfd(address(), value); return this;
/*     */   } public EpollData u32(@NativeType("uint32_t") int value) {
/* 100 */     nu32(address(), value); return this;
/*     */   } public EpollData u64(@NativeType("uint64_t") long value) {
/* 102 */     nu64(address(), value); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EpollData set(EpollData src) {
/* 112 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 113 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static EpollData malloc() {
/* 120 */     return new EpollData(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static EpollData calloc() {
/* 125 */     return new EpollData(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static EpollData create() {
/* 130 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 131 */     return new EpollData(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static EpollData create(long address) {
/* 136 */     return new EpollData(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static EpollData createSafe(long address) {
/* 141 */     return (address == 0L) ? null : new EpollData(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 150 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 159 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 168 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 169 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 179 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 184 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static EpollData malloc(MemoryStack stack) {
/* 193 */     return new EpollData(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static EpollData calloc(MemoryStack stack) {
/* 202 */     return new EpollData(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 212 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 222 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nptr(long struct) {
/* 228 */     return MemoryUtil.memGetAddress(struct + PTR);
/*     */   } public static int nfd(long struct) {
/* 230 */     return MemoryUtil.memGetInt(struct + FD);
/*     */   } public static int nu32(long struct) {
/* 232 */     return MemoryUtil.memGetInt(struct + U32);
/*     */   } public static long nu64(long struct) {
/* 234 */     return MemoryUtil.memGetLong(struct + U64);
/*     */   }
/*     */   public static void nptr(long struct, long value) {
/* 237 */     MemoryUtil.memPutAddress(struct + PTR, Checks.check(value));
/*     */   } public static void nfd(long struct, int value) {
/* 239 */     MemoryUtil.memPutInt(struct + FD, value);
/*     */   } public static void nu32(long struct, int value) {
/* 241 */     MemoryUtil.memPutInt(struct + U32, value);
/*     */   } public static void nu64(long struct, long value) {
/* 243 */     MemoryUtil.memPutLong(struct + U64, value);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<EpollData, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 250 */     private static final EpollData ELEMENT_FACTORY = EpollData.create(-1L);
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
/* 262 */       super(container, container.remaining() / EpollData.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 266 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 270 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 275 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 280 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected EpollData getElementFactory() {
/* 285 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("void *")
/*     */     public long ptr() {
/* 290 */       return EpollData.nptr(address());
/*     */     } public int fd() {
/* 292 */       return EpollData.nfd(address());
/*     */     } @NativeType("uint32_t")
/*     */     public int u32() {
/* 295 */       return EpollData.nu32(address());
/*     */     } @NativeType("uint64_t")
/*     */     public long u64() {
/* 298 */       return EpollData.nu64(address());
/*     */     }
/*     */     public Buffer ptr(@NativeType("void *") long value) {
/* 301 */       EpollData.nptr(address(), value); return this;
/*     */     } public Buffer fd(int value) {
/* 303 */       EpollData.nfd(address(), value); return this;
/*     */     } public Buffer u32(@NativeType("uint32_t") int value) {
/* 305 */       EpollData.nu32(address(), value); return this;
/*     */     } public Buffer u64(@NativeType("uint64_t") long value) {
/* 307 */       EpollData.nu64(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\EpollData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */