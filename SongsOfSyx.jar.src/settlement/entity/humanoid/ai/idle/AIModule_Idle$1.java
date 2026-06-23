/*     */ package settlement.entity.humanoid.ai.idle;
/*     */ 
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.HPoll;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
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
/*     */ class null
/*     */   extends AIPLAN.PLANRES
/*     */ {
/*     */   private final SubStand sub;
/*     */   private final SubMove walk;
/*     */   private final AIPLAN.PLANRES.Resumer start;
/*     */   private final AIPLAN.PLANRES.Resumer walking;
/*     */   private final AIPLAN.PLANRES.Resumer exit;
/*     */   
/*     */   null(String $anonymous0) {
/*  46 */     super($anonymous0);
/*     */     
/*  48 */     this.sub = new SubStand((AIPLAN)this, "idlestand");
/*  49 */     this.walk = new SubMove("idlewalk");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  57 */     this.start = new AIPLAN.PLANRES.Resumer(this, AIModule_Idle.¤¤name)
/*     */       {
/*     */ 
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/*  64 */           if ((SETT.PATH()).finders.getOutofWay.shouldFind((ENTITY)a)) {
/*  65 */             (SETT.PATH()).finders.getOutofWay.request(a, d.path);
/*  66 */             return AIModule_Idle.null.this.walking.set(a, d);
/*     */           } 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*  72 */           if (RND.oneIn(10))
/*  73 */             return AIModule_Idle.null.this.walk.activate(a, d); 
/*  74 */           return AIModule_Idle.null.this.sub.activate(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/*  79 */           if (AIModule_Idle.null.access$0(AIModule_Idle.null.this).moduleCanContinue(a, d)) {
/*  80 */             if (RND.oneIn(15))
/*  81 */               return AIModule_Idle.null.this.walk.activate(a, d); 
/*  82 */             return AIModule_Idle.null.this.sub.activate(a, d);
/*     */           } 
/*  84 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/*  89 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */ 
/*     */ 
/*     */         
/*     */         public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/*  99 */           if (e.type == HPoll.CAN_INTERRACT && a.speed.isZero())
/* 100 */             return 1.0D; 
/* 101 */           return super.poll(a, d, e);
/*     */         }
/*     */       };
/*     */     
/* 105 */     this.walking = new AIPLAN.PLANRES.Resumer(this, AIModule_Idle.¤¤name)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 109 */           return (AI.SUBS()).STAND.activateRndDir(a, d, 1 + RND.rInt(4));
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 114 */           if (AIModule_Idle.null.access$0(AIModule_Idle.null.this).moduleCanContinue(a, d)) {
/* 115 */             if ((SETT.PATH()).finders.getOutofWay.checkAndSetRequest(a.tc().x(), a.tc().y(), d.path)) {
/* 116 */               return AIModule_Idle.null.this.exit.set(a, d);
/*     */             }
/* 118 */             return (AI.SUBS()).STAND.activateRndDir(a, d, 1 + RND.rInt(4));
/*     */           } 
/* 120 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 125 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/* 134 */     this.exit = new AIPLAN.PLANRES.Resumer(this)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 138 */           if (d.path.isSuccessful()) {
/* 139 */             return (AI.SUBS()).walkTo.pathFull(a, d);
/*     */           }
/* 141 */           if (RND.oneIn(15))
/* 142 */             return AIModule_Idle.null.this.walk.activate(a, d); 
/* 143 */           return AIModule_Idle.null.this.sub.activate(a, d);
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 150 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 155 */           return true;
/*     */         }
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/*     */   }
/*     */   
/*     */   protected AISUB.AISubActivation init(Humanoid a, AIManager d) {
/*     */     return this.start.set(a, d);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\idle\AIModule_Idle$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */