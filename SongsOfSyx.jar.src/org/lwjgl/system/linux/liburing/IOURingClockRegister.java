/*     */ package org.lwjgl.system.linux.liburing;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.IntBuffer;
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
/*     */ @NativeType("struct io_uring_clock_register")
/*     */ public class IOURingClockRegister
/*     */   extends Struct<IOURingClockRegister>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int CLOCKID;
/*     */   public static final int __RESV;
/*     */   
/*     */   static {
/*  41 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  42 */           __member(4), 
/*  43 */           __array(4, 3)
/*     */         });
/*     */     
/*  46 */     SIZEOF = layout.getSize();
/*  47 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  49 */     CLOCKID = layout.offsetof(0);
/*  50 */     __RESV = layout.offsetof(1);
/*     */   }
/*     */   
/*     */   protected IOURingClockRegister(long address, ByteBuffer container) {
/*  54 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected IOURingClockRegister create(long address, ByteBuffer container) {
/*  59 */     return new IOURingClockRegister(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingClockRegister(ByteBuffer container) {
/*  69 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  73 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("__u32")
/*     */   public int clockid() {
/*  77 */     return nclockid(address());
/*     */   }
/*     */   public IOURingClockRegister clockid(@NativeType("__u32") int value) {
/*  80 */     nclockid(address(), value); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingClockRegister set(IOURingClockRegister src) {
/*  90 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/*  91 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingClockRegister malloc() {
/*  98 */     return new IOURingClockRegister(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingClockRegister calloc() {
/* 103 */     return new IOURingClockRegister(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingClockRegister create() {
/* 108 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 109 */     return new IOURingClockRegister(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingClockRegister create(long address) {
/* 114 */     return new IOURingClockRegister(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingClockRegister createSafe(long address) {
/* 119 */     return (address == 0L) ? null : new IOURingClockRegister(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 128 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 137 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 146 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 147 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 157 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 162 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingClockRegister malloc(MemoryStack stack) {
/* 171 */     return new IOURingClockRegister(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingClockRegister calloc(MemoryStack stack) {
/* 180 */     return new IOURingClockRegister(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 190 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 200 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nclockid(long struct) {
/* 206 */     return MemoryUtil.memGetInt(struct + CLOCKID); } public static IntBuffer n__resv(long struct) {
/* 207 */     return MemoryUtil.memIntBuffer(struct + __RESV, 3);
/*     */   } public static int n__resv(long struct, int index) {
/* 209 */     return MemoryUtil.memGetInt(struct + __RESV + Checks.check(index, 3) * 4L);
/*     */   }
/*     */   
/*     */   public static void nclockid(long struct, int value) {
/* 213 */     MemoryUtil.memPutInt(struct + CLOCKID, value);
/*     */   } public static void n__resv(long struct, IntBuffer value) {
/* 215 */     if (Checks.CHECKS) Checks.checkGT(value, 3); 
/* 216 */     MemoryUtil.memCopy(MemoryUtil.memAddress(value), struct + __RESV, (value.remaining() * 4));
/*     */   }
/*     */   public static void n__resv(long struct, int index, int value) {
/* 219 */     MemoryUtil.memPutInt(struct + __RESV + Checks.check(index, 3) * 4L, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<IOURingClockRegister, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 227 */     private static final IOURingClockRegister ELEMENT_FACTORY = IOURingClockRegister.create(-1L);
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
/* 239 */       super(container, container.remaining() / IOURingClockRegister.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 243 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 247 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 252 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 257 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected IOURingClockRegister getElementFactory() {
/* 262 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("__u32")
/*     */     public int clockid() {
/* 267 */       return IOURingClockRegister.nclockid(address());
/*     */     }
/*     */     public Buffer clockid(@NativeType("__u32") int value) {
/* 270 */       IOURingClockRegister.nclockid(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\liburing\IOURingClockRegister.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */