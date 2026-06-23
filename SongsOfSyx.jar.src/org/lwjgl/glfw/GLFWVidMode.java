/*     */ package org.lwjgl.glfw;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ @NativeType("struct GLFWvidmode")
/*     */ public class GLFWVidMode
/*     */   extends Struct<GLFWVidMode>
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int WIDTH;
/*     */   public static final int HEIGHT;
/*     */   public static final int REDBITS;
/*     */   public static final int GREENBITS;
/*     */   public static final int BLUEBITS;
/*     */   public static final int REFRESHRATE;
/*     */   
/*     */   static {
/*  46 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  47 */           __member(4), 
/*  48 */           __member(4), 
/*  49 */           __member(4), 
/*  50 */           __member(4), 
/*  51 */           __member(4), 
/*  52 */           __member(4)
/*     */         });
/*     */     
/*  55 */     SIZEOF = layout.getSize();
/*  56 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  58 */     WIDTH = layout.offsetof(0);
/*  59 */     HEIGHT = layout.offsetof(1);
/*  60 */     REDBITS = layout.offsetof(2);
/*  61 */     GREENBITS = layout.offsetof(3);
/*  62 */     BLUEBITS = layout.offsetof(4);
/*  63 */     REFRESHRATE = layout.offsetof(5);
/*     */   }
/*     */   
/*     */   protected GLFWVidMode(long address, ByteBuffer container) {
/*  67 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected GLFWVidMode create(long address, ByteBuffer container) {
/*  72 */     return new GLFWVidMode(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GLFWVidMode(ByteBuffer container) {
/*  82 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  86 */     return SIZEOF;
/*     */   }
/*     */   public int width() {
/*  89 */     return nwidth(address());
/*     */   } public int height() {
/*  91 */     return nheight(address());
/*     */   } public int redBits() {
/*  93 */     return nredBits(address());
/*     */   } public int greenBits() {
/*  95 */     return ngreenBits(address());
/*     */   } public int blueBits() {
/*  97 */     return nblueBits(address());
/*     */   } public int refreshRate() {
/*  99 */     return nrefreshRate(address());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static GLFWVidMode create(long address) {
/* 105 */     return new GLFWVidMode(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static GLFWVidMode createSafe(long address) {
/* 110 */     return (address == 0L) ? null : new GLFWVidMode(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 120 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 125 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nwidth(long struct) {
/* 131 */     return MemoryUtil.memGetInt(struct + WIDTH);
/*     */   } public static int nheight(long struct) {
/* 133 */     return MemoryUtil.memGetInt(struct + HEIGHT);
/*     */   } public static int nredBits(long struct) {
/* 135 */     return MemoryUtil.memGetInt(struct + REDBITS);
/*     */   } public static int ngreenBits(long struct) {
/* 137 */     return MemoryUtil.memGetInt(struct + GREENBITS);
/*     */   } public static int nblueBits(long struct) {
/* 139 */     return MemoryUtil.memGetInt(struct + BLUEBITS);
/*     */   } public static int nrefreshRate(long struct) {
/* 141 */     return MemoryUtil.memGetInt(struct + REFRESHRATE);
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<GLFWVidMode, Buffer>
/*     */   {
/* 148 */     private static final GLFWVidMode ELEMENT_FACTORY = GLFWVidMode.create(-1L);
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
/* 160 */       super(container, container.remaining() / GLFWVidMode.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 164 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 168 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 173 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 178 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected GLFWVidMode getElementFactory() {
/* 183 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     public int width() {
/* 187 */       return GLFWVidMode.nwidth(address());
/*     */     } public int height() {
/* 189 */       return GLFWVidMode.nheight(address());
/*     */     } public int redBits() {
/* 191 */       return GLFWVidMode.nredBits(address());
/*     */     } public int greenBits() {
/* 193 */       return GLFWVidMode.ngreenBits(address());
/*     */     } public int blueBits() {
/* 195 */       return GLFWVidMode.nblueBits(address());
/*     */     } public int refreshRate() {
/* 197 */       return GLFWVidMode.nrefreshRate(address());
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\glfw\GLFWVidMode.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */