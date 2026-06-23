/*    */ package META-INF.versions.25.org.lwjgl.system;
/*    */ 
/*    */ import java.lang.foreign.Arena;
/*    */ import org.lwjgl.system.Upcalls;
/*    */ 
/*    */ final class Upcall extends Record {
/*    */   private final Arena arena;
/*    */   private final Object javaCallback;
/*    */   
/*    */   public final String toString() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Lorg/lwjgl/system/Upcalls$Upcall;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #24	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lorg/lwjgl/system/Upcalls$Upcall;
/*    */   }
/*    */   
/*    */   public final int hashCode() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Lorg/lwjgl/system/Upcalls$Upcall;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #24	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lorg/lwjgl/system/Upcalls$Upcall;
/*    */   }
/*    */   
/*    */   public final boolean equals(Object o) {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Lorg/lwjgl/system/Upcalls$Upcall;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #24	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Lorg/lwjgl/system/Upcalls$Upcall;
/*    */     //   0	8	1	o	Ljava/lang/Object;
/*    */   }
/*    */   
/*    */   private Upcall(Arena arena, Object javaCallback)
/*    */   {
/* 24 */     this.arena = arena; this.javaCallback = javaCallback; } public Arena arena() { return this.arena; } public Object javaCallback() { return this.javaCallback; }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\META-INF\versions\25\org\lwjgl\system\Upcalls$Upcall.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */