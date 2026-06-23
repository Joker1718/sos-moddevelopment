/*     */ package settlement.entity.humanoid.ai.service;
/*     */ 
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIModules;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISTATE;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.util.FINDABLE;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.datatypes.DIR;
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
/*     */ class null
/*     */   extends AIPLAN.PLANRES
/*     */ {
/*     */   private final AISUB sub;
/*     */   private final AIPLAN.PLANRES.Resumer walkToWater;
/*     */   private final AIPLAN.PLANRES.Resumer bathe;
/*     */   
/*     */   null(String $anonymous0) {
/*  68 */     super($anonymous0);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  78 */     this.sub = (AISUB)new AISUB.Simple("")
/*     */       {
/*     */         
/*     */         protected AISTATE resume(Humanoid a, AIManager d)
/*     */         {
/*  83 */           d.subByte = (byte)(d.subByte + 1);
/*     */           
/*  85 */           if (!a.speed.isZero()) {
/*  86 */             a.speed.magnitudeInit(0.0D);
/*     */           }
/*  88 */           if (d.subByte > 1) {
/*  89 */             (STATS.NEEDS()).EXPOSURE.fix(a.indu());
/*  90 */             (STATS.NEEDS()).DIRTINESS.set(a.indu(), 0);
/*     */           } 
/*     */           
/*  93 */           if (d.subByte > 20) {
/*  94 */             return null;
/*     */           }
/*  96 */           if (RND.oneIn(5)) {
/*     */             
/*  98 */             DIR dir = (DIR)DIR.ALL.get(RND.rInt(DIR.ALL.size()));
/*     */             
/* 100 */             for (int i = 0; i < 8; i++) {
/* 101 */               int x = a.physics.tileC().x() + dir.x();
/* 102 */               int y = a.physics.tileC().y() + dir.y();
/* 103 */               if ((SETT.PATH()).coster.player.getCost(a.tc().x(), a.tc().y(), x, y) > 0.0D && (SETT.PATH()).finders.water.get(x, y) != null) {
/* 104 */                 return (AI.STATES()).WALK2.dirTile(a, d, dir);
/*     */               }
/* 106 */               dir = dir.next(1);
/*     */             } 
/*     */           } 
/*     */ 
/*     */           
/* 111 */           if (RND.oneIn(3))
/* 112 */             return (AI.STATES()).STAND.aDirRND(a, d, 1.0F + RND.rFloat(2.0D)); 
/* 113 */           return (AI.STATES()).LAY.activate(a, d, (1.0F + RND.rFloat(5.0D)));
/*     */         }
/*     */       };
/*     */     
/* 117 */     this.walkToWater = new AIPLAN.PLANRES.Resumer(this, PlanSkinny.¤¤verb)
/*     */       {
/*     */         
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 122 */           if ((SETT.PATH()).finders.water.reserve(a.physics.tileC(), d.path, (PlanSkinny.null.access$0(PlanSkinny.null.this)).dist)) {
/* 123 */             AISUB.AISubActivation ss = (AI.SUBS()).walkTo.pathFull(a, d);
/* 124 */             if (ss != null) {
/* 125 */               (PlanSkinny.null.access$0(PlanSkinny.null.this)).stat.setAccess(a, true);
/* 126 */               return ss;
/*     */             } 
/* 128 */             can(a, d);
/*     */           } 
/* 130 */           (PlanSkinny.null.access$0(PlanSkinny.null.this)).stat.setAccess(a, false);
/* 131 */           return null;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 137 */           FINDABLE s = (SETT.PATH()).finders.water.get(d.path.destX(), d.path.destY());
/* 138 */           if (s == null)
/* 139 */             return null; 
/* 140 */           if (!s.findableReservedIs()) {
/* 141 */             if (!s.findableReservedCanBe())
/* 142 */               return null; 
/* 143 */             s.findableReserve();
/*     */           } 
/* 145 */           return PlanSkinny.null.this.bathe.set(a, d);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 151 */           return true;
/*     */         }
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {
/* 156 */           FINDABLE s = (SETT.PATH()).finders.water.getReserved(d.path.destX(), d.path.destY());
/* 157 */           if (s != null)
/* 158 */             s.findableReserveCancel(); 
/* 159 */           (STATS.POP()).NAKED.set(a.indu(), 0);
/*     */         }
/*     */       };
/*     */     
/* 163 */     this.bathe = new AIPLAN.PLANRES.Resumer(this, PlanSkinny.¤¤verb)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 167 */           (STATS.POP()).NAKED.set(a.indu(), 1);
/* 168 */           (STATS.NEEDS()).EXPOSURE.fix(a.indu());
/* 169 */           d.planByte1 = (byte)(5 + RND.rInt(10));
/* 170 */           return PlanSkinny.null.this.sub.activate(a, d);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 176 */           (STATS.NEEDS()).EXPOSURE.fix(a.indu());
/* 177 */           (STATS.NEEDS()).DIRTINESS.set(a.indu(), 0);
/*     */           
/* 179 */           if (!conn(a, d)) {
/* 180 */             can(a, d);
/* 181 */             return null;
/*     */           } 
/*     */ 
/*     */           
/* 185 */           d.planByte1 = (byte)(d.planByte1 - 1); if (d.planByte1 > 0 && AIModules.current(d) != null && AIModules.current(d).moduleCanContinue(a, d) && (SETT.WEATHER()).ice.canBatheOutside()) {
/* 186 */             return PlanSkinny.null.this.sub.activate(a, d);
/*     */           }
/* 188 */           can(a, d);
/* 189 */           return null;
/*     */         }
/*     */         
/*     */         private boolean conn(Humanoid a, AIManager d) {
/* 193 */           FINDABLE s = (SETT.PATH()).finders.water.getReserved(d.path.destX(), d.path.destY());
/* 194 */           return (s != null && s.findableReservedIs());
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 199 */           return true;
/*     */         }
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {
/* 204 */           FINDABLE s = (SETT.PATH()).finders.water.getReserved(d.path.destX(), d.path.destY());
/* 205 */           if (s != null)
/* 206 */             s.findableReserveCancel(); 
/* 207 */           (STATS.POP()).NAKED.set(a.indu(), 0);
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   protected AISUB.AISubActivation init(Humanoid a, AIManager d) {
/*     */     if ((SETT.WEATHER()).ice.canBatheOutside() && (SETT.PATH()).finders.water.has(a.tc()))
/*     */       return this.walkToWater.set(a, d); 
/*     */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\service\PlanSkinny$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */