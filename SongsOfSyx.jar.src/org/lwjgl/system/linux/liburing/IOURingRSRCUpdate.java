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
/*     */ @NativeType("struct io_uring_rsrc_update")
/*     */ public class IOURingRSRCUpdate
/*     */   extends Struct<IOURingRSRCUpdate>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int OFFSET;
/*     */   public static final int RESV;
/*     */   public static final int DATA;
/*     */   
/*     */   static {
/*  42 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  43 */           __member(4), 
/*  44 */           __member(4), 
/*  45 */           __member(8)
/*     */         });
/*     */     
/*  48 */     SIZEOF = layout.getSize();
/*  49 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  51 */     OFFSET = layout.offsetof(0);
/*  52 */     RESV = layout.offsetof(1);
/*  53 */     DATA = layout.offsetof(2);
/*     */   }
/*     */   
/*     */   protected IOURingRSRCUpdate(long address, ByteBuffer container) {
/*  57 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected IOURingRSRCUpdate create(long address, ByteBuffer container) {
/*  62 */     return new IOURingRSRCUpdate(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingRSRCUpdate(ByteBuffer container) {
/*  72 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  76 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("__u32")
/*     */   public int offset() {
/*  80 */     return noffset(address());
/*     */   } @NativeType("__u64")
/*     */   public long data() {
/*  83 */     return ndata(address());
/*     */   }
/*     */   public IOURingRSRCUpdate offset(@NativeType("__u32") int value) {
/*  86 */     noffset(address(), value); return this;
/*     */   } public IOURingRSRCUpdate data(@NativeType("__u64") long value) {
/*  88 */     ndata(address(), value); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingRSRCUpdate set(int offset, long data) {
/*  95 */     offset(offset);
/*  96 */     data(data);
/*     */     
/*  98 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingRSRCUpdate set(IOURingRSRCUpdate src) {
/* 109 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 110 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingRSRCUpdate malloc() {
/* 117 */     return new IOURingRSRCUpdate(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingRSRCUpdate calloc() {
/* 122 */     return new IOURingRSRCUpdate(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingRSRCUpdate create() {
/* 127 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 128 */     return new IOURingRSRCUpdate(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingRSRCUpdate create(long address) {
/* 133 */     return new IOURingRSRCUpdate(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingRSRCUpdate createSafe(long address) {
/* 138 */     return (address == 0L) ? null : new IOURingRSRCUpdate(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 147 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 156 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 165 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 166 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 176 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 181 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingRSRCUpdate malloc(MemoryStack stack) {
/* 190 */     return new IOURingRSRCUpdate(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingRSRCUpdate calloc(MemoryStack stack) {
/* 199 */     return new IOURingRSRCUpdate(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 209 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 219 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int noffset(long struct) {
/* 225 */     return MemoryUtil.memGetInt(struct + OFFSET); } public static int nresv(long struct) {
/* 226 */     return MemoryUtil.memGetInt(struct + RESV);
/*     */   } public static long ndata(long struct) {
/* 228 */     return MemoryUtil.memGetLong(struct + DATA);
/*     */   }
/*     */   
/* 231 */   public static void noffset(long struct, int value) { MemoryUtil.memPutInt(struct + OFFSET, value); } public static void nresv(long struct, int value) {
/* 232 */     MemoryUtil.memPutInt(struct + RESV, value);
/*     */   } public static void ndata(long struct, long value) {
/* 234 */     MemoryUtil.memPutLong(struct + DATA, value);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<IOURingRSRCUpdate, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 241 */     private static final IOURingRSRCUpdate ELEMENT_FACTORY = IOURingRSRCUpdate.create(-1L);
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
/* 253 */       super(container, container.remaining() / IOURingRSRCUpdate.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 257 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 261 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 266 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 271 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected IOURingRSRCUpdate getElementFactory() {
/* 276 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("__u32")
/*     */     public int offset() {
/* 281 */       return IOURingRSRCUpdate.noffset(address());
/*     */     } @NativeType("__u64")
/*     */     public long data() {
/* 284 */       return IOURingRSRCUpdate.ndata(address());
/*     */     }
/*     */     public Buffer offset(@NativeType("__u32") int value) {
/* 287 */       IOURingRSRCUpdate.noffset(address(), value); return this;
/*     */     } public Buffer data(@NativeType("__u64") long value) {
/* 289 */       IOURingRSRCUpdate.ndata(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\liburing\IOURingRSRCUpdate.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */