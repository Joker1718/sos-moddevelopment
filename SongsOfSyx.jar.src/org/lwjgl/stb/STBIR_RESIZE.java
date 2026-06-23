/*     */ package org.lwjgl.stb;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import org.lwjgl.BufferUtils;
/*     */ import org.lwjgl.PointerBuffer;
/*     */ import org.lwjgl.system.Checks;
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
/*     */ public class STBIR_RESIZE
/*     */   extends Struct<STBIR_RESIZE>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int USER_DATA;
/*     */   public static final int INPUT_PIXELS;
/*     */   public static final int INPUT_W;
/*     */   public static final int INPUT_H;
/*     */   public static final int INPUT_S0;
/*     */   public static final int INPUT_T0;
/*     */   public static final int INPUT_S1;
/*     */   public static final int INPUT_T1;
/*     */   public static final int INPUT_CB;
/*     */   public static final int OUTPUT_PIXELS;
/*     */   public static final int OUTPUT_W;
/*     */   public static final int OUTPUT_H;
/*     */   public static final int OUTPUT_SUBX;
/*     */   public static final int OUTPUT_SUBY;
/*     */   public static final int OUTPUT_SUBW;
/*     */   public static final int OUTPUT_SUBH;
/*     */   public static final int OUTPUT_CB;
/*     */   public static final int INPUT_STRIDE_IN_BYTES;
/*     */   public static final int OUTPUT_STRIDE_IN_BYTES;
/*     */   public static final int SPLITS;
/*     */   public static final int FAST_ALPHA;
/*     */   public static final int NEEDS_REBUILD;
/*     */   public static final int CALLED_ALLOC;
/*     */   public static final int INPUT_PIXEL_LAYOUT_PUBLIC;
/*     */   public static final int OUTPUT_PIXEL_LAYOUT_PUBLIC;
/*     */   public static final int INPUT_DATA_TYPE;
/*     */   public static final int OUTPUT_DATA_TYPE;
/*     */   public static final int HORIZONTAL_FILTER;
/*     */   public static final int VERTICAL_FILTER;
/*     */   public static final int HORIZONTAL_EDGE;
/*     */   public static final int VERTICAL_EDGE;
/*     */   public static final int HORIZONTAL_FILTER_KERNEL;
/*     */   public static final int HORIZONTAL_FILTER_SUPPORT;
/*     */   public static final int VERTICAL_FILTER_KERNEL;
/*     */   public static final int VERTICAL_FILTER_SUPPORT;
/*     */   public static final int SAMPLERS;
/*     */   
/*     */   static {
/* 108 */     Struct.Layout layout = __struct(new Struct.Member[] { 
/* 109 */           __member(POINTER_SIZE), 
/* 110 */           __member(POINTER_SIZE), 
/* 111 */           __member(4), 
/* 112 */           __member(4), 
/* 113 */           __member(8), 
/* 114 */           __member(8), 
/* 115 */           __member(8), 
/* 116 */           __member(8), 
/* 117 */           __member(POINTER_SIZE), 
/* 118 */           __member(POINTER_SIZE), 
/* 119 */           __member(4), 
/* 120 */           __member(4), 
/* 121 */           __member(4), 
/* 122 */           __member(4), 
/* 123 */           __member(4), 
/* 124 */           __member(4), 
/* 125 */           __member(POINTER_SIZE), 
/* 126 */           __member(4), 
/* 127 */           __member(4), 
/* 128 */           __member(4), 
/* 129 */           __member(4), 
/* 130 */           __member(4), 
/* 131 */           __member(4), 
/* 132 */           __member(4), 
/* 133 */           __member(4), 
/* 134 */           __member(4), 
/* 135 */           __member(4), 
/* 136 */           __member(4), 
/* 137 */           __member(4), 
/* 138 */           __member(4), 
/* 139 */           __member(4), 
/* 140 */           __member(POINTER_SIZE), 
/* 141 */           __member(POINTER_SIZE), 
/* 142 */           __member(POINTER_SIZE), 
/* 143 */           __member(POINTER_SIZE), 
/* 144 */           __member(POINTER_SIZE) });
/*     */ 
/*     */     
/* 147 */     SIZEOF = layout.getSize();
/* 148 */     ALIGNOF = layout.getAlignment();
/*     */     
/* 150 */     USER_DATA = layout.offsetof(0);
/* 151 */     INPUT_PIXELS = layout.offsetof(1);
/* 152 */     INPUT_W = layout.offsetof(2);
/* 153 */     INPUT_H = layout.offsetof(3);
/* 154 */     INPUT_S0 = layout.offsetof(4);
/* 155 */     INPUT_T0 = layout.offsetof(5);
/* 156 */     INPUT_S1 = layout.offsetof(6);
/* 157 */     INPUT_T1 = layout.offsetof(7);
/* 158 */     INPUT_CB = layout.offsetof(8);
/* 159 */     OUTPUT_PIXELS = layout.offsetof(9);
/* 160 */     OUTPUT_W = layout.offsetof(10);
/* 161 */     OUTPUT_H = layout.offsetof(11);
/* 162 */     OUTPUT_SUBX = layout.offsetof(12);
/* 163 */     OUTPUT_SUBY = layout.offsetof(13);
/* 164 */     OUTPUT_SUBW = layout.offsetof(14);
/* 165 */     OUTPUT_SUBH = layout.offsetof(15);
/* 166 */     OUTPUT_CB = layout.offsetof(16);
/* 167 */     INPUT_STRIDE_IN_BYTES = layout.offsetof(17);
/* 168 */     OUTPUT_STRIDE_IN_BYTES = layout.offsetof(18);
/* 169 */     SPLITS = layout.offsetof(19);
/* 170 */     FAST_ALPHA = layout.offsetof(20);
/* 171 */     NEEDS_REBUILD = layout.offsetof(21);
/* 172 */     CALLED_ALLOC = layout.offsetof(22);
/* 173 */     INPUT_PIXEL_LAYOUT_PUBLIC = layout.offsetof(23);
/* 174 */     OUTPUT_PIXEL_LAYOUT_PUBLIC = layout.offsetof(24);
/* 175 */     INPUT_DATA_TYPE = layout.offsetof(25);
/* 176 */     OUTPUT_DATA_TYPE = layout.offsetof(26);
/* 177 */     HORIZONTAL_FILTER = layout.offsetof(27);
/* 178 */     VERTICAL_FILTER = layout.offsetof(28);
/* 179 */     HORIZONTAL_EDGE = layout.offsetof(29);
/* 180 */     VERTICAL_EDGE = layout.offsetof(30);
/* 181 */     HORIZONTAL_FILTER_KERNEL = layout.offsetof(31);
/* 182 */     HORIZONTAL_FILTER_SUPPORT = layout.offsetof(32);
/* 183 */     VERTICAL_FILTER_KERNEL = layout.offsetof(33);
/* 184 */     VERTICAL_FILTER_SUPPORT = layout.offsetof(34);
/* 185 */     SAMPLERS = layout.offsetof(35);
/*     */   }
/*     */   
/*     */   protected STBIR_RESIZE(long address, ByteBuffer container) {
/* 189 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected STBIR_RESIZE create(long address, ByteBuffer container) {
/* 194 */     return new STBIR_RESIZE(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public STBIR_RESIZE(ByteBuffer container) {
/* 204 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/* 208 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("void *")
/*     */   public long user_data() {
/* 212 */     return nuser_data(address());
/*     */   } @NativeType("void const *")
/*     */   public ByteBuffer input_pixels(int capacity) {
/* 215 */     return ninput_pixels(address(), capacity);
/*     */   } public int input_w() {
/* 217 */     return ninput_w(address());
/*     */   } public int input_h() {
/* 219 */     return ninput_h(address());
/*     */   } public double input_s0() {
/* 221 */     return ninput_s0(address());
/*     */   } public double input_t0() {
/* 223 */     return ninput_t0(address());
/*     */   } public double input_s1() {
/* 225 */     return ninput_s1(address());
/*     */   } public double input_t1() {
/* 227 */     return ninput_t1(address());
/*     */   } @NativeType("stbir_input_callback **")
/*     */   public PointerBuffer input_cb(int capacity) {
/* 230 */     return ninput_cb(address(), capacity);
/*     */   } @NativeType("void *")
/*     */   public ByteBuffer output_pixels(int capacity) {
/* 233 */     return noutput_pixels(address(), capacity);
/*     */   } public int output_w() {
/* 235 */     return noutput_w(address());
/*     */   } public int output_h() {
/* 237 */     return noutput_h(address());
/*     */   } public int output_subx() {
/* 239 */     return noutput_subx(address());
/*     */   } public int output_suby() {
/* 241 */     return noutput_suby(address());
/*     */   } public int output_subw() {
/* 243 */     return noutput_subw(address());
/*     */   } public int output_subh() {
/* 245 */     return noutput_subh(address());
/*     */   } @NativeType("stbir_output_callback **")
/*     */   public PointerBuffer output_cb(int capacity) {
/* 248 */     return noutput_cb(address(), capacity);
/*     */   } public int input_stride_in_bytes() {
/* 250 */     return ninput_stride_in_bytes(address());
/*     */   } public int output_stride_in_bytes() {
/* 252 */     return noutput_stride_in_bytes(address());
/*     */   } public int splits() {
/* 254 */     return nsplits(address());
/*     */   } @NativeType("int")
/*     */   public boolean fast_alpha() {
/* 257 */     return (nfast_alpha(address()) != 0);
/*     */   } @NativeType("int")
/*     */   public boolean needs_rebuild() {
/* 260 */     return (nneeds_rebuild(address()) != 0);
/*     */   } @NativeType("int")
/*     */   public boolean called_alloc() {
/* 263 */     return (ncalled_alloc(address()) != 0);
/*     */   } @NativeType("stbir_pixel_layout")
/*     */   public int input_pixel_layout_public() {
/* 266 */     return ninput_pixel_layout_public(address());
/*     */   } @NativeType("stbir_pixel_layout")
/*     */   public int output_pixel_layout_public() {
/* 269 */     return noutput_pixel_layout_public(address());
/*     */   } @NativeType("stbir_datatype")
/*     */   public int input_data_type() {
/* 272 */     return ninput_data_type(address());
/*     */   } @NativeType("stbir_datatype")
/*     */   public int output_data_type() {
/* 275 */     return noutput_data_type(address());
/*     */   } @NativeType("stbir_filter")
/*     */   public int horizontal_filter() {
/* 278 */     return nhorizontal_filter(address());
/*     */   } @NativeType("stbir_filter")
/*     */   public int vertical_filter() {
/* 281 */     return nvertical_filter(address());
/*     */   } @NativeType("stbir_edge")
/*     */   public int horizontal_edge() {
/* 284 */     return nhorizontal_edge(address());
/*     */   } @NativeType("stbir_edge")
/*     */   public int vertical_edge() {
/* 287 */     return nvertical_edge(address());
/*     */   } @NativeType("stbir__kernel_callback **")
/*     */   public PointerBuffer horizontal_filter_kernel(int capacity) {
/* 290 */     return nhorizontal_filter_kernel(address(), capacity);
/*     */   } @NativeType("stbir__support_callback **")
/*     */   public PointerBuffer horizontal_filter_support(int capacity) {
/* 293 */     return nhorizontal_filter_support(address(), capacity);
/*     */   } @NativeType("stbir__kernel_callback **")
/*     */   public PointerBuffer vertical_filter_kernel(int capacity) {
/* 296 */     return nvertical_filter_kernel(address(), capacity);
/*     */   } @NativeType("stbir__support_callback **")
/*     */   public PointerBuffer vertical_filter_support(int capacity) {
/* 299 */     return nvertical_filter_support(address(), capacity);
/*     */   } @NativeType("stbir__info *")
/*     */   public long samplers() {
/* 302 */     return nsamplers(address());
/*     */   }
/*     */   public STBIR_RESIZE user_data(@NativeType("void *") long value) {
/* 305 */     nuser_data(address(), value); return this;
/*     */   } public STBIR_RESIZE input_pixels(@NativeType("void const *") ByteBuffer value) {
/* 307 */     ninput_pixels(address(), value); return this;
/*     */   } public STBIR_RESIZE input_w(int value) {
/* 309 */     ninput_w(address(), value); return this;
/*     */   } public STBIR_RESIZE input_h(int value) {
/* 311 */     ninput_h(address(), value); return this;
/*     */   } public STBIR_RESIZE input_s0(double value) {
/* 313 */     ninput_s0(address(), value); return this;
/*     */   } public STBIR_RESIZE input_t0(double value) {
/* 315 */     ninput_t0(address(), value); return this;
/*     */   } public STBIR_RESIZE input_s1(double value) {
/* 317 */     ninput_s1(address(), value); return this;
/*     */   } public STBIR_RESIZE input_t1(double value) {
/* 319 */     ninput_t1(address(), value); return this;
/*     */   } public STBIR_RESIZE input_cb(@NativeType("stbir_input_callback **") PointerBuffer value) {
/* 321 */     ninput_cb(address(), value); return this;
/*     */   } public STBIR_RESIZE output_pixels(@NativeType("void *") ByteBuffer value) {
/* 323 */     noutput_pixels(address(), value); return this;
/*     */   } public STBIR_RESIZE output_w(int value) {
/* 325 */     noutput_w(address(), value); return this;
/*     */   } public STBIR_RESIZE output_h(int value) {
/* 327 */     noutput_h(address(), value); return this;
/*     */   } public STBIR_RESIZE output_subx(int value) {
/* 329 */     noutput_subx(address(), value); return this;
/*     */   } public STBIR_RESIZE output_suby(int value) {
/* 331 */     noutput_suby(address(), value); return this;
/*     */   } public STBIR_RESIZE output_subw(int value) {
/* 333 */     noutput_subw(address(), value); return this;
/*     */   } public STBIR_RESIZE output_subh(int value) {
/* 335 */     noutput_subh(address(), value); return this;
/*     */   } public STBIR_RESIZE output_cb(@NativeType("stbir_output_callback **") PointerBuffer value) {
/* 337 */     noutput_cb(address(), value); return this;
/*     */   } public STBIR_RESIZE input_stride_in_bytes(int value) {
/* 339 */     ninput_stride_in_bytes(address(), value); return this;
/*     */   } public STBIR_RESIZE output_stride_in_bytes(int value) {
/* 341 */     noutput_stride_in_bytes(address(), value); return this;
/*     */   } public STBIR_RESIZE splits(int value) {
/* 343 */     nsplits(address(), value); return this;
/*     */   } public STBIR_RESIZE fast_alpha(@NativeType("int") boolean value) {
/* 345 */     nfast_alpha(address(), value ? 1 : 0); return this;
/*     */   } public STBIR_RESIZE needs_rebuild(@NativeType("int") boolean value) {
/* 347 */     nneeds_rebuild(address(), value ? 1 : 0); return this;
/*     */   } public STBIR_RESIZE called_alloc(@NativeType("int") boolean value) {
/* 349 */     ncalled_alloc(address(), value ? 1 : 0); return this;
/*     */   } public STBIR_RESIZE input_pixel_layout_public(@NativeType("stbir_pixel_layout") int value) {
/* 351 */     ninput_pixel_layout_public(address(), value); return this;
/*     */   } public STBIR_RESIZE output_pixel_layout_public(@NativeType("stbir_pixel_layout") int value) {
/* 353 */     noutput_pixel_layout_public(address(), value); return this;
/*     */   } public STBIR_RESIZE input_data_type(@NativeType("stbir_datatype") int value) {
/* 355 */     ninput_data_type(address(), value); return this;
/*     */   } public STBIR_RESIZE output_data_type(@NativeType("stbir_datatype") int value) {
/* 357 */     noutput_data_type(address(), value); return this;
/*     */   } public STBIR_RESIZE horizontal_filter(@NativeType("stbir_filter") int value) {
/* 359 */     nhorizontal_filter(address(), value); return this;
/*     */   } public STBIR_RESIZE vertical_filter(@NativeType("stbir_filter") int value) {
/* 361 */     nvertical_filter(address(), value); return this;
/*     */   } public STBIR_RESIZE horizontal_edge(@NativeType("stbir_edge") int value) {
/* 363 */     nhorizontal_edge(address(), value); return this;
/*     */   } public STBIR_RESIZE vertical_edge(@NativeType("stbir_edge") int value) {
/* 365 */     nvertical_edge(address(), value); return this;
/*     */   } public STBIR_RESIZE horizontal_filter_kernel(@NativeType("stbir__kernel_callback **") PointerBuffer value) {
/* 367 */     nhorizontal_filter_kernel(address(), value); return this;
/*     */   } public STBIR_RESIZE horizontal_filter_support(@NativeType("stbir__support_callback **") PointerBuffer value) {
/* 369 */     nhorizontal_filter_support(address(), value); return this;
/*     */   } public STBIR_RESIZE vertical_filter_kernel(@NativeType("stbir__kernel_callback **") PointerBuffer value) {
/* 371 */     nvertical_filter_kernel(address(), value); return this;
/*     */   } public STBIR_RESIZE vertical_filter_support(@NativeType("stbir__support_callback **") PointerBuffer value) {
/* 373 */     nvertical_filter_support(address(), value); return this;
/*     */   } public STBIR_RESIZE samplers(@NativeType("stbir__info *") long value) {
/* 375 */     nsamplers(address(), value); return this;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public STBIR_RESIZE set(long user_data, ByteBuffer input_pixels, int input_w, int input_h, double input_s0, double input_t0, double input_s1, double input_t1, PointerBuffer input_cb, ByteBuffer output_pixels, int output_w, int output_h, int output_subx, int output_suby, int output_subw, int output_subh, PointerBuffer output_cb, int input_stride_in_bytes, int output_stride_in_bytes, int splits, boolean fast_alpha, boolean needs_rebuild, boolean called_alloc, int input_pixel_layout_public, int output_pixel_layout_public, int input_data_type, int output_data_type, int horizontal_filter, int vertical_filter, int horizontal_edge, int vertical_edge, PointerBuffer horizontal_filter_kernel, PointerBuffer horizontal_filter_support, PointerBuffer vertical_filter_kernel, PointerBuffer vertical_filter_support, long samplers) {
/* 416 */     user_data(user_data);
/* 417 */     input_pixels(input_pixels);
/* 418 */     input_w(input_w);
/* 419 */     input_h(input_h);
/* 420 */     input_s0(input_s0);
/* 421 */     input_t0(input_t0);
/* 422 */     input_s1(input_s1);
/* 423 */     input_t1(input_t1);
/* 424 */     input_cb(input_cb);
/* 425 */     output_pixels(output_pixels);
/* 426 */     output_w(output_w);
/* 427 */     output_h(output_h);
/* 428 */     output_subx(output_subx);
/* 429 */     output_suby(output_suby);
/* 430 */     output_subw(output_subw);
/* 431 */     output_subh(output_subh);
/* 432 */     output_cb(output_cb);
/* 433 */     input_stride_in_bytes(input_stride_in_bytes);
/* 434 */     output_stride_in_bytes(output_stride_in_bytes);
/* 435 */     splits(splits);
/* 436 */     fast_alpha(fast_alpha);
/* 437 */     needs_rebuild(needs_rebuild);
/* 438 */     called_alloc(called_alloc);
/* 439 */     input_pixel_layout_public(input_pixel_layout_public);
/* 440 */     output_pixel_layout_public(output_pixel_layout_public);
/* 441 */     input_data_type(input_data_type);
/* 442 */     output_data_type(output_data_type);
/* 443 */     horizontal_filter(horizontal_filter);
/* 444 */     vertical_filter(vertical_filter);
/* 445 */     horizontal_edge(horizontal_edge);
/* 446 */     vertical_edge(vertical_edge);
/* 447 */     horizontal_filter_kernel(horizontal_filter_kernel);
/* 448 */     horizontal_filter_support(horizontal_filter_support);
/* 449 */     vertical_filter_kernel(vertical_filter_kernel);
/* 450 */     vertical_filter_support(vertical_filter_support);
/* 451 */     samplers(samplers);
/*     */     
/* 453 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public STBIR_RESIZE set(STBIR_RESIZE src) {
/* 464 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 465 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBIR_RESIZE malloc() {
/* 472 */     return new STBIR_RESIZE(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBIR_RESIZE calloc() {
/* 477 */     return new STBIR_RESIZE(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBIR_RESIZE create() {
/* 482 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 483 */     return new STBIR_RESIZE(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBIR_RESIZE create(long address) {
/* 488 */     return new STBIR_RESIZE(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBIR_RESIZE createSafe(long address) {
/* 493 */     return (address == 0L) ? null : new STBIR_RESIZE(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 502 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 511 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 520 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 521 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 531 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 536 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBIR_RESIZE malloc(MemoryStack stack) {
/* 545 */     return new STBIR_RESIZE(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBIR_RESIZE calloc(MemoryStack stack) {
/* 554 */     return new STBIR_RESIZE(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 564 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 574 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nuser_data(long struct) {
/* 580 */     return MemoryUtil.memGetAddress(struct + USER_DATA);
/*     */   } public static ByteBuffer ninput_pixels(long struct, int capacity) {
/* 582 */     return MemoryUtil.memByteBuffer(MemoryUtil.memGetAddress(struct + INPUT_PIXELS), capacity);
/*     */   } public static int ninput_w(long struct) {
/* 584 */     return MemoryUtil.memGetInt(struct + INPUT_W);
/*     */   } public static int ninput_h(long struct) {
/* 586 */     return MemoryUtil.memGetInt(struct + INPUT_H);
/*     */   } public static double ninput_s0(long struct) {
/* 588 */     return MemoryUtil.memGetDouble(struct + INPUT_S0);
/*     */   } public static double ninput_t0(long struct) {
/* 590 */     return MemoryUtil.memGetDouble(struct + INPUT_T0);
/*     */   } public static double ninput_s1(long struct) {
/* 592 */     return MemoryUtil.memGetDouble(struct + INPUT_S1);
/*     */   } public static double ninput_t1(long struct) {
/* 594 */     return MemoryUtil.memGetDouble(struct + INPUT_T1);
/*     */   } public static PointerBuffer ninput_cb(long struct, int capacity) {
/* 596 */     return MemoryUtil.memPointerBufferSafe(MemoryUtil.memGetAddress(struct + INPUT_CB), capacity);
/*     */   } public static ByteBuffer noutput_pixels(long struct, int capacity) {
/* 598 */     return MemoryUtil.memByteBufferSafe(MemoryUtil.memGetAddress(struct + OUTPUT_PIXELS), capacity);
/*     */   } public static int noutput_w(long struct) {
/* 600 */     return MemoryUtil.memGetInt(struct + OUTPUT_W);
/*     */   } public static int noutput_h(long struct) {
/* 602 */     return MemoryUtil.memGetInt(struct + OUTPUT_H);
/*     */   } public static int noutput_subx(long struct) {
/* 604 */     return MemoryUtil.memGetInt(struct + OUTPUT_SUBX);
/*     */   } public static int noutput_suby(long struct) {
/* 606 */     return MemoryUtil.memGetInt(struct + OUTPUT_SUBY);
/*     */   } public static int noutput_subw(long struct) {
/* 608 */     return MemoryUtil.memGetInt(struct + OUTPUT_SUBW);
/*     */   } public static int noutput_subh(long struct) {
/* 610 */     return MemoryUtil.memGetInt(struct + OUTPUT_SUBH);
/*     */   } public static PointerBuffer noutput_cb(long struct, int capacity) {
/* 612 */     return MemoryUtil.memPointerBufferSafe(MemoryUtil.memGetAddress(struct + OUTPUT_CB), capacity);
/*     */   } public static int ninput_stride_in_bytes(long struct) {
/* 614 */     return MemoryUtil.memGetInt(struct + INPUT_STRIDE_IN_BYTES);
/*     */   } public static int noutput_stride_in_bytes(long struct) {
/* 616 */     return MemoryUtil.memGetInt(struct + OUTPUT_STRIDE_IN_BYTES);
/*     */   } public static int nsplits(long struct) {
/* 618 */     return MemoryUtil.memGetInt(struct + SPLITS);
/*     */   } public static int nfast_alpha(long struct) {
/* 620 */     return MemoryUtil.memGetInt(struct + FAST_ALPHA);
/*     */   } public static int nneeds_rebuild(long struct) {
/* 622 */     return MemoryUtil.memGetInt(struct + NEEDS_REBUILD);
/*     */   } public static int ncalled_alloc(long struct) {
/* 624 */     return MemoryUtil.memGetInt(struct + CALLED_ALLOC);
/*     */   } public static int ninput_pixel_layout_public(long struct) {
/* 626 */     return MemoryUtil.memGetInt(struct + INPUT_PIXEL_LAYOUT_PUBLIC);
/*     */   } public static int noutput_pixel_layout_public(long struct) {
/* 628 */     return MemoryUtil.memGetInt(struct + OUTPUT_PIXEL_LAYOUT_PUBLIC);
/*     */   } public static int ninput_data_type(long struct) {
/* 630 */     return MemoryUtil.memGetInt(struct + INPUT_DATA_TYPE);
/*     */   } public static int noutput_data_type(long struct) {
/* 632 */     return MemoryUtil.memGetInt(struct + OUTPUT_DATA_TYPE);
/*     */   } public static int nhorizontal_filter(long struct) {
/* 634 */     return MemoryUtil.memGetInt(struct + HORIZONTAL_FILTER);
/*     */   } public static int nvertical_filter(long struct) {
/* 636 */     return MemoryUtil.memGetInt(struct + VERTICAL_FILTER);
/*     */   } public static int nhorizontal_edge(long struct) {
/* 638 */     return MemoryUtil.memGetInt(struct + HORIZONTAL_EDGE);
/*     */   } public static int nvertical_edge(long struct) {
/* 640 */     return MemoryUtil.memGetInt(struct + VERTICAL_EDGE);
/*     */   } public static PointerBuffer nhorizontal_filter_kernel(long struct, int capacity) {
/* 642 */     return MemoryUtil.memPointerBufferSafe(MemoryUtil.memGetAddress(struct + HORIZONTAL_FILTER_KERNEL), capacity);
/*     */   } public static PointerBuffer nhorizontal_filter_support(long struct, int capacity) {
/* 644 */     return MemoryUtil.memPointerBufferSafe(MemoryUtil.memGetAddress(struct + HORIZONTAL_FILTER_SUPPORT), capacity);
/*     */   } public static PointerBuffer nvertical_filter_kernel(long struct, int capacity) {
/* 646 */     return MemoryUtil.memPointerBufferSafe(MemoryUtil.memGetAddress(struct + VERTICAL_FILTER_KERNEL), capacity);
/*     */   } public static PointerBuffer nvertical_filter_support(long struct, int capacity) {
/* 648 */     return MemoryUtil.memPointerBufferSafe(MemoryUtil.memGetAddress(struct + VERTICAL_FILTER_SUPPORT), capacity);
/*     */   } public static long nsamplers(long struct) {
/* 650 */     return MemoryUtil.memGetAddress(struct + SAMPLERS);
/*     */   }
/*     */   public static void nuser_data(long struct, long value) {
/* 653 */     MemoryUtil.memPutAddress(struct + USER_DATA, value);
/*     */   } public static void ninput_pixels(long struct, ByteBuffer value) {
/* 655 */     MemoryUtil.memPutAddress(struct + INPUT_PIXELS, MemoryUtil.memAddress(value));
/*     */   } public static void ninput_w(long struct, int value) {
/* 657 */     MemoryUtil.memPutInt(struct + INPUT_W, value);
/*     */   } public static void ninput_h(long struct, int value) {
/* 659 */     MemoryUtil.memPutInt(struct + INPUT_H, value);
/*     */   } public static void ninput_s0(long struct, double value) {
/* 661 */     MemoryUtil.memPutDouble(struct + INPUT_S0, value);
/*     */   } public static void ninput_t0(long struct, double value) {
/* 663 */     MemoryUtil.memPutDouble(struct + INPUT_T0, value);
/*     */   } public static void ninput_s1(long struct, double value) {
/* 665 */     MemoryUtil.memPutDouble(struct + INPUT_S1, value);
/*     */   } public static void ninput_t1(long struct, double value) {
/* 667 */     MemoryUtil.memPutDouble(struct + INPUT_T1, value);
/*     */   } public static void ninput_cb(long struct, PointerBuffer value) {
/* 669 */     MemoryUtil.memPutAddress(struct + INPUT_CB, MemoryUtil.memAddressSafe((Pointer)value));
/*     */   } public static void noutput_pixels(long struct, ByteBuffer value) {
/* 671 */     MemoryUtil.memPutAddress(struct + OUTPUT_PIXELS, MemoryUtil.memAddressSafe(value));
/*     */   } public static void noutput_w(long struct, int value) {
/* 673 */     MemoryUtil.memPutInt(struct + OUTPUT_W, value);
/*     */   } public static void noutput_h(long struct, int value) {
/* 675 */     MemoryUtil.memPutInt(struct + OUTPUT_H, value);
/*     */   } public static void noutput_subx(long struct, int value) {
/* 677 */     MemoryUtil.memPutInt(struct + OUTPUT_SUBX, value);
/*     */   } public static void noutput_suby(long struct, int value) {
/* 679 */     MemoryUtil.memPutInt(struct + OUTPUT_SUBY, value);
/*     */   } public static void noutput_subw(long struct, int value) {
/* 681 */     MemoryUtil.memPutInt(struct + OUTPUT_SUBW, value);
/*     */   } public static void noutput_subh(long struct, int value) {
/* 683 */     MemoryUtil.memPutInt(struct + OUTPUT_SUBH, value);
/*     */   } public static void noutput_cb(long struct, PointerBuffer value) {
/* 685 */     MemoryUtil.memPutAddress(struct + OUTPUT_CB, MemoryUtil.memAddressSafe((Pointer)value));
/*     */   } public static void ninput_stride_in_bytes(long struct, int value) {
/* 687 */     MemoryUtil.memPutInt(struct + INPUT_STRIDE_IN_BYTES, value);
/*     */   } public static void noutput_stride_in_bytes(long struct, int value) {
/* 689 */     MemoryUtil.memPutInt(struct + OUTPUT_STRIDE_IN_BYTES, value);
/*     */   } public static void nsplits(long struct, int value) {
/* 691 */     MemoryUtil.memPutInt(struct + SPLITS, value);
/*     */   } public static void nfast_alpha(long struct, int value) {
/* 693 */     MemoryUtil.memPutInt(struct + FAST_ALPHA, value);
/*     */   } public static void nneeds_rebuild(long struct, int value) {
/* 695 */     MemoryUtil.memPutInt(struct + NEEDS_REBUILD, value);
/*     */   } public static void ncalled_alloc(long struct, int value) {
/* 697 */     MemoryUtil.memPutInt(struct + CALLED_ALLOC, value);
/*     */   } public static void ninput_pixel_layout_public(long struct, int value) {
/* 699 */     MemoryUtil.memPutInt(struct + INPUT_PIXEL_LAYOUT_PUBLIC, value);
/*     */   } public static void noutput_pixel_layout_public(long struct, int value) {
/* 701 */     MemoryUtil.memPutInt(struct + OUTPUT_PIXEL_LAYOUT_PUBLIC, value);
/*     */   } public static void ninput_data_type(long struct, int value) {
/* 703 */     MemoryUtil.memPutInt(struct + INPUT_DATA_TYPE, value);
/*     */   } public static void noutput_data_type(long struct, int value) {
/* 705 */     MemoryUtil.memPutInt(struct + OUTPUT_DATA_TYPE, value);
/*     */   } public static void nhorizontal_filter(long struct, int value) {
/* 707 */     MemoryUtil.memPutInt(struct + HORIZONTAL_FILTER, value);
/*     */   } public static void nvertical_filter(long struct, int value) {
/* 709 */     MemoryUtil.memPutInt(struct + VERTICAL_FILTER, value);
/*     */   } public static void nhorizontal_edge(long struct, int value) {
/* 711 */     MemoryUtil.memPutInt(struct + HORIZONTAL_EDGE, value);
/*     */   } public static void nvertical_edge(long struct, int value) {
/* 713 */     MemoryUtil.memPutInt(struct + VERTICAL_EDGE, value);
/*     */   } public static void nhorizontal_filter_kernel(long struct, PointerBuffer value) {
/* 715 */     MemoryUtil.memPutAddress(struct + HORIZONTAL_FILTER_KERNEL, MemoryUtil.memAddressSafe((Pointer)value));
/*     */   } public static void nhorizontal_filter_support(long struct, PointerBuffer value) {
/* 717 */     MemoryUtil.memPutAddress(struct + HORIZONTAL_FILTER_SUPPORT, MemoryUtil.memAddressSafe((Pointer)value));
/*     */   } public static void nvertical_filter_kernel(long struct, PointerBuffer value) {
/* 719 */     MemoryUtil.memPutAddress(struct + VERTICAL_FILTER_KERNEL, MemoryUtil.memAddressSafe((Pointer)value));
/*     */   } public static void nvertical_filter_support(long struct, PointerBuffer value) {
/* 721 */     MemoryUtil.memPutAddress(struct + VERTICAL_FILTER_SUPPORT, MemoryUtil.memAddressSafe((Pointer)value));
/*     */   } public static void nsamplers(long struct, long value) {
/* 723 */     MemoryUtil.memPutAddress(struct + SAMPLERS, Checks.check(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long struct) {
/* 731 */     Checks.check(MemoryUtil.memGetAddress(struct + INPUT_PIXELS));
/* 732 */     Checks.check(MemoryUtil.memGetAddress(struct + SAMPLERS));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<STBIR_RESIZE, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 740 */     private static final STBIR_RESIZE ELEMENT_FACTORY = STBIR_RESIZE.create(-1L);
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
/* 752 */       super(container, container.remaining() / STBIR_RESIZE.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 756 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 760 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 765 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 770 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected STBIR_RESIZE getElementFactory() {
/* 775 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("void *")
/*     */     public long user_data() {
/* 780 */       return STBIR_RESIZE.nuser_data(address());
/*     */     } @NativeType("void const *")
/*     */     public ByteBuffer input_pixels(int capacity) {
/* 783 */       return STBIR_RESIZE.ninput_pixels(address(), capacity);
/*     */     } public int input_w() {
/* 785 */       return STBIR_RESIZE.ninput_w(address());
/*     */     } public int input_h() {
/* 787 */       return STBIR_RESIZE.ninput_h(address());
/*     */     } public double input_s0() {
/* 789 */       return STBIR_RESIZE.ninput_s0(address());
/*     */     } public double input_t0() {
/* 791 */       return STBIR_RESIZE.ninput_t0(address());
/*     */     } public double input_s1() {
/* 793 */       return STBIR_RESIZE.ninput_s1(address());
/*     */     } public double input_t1() {
/* 795 */       return STBIR_RESIZE.ninput_t1(address());
/*     */     } @NativeType("stbir_input_callback **")
/*     */     public PointerBuffer input_cb(int capacity) {
/* 798 */       return STBIR_RESIZE.ninput_cb(address(), capacity);
/*     */     } @NativeType("void *")
/*     */     public ByteBuffer output_pixels(int capacity) {
/* 801 */       return STBIR_RESIZE.noutput_pixels(address(), capacity);
/*     */     } public int output_w() {
/* 803 */       return STBIR_RESIZE.noutput_w(address());
/*     */     } public int output_h() {
/* 805 */       return STBIR_RESIZE.noutput_h(address());
/*     */     } public int output_subx() {
/* 807 */       return STBIR_RESIZE.noutput_subx(address());
/*     */     } public int output_suby() {
/* 809 */       return STBIR_RESIZE.noutput_suby(address());
/*     */     } public int output_subw() {
/* 811 */       return STBIR_RESIZE.noutput_subw(address());
/*     */     } public int output_subh() {
/* 813 */       return STBIR_RESIZE.noutput_subh(address());
/*     */     } @NativeType("stbir_output_callback **")
/*     */     public PointerBuffer output_cb(int capacity) {
/* 816 */       return STBIR_RESIZE.noutput_cb(address(), capacity);
/*     */     } public int input_stride_in_bytes() {
/* 818 */       return STBIR_RESIZE.ninput_stride_in_bytes(address());
/*     */     } public int output_stride_in_bytes() {
/* 820 */       return STBIR_RESIZE.noutput_stride_in_bytes(address());
/*     */     } public int splits() {
/* 822 */       return STBIR_RESIZE.nsplits(address());
/*     */     } @NativeType("int")
/*     */     public boolean fast_alpha() {
/* 825 */       return (STBIR_RESIZE.nfast_alpha(address()) != 0);
/*     */     } @NativeType("int")
/*     */     public boolean needs_rebuild() {
/* 828 */       return (STBIR_RESIZE.nneeds_rebuild(address()) != 0);
/*     */     } @NativeType("int")
/*     */     public boolean called_alloc() {
/* 831 */       return (STBIR_RESIZE.ncalled_alloc(address()) != 0);
/*     */     } @NativeType("stbir_pixel_layout")
/*     */     public int input_pixel_layout_public() {
/* 834 */       return STBIR_RESIZE.ninput_pixel_layout_public(address());
/*     */     } @NativeType("stbir_pixel_layout")
/*     */     public int output_pixel_layout_public() {
/* 837 */       return STBIR_RESIZE.noutput_pixel_layout_public(address());
/*     */     } @NativeType("stbir_datatype")
/*     */     public int input_data_type() {
/* 840 */       return STBIR_RESIZE.ninput_data_type(address());
/*     */     } @NativeType("stbir_datatype")
/*     */     public int output_data_type() {
/* 843 */       return STBIR_RESIZE.noutput_data_type(address());
/*     */     } @NativeType("stbir_filter")
/*     */     public int horizontal_filter() {
/* 846 */       return STBIR_RESIZE.nhorizontal_filter(address());
/*     */     } @NativeType("stbir_filter")
/*     */     public int vertical_filter() {
/* 849 */       return STBIR_RESIZE.nvertical_filter(address());
/*     */     } @NativeType("stbir_edge")
/*     */     public int horizontal_edge() {
/* 852 */       return STBIR_RESIZE.nhorizontal_edge(address());
/*     */     } @NativeType("stbir_edge")
/*     */     public int vertical_edge() {
/* 855 */       return STBIR_RESIZE.nvertical_edge(address());
/*     */     } @NativeType("stbir__kernel_callback **")
/*     */     public PointerBuffer horizontal_filter_kernel(int capacity) {
/* 858 */       return STBIR_RESIZE.nhorizontal_filter_kernel(address(), capacity);
/*     */     } @NativeType("stbir__support_callback **")
/*     */     public PointerBuffer horizontal_filter_support(int capacity) {
/* 861 */       return STBIR_RESIZE.nhorizontal_filter_support(address(), capacity);
/*     */     } @NativeType("stbir__kernel_callback **")
/*     */     public PointerBuffer vertical_filter_kernel(int capacity) {
/* 864 */       return STBIR_RESIZE.nvertical_filter_kernel(address(), capacity);
/*     */     } @NativeType("stbir__support_callback **")
/*     */     public PointerBuffer vertical_filter_support(int capacity) {
/* 867 */       return STBIR_RESIZE.nvertical_filter_support(address(), capacity);
/*     */     } @NativeType("stbir__info *")
/*     */     public long samplers() {
/* 870 */       return STBIR_RESIZE.nsamplers(address());
/*     */     }
/*     */     public Buffer user_data(@NativeType("void *") long value) {
/* 873 */       STBIR_RESIZE.nuser_data(address(), value); return this;
/*     */     } public Buffer input_pixels(@NativeType("void const *") ByteBuffer value) {
/* 875 */       STBIR_RESIZE.ninput_pixels(address(), value); return this;
/*     */     } public Buffer input_w(int value) {
/* 877 */       STBIR_RESIZE.ninput_w(address(), value); return this;
/*     */     } public Buffer input_h(int value) {
/* 879 */       STBIR_RESIZE.ninput_h(address(), value); return this;
/*     */     } public Buffer input_s0(double value) {
/* 881 */       STBIR_RESIZE.ninput_s0(address(), value); return this;
/*     */     } public Buffer input_t0(double value) {
/* 883 */       STBIR_RESIZE.ninput_t0(address(), value); return this;
/*     */     } public Buffer input_s1(double value) {
/* 885 */       STBIR_RESIZE.ninput_s1(address(), value); return this;
/*     */     } public Buffer input_t1(double value) {
/* 887 */       STBIR_RESIZE.ninput_t1(address(), value); return this;
/*     */     } public Buffer input_cb(@NativeType("stbir_input_callback **") PointerBuffer value) {
/* 889 */       STBIR_RESIZE.ninput_cb(address(), value); return this;
/*     */     } public Buffer output_pixels(@NativeType("void *") ByteBuffer value) {
/* 891 */       STBIR_RESIZE.noutput_pixels(address(), value); return this;
/*     */     } public Buffer output_w(int value) {
/* 893 */       STBIR_RESIZE.noutput_w(address(), value); return this;
/*     */     } public Buffer output_h(int value) {
/* 895 */       STBIR_RESIZE.noutput_h(address(), value); return this;
/*     */     } public Buffer output_subx(int value) {
/* 897 */       STBIR_RESIZE.noutput_subx(address(), value); return this;
/*     */     } public Buffer output_suby(int value) {
/* 899 */       STBIR_RESIZE.noutput_suby(address(), value); return this;
/*     */     } public Buffer output_subw(int value) {
/* 901 */       STBIR_RESIZE.noutput_subw(address(), value); return this;
/*     */     } public Buffer output_subh(int value) {
/* 903 */       STBIR_RESIZE.noutput_subh(address(), value); return this;
/*     */     } public Buffer output_cb(@NativeType("stbir_output_callback **") PointerBuffer value) {
/* 905 */       STBIR_RESIZE.noutput_cb(address(), value); return this;
/*     */     } public Buffer input_stride_in_bytes(int value) {
/* 907 */       STBIR_RESIZE.ninput_stride_in_bytes(address(), value); return this;
/*     */     } public Buffer output_stride_in_bytes(int value) {
/* 909 */       STBIR_RESIZE.noutput_stride_in_bytes(address(), value); return this;
/*     */     } public Buffer splits(int value) {
/* 911 */       STBIR_RESIZE.nsplits(address(), value); return this;
/*     */     } public Buffer fast_alpha(@NativeType("int") boolean value) {
/* 913 */       STBIR_RESIZE.nfast_alpha(address(), value ? 1 : 0); return this;
/*     */     } public Buffer needs_rebuild(@NativeType("int") boolean value) {
/* 915 */       STBIR_RESIZE.nneeds_rebuild(address(), value ? 1 : 0); return this;
/*     */     } public Buffer called_alloc(@NativeType("int") boolean value) {
/* 917 */       STBIR_RESIZE.ncalled_alloc(address(), value ? 1 : 0); return this;
/*     */     } public Buffer input_pixel_layout_public(@NativeType("stbir_pixel_layout") int value) {
/* 919 */       STBIR_RESIZE.ninput_pixel_layout_public(address(), value); return this;
/*     */     } public Buffer output_pixel_layout_public(@NativeType("stbir_pixel_layout") int value) {
/* 921 */       STBIR_RESIZE.noutput_pixel_layout_public(address(), value); return this;
/*     */     } public Buffer input_data_type(@NativeType("stbir_datatype") int value) {
/* 923 */       STBIR_RESIZE.ninput_data_type(address(), value); return this;
/*     */     } public Buffer output_data_type(@NativeType("stbir_datatype") int value) {
/* 925 */       STBIR_RESIZE.noutput_data_type(address(), value); return this;
/*     */     } public Buffer horizontal_filter(@NativeType("stbir_filter") int value) {
/* 927 */       STBIR_RESIZE.nhorizontal_filter(address(), value); return this;
/*     */     } public Buffer vertical_filter(@NativeType("stbir_filter") int value) {
/* 929 */       STBIR_RESIZE.nvertical_filter(address(), value); return this;
/*     */     } public Buffer horizontal_edge(@NativeType("stbir_edge") int value) {
/* 931 */       STBIR_RESIZE.nhorizontal_edge(address(), value); return this;
/*     */     } public Buffer vertical_edge(@NativeType("stbir_edge") int value) {
/* 933 */       STBIR_RESIZE.nvertical_edge(address(), value); return this;
/*     */     } public Buffer horizontal_filter_kernel(@NativeType("stbir__kernel_callback **") PointerBuffer value) {
/* 935 */       STBIR_RESIZE.nhorizontal_filter_kernel(address(), value); return this;
/*     */     } public Buffer horizontal_filter_support(@NativeType("stbir__support_callback **") PointerBuffer value) {
/* 937 */       STBIR_RESIZE.nhorizontal_filter_support(address(), value); return this;
/*     */     } public Buffer vertical_filter_kernel(@NativeType("stbir__kernel_callback **") PointerBuffer value) {
/* 939 */       STBIR_RESIZE.nvertical_filter_kernel(address(), value); return this;
/*     */     } public Buffer vertical_filter_support(@NativeType("stbir__support_callback **") PointerBuffer value) {
/* 941 */       STBIR_RESIZE.nvertical_filter_support(address(), value); return this;
/*     */     } public Buffer samplers(@NativeType("stbir__info *") long value) {
/* 943 */       STBIR_RESIZE.nsamplers(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\stb\STBIR_RESIZE.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */