/*     */ package settlement.entity.humanoid.ai.types.slave;
/*     */ 
/*     */ import init.type.CAUSE_LEAVES;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
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
/*     */   private final AIPLAN.PLANRES.Resumer start;
/*     */   private final AIPLAN.PLANRES.Resumer fin;
/*     */   
/*     */   null(String $anonymous0) {
/*  54 */     super($anonymous0);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  61 */     this.start = new AIPLAN.PLANRES.Resumer(this, AIModule_Slave.¤¤leave)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/*  65 */           if ((SETT.PATH()).finders.entryPoints.find(a.tc().x(), a.tc().y(), d.path, 2147483647)) {
/*  66 */             SETT.TRADE().reserveLeave(a);
/*  67 */             return (AI.SUBS()).walkTo.path(a, d);
/*     */           } 
/*  69 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/*  74 */           return AIModule_Slave.null.this.fin.set(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/*  79 */           return true;
/*     */         }
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {
/*  84 */           SETT.TRADE().reserveLeaveCancel(a);
/*     */         }
/*     */       };
/*     */     
/*  88 */     this.fin = new AIPLAN.PLANRES.Resumer(this, AIModule_Slave.¤¤leave)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/*  92 */           Humanoid.HumanoidResource.dead = CAUSE_LEAVES.SOLD();
/*  93 */           SETT.TRADE().leave(a);
/*  94 */           return (AI.SUBS()).STAND.activate(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/*  99 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 104 */           return true;
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


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\types\slave\AIModule_Slave$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */