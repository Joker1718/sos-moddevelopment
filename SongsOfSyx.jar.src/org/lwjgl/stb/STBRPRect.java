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
/*     */ @NativeType("struct stbrp_rect")
/*     */ public class STBRPRect
/*     */   extends Struct<STBRPRect>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int ID;
/*     */   public static final int W;
/*     */   public static final int H;
/*     */   public static final int X;
/*     */   public static final int Y;
/*     */   public static final int WAS_PACKED;
/*     */   
/*     */   static {
/*  48 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  49 */           __member(4), 
/*  50 */           __member(4), 
/*  51 */           __member(4), 
/*  52 */           __member(4), 
/*  53 */           __member(4), 
/*  54 */           __member(4)
/*     */         });
/*     */     
/*  57 */     SIZEOF = layout.getSize();
/*  58 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  60 */     ID = layout.offsetof(0);
/*  61 */     W = layout.offsetof(1);
/*  62 */     H = layout.offsetof(2);
/*  63 */     X = layout.offsetof(3);
/*  64 */     Y = layout.offsetof(4);
/*  65 */     WAS_PACKED = layout.offsetof(5);
/*     */   }
/*     */   
/*     */   protected STBRPRect(long address, ByteBuffer container) {
/*  69 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected STBRPRect create(long address, ByteBuffer container) {
/*  74 */     return new STBRPRect(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public STBRPRect(ByteBuffer container) {
/*  84 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  88 */     return SIZEOF;
/*     */   }
/*     */   public int id() {
/*  91 */     return nid(address());
/*     */   } @NativeType("stbrp_coord")
/*     */   public int w() {
/*  94 */     return nw(address());
/*     */   } @NativeType("stbrp_coord")
/*     */   public int h() {
/*  97 */     return nh(address());
/*     */   } @NativeType("stbrp_coord")
/*     */   public int x() {
/* 100 */     return nx(address());
/*     */   } @NativeType("stbrp_coord")
/*     */   public int y() {
/* 103 */     return ny(address());
/*     */   } @NativeType("int")
/*     */   public boolean was_packed() {
/* 106 */     return (nwas_packed(address()) != 0);
/*     */   }
/*     */   public STBRPRect id(int value) {
/* 109 */     nid(address(), value); return this;
/*     */   } public STBRPRect w(@NativeType("stbrp_coord") int value) {
/* 111 */     nw(address(), value); return this;
/*     */   } public STBRPRect h(@NativeType("stbrp_coord") int value) {
/* 113 */     nh(address(), value); return this;
/*     */   } public STBRPRect x(@NativeType("stbrp_coord") int value) {
/* 115 */     nx(address(), value); return this;
/*     */   } public STBRPRect y(@NativeType("stbrp_coord") int value) {
/* 117 */     ny(address(), value); return this;
/*     */   } public STBRPRect was_packed(@NativeType("int") boolean value) {
/* 119 */     nwas_packed(address(), value ? 1 : 0); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public STBRPRect set(int id, int w, int h, int x, int y, boolean was_packed) {
/* 130 */     id(id);
/* 131 */     w(w);
/* 132 */     h(h);
/* 133 */     x(x);
/* 134 */     y(y);
/* 135 */     was_packed(was_packed);
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
/*     */   public STBRPRect set(STBRPRect src) {
/* 148 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 149 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBRPRect malloc() {
/* 156 */     return new STBRPRect(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBRPRect calloc() {
/* 161 */     return new STBRPRect(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBRPRect create() {
/* 166 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 167 */     return new STBRPRect(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBRPRect create(long address) {
/* 172 */     return new STBRPRect(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBRPRect createSafe(long address) {
/* 177 */     return (address == 0L) ? null : new STBRPRect(address, null);
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
/*     */   public static STBRPRect malloc(MemoryStack stack) {
/* 229 */     return new STBRPRect(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBRPRect calloc(MemoryStack stack) {
/* 238 */     return new STBRPRect(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
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
/*     */   public static int nid(long struct) {
/* 264 */     return MemoryUtil.memGetInt(struct + ID);
/*     */   } public static int nw(long struct) {
/* 266 */     return MemoryUtil.memGetInt(struct + W);
/*     */   } public static int nh(long struct) {
/* 268 */     return MemoryUtil.memGetInt(struct + H);
/*     */   } public static int nx(long struct) {
/* 270 */     return MemoryUtil.memGetInt(struct + X);
/*     */   } public static int ny(long struct) {
/* 272 */     return MemoryUtil.memGetInt(struct + Y);
/*     */   } public static int nwas_packed(long struct) {
/* 274 */     return MemoryUtil.memGetInt(struct + WAS_PACKED);
/*     */   }
/*     */   public static void nid(long struct, int value) {
/* 277 */     MemoryUtil.memPutInt(struct + ID, value);
/*     */   } public static void nw(long struct, int value) {
/* 279 */     MemoryUtil.memPutInt(struct + W, value);
/*     */   } public static void nh(long struct, int value) {
/* 281 */     MemoryUtil.memPutInt(struct + H, value);
/*     */   } public static void nx(long struct, int value) {
/* 283 */     MemoryUtil.memPutInt(struct + X, value);
/*     */   } public static void ny(long struct, int value) {
/* 285 */     MemoryUtil.memPutInt(struct + Y, value);
/*     */   } public static void nwas_packed(long struct, int value) {
/* 287 */     MemoryUtil.memPutInt(struct + WAS_PACKED, value);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<STBRPRect, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 294 */     private static final STBRPRect ELEMENT_FACTORY = STBRPRect.create(-1L);
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
/* 306 */       super(container, container.remaining() / STBRPRect.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 310 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 314 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 319 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 324 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected STBRPRect getElementFactory() {
/* 329 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     public int id() {
/* 333 */       return STBRPRect.nid(address());
/*     */     } @NativeType("stbrp_coord")
/*     */     public int w() {
/* 336 */       return STBRPRect.nw(address());
/*     */     } @NativeType("stbrp_coord")
/*     */     public int h() {
/* 339 */       return STBRPRect.nh(address());
/*     */     } @NativeType("stbrp_coord")
/*     */     public int x() {
/* 342 */       return STBRPRect.nx(address());
/*     */     } @NativeType("stbrp_coord")
/*     */     public int y() {
/* 345 */       return STBRPRect.ny(address());
/*     */     } @NativeType("int")
/*     */     public boolean was_packed() {
/* 348 */       return (STBRPRect.nwas_packed(address()) != 0);
/*     */     }
/*     */     public Buffer id(int value) {
/* 351 */       STBRPRect.nid(address(), value); return this;
/*     */     } public Buffer w(@NativeType("stbrp_coord") int value) {
/* 353 */       STBRPRect.nw(address(), value); return this;
/*     */     } public Buffer h(@NativeType("stbrp_coord") int value) {
/* 355 */       STBRPRect.nh(address(), value); return this;
/*     */     } public Buffer x(@NativeType("stbrp_coord") int value) {
/* 357 */       STBRPRect.nx(address(), value); return this;
/*     */     } public Buffer y(@NativeType("stbrp_coord") int value) {
/* 359 */       STBRPRect.ny(address(), value); return this;
/*     */     } public Buffer was_packed(@NativeType("int") boolean value) {
/* 361 */       STBRPRect.nwas_packed(address(), value ? 1 : 0); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\stb\STBRPRect.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */