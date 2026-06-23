/*     */ package snake2d;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import org.lwjgl.opengl.GL15;
/*     */ import org.lwjgl.opengl.GL20;
/*     */ import org.lwjgl.opengl.GL30;
/*     */ import org.lwjgl.system.MemoryUtil;
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
/*     */ abstract class VboAbs
/*     */ {
/*     */   private final int vertexArrayID;
/*     */   private final int attributeElementID;
/*     */   final ByteBuffer buffer;
/*     */   final int MAX_ELEMENTS;
/*     */   final int ELEMENT_SIZE;
/*     */   private final int BUFFER_SIZE;
/*     */   private final int NR_OF_ATTRIBUTES;
/*     */   private final int type;
/*     */   private final int indexMul;
/*     */   
/*     */   VboAbs(int type, int maxElements, VboAttribute... attributes) {
/*  43 */     GlHelper.checkErrors();
/*  44 */     this.MAX_ELEMENTS = maxElements;
/*  45 */     this.NR_OF_ATTRIBUTES = attributes.length;
/*     */     
/*  47 */     this.type = type;
/*  48 */     int vertecies = 0;
/*  49 */     if (type == 4) {
/*  50 */       this.indexMul = 6;
/*  51 */       vertecies = 4;
/*  52 */     } else if (type == 0) {
/*  53 */       this.indexMul = 1;
/*  54 */       vertecies = 1;
/*     */     } else {
/*  56 */       throw new RuntimeException("unsupported type");
/*     */     } 
/*     */     
/*  59 */     int byteStride = 0; byte b1; int i; VboAttribute[] arrayOfVboAttribute1;
/*  60 */     for (i = (arrayOfVboAttribute1 = attributes).length, b1 = 0; b1 < i; ) { VboAttribute v = arrayOfVboAttribute1[b1];
/*  61 */       byteStride += v.sizeInBytes;
/*     */       b1++; }
/*     */     
/*  64 */     if (byteStride % 4 != 0) {
/*  65 */       throw new RuntimeException(String.valueOf(byteStride) + " Needs padding with " + (4 - byteStride % 4));
/*     */     }
/*  67 */     this.ELEMENT_SIZE = byteStride * vertecies;
/*  68 */     this.BUFFER_SIZE = this.ELEMENT_SIZE * this.MAX_ELEMENTS;
/*  69 */     this.buffer = MemoryUtil.memAlloc(this.BUFFER_SIZE);
/*     */     
/*  71 */     this.vertexArrayID = GL30.glGenVertexArrays();
/*  72 */     GL30.glBindVertexArray(this.vertexArrayID);
/*     */     
/*  74 */     this.attributeElementID = GL15.glGenBuffers();
/*  75 */     GL15.glBindBuffer(34962, this.attributeElementID);
/*     */     
/*  77 */     int index = 0;
/*  78 */     int pointerOffset = 0; byte b2; int j; VboAttribute[] arrayOfVboAttribute2;
/*  79 */     for (j = (arrayOfVboAttribute2 = attributes).length, b2 = 0; b2 < j; ) { VboAttribute v = arrayOfVboAttribute2[b2];
/*  80 */       if (v.isInt) {
/*  81 */         GL30.glVertexAttribIPointer(index, v.amount, v.glType, byteStride, pointerOffset);
/*     */       } else {
/*  83 */         GL20.glVertexAttribPointer(index, v.amount, v.glType, v.normalized, byteStride, pointerOffset);
/*  84 */       }  index++;
/*  85 */       pointerOffset += v.sizeInBytes;
/*     */       b2++; }
/*     */     
/*  88 */     GL15.glBufferData(34962, this.buffer, 35040);
/*  89 */     if (type == 4) {
/*  90 */       ElementArrays.quadBind();
/*  91 */     } else if (type == 0) {
/*  92 */       ElementArrays.pointBind();
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  97 */     GL30.glBindVertexArray(0);
/*     */     
/*  99 */     GlHelper.checkErrors();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final void flush(int from, int to) {
/* 106 */     if (from == to)
/*     */       return; 
/* 108 */     GL20.glDrawElements(this.type, (to - from) * this.indexMul, 5125, (from * 4 * this.indexMul));
/*     */   }
/*     */ 
/*     */   
/*     */   void clear() {
/* 113 */     this.buffer.clear();
/*     */   }
/*     */   
/*     */   void dis() {
/* 117 */     GlHelper.checkErrors();
/*     */     
/* 119 */     GL30.glBindVertexArray(this.vertexArrayID);
/*     */     
/* 121 */     GL15.glBindBuffer(34962, this.attributeElementID);
/*     */     
/* 123 */     for (int i = 0; i < this.NR_OF_ATTRIBUTES; i++) {
/* 124 */       GL20.glDisableVertexAttribArray(i);
/*     */     }
/*     */ 
/*     */     
/* 128 */     GL15.glBindBuffer(34962, 0);
/* 129 */     GL15.glDeleteBuffers(this.attributeElementID);
/*     */ 
/*     */     
/* 132 */     GL30.glBindVertexArray(0);
/* 133 */     GL30.glDeleteVertexArrays(this.vertexArrayID);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 138 */     GlHelper.checkErrors();
/*     */     
/* 140 */     MemoryUtil.memFree(this.buffer);
/*     */   }
/*     */ 
/*     */   
/*     */   final void bindAndUpload() {
/* 145 */     if (this.buffer.position() == 0) {
/*     */       return;
/*     */     }
/* 148 */     this.buffer.flip();
/*     */     
/* 150 */     bind();
/*     */     
/* 152 */     GL15.glBufferSubData(34962, 0L, this.buffer);
/*     */   }
/*     */ 
/*     */   
/*     */   final void upload() {
/* 157 */     this.buffer.flip();
/* 158 */     GL15.glBufferSubData(34962, 0L, this.buffer);
/*     */   }
/*     */   
/*     */   final void bind() {
/* 162 */     GL30.glBindVertexArray(this.vertexArrayID);
/*     */     
/* 164 */     GL15.glBindBuffer(34962, this.attributeElementID);
/*     */     
/* 166 */     for (int i = 0; i < this.NR_OF_ATTRIBUTES; i++) {
/* 167 */       GL20.glEnableVertexAttribArray(i);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   static class VboAttribute
/*     */   {
/*     */     private final boolean isInt;
/*     */     
/*     */     private final int amount;
/*     */     private final int glType;
/*     */     private final int sizeInBytes;
/*     */     private final boolean normalized;
/*     */     
/*     */     public VboAttribute(int amount, int glType, boolean normalized, int sizeInBytes) {
/* 182 */       this.isInt = false;
/* 183 */       this.amount = amount;
/* 184 */       this.glType = glType;
/* 185 */       this.sizeInBytes = sizeInBytes * amount;
/* 186 */       this.normalized = normalized;
/*     */     }
/*     */     
/*     */     public VboAttribute(int amount, int glType, int sizeInBytes) {
/* 190 */       this.isInt = true;
/* 191 */       this.amount = amount;
/* 192 */       this.glType = glType;
/* 193 */       this.sizeInBytes = sizeInBytes * amount;
/* 194 */       this.normalized = false;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2d\VboAbs.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */