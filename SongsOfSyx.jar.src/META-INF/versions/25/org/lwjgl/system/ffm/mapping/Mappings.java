/*    */ package META-INF.versions.25.org.lwjgl.system.ffm.mapping;
/*    */ 
/*    */ import java.lang.foreign.MemoryLayout;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ final class Mappings
/*    */ {
/*    */   static String nameConst(MemoryLayout layout) {
/* 13 */     return (String)layout.name().orElseThrow() + " const";
/*    */   }
/*    */   
/*    */   static void check(MemoryLayout layout) {
/* 17 */     if (layout.name().isEmpty())
/* 18 */       throw new IllegalArgumentException("Layout must be named"); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\META-INF\versions\25\org\lwjgl\system\ffm\mapping\Mappings.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */