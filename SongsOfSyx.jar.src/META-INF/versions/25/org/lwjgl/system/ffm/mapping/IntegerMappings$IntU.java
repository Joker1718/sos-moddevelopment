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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ final class IntU
/*    */   extends Record
/*    */   implements Mapping.Int
/*    */ {
/*    */   private final ValueLayout.OfInt layout;
/*    */   private final Mapping.Pointer p;
/*    */   
/*    */   public final String toString() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Lorg/lwjgl/system/ffm/mapping/IntegerMappings$IntU;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #64	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lorg/lwjgl/system/ffm/mapping/IntegerMappings$IntU;
/*    */   }
/*    */   
/*    */   public final int hashCode() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Lorg/lwjgl/system/ffm/mapping/IntegerMappings$IntU;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #64	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lorg/lwjgl/system/ffm/mapping/IntegerMappings$IntU;
/*    */   }
/*    */   
/*    */   public final boolean equals(Object o) {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Lorg/lwjgl/system/ffm/mapping/IntegerMappings$IntU;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #64	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Lorg/lwjgl/system/ffm/mapping/IntegerMappings$IntU;
/*    */     //   0	8	1	o	Ljava/lang/Object;
/*    */   }
/*    */   
/*    */   IntU(ValueLayout.OfInt layout, Mapping.Pointer p) {
/* 64 */     this.layout = layout; this.p = p; } public ValueLayout.OfInt layout() { return this.layout; } public Mapping.Pointer p() { return this.p; }
/* 65 */   public boolean signed() { return false; }
/* 66 */   public long toLong(int value) { return Integer.toUnsignedLong(value); } public int fromLong(long value) {
/* 67 */     return (int)(value & 0xFFFFFFFFL);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\META-INF\versions\25\org\lwjgl\system\ffm\mapping\IntegerMappings$IntU.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */