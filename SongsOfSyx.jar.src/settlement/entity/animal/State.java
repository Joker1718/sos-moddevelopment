/*     */ package settlement.entity.animal;
/*     */ 
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.MButt;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import view.keyboard.KEYS;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ enum State
/*     */ {
/*  19 */   STAND
/*     */   {
/*     */     boolean update(Animal a, double ds)
/*     */     {
/*  23 */       if (!a.speed.isZero()) {
/*  24 */         a.speed.magnitudeAdjust(ds, 1.0D, 1.0D);
/*  25 */         return true;
/*     */       } 
/*  27 */       return super.update(a, ds);
/*     */     }
/*     */ 
/*     */     
/*     */     void activate(Animal a, double duration) {
/*  32 */       super.activate(a, duration);
/*  33 */       a.speed.magnitudeTargetSet(0.0D);
/*     */     }
/*     */ 
/*     */     
/*     */     Sprite sprite(Animal a) {
/*  38 */       return a.speed.isZero() ? Sprite.STAND_STILL : Sprite.MOVE;
/*     */     }
/*     */   },
/*     */ 
/*     */   
/*  43 */   GRACE
/*     */   {
/*     */     void activate(Animal a, double duration)
/*     */     {
/*  47 */       super.activate(a, duration);
/*  48 */       a.speed.magnitudeTargetSet(0.0D);
/*     */     }
/*     */ 
/*     */     
/*     */     Sprite sprite(Animal a) {
/*  53 */       return Sprite.EATING;
/*     */     }
/*     */ 
/*     */     
/*     */     boolean update(Animal a, double ds) {
/*  58 */       if (!super.update(a, ds)) {
/*  59 */         grace(a);
/*  60 */         return false;
/*     */       } 
/*  62 */       return true;
/*     */     }
/*     */     
/*     */     void grace(Animal a) {
/*  66 */       int tx = a.physics.tileC().x();
/*  67 */       int ty = a.physics.tileC().y();
/*  68 */       if ((SETT.ROOMS()).map.is(tx, ty) && (SETT.ROOMS()).map.get(tx, ty) instanceof ANIMAL_ROOM_RUINER) {
/*  69 */         ANIMAL_ROOM_RUINER i = (ANIMAL_ROOM_RUINER)(SETT.ROOMS()).map.get(tx, ty);
/*  70 */         if (i.canBeGraced(tx, ty))
/*  71 */         { i.grace(tx, ty); }
/*     */         else { return; }
/*     */       
/*  74 */       } else if (RND.oneIn(8)) {
/*  75 */         (SETT.TILE_MAP()).growth.tear(tx, ty);
/*     */ 
/*     */ 
/*     */       
/*     */       }
/*     */     
/*     */     }
/*     */   },
/*  83 */   WALK_RANDOM
/*     */   {
/*     */     void activate(Animal a, double duration)
/*     */     {
/*  87 */       a.stateTimer = (float)duration;
/*  88 */       a.speed.magnitudeTargetSet(0.3D + RND.rFloat(0.1D));
/*     */       
/*  90 */       int d = 64;
/*     */ 
/*     */ 
/*     */       
/*  94 */       for (int i = 0; i < 4; i++) {
/*  95 */         int x = (int)(a.body().cX() + a.speed.nX() * d);
/*  96 */         int y = (int)(a.body().cY() + a.speed.nY() * d);
/*  97 */         int tx = x >> 6;
/*  98 */         int ty = y >> 6;
/*  99 */         if (!(SETT.PATH()).solidity.is(tx, ty) && !SETT.ENTITIES().hasAtTile(tx, ty)) {
/*     */           return;
/*     */         }
/* 102 */         a.speed.turn90();
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Sprite sprite(Animal a) {
/* 110 */       return Sprite.MOVE;
/*     */     }
/*     */ 
/*     */     
/*     */     void meet(Animal a, ENTITY other) {
/* 115 */       if (other(a) != other) {
/* 116 */         a.speed.magnitudeTargetSet(0.0D);
/*     */       
/*     */       }
/*     */     }
/*     */   },
/* 121 */   PANNIC
/*     */   {
/*     */     
/*     */     void activate(Animal a, double duration)
/*     */     {
/* 126 */       a.stateTimer = (float)duration;
/* 127 */       a.speed.magnitudeTargetSet(0.8D + RND.rFloat(0.2D));
/* 128 */       (a.species()).sound.rnd(a.body());
/*     */     }
/*     */ 
/*     */     
/*     */     void collide(Animal a, ENTITY other, double norX, double norY, double momentum) {
/* 133 */       if (momentum > (a.species()).momTresholdFly) {
/* 134 */         super.collide(a, other, norX, norY, momentum);
/*     */       } else {
/* 136 */         a.speed.turn2(-norX, -norY);
/*     */       } 
/*     */     }
/*     */     
/*     */     boolean collideTile(Animal a, boolean broken, double norX, double norY, double momentum) {
/* 141 */       if (momentum > (a.species()).momTreshold) {
/* 142 */         super.collideTile(a, broken, norX, norY, momentum);
/*     */       }
/* 144 */       collideUnwalkable(a);
/* 145 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     void collideUnwalkable(Animal a) {
/* 150 */       int tx = a.tc().x();
/* 151 */       int ty = a.tc().y();
/* 152 */       DIR d = a.speed.dir();
/* 153 */       for (int i = 0; i < DIR.ORTHO.size() && 
/* 154 */         (SETT.PATH()).solidity.is(tx, ty, d); i++) {
/*     */ 
/*     */         
/* 157 */         a.speed.turn90();
/* 158 */         d = d.next(2);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     void meet(Animal a, ENTITY other) {
/* 164 */       if (other instanceof Animal) {
/* 165 */         Animal o = (Animal)other;
/* 166 */         o.scare(a, true);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     void scare(Animal a, ENTITY other, boolean flee) {
/* 173 */       if (!(other instanceof Animal))
/*     */       {
/*     */         
/* 176 */         super.scare(a, other, flee);
/*     */       }
/*     */     }
/*     */     
/*     */     Sprite sprite(Animal a) {
/* 181 */       return Sprite.MOVE;
/*     */     }
/*     */   },
/*     */ 
/*     */   
/* 186 */   UNCONSIOUS
/*     */   {
/*     */     void collide(Animal a, ENTITY other, double norX, double norY, double momentum) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     boolean collideTile(Animal a, boolean broken, double norX, double norY, double momentum) {
/* 195 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     boolean wantsToCollide(Animal a, double mom) {
/* 200 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     void collideUnwalkable(Animal a) {}
/*     */ 
/*     */ 
/*     */     
/*     */     boolean update(Animal a, double ds) {
/* 210 */       a.physics.setHeightOverGround(CLAMP.d(a.physics.getZ() - ds * 10.0D, 0.0D, 10.0D));
/* 211 */       if (a.physics.getZ() > 0.0D)
/* 212 */         return true; 
/* 213 */       if (!a.speed.isZero()) {
/* 214 */         a.speed.magnitudeTargetSet(0.0D);
/* 215 */         a.speed.magnitudeAdjust(ds, 1.0D, 1.0D);
/* 216 */         return true;
/*     */       } 
/* 218 */       return super.update(a, ds);
/*     */     }
/*     */ 
/*     */     
/*     */     void meet(Animal a, ENTITY other) {
/* 223 */       PANNIC.meet(a, other);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     void scare(Animal a, ENTITY other, boolean flee) {}
/*     */ 
/*     */ 
/*     */     
/*     */     Sprite sprite(Animal a) {
/* 233 */       if (a.physics.getZ() > 0.0D) {
/* 234 */         return Sprite.LAYING_SPIN;
/*     */       }
/* 236 */       return Sprite.LAYING_STILL;
/*     */     }
/*     */   },
/*     */ 
/*     */   
/* 241 */   CONTROLLED
/*     */   {
/*     */     void collide(Animal a, ENTITY other, double norX, double norY, double momentum) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     boolean collideTile(Animal a, boolean broken, double norX, double norY, double momentum) {
/* 250 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     boolean wantsToCollide(Animal a, double mom) {
/* 255 */       return (mom > (a.species()).momTreshold);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     void collideUnwalkable(Animal a) {}
/*     */ 
/*     */ 
/*     */     
/*     */     void activate(Animal a, double duration) {
/* 265 */       a.speed.magnitudeMaxInit(512.0D);
/* 266 */       a.speed.magnitudeTargetSet(1.0D);
/* 267 */       a.physics.setMass(500.0D);
/* 268 */       super.activate(a, duration);
/*     */     }
/*     */ 
/*     */     
/*     */     boolean update(Animal a, double ds) {
/*     */       float y, x;
/* 274 */       if (MButt.RIGHT.consumeClick()) {
/* 275 */         return false;
/*     */       }
/*     */ 
/*     */       
/* 279 */       if ((KEYS.MAIN()).MUP.isPressed()) {
/* 280 */         y = -1.0F;
/* 281 */       } else if ((KEYS.MAIN()).MDOWN.isPressed()) {
/* 282 */         y = 1.0F;
/*     */       } else {
/* 284 */         y = 0.0F;
/*     */       } 
/*     */ 
/*     */       
/* 288 */       if ((KEYS.MAIN()).MRIGHT.isPressed()) {
/* 289 */         x = 1.0F;
/* 290 */       } else if ((KEYS.MAIN()).MLEFT.isPressed()) {
/* 291 */         x = -1.0F;
/*     */       } else {
/* 293 */         x = 0.0F;
/*     */       } 
/*     */       
/* 296 */       if (x != 0.0F || y != 0.0F) {
/* 297 */         VIEW.s().getWindow().centerAt(a.body().cX(), a.body().cY());
/* 298 */         a.speed.turn2(x, y);
/* 299 */         a.speed.magnitudeTargetSet(1.0D);
/*     */       } else {
/* 301 */         a.speed.magnitudeTargetSet(0.0D);
/*     */       } 
/* 303 */       a.speed.magnitudeAdjust(ds, 1.0D, 1.0D);
/* 304 */       return true;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void meet(Animal a, ENTITY other) {}
/*     */ 
/*     */ 
/*     */     
/*     */     void scare(Animal a, ENTITY other, boolean flee) {}
/*     */ 
/*     */ 
/*     */     
/*     */     Sprite sprite(Animal a) {
/* 319 */       return Sprite.MOVE;
/*     */     }
/*     */ 
/*     */     
/*     */     boolean willCollideWith(Animal a, ENTITY other) {
/* 324 */       return true;
/*     */     }
/*     */   };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static final State[] all;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean update(Animal a, double ds) {
/* 338 */     a.speed.magnitudeAdjust(ds, 1.0D, 1.0D);
/* 339 */     a.stateTimer = (float)(a.stateTimer - ds);
/* 340 */     return (a.stateTimer > 0.0F);
/*     */   }
/*     */   
/*     */   void activate(Animal a, double duration) {
/* 344 */     a.stateTimer = (float)duration;
/*     */   }
/*     */   
/*     */   Sprite sprite(Animal a) {
/* 348 */     return Sprite.STAND_STILL;
/*     */   }
/*     */   
/*     */   void scare(Animal a, ENTITY other, boolean flee) {
/* 352 */     if (a.domesticated())
/*     */       return; 
/* 354 */     if (other == null)
/*     */       return; 
/* 356 */     otherSet(a, other);
/*     */     
/* 358 */     boolean shouldFlee = !(!flee && !(other instanceof Animal) && !a.cub);
/*     */     
/* 360 */     if (!shouldFlee) {
/* 361 */       shouldFlee = !(SETT.ANIMALS()).spawn.isTimeForAKill(a.species());
/*     */     }
/* 363 */     if (shouldFlee) {
/* 364 */       a.speed.turn2((other.body().cX() + RND.rInt0(32)), (other.body().cY() + RND.rInt0(32)), a.body().cX(), a.body().cY());
/*     */     } else {
/* 366 */       a.speed.turn2(a.body(), other.body());
/* 367 */     }  a.setState(PANNIC, 5.0F);
/*     */   }
/*     */   
/*     */   void collide(Animal a, ENTITY other, double norX, double norY, double momentum) {
/* 371 */     if (momentum < (a.species()).momTreshold) {
/* 372 */       if (!a.domesticated()) {
/* 373 */         scare(a, other, false);
/*     */       }
/* 375 */       a.setState(STAND, 1.0F);
/* 376 */     } else if (momentum < (a.species()).momTreshold * 1.6D) {
/* 377 */       a.setState(UNCONSIOUS, 4.0F);
/*     */     } else {
/* 379 */       a.physics.setHeightOverGround(a.physics.getZ() + (momentum - (a.species()).momTreshold) * 4.0D);
/* 380 */       a.setState(UNCONSIOUS, 8.0F);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean collideTile(Animal a, boolean broken, double norX, double norY, double momentum) {
/* 389 */     if (momentum < (a.species()).momTreshold) {
/* 390 */       a.setState(STAND, 1.0F);
/* 391 */       return false;
/* 392 */     }  if (momentum < (a.species()).momTreshold * 1.5D) {
/* 393 */       a.setState(UNCONSIOUS, 4.0F);
/*     */     } else {
/* 395 */       a.physics.setHeightOverGround(a.physics.getZ() + (momentum - (a.species()).momTreshold) * 4.0D);
/* 396 */       a.setState(UNCONSIOUS, 8.0F);
/*     */     } 
/*     */     
/* 399 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   boolean wantsToCollide(Animal a, double mom) {
/* 404 */     return (mom > (a.species()).momTreshold);
/*     */   }
/*     */ 
/*     */   
/*     */   void collideUnwalkable(Animal a) {
/* 409 */     int tx = a.tc().x();
/* 410 */     int ty = a.tc().y();
/* 411 */     DIR d = a.speed.dir();
/* 412 */     for (int i = 0; i < DIR.ALL.size(); i++) {
/* 413 */       if (!(SETT.PATH()).solidity.is(tx, ty, d)) {
/* 414 */         a.speed.setRaw(d, 1.0D);
/*     */         break;
/*     */       } 
/* 417 */       d = d.next(1);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void meet(Animal a, ENTITY other) {
/* 424 */     otherSet(a, other);
/* 425 */     a.setState(WALK_RANDOM, 1.0F);
/*     */   }
/*     */   
/*     */   private static ENTITY other(Animal a) {
/* 429 */     ENTITY e = SETT.ENTITIES().getByID(a.stateI);
/* 430 */     if (e == null)
/* 431 */       a.stateI = -1; 
/* 432 */     return e;
/*     */   }
/*     */   
/*     */   private static void otherSet(Animal a, ENTITY other) {
/* 436 */     if (other != null) {
/* 437 */       a.stateI = other.id();
/*     */     } else {
/* 439 */       a.stateI = -1;
/*     */     } 
/*     */   }
/*     */   boolean willCollideWith(Animal a, ENTITY other) {
/* 443 */     return (other instanceof settlement.entity.humanoid.Humanoid && !a.domesticated());
/*     */   }
/*     */   static {
/* 446 */     all = values();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\animal\State.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */