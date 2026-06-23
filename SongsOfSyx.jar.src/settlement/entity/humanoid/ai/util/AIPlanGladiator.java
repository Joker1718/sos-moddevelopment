/*     */ package settlement.entity.humanoid.ai.util;
/*     */ 
/*     */ import init.type.CAUSE_LEAVE;
/*     */ import init.type.CAUSE_LEAVES;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.HEvent;
/*     */ import settlement.entity.humanoid.HPoll;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.battle.SubFight;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISTATE;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.service.arena.RoomArenaWork;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ 
/*     */ public abstract class AIPlanGladiator
/*     */   extends AIPLAN.PLANRES
/*     */ {
/*     */   private final CharSequence ¤¤name;
/*  29 */   private final double inj = 0.3D; private final boolean toDeath; private final SubFight fightSub; private final AIPLAN.PLANRES.Resumer walk; private final AIPLAN.PLANRES.Resumer taunt; private final AIPLAN.PLANRES.Resumer ready; private final AIPLAN.PLANRES.Resumer fight; private final AIPLAN.PLANRES.Resumer yield;
/*     */   private final AIPLAN.PLANRES.Resumer taunt2;
/*     */   private final AIPLAN.PLANRES.Resumer removed;
/*     */   
/*  33 */   public AIPlanGladiator(String key, boolean toDeath, CharSequence verb) { super(key);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  52 */     this.fightSub = new SubFight(this.key + "Fighting")
/*     */       {
/*     */         protected AISTATE resume(Humanoid a, AIManager d)
/*     */         {
/*  56 */           if (!AIPlanGladiator.this.shouldFight(a, d))
/*  57 */             return null; 
/*  58 */           if (!AIPlanGladiator.this.isFighter((ENTITY)d.otherEntity()))
/*  59 */             return null; 
/*  60 */           return super.resume(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/*  65 */           if (AIPlanGladiator.this.isFighter(e.other) && (
/*  66 */             e.event == HEvent.MEET_HARMLESS || e.event == HEvent.COLLISION_SOFT)) {
/*  67 */             e.event = HEvent.MEET_ENEMY;
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*  73 */           return super.event(a, d, e);
/*     */         }
/*     */ 
/*     */         
/*     */         public void attack(Humanoid a, AIManager d, Humanoid enemy) {
/*  78 */           (AI.modules()).battle.soundSword.rnd(a);
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  93 */     this.walk = new AIPLAN.PLANRES.Resumer(this)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/*  97 */           AISUB.AISubActivation s = (AI.SUBS()).walkTo.cooFull(a, d, (COORDINATE)d.planTile);
/*  98 */           if (s != null)
/*  99 */             return s; 
/* 100 */           AIPlanGladiator.this.cancel(a, d);
/* 101 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 106 */           if (!AIPlanGladiator.this.toDeath) {
/* 107 */             return AIPlanGladiator.this.taunt.set(a, d);
/*     */           }
/* 109 */           return AIPlanGladiator.this.ready.set(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 114 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/* 125 */     this.taunt = new AIPLAN.PLANRES.Resumer(this)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 129 */           a.speed.impulseBreak(1.0D);
/* 130 */           d.planByte1 = 4;
/* 131 */           a.speed.setDirCurrent((DIR)DIR.ALL.rnd());
/* 132 */           AIPlanGladiator.this.w(a, d).gladiatorDrawMakeSheer((COORDINATE)d.planTile);
/* 133 */           return (AI.SUBS()).single.activate(a, d, (AI.STATES()).anima.armsOut, (3 + RND.rInt(3)));
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 138 */           d.planByte1 = (byte)(d.planByte1 - 1);
/* 139 */           if (d.planByte1 <= 0) {
/* 140 */             return AIPlanGladiator.this.ready.set(a, d);
/*     */           }
/* 142 */           a.speed.setDirCurrent((DIR)DIR.ALL.rnd());
/* 143 */           return (AI.SUBS()).single.activate(a, d, (AI.STATES()).anima.armsOut, (3 + RND.rInt(3)));
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 148 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/* 158 */     this.ready = new Ready();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 216 */     this.fight = new ResFigher(this)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 220 */           AISUB.AISubActivation s = AIPlanGladiator.this.fightSub.activate(a, d);
/* 221 */           d.planByte1 = (byte)(3 + RND.rInt(8));
/* 222 */           if (s == null) {
/* 223 */             AIPlanGladiator.this.cancel(a, d);
/*     */           }
/* 225 */           return s;
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 230 */           d.planByte1 = (byte)(d.planByte1 - 1); if (d.planByte1 < 0 && !AIPlanGladiator.this.toDeath)
/* 231 */             return AIPlanGladiator.this.yield.set(a, d); 
/* 232 */           if (!AIPlanGladiator.this.toDeath && (STATS.NEEDS()).INJURIES.COUNT.indu().getD(a.indu()) >= 0.3D)
/* 233 */             return AIPlanGladiator.this.yield.set(a, d); 
/* 234 */           if (!AIPlanGladiator.this.isFighter((ENTITY)d.otherEntity()))
/* 235 */             return AIPlanGladiator.this.taunt2.set(a, d); 
/* 236 */           return AIPlanGladiator.this.ready.set(a, d);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 241 */     this.yield = new AIPLAN.PLANRES.Resumer(this)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 245 */           return (AI.SUBS()).LAY.activateTime(a, d, 8 + RND.rInt(14));
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 250 */           AIPlanGladiator.this.cancel(a, d);
/* 251 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 256 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/* 268 */     this.taunt2 = new AIPLAN.PLANRES.Resumer(this)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 272 */           a.speed.impulseBreak(1.0D);
/* 273 */           AIPlanGladiator.this.w(a, d).gladiatorDrawMakeSheer((COORDINATE)d.planTile);
/* 274 */           d.planByte1 = 4;
/* 275 */           a.speed.setDirCurrent((DIR)DIR.ALL.rnd());
/* 276 */           return (AI.SUBS()).single.activate(a, d, (AI.STATES()).anima.armsOut, (3 + RND.rInt(3)));
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 281 */           d.planByte1 = (byte)(d.planByte1 - 1);
/* 282 */           if (d.planByte1 <= 0) {
/* 283 */             return null;
/*     */           }
/* 285 */           a.speed.setDirCurrent((DIR)DIR.ALL.rnd());
/* 286 */           return (AI.SUBS()).single.activate(a, d, (AI.STATES()).anima.armsOut, (3 + RND.rInt(3)));
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 291 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/* 320 */     this.removed = new AIPLAN.PLANRES.Resumer(this)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 324 */           return (AI.SUBS()).STAND.activate(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 329 */           return null;
/*     */         }
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d)
/*     */         {
/* 334 */           return true;
/*     */         }
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/*     */     this.¤¤name = verb;
/*     */     this.toDeath = toDeath; }
/*     */    protected void name(Humanoid a, AIManager d, Str string) {
/*     */     string.add(this.¤¤name);
/*     */   } protected AISUB.AISubActivation init(Humanoid a, AIManager d) {
/*     */     if (!w(a, d).gladiatorInArena(d.planTile.x(), d.planTile.y()))
/*     */       throw new RuntimeException(); 
/*     */     return this.walk.set(a, d);
/* 346 */   } public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) { if (e.event == HEvent.ROOM_REMOVED && (SETT.ROOMS()).map.get((COORDINATE)d.planTile) == e.room) {
/* 347 */       d.planTile.set(-1.0D, -1.0D);
/* 348 */       d.overwrite(a, this.removed.set(a, d));
/* 349 */       return true;
/*     */     } 
/* 351 */     return super.event(a, d, e); }
/*     */   private boolean shouldFight(Humanoid a, AIManager d) { if (!w(a, d).gladiatorInArena(a.tc().x(), a.tc().y())) return false;  if (!this.toDeath && (STATS.NEEDS()).INJURIES.COUNT.indu().getD(a.indu()) >= 0.3D) return false;  if (!this.toDeath && (STATS.WORK()).WORK_TIME.indu().isMax(a.indu())) return false;  return true; }
/*     */   private class Ready extends ResFigher {
/*     */     protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) { d.planByte1 = 8; d.otherEntitySet(null); return (AI.SUBS()).single.activate(a, d, (AI.STATES()).anima.sword, (4 + RND.rInt(4))); }
/*     */     protected AISUB.AISubActivation res(Humanoid a, AIManager d) { if (!AIPlanGladiator.this.shouldFight(a, d)) { AIPlanGladiator.this.cancel(a, d); return null; }  if (AIPlanGladiator.this.isFighter((ENTITY)d.otherEntity())) return AIPlanGladiator.this.fight.set(a, d);  d.planByte1 = (byte)(d.planByte1 - 1); if (d.planByte1 < 0) return null;  Humanoid other = other(a, d); if (other != null) { d.otherEntitySet(other); AIPlanGladiator.this.w(a, d).gladiatorDrawMakeSheer((COORDINATE)d.planTile); return AIPlanGladiator.this.fight.set(a, d); }  a.speed.setDirCurrent((DIR)DIR.ALL.rnd()); return (AI.SUBS()).single.activate(a, d, (AI.STATES()).anima.sword, (4 + RND.rInt(4))); } private Humanoid other(Humanoid a, AIManager d) { RECTANGLE rec = AIPlanGladiator.this.w(a, d).gladiatorArea(d.planTile.x(), d.planTile.y()); LIST<ENTITY> ents = SETT.ENTITIES().fillTiles(rec); if (ents.size() < 1) return null;  int k = RND.rInt(ents.size()); for (int i = 0; i < ents.size(); i++) { ENTITY e = (ENTITY)ents.getC(i + k); if (e != a) if (AIPlanGladiator.this.isFighter(e)) { Humanoid a2 = (Humanoid)e; AIManager d2 = (AIManager)a2.ai(); if (!AIPlanGladiator.this.isFighter((ENTITY)d2.otherEntity())) d2.otherEntitySet(a);  return a2; }   }  return null; }
/*     */   } private boolean isFighter(ENTITY e) { if (e instanceof Humanoid && !e.isRemoved()) { Humanoid a2 = (Humanoid)e; AIManager d2 = (AIManager)a2.ai(); if (d2.plan() instanceof AIPlanGladiator) return getResumer(d2) instanceof ResFigher;  }  return false; } protected abstract RoomArenaWork w(Humanoid paramHumanoid, AIManager paramAIManager); private abstract class ResFigher extends AIPLAN.PLANRES.Resumer {
/* 357 */     protected ResFigher() { super(AIPlanGladiator.this, AIPlanGladiator.this.¤¤name); }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean con(Humanoid a, AIManager d) {
/* 362 */       return true;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void can(Humanoid a, AIManager d) {}
/*     */ 
/*     */ 
/*     */     
/*     */     public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/* 372 */       if (e.type == HPoll.WILL_COLLIDE_WITH) {
/* 373 */         return (AIPlanGladiator.this.isFighter(e.other) ? true : false);
/*     */       }
/*     */ 
/*     */       
/* 377 */       return super.poll(a, d, e);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 383 */       if ((e.event == HEvent.COLLISION_HARD || e.event == HEvent.MEET_HARMLESS || e.event == HEvent.COLLISION_SOFT) && 
/* 384 */         AIPlanGladiator.this.isFighter(e.other)) {
/* 385 */         Humanoid oo = (Humanoid)e.other;
/* 386 */         if (AIPlanGladiator.this.shouldFight(oo, d) && RND.oneIn(10)) {
/* 387 */           AIManager d2 = (AIManager)oo.ai();
/* 388 */           double am = 0.1D + RND.rFloat(0.19999999999999998D);
/* 389 */           CAUSE_LEAVE ll = CAUSE_LEAVES.SLAYED();
/* 390 */           if (((AIPlanGladiator)d2.plan()).toDeath) {
/* 391 */             ll = CAUSE_LEAVES.EXECUTED();
/*     */           } else {
/* 393 */             double inj = (STATS.NEEDS()).INJURIES.COUNT.indu().getD(oo.indu());
/* 394 */             am = Math.min(am, 0.3D - inj);
/* 395 */             if (am < 0.0D) {
/* 396 */               return false;
/*     */             }
/*     */           } 
/* 399 */           if (!oo.inflictDamage(0.1D, ll)) {
/* 400 */             return true;
/*     */           }
/*     */         } 
/*     */         
/* 404 */         if (d.plansub() == AIPlanGladiator.this.fightSub) {
/* 405 */           AIPlanGladiator.this.fightSub.event(a, d, e);
/* 406 */         } else if (AIPlanGladiator.this.shouldFight(a, d)) {
/* 407 */           d.otherEntitySet((Humanoid)e.other);
/* 408 */           d.overwrite(a, AIPlanGladiator.this.fight.set(a, d));
/*     */         } 
/* 410 */         if (AIPlanGladiator.this.toDeath && RND.oneIn(5) && 
/* 411 */           !a.inflictDamage(RND.rFloat(), CAUSE_LEAVES.EXECUTED())) {
/* 412 */           return false;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 418 */         return true;
/*     */       } 
/*     */       
/* 421 */       return super.event(a, d, e);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\a\\util\AIPlanGladiator.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */