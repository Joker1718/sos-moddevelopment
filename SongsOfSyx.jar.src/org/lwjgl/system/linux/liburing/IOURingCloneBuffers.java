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
/*     */ 
/*     */ 
/*     */ 
/*     */ @NativeType("struct io_uring_clone_buffers")
/*     */ public class IOURingCloneBuffers
/*     */   extends Struct<IOURingCloneBuffers>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int SRC_FD;
/*     */   public static final int FLAGS;
/*     */   public static final int SRC_OFF;
/*     */   public static final int DST_OFF;
/*     */   public static final int NR;
/*     */   public static final int PAD;
/*     */   
/*     */   static {
/*  49 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  50 */           __member(4), 
/*  51 */           __member(4), 
/*  52 */           __member(4), 
/*  53 */           __member(4), 
/*  54 */           __member(4), 
/*  55 */           __array(4, 3)
/*     */         });
/*     */     
/*  58 */     SIZEOF = layout.getSize();
/*  59 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  61 */     SRC_FD = layout.offsetof(0);
/*  62 */     FLAGS = layout.offsetof(1);
/*  63 */     SRC_OFF = layout.offsetof(2);
/*  64 */     DST_OFF = layout.offsetof(3);
/*  65 */     NR = layout.offsetof(4);
/*  66 */     PAD = layout.offsetof(5);
/*     */   }
/*     */   
/*     */   protected IOURingCloneBuffers(long address, ByteBuffer container) {
/*  70 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected IOURingCloneBuffers create(long address, ByteBuffer container) {
/*  75 */     return new IOURingCloneBuffers(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingCloneBuffers(ByteBuffer container) {
/*  85 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  89 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("__u32")
/*     */   public int src_fd() {
/*  93 */     return nsrc_fd(address());
/*     */   } @NativeType("__u32")
/*     */   public int flags() {
/*  96 */     return nflags(address());
/*     */   } @NativeType("__u32")
/*     */   public int src_off() {
/*  99 */     return nsrc_off(address());
/*     */   } @NativeType("__u32")
/*     */   public int dst_off() {
/* 102 */     return ndst_off(address());
/*     */   } @NativeType("__u32")
/*     */   public int nr() {
/* 105 */     return nnr(address());
/*     */   }
/*     */   public IOURingCloneBuffers src_fd(@NativeType("__u32") int value) {
/* 108 */     nsrc_fd(address(), value); return this;
/*     */   } public IOURingCloneBuffers flags(@NativeType("__u32") int value) {
/* 110 */     nflags(address(), value); return this;
/*     */   } public IOURingCloneBuffers src_off(@NativeType("__u32") int value) {
/* 112 */     nsrc_off(address(), value); return this;
/*     */   } public IOURingCloneBuffers dst_off(@NativeType("__u32") int value) {
/* 114 */     ndst_off(address(), value); return this;
/*     */   } public IOURingCloneBuffers nr(@NativeType("__u32") int value) {
/* 116 */     nnr(address(), value); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingCloneBuffers set(int src_fd, int flags, int src_off, int dst_off, int nr) {
/* 126 */     src_fd(src_fd);
/* 127 */     flags(flags);
/* 128 */     src_off(src_off);
/* 129 */     dst_off(dst_off);
/* 130 */     nr(nr);
/*     */     
/* 132 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingCloneBuffers set(IOURingCloneBuffers src) {
/* 143 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 144 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingCloneBuffers malloc() {
/* 151 */     return new IOURingCloneBuffers(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingCloneBuffers calloc() {
/* 156 */     return new IOURingCloneBuffers(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingCloneBuffers create() {
/* 161 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 162 */     return new IOURingCloneBuffers(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingCloneBuffers create(long address) {
/* 167 */     return new IOURingCloneBuffers(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingCloneBuffers createSafe(long address) {
/* 172 */     return (address == 0L) ? null : new IOURingCloneBuffers(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 181 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 190 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 199 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 200 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 210 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 215 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingCloneBuffers malloc(MemoryStack stack) {
/* 224 */     return new IOURingCloneBuffers(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingCloneBuffers calloc(MemoryStack stack) {
/* 233 */     return new IOURingCloneBuffers(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 243 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 253 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nsrc_fd(long struct) {
/* 259 */     return MemoryUtil.memGetInt(struct + SRC_FD);
/*     */   } public static int nflags(long struct) {
/* 261 */     return MemoryUtil.memGetInt(struct + FLAGS);
/*     */   } public static int nsrc_off(long struct) {
/* 263 */     return MemoryUtil.memGetInt(struct + SRC_OFF);
/*     */   } public static int ndst_off(long struct) {
/* 265 */     return MemoryUtil.memGetInt(struct + DST_OFF);
/*     */   }
/* 267 */   public static int nnr(long struct) { return MemoryUtil.memGetInt(struct + NR); } public static IntBuffer npad(long struct) {
/* 268 */     return MemoryUtil.memIntBuffer(struct + PAD, 3);
/*     */   } public static int npad(long struct, int index) {
/* 270 */     return MemoryUtil.memGetInt(struct + PAD + Checks.check(index, 3) * 4L);
/*     */   }
/*     */   
/*     */   public static void nsrc_fd(long struct, int value) {
/* 274 */     MemoryUtil.memPutInt(struct + SRC_FD, value);
/*     */   } public static void nflags(long struct, int value) {
/* 276 */     MemoryUtil.memPutInt(struct + FLAGS, value);
/*     */   } public static void nsrc_off(long struct, int value) {
/* 278 */     MemoryUtil.memPutInt(struct + SRC_OFF, value);
/*     */   } public static void ndst_off(long struct, int value) {
/* 280 */     MemoryUtil.memPutInt(struct + DST_OFF, value);
/*     */   } public static void nnr(long struct, int value) {
/* 282 */     MemoryUtil.memPutInt(struct + NR, value);
/*     */   } public static void npad(long struct, IntBuffer value) {
/* 284 */     if (Checks.CHECKS) Checks.checkGT(value, 3); 
/* 285 */     MemoryUtil.memCopy(MemoryUtil.memAddress(value), struct + PAD, (value.remaining() * 4));
/*     */   }
/*     */   public static void npad(long struct, int index, int value) {
/* 288 */     MemoryUtil.memPutInt(struct + PAD + Checks.check(index, 3) * 4L, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<IOURingCloneBuffers, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 296 */     private static final IOURingCloneBuffers ELEMENT_FACTORY = IOURingCloneBuffers.create(-1L);
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
/* 308 */       super(container, container.remaining() / IOURingCloneBuffers.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 312 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 316 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 321 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 326 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected IOURingCloneBuffers getElementFactory() {
/* 331 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("__u32")
/*     */     public int src_fd() {
/* 336 */       return IOURingCloneBuffers.nsrc_fd(address());
/*     */     } @NativeType("__u32")
/*     */     public int flags() {
/* 339 */       return IOURingCloneBuffers.nflags(address());
/*     */     } @NativeType("__u32")
/*     */     public int src_off() {
/* 342 */       return IOURingCloneBuffers.nsrc_off(address());
/*     */     } @NativeType("__u32")
/*     */     public int dst_off() {
/* 345 */       return IOURingCloneBuffers.ndst_off(address());
/*     */     } @NativeType("__u32")
/*     */     public int nr() {
/* 348 */       return IOURingCloneBuffers.nnr(address());
/*     */     }
/*     */     public Buffer src_fd(@NativeType("__u32") int value) {
/* 351 */       IOURingCloneBuffers.nsrc_fd(address(), value); return this;
/*     */     } public Buffer flags(@NativeType("__u32") int value) {
/* 353 */       IOURingCloneBuffers.nflags(address(), value); return this;
/*     */     } public Buffer src_off(@NativeType("__u32") int value) {
/* 355 */       IOURingCloneBuffers.nsrc_off(address(), value); return this;
/*     */     } public Buffer dst_off(@NativeType("__u32") int value) {
/* 357 */       IOURingCloneBuffers.ndst_off(address(), value); return this;
/*     */     } public Buffer nr(@NativeType("__u32") int value) {
/* 359 */       IOURingCloneBuffers.nnr(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\liburing\IOURingCloneBuffers.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */