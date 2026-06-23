/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import org.lwjgl.system.APIUtil;
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
/*     */ final class GLChecks
/*     */ {
/*     */   static int typeToBytes(int type) {
/*  24 */     switch (type) {
/*     */       case 5120:
/*     */       case 5121:
/*  27 */         return 1;
/*     */       case 5122:
/*     */       case 5123:
/*     */       case 5127:
/*     */       case 5131:
/*  32 */         return 2;
/*     */       case 5128:
/*  34 */         return 3;
/*     */       case 5124:
/*     */       case 5125:
/*     */       case 5126:
/*     */       case 5129:
/*     */       case 5132:
/*  40 */         return 4;
/*     */       case 5130:
/*     */       case 5134:
/*     */       case 5135:
/*  44 */         return 8;
/*     */     } 
/*  46 */     throw new IllegalArgumentException(APIUtil.apiUnknownToken("Unsupported OpenGL type", type));
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
/*     */   static int typeToByteShift(int type) {
/*  58 */     switch (type) {
/*     */       case 5120:
/*     */       case 5121:
/*  61 */         return 0;
/*     */       case 5122:
/*     */       case 5123:
/*     */       case 5127:
/*     */       case 5131:
/*  66 */         return 1;
/*     */       case 5124:
/*     */       case 5125:
/*     */       case 5126:
/*     */       case 5129:
/*     */       case 5132:
/*  72 */         return 2;
/*     */       case 5130:
/*     */       case 5134:
/*     */       case 5135:
/*  76 */         return 3;
/*     */     } 
/*  78 */     throw new IllegalArgumentException(APIUtil.apiUnknownToken("Unsupported OpenGL type", type));
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
/*     */   static int getTexLevelParameteri(int texture, int target, int level, int pname) {
/*  94 */     GLCapabilities caps = GL.getCapabilities();
/*     */     
/*  96 */     if (caps.OpenGL45) {
/*  97 */       return GL45.glGetTextureLevelParameteri(texture, level, pname);
/*     */     }
/*  99 */     if (caps.GL_ARB_direct_state_access) {
/* 100 */       return ARBDirectStateAccess.glGetTextureLevelParameteri(texture, level, pname);
/*     */     }
/* 102 */     if (caps.GL_EXT_direct_state_access) {
/* 103 */       return EXTDirectStateAccess.glGetTextureLevelParameteriEXT(texture, target, level, pname);
/*     */     }
/*     */     
/* 106 */     return GL41.glGetTexLevelParameteri(target, level, pname);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\GLChecks.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */