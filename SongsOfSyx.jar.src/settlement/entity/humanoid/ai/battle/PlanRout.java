/*     */ package settlement.entity.humanoid.ai.battle;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.div.Div;
/*     */ import init.type.CAUSE_LEAVES;
/*     */ import settlement.entity.humanoid.HEvent;
/*     */ import settlement.entity.humanoid.HPoll;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.rnd.RND;
/*     */ 
/*     */ class PlanRout
/*     */   extends AIPLAN.PLANRES {
/*     */   private final AIPLAN.PLANRES.Resumer run;
/*     */   private final AIPLAN.PLANRES.Resumer path;
/*     */   private final AIPLAN.PLANRES.Resumer surrendered;
/*     */   
/*     */   public PlanRout(String key) {
/*  25 */     super(key);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  34 */     this.run = new AIPLAN.PLANRES.Resumer(this, "Routing")
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/*  38 */           (STATS.BATTLE()).ROUTING.indu().set(a.indu(), 1);
/*  39 */           Div div = a.division();
/*  40 */           if (div != null) {
/*  41 */             (GAME.ARMIES()).factors.reportRout(div);
/*  42 */             int di = RND.rInt(DIR.ALL.size());
/*  43 */             for (int i = 0; i < DIR.ALL.size(); i++) {
/*  44 */               DIR dir = (DIR)DIR.ALL.getC(di + i);
/*  45 */               if (!div.status().threat(dir) && !div.status().threat(dir.next(1)) && !div.status().threat(dir.next(-1))) {
/*  46 */                 a.setDivision(null);
/*  47 */                 a.speed.turn2(dir);
/*  48 */                 return (AI.SUBS()).walkTo.run_arround_crazy(a, d, 5);
/*     */               } 
/*     */             } 
/*  51 */             a.setDivision(null);
/*     */           } 
/*     */           
/*  54 */           a.speed.turn90().turn90();
/*  55 */           a.speed.turnWithAngel(RND.rFloat0(20.0D));
/*  56 */           return (AI.SUBS()).walkTo.run_arround_crazy(a, d, 5);
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/*  61 */           if (RND.oneIn(5)) {
/*  62 */             return PlanRout.this.path.set(a, d);
/*     */           }
/*  64 */           return PlanRout.this.surrendered.set(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/*  69 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/*  78 */     this.path = new AIPLAN.PLANRES.Resumer(this, "Routing")
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/*  82 */           if ((SETT.PATH()).finders.entity.findExitNoEnemies(a, a.physics.tileC().x(), a.physics.tileC().y(), d.path, 2147483647)) {
/*  83 */             return (AI.SUBS()).walkTo.pathRun(a, d);
/*     */           }
/*  85 */           return PlanRout.this.run.set(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/*  90 */           AIManager.dead = CAUSE_LEAVES.DESERTED();
/*  91 */           return (AI.SUBS()).STAND.activate(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/*  96 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/* 105 */     this.surrendered = new AIPLAN.PLANRES.Resumer(this, "Surrendered")
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 109 */           d.planByte1 = 0;
/* 110 */           return (AI.SUBS()).LAY.activateTime(a, d, 10);
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 115 */           d.planByte1 = (byte)(d.planByte1 + 1);
/* 116 */           if (d.planByte1 >= 32) {
/* 117 */             AIManager.dead = CAUSE_LEAVES.DESERTED();
/* 118 */             return (AI.SUBS()).LAY.activateTime(a, d, 10);
/*     */           } 
/*     */           
/* 121 */           if (a.indu().army() == GAME.ARMIES().player() && 
/* 122 */             GAME.ARMIES().enemy().men() == 0) {
/* 123 */             return PlanRout.this.path.set(a, d);
/*     */           }
/*     */           
/* 126 */           return (AI.SUBS()).LAY.activateTime(a, d, 10);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 131 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */ 
/*     */ 
/*     */         
/*     */         public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/* 142 */           return 0.0D;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 147 */           return false;
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 154 */     if (e.event == HEvent.COLLISION_TILE && !SETT.TILE_BOUNDS.holdsPoint(e.tx, e.ty)) {
/* 155 */       a.helloMyNameIsInigoMontoyaYouKilledMyFatherPrepareToDie();
/* 156 */       return false;
/*     */     } 
/*     */     
/* 159 */     return super.event(a, d, e);
/*     */   } protected AISUB.AISubActivation init(Humanoid a, AIManager d) {
/*     */     return this.run.set(a, d);
/*     */   }
/*     */   public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/* 164 */     if (e.type == HPoll.DEFENCE_SKILL)
/* 165 */       return 0.0D; 
/* 166 */     return super.poll(a, d, e);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\battle\PlanRout.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */