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
/*     */ @NativeType("struct stbtt_vertex")
/*     */ public class STBTTVertex
/*     */   extends Struct<STBTTVertex>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int X;
/*     */   public static final int Y;
/*     */   public static final int CX;
/*     */   public static final int CY;
/*     */   public static final int CX1;
/*     */   public static final int CY1;
/*     */   public static final int TYPE;
/*     */   
/*     */   static {
/*  50 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  51 */           __member(2), 
/*  52 */           __member(2), 
/*  53 */           __member(2), 
/*  54 */           __member(2), 
/*  55 */           __member(2), 
/*  56 */           __member(2), 
/*  57 */           __member(1)
/*     */         });
/*     */     
/*  60 */     SIZEOF = layout.getSize();
/*  61 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  63 */     X = layout.offsetof(0);
/*  64 */     Y = layout.offsetof(1);
/*  65 */     CX = layout.offsetof(2);
/*  66 */     CY = layout.offsetof(3);
/*  67 */     CX1 = layout.offsetof(4);
/*  68 */     CY1 = layout.offsetof(5);
/*  69 */     TYPE = layout.offsetof(6);
/*     */   }
/*     */   
/*     */   protected STBTTVertex(long address, ByteBuffer container) {
/*  73 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected STBTTVertex create(long address, ByteBuffer container) {
/*  78 */     return new STBTTVertex(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public STBTTVertex(ByteBuffer container) {
/*  88 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  92 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("stbtt_vertex_type")
/*     */   public short x() {
/*  96 */     return nx(address());
/*     */   } @NativeType("stbtt_vertex_type")
/*     */   public short y() {
/*  99 */     return ny(address());
/*     */   } @NativeType("stbtt_vertex_type")
/*     */   public short cx() {
/* 102 */     return ncx(address());
/*     */   } @NativeType("stbtt_vertex_type")
/*     */   public short cy() {
/* 105 */     return ncy(address());
/*     */   } @NativeType("stbtt_vertex_type")
/*     */   public short cx1() {
/* 108 */     return ncx1(address());
/*     */   } @NativeType("stbtt_vertex_type")
/*     */   public short cy1() {
/* 111 */     return ncy1(address());
/*     */   } @NativeType("unsigned char")
/*     */   public byte type() {
/* 114 */     return ntype(address());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBTTVertex malloc() {
/* 120 */     return new STBTTVertex(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBTTVertex calloc() {
/* 125 */     return new STBTTVertex(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBTTVertex create() {
/* 130 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 131 */     return new STBTTVertex(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBTTVertex create(long address) {
/* 136 */     return new STBTTVertex(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBTTVertex createSafe(long address) {
/* 141 */     return (address == 0L) ? null : new STBTTVertex(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 150 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 159 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 168 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 169 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 179 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 184 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBTTVertex malloc(MemoryStack stack) {
/* 193 */     return new STBTTVertex(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBTTVertex calloc(MemoryStack stack) {
/* 202 */     return new STBTTVertex(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 212 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 222 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static short nx(long struct) {
/* 228 */     return MemoryUtil.memGetShort(struct + X);
/*     */   } public static short ny(long struct) {
/* 230 */     return MemoryUtil.memGetShort(struct + Y);
/*     */   } public static short ncx(long struct) {
/* 232 */     return MemoryUtil.memGetShort(struct + CX);
/*     */   } public static short ncy(long struct) {
/* 234 */     return MemoryUtil.memGetShort(struct + CY);
/*     */   } public static short ncx1(long struct) {
/* 236 */     return MemoryUtil.memGetShort(struct + CX1);
/*     */   } public static short ncy1(long struct) {
/* 238 */     return MemoryUtil.memGetShort(struct + CY1);
/*     */   } public static byte ntype(long struct) {
/* 240 */     return MemoryUtil.memGetByte(struct + TYPE);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<STBTTVertex, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 247 */     private static final STBTTVertex ELEMENT_FACTORY = STBTTVertex.create(-1L);
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
/* 259 */       super(container, container.remaining() / STBTTVertex.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 263 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 267 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 272 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 277 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected STBTTVertex getElementFactory() {
/* 282 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("stbtt_vertex_type")
/*     */     public short x() {
/* 287 */       return STBTTVertex.nx(address());
/*     */     } @NativeType("stbtt_vertex_type")
/*     */     public short y() {
/* 290 */       return STBTTVertex.ny(address());
/*     */     } @NativeType("stbtt_vertex_type")
/*     */     public short cx() {
/* 293 */       return STBTTVertex.ncx(address());
/*     */     } @NativeType("stbtt_vertex_type")
/*     */     public short cy() {
/* 296 */       return STBTTVertex.ncy(address());
/*     */     } @NativeType("stbtt_vertex_type")
/*     */     public short cx1() {
/* 299 */       return STBTTVertex.ncx1(address());
/*     */     } @NativeType("stbtt_vertex_type")
/*     */     public short cy1() {
/* 302 */       return STBTTVertex.ncy1(address());
/*     */     } @NativeType("unsigned char")
/*     */     public byte type() {
/* 305 */       return STBTTVertex.ntype(address());
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\stb\STBTTVertex.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */