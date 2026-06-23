/*     */ package settlement.entity.humanoid.ai.battle;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.HEvent;
/*     */ import settlement.entity.humanoid.HPoll;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISTATE;
/*     */ import settlement.entity.humanoid.ai.main.AISTATES;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.entity.humanoid.spirte.HSprites;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.datatypes.BODY_HOLDER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.VectorImp;
/*     */ import snake2d.util.rnd.RND;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SubFight
/*     */   extends AISUB.Resumable
/*     */ {
/*  29 */   private final double stopMom = 0.5D; private final AISUB.Resumable.Resumer stop; private final AISUB.Resumable.Resumer findFooting; private final AISUB.Resumable.Resumer beBraced; private final AISUB.Resumable.Resumer escape; private final AISUB.Resumable.Resumer move_closer; private final AISUB.Resumable.Resumer charge; private final AISUB.Resumable.Resumer strike; private final AISUB.Resumable.Resumer strike2; private final AISUB.Resumable.Resumer backup;
/*     */   private final AISUB.Resumable.Resumer exit;
/*     */   
/*  32 */   public SubFight(String key) { super(key, "fighting");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  57 */     this.stop = new ResumerB(this)
/*     */       {
/*     */         public double poll(Humanoid a, AIManager d, HPoll.HPollData e)
/*     */         {
/*  61 */           switch (e.type) {
/*     */             case IMPACT_DAMAGE:
/*  63 */               return 0.0D;
/*     */           } 
/*  65 */           return super.poll(a, d, e);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/*  71 */           switch (e.event) {
/*     */             
/*     */             case COLLISION_SOFT:
/*  74 */               if (d.otherEntity() != null) {
/*  75 */                 a.speed.setDirCurrent(DIR.get(a.body(), d.otherEntity().body()));
/*  76 */               } else if (e.other != null) {
/*  77 */                 a.speed.setDirCurrent(DIR.get(a.body(), e.other.body()));
/*  78 */               }  return false;
/*     */             case COLLISION_TILE:
/*  80 */               if (d.otherEntity() != null) {
/*  81 */                 a.speed.setDirCurrent(DIR.get(a.body(), d.otherEntity().body()));
/*     */               } else {
/*  83 */                 a.speed.setDirCurrent(DIR.get(-e.norX, -e.norY));
/*  84 */               }  return false;
/*     */             case MEET_ENEMY:
/*  86 */               d.otherEntitySet((Humanoid)e.other);
/*  87 */               a.speed.setDirCurrent(DIR.get(-e.norX, -e.norY));
/*  88 */               return false;
/*     */           } 
/*  90 */           return super.event(a, d, e);
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public AISTATE setAction(Humanoid a, AIManager d) {
/*  97 */           if (a.speed.isZero())
/*  98 */             return SubFight.this.findFooting.set(a, d); 
/*  99 */           return (AI.STATES()).anima.sword_out.activate(a, d, 1.0D + RND.rFloat0(0.5D));
/*     */         }
/*     */ 
/*     */         
/*     */         public AISTATE res(Humanoid a, AIManager d) {
/* 104 */           if (!a.speed.isZero())
/* 105 */             return (AI.STATES()).STOP.activate(a, d); 
/* 106 */           return SubFight.this.findFooting.set(a, d);
/*     */         }
/*     */       };
/*     */     
/* 110 */     this.findFooting = new ResumerB(this)
/*     */       {
/*     */         public double poll(Humanoid a, AIManager d, HPoll.HPollData e)
/*     */         {
/* 114 */           if (e.type == HPoll.IMPACT_DAMAGE)
/* 115 */             return 0.0D; 
/* 116 */           return super.poll(a, d, e);
/*     */         }
/*     */ 
/*     */         
/*     */         public AISTATE setAction(Humanoid a, AIManager d) {
/* 121 */           if (d.otherEntity() != null)
/* 122 */             a.speed.setDirCurrent(DIR.get(a.body(), d.otherEntity().body())); 
/* 123 */           return (AI.STATES()).STAND.activate(a, d, 0.1D + BattleUtil.getAttackPause(a, d) * 5.0D);
/*     */         }
/*     */ 
/*     */         
/*     */         public AISTATE res(Humanoid a, AIManager d) {
/* 128 */           return SubFight.this.beBraced.set(a, d);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 133 */     this.beBraced = new ResumerB(this)
/*     */       {
/*     */         public AISTATE setAction(Humanoid a, AIManager d)
/*     */         {
/* 137 */           if (d.otherEntity() == null)
/* 138 */             return SubFight.this.exit.set(a, d); 
/* 139 */           a.speed.setDirCurrent(DIR.get(a.body(), d.otherEntity().body()));
/* 140 */           return (AI.STATES()).SWORD.STOP_SWORD.activate(a, d, 0.1D + BattleUtil.getAttackPause(a, d) * 5.0D);
/*     */         }
/*     */ 
/*     */         
/*     */         public AISTATE res(Humanoid a, AIManager d) {
/* 145 */           Humanoid ene = d.otherEntity();
/*     */           
/* 147 */           AIPLAN p = (AI.modules()).battle.escape.plan(a, d);
/* 148 */           if (p != null) {
/* 149 */             return d.resumeOtherPlanState(a, p);
/*     */           }
/* 151 */           AISTATE s = SubFight.this.escape.set(a, d);
/* 152 */           if (s != null) {
/* 153 */             return s;
/*     */           }
/* 155 */           if (ene == null || ene.isRemoved()) {
/* 156 */             return SubFight.this.exit.set(a, d);
/*     */           }
/*     */           
/* 159 */           int dist = a.body().getDistance(ene.body());
/* 160 */           if (dist > 640)
/* 161 */             return SubFight.this.exit.set(a, d); 
/* 162 */           if (dist <= (a.body().width() + ene.body().width()) / 2 - 6)
/* 163 */             return SubFight.this.backup.set(a, d); 
/* 164 */           if (dist > 256)
/* 165 */             return SubFight.this.charge.set(a, d); 
/* 166 */           if (dist > (a.body().width() + a.body().width()) / 2 + 8) {
/* 167 */             return SubFight.this.move_closer.set(a, d);
/*     */           }
/* 169 */           return SubFight.this.strike.set(a, d);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 174 */     this.escape = new ResumerB(this)
/*     */       {
/* 176 */         private final VectorImp vec = new VectorImp();
/*     */ 
/*     */ 
/*     */         
/*     */         public AISTATE setAction(Humanoid a, AIManager d) {
/* 181 */           if (!BattleUtil.shouldMoveIntoDivPosition(a, d)) {
/* 182 */             return null;
/*     */           }
/* 184 */           if (!(a.division()).reporter.posHas(a)) {
/* 185 */             return null;
/*     */           }
/* 187 */           double m = this.vec.set(a.body().cX(), a.body().cY(), (a.division()).reporter.getPixel(a));
/* 188 */           if (m > 128.0D) {
/* 189 */             return (AI.STATES()).STAND_SWORD.activate(a, d, 0.1D);
/*     */           }
/* 191 */           boolean can = true;
/* 192 */           if (m > 64.0D) {
/* 193 */             for (int i = 1; i < 3 && m > 0.0D; i++) {
/* 194 */               int j = (int)(a.body().cX() + this.vec.nX() * 64.0D * i) >> 6;
/* 195 */               int k = (int)(a.body().cY() + this.vec.nY() * 64.0D * i) >> 6;
/* 196 */               if (!SETT.IN_BOUNDS(j, k) || (SETT.PATH().finders()).entity.getEnemies(a, j, k) > 0) {
/* 197 */                 can = false;
/*     */                 break;
/*     */               } 
/* 200 */               m -= 64.0D;
/*     */             } 
/*     */           }
/* 203 */           if (can) {
/*     */             
/* 205 */             AISTATE s = (AI.STATES()).WALK2_SWORD.free(a, d, (int)(a.body().cX() + this.vec.nX() * 64.0D * 2.0D), (int)(a.body().cY() + this.vec.nY() * 64.0D * 2.0D));
/* 206 */             a.speed.setPrevDir();
/* 207 */             return s;
/*     */           } 
/*     */           
/* 210 */           Humanoid ene = d.otherEntity();
/* 211 */           if (ene == null) {
/* 212 */             return null;
/*     */           }
/* 214 */           this.vec.set(ene.body().cX(), ene.body().cY(), a.body().cX(), a.body().cY());
/* 215 */           int tx = (int)(a.body().cX() + this.vec.nX() * 64.0D) >> 6;
/* 216 */           int ty = (int)(a.body().cY() + this.vec.nY() * 64.0D) >> 6;
/* 217 */           if (SETT.IN_BOUNDS(tx, ty) && (SETT.PATH().finders()).entity.getEnemies(a, tx, ty) <= 0) {
/* 218 */             AISTATE s = (AI.STATES()).WALK2_SWORD.free(a, d, (int)(a.body().cX() + this.vec.nX() * 64.0D * 2.0D), (int)(a.body().cY() + this.vec.nY() * 64.0D * 2.0D));
/* 219 */             a.speed.setPrevDir();
/* 220 */             return s;
/*     */           } 
/*     */           
/* 223 */           return null;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 229 */           boolean ret = super.event(a, d, e);
/* 230 */           if (e.speedHasChanged && d.subByte == this.index && d.plansub() == SubFight.this) {
/* 231 */             d.otherEntitySet(null);
/* 232 */             a.speed.setPrevDir();
/*     */             
/* 234 */             float dx = d.X - a.body().cX();
/* 235 */             float dy = d.Y - a.body().cY();
/*     */             
/* 237 */             if (dx * a.speed.nX() < 0.0D || dy * a.speed.nY() < 0.0D) {
/* 238 */               a.speed.turn2((BODY_HOLDER)a, d.X, d.Y).magnitudeTargetSet(0.4D + RND.rFloat(0.05D));
/* 239 */               return false;
/*     */             } 
/* 241 */             d.overwrite(a, (AI.STATES()).STAND_SWORD.activate(a, d, 0.1D));
/*     */             
/* 243 */             return true;
/*     */           } 
/*     */ 
/*     */           
/* 247 */           return ret;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public AISTATE res(Humanoid a, AIManager d) {
/* 254 */           return null;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 259 */     this.move_closer = new ResumerB(this) {
/* 260 */         private final AISTATES.WALK state = (AI.STATES()).SWORD.WALK;
/*     */ 
/*     */         
/*     */         public AISTATE setAction(Humanoid a, AIManager d) {
/* 264 */           a.speed.setDirCurrent(DIR.get(a.body(), d.otherEntity().body()));
/* 265 */           return this.state.activate(a, d, 1.0F + RND.rFloat(1.0D), (ENTITY)d.otherEntity());
/*     */         }
/*     */ 
/*     */         
/*     */         public AISTATE res(Humanoid a, AIManager d) {
/* 270 */           return SubFight.this.beBraced.set(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 275 */           if (e.event == HEvent.COLLISION_TILE) {
/* 276 */             d.otherEntitySet(null);
/* 277 */             d.overwrite(a, SubFight.this.stop.set(a, d));
/* 278 */             return true;
/*     */           } 
/* 280 */           return super.event(a, d, e);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 285 */     this.charge = new ResumerB(this) {
/* 286 */         private final AISTATES.WALK state = (AI.STATES()).SWORD.RUN;
/*     */ 
/*     */         
/*     */         public AISTATE setAction(Humanoid a, AIManager d) {
/* 290 */           a.speed.setDirCurrent(DIR.get(a.body(), d.otherEntity().body()));
/* 291 */           return this.state.activate(a, d, 1.0F + RND.rFloat(1.0D), (ENTITY)d.otherEntity());
/*     */         }
/*     */ 
/*     */         
/*     */         public AISTATE res(Humanoid a, AIManager d) {
/* 296 */           return SubFight.this.beBraced.set(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 301 */           if (e.event == HEvent.COLLISION_TILE) {
/* 302 */             d.otherEntitySet(null);
/* 303 */             d.overwrite(a, SubFight.this.stop.set(a, d));
/* 304 */             return true;
/*     */           } 
/* 306 */           return super.event(a, d, e);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 311 */     this.strike = new ResumerB(this) {
/* 312 */         private final double offMom = 0.25D;
/* 313 */         private final AISTATE state = (AI.STATES()).SWORD.strike;
/* 314 */         private final float time = (float)HSprites.SWORD_OUT.time;
/*     */ 
/*     */ 
/*     */         
/*     */         public AISTATE setAction(Humanoid a, AIManager d) {
/* 319 */           if (d.otherEntity() != null) {
/* 320 */             a.speed.setDirCurrent(DIR.get(a.body(), d.otherEntity().body()));
/* 321 */             if (RND.rInt(3) == 0)
/* 322 */               return SubFight.this.charge.set(a, d); 
/*     */           } 
/* 324 */           a.spriteTimer = 0.0F;
/* 325 */           d.stateTimer = this.time;
/* 326 */           a.speed.magnitudeTargetSet(0.0D);
/* 327 */           return this.state;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 332 */           if (e.event == HEvent.MEET_ENEMY) {
/* 333 */             if (e.speedHasChanged)
/* 334 */               a.speed.setPrevDir(); 
/* 335 */             if (e.momentum > 0.25D)
/* 336 */               return super.event(a, d, e); 
/* 337 */             return false;
/*     */           } 
/* 339 */           return super.event(a, d, e);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public AISTATE res(Humanoid a, AIManager d) {
/* 345 */           return SubFight.this.strike2.set(a, d);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 350 */     this.strike2 = new ResumerB(this)
/*     */       {
/* 352 */         private final AISTATE state = (AI.STATES()).SWORD.strikeIn;
/* 353 */         private final double offMom = 0.25D;
/* 354 */         private final float time = (float)HSprites.SWORD_IN.time;
/*     */ 
/*     */ 
/*     */         
/*     */         public AISTATE setAction(Humanoid a, AIManager d) {
/* 359 */           if (d.otherEntity() != null) {
/* 360 */             int dist = a.body().getDistance(d.otherEntity().body());
/* 361 */             if (dist <= (a.body().width() + d.otherEntity().body().width()) / 2 + 24) {
/* 362 */               Humanoid enemy = d.otherEntity();
/* 363 */               SubFight.this.attack(a, d, enemy);
/*     */             } 
/*     */           } 
/*     */ 
/*     */ 
/*     */           
/* 369 */           a.spriteTimer = 0.0F;
/* 370 */           d.stateTimer = this.time;
/* 371 */           a.speed.magnitudeTargetSet(0.0D);
/*     */           
/* 373 */           return this.state;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 378 */           if (e.event == HEvent.MEET_ENEMY) {
/* 379 */             if (e.speedHasChanged)
/* 380 */               a.speed.setPrevDir(); 
/* 381 */             if (e.momentum > 0.25D)
/* 382 */               return super.event(a, d, e); 
/* 383 */             return false;
/*     */           } 
/* 385 */           return super.event(a, d, e);
/*     */         }
/*     */ 
/*     */         
/*     */         public AISTATE res(Humanoid a, AIManager d) {
/* 390 */           return SubFight.this.beBraced.set(a, d);
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 399 */     this.backup = new ResumerB(this)
/*     */       {
/*     */         public boolean event(Humanoid a, AIManager d, HEvent.HEventData e)
/*     */         {
/* 403 */           if (e.event == HEvent.COLLISION_TILE && RND.rBoolean()) {
/*     */             
/* 405 */             a.speed.turn90();
/* 406 */             if (RND.rBoolean()) {
/* 407 */               a.speed.turn90();
/* 408 */               a.speed.turn90();
/*     */             } 
/* 410 */             return true;
/* 411 */           }  if (e.event == HEvent.COLLISION_SOFT) {
/* 412 */             a.speed.setPrevDir();
/* 413 */             SubFight.this.beBraced.set(a, d);
/* 414 */             return false;
/*     */           } 
/* 416 */           return super.event(a, d, e);
/*     */         }
/*     */ 
/*     */         
/* 420 */         private final AISTATE state = (AI.STATES()).SWORD.backup;
/*     */ 
/*     */         
/*     */         public AISTATE setAction(Humanoid a, AIManager d) {
/* 424 */           a.speed.setDirCurrent(DIR.get(a.body(), d.otherEntity().body()));
/* 425 */           d.stateTimer = 0.25F + RND.rFloat(0.5D);
/* 426 */           a.speed.turn2(a.body(), d.otherEntity().body()).turn90().turn90();
/* 427 */           a.speed.setDirCurrent(a.speed.dir().perpendicular());
/* 428 */           a.speed.magnitudeTargetSet(0.3D);
/* 429 */           return this.state;
/*     */         }
/*     */ 
/*     */         
/*     */         public AISTATE res(Humanoid a, AIManager d) {
/* 434 */           return SubFight.this.beBraced.set(a, d);
/*     */         }
/*     */       };
/*     */     
/* 438 */     this.exit = new ResumerB(this)
/*     */       {
/*     */         public AISTATE setAction(Humanoid a, AIManager d)
/*     */         {
/* 442 */           return (AI.STATES()).SWORD.STOP_SWORD.activate(a, d, 1.5D);
/*     */         }
/*     */         
/*     */         public AISTATE res(Humanoid a, AIManager d)
/*     */         {
/* 447 */           d.otherEntitySet(null);
/* 448 */           return null; } }; }
/*     */   AISUB.AISubActivation initReady(AIManager d, Humanoid a, ENTITY other, double norX, double norY, double faceDot, double momentum) { if (a.division() != null) (a.division()).reporter.reportReachable(a, false);  d.otherEntitySet((Humanoid)other); if (momentum > 0.5D) return activate(a, d, this.stop);  if (faceDot > 0.5D) return activate(a, d, this.strike);  return activate(a, d, this.beBraced); } protected AISTATE init(Humanoid a, AIManager d) { if (d.otherEntity() != null)
/*     */       a.speed.setDirCurrent(DIR.get(a.body(), d.otherEntity().body()));  d.subPathByte = 0; return this.stop.set(a, d); } public void attack(Humanoid a, AIManager d, Humanoid enemy) { (GAME.battle()).fight.attack(a, (ENTITY)enemy); } private abstract class ResumerB extends AISUB.Resumable.Resumer
/*     */   {
/* 452 */     private ResumerB() { super(SubFight.this);
/*     */       
/* 454 */       this.stopMom = 0.5D; }
/*     */     
/*     */     private final double stopMom = 0.5D;
/*     */     
/*     */     public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 459 */       switch (e.event) {
/*     */         case COLLISION_SOFT:
/* 461 */           a.speed.setPrevDir();
/* 462 */           if (e.momentum > 0.5D) {
/* 463 */             d.overwrite(a, SubFight.this.stop.set(a, d));
/*     */           }
/* 465 */           return true;
/*     */         case COLLISION_HARD:
/* 467 */           d.otherEntitySet(null);
/* 468 */           return super.event(a, d, e);
/*     */         case COLLISION_TILE:
/* 470 */           a.speed.setPrevDir();
/* 471 */           d.overwrite(a, SubFight.this.stop.set(a, d));
/* 472 */           return false;
/*     */         case MEET_HARMLESS:
/* 474 */           return false;
/*     */         case MEET_ENEMY:
/* 476 */           if (e.other.isRemoved()) {
/* 477 */             a.speed.setPrevDir();
/* 478 */             return false;
/*     */           } 
/*     */           
/* 481 */           d.otherEntitySet((Humanoid)e.other);
/*     */           
/* 483 */           if (e.momentum > 0.5D) {
/* 484 */             d.overwrite(a, SubFight.this.stop.set(a, d));
/* 485 */           } else if (e.facingDot > 0.5D) {
/* 486 */             d.overwrite(a, SubFight.this.strike.set(a, d));
/* 487 */           } else if (e.speedHasChanged) {
/* 488 */             a.speed.setPrevDir();
/*     */           } 
/* 490 */           return false;
/*     */         case EXHAUST:
/* 492 */           if (RND.oneIn((BOOSTABLES.PHYSICS()).STAMINA.get((BOOSTABLE_O)a.indu()) * 4.0D))
/*     */           {
/* 494 */             (STATS.NEEDS()).EXHASTION.indu().inc(a.indu(), 1);
/*     */           }
/* 496 */           return false;
/*     */       } 
/* 498 */       return InterBattle.listener.event(a, d, e);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/* 504 */       switch (e.type) {
/*     */         case WILL_COLLIDE_WITH:
/* 506 */           return 1.0D;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 511 */       return InterBattle.listener.poll(a, d, e);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected AISTATE resume(Humanoid a, AIManager d) {
/* 519 */     if (d.subByte >= 0) {
/* 520 */       AIPLAN p = (AI.modules()).battle.escape.plan(a, d);
/* 521 */       if (p != null) {
/* 522 */         return d.resumeOtherPlanState(a, p);
/*     */       }
/*     */     } 
/* 525 */     return super.resume(a, d);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\battle\SubFight.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */