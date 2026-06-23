/*     */ package org.lwjgl.system.libffi;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import org.lwjgl.BufferUtils;
/*     */ import org.lwjgl.PointerBuffer;
/*     */ import org.lwjgl.system.CustomBuffer;
/*     */ import org.lwjgl.system.MemoryStack;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeResource;
/*     */ import org.lwjgl.system.NativeType;
/*     */ import org.lwjgl.system.Pointer;
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
/*     */ @NativeType("struct ffi_type")
/*     */ public class FFIType
/*     */   extends Struct<FFIType>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int SIZE;
/*     */   public static final int ALIGNMENT;
/*     */   public static final int TYPE;
/*     */   public static final int ELEMENTS;
/*     */   
/*     */   static {
/*  44 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  45 */           __member(POINTER_SIZE), 
/*  46 */           __member(2), 
/*  47 */           __member(2), 
/*  48 */           __member(POINTER_SIZE)
/*     */         });
/*     */     
/*  51 */     SIZEOF = layout.getSize();
/*  52 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  54 */     SIZE = layout.offsetof(0);
/*  55 */     ALIGNMENT = layout.offsetof(1);
/*  56 */     TYPE = layout.offsetof(2);
/*  57 */     ELEMENTS = layout.offsetof(3);
/*     */   }
/*     */   
/*     */   protected FFIType(long address, ByteBuffer container) {
/*  61 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected FFIType create(long address, ByteBuffer container) {
/*  66 */     return new FFIType(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FFIType(ByteBuffer container) {
/*  76 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  80 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("size_t")
/*     */   public long size() {
/*  84 */     return nsize(address());
/*     */   } @NativeType("unsigned short")
/*     */   public short alignment() {
/*  87 */     return nalignment(address());
/*     */   } @NativeType("unsigned short")
/*     */   public short type() {
/*  90 */     return ntype(address());
/*     */   } @NativeType("ffi_type *")
/*     */   public PointerBuffer elements(int capacity) {
/*  93 */     return nelements(address(), capacity);
/*     */   }
/*     */   public FFIType size(@NativeType("size_t") long value) {
/*  96 */     nsize(address(), value); return this;
/*     */   } public FFIType alignment(@NativeType("unsigned short") short value) {
/*  98 */     nalignment(address(), value); return this;
/*     */   } public FFIType type(@NativeType("unsigned short") short value) {
/* 100 */     ntype(address(), value); return this;
/*     */   } public FFIType elements(@NativeType("ffi_type *") PointerBuffer value) {
/* 102 */     nelements(address(), value); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FFIType set(long size, short alignment, short type, PointerBuffer elements) {
/* 111 */     size(size);
/* 112 */     alignment(alignment);
/* 113 */     type(type);
/* 114 */     elements(elements);
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
/*     */   public FFIType set(FFIType src) {
/* 127 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 128 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static FFIType malloc() {
/* 135 */     return new FFIType(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static FFIType calloc() {
/* 140 */     return new FFIType(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static FFIType create() {
/* 145 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 146 */     return new FFIType(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static FFIType create(long address) {
/* 151 */     return new FFIType(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static FFIType createSafe(long address) {
/* 156 */     return (address == 0L) ? null : new FFIType(address, null);
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
/*     */   public static FFIType malloc(MemoryStack stack) {
/* 208 */     return new FFIType(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static FFIType calloc(MemoryStack stack) {
/* 217 */     return new FFIType(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
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
/*     */   public static long nsize(long struct) {
/* 243 */     return MemoryUtil.memGetAddress(struct + SIZE);
/*     */   } public static short nalignment(long struct) {
/* 245 */     return MemoryUtil.memGetShort(struct + ALIGNMENT);
/*     */   } public static short ntype(long struct) {
/* 247 */     return MemoryUtil.memGetShort(struct + TYPE);
/*     */   } public static PointerBuffer nelements(long struct, int capacity) {
/* 249 */     return MemoryUtil.memPointerBufferSafe(MemoryUtil.memGetAddress(struct + ELEMENTS), capacity);
/*     */   }
/*     */   public static void nsize(long struct, long value) {
/* 252 */     MemoryUtil.memPutAddress(struct + SIZE, value);
/*     */   } public static void nalignment(long struct, short value) {
/* 254 */     MemoryUtil.memPutShort(struct + ALIGNMENT, value);
/*     */   } public static void ntype(long struct, short value) {
/* 256 */     MemoryUtil.memPutShort(struct + TYPE, value);
/*     */   } public static void nelements(long struct, PointerBuffer value) {
/* 258 */     MemoryUtil.memPutAddress(struct + ELEMENTS, MemoryUtil.memAddressSafe((Pointer)value));
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<FFIType, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 265 */     private static final FFIType ELEMENT_FACTORY = FFIType.create(-1L);
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
/* 277 */       super(container, container.remaining() / FFIType.SIZEOF);
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
/*     */     protected FFIType getElementFactory() {
/* 300 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("size_t")
/*     */     public long size() {
/* 305 */       return FFIType.nsize(address());
/*     */     } @NativeType("unsigned short")
/*     */     public short alignment() {
/* 308 */       return FFIType.nalignment(address());
/*     */     } @NativeType("unsigned short")
/*     */     public short type() {
/* 311 */       return FFIType.ntype(address());
/*     */     } @NativeType("ffi_type *")
/*     */     public PointerBuffer elements(int capacity) {
/* 314 */       return FFIType.nelements(address(), capacity);
/*     */     }
/*     */     public Buffer size(@NativeType("size_t") long value) {
/* 317 */       FFIType.nsize(address(), value); return this;
/*     */     } public Buffer alignment(@NativeType("unsigned short") short value) {
/* 319 */       FFIType.nalignment(address(), value); return this;
/*     */     } public Buffer type(@NativeType("unsigned short") short value) {
/* 321 */       FFIType.ntype(address(), value); return this;
/*     */     } public Buffer elements(@NativeType("ffi_type *") PointerBuffer value) {
/* 323 */       FFIType.nelements(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\libffi\FFIType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */