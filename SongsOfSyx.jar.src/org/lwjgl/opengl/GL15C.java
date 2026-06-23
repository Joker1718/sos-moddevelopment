/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.DoubleBuffer;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.nio.LongBuffer;
/*     */ import java.nio.ShortBuffer;
/*     */ import org.lwjgl.PointerBuffer;
/*     */ import org.lwjgl.system.APIUtil;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.CustomBuffer;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.MemoryStack;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ public class GL15C extends GL14C {
/*     */   public static final int GL_SRC1_ALPHA = 34185;
/*     */   public static final int GL_ARRAY_BUFFER = 34962;
/*     */   public static final int GL_ELEMENT_ARRAY_BUFFER = 34963;
/*     */   
/*     */   static {
/*  24 */     GL.initialize();
/*     */   }
/*     */ 
/*     */   
/*     */   public static final int GL_ARRAY_BUFFER_BINDING = 34964;
/*     */   
/*     */   public static final int GL_ELEMENT_ARRAY_BUFFER_BINDING = 34965;
/*     */   
/*     */   public static final int GL_VERTEX_ATTRIB_ARRAY_BUFFER_BINDING = 34975;
/*     */   
/*     */   public static final int GL_STREAM_DRAW = 35040;
/*     */   
/*     */   public static final int GL_STREAM_READ = 35041;
/*     */   
/*     */   public static final int GL_STREAM_COPY = 35042;
/*     */   
/*     */   public static final int GL_STATIC_DRAW = 35044;
/*     */   
/*     */   public static final int GL_STATIC_READ = 35045;
/*     */   
/*     */   public static final int GL_STATIC_COPY = 35046;
/*     */   
/*     */   public static final int GL_DYNAMIC_DRAW = 35048;
/*     */   
/*     */   public static final int GL_DYNAMIC_READ = 35049;
/*     */   
/*     */   public static final int GL_DYNAMIC_COPY = 35050;
/*     */   
/*     */   public static final int GL_READ_ONLY = 35000;
/*     */   
/*     */   public static final int GL_WRITE_ONLY = 35001;
/*     */   
/*     */   public static final int GL_READ_WRITE = 35002;
/*     */   
/*     */   public static final int GL_BUFFER_SIZE = 34660;
/*     */   
/*     */   public static final int GL_BUFFER_USAGE = 34661;
/*     */   
/*     */   public static final int GL_BUFFER_ACCESS = 35003;
/*     */   
/*     */   public static final int GL_BUFFER_MAPPED = 35004;
/*     */   public static final int GL_BUFFER_MAP_POINTER = 35005;
/*     */   public static final int GL_SAMPLES_PASSED = 35092;
/*     */   public static final int GL_QUERY_COUNTER_BITS = 34916;
/*     */   public static final int GL_CURRENT_QUERY = 34917;
/*     */   public static final int GL_QUERY_RESULT = 34918;
/*     */   public static final int GL_QUERY_RESULT_AVAILABLE = 34919;
/*     */   
/*     */   protected GL15C() {
/*  73 */     throw new UnsupportedOperationException();
/*     */   }
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
/*     */   public static void glDeleteBuffers(@NativeType("GLuint const *") IntBuffer buffers) {
/*  88 */     nglDeleteBuffers(buffers.remaining(), MemoryUtil.memAddress(buffers));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDeleteBuffers(@NativeType("GLuint const *") int buffer) {
/*  93 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/*  95 */       IntBuffer buffers = stack.ints(buffer);
/*  96 */       nglDeleteBuffers(1, MemoryUtil.memAddress(buffers));
/*     */     } finally {
/*  98 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGenBuffers(@NativeType("GLuint *") IntBuffer buffers) {
/* 109 */     nglGenBuffers(buffers.remaining(), MemoryUtil.memAddress(buffers));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGenBuffers() {
/* 115 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 117 */       IntBuffer buffers = stack.callocInt(1);
/* 118 */       nglGenBuffers(1, MemoryUtil.memAddress(buffers));
/* 119 */       return buffers.get(0);
/*     */     } finally {
/* 121 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
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
/*     */   public static void glBufferData(@NativeType("GLenum") int target, @NativeType("GLsizeiptr") long size, @NativeType("GLenum") int usage) {
/* 138 */     nglBufferData(target, size, 0L, usage);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferData(@NativeType("GLenum") int target, @NativeType("void const *") ByteBuffer data, @NativeType("GLenum") int usage) {
/* 143 */     nglBufferData(target, data.remaining(), MemoryUtil.memAddress(data), usage);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferData(@NativeType("GLenum") int target, @NativeType("void const *") ShortBuffer data, @NativeType("GLenum") int usage) {
/* 148 */     nglBufferData(target, Integer.toUnsignedLong(data.remaining()) << 1L, MemoryUtil.memAddress(data), usage);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferData(@NativeType("GLenum") int target, @NativeType("void const *") IntBuffer data, @NativeType("GLenum") int usage) {
/* 153 */     nglBufferData(target, Integer.toUnsignedLong(data.remaining()) << 2L, MemoryUtil.memAddress(data), usage);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferData(@NativeType("GLenum") int target, @NativeType("void const *") LongBuffer data, @NativeType("GLenum") int usage) {
/* 158 */     nglBufferData(target, Integer.toUnsignedLong(data.remaining()) << 3L, MemoryUtil.memAddress(data), usage);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferData(@NativeType("GLenum") int target, @NativeType("void const *") FloatBuffer data, @NativeType("GLenum") int usage) {
/* 163 */     nglBufferData(target, Integer.toUnsignedLong(data.remaining()) << 2L, MemoryUtil.memAddress(data), usage);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferData(@NativeType("GLenum") int target, @NativeType("void const *") DoubleBuffer data, @NativeType("GLenum") int usage) {
/* 168 */     nglBufferData(target, Integer.toUnsignedLong(data.remaining()) << 3L, MemoryUtil.memAddress(data), usage);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glBufferSubData(@NativeType("GLenum") int target, @NativeType("GLintptr") long offset, @NativeType("void const *") ByteBuffer data) {
/* 178 */     nglBufferSubData(target, offset, data.remaining(), MemoryUtil.memAddress(data));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferSubData(@NativeType("GLenum") int target, @NativeType("GLintptr") long offset, @NativeType("void const *") ShortBuffer data) {
/* 183 */     nglBufferSubData(target, offset, Integer.toUnsignedLong(data.remaining()) << 1L, MemoryUtil.memAddress(data));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferSubData(@NativeType("GLenum") int target, @NativeType("GLintptr") long offset, @NativeType("void const *") IntBuffer data) {
/* 188 */     nglBufferSubData(target, offset, Integer.toUnsignedLong(data.remaining()) << 2L, MemoryUtil.memAddress(data));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferSubData(@NativeType("GLenum") int target, @NativeType("GLintptr") long offset, @NativeType("void const *") LongBuffer data) {
/* 193 */     nglBufferSubData(target, offset, Integer.toUnsignedLong(data.remaining()) << 3L, MemoryUtil.memAddress(data));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferSubData(@NativeType("GLenum") int target, @NativeType("GLintptr") long offset, @NativeType("void const *") FloatBuffer data) {
/* 198 */     nglBufferSubData(target, offset, Integer.toUnsignedLong(data.remaining()) << 2L, MemoryUtil.memAddress(data));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferSubData(@NativeType("GLenum") int target, @NativeType("GLintptr") long offset, @NativeType("void const *") DoubleBuffer data) {
/* 203 */     nglBufferSubData(target, offset, Integer.toUnsignedLong(data.remaining()) << 3L, MemoryUtil.memAddress(data));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetBufferSubData(@NativeType("GLenum") int target, @NativeType("GLintptr") long offset, @NativeType("void *") ByteBuffer data) {
/* 213 */     nglGetBufferSubData(target, offset, data.remaining(), MemoryUtil.memAddress(data));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetBufferSubData(@NativeType("GLenum") int target, @NativeType("GLintptr") long offset, @NativeType("void *") ShortBuffer data) {
/* 218 */     nglGetBufferSubData(target, offset, Integer.toUnsignedLong(data.remaining()) << 1L, MemoryUtil.memAddress(data));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetBufferSubData(@NativeType("GLenum") int target, @NativeType("GLintptr") long offset, @NativeType("void *") IntBuffer data) {
/* 223 */     nglGetBufferSubData(target, offset, Integer.toUnsignedLong(data.remaining()) << 2L, MemoryUtil.memAddress(data));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetBufferSubData(@NativeType("GLenum") int target, @NativeType("GLintptr") long offset, @NativeType("void *") LongBuffer data) {
/* 228 */     nglGetBufferSubData(target, offset, Integer.toUnsignedLong(data.remaining()) << 3L, MemoryUtil.memAddress(data));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetBufferSubData(@NativeType("GLenum") int target, @NativeType("GLintptr") long offset, @NativeType("void *") FloatBuffer data) {
/* 233 */     nglGetBufferSubData(target, offset, Integer.toUnsignedLong(data.remaining()) << 2L, MemoryUtil.memAddress(data));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetBufferSubData(@NativeType("GLenum") int target, @NativeType("GLintptr") long offset, @NativeType("void *") DoubleBuffer data) {
/* 238 */     nglGetBufferSubData(target, offset, Integer.toUnsignedLong(data.remaining()) << 3L, MemoryUtil.memAddress(data));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static ByteBuffer glMapBuffer(@NativeType("GLenum") int target, @NativeType("GLenum") int access) {
/* 249 */     long __result = nglMapBuffer(target, access);
/* 250 */     return MemoryUtil.memByteBufferSafe(__result, glGetBufferParameteri(target, 34660));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static ByteBuffer glMapBuffer(@NativeType("GLenum") int target, @NativeType("GLenum") int access, ByteBuffer old_buffer) {
/* 256 */     long __result = nglMapBuffer(target, access);
/* 257 */     int length = glGetBufferParameteri(target, 34660);
/* 258 */     return APIUtil.apiGetMappedBuffer(old_buffer, __result, length);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static ByteBuffer glMapBuffer(@NativeType("GLenum") int target, @NativeType("GLenum") int access, long length, ByteBuffer old_buffer) {
/* 264 */     long __result = nglMapBuffer(target, access);
/* 265 */     return APIUtil.apiGetMappedBuffer(old_buffer, __result, (int)length);
/*     */   }
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
/*     */   public static void glGetBufferParameteriv(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/* 281 */     if (Checks.CHECKS) {
/* 282 */       Checks.check(params, 1);
/*     */     }
/* 284 */     nglGetBufferParameteriv(target, pname, MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetBufferParameteri(@NativeType("GLenum") int target, @NativeType("GLenum") int pname) {
/* 290 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 292 */       IntBuffer params = stack.callocInt(1);
/* 293 */       nglGetBufferParameteriv(target, pname, MemoryUtil.memAddress(params));
/* 294 */       return params.get(0);
/*     */     } finally {
/* 296 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetBufferPointerv(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("void **") PointerBuffer params) {
/* 307 */     if (Checks.CHECKS) {
/* 308 */       Checks.check((CustomBuffer)params, 1);
/*     */     }
/* 310 */     nglGetBufferPointerv(target, pname, MemoryUtil.memAddress((CustomBuffer)params));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static long glGetBufferPointer(@NativeType("GLenum") int target, @NativeType("GLenum") int pname) {
/* 316 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 318 */       PointerBuffer params = stack.callocPointer(1);
/* 319 */       nglGetBufferPointerv(target, pname, MemoryUtil.memAddress((CustomBuffer)params));
/* 320 */       return params.get(0);
/*     */     } finally {
/* 322 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGenQueries(@NativeType("GLuint *") IntBuffer ids) {
/* 333 */     nglGenQueries(ids.remaining(), MemoryUtil.memAddress(ids));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGenQueries() {
/* 339 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 341 */       IntBuffer ids = stack.callocInt(1);
/* 342 */       nglGenQueries(1, MemoryUtil.memAddress(ids));
/* 343 */       return ids.get(0);
/*     */     } finally {
/* 345 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glDeleteQueries(@NativeType("GLuint const *") IntBuffer ids) {
/* 356 */     nglDeleteQueries(ids.remaining(), MemoryUtil.memAddress(ids));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDeleteQueries(@NativeType("GLuint const *") int id) {
/* 361 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 363 */       IntBuffer ids = stack.ints(id);
/* 364 */       nglDeleteQueries(1, MemoryUtil.memAddress(ids));
/*     */     } finally {
/* 366 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
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
/*     */   public static void glGetQueryiv(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/* 393 */     if (Checks.CHECKS) {
/* 394 */       Checks.check(params, 1);
/*     */     }
/* 396 */     nglGetQueryiv(target, pname, MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetQueryi(@NativeType("GLenum") int target, @NativeType("GLenum") int pname) {
/* 402 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 404 */       IntBuffer params = stack.callocInt(1);
/* 405 */       nglGetQueryiv(target, pname, MemoryUtil.memAddress(params));
/* 406 */       return params.get(0);
/*     */     } finally {
/* 408 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetQueryObjectiv(@NativeType("GLuint") int id, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/* 419 */     if (Checks.CHECKS) {
/* 420 */       Checks.check(params, 1);
/*     */     }
/* 422 */     nglGetQueryObjectiv(id, pname, MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetQueryObjectiv(@NativeType("GLuint") int id, @NativeType("GLenum") int pname, @NativeType("GLint *") long params) {
/* 427 */     nglGetQueryObjectiv(id, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetQueryObjecti(@NativeType("GLuint") int id, @NativeType("GLenum") int pname) {
/* 433 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 435 */       IntBuffer params = stack.callocInt(1);
/* 436 */       nglGetQueryObjectiv(id, pname, MemoryUtil.memAddress(params));
/* 437 */       return params.get(0);
/*     */     } finally {
/* 439 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetQueryObjectuiv(@NativeType("GLuint") int id, @NativeType("GLenum") int pname, @NativeType("GLuint *") IntBuffer params) {
/* 450 */     if (Checks.CHECKS) {
/* 451 */       Checks.check(params, 1);
/*     */     }
/* 453 */     nglGetQueryObjectuiv(id, pname, MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetQueryObjectuiv(@NativeType("GLuint") int id, @NativeType("GLenum") int pname, @NativeType("GLuint *") long params) {
/* 458 */     nglGetQueryObjectuiv(id, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetQueryObjectui(@NativeType("GLuint") int id, @NativeType("GLenum") int pname) {
/* 464 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 466 */       IntBuffer params = stack.callocInt(1);
/* 467 */       nglGetQueryObjectuiv(id, pname, MemoryUtil.memAddress(params));
/* 468 */       return params.get(0);
/*     */     } finally {
/* 470 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDeleteBuffers(@NativeType("GLuint const *") int[] buffers) {
/* 476 */     long __functionAddress = (GL.getICD()).glDeleteBuffers;
/* 477 */     if (Checks.CHECKS) {
/* 478 */       Checks.check(__functionAddress);
/*     */     }
/* 480 */     JNI.callPV(buffers.length, buffers, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGenBuffers(@NativeType("GLuint *") int[] buffers) {
/* 485 */     long __functionAddress = (GL.getICD()).glGenBuffers;
/* 486 */     if (Checks.CHECKS) {
/* 487 */       Checks.check(__functionAddress);
/*     */     }
/* 489 */     JNI.callPV(buffers.length, buffers, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferData(@NativeType("GLenum") int target, @NativeType("void const *") short[] data, @NativeType("GLenum") int usage) {
/* 494 */     long __functionAddress = (GL.getICD()).glBufferData;
/* 495 */     if (Checks.CHECKS) {
/* 496 */       Checks.check(__functionAddress);
/*     */     }
/* 498 */     JNI.callPPV(target, Integer.toUnsignedLong(data.length) << 1L, data, usage, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferData(@NativeType("GLenum") int target, @NativeType("void const *") int[] data, @NativeType("GLenum") int usage) {
/* 503 */     long __functionAddress = (GL.getICD()).glBufferData;
/* 504 */     if (Checks.CHECKS) {
/* 505 */       Checks.check(__functionAddress);
/*     */     }
/* 507 */     JNI.callPPV(target, Integer.toUnsignedLong(data.length) << 2L, data, usage, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferData(@NativeType("GLenum") int target, @NativeType("void const *") long[] data, @NativeType("GLenum") int usage) {
/* 512 */     long __functionAddress = (GL.getICD()).glBufferData;
/* 513 */     if (Checks.CHECKS) {
/* 514 */       Checks.check(__functionAddress);
/*     */     }
/* 516 */     JNI.callPPV(target, Integer.toUnsignedLong(data.length) << 3L, data, usage, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferData(@NativeType("GLenum") int target, @NativeType("void const *") float[] data, @NativeType("GLenum") int usage) {
/* 521 */     long __functionAddress = (GL.getICD()).glBufferData;
/* 522 */     if (Checks.CHECKS) {
/* 523 */       Checks.check(__functionAddress);
/*     */     }
/* 525 */     JNI.callPPV(target, Integer.toUnsignedLong(data.length) << 2L, data, usage, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferData(@NativeType("GLenum") int target, @NativeType("void const *") double[] data, @NativeType("GLenum") int usage) {
/* 530 */     long __functionAddress = (GL.getICD()).glBufferData;
/* 531 */     if (Checks.CHECKS) {
/* 532 */       Checks.check(__functionAddress);
/*     */     }
/* 534 */     JNI.callPPV(target, Integer.toUnsignedLong(data.length) << 3L, data, usage, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferSubData(@NativeType("GLenum") int target, @NativeType("GLintptr") long offset, @NativeType("void const *") short[] data) {
/* 539 */     long __functionAddress = (GL.getICD()).glBufferSubData;
/* 540 */     if (Checks.CHECKS) {
/* 541 */       Checks.check(__functionAddress);
/*     */     }
/* 543 */     JNI.callPPPV(target, offset, Integer.toUnsignedLong(data.length) << 1L, data, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferSubData(@NativeType("GLenum") int target, @NativeType("GLintptr") long offset, @NativeType("void const *") int[] data) {
/* 548 */     long __functionAddress = (GL.getICD()).glBufferSubData;
/* 549 */     if (Checks.CHECKS) {
/* 550 */       Checks.check(__functionAddress);
/*     */     }
/* 552 */     JNI.callPPPV(target, offset, Integer.toUnsignedLong(data.length) << 2L, data, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferSubData(@NativeType("GLenum") int target, @NativeType("GLintptr") long offset, @NativeType("void const *") long[] data) {
/* 557 */     long __functionAddress = (GL.getICD()).glBufferSubData;
/* 558 */     if (Checks.CHECKS) {
/* 559 */       Checks.check(__functionAddress);
/*     */     }
/* 561 */     JNI.callPPPV(target, offset, Integer.toUnsignedLong(data.length) << 3L, data, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferSubData(@NativeType("GLenum") int target, @NativeType("GLintptr") long offset, @NativeType("void const *") float[] data) {
/* 566 */     long __functionAddress = (GL.getICD()).glBufferSubData;
/* 567 */     if (Checks.CHECKS) {
/* 568 */       Checks.check(__functionAddress);
/*     */     }
/* 570 */     JNI.callPPPV(target, offset, Integer.toUnsignedLong(data.length) << 2L, data, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferSubData(@NativeType("GLenum") int target, @NativeType("GLintptr") long offset, @NativeType("void const *") double[] data) {
/* 575 */     long __functionAddress = (GL.getICD()).glBufferSubData;
/* 576 */     if (Checks.CHECKS) {
/* 577 */       Checks.check(__functionAddress);
/*     */     }
/* 579 */     JNI.callPPPV(target, offset, Integer.toUnsignedLong(data.length) << 3L, data, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetBufferSubData(@NativeType("GLenum") int target, @NativeType("GLintptr") long offset, @NativeType("void *") short[] data) {
/* 584 */     long __functionAddress = (GL.getICD()).glGetBufferSubData;
/* 585 */     if (Checks.CHECKS) {
/* 586 */       Checks.check(__functionAddress);
/*     */     }
/* 588 */     JNI.callPPPV(target, offset, Integer.toUnsignedLong(data.length) << 1L, data, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetBufferSubData(@NativeType("GLenum") int target, @NativeType("GLintptr") long offset, @NativeType("void *") int[] data) {
/* 593 */     long __functionAddress = (GL.getICD()).glGetBufferSubData;
/* 594 */     if (Checks.CHECKS) {
/* 595 */       Checks.check(__functionAddress);
/*     */     }
/* 597 */     JNI.callPPPV(target, offset, Integer.toUnsignedLong(data.length) << 2L, data, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetBufferSubData(@NativeType("GLenum") int target, @NativeType("GLintptr") long offset, @NativeType("void *") long[] data) {
/* 602 */     long __functionAddress = (GL.getICD()).glGetBufferSubData;
/* 603 */     if (Checks.CHECKS) {
/* 604 */       Checks.check(__functionAddress);
/*     */     }
/* 606 */     JNI.callPPPV(target, offset, Integer.toUnsignedLong(data.length) << 3L, data, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetBufferSubData(@NativeType("GLenum") int target, @NativeType("GLintptr") long offset, @NativeType("void *") float[] data) {
/* 611 */     long __functionAddress = (GL.getICD()).glGetBufferSubData;
/* 612 */     if (Checks.CHECKS) {
/* 613 */       Checks.check(__functionAddress);
/*     */     }
/* 615 */     JNI.callPPPV(target, offset, Integer.toUnsignedLong(data.length) << 2L, data, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetBufferSubData(@NativeType("GLenum") int target, @NativeType("GLintptr") long offset, @NativeType("void *") double[] data) {
/* 620 */     long __functionAddress = (GL.getICD()).glGetBufferSubData;
/* 621 */     if (Checks.CHECKS) {
/* 622 */       Checks.check(__functionAddress);
/*     */     }
/* 624 */     JNI.callPPPV(target, offset, Integer.toUnsignedLong(data.length) << 3L, data, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetBufferParameteriv(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 629 */     long __functionAddress = (GL.getICD()).glGetBufferParameteriv;
/* 630 */     if (Checks.CHECKS) {
/* 631 */       Checks.check(__functionAddress);
/* 632 */       Checks.check(params, 1);
/*     */     } 
/* 634 */     JNI.callPV(target, pname, params, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGenQueries(@NativeType("GLuint *") int[] ids) {
/* 639 */     long __functionAddress = (GL.getICD()).glGenQueries;
/* 640 */     if (Checks.CHECKS) {
/* 641 */       Checks.check(__functionAddress);
/*     */     }
/* 643 */     JNI.callPV(ids.length, ids, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDeleteQueries(@NativeType("GLuint const *") int[] ids) {
/* 648 */     long __functionAddress = (GL.getICD()).glDeleteQueries;
/* 649 */     if (Checks.CHECKS) {
/* 650 */       Checks.check(__functionAddress);
/*     */     }
/* 652 */     JNI.callPV(ids.length, ids, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetQueryiv(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 657 */     long __functionAddress = (GL.getICD()).glGetQueryiv;
/* 658 */     if (Checks.CHECKS) {
/* 659 */       Checks.check(__functionAddress);
/* 660 */       Checks.check(params, 1);
/*     */     } 
/* 662 */     JNI.callPV(target, pname, params, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetQueryObjectiv(@NativeType("GLuint") int id, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 667 */     long __functionAddress = (GL.getICD()).glGetQueryObjectiv;
/* 668 */     if (Checks.CHECKS) {
/* 669 */       Checks.check(__functionAddress);
/* 670 */       Checks.check(params, 1);
/*     */     } 
/* 672 */     JNI.callPV(id, pname, params, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetQueryObjectuiv(@NativeType("GLuint") int id, @NativeType("GLenum") int pname, @NativeType("GLuint *") int[] params) {
/* 677 */     long __functionAddress = (GL.getICD()).glGetQueryObjectuiv;
/* 678 */     if (Checks.CHECKS) {
/* 679 */       Checks.check(__functionAddress);
/* 680 */       Checks.check(params, 1);
/*     */     } 
/* 682 */     JNI.callPV(id, pname, params, __functionAddress);
/*     */   }
/*     */   
/*     */   public static native void glBindBuffer(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2);
/*     */   
/*     */   public static native void nglDeleteBuffers(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglGenBuffers(int paramInt, long paramLong);
/*     */   
/*     */   @NativeType("GLboolean")
/*     */   public static native boolean glIsBuffer(@NativeType("GLuint") int paramInt);
/*     */   
/*     */   public static native void nglBufferData(int paramInt1, long paramLong1, long paramLong2, int paramInt2);
/*     */   
/*     */   public static native void nglBufferSubData(int paramInt, long paramLong1, long paramLong2, long paramLong3);
/*     */   
/*     */   public static native void nglGetBufferSubData(int paramInt, long paramLong1, long paramLong2, long paramLong3);
/*     */   
/*     */   public static native long nglMapBuffer(int paramInt1, int paramInt2);
/*     */   
/*     */   @NativeType("GLboolean")
/*     */   public static native boolean glUnmapBuffer(@NativeType("GLenum") int paramInt);
/*     */   
/*     */   public static native void nglGetBufferParameteriv(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglGetBufferPointerv(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglGenQueries(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglDeleteQueries(int paramInt, long paramLong);
/*     */   
/*     */   @NativeType("GLboolean")
/*     */   public static native boolean glIsQuery(@NativeType("GLuint") int paramInt);
/*     */   
/*     */   public static native void glBeginQuery(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2);
/*     */   
/*     */   public static native void glEndQuery(@NativeType("GLenum") int paramInt);
/*     */   
/*     */   public static native void nglGetQueryiv(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglGetQueryObjectiv(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglGetQueryObjectuiv(int paramInt1, int paramInt2, long paramLong);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\GL15C.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */