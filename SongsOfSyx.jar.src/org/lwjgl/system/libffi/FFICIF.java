/*     */ package org.lwjgl.system.libffi;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import org.lwjgl.BufferUtils;
/*     */ import org.lwjgl.PointerBuffer;
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
/*     */ @NativeType("struct ffi_cif")
/*     */ public class FFICIF
/*     */   extends Struct<FFICIF>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int ABI;
/*     */   public static final int NARGS;
/*     */   public static final int ARG_TYPES;
/*     */   public static final int RTYPE;
/*     */   public static final int BYTES;
/*     */   public static final int FLAGS;
/*     */   
/*     */   static {
/*  48 */     try (MemoryStack stack = MemoryStack.stackPush()) {
/*  49 */       IntBuffer offsets = stack.mallocInt(7);
/*  50 */       SIZEOF = offsets(MemoryUtil.memAddress(offsets));
/*     */       
/*  52 */       ABI = offsets.get(0);
/*  53 */       NARGS = offsets.get(1);
/*  54 */       ARG_TYPES = offsets.get(2);
/*  55 */       RTYPE = offsets.get(3);
/*  56 */       BYTES = offsets.get(4);
/*  57 */       FLAGS = offsets.get(5);
/*     */       
/*  59 */       ALIGNOF = offsets.get(6);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected FFICIF(long address, ByteBuffer container) {
/*  66 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected FFICIF create(long address, ByteBuffer container) {
/*  71 */     return new FFICIF(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FFICIF(ByteBuffer container) {
/*  81 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  85 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("ffi_abi")
/*     */   public int abi() {
/*  89 */     return nabi(address());
/*     */   } @NativeType("unsigned")
/*     */   public int nargs() {
/*  92 */     return nnargs(address());
/*     */   } @NativeType("ffi_type **")
/*     */   public PointerBuffer arg_types() {
/*  95 */     return narg_types(address());
/*     */   } @NativeType("ffi_type *")
/*     */   public FFIType rtype() {
/*  98 */     return nrtype(address());
/*     */   } @NativeType("unsigned")
/*     */   public int bytes() {
/* 101 */     return nbytes(address());
/*     */   } @NativeType("unsigned")
/*     */   public int flags() {
/* 104 */     return nflags(address());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static FFICIF malloc() {
/* 110 */     return new FFICIF(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static FFICIF calloc() {
/* 115 */     return new FFICIF(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static FFICIF create() {
/* 120 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 121 */     return new FFICIF(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static FFICIF create(long address) {
/* 126 */     return new FFICIF(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static FFICIF createSafe(long address) {
/* 131 */     return (address == 0L) ? null : new FFICIF(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 140 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 149 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 158 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 159 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 169 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 174 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static FFICIF malloc(MemoryStack stack) {
/* 183 */     return new FFICIF(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static FFICIF calloc(MemoryStack stack) {
/* 192 */     return new FFICIF(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 202 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 212 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nabi(long struct) {
/* 218 */     return MemoryUtil.memGetInt(struct + ABI);
/*     */   } public static int nnargs(long struct) {
/* 220 */     return MemoryUtil.memGetInt(struct + NARGS);
/*     */   } public static PointerBuffer narg_types(long struct) {
/* 222 */     return MemoryUtil.memPointerBuffer(MemoryUtil.memGetAddress(struct + ARG_TYPES), nnargs(struct));
/*     */   } public static FFIType nrtype(long struct) {
/* 224 */     return FFIType.create(MemoryUtil.memGetAddress(struct + RTYPE));
/*     */   } public static int nbytes(long struct) {
/* 226 */     return MemoryUtil.memGetInt(struct + BYTES);
/*     */   } public static int nflags(long struct) {
/* 228 */     return MemoryUtil.memGetInt(struct + FLAGS);
/*     */   }
/*     */   
/*     */   private static native int offsets(long paramLong);
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<FFICIF, Buffer> implements NativeResource {
/* 235 */     private static final FFICIF ELEMENT_FACTORY = FFICIF.create(-1L);
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
/* 247 */       super(container, container.remaining() / FFICIF.SIZEOF);
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
/*     */     protected FFICIF getElementFactory() {
/* 270 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("ffi_abi")
/*     */     public int abi() {
/* 275 */       return FFICIF.nabi(address());
/*     */     } @NativeType("unsigned")
/*     */     public int nargs() {
/* 278 */       return FFICIF.nnargs(address());
/*     */     } @NativeType("ffi_type **")
/*     */     public PointerBuffer arg_types() {
/* 281 */       return FFICIF.narg_types(address());
/*     */     } @NativeType("ffi_type *")
/*     */     public FFIType rtype() {
/* 284 */       return FFICIF.nrtype(address());
/*     */     } @NativeType("unsigned")
/*     */     public int bytes() {
/* 287 */       return FFICIF.nbytes(address());
/*     */     } @NativeType("unsigned")
/*     */     public int flags() {
/* 290 */       return FFICIF.nflags(address());
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\libffi\FFICIF.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */