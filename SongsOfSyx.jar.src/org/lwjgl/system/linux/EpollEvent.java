/*     */ package org.lwjgl.system.linux;
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
/*     */ @NativeType("struct epoll_event")
/*     */ public class EpollEvent
/*     */   extends Struct<EpollEvent>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int EVENTS;
/*     */   public static final int DATA;
/*     */   
/*     */   static {
/*  40 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  41 */           __member(4), 
/*  42 */           __member(EpollData.SIZEOF, EpollData.ALIGNOF)
/*     */         });
/*     */     
/*  45 */     SIZEOF = layout.getSize();
/*  46 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  48 */     EVENTS = layout.offsetof(0);
/*  49 */     DATA = layout.offsetof(1);
/*     */   }
/*     */   
/*     */   protected EpollEvent(long address, ByteBuffer container) {
/*  53 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected EpollEvent create(long address, ByteBuffer container) {
/*  58 */     return new EpollEvent(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EpollEvent(ByteBuffer container) {
/*  68 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  72 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("uint32_t")
/*     */   public int events() {
/*  76 */     return nevents(address());
/*     */   } @NativeType("epoll_data_t")
/*     */   public EpollData data() {
/*  79 */     return ndata(address());
/*     */   }
/*     */   public EpollEvent events(@NativeType("uint32_t") int value) {
/*  82 */     nevents(address(), value); return this;
/*     */   } public EpollEvent data(@NativeType("epoll_data_t") EpollData value) {
/*  84 */     ndata(address(), value); return this;
/*     */   } public EpollEvent data(Consumer<EpollData> consumer) {
/*  86 */     consumer.accept(data()); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EpollEvent set(int events, EpollData data) {
/*  93 */     events(events);
/*  94 */     data(data);
/*     */     
/*  96 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EpollEvent set(EpollEvent src) {
/* 107 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 108 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static EpollEvent malloc() {
/* 115 */     return new EpollEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static EpollEvent calloc() {
/* 120 */     return new EpollEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static EpollEvent create() {
/* 125 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 126 */     return new EpollEvent(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static EpollEvent create(long address) {
/* 131 */     return new EpollEvent(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static EpollEvent createSafe(long address) {
/* 136 */     return (address == 0L) ? null : new EpollEvent(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 145 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 154 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 163 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 164 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 174 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 179 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static EpollEvent malloc(MemoryStack stack) {
/* 188 */     return new EpollEvent(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static EpollEvent calloc(MemoryStack stack) {
/* 197 */     return new EpollEvent(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 207 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 217 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nevents(long struct) {
/* 223 */     return MemoryUtil.memGetInt(struct + EVENTS);
/*     */   } public static EpollData ndata(long struct) {
/* 225 */     return EpollData.create(struct + DATA);
/*     */   }
/*     */   public static void nevents(long struct, int value) {
/* 228 */     MemoryUtil.memPutInt(struct + EVENTS, value);
/*     */   } public static void ndata(long struct, EpollData value) {
/* 230 */     MemoryUtil.memCopy(value.address(), struct + DATA, EpollData.SIZEOF);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<EpollEvent, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 237 */     private static final EpollEvent ELEMENT_FACTORY = EpollEvent.create(-1L);
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
/* 249 */       super(container, container.remaining() / EpollEvent.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 253 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 257 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 262 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 267 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected EpollEvent getElementFactory() {
/* 272 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("uint32_t")
/*     */     public int events() {
/* 277 */       return EpollEvent.nevents(address());
/*     */     } @NativeType("epoll_data_t")
/*     */     public EpollData data() {
/* 280 */       return EpollEvent.ndata(address());
/*     */     }
/*     */     public Buffer events(@NativeType("uint32_t") int value) {
/* 283 */       EpollEvent.nevents(address(), value); return this;
/*     */     } public Buffer data(@NativeType("epoll_data_t") EpollData value) {
/* 285 */       EpollEvent.ndata(address(), value); return this;
/*     */     } public Buffer data(Consumer<EpollData> consumer) {
/* 287 */       consumer.accept(data()); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\EpollEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */