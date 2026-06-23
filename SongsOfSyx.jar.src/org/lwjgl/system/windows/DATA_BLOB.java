/*     */ package org.lwjgl.system.windows;
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
/*     */ public class DATA_BLOB
/*     */   extends Struct<DATA_BLOB>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int CBDATA;
/*     */   public static final int PBDATA;
/*     */   
/*     */   static {
/*  40 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  41 */           __member(4), 
/*  42 */           __member(POINTER_SIZE)
/*     */         });
/*     */     
/*  45 */     SIZEOF = layout.getSize();
/*  46 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  48 */     CBDATA = layout.offsetof(0);
/*  49 */     PBDATA = layout.offsetof(1);
/*     */   }
/*     */   
/*     */   protected DATA_BLOB(long address, ByteBuffer container) {
/*  53 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected DATA_BLOB create(long address, ByteBuffer container) {
/*  58 */     return new DATA_BLOB(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DATA_BLOB(ByteBuffer container) {
/*  68 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  72 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("DWORD")
/*     */   public int cbData() {
/*  76 */     return ncbData(address());
/*     */   } @NativeType("BYTE *")
/*     */   public ByteBuffer pbData() {
/*  79 */     return npbData(address());
/*     */   }
/*     */   public DATA_BLOB pbData(@NativeType("BYTE *") ByteBuffer value) {
/*  82 */     npbData(address(), value); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DATA_BLOB set(DATA_BLOB src) {
/*  92 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/*  93 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static DATA_BLOB malloc() {
/* 100 */     return new DATA_BLOB(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static DATA_BLOB calloc() {
/* 105 */     return new DATA_BLOB(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static DATA_BLOB create() {
/* 110 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 111 */     return new DATA_BLOB(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static DATA_BLOB create(long address) {
/* 116 */     return new DATA_BLOB(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static DATA_BLOB createSafe(long address) {
/* 121 */     return (address == 0L) ? null : new DATA_BLOB(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 130 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 139 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 148 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 149 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 159 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 164 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static DATA_BLOB malloc(MemoryStack stack) {
/* 173 */     return new DATA_BLOB(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static DATA_BLOB calloc(MemoryStack stack) {
/* 182 */     return new DATA_BLOB(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 192 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 202 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int ncbData(long struct) {
/* 208 */     return MemoryUtil.memGetInt(struct + CBDATA);
/*     */   } public static ByteBuffer npbData(long struct) {
/* 210 */     return MemoryUtil.memByteBuffer(MemoryUtil.memGetAddress(struct + PBDATA), ncbData(struct));
/*     */   }
/*     */   public static void ncbData(long struct, int value) {
/* 213 */     MemoryUtil.memPutInt(struct + CBDATA, value);
/*     */   } public static void npbData(long struct, ByteBuffer value) {
/* 215 */     MemoryUtil.memPutAddress(struct + PBDATA, MemoryUtil.memAddress(value)); ncbData(struct, value.remaining());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long struct) {
/* 223 */     Checks.check(MemoryUtil.memGetAddress(struct + PBDATA));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<DATA_BLOB, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 231 */     private static final DATA_BLOB ELEMENT_FACTORY = DATA_BLOB.create(-1L);
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
/* 243 */       super(container, container.remaining() / DATA_BLOB.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 247 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 251 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 256 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 261 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected DATA_BLOB getElementFactory() {
/* 266 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("DWORD")
/*     */     public int cbData() {
/* 271 */       return DATA_BLOB.ncbData(address());
/*     */     } @NativeType("BYTE *")
/*     */     public ByteBuffer pbData() {
/* 274 */       return DATA_BLOB.npbData(address());
/*     */     }
/*     */     public Buffer pbData(@NativeType("BYTE *") ByteBuffer value) {
/* 277 */       DATA_BLOB.npbData(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\windows\DATA_BLOB.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */