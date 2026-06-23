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
/*     */ 
/*     */ 
/*     */ public class RECT
/*     */   extends Struct<RECT>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int LEFT;
/*     */   public static final int TOP;
/*     */   public static final int RIGHT;
/*     */   public static final int BOTTOM;
/*     */   
/*     */   static {
/*  43 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  44 */           __member(4), 
/*  45 */           __member(4), 
/*  46 */           __member(4), 
/*  47 */           __member(4)
/*     */         });
/*     */     
/*  50 */     SIZEOF = layout.getSize();
/*  51 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  53 */     LEFT = layout.offsetof(0);
/*  54 */     TOP = layout.offsetof(1);
/*  55 */     RIGHT = layout.offsetof(2);
/*  56 */     BOTTOM = layout.offsetof(3);
/*     */   }
/*     */   
/*     */   protected RECT(long address, ByteBuffer container) {
/*  60 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected RECT create(long address, ByteBuffer container) {
/*  65 */     return new RECT(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RECT(ByteBuffer container) {
/*  75 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  79 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("LONG")
/*     */   public int left() {
/*  83 */     return nleft(address());
/*     */   } @NativeType("LONG")
/*     */   public int top() {
/*  86 */     return ntop(address());
/*     */   } @NativeType("LONG")
/*     */   public int right() {
/*  89 */     return nright(address());
/*     */   } @NativeType("LONG")
/*     */   public int bottom() {
/*  92 */     return nbottom(address());
/*     */   }
/*     */   public RECT left(@NativeType("LONG") int value) {
/*  95 */     nleft(address(), value); return this;
/*     */   } public RECT top(@NativeType("LONG") int value) {
/*  97 */     ntop(address(), value); return this;
/*     */   } public RECT right(@NativeType("LONG") int value) {
/*  99 */     nright(address(), value); return this;
/*     */   } public RECT bottom(@NativeType("LONG") int value) {
/* 101 */     nbottom(address(), value); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RECT set(int left, int top, int right, int bottom) {
/* 110 */     left(left);
/* 111 */     top(top);
/* 112 */     right(right);
/* 113 */     bottom(bottom);
/*     */     
/* 115 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RECT set(RECT src) {
/* 126 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 127 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static RECT malloc() {
/* 134 */     return new RECT(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static RECT calloc() {
/* 139 */     return new RECT(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static RECT create() {
/* 144 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 145 */     return new RECT(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static RECT create(long address) {
/* 150 */     return new RECT(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static RECT createSafe(long address) {
/* 155 */     return (address == 0L) ? null : new RECT(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 164 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 173 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 182 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 183 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 193 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 198 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static RECT malloc(MemoryStack stack) {
/* 207 */     return new RECT(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static RECT calloc(MemoryStack stack) {
/* 216 */     return new RECT(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 226 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 236 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nleft(long struct) {
/* 242 */     return MemoryUtil.memGetInt(struct + LEFT);
/*     */   } public static int ntop(long struct) {
/* 244 */     return MemoryUtil.memGetInt(struct + TOP);
/*     */   } public static int nright(long struct) {
/* 246 */     return MemoryUtil.memGetInt(struct + RIGHT);
/*     */   } public static int nbottom(long struct) {
/* 248 */     return MemoryUtil.memGetInt(struct + BOTTOM);
/*     */   }
/*     */   public static void nleft(long struct, int value) {
/* 251 */     MemoryUtil.memPutInt(struct + LEFT, value);
/*     */   } public static void ntop(long struct, int value) {
/* 253 */     MemoryUtil.memPutInt(struct + TOP, value);
/*     */   } public static void nright(long struct, int value) {
/* 255 */     MemoryUtil.memPutInt(struct + RIGHT, value);
/*     */   } public static void nbottom(long struct, int value) {
/* 257 */     MemoryUtil.memPutInt(struct + BOTTOM, value);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<RECT, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 264 */     private static final RECT ELEMENT_FACTORY = RECT.create(-1L);
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
/* 276 */       super(container, container.remaining() / RECT.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 280 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 284 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 289 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 294 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected RECT getElementFactory() {
/* 299 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("LONG")
/*     */     public int left() {
/* 304 */       return RECT.nleft(address());
/*     */     } @NativeType("LONG")
/*     */     public int top() {
/* 307 */       return RECT.ntop(address());
/*     */     } @NativeType("LONG")
/*     */     public int right() {
/* 310 */       return RECT.nright(address());
/*     */     } @NativeType("LONG")
/*     */     public int bottom() {
/* 313 */       return RECT.nbottom(address());
/*     */     }
/*     */     public Buffer left(@NativeType("LONG") int value) {
/* 316 */       RECT.nleft(address(), value); return this;
/*     */     } public Buffer top(@NativeType("LONG") int value) {
/* 318 */       RECT.ntop(address(), value); return this;
/*     */     } public Buffer right(@NativeType("LONG") int value) {
/* 320 */       RECT.nright(address(), value); return this;
/*     */     } public Buffer bottom(@NativeType("LONG") int value) {
/* 322 */       RECT.nbottom(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\windows\RECT.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */