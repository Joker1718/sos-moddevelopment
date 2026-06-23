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
/*     */ 
/*     */ @NativeType("struct stbtt_bakedchar")
/*     */ public class STBTTBakedChar
/*     */   extends Struct<STBTTBakedChar>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int X0;
/*     */   public static final int Y0;
/*     */   public static final int X1;
/*     */   public static final int Y1;
/*     */   public static final int XOFF;
/*     */   public static final int YOFF;
/*     */   public static final int XADVANCE;
/*     */   
/*     */   static {
/*  50 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  51 */           __member(2), 
/*  52 */           __member(2), 
/*  53 */           __member(2), 
/*  54 */           __member(2), 
/*  55 */           __member(4), 
/*  56 */           __member(4), 
/*  57 */           __member(4)
/*     */         });
/*     */     
/*  60 */     SIZEOF = layout.getSize();
/*  61 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  63 */     X0 = layout.offsetof(0);
/*  64 */     Y0 = layout.offsetof(1);
/*  65 */     X1 = layout.offsetof(2);
/*  66 */     Y1 = layout.offsetof(3);
/*  67 */     XOFF = layout.offsetof(4);
/*  68 */     YOFF = layout.offsetof(5);
/*  69 */     XADVANCE = layout.offsetof(6);
/*     */   }
/*     */   
/*     */   protected STBTTBakedChar(long address, ByteBuffer container) {
/*  73 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected STBTTBakedChar create(long address, ByteBuffer container) {
/*  78 */     return new STBTTBakedChar(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public STBTTBakedChar(ByteBuffer container) {
/*  88 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  92 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("unsigned short")
/*     */   public short x0() {
/*  96 */     return nx0(address());
/*     */   } @NativeType("unsigned short")
/*     */   public short y0() {
/*  99 */     return ny0(address());
/*     */   } @NativeType("unsigned short")
/*     */   public short x1() {
/* 102 */     return nx1(address());
/*     */   } @NativeType("unsigned short")
/*     */   public short y1() {
/* 105 */     return ny1(address());
/*     */   } public float xoff() {
/* 107 */     return nxoff(address());
/*     */   } public float yoff() {
/* 109 */     return nyoff(address());
/*     */   } public float xadvance() {
/* 111 */     return nxadvance(address());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBTTBakedChar malloc() {
/* 117 */     return new STBTTBakedChar(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBTTBakedChar calloc() {
/* 122 */     return new STBTTBakedChar(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBTTBakedChar create() {
/* 127 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 128 */     return new STBTTBakedChar(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBTTBakedChar create(long address) {
/* 133 */     return new STBTTBakedChar(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBTTBakedChar createSafe(long address) {
/* 138 */     return (address == 0L) ? null : new STBTTBakedChar(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 147 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 156 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 165 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 166 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 176 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 181 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBTTBakedChar malloc(MemoryStack stack) {
/* 190 */     return new STBTTBakedChar(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBTTBakedChar calloc(MemoryStack stack) {
/* 199 */     return new STBTTBakedChar(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 209 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 219 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static short nx0(long struct) {
/* 225 */     return MemoryUtil.memGetShort(struct + X0);
/*     */   } public static short ny0(long struct) {
/* 227 */     return MemoryUtil.memGetShort(struct + Y0);
/*     */   } public static short nx1(long struct) {
/* 229 */     return MemoryUtil.memGetShort(struct + X1);
/*     */   } public static short ny1(long struct) {
/* 231 */     return MemoryUtil.memGetShort(struct + Y1);
/*     */   } public static float nxoff(long struct) {
/* 233 */     return MemoryUtil.memGetFloat(struct + XOFF);
/*     */   } public static float nyoff(long struct) {
/* 235 */     return MemoryUtil.memGetFloat(struct + YOFF);
/*     */   } public static float nxadvance(long struct) {
/* 237 */     return MemoryUtil.memGetFloat(struct + XADVANCE);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<STBTTBakedChar, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 244 */     private static final STBTTBakedChar ELEMENT_FACTORY = STBTTBakedChar.create(-1L);
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
/* 256 */       super(container, container.remaining() / STBTTBakedChar.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 260 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 264 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 269 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 274 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected STBTTBakedChar getElementFactory() {
/* 279 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("unsigned short")
/*     */     public short x0() {
/* 284 */       return STBTTBakedChar.nx0(address());
/*     */     } @NativeType("unsigned short")
/*     */     public short y0() {
/* 287 */       return STBTTBakedChar.ny0(address());
/*     */     } @NativeType("unsigned short")
/*     */     public short x1() {
/* 290 */       return STBTTBakedChar.nx1(address());
/*     */     } @NativeType("unsigned short")
/*     */     public short y1() {
/* 293 */       return STBTTBakedChar.ny1(address());
/*     */     } public float xoff() {
/* 295 */       return STBTTBakedChar.nxoff(address());
/*     */     } public float yoff() {
/* 297 */       return STBTTBakedChar.nyoff(address());
/*     */     } public float xadvance() {
/* 299 */       return STBTTBakedChar.nxadvance(address());
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\stb\STBTTBakedChar.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */