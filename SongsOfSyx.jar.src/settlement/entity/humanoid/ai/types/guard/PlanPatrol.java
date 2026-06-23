/*     */ package settlement.entity.humanoid.ai.types.guard;
/*     */ 
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
/*     */ import settlement.room.law.guard.Patrol;
/*     */ import settlement.room.law.guard.Patrols;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import util.text.D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class PlanPatrol
/*     */   extends AIPLAN.PLANRES
/*     */ {
/*     */   protected PlanPatrol() {
/*  31 */     super("GUARD_PATROL");
/*     */ 
/*     */ 
/*     */     
/*  35 */     this.cutDistance = 2048;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 106 */     this.cutToPosition = new AIPLAN.PLANRES.Resumer(this, ¤¤Reforming)
/*     */       {
/* 108 */         private final AISUB sub = (AISUB)new AISUB.Simple("GuardCutTo")
/*     */           {
/* 110 */             private final int distFar = 9216;
/* 111 */             private final double distFarI = 1.0850694444444444E-4D;
/* 112 */             private final int distClose = 512;
/* 113 */             private final double distCloseI = 0.001953125D;
/*     */ 
/*     */             
/*     */             protected AISTATE resume(Humanoid a, AIManager d) {
/* 117 */               d.subByte = (byte)(d.subByte + 1);
/* 118 */               if (!PlanPatrol.null.access$0(PlanPatrol.null.this).valid(d)) {
/* 119 */                 return null;
/*     */               }
/* 121 */               Coo coo = PlanPatrol.null.access$0(PlanPatrol.null.this).coo(d);
/*     */               
/* 123 */               if (PlanPatrol.null.access$0(PlanPatrol.null.this).isInPosition((COORDINATE)coo, a, d)) {
/* 124 */                 a.speed.magnitudeInit(0.0D);
/* 125 */                 if (d.subByte == 1)
/* 126 */                   return (AI.STATES()).STAND.activate(a, d, 0.05D); 
/* 127 */                 return null;
/*     */               } 
/*     */               
/* 130 */               double speed = Patrol.speed * 64.0D;
/*     */               
/* 132 */               int distX = coo.x() - a.physics.body().cX();
/* 133 */               int distY = coo.y() - a.physics.body().cY();
/* 134 */               double dist = (distX * distX + distY * distY);
/*     */               
/* 136 */               if (dist > 9216.0D) {
/* 137 */                 speed += a.speed.magintudeMax() * (dist - 9216.0D) * 1.0850694444444444E-4D;
/* 138 */               } else if (dist < 512.0D) {
/* 139 */                 speed *= dist * 0.001953125D;
/*     */               } 
/*     */               
/* 142 */               speed = CLAMP.d(speed, 0.0D, a.speed.magintudeMax());
/*     */ 
/*     */ 
/*     */               
/* 146 */               AISTATE s = (AI.STATES()).MOVE_TO.move(a, d, coo.x(), coo.y(), 0.05D, speed);
/*     */               
/* 148 */               return s;
/*     */             }
/*     */           };
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 156 */           DIR dir = PlanPatrol.this.p().dir(d.planObject);
/* 157 */           if ((dir.x() != 0 || dir.y() != 0) && 
/* 158 */             (SETT.PATH()).coster.player.getCost(a.tc().x(), a.tc().y(), a.tc().x() + dir.x(), a.tc().y() + dir.y()) < 0.0D) {
/* 159 */             return PlanPatrol.this.pathToPosition.set(a, d);
/*     */           }
/* 161 */           return this.sub.activate(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 166 */           return PlanPatrol.this.retry2(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public AISUB.AISubActivation resFailed(Humanoid a, AIManager d, HEvent event) {
/* 171 */           if (event == HEvent.COLLISION_TILE) {
/* 172 */             return PlanPatrol.this.pathToPosition.set(a, d);
/*     */           }
/* 174 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 179 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/* 188 */     this.pathToPosition = new AIPLAN.PLANRES.Resumer(this, ¤¤Reforming)
/*     */       {
/* 190 */         private final AISUB sub = (AISUB)new AISUB.Simple("GuardCut")
/*     */           {
/*     */             protected AISTATE resume(Humanoid a, AIManager d) {
/* 193 */               d.subByte = (byte)(d.subByte + 1);
/* 194 */               if (d.subByte == 1)
/* 195 */                 return (AI.STATES()).WALK2.path(a, d); 
/* 196 */               return null;
/*     */             }
/*     */           };
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 204 */           Coo coo = PlanPatrol.this.coo(d);
/* 205 */           int tx = coo.x() / 64;
/* 206 */           int ty = coo.y() / 64;
/*     */ 
/*     */           
/* 209 */           d.path.request(a.physics.tileC(), tx, ty);
/* 210 */           if (!d.path.isSuccessful())
/* 211 */             return null; 
/* 212 */           d.planByte2 = (byte)(8 + d.path.length() / 2);
/* 213 */           return this.sub.activate(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 218 */           if (!d.path.isSuccessful())
/* 219 */             return null; 
/* 220 */           d.planByte2 = (byte)(d.planByte2 - 1); if (d.path.isDest() || d.planByte2 <= 0) {
/* 221 */             return PlanPatrol.this.retry2(a, d);
/*     */           }
/* 223 */           d.path.setNext();
/* 224 */           return this.sub.activate(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 229 */           return true;
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
/* 240 */     this.stand = new AISTATES.STOP("MP_GUARD_STAND", HSprites.SWORD_STAND_SWAY);
/*     */     
/* 242 */     this.beBraced = new AIPLAN.PLANRES.Resumer(this, ¤¤Reforming)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 250 */           d.subByte = 0;
/* 251 */           return (AI.SUBS()).single.activate(a, d, PlanPatrol.this.stand.activate(a, d, 0.5D));
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 257 */           d.subByte = (byte)(d.subByte + 1);
/*     */           
/* 259 */           if (d.subByte < 50 || !PlanPatrol.this.isInPosition((COORDINATE)PlanPatrol.this.coo(d), a, d)) {
/* 260 */             return PlanPatrol.this.retry2(a, d);
/*     */           }
/* 262 */           a.speed.turn2(PlanPatrol.this.p().dir(d.planObject));
/* 263 */           return (AI.SUBS()).single.activate(a, d, PlanPatrol.this.stand.activate(a, d, 0.5D));
/*     */         }
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d)
/*     */         {
/* 268 */           return true;
/*     */         }
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/*     */   } private static CharSequence ¤¤Reforming = "¤Patrolling"; private final int cutDistance = 2048; private final AIPLAN.PLANRES.Resumer cutToPosition; private final AIPLAN.PLANRES.Resumer pathToPosition; private final AISTATES.STOP stand; private final AIPLAN.PLANRES.Resumer beBraced; static {
/*     */     D.ts(PlanPatrol.class);
/*     */   } protected AISUB.AISubActivation init(Humanoid a, AIManager d) {
/*     */     int pos = p().reservePosition();
/*     */     if (pos < 0)
/*     */       return null; 
/*     */     d.planObject = pos;
/*     */     return retry2(a, d);
/*     */   }
/* 281 */   protected AISUB.AISubActivation resume(Humanoid a, AIManager d) { AISUB.AISubActivation s = super.resume(a, d);
/* 282 */     if (s == null)
/* 283 */       p().returnPosition(d.planObject); 
/* 284 */     return s; }
/*     */   private AISUB.AISubActivation retry2(Humanoid a, AIManager d) { if ((STATS.WORK()).WORK_TIME.indu().getD(a.indu()) >= 1.0D) return null;  if ((STATS.BATTLE()).DIV.get(a) == null) return null;  Coo coo = coo(d); if (coo == null)
/*     */       return null;  if (!(SETT.PATH()).connectivity.is(coo.x() / 64, coo.y() / 64))
/*     */       return null;  if (isInPosition((COORDINATE)coo, a, d))
/*     */       return this.beBraced.set(a, d);  if (COORDINATE.tileDistance((COORDINATE)coo, a.body().cX(), a.body().cY()) < 2048.0D)
/* 289 */       return this.cutToPosition.set(a, d);  return this.pathToPosition.set(a, d); } protected void cancel(Humanoid a, AIManager d) { p().returnPosition(d.planObject);
/* 290 */     super.cancel(a, d); } private boolean isInPosition(COORDINATE dest, Humanoid a, AIManager d) { return dest.isSameAs(a.physics.body().cX(), a.physics.body().cY()); }
/*     */   private Patrols p() { return (SETT.ROOMS()).GUARD.patrols; }
/*     */   private Coo coo(AIManager d) { return p().pos(d.planObject); }
/*     */   private boolean valid(AIManager d) { Coo coo = p().pos(d.planObject); if (coo == null) return false;  if (!(SETT.PATH()).connectivity.is(coo.x() / 64, coo.y() / 64))
/*     */       return false;  return true; }
/* 295 */   public double poll(Humanoid a, AIManager d, HPoll.HPollData e) { if (e.type == HPoll.WORKING)
/* 296 */       return 1.0D; 
/* 297 */     return super.poll(a, d, e); }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 302 */     if (e.event == HEvent.NOTIFY_CRIME && 
/* 303 */       e.other instanceof Humanoid) {
/* 304 */       d.overwrite(a, AI.listeners().catchCriminal((Humanoid)e.other));
/* 305 */       return true;
/*     */     } 
/*     */     
/* 308 */     return super.event(a, d, e);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\types\guard\PlanPatrol.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */