/*    */ package settlement.entity.humanoid.ai.service;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AI;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*    */ import settlement.entity.humanoid.ai.main.AISTATES;
/*    */ import settlement.entity.humanoid.ai.main.AISUB;
/*    */ import settlement.main.SETT;
/*    */ import settlement.misc.util.FSERVICE;
/*    */ import settlement.room.main.Room;
/*    */ import settlement.room.main.RoomInstance;
/*    */ import settlement.room.service.hearth.ROOM_HEARTH;
/*    */ import settlement.room.service.module.ROOM_SERVICER;
/*    */ import settlement.stats.STATS;
/*    */ import snake2d.util.rnd.RND;
/*    */ import snake2d.util.sets.ArrayList;
/*    */ import snake2d.util.sets.LIST;
/*    */ 
/*    */ final class M_PlanHearth extends MPlan<ROOM_HEARTH> {
/*    */   public M_PlanHearth() {
/* 21 */     super("Hearth", (LIST<ROOM_HEARTH>)new ArrayList((SETT.ROOMS()).HEARTH), true);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 29 */     this.first = new AIPLAN.PLANRES.Resumer(this, "2")
/*    */       {
/*    */         public AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*    */         {
/* 33 */           M_PlanHearth.this.blue(d).service().service(d.path().destX(), d.path().destY()).startUsing();
/* 34 */           d.planByte1 = 0;
/* 35 */           RoomInstance r = M_PlanHearth.this.blue(d).get(a.tc().x(), a.tc().y());
/* 36 */           a.speed.turn2((r.body().cX() - a.tc().x()), (r.body().cY() - a.tc().y()));
/* 37 */           return (AI.SUBS()).STAND.activateTime(a, d, 2 + RND.rInt(15));
/*    */         }
/*    */ 
/*    */ 
/*    */ 
/*    */         
/*    */         public AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 44 */           d.planByte1 = (byte)(d.planByte1 + 1);
/* 45 */           (STATS.NEEDS()).EXPOSURE.fix(a.indu());
/* 46 */           if (d.planByte1 < 8) {
/*    */             
/* 48 */             Room r = (Room)(SETT.ROOMS()).HEARTH.get(a.tc());
/*    */             
/* 50 */             if (r != null) {
/* 51 */               ROOM_SERVICER ss = (ROOM_SERVICER)r;
/* 52 */               if (ss.service().total() - ss.service().reserved() > 4) {
/* 53 */                 if ((d.planByte1 & 0x1) == 1) {
/*    */                   
/* 55 */                   AISTATES.Animation animation = RND.rBoolean() ? (AI.STATES()).anima.box : (AI.STATES()).anima.wave;
/* 56 */                   return (AI.SUBS()).single.activate(a, d, animation, (1.0F + RND.rFloat(3.0D)));
/*    */                 } 
/* 58 */                 return (AI.SUBS()).STAND.activateTime(a, d, 2 + RND.rInt(10));
/*    */               } 
/*    */             } 
/*    */           } 
/*    */ 
/*    */ 
/*    */           
/* 65 */           FSERVICE s = M_PlanHearth.this.get(a, d);
/* 66 */           if (s != null && s.findableReservedIs()) {
/* 67 */             s.consume();
/*    */           }
/* 69 */           return null;
/*    */         }
/*    */ 
/*    */         
/*    */         public boolean con(Humanoid a, AIManager d) {
/* 74 */           FSERVICE s = M_PlanHearth.this.get(a, d);
/* 75 */           return (s != null && s.findableReservedIs());
/*    */         }
/*    */ 
/*    */         
/*    */         public void can(Humanoid a, AIManager d) {
/* 80 */           FSERVICE s = M_PlanHearth.this.get(a, d);
/* 81 */           if (s != null)
/* 82 */             s.findableReserveCancel(); 
/*    */         }
/*    */       };
/*    */   }
/*    */   
/*    */   private final AIPLAN.PLANRES.Resumer first;
/*    */   
/*    */   protected AISUB.AISubActivation arrive(Humanoid a, AIManager d) {
/*    */     return this.first.set(a, d);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\service\M_PlanHearth.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */