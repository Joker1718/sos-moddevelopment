/*     */ package org.lwjgl.system.jni;
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
/*     */ public class JNINativeMethod
/*     */   extends Struct<JNINativeMethod>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int NAME;
/*     */   public static final int SIGNATURE;
/*     */   public static final int FNPTR;
/*     */   
/*     */   static {
/*  42 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  43 */           __member(POINTER_SIZE), 
/*  44 */           __member(POINTER_SIZE), 
/*  45 */           __member(POINTER_SIZE)
/*     */         });
/*     */     
/*  48 */     SIZEOF = layout.getSize();
/*  49 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  51 */     NAME = layout.offsetof(0);
/*  52 */     SIGNATURE = layout.offsetof(1);
/*  53 */     FNPTR = layout.offsetof(2);
/*     */   }
/*     */   
/*     */   protected JNINativeMethod(long address, ByteBuffer container) {
/*  57 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected JNINativeMethod create(long address, ByteBuffer container) {
/*  62 */     return new JNINativeMethod(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JNINativeMethod(ByteBuffer container) {
/*  72 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  76 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("char *")
/*     */   public ByteBuffer name() {
/*  80 */     return nname(address());
/*     */   } @NativeType("char *")
/*     */   public String nameString() {
/*  83 */     return nnameString(address());
/*     */   } @NativeType("char *")
/*     */   public ByteBuffer signature() {
/*  86 */     return nsignature(address());
/*     */   } @NativeType("char *")
/*     */   public String signatureString() {
/*  89 */     return nsignatureString(address());
/*     */   } @NativeType("void *")
/*     */   public long fnPtr() {
/*  92 */     return nfnPtr(address());
/*     */   }
/*     */   public JNINativeMethod name(@NativeType("char *") ByteBuffer value) {
/*  95 */     nname(address(), value); return this;
/*     */   } public JNINativeMethod signature(@NativeType("char *") ByteBuffer value) {
/*  97 */     nsignature(address(), value); return this;
/*     */   } public JNINativeMethod fnPtr(@NativeType("void *") long value) {
/*  99 */     nfnPtr(address(), value); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JNINativeMethod set(ByteBuffer name, ByteBuffer signature, long fnPtr) {
/* 107 */     name(name);
/* 108 */     signature(signature);
/* 109 */     fnPtr(fnPtr);
/*     */     
/* 111 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JNINativeMethod set(JNINativeMethod src) {
/* 122 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 123 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static JNINativeMethod malloc() {
/* 130 */     return new JNINativeMethod(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static JNINativeMethod calloc() {
/* 135 */     return new JNINativeMethod(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static JNINativeMethod create() {
/* 140 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 141 */     return new JNINativeMethod(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static JNINativeMethod create(long address) {
/* 146 */     return new JNINativeMethod(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static JNINativeMethod createSafe(long address) {
/* 151 */     return (address == 0L) ? null : new JNINativeMethod(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 160 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 169 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 178 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 179 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 189 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 194 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static JNINativeMethod malloc(MemoryStack stack) {
/* 203 */     return new JNINativeMethod(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static JNINativeMethod calloc(MemoryStack stack) {
/* 212 */     return new JNINativeMethod(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 222 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 232 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static ByteBuffer nname(long struct) {
/* 238 */     return MemoryUtil.memByteBufferNT1(MemoryUtil.memGetAddress(struct + NAME));
/*     */   } public static String nnameString(long struct) {
/* 240 */     return MemoryUtil.memUTF8(MemoryUtil.memGetAddress(struct + NAME));
/*     */   } public static ByteBuffer nsignature(long struct) {
/* 242 */     return MemoryUtil.memByteBufferNT1(MemoryUtil.memGetAddress(struct + SIGNATURE));
/*     */   } public static String nsignatureString(long struct) {
/* 244 */     return MemoryUtil.memUTF8(MemoryUtil.memGetAddress(struct + SIGNATURE));
/*     */   } public static long nfnPtr(long struct) {
/* 246 */     return MemoryUtil.memGetAddress(struct + FNPTR);
/*     */   }
/*     */   
/*     */   public static void nname(long struct, ByteBuffer value) {
/* 250 */     if (Checks.CHECKS) Checks.checkNT1(value); 
/* 251 */     MemoryUtil.memPutAddress(struct + NAME, MemoryUtil.memAddress(value));
/*     */   }
/*     */   
/*     */   public static void nsignature(long struct, ByteBuffer value) {
/* 255 */     if (Checks.CHECKS) Checks.checkNT1(value); 
/* 256 */     MemoryUtil.memPutAddress(struct + SIGNATURE, MemoryUtil.memAddress(value));
/*     */   }
/*     */   public static void nfnPtr(long struct, long value) {
/* 259 */     MemoryUtil.memPutAddress(struct + FNPTR, Checks.check(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long struct) {
/* 267 */     Checks.check(MemoryUtil.memGetAddress(struct + NAME));
/* 268 */     Checks.check(MemoryUtil.memGetAddress(struct + SIGNATURE));
/* 269 */     Checks.check(MemoryUtil.memGetAddress(struct + FNPTR));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<JNINativeMethod, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 277 */     private static final JNINativeMethod ELEMENT_FACTORY = JNINativeMethod.create(-1L);
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
/* 289 */       super(container, container.remaining() / JNINativeMethod.SIZEOF);
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
/*     */     protected JNINativeMethod getElementFactory() {
/* 312 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("char *")
/*     */     public ByteBuffer name() {
/* 317 */       return JNINativeMethod.nname(address());
/*     */     } @NativeType("char *")
/*     */     public String nameString() {
/* 320 */       return JNINativeMethod.nnameString(address());
/*     */     } @NativeType("char *")
/*     */     public ByteBuffer signature() {
/* 323 */       return JNINativeMethod.nsignature(address());
/*     */     } @NativeType("char *")
/*     */     public String signatureString() {
/* 326 */       return JNINativeMethod.nsignatureString(address());
/*     */     } @NativeType("void *")
/*     */     public long fnPtr() {
/* 329 */       return JNINativeMethod.nfnPtr(address());
/*     */     }
/*     */     public Buffer name(@NativeType("char *") ByteBuffer value) {
/* 332 */       JNINativeMethod.nname(address(), value); return this;
/*     */     } public Buffer signature(@NativeType("char *") ByteBuffer value) {
/* 334 */       JNINativeMethod.nsignature(address(), value); return this;
/*     */     } public Buffer fnPtr(@NativeType("void *") long value) {
/* 336 */       JNINativeMethod.nfnPtr(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\jni\JNINativeMethod.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */