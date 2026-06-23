/*    */ package settlement.entity;
/*    */ 
/*    */ import settlement.path.AVAILABILITY;
/*    */ import settlement.path.AvailabilityListener;
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
/*    */   extends AvailabilityListener
/*    */ {
/*    */   protected void changed(int tx, int ty, AVAILABILITY a, AVAILABILITY old, boolean playerChange) {
/* 78 */     if (!playerChange || a.player >= 0.0D) {
/*    */       return;
/*    */     }
/* 81 */     for (ENTITY e : ENTETIES.this.getAtTile(tx, ty)) {
/* 82 */       ResolverTile.trapped(e);
/* 83 */       if (!e.isRemoved() && !e.physics.MoveCheck()) {
/* 84 */         e.physics.initMoveCheck();
/* 85 */         ENTETIES.this.grid.remove(e);
/* 86 */         ENTETIES.this.grid.add(e);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\ENTETIES$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */