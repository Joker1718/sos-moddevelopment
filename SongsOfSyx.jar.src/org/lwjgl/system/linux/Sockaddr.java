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
/*     */ @NativeType("struct sockaddr")
/*     */ public class Sockaddr
/*     */   extends Struct<Sockaddr>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int SA_FAMILY;
/*     */   public static final int SA_DATA;
/*     */   
/*     */   static {
/*  41 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  42 */           __member(2), 
/*  43 */           __array(1, 14)
/*     */         });
/*     */     
/*  46 */     SIZEOF = layout.getSize();
/*  47 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  49 */     SA_FAMILY = layout.offsetof(0);
/*  50 */     SA_DATA = layout.offsetof(1);
/*     */   }
/*     */   
/*     */   protected Sockaddr(long address, ByteBuffer container) {
/*  54 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected Sockaddr create(long address, ByteBuffer container) {
/*  59 */     return new Sockaddr(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Sockaddr(ByteBuffer container) {
/*  69 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  73 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("sa_family_t")
/*     */   public short sa_family() {
/*  77 */     return nsa_family(address());
/*     */   } @NativeType("char[14]")
/*     */   public ByteBuffer sa_data() {
/*  80 */     return nsa_data(address());
/*     */   } @NativeType("char")
/*     */   public byte sa_data(int index) {
/*  83 */     return nsa_data(address(), index);
/*     */   }
/*     */   public Sockaddr sa_family(@NativeType("sa_family_t") short value) {
/*  86 */     nsa_family(address(), value); return this;
/*     */   } public Sockaddr sa_data(@NativeType("char[14]") ByteBuffer value) {
/*  88 */     nsa_data(address(), value); return this;
/*     */   } public Sockaddr sa_data(int index, @NativeType("char") byte value) {
/*  90 */     nsa_data(address(), index, value); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Sockaddr set(short sa_family, ByteBuffer sa_data) {
/*  97 */     sa_family(sa_family);
/*  98 */     sa_data(sa_data);
/*     */     
/* 100 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Sockaddr set(Sockaddr src) {
/* 111 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 112 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Sockaddr malloc() {
/* 119 */     return new Sockaddr(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Sockaddr calloc() {
/* 124 */     return new Sockaddr(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Sockaddr create() {
/* 129 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 130 */     return new Sockaddr(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Sockaddr create(long address) {
/* 135 */     return new Sockaddr(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Sockaddr createSafe(long address) {
/* 140 */     return (address == 0L) ? null : new Sockaddr(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 149 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 158 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 167 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 168 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 178 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 183 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Sockaddr malloc(MemoryStack stack) {
/* 192 */     return new Sockaddr(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Sockaddr calloc(MemoryStack stack) {
/* 201 */     return new Sockaddr(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 211 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 221 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static short nsa_family(long struct) {
/* 227 */     return MemoryUtil.memGetShort(struct + SA_FAMILY);
/*     */   } public static ByteBuffer nsa_data(long struct) {
/* 229 */     return MemoryUtil.memByteBuffer(struct + SA_DATA, 14);
/*     */   }
/*     */   public static byte nsa_data(long struct, int index) {
/* 232 */     return MemoryUtil.memGetByte(struct + SA_DATA + Checks.check(index, 14) * 1L);
/*     */   }
/*     */   
/*     */   public static void nsa_family(long struct, short value) {
/* 236 */     MemoryUtil.memPutShort(struct + SA_FAMILY, value);
/*     */   }
/*     */   public static void nsa_data(long struct, ByteBuffer value) {
/* 239 */     if (Checks.CHECKS) Checks.checkGT(value, 14); 
/* 240 */     MemoryUtil.memCopy(MemoryUtil.memAddress(value), struct + SA_DATA, (value.remaining() * 1));
/*     */   }
/*     */   
/*     */   public static void nsa_data(long struct, int index, byte value) {
/* 244 */     MemoryUtil.memPutByte(struct + SA_DATA + Checks.check(index, 14) * 1L, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<Sockaddr, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 252 */     private static final Sockaddr ELEMENT_FACTORY = Sockaddr.create(-1L);
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
/* 264 */       super(container, container.remaining() / Sockaddr.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 268 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 272 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 277 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 282 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Sockaddr getElementFactory() {
/* 287 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("sa_family_t")
/*     */     public short sa_family() {
/* 292 */       return Sockaddr.nsa_family(address());
/*     */     } @NativeType("char[14]")
/*     */     public ByteBuffer sa_data() {
/* 295 */       return Sockaddr.nsa_data(address());
/*     */     } @NativeType("char")
/*     */     public byte sa_data(int index) {
/* 298 */       return Sockaddr.nsa_data(address(), index);
/*     */     }
/*     */     public Buffer sa_family(@NativeType("sa_family_t") short value) {
/* 301 */       Sockaddr.nsa_family(address(), value); return this;
/*     */     } public Buffer sa_data(@NativeType("char[14]") ByteBuffer value) {
/* 303 */       Sockaddr.nsa_data(address(), value); return this;
/*     */     } public Buffer sa_data(int index, @NativeType("char") byte value) {
/* 305 */       Sockaddr.nsa_data(address(), index, value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\Sockaddr.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */