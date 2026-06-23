/*     */ package org.lwjgl.stb;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @NativeType("struct stbtt_pack_context")
/*     */ public class STBTTPackContext
/*     */   extends Struct<STBTTPackContext>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int USER_ALLOCATOR_CONTEXT;
/*     */   public static final int PACK_INFO;
/*     */   public static final int WIDTH;
/*     */   public static final int HEIGHT;
/*     */   public static final int STRIDE_IN_BYTES;
/*     */   public static final int PADDING;
/*     */   public static final int SKIP_MISSING;
/*     */   public static final int H_OVERSAMPLE;
/*     */   public static final int V_OVERSAMPLE;
/*     */   public static final int PIXELS;
/*     */   public static final int NODES;
/*     */   
/*     */   static {
/*  58 */     Struct.Layout layout = __struct(new Struct.Member[] { 
/*  59 */           __member(POINTER_SIZE), 
/*  60 */           __member(POINTER_SIZE), 
/*  61 */           __member(4), 
/*  62 */           __member(4), 
/*  63 */           __member(4), 
/*  64 */           __member(4), 
/*  65 */           __member(4), 
/*  66 */           __member(4), 
/*  67 */           __member(4), 
/*  68 */           __member(POINTER_SIZE), 
/*  69 */           __member(POINTER_SIZE) });
/*     */ 
/*     */     
/*  72 */     SIZEOF = layout.getSize();
/*  73 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  75 */     USER_ALLOCATOR_CONTEXT = layout.offsetof(0);
/*  76 */     PACK_INFO = layout.offsetof(1);
/*  77 */     WIDTH = layout.offsetof(2);
/*  78 */     HEIGHT = layout.offsetof(3);
/*  79 */     STRIDE_IN_BYTES = layout.offsetof(4);
/*  80 */     PADDING = layout.offsetof(5);
/*  81 */     SKIP_MISSING = layout.offsetof(6);
/*  82 */     H_OVERSAMPLE = layout.offsetof(7);
/*  83 */     V_OVERSAMPLE = layout.offsetof(8);
/*  84 */     PIXELS = layout.offsetof(9);
/*  85 */     NODES = layout.offsetof(10);
/*     */   }
/*     */   
/*     */   protected STBTTPackContext(long address, ByteBuffer container) {
/*  89 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected STBTTPackContext create(long address, ByteBuffer container) {
/*  94 */     return new STBTTPackContext(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public STBTTPackContext(ByteBuffer container) {
/* 104 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/* 108 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("void *")
/*     */   public long user_allocator_context() {
/* 112 */     return nuser_allocator_context(address());
/*     */   } @NativeType("stbrp_context *")
/*     */   public STBRPContext pack_info() {
/* 115 */     return npack_info(address());
/*     */   } public int width() {
/* 117 */     return nwidth(address());
/*     */   } public int height() {
/* 119 */     return nheight(address());
/*     */   } public int stride_in_bytes() {
/* 121 */     return nstride_in_bytes(address());
/*     */   } public int padding() {
/* 123 */     return npadding(address());
/*     */   } @NativeType("int")
/*     */   public boolean skip_missing() {
/* 126 */     return (nskip_missing(address()) != 0);
/*     */   } @NativeType("unsigned int")
/*     */   public int h_oversample() {
/* 129 */     return nh_oversample(address());
/*     */   } @NativeType("unsigned int")
/*     */   public int v_oversample() {
/* 132 */     return nv_oversample(address());
/*     */   } @NativeType("unsigned char *")
/*     */   public ByteBuffer pixels(int capacity) {
/* 135 */     return npixels(address(), capacity);
/*     */   } @NativeType("stbrp_node *")
/*     */   public STBRPNode.Buffer nodes(int capacity) {
/* 138 */     return nnodes(address(), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBTTPackContext malloc() {
/* 144 */     return new STBTTPackContext(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBTTPackContext calloc() {
/* 149 */     return new STBTTPackContext(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBTTPackContext create() {
/* 154 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 155 */     return new STBTTPackContext(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBTTPackContext create(long address) {
/* 160 */     return new STBTTPackContext(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBTTPackContext createSafe(long address) {
/* 165 */     return (address == 0L) ? null : new STBTTPackContext(address, null);
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
/*     */   public static STBTTPackContext malloc(MemoryStack stack) {
/* 217 */     return new STBTTPackContext(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBTTPackContext calloc(MemoryStack stack) {
/* 226 */     return new STBTTPackContext(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
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
/*     */   public static long nuser_allocator_context(long struct) {
/* 252 */     return MemoryUtil.memGetAddress(struct + USER_ALLOCATOR_CONTEXT);
/*     */   } public static STBRPContext npack_info(long struct) {
/* 254 */     return STBRPContext.create(MemoryUtil.memGetAddress(struct + PACK_INFO));
/*     */   } public static int nwidth(long struct) {
/* 256 */     return MemoryUtil.memGetInt(struct + WIDTH);
/*     */   } public static int nheight(long struct) {
/* 258 */     return MemoryUtil.memGetInt(struct + HEIGHT);
/*     */   } public static int nstride_in_bytes(long struct) {
/* 260 */     return MemoryUtil.memGetInt(struct + STRIDE_IN_BYTES);
/*     */   } public static int npadding(long struct) {
/* 262 */     return MemoryUtil.memGetInt(struct + PADDING);
/*     */   } public static int nskip_missing(long struct) {
/* 264 */     return MemoryUtil.memGetInt(struct + SKIP_MISSING);
/*     */   } public static int nh_oversample(long struct) {
/* 266 */     return MemoryUtil.memGetInt(struct + H_OVERSAMPLE);
/*     */   } public static int nv_oversample(long struct) {
/* 268 */     return MemoryUtil.memGetInt(struct + V_OVERSAMPLE);
/*     */   } public static ByteBuffer npixels(long struct, int capacity) {
/* 270 */     return MemoryUtil.memByteBuffer(MemoryUtil.memGetAddress(struct + PIXELS), capacity);
/*     */   } public static STBRPNode.Buffer nnodes(long struct, int capacity) {
/* 272 */     return STBRPNode.create(MemoryUtil.memGetAddress(struct + NODES), capacity);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<STBTTPackContext, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 279 */     private static final STBTTPackContext ELEMENT_FACTORY = STBTTPackContext.create(-1L);
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
/* 291 */       super(container, container.remaining() / STBTTPackContext.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 295 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 299 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 304 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 309 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected STBTTPackContext getElementFactory() {
/* 314 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("void *")
/*     */     public long user_allocator_context() {
/* 319 */       return STBTTPackContext.nuser_allocator_context(address());
/*     */     } @NativeType("stbrp_context *")
/*     */     public STBRPContext pack_info() {
/* 322 */       return STBTTPackContext.npack_info(address());
/*     */     } public int width() {
/* 324 */       return STBTTPackContext.nwidth(address());
/*     */     } public int height() {
/* 326 */       return STBTTPackContext.nheight(address());
/*     */     } public int stride_in_bytes() {
/* 328 */       return STBTTPackContext.nstride_in_bytes(address());
/*     */     } public int padding() {
/* 330 */       return STBTTPackContext.npadding(address());
/*     */     } @NativeType("int")
/*     */     public boolean skip_missing() {
/* 333 */       return (STBTTPackContext.nskip_missing(address()) != 0);
/*     */     } @NativeType("unsigned int")
/*     */     public int h_oversample() {
/* 336 */       return STBTTPackContext.nh_oversample(address());
/*     */     } @NativeType("unsigned int")
/*     */     public int v_oversample() {
/* 339 */       return STBTTPackContext.nv_oversample(address());
/*     */     } @NativeType("unsigned char *")
/*     */     public ByteBuffer pixels(int capacity) {
/* 342 */       return STBTTPackContext.npixels(address(), capacity);
/*     */     } @NativeType("stbrp_node *")
/*     */     public STBRPNode.Buffer nodes(int capacity) {
/* 345 */       return STBTTPackContext.nnodes(address(), capacity);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\stb\STBTTPackContext.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */