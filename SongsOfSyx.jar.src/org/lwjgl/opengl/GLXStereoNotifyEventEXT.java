/*     */ package org.lwjgl.opengl;
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
/*     */ 
/*     */ 
/*     */ public class GLXStereoNotifyEventEXT
/*     */   extends Struct<GLXStereoNotifyEventEXT>
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int TYPE;
/*     */   public static final int SERIAL;
/*     */   public static final int SEND_EVENT;
/*     */   public static final int DISPLAY;
/*     */   public static final int EXTENSION;
/*     */   public static final int EVTYPE;
/*     */   public static final int WINDOW;
/*     */   public static final int STEREO_TREE;
/*     */   
/*     */   static {
/*  49 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  50 */           __member(4), 
/*  51 */           __member(CLONG_SIZE), 
/*  52 */           __member(4), 
/*  53 */           __member(POINTER_SIZE), 
/*  54 */           __member(4), 
/*  55 */           __member(4), 
/*  56 */           __member(POINTER_SIZE), 
/*  57 */           __member(4)
/*     */         });
/*     */     
/*  60 */     SIZEOF = layout.getSize();
/*  61 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  63 */     TYPE = layout.offsetof(0);
/*  64 */     SERIAL = layout.offsetof(1);
/*  65 */     SEND_EVENT = layout.offsetof(2);
/*  66 */     DISPLAY = layout.offsetof(3);
/*  67 */     EXTENSION = layout.offsetof(4);
/*  68 */     EVTYPE = layout.offsetof(5);
/*  69 */     WINDOW = layout.offsetof(6);
/*  70 */     STEREO_TREE = layout.offsetof(7);
/*     */   }
/*     */   
/*     */   protected GLXStereoNotifyEventEXT(long address, ByteBuffer container) {
/*  74 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected GLXStereoNotifyEventEXT create(long address, ByteBuffer container) {
/*  79 */     return new GLXStereoNotifyEventEXT(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GLXStereoNotifyEventEXT(ByteBuffer container) {
/*  89 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  93 */     return SIZEOF;
/*     */   }
/*     */   public int type() {
/*  96 */     return ntype(address());
/*     */   } @NativeType("unsigned long")
/*     */   public long serial() {
/*  99 */     return nserial(address());
/*     */   } @NativeType("Bool")
/*     */   public boolean send_event() {
/* 102 */     return (nsend_event(address()) != 0);
/*     */   } @NativeType("Display *")
/*     */   public long display() {
/* 105 */     return ndisplay(address());
/*     */   } public int extension() {
/* 107 */     return nextension(address());
/*     */   } public int evtype() {
/* 109 */     return nevtype(address());
/*     */   } @NativeType("GLXDrawable")
/*     */   public long window() {
/* 112 */     return nwindow(address());
/*     */   } @NativeType("Bool")
/*     */   public boolean stereo_tree() {
/* 115 */     return (nstereo_tree(address()) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static GLXStereoNotifyEventEXT create(long address) {
/* 121 */     return new GLXStereoNotifyEventEXT(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static GLXStereoNotifyEventEXT createSafe(long address) {
/* 126 */     return (address == 0L) ? null : new GLXStereoNotifyEventEXT(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 136 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 141 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int ntype(long struct) {
/* 147 */     return MemoryUtil.memGetInt(struct + TYPE);
/*     */   } public static long nserial(long struct) {
/* 149 */     return MemoryUtil.memGetCLong(struct + SERIAL);
/*     */   } public static int nsend_event(long struct) {
/* 151 */     return MemoryUtil.memGetInt(struct + SEND_EVENT);
/*     */   } public static long ndisplay(long struct) {
/* 153 */     return MemoryUtil.memGetAddress(struct + DISPLAY);
/*     */   } public static int nextension(long struct) {
/* 155 */     return MemoryUtil.memGetInt(struct + EXTENSION);
/*     */   } public static int nevtype(long struct) {
/* 157 */     return MemoryUtil.memGetInt(struct + EVTYPE);
/*     */   } public static long nwindow(long struct) {
/* 159 */     return MemoryUtil.memGetAddress(struct + WINDOW);
/*     */   } public static int nstereo_tree(long struct) {
/* 161 */     return MemoryUtil.memGetInt(struct + STEREO_TREE);
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<GLXStereoNotifyEventEXT, Buffer>
/*     */   {
/* 168 */     private static final GLXStereoNotifyEventEXT ELEMENT_FACTORY = GLXStereoNotifyEventEXT.create(-1L);
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
/* 180 */       super(container, container.remaining() / GLXStereoNotifyEventEXT.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 184 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 188 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 193 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 198 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected GLXStereoNotifyEventEXT getElementFactory() {
/* 203 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     public int type() {
/* 207 */       return GLXStereoNotifyEventEXT.ntype(address());
/*     */     } @NativeType("unsigned long")
/*     */     public long serial() {
/* 210 */       return GLXStereoNotifyEventEXT.nserial(address());
/*     */     } @NativeType("Bool")
/*     */     public boolean send_event() {
/* 213 */       return (GLXStereoNotifyEventEXT.nsend_event(address()) != 0);
/*     */     } @NativeType("Display *")
/*     */     public long display() {
/* 216 */       return GLXStereoNotifyEventEXT.ndisplay(address());
/*     */     } public int extension() {
/* 218 */       return GLXStereoNotifyEventEXT.nextension(address());
/*     */     } public int evtype() {
/* 220 */       return GLXStereoNotifyEventEXT.nevtype(address());
/*     */     } @NativeType("GLXDrawable")
/*     */     public long window() {
/* 223 */       return GLXStereoNotifyEventEXT.nwindow(address());
/*     */     } @NativeType("Bool")
/*     */     public boolean stereo_tree() {
/* 226 */       return (GLXStereoNotifyEventEXT.nstereo_tree(address()) != 0);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\GLXStereoNotifyEventEXT.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */