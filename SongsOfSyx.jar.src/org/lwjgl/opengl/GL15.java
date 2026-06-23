/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.DoubleBuffer;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.nio.LongBuffer;
/*     */ import java.nio.ShortBuffer;
/*     */ import org.lwjgl.PointerBuffer;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ public class GL15 extends GL14 {
/*     */   public static final int GL_FOG_COORD_SRC = 33872;
/*     */   public static final int GL_FOG_COORD = 33873;
/*     */   public static final int GL_CURRENT_FOG_COORD = 33875;
/*     */   
/*     */   static {
/*  18 */     GL.initialize();
/*     */   }
/*     */ 
/*     */   
/*     */   public static final int GL_FOG_COORD_ARRAY_TYPE = 33876;
/*     */   
/*     */   public static final int GL_FOG_COORD_ARRAY_STRIDE = 33877;
/*     */   
/*     */   public static final int GL_FOG_COORD_ARRAY_POINTER = 33878;
/*     */   
/*     */   public static final int GL_FOG_COORD_ARRAY = 33879;
/*     */   
/*     */   public static final int GL_FOG_COORD_ARRAY_BUFFER_BINDING = 34973;
/*     */   
/*     */   public static final int GL_SRC0_RGB = 34176;
/*     */   
/*     */   public static final int GL_SRC1_RGB = 34177;
/*     */   
/*     */   public static final int GL_SRC2_RGB = 34178;
/*     */   
/*     */   public static final int GL_SRC0_ALPHA = 34184;
/*     */   
/*     */   public static final int GL_SRC1_ALPHA = 34185;
/*     */   
/*     */   public static final int GL_SRC2_ALPHA = 34186;
/*     */   
/*     */   public static final int GL_ARRAY_BUFFER = 34962;
/*     */   
/*     */   public static final int GL_ELEMENT_ARRAY_BUFFER = 34963;
/*     */   
/*     */   public static final int GL_ARRAY_BUFFER_BINDING = 34964;
/*     */   
/*     */   public static final int GL_ELEMENT_ARRAY_BUFFER_BINDING = 34965;
/*     */   
/*     */   public static final int GL_VERTEX_ARRAY_BUFFER_BINDING = 34966;
/*     */   
/*     */   public static final int GL_NORMAL_ARRAY_BUFFER_BINDING = 34967;
/*     */   
/*     */   public static final int GL_COLOR_ARRAY_BUFFER_BINDING = 34968;
/*     */   
/*     */   public static final int GL_INDEX_ARRAY_BUFFER_BINDING = 34969;
/*     */   
/*     */   public static final int GL_TEXTURE_COORD_ARRAY_BUFFER_BINDING = 34970;
/*     */   public static final int GL_EDGE_FLAG_ARRAY_BUFFER_BINDING = 34971;
/*     */   public static final int GL_SECONDARY_COLOR_ARRAY_BUFFER_BINDING = 34972;
/*     */   public static final int GL_FOG_COORDINATE_ARRAY_BUFFER_BINDING = 34973;
/*     */   public static final int GL_WEIGHT_ARRAY_BUFFER_BINDING = 34974;
/*     */   public static final int GL_VERTEX_ATTRIB_ARRAY_BUFFER_BINDING = 34975;
/*     */   public static final int GL_STREAM_DRAW = 35040;
/*     */   public static final int GL_STREAM_READ = 35041;
/*     */   public static final int GL_STREAM_COPY = 35042;
/*     */   public static final int GL_STATIC_DRAW = 35044;
/*     */   public static final int GL_STATIC_READ = 35045;
/*     */   public static final int GL_STATIC_COPY = 35046;
/*     */   public static final int GL_DYNAMIC_DRAW = 35048;
/*     */   public static final int GL_DYNAMIC_READ = 35049;
/*     */   public static final int GL_DYNAMIC_COPY = 35050;
/*     */   public static final int GL_READ_ONLY = 35000;
/*     */   public static final int GL_WRITE_ONLY = 35001;
/*     */   public static final int GL_READ_WRITE = 35002;
/*     */   public static final int GL_BUFFER_SIZE = 34660;
/*     */   public static final int GL_BUFFER_USAGE = 34661;
/*     */   public static final int GL_BUFFER_ACCESS = 35003;
/*     */   public static final int GL_BUFFER_MAPPED = 35004;
/*     */   public static final int GL_BUFFER_MAP_POINTER = 35005;
/*     */   public static final int GL_SAMPLES_PASSED = 35092;
/*     */   public static final int GL_QUERY_COUNTER_BITS = 34916;
/*     */   public static final int GL_CURRENT_QUERY = 34917;
/*     */   public static final int GL_QUERY_RESULT = 34918;
/*     */   public static final int GL_QUERY_RESULT_AVAILABLE = 34919;
/*     */   
/*     */   protected GL15() {
/*  90 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glBindBuffer(@NativeType("GLenum") int target, @NativeType("GLuint") int buffer) {
/*  97 */     GL15C.glBindBuffer(target, buffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglDeleteBuffers(int n, long buffers) {
/* 104 */     GL15C.nglDeleteBuffers(n, buffers);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDeleteBuffers(@NativeType("GLuint const *") IntBuffer buffers) {
/* 109 */     GL15C.glDeleteBuffers(buffers);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDeleteBuffers(@NativeType("GLuint const *") int buffer) {
/* 114 */     GL15C.glDeleteBuffers(buffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGenBuffers(int n, long buffers) {
/* 121 */     GL15C.nglGenBuffers(n, buffers);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGenBuffers(@NativeType("GLuint *") IntBuffer buffers) {
/* 126 */     GL15C.glGenBuffers(buffers);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGenBuffers() {
/* 132 */     return GL15C.glGenBuffers();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("GLboolean")
/*     */   public static boolean glIsBuffer(@NativeType("GLuint") int buffer) {
/* 140 */     return GL15C.glIsBuffer(buffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglBufferData(int target, long size, long data, int usage) {
/* 147 */     GL15C.nglBufferData(target, size, data, usage);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferData(@NativeType("GLenum") int target, @NativeType("GLsizeiptr") long size, @NativeType("GLenum") int usage) {
/* 152 */     GL15C.glBufferData(target, size, usage);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferData(@NativeType("GLenum") int target, @NativeType("void const *") ByteBuffer data, @NativeType("GLenum") int usage) {
/* 157 */     GL15C.glBufferData(target, data, usage);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferData(@NativeType("GLenum") int target, @NativeType("void const *") ShortBuffer data, @NativeType("GLenum") int usage) {
/* 162 */     GL15C.glBufferData(target, data, usage);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferData(@NativeType("GLenum") int target, @NativeType("void const *") IntBuffer data, @NativeType("GLenum") int usage) {
/* 167 */     GL15C.glBufferData(target, data, usage);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferData(@NativeType("GLenum") int target, @NativeType("void const *") LongBuffer data, @NativeType("GLenum") int usage) {
/* 172 */     GL15C.glBufferData(target, data, usage);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferData(@NativeType("GLenum") int target, @NativeType("void const *") FloatBuffer data, @NativeType("GLenum") int usage) {
/* 177 */     GL15C.glBufferData(target, data, usage);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferData(@NativeType("GLenum") int target, @NativeType("void const *") DoubleBuffer data, @NativeType("GLenum") int usage) {
/* 182 */     GL15C.glBufferData(target, data, usage);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglBufferSubData(int target, long offset, long size, long data) {
/* 189 */     GL15C.nglBufferSubData(target, offset, size, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferSubData(@NativeType("GLenum") int target, @NativeType("GLintptr") long offset, @NativeType("void const *") ByteBuffer data) {
/* 194 */     GL15C.glBufferSubData(target, offset, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferSubData(@NativeType("GLenum") int target, @NativeType("GLintptr") long offset, @NativeType("void const *") ShortBuffer data) {
/* 199 */     GL15C.glBufferSubData(target, offset, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferSubData(@NativeType("GLenum") int target, @NativeType("GLintptr") long offset, @NativeType("void const *") IntBuffer data) {
/* 204 */     GL15C.glBufferSubData(target, offset, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferSubData(@NativeType("GLenum") int target, @NativeType("GLintptr") long offset, @NativeType("void const *") LongBuffer data) {
/* 209 */     GL15C.glBufferSubData(target, offset, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferSubData(@NativeType("GLenum") int target, @NativeType("GLintptr") long offset, @NativeType("void const *") FloatBuffer data) {
/* 214 */     GL15C.glBufferSubData(target, offset, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferSubData(@NativeType("GLenum") int target, @NativeType("GLintptr") long offset, @NativeType("void const *") DoubleBuffer data) {
/* 219 */     GL15C.glBufferSubData(target, offset, data);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetBufferSubData(int target, long offset, long size, long data) {
/* 226 */     GL15C.nglGetBufferSubData(target, offset, size, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetBufferSubData(@NativeType("GLenum") int target, @NativeType("GLintptr") long offset, @NativeType("void *") ByteBuffer data) {
/* 231 */     GL15C.glGetBufferSubData(target, offset, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetBufferSubData(@NativeType("GLenum") int target, @NativeType("GLintptr") long offset, @NativeType("void *") ShortBuffer data) {
/* 236 */     GL15C.glGetBufferSubData(target, offset, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetBufferSubData(@NativeType("GLenum") int target, @NativeType("GLintptr") long offset, @NativeType("void *") IntBuffer data) {
/* 241 */     GL15C.glGetBufferSubData(target, offset, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetBufferSubData(@NativeType("GLenum") int target, @NativeType("GLintptr") long offset, @NativeType("void *") LongBuffer data) {
/* 246 */     GL15C.glGetBufferSubData(target, offset, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetBufferSubData(@NativeType("GLenum") int target, @NativeType("GLintptr") long offset, @NativeType("void *") FloatBuffer data) {
/* 251 */     GL15C.glGetBufferSubData(target, offset, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetBufferSubData(@NativeType("GLenum") int target, @NativeType("GLintptr") long offset, @NativeType("void *") DoubleBuffer data) {
/* 256 */     GL15C.glGetBufferSubData(target, offset, data);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nglMapBuffer(int target, int access) {
/* 263 */     return GL15C.nglMapBuffer(target, access);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static ByteBuffer glMapBuffer(@NativeType("GLenum") int target, @NativeType("GLenum") int access) {
/* 269 */     return GL15C.glMapBuffer(target, access);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static ByteBuffer glMapBuffer(@NativeType("GLenum") int target, @NativeType("GLenum") int access, ByteBuffer old_buffer) {
/* 275 */     return GL15C.glMapBuffer(target, access, old_buffer);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static ByteBuffer glMapBuffer(@NativeType("GLenum") int target, @NativeType("GLenum") int access, long length, ByteBuffer old_buffer) {
/* 281 */     return GL15C.glMapBuffer(target, access, length, old_buffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("GLboolean")
/*     */   public static boolean glUnmapBuffer(@NativeType("GLenum") int target) {
/* 289 */     return GL15C.glUnmapBuffer(target);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetBufferParameteriv(int target, int pname, long params) {
/* 296 */     GL15C.nglGetBufferParameteriv(target, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetBufferParameteriv(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/* 301 */     GL15C.glGetBufferParameteriv(target, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetBufferParameteri(@NativeType("GLenum") int target, @NativeType("GLenum") int pname) {
/* 307 */     return GL15C.glGetBufferParameteri(target, pname);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetBufferPointerv(int target, int pname, long params) {
/* 314 */     GL15C.nglGetBufferPointerv(target, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetBufferPointerv(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("void **") PointerBuffer params) {
/* 319 */     GL15C.glGetBufferPointerv(target, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static long glGetBufferPointer(@NativeType("GLenum") int target, @NativeType("GLenum") int pname) {
/* 325 */     return GL15C.glGetBufferPointer(target, pname);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGenQueries(int n, long ids) {
/* 332 */     GL15C.nglGenQueries(n, ids);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGenQueries(@NativeType("GLuint *") IntBuffer ids) {
/* 337 */     GL15C.glGenQueries(ids);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGenQueries() {
/* 343 */     return GL15C.glGenQueries();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglDeleteQueries(int n, long ids) {
/* 350 */     GL15C.nglDeleteQueries(n, ids);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDeleteQueries(@NativeType("GLuint const *") IntBuffer ids) {
/* 355 */     GL15C.glDeleteQueries(ids);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDeleteQueries(@NativeType("GLuint const *") int id) {
/* 360 */     GL15C.glDeleteQueries(id);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("GLboolean")
/*     */   public static boolean glIsQuery(@NativeType("GLuint") int id) {
/* 368 */     return GL15C.glIsQuery(id);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glBeginQuery(@NativeType("GLenum") int target, @NativeType("GLuint") int id) {
/* 375 */     GL15C.glBeginQuery(target, id);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glEndQuery(@NativeType("GLenum") int target) {
/* 382 */     GL15C.glEndQuery(target);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetQueryiv(int target, int pname, long params) {
/* 389 */     GL15C.nglGetQueryiv(target, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetQueryiv(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/* 394 */     GL15C.glGetQueryiv(target, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetQueryi(@NativeType("GLenum") int target, @NativeType("GLenum") int pname) {
/* 400 */     return GL15C.glGetQueryi(target, pname);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetQueryObjectiv(int id, int pname, long params) {
/* 407 */     GL15C.nglGetQueryObjectiv(id, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetQueryObjectiv(@NativeType("GLuint") int id, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/* 412 */     GL15C.glGetQueryObjectiv(id, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetQueryObjectiv(@NativeType("GLuint") int id, @NativeType("GLenum") int pname, @NativeType("GLint *") long params) {
/* 417 */     GL15C.glGetQueryObjectiv(id, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetQueryObjecti(@NativeType("GLuint") int id, @NativeType("GLenum") int pname) {
/* 423 */     return GL15C.glGetQueryObjecti(id, pname);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetQueryObjectuiv(int id, int pname, long params) {
/* 430 */     GL15C.nglGetQueryObjectuiv(id, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetQueryObjectuiv(@NativeType("GLuint") int id, @NativeType("GLenum") int pname, @NativeType("GLuint *") IntBuffer params) {
/* 435 */     GL15C.glGetQueryObjectuiv(id, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetQueryObjectuiv(@NativeType("GLuint") int id, @NativeType("GLenum") int pname, @NativeType("GLuint *") long params) {
/* 440 */     GL15C.glGetQueryObjectuiv(id, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetQueryObjectui(@NativeType("GLuint") int id, @NativeType("GLenum") int pname) {
/* 446 */     return GL15C.glGetQueryObjectui(id, pname);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDeleteBuffers(@NativeType("GLuint const *") int[] buffers) {
/* 451 */     GL15C.glDeleteBuffers(buffers);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGenBuffers(@NativeType("GLuint *") int[] buffers) {
/* 456 */     GL15C.glGenBuffers(buffers);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferData(@NativeType("GLenum") int target, @NativeType("void const *") short[] data, @NativeType("GLenum") int usage) {
/* 461 */     GL15C.glBufferData(target, data, usage);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferData(@NativeType("GLenum") int target, @NativeType("void const *") int[] data, @NativeType("GLenum") int usage) {
/* 466 */     GL15C.glBufferData(target, data, usage);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferData(@NativeType("GLenum") int target, @NativeType("void const *") long[] data, @NativeType("GLenum") int usage) {
/* 471 */     GL15C.glBufferData(target, data, usage);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferData(@NativeType("GLenum") int target, @NativeType("void const *") float[] data, @NativeType("GLenum") int usage) {
/* 476 */     GL15C.glBufferData(target, data, usage);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferData(@NativeType("GLenum") int target, @NativeType("void const *") double[] data, @NativeType("GLenum") int usage) {
/* 481 */     GL15C.glBufferData(target, data, usage);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferSubData(@NativeType("GLenum") int target, @NativeType("GLintptr") long offset, @NativeType("void const *") short[] data) {
/* 486 */     GL15C.glBufferSubData(target, offset, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferSubData(@NativeType("GLenum") int target, @NativeType("GLintptr") long offset, @NativeType("void const *") int[] data) {
/* 491 */     GL15C.glBufferSubData(target, offset, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferSubData(@NativeType("GLenum") int target, @NativeType("GLintptr") long offset, @NativeType("void const *") long[] data) {
/* 496 */     GL15C.glBufferSubData(target, offset, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferSubData(@NativeType("GLenum") int target, @NativeType("GLintptr") long offset, @NativeType("void const *") float[] data) {
/* 501 */     GL15C.glBufferSubData(target, offset, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferSubData(@NativeType("GLenum") int target, @NativeType("GLintptr") long offset, @NativeType("void const *") double[] data) {
/* 506 */     GL15C.glBufferSubData(target, offset, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetBufferSubData(@NativeType("GLenum") int target, @NativeType("GLintptr") long offset, @NativeType("void *") short[] data) {
/* 511 */     GL15C.glGetBufferSubData(target, offset, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetBufferSubData(@NativeType("GLenum") int target, @NativeType("GLintptr") long offset, @NativeType("void *") int[] data) {
/* 516 */     GL15C.glGetBufferSubData(target, offset, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetBufferSubData(@NativeType("GLenum") int target, @NativeType("GLintptr") long offset, @NativeType("void *") long[] data) {
/* 521 */     GL15C.glGetBufferSubData(target, offset, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetBufferSubData(@NativeType("GLenum") int target, @NativeType("GLintptr") long offset, @NativeType("void *") float[] data) {
/* 526 */     GL15C.glGetBufferSubData(target, offset, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetBufferSubData(@NativeType("GLenum") int target, @NativeType("GLintptr") long offset, @NativeType("void *") double[] data) {
/* 531 */     GL15C.glGetBufferSubData(target, offset, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetBufferParameteriv(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 536 */     GL15C.glGetBufferParameteriv(target, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGenQueries(@NativeType("GLuint *") int[] ids) {
/* 541 */     GL15C.glGenQueries(ids);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDeleteQueries(@NativeType("GLuint const *") int[] ids) {
/* 546 */     GL15C.glDeleteQueries(ids);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetQueryiv(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 551 */     GL15C.glGetQueryiv(target, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetQueryObjectiv(@NativeType("GLuint") int id, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 556 */     GL15C.glGetQueryObjectiv(id, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetQueryObjectuiv(@NativeType("GLuint") int id, @NativeType("GLenum") int pname, @NativeType("GLuint *") int[] params) {
/* 561 */     GL15C.glGetQueryObjectuiv(id, pname, params);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\GL15.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */