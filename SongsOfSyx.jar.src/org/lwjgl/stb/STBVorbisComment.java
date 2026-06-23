/*     */ package org.lwjgl.stb;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import org.lwjgl.BufferUtils;
/*     */ import org.lwjgl.PointerBuffer;
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
/*     */ @NativeType("struct stb_vorbis_comment")
/*     */ public class STBVorbisComment
/*     */   extends Struct<STBVorbisComment>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int VENDOR;
/*     */   public static final int COMMENT_LIST_LENGTH;
/*     */   public static final int COMMENT_LIST;
/*     */   
/*     */   static {
/*  42 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  43 */           __member(POINTER_SIZE), 
/*  44 */           __member(4), 
/*  45 */           __member(POINTER_SIZE)
/*     */         });
/*     */     
/*  48 */     SIZEOF = layout.getSize();
/*  49 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  51 */     VENDOR = layout.offsetof(0);
/*  52 */     COMMENT_LIST_LENGTH = layout.offsetof(1);
/*  53 */     COMMENT_LIST = layout.offsetof(2);
/*     */   }
/*     */   
/*     */   protected STBVorbisComment(long address, ByteBuffer container) {
/*  57 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected STBVorbisComment create(long address, ByteBuffer container) {
/*  62 */     return new STBVorbisComment(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public STBVorbisComment(ByteBuffer container) {
/*  72 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  76 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("char *")
/*     */   public ByteBuffer vendor() {
/*  80 */     return nvendor(address());
/*     */   } @NativeType("char *")
/*     */   public String vendorString() {
/*  83 */     return nvendorString(address());
/*     */   } public int comment_list_length() {
/*  85 */     return ncomment_list_length(address());
/*     */   } @NativeType("char **")
/*     */   public PointerBuffer comment_list() {
/*  88 */     return ncomment_list(address());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBVorbisComment malloc() {
/*  94 */     return new STBVorbisComment(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBVorbisComment calloc() {
/*  99 */     return new STBVorbisComment(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBVorbisComment create() {
/* 104 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 105 */     return new STBVorbisComment(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBVorbisComment create(long address) {
/* 110 */     return new STBVorbisComment(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBVorbisComment createSafe(long address) {
/* 115 */     return (address == 0L) ? null : new STBVorbisComment(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 124 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 133 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 142 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 143 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 153 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 158 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBVorbisComment malloc(MemoryStack stack) {
/* 167 */     return new STBVorbisComment(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBVorbisComment calloc(MemoryStack stack) {
/* 176 */     return new STBVorbisComment(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 186 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 196 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static ByteBuffer nvendor(long struct) {
/* 202 */     return MemoryUtil.memByteBufferNT1(MemoryUtil.memGetAddress(struct + VENDOR));
/*     */   } public static String nvendorString(long struct) {
/* 204 */     return MemoryUtil.memASCII(MemoryUtil.memGetAddress(struct + VENDOR));
/*     */   } public static int ncomment_list_length(long struct) {
/* 206 */     return MemoryUtil.memGetInt(struct + COMMENT_LIST_LENGTH);
/*     */   } public static PointerBuffer ncomment_list(long struct) {
/* 208 */     return MemoryUtil.memPointerBuffer(MemoryUtil.memGetAddress(struct + COMMENT_LIST), ncomment_list_length(struct));
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<STBVorbisComment, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 215 */     private static final STBVorbisComment ELEMENT_FACTORY = STBVorbisComment.create(-1L);
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
/* 227 */       super(container, container.remaining() / STBVorbisComment.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 231 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 235 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 240 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 245 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected STBVorbisComment getElementFactory() {
/* 250 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("char *")
/*     */     public ByteBuffer vendor() {
/* 255 */       return STBVorbisComment.nvendor(address());
/*     */     } @NativeType("char *")
/*     */     public String vendorString() {
/* 258 */       return STBVorbisComment.nvendorString(address());
/*     */     } public int comment_list_length() {
/* 260 */       return STBVorbisComment.ncomment_list_length(address());
/*     */     } @NativeType("char **")
/*     */     public PointerBuffer comment_list() {
/* 263 */       return STBVorbisComment.ncomment_list(address());
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\stb\STBVorbisComment.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */