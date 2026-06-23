/*    */ package settlement.entity.humanoid.ai.crime;
/*    */ 
/*    */ import init.type.CRIMES;
/*    */ import settlement.entity.ENTITY;
/*    */ import settlement.entity.humanoid.HEvent;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AI;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*    */ import settlement.entity.humanoid.ai.main.AISUB;
/*    */ import settlement.main.SETT;
/*    */ import settlement.stats.STATS;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends AIPLAN.PLANRES.Resumer
/*    */ {
/*    */   null(AIPLAN.PLANRES paramPLANRES, CharSequence $anonymous0) {
/* 38 */     super(paramPLANRES, $anonymous0);
/*    */   }
/*    */   
/*    */   protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 42 */     if (d.planByte1 == 5)
/* 43 */       return null; 
/* 44 */     d.planByte1 = (byte)(d.planByte1 + 1);
/* 45 */     Humanoid h = (SETT.PATH()).finders.otherHumanoid.find(a, 100);
/* 46 */     if (h != null)
/*    */     {
/* 48 */       return (AI.SUBS()).walkTo.follow(a, d, (ENTITY)h, false, (byte)100);
/*    */     }
/* 50 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 57 */     if ((AI.SUBS()).walkTo.followSucess(a, d))
/* 58 */       return Murder.this.murder.set(a, d); 
/* 59 */     return set(a, d);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean con(Humanoid a, AIManager d) {
/* 64 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void can(Humanoid a, AIManager d) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 75 */     if (e.event == HEvent.MEET_HARMLESS) {
/* 76 */       ENTITY ee = SETT.ENTITIES().getByID(d.planObject);
/* 77 */       if (ee != null && ee instanceof Humanoid && ee == e.other) {
/* 78 */         Murder.this.m.commitCrime(a, d, true, (CRIMES.CRIME)(STATS.LAW()).prisonerType.get(a.indu()));
/* 79 */         d.overwrite(a, Murder.this.murder.set(a, d));
/* 80 */         return true;
/*    */       } 
/*    */     } 
/* 83 */     return super.event(a, d, e);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\crime\Murder$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */