/*     */ package settlement.entity.humanoid.ai.types.rioter;
/*     */ 
/*     */ import init.type.HTYPES;
/*     */ import settlement.entity.humanoid.HEvent;
/*     */ import settlement.entity.humanoid.HPoll;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.battle.InterBattle;
/*     */ import settlement.entity.humanoid.ai.crime.AIModule_Crime;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
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
/*     */ class null
/*     */   extends AIPLAN.PLANRES
/*     */ {
/*     */   final AIModule_Rioter.SubFlee sub;
/*     */   private final AIPLAN.PLANRES.Resumer go;
/*     */   
/*     */   null(String $anonymous0) {
/*  67 */     super($anonymous0);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  75 */     this.sub = new AIModule_Rioter.SubFlee(paramAIModule_Rioter);
/*     */     
/*  77 */     this.go = new AIPLAN.PLANRES.Resumer(this, AIModule_Rioter.¤¤verb)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/*  81 */           AIModule_Crime.notify(a);
/*  82 */           (SETT.ROOMS()).GUARD.reporter.reportCriminal(a);
/*  83 */           return AIModule_Rioter.null.this.sub.activate(a, d, 1);
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/*  91 */           if (a.indu().hType() != HTYPES.RIOTER()) {
/*  92 */             return null;
/*     */           }
/*     */           
/*  95 */           d.planByte1 = (byte)(d.planByte1 - 5);
/*  96 */           if (d.planByte1 < 0) {
/*  97 */             d.planByte1 = 0;
/*     */           }
/*  99 */           AIModule_Crime.notify(a);
/* 100 */           if (RND.oneIn(5))
/* 101 */             (SETT.ROOMS()).GUARD.reporter.reportCriminal(a); 
/* 102 */           if (RND.rBoolean()) {
/* 103 */             int ri = RND.rInt(DIR.ORTHO.size());
/* 104 */             for (int i = 0; i < DIR.ORTHO.size(); i++) {
/* 105 */               DIR dd = (DIR)DIR.ORTHO.getC(ri + i);
/* 106 */               if (SETT.IN_BOUNDS(a.tc(), dd) && (SETT.PATH()).cost.get(a.tc().x(), a.tc().y(), dd) > 0.0D) {
/* 107 */                 a.speed.turn2(dd);
/* 108 */                 return (AI.SUBS()).single.activate(a, d, (AIModule_Rioter.null.access$0(AIModule_Rioter.null.this)).anima[RND.rInt((AIModule_Rioter.null.access$0(AIModule_Rioter.null.this)).anima.length)].activate(a, d, (2 + RND.rInt(5))));
/*     */               } 
/*     */             } 
/*     */           } 
/*     */           
/* 113 */           if (RND.rBoolean()) {
/* 114 */             return (AI.SUBS()).STAND.activateTime(a, d, 2 + RND.rInt(5));
/*     */           }
/* 116 */           return AIModule_Rioter.null.this.sub.activate(a, d, 1);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 122 */           return true;
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
/*     */   public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/* 134 */     return InterBattle.pollReady(a, d, e);
/*     */   } protected AISUB.AISubActivation init(Humanoid a, AIManager d) {
/*     */     d.planByte1 = 0;
/*     */     return this.go.set(a, d);
/*     */   } public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 139 */     if (e.event == HEvent.CHECK_MORALE)
/* 140 */       return false; 
/* 141 */     return InterBattle.listener.event(a, d, e);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\types\rioter\AIModule_Rioter$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */