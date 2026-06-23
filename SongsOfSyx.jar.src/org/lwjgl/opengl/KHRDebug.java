/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ 
/*     */ public class KHRDebug
/*     */ {
/*     */   public static final int GL_DEBUG_OUTPUT = 37600;
/*     */   public static final int GL_DEBUG_OUTPUT_SYNCHRONOUS = 33346;
/*     */   public static final int GL_CONTEXT_FLAG_DEBUG_BIT = 2;
/*     */   public static final int GL_MAX_DEBUG_MESSAGE_LENGTH = 37187;
/*     */   
/*     */   static {
/*  16 */     GL.initialize();
/*     */   }
/*     */ 
/*     */   
/*     */   public static final int GL_MAX_DEBUG_LOGGED_MESSAGES = 37188;
/*     */   
/*     */   public static final int GL_DEBUG_LOGGED_MESSAGES = 37189;
/*     */   
/*     */   public static final int GL_DEBUG_NEXT_LOGGED_MESSAGE_LENGTH = 33347;
/*     */   
/*     */   public static final int GL_MAX_DEBUG_GROUP_STACK_DEPTH = 33388;
/*     */   
/*     */   public static final int GL_DEBUG_GROUP_STACK_DEPTH = 33389;
/*     */   
/*     */   public static final int GL_MAX_LABEL_LENGTH = 33512;
/*     */   
/*     */   public static final int GL_DEBUG_CALLBACK_FUNCTION = 33348;
/*     */   
/*     */   public static final int GL_DEBUG_CALLBACK_USER_PARAM = 33349;
/*     */   
/*     */   public static final int GL_DEBUG_SOURCE_API = 33350;
/*     */   
/*     */   public static final int GL_DEBUG_SOURCE_WINDOW_SYSTEM = 33351;
/*     */   
/*     */   public static final int GL_DEBUG_SOURCE_SHADER_COMPILER = 33352;
/*     */   
/*     */   public static final int GL_DEBUG_SOURCE_THIRD_PARTY = 33353;
/*     */   
/*     */   public static final int GL_DEBUG_SOURCE_APPLICATION = 33354;
/*     */   
/*     */   public static final int GL_DEBUG_SOURCE_OTHER = 33355;
/*     */   
/*     */   public static final int GL_DEBUG_TYPE_ERROR = 33356;
/*     */   
/*     */   public static final int GL_DEBUG_TYPE_DEPRECATED_BEHAVIOR = 33357;
/*     */   
/*     */   public static final int GL_DEBUG_TYPE_UNDEFINED_BEHAVIOR = 33358;
/*     */   
/*     */   public static final int GL_DEBUG_TYPE_PORTABILITY = 33359;
/*     */   
/*     */   public static final int GL_DEBUG_TYPE_PERFORMANCE = 33360;
/*     */   public static final int GL_DEBUG_TYPE_OTHER = 33361;
/*     */   public static final int GL_DEBUG_TYPE_MARKER = 33384;
/*     */   public static final int GL_DEBUG_TYPE_PUSH_GROUP = 33385;
/*     */   public static final int GL_DEBUG_TYPE_POP_GROUP = 33386;
/*     */   public static final int GL_DEBUG_SEVERITY_HIGH = 37190;
/*     */   public static final int GL_DEBUG_SEVERITY_MEDIUM = 37191;
/*     */   public static final int GL_DEBUG_SEVERITY_LOW = 37192;
/*     */   public static final int GL_DEBUG_SEVERITY_NOTIFICATION = 33387;
/*     */   public static final int GL_BUFFER = 33504;
/*     */   public static final int GL_SHADER = 33505;
/*     */   public static final int GL_PROGRAM = 33506;
/*     */   public static final int GL_QUERY = 33507;
/*     */   public static final int GL_PROGRAM_PIPELINE = 33508;
/*     */   public static final int GL_SAMPLER = 33510;
/*     */   public static final int GL_DISPLAY_LIST = 33511;
/*     */   
/*     */   protected KHRDebug() {
/*  74 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglDebugMessageControl(int source, int type, int severity, int count, long ids, boolean enabled) {
/*  81 */     GL43C.nglDebugMessageControl(source, type, severity, count, ids, enabled);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDebugMessageControl(@NativeType("GLenum") int source, @NativeType("GLenum") int type, @NativeType("GLenum") int severity, @NativeType("GLuint const *") IntBuffer ids, @NativeType("GLboolean") boolean enabled) {
/*  86 */     GL43C.glDebugMessageControl(source, type, severity, ids, enabled);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDebugMessageControl(@NativeType("GLenum") int source, @NativeType("GLenum") int type, @NativeType("GLenum") int severity, @NativeType("GLuint const *") int id, @NativeType("GLboolean") boolean enabled) {
/*  91 */     GL43C.glDebugMessageControl(source, type, severity, id, enabled);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglDebugMessageInsert(int source, int type, int id, int severity, int length, long message) {
/*  98 */     GL43C.nglDebugMessageInsert(source, type, id, severity, length, message);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDebugMessageInsert(@NativeType("GLenum") int source, @NativeType("GLenum") int type, @NativeType("GLuint") int id, @NativeType("GLenum") int severity, @NativeType("GLchar const *") ByteBuffer message) {
/* 103 */     GL43C.glDebugMessageInsert(source, type, id, severity, message);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDebugMessageInsert(@NativeType("GLenum") int source, @NativeType("GLenum") int type, @NativeType("GLuint") int id, @NativeType("GLenum") int severity, @NativeType("GLchar const *") CharSequence message) {
/* 108 */     GL43C.glDebugMessageInsert(source, type, id, severity, message);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglDebugMessageCallback(long callback, long userParam) {
/* 115 */     GL43C.nglDebugMessageCallback(callback, userParam);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDebugMessageCallback(@NativeType("GLDEBUGPROC") GLDebugMessageCallbackI callback, @NativeType("void const *") long userParam) {
/* 120 */     GL43C.glDebugMessageCallback(callback, userParam);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nglGetDebugMessageLog(int count, int bufsize, long sources, long types, long ids, long severities, long lengths, long messageLog) {
/* 127 */     return GL43C.nglGetDebugMessageLog(count, bufsize, sources, types, ids, severities, lengths, messageLog);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("GLuint")
/*     */   public static int glGetDebugMessageLog(@NativeType("GLuint") int count, @NativeType("GLenum *") IntBuffer sources, @NativeType("GLenum *") IntBuffer types, @NativeType("GLuint *") IntBuffer ids, @NativeType("GLenum *") IntBuffer severities, @NativeType("GLsizei *") IntBuffer lengths, @NativeType("GLchar *") ByteBuffer messageLog) {
/* 133 */     return GL43C.glGetDebugMessageLog(count, sources, types, ids, severities, lengths, messageLog);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglPushDebugGroup(int source, int id, int length, long message) {
/* 140 */     GL43C.nglPushDebugGroup(source, id, length, message);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glPushDebugGroup(@NativeType("GLenum") int source, @NativeType("GLuint") int id, @NativeType("GLchar const *") ByteBuffer message) {
/* 145 */     GL43C.glPushDebugGroup(source, id, message);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glPushDebugGroup(@NativeType("GLenum") int source, @NativeType("GLuint") int id, @NativeType("GLchar const *") CharSequence message) {
/* 150 */     GL43C.glPushDebugGroup(source, id, message);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glPopDebugGroup() {
/* 157 */     GL43C.glPopDebugGroup();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglObjectLabel(int identifier, int name, int length, long label) {
/* 164 */     GL43C.nglObjectLabel(identifier, name, length, label);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glObjectLabel(@NativeType("GLenum") int identifier, @NativeType("GLuint") int name, @NativeType("GLchar const *") ByteBuffer label) {
/* 169 */     GL43C.glObjectLabel(identifier, name, label);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glObjectLabel(@NativeType("GLenum") int identifier, @NativeType("GLuint") int name, @NativeType("GLchar const *") CharSequence label) {
/* 174 */     GL43C.glObjectLabel(identifier, name, label);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetObjectLabel(int identifier, int name, int bufSize, long length, long label) {
/* 181 */     GL43C.nglGetObjectLabel(identifier, name, bufSize, length, label);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetObjectLabel(@NativeType("GLenum") int identifier, @NativeType("GLuint") int name, @NativeType("GLsizei *") IntBuffer length, @NativeType("GLchar *") ByteBuffer label) {
/* 186 */     GL43C.glGetObjectLabel(identifier, name, length, label);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static String glGetObjectLabel(@NativeType("GLenum") int identifier, @NativeType("GLuint") int name, @NativeType("GLsizei") int bufSize) {
/* 192 */     return GL43C.glGetObjectLabel(identifier, name, bufSize);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static String glGetObjectLabel(@NativeType("GLenum") int identifier, @NativeType("GLuint") int name) {
/* 198 */     return glGetObjectLabel(identifier, name, GL11.glGetInteger(33512));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglObjectPtrLabel(long ptr, int length, long label) {
/* 205 */     GL43C.nglObjectPtrLabel(ptr, length, label);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glObjectPtrLabel(@NativeType("void *") long ptr, @NativeType("GLchar const *") ByteBuffer label) {
/* 210 */     GL43C.glObjectPtrLabel(ptr, label);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glObjectPtrLabel(@NativeType("void *") long ptr, @NativeType("GLchar const *") CharSequence label) {
/* 215 */     GL43C.glObjectPtrLabel(ptr, label);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetObjectPtrLabel(long ptr, int bufSize, long length, long label) {
/* 222 */     GL43C.nglGetObjectPtrLabel(ptr, bufSize, length, label);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetObjectPtrLabel(@NativeType("void *") long ptr, @NativeType("GLsizei *") IntBuffer length, @NativeType("GLchar *") ByteBuffer label) {
/* 227 */     GL43C.glGetObjectPtrLabel(ptr, length, label);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static String glGetObjectPtrLabel(@NativeType("void *") long ptr, @NativeType("GLsizei") int bufSize) {
/* 233 */     return GL43C.glGetObjectPtrLabel(ptr, bufSize);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static String glGetObjectPtrLabel(@NativeType("void *") long ptr) {
/* 239 */     return glGetObjectPtrLabel(ptr, GL11.glGetInteger(33512));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDebugMessageControl(@NativeType("GLenum") int source, @NativeType("GLenum") int type, @NativeType("GLenum") int severity, @NativeType("GLuint const *") int[] ids, @NativeType("GLboolean") boolean enabled) {
/* 244 */     GL43C.glDebugMessageControl(source, type, severity, ids, enabled);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("GLuint")
/*     */   public static int glGetDebugMessageLog(@NativeType("GLuint") int count, @NativeType("GLenum *") int[] sources, @NativeType("GLenum *") int[] types, @NativeType("GLuint *") int[] ids, @NativeType("GLenum *") int[] severities, @NativeType("GLsizei *") int[] lengths, @NativeType("GLchar *") ByteBuffer messageLog) {
/* 250 */     return GL43C.glGetDebugMessageLog(count, sources, types, ids, severities, lengths, messageLog);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetObjectLabel(@NativeType("GLenum") int identifier, @NativeType("GLuint") int name, @NativeType("GLsizei *") int[] length, @NativeType("GLchar *") ByteBuffer label) {
/* 255 */     GL43C.glGetObjectLabel(identifier, name, length, label);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetObjectPtrLabel(@NativeType("void *") long ptr, @NativeType("GLsizei *") int[] length, @NativeType("GLchar *") ByteBuffer label) {
/* 260 */     GL43C.glGetObjectPtrLabel(ptr, length, label);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\KHRDebug.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */