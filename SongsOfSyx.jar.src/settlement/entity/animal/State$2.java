/*    */ package settlement.entity.animal;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ import snake2d.util.rnd.RND;
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
/*    */ enum null
/*    */ {
/*    */   void activate(Animal a, double duration) {
/* 47 */     super.activate(a, duration);
/* 48 */     a.speed.magnitudeTargetSet(0.0D);
/*    */   }
/*    */ 
/*    */   
/*    */   Sprite sprite(Animal a) {
/* 53 */     return Sprite.EATING;
/*    */   }
/*    */ 
/*    */   
/*    */   boolean update(Animal a, double ds) {
/* 58 */     if (!super.update(a, ds)) {
/* 59 */       grace(a);
/* 60 */       return false;
/*    */     } 
/* 62 */     return true;
/*    */   }
/*    */   
/*    */   void grace(Animal a) {
/* 66 */     int tx = a.physics.tileC().x();
/* 67 */     int ty = a.physics.tileC().y();
/* 68 */     if ((SETT.ROOMS()).map.is(tx, ty) && (SETT.ROOMS()).map.get(tx, ty) instanceof ANIMAL_ROOM_RUINER) {
/* 69 */       ANIMAL_ROOM_RUINER i = (ANIMAL_ROOM_RUINER)(SETT.ROOMS()).map.get(tx, ty);
/* 70 */       if (i.canBeGraced(tx, ty))
/* 71 */       { i.grace(tx, ty); }
/*    */       else { return; }
/*    */     
/* 74 */     } else if (RND.oneIn(8)) {
/* 75 */       (SETT.TILE_MAP()).growth.tear(tx, ty);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\animal\State$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */