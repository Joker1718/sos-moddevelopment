/*    */ package settlement.entity.humanoid.ai.subject;
/*    */ 
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AI;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*    */ import settlement.entity.humanoid.ai.main.AISUB;
/*    */ import settlement.main.SETT;
/*    */ import settlement.misc.util.FSERVICE;
/*    */ import settlement.path.finders.SFinderFindable;
/*    */ import snake2d.util.rnd.RND;
/*    */ import util.text.D;
/*    */ 
/*    */ final class ActivityMourn
/*    */   extends AIPLAN.PLANRES {
/* 16 */   private static CharSequence ¤¤verb = "Mourning old friend"; private final AIPLAN.PLANRES.Resumer start;
/*    */   
/*    */   static {
/* 19 */     D.ts(ActivityMourn.class);
/*    */   }
/*    */   private final AIPLAN.PLANRES.Resumer mourn;
/*    */   public ActivityMourn() {
/* 23 */     super("SUBJECT_MOURN");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 33 */     this.start = new AIPLAN.PLANRES.Resumer(this, ¤¤verb)
/*    */       {
/*    */         public AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*    */         {
/* 37 */           AISUB.AISubActivation s = (AI.SUBS()).walkTo.service(a, d, (SFinderFindable)(SETT.ROOMS()).graveServiceSpots, 500);
/* 38 */           return s;
/*    */         }
/*    */ 
/*    */         
/*    */         public AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 43 */           return ActivityMourn.this.mourn.set(a, d);
/*    */         }
/*    */ 
/*    */         
/*    */         public boolean con(Humanoid a, AIManager d) {
/* 48 */           return true;
/*    */         }
/*    */ 
/*    */ 
/*    */ 
/*    */         
/*    */         public void can(Humanoid a, AIManager d) {}
/*    */       };
/* 56 */     this.mourn = new AIPLAN.PLANRES.Resumer(this, ¤¤verb)
/*    */       {
/*    */         public AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*    */         {
/* 60 */           d.planByte1 = (byte)(4 + RND.rInt(8));
/* 61 */           return (AI.SUBS()).STAND.activate(a, d);
/*    */         }
/*    */ 
/*    */ 
/*    */         
/*    */         public AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 67 */           d.planByte1 = (byte)(d.planByte1 - 1);
/* 68 */           if (d.planByte1 >= 0) {
/* 69 */             return (AI.SUBS()).STAND.activateRndDir(a, d);
/*    */           }
/*    */           
/* 72 */           FSERVICE s = (FSERVICE)(SETT.ROOMS()).graveServiceSpots.get(d.path.destX(), d.path.destY());
/* 73 */           if (s != null)
/* 74 */             s.consume(); 
/* 75 */           return null;
/*    */         }
/*    */ 
/*    */         
/*    */         public boolean con(Humanoid a, AIManager d) {
/* 80 */           return ((SETT.ROOMS()).graveServiceSpots.get(d.path.destX(), d.path.destY()) != null);
/*    */         }
/*    */ 
/*    */         
/*    */         public void can(Humanoid a, AIManager d) {
/* 85 */           FSERVICE s = (FSERVICE)(SETT.ROOMS()).graveServiceSpots.get(d.path.destX(), d.path.destY());
/* 86 */           if (s != null)
/* 87 */             s.findableReserveCancel(); 
/*    */         }
/*    */       };
/*    */   }
/*    */   
/*    */   protected AISUB.AISubActivation init(Humanoid a, AIManager d) {
/*    */     return this.start.set(a, d);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\subject\ActivityMourn.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */