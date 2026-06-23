/*    */ package settlement.entity;
/*    */ 
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
/*    */ public abstract class Humans
/*    */   extends EntityIterator
/*    */ {
/*    */   public final boolean processAndShouldBreak(ENTITY e, int ie) {
/* 41 */     if (e instanceof Humanoid) {
/* 42 */       return processAndShouldBreakH((Humanoid)e, ie);
/*    */     }
/* 44 */     return false;
/*    */   }
/*    */   
/*    */   protected abstract boolean processAndShouldBreakH(Humanoid paramHumanoid, int paramInt);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\EntityIterator$Humans.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */