/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import org.lwjgl.system.Checks;
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ARBCLEvent
/*    */ {
/*    */   public static final int GL_SYNC_CL_EVENT_ARB = 33344;
/*    */   public static final int GL_SYNC_CL_EVENT_COMPLETE_ARB = 33345;
/*    */   
/*    */   static {
/* 14 */     GL.initialize();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected ARBCLEvent() {
/* 21 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @NativeType("GLsync")
/*    */   public static long glCreateSyncFromCLeventARB(@NativeType("cl_context") long context, @NativeType("cl_event") long event, @NativeType("GLbitfield") int flags) {
/* 32 */     if (Checks.CHECKS) {
/* 33 */       Checks.check(context);
/* 34 */       Checks.check(event);
/*    */     } 
/* 36 */     return nglCreateSyncFromCLeventARB(context, event, flags);
/*    */   }
/*    */   
/*    */   public static native long nglCreateSyncFromCLeventARB(long paramLong1, long paramLong2, int paramInt);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\ARBCLEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */