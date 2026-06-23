/*     */ package org.lwjgl.system.windows;
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
/*     */ public class HARDWAREINPUT
/*     */   extends Struct<HARDWAREINPUT>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int UMSG;
/*     */   public static final int WPARAML;
/*     */   public static final int WPARAMH;
/*     */   
/*     */   static {
/*  41 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  42 */           __member(4), 
/*  43 */           __member(2), 
/*  44 */           __member(2)
/*     */         });
/*     */     
/*  47 */     SIZEOF = layout.getSize();
/*  48 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  50 */     UMSG = layout.offsetof(0);
/*  51 */     WPARAML = layout.offsetof(1);
/*  52 */     WPARAMH = layout.offsetof(2);
/*     */   }
/*     */   
/*     */   protected HARDWAREINPUT(long address, ByteBuffer container) {
/*  56 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected HARDWAREINPUT create(long address, ByteBuffer container) {
/*  61 */     return new HARDWAREINPUT(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HARDWAREINPUT(ByteBuffer container) {
/*  71 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  75 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("DWORD")
/*     */   public int uMsg() {
/*  79 */     return nuMsg(address());
/*     */   } @NativeType("WORD")
/*     */   public short wParamL() {
/*  82 */     return nwParamL(address());
/*     */   } @NativeType("WORD")
/*     */   public short wParamH() {
/*  85 */     return nwParamH(address());
/*     */   }
/*     */   public HARDWAREINPUT uMsg(@NativeType("DWORD") int value) {
/*  88 */     nuMsg(address(), value); return this;
/*     */   } public HARDWAREINPUT wParamL(@NativeType("WORD") short value) {
/*  90 */     nwParamL(address(), value); return this;
/*     */   } public HARDWAREINPUT wParamH(@NativeType("WORD") short value) {
/*  92 */     nwParamH(address(), value); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HARDWAREINPUT set(int uMsg, short wParamL, short wParamH) {
/* 100 */     uMsg(uMsg);
/* 101 */     wParamL(wParamL);
/* 102 */     wParamH(wParamH);
/*     */     
/* 104 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HARDWAREINPUT set(HARDWAREINPUT src) {
/* 115 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 116 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static HARDWAREINPUT malloc() {
/* 123 */     return new HARDWAREINPUT(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static HARDWAREINPUT calloc() {
/* 128 */     return new HARDWAREINPUT(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static HARDWAREINPUT create() {
/* 133 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 134 */     return new HARDWAREINPUT(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static HARDWAREINPUT create(long address) {
/* 139 */     return new HARDWAREINPUT(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static HARDWAREINPUT createSafe(long address) {
/* 144 */     return (address == 0L) ? null : new HARDWAREINPUT(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 153 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 162 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 171 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 172 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 182 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 187 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static HARDWAREINPUT malloc(MemoryStack stack) {
/* 196 */     return new HARDWAREINPUT(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static HARDWAREINPUT calloc(MemoryStack stack) {
/* 205 */     return new HARDWAREINPUT(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 215 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 225 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nuMsg(long struct) {
/* 231 */     return MemoryUtil.memGetInt(struct + UMSG);
/*     */   } public static short nwParamL(long struct) {
/* 233 */     return MemoryUtil.memGetShort(struct + WPARAML);
/*     */   } public static short nwParamH(long struct) {
/* 235 */     return MemoryUtil.memGetShort(struct + WPARAMH);
/*     */   }
/*     */   public static void nuMsg(long struct, int value) {
/* 238 */     MemoryUtil.memPutInt(struct + UMSG, value);
/*     */   } public static void nwParamL(long struct, short value) {
/* 240 */     MemoryUtil.memPutShort(struct + WPARAML, value);
/*     */   } public static void nwParamH(long struct, short value) {
/* 242 */     MemoryUtil.memPutShort(struct + WPARAMH, value);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<HARDWAREINPUT, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 249 */     private static final HARDWAREINPUT ELEMENT_FACTORY = HARDWAREINPUT.create(-1L);
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
/* 261 */       super(container, container.remaining() / HARDWAREINPUT.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 265 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 269 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 274 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 279 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected HARDWAREINPUT getElementFactory() {
/* 284 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("DWORD")
/*     */     public int uMsg() {
/* 289 */       return HARDWAREINPUT.nuMsg(address());
/*     */     } @NativeType("WORD")
/*     */     public short wParamL() {
/* 292 */       return HARDWAREINPUT.nwParamL(address());
/*     */     } @NativeType("WORD")
/*     */     public short wParamH() {
/* 295 */       return HARDWAREINPUT.nwParamH(address());
/*     */     }
/*     */     public Buffer uMsg(@NativeType("DWORD") int value) {
/* 298 */       HARDWAREINPUT.nuMsg(address(), value); return this;
/*     */     } public Buffer wParamL(@NativeType("WORD") short value) {
/* 300 */       HARDWAREINPUT.nwParamL(address(), value); return this;
/*     */     } public Buffer wParamH(@NativeType("WORD") short value) {
/* 302 */       HARDWAREINPUT.nwParamH(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\windows\HARDWAREINPUT.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */