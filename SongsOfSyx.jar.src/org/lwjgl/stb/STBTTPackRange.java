/*     */ package org.lwjgl.stb;
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
/*     */ 
/*     */ @NativeType("struct stbtt_pack_range")
/*     */ public class STBTTPackRange
/*     */   extends Struct<STBTTPackRange>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int FONT_SIZE;
/*     */   public static final int FIRST_UNICODE_CODEPOINT_IN_RANGE;
/*     */   public static final int ARRAY_OF_UNICODE_CODEPOINTS;
/*     */   public static final int NUM_CHARS;
/*     */   public static final int CHARDATA_FOR_RANGE;
/*     */   public static final int H_OVERSAMPLE;
/*     */   public static final int V_OVERSAMPLE;
/*     */   
/*     */   static {
/*  51 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  52 */           __member(4), 
/*  53 */           __member(4), 
/*  54 */           __member(POINTER_SIZE), 
/*  55 */           __member(4), 
/*  56 */           __member(POINTER_SIZE), 
/*  57 */           __member(1), 
/*  58 */           __member(1)
/*     */         });
/*     */     
/*  61 */     SIZEOF = layout.getSize();
/*  62 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  64 */     FONT_SIZE = layout.offsetof(0);
/*  65 */     FIRST_UNICODE_CODEPOINT_IN_RANGE = layout.offsetof(1);
/*  66 */     ARRAY_OF_UNICODE_CODEPOINTS = layout.offsetof(2);
/*  67 */     NUM_CHARS = layout.offsetof(3);
/*  68 */     CHARDATA_FOR_RANGE = layout.offsetof(4);
/*  69 */     H_OVERSAMPLE = layout.offsetof(5);
/*  70 */     V_OVERSAMPLE = layout.offsetof(6);
/*     */   }
/*     */   
/*     */   protected STBTTPackRange(long address, ByteBuffer container) {
/*  74 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected STBTTPackRange create(long address, ByteBuffer container) {
/*  79 */     return new STBTTPackRange(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public STBTTPackRange(ByteBuffer container) {
/*  89 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  93 */     return SIZEOF;
/*     */   }
/*     */   public float font_size() {
/*  96 */     return nfont_size(address());
/*     */   } public int first_unicode_codepoint_in_range() {
/*  98 */     return nfirst_unicode_codepoint_in_range(address());
/*     */   } @NativeType("int *")
/*     */   public IntBuffer array_of_unicode_codepoints() {
/* 101 */     return narray_of_unicode_codepoints(address());
/*     */   } public int num_chars() {
/* 103 */     return nnum_chars(address());
/*     */   } @NativeType("stbtt_packedchar *")
/*     */   public STBTTPackedchar.Buffer chardata_for_range() {
/* 106 */     return nchardata_for_range(address());
/*     */   } @NativeType("unsigned char")
/*     */   public byte h_oversample() {
/* 109 */     return nh_oversample(address());
/*     */   } @NativeType("unsigned char")
/*     */   public byte v_oversample() {
/* 112 */     return nv_oversample(address());
/*     */   }
/*     */   public STBTTPackRange font_size(float value) {
/* 115 */     nfont_size(address(), value); return this;
/*     */   } public STBTTPackRange first_unicode_codepoint_in_range(int value) {
/* 117 */     nfirst_unicode_codepoint_in_range(address(), value); return this;
/*     */   } public STBTTPackRange array_of_unicode_codepoints(@NativeType("int *") IntBuffer value) {
/* 119 */     narray_of_unicode_codepoints(address(), value); return this;
/*     */   } public STBTTPackRange num_chars(int value) {
/* 121 */     nnum_chars(address(), value); return this;
/*     */   } public STBTTPackRange chardata_for_range(@NativeType("stbtt_packedchar *") STBTTPackedchar.Buffer value) {
/* 123 */     nchardata_for_range(address(), value); return this;
/*     */   } public STBTTPackRange h_oversample(@NativeType("unsigned char") byte value) {
/* 125 */     nh_oversample(address(), value); return this;
/*     */   } public STBTTPackRange v_oversample(@NativeType("unsigned char") byte value) {
/* 127 */     nv_oversample(address(), value); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public STBTTPackRange set(float font_size, int first_unicode_codepoint_in_range, IntBuffer array_of_unicode_codepoints, int num_chars, STBTTPackedchar.Buffer chardata_for_range, byte h_oversample, byte v_oversample) {
/* 139 */     font_size(font_size);
/* 140 */     first_unicode_codepoint_in_range(first_unicode_codepoint_in_range);
/* 141 */     array_of_unicode_codepoints(array_of_unicode_codepoints);
/* 142 */     num_chars(num_chars);
/* 143 */     chardata_for_range(chardata_for_range);
/* 144 */     h_oversample(h_oversample);
/* 145 */     v_oversample(v_oversample);
/*     */     
/* 147 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public STBTTPackRange set(STBTTPackRange src) {
/* 158 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 159 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBTTPackRange malloc() {
/* 166 */     return new STBTTPackRange(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBTTPackRange calloc() {
/* 171 */     return new STBTTPackRange(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBTTPackRange create() {
/* 176 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 177 */     return new STBTTPackRange(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBTTPackRange create(long address) {
/* 182 */     return new STBTTPackRange(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBTTPackRange createSafe(long address) {
/* 187 */     return (address == 0L) ? null : new STBTTPackRange(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 196 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 205 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 214 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 215 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 225 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 230 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBTTPackRange malloc(MemoryStack stack) {
/* 239 */     return new STBTTPackRange(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBTTPackRange calloc(MemoryStack stack) {
/* 248 */     return new STBTTPackRange(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 258 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 268 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static float nfont_size(long struct) {
/* 274 */     return MemoryUtil.memGetFloat(struct + FONT_SIZE);
/*     */   } public static int nfirst_unicode_codepoint_in_range(long struct) {
/* 276 */     return MemoryUtil.memGetInt(struct + FIRST_UNICODE_CODEPOINT_IN_RANGE);
/*     */   } public static IntBuffer narray_of_unicode_codepoints(long struct) {
/* 278 */     return MemoryUtil.memIntBufferSafe(MemoryUtil.memGetAddress(struct + ARRAY_OF_UNICODE_CODEPOINTS), nnum_chars(struct));
/*     */   } public static int nnum_chars(long struct) {
/* 280 */     return MemoryUtil.memGetInt(struct + NUM_CHARS);
/*     */   } public static STBTTPackedchar.Buffer nchardata_for_range(long struct) {
/* 282 */     return STBTTPackedchar.create(MemoryUtil.memGetAddress(struct + CHARDATA_FOR_RANGE), nnum_chars(struct));
/*     */   } public static byte nh_oversample(long struct) {
/* 284 */     return MemoryUtil.memGetByte(struct + H_OVERSAMPLE);
/*     */   } public static byte nv_oversample(long struct) {
/* 286 */     return MemoryUtil.memGetByte(struct + V_OVERSAMPLE);
/*     */   }
/*     */   public static void nfont_size(long struct, float value) {
/* 289 */     MemoryUtil.memPutFloat(struct + FONT_SIZE, value);
/*     */   } public static void nfirst_unicode_codepoint_in_range(long struct, int value) {
/* 291 */     MemoryUtil.memPutInt(struct + FIRST_UNICODE_CODEPOINT_IN_RANGE, value);
/*     */   } public static void narray_of_unicode_codepoints(long struct, IntBuffer value) {
/* 293 */     MemoryUtil.memPutAddress(struct + ARRAY_OF_UNICODE_CODEPOINTS, MemoryUtil.memAddressSafe(value));
/*     */   } public static void nnum_chars(long struct, int value) {
/* 295 */     MemoryUtil.memPutInt(struct + NUM_CHARS, value);
/*     */   } public static void nchardata_for_range(long struct, STBTTPackedchar.Buffer value) {
/* 297 */     MemoryUtil.memPutAddress(struct + CHARDATA_FOR_RANGE, value.address());
/*     */   } public static void nh_oversample(long struct, byte value) {
/* 299 */     MemoryUtil.memPutByte(struct + H_OVERSAMPLE, value);
/*     */   } public static void nv_oversample(long struct, byte value) {
/* 301 */     MemoryUtil.memPutByte(struct + V_OVERSAMPLE, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long struct) {
/* 309 */     Checks.check(MemoryUtil.memGetAddress(struct + CHARDATA_FOR_RANGE));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<STBTTPackRange, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 317 */     private static final STBTTPackRange ELEMENT_FACTORY = STBTTPackRange.create(-1L);
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
/* 329 */       super(container, container.remaining() / STBTTPackRange.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 333 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 337 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 342 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 347 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected STBTTPackRange getElementFactory() {
/* 352 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     public float font_size() {
/* 356 */       return STBTTPackRange.nfont_size(address());
/*     */     } public int first_unicode_codepoint_in_range() {
/* 358 */       return STBTTPackRange.nfirst_unicode_codepoint_in_range(address());
/*     */     } @NativeType("int *")
/*     */     public IntBuffer array_of_unicode_codepoints() {
/* 361 */       return STBTTPackRange.narray_of_unicode_codepoints(address());
/*     */     } public int num_chars() {
/* 363 */       return STBTTPackRange.nnum_chars(address());
/*     */     } @NativeType("stbtt_packedchar *")
/*     */     public STBTTPackedchar.Buffer chardata_for_range() {
/* 366 */       return STBTTPackRange.nchardata_for_range(address());
/*     */     } @NativeType("unsigned char")
/*     */     public byte h_oversample() {
/* 369 */       return STBTTPackRange.nh_oversample(address());
/*     */     } @NativeType("unsigned char")
/*     */     public byte v_oversample() {
/* 372 */       return STBTTPackRange.nv_oversample(address());
/*     */     }
/*     */     public Buffer font_size(float value) {
/* 375 */       STBTTPackRange.nfont_size(address(), value); return this;
/*     */     } public Buffer first_unicode_codepoint_in_range(int value) {
/* 377 */       STBTTPackRange.nfirst_unicode_codepoint_in_range(address(), value); return this;
/*     */     } public Buffer array_of_unicode_codepoints(@NativeType("int *") IntBuffer value) {
/* 379 */       STBTTPackRange.narray_of_unicode_codepoints(address(), value); return this;
/*     */     } public Buffer num_chars(int value) {
/* 381 */       STBTTPackRange.nnum_chars(address(), value); return this;
/*     */     } public Buffer chardata_for_range(@NativeType("stbtt_packedchar *") STBTTPackedchar.Buffer value) {
/* 383 */       STBTTPackRange.nchardata_for_range(address(), value); return this;
/*     */     } public Buffer h_oversample(@NativeType("unsigned char") byte value) {
/* 385 */       STBTTPackRange.nh_oversample(address(), value); return this;
/*     */     } public Buffer v_oversample(@NativeType("unsigned char") byte value) {
/* 387 */       STBTTPackRange.nv_oversample(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\stb\STBTTPackRange.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */