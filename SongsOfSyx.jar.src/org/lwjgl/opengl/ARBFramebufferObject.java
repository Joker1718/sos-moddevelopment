/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.IntBuffer;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ public class ARBFramebufferObject
/*     */ {
/*     */   public static final int GL_FRAMEBUFFER = 36160;
/*     */   public static final int GL_READ_FRAMEBUFFER = 36008;
/*     */   public static final int GL_DRAW_FRAMEBUFFER = 36009;
/*     */   public static final int GL_RENDERBUFFER = 36161;
/*     */   
/*     */   static {
/*  14 */     GL.initialize();
/*     */   }
/*     */ 
/*     */   
/*     */   public static final int GL_STENCIL_INDEX1 = 36166;
/*     */   
/*     */   public static final int GL_STENCIL_INDEX4 = 36167;
/*     */   
/*     */   public static final int GL_STENCIL_INDEX8 = 36168;
/*     */   
/*     */   public static final int GL_STENCIL_INDEX16 = 36169;
/*     */   
/*     */   public static final int GL_RENDERBUFFER_WIDTH = 36162;
/*     */   
/*     */   public static final int GL_RENDERBUFFER_HEIGHT = 36163;
/*     */   
/*     */   public static final int GL_RENDERBUFFER_INTERNAL_FORMAT = 36164;
/*     */   
/*     */   public static final int GL_RENDERBUFFER_RED_SIZE = 36176;
/*     */   
/*     */   public static final int GL_RENDERBUFFER_GREEN_SIZE = 36177;
/*     */   
/*     */   public static final int GL_RENDERBUFFER_BLUE_SIZE = 36178;
/*     */   
/*     */   public static final int GL_RENDERBUFFER_ALPHA_SIZE = 36179;
/*     */   
/*     */   public static final int GL_RENDERBUFFER_DEPTH_SIZE = 36180;
/*     */   
/*     */   public static final int GL_RENDERBUFFER_STENCIL_SIZE = 36181;
/*     */   
/*     */   public static final int GL_RENDERBUFFER_SAMPLES = 36011;
/*     */   
/*     */   public static final int GL_FRAMEBUFFER_ATTACHMENT_OBJECT_TYPE = 36048;
/*     */   
/*     */   public static final int GL_FRAMEBUFFER_ATTACHMENT_OBJECT_NAME = 36049;
/*     */   
/*     */   public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_LEVEL = 36050;
/*     */   
/*     */   public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_CUBE_MAP_FACE = 36051;
/*     */   
/*     */   public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_LAYER = 36052;
/*     */   
/*     */   public static final int GL_FRAMEBUFFER_ATTACHMENT_COLOR_ENCODING = 33296;
/*     */   
/*     */   public static final int GL_FRAMEBUFFER_ATTACHMENT_COMPONENT_TYPE = 33297;
/*     */   
/*     */   public static final int GL_FRAMEBUFFER_ATTACHMENT_RED_SIZE = 33298;
/*     */   
/*     */   public static final int GL_FRAMEBUFFER_ATTACHMENT_GREEN_SIZE = 33299;
/*     */   
/*     */   public static final int GL_FRAMEBUFFER_ATTACHMENT_BLUE_SIZE = 33300;
/*     */   
/*     */   public static final int GL_FRAMEBUFFER_ATTACHMENT_ALPHA_SIZE = 33301;
/*     */   public static final int GL_FRAMEBUFFER_ATTACHMENT_DEPTH_SIZE = 33302;
/*     */   public static final int GL_FRAMEBUFFER_ATTACHMENT_STENCIL_SIZE = 33303;
/*     */   public static final int GL_UNSIGNED_NORMALIZED = 35863;
/*     */   public static final int GL_FRAMEBUFFER_DEFAULT = 33304;
/*     */   public static final int GL_INDEX = 33314;
/*     */   public static final int GL_COLOR_ATTACHMENT0 = 36064;
/*     */   public static final int GL_COLOR_ATTACHMENT1 = 36065;
/*     */   public static final int GL_COLOR_ATTACHMENT2 = 36066;
/*     */   public static final int GL_COLOR_ATTACHMENT3 = 36067;
/*     */   public static final int GL_COLOR_ATTACHMENT4 = 36068;
/*     */   public static final int GL_COLOR_ATTACHMENT5 = 36069;
/*     */   public static final int GL_COLOR_ATTACHMENT6 = 36070;
/*     */   public static final int GL_COLOR_ATTACHMENT7 = 36071;
/*     */   public static final int GL_COLOR_ATTACHMENT8 = 36072;
/*     */   public static final int GL_COLOR_ATTACHMENT9 = 36073;
/*     */   public static final int GL_COLOR_ATTACHMENT10 = 36074;
/*     */   public static final int GL_COLOR_ATTACHMENT11 = 36075;
/*     */   public static final int GL_COLOR_ATTACHMENT12 = 36076;
/*     */   public static final int GL_COLOR_ATTACHMENT13 = 36077;
/*     */   public static final int GL_COLOR_ATTACHMENT14 = 36078;
/*     */   public static final int GL_COLOR_ATTACHMENT15 = 36079;
/*     */   public static final int GL_DEPTH_ATTACHMENT = 36096;
/*     */   public static final int GL_STENCIL_ATTACHMENT = 36128;
/*     */   public static final int GL_DEPTH_STENCIL_ATTACHMENT = 33306;
/*     */   public static final int GL_MAX_SAMPLES = 36183;
/*     */   public static final int GL_FRAMEBUFFER_COMPLETE = 36053;
/*     */   public static final int GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT = 36054;
/*     */   public static final int GL_FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT = 36055;
/*     */   public static final int GL_FRAMEBUFFER_INCOMPLETE_DRAW_BUFFER = 36059;
/*     */   public static final int GL_FRAMEBUFFER_INCOMPLETE_READ_BUFFER = 36060;
/*     */   public static final int GL_FRAMEBUFFER_UNSUPPORTED = 36061;
/*     */   public static final int GL_FRAMEBUFFER_INCOMPLETE_MULTISAMPLE = 36182;
/*     */   public static final int GL_FRAMEBUFFER_UNDEFINED = 33305;
/*     */   public static final int GL_FRAMEBUFFER_BINDING = 36006;
/*     */   public static final int GL_DRAW_FRAMEBUFFER_BINDING = 36006;
/*     */   public static final int GL_READ_FRAMEBUFFER_BINDING = 36010;
/*     */   public static final int GL_RENDERBUFFER_BINDING = 36007;
/*     */   public static final int GL_MAX_COLOR_ATTACHMENTS = 36063;
/*     */   public static final int GL_MAX_RENDERBUFFER_SIZE = 34024;
/*     */   public static final int GL_INVALID_FRAMEBUFFER_OPERATION = 1286;
/*     */   public static final int GL_DEPTH_STENCIL = 34041;
/*     */   public static final int GL_UNSIGNED_INT_24_8 = 34042;
/*     */   public static final int GL_DEPTH24_STENCIL8 = 35056;
/*     */   public static final int GL_TEXTURE_STENCIL_SIZE = 35057;
/*     */   
/*     */   protected ARBFramebufferObject() {
/* 113 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("GLboolean")
/*     */   public static boolean glIsRenderbuffer(@NativeType("GLuint") int renderbuffer) {
/* 121 */     return GL30C.glIsRenderbuffer(renderbuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glBindRenderbuffer(@NativeType("GLenum") int target, @NativeType("GLuint") int renderbuffer) {
/* 128 */     GL30C.glBindRenderbuffer(target, renderbuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglDeleteRenderbuffers(int n, long renderbuffers) {
/* 135 */     GL30C.nglDeleteRenderbuffers(n, renderbuffers);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDeleteRenderbuffers(@NativeType("GLuint const *") IntBuffer renderbuffers) {
/* 140 */     GL30C.glDeleteRenderbuffers(renderbuffers);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDeleteRenderbuffers(@NativeType("GLuint const *") int renderbuffer) {
/* 145 */     GL30C.glDeleteRenderbuffers(renderbuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGenRenderbuffers(int n, long renderbuffers) {
/* 152 */     GL30C.nglGenRenderbuffers(n, renderbuffers);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGenRenderbuffers(@NativeType("GLuint *") IntBuffer renderbuffers) {
/* 157 */     GL30C.glGenRenderbuffers(renderbuffers);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGenRenderbuffers() {
/* 163 */     return GL30C.glGenRenderbuffers();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glRenderbufferStorage(@NativeType("GLenum") int target, @NativeType("GLenum") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height) {
/* 170 */     GL30C.glRenderbufferStorage(target, internalformat, width, height);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glRenderbufferStorageMultisample(@NativeType("GLenum") int target, @NativeType("GLsizei") int samples, @NativeType("GLenum") int internalformat, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height) {
/* 177 */     GL30C.glRenderbufferStorageMultisample(target, samples, internalformat, width, height);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetRenderbufferParameteriv(int target, int pname, long params) {
/* 184 */     GL30C.nglGetRenderbufferParameteriv(target, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetRenderbufferParameteriv(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/* 189 */     GL30C.glGetRenderbufferParameteriv(target, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetRenderbufferParameteri(@NativeType("GLenum") int target, @NativeType("GLenum") int pname) {
/* 195 */     return GL30C.glGetRenderbufferParameteri(target, pname);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("GLboolean")
/*     */   public static boolean glIsFramebuffer(@NativeType("GLuint") int framebuffer) {
/* 203 */     return GL30C.glIsFramebuffer(framebuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glBindFramebuffer(@NativeType("GLenum") int target, @NativeType("GLuint") int framebuffer) {
/* 210 */     GL30C.glBindFramebuffer(target, framebuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglDeleteFramebuffers(int n, long framebuffers) {
/* 217 */     GL30C.nglDeleteFramebuffers(n, framebuffers);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDeleteFramebuffers(@NativeType("GLuint const *") IntBuffer framebuffers) {
/* 222 */     GL30C.glDeleteFramebuffers(framebuffers);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDeleteFramebuffers(@NativeType("GLuint const *") int framebuffer) {
/* 227 */     GL30C.glDeleteFramebuffers(framebuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGenFramebuffers(int n, long framebuffers) {
/* 234 */     GL30C.nglGenFramebuffers(n, framebuffers);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGenFramebuffers(@NativeType("GLuint *") IntBuffer framebuffers) {
/* 239 */     GL30C.glGenFramebuffers(framebuffers);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGenFramebuffers() {
/* 245 */     return GL30C.glGenFramebuffers();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("GLenum")
/*     */   public static int glCheckFramebufferStatus(@NativeType("GLenum") int target) {
/* 253 */     return GL30C.glCheckFramebufferStatus(target);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glFramebufferTexture1D(@NativeType("GLenum") int target, @NativeType("GLenum") int attachment, @NativeType("GLenum") int textarget, @NativeType("GLuint") int texture, @NativeType("GLint") int level) {
/* 260 */     GL30C.glFramebufferTexture1D(target, attachment, textarget, texture, level);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glFramebufferTexture2D(@NativeType("GLenum") int target, @NativeType("GLenum") int attachment, @NativeType("GLenum") int textarget, @NativeType("GLuint") int texture, @NativeType("GLint") int level) {
/* 267 */     GL30C.glFramebufferTexture2D(target, attachment, textarget, texture, level);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glFramebufferTexture3D(@NativeType("GLenum") int target, @NativeType("GLenum") int attachment, @NativeType("GLenum") int textarget, @NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int layer) {
/* 274 */     GL30C.glFramebufferTexture3D(target, attachment, textarget, texture, level, layer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glFramebufferTextureLayer(@NativeType("GLenum") int target, @NativeType("GLenum") int attachment, @NativeType("GLuint") int texture, @NativeType("GLint") int level, @NativeType("GLint") int layer) {
/* 281 */     GL30C.glFramebufferTextureLayer(target, attachment, texture, level, layer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glFramebufferRenderbuffer(@NativeType("GLenum") int target, @NativeType("GLenum") int attachment, @NativeType("GLenum") int renderbuffertarget, @NativeType("GLuint") int renderbuffer) {
/* 288 */     GL30C.glFramebufferRenderbuffer(target, attachment, renderbuffertarget, renderbuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetFramebufferAttachmentParameteriv(int target, int attachment, int pname, long params) {
/* 295 */     GL30C.nglGetFramebufferAttachmentParameteriv(target, attachment, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetFramebufferAttachmentParameteriv(@NativeType("GLenum") int target, @NativeType("GLenum") int attachment, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/* 300 */     GL30C.glGetFramebufferAttachmentParameteriv(target, attachment, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetFramebufferAttachmentParameteri(@NativeType("GLenum") int target, @NativeType("GLenum") int attachment, @NativeType("GLenum") int pname) {
/* 306 */     return GL30C.glGetFramebufferAttachmentParameteri(target, attachment, pname);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glBlitFramebuffer(@NativeType("GLint") int srcX0, @NativeType("GLint") int srcY0, @NativeType("GLint") int srcX1, @NativeType("GLint") int srcY1, @NativeType("GLint") int dstX0, @NativeType("GLint") int dstY0, @NativeType("GLint") int dstX1, @NativeType("GLint") int dstY1, @NativeType("GLbitfield") int mask, @NativeType("GLenum") int filter) {
/* 313 */     GL30C.glBlitFramebuffer(srcX0, srcY0, srcX1, srcY1, dstX0, dstY0, dstX1, dstY1, mask, filter);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGenerateMipmap(@NativeType("GLenum") int target) {
/* 320 */     GL30C.glGenerateMipmap(target);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDeleteRenderbuffers(@NativeType("GLuint const *") int[] renderbuffers) {
/* 325 */     GL30C.glDeleteRenderbuffers(renderbuffers);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGenRenderbuffers(@NativeType("GLuint *") int[] renderbuffers) {
/* 330 */     GL30C.glGenRenderbuffers(renderbuffers);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetRenderbufferParameteriv(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 335 */     GL30C.glGetRenderbufferParameteriv(target, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDeleteFramebuffers(@NativeType("GLuint const *") int[] framebuffers) {
/* 340 */     GL30C.glDeleteFramebuffers(framebuffers);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGenFramebuffers(@NativeType("GLuint *") int[] framebuffers) {
/* 345 */     GL30C.glGenFramebuffers(framebuffers);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetFramebufferAttachmentParameteriv(@NativeType("GLenum") int target, @NativeType("GLenum") int attachment, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 350 */     GL30C.glGetFramebufferAttachmentParameteriv(target, attachment, pname, params);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\ARBFramebufferObject.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */