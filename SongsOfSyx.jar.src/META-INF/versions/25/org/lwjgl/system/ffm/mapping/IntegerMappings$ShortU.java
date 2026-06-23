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
/*    */ final class ShortU
/*    */   extends Record
/*    */   implements Mapping.Short
/*    */ {
/*    */   private final ValueLayout.OfShort layout;
/*    */   private final Mapping.Pointer p;
/*    */   
/*    */   public final String toString() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Lorg/lwjgl/system/ffm/mapping/IntegerMappings$ShortU;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #47	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lorg/lwjgl/system/ffm/mapping/IntegerMappings$ShortU;
/*    */   }
/*    */   
/*    */   public final int hashCode() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Lorg/lwjgl/system/ffm/mapping/IntegerMappings$ShortU;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #47	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lorg/lwjgl/system/ffm/mapping/IntegerMappings$ShortU;
/*    */   }
/*    */   
/*    */   public final boolean equals(Object o) {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Lorg/lwjgl/system/ffm/mapping/IntegerMappings$ShortU;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #47	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Lorg/lwjgl/system/ffm/mapping/IntegerMappings$ShortU;
/*    */     //   0	8	1	o	Ljava/lang/Object;
/*    */   }
/*    */   
/*    */   ShortU(ValueLayout.OfShort layout, Mapping.Pointer p) {
/* 47 */     this.layout = layout; this.p = p; } public ValueLayout.OfShort layout() { return this.layout; } public Mapping.Pointer p() { return this.p; }
/* 48 */   public boolean signed() { return false; }
/* 49 */   public int toInt(short value) { return Short.toUnsignedInt(value); } public short fromInt(int value) {
/* 50 */     return (short)(value & 0xFFFF);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\META-INF\versions\25\org\lwjgl\system\ffm\mapping\IntegerMappings$ShortU.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */