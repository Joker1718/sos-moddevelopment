/*     */ package META-INF.versions.25.org.lwjgl.system.ffm;
/*     */ 
/*     */ import java.lang.classfile.CodeBuilder;
/*     */ import java.lang.classfile.TypeKind;
/*     */ import org.lwjgl.system.ffm.BCDescriptors;
/*     */ 
/*     */ final class BCReturnTransform extends Record {
/*     */   private final int bufferIndex;
/*     */   private final int bufferSlot;
/*     */   private final int sizeIndex;
/*     */   private final SizeCarrier sizeCarrier;
/*     */   private final int sizeOutputIndex;
/*     */   private final int sizeOutputSlot;
/*     */   
/*  15 */   BCReturnTransform(int bufferIndex, int bufferSlot, int sizeIndex, SizeCarrier sizeCarrier, int sizeOutputIndex, int sizeOutputSlot) { this.bufferIndex = bufferIndex; this.bufferSlot = bufferSlot; this.sizeIndex = sizeIndex; this.sizeCarrier = sizeCarrier; this.sizeOutputIndex = sizeOutputIndex; this.sizeOutputSlot = sizeOutputSlot; } public final String toString() { // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: <illegal opcode> toString : (Lorg/lwjgl/system/ffm/BCReturnTransform;)Ljava/lang/String;
/*     */     //   6: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #15	-> 0
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*  15 */     //   0	7	0	this	Lorg/lwjgl/system/ffm/BCReturnTransform; } public int bufferIndex() { return this.bufferIndex; } public final int hashCode() { // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: <illegal opcode> hashCode : (Lorg/lwjgl/system/ffm/BCReturnTransform;)I
/*     */     //   6: ireturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #15	-> 0
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   0	7	0	this	Lorg/lwjgl/system/ffm/BCReturnTransform; } public final boolean equals(Object o) { // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: aload_1
/*     */     //   2: <illegal opcode> equals : (Lorg/lwjgl/system/ffm/BCReturnTransform;Ljava/lang/Object;)Z
/*     */     //   7: ireturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #15	-> 0
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   0	8	0	this	Lorg/lwjgl/system/ffm/BCReturnTransform;
/*  15 */     //   0	8	1	o	Ljava/lang/Object; } public int bufferSlot() { return this.bufferSlot; } public int sizeIndex() { return this.sizeIndex; } public SizeCarrier sizeCarrier() { return this.sizeCarrier; } public int sizeOutputIndex() { return this.sizeOutputIndex; } public int sizeOutputSlot() { return this.sizeOutputSlot; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static org.lwjgl.system.ffm.BCReturnTransform create(CodeBuilder cb, MethodTypeDesc methodTypeDesc, Method method, Parameter[] parameters, FFMReturn returnAnnotation, int allocatorSlot) {
/*  26 */     int bufferIndex = returnAnnotation.value();
/*     */     
/*  28 */     int sizeInputIndex = -1;
/*  29 */     for (int p = 0; p < methodTypeDesc.parameterCount(); p++) {
/*  30 */       if (parameters[p].isAnnotationPresent((Class)FFMReturn.Size.class)) {
/*  31 */         sizeInputIndex = p;
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/*  36 */     if (sizeInputIndex == -1 && (
/*  37 */       BCDescriptors.CD_MemorySegment.equals(methodTypeDesc.returnType()) || ConstantDescs.CD_String.equals(methodTypeDesc.returnType()))) {
/*  38 */       throw new IllegalStateException("Missing @FFMReturn.Size annotation");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  44 */     SizeCarrier sizeCarrier = (sizeInputIndex == -1) ? SizeCarrier.get(method.getReturnType()) : SizeCarrier.get(parameters[sizeInputIndex].getType());
/*     */     
/*  46 */     FFMReturn.SizeOut returnOutputAnnotation = method.<FFMReturn.SizeOut>getAnnotation(FFMReturn.SizeOut.class);
/*     */     
/*  48 */     int sizeOutputIndex = (returnOutputAnnotation == null) ? -1 : returnOutputAnnotation.value();
/*  49 */     int sizeOutputSlot = -1;
/*     */     
/*  51 */     if (returnOutputAnnotation != null && sizeOutputIndex < bufferIndex) {
/*  52 */       sizeOutputSlot = allocateOutputSlot(cb, sizeCarrier, allocatorSlot);
/*     */     }
/*     */     
/*  55 */     int bufferSlot = cb.allocateLocal(TypeKind.REFERENCE);
/*     */     
/*  57 */     if (sizeInputIndex == -1) {
/*  58 */       cb.aload(allocatorSlot);
/*  59 */       SizeCarrier.get(method.getReturnType())
/*  60 */         .allocateSingle(cb)
/*  61 */         .astore(bufferSlot);
/*     */     } else {
/*  63 */       int slot = cb.parameterSlot(sizeInputIndex);
/*  64 */       TypeKind kind = TypeKind.from(methodTypeDesc.parameterType(sizeInputIndex));
/*     */       
/*  66 */       cb
/*  67 */         .aload(allocatorSlot)
/*  68 */         .loadLocal(kind, slot);
/*  69 */       if (method.getReturnType() == String.class) {
/*  70 */         BCUtil.buildCharsetShift(cb, BCUtil.getCharset(method), kind);
/*     */       }
/*  72 */       if (kind != TypeKind.LONG) {
/*  73 */         cb.i2l();
/*     */       }
/*  75 */       cb
/*  76 */         .invokeinterface(BCDescriptors.CD_SegmentAllocator, "allocate", BCDescriptors.MTD_MemorySegment_long)
/*  77 */         .astore(bufferSlot);
/*     */     } 
/*     */     
/*  80 */     if (returnOutputAnnotation != null && bufferIndex < sizeOutputIndex) {
/*  81 */       sizeOutputSlot = allocateOutputSlot(cb, sizeCarrier, allocatorSlot);
/*     */     }
/*     */     
/*  84 */     return new org.lwjgl.system.ffm.BCReturnTransform(bufferIndex, bufferSlot, sizeInputIndex, sizeCarrier, sizeOutputIndex, sizeOutputSlot);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int allocateOutputSlot(CodeBuilder cb, SizeCarrier sizeCarrier, int allocatorSlot) {
/*  92 */     int slot = cb.allocateLocal(TypeKind.REFERENCE);
/*  93 */     cb.aload(allocatorSlot);
/*  94 */     sizeCarrier
/*  95 */       .allocateSingle(cb)
/*  96 */       .astore(slot);
/*  97 */     return slot;
/*     */   }
/*     */   
/*     */   void loadParameters(CodeBuilder bcb, int virtualParameterCount, int p) {
/* 101 */     if (p == virtualParameterCount + this.bufferIndex) {
/* 102 */       bcb.aload(this.bufferSlot);
/*     */     }
/* 104 */     if (sizeOutputIndex() != -1 && p == virtualParameterCount + this.sizeOutputIndex) {
/* 105 */       bcb.aload(this.sizeOutputSlot);
/*     */     }
/*     */   }
/*     */   
/*     */   void loadParametersTail(CodeBuilder bcb, int virtualParameterCount, int parameterCount) {
/* 110 */     if (this.sizeOutputSlot != -1 && parameterCount <= virtualParameterCount + this.sizeOutputIndex && this.sizeOutputSlot < this.bufferSlot) {
/* 111 */       bcb.aload(this.sizeOutputSlot);
/*     */     }
/* 113 */     if (parameterCount <= virtualParameterCount + this.bufferIndex) {
/* 114 */       bcb.aload(this.bufferSlot);
/*     */     }
/* 116 */     if (this.sizeOutputSlot != -1 && parameterCount <= virtualParameterCount + this.sizeOutputIndex && this.bufferSlot < this.sizeOutputSlot) {
/* 117 */       bcb.aload(this.sizeOutputSlot);
/*     */     }
/*     */   }
/*     */   
/*     */   void buildResult(CodeBuilder bcb, MethodTypeDesc methodTypeDesc, Method method) {
/* 122 */     if (method.getReturnType().isPrimitive()) {
/* 123 */       bcb
/* 124 */         .aload(this.bufferSlot)
/* 125 */         .getstatic(BCDescriptors.CD_ValueLayout, this.sizeCarrier.name, this.sizeCarrier.type)
/* 126 */         .lconst_0()
/* 127 */         .invokeinterface(BCDescriptors.CD_MemorySegment, "get", this.sizeCarrier.getter);
/*     */ 
/*     */ 
/*     */     
/*     */     }
/*     */     else {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 137 */       TypeKind sizeKind = TypeKind.from(methodTypeDesc.parameterType(this.sizeIndex));
/* 138 */       int sizeSlot = bcb.allocateLocal(sizeKind);
/*     */       
/* 140 */       if (this.sizeOutputSlot != -1) {
/* 141 */         bcb
/* 142 */           .aload(this.sizeOutputSlot)
/* 143 */           .getstatic(BCDescriptors.CD_ValueLayout, this.sizeCarrier.name, this.sizeCarrier.type)
/* 144 */           .lconst_0()
/* 145 */           .invokeinterface(BCDescriptors.CD_MemorySegment, "get", this.sizeCarrier.getter);
/*     */       }
/* 147 */       bcb
/* 148 */         .storeLocal(sizeKind, sizeSlot)
/* 149 */         .aload(this.bufferSlot)
/* 150 */         .lconst_0()
/* 151 */         .loadLocal(sizeKind, sizeSlot);
/*     */       
/* 153 */       FFMCharset.Type charsetType = (method.getReturnType() == String.class) ? BCUtil.getCharset(method) : null;
/* 154 */       if (charsetType != null) {
/* 155 */         BCUtil.buildCharsetShift(bcb, charsetType, sizeKind);
/*     */       }
/*     */       
/* 158 */       if (sizeKind != TypeKind.LONG) {
/* 159 */         bcb.i2l();
/*     */       }
/* 161 */       bcb.invokeinterface(BCDescriptors.CD_MemorySegment, "asSlice", BCDescriptors.MTD_MemorySegment_long_long);
/*     */       
/* 163 */       if (charsetType != null) {
/* 164 */         int arraySlot = bcb.allocateLocal(TypeKind.REFERENCE);
/* 165 */         bcb
/* 166 */           .getstatic(BCDescriptors.CD_ValueLayout, "JAVA_BYTE", BCDescriptors.CD_ValueLayout$OfByte)
/* 167 */           .invokeinterface(BCDescriptors.CD_MemorySegment, "toArray", BCDescriptors.MTD_byteArray_ValueLayout$OfByte)
/* 168 */           .astore(arraySlot)
/* 169 */           .new_(ConstantDescs.CD_String)
/* 170 */           .dup()
/* 171 */           .aload(arraySlot);
/* 172 */         BCUtil.buildCharsetInstance(bcb, charsetType)
/* 173 */           .invokespecial(ConstantDescs.CD_String, "<init>", BCDescriptors.MTD_void_byteArray_Charset);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\META-INF\versions\25\org\lwjgl\system\ffm\BCReturnTransform.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */