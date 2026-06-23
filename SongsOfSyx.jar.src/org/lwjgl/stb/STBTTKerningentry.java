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
/*     */ @NativeType("struct stbtt_kerningentry")
/*     */ public class STBTTKerningentry
/*     */   extends Struct<STBTTKerningentry>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int GLYPH1;
/*     */   public static final int GLYPH2;
/*     */   public static final int ADVANCE;
/*     */   
/*     */   static {
/*  42 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  43 */           __member(4), 
/*  44 */           __member(4), 
/*  45 */           __member(4)
/*     */         });
/*     */     
/*  48 */     SIZEOF = layout.getSize();
/*  49 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  51 */     GLYPH1 = layout.offsetof(0);
/*  52 */     GLYPH2 = layout.offsetof(1);
/*  53 */     ADVANCE = layout.offsetof(2);
/*     */   }
/*     */   
/*     */   protected STBTTKerningentry(long address, ByteBuffer container) {
/*  57 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected STBTTKerningentry create(long address, ByteBuffer container) {
/*  62 */     return new STBTTKerningentry(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public STBTTKerningentry(ByteBuffer container) {
/*  72 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  76 */     return SIZEOF;
/*     */   }
/*     */   public int glyph1() {
/*  79 */     return nglyph1(address());
/*     */   } public int glyph2() {
/*  81 */     return nglyph2(address());
/*     */   } public int advance() {
/*  83 */     return nadvance(address());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBTTKerningentry malloc() {
/*  89 */     return new STBTTKerningentry(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBTTKerningentry calloc() {
/*  94 */     return new STBTTKerningentry(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBTTKerningentry create() {
/*  99 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 100 */     return new STBTTKerningentry(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBTTKerningentry create(long address) {
/* 105 */     return new STBTTKerningentry(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBTTKerningentry createSafe(long address) {
/* 110 */     return (address == 0L) ? null : new STBTTKerningentry(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 119 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 128 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 137 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 138 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 148 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 153 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBTTKerningentry malloc(MemoryStack stack) {
/* 162 */     return new STBTTKerningentry(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBTTKerningentry calloc(MemoryStack stack) {
/* 171 */     return new STBTTKerningentry(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 181 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 191 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nglyph1(long struct) {
/* 197 */     return MemoryUtil.memGetInt(struct + GLYPH1);
/*     */   } public static int nglyph2(long struct) {
/* 199 */     return MemoryUtil.memGetInt(struct + GLYPH2);
/*     */   } public static int nadvance(long struct) {
/* 201 */     return MemoryUtil.memGetInt(struct + ADVANCE);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<STBTTKerningentry, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 208 */     private static final STBTTKerningentry ELEMENT_FACTORY = STBTTKerningentry.create(-1L);
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
/* 220 */       super(container, container.remaining() / STBTTKerningentry.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 224 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 228 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 233 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 238 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected STBTTKerningentry getElementFactory() {
/* 243 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     public int glyph1() {
/* 247 */       return STBTTKerningentry.nglyph1(address());
/*     */     } public int glyph2() {
/* 249 */       return STBTTKerningentry.nglyph2(address());
/*     */     } public int advance() {
/* 251 */       return STBTTKerningentry.nadvance(address());
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\stb\STBTTKerningentry.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */