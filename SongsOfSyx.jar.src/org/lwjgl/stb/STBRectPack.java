/*    */ package org.lwjgl.stb;
/*    */ 
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ public class STBRectPack {
/*    */   public static final int STBRP__MAXVAL = 2147483647;
/*    */   public static final int STBRP_HEURISTIC_Skyline_default = 0;
/*    */   public static final int STBRP_HEURISTIC_Skyline_BL_sortHeight = 0;
/*    */   public static final int STBRP_HEURISTIC_Skyline_BF_sortHeight = 1;
/*    */   
/*    */   static {
/* 12 */     LibSTB.initialize();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected STBRectPack() {
/* 22 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static int stbrp_pack_rects(@NativeType("stbrp_context *") STBRPContext context, @NativeType("stbrp_rect *") STBRPRect.Buffer rects) {
/* 32 */     return nstbrp_pack_rects(context.address(), rects.address(), rects.remaining());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void stbrp_init_target(@NativeType("stbrp_context *") STBRPContext context, int width, int height, @NativeType("stbrp_node *") STBRPNode.Buffer nodes) {
/* 42 */     nstbrp_init_target(context.address(), width, height, nodes.address(), nodes.remaining());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void stbrp_setup_allow_out_of_mem(@NativeType("stbrp_context *") STBRPContext context, @NativeType("int") boolean allow_out_of_mem) {
/* 52 */     nstbrp_setup_allow_out_of_mem(context.address(), allow_out_of_mem ? 1 : 0);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void stbrp_setup_heuristic(@NativeType("stbrp_context *") STBRPContext context, int heuristic) {
/* 62 */     nstbrp_setup_heuristic(context.address(), heuristic);
/*    */   }
/*    */   
/*    */   public static native int nstbrp_pack_rects(long paramLong1, long paramLong2, int paramInt);
/*    */   
/*    */   public static native void nstbrp_init_target(long paramLong1, int paramInt1, int paramInt2, long paramLong2, int paramInt3);
/*    */   
/*    */   public static native void nstbrp_setup_allow_out_of_mem(long paramLong, int paramInt);
/*    */   
/*    */   public static native void nstbrp_setup_heuristic(long paramLong, int paramInt);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\stb\STBRectPack.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */