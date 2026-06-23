/*    */ package settlement.path;
/*    */ 
/*    */ import game.GameDisposable;
/*    */ import snake2d.util.sets.ArrayList;
/*    */ 
/*    */ public abstract class AvailabilityListener
/*    */ {
/*  8 */   private static final ArrayList<AvailabilityListener> listeners = new ArrayList(20);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private static boolean listening = true;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void listenAll(boolean listening) {
/* 21 */     AvailabilityListener.listening = listening;
/*    */   }
/*    */   
/*    */   public static void notify(int tx, int ty, AVAILABILITY a, AVAILABILITY old, boolean playerChange) {
/* 25 */     if (!listening)
/*    */       return; 
/* 27 */     for (AvailabilityListener l : listeners) {
/* 28 */       l.changed(tx, ty, a, old, playerChange);
/*    */     }
/*    */   }
/*    */   
/*    */   protected AvailabilityListener() {
/* 33 */     listeners.add(this);
/*    */   }
/*    */   
/*    */   protected abstract void changed(int paramInt1, int paramInt2, AVAILABILITY paramAVAILABILITY1, AVAILABILITY paramAVAILABILITY2, boolean paramBoolean);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\AvailabilityListener.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */