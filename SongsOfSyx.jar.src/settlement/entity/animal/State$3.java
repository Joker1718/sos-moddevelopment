/*     */ package settlement.entity.animal;
/*     */ 
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.rnd.RND;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   void activate(Animal a, double duration) {
/*  87 */     a.stateTimer = (float)duration;
/*  88 */     a.speed.magnitudeTargetSet(0.3D + RND.rFloat(0.1D));
/*     */     
/*  90 */     int d = 64;
/*     */ 
/*     */ 
/*     */     
/*  94 */     for (int i = 0; i < 4; i++) {
/*  95 */       int x = (int)(a.body().cX() + a.speed.nX() * d);
/*  96 */       int y = (int)(a.body().cY() + a.speed.nY() * d);
/*  97 */       int tx = x >> 6;
/*  98 */       int ty = y >> 6;
/*  99 */       if (!(SETT.PATH()).solidity.is(tx, ty) && !SETT.ENTITIES().hasAtTile(tx, ty)) {
/*     */         return;
/*     */       }
/* 102 */       a.speed.turn90();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Sprite sprite(Animal a) {
/* 110 */     return Sprite.MOVE;
/*     */   }
/*     */ 
/*     */   
/*     */   void meet(Animal a, ENTITY other) {
/* 115 */     if (State.other(a) != other)
/* 116 */       a.speed.magnitudeTargetSet(0.0D); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\animal\State$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */