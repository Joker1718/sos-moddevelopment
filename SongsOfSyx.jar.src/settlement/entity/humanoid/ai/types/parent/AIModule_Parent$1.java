/*     */ package settlement.entity.humanoid.ai.types.parent;
/*     */ 
/*     */ import settlement.entity.ENTITY;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   extends AIPLAN.PLANRES
/*     */ {
/*     */   private final AIPLAN.PLANRES.Resumer start;
/*     */   private final AIPLAN.PLANRES.Resumer walking;
/*     */   private final AIPLAN.PLANRES.Resumer exit;
/*     */   
/*     */   null(String $anonymous0) {
/*  46 */     super($anonymous0);
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
/*  58 */     this.start = new AIPLAN.PLANRES.Resumer(this, AIModule_Parent.¤¤nurishing)
/*     */       {
/*     */         
/*     */         public AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/*  63 */           return res(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public AISUB.AISubActivation res(Humanoid a, AIManager d) {
/*  68 */           d.planByte1 = (byte)(d.planByte1 - 1); if (d.planByte1 < 0) {
/*  69 */             return null;
/*     */           }
/*     */           
/*  72 */           return (AI.SUBS()).single.activate(a, d, (AI.STATES()).STAND_BABY.aDirRND(a, d, 1.0F + RND.rFloat() * 5.0F));
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/*  77 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/*  86 */     this.walking = new AIPLAN.PLANRES.Resumer(this, AIModule_Parent.¤¤nurishing)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/*  90 */           return (AI.SUBS()).STAND.activateRndDir(a, d, 1 + RND.rInt(4));
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/*  95 */           if (AIModule_Parent.null.access$0(AIModule_Parent.null.this).moduleCanContinue(a, d)) {
/*  96 */             if ((SETT.PATH()).finders.getOutofWay.checkAndSetRequest(a.tc().x(), a.tc().y(), d.path)) {
/*  97 */               return AIModule_Parent.null.this.exit.set(a, d);
/*     */             }
/*  99 */             return (AI.SUBS()).STAND.activateRndDir(a, d, 1 + RND.rInt(4));
/*     */           } 
/* 101 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 106 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/* 115 */     this.exit = new AIPLAN.PLANRES.Resumer(this, AIModule_Parent.¤¤nurishing)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 119 */           if (d.path.isSuccessful()) {
/* 120 */             return (AI.SUBS()).walkTo.pathFull(a, d);
/*     */           }
/* 122 */           return AIModule_Parent.null.this.start.set(a, d);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 128 */           return AIModule_Parent.null.this.start.set(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 133 */           return true;
/*     */         }
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/*     */   }
/*     */   
/*     */   protected AISUB.AISubActivation init(Humanoid a, AIManager d) {
/*     */     if ((SETT.PATH()).finders.getOutofWay.shouldFind((ENTITY)a)) {
/*     */       (SETT.PATH()).finders.getOutofWay.request(a, d.path);
/*     */       return this.walking.set(a, d);
/*     */     } 
/*     */     d.planByte1 = (byte)(3 + RND.rInt(5));
/*     */     return this.start.set(a, d);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\types\parent\AIModule_Parent$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */