/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ARBES31Compatibility
/*    */ {
/*    */   static {
/* 12 */     GL.initialize();
/*    */   }
/*    */   protected ARBES31Compatibility() {
/* 15 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glMemoryBarrierByRegion(@NativeType("GLbitfield") int barriers) {
/* 22 */     GL45C.glMemoryBarrierByRegion(barriers);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\ARBES31Compatibility.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */