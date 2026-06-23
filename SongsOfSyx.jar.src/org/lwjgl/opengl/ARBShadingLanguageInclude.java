/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import org.lwjgl.PointerBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.CustomBuffer;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.MemoryStack;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ARBShadingLanguageInclude
/*     */ {
/*     */   public static final int GL_SHADER_INCLUDE_ARB = 36270;
/*     */   public static final int GL_NAMED_STRING_LENGTH_ARB = 36329;
/*     */   public static final int GL_NAMED_STRING_TYPE_ARB = 36330;
/*     */   
/*     */   static {
/*  23 */     GL.initialize();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected ARBShadingLanguageInclude() {
/*  32 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glNamedStringARB(@NativeType("GLenum") int type, @NativeType("GLchar const *") ByteBuffer name, @NativeType("GLchar const *") ByteBuffer string) {
/*  42 */     nglNamedStringARB(type, name.remaining(), MemoryUtil.memAddress(name), string.remaining(), MemoryUtil.memAddress(string));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glNamedStringARB(@NativeType("GLenum") int type, @NativeType("GLchar const *") CharSequence name, @NativeType("GLchar const *") CharSequence string) {
/*  47 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/*  49 */       int nameEncodedLength = stack.nASCII(name, false);
/*  50 */       long nameEncoded = stack.getPointerAddress();
/*  51 */       int stringEncodedLength = stack.nUTF8(string, false);
/*  52 */       long stringEncoded = stack.getPointerAddress();
/*  53 */       nglNamedStringARB(type, nameEncodedLength, nameEncoded, stringEncodedLength, stringEncoded);
/*     */     } finally {
/*  55 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glDeleteNamedStringARB(@NativeType("GLchar const *") ByteBuffer name) {
/*  66 */     nglDeleteNamedStringARB(name.remaining(), MemoryUtil.memAddress(name));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDeleteNamedStringARB(@NativeType("GLchar const *") CharSequence name) {
/*  71 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/*  73 */       int nameEncodedLength = stack.nASCII(name, false);
/*  74 */       long nameEncoded = stack.getPointerAddress();
/*  75 */       nglDeleteNamedStringARB(nameEncodedLength, nameEncoded);
/*     */     } finally {
/*  77 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glCompileShaderIncludeARB(@NativeType("GLuint") int shader, @NativeType("GLchar const * const *") PointerBuffer path, @NativeType("GLint const *") IntBuffer length) {
/*  88 */     if (Checks.CHECKS) {
/*  89 */       Checks.checkSafe(length, path.remaining());
/*     */     }
/*  91 */     nglCompileShaderIncludeARB(shader, path.remaining(), MemoryUtil.memAddress((CustomBuffer)path), MemoryUtil.memAddressSafe(length));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("GLboolean")
/*     */   public static boolean glIsNamedStringARB(@NativeType("GLchar const *") ByteBuffer name) {
/* 102 */     return nglIsNamedStringARB(name.remaining(), MemoryUtil.memAddress(name));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("GLboolean")
/*     */   public static boolean glIsNamedStringARB(@NativeType("GLchar const *") CharSequence name) {
/* 108 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 110 */       int nameEncodedLength = stack.nASCII(name, false);
/* 111 */       long nameEncoded = stack.getPointerAddress();
/* 112 */       return nglIsNamedStringARB(nameEncodedLength, nameEncoded);
/*     */     } finally {
/* 114 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetNamedStringARB(@NativeType("GLchar const *") ByteBuffer name, @NativeType("GLint *") IntBuffer stringlen, @NativeType("GLchar *") ByteBuffer string) {
/* 125 */     if (Checks.CHECKS) {
/* 126 */       Checks.checkSafe(stringlen, 1);
/*     */     }
/* 128 */     nglGetNamedStringARB(name.remaining(), MemoryUtil.memAddress(name), string.remaining(), MemoryUtil.memAddressSafe(stringlen), MemoryUtil.memAddress(string));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetNamedStringARB(@NativeType("GLchar const *") CharSequence name, @NativeType("GLint *") IntBuffer stringlen, @NativeType("GLchar *") ByteBuffer string) {
/* 133 */     if (Checks.CHECKS) {
/* 134 */       Checks.checkSafe(stringlen, 1);
/*     */     }
/* 136 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 138 */       int nameEncodedLength = stack.nASCII(name, false);
/* 139 */       long nameEncoded = stack.getPointerAddress();
/* 140 */       nglGetNamedStringARB(nameEncodedLength, nameEncoded, string.remaining(), MemoryUtil.memAddressSafe(stringlen), MemoryUtil.memAddress(string));
/*     */     } finally {
/* 142 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static String glGetNamedStringARB(@NativeType("GLchar const *") CharSequence name, @NativeType("GLsizei") int bufSize) {
/* 149 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 151 */       int nameEncodedLength = stack.nASCII(name, false);
/* 152 */       long nameEncoded = stack.getPointerAddress();
/* 153 */       IntBuffer stringlen = stack.ints(0);
/* 154 */       ByteBuffer string = stack.malloc(bufSize);
/* 155 */       nglGetNamedStringARB(nameEncodedLength, nameEncoded, bufSize, MemoryUtil.memAddress(stringlen), MemoryUtil.memAddress(string));
/* 156 */       return MemoryUtil.memUTF8(string, stringlen.get(0));
/*     */     } finally {
/* 158 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static String glGetNamedStringARB(@NativeType("GLchar const *") CharSequence name) {
/* 165 */     return glGetNamedStringARB(name, glGetNamedStringiARB(name, 36329));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetNamedStringivARB(@NativeType("GLchar const *") ByteBuffer name, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/* 175 */     if (Checks.CHECKS) {
/* 176 */       Checks.check(params, 1);
/*     */     }
/* 178 */     nglGetNamedStringivARB(name.remaining(), MemoryUtil.memAddress(name), pname, MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetNamedStringivARB(@NativeType("GLchar const *") CharSequence name, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/* 183 */     if (Checks.CHECKS) {
/* 184 */       Checks.check(params, 1);
/*     */     }
/* 186 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 188 */       int nameEncodedLength = stack.nASCII(name, false);
/* 189 */       long nameEncoded = stack.getPointerAddress();
/* 190 */       nglGetNamedStringivARB(nameEncodedLength, nameEncoded, pname, MemoryUtil.memAddress(params));
/*     */     } finally {
/* 192 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetNamedStringiARB(@NativeType("GLchar const *") CharSequence name, @NativeType("GLenum") int pname) {
/* 199 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 201 */       int nameEncodedLength = stack.nASCII(name, false);
/* 202 */       long nameEncoded = stack.getPointerAddress();
/* 203 */       IntBuffer params = stack.callocInt(1);
/* 204 */       nglGetNamedStringivARB(nameEncodedLength, nameEncoded, pname, MemoryUtil.memAddress(params));
/* 205 */       return params.get(0);
/*     */     } finally {
/* 207 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glCompileShaderIncludeARB(@NativeType("GLuint") int shader, @NativeType("GLchar const * const *") PointerBuffer path, @NativeType("GLint const *") int[] length) {
/* 213 */     long __functionAddress = (GL.getICD()).glCompileShaderIncludeARB;
/* 214 */     if (Checks.CHECKS) {
/* 215 */       Checks.check(__functionAddress);
/* 216 */       Checks.checkSafe(length, path.remaining());
/*     */     } 
/* 218 */     JNI.callPPV(shader, path.remaining(), MemoryUtil.memAddress((CustomBuffer)path), length, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetNamedStringARB(@NativeType("GLchar const *") ByteBuffer name, @NativeType("GLint *") int[] stringlen, @NativeType("GLchar *") ByteBuffer string) {
/* 223 */     long __functionAddress = (GL.getICD()).glGetNamedStringARB;
/* 224 */     if (Checks.CHECKS) {
/* 225 */       Checks.check(__functionAddress);
/* 226 */       Checks.checkSafe(stringlen, 1);
/*     */     } 
/* 228 */     JNI.callPPPV(name.remaining(), MemoryUtil.memAddress(name), string.remaining(), stringlen, MemoryUtil.memAddress(string), __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetNamedStringARB(@NativeType("GLchar const *") CharSequence name, @NativeType("GLint *") int[] stringlen, @NativeType("GLchar *") ByteBuffer string) {
/* 233 */     long __functionAddress = (GL.getICD()).glGetNamedStringARB;
/* 234 */     if (Checks.CHECKS) {
/* 235 */       Checks.check(__functionAddress);
/* 236 */       Checks.checkSafe(stringlen, 1);
/*     */     } 
/* 238 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 240 */       int nameEncodedLength = stack.nASCII(name, false);
/* 241 */       long nameEncoded = stack.getPointerAddress();
/* 242 */       JNI.callPPPV(nameEncodedLength, nameEncoded, string.remaining(), stringlen, MemoryUtil.memAddress(string), __functionAddress);
/*     */     } finally {
/* 244 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetNamedStringivARB(@NativeType("GLchar const *") ByteBuffer name, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 250 */     long __functionAddress = (GL.getICD()).glGetNamedStringivARB;
/* 251 */     if (Checks.CHECKS) {
/* 252 */       Checks.check(__functionAddress);
/* 253 */       Checks.check(params, 1);
/*     */     } 
/* 255 */     JNI.callPPV(name.remaining(), MemoryUtil.memAddress(name), pname, params, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetNamedStringivARB(@NativeType("GLchar const *") CharSequence name, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 260 */     long __functionAddress = (GL.getICD()).glGetNamedStringivARB;
/* 261 */     if (Checks.CHECKS) {
/* 262 */       Checks.check(__functionAddress);
/* 263 */       Checks.check(params, 1);
/*     */     } 
/* 265 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 267 */       int nameEncodedLength = stack.nASCII(name, false);
/* 268 */       long nameEncoded = stack.getPointerAddress();
/* 269 */       JNI.callPPV(nameEncodedLength, nameEncoded, pname, params, __functionAddress);
/*     */     } finally {
/* 271 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static native void nglNamedStringARB(int paramInt1, int paramInt2, long paramLong1, int paramInt3, long paramLong2);
/*     */   
/*     */   public static native void nglDeleteNamedStringARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglCompileShaderIncludeARB(int paramInt1, int paramInt2, long paramLong1, long paramLong2);
/*     */   
/*     */   public static native boolean nglIsNamedStringARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglGetNamedStringARB(int paramInt1, long paramLong1, int paramInt2, long paramLong2, long paramLong3);
/*     */   
/*     */   public static native void nglGetNamedStringivARB(int paramInt1, long paramLong1, int paramInt2, long paramLong2);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\ARBShadingLanguageInclude.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */