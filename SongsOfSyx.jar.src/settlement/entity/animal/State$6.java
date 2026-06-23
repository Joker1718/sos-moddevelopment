/*     */ package settlement.entity.animal;
/*     */ 
/*     */ import settlement.entity.ENTITY;
/*     */ import snake2d.MButt;
/*     */ import view.keyboard.KEYS;
/*     */ import view.main.VIEW;
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
/* 250 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   boolean wantsToCollide(Animal a, double mom) {
/* 255 */     return (mom > (a.species()).momTreshold);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void collideUnwalkable(Animal a) {}
/*     */ 
/*     */ 
/*     */   
/*     */   void activate(Animal a, double duration) {
/* 265 */     a.speed.magnitudeMaxInit(512.0D);
/* 266 */     a.speed.magnitudeTargetSet(1.0D);
/* 267 */     a.physics.setMass(500.0D);
/* 268 */     super.activate(a, duration);
/*     */   }
/*     */ 
/*     */   
/*     */   boolean update(Animal a, double ds) {
/*     */     float y, x;
/* 274 */     if (MButt.RIGHT.consumeClick()) {
/* 275 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 279 */     if ((KEYS.MAIN()).MUP.isPressed()) {
/* 280 */       y = -1.0F;
/* 281 */     } else if ((KEYS.MAIN()).MDOWN.isPressed()) {
/* 282 */       y = 1.0F;
/*     */     } else {
/* 284 */       y = 0.0F;
/*     */     } 
/*     */ 
/*     */     
/* 288 */     if ((KEYS.MAIN()).MRIGHT.isPressed()) {
/* 289 */       x = 1.0F;
/* 290 */     } else if ((KEYS.MAIN()).MLEFT.isPressed()) {
/* 291 */       x = -1.0F;
/*     */     } else {
/* 293 */       x = 0.0F;
/*     */     } 
/*     */     
/* 296 */     if (x != 0.0F || y != 0.0F) {
/* 297 */       VIEW.s().getWindow().centerAt(a.body().cX(), a.body().cY());
/* 298 */       a.speed.turn2(x, y);
/* 299 */       a.speed.magnitudeTargetSet(1.0D);
/*     */     } else {
/* 301 */       a.speed.magnitudeTargetSet(0.0D);
/*     */     } 
/* 303 */     a.speed.magnitudeAdjust(ds, 1.0D, 1.0D);
/* 304 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void meet(Animal a, ENTITY other) {}
/*     */ 
/*     */ 
/*     */   
/*     */   void scare(Animal a, ENTITY other, boolean flee) {}
/*     */ 
/*     */ 
/*     */   
/*     */   Sprite sprite(Animal a) {
/* 319 */     return Sprite.MOVE;
/*     */   }
/*     */ 
/*     */   
/*     */   boolean willCollideWith(Animal a, ENTITY other) {
/* 324 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\animal\State$6.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */