/*    */ package settlement.thing;
/*    */ 
/*    */ import game.GameDisposable;
/*    */ import snake2d.util.datatypes.BODY_HOLDER;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import snake2d.util.sets.ArrayList;
/*    */ import snake2d.util.sets.LIST;
/*    */ 
/*    */ public interface DRAGGABLE
/*    */   extends BODY_HOLDER {
/*    */   void drag(DIR paramDIR, int paramInt1, int paramInt2, int paramInt3);
/*    */   
/*    */   void drag(DIR paramDIR, int paramInt1, int paramInt2);
/*    */   
/*    */   boolean canBeDragged();
/*    */   
/*    */   public static abstract class DRAGGABLE_HOLDER {
/*    */     public final byte index;
/* 19 */     private static ArrayList<DRAGGABLE_HOLDER> all = new ArrayList(16);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public DRAGGABLE_HOLDER() {
/* 30 */       this.index = (byte)all.add(this);
/*    */     }
/*    */     
/*    */     public abstract DRAGGABLE draggable(int param1Int);
/*    */     
/*    */     public static LIST<DRAGGABLE_HOLDER> all() {
/* 36 */       return (LIST<DRAGGABLE_HOLDER>)all;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\DRAGGABLE.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */