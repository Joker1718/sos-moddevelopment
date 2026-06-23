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
/*     */ 
/*     */ 
/*     */ 
/*     */ @NativeType("struct msghdr")
/*     */ public class Msghdr
/*     */   extends Struct<Msghdr>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int MSG_NAME;
/*     */   public static final int MSG_NAMELEN;
/*     */   public static final int MSG_IOV;
/*     */   public static final int MSG_IOVLEN;
/*     */   public static final int MSG_CONTROL;
/*     */   public static final int MSG_CONTROLLEN;
/*     */   public static final int MSG_FLAGS;
/*     */   
/*     */   static {
/*  51 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  52 */           __member(POINTER_SIZE), 
/*  53 */           __member(4), 
/*  54 */           __member(POINTER_SIZE), 
/*  55 */           __member(POINTER_SIZE), 
/*  56 */           __member(POINTER_SIZE), 
/*  57 */           __member(POINTER_SIZE), 
/*  58 */           __member(4)
/*     */         });
/*     */     
/*  61 */     SIZEOF = layout.getSize();
/*  62 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  64 */     MSG_NAME = layout.offsetof(0);
/*  65 */     MSG_NAMELEN = layout.offsetof(1);
/*  66 */     MSG_IOV = layout.offsetof(2);
/*  67 */     MSG_IOVLEN = layout.offsetof(3);
/*  68 */     MSG_CONTROL = layout.offsetof(4);
/*  69 */     MSG_CONTROLLEN = layout.offsetof(5);
/*  70 */     MSG_FLAGS = layout.offsetof(6);
/*     */   }
/*     */   
/*     */   protected Msghdr(long address, ByteBuffer container) {
/*  74 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected Msghdr create(long address, ByteBuffer container) {
/*  79 */     return new Msghdr(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Msghdr(ByteBuffer container) {
/*  89 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  93 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("void *")
/*     */   public ByteBuffer msg_name() {
/*  97 */     return nmsg_name(address());
/*     */   } @NativeType("socklen_t")
/*     */   public int msg_namelen() {
/* 100 */     return nmsg_namelen(address());
/*     */   } @NativeType("struct iovec *")
/*     */   public IOVec.Buffer msg_iov() {
/* 103 */     return nmsg_iov(address());
/*     */   } @NativeType("size_t")
/*     */   public long msg_iovlen() {
/* 106 */     return nmsg_iovlen(address());
/*     */   } @NativeType("void *")
/*     */   public ByteBuffer msg_control() {
/* 109 */     return nmsg_control(address());
/*     */   } @NativeType("size_t")
/*     */   public long msg_controllen() {
/* 112 */     return nmsg_controllen(address());
/*     */   } public int msg_flags() {
/* 114 */     return nmsg_flags(address());
/*     */   }
/*     */   public Msghdr msg_name(@NativeType("void *") ByteBuffer value) {
/* 117 */     nmsg_name(address(), value); return this;
/*     */   } public Msghdr msg_iov(@NativeType("struct iovec *") IOVec.Buffer value) {
/* 119 */     nmsg_iov(address(), value); return this;
/*     */   } public Msghdr msg_control(@NativeType("void *") ByteBuffer value) {
/* 121 */     nmsg_control(address(), value); return this;
/*     */   } public Msghdr msg_flags(int value) {
/* 123 */     nmsg_flags(address(), value); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Msghdr set(ByteBuffer msg_name, IOVec.Buffer msg_iov, ByteBuffer msg_control, int msg_flags) {
/* 132 */     msg_name(msg_name);
/* 133 */     msg_iov(msg_iov);
/* 134 */     msg_control(msg_control);
/* 135 */     msg_flags(msg_flags);
/*     */     
/* 137 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Msghdr set(Msghdr src) {
/* 148 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 149 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Msghdr malloc() {
/* 156 */     return new Msghdr(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Msghdr calloc() {
/* 161 */     return new Msghdr(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Msghdr create() {
/* 166 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 167 */     return new Msghdr(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Msghdr create(long address) {
/* 172 */     return new Msghdr(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Msghdr createSafe(long address) {
/* 177 */     return (address == 0L) ? null : new Msghdr(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 186 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 195 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 204 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 205 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 215 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 220 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Msghdr malloc(MemoryStack stack) {
/* 229 */     return new Msghdr(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Msghdr calloc(MemoryStack stack) {
/* 238 */     return new Msghdr(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 248 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 258 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static ByteBuffer nmsg_name(long struct) {
/* 264 */     return MemoryUtil.memByteBuffer(MemoryUtil.memGetAddress(struct + MSG_NAME), nmsg_namelen(struct));
/*     */   } public static int nmsg_namelen(long struct) {
/* 266 */     return MemoryUtil.memGetInt(struct + MSG_NAMELEN);
/*     */   } public static IOVec.Buffer nmsg_iov(long struct) {
/* 268 */     return IOVec.create(MemoryUtil.memGetAddress(struct + MSG_IOV), (int)nmsg_iovlen(struct));
/*     */   } public static long nmsg_iovlen(long struct) {
/* 270 */     return MemoryUtil.memGetAddress(struct + MSG_IOVLEN);
/*     */   } public static ByteBuffer nmsg_control(long struct) {
/* 272 */     return MemoryUtil.memByteBuffer(MemoryUtil.memGetAddress(struct + MSG_CONTROL), (int)nmsg_controllen(struct));
/*     */   } public static long nmsg_controllen(long struct) {
/* 274 */     return MemoryUtil.memGetAddress(struct + MSG_CONTROLLEN);
/*     */   } public static int nmsg_flags(long struct) {
/* 276 */     return MemoryUtil.memGetInt(struct + MSG_FLAGS);
/*     */   }
/*     */   public static void nmsg_name(long struct, ByteBuffer value) {
/* 279 */     MemoryUtil.memPutAddress(struct + MSG_NAME, MemoryUtil.memAddress(value)); nmsg_namelen(struct, value.remaining());
/*     */   } public static void nmsg_namelen(long struct, int value) {
/* 281 */     MemoryUtil.memPutInt(struct + MSG_NAMELEN, value);
/*     */   } public static void nmsg_iov(long struct, IOVec.Buffer value) {
/* 283 */     MemoryUtil.memPutAddress(struct + MSG_IOV, value.address()); nmsg_iovlen(struct, value.remaining());
/*     */   } public static void nmsg_iovlen(long struct, long value) {
/* 285 */     MemoryUtil.memPutAddress(struct + MSG_IOVLEN, value);
/*     */   } public static void nmsg_control(long struct, ByteBuffer value) {
/* 287 */     MemoryUtil.memPutAddress(struct + MSG_CONTROL, MemoryUtil.memAddress(value)); nmsg_controllen(struct, value.remaining());
/*     */   } public static void nmsg_controllen(long struct, long value) {
/* 289 */     MemoryUtil.memPutAddress(struct + MSG_CONTROLLEN, value);
/*     */   } public static void nmsg_flags(long struct, int value) {
/* 291 */     MemoryUtil.memPutInt(struct + MSG_FLAGS, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long struct) {
/* 299 */     Checks.check(MemoryUtil.memGetAddress(struct + MSG_NAME));
/* 300 */     Checks.check(MemoryUtil.memGetAddress(struct + MSG_IOV));
/* 301 */     Checks.check(MemoryUtil.memGetAddress(struct + MSG_CONTROL));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<Msghdr, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 309 */     private static final Msghdr ELEMENT_FACTORY = Msghdr.create(-1L);
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
/* 321 */       super(container, container.remaining() / Msghdr.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 325 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 329 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 334 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 339 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Msghdr getElementFactory() {
/* 344 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("void *")
/*     */     public ByteBuffer msg_name() {
/* 349 */       return Msghdr.nmsg_name(address());
/*     */     } @NativeType("socklen_t")
/*     */     public int msg_namelen() {
/* 352 */       return Msghdr.nmsg_namelen(address());
/*     */     } @NativeType("struct iovec *")
/*     */     public IOVec.Buffer msg_iov() {
/* 355 */       return Msghdr.nmsg_iov(address());
/*     */     } @NativeType("size_t")
/*     */     public long msg_iovlen() {
/* 358 */       return Msghdr.nmsg_iovlen(address());
/*     */     } @NativeType("void *")
/*     */     public ByteBuffer msg_control() {
/* 361 */       return Msghdr.nmsg_control(address());
/*     */     } @NativeType("size_t")
/*     */     public long msg_controllen() {
/* 364 */       return Msghdr.nmsg_controllen(address());
/*     */     } public int msg_flags() {
/* 366 */       return Msghdr.nmsg_flags(address());
/*     */     }
/*     */     public Buffer msg_name(@NativeType("void *") ByteBuffer value) {
/* 369 */       Msghdr.nmsg_name(address(), value); return this;
/*     */     } public Buffer msg_iov(@NativeType("struct iovec *") IOVec.Buffer value) {
/* 371 */       Msghdr.nmsg_iov(address(), value); return this;
/*     */     } public Buffer msg_control(@NativeType("void *") ByteBuffer value) {
/* 373 */       Msghdr.nmsg_control(address(), value); return this;
/*     */     } public Buffer msg_flags(int value) {
/* 375 */       Msghdr.nmsg_flags(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\Msghdr.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */