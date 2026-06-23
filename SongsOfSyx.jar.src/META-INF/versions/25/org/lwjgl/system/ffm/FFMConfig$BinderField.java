/*    */ package META-INF.versions.25.org.lwjgl.system.ffm;
/*    */ 
/*    */ import org.lwjgl.system.ffm.Binder;
/*    */ import org.lwjgl.system.ffm.FFMConfig;
/*    */ 
/*    */ final class BinderField
/*    */   extends Record
/*    */ {
/*    */   private final String name;
/*    */   private final Binder<?> binder;
/*    */   
/*    */   public final String toString() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Lorg/lwjgl/system/ffm/FFMConfig$BinderField;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #25	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lorg/lwjgl/system/ffm/FFMConfig$BinderField;
/*    */   }
/*    */   
/*    */   public final int hashCode() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Lorg/lwjgl/system/ffm/FFMConfig$BinderField;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #25	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lorg/lwjgl/system/ffm/FFMConfig$BinderField;
/*    */   }
/*    */   
/*    */   public final boolean equals(Object o) {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Lorg/lwjgl/system/ffm/FFMConfig$BinderField;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #25	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Lorg/lwjgl/system/ffm/FFMConfig$BinderField;
/*    */     //   0	8	1	o	Ljava/lang/Object;
/*    */   }
/*    */   
/*    */   BinderField(String name, Binder<?> binder) {
/* 25 */     this.name = name; this.binder = binder; } public String name() { return this.name; } public Binder<?> binder() { return this.binder; }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\META-INF\versions\25\org\lwjgl\system\ffm\FFMConfig$BinderField.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */