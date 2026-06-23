/*    */ package META-INF.versions.25.org.lwjgl.system.ffm.mapping;
/*    */ 
/*    */ import java.lang.foreign.MemoryLayout;
/*    */ import java.lang.foreign.ValueLayout;
/*    */ import org.lwjgl.system.ffm.mapping.IntegerMappings;
/*    */ import org.lwjgl.system.ffm.mapping.Mapping;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ final class ByteS
/*    */   extends Record
/*    */   implements Mapping.Byte
/*    */ {
/*    */   private final ValueLayout.OfByte layout;
/*    */   private final Mapping.Pointer p;
/*    */   
/*    */   ByteS(ValueLayout.OfByte layout, Mapping.Pointer p) {
/* 21 */     this.layout = layout; this.p = p; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Lorg/lwjgl/system/ffm/mapping/IntegerMappings$ByteS;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #21	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lorg/lwjgl/system/ffm/mapping/IntegerMappings$ByteS; } public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Lorg/lwjgl/system/ffm/mapping/IntegerMappings$ByteS;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #21	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lorg/lwjgl/system/ffm/mapping/IntegerMappings$ByteS; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Lorg/lwjgl/system/ffm/mapping/IntegerMappings$ByteS;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #21	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Lorg/lwjgl/system/ffm/mapping/IntegerMappings$ByteS;
/* 21 */     //   0	8	1	o	Ljava/lang/Object; } public ValueLayout.OfByte layout() { return this.layout; } public Mapping.Pointer p() { return this.p; }
/* 22 */   public boolean signed() { return true; }
/* 23 */   public int toInt(byte value) { return value; } public byte fromInt(int value) {
/* 24 */     return (byte)value;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\META-INF\versions\25\org\lwjgl\system\ffm\mapping\IntegerMappings$ByteS.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */