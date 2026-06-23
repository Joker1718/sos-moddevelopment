/*     */ package settlement.entity.humanoid.ai.battle;
/*     */ 
/*     */ import game.battle.div.Div;
/*     */ import settlement.entity.humanoid.HEvent;
/*     */ import settlement.entity.humanoid.HPoll;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISTATE;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.VectorImp;
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
/*     */ class null
/*     */   extends AIPLAN.PLANRES
/*     */ {
/*     */   private final VectorImp vec;
/*     */   private AIPLAN.PLANRES.Resumer cutTo;
/*     */   private AIPLAN.PLANRES.Resumer path;
/*     */   private AIPLAN.PLANRES.Resumer fail;
/*     */   
/*     */   null(String $anonymous0) {
/*  90 */     super($anonymous0);
/*     */     
/*  92 */     this.vec = new VectorImp();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 145 */     this.cutTo = new AIPLAN.PLANRES.Resumer(this, PlanEscape.¤¤Reforming)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 149 */           if (PlanEscape.null.this.sett(a, d)) {
/* 150 */             AISTATE s = (AI.STATES()).PUSH_TO.move(a, d, (a.division()).reporter.getPixel(a).x(), (a.division()).reporter.getPixel(a).y(), 0.5D + RND.rFloat0(0.5D), 0.75D);
/* 151 */             return (AI.SUBS()).single.activate(a, d, s);
/*     */           } 
/* 153 */           return PlanEscape.null.this.fail.set(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 158 */           if (BattleUtil.shouldMoveIntoDivPosition(a, d))
/* 159 */             return PlanEscape.null.this.init(a, d); 
/* 160 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 165 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 175 */           if (e.event == HEvent.MEET_ENEMY) {
/* 176 */             if (e.speedHasChanged)
/* 177 */               a.speed.setPrevDir(); 
/* 178 */             return true;
/*     */           } 
/*     */           
/* 181 */           if (e.event == HEvent.COLLISION_SOFT) {
/* 182 */             a.speed.setPrevDir();
/* 183 */             return true;
/*     */           } 
/*     */ 
/*     */           
/* 187 */           return InterBattle.listener.event(a, d, e);
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/* 193 */     this.path = new AIPLAN.PLANRES.Resumer(this, PlanEscape.¤¤Reforming)
/*     */       {
/*     */         
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 198 */           if (!d.path.request(a, (a.division()).reporter.getTile(a).x(), (a.division()).reporter.getTile(a).y())) {
/* 199 */             return PlanEscape.null.this.fail.set(a, d);
/*     */           }
/* 201 */           return nextTile(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         private AISUB.AISubActivation nextTile(Humanoid a, AIManager d) {
/* 206 */           if ((a.division()).reporter.getTile(a).tileDistanceTo(d.path.destX(), d.path.destY()) > 2.0D) {
/* 207 */             return PlanEscape.null.this.init(a, d);
/*     */           }
/* 209 */           if (COORDINATE.tileDistance(a.body().cX(), a.body().cY(), d.path().getSettCX(), d.path().getSettCY()) < 16.0D) {
/* 210 */             if (d.path.hasNext()) {
/* 211 */               d.path.setNext();
/*     */             } else {
/* 213 */               return PlanEscape.null.this.fail.set(a, d);
/*     */             } 
/*     */           }
/* 216 */           if (!d.path.isSuccessful()) {
/* 217 */             return PlanEscape.null.this.fail.set(a, d);
/*     */           }
/* 219 */           AISTATE s = (AI.STATES()).PUSH_TO.move(a, d, d.path.getSettCX(), d.path.getSettCY(), 0.5D + RND.rFloat0(0.5D), 0.75D);
/* 220 */           return (AI.SUBS()).single.activate(a, d, s);
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 225 */           if (!BattleUtil.shouldMoveIntoDivPosition(a, d))
/* 226 */             return null; 
/* 227 */           return nextTile(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 232 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 242 */           if (e.event == HEvent.MEET_ENEMY) {
/* 243 */             if (e.speedHasChanged)
/* 244 */               a.speed.setPrevDir(); 
/* 245 */             return true;
/*     */           } 
/*     */           
/* 248 */           if (e.event == HEvent.COLLISION_SOFT) {
/* 249 */             a.speed.setPrevDir();
/* 250 */             return true;
/*     */           } 
/*     */ 
/*     */           
/* 254 */           return InterBattle.listener.event(a, d, e);
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/* 260 */     this.fail = new AIPLAN.PLANRES.Resumer(this, PlanEscape.¤¤Reforming)
/*     */       {
/*     */         
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 265 */           if (a.division() != null) {
/* 266 */             a.speed.setDirCurrent(a.division().dir());
/*     */           } else {
/* 268 */             a.speed.setPrevDir();
/* 269 */           }  return (AI.SUBS()).single.activate(a, d, (AI.STATES()).STAND_SWORD.activate(a, d, 0.5D));
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 274 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 279 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */ 
/*     */         
/*     */         public boolean event(Humanoid a, AIManager d, HEvent.HEventData e)
/*     */         {
/* 289 */           if (e.event == HEvent.MEET_ENEMY) {
/* 290 */             if (a.division() != null) {
/* 291 */               a.speed.setDirCurrent(a.division().dir());
/*     */             } else {
/* 293 */               a.speed.setPrevDir();
/* 294 */             }  return true;
/*     */           } 
/*     */           
/* 297 */           if (e.event == HEvent.COLLISION_SOFT) {
/* 298 */             if (a.division() != null) {
/* 299 */               a.speed.setDirCurrent(a.division().dir());
/*     */             } else {
/* 301 */               a.speed.setPrevDir();
/* 302 */             }  return true;
/*     */           } 
/*     */ 
/*     */           
/* 306 */           return InterBattle.listener.event(a, d, e); }
/*     */       }; } protected AISUB.AISubActivation init(Humanoid a, AIManager d) { Div div = a.division(); if (div == null)
/*     */       return this.fail.set(a, d);  if (!div.reporter.posHas(a))
/*     */       return this.fail.set(a, d);  int startX = a.body().cX(); int startY = a.body().cY(); int endX = (a.division()).reporter.getPixel(a).x(); int endY = (a.division()).reporter.getPixel(a).y(); double m = this.vec.set(startX, startY, endX, endY); if (m > 12.0D)
/*     */       return this.path.set(a, d); 
/*     */     for (int i = 64; i < m; i += 64) {
/*     */       int tx = (int)(startX + i * this.vec.nX() * 0.015625D);
/*     */       int ty = (int)(startX + i * this.vec.nX() * 0.015625D);
/*     */       int tx2 = (int)(startX + (i - 64) * this.vec.nX() * 0.015625D);
/*     */       int ty2 = (int)(startX + (i - 64) * this.vec.nX() * 0.015625D);
/*     */       if ((SETT.PATH()).solidity.is(tx, ty) || (SETT.PATH()).solidity.is(tx2, ty) || (SETT.PATH()).solidity.is(tx, ty2))
/*     */         return this.path.set(a, d); 
/*     */     } 
/* 319 */     return this.cutTo.set(a, d); } public double poll(Humanoid a, AIManager d, HPoll.HPollData e) { if (e.type == HPoll.COLLIDES) {
/* 320 */       if (e.other instanceof Humanoid) {
/* 321 */         return ((((Humanoid)e.other).indu().hostile() != a.indu().hostile()) ? true : false);
/*     */       }
/* 323 */       return 1.0D;
/*     */     } 
/* 325 */     return InterBattle.listener.poll(a, d, e); }
/*     */   private boolean sett(Humanoid a, AIManager d) { Div div = a.division(); if (div == null)
/*     */       return false;  double m = COORDINATE.tileDistance(a.body().cX(), a.body().cY(), (a.division()).reporter.getPixel(a));
/*     */     if (m > 32.0D)
/*     */       return true; 
/* 330 */     return false; } public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) { if (e.event == HEvent.MEET_ENEMY)
/* 331 */       return true; 
/* 332 */     if (e.event == HEvent.COLLISION_SOFT) {
/* 333 */       return true;
/*     */     }
/*     */ 
/*     */     
/* 337 */     return InterBattle.listener.event(a, d, e); }
/*     */ 
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\battle\PlanEscape$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */