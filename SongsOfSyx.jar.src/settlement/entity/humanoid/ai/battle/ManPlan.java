/*     */ package settlement.entity.humanoid.ai.battle;
/*     */ 
/*     */ import game.GAME;
/*     */ import settlement.entity.humanoid.HEvent;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.finders.SFinderFindable;
/*     */ import settlement.path.finders.SFinderSoldierManning;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.rnd.RND;
/*     */ import util.text.D;
/*     */ 
/*     */ final class ManPlan
/*     */   extends AIPLAN.PLANRES {
/*     */   ManPlan(String key) {
/*  20 */     super(key);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  46 */     this.wait = new AIPLAN.PLANRES.Resumer(this, ¤¤Name)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/*  50 */           AISUB.AISubActivation s = (AI.SUBS()).walkTo.serviceInclude(a, d, (SFinderFindable)(SETT.PATH()).finders.manning(a.indu().army()), 100);
/*  51 */           if (s != null) {
/*  52 */             ManPlan.this.walk.set(a, d);
/*  53 */             return s;
/*     */           } 
/*  55 */           return (AI.SUBS()).STAND.activateTime(a, d, 5);
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/*  60 */           AISUB.AISubActivation s = (AI.SUBS()).walkTo.serviceInclude(a, d, (SFinderFindable)(SETT.PATH()).finders.manning(a.indu().army()), 2147483647);
/*  61 */           if (s != null) {
/*  62 */             ManPlan.this.walk.set(a, d);
/*  63 */             return s;
/*     */           } 
/*  65 */           if (!a.indu().player())
/*  66 */             (STATS.BATTLE()).ROUTING.indu().set(a.indu(), 1); 
/*  67 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/*  72 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/*  82 */     this.walk = new AIPLAN.PLANRES.Resumer(this, ¤¤Name)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/*  86 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/*  91 */           SFinderSoldierManning.FINDABLE_MANNING f = (SETT.PATH()).finders.manning(a.indu().army()).getReserved(d.path.destX(), d.path.destY());
/*  92 */           if (f == null)
/*  93 */             return null; 
/*  94 */           a.speed.setDirCurrent(f.faceDIR());
/*  95 */           if (!(AI.modules()).battle.moduleCanContinue(a, d)) {
/*  96 */             can(a, d);
/*  97 */             return null;
/*     */           } 
/*  99 */           return ManPlan.this.stand.set(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 104 */           return true;
/*     */         }
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {
/* 109 */           SFinderSoldierManning.FINDABLE_MANNING f = (SETT.PATH()).finders.manning(a.indu().army()).getReserved(d.path.destX(), d.path.destY());
/* 110 */           if (f != null) {
/* 111 */             f.findableReserveCancel();
/*     */           }
/*     */         }
/*     */       };
/*     */     
/* 116 */     this.stand = new AIPLAN.PLANRES.Resumer(this, ¤¤Name)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 120 */           return (AI.SUBS()).STAND.activateTime(a, d, (int)(2.0F + RND.rFloat() * 2.0F));
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 125 */           if (!(AI.modules()).battle.moduleCanContinue(a, d)) {
/* 126 */             can(a, d);
/* 127 */             return null;
/*     */           } 
/* 129 */           SFinderSoldierManning.FINDABLE_MANNING f = (SETT.PATH()).finders.manning(a.indu().army()).getReserved(d.path.destX(), d.path.destY());
/* 130 */           if (f == null) {
/* 131 */             return null;
/*     */           }
/* 133 */           if (f.needsWork())
/* 134 */             return ManPlan.this.work.set(a, d); 
/* 135 */           return (AI.SUBS()).STAND.activateTime(a, d, (int)(2.0F + RND.rFloat() * 2.0F));
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 140 */           return true;
/*     */         }
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {
/* 145 */           SFinderSoldierManning.FINDABLE_MANNING f = (SETT.PATH()).finders.manning(a.indu().army()).getReserved(d.path.destX(), d.path.destY());
/* 146 */           if (f != null) {
/* 147 */             f.findableReserveCancel();
/*     */           }
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 153 */           if (e.event == HEvent.CHECK_MORALE && 
/* 154 */             a.indu().army() == GAME.ARMIES().enemy() && GAME.ARMIES().enemy().morale() < 0.2D) {
/* 155 */             (STATS.BATTLE()).ROUTING.indu().set(a.indu(), 1);
/* 156 */             d.overwrite(a, (AI.modules()).battle.dessert);
/* 157 */             return false;
/*     */           } 
/*     */ 
/*     */           
/* 161 */           return super.event(a, d, e);
/*     */         }
/*     */       };
/*     */     
/* 165 */     this.work = new AIPLAN.PLANRES.Resumer(this, ¤¤Name)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 169 */           return (AI.SUBS()).WORK_HANDS.activate(a, d, 1.0D);
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 174 */           SFinderSoldierManning.FINDABLE_MANNING f = (SETT.PATH()).finders.manning(a.indu().army()).getReserved(d.path.destX(), d.path.destY());
/* 175 */           if (f == null)
/* 176 */             return null; 
/* 177 */           f.work(5.0D, a);
/* 178 */           if (!(AI.modules()).battle.moduleCanContinue(a, d)) {
/* 179 */             can(a, d);
/* 180 */             return null;
/*     */           } 
/* 182 */           if (a.division() != null && a.division().settings().mustering()) {
/* 183 */             can(a, d);
/* 184 */             return null;
/*     */           } 
/* 186 */           return ManPlan.this.stand.set(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 191 */           return true;
/*     */         }
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {
/* 196 */           SFinderSoldierManning.FINDABLE_MANNING f = (SETT.PATH()).finders.manning(a.indu().army()).getReserved(d.path.destX(), d.path.destY());
/* 197 */           if (f != null) {
/* 198 */             f.findableReserveCancel();
/*     */           }
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 204 */           if (e.event == HEvent.CHECK_MORALE && 
/* 205 */             a.indu().army() == GAME.ARMIES().enemy() && GAME.ARMIES().enemy().morale() < 0.2D) {
/* 206 */             (STATS.BATTLE()).ROUTING.indu().set(a.indu(), 1);
/* 207 */             d.overwrite(a, (AI.modules()).battle.dessert);
/* 208 */             return false;
/*     */           } 
/*     */ 
/*     */           
/* 212 */           return super.event(a, d, e);
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   private static CharSequence ¤¤Name = "¤Manning defenses"; private AIPLAN.PLANRES.Resumer wait; private AIPLAN.PLANRES.Resumer walk; private AIPLAN.PLANRES.Resumer stand;
/* 218 */   protected AISUB.AISubActivation resume(Humanoid a, AIManager d) { return super.resume(a, d); }
/*     */   private AIPLAN.PLANRES.Resumer work;
/*     */   static { D.ts(ManPlan.class); }
/*     */   boolean shouldMan(Humanoid a, AIManager d) { if (a.division() != null && a.division().settings().mustering()) return false;  if (d.plan() == this && getResumer(d) != this.wait)
/*     */       return true;  if (!(SETT.PATH()).finders.manning(a.indu().army()).has(a.tc()))
/* 223 */       return false;  return true; } protected AISUB.AISubActivation init(Humanoid a, AIManager d) { return this.wait.set(a, d); } public boolean notifyIfSubFails() { return false; }
/*     */ 
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\battle\ManPlan.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */