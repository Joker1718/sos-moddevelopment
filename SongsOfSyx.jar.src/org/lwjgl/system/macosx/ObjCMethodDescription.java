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
/*     */ @NativeType("struct objc_method_description")
/*     */ public class ObjCMethodDescription
/*     */   extends Struct<ObjCMethodDescription>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int NAME;
/*     */   public static final int TYPES;
/*     */   
/*     */   static {
/*  40 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  41 */           __member(POINTER_SIZE), 
/*  42 */           __member(POINTER_SIZE)
/*     */         });
/*     */     
/*  45 */     SIZEOF = layout.getSize();
/*  46 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  48 */     NAME = layout.offsetof(0);
/*  49 */     TYPES = layout.offsetof(1);
/*     */   }
/*     */   
/*     */   protected ObjCMethodDescription(long address, ByteBuffer container) {
/*  53 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected ObjCMethodDescription create(long address, ByteBuffer container) {
/*  58 */     return new ObjCMethodDescription(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ObjCMethodDescription(ByteBuffer container) {
/*  68 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  72 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("SEL")
/*     */   public long name() {
/*  76 */     return nname(address());
/*     */   } @NativeType("char *")
/*     */   public ByteBuffer types() {
/*  79 */     return ntypes(address());
/*     */   } @NativeType("char *")
/*     */   public String typesString() {
/*  82 */     return ntypesString(address());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static ObjCMethodDescription malloc() {
/*  88 */     return new ObjCMethodDescription(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static ObjCMethodDescription calloc() {
/*  93 */     return new ObjCMethodDescription(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static ObjCMethodDescription create() {
/*  98 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/*  99 */     return new ObjCMethodDescription(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static ObjCMethodDescription create(long address) {
/* 104 */     return new ObjCMethodDescription(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static ObjCMethodDescription createSafe(long address) {
/* 109 */     return (address == 0L) ? null : new ObjCMethodDescription(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 118 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 127 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 136 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 137 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 147 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 152 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ObjCMethodDescription malloc(MemoryStack stack) {
/* 161 */     return new ObjCMethodDescription(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ObjCMethodDescription calloc(MemoryStack stack) {
/* 170 */     return new ObjCMethodDescription(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 180 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 190 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nname(long struct) {
/* 196 */     return MemoryUtil.memGetAddress(struct + NAME);
/*     */   } public static ByteBuffer ntypes(long struct) {
/* 198 */     return MemoryUtil.memByteBufferNT1(MemoryUtil.memGetAddress(struct + TYPES));
/*     */   } public static String ntypesString(long struct) {
/* 200 */     return MemoryUtil.memUTF8(MemoryUtil.memGetAddress(struct + TYPES));
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<ObjCMethodDescription, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 207 */     private static final ObjCMethodDescription ELEMENT_FACTORY = ObjCMethodDescription.create(-1L);
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
/* 219 */       super(container, container.remaining() / ObjCMethodDescription.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 223 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 227 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 232 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 237 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected ObjCMethodDescription getElementFactory() {
/* 242 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("SEL")
/*     */     public long name() {
/* 247 */       return ObjCMethodDescription.nname(address());
/*     */     } @NativeType("char *")
/*     */     public ByteBuffer types() {
/* 250 */       return ObjCMethodDescription.ntypes(address());
/*     */     } @NativeType("char *")
/*     */     public String typesString() {
/* 253 */       return ObjCMethodDescription.ntypesString(address());
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\macosx\ObjCMethodDescription.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */