/*     */ package org.lwjgl.glfw;
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
/*     */ @NativeType("struct GLFWallocator")
/*     */ public class GLFWAllocator
/*     */   extends Struct<GLFWAllocator>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int ALLOCATE;
/*     */   public static final int REALLOCATE;
/*     */   public static final int DEALLOCATE;
/*     */   public static final int USER;
/*     */   
/*     */   static {
/*  45 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  46 */           __member(POINTER_SIZE), 
/*  47 */           __member(POINTER_SIZE), 
/*  48 */           __member(POINTER_SIZE), 
/*  49 */           __member(POINTER_SIZE)
/*     */         });
/*     */     
/*  52 */     SIZEOF = layout.getSize();
/*  53 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  55 */     ALLOCATE = layout.offsetof(0);
/*  56 */     REALLOCATE = layout.offsetof(1);
/*  57 */     DEALLOCATE = layout.offsetof(2);
/*  58 */     USER = layout.offsetof(3);
/*     */   }
/*     */   
/*     */   protected GLFWAllocator(long address, ByteBuffer container) {
/*  62 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected GLFWAllocator create(long address, ByteBuffer container) {
/*  67 */     return new GLFWAllocator(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GLFWAllocator(ByteBuffer container) {
/*  77 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  81 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("GLFWallocatefun")
/*     */   public GLFWAllocateCallback allocate() {
/*  85 */     return nallocate(address());
/*     */   } @NativeType("GLFWreallocatefun")
/*     */   public GLFWReallocateCallback reallocate() {
/*  88 */     return nreallocate(address());
/*     */   } @NativeType("GLFWdeallocatefun")
/*     */   public GLFWDeallocateCallback deallocate() {
/*  91 */     return ndeallocate(address());
/*     */   } @NativeType("void *")
/*     */   public long user() {
/*  94 */     return nuser(address());
/*     */   }
/*     */   public GLFWAllocator allocate(@NativeType("GLFWallocatefun") GLFWAllocateCallbackI value) {
/*  97 */     nallocate(address(), value); return this;
/*     */   } public GLFWAllocator reallocate(@NativeType("GLFWreallocatefun") GLFWReallocateCallbackI value) {
/*  99 */     nreallocate(address(), value); return this;
/*     */   } public GLFWAllocator deallocate(@NativeType("GLFWdeallocatefun") GLFWDeallocateCallbackI value) {
/* 101 */     ndeallocate(address(), value); return this;
/*     */   } public GLFWAllocator user(@NativeType("void *") long value) {
/* 103 */     nuser(address(), value); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GLFWAllocator set(GLFWAllocateCallbackI allocate, GLFWReallocateCallbackI reallocate, GLFWDeallocateCallbackI deallocate, long user) {
/* 112 */     allocate(allocate);
/* 113 */     reallocate(reallocate);
/* 114 */     deallocate(deallocate);
/* 115 */     user(user);
/*     */     
/* 117 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GLFWAllocator set(GLFWAllocator src) {
/* 128 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 129 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static GLFWAllocator malloc() {
/* 136 */     return new GLFWAllocator(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static GLFWAllocator calloc() {
/* 141 */     return new GLFWAllocator(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static GLFWAllocator create() {
/* 146 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 147 */     return new GLFWAllocator(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static GLFWAllocator create(long address) {
/* 152 */     return new GLFWAllocator(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static GLFWAllocator createSafe(long address) {
/* 157 */     return (address == 0L) ? null : new GLFWAllocator(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 166 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 175 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 184 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 185 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 195 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 200 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static GLFWAllocator malloc(MemoryStack stack) {
/* 209 */     return new GLFWAllocator(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static GLFWAllocator calloc(MemoryStack stack) {
/* 218 */     return new GLFWAllocator(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 228 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 238 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static GLFWAllocateCallback nallocate(long struct) {
/* 244 */     return GLFWAllocateCallback.create(MemoryUtil.memGetAddress(struct + ALLOCATE));
/*     */   } public static GLFWReallocateCallback nreallocate(long struct) {
/* 246 */     return GLFWReallocateCallback.create(MemoryUtil.memGetAddress(struct + REALLOCATE));
/*     */   } public static GLFWDeallocateCallback ndeallocate(long struct) {
/* 248 */     return GLFWDeallocateCallback.create(MemoryUtil.memGetAddress(struct + DEALLOCATE));
/*     */   } public static long nuser(long struct) {
/* 250 */     return MemoryUtil.memGetAddress(struct + USER);
/*     */   }
/*     */   public static void nallocate(long struct, GLFWAllocateCallbackI value) {
/* 253 */     MemoryUtil.memPutAddress(struct + ALLOCATE, value.address());
/*     */   } public static void nreallocate(long struct, GLFWReallocateCallbackI value) {
/* 255 */     MemoryUtil.memPutAddress(struct + REALLOCATE, value.address());
/*     */   } public static void ndeallocate(long struct, GLFWDeallocateCallbackI value) {
/* 257 */     MemoryUtil.memPutAddress(struct + DEALLOCATE, value.address());
/*     */   } public static void nuser(long struct, long value) {
/* 259 */     MemoryUtil.memPutAddress(struct + USER, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long struct) {
/* 267 */     Checks.check(MemoryUtil.memGetAddress(struct + ALLOCATE));
/* 268 */     Checks.check(MemoryUtil.memGetAddress(struct + REALLOCATE));
/* 269 */     Checks.check(MemoryUtil.memGetAddress(struct + DEALLOCATE));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<GLFWAllocator, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 277 */     private static final GLFWAllocator ELEMENT_FACTORY = GLFWAllocator.create(-1L);
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
/* 289 */       super(container, container.remaining() / GLFWAllocator.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 293 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 297 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 302 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 307 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected GLFWAllocator getElementFactory() {
/* 312 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("GLFWallocatefun")
/*     */     public GLFWAllocateCallback allocate() {
/* 317 */       return GLFWAllocator.nallocate(address());
/*     */     } @NativeType("GLFWreallocatefun")
/*     */     public GLFWReallocateCallback reallocate() {
/* 320 */       return GLFWAllocator.nreallocate(address());
/*     */     } @NativeType("GLFWdeallocatefun")
/*     */     public GLFWDeallocateCallback deallocate() {
/* 323 */       return GLFWAllocator.ndeallocate(address());
/*     */     } @NativeType("void *")
/*     */     public long user() {
/* 326 */       return GLFWAllocator.nuser(address());
/*     */     }
/*     */     public Buffer allocate(@NativeType("GLFWallocatefun") GLFWAllocateCallbackI value) {
/* 329 */       GLFWAllocator.nallocate(address(), value); return this;
/*     */     } public Buffer reallocate(@NativeType("GLFWreallocatefun") GLFWReallocateCallbackI value) {
/* 331 */       GLFWAllocator.nreallocate(address(), value); return this;
/*     */     } public Buffer deallocate(@NativeType("GLFWdeallocatefun") GLFWDeallocateCallbackI value) {
/* 333 */       GLFWAllocator.ndeallocate(address(), value); return this;
/*     */     } public Buffer user(@NativeType("void *") long value) {
/* 335 */       GLFWAllocator.nuser(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\glfw\GLFWAllocator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */