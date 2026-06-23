/*     */ package META-INF.versions.25.org.lwjgl.system.ffm.mapping;
/*     */ 
/*     */ import java.lang.foreign.AddressLayout;
/*     */ import java.lang.foreign.MemoryLayout;
/*     */ import org.lwjgl.system.ffm.mapping.IntegerMappings;
/*     */ import org.lwjgl.system.ffm.mapping.Mapping;
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
/*     */ final class SizeU
/*     */   extends Record
/*     */   implements Mapping.Size
/*     */ {
/*     */   private final AddressLayout layout;
/*     */   private final Mapping.Pointer p;
/*     */   
/*     */   public final String toString() {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: <illegal opcode> toString : (Lorg/lwjgl/system/ffm/mapping/IntegerMappings$SizeU;)Ljava/lang/String;
/*     */     //   6: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #220	-> 0
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   0	7	0	this	Lorg/lwjgl/system/ffm/mapping/IntegerMappings$SizeU;
/*     */   }
/*     */   
/*     */   public final int hashCode() {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: <illegal opcode> hashCode : (Lorg/lwjgl/system/ffm/mapping/IntegerMappings$SizeU;)I
/*     */     //   6: ireturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #220	-> 0
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   0	7	0	this	Lorg/lwjgl/system/ffm/mapping/IntegerMappings$SizeU;
/*     */   }
/*     */   
/*     */   public final boolean equals(Object o) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: aload_1
/*     */     //   2: <illegal opcode> equals : (Lorg/lwjgl/system/ffm/mapping/IntegerMappings$SizeU;Ljava/lang/Object;)Z
/*     */     //   7: ireturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #220	-> 0
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   0	8	0	this	Lorg/lwjgl/system/ffm/mapping/IntegerMappings$SizeU;
/*     */     //   0	8	1	o	Ljava/lang/Object;
/*     */   }
/*     */   
/*     */   SizeU(AddressLayout layout, Mapping.Pointer p) {
/* 220 */     this.layout = layout; this.p = p; } public AddressLayout layout() { return this.layout; } public Mapping.Pointer p() { return this.p; } public boolean signed() {
/* 221 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\META-INF\versions\25\org\lwjgl\system\ffm\mapping\IntegerMappings$SizeU.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */