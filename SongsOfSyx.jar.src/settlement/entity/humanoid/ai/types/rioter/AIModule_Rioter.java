/*     */ package settlement.entity.humanoid.ai.types.rioter;
/*     */ 
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.CAUSE_LEAVES;
/*     */ import init.type.HTYPES;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.HEvent;
/*     */ import settlement.entity.humanoid.HPoll;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.battle.InterBattle;
/*     */ import settlement.entity.humanoid.ai.crime.AIModule_Crime;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIModule;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISTATE;
/*     */ import settlement.entity.humanoid.ai.main.AISTATES;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.text.D;
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class AIModule_Rioter
/*     */   extends AIModule
/*     */ {
/*  30 */   private static CharSequence ¤¤verb = "¤Rioting";
/*  31 */   private static CharSequence ¤¤name = "¤Riot"; private final AISTATES.Animation[] anima;
/*     */   
/*     */   static {
/*  34 */     D.ts(AIModule_Rioter.class);
/*     */   }
/*     */   private final AIPLAN planRout;
/*     */   public AIModule_Rioter() {
/*  38 */     super((SPRITE)(UI.icons()).s.degrade, ¤¤name, null);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  43 */     this
/*     */ 
/*     */       
/*  46 */       .anima = new AISTATES.Animation[] { (AI.STATES()).anima.fist, (AI.STATES()).anima.grab, (AI.STATES()).anima.lay };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  65 */     D.gInit(this);
/*     */     
/*  67 */     this.planRout = (AIPLAN)new AIPLAN.PLANRES("riot")
/*     */       {
/*     */         protected AISUB.AISubActivation init(Humanoid a, AIManager d)
/*     */         {
/*  71 */           d.planByte1 = 0;
/*  72 */           return this.go.set(a, d);
/*     */         }
/*     */         
/*  75 */         final AIModule_Rioter.SubFlee sub = new AIModule_Rioter.SubFlee();
/*     */         
/*  77 */         private final AIPLAN.PLANRES.Resumer go = new AIPLAN.PLANRES.Resumer(this, AIModule_Rioter.¤¤verb)
/*     */           {
/*     */             protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */             {
/*  81 */               AIModule_Crime.notify(a);
/*  82 */               (SETT.ROOMS()).GUARD.reporter.reportCriminal(a);
/*  83 */               return AIModule_Rioter.null.this.sub.activate(a, d, 1);
/*     */             }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/*  91 */               if (a.indu().hType() != HTYPES.RIOTER()) {
/*  92 */                 return null;
/*     */               }
/*     */               
/*  95 */               d.planByte1 = (byte)(d.planByte1 - 5);
/*  96 */               if (d.planByte1 < 0) {
/*  97 */                 d.planByte1 = 0;
/*     */               }
/*  99 */               AIModule_Crime.notify(a);
/* 100 */               if (RND.oneIn(5))
/* 101 */                 (SETT.ROOMS()).GUARD.reporter.reportCriminal(a); 
/* 102 */               if (RND.rBoolean()) {
/* 103 */                 int ri = RND.rInt(DIR.ORTHO.size());
/* 104 */                 for (int i = 0; i < DIR.ORTHO.size(); i++) {
/* 105 */                   DIR dd = (DIR)DIR.ORTHO.getC(ri + i);
/* 106 */                   if (SETT.IN_BOUNDS(a.tc(), dd) && (SETT.PATH()).cost.get(a.tc().x(), a.tc().y(), dd) > 0.0D) {
/* 107 */                     a.speed.turn2(dd);
/* 108 */                     return (AI.SUBS()).single.activate(a, d, (AIModule_Rioter.null.access$0(AIModule_Rioter.null.this)).anima[RND.rInt((AIModule_Rioter.null.access$0(AIModule_Rioter.null.this)).anima.length)].activate(a, d, (2 + RND.rInt(5))));
/*     */                   } 
/*     */                 } 
/*     */               } 
/*     */               
/* 113 */               if (RND.rBoolean()) {
/* 114 */                 return (AI.SUBS()).STAND.activateTime(a, d, 2 + RND.rInt(5));
/*     */               }
/* 116 */               return AIModule_Rioter.null.this.sub.activate(a, d, 1);
/*     */             }
/*     */ 
/*     */ 
/*     */             
/*     */             public boolean con(Humanoid a, AIManager d) {
/* 122 */               return true;
/*     */             }
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             public void can(Humanoid a, AIManager d) {}
/*     */           };
/*     */ 
/*     */ 
/*     */         
/*     */         public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/* 134 */           return InterBattle.pollReady(a, d, e);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 139 */           if (e.event == HEvent.CHECK_MORALE)
/* 140 */             return false; 
/* 141 */           return InterBattle.listener.event(a, d, e);
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AIPLAN.AiPlanActivation getPlan(Humanoid a, AIManager d) {
/*     */     return this.planRout.activate(a, d);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void update(Humanoid a, AIManager d, boolean newDay, int byteDelta, int updateOfDay) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getPriority(Humanoid a, AIManager d) {
/*     */     return 11;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final class SubFlee
/*     */     extends AISUB.Simple
/*     */   {
/*     */     public SubFlee() {
/* 196 */       super("riot_Flee");
/*     */     }
/*     */     
/*     */     AISUB.AISubActivation activate(Humanoid a, AIManager d, ENTITY other) {
/* 200 */       a.speed.turn2(other.body(), a.body());
/* 201 */       return activate(a, d);
/*     */     }
/*     */     
/*     */     AISUB.AISubActivation activate(Humanoid a, AIManager d, int iterations) {
/* 205 */       d.subPathByte = (byte)(iterations + 1);
/* 206 */       return activate(a, d);
/*     */     }
/*     */ 
/*     */     
/*     */     public AISUB.AISubActivation activate(Humanoid a, AIManager d) {
/* 211 */       d.subPathByte = (byte)(2 + RND.rInt(5));
/* 212 */       d.subPathByte2 = (byte)(2 + RND.rInt(15));
/* 213 */       return super.activate(a, d);
/*     */     }
/*     */ 
/*     */     
/*     */     protected AISTATE resume(Humanoid a, AIManager d) {
/* 218 */       a.speed.turnWithAngel(RND.rFloat0(90.0D));
/* 219 */       d.subPathByte = (short)(d.subPathByte - 1);
/* 220 */       if ((SETT.TERRAIN()).WATER.DEEP.is(a.tc())) {
/* 221 */         d.subPathByte2 = (byte)(d.subPathByte2 - 1);
/* 222 */         if (d.subPathByte2 <= 0) {
/* 223 */           Humanoid.HumanoidResource.dead = CAUSE_LEAVES.DROWNED();
/*     */         }
/*     */       } 
/*     */       
/* 227 */       if (d.subPathByte > 0) {
/* 228 */         if (RND.oneIn(3))
/* 229 */           return (AI.STATES()).jogCrazy.activate(a, d, (2.0F + RND.rFloat() * 3.0F)); 
/* 230 */         return (AI.STATES()).jog.activate(a, d, (2.0F + RND.rFloat() * 3.0F));
/*     */       } 
/*     */       
/* 233 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     protected AISTATE resumeInterrupted(Humanoid a, AIManager d, HEvent event) {
/* 238 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/* 243 */       return InterBattle.pollReady(a, d, e);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 248 */       if (e.event == HEvent.CHECK_MORALE)
/* 249 */         return false; 
/* 250 */       return InterBattle.listener.event(a, d, e);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\types\rioter\AIModule_Rioter.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */