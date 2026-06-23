/*     */ package org.lwjgl.system.linux.liburing;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.IntBuffer;
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
/*     */ @NativeType("struct io_uring_buf_status")
/*     */ public class IOURingBufStatus
/*     */   extends Struct<IOURingBufStatus>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int BUF_GROUP;
/*     */   public static final int HEAD;
/*     */   public static final int RESV;
/*     */   
/*     */   static {
/*  43 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  44 */           __member(4), 
/*  45 */           __member(4), 
/*  46 */           __array(4, 8)
/*     */         });
/*     */     
/*  49 */     SIZEOF = layout.getSize();
/*  50 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  52 */     BUF_GROUP = layout.offsetof(0);
/*  53 */     HEAD = layout.offsetof(1);
/*  54 */     RESV = layout.offsetof(2);
/*     */   }
/*     */   
/*     */   protected IOURingBufStatus(long address, ByteBuffer container) {
/*  58 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected IOURingBufStatus create(long address, ByteBuffer container) {
/*  63 */     return new IOURingBufStatus(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingBufStatus(ByteBuffer container) {
/*  73 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  77 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("__u32")
/*     */   public int buf_group() {
/*  81 */     return nbuf_group(address());
/*     */   } @NativeType("__u32")
/*     */   public int head() {
/*  84 */     return nhead(address());
/*     */   }
/*     */   public IOURingBufStatus buf_group(@NativeType("__u32") int value) {
/*  87 */     nbuf_group(address(), value); return this;
/*     */   } public IOURingBufStatus head(@NativeType("__u32") int value) {
/*  89 */     nhead(address(), value); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingBufStatus set(int buf_group, int head) {
/*  96 */     buf_group(buf_group);
/*  97 */     head(head);
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
/*     */   public IOURingBufStatus set(IOURingBufStatus src) {
/* 110 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 111 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingBufStatus malloc() {
/* 118 */     return new IOURingBufStatus(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingBufStatus calloc() {
/* 123 */     return new IOURingBufStatus(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingBufStatus create() {
/* 128 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 129 */     return new IOURingBufStatus(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingBufStatus create(long address) {
/* 134 */     return new IOURingBufStatus(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingBufStatus createSafe(long address) {
/* 139 */     return (address == 0L) ? null : new IOURingBufStatus(address, null);
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
/*     */   public static IOURingBufStatus malloc(MemoryStack stack) {
/* 191 */     return new IOURingBufStatus(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingBufStatus calloc(MemoryStack stack) {
/* 200 */     return new IOURingBufStatus(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
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
/*     */   public static int nbuf_group(long struct) {
/* 226 */     return MemoryUtil.memGetInt(struct + BUF_GROUP);
/*     */   }
/* 228 */   public static int nhead(long struct) { return MemoryUtil.memGetInt(struct + HEAD); } public static IntBuffer nresv(long struct) {
/* 229 */     return MemoryUtil.memIntBuffer(struct + RESV, 8);
/*     */   } public static int nresv(long struct, int index) {
/* 231 */     return MemoryUtil.memGetInt(struct + RESV + Checks.check(index, 8) * 4L);
/*     */   }
/*     */   
/*     */   public static void nbuf_group(long struct, int value) {
/* 235 */     MemoryUtil.memPutInt(struct + BUF_GROUP, value);
/*     */   } public static void nhead(long struct, int value) {
/* 237 */     MemoryUtil.memPutInt(struct + HEAD, value);
/*     */   } public static void nresv(long struct, IntBuffer value) {
/* 239 */     if (Checks.CHECKS) Checks.checkGT(value, 8); 
/* 240 */     MemoryUtil.memCopy(MemoryUtil.memAddress(value), struct + RESV, (value.remaining() * 4));
/*     */   }
/*     */   public static void nresv(long struct, int index, int value) {
/* 243 */     MemoryUtil.memPutInt(struct + RESV + Checks.check(index, 8) * 4L, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<IOURingBufStatus, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 251 */     private static final IOURingBufStatus ELEMENT_FACTORY = IOURingBufStatus.create(-1L);
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
/* 263 */       super(container, container.remaining() / IOURingBufStatus.SIZEOF);
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
/*     */     protected IOURingBufStatus getElementFactory() {
/* 286 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("__u32")
/*     */     public int buf_group() {
/* 291 */       return IOURingBufStatus.nbuf_group(address());
/*     */     } @NativeType("__u32")
/*     */     public int head() {
/* 294 */       return IOURingBufStatus.nhead(address());
/*     */     }
/*     */     public Buffer buf_group(@NativeType("__u32") int value) {
/* 297 */       IOURingBufStatus.nbuf_group(address(), value); return this;
/*     */     } public Buffer head(@NativeType("__u32") int value) {
/* 299 */       IOURingBufStatus.nhead(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\liburing\IOURingBufStatus.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */