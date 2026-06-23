/*    */ package settlement.entity.humanoid.ai.types.prisoner;
/*    */ 
/*    */ import game.time.TIME;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AI;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*    */ import settlement.entity.humanoid.ai.main.AISUB;
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.food.cannibal.Cage;
/*    */ import settlement.room.food.cannibal.ROOM_CANNIBAL;
/*    */ import snake2d.util.MATH;
/*    */ import util.text.D;
/*    */ 
/*    */ class ExecuteCannibal
/*    */   extends AIPLAN.PLANRES {
/* 17 */   private static CharSequence ¤¤verb = "Report to the cannibal for immediate pardon.";
/*    */   static {
/* 19 */     D.ts(ExecuteCannibal.class);
/*    */   }
/* 21 */   private final ROOM_CANNIBAL b = (SETT.ROOMS()).CANNIBAL; private final AIPLAN.PLANRES.Resumer walk;
/*    */   
/*    */   public ExecuteCannibal() {
/* 24 */     super("PUNISH_CANNIBAL");
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 51 */     this.walk = new AIPLAN.PLANRES.Resumer(this, ¤¤verb)
/*    */       {
/*    */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*    */         {
/* 55 */           d.planByte1 = -1;
/* 56 */           return null;
/*    */         }
/*    */ 
/*    */         
/*    */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 61 */           Cage c = ExecuteCannibal.this.b.cage(d.planTile.x(), d.planTile.y());
/* 62 */           if (c == null || !c.prisonerOk()) {
/* 63 */             can(a, d);
/* 64 */             return null;
/*    */           } 
/* 66 */           if (d.planByte1 == -1) {
/* 67 */             d.planByte1 = (byte)(TIME.days().bitsSinceStart() & 0xF);
/* 68 */             c.prisonerArrive();
/*    */           }
/* 70 */           else if (MATH.distance(d.planByte1, TIME.days().bitsSinceStart() & 0xF, 15) >= 2) {
/* 71 */             can(a, d);
/* 72 */             return null;
/*    */           } 
/*    */ 
/*    */ 
/*    */           
/* 77 */           return (AI.SUBS()).STAND.activateRndDir(a, d, 10);
/*    */         }
/*    */ 
/*    */         
/*    */         public boolean con(Humanoid a, AIManager d) {
/* 82 */           return true;
/*    */         }
/*    */ 
/*    */         
/*    */         public void can(Humanoid a, AIManager d) {
/* 87 */           Cage c = ExecuteCannibal.this.b.cage(d.planTile.x(), d.planTile.y());
/* 88 */           if (c != null)
/* 89 */             c.prisonerCancel(); 
/*    */         }
/*    */       };
/*    */   }
/*    */   
/*    */   protected AISUB.AISubActivation init(Humanoid a, AIManager d) {
/*    */     if (!this.b.punishEnabled().is(a.race()))
/*    */       return null; 
/*    */     Cage c = this.b.getPrisonerCage();
/*    */     if (c == null)
/*    */       return null; 
/*    */     d.planTile.set(c.coo());
/*    */     AISUB.AISubActivation s = (AI.SUBS()).walkTo.cooFull(a, d, c.coo());
/*    */     if (s == null)
/*    */       return null; 
/*    */     this.b.cage(d.planTile.x(), d.planTile.y()).prisonerReserve();
/*    */     this.walk.set(a, d);
/*    */     return s;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\types\prisoner\ExecuteCannibal.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */