/*     */ package org.lwjgl.system.macosx;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CGEventTapInformation
/*     */   extends Struct<CGEventTapInformation>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int EVENTTAPID;
/*     */   public static final int TAPPOINT;
/*     */   public static final int OPTIONS;
/*     */   public static final int EVENTSOFINTEREST;
/*     */   public static final int TAPPINGPROCESS;
/*     */   public static final int PROCESSBEINGTAPPED;
/*     */   public static final int ENABLED;
/*     */   public static final int MINUSECLATENCY;
/*     */   public static final int AVGUSECLATENCY;
/*     */   public static final int MAXUSECLATENCY;
/*     */   
/*     */   static {
/*  55 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  56 */           __member(4), 
/*  57 */           __member(4), 
/*  58 */           __member(4), 
/*  59 */           __member(8), 
/*  60 */           __member(POINTER_SIZE), 
/*  61 */           __member(POINTER_SIZE), 
/*  62 */           __member(1), 
/*  63 */           __member(4), 
/*  64 */           __member(4), 
/*  65 */           __member(4)
/*     */         });
/*     */     
/*  68 */     SIZEOF = layout.getSize();
/*  69 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  71 */     EVENTTAPID = layout.offsetof(0);
/*  72 */     TAPPOINT = layout.offsetof(1);
/*  73 */     OPTIONS = layout.offsetof(2);
/*  74 */     EVENTSOFINTEREST = layout.offsetof(3);
/*  75 */     TAPPINGPROCESS = layout.offsetof(4);
/*  76 */     PROCESSBEINGTAPPED = layout.offsetof(5);
/*  77 */     ENABLED = layout.offsetof(6);
/*  78 */     MINUSECLATENCY = layout.offsetof(7);
/*  79 */     AVGUSECLATENCY = layout.offsetof(8);
/*  80 */     MAXUSECLATENCY = layout.offsetof(9);
/*     */   }
/*     */   
/*     */   protected CGEventTapInformation(long address, ByteBuffer container) {
/*  84 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected CGEventTapInformation create(long address, ByteBuffer container) {
/*  89 */     return new CGEventTapInformation(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CGEventTapInformation(ByteBuffer container) {
/*  99 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/* 103 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("uint32_t")
/*     */   public int eventTapID() {
/* 107 */     return neventTapID(address());
/*     */   } @NativeType("CGEventTapLocation")
/*     */   public int tapPoint() {
/* 110 */     return ntapPoint(address());
/*     */   } @NativeType("CGEventTapOptions")
/*     */   public int options() {
/* 113 */     return noptions(address());
/*     */   } @NativeType("CGEventMask")
/*     */   public long eventsOfInterest() {
/* 116 */     return neventsOfInterest(address());
/*     */   } @NativeType("pid_t")
/*     */   public long tappingProcess() {
/* 119 */     return ntappingProcess(address());
/*     */   } @NativeType("pid_t")
/*     */   public long processBeingTapped() {
/* 122 */     return nprocessBeingTapped(address());
/*     */   } @NativeType("bool")
/*     */   public boolean enabled() {
/* 125 */     return nenabled(address());
/*     */   } public float minUsecLatency() {
/* 127 */     return nminUsecLatency(address());
/*     */   } public float avgUsecLatency() {
/* 129 */     return navgUsecLatency(address());
/*     */   } public float maxUsecLatency() {
/* 131 */     return nmaxUsecLatency(address());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static CGEventTapInformation malloc() {
/* 137 */     return new CGEventTapInformation(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static CGEventTapInformation calloc() {
/* 142 */     return new CGEventTapInformation(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static CGEventTapInformation create() {
/* 147 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 148 */     return new CGEventTapInformation(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static CGEventTapInformation create(long address) {
/* 153 */     return new CGEventTapInformation(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static CGEventTapInformation createSafe(long address) {
/* 158 */     return (address == 0L) ? null : new CGEventTapInformation(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 167 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 176 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 185 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 186 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 196 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 201 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static CGEventTapInformation malloc(MemoryStack stack) {
/* 210 */     return new CGEventTapInformation(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static CGEventTapInformation calloc(MemoryStack stack) {
/* 219 */     return new CGEventTapInformation(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 229 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 239 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int neventTapID(long struct) {
/* 245 */     return MemoryUtil.memGetInt(struct + EVENTTAPID);
/*     */   } public static int ntapPoint(long struct) {
/* 247 */     return MemoryUtil.memGetInt(struct + TAPPOINT);
/*     */   } public static int noptions(long struct) {
/* 249 */     return MemoryUtil.memGetInt(struct + OPTIONS);
/*     */   } public static long neventsOfInterest(long struct) {
/* 251 */     return MemoryUtil.memGetLong(struct + EVENTSOFINTEREST);
/*     */   } public static long ntappingProcess(long struct) {
/* 253 */     return MemoryUtil.memGetAddress(struct + TAPPINGPROCESS);
/*     */   } public static long nprocessBeingTapped(long struct) {
/* 255 */     return MemoryUtil.memGetAddress(struct + PROCESSBEINGTAPPED);
/*     */   } public static boolean nenabled(long struct) {
/* 257 */     return (MemoryUtil.memGetByte(struct + ENABLED) != 0);
/*     */   } public static float nminUsecLatency(long struct) {
/* 259 */     return MemoryUtil.memGetFloat(struct + MINUSECLATENCY);
/*     */   } public static float navgUsecLatency(long struct) {
/* 261 */     return MemoryUtil.memGetFloat(struct + AVGUSECLATENCY);
/*     */   } public static float nmaxUsecLatency(long struct) {
/* 263 */     return MemoryUtil.memGetFloat(struct + MAXUSECLATENCY);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<CGEventTapInformation, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 270 */     private static final CGEventTapInformation ELEMENT_FACTORY = CGEventTapInformation.create(-1L);
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
/* 282 */       super(container, container.remaining() / CGEventTapInformation.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 286 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 290 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 295 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 300 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected CGEventTapInformation getElementFactory() {
/* 305 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("uint32_t")
/*     */     public int eventTapID() {
/* 310 */       return CGEventTapInformation.neventTapID(address());
/*     */     } @NativeType("CGEventTapLocation")
/*     */     public int tapPoint() {
/* 313 */       return CGEventTapInformation.ntapPoint(address());
/*     */     } @NativeType("CGEventTapOptions")
/*     */     public int options() {
/* 316 */       return CGEventTapInformation.noptions(address());
/*     */     } @NativeType("CGEventMask")
/*     */     public long eventsOfInterest() {
/* 319 */       return CGEventTapInformation.neventsOfInterest(address());
/*     */     } @NativeType("pid_t")
/*     */     public long tappingProcess() {
/* 322 */       return CGEventTapInformation.ntappingProcess(address());
/*     */     } @NativeType("pid_t")
/*     */     public long processBeingTapped() {
/* 325 */       return CGEventTapInformation.nprocessBeingTapped(address());
/*     */     } @NativeType("bool")
/*     */     public boolean enabled() {
/* 328 */       return CGEventTapInformation.nenabled(address());
/*     */     } public float minUsecLatency() {
/* 330 */       return CGEventTapInformation.nminUsecLatency(address());
/*     */     } public float avgUsecLatency() {
/* 332 */       return CGEventTapInformation.navgUsecLatency(address());
/*     */     } public float maxUsecLatency() {
/* 334 */       return CGEventTapInformation.nmaxUsecLatency(address());
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\macosx\CGEventTapInformation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */