/*    */ package settlement.entity.humanoid.ai.service;
/*    */ 
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AI;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*    */ import settlement.entity.humanoid.ai.main.AISUB;
/*    */ import settlement.main.SETT;
/*    */ import settlement.misc.util.FSERVICE;
/*    */ import settlement.room.service.hygine.well.ROOM_WELL;
/*    */ import settlement.stats.STATS;
/*    */ import snake2d.util.rnd.RND;
/*    */ 
/*    */ final class M_PlanWell extends MPlan<ROOM_WELL> {
/*    */   public M_PlanWell() {
/* 16 */     super("Well", (SETT.ROOMS()).WELLS, true);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 24 */     this.first = new AIPLAN.PLANRES.Resumer(this, "1")
/*    */       {
/*    */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*    */         {
/* 28 */           (STATS.POP()).NAKED.set(a.indu(), 1);
/* 29 */           M_PlanWell.this.blue(d).service().service(d.planTile.x(), d.planTile.y()).startUsing();
/* 30 */           d.planByte1 = (byte)(1 + RND.rInt(8));
/* 31 */           return (AI.SUBS()).STAND.activate(a, d);
/*    */         }
/*    */ 
/*    */ 
/*    */         
/*    */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 37 */           if (d.planByte1 <= 0) {
/*    */             
/* 39 */             (STATS.NEEDS()).EXPOSURE.fix(a.indu());
/* 40 */             (STATS.NEEDS()).DIRTINESS.set(a.indu(), 0);
/* 41 */             if ((STATS.NEEDS()).EXPOSURE.COUNT.indu().get(a.indu()) == 0) {
/* 42 */               can(a, d);
/* 43 */               return null;
/*    */             } 
/* 45 */             d.planByte1 = (byte)(1 + RND.rInt(8));
/*    */           } 
/*    */           
/* 48 */           d.planByte1 = (byte)(d.planByte1 - 1);
/*    */           
/* 50 */           if ((d.planByte1 & 0x1) == 1) {
/* 51 */             return (AI.SUBS()).STAND.activateTime(a, d, 1 + RND.rInt(5));
/*    */           }
/* 53 */           return (AI.SUBS()).single.activate(a, d, (AI.STATES()).anima.box, (1 + RND.rInt(5)));
/*    */         }
/*    */ 
/*    */ 
/*    */         
/*    */         public boolean con(Humanoid a, AIManager d) {
/* 59 */           FSERVICE s = M_PlanWell.this.blue(d).service().service(d.planTile.x(), d.planTile.y());
/* 60 */           return (s != null && s.findableReservedIs());
/*    */         }
/*    */ 
/*    */         
/*    */         public void can(Humanoid a, AIManager d) {
/* 65 */           FSERVICE s = M_PlanWell.this.blue(d).service().service(d.planTile.x(), d.planTile.y());
/* 66 */           if (s != null && s.findableReservedIs())
/* 67 */             s.consume(); 
/* 68 */           (STATS.POP()).NAKED.set(a.indu(), 0);
/*    */         }
/*    */       };
/*    */   }
/*    */   
/*    */   final AIPLAN.PLANRES.Resumer first;
/*    */   
/*    */   protected AISUB.AISubActivation arrive(Humanoid a, AIManager d) {
/*    */     return this.first.set(a, d);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\service\M_PlanWell.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */