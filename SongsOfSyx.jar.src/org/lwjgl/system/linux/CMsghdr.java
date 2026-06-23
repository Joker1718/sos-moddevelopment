/*     */ package org.lwjgl.system.linux;
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
/*     */ 
/*     */ @NativeType("struct cmsghdr")
/*     */ public class CMsghdr
/*     */   extends Struct<CMsghdr>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int CMSG_LEN;
/*     */   public static final int CMSG_LEVEL;
/*     */   public static final int CMSG_TYPE;
/*     */   public static final int CMSG_DATA;
/*     */   
/*     */   static {
/*  45 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  46 */           __member(4), 
/*  47 */           __member(4), 
/*  48 */           __member(4), 
/*  49 */           __array(1, 0)
/*     */         });
/*     */     
/*  52 */     SIZEOF = layout.getSize();
/*  53 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  55 */     CMSG_LEN = layout.offsetof(0);
/*  56 */     CMSG_LEVEL = layout.offsetof(1);
/*  57 */     CMSG_TYPE = layout.offsetof(2);
/*  58 */     CMSG_DATA = layout.offsetof(3);
/*     */   }
/*     */   
/*     */   protected CMsghdr(long address, ByteBuffer container) {
/*  62 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected CMsghdr create(long address, ByteBuffer container) {
/*  67 */     return new CMsghdr(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CMsghdr(ByteBuffer container) {
/*  77 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  81 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("socklen_t")
/*     */   public int cmsg_len() {
/*  85 */     return ncmsg_len(address());
/*     */   } public int cmsg_level() {
/*  87 */     return ncmsg_level(address());
/*     */   } public int cmsg_type() {
/*  89 */     return ncmsg_type(address());
/*     */   } @NativeType("char[0]")
/*     */   public ByteBuffer cmsg_data() {
/*  92 */     return ncmsg_data(address());
/*     */   } @NativeType("char")
/*     */   public byte cmsg_data(int index) {
/*  95 */     return ncmsg_data(address(), index);
/*     */   }
/*     */   public CMsghdr cmsg_len(@NativeType("socklen_t") int value) {
/*  98 */     ncmsg_len(address(), value); return this;
/*     */   } public CMsghdr cmsg_level(int value) {
/* 100 */     ncmsg_level(address(), value); return this;
/*     */   } public CMsghdr cmsg_type(int value) {
/* 102 */     ncmsg_type(address(), value); return this;
/*     */   } public CMsghdr cmsg_data(@NativeType("char[0]") ByteBuffer value) {
/* 104 */     ncmsg_data(address(), value); return this;
/*     */   } public CMsghdr cmsg_data(int index, @NativeType("char") byte value) {
/* 106 */     ncmsg_data(address(), index, value); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CMsghdr set(int cmsg_len, int cmsg_level, int cmsg_type, ByteBuffer cmsg_data) {
/* 115 */     cmsg_len(cmsg_len);
/* 116 */     cmsg_level(cmsg_level);
/* 117 */     cmsg_type(cmsg_type);
/* 118 */     cmsg_data(cmsg_data);
/*     */     
/* 120 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CMsghdr set(CMsghdr src) {
/* 131 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 132 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static CMsghdr malloc() {
/* 139 */     return new CMsghdr(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static CMsghdr calloc() {
/* 144 */     return new CMsghdr(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static CMsghdr create() {
/* 149 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 150 */     return new CMsghdr(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static CMsghdr create(long address) {
/* 155 */     return new CMsghdr(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static CMsghdr createSafe(long address) {
/* 160 */     return (address == 0L) ? null : new CMsghdr(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 169 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 178 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 187 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 188 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 198 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 203 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static CMsghdr malloc(MemoryStack stack) {
/* 212 */     return new CMsghdr(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static CMsghdr calloc(MemoryStack stack) {
/* 221 */     return new CMsghdr(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 231 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 241 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int ncmsg_len(long struct) {
/* 247 */     return MemoryUtil.memGetInt(struct + CMSG_LEN);
/*     */   } public static int ncmsg_level(long struct) {
/* 249 */     return MemoryUtil.memGetInt(struct + CMSG_LEVEL);
/*     */   } public static int ncmsg_type(long struct) {
/* 251 */     return MemoryUtil.memGetInt(struct + CMSG_TYPE);
/*     */   } public static ByteBuffer ncmsg_data(long struct) {
/* 253 */     return MemoryUtil.memByteBuffer(struct + CMSG_DATA, 0);
/*     */   }
/*     */   public static byte ncmsg_data(long struct, int index) {
/* 256 */     return MemoryUtil.memGetByte(struct + CMSG_DATA + Checks.check(index, 0) * 1L);
/*     */   }
/*     */   
/*     */   public static void ncmsg_len(long struct, int value) {
/* 260 */     MemoryUtil.memPutInt(struct + CMSG_LEN, value);
/*     */   } public static void ncmsg_level(long struct, int value) {
/* 262 */     MemoryUtil.memPutInt(struct + CMSG_LEVEL, value);
/*     */   } public static void ncmsg_type(long struct, int value) {
/* 264 */     MemoryUtil.memPutInt(struct + CMSG_TYPE, value);
/*     */   }
/*     */   public static void ncmsg_data(long struct, ByteBuffer value) {
/* 267 */     if (Checks.CHECKS) Checks.checkGT(value, 0); 
/* 268 */     MemoryUtil.memCopy(MemoryUtil.memAddress(value), struct + CMSG_DATA, (value.remaining() * 1));
/*     */   }
/*     */   
/*     */   public static void ncmsg_data(long struct, int index, byte value) {
/* 272 */     MemoryUtil.memPutByte(struct + CMSG_DATA + Checks.check(index, 0) * 1L, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<CMsghdr, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 280 */     private static final CMsghdr ELEMENT_FACTORY = CMsghdr.create(-1L);
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
/* 292 */       super(container, container.remaining() / CMsghdr.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 296 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 300 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 305 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 310 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected CMsghdr getElementFactory() {
/* 315 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("socklen_t")
/*     */     public int cmsg_len() {
/* 320 */       return CMsghdr.ncmsg_len(address());
/*     */     } public int cmsg_level() {
/* 322 */       return CMsghdr.ncmsg_level(address());
/*     */     } public int cmsg_type() {
/* 324 */       return CMsghdr.ncmsg_type(address());
/*     */     } @NativeType("char[0]")
/*     */     public ByteBuffer cmsg_data() {
/* 327 */       return CMsghdr.ncmsg_data(address());
/*     */     } @NativeType("char")
/*     */     public byte cmsg_data(int index) {
/* 330 */       return CMsghdr.ncmsg_data(address(), index);
/*     */     }
/*     */     public Buffer cmsg_len(@NativeType("socklen_t") int value) {
/* 333 */       CMsghdr.ncmsg_len(address(), value); return this;
/*     */     } public Buffer cmsg_level(int value) {
/* 335 */       CMsghdr.ncmsg_level(address(), value); return this;
/*     */     } public Buffer cmsg_type(int value) {
/* 337 */       CMsghdr.ncmsg_type(address(), value); return this;
/*     */     } public Buffer cmsg_data(@NativeType("char[0]") ByteBuffer value) {
/* 339 */       CMsghdr.ncmsg_data(address(), value); return this;
/*     */     } public Buffer cmsg_data(int index, @NativeType("char") byte value) {
/* 341 */       CMsghdr.ncmsg_data(address(), index, value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\CMsghdr.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */