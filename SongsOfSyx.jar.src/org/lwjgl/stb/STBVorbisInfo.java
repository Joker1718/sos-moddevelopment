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
/*     */ 
/*     */ 
/*     */ 
/*     */ @NativeType("struct stb_vorbis_info")
/*     */ public class STBVorbisInfo
/*     */   extends Struct<STBVorbisInfo>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int SAMPLE_RATE;
/*     */   public static final int CHANNELS;
/*     */   public static final int SETUP_MEMORY_REQUIRED;
/*     */   public static final int SETUP_TEMP_MEMORY_REQUIRED;
/*     */   public static final int TEMP_MEMORY_REQUIRED;
/*     */   public static final int MAX_FRAME_SIZE;
/*     */   
/*     */   static {
/*  48 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  49 */           __member(4), 
/*  50 */           __member(4), 
/*  51 */           __member(4), 
/*  52 */           __member(4), 
/*  53 */           __member(4), 
/*  54 */           __member(4)
/*     */         });
/*     */     
/*  57 */     SIZEOF = layout.getSize();
/*  58 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  60 */     SAMPLE_RATE = layout.offsetof(0);
/*  61 */     CHANNELS = layout.offsetof(1);
/*  62 */     SETUP_MEMORY_REQUIRED = layout.offsetof(2);
/*  63 */     SETUP_TEMP_MEMORY_REQUIRED = layout.offsetof(3);
/*  64 */     TEMP_MEMORY_REQUIRED = layout.offsetof(4);
/*  65 */     MAX_FRAME_SIZE = layout.offsetof(5);
/*     */   }
/*     */   
/*     */   protected STBVorbisInfo(long address, ByteBuffer container) {
/*  69 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected STBVorbisInfo create(long address, ByteBuffer container) {
/*  74 */     return new STBVorbisInfo(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public STBVorbisInfo(ByteBuffer container) {
/*  84 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  88 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("unsigned int")
/*     */   public int sample_rate() {
/*  92 */     return nsample_rate(address());
/*     */   } public int channels() {
/*  94 */     return nchannels(address());
/*     */   } @NativeType("unsigned int")
/*     */   public int setup_memory_required() {
/*  97 */     return nsetup_memory_required(address());
/*     */   } @NativeType("unsigned int")
/*     */   public int setup_temp_memory_required() {
/* 100 */     return nsetup_temp_memory_required(address());
/*     */   } @NativeType("unsigned int")
/*     */   public int temp_memory_required() {
/* 103 */     return ntemp_memory_required(address());
/*     */   } public int max_frame_size() {
/* 105 */     return nmax_frame_size(address());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBVorbisInfo malloc() {
/* 111 */     return new STBVorbisInfo(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBVorbisInfo calloc() {
/* 116 */     return new STBVorbisInfo(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBVorbisInfo create() {
/* 121 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 122 */     return new STBVorbisInfo(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBVorbisInfo create(long address) {
/* 127 */     return new STBVorbisInfo(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBVorbisInfo createSafe(long address) {
/* 132 */     return (address == 0L) ? null : new STBVorbisInfo(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 141 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 150 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 159 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 160 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 170 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 175 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBVorbisInfo malloc(MemoryStack stack) {
/* 184 */     return new STBVorbisInfo(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBVorbisInfo calloc(MemoryStack stack) {
/* 193 */     return new STBVorbisInfo(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 203 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 213 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nsample_rate(long struct) {
/* 219 */     return MemoryUtil.memGetInt(struct + SAMPLE_RATE);
/*     */   } public static int nchannels(long struct) {
/* 221 */     return MemoryUtil.memGetInt(struct + CHANNELS);
/*     */   } public static int nsetup_memory_required(long struct) {
/* 223 */     return MemoryUtil.memGetInt(struct + SETUP_MEMORY_REQUIRED);
/*     */   } public static int nsetup_temp_memory_required(long struct) {
/* 225 */     return MemoryUtil.memGetInt(struct + SETUP_TEMP_MEMORY_REQUIRED);
/*     */   } public static int ntemp_memory_required(long struct) {
/* 227 */     return MemoryUtil.memGetInt(struct + TEMP_MEMORY_REQUIRED);
/*     */   } public static int nmax_frame_size(long struct) {
/* 229 */     return MemoryUtil.memGetInt(struct + MAX_FRAME_SIZE);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<STBVorbisInfo, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 236 */     private static final STBVorbisInfo ELEMENT_FACTORY = STBVorbisInfo.create(-1L);
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
/* 248 */       super(container, container.remaining() / STBVorbisInfo.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 252 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 256 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 261 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 266 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected STBVorbisInfo getElementFactory() {
/* 271 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("unsigned int")
/*     */     public int sample_rate() {
/* 276 */       return STBVorbisInfo.nsample_rate(address());
/*     */     } public int channels() {
/* 278 */       return STBVorbisInfo.nchannels(address());
/*     */     } @NativeType("unsigned int")
/*     */     public int setup_memory_required() {
/* 281 */       return STBVorbisInfo.nsetup_memory_required(address());
/*     */     } @NativeType("unsigned int")
/*     */     public int setup_temp_memory_required() {
/* 284 */       return STBVorbisInfo.nsetup_temp_memory_required(address());
/*     */     } @NativeType("unsigned int")
/*     */     public int temp_memory_required() {
/* 287 */       return STBVorbisInfo.ntemp_memory_required(address());
/*     */     } public int max_frame_size() {
/* 289 */       return STBVorbisInfo.nmax_frame_size(address());
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\stb\STBVorbisInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */