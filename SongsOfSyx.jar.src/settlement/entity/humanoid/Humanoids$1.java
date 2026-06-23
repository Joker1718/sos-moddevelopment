/*    */ package settlement.entity.humanoid;
/*    */ 
/*    */ import settlement.entity.ENTITY;
/*    */ import settlement.main.SETT;
/*    */ import settlement.thing.DRAGGABLE;
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
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends DRAGGABLE.DRAGGABLE_HOLDER
/*    */ {
/*    */   public DRAGGABLE draggable(int index) {
/* 48 */     ENTITY e = SETT.ENTITIES().getByID(index);
/* 49 */     if (e != null && e instanceof Humanoid) {
/* 50 */       Humanoid a = (Humanoid)e;
/* 51 */       return a;
/*    */     } 
/*    */     
/* 54 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\Humanoids$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */