/*     */ package org.lwjgl.system.macosx;
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
/*     */ public class CGPoint
/*     */   extends Struct<CGPoint>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int X;
/*     */   public static final int Y;
/*     */   
/*     */   static {
/*  39 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  40 */           __member(8), 
/*  41 */           __member(8)
/*     */         });
/*     */     
/*  44 */     SIZEOF = layout.getSize();
/*  45 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  47 */     X = layout.offsetof(0);
/*  48 */     Y = layout.offsetof(1);
/*     */   }
/*     */   
/*     */   protected CGPoint(long address, ByteBuffer container) {
/*  52 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected CGPoint create(long address, ByteBuffer container) {
/*  57 */     return new CGPoint(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CGPoint(ByteBuffer container) {
/*  67 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  71 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("CGFloat")
/*     */   public double x() {
/*  75 */     return nx(address());
/*     */   } @NativeType("CGFloat")
/*     */   public double y() {
/*  78 */     return ny(address());
/*     */   }
/*     */   public CGPoint x(@NativeType("CGFloat") double value) {
/*  81 */     nx(address(), value); return this;
/*     */   } public CGPoint y(@NativeType("CGFloat") double value) {
/*  83 */     ny(address(), value); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CGPoint set(double x, double y) {
/*  90 */     x(x);
/*  91 */     y(y);
/*     */     
/*  93 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CGPoint set(CGPoint src) {
/* 104 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 105 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static CGPoint malloc() {
/* 112 */     return new CGPoint(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static CGPoint calloc() {
/* 117 */     return new CGPoint(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static CGPoint create() {
/* 122 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 123 */     return new CGPoint(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static CGPoint create(long address) {
/* 128 */     return new CGPoint(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static CGPoint createSafe(long address) {
/* 133 */     return (address == 0L) ? null : new CGPoint(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 142 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 151 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 160 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 161 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 171 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 176 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static CGPoint malloc(MemoryStack stack) {
/* 185 */     return new CGPoint(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static CGPoint calloc(MemoryStack stack) {
/* 194 */     return new CGPoint(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 204 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 214 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static double nx(long struct) {
/* 220 */     return MemoryUtil.memGetDouble(struct + X);
/*     */   } public static double ny(long struct) {
/* 222 */     return MemoryUtil.memGetDouble(struct + Y);
/*     */   }
/*     */   public static void nx(long struct, double value) {
/* 225 */     MemoryUtil.memPutDouble(struct + X, value);
/*     */   } public static void ny(long struct, double value) {
/* 227 */     MemoryUtil.memPutDouble(struct + Y, value);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<CGPoint, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 234 */     private static final CGPoint ELEMENT_FACTORY = CGPoint.create(-1L);
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
/* 246 */       super(container, container.remaining() / CGPoint.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 250 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 254 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 259 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 264 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected CGPoint getElementFactory() {
/* 269 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("CGFloat")
/*     */     public double x() {
/* 274 */       return CGPoint.nx(address());
/*     */     } @NativeType("CGFloat")
/*     */     public double y() {
/* 277 */       return CGPoint.ny(address());
/*     */     }
/*     */     public Buffer x(@NativeType("CGFloat") double value) {
/* 280 */       CGPoint.nx(address(), value); return this;
/*     */     } public Buffer y(@NativeType("CGFloat") double value) {
/* 282 */       CGPoint.ny(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\macosx\CGPoint.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */