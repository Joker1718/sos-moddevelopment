/*     */ package settlement.entity.humanoid.ai.subject;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.Boostable;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.HTYPE;
/*     */ import init.type.HTYPES;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.idle.AIModule_Idle;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIModule;
/*     */ import settlement.entity.humanoid.ai.main.AIModules;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.throne.THRONE;
/*     */ import settlement.room.service.module.ROOM_ACTIVITY;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.INT_O;
/*     */ import util.text.D;
/*     */ 
/*     */ public final class AIModule_Subject
/*     */   extends AIModule {
/*  31 */   private final INT_O.INT_OE<AIManager> kissed = (INT_O.INT_OE<AIManager>)new INT_O.INTWRAP(1, (AIModules.data()).byte3);
/*  32 */   private final INT_O.INT_OE<AIManager> activity = (INT_O.INT_OE<AIManager>)new INT_O.INTWRAP(2, (AIModules.data()).byte3);
/*  33 */   private final PlanJoinArmy army = new PlanJoinArmy();
/*  34 */   private final PlanEmmigrate emmi = new PlanEmmigrate();
/*  35 */   public final PlanBuryCorpse corpse = new PlanBuryCorpse();
/*     */   
/*  37 */   private static CharSequence ¤¤swearing = "Swearing fealty";
/*  38 */   private static CharSequence ¤¤name = "Misc.";
/*     */   
/*  40 */   private static CharSequence ¤¤aexe = "Watching an execution"; private final AA[] activities; private final AIPLAN immigrate;
/*     */   
/*     */   static {
/*  43 */     D.ts(AIModule_Subject.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AIModule_Subject(AIModule_Idle idle) {
/*  50 */     super((SPRITE)(UI.icons()).s.human, ¤¤name, null);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  62 */     this.immigrate = (AIPLAN)new AIPLAN.PLANRES("subImmigrate")
/*     */       {
/*     */         
/*     */         protected AISUB.AISubActivation init(Humanoid a, AIManager d)
/*     */         {
/*  67 */           COORDINATE c = (SETT.PATH()).finders.rndCoo.find(THRONE.coo().x(), THRONE.coo().y(), 8);
/*  68 */           if (c != null) {
/*  69 */             d.planTile.set(c);
/*  70 */             AISUB.AISubActivation s = (AI.SUBS()).walkTo.cooFull(a, d, (COORDINATE)d.planTile);
/*  71 */             this.start.set(a, d);
/*  72 */             return s;
/*     */           } 
/*     */           
/*  75 */           AIModule_Subject.this.kissed.set(d, 1);
/*  76 */           return null;
/*     */         }
/*     */         
/*  79 */         private final AIPLAN.PLANRES.Resumer start = new AIPLAN.PLANRES.Resumer(this, AIModule_Subject.¤¤swearing)
/*     */           {
/*     */             public AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */             {
/*  83 */               return null;
/*     */             }
/*     */ 
/*     */             
/*     */             public AISUB.AISubActivation res(Humanoid a, AIManager d) {
/*  88 */               a.speed.turn2((THRONE.coo().x() - a.tc().x()), (THRONE.coo().y() - a.tc().y()));
/*  89 */               return AIModule_Subject.null.this.swear.set(a, d);
/*     */             }
/*     */ 
/*     */             
/*     */             public boolean con(Humanoid a, AIManager d) {
/*  94 */               return true;
/*     */             }
/*     */ 
/*     */ 
/*     */             
/*     */             public void can(Humanoid a, AIManager d) {}
/*     */           };
/*     */ 
/*     */         
/* 103 */         private final AIPLAN.PLANRES.Resumer swear = new AIPLAN.PLANRES.Resumer(this, AIModule_Subject.¤¤swearing)
/*     */           {
/*     */             public AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */             {
/* 107 */               return (AI.SUBS()).LAY.activateTime(a, d, 4 + RND.rInt(10));
/*     */             }
/*     */ 
/*     */             
/*     */             public AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 112 */               (AIModule_Subject.null.access$0(AIModule_Subject.null.this)).kissed.set(d, 1);
/* 113 */               return null;
/*     */             }
/*     */ 
/*     */             
/*     */             public boolean con(Humanoid a, AIManager d) {
/* 118 */               return true;
/*     */             }
/*     */ 
/*     */             
/*     */             public void can(Humanoid a, AIManager d) {}
/*     */           };
/*     */       };
/*     */     this.activities = new AA[] { (new AA((BOOSTABLES.ACTIVITY()).SOCIAL)).add(idle.interract()), (new AA((BOOSTABLES.ACTIVITY()).PUNISHMENT)).add((AIPLAN)new Activity((ROOM_ACTIVITY.ROOM_ACTIVITY_HASER)(SETT.ROOMS()).EXECUTION, ¤¤aexe)), (new AA((BOOSTABLES.ACTIVITY()).MOURN)).add((AIPLAN)new ActivityMourn()) };
/*     */   }
/*     */ 
/*     */   
/*     */   public int debug(AIManager aiManager) {
/*     */     return this.kissed.get(aiManager);
/*     */   }
/*     */   
/*     */   public AIPLAN.AiPlanActivation getPlan(Humanoid a, AIManager d) {
/* 134 */     if (this.emmi.shouldEmmigrate(a)) {
/* 135 */       return this.emmi.activate(a, d);
/*     */     }
/*     */     
/* 138 */     if (this.corpse.shouldBury(a, d)) {
/* 139 */       AIPLAN.AiPlanActivation p = this.corpse.activate(a, d);
/*     */       
/* 141 */       if (p != null) {
/* 142 */         return p;
/*     */       }
/*     */     } 
/* 145 */     if (this.army.getPriority(a) != 0) {
/* 146 */       AIPLAN.AiPlanActivation s = this.army.activate(a, d);
/* 147 */       if (s != null) {
/* 148 */         return s;
/*     */       }
/*     */     } 
/* 151 */     if (this.kissed.get(d) == 0 && (a.indu().clas()).player) {
/* 152 */       return this.immigrate.activate(a, d);
/*     */     }
/* 154 */     if (this.activity.get(d) == 1) {
/* 155 */       this.activity.set(d, 0);
/*     */       
/* 157 */       double ma = 0.0D; byte b; int i; AA[] arrayOfAA;
/* 158 */       for (i = (arrayOfAA = this.activities).length, b = 0; b < i; ) { AA aa = arrayOfAA[b];
/* 159 */         ma += aa.bo.get((BOOSTABLE_O)a.indu()); b++; }
/*     */       
/* 161 */       ma *= RND.rFloat();
/* 162 */       for (i = (arrayOfAA = this.activities).length, b = 0; b < i; ) { AA aa = arrayOfAA[b];
/* 163 */         ma -= aa.bo.get((BOOSTABLE_O)a.indu());
/* 164 */         if (ma <= 0.0D) {
/* 165 */           int ri = RND.rInt(aa.plans.size());
/* 166 */           for (int j = 0; j < aa.plans.size(); j++) {
/* 167 */             AIPLAN.AiPlanActivation s = ((AIPLAN)aa.plans.get(ri)).activate(a, d);
/* 168 */             if (s != null)
/* 169 */               return s; 
/* 170 */             ri++;
/* 171 */             if (ri >= aa.plans.size()) {
/* 172 */               ri = 0;
/*     */             }
/*     */           } 
/*     */         } 
/*     */         b++; }
/*     */     
/*     */     } 
/* 179 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void init(Humanoid a, AIManager d, HTYPE prev, HTYPE current) {
/* 186 */     if (prev == null || !prev.CLASS.player) {
/* 187 */       (AIModules.data()).byte3.set(d, 0);
/*     */     }
/*     */   }
/*     */   
/*     */   protected void update(Humanoid a, AIManager d, boolean newDay, int byteDelta, int upI) {
/* 192 */     if (newDay && RND.oneIn(4 + (STATS.POP()).POP.data().get(null) / 1000)) {
/* 193 */       this.activity.set(d, 1);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public int getPriority(Humanoid a, AIManager d) {
/* 199 */     if (this.army.getPriority(a) != 0) {
/* 200 */       return 10;
/*     */     }
/* 202 */     if (this.corpse.shouldBury(a, d)) {
/* 203 */       return 6;
/*     */     }
/*     */     
/* 206 */     if (this.kissed.get(d) == 0 && a.indu().hType() == HTYPES.SUBJECT())
/* 207 */       return 6; 
/* 208 */     if (((SETT.ROOMS()).DUMP.service()).finder.has(a.tc()) && GAME.ARMIES().enemy().men() == 0 && 
/* 209 */       (SETT.PATH()).finders.corpses.has(a.tc())) {
/* 210 */       return 5;
/*     */     }
/*     */ 
/*     */     
/* 214 */     if (this.emmi.shouldEmmigrate(a)) {
/* 215 */       return 4;
/*     */     }
/* 217 */     if (this.activity.get(d) == 1) {
/* 218 */       return 2;
/*     */     }
/*     */     
/* 221 */     return 0;
/*     */   }
/*     */   
/*     */   private final class AA
/*     */   {
/* 226 */     public final ArrayListGrower<AIPLAN> plans = new ArrayListGrower();
/*     */     public final Boostable bo;
/*     */     
/*     */     AA(Boostable bo) {
/* 230 */       this.bo = bo;
/*     */     }
/*     */     
/*     */     AA add(AIPLAN p) {
/* 234 */       this.plans.add(p);
/* 235 */       return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\subject\AIModule_Subject.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */