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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @NativeType("struct stbrp_context")
/*     */ public class STBRPContext
/*     */   extends Struct<STBRPContext>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int WIDTH;
/*     */   public static final int HEIGHT;
/*     */   public static final int ALIGN;
/*     */   public static final int INIT_MODE;
/*     */   public static final int HEURISTIC;
/*     */   public static final int NUM_NODES;
/*     */   public static final int ACTIVE_HEAD;
/*     */   public static final int FREE_HEAD;
/*     */   public static final int EXTRA;
/*     */   
/*     */   static {
/*  55 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  56 */           __member(4), 
/*  57 */           __member(4), 
/*  58 */           __member(4), 
/*  59 */           __member(4), 
/*  60 */           __member(4), 
/*  61 */           __member(4), 
/*  62 */           __member(POINTER_SIZE), 
/*  63 */           __member(POINTER_SIZE), 
/*  64 */           __array(STBRPNode.SIZEOF, STBRPNode.ALIGNOF, 2)
/*     */         });
/*     */     
/*  67 */     SIZEOF = layout.getSize();
/*  68 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  70 */     WIDTH = layout.offsetof(0);
/*  71 */     HEIGHT = layout.offsetof(1);
/*  72 */     ALIGN = layout.offsetof(2);
/*  73 */     INIT_MODE = layout.offsetof(3);
/*  74 */     HEURISTIC = layout.offsetof(4);
/*  75 */     NUM_NODES = layout.offsetof(5);
/*  76 */     ACTIVE_HEAD = layout.offsetof(6);
/*  77 */     FREE_HEAD = layout.offsetof(7);
/*  78 */     EXTRA = layout.offsetof(8);
/*     */   }
/*     */   
/*     */   protected STBRPContext(long address, ByteBuffer container) {
/*  82 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected STBRPContext create(long address, ByteBuffer container) {
/*  87 */     return new STBRPContext(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public STBRPContext(ByteBuffer container) {
/*  97 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/* 101 */     return SIZEOF;
/*     */   }
/*     */   public int width() {
/* 104 */     return nwidth(address());
/*     */   } public int height() {
/* 106 */     return nheight(address());
/*     */   } public int align() {
/* 108 */     return nalign(address());
/*     */   } public int init_mode() {
/* 110 */     return ninit_mode(address());
/*     */   } public int heuristic() {
/* 112 */     return nheuristic(address());
/*     */   } public int num_nodes() {
/* 114 */     return nnum_nodes(address());
/*     */   } @NativeType("stbrp_node *")
/*     */   public STBRPNode active_head() {
/* 117 */     return nactive_head(address());
/*     */   } @NativeType("stbrp_node *")
/*     */   public STBRPNode free_head() {
/* 120 */     return nfree_head(address());
/*     */   } @NativeType("stbrp_node[2]")
/*     */   public STBRPNode.Buffer extra() {
/* 123 */     return nextra(address());
/*     */   } @NativeType("stbrp_node")
/*     */   public STBRPNode extra(int index) {
/* 126 */     return nextra(address(), index);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBRPContext malloc() {
/* 132 */     return new STBRPContext(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBRPContext calloc() {
/* 137 */     return new STBRPContext(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBRPContext create() {
/* 142 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 143 */     return new STBRPContext(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBRPContext create(long address) {
/* 148 */     return new STBRPContext(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBRPContext createSafe(long address) {
/* 153 */     return (address == 0L) ? null : new STBRPContext(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 162 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 171 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 180 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 181 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 191 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 196 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBRPContext malloc(MemoryStack stack) {
/* 205 */     return new STBRPContext(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBRPContext calloc(MemoryStack stack) {
/* 214 */     return new STBRPContext(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 224 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 234 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nwidth(long struct) {
/* 240 */     return MemoryUtil.memGetInt(struct + WIDTH);
/*     */   } public static int nheight(long struct) {
/* 242 */     return MemoryUtil.memGetInt(struct + HEIGHT);
/*     */   } public static int nalign(long struct) {
/* 244 */     return MemoryUtil.memGetInt(struct + ALIGN);
/*     */   } public static int ninit_mode(long struct) {
/* 246 */     return MemoryUtil.memGetInt(struct + INIT_MODE);
/*     */   } public static int nheuristic(long struct) {
/* 248 */     return MemoryUtil.memGetInt(struct + HEURISTIC);
/*     */   } public static int nnum_nodes(long struct) {
/* 250 */     return MemoryUtil.memGetInt(struct + NUM_NODES);
/*     */   } public static STBRPNode nactive_head(long struct) {
/* 252 */     return STBRPNode.createSafe(MemoryUtil.memGetAddress(struct + ACTIVE_HEAD));
/*     */   } public static STBRPNode nfree_head(long struct) {
/* 254 */     return STBRPNode.createSafe(MemoryUtil.memGetAddress(struct + FREE_HEAD));
/*     */   } public static STBRPNode.Buffer nextra(long struct) {
/* 256 */     return STBRPNode.create(struct + EXTRA, 2);
/*     */   }
/*     */   public static STBRPNode nextra(long struct, int index) {
/* 259 */     return STBRPNode.create(struct + EXTRA + Checks.check(index, 2) * STBRPNode.SIZEOF);
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<STBRPContext, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 267 */     private static final STBRPContext ELEMENT_FACTORY = STBRPContext.create(-1L);
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
/* 279 */       super(container, container.remaining() / STBRPContext.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 283 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 287 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 292 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 297 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected STBRPContext getElementFactory() {
/* 302 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     public int width() {
/* 306 */       return STBRPContext.nwidth(address());
/*     */     } public int height() {
/* 308 */       return STBRPContext.nheight(address());
/*     */     } public int align() {
/* 310 */       return STBRPContext.nalign(address());
/*     */     } public int init_mode() {
/* 312 */       return STBRPContext.ninit_mode(address());
/*     */     } public int heuristic() {
/* 314 */       return STBRPContext.nheuristic(address());
/*     */     } public int num_nodes() {
/* 316 */       return STBRPContext.nnum_nodes(address());
/*     */     } @NativeType("stbrp_node *")
/*     */     public STBRPNode active_head() {
/* 319 */       return STBRPContext.nactive_head(address());
/*     */     } @NativeType("stbrp_node *")
/*     */     public STBRPNode free_head() {
/* 322 */       return STBRPContext.nfree_head(address());
/*     */     } @NativeType("stbrp_node[2]")
/*     */     public STBRPNode.Buffer extra() {
/* 325 */       return STBRPContext.nextra(address());
/*     */     } @NativeType("stbrp_node")
/*     */     public STBRPNode extra(int index) {
/* 328 */       return STBRPContext.nextra(address(), index);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\stb\STBRPContext.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */