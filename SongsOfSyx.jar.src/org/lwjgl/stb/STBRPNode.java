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
/*     */ @NativeType("struct stbrp_node")
/*     */ public class STBRPNode
/*     */   extends Struct<STBRPNode>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int X;
/*     */   public static final int Y;
/*     */   public static final int NEXT;
/*     */   
/*     */   static {
/*  42 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  43 */           __member(4), 
/*  44 */           __member(4), 
/*  45 */           __member(POINTER_SIZE)
/*     */         });
/*     */     
/*  48 */     SIZEOF = layout.getSize();
/*  49 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  51 */     X = layout.offsetof(0);
/*  52 */     Y = layout.offsetof(1);
/*  53 */     NEXT = layout.offsetof(2);
/*     */   }
/*     */   
/*     */   protected STBRPNode(long address, ByteBuffer container) {
/*  57 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected STBRPNode create(long address, ByteBuffer container) {
/*  62 */     return new STBRPNode(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public STBRPNode(ByteBuffer container) {
/*  72 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  76 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("stbrp_coord")
/*     */   public int x() {
/*  80 */     return nx(address());
/*     */   } @NativeType("stbrp_coord")
/*     */   public int y() {
/*  83 */     return ny(address());
/*     */   } @NativeType("stbrp_node *")
/*     */   public STBRPNode next() {
/*  86 */     return nnext(address());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBRPNode malloc() {
/*  92 */     return new STBRPNode(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBRPNode calloc() {
/*  97 */     return new STBRPNode(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBRPNode create() {
/* 102 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 103 */     return new STBRPNode(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBRPNode create(long address) {
/* 108 */     return new STBRPNode(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBRPNode createSafe(long address) {
/* 113 */     return (address == 0L) ? null : new STBRPNode(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 122 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 131 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 140 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 141 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 151 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 156 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBRPNode malloc(MemoryStack stack) {
/* 165 */     return new STBRPNode(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBRPNode calloc(MemoryStack stack) {
/* 174 */     return new STBRPNode(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 184 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 194 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nx(long struct) {
/* 200 */     return MemoryUtil.memGetInt(struct + X);
/*     */   } public static int ny(long struct) {
/* 202 */     return MemoryUtil.memGetInt(struct + Y);
/*     */   } public static STBRPNode nnext(long struct) {
/* 204 */     return createSafe(MemoryUtil.memGetAddress(struct + NEXT));
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<STBRPNode, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 211 */     private static final STBRPNode ELEMENT_FACTORY = STBRPNode.create(-1L);
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
/* 223 */       super(container, container.remaining() / STBRPNode.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 227 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 231 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 236 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 241 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected STBRPNode getElementFactory() {
/* 246 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("stbrp_coord")
/*     */     public int x() {
/* 251 */       return STBRPNode.nx(address());
/*     */     } @NativeType("stbrp_coord")
/*     */     public int y() {
/* 254 */       return STBRPNode.ny(address());
/*     */     } @NativeType("stbrp_node *")
/*     */     public STBRPNode next() {
/* 257 */       return STBRPNode.nnext(address());
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\stb\STBRPNode.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */