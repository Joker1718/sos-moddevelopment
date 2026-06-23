/*    */ package settlement.entity.animal;
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
/*    */ enum null
/*    */ {
/*    */   boolean update(Animal a, double ds) {
/* 23 */     if (!a.speed.isZero()) {
/* 24 */       a.speed.magnitudeAdjust(ds, 1.0D, 1.0D);
/* 25 */       return true;
/*    */     } 
/* 27 */     return super.update(a, ds);
/*    */   }
/*    */ 
/*    */   
/*    */   void activate(Animal a, double duration) {
/* 32 */     super.activate(a, duration);
/* 33 */     a.speed.magnitudeTargetSet(0.0D);
/*    */   }
/*    */ 
/*    */   
/*    */   Sprite sprite(Animal a) {
/* 38 */     return a.speed.isZero() ? Sprite.STAND_STILL : Sprite.MOVE;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\animal\State$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */