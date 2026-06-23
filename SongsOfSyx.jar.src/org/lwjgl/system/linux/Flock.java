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
/*     */ 
/*     */ 
/*     */ 
/*     */ @NativeType("struct flock64")
/*     */ public class Flock
/*     */   extends Struct<Flock>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int L_TYPE;
/*     */   public static final int L_WHENCE;
/*     */   public static final int L_START;
/*     */   public static final int L_LEN;
/*     */   public static final int L_PID;
/*     */   
/*     */   static {
/*  46 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  47 */           __member(2), 
/*  48 */           __member(2), 
/*  49 */           __member(8), 
/*  50 */           __member(8), 
/*  51 */           __member(4)
/*     */         });
/*     */     
/*  54 */     SIZEOF = layout.getSize();
/*  55 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  57 */     L_TYPE = layout.offsetof(0);
/*  58 */     L_WHENCE = layout.offsetof(1);
/*  59 */     L_START = layout.offsetof(2);
/*  60 */     L_LEN = layout.offsetof(3);
/*  61 */     L_PID = layout.offsetof(4);
/*     */   }
/*     */   
/*     */   protected Flock(long address, ByteBuffer container) {
/*  65 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected Flock create(long address, ByteBuffer container) {
/*  70 */     return new Flock(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Flock(ByteBuffer container) {
/*  80 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  84 */     return SIZEOF;
/*     */   }
/*     */   public short l_type() {
/*  87 */     return nl_type(address());
/*     */   } public short l_whence() {
/*  89 */     return nl_whence(address());
/*     */   } @NativeType("off_t")
/*     */   public long l_start() {
/*  92 */     return nl_start(address());
/*     */   } @NativeType("off_t")
/*     */   public long l_len() {
/*  95 */     return nl_len(address());
/*     */   } @NativeType("pid_t")
/*     */   public int l_pid() {
/*  98 */     return nl_pid(address());
/*     */   }
/*     */   public Flock l_type(short value) {
/* 101 */     nl_type(address(), value); return this;
/*     */   } public Flock l_whence(short value) {
/* 103 */     nl_whence(address(), value); return this;
/*     */   } public Flock l_start(@NativeType("off_t") long value) {
/* 105 */     nl_start(address(), value); return this;
/*     */   } public Flock l_len(@NativeType("off_t") long value) {
/* 107 */     nl_len(address(), value); return this;
/*     */   } public Flock l_pid(@NativeType("pid_t") int value) {
/* 109 */     nl_pid(address(), value); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Flock set(short l_type, short l_whence, long l_start, long l_len, int l_pid) {
/* 119 */     l_type(l_type);
/* 120 */     l_whence(l_whence);
/* 121 */     l_start(l_start);
/* 122 */     l_len(l_len);
/* 123 */     l_pid(l_pid);
/*     */     
/* 125 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Flock set(Flock src) {
/* 136 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 137 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Flock malloc() {
/* 144 */     return new Flock(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Flock calloc() {
/* 149 */     return new Flock(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Flock create() {
/* 154 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 155 */     return new Flock(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Flock create(long address) {
/* 160 */     return new Flock(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Flock createSafe(long address) {
/* 165 */     return (address == 0L) ? null : new Flock(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 174 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 183 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 192 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 193 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 203 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 208 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Flock malloc(MemoryStack stack) {
/* 217 */     return new Flock(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Flock calloc(MemoryStack stack) {
/* 226 */     return new Flock(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 236 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 246 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static short nl_type(long struct) {
/* 252 */     return MemoryUtil.memGetShort(struct + L_TYPE);
/*     */   } public static short nl_whence(long struct) {
/* 254 */     return MemoryUtil.memGetShort(struct + L_WHENCE);
/*     */   } public static long nl_start(long struct) {
/* 256 */     return MemoryUtil.memGetLong(struct + L_START);
/*     */   } public static long nl_len(long struct) {
/* 258 */     return MemoryUtil.memGetLong(struct + L_LEN);
/*     */   } public static int nl_pid(long struct) {
/* 260 */     return MemoryUtil.memGetInt(struct + L_PID);
/*     */   }
/*     */   public static void nl_type(long struct, short value) {
/* 263 */     MemoryUtil.memPutShort(struct + L_TYPE, value);
/*     */   } public static void nl_whence(long struct, short value) {
/* 265 */     MemoryUtil.memPutShort(struct + L_WHENCE, value);
/*     */   } public static void nl_start(long struct, long value) {
/* 267 */     MemoryUtil.memPutLong(struct + L_START, value);
/*     */   } public static void nl_len(long struct, long value) {
/* 269 */     MemoryUtil.memPutLong(struct + L_LEN, value);
/*     */   } public static void nl_pid(long struct, int value) {
/* 271 */     MemoryUtil.memPutInt(struct + L_PID, value);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<Flock, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 278 */     private static final Flock ELEMENT_FACTORY = Flock.create(-1L);
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
/* 290 */       super(container, container.remaining() / Flock.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 294 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 298 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 303 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 308 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Flock getElementFactory() {
/* 313 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     public short l_type() {
/* 317 */       return Flock.nl_type(address());
/*     */     } public short l_whence() {
/* 319 */       return Flock.nl_whence(address());
/*     */     } @NativeType("off_t")
/*     */     public long l_start() {
/* 322 */       return Flock.nl_start(address());
/*     */     } @NativeType("off_t")
/*     */     public long l_len() {
/* 325 */       return Flock.nl_len(address());
/*     */     } @NativeType("pid_t")
/*     */     public int l_pid() {
/* 328 */       return Flock.nl_pid(address());
/*     */     }
/*     */     public Buffer l_type(short value) {
/* 331 */       Flock.nl_type(address(), value); return this;
/*     */     } public Buffer l_whence(short value) {
/* 333 */       Flock.nl_whence(address(), value); return this;
/*     */     } public Buffer l_start(@NativeType("off_t") long value) {
/* 335 */       Flock.nl_start(address(), value); return this;
/*     */     } public Buffer l_len(@NativeType("off_t") long value) {
/* 337 */       Flock.nl_len(address(), value); return this;
/*     */     } public Buffer l_pid(@NativeType("pid_t") int value) {
/* 339 */       Flock.nl_pid(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\Flock.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */