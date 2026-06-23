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
/*     */ 
/*     */ public class SECURITY_ATTRIBUTES
/*     */   extends Struct<SECURITY_ATTRIBUTES>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int NLENGTH;
/*     */   public static final int LPSECURITYDESCRIPTOR;
/*     */   public static final int BINHERITHANDLE;
/*     */   
/*     */   static {
/*  42 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  43 */           __member(4), 
/*  44 */           __member(POINTER_SIZE), 
/*  45 */           __member(4)
/*     */         });
/*     */     
/*  48 */     SIZEOF = layout.getSize();
/*  49 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  51 */     NLENGTH = layout.offsetof(0);
/*  52 */     LPSECURITYDESCRIPTOR = layout.offsetof(1);
/*  53 */     BINHERITHANDLE = layout.offsetof(2);
/*     */   }
/*     */   
/*     */   protected SECURITY_ATTRIBUTES(long address, ByteBuffer container) {
/*  57 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected SECURITY_ATTRIBUTES create(long address, ByteBuffer container) {
/*  62 */     return new SECURITY_ATTRIBUTES(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SECURITY_ATTRIBUTES(ByteBuffer container) {
/*  72 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  76 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("DWORD")
/*     */   public int nLength() {
/*  80 */     return nnLength(address());
/*     */   } @NativeType("LPVOID")
/*     */   public long lpSecurityDescriptor() {
/*  83 */     return nlpSecurityDescriptor(address());
/*     */   } @NativeType("BOOL")
/*     */   public boolean bInheritHandle() {
/*  86 */     return (nbInheritHandle(address()) != 0);
/*     */   }
/*     */   public SECURITY_ATTRIBUTES nLength(@NativeType("DWORD") int value) {
/*  89 */     nnLength(address(), value); return this;
/*     */   } public SECURITY_ATTRIBUTES lpSecurityDescriptor(@NativeType("LPVOID") long value) {
/*  91 */     nlpSecurityDescriptor(address(), value); return this;
/*     */   } public SECURITY_ATTRIBUTES bInheritHandle(@NativeType("BOOL") boolean value) {
/*  93 */     nbInheritHandle(address(), value ? 1 : 0); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SECURITY_ATTRIBUTES set(int nLength, long lpSecurityDescriptor, boolean bInheritHandle) {
/* 101 */     nLength(nLength);
/* 102 */     lpSecurityDescriptor(lpSecurityDescriptor);
/* 103 */     bInheritHandle(bInheritHandle);
/*     */     
/* 105 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SECURITY_ATTRIBUTES set(SECURITY_ATTRIBUTES src) {
/* 116 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 117 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static SECURITY_ATTRIBUTES malloc() {
/* 124 */     return new SECURITY_ATTRIBUTES(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static SECURITY_ATTRIBUTES calloc() {
/* 129 */     return new SECURITY_ATTRIBUTES(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static SECURITY_ATTRIBUTES create() {
/* 134 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 135 */     return new SECURITY_ATTRIBUTES(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static SECURITY_ATTRIBUTES create(long address) {
/* 140 */     return new SECURITY_ATTRIBUTES(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static SECURITY_ATTRIBUTES createSafe(long address) {
/* 145 */     return (address == 0L) ? null : new SECURITY_ATTRIBUTES(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 154 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 163 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 172 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 173 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 183 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 188 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static SECURITY_ATTRIBUTES malloc(MemoryStack stack) {
/* 197 */     return new SECURITY_ATTRIBUTES(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static SECURITY_ATTRIBUTES calloc(MemoryStack stack) {
/* 206 */     return new SECURITY_ATTRIBUTES(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 216 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 226 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nnLength(long struct) {
/* 232 */     return MemoryUtil.memGetInt(struct + NLENGTH);
/*     */   } public static long nlpSecurityDescriptor(long struct) {
/* 234 */     return MemoryUtil.memGetAddress(struct + LPSECURITYDESCRIPTOR);
/*     */   } public static int nbInheritHandle(long struct) {
/* 236 */     return MemoryUtil.memGetInt(struct + BINHERITHANDLE);
/*     */   }
/*     */   public static void nnLength(long struct, int value) {
/* 239 */     MemoryUtil.memPutInt(struct + NLENGTH, value);
/*     */   } public static void nlpSecurityDescriptor(long struct, long value) {
/* 241 */     MemoryUtil.memPutAddress(struct + LPSECURITYDESCRIPTOR, Checks.check(value));
/*     */   } public static void nbInheritHandle(long struct, int value) {
/* 243 */     MemoryUtil.memPutInt(struct + BINHERITHANDLE, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long struct) {
/* 251 */     Checks.check(MemoryUtil.memGetAddress(struct + LPSECURITYDESCRIPTOR));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<SECURITY_ATTRIBUTES, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 259 */     private static final SECURITY_ATTRIBUTES ELEMENT_FACTORY = SECURITY_ATTRIBUTES.create(-1L);
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
/* 271 */       super(container, container.remaining() / SECURITY_ATTRIBUTES.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 275 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 279 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 284 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 289 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected SECURITY_ATTRIBUTES getElementFactory() {
/* 294 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("DWORD")
/*     */     public int nLength() {
/* 299 */       return SECURITY_ATTRIBUTES.nnLength(address());
/*     */     } @NativeType("LPVOID")
/*     */     public long lpSecurityDescriptor() {
/* 302 */       return SECURITY_ATTRIBUTES.nlpSecurityDescriptor(address());
/*     */     } @NativeType("BOOL")
/*     */     public boolean bInheritHandle() {
/* 305 */       return (SECURITY_ATTRIBUTES.nbInheritHandle(address()) != 0);
/*     */     }
/*     */     public Buffer nLength(@NativeType("DWORD") int value) {
/* 308 */       SECURITY_ATTRIBUTES.nnLength(address(), value); return this;
/*     */     } public Buffer lpSecurityDescriptor(@NativeType("LPVOID") long value) {
/* 310 */       SECURITY_ATTRIBUTES.nlpSecurityDescriptor(address(), value); return this;
/*     */     } public Buffer bInheritHandle(@NativeType("BOOL") boolean value) {
/* 312 */       SECURITY_ATTRIBUTES.nbInheritHandle(address(), value ? 1 : 0); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\windows\SECURITY_ATTRIBUTES.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */