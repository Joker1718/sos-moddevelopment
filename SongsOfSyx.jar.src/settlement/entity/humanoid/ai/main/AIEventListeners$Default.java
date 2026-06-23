/*    */ package settlement.entity.humanoid.ai.main;
/*    */ 
/*    */ import settlement.entity.humanoid.HEvent;
/*    */ import settlement.entity.humanoid.HPoll;
/*    */ import settlement.entity.humanoid.Humanoid;
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
/*    */ public interface Default
/*    */   extends AIEventListeners.HEventListener
/*    */ {
/*    */   default boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 46 */     return AIEventListeners.PreventSwitchtableIntAlloc.event(a, d, e);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   default double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/* 52 */     return AIEventListeners.PreventSwitchtableIntAlloc.poll(a, d, e);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\main\AIEventListeners$Default.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */