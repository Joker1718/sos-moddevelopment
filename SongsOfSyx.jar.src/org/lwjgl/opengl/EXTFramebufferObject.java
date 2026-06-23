/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.IntBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.MemoryStack;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ public class EXTFramebufferObject {
/*     */   public static final int GL_FRAMEBUFFER_EXT = 36160;
/*     */   public static final int GL_RENDERBUFFER_EXT = 36161;
/*     */   public static final int GL_STENCIL_INDEX1_EXT = 36166;
/*     */   public static final int GL_STENCIL_INDEX4_EXT = 36167;
/*     */   public static final int GL_STENCIL_INDEX8_EXT = 36168;
/*     */   public static final int GL_STENCIL_INDEX16_EXT = 36169;
/*     */   
/*     */   static {
/*  19 */     GL.initialize();
/*     */   }
/*     */ 
/*     */   
/*     */   public static final int GL_RENDERBUFFER_WIDTH_EXT = 36162;
/*     */   
/*     */   public static final int GL_RENDERBUFFER_HEIGHT_EXT = 36163;
/*     */   
/*     */   public static final int GL_RENDERBUFFER_INTERNAL_FORMAT_EXT = 36164;
/*     */   
/*     */   public static final int GL_RENDERBUFFER_RED_SIZE_EXT = 36176;
/*     */   
/*     */   public static final int GL_RENDERBUFFER_GREEN_SIZE_EXT = 36177;
/*     */   
/*     */   public static final int GL_RENDERBUFFER_BLUE_SIZE_EXT = 36178;
/*     */   
/*     */   public static final int GL_RENDERBUFFER_ALPHA_SIZE_EXT = 36179;
/*     */   
/*     */   public static final int GL_RENDERBUFFER_DEPTH_SIZE_EXT = 36180;
/*     */   
/*     */   public static final int GL_RENDERBUFFER_STENCIL_SIZE_EXT = 36181;
/*     */   
/*     */   public static final int GL_FRAMEBUFFER_ATTACHMENT_OBJECT_TYPE_EXT = 36048;
/*     */   
/*     */   public static final int GL_FRAMEBUFFER_ATTACHMENT_OBJECT_NAME_EXT = 36049;
/*     */   
/*     */   public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_LEVEL_EXT = 36050;
/*     */   
/*     */   public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_CUBE_MAP_FACE_EXT = 36051;
/*     */   
/*     */   public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_3D_ZOFFSET_EXT = 36052;
/*     */   
/*     */   public static final int GL_COLOR_ATTACHMENT0_EXT = 36064;
/*     */   
/*     */   public static final int GL_COLOR_ATTACHMENT1_EXT = 36065;
/*     */   
/*     */   public static final int GL_COLOR_ATTACHMENT2_EXT = 36066;
/*     */   
/*     */   public static final int GL_COLOR_ATTACHMENT3_EXT = 36067;
/*     */   
/*     */   public static final int GL_COLOR_ATTACHMENT4_EXT = 36068;
/*     */   public static final int GL_COLOR_ATTACHMENT5_EXT = 36069;
/*     */   public static final int GL_COLOR_ATTACHMENT6_EXT = 36070;
/*     */   public static final int GL_COLOR_ATTACHMENT7_EXT = 36071;
/*     */   public static final int GL_COLOR_ATTACHMENT8_EXT = 36072;
/*     */   public static final int GL_COLOR_ATTACHMENT9_EXT = 36073;
/*     */   public static final int GL_COLOR_ATTACHMENT10_EXT = 36074;
/*     */   public static final int GL_COLOR_ATTACHMENT11_EXT = 36075;
/*     */   public static final int GL_COLOR_ATTACHMENT12_EXT = 36076;
/*     */   public static final int GL_COLOR_ATTACHMENT13_EXT = 36077;
/*     */   public static final int GL_COLOR_ATTACHMENT14_EXT = 36078;
/*     */   public static final int GL_COLOR_ATTACHMENT15_EXT = 36079;
/*     */   public static final int GL_DEPTH_ATTACHMENT_EXT = 36096;
/*     */   public static final int GL_STENCIL_ATTACHMENT_EXT = 36128;
/*     */   public static final int GL_FRAMEBUFFER_COMPLETE_EXT = 36053;
/*     */   public static final int GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT_EXT = 36054;
/*     */   public static final int GL_FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT_EXT = 36055;
/*     */   public static final int GL_FRAMEBUFFER_INCOMPLETE_DIMENSIONS_EXT = 36057;
/*     */   public static final int GL_FRAMEBUFFER_INCOMPLETE_FORMATS_EXT = 36058;
/*     */   public static final int GL_FRAMEBUFFER_INCOMPLETE_DRAW_BUFFER_EXT = 36059;
/*     */   public static final int GL_FRAMEBUFFER_INCOMPLETE_READ_BUFFER_EXT = 36060;
/*     */   public static final int GL_FRAMEBUFFER_UNSUPPORTED_EXT = 36061;
/*     */   public static final int GL_FRAMEBUFFER_BINDING_EXT = 36006;
/*     */   public static final int GL_RENDERBUFFER_BINDING_EXT = 36007;
/*     */   public static final int GL_MAX_COLOR_ATTACHMENTS_EXT = 36063;
/*     */   public static final int GL_MAX_RENDERBUFFER_SIZE_EXT = 34024;
/*     */   public static final int GL_INVALID_FRAMEBUFFER_OPERATION_EXT = 1286;
/*     */   
/*     */   protected EXTFramebufferObject() {
/*  88 */     throw new UnsupportedOperationException();
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
/*     */   public static void glDeleteRenderbuffersEXT(@NativeType("GLuint const *") IntBuffer renderbuffers) {
/* 109 */     nglDeleteRenderbuffersEXT(renderbuffers.remaining(), MemoryUtil.memAddress(renderbuffers));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDeleteRenderbuffersEXT(@NativeType("GLuint const *") int renderbuffer) {
/* 114 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 116 */       IntBuffer renderbuffers = stack.ints(renderbuffer);
/* 117 */       nglDeleteRenderbuffersEXT(1, MemoryUtil.memAddress(renderbuffers));
/*     */     } finally {
/* 119 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGenRenderbuffersEXT(@NativeType("GLuint *") IntBuffer renderbuffers) {
/* 130 */     nglGenRenderbuffersEXT(renderbuffers.remaining(), MemoryUtil.memAddress(renderbuffers));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGenRenderbuffersEXT() {
/* 136 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 138 */       IntBuffer renderbuffers = stack.callocInt(1);
/* 139 */       nglGenRenderbuffersEXT(1, MemoryUtil.memAddress(renderbuffers));
/* 140 */       return renderbuffers.get(0);
/*     */     } finally {
/* 142 */       stack.setPointer(stackPointer);
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
/*     */   public static void glGetRenderbufferParameterivEXT(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/* 158 */     if (Checks.CHECKS) {
/* 159 */       Checks.check(params, 1);
/*     */     }
/* 161 */     nglGetRenderbufferParameterivEXT(target, pname, MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetRenderbufferParameteriEXT(@NativeType("GLenum") int target, @NativeType("GLenum") int pname) {
/* 167 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 169 */       IntBuffer params = stack.callocInt(1);
/* 170 */       nglGetRenderbufferParameterivEXT(target, pname, MemoryUtil.memAddress(params));
/* 171 */       return params.get(0);
/*     */     } finally {
/* 173 */       stack.setPointer(stackPointer);
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
/*     */   public static void glDeleteFramebuffersEXT(@NativeType("GLuint const *") IntBuffer framebuffers) {
/* 195 */     nglDeleteFramebuffersEXT(framebuffers.remaining(), MemoryUtil.memAddress(framebuffers));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDeleteFramebuffersEXT(@NativeType("GLuint const *") int framebuffer) {
/* 200 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 202 */       IntBuffer framebuffers = stack.ints(framebuffer);
/* 203 */       nglDeleteFramebuffersEXT(1, MemoryUtil.memAddress(framebuffers));
/*     */     } finally {
/* 205 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGenFramebuffersEXT(@NativeType("GLuint *") IntBuffer framebuffers) {
/* 216 */     nglGenFramebuffersEXT(framebuffers.remaining(), MemoryUtil.memAddress(framebuffers));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGenFramebuffersEXT() {
/* 222 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 224 */       IntBuffer framebuffers = stack.callocInt(1);
/* 225 */       nglGenFramebuffersEXT(1, MemoryUtil.memAddress(framebuffers));
/* 226 */       return framebuffers.get(0);
/*     */     } finally {
/* 228 */       stack.setPointer(stackPointer);
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
/*     */   public static void glGetFramebufferAttachmentParameterivEXT(@NativeType("GLenum") int target, @NativeType("GLenum") int attachment, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/* 265 */     if (Checks.CHECKS) {
/* 266 */       Checks.check(params, 1);
/*     */     }
/* 268 */     nglGetFramebufferAttachmentParameterivEXT(target, attachment, pname, MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetFramebufferAttachmentParameteriEXT(@NativeType("GLenum") int target, @NativeType("GLenum") int attachment, @NativeType("GLenum") int pname) {
/* 274 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 276 */       IntBuffer params = stack.callocInt(1);
/* 277 */       nglGetFramebufferAttachmentParameterivEXT(target, attachment, pname, MemoryUtil.memAddress(params));
/* 278 */       return params.get(0);
/*     */     } finally {
/* 280 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glDeleteRenderbuffersEXT(@NativeType("GLuint const *") int[] renderbuffers) {
/* 291 */     long __functionAddress = (GL.getICD()).glDeleteRenderbuffersEXT;
/* 292 */     if (Checks.CHECKS) {
/* 293 */       Checks.check(__functionAddress);
/*     */     }
/* 295 */     JNI.callPV(renderbuffers.length, renderbuffers, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGenRenderbuffersEXT(@NativeType("GLuint *") int[] renderbuffers) {
/* 300 */     long __functionAddress = (GL.getICD()).glGenRenderbuffersEXT;
/* 301 */     if (Checks.CHECKS) {
/* 302 */       Checks.check(__functionAddress);
/*     */     }
/* 304 */     JNI.callPV(renderbuffers.length, renderbuffers, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetRenderbufferParameterivEXT(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 309 */     long __functionAddress = (GL.getICD()).glGetRenderbufferParameterivEXT;
/* 310 */     if (Checks.CHECKS) {
/* 311 */       Checks.check(__functionAddress);
/* 312 */       Checks.check(params, 1);
/*     */     } 
/* 314 */     JNI.callPV(target, pname, params, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDeleteFramebuffersEXT(@NativeType("GLuint const *") int[] framebuffers) {
/* 319 */     long __functionAddress = (GL.getICD()).glDeleteFramebuffersEXT;
/* 320 */     if (Checks.CHECKS) {
/* 321 */       Checks.check(__functionAddress);
/*     */     }
/* 323 */     JNI.callPV(framebuffers.length, framebuffers, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGenFramebuffersEXT(@NativeType("GLuint *") int[] framebuffers) {
/* 328 */     long __functionAddress = (GL.getICD()).glGenFramebuffersEXT;
/* 329 */     if (Checks.CHECKS) {
/* 330 */       Checks.check(__functionAddress);
/*     */     }
/* 332 */     JNI.callPV(framebuffers.length, framebuffers, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetFramebufferAttachmentParameterivEXT(@NativeType("GLenum") int target, @NativeType("GLenum") int attachment, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 337 */     long __functionAddress = (GL.getICD()).glGetFramebufferAttachmentParameterivEXT;
/* 338 */     if (Checks.CHECKS) {
/* 339 */       Checks.check(__functionAddress);
/* 340 */       Checks.check(params, 1);
/*     */     } 
/* 342 */     JNI.callPV(target, attachment, pname, params, __functionAddress);
/*     */   }
/*     */   
/*     */   @NativeType("GLboolean")
/*     */   public static native boolean glIsRenderbufferEXT(@NativeType("GLuint") int paramInt);
/*     */   
/*     */   public static native void glBindRenderbufferEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2);
/*     */   
/*     */   public static native void nglDeleteRenderbuffersEXT(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglGenRenderbuffersEXT(int paramInt, long paramLong);
/*     */   
/*     */   public static native void glRenderbufferStorageEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4);
/*     */   
/*     */   public static native void nglGetRenderbufferParameterivEXT(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   @NativeType("GLboolean")
/*     */   public static native boolean glIsFramebufferEXT(@NativeType("GLuint") int paramInt);
/*     */   
/*     */   public static native void glBindFramebufferEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2);
/*     */   
/*     */   public static native void nglDeleteFramebuffersEXT(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglGenFramebuffersEXT(int paramInt, long paramLong);
/*     */   
/*     */   @NativeType("GLenum")
/*     */   public static native int glCheckFramebufferStatusEXT(@NativeType("GLenum") int paramInt);
/*     */   
/*     */   public static native void glFramebufferTexture1DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLuint") int paramInt4, @NativeType("GLint") int paramInt5);
/*     */   
/*     */   public static native void glFramebufferTexture2DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLuint") int paramInt4, @NativeType("GLint") int paramInt5);
/*     */   
/*     */   public static native void glFramebufferTexture3DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLuint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6);
/*     */   
/*     */   public static native void glFramebufferRenderbufferEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLuint") int paramInt4);
/*     */   
/*     */   public static native void nglGetFramebufferAttachmentParameterivEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */   
/*     */   public static native void glGenerateMipmapEXT(@NativeType("GLenum") int paramInt);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\EXTFramebufferObject.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */