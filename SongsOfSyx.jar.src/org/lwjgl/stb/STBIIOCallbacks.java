/*     */ package org.lwjgl.stb;
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
/*     */ @NativeType("struct stbi_io_callbacks")
/*     */ public class STBIIOCallbacks
/*     */   extends Struct<STBIIOCallbacks>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int READ;
/*     */   public static final int SKIP;
/*     */   public static final int EOF;
/*     */   
/*     */   static {
/*  43 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  44 */           __member(POINTER_SIZE), 
/*  45 */           __member(POINTER_SIZE), 
/*  46 */           __member(POINTER_SIZE)
/*     */         });
/*     */     
/*  49 */     SIZEOF = layout.getSize();
/*  50 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  52 */     READ = layout.offsetof(0);
/*  53 */     SKIP = layout.offsetof(1);
/*  54 */     EOF = layout.offsetof(2);
/*     */   }
/*     */   
/*     */   protected STBIIOCallbacks(long address, ByteBuffer container) {
/*  58 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected STBIIOCallbacks create(long address, ByteBuffer container) {
/*  63 */     return new STBIIOCallbacks(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public STBIIOCallbacks(ByteBuffer container) {
/*  73 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  77 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("int (*) (void *, char *, int)")
/*     */   public STBIReadCallback read() {
/*  81 */     return nread(address());
/*     */   } @NativeType("void (*) (void *, int)")
/*     */   public STBISkipCallback skip() {
/*  84 */     return nskip(address());
/*     */   } @NativeType("int (*) (void *)")
/*     */   public STBIEOFCallback eof() {
/*  87 */     return neof(address());
/*     */   }
/*     */   public STBIIOCallbacks read(@NativeType("int (*) (void *, char *, int)") STBIReadCallbackI value) {
/*  90 */     nread(address(), value); return this;
/*     */   } public STBIIOCallbacks skip(@NativeType("void (*) (void *, int)") STBISkipCallbackI value) {
/*  92 */     nskip(address(), value); return this;
/*     */   } public STBIIOCallbacks eof(@NativeType("int (*) (void *)") STBIEOFCallbackI value) {
/*  94 */     neof(address(), value); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public STBIIOCallbacks set(STBIReadCallbackI read, STBISkipCallbackI skip, STBIEOFCallbackI eof) {
/* 102 */     read(read);
/* 103 */     skip(skip);
/* 104 */     eof(eof);
/*     */     
/* 106 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public STBIIOCallbacks set(STBIIOCallbacks src) {
/* 117 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 118 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBIIOCallbacks malloc() {
/* 125 */     return new STBIIOCallbacks(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBIIOCallbacks calloc() {
/* 130 */     return new STBIIOCallbacks(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBIIOCallbacks create() {
/* 135 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 136 */     return new STBIIOCallbacks(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBIIOCallbacks create(long address) {
/* 141 */     return new STBIIOCallbacks(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBIIOCallbacks createSafe(long address) {
/* 146 */     return (address == 0L) ? null : new STBIIOCallbacks(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 155 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 164 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 173 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 174 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 184 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 189 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBIIOCallbacks malloc(MemoryStack stack) {
/* 198 */     return new STBIIOCallbacks(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBIIOCallbacks calloc(MemoryStack stack) {
/* 207 */     return new STBIIOCallbacks(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 217 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 227 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBIReadCallback nread(long struct) {
/* 233 */     return STBIReadCallback.create(MemoryUtil.memGetAddress(struct + READ));
/*     */   } public static STBISkipCallback nskip(long struct) {
/* 235 */     return STBISkipCallback.create(MemoryUtil.memGetAddress(struct + SKIP));
/*     */   } public static STBIEOFCallback neof(long struct) {
/* 237 */     return STBIEOFCallback.create(MemoryUtil.memGetAddress(struct + EOF));
/*     */   }
/*     */   public static void nread(long struct, STBIReadCallbackI value) {
/* 240 */     MemoryUtil.memPutAddress(struct + READ, value.address());
/*     */   } public static void nskip(long struct, STBISkipCallbackI value) {
/* 242 */     MemoryUtil.memPutAddress(struct + SKIP, value.address());
/*     */   } public static void neof(long struct, STBIEOFCallbackI value) {
/* 244 */     MemoryUtil.memPutAddress(struct + EOF, value.address());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long struct) {
/* 252 */     Checks.check(MemoryUtil.memGetAddress(struct + READ));
/* 253 */     Checks.check(MemoryUtil.memGetAddress(struct + SKIP));
/* 254 */     Checks.check(MemoryUtil.memGetAddress(struct + EOF));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<STBIIOCallbacks, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 262 */     private static final STBIIOCallbacks ELEMENT_FACTORY = STBIIOCallbacks.create(-1L);
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
/* 274 */       super(container, container.remaining() / STBIIOCallbacks.SIZEOF);
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
/*     */     protected STBIIOCallbacks getElementFactory() {
/* 297 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("int (*) (void *, char *, int)")
/*     */     public STBIReadCallback read() {
/* 302 */       return STBIIOCallbacks.nread(address());
/*     */     } @NativeType("void (*) (void *, int)")
/*     */     public STBISkipCallback skip() {
/* 305 */       return STBIIOCallbacks.nskip(address());
/*     */     } @NativeType("int (*) (void *)")
/*     */     public STBIEOFCallback eof() {
/* 308 */       return STBIIOCallbacks.neof(address());
/*     */     }
/*     */     public Buffer read(@NativeType("int (*) (void *, char *, int)") STBIReadCallbackI value) {
/* 311 */       STBIIOCallbacks.nread(address(), value); return this;
/*     */     } public Buffer skip(@NativeType("void (*) (void *, int)") STBISkipCallbackI value) {
/* 313 */       STBIIOCallbacks.nskip(address(), value); return this;
/*     */     } public Buffer eof(@NativeType("int (*) (void *)") STBIEOFCallbackI value) {
/* 315 */       STBIIOCallbacks.neof(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\stb\STBIIOCallbacks.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */