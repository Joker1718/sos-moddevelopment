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
/*     */ public class MSG
/*     */   extends Struct<MSG>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int HWND;
/*     */   public static final int MESSAGE;
/*     */   public static final int WPARAM;
/*     */   public static final int LPARAM;
/*     */   public static final int TIME;
/*     */   public static final int PT;
/*     */   
/*     */   static {
/*  47 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  48 */           __member(POINTER_SIZE), 
/*  49 */           __member(4), 
/*  50 */           __member(POINTER_SIZE), 
/*  51 */           __member(POINTER_SIZE), 
/*  52 */           __member(4), 
/*  53 */           __member(POINT.SIZEOF, POINT.ALIGNOF)
/*     */         });
/*     */     
/*  56 */     SIZEOF = layout.getSize();
/*  57 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  59 */     HWND = layout.offsetof(0);
/*  60 */     MESSAGE = layout.offsetof(1);
/*  61 */     WPARAM = layout.offsetof(2);
/*  62 */     LPARAM = layout.offsetof(3);
/*  63 */     TIME = layout.offsetof(4);
/*  64 */     PT = layout.offsetof(5);
/*     */   }
/*     */   
/*     */   protected MSG(long address, ByteBuffer container) {
/*  68 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected MSG create(long address, ByteBuffer container) {
/*  73 */     return new MSG(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MSG(ByteBuffer container) {
/*  83 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  87 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("HWND")
/*     */   public long hwnd() {
/*  91 */     return nhwnd(address());
/*     */   } @NativeType("UINT")
/*     */   public int message() {
/*  94 */     return nmessage(address());
/*     */   } @NativeType("WPARAM")
/*     */   public long wParam() {
/*  97 */     return nwParam(address());
/*     */   } @NativeType("LPARAM")
/*     */   public long lParam() {
/* 100 */     return nlParam(address());
/*     */   } @NativeType("DWORD")
/*     */   public int time() {
/* 103 */     return ntime(address());
/*     */   } public POINT pt() {
/* 105 */     return npt(address());
/*     */   }
/*     */   public MSG hwnd(@NativeType("HWND") long value) {
/* 108 */     nhwnd(address(), value); return this;
/*     */   } public MSG message(@NativeType("UINT") int value) {
/* 110 */     nmessage(address(), value); return this;
/*     */   } public MSG wParam(@NativeType("WPARAM") long value) {
/* 112 */     nwParam(address(), value); return this;
/*     */   } public MSG lParam(@NativeType("LPARAM") long value) {
/* 114 */     nlParam(address(), value); return this;
/*     */   } public MSG time(@NativeType("DWORD") int value) {
/* 116 */     ntime(address(), value); return this;
/*     */   } public MSG pt(POINT value) {
/* 118 */     npt(address(), value); return this;
/*     */   } public MSG pt(Consumer<POINT> consumer) {
/* 120 */     consumer.accept(pt()); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MSG set(long hwnd, int message, long wParam, long lParam, int time, POINT pt) {
/* 131 */     hwnd(hwnd);
/* 132 */     message(message);
/* 133 */     wParam(wParam);
/* 134 */     lParam(lParam);
/* 135 */     time(time);
/* 136 */     pt(pt);
/*     */     
/* 138 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MSG set(MSG src) {
/* 149 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 150 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static MSG malloc() {
/* 157 */     return new MSG(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static MSG calloc() {
/* 162 */     return new MSG(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static MSG create() {
/* 167 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 168 */     return new MSG(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static MSG create(long address) {
/* 173 */     return new MSG(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static MSG createSafe(long address) {
/* 178 */     return (address == 0L) ? null : new MSG(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 187 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 196 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 205 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 206 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 216 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 221 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static MSG malloc(MemoryStack stack) {
/* 230 */     return new MSG(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static MSG calloc(MemoryStack stack) {
/* 239 */     return new MSG(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 249 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 259 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nhwnd(long struct) {
/* 265 */     return MemoryUtil.memGetAddress(struct + HWND);
/*     */   } public static int nmessage(long struct) {
/* 267 */     return MemoryUtil.memGetInt(struct + MESSAGE);
/*     */   } public static long nwParam(long struct) {
/* 269 */     return MemoryUtil.memGetAddress(struct + WPARAM);
/*     */   } public static long nlParam(long struct) {
/* 271 */     return MemoryUtil.memGetAddress(struct + LPARAM);
/*     */   } public static int ntime(long struct) {
/* 273 */     return MemoryUtil.memGetInt(struct + TIME);
/*     */   } public static POINT npt(long struct) {
/* 275 */     return POINT.create(struct + PT);
/*     */   }
/*     */   public static void nhwnd(long struct, long value) {
/* 278 */     MemoryUtil.memPutAddress(struct + HWND, value);
/*     */   } public static void nmessage(long struct, int value) {
/* 280 */     MemoryUtil.memPutInt(struct + MESSAGE, value);
/*     */   } public static void nwParam(long struct, long value) {
/* 282 */     MemoryUtil.memPutAddress(struct + WPARAM, value);
/*     */   } public static void nlParam(long struct, long value) {
/* 284 */     MemoryUtil.memPutAddress(struct + LPARAM, value);
/*     */   } public static void ntime(long struct, int value) {
/* 286 */     MemoryUtil.memPutInt(struct + TIME, value);
/*     */   } public static void npt(long struct, POINT value) {
/* 288 */     MemoryUtil.memCopy(value.address(), struct + PT, POINT.SIZEOF);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<MSG, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 295 */     private static final MSG ELEMENT_FACTORY = MSG.create(-1L);
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
/* 307 */       super(container, container.remaining() / MSG.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 311 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 315 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 320 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 325 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected MSG getElementFactory() {
/* 330 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("HWND")
/*     */     public long hwnd() {
/* 335 */       return MSG.nhwnd(address());
/*     */     } @NativeType("UINT")
/*     */     public int message() {
/* 338 */       return MSG.nmessage(address());
/*     */     } @NativeType("WPARAM")
/*     */     public long wParam() {
/* 341 */       return MSG.nwParam(address());
/*     */     } @NativeType("LPARAM")
/*     */     public long lParam() {
/* 344 */       return MSG.nlParam(address());
/*     */     } @NativeType("DWORD")
/*     */     public int time() {
/* 347 */       return MSG.ntime(address());
/*     */     } public POINT pt() {
/* 349 */       return MSG.npt(address());
/*     */     }
/*     */     public Buffer hwnd(@NativeType("HWND") long value) {
/* 352 */       MSG.nhwnd(address(), value); return this;
/*     */     } public Buffer message(@NativeType("UINT") int value) {
/* 354 */       MSG.nmessage(address(), value); return this;
/*     */     } public Buffer wParam(@NativeType("WPARAM") long value) {
/* 356 */       MSG.nwParam(address(), value); return this;
/*     */     } public Buffer lParam(@NativeType("LPARAM") long value) {
/* 358 */       MSG.nlParam(address(), value); return this;
/*     */     } public Buffer time(@NativeType("DWORD") int value) {
/* 360 */       MSG.ntime(address(), value); return this;
/*     */     } public Buffer pt(POINT value) {
/* 362 */       MSG.npt(address(), value); return this;
/*     */     } public Buffer pt(Consumer<POINT> consumer) {
/* 364 */       consumer.accept(pt()); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\windows\MSG.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */