/*     */ package org.lwjgl.system.linux;
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
/*     */ @NativeType("struct f_owner_ex")
/*     */ public class FOwnerEx
/*     */   extends Struct<FOwnerEx>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int TYPE;
/*     */   public static final int PID;
/*     */   
/*     */   static {
/*  40 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  41 */           __member(4), 
/*  42 */           __member(4)
/*     */         });
/*     */     
/*  45 */     SIZEOF = layout.getSize();
/*  46 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  48 */     TYPE = layout.offsetof(0);
/*  49 */     PID = layout.offsetof(1);
/*     */   }
/*     */   
/*     */   protected FOwnerEx(long address, ByteBuffer container) {
/*  53 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected FOwnerEx create(long address, ByteBuffer container) {
/*  58 */     return new FOwnerEx(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FOwnerEx(ByteBuffer container) {
/*  68 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  72 */     return SIZEOF;
/*     */   }
/*     */   public int type() {
/*  75 */     return ntype(address());
/*     */   } @NativeType("pid_t")
/*     */   public int pid() {
/*  78 */     return npid(address());
/*     */   }
/*     */   public FOwnerEx type(int value) {
/*  81 */     ntype(address(), value); return this;
/*     */   } public FOwnerEx pid(@NativeType("pid_t") int value) {
/*  83 */     npid(address(), value); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FOwnerEx set(int type, int pid) {
/*  90 */     type(type);
/*  91 */     pid(pid);
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
/*     */   public FOwnerEx set(FOwnerEx src) {
/* 104 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 105 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static FOwnerEx malloc() {
/* 112 */     return new FOwnerEx(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static FOwnerEx calloc() {
/* 117 */     return new FOwnerEx(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static FOwnerEx create() {
/* 122 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 123 */     return new FOwnerEx(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static FOwnerEx create(long address) {
/* 128 */     return new FOwnerEx(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static FOwnerEx createSafe(long address) {
/* 133 */     return (address == 0L) ? null : new FOwnerEx(address, null);
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
/*     */   public static FOwnerEx malloc(MemoryStack stack) {
/* 185 */     return new FOwnerEx(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static FOwnerEx calloc(MemoryStack stack) {
/* 194 */     return new FOwnerEx(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
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
/*     */   public static int ntype(long struct) {
/* 220 */     return MemoryUtil.memGetInt(struct + TYPE);
/*     */   } public static int npid(long struct) {
/* 222 */     return MemoryUtil.memGetInt(struct + PID);
/*     */   }
/*     */   public static void ntype(long struct, int value) {
/* 225 */     MemoryUtil.memPutInt(struct + TYPE, value);
/*     */   } public static void npid(long struct, int value) {
/* 227 */     MemoryUtil.memPutInt(struct + PID, value);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<FOwnerEx, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 234 */     private static final FOwnerEx ELEMENT_FACTORY = FOwnerEx.create(-1L);
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
/* 246 */       super(container, container.remaining() / FOwnerEx.SIZEOF);
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
/*     */     protected FOwnerEx getElementFactory() {
/* 269 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     public int type() {
/* 273 */       return FOwnerEx.ntype(address());
/*     */     } @NativeType("pid_t")
/*     */     public int pid() {
/* 276 */       return FOwnerEx.npid(address());
/*     */     }
/*     */     public Buffer type(int value) {
/* 279 */       FOwnerEx.ntype(address(), value); return this;
/*     */     } public Buffer pid(@NativeType("pid_t") int value) {
/* 281 */       FOwnerEx.npid(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\FOwnerEx.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */