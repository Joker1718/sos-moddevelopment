/*     */ package settlement.entity.humanoid.ai.battle;
/*     */ import game.GAME;
/*     */ import game.time.TIME;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.HEvent;
/*     */ import settlement.entity.humanoid.HPoll;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISTATE;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.entity.humanoid.spirte.HSprites;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.rnd.RND;
/*     */ 
/*     */ final class MarchSoftCollision extends AISUB.Resumable {
/*     */   private final AISUB.Resumable.Resumer push;
/*     */   private final AISUB.Resumable.Resumer brakes;
/*     */   private final AISUB.Resumable.Resumer strike;
/*     */   private final AISUB.Resumable.Resumer strike2;
/*     */   
/*     */   AISUB.AISubActivation initReady(AIManager d, Humanoid a, ENTITY other, double norX, double norY, double faceDot, double momentum) {
/*  25 */     d.subPathByte = 5;
/*  26 */     if (other instanceof Humanoid) {
/*  27 */       Humanoid o = (Humanoid)other;
/*  28 */       if (o.indu().hostile() != a.indu().hostile()) {
/*  29 */         d.otherEntitySet((Humanoid)other);
/*     */       }
/*     */     } 
/*     */     
/*  33 */     return activate(a, d, gg(a, d));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   AISUB.AISubActivation initCoo(AIManager d, Humanoid a, ENTITY other, int px, int py) {
/*  40 */     d.subPathByte = 5;
/*  41 */     if (other instanceof Humanoid) {
/*  42 */       Humanoid o = (Humanoid)other;
/*  43 */       if (o.indu().hostile() != a.indu().hostile()) {
/*  44 */         d.otherEntitySet((Humanoid)other);
/*     */       }
/*     */     } 
/*  47 */     return activate(a, d, gg(a, d));
/*     */   }
/*     */ 
/*     */   
/*     */   protected MarchSoftCollision() {
/*  52 */     super("MarchSoftColl");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  77 */     this.push = new ResumerB(this)
/*     */       {
/*     */         protected AISTATE setAction(Humanoid a, AIManager d)
/*     */         {
/*  81 */           d.subPathByte = (short)(d.subPathByte - 1);
/*  82 */           return (AI.STATES()).PUSH_TO.move(a, d, (a.division()).reporter.getPixel(a).x(), (a.division()).reporter.getPixel(a).y(), 1.0D, 0.75D);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected AISTATE res(Humanoid a, AIManager d) {
/*  88 */           if (d.subPathByte < 0 && d.subByte >= 0) {
/*  89 */             AIPLAN p = (AI.modules()).battle.escape.plan(a, d);
/*  90 */             if (p != null) {
/*  91 */               return d.resumeOtherPlanState(a, p);
/*     */             }
/*     */           } 
/*  94 */           return MarchSoftCollision.this.strike.set(a, d);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  99 */     this.brakes = new ResumerB(this)
/*     */       {
/*     */         protected AISTATE setAction(Humanoid a, AIManager d)
/*     */         {
/* 103 */           d.subByte = 0;
/* 104 */           if (a.division() != null)
/* 105 */             a.speed.setDirCurrent(a.division().dir()); 
/* 106 */           return (AI.STATES()).STAND_SWORD.activate(a, d, RND.rFloat0(0.5D));
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISTATE res(Humanoid a, AIManager d) {
/* 111 */           return MarchSoftCollision.this.strike.set(a, d);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 116 */     this.strike = new ResumerB(this) {
/* 117 */         private final AISTATE state = (AI.STATES()).SWORD.strike;
/* 118 */         private final float time = (float)HSprites.SWORD_OUT.time;
/*     */ 
/*     */         
/*     */         public AISTATE setAction(Humanoid a, AIManager d) {
/* 122 */           a.spriteTimer = 0.0F;
/* 123 */           d.stateTimer = this.time;
/* 124 */           a.speed.magnitudeTargetSet(0.0D);
/*     */ 
/*     */ 
/*     */           
/* 128 */           return this.state;
/*     */         }
/*     */ 
/*     */         
/*     */         public AISTATE res(Humanoid a, AIManager d) {
/* 133 */           return MarchSoftCollision.this.strike2.set(a, d);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 138 */     this.strike2 = new ResumerB(this)
/*     */       {
/* 140 */         private final AISTATE state = (AI.STATES()).SWORD.strikeIn;
/* 141 */         private final float time = (float)HSprites.SWORD_IN.time;
/*     */ 
/*     */ 
/*     */         
/*     */         public AISTATE setAction(Humanoid a, AIManager d) {
/* 146 */           if (d.otherEntity() != null) {
/* 147 */             int dist = a.body().getDistance(d.otherEntity().body());
/* 148 */             if (dist <= (a.body().width() + d.otherEntity().body().width()) / 2 + 24) {
/* 149 */               Humanoid enemy = d.otherEntity();
/* 150 */               (GAME.battle()).fight.attack(a, (ENTITY)enemy);
/*     */             } 
/*     */           } 
/*     */ 
/*     */ 
/*     */           
/* 156 */           a.spriteTimer = 0.0F;
/* 157 */           d.stateTimer = this.time;
/* 158 */           a.speed.magnitudeTargetSet(0.0D);
/*     */           
/* 160 */           return this.state;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public AISTATE res(Humanoid a, AIManager d) {
/* 167 */           return null;
/*     */         }
/*     */       }; } protected AISTATE init(Humanoid a, AIManager d) { return null; } private AISUB.Resumable.Resumer gg(Humanoid a, AIManager d) { if (a.division() != null)
/*     */       a.speed.setDirCurrent(a.division().dir());  if (BattleUtil.shouldMoveIntoDivPosition(a, d)) { double m = COORDINATE.tileDistance(a.body().cX(), a.body().cY(), (a.division()).reporter.getPixel(a)); if (m > 32.0D)
/*     */         return this.push;  }
/* 172 */      return this.brakes; } private abstract class ResumerB extends AISUB.Resumable.Resumer { private ResumerB() { super(MarchSoftCollision.this); }
/*     */     
/*     */     public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/*     */       AISUB.Resumable.Resumer ss;
/* 176 */       switch (e.event) {
/*     */         
/*     */         case COLLISION_SOFT:
/* 179 */           a.speed.setPrevDir();
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 184 */           ss = MarchSoftCollision.this.gg(a, d);
/* 185 */           if (MarchSoftCollision.this.getResumer(a, d) != MarchSoftCollision.this.push && ss != MarchSoftCollision.this.push) {
/* 186 */             d.overwrite(a, ss.set(a, d));
/* 187 */           } else if (a.division() != null) {
/* 188 */             a.speed.setDirCurrent(a.division().dir());
/*     */           } else {
/* 190 */             a.speed.setPrevDir();
/*     */           } 
/* 192 */           return true;
/*     */         case EXHAUST:
/* 194 */           if (RND.oneIn((BOOSTABLES.PHYSICS()).STAMINA.get((BOOSTABLE_O)a.indu()) * 8.0D))
/*     */           {
/* 196 */             (STATS.NEEDS()).EXHASTION.indu().inc(a.indu(), 1);
/*     */           }
/* 198 */           return false;
/*     */         case MEET_ENEMY:
/* 200 */           a.speed.setPrevDir();
/* 201 */           d.otherEntitySet((Humanoid)e.other);
/* 202 */           ss = MarchSoftCollision.this.gg(a, d);
/* 203 */           if (MarchSoftCollision.this.getResumer(a, d) != MarchSoftCollision.this.push && ss != MarchSoftCollision.this.push) {
/* 204 */             d.overwrite(a, ss.set(a, d));
/* 205 */           } else if (a.division() != null) {
/* 206 */             a.speed.setDirCurrent(a.division().dir());
/*     */           } else {
/* 208 */             a.speed.setPrevDir();
/*     */           } 
/* 210 */           return false;
/*     */         
/*     */         case MEET_HARMLESS:
/* 213 */           return false;
/*     */       } 
/*     */       
/* 216 */       return InterBattle.listener.event(a, d, e);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/* 223 */       switch (e.type) {
/*     */         case COLLIDES:
/* 225 */           return 1.0D;
/*     */         case WILL_COLLIDE_WITH:
/* 227 */           if (e.other instanceof Humanoid && ((Humanoid)e.other).indu().hostile() != a.indu().hostile()) {
/* 228 */             return 1.0D;
/*     */           }
/* 230 */           if (TIME.currentSecond() - d.lastCollision < 3.0D) {
/* 231 */             return 1.0D;
/*     */           }
/*     */ 
/*     */           
/* 235 */           return 0.0D;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 240 */       return InterBattle.listener.poll(a, d, e);
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\battle\MarchSoftCollision.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */