/*     */ package org.lwjgl.system.windows;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.util.function.Consumer;
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
/*     */ public class WINDOWPLACEMENT
/*     */   extends Struct<WINDOWPLACEMENT>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int LENGTH;
/*     */   public static final int FLAGS;
/*     */   public static final int SHOWCMD;
/*     */   public static final int PTMINPOSITION;
/*     */   public static final int PTMAXPOSITION;
/*     */   public static final int RCNORMALPOSITION;
/*     */   
/*     */   static {
/*  47 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  48 */           __member(4), 
/*  49 */           __member(4), 
/*  50 */           __member(4), 
/*  51 */           __member(POINT.SIZEOF, POINT.ALIGNOF), 
/*  52 */           __member(POINT.SIZEOF, POINT.ALIGNOF), 
/*  53 */           __member(RECT.SIZEOF, RECT.ALIGNOF)
/*     */         });
/*     */     
/*  56 */     SIZEOF = layout.getSize();
/*  57 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  59 */     LENGTH = layout.offsetof(0);
/*  60 */     FLAGS = layout.offsetof(1);
/*  61 */     SHOWCMD = layout.offsetof(2);
/*  62 */     PTMINPOSITION = layout.offsetof(3);
/*  63 */     PTMAXPOSITION = layout.offsetof(4);
/*  64 */     RCNORMALPOSITION = layout.offsetof(5);
/*     */   }
/*     */   
/*     */   protected WINDOWPLACEMENT(long address, ByteBuffer container) {
/*  68 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected WINDOWPLACEMENT create(long address, ByteBuffer container) {
/*  73 */     return new WINDOWPLACEMENT(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public WINDOWPLACEMENT(ByteBuffer container) {
/*  83 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  87 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("UINT")
/*     */   public int length() {
/*  91 */     return nlength(address());
/*     */   } @NativeType("UINT")
/*     */   public int flags() {
/*  94 */     return nflags(address());
/*     */   } @NativeType("UINT")
/*     */   public int showCmd() {
/*  97 */     return nshowCmd(address());
/*     */   } public POINT ptMinPosition() {
/*  99 */     return nptMinPosition(address());
/*     */   } public POINT ptMaxPosition() {
/* 101 */     return nptMaxPosition(address());
/*     */   } public RECT rcNormalPosition() {
/* 103 */     return nrcNormalPosition(address());
/*     */   }
/*     */   public WINDOWPLACEMENT length(@NativeType("UINT") int value) {
/* 106 */     nlength(address(), value); return this;
/*     */   } public WINDOWPLACEMENT flags(@NativeType("UINT") int value) {
/* 108 */     nflags(address(), value); return this;
/*     */   } public WINDOWPLACEMENT showCmd(@NativeType("UINT") int value) {
/* 110 */     nshowCmd(address(), value); return this;
/*     */   } public WINDOWPLACEMENT ptMinPosition(POINT value) {
/* 112 */     nptMinPosition(address(), value); return this;
/*     */   } public WINDOWPLACEMENT ptMinPosition(Consumer<POINT> consumer) {
/* 114 */     consumer.accept(ptMinPosition()); return this;
/*     */   } public WINDOWPLACEMENT ptMaxPosition(POINT value) {
/* 116 */     nptMaxPosition(address(), value); return this;
/*     */   } public WINDOWPLACEMENT ptMaxPosition(Consumer<POINT> consumer) {
/* 118 */     consumer.accept(ptMaxPosition()); return this;
/*     */   } public WINDOWPLACEMENT rcNormalPosition(RECT value) {
/* 120 */     nrcNormalPosition(address(), value); return this;
/*     */   } public WINDOWPLACEMENT rcNormalPosition(Consumer<RECT> consumer) {
/* 122 */     consumer.accept(rcNormalPosition()); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public WINDOWPLACEMENT set(int length, int flags, int showCmd, POINT ptMinPosition, POINT ptMaxPosition, RECT rcNormalPosition) {
/* 133 */     length(length);
/* 134 */     flags(flags);
/* 135 */     showCmd(showCmd);
/* 136 */     ptMinPosition(ptMinPosition);
/* 137 */     ptMaxPosition(ptMaxPosition);
/* 138 */     rcNormalPosition(rcNormalPosition);
/*     */     
/* 140 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public WINDOWPLACEMENT set(WINDOWPLACEMENT src) {
/* 151 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 152 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static WINDOWPLACEMENT malloc() {
/* 159 */     return new WINDOWPLACEMENT(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static WINDOWPLACEMENT calloc() {
/* 164 */     return new WINDOWPLACEMENT(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static WINDOWPLACEMENT create() {
/* 169 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 170 */     return new WINDOWPLACEMENT(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static WINDOWPLACEMENT create(long address) {
/* 175 */     return new WINDOWPLACEMENT(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static WINDOWPLACEMENT createSafe(long address) {
/* 180 */     return (address == 0L) ? null : new WINDOWPLACEMENT(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 189 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 198 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 207 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 208 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 218 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 223 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static WINDOWPLACEMENT malloc(MemoryStack stack) {
/* 232 */     return new WINDOWPLACEMENT(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static WINDOWPLACEMENT calloc(MemoryStack stack) {
/* 241 */     return new WINDOWPLACEMENT(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 251 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 261 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nlength(long struct) {
/* 267 */     return MemoryUtil.memGetInt(struct + LENGTH);
/*     */   } public static int nflags(long struct) {
/* 269 */     return MemoryUtil.memGetInt(struct + FLAGS);
/*     */   } public static int nshowCmd(long struct) {
/* 271 */     return MemoryUtil.memGetInt(struct + SHOWCMD);
/*     */   } public static POINT nptMinPosition(long struct) {
/* 273 */     return POINT.create(struct + PTMINPOSITION);
/*     */   } public static POINT nptMaxPosition(long struct) {
/* 275 */     return POINT.create(struct + PTMAXPOSITION);
/*     */   } public static RECT nrcNormalPosition(long struct) {
/* 277 */     return RECT.create(struct + RCNORMALPOSITION);
/*     */   }
/*     */   public static void nlength(long struct, int value) {
/* 280 */     MemoryUtil.memPutInt(struct + LENGTH, value);
/*     */   } public static void nflags(long struct, int value) {
/* 282 */     MemoryUtil.memPutInt(struct + FLAGS, value);
/*     */   } public static void nshowCmd(long struct, int value) {
/* 284 */     MemoryUtil.memPutInt(struct + SHOWCMD, value);
/*     */   } public static void nptMinPosition(long struct, POINT value) {
/* 286 */     MemoryUtil.memCopy(value.address(), struct + PTMINPOSITION, POINT.SIZEOF);
/*     */   } public static void nptMaxPosition(long struct, POINT value) {
/* 288 */     MemoryUtil.memCopy(value.address(), struct + PTMAXPOSITION, POINT.SIZEOF);
/*     */   } public static void nrcNormalPosition(long struct, RECT value) {
/* 290 */     MemoryUtil.memCopy(value.address(), struct + RCNORMALPOSITION, RECT.SIZEOF);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<WINDOWPLACEMENT, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 297 */     private static final WINDOWPLACEMENT ELEMENT_FACTORY = WINDOWPLACEMENT.create(-1L);
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
/* 309 */       super(container, container.remaining() / WINDOWPLACEMENT.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 313 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 317 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 322 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 327 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected WINDOWPLACEMENT getElementFactory() {
/* 332 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("UINT")
/*     */     public int length() {
/* 337 */       return WINDOWPLACEMENT.nlength(address());
/*     */     } @NativeType("UINT")
/*     */     public int flags() {
/* 340 */       return WINDOWPLACEMENT.nflags(address());
/*     */     } @NativeType("UINT")
/*     */     public int showCmd() {
/* 343 */       return WINDOWPLACEMENT.nshowCmd(address());
/*     */     } public POINT ptMinPosition() {
/* 345 */       return WINDOWPLACEMENT.nptMinPosition(address());
/*     */     } public POINT ptMaxPosition() {
/* 347 */       return WINDOWPLACEMENT.nptMaxPosition(address());
/*     */     } public RECT rcNormalPosition() {
/* 349 */       return WINDOWPLACEMENT.nrcNormalPosition(address());
/*     */     }
/*     */     public Buffer length(@NativeType("UINT") int value) {
/* 352 */       WINDOWPLACEMENT.nlength(address(), value); return this;
/*     */     } public Buffer flags(@NativeType("UINT") int value) {
/* 354 */       WINDOWPLACEMENT.nflags(address(), value); return this;
/*     */     } public Buffer showCmd(@NativeType("UINT") int value) {
/* 356 */       WINDOWPLACEMENT.nshowCmd(address(), value); return this;
/*     */     } public Buffer ptMinPosition(POINT value) {
/* 358 */       WINDOWPLACEMENT.nptMinPosition(address(), value); return this;
/*     */     } public Buffer ptMinPosition(Consumer<POINT> consumer) {
/* 360 */       consumer.accept(ptMinPosition()); return this;
/*     */     } public Buffer ptMaxPosition(POINT value) {
/* 362 */       WINDOWPLACEMENT.nptMaxPosition(address(), value); return this;
/*     */     } public Buffer ptMaxPosition(Consumer<POINT> consumer) {
/* 364 */       consumer.accept(ptMaxPosition()); return this;
/*     */     } public Buffer rcNormalPosition(RECT value) {
/* 366 */       WINDOWPLACEMENT.nrcNormalPosition(address(), value); return this;
/*     */     } public Buffer rcNormalPosition(Consumer<RECT> consumer) {
/* 368 */       consumer.accept(rcNormalPosition()); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\windows\WINDOWPLACEMENT.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */