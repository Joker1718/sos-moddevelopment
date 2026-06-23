/*     */ package org.lwjgl.stb;
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
/*     */ @NativeType("struct stb_vorbis_alloc")
/*     */ public class STBVorbisAlloc
/*     */   extends Struct<STBVorbisAlloc>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int ALLOC_BUFFER;
/*     */   public static final int ALLOC_BUFFER_LENGTH_IN_BYTES;
/*     */   
/*     */   static {
/*  41 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  42 */           __member(POINTER_SIZE), 
/*  43 */           __member(4)
/*     */         });
/*     */     
/*  46 */     SIZEOF = layout.getSize();
/*  47 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  49 */     ALLOC_BUFFER = layout.offsetof(0);
/*  50 */     ALLOC_BUFFER_LENGTH_IN_BYTES = layout.offsetof(1);
/*     */   }
/*     */   
/*     */   protected STBVorbisAlloc(long address, ByteBuffer container) {
/*  54 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected STBVorbisAlloc create(long address, ByteBuffer container) {
/*  59 */     return new STBVorbisAlloc(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public STBVorbisAlloc(ByteBuffer container) {
/*  69 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  73 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("char *")
/*     */   public ByteBuffer alloc_buffer() {
/*  77 */     return nalloc_buffer(address());
/*     */   } public int alloc_buffer_length_in_bytes() {
/*  79 */     return nalloc_buffer_length_in_bytes(address());
/*     */   }
/*     */   public STBVorbisAlloc alloc_buffer(@NativeType("char *") ByteBuffer value) {
/*  82 */     nalloc_buffer(address(), value); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public STBVorbisAlloc set(STBVorbisAlloc src) {
/*  92 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/*  93 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBVorbisAlloc malloc() {
/* 100 */     return new STBVorbisAlloc(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBVorbisAlloc calloc() {
/* 105 */     return new STBVorbisAlloc(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBVorbisAlloc create() {
/* 110 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 111 */     return new STBVorbisAlloc(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBVorbisAlloc create(long address) {
/* 116 */     return new STBVorbisAlloc(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBVorbisAlloc createSafe(long address) {
/* 121 */     return (address == 0L) ? null : new STBVorbisAlloc(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 130 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 139 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 148 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 149 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 159 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 164 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBVorbisAlloc malloc(MemoryStack stack) {
/* 173 */     return new STBVorbisAlloc(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBVorbisAlloc calloc(MemoryStack stack) {
/* 182 */     return new STBVorbisAlloc(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 192 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 202 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static ByteBuffer nalloc_buffer(long struct) {
/* 208 */     return MemoryUtil.memByteBuffer(MemoryUtil.memGetAddress(struct + ALLOC_BUFFER), nalloc_buffer_length_in_bytes(struct));
/*     */   } public static int nalloc_buffer_length_in_bytes(long struct) {
/* 210 */     return MemoryUtil.memGetInt(struct + ALLOC_BUFFER_LENGTH_IN_BYTES);
/*     */   }
/*     */   public static void nalloc_buffer(long struct, ByteBuffer value) {
/* 213 */     MemoryUtil.memPutAddress(struct + ALLOC_BUFFER, MemoryUtil.memAddress(value)); nalloc_buffer_length_in_bytes(struct, value.remaining());
/*     */   } public static void nalloc_buffer_length_in_bytes(long struct, int value) {
/* 215 */     MemoryUtil.memPutInt(struct + ALLOC_BUFFER_LENGTH_IN_BYTES, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long struct) {
/* 223 */     Checks.check(MemoryUtil.memGetAddress(struct + ALLOC_BUFFER));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<STBVorbisAlloc, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 231 */     private static final STBVorbisAlloc ELEMENT_FACTORY = STBVorbisAlloc.create(-1L);
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
/* 243 */       super(container, container.remaining() / STBVorbisAlloc.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 247 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 251 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 256 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 261 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected STBVorbisAlloc getElementFactory() {
/* 266 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("char *")
/*     */     public ByteBuffer alloc_buffer() {
/* 271 */       return STBVorbisAlloc.nalloc_buffer(address());
/*     */     } public int alloc_buffer_length_in_bytes() {
/* 273 */       return STBVorbisAlloc.nalloc_buffer_length_in_bytes(address());
/*     */     }
/*     */     public Buffer alloc_buffer(@NativeType("char *") ByteBuffer value) {
/* 276 */       STBVorbisAlloc.nalloc_buffer(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\stb\STBVorbisAlloc.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */