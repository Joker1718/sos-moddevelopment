/*     */ package org.lwjgl.system.macosx;
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
/*     */ @NativeType("struct objc_property_attribute_t")
/*     */ public class ObjCPropertyAttribute
/*     */   extends Struct<ObjCPropertyAttribute>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int NAME;
/*     */   public static final int VALUE;
/*     */   
/*     */   static {
/*  41 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  42 */           __member(POINTER_SIZE), 
/*  43 */           __member(POINTER_SIZE)
/*     */         });
/*     */     
/*  46 */     SIZEOF = layout.getSize();
/*  47 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  49 */     NAME = layout.offsetof(0);
/*  50 */     VALUE = layout.offsetof(1);
/*     */   }
/*     */   
/*     */   protected ObjCPropertyAttribute(long address, ByteBuffer container) {
/*  54 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected ObjCPropertyAttribute create(long address, ByteBuffer container) {
/*  59 */     return new ObjCPropertyAttribute(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ObjCPropertyAttribute(ByteBuffer container) {
/*  69 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  73 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("char *")
/*     */   public ByteBuffer name() {
/*  77 */     return nname(address());
/*     */   } @NativeType("char *")
/*     */   public String nameString() {
/*  80 */     return nnameString(address());
/*     */   } @NativeType("char *")
/*     */   public ByteBuffer value() {
/*  83 */     return nvalue(address());
/*     */   } @NativeType("char *")
/*     */   public String valueString() {
/*  86 */     return nvalueString(address());
/*     */   }
/*     */   public ObjCPropertyAttribute name(@NativeType("char *") ByteBuffer value) {
/*  89 */     nname(address(), value); return this;
/*     */   } public ObjCPropertyAttribute value(@NativeType("char *") ByteBuffer value) {
/*  91 */     nvalue(address(), value); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ObjCPropertyAttribute set(ByteBuffer name, ByteBuffer value) {
/*  98 */     name(name);
/*  99 */     value(value);
/*     */     
/* 101 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ObjCPropertyAttribute set(ObjCPropertyAttribute src) {
/* 112 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 113 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ObjCPropertyAttribute malloc() {
/* 120 */     return new ObjCPropertyAttribute(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static ObjCPropertyAttribute calloc() {
/* 125 */     return new ObjCPropertyAttribute(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static ObjCPropertyAttribute create() {
/* 130 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 131 */     return new ObjCPropertyAttribute(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static ObjCPropertyAttribute create(long address) {
/* 136 */     return new ObjCPropertyAttribute(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static ObjCPropertyAttribute createSafe(long address) {
/* 141 */     return (address == 0L) ? null : new ObjCPropertyAttribute(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 150 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 159 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 168 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 169 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 179 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 184 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ObjCPropertyAttribute malloc(MemoryStack stack) {
/* 193 */     return new ObjCPropertyAttribute(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ObjCPropertyAttribute calloc(MemoryStack stack) {
/* 202 */     return new ObjCPropertyAttribute(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 212 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 222 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static ByteBuffer nname(long struct) {
/* 228 */     return MemoryUtil.memByteBufferNT1(MemoryUtil.memGetAddress(struct + NAME));
/*     */   } public static String nnameString(long struct) {
/* 230 */     return MemoryUtil.memUTF8(MemoryUtil.memGetAddress(struct + NAME));
/*     */   } public static ByteBuffer nvalue(long struct) {
/* 232 */     return MemoryUtil.memByteBufferNT1(MemoryUtil.memGetAddress(struct + VALUE));
/*     */   } public static String nvalueString(long struct) {
/* 234 */     return MemoryUtil.memUTF8(MemoryUtil.memGetAddress(struct + VALUE));
/*     */   }
/*     */   
/*     */   public static void nname(long struct, ByteBuffer value) {
/* 238 */     if (Checks.CHECKS) Checks.checkNT1(value); 
/* 239 */     MemoryUtil.memPutAddress(struct + NAME, MemoryUtil.memAddress(value));
/*     */   }
/*     */   
/*     */   public static void nvalue(long struct, ByteBuffer value) {
/* 243 */     if (Checks.CHECKS) Checks.checkNT1(value); 
/* 244 */     MemoryUtil.memPutAddress(struct + VALUE, MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long struct) {
/* 253 */     Checks.check(MemoryUtil.memGetAddress(struct + NAME));
/* 254 */     Checks.check(MemoryUtil.memGetAddress(struct + VALUE));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<ObjCPropertyAttribute, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 262 */     private static final ObjCPropertyAttribute ELEMENT_FACTORY = ObjCPropertyAttribute.create(-1L);
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
/* 274 */       super(container, container.remaining() / ObjCPropertyAttribute.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 278 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 282 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 287 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 292 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected ObjCPropertyAttribute getElementFactory() {
/* 297 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("char *")
/*     */     public ByteBuffer name() {
/* 302 */       return ObjCPropertyAttribute.nname(address());
/*     */     } @NativeType("char *")
/*     */     public String nameString() {
/* 305 */       return ObjCPropertyAttribute.nnameString(address());
/*     */     } @NativeType("char *")
/*     */     public ByteBuffer value() {
/* 308 */       return ObjCPropertyAttribute.nvalue(address());
/*     */     } @NativeType("char *")
/*     */     public String valueString() {
/* 311 */       return ObjCPropertyAttribute.nvalueString(address());
/*     */     }
/*     */     public Buffer name(@NativeType("char *") ByteBuffer value) {
/* 314 */       ObjCPropertyAttribute.nname(address(), value); return this;
/*     */     } public Buffer value(@NativeType("char *") ByteBuffer value) {
/* 316 */       ObjCPropertyAttribute.nvalue(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\macosx\ObjCPropertyAttribute.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */