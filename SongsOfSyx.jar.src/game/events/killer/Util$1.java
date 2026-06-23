/*    */ package game.events.killer;
/*    */ 
/*    */ import settlement.entity.ENTITY;
/*    */ import settlement.entity.EntityIterator;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import snake2d.util.rnd.RND;
/*    */ import util.data.GETTER;
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
/*    */ class null
/*    */   extends EntityIterator.Humans
/*    */ {
/*    */   protected boolean processAndShouldBreakH(Humanoid h, int ie) {
/* 25 */     if (Util.isGoodKiller((ENTITY)h) != null) {
/* 26 */       res.set(h);
/* 27 */       if (RND.rBoolean())
/* 28 */         return true; 
/*    */     } 
/* 30 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\events\killer\Util$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */