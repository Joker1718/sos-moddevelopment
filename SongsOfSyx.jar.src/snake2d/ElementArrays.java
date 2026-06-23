/*     */ package snake2d;
/*     */ 
/*     */ import java.nio.IntBuffer;
/*     */ import org.lwjgl.opengl.GL15;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import snake2d.util.file.Alloc;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ abstract class ElementArrays
/*     */ {
/*     */   private static ElementArrays quad;
/*     */   private static ElementArrays point;
/*     */   
/*     */   abstract void bind();
/*     */   
/*     */   abstract void dis();
/*     */   
/*     */   static void quadBind() {
/*  25 */     if (quad != null) {
/*  26 */       quad.bind();
/*     */       
/*     */       return;
/*     */     } 
/*  30 */     int[] indices = Alloc.ii(393216);
/*  31 */     int tmp = 0;
/*  32 */     for (int i = 0; i < indices.length; i += 6) {
/*  33 */       indices[i] = tmp++;
/*  34 */       indices[i + 1] = tmp++;
/*  35 */       indices[i + 2] = tmp--;
/*  36 */       indices[i + 3] = tmp++;
/*  37 */       indices[i + 4] = tmp++;
/*  38 */       indices[i + 5] = tmp++;
/*     */     } 
/*     */     
/*  41 */     IntBuffer indicesBuffer = MemoryUtil.memAllocInt(indices.length);
/*  42 */     indicesBuffer.put(indices).flip();
/*  43 */     GlHelper.checkErrors();
/*  44 */     final int vertexFixID = GL15.glGenBuffers();
/*  45 */     GL15.glBindBuffer(34963, vertexFixID);
/*  46 */     GL15.glBufferData(34963, indicesBuffer, 35045);
/*  47 */     MemoryUtil.memFree(indicesBuffer);
/*     */     
/*  49 */     quad = new ElementArrays()
/*     */       {
/*     */         void dis()
/*     */         {
/*  53 */           GL15.glBindBuffer(34963, 0);
/*  54 */           GL15.glDeleteBuffers(vertexFixID);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         void bind() {
/*  60 */           GL15.glBindBuffer(34963, vertexFixID);
/*     */         }
/*     */       };
/*     */     
/*  64 */     quad.bind();
/*  65 */     GlHelper.checkErrors();
/*     */   }
/*     */ 
/*     */   
/*     */   static void pointBind() {
/*  70 */     if (point != null) {
/*  71 */       point.bind();
/*     */       
/*     */       return;
/*     */     } 
/*  75 */     int[] indices = Alloc.ii(65536);
/*  76 */     for (int i = 0; i < indices.length; i++) {
/*  77 */       indices[i] = i;
/*     */     }
/*     */     
/*  80 */     IntBuffer indicesBuffer = MemoryUtil.memAllocInt(indices.length);
/*  81 */     indicesBuffer.put(indices).flip();
/*  82 */     GlHelper.checkErrors();
/*  83 */     final int vertexFixID = GL15.glGenBuffers();
/*  84 */     GL15.glBindBuffer(34963, vertexFixID);
/*  85 */     GL15.glBufferData(34963, indicesBuffer, 35045);
/*  86 */     MemoryUtil.memFree(indicesBuffer);
/*     */     
/*  88 */     point = new ElementArrays()
/*     */       {
/*     */         void dis()
/*     */         {
/*  92 */           GL15.glBindBuffer(34963, 0);
/*  93 */           GL15.glDeleteBuffers(vertexFixID);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         void bind() {
/*  99 */           GL15.glBindBuffer(34963, vertexFixID);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 104 */     point.bind();
/* 105 */     GlHelper.checkErrors();
/*     */   }
/*     */   
/*     */   static void dispose() {
/* 109 */     GlHelper.checkErrors();
/* 110 */     if (quad != null) {
/* 111 */       quad.dis();
/* 112 */       GlHelper.checkErrors();
/*     */     } 
/* 114 */     if (point != null) {
/* 115 */       point.dis();
/* 116 */       GlHelper.checkErrors();
/*     */     } 
/* 118 */     quad = null;
/* 119 */     point = null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2d\ElementArrays.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */