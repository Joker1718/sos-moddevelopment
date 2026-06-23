/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.IntBuffer;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ARBVertexType2_10_10_10_REV
/*     */ {
/*     */   public static final int GL_INT_2_10_10_10_REV = 36255;
/*     */   
/*     */   static {
/*  14 */     GL.initialize();
/*     */   }
/*     */ 
/*     */   
/*     */   protected ARBVertexType2_10_10_10_REV() {
/*  19 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexP2ui(@NativeType("GLenum") int type, @NativeType("GLuint") int value) {
/*  26 */     GL33.glVertexP2ui(type, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexP3ui(@NativeType("GLenum") int type, @NativeType("GLuint") int value) {
/*  33 */     GL33.glVertexP3ui(type, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexP4ui(@NativeType("GLenum") int type, @NativeType("GLuint") int value) {
/*  40 */     GL33.glVertexP4ui(type, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglVertexP2uiv(int type, long value) {
/*  47 */     GL33.nglVertexP2uiv(type, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexP2uiv(@NativeType("GLenum") int type, @NativeType("GLuint const *") IntBuffer value) {
/*  52 */     GL33.glVertexP2uiv(type, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglVertexP3uiv(int type, long value) {
/*  59 */     GL33.nglVertexP3uiv(type, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexP3uiv(@NativeType("GLenum") int type, @NativeType("GLuint const *") IntBuffer value) {
/*  64 */     GL33.glVertexP3uiv(type, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglVertexP4uiv(int type, long value) {
/*  71 */     GL33.nglVertexP4uiv(type, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexP4uiv(@NativeType("GLenum") int type, @NativeType("GLuint const *") IntBuffer value) {
/*  76 */     GL33.glVertexP4uiv(type, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glTexCoordP1ui(@NativeType("GLenum") int type, @NativeType("GLuint") int coords) {
/*  83 */     GL33.glTexCoordP1ui(type, coords);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glTexCoordP2ui(@NativeType("GLenum") int type, @NativeType("GLuint") int coords) {
/*  90 */     GL33.glTexCoordP2ui(type, coords);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glTexCoordP3ui(@NativeType("GLenum") int type, @NativeType("GLuint") int coords) {
/*  97 */     GL33.glTexCoordP3ui(type, coords);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glTexCoordP4ui(@NativeType("GLenum") int type, @NativeType("GLuint") int coords) {
/* 104 */     GL33.glTexCoordP4ui(type, coords);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglTexCoordP1uiv(int type, long coords) {
/* 111 */     GL33.nglTexCoordP1uiv(type, coords);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glTexCoordP1uiv(@NativeType("GLenum") int type, @NativeType("GLuint const *") IntBuffer coords) {
/* 116 */     GL33.glTexCoordP1uiv(type, coords);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglTexCoordP2uiv(int type, long coords) {
/* 123 */     GL33.nglTexCoordP2uiv(type, coords);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glTexCoordP2uiv(@NativeType("GLenum") int type, @NativeType("GLuint const *") IntBuffer coords) {
/* 128 */     GL33.glTexCoordP2uiv(type, coords);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglTexCoordP3uiv(int type, long coords) {
/* 135 */     GL33.nglTexCoordP3uiv(type, coords);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glTexCoordP3uiv(@NativeType("GLenum") int type, @NativeType("GLuint const *") IntBuffer coords) {
/* 140 */     GL33.glTexCoordP3uiv(type, coords);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglTexCoordP4uiv(int type, long coords) {
/* 147 */     GL33.nglTexCoordP4uiv(type, coords);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glTexCoordP4uiv(@NativeType("GLenum") int type, @NativeType("GLuint const *") IntBuffer coords) {
/* 152 */     GL33.glTexCoordP4uiv(type, coords);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoordP1ui(@NativeType("GLenum") int texture, @NativeType("GLenum") int type, @NativeType("GLuint") int coords) {
/* 159 */     GL33.glMultiTexCoordP1ui(texture, type, coords);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoordP2ui(@NativeType("GLenum") int texture, @NativeType("GLenum") int type, @NativeType("GLuint") int coords) {
/* 166 */     GL33.glMultiTexCoordP2ui(texture, type, coords);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoordP3ui(@NativeType("GLenum") int texture, @NativeType("GLenum") int type, @NativeType("GLuint") int coords) {
/* 173 */     GL33.glMultiTexCoordP3ui(texture, type, coords);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoordP4ui(@NativeType("GLenum") int texture, @NativeType("GLenum") int type, @NativeType("GLuint") int coords) {
/* 180 */     GL33.glMultiTexCoordP4ui(texture, type, coords);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglMultiTexCoordP1uiv(int texture, int type, long coords) {
/* 187 */     GL33.nglMultiTexCoordP1uiv(texture, type, coords);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoordP1uiv(@NativeType("GLenum") int texture, @NativeType("GLenum") int type, @NativeType("GLuint const *") IntBuffer coords) {
/* 192 */     GL33.glMultiTexCoordP1uiv(texture, type, coords);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglMultiTexCoordP2uiv(int texture, int type, long coords) {
/* 199 */     GL33.nglMultiTexCoordP2uiv(texture, type, coords);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoordP2uiv(@NativeType("GLenum") int texture, @NativeType("GLenum") int type, @NativeType("GLuint const *") IntBuffer coords) {
/* 204 */     GL33.glMultiTexCoordP2uiv(texture, type, coords);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglMultiTexCoordP3uiv(int texture, int type, long coords) {
/* 211 */     GL33.nglMultiTexCoordP3uiv(texture, type, coords);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoordP3uiv(@NativeType("GLenum") int texture, @NativeType("GLenum") int type, @NativeType("GLuint const *") IntBuffer coords) {
/* 216 */     GL33.glMultiTexCoordP3uiv(texture, type, coords);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglMultiTexCoordP4uiv(int texture, int type, long coords) {
/* 223 */     GL33.nglMultiTexCoordP4uiv(texture, type, coords);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoordP4uiv(@NativeType("GLenum") int texture, @NativeType("GLenum") int type, @NativeType("GLuint const *") IntBuffer coords) {
/* 228 */     GL33.glMultiTexCoordP4uiv(texture, type, coords);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glNormalP3ui(@NativeType("GLenum") int type, @NativeType("GLuint") int coords) {
/* 235 */     GL33.glNormalP3ui(type, coords);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglNormalP3uiv(int type, long coords) {
/* 242 */     GL33.nglNormalP3uiv(type, coords);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glNormalP3uiv(@NativeType("GLenum") int type, @NativeType("GLuint const *") IntBuffer coords) {
/* 247 */     GL33.glNormalP3uiv(type, coords);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glColorP3ui(@NativeType("GLenum") int type, @NativeType("GLuint") int color) {
/* 254 */     GL33.glColorP3ui(type, color);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glColorP4ui(@NativeType("GLenum") int type, @NativeType("GLuint") int color) {
/* 261 */     GL33.glColorP4ui(type, color);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglColorP3uiv(int type, long color) {
/* 268 */     GL33.nglColorP3uiv(type, color);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glColorP3uiv(@NativeType("GLenum") int type, @NativeType("GLuint const *") IntBuffer color) {
/* 273 */     GL33.glColorP3uiv(type, color);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglColorP4uiv(int type, long color) {
/* 280 */     GL33.nglColorP4uiv(type, color);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glColorP4uiv(@NativeType("GLenum") int type, @NativeType("GLuint const *") IntBuffer color) {
/* 285 */     GL33.glColorP4uiv(type, color);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glSecondaryColorP3ui(@NativeType("GLenum") int type, @NativeType("GLuint") int color) {
/* 292 */     GL33.glSecondaryColorP3ui(type, color);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglSecondaryColorP3uiv(int type, long color) {
/* 299 */     GL33.nglSecondaryColorP3uiv(type, color);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glSecondaryColorP3uiv(@NativeType("GLenum") int type, @NativeType("GLuint const *") IntBuffer color) {
/* 304 */     GL33.glSecondaryColorP3uiv(type, color);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexAttribP1ui(@NativeType("GLuint") int index, @NativeType("GLenum") int type, @NativeType("GLboolean") boolean normalized, @NativeType("GLuint") int value) {
/* 311 */     GL33C.glVertexAttribP1ui(index, type, normalized, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexAttribP2ui(@NativeType("GLuint") int index, @NativeType("GLenum") int type, @NativeType("GLboolean") boolean normalized, @NativeType("GLuint") int value) {
/* 318 */     GL33C.glVertexAttribP2ui(index, type, normalized, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexAttribP3ui(@NativeType("GLuint") int index, @NativeType("GLenum") int type, @NativeType("GLboolean") boolean normalized, @NativeType("GLuint") int value) {
/* 325 */     GL33C.glVertexAttribP3ui(index, type, normalized, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexAttribP4ui(@NativeType("GLuint") int index, @NativeType("GLenum") int type, @NativeType("GLboolean") boolean normalized, @NativeType("GLuint") int value) {
/* 332 */     GL33C.glVertexAttribP4ui(index, type, normalized, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglVertexAttribP1uiv(int index, int type, boolean normalized, long value) {
/* 339 */     GL33C.nglVertexAttribP1uiv(index, type, normalized, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribP1uiv(@NativeType("GLuint") int index, @NativeType("GLenum") int type, @NativeType("GLboolean") boolean normalized, @NativeType("GLuint const *") IntBuffer value) {
/* 344 */     GL33C.glVertexAttribP1uiv(index, type, normalized, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglVertexAttribP2uiv(int index, int type, boolean normalized, long value) {
/* 351 */     GL33C.nglVertexAttribP2uiv(index, type, normalized, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribP2uiv(@NativeType("GLuint") int index, @NativeType("GLenum") int type, @NativeType("GLboolean") boolean normalized, @NativeType("GLuint const *") IntBuffer value) {
/* 356 */     GL33C.glVertexAttribP2uiv(index, type, normalized, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglVertexAttribP3uiv(int index, int type, boolean normalized, long value) {
/* 363 */     GL33C.nglVertexAttribP3uiv(index, type, normalized, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribP3uiv(@NativeType("GLuint") int index, @NativeType("GLenum") int type, @NativeType("GLboolean") boolean normalized, @NativeType("GLuint const *") IntBuffer value) {
/* 368 */     GL33C.glVertexAttribP3uiv(index, type, normalized, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglVertexAttribP4uiv(int index, int type, boolean normalized, long value) {
/* 375 */     GL33C.nglVertexAttribP4uiv(index, type, normalized, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribP4uiv(@NativeType("GLuint") int index, @NativeType("GLenum") int type, @NativeType("GLboolean") boolean normalized, @NativeType("GLuint const *") IntBuffer value) {
/* 380 */     GL33C.glVertexAttribP4uiv(index, type, normalized, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexP2uiv(@NativeType("GLenum") int type, @NativeType("GLuint const *") int[] value) {
/* 385 */     GL33.glVertexP2uiv(type, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexP3uiv(@NativeType("GLenum") int type, @NativeType("GLuint const *") int[] value) {
/* 390 */     GL33.glVertexP3uiv(type, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexP4uiv(@NativeType("GLenum") int type, @NativeType("GLuint const *") int[] value) {
/* 395 */     GL33.glVertexP4uiv(type, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glTexCoordP1uiv(@NativeType("GLenum") int type, @NativeType("GLuint const *") int[] coords) {
/* 400 */     GL33.glTexCoordP1uiv(type, coords);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glTexCoordP2uiv(@NativeType("GLenum") int type, @NativeType("GLuint const *") int[] coords) {
/* 405 */     GL33.glTexCoordP2uiv(type, coords);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glTexCoordP3uiv(@NativeType("GLenum") int type, @NativeType("GLuint const *") int[] coords) {
/* 410 */     GL33.glTexCoordP3uiv(type, coords);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glTexCoordP4uiv(@NativeType("GLenum") int type, @NativeType("GLuint const *") int[] coords) {
/* 415 */     GL33.glTexCoordP4uiv(type, coords);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoordP1uiv(@NativeType("GLenum") int texture, @NativeType("GLenum") int type, @NativeType("GLuint const *") int[] coords) {
/* 420 */     GL33.glMultiTexCoordP1uiv(texture, type, coords);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoordP2uiv(@NativeType("GLenum") int texture, @NativeType("GLenum") int type, @NativeType("GLuint const *") int[] coords) {
/* 425 */     GL33.glMultiTexCoordP2uiv(texture, type, coords);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoordP3uiv(@NativeType("GLenum") int texture, @NativeType("GLenum") int type, @NativeType("GLuint const *") int[] coords) {
/* 430 */     GL33.glMultiTexCoordP3uiv(texture, type, coords);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoordP4uiv(@NativeType("GLenum") int texture, @NativeType("GLenum") int type, @NativeType("GLuint const *") int[] coords) {
/* 435 */     GL33.glMultiTexCoordP4uiv(texture, type, coords);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glNormalP3uiv(@NativeType("GLenum") int type, @NativeType("GLuint const *") int[] coords) {
/* 440 */     GL33.glNormalP3uiv(type, coords);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glColorP3uiv(@NativeType("GLenum") int type, @NativeType("GLuint const *") int[] color) {
/* 445 */     GL33.glColorP3uiv(type, color);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glColorP4uiv(@NativeType("GLenum") int type, @NativeType("GLuint const *") int[] color) {
/* 450 */     GL33.glColorP4uiv(type, color);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glSecondaryColorP3uiv(@NativeType("GLenum") int type, @NativeType("GLuint const *") int[] color) {
/* 455 */     GL33.glSecondaryColorP3uiv(type, color);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribP1uiv(@NativeType("GLuint") int index, @NativeType("GLenum") int type, @NativeType("GLboolean") boolean normalized, @NativeType("GLuint const *") int[] value) {
/* 460 */     GL33C.glVertexAttribP1uiv(index, type, normalized, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribP2uiv(@NativeType("GLuint") int index, @NativeType("GLenum") int type, @NativeType("GLboolean") boolean normalized, @NativeType("GLuint const *") int[] value) {
/* 465 */     GL33C.glVertexAttribP2uiv(index, type, normalized, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribP3uiv(@NativeType("GLuint") int index, @NativeType("GLenum") int type, @NativeType("GLboolean") boolean normalized, @NativeType("GLuint const *") int[] value) {
/* 470 */     GL33C.glVertexAttribP3uiv(index, type, normalized, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribP4uiv(@NativeType("GLuint") int index, @NativeType("GLenum") int type, @NativeType("GLboolean") boolean normalized, @NativeType("GLuint const *") int[] value) {
/* 475 */     GL33C.glVertexAttribP4uiv(index, type, normalized, value);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\ARBVertexType2_10_10_10_REV.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */