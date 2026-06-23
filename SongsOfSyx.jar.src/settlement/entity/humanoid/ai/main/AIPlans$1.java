/*     */ package settlement.entity.humanoid.ai.main;
/*     */ 
/*     */ import init.type.CAUSE_LEAVES;
/*     */ import init.type.NEEDS;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
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
/*     */ class null
/*     */   extends AIPLAN.PLANRES
/*     */ {
/*     */   private final AIPLAN.PLANRES.Resumer path;
/*     */   private final AIPLAN.PLANRES.Resumer drowning;
/*     */   private AISUB sub;
/*     */   private final AIPLAN.PLANRES.Resumer start;
/*     */   
/*     */   null(String $anonymous0) {
/*  37 */     super($anonymous0);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  62 */     this.path = new AIPLAN.PLANRES.Resumer(this, AIPlans.¤¤trapped)
/*     */       {
/*     */         public AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/*  66 */           return (AI.SUBS()).walkTo.path(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public AISUB.AISubActivation res(Humanoid a, AIManager d) {
/*  71 */           if ((SETT.TERRAIN()).WATER.DEEP.is(a.tc()))
/*  72 */             return AIPlans.null.this.drowning.set(a, d); 
/*  73 */           if (!(SETT.PATH()).connectivity.is(a.physics.tileC()))
/*  74 */             AIManager.dead = CAUSE_LEAVES.DROWNED(); 
/*  75 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/*  80 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/*  89 */     this.drowning = new AIPLAN.PLANRES.Resumer(this, AIPlans.¤¤swimming)
/*     */       {
/*  91 */         private AISUB sub = new AISUB.Simple("UNR_DROWN")
/*     */           {
/*     */ 
/*     */ 
/*     */             
/*     */             public AISTATE resume(Humanoid a, AIManager d)
/*     */             {
/*  98 */               if (d.subByte > 20 && RND.oneIn(3)) {
/*  99 */                 return null;
/*     */               }
/* 101 */               d.subByte = (byte)(d.subByte + 1);
/*     */               
/* 103 */               return (AI.STATES()).STAND.aDirRND(a, d, (float)(0.2D + RND.rFloat(0.3D)));
/*     */             }
/*     */           };
/*     */ 
/*     */         
/*     */         public AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 109 */           return this.sub.activate(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 114 */           AIManager.dead = CAUSE_LEAVES.DROWNED();
/* 115 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 120 */           return true;
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
/* 131 */     this.sub = new AISUB.Simple("UNR_DROWN2")
/*     */       {
/*     */         public AISTATE resume(Humanoid a, AIManager d)
/*     */         {
/* 135 */           d.subByte = (byte)(d.subByte + 1);
/* 136 */           if (d.subByte != 1)
/* 137 */             return null; 
/* 138 */           for (int di = 0; di < DIR.ALL.size(); di++) {
/* 139 */             DIR dir = (DIR)DIR.ALL.get(di);
/* 140 */             if ((SETT.PATH()).connectivity.is(a.tc(), dir)) {
/* 141 */               if (!dir.isOrtho() && 
/* 142 */                 !((SETT.PATH()).availability.get(a.tc().x() + dir.x(), a.tc().y())).tileCollide && 
/* 143 */                 !((SETT.PATH()).availability.get(a.tc().x(), a.tc().y() + dir.y())).tileCollide)
/* 144 */                 return (AI.STATES()).WALK2.dirTile(a, d, dir); 
/* 145 */               if (dir.isOrtho() && !((SETT.PATH()).availability.get(a.tc().x() + dir.x(), a.tc().y() + dir.y())).tileCollide) {
/* 146 */                 return (AI.STATES()).WALK2.dirTile(a, d, dir);
/*     */               }
/*     */             } 
/*     */           } 
/*     */           
/* 151 */           switch (RND.rInt(3)) { case 0:
/* 152 */               return (AI.STATES()).STAND.activate(a, d, (0.5F + RND.rFloat(5.0D)));
/* 153 */             case 1: return (AI.STATES()).anima.wave.activate(a, d, (0.5F + RND.rFloat(5.0D))); }
/*     */           
/* 155 */           if (a.division() != null) {
/* 156 */             a.setDivision(null);
/*     */           }
/*     */           
/* 159 */           if (a.indu().hType().isHostile())
/* 160 */             (STATS.BATTLE()).ROUTING.indu().set(a.indu(), 1); 
/* 161 */           return (AI.STATES()).anima.box.activate(a, d, (0.5F + RND.rFloat(5.0D)));
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 166 */     this.start = new AIPLAN.PLANRES.Resumer(this, AIPlans.¤¤trapped)
/*     */       {
/*     */         public AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 170 */           d.planByte1 = 0;
/* 171 */           return (AI.SUBS()).STAND.activate(a, d);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 177 */           d.planByte1 = (byte)(d.planByte1 + 1);
/* 178 */           if (d.planByte1 > 5)
/* 179 */             return null; 
/* 180 */           if ((SETT.PATH()).connectivity.is(a.physics.tileC()))
/*     */           {
/*     */ 
/*     */             
/* 184 */             return null;
/*     */           }
/*     */ 
/*     */ 
/*     */           
/* 189 */           return AIPlans.null.this.sub.activate(a, d);
/*     */         }
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d)
/*     */         {
/* 194 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void cancel(Humanoid a, AIManager d) {
/* 206 */     super.cancel(a, d);
/*     */   }
/*     */   
/*     */   public AISUB.AISubActivation init(Humanoid a, AIManager d) {
/*     */     if ((NEEDS.TYPES()).HUNGER.stat().stat().indu().isMax(a.indu()))
/*     */       AIManager.dead = CAUSE_LEAVES.STARVED(); 
/*     */     if ((SETT.PATH().finders()).reachable.find(a.tc(), d.path, 8))
/*     */       return this.path.set(a, d); 
/*     */     (STATS.POP()).TRAPPED.indu().set(a.indu(), 1);
/*     */     if (a.division() != null)
/*     */       (a.division()).reporter.reportReachable(a, false); 
/*     */     if ((SETT.TERRAIN()).WATER.DEEP.is(a.tc()))
/*     */       return this.drowning.set(a, d); 
/*     */     return this.start.set(a, d);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\main\AIPlans$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */