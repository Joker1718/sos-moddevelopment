/*     */ package org.lwjgl.opengl;
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
/*     */ import org.lwjgl.system.windows.RECT;
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
/*     */ public class GPU_DEVICE
/*     */   extends Struct<GPU_DEVICE>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int CB;
/*     */   public static final int DEVICENAME;
/*     */   public static final int DEVICESTRING;
/*     */   public static final int FLAGS;
/*     */   public static final int RCVIRTUALSCREEN;
/*     */   
/*     */   static {
/*  47 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  48 */           __member(4), 
/*  49 */           __array(1, 32), 
/*  50 */           __array(1, 128), 
/*  51 */           __member(4), 
/*  52 */           __member(RECT.SIZEOF, RECT.ALIGNOF)
/*     */         });
/*     */     
/*  55 */     SIZEOF = layout.getSize();
/*  56 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  58 */     CB = layout.offsetof(0);
/*  59 */     DEVICENAME = layout.offsetof(1);
/*  60 */     DEVICESTRING = layout.offsetof(2);
/*  61 */     FLAGS = layout.offsetof(3);
/*  62 */     RCVIRTUALSCREEN = layout.offsetof(4);
/*     */   }
/*     */   
/*     */   protected GPU_DEVICE(long address, ByteBuffer container) {
/*  66 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected GPU_DEVICE create(long address, ByteBuffer container) {
/*  71 */     return new GPU_DEVICE(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GPU_DEVICE(ByteBuffer container) {
/*  81 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  85 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("DWORD")
/*     */   public int cb() {
/*  89 */     return ncb(address());
/*     */   } @NativeType("CHAR[32]")
/*     */   public ByteBuffer DeviceName() {
/*  92 */     return nDeviceName(address());
/*     */   } @NativeType("CHAR[32]")
/*     */   public String DeviceNameString() {
/*  95 */     return nDeviceNameString(address());
/*     */   } @NativeType("CHAR[128]")
/*     */   public ByteBuffer DeviceString() {
/*  98 */     return nDeviceString(address());
/*     */   } @NativeType("CHAR[128]")
/*     */   public String DeviceStringString() {
/* 101 */     return nDeviceStringString(address());
/*     */   } @NativeType("DWORD")
/*     */   public int Flags() {
/* 104 */     return nFlags(address());
/*     */   } public RECT rcVirtualScreen() {
/* 106 */     return nrcVirtualScreen(address());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static GPU_DEVICE malloc() {
/* 112 */     return new GPU_DEVICE(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static GPU_DEVICE calloc() {
/* 117 */     return new GPU_DEVICE(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static GPU_DEVICE create() {
/* 122 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 123 */     return new GPU_DEVICE(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static GPU_DEVICE create(long address) {
/* 128 */     return new GPU_DEVICE(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static GPU_DEVICE createSafe(long address) {
/* 133 */     return (address == 0L) ? null : new GPU_DEVICE(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 142 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 151 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 160 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 161 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 171 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 176 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static GPU_DEVICE malloc(MemoryStack stack) {
/* 185 */     return new GPU_DEVICE(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static GPU_DEVICE calloc(MemoryStack stack) {
/* 194 */     return new GPU_DEVICE(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 204 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 214 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int ncb(long struct) {
/* 220 */     return MemoryUtil.memGetInt(struct + CB);
/*     */   } public static ByteBuffer nDeviceName(long struct) {
/* 222 */     return MemoryUtil.memByteBuffer(struct + DEVICENAME, 32);
/*     */   } public static String nDeviceNameString(long struct) {
/* 224 */     return MemoryUtil.memASCII(struct + DEVICENAME);
/*     */   } public static ByteBuffer nDeviceString(long struct) {
/* 226 */     return MemoryUtil.memByteBuffer(struct + DEVICESTRING, 128);
/*     */   } public static String nDeviceStringString(long struct) {
/* 228 */     return MemoryUtil.memASCII(struct + DEVICESTRING);
/*     */   } public static int nFlags(long struct) {
/* 230 */     return MemoryUtil.memGetInt(struct + FLAGS);
/*     */   } public static RECT nrcVirtualScreen(long struct) {
/* 232 */     return RECT.create(struct + RCVIRTUALSCREEN);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<GPU_DEVICE, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 239 */     private static final GPU_DEVICE ELEMENT_FACTORY = GPU_DEVICE.create(-1L);
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
/* 251 */       super(container, container.remaining() / GPU_DEVICE.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 255 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 259 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 264 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 269 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected GPU_DEVICE getElementFactory() {
/* 274 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("DWORD")
/*     */     public int cb() {
/* 279 */       return GPU_DEVICE.ncb(address());
/*     */     } @NativeType("CHAR[32]")
/*     */     public ByteBuffer DeviceName() {
/* 282 */       return GPU_DEVICE.nDeviceName(address());
/*     */     } @NativeType("CHAR[32]")
/*     */     public String DeviceNameString() {
/* 285 */       return GPU_DEVICE.nDeviceNameString(address());
/*     */     } @NativeType("CHAR[128]")
/*     */     public ByteBuffer DeviceString() {
/* 288 */       return GPU_DEVICE.nDeviceString(address());
/*     */     } @NativeType("CHAR[128]")
/*     */     public String DeviceStringString() {
/* 291 */       return GPU_DEVICE.nDeviceStringString(address());
/*     */     } @NativeType("DWORD")
/*     */     public int Flags() {
/* 294 */       return GPU_DEVICE.nFlags(address());
/*     */     } public RECT rcVirtualScreen() {
/* 296 */       return GPU_DEVICE.nrcVirtualScreen(address());
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\GPU_DEVICE.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */