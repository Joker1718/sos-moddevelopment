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
/*     */ @NativeType("struct stbtt_aligned_quad")
/*     */ public class STBTTAlignedQuad
/*     */   extends Struct<STBTTAlignedQuad>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int X0;
/*     */   public static final int Y0;
/*     */   public static final int S0;
/*     */   public static final int T0;
/*     */   public static final int X1;
/*     */   public static final int Y1;
/*     */   public static final int S1;
/*     */   public static final int T1;
/*     */   
/*     */   static {
/*  52 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  53 */           __member(4), 
/*  54 */           __member(4), 
/*  55 */           __member(4), 
/*  56 */           __member(4), 
/*  57 */           __member(4), 
/*  58 */           __member(4), 
/*  59 */           __member(4), 
/*  60 */           __member(4)
/*     */         });
/*     */     
/*  63 */     SIZEOF = layout.getSize();
/*  64 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  66 */     X0 = layout.offsetof(0);
/*  67 */     Y0 = layout.offsetof(1);
/*  68 */     S0 = layout.offsetof(2);
/*  69 */     T0 = layout.offsetof(3);
/*  70 */     X1 = layout.offsetof(4);
/*  71 */     Y1 = layout.offsetof(5);
/*  72 */     S1 = layout.offsetof(6);
/*  73 */     T1 = layout.offsetof(7);
/*     */   }
/*     */   
/*     */   protected STBTTAlignedQuad(long address, ByteBuffer container) {
/*  77 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected STBTTAlignedQuad create(long address, ByteBuffer container) {
/*  82 */     return new STBTTAlignedQuad(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public STBTTAlignedQuad(ByteBuffer container) {
/*  92 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  96 */     return SIZEOF;
/*     */   }
/*     */   public float x0() {
/*  99 */     return nx0(address());
/*     */   } public float y0() {
/* 101 */     return ny0(address());
/*     */   } public float s0() {
/* 103 */     return ns0(address());
/*     */   } public float t0() {
/* 105 */     return nt0(address());
/*     */   } public float x1() {
/* 107 */     return nx1(address());
/*     */   } public float y1() {
/* 109 */     return ny1(address());
/*     */   } public float s1() {
/* 111 */     return ns1(address());
/*     */   } public float t1() {
/* 113 */     return nt1(address());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBTTAlignedQuad malloc() {
/* 119 */     return new STBTTAlignedQuad(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBTTAlignedQuad calloc() {
/* 124 */     return new STBTTAlignedQuad(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBTTAlignedQuad create() {
/* 129 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 130 */     return new STBTTAlignedQuad(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBTTAlignedQuad create(long address) {
/* 135 */     return new STBTTAlignedQuad(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBTTAlignedQuad createSafe(long address) {
/* 140 */     return (address == 0L) ? null : new STBTTAlignedQuad(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 149 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 158 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 167 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 168 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 178 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 183 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBTTAlignedQuad malloc(MemoryStack stack) {
/* 192 */     return new STBTTAlignedQuad(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBTTAlignedQuad calloc(MemoryStack stack) {
/* 201 */     return new STBTTAlignedQuad(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 211 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 221 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static float nx0(long struct) {
/* 227 */     return MemoryUtil.memGetFloat(struct + X0);
/*     */   } public static float ny0(long struct) {
/* 229 */     return MemoryUtil.memGetFloat(struct + Y0);
/*     */   } public static float ns0(long struct) {
/* 231 */     return MemoryUtil.memGetFloat(struct + S0);
/*     */   } public static float nt0(long struct) {
/* 233 */     return MemoryUtil.memGetFloat(struct + T0);
/*     */   } public static float nx1(long struct) {
/* 235 */     return MemoryUtil.memGetFloat(struct + X1);
/*     */   } public static float ny1(long struct) {
/* 237 */     return MemoryUtil.memGetFloat(struct + Y1);
/*     */   } public static float ns1(long struct) {
/* 239 */     return MemoryUtil.memGetFloat(struct + S1);
/*     */   } public static float nt1(long struct) {
/* 241 */     return MemoryUtil.memGetFloat(struct + T1);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<STBTTAlignedQuad, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 248 */     private static final STBTTAlignedQuad ELEMENT_FACTORY = STBTTAlignedQuad.create(-1L);
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
/* 260 */       super(container, container.remaining() / STBTTAlignedQuad.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 264 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 268 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 273 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 278 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected STBTTAlignedQuad getElementFactory() {
/* 283 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     public float x0() {
/* 287 */       return STBTTAlignedQuad.nx0(address());
/*     */     } public float y0() {
/* 289 */       return STBTTAlignedQuad.ny0(address());
/*     */     } public float s0() {
/* 291 */       return STBTTAlignedQuad.ns0(address());
/*     */     } public float t0() {
/* 293 */       return STBTTAlignedQuad.nt0(address());
/*     */     } public float x1() {
/* 295 */       return STBTTAlignedQuad.nx1(address());
/*     */     } public float y1() {
/* 297 */       return STBTTAlignedQuad.ny1(address());
/*     */     } public float s1() {
/* 299 */       return STBTTAlignedQuad.ns1(address());
/*     */     } public float t1() {
/* 301 */       return STBTTAlignedQuad.nt1(address());
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\stb\STBTTAlignedQuad.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */