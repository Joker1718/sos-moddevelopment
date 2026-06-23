/*     */ package org.lwjgl.system.linux;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import org.lwjgl.system.CustomBuffer;
/*     */ import org.lwjgl.system.MemoryUtil;
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
/*     */ public class XTimeCoord
/*     */   extends Struct<XTimeCoord>
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int TIME;
/*     */   public static final int X;
/*     */   public static final int Y;
/*     */   
/*     */   static {
/*  39 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  40 */           __member(CLONG_SIZE), 
/*  41 */           __member(2), 
/*  42 */           __member(2)
/*     */         });
/*     */     
/*  45 */     SIZEOF = layout.getSize();
/*  46 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  48 */     TIME = layout.offsetof(0);
/*  49 */     X = layout.offsetof(1);
/*  50 */     Y = layout.offsetof(2);
/*     */   }
/*     */   
/*     */   protected XTimeCoord(long address, ByteBuffer container) {
/*  54 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected XTimeCoord create(long address, ByteBuffer container) {
/*  59 */     return new XTimeCoord(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XTimeCoord(ByteBuffer container) {
/*  69 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  73 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("Time")
/*     */   public long time() {
/*  77 */     return ntime(address());
/*     */   } public short x() {
/*  79 */     return nx(address());
/*     */   } public short y() {
/*  81 */     return ny(address());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static XTimeCoord create(long address) {
/*  87 */     return new XTimeCoord(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XTimeCoord createSafe(long address) {
/*  92 */     return (address == 0L) ? null : new XTimeCoord(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 102 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 107 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static long ntime(long struct) {
/* 113 */     return MemoryUtil.memGetCLong(struct + TIME);
/*     */   } public static short nx(long struct) {
/* 115 */     return MemoryUtil.memGetShort(struct + X);
/*     */   } public static short ny(long struct) {
/* 117 */     return MemoryUtil.memGetShort(struct + Y);
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<XTimeCoord, Buffer>
/*     */   {
/* 124 */     private static final XTimeCoord ELEMENT_FACTORY = XTimeCoord.create(-1L);
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
/* 136 */       super(container, container.remaining() / XTimeCoord.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 140 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 144 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 149 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 154 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected XTimeCoord getElementFactory() {
/* 159 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("Time")
/*     */     public long time() {
/* 164 */       return XTimeCoord.ntime(address());
/*     */     } public short x() {
/* 166 */       return XTimeCoord.nx(address());
/*     */     } public short y() {
/* 168 */       return XTimeCoord.ny(address());
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\XTimeCoord.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */