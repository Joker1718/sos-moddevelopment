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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DISPLAY_DEVICE
/*     */   extends Struct<DISPLAY_DEVICE>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int CB;
/*     */   public static final int DEVICENAME;
/*     */   public static final int DEVICESTRING;
/*     */   public static final int STATEFLAGS;
/*     */   public static final int DEVICEID;
/*     */   public static final int DEVICEKEY;
/*     */   
/*     */   static {
/*  47 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  48 */           __member(4), 
/*  49 */           __array(2, 32), 
/*  50 */           __array(2, 128), 
/*  51 */           __member(4), 
/*  52 */           __array(2, 128), 
/*  53 */           __array(2, 128)
/*     */         });
/*     */     
/*  56 */     SIZEOF = layout.getSize();
/*  57 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  59 */     CB = layout.offsetof(0);
/*  60 */     DEVICENAME = layout.offsetof(1);
/*  61 */     DEVICESTRING = layout.offsetof(2);
/*  62 */     STATEFLAGS = layout.offsetof(3);
/*  63 */     DEVICEID = layout.offsetof(4);
/*  64 */     DEVICEKEY = layout.offsetof(5);
/*     */   }
/*     */   
/*     */   protected DISPLAY_DEVICE(long address, ByteBuffer container) {
/*  68 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected DISPLAY_DEVICE create(long address, ByteBuffer container) {
/*  73 */     return new DISPLAY_DEVICE(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DISPLAY_DEVICE(ByteBuffer container) {
/*  83 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  87 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("DWORD")
/*     */   public int cb() {
/*  91 */     return ncb(address());
/*     */   } @NativeType("TCHAR[32]")
/*     */   public ByteBuffer DeviceName() {
/*  94 */     return nDeviceName(address());
/*     */   } @NativeType("TCHAR[32]")
/*     */   public String DeviceNameString() {
/*  97 */     return nDeviceNameString(address());
/*     */   } @NativeType("TCHAR[128]")
/*     */   public ByteBuffer DeviceString() {
/* 100 */     return nDeviceString(address());
/*     */   } @NativeType("TCHAR[128]")
/*     */   public String DeviceStringString() {
/* 103 */     return nDeviceStringString(address());
/*     */   } @NativeType("DWORD")
/*     */   public int StateFlags() {
/* 106 */     return nStateFlags(address());
/*     */   } @NativeType("TCHAR[128]")
/*     */   public ByteBuffer DeviceID() {
/* 109 */     return nDeviceID(address());
/*     */   } @NativeType("TCHAR[128]")
/*     */   public String DeviceIDString() {
/* 112 */     return nDeviceIDString(address());
/*     */   } @NativeType("TCHAR[128]")
/*     */   public ByteBuffer DeviceKey() {
/* 115 */     return nDeviceKey(address());
/*     */   } @NativeType("TCHAR[128]")
/*     */   public String DeviceKeyString() {
/* 118 */     return nDeviceKeyString(address());
/*     */   }
/*     */   public DISPLAY_DEVICE cb(@NativeType("DWORD") int value) {
/* 121 */     ncb(address(), value); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DISPLAY_DEVICE set(DISPLAY_DEVICE src) {
/* 131 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 132 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static DISPLAY_DEVICE malloc() {
/* 139 */     return new DISPLAY_DEVICE(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static DISPLAY_DEVICE calloc() {
/* 144 */     return new DISPLAY_DEVICE(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static DISPLAY_DEVICE create() {
/* 149 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 150 */     return new DISPLAY_DEVICE(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static DISPLAY_DEVICE create(long address) {
/* 155 */     return new DISPLAY_DEVICE(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static DISPLAY_DEVICE createSafe(long address) {
/* 160 */     return (address == 0L) ? null : new DISPLAY_DEVICE(address, null);
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
/*     */   public static DISPLAY_DEVICE malloc(MemoryStack stack) {
/* 212 */     return new DISPLAY_DEVICE(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static DISPLAY_DEVICE calloc(MemoryStack stack) {
/* 221 */     return new DISPLAY_DEVICE(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
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
/*     */   public static int ncb(long struct) {
/* 247 */     return MemoryUtil.memGetInt(struct + CB);
/*     */   } public static ByteBuffer nDeviceName(long struct) {
/* 249 */     return MemoryUtil.memByteBuffer(struct + DEVICENAME, 64);
/*     */   } public static String nDeviceNameString(long struct) {
/* 251 */     return MemoryUtil.memUTF16(struct + DEVICENAME);
/*     */   } public static ByteBuffer nDeviceString(long struct) {
/* 253 */     return MemoryUtil.memByteBuffer(struct + DEVICESTRING, 256);
/*     */   } public static String nDeviceStringString(long struct) {
/* 255 */     return MemoryUtil.memUTF16(struct + DEVICESTRING);
/*     */   } public static int nStateFlags(long struct) {
/* 257 */     return MemoryUtil.memGetInt(struct + STATEFLAGS);
/*     */   } public static ByteBuffer nDeviceID(long struct) {
/* 259 */     return MemoryUtil.memByteBuffer(struct + DEVICEID, 256);
/*     */   } public static String nDeviceIDString(long struct) {
/* 261 */     return MemoryUtil.memUTF16(struct + DEVICEID);
/*     */   } public static ByteBuffer nDeviceKey(long struct) {
/* 263 */     return MemoryUtil.memByteBuffer(struct + DEVICEKEY, 256);
/*     */   } public static String nDeviceKeyString(long struct) {
/* 265 */     return MemoryUtil.memUTF16(struct + DEVICEKEY);
/*     */   }
/*     */   public static void ncb(long struct, int value) {
/* 268 */     MemoryUtil.memPutInt(struct + CB, value);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<DISPLAY_DEVICE, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 275 */     private static final DISPLAY_DEVICE ELEMENT_FACTORY = DISPLAY_DEVICE.create(-1L);
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
/* 287 */       super(container, container.remaining() / DISPLAY_DEVICE.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 291 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 295 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 300 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 305 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected DISPLAY_DEVICE getElementFactory() {
/* 310 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("DWORD")
/*     */     public int cb() {
/* 315 */       return DISPLAY_DEVICE.ncb(address());
/*     */     } @NativeType("TCHAR[32]")
/*     */     public ByteBuffer DeviceName() {
/* 318 */       return DISPLAY_DEVICE.nDeviceName(address());
/*     */     } @NativeType("TCHAR[32]")
/*     */     public String DeviceNameString() {
/* 321 */       return DISPLAY_DEVICE.nDeviceNameString(address());
/*     */     } @NativeType("TCHAR[128]")
/*     */     public ByteBuffer DeviceString() {
/* 324 */       return DISPLAY_DEVICE.nDeviceString(address());
/*     */     } @NativeType("TCHAR[128]")
/*     */     public String DeviceStringString() {
/* 327 */       return DISPLAY_DEVICE.nDeviceStringString(address());
/*     */     } @NativeType("DWORD")
/*     */     public int StateFlags() {
/* 330 */       return DISPLAY_DEVICE.nStateFlags(address());
/*     */     } @NativeType("TCHAR[128]")
/*     */     public ByteBuffer DeviceID() {
/* 333 */       return DISPLAY_DEVICE.nDeviceID(address());
/*     */     } @NativeType("TCHAR[128]")
/*     */     public String DeviceIDString() {
/* 336 */       return DISPLAY_DEVICE.nDeviceIDString(address());
/*     */     } @NativeType("TCHAR[128]")
/*     */     public ByteBuffer DeviceKey() {
/* 339 */       return DISPLAY_DEVICE.nDeviceKey(address());
/*     */     } @NativeType("TCHAR[128]")
/*     */     public String DeviceKeyString() {
/* 342 */       return DISPLAY_DEVICE.nDeviceKeyString(address());
/*     */     }
/*     */     public Buffer cb(@NativeType("DWORD") int value) {
/* 345 */       DISPLAY_DEVICE.ncb(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\windows\DISPLAY_DEVICE.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */