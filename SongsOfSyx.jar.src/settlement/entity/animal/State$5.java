/*     */ package settlement.entity.animal;
/*     */ 
/*     */ import settlement.entity.ENTITY;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ enum null
/*     */ {
/*     */   void collide(Animal a, ENTITY other, double norX, double norY, double momentum) {}
/*     */   
/*     */   boolean collideTile(Animal a, boolean broken, double norX, double norY, double momentum) {
/* 195 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   boolean wantsToCollide(Animal a, double mom) {
/* 200 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void collideUnwalkable(Animal a) {}
/*     */ 
/*     */ 
/*     */   
/*     */   boolean update(Animal a, double ds) {
/* 210 */     a.physics.setHeightOverGround(CLAMP.d(a.physics.getZ() - ds * 10.0D, 0.0D, 10.0D));
/* 211 */     if (a.physics.getZ() > 0.0D)
/* 212 */       return true; 
/* 213 */     if (!a.speed.isZero()) {
/* 214 */       a.speed.magnitudeTargetSet(0.0D);
/* 215 */       a.speed.magnitudeAdjust(ds, 1.0D, 1.0D);
/* 216 */       return true;
/*     */     } 
/* 218 */     return super.update(a, ds);
/*     */   }
/*     */ 
/*     */   
/*     */   void meet(Animal a, ENTITY other) {
/* 223 */     PANNIC.meet(a, other);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void scare(Animal a, ENTITY other, boolean flee) {}
/*     */ 
/*     */ 
/*     */   
/*     */   Sprite sprite(Animal a) {
/* 233 */     if (a.physics.getZ() > 0.0D) {
/* 234 */       return Sprite.LAYING_SPIN;
/*     */     }
/* 236 */     return Sprite.LAYING_STILL;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\animal\State$5.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */