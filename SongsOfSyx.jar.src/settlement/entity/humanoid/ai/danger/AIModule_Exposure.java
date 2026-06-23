/*     */ package settlement.entity.humanoid.ai.danger;
/*     */ 
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.CAUSE_LEAVES;
/*     */ import init.type.HTYPES;
/*     */ import init.type.NEEDS;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIData;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIModule;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.util.FINDABLE;
/*     */ import settlement.path.finders.SFinderFindable;
/*     */ import settlement.room.service.hygine.well.ROOM_WELL;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.text.D;
/*     */ 
/*     */ final class AIModule_Exposure
/*     */   extends AIModule
/*     */ {
/*  27 */   private final AIData.AIDataSuspender suspender = AI.suspender("Exposure");
/*     */   
/*  29 */   private static CharSequence ¤¤name = "Find Shelter";
/*  30 */   private static CharSequence ¤¤desc = "Find Shelter or services to alleviate heat or cold.";
/*  31 */   private static CharSequence ¤¤freezing = "Freezing!";
/*  32 */   private static CharSequence ¤¤cover = "Cooling down";
/*  33 */   private static CharSequence ¤¤nearDeath = "(Near Death!)";
/*     */   
/*     */   static {
/*  36 */     D.ts(AIModule_Exposure.class);
/*     */   }
/*     */   final AIPLAN inside;
/*     */   
/*     */   public AIModule_Exposure() {
/*  41 */     super((SPRITE)(UI.icons()).s.heat, ¤¤name, ¤¤desc);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 122 */     this.inside = (AIPLAN)new AIPLAN.PLANRES("dangerExposeure")
/*     */       {
/*     */         protected AISUB.AISubActivation init(Humanoid a, AIManager d)
/*     */         {
/* 126 */           return this.find.set(a, d);
/*     */         }
/*     */         
/* 129 */         private final AIPLAN.PLANRES.Resumer find = new AIPLAN.PLANRES.Resumer(this)
/*     */           {
/*     */             protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */             {
/* 133 */               AIModule_Exposure.null.this.exit.set(a, d);
/* 134 */               FINDABLE f = (SETT.PATH()).finders.indoor.getReservable(a.tc().x(), a.tc().y());
/* 135 */               d.planByte2 = 0;
/* 136 */               if (f != null) {
/* 137 */                 d.planTile.set(a.tc());
/* 138 */                 f.findableReserve();
/* 139 */                 d.planByte2 = 1;
/* 140 */                 return (AI.SUBS()).STAND.activateRndDir(a, d);
/*     */               } 
/*     */               
/* 143 */               AISUB.AISubActivation s = (AI.SUBS()).walkTo.serviceInclude(a, d, (SFinderFindable)(SETT.PATH()).finders.indoor, 64);
/* 144 */               if (s != null) {
/* 145 */                 d.planTile.set(d.path.destX(), d.path.destY());
/* 146 */                 d.planByte2 = 1;
/* 147 */                 return s;
/*     */               } 
/*     */               
/* 150 */               return (AI.SUBS()).STAND.activateRndDir(a, d);
/*     */             }
/*     */ 
/*     */ 
/*     */             
/*     */             protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 156 */               return AIModule_Exposure.null.this.exit.set(a, d);
/*     */             }
/*     */ 
/*     */             
/*     */             public boolean con(Humanoid a, AIManager d) {
/* 161 */               return true;
/*     */             }
/*     */ 
/*     */             
/*     */             public void can(Humanoid a, AIManager d) {
/* 166 */               if (d.planByte2 == 1) {
/* 167 */                 FINDABLE f = (SETT.PATH()).finders.indoor.getReserved(d.planTile.x(), d.planTile.y());
/* 168 */                 if (f != null)
/* 169 */                   f.findableReserveCancel(); 
/* 170 */                 d.planByte2 = 0;
/*     */               } 
/*     */             }
/*     */           };
/*     */         
/* 175 */         private final AIPLAN.PLANRES.Resumer exit = new AIPLAN.PLANRES.Resumer(this)
/*     */           {
/*     */             protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */             {
/* 179 */               d.planByte1 = (byte)(5 + RND.rInt(5));
/* 180 */               return (AI.SUBS()).STAND.activateRndDir(a, d);
/*     */             }
/*     */ 
/*     */ 
/*     */             
/*     */             protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 186 */               d.planByte1 = (byte)(d.planByte1 - 1);
/*     */ 
/*     */ 
/*     */               
/* 190 */               if (d.planByte1 > 0 && (STATS.NEEDS()).EXPOSURE.COUNT.indu().get(a.indu()) > 0 && AIModule_Exposure.null.access$0(AIModule_Exposure.null.this).moduleCanContinue(a, d)) {
/* 191 */                 if ((STATS.NEEDS()).EXPOSURE.critical(a.indu())) {
/* 192 */                   return AIModule_Exposure.null.this.exit2.set(a, d);
/*     */                 }
/*     */                 
/* 195 */                 if (RND.rBoolean()) {
/* 196 */                   return (AI.SUBS()).STAND.activate(a, d, (AI.STATES()).anima.wave.activate(a, d, (2.0F + RND.rFloat() * 2.0F)));
/*     */                 }
/* 198 */                 return (AI.SUBS()).STAND.activateRndDir(a, d);
/*     */               } 
/* 200 */               can(a, d);
/* 201 */               return null;
/*     */             }
/*     */ 
/*     */             
/*     */             public boolean con(Humanoid a, AIManager d) {
/* 206 */               return true;
/*     */             }
/*     */ 
/*     */             
/*     */             public void can(Humanoid a, AIManager d) {
/* 211 */               if (d.planByte2 == 1) {
/* 212 */                 FINDABLE f = (SETT.PATH()).finders.indoor.getReserved(d.planTile.x(), d.planTile.y());
/* 213 */                 if (f != null)
/* 214 */                   f.findableReserveCancel(); 
/* 215 */                 d.planByte2 = 0;
/*     */               } 
/*     */             }
/*     */           };
/*     */         
/* 220 */         private final AIPLAN.PLANRES.Resumer exit2 = new AIPLAN.PLANRES.Resumer(this)
/*     */           {
/*     */             protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */             {
/* 224 */               return (AI.SUBS()).LAY.activateTime(a, d, 8);
/*     */             }
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 231 */               if ((STATS.NEEDS()).EXPOSURE.COUNT.indu().isMax(a.indu()) && (SETT.WEATHER()).temp.getEntityTemp() != 0.0D) {
/*     */                 
/* 233 */                 AIManager.dead = (STATS.NEEDS()).EXPOSURE.isCold(a.indu()) ? CAUSE_LEAVES.COLD() : CAUSE_LEAVES.HEAT();
/* 234 */                 return (AI.SUBS()).LAY.activateTime(a, d, 8);
/*     */               } 
/* 236 */               return null;
/*     */             }
/*     */ 
/*     */             
/*     */             public boolean con(Humanoid a, AIManager d) {
/* 241 */               return true;
/*     */             }
/*     */ 
/*     */             
/*     */             public void can(Humanoid a, AIManager d) {
/* 246 */               if (d.planByte2 == 1) {
/* 247 */                 FINDABLE f = (SETT.PATH()).finders.indoor.getReserved(d.planTile.x(), d.planTile.y());
/* 248 */                 if (f != null)
/* 249 */                   f.findableReserveCancel(); 
/* 250 */                 d.planByte2 = 0;
/*     */               } 
/*     */             }
/*     */           };
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         protected void name(Humanoid a, AIManager d, Str string) {
/* 259 */           if ((STATS.NEEDS()).EXPOSURE.isCold(a.indu())) {
/* 260 */             string.add(AIModule_Exposure.¤¤freezing);
/*     */           } else {
/* 262 */             string.add(AIModule_Exposure.¤¤cover);
/* 263 */           }  if ((STATS.NEEDS()).EXPOSURE.critical(a.indu()))
/* 264 */             string.s().add(AIModule_Exposure.¤¤nearDeath); 
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   public AIPLAN.AiPlanActivation getPlan(Humanoid a, AIManager d) {
/*     */     if ((STATS.NEEDS()).EXPOSURE.COUNT.indu().get(a.indu()) == 0)
/*     */       return null; 
/*     */     if (!this.suspender.is(d)) {
/*     */       if (!(STATS.NEEDS()).EXPOSURE.isCold(a.indu())) {
/*     */         AIPLAN.AiPlanActivation aiPlanActivation = getHot(a, d);
/*     */         if (aiPlanActivation != null)
/*     */           return aiPlanActivation; 
/*     */       } else {
/*     */         AIPLAN.AiPlanActivation aiPlanActivation = getCold(a, d);
/*     */         if (aiPlanActivation != null)
/*     */           return aiPlanActivation; 
/*     */       } 
/*     */       this.suspender.suspend(d);
/*     */     } 
/*     */     AIPLAN.AiPlanActivation p = this.inside.activate(a, d);
/*     */     if (p != null)
/*     */       return p; 
/*     */     return null;
/*     */   }
/*     */   
/*     */   public AIPLAN.AiPlanActivation getHot(Humanoid a, AIManager d) {
/*     */     int dist = (a.indu().hType() == HTYPES.DERANGED()) ? Integer.MAX_VALUE : 200;
/*     */     AIPLAN.AiPlanActivation p = (AI.modules()).needs.get(a, d, (NEEDS.TYPES()).SKINNYDIP, dist);
/*     */     if (p != null)
/*     */       return p; 
/*     */     for (ROOM_WELL w : (SETT.ROOMS()).WELLS) {
/*     */       p = (AI.modules()).needs.get(a, d, (w.service()).need, dist);
/*     */       if (p != null)
/*     */         return p; 
/*     */     } 
/*     */     return null;
/*     */   }
/*     */   
/*     */   public AIPLAN.AiPlanActivation getCold(Humanoid a, AIManager d) {
/*     */     int dist = (a.indu().hType() == HTYPES.DERANGED()) ? Integer.MAX_VALUE : 200;
/*     */     AIPLAN.AiPlanActivation p = (AI.modules()).needs.get(a, d, ((SETT.ROOMS()).HEARTH.service()).need, dist);
/*     */     if (p != null)
/*     */       return p; 
/*     */     return null;
/*     */   }
/*     */   
/*     */   protected void update(Humanoid a, AIManager d, boolean newDay, int byteDelta, int upI) {
/*     */     this.suspender.update(d);
/*     */   }
/*     */   
/*     */   public int getPriority(Humanoid a, AIManager d) {
/*     */     if ((STATS.NEEDS()).EXPOSURE.critical(a.indu()))
/*     */       return 10; 
/*     */     if (!this.suspender.is(d) && (STATS.NEEDS()).EXPOSURE.COUNT.indu().get(a.indu()) > 0)
/*     */       return 8; 
/*     */     return 0;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\danger\AIModule_Exposure.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */