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
/*     */ @NativeType("struct open_how")
/*     */ public class OpenHow
/*     */   extends Struct<OpenHow>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int FLAGS;
/*     */   public static final int MODE;
/*     */   public static final int RESOLVE;
/*     */   
/*     */   static {
/*  42 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  43 */           __member(8), 
/*  44 */           __member(8), 
/*  45 */           __member(8)
/*     */         });
/*     */     
/*  48 */     SIZEOF = layout.getSize();
/*  49 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  51 */     FLAGS = layout.offsetof(0);
/*  52 */     MODE = layout.offsetof(1);
/*  53 */     RESOLVE = layout.offsetof(2);
/*     */   }
/*     */   
/*     */   protected OpenHow(long address, ByteBuffer container) {
/*  57 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected OpenHow create(long address, ByteBuffer container) {
/*  62 */     return new OpenHow(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public OpenHow(ByteBuffer container) {
/*  72 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  76 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("__u64")
/*     */   public long flags() {
/*  80 */     return nflags(address());
/*     */   } @NativeType("__u64")
/*     */   public long mode() {
/*  83 */     return nmode(address());
/*     */   } @NativeType("__u64")
/*     */   public long resolve() {
/*  86 */     return nresolve(address());
/*     */   }
/*     */   public OpenHow flags(@NativeType("__u64") long value) {
/*  89 */     nflags(address(), value); return this;
/*     */   } public OpenHow mode(@NativeType("__u64") long value) {
/*  91 */     nmode(address(), value); return this;
/*     */   } public OpenHow resolve(@NativeType("__u64") long value) {
/*  93 */     nresolve(address(), value); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public OpenHow set(long flags, long mode, long resolve) {
/* 101 */     flags(flags);
/* 102 */     mode(mode);
/* 103 */     resolve(resolve);
/*     */     
/* 105 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public OpenHow set(OpenHow src) {
/* 116 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 117 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static OpenHow malloc() {
/* 124 */     return new OpenHow(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static OpenHow calloc() {
/* 129 */     return new OpenHow(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static OpenHow create() {
/* 134 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 135 */     return new OpenHow(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static OpenHow create(long address) {
/* 140 */     return new OpenHow(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static OpenHow createSafe(long address) {
/* 145 */     return (address == 0L) ? null : new OpenHow(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 154 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 163 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 172 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 173 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 183 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 188 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static OpenHow malloc(MemoryStack stack) {
/* 197 */     return new OpenHow(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static OpenHow calloc(MemoryStack stack) {
/* 206 */     return new OpenHow(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 216 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 226 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nflags(long struct) {
/* 232 */     return MemoryUtil.memGetLong(struct + FLAGS);
/*     */   } public static long nmode(long struct) {
/* 234 */     return MemoryUtil.memGetLong(struct + MODE);
/*     */   } public static long nresolve(long struct) {
/* 236 */     return MemoryUtil.memGetLong(struct + RESOLVE);
/*     */   }
/*     */   public static void nflags(long struct, long value) {
/* 239 */     MemoryUtil.memPutLong(struct + FLAGS, value);
/*     */   } public static void nmode(long struct, long value) {
/* 241 */     MemoryUtil.memPutLong(struct + MODE, value);
/*     */   } public static void nresolve(long struct, long value) {
/* 243 */     MemoryUtil.memPutLong(struct + RESOLVE, value);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<OpenHow, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 250 */     private static final OpenHow ELEMENT_FACTORY = OpenHow.create(-1L);
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
/* 262 */       super(container, container.remaining() / OpenHow.SIZEOF);
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
/*     */     protected OpenHow getElementFactory() {
/* 285 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("__u64")
/*     */     public long flags() {
/* 290 */       return OpenHow.nflags(address());
/*     */     } @NativeType("__u64")
/*     */     public long mode() {
/* 293 */       return OpenHow.nmode(address());
/*     */     } @NativeType("__u64")
/*     */     public long resolve() {
/* 296 */       return OpenHow.nresolve(address());
/*     */     }
/*     */     public Buffer flags(@NativeType("__u64") long value) {
/* 299 */       OpenHow.nflags(address(), value); return this;
/*     */     } public Buffer mode(@NativeType("__u64") long value) {
/* 301 */       OpenHow.nmode(address(), value); return this;
/*     */     } public Buffer resolve(@NativeType("__u64") long value) {
/* 303 */       OpenHow.nresolve(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\OpenHow.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */