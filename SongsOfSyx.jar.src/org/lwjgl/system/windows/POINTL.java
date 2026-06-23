/*     */ package org.lwjgl.system.windows;
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
/*     */ public class POINTL
/*     */   extends Struct<POINTL>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int X;
/*     */   public static final int Y;
/*     */   
/*     */   static {
/*  39 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  40 */           __member(4), 
/*  41 */           __member(4)
/*     */         });
/*     */     
/*  44 */     SIZEOF = layout.getSize();
/*  45 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  47 */     X = layout.offsetof(0);
/*  48 */     Y = layout.offsetof(1);
/*     */   }
/*     */   
/*     */   protected POINTL(long address, ByteBuffer container) {
/*  52 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected POINTL create(long address, ByteBuffer container) {
/*  57 */     return new POINTL(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public POINTL(ByteBuffer container) {
/*  67 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  71 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("LONG")
/*     */   public int x() {
/*  75 */     return nx(address());
/*     */   } @NativeType("LONG")
/*     */   public int y() {
/*  78 */     return ny(address());
/*     */   }
/*     */   public POINTL x(@NativeType("LONG") int value) {
/*  81 */     nx(address(), value); return this;
/*     */   } public POINTL y(@NativeType("LONG") int value) {
/*  83 */     ny(address(), value); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public POINTL set(int x, int y) {
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
/*     */   public POINTL set(POINTL src) {
/* 104 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 105 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static POINTL malloc() {
/* 112 */     return new POINTL(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static POINTL calloc() {
/* 117 */     return new POINTL(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static POINTL create() {
/* 122 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 123 */     return new POINTL(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static POINTL create(long address) {
/* 128 */     return new POINTL(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static POINTL createSafe(long address) {
/* 133 */     return (address == 0L) ? null : new POINTL(address, null);
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
/*     */   public static POINTL malloc(MemoryStack stack) {
/* 185 */     return new POINTL(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static POINTL calloc(MemoryStack stack) {
/* 194 */     return new POINTL(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
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
/*     */   public static int nx(long struct) {
/* 220 */     return MemoryUtil.memGetInt(struct + X);
/*     */   } public static int ny(long struct) {
/* 222 */     return MemoryUtil.memGetInt(struct + Y);
/*     */   }
/*     */   public static void nx(long struct, int value) {
/* 225 */     MemoryUtil.memPutInt(struct + X, value);
/*     */   } public static void ny(long struct, int value) {
/* 227 */     MemoryUtil.memPutInt(struct + Y, value);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<POINTL, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 234 */     private static final POINTL ELEMENT_FACTORY = POINTL.create(-1L);
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
/* 246 */       super(container, container.remaining() / POINTL.SIZEOF);
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
/*     */     protected POINTL getElementFactory() {
/* 269 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("LONG")
/*     */     public int x() {
/* 274 */       return POINTL.nx(address());
/*     */     } @NativeType("LONG")
/*     */     public int y() {
/* 277 */       return POINTL.ny(address());
/*     */     }
/*     */     public Buffer x(@NativeType("LONG") int value) {
/* 280 */       POINTL.nx(address(), value); return this;
/*     */     } public Buffer y(@NativeType("LONG") int value) {
/* 282 */       POINTL.ny(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\windows\POINTL.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */