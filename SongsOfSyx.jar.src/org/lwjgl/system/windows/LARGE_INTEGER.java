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
/*     */ 
/*     */ public class LARGE_INTEGER
/*     */   extends Struct<LARGE_INTEGER>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int U;
/*     */   public static final int U_LOWPART;
/*     */   public static final int U_HIGHPART;
/*     */   public static final int QUADPART;
/*     */   
/*     */   static {
/*  44 */     Struct.Layout layout = __union(new Struct.Member[] {
/*  45 */           (Struct.Member)__struct(new Struct.Member[] {
/*  46 */               __member(4), 
/*  47 */               __member(4)
/*     */             
/*  49 */             }), __member(8)
/*     */         });
/*     */     
/*  52 */     SIZEOF = layout.getSize();
/*  53 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  55 */     U = layout.offsetof(0);
/*  56 */     U_LOWPART = layout.offsetof(1);
/*  57 */     U_HIGHPART = layout.offsetof(2);
/*  58 */     QUADPART = layout.offsetof(3);
/*     */   }
/*     */   
/*     */   protected LARGE_INTEGER(long address, ByteBuffer container) {
/*  62 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected LARGE_INTEGER create(long address, ByteBuffer container) {
/*  67 */     return new LARGE_INTEGER(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LARGE_INTEGER(ByteBuffer container) {
/*  77 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  81 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("DWORD")
/*     */   public int u_LowPart() {
/*  85 */     return nu_LowPart(address());
/*     */   } @NativeType("LONG")
/*     */   public int u_HighPart() {
/*  88 */     return nu_HighPart(address());
/*     */   } @NativeType("LONGLONG")
/*     */   public long QuadPart() {
/*  91 */     return nQuadPart(address());
/*     */   }
/*     */   public LARGE_INTEGER u_LowPart(@NativeType("DWORD") int value) {
/*  94 */     nu_LowPart(address(), value); return this;
/*     */   } public LARGE_INTEGER u_HighPart(@NativeType("LONG") int value) {
/*  96 */     nu_HighPart(address(), value); return this;
/*     */   } public LARGE_INTEGER QuadPart(@NativeType("LONGLONG") long value) {
/*  98 */     nQuadPart(address(), value); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LARGE_INTEGER set(LARGE_INTEGER src) {
/* 108 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 109 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static LARGE_INTEGER malloc() {
/* 116 */     return new LARGE_INTEGER(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static LARGE_INTEGER calloc() {
/* 121 */     return new LARGE_INTEGER(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static LARGE_INTEGER create() {
/* 126 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 127 */     return new LARGE_INTEGER(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static LARGE_INTEGER create(long address) {
/* 132 */     return new LARGE_INTEGER(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static LARGE_INTEGER createSafe(long address) {
/* 137 */     return (address == 0L) ? null : new LARGE_INTEGER(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 146 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 155 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 164 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 165 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 175 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 180 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static LARGE_INTEGER malloc(MemoryStack stack) {
/* 189 */     return new LARGE_INTEGER(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static LARGE_INTEGER calloc(MemoryStack stack) {
/* 198 */     return new LARGE_INTEGER(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 208 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 218 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nu_LowPart(long struct) {
/* 224 */     return MemoryUtil.memGetInt(struct + U_LOWPART);
/*     */   } public static int nu_HighPart(long struct) {
/* 226 */     return MemoryUtil.memGetInt(struct + U_HIGHPART);
/*     */   } public static long nQuadPart(long struct) {
/* 228 */     return MemoryUtil.memGetLong(struct + QUADPART);
/*     */   }
/*     */   public static void nu_LowPart(long struct, int value) {
/* 231 */     MemoryUtil.memPutInt(struct + U_LOWPART, value);
/*     */   } public static void nu_HighPart(long struct, int value) {
/* 233 */     MemoryUtil.memPutInt(struct + U_HIGHPART, value);
/*     */   } public static void nQuadPart(long struct, long value) {
/* 235 */     MemoryUtil.memPutLong(struct + QUADPART, value);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<LARGE_INTEGER, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 242 */     private static final LARGE_INTEGER ELEMENT_FACTORY = LARGE_INTEGER.create(-1L);
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
/* 254 */       super(container, container.remaining() / LARGE_INTEGER.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 258 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 262 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 267 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 272 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected LARGE_INTEGER getElementFactory() {
/* 277 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("DWORD")
/*     */     public int u_LowPart() {
/* 282 */       return LARGE_INTEGER.nu_LowPart(address());
/*     */     } @NativeType("LONG")
/*     */     public int u_HighPart() {
/* 285 */       return LARGE_INTEGER.nu_HighPart(address());
/*     */     } @NativeType("LONGLONG")
/*     */     public long QuadPart() {
/* 288 */       return LARGE_INTEGER.nQuadPart(address());
/*     */     }
/*     */     public Buffer u_LowPart(@NativeType("DWORD") int value) {
/* 291 */       LARGE_INTEGER.nu_LowPart(address(), value); return this;
/*     */     } public Buffer u_HighPart(@NativeType("LONG") int value) {
/* 293 */       LARGE_INTEGER.nu_HighPart(address(), value); return this;
/*     */     } public Buffer QuadPart(@NativeType("LONGLONG") long value) {
/* 295 */       LARGE_INTEGER.nQuadPart(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\windows\LARGE_INTEGER.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */