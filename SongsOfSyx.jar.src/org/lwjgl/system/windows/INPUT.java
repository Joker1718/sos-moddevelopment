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
/*     */ public class INPUT
/*     */   extends Struct<INPUT>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int TYPE;
/*     */   public static final int DUMMYUNIONNAME;
/*     */   public static final int DUMMYUNIONNAME_MI;
/*     */   public static final int DUMMYUNIONNAME_KI;
/*     */   public static final int DUMMYUNIONNAME_HI;
/*     */   
/*     */   static {
/*  46 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  47 */           __member(4), 
/*  48 */           (Struct.Member)__union(new Struct.Member[] {
/*  49 */               __member(MOUSEINPUT.SIZEOF, MOUSEINPUT.ALIGNOF), 
/*  50 */               __member(KEYBDINPUT.SIZEOF, KEYBDINPUT.ALIGNOF), 
/*  51 */               __member(HARDWAREINPUT.SIZEOF, HARDWAREINPUT.ALIGNOF)
/*     */             })
/*     */         });
/*     */     
/*  55 */     SIZEOF = layout.getSize();
/*  56 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  58 */     TYPE = layout.offsetof(0);
/*  59 */     DUMMYUNIONNAME = layout.offsetof(1);
/*  60 */     DUMMYUNIONNAME_MI = layout.offsetof(2);
/*  61 */     DUMMYUNIONNAME_KI = layout.offsetof(3);
/*  62 */     DUMMYUNIONNAME_HI = layout.offsetof(4);
/*     */   }
/*     */   
/*     */   protected INPUT(long address, ByteBuffer container) {
/*  66 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected INPUT create(long address, ByteBuffer container) {
/*  71 */     return new INPUT(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public INPUT(ByteBuffer container) {
/*  81 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  85 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("DWORD")
/*     */   public int type() {
/*  89 */     return ntype(address());
/*     */   } public MOUSEINPUT DUMMYUNIONNAME_mi() {
/*  91 */     return nDUMMYUNIONNAME_mi(address());
/*     */   } public KEYBDINPUT DUMMYUNIONNAME_ki() {
/*  93 */     return nDUMMYUNIONNAME_ki(address());
/*     */   } public HARDWAREINPUT DUMMYUNIONNAME_hi() {
/*  95 */     return nDUMMYUNIONNAME_hi(address());
/*     */   }
/*     */   public INPUT type(@NativeType("DWORD") int value) {
/*  98 */     ntype(address(), value); return this;
/*     */   } public INPUT DUMMYUNIONNAME_mi(MOUSEINPUT value) {
/* 100 */     nDUMMYUNIONNAME_mi(address(), value); return this;
/*     */   } public INPUT DUMMYUNIONNAME_mi(Consumer<MOUSEINPUT> consumer) {
/* 102 */     consumer.accept(DUMMYUNIONNAME_mi()); return this;
/*     */   } public INPUT DUMMYUNIONNAME_ki(KEYBDINPUT value) {
/* 104 */     nDUMMYUNIONNAME_ki(address(), value); return this;
/*     */   } public INPUT DUMMYUNIONNAME_ki(Consumer<KEYBDINPUT> consumer) {
/* 106 */     consumer.accept(DUMMYUNIONNAME_ki()); return this;
/*     */   } public INPUT DUMMYUNIONNAME_hi(HARDWAREINPUT value) {
/* 108 */     nDUMMYUNIONNAME_hi(address(), value); return this;
/*     */   } public INPUT DUMMYUNIONNAME_hi(Consumer<HARDWAREINPUT> consumer) {
/* 110 */     consumer.accept(DUMMYUNIONNAME_hi()); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public INPUT set(INPUT src) {
/* 120 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 121 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static INPUT malloc() {
/* 128 */     return new INPUT(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static INPUT calloc() {
/* 133 */     return new INPUT(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static INPUT create() {
/* 138 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 139 */     return new INPUT(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static INPUT create(long address) {
/* 144 */     return new INPUT(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static INPUT createSafe(long address) {
/* 149 */     return (address == 0L) ? null : new INPUT(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 158 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 167 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 176 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 177 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 187 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 192 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static INPUT malloc(MemoryStack stack) {
/* 201 */     return new INPUT(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static INPUT calloc(MemoryStack stack) {
/* 210 */     return new INPUT(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 220 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 230 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int ntype(long struct) {
/* 236 */     return MemoryUtil.memGetInt(struct + TYPE);
/*     */   } public static MOUSEINPUT nDUMMYUNIONNAME_mi(long struct) {
/* 238 */     return MOUSEINPUT.create(struct + DUMMYUNIONNAME_MI);
/*     */   } public static KEYBDINPUT nDUMMYUNIONNAME_ki(long struct) {
/* 240 */     return KEYBDINPUT.create(struct + DUMMYUNIONNAME_KI);
/*     */   } public static HARDWAREINPUT nDUMMYUNIONNAME_hi(long struct) {
/* 242 */     return HARDWAREINPUT.create(struct + DUMMYUNIONNAME_HI);
/*     */   }
/*     */   public static void ntype(long struct, int value) {
/* 245 */     MemoryUtil.memPutInt(struct + TYPE, value);
/*     */   } public static void nDUMMYUNIONNAME_mi(long struct, MOUSEINPUT value) {
/* 247 */     MemoryUtil.memCopy(value.address(), struct + DUMMYUNIONNAME_MI, MOUSEINPUT.SIZEOF);
/*     */   } public static void nDUMMYUNIONNAME_ki(long struct, KEYBDINPUT value) {
/* 249 */     MemoryUtil.memCopy(value.address(), struct + DUMMYUNIONNAME_KI, KEYBDINPUT.SIZEOF);
/*     */   } public static void nDUMMYUNIONNAME_hi(long struct, HARDWAREINPUT value) {
/* 251 */     MemoryUtil.memCopy(value.address(), struct + DUMMYUNIONNAME_HI, HARDWAREINPUT.SIZEOF);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<INPUT, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 258 */     private static final INPUT ELEMENT_FACTORY = INPUT.create(-1L);
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
/* 270 */       super(container, container.remaining() / INPUT.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 274 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 278 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 283 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 288 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected INPUT getElementFactory() {
/* 293 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("DWORD")
/*     */     public int type() {
/* 298 */       return INPUT.ntype(address());
/*     */     } public MOUSEINPUT DUMMYUNIONNAME_mi() {
/* 300 */       return INPUT.nDUMMYUNIONNAME_mi(address());
/*     */     } public KEYBDINPUT DUMMYUNIONNAME_ki() {
/* 302 */       return INPUT.nDUMMYUNIONNAME_ki(address());
/*     */     } public HARDWAREINPUT DUMMYUNIONNAME_hi() {
/* 304 */       return INPUT.nDUMMYUNIONNAME_hi(address());
/*     */     }
/*     */     public Buffer type(@NativeType("DWORD") int value) {
/* 307 */       INPUT.ntype(address(), value); return this;
/*     */     } public Buffer DUMMYUNIONNAME_mi(MOUSEINPUT value) {
/* 309 */       INPUT.nDUMMYUNIONNAME_mi(address(), value); return this;
/*     */     } public Buffer DUMMYUNIONNAME_mi(Consumer<MOUSEINPUT> consumer) {
/* 311 */       consumer.accept(DUMMYUNIONNAME_mi()); return this;
/*     */     } public Buffer DUMMYUNIONNAME_ki(KEYBDINPUT value) {
/* 313 */       INPUT.nDUMMYUNIONNAME_ki(address(), value); return this;
/*     */     } public Buffer DUMMYUNIONNAME_ki(Consumer<KEYBDINPUT> consumer) {
/* 315 */       consumer.accept(DUMMYUNIONNAME_ki()); return this;
/*     */     } public Buffer DUMMYUNIONNAME_hi(HARDWAREINPUT value) {
/* 317 */       INPUT.nDUMMYUNIONNAME_hi(address(), value); return this;
/*     */     } public Buffer DUMMYUNIONNAME_hi(Consumer<HARDWAREINPUT> consumer) {
/* 319 */       consumer.accept(DUMMYUNIONNAME_hi()); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\windows\INPUT.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */