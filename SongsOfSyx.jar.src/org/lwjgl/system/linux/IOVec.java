/*     */ package org.lwjgl.system.linux;
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
/*     */ @NativeType("struct iovec")
/*     */ public class IOVec
/*     */   extends Struct<IOVec>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int IOV_BASE;
/*     */   public static final int IOV_LEN;
/*     */   
/*     */   static {
/*  40 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  41 */           __member(POINTER_SIZE), 
/*  42 */           __member(POINTER_SIZE)
/*     */         });
/*     */     
/*  45 */     SIZEOF = layout.getSize();
/*  46 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  48 */     IOV_BASE = layout.offsetof(0);
/*  49 */     IOV_LEN = layout.offsetof(1);
/*     */   }
/*     */   
/*     */   protected IOVec(long address, ByteBuffer container) {
/*  53 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected IOVec create(long address, ByteBuffer container) {
/*  58 */     return new IOVec(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOVec(ByteBuffer container) {
/*  68 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  72 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("void *")
/*     */   public ByteBuffer iov_base() {
/*  76 */     return niov_base(address());
/*     */   } @NativeType("size_t")
/*     */   public long iov_len() {
/*  79 */     return niov_len(address());
/*     */   }
/*     */   public IOVec iov_base(@NativeType("void *") ByteBuffer value) {
/*  82 */     niov_base(address(), value); return this;
/*     */   } public IOVec iov_len(@NativeType("size_t") long value) {
/*  84 */     niov_len(address(), value); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOVec set(ByteBuffer iov_base, long iov_len) {
/*  91 */     iov_base(iov_base);
/*  92 */     iov_len(iov_len);
/*     */     
/*  94 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOVec set(IOVec src) {
/* 105 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 106 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOVec malloc() {
/* 113 */     return new IOVec(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOVec calloc() {
/* 118 */     return new IOVec(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOVec create() {
/* 123 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 124 */     return new IOVec(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOVec create(long address) {
/* 129 */     return new IOVec(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOVec createSafe(long address) {
/* 134 */     return (address == 0L) ? null : new IOVec(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 143 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 152 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 161 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 162 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 172 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 177 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOVec malloc(MemoryStack stack) {
/* 186 */     return new IOVec(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOVec calloc(MemoryStack stack) {
/* 195 */     return new IOVec(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 205 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 215 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static ByteBuffer niov_base(long struct) {
/* 221 */     return MemoryUtil.memByteBufferSafe(MemoryUtil.memGetAddress(struct + IOV_BASE), (int)niov_len(struct));
/*     */   } public static long niov_len(long struct) {
/* 223 */     return MemoryUtil.memGetAddress(struct + IOV_LEN);
/*     */   }
/*     */   public static void niov_base(long struct, ByteBuffer value) {
/* 226 */     MemoryUtil.memPutAddress(struct + IOV_BASE, MemoryUtil.memAddressSafe(value));
/*     */   } public static void niov_len(long struct, long value) {
/* 228 */     MemoryUtil.memPutAddress(struct + IOV_LEN, value);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<IOVec, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 235 */     private static final IOVec ELEMENT_FACTORY = IOVec.create(-1L);
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
/* 247 */       super(container, container.remaining() / IOVec.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 251 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 255 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 260 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 265 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected IOVec getElementFactory() {
/* 270 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("void *")
/*     */     public ByteBuffer iov_base() {
/* 275 */       return IOVec.niov_base(address());
/*     */     } @NativeType("size_t")
/*     */     public long iov_len() {
/* 278 */       return IOVec.niov_len(address());
/*     */     }
/*     */     public Buffer iov_base(@NativeType("void *") ByteBuffer value) {
/* 281 */       IOVec.niov_base(address(), value); return this;
/*     */     } public Buffer iov_len(@NativeType("size_t") long value) {
/* 283 */       IOVec.niov_len(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\IOVec.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */