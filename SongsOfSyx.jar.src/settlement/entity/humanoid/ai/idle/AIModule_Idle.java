/*     */ package settlement.entity.humanoid.ai.idle;
/*     */ 
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.time.TIME;
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.HPoll;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIModule;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.util.FINDABLE;
/*     */ import settlement.path.finders.SFinderFindable;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.text.D;
/*     */ 
/*     */ public final class AIModule_Idle
/*     */   extends AIModule
/*     */ {
/*  29 */   private static CharSequence ¤¤name = "Biding Time";
/*  30 */   private static CharSequence ¤¤name2 = "Bide Time"; private final PlanInterract inter;
/*     */   static {
/*  32 */     D.ts(AIModule_Idle.class);
/*     */   }
/*     */   private final AIPLAN plan; private final AIPLAN bench;
/*     */   public AIModule_Idle() {
/*  36 */     super((SPRITE)(UI.icons()).s.cancel, ¤¤name2, ¤¤name);
/*     */ 
/*     */ 
/*     */     
/*  40 */     this.inter = new PlanInterract();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  46 */     this.plan = (AIPLAN)new AIPLAN.PLANRES("idlePlan")
/*     */       {
/*  48 */         private final SubStand sub = new SubStand((AIPLAN)this, "idlestand");
/*  49 */         private final SubMove walk = new SubMove("idlewalk");
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation init(Humanoid a, AIManager d) {
/*  53 */           return this.start.set(a, d);
/*     */         }
/*     */ 
/*     */         
/*  57 */         private final AIPLAN.PLANRES.Resumer start = new AIPLAN.PLANRES.Resumer(this, AIModule_Idle.¤¤name)
/*     */           {
/*     */ 
/*     */ 
/*     */             
/*     */             protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */             {
/*  64 */               if ((SETT.PATH()).finders.getOutofWay.shouldFind((ENTITY)a)) {
/*  65 */                 (SETT.PATH()).finders.getOutofWay.request(a, d.path);
/*  66 */                 return AIModule_Idle.null.this.walking.set(a, d);
/*     */               } 
/*     */ 
/*     */ 
/*     */ 
/*     */               
/*  72 */               if (RND.oneIn(10))
/*  73 */                 return AIModule_Idle.null.this.walk.activate(a, d); 
/*  74 */               return AIModule_Idle.null.this.sub.activate(a, d);
/*     */             }
/*     */ 
/*     */             
/*     */             protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/*  79 */               if (AIModule_Idle.null.access$0(AIModule_Idle.null.this).moduleCanContinue(a, d)) {
/*  80 */                 if (RND.oneIn(15))
/*  81 */                   return AIModule_Idle.null.this.walk.activate(a, d); 
/*  82 */                 return AIModule_Idle.null.this.sub.activate(a, d);
/*     */               } 
/*  84 */               return null;
/*     */             }
/*     */ 
/*     */             
/*     */             public boolean con(Humanoid a, AIManager d) {
/*  89 */               return true;
/*     */             }
/*     */ 
/*     */ 
/*     */             
/*     */             public void can(Humanoid a, AIManager d) {}
/*     */ 
/*     */ 
/*     */             
/*     */             public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/*  99 */               if (e.type == HPoll.CAN_INTERRACT && a.speed.isZero())
/* 100 */                 return 1.0D; 
/* 101 */               return super.poll(a, d, e);
/*     */             }
/*     */           };
/*     */         
/* 105 */         private final AIPLAN.PLANRES.Resumer walking = new AIPLAN.PLANRES.Resumer(this, AIModule_Idle.¤¤name)
/*     */           {
/*     */             protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */             {
/* 109 */               return (AI.SUBS()).STAND.activateRndDir(a, d, 1 + RND.rInt(4));
/*     */             }
/*     */ 
/*     */             
/*     */             protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 114 */               if (AIModule_Idle.null.access$0(AIModule_Idle.null.this).moduleCanContinue(a, d)) {
/* 115 */                 if ((SETT.PATH()).finders.getOutofWay.checkAndSetRequest(a.tc().x(), a.tc().y(), d.path)) {
/* 116 */                   return AIModule_Idle.null.this.exit.set(a, d);
/*     */                 }
/* 118 */                 return (AI.SUBS()).STAND.activateRndDir(a, d, 1 + RND.rInt(4));
/*     */               } 
/* 120 */               return null;
/*     */             }
/*     */ 
/*     */             
/*     */             public boolean con(Humanoid a, AIManager d) {
/* 125 */               return true;
/*     */             }
/*     */ 
/*     */ 
/*     */             
/*     */             public void can(Humanoid a, AIManager d) {}
/*     */           };
/*     */ 
/*     */         
/* 134 */         private final AIPLAN.PLANRES.Resumer exit = new AIPLAN.PLANRES.Resumer(this)
/*     */           {
/*     */             protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */             {
/* 138 */               if (d.path.isSuccessful()) {
/* 139 */                 return (AI.SUBS()).walkTo.pathFull(a, d);
/*     */               }
/* 141 */               if (RND.oneIn(15))
/* 142 */                 return AIModule_Idle.null.this.walk.activate(a, d); 
/* 143 */               return AIModule_Idle.null.this.sub.activate(a, d);
/*     */             }
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 150 */               return null;
/*     */             }
/*     */ 
/*     */             
/*     */             public boolean con(Humanoid a, AIManager d) {
/* 155 */               return true;
/*     */             }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             public void can(Humanoid a, AIManager d) {}
/*     */           };
/*     */       };
/* 167 */     this.bench = (AIPLAN)new AIPLAN.PLANRES("idleBench")
/*     */       {
/*     */         protected AISUB.AISubActivation init(Humanoid a, AIManager d)
/*     */         {
/* 171 */           int r = STATS.RAN().get(a.indu(), 39) + TIME.hours().bitsSinceStart();
/* 172 */           r &= 0xFF;
/*     */ 
/*     */ 
/*     */           
/* 176 */           if (r > 127) {
/* 177 */             FINDABLE ff = (SETT.ROOMS()).BENCH.finder.getReservable(a.tc().x(), a.tc().y());
/* 178 */             if (ff != null) {
/* 179 */               d.planTile.set((COORDINATE)ff);
/* 180 */               ff.findableReserve();
/* 181 */               this.walk.set(a, d);
/* 182 */               return (AI.SUBS()).STAND.activateTime(a, d, 1);
/*     */             } 
/* 184 */             AISUB.AISubActivation s = (AI.SUBS()).walkTo.serviceInclude(a, d, (SFinderFindable)(SETT.ROOMS()).BENCH.finder, (SETT.ROOMS()).BENCH.radius());
/* 185 */             if (s != null) {
/* 186 */               d.planTile.set(d.path.destX(), d.path.destY());
/* 187 */               this.walk.set(a, d);
/* 188 */               return s;
/*     */             } 
/* 190 */             if (!(SETT.ROOMS()).map.is(a.tc()) && (SETT.FLOOR()).getter.is(a.tc())) {
/* 191 */               (STATS.SERVICE()).bench.clearAccess(a.indu());
/*     */             }
/*     */           } 
/*     */           
/* 195 */           return null;
/*     */         }
/*     */ 
/*     */         
/* 199 */         private final AIPLAN.PLANRES.Resumer walk = new AIPLAN.PLANRES.Resumer(this, AIModule_Idle.¤¤name)
/*     */           {
/*     */             protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */             {
/* 203 */               d.planByte1 = 16;
/* 204 */               return null;
/*     */             }
/*     */ 
/*     */             
/*     */             protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 209 */               if ((SETT.ROOMS()).BENCH.finder.getReserved(d.planTile.x(), d.planTile.y()) == null) {
/* 210 */                 return null;
/*     */               }
/* 212 */               (STATS.SERVICE()).bench.access.indu().set(a.indu(), 1);
/* 213 */               Room bb = (SETT.ROOMS()).BENCH.get(d.planTile.x(), d.planTile.y());
/* 214 */               (STATS.SERVICE()).bench.setAccess(a.indu(), true, 1.0D - bb.getDegrade(d.planTile.x(), d.planTile.y()), bb.upgrade(d.planTile.x(), d.planTile.y()));
/* 215 */               d.planByte1 = (byte)(d.planByte1 - 1); if (d.planByte1 < 0 || !AIModule_Idle.null.access$0(AIModule_Idle.null.this).moduleCanContinue(a, d)) {
/* 216 */                 can(a, d);
/* 217 */                 return null;
/*     */               } 
/*     */               
/* 220 */               DIR dir = (SETT.ROOMS()).BENCH.benchDir(d.planTile.x(), d.planTile.y(), a.speed.dir());
/* 221 */               if (RND.oneIn(4))
/* 222 */                 dir = dir.next((int)RND.rSign()); 
/* 223 */               a.speed.setDirCurrent(dir);
/* 224 */               return (AI.SUBS()).STAND.activateTime(a, d, 1 + RND.rInt(10));
/*     */             }
/*     */ 
/*     */             
/*     */             public boolean con(Humanoid a, AIManager d) {
/* 229 */               return true;
/*     */             }
/*     */ 
/*     */             
/*     */             public void can(Humanoid a, AIManager d) {
/* 234 */               FINDABLE s = (SETT.ROOMS()).BENCH.finder.getReserved(d.planTile.x(), d.planTile.y());
/* 235 */               if (s != null) {
/* 236 */                 s.findableReserveCancel();
/*     */               }
/*     */             }
/*     */             
/*     */             public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/* 241 */               if (e.type == HPoll.CAN_INTERRACT && a.speed.isZero())
/* 242 */                 return 1.0D; 
/* 243 */               return super.poll(a, d, e);
/*     */             }
/*     */           };
/*     */       };
/*     */   } public AIPLAN interract() {
/*     */     return this.inter.interract;
/*     */   }
/*     */   public AIPLAN.AiPlanActivation getPlan(Humanoid a, AIManager d) {
/* 251 */     AIPLAN.AiPlanActivation p = this.bench.activate(a, d);
/* 252 */     if (p != null) {
/* 253 */       return p;
/*     */     }
/*     */     
/* 256 */     if ((SETT.PATH()).finders.getOutofWay.shouldFind((ENTITY)a))
/* 257 */       return this.plan.activate(a, d); 
/* 258 */     double b = (BOOSTABLES.ACTIVITY()).SOCIAL.get((BOOSTABLE_O)a.indu());
/* 259 */     if (b > 0.0D && RND.oneIn(5.0D / b)) {
/* 260 */       p = this.inter.lookForFriend.activate(a, d);
/* 261 */       if (p != null)
/* 262 */         return p; 
/*     */     } 
/* 264 */     return this.plan.activate(a, d);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void update(Humanoid a, AIManager d, boolean newDay, int byteDelta, int upI) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public int getPriority(Humanoid a, AIManager d) {
/* 274 */     return 0;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\idle\AIModule_Idle.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */