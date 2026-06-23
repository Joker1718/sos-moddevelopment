/*     */ package settlement.entity.humanoid.ai.types.slave;
/*     */ 
/*     */ import game.GAME;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.CAUSE_LEAVES;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIModule;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.text.D;
/*     */ 
/*     */ public final class AIModule_Slave
/*     */   extends AIModule
/*     */ {
/*  19 */   private PlanUprise uprise = new PlanUprise();
/*  20 */   private static CharSequence ¤¤leave = "Leaving city for another master.";
/*  21 */   private static CharSequence ¤¤name = "rise up";
/*     */   static {
/*  23 */     D.ts(AIModule_Slave.class);
/*     */   }
/*     */   public final AIPLAN leave;
/*     */   public AIModule_Slave() {
/*  27 */     super((SPRITE)(UI.icons()).s.slave, ¤¤name, null);
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
/*  54 */     this.leave = (AIPLAN)new AIPLAN.PLANRES("SLAVE_SOLD")
/*     */       {
/*     */         protected AISUB.AISubActivation init(Humanoid a, AIManager d)
/*     */         {
/*  58 */           return this.start.set(a, d);
/*     */         }
/*     */         
/*  61 */         private final AIPLAN.PLANRES.Resumer start = new AIPLAN.PLANRES.Resumer(this, AIModule_Slave.¤¤leave)
/*     */           {
/*     */             protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */             {
/*  65 */               if ((SETT.PATH()).finders.entryPoints.find(a.tc().x(), a.tc().y(), d.path, 2147483647)) {
/*  66 */                 SETT.TRADE().reserveLeave(a);
/*  67 */                 return (AI.SUBS()).walkTo.path(a, d);
/*     */               } 
/*  69 */               return null;
/*     */             }
/*     */ 
/*     */             
/*     */             protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/*  74 */               return AIModule_Slave.null.this.fin.set(a, d);
/*     */             }
/*     */ 
/*     */             
/*     */             public boolean con(Humanoid a, AIManager d) {
/*  79 */               return true;
/*     */             }
/*     */ 
/*     */             
/*     */             public void can(Humanoid a, AIManager d) {
/*  84 */               SETT.TRADE().reserveLeaveCancel(a);
/*     */             }
/*     */           };
/*     */         
/*  88 */         private final AIPLAN.PLANRES.Resumer fin = new AIPLAN.PLANRES.Resumer(this, AIModule_Slave.¤¤leave)
/*     */           {
/*     */             protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */             {
/*  92 */               Humanoid.HumanoidResource.dead = CAUSE_LEAVES.SOLD();
/*  93 */               SETT.TRADE().leave(a);
/*  94 */               return (AI.SUBS()).STAND.activate(a, d);
/*     */             }
/*     */ 
/*     */             
/*     */             protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/*  99 */               return null;
/*     */             }
/*     */ 
/*     */             
/*     */             public boolean con(Humanoid a, AIManager d) {
/* 104 */               return true;
/*     */             }
/*     */             
/*     */             public void can(Humanoid a, AIManager d) {}
/*     */           };
/*     */       };
/*     */   }
/*     */   
/*     */   public AIPLAN.AiPlanActivation getPlan(Humanoid a, AIManager d) {
/*     */     if ((GAME.events()).uprising.spots.shouldSignUpUpriser(a))
/*     */       return this.uprise.activate(a, d); 
/*     */     if (!SETT.ENTRY().isClosed() && SETT.TRADE().shouldLeave(a))
/*     */       return this.leave.activate(a, d); 
/*     */     return null;
/*     */   }
/*     */   
/*     */   protected void update(Humanoid a, AIManager d, boolean newDay, int byteDelta, int updateOfDay) {}
/*     */   
/*     */   public int getPriority(Humanoid a, AIManager d) {
/*     */     if ((GAME.events()).uprising.spots.shouldSignUpUpriser(a))
/*     */       return 8; 
/*     */     if (!SETT.ENTRY().isClosed() && SETT.TRADE().shouldLeave(a))
/*     */       return 9; 
/*     */     return 0;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\types\slave\AIModule_Slave.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */