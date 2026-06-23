/*     */ package settlement.entity.animal;
/*     */ 
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.datatypes.DIR;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 126 */     a.stateTimer = (float)duration;
/* 127 */     a.speed.magnitudeTargetSet(0.8D + RND.rFloat(0.2D));
/* 128 */     (a.species()).sound.rnd(a.body());
/*     */   }
/*     */ 
/*     */   
/*     */   void collide(Animal a, ENTITY other, double norX, double norY, double momentum) {
/* 133 */     if (momentum > (a.species()).momTresholdFly) {
/* 134 */       super.collide(a, other, norX, norY, momentum);
/*     */     } else {
/* 136 */       a.speed.turn2(-norX, -norY);
/*     */     } 
/*     */   }
/*     */   
/*     */   boolean collideTile(Animal a, boolean broken, double norX, double norY, double momentum) {
/* 141 */     if (momentum > (a.species()).momTreshold) {
/* 142 */       super.collideTile(a, broken, norX, norY, momentum);
/*     */     }
/* 144 */     collideUnwalkable(a);
/* 145 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   void collideUnwalkable(Animal a) {
/* 150 */     int tx = a.tc().x();
/* 151 */     int ty = a.tc().y();
/* 152 */     DIR d = a.speed.dir();
/* 153 */     for (int i = 0; i < DIR.ORTHO.size() && 
/* 154 */       (SETT.PATH()).solidity.is(tx, ty, d); i++) {
/*     */ 
/*     */       
/* 157 */       a.speed.turn90();
/* 158 */       d = d.next(2);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   void meet(Animal a, ENTITY other) {
/* 164 */     if (other instanceof Animal) {
/* 165 */       Animal o = (Animal)other;
/* 166 */       o.scare(a, true);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void scare(Animal a, ENTITY other, boolean flee) {
/* 173 */     if (!(other instanceof Animal))
/*     */     {
/*     */       
/* 176 */       super.scare(a, other, flee);
/*     */     }
/*     */   }
/*     */   
/*     */   Sprite sprite(Animal a) {
/* 181 */     return Sprite.MOVE;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\animal\State$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */