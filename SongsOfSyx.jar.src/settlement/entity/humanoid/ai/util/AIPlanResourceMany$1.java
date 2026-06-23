/*    */ package settlement.entity.humanoid.ai.util;
/*    */ 
/*    */ import init.resources.RBIT;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AI;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*    */ import settlement.entity.humanoid.ai.main.AISUB;
/*    */ import settlement.main.SETT;
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
/* 26 */     super(paramPLANRES, $anonymous0);
/*    */   }
/*    */ 
/*    */   
/*    */   protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 31 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 36 */     int am = (SETT.PATH()).finders.resource.pickup(AIPlanResourceMany.this.resource(a, d), d.path.destX(), d.path.destY(), d.planByte2);
/*    */     
/* 38 */     if (d.resourceCarried() != AIPlanResourceMany.this.resource(a, d)) {
/* 39 */       d.resourceDrop(a);
/* 40 */       d.resourceCarriedSet(AIPlanResourceMany.this.resource(a, d));
/* 41 */       if (am > 0)
/* 42 */         am--; 
/*    */     } 
/* 44 */     d.resourceAInc(am);
/* 45 */     d.planByte2 = 0;
/* 46 */     int more = AIPlanResourceMany.this.target(a, d) - d.resourceA();
/*    */     
/* 48 */     if (more == 0) {
/* 49 */       return AIPlanResourceMany.this.next(a, d);
/*    */     }
/*    */ 
/*    */     
/* 53 */     int dist = extraDistance - extraDistance * d.resourceA() / AIPlanResourceMany.this.target(a, d);
/*    */     
/* 55 */     if ((SETT.PATH()).finders.resource.find((AIPlanResourceMany.this.resource(a, d)).bit, AIPlanResourceMany.this.stored(d) ? (AIPlanResourceMany.this.resource(a, d)).bit : RBIT.NONE, AIPlanResourceMany.this.prio(d) ? (AIPlanResourceMany.this.resource(a, d)).bit : RBIT.NONE, a.tc(), d.path, dist) == null) {
/* 56 */       return AIPlanResourceMany.this.next(a, d);
/*    */     }
/* 58 */     d.planByte2 = 1;
/* 59 */     AISUB.AISubActivation s = (AI.SUBS()).walkTo.path(a, d);
/* 60 */     if (s == null) {
/* 61 */       (SETT.PATH()).finders.resource.unreserve(AIPlanResourceMany.this.resource(a, d), d.path.destX(), d.path.destY(), 1);
/* 62 */       return AIPlanResourceMany.this.next(a, d);
/*    */     } 
/*    */     
/* 65 */     int extra = AIPlanResourceMany.this.target(a, d) - d.resourceA() - d.planByte2;
/* 66 */     extra = (SETT.PATH()).finders.resource.reserveExtra(AIPlanResourceMany.this.stored(d), AIPlanResourceMany.this.prio(d), AIPlanResourceMany.this.resource(a, d), d.path.destX(), d.path.destY(), extra);
/* 67 */     d.planByte2 = (byte)(d.planByte2 + extra);
/*    */     
/* 69 */     return s;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean con(Humanoid a, AIManager d) {
/* 76 */     int am = AIPlanResourceMany.this.target(a, d) - d.resourceA() - d.planByte2;
/* 77 */     if (am > 0) {
/* 78 */       d.planByte2 = (byte)(d.planByte2 + (byte)(SETT.PATH()).finders.resource.reserveExtra(AIPlanResourceMany.this.stored(d), AIPlanResourceMany.this.prio(d), AIPlanResourceMany.this.resource(a, d), d.path.destX(), d.path.destY(), am));
/*    */     }
/*    */     
/* 81 */     return !(d.resourceCarried() != AIPlanResourceMany.this.resource(a, d) && !(SETT.PATH()).finders.resource.isReservedAndAvailable(AIPlanResourceMany.this.resource(a, d), d.path.destX(), d.path.destY()));
/*    */   }
/*    */ 
/*    */   
/*    */   public void can(Humanoid a, AIManager d) {
/* 86 */     (SETT.PATH()).finders.resource.unreserve(AIPlanResourceMany.this.resource(a, d), d.path.destX(), d.path.destY(), d.planByte2);
/* 87 */     d.resourceDrop(a);
/* 88 */     AIPlanResourceMany.this.cancel(a, d);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\a\\util\AIPlanResourceMany$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */