/*    */ package settlement.entity.humanoid.ai.service;
/*    */ import game.faction.FACTIONS;
/*    */ import game.faction.FResources;
/*    */ import init.resources.RES_AMOUNT;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AI;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*    */ import settlement.entity.humanoid.ai.main.AISUB;
/*    */ import settlement.main.SETT;
/*    */ import settlement.misc.util.FSERVICE;
/*    */ import settlement.room.service.barber.ROOM_BARBER;
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import snake2d.util.rnd.RND;
/*    */ 
/*    */ final class M_PlanBarber extends MPlan<ROOM_BARBER> {
/*    */   public M_PlanBarber() {
/* 19 */     super("Barber", (SETT.ROOMS()).BARBERS, true);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 27 */     this.first = new AIPLAN.PLANRES.Resumer(this, "")
/*    */       {
/*    */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*    */         {
/* 31 */           d.planByte2 = (byte)(5 + RND.rInt(15));
/* 32 */           M_PlanBarber.this.get(a, d).startUsing();
/* 33 */           return res(a, d);
/*    */         }
/*    */ 
/*    */ 
/*    */         
/*    */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 39 */           d.planByte2 = (byte)(d.planByte2 - 1); if (d.planByte2 < 0) {
/* 40 */             M_PlanBarber.this.get(a, d).consume();
/* 41 */             for (int di = 0; di < DIR.ORTHO.size(); di++) {
/* 42 */               if (!(SETT.PATH()).solidity.is((COORDINATE)d.planTile, (DIR)DIR.ORTHO.get(di))) {
/* 43 */                 for (RES_AMOUNT ra : a.race().resourcesGroom()) {
/* 44 */                   FACTIONS.player().res().inc(ra.resource(), FResources.RTYPE.PRODUCED, ra.amount());
/* 45 */                   (SETT.THINGS()).resources.create(d.planTile.x(), d.planTile.y(), ra.resource(), ra.amount());
/*    */                 } 
/*    */               }
/*    */             } 
/* 49 */             return null;
/*    */           } 
/*    */           
/* 52 */           DIR dir = M_PlanBarber.this.blue(d).dir(d.planTile.x(), d.planTile.y());
/*    */           
/* 54 */           if ((M_PlanBarber.this.blue(d).service()).usageSound != null && RND.oneIn(5)) {
/* 55 */             (M_PlanBarber.this.blue(d).service()).usageSound.rnd(a);
/*    */           }
/* 57 */           if (RND.rBoolean()) {
/* 58 */             a.speed.setDirCurrent(dir);
/* 59 */             if (RND.rBoolean()) {
/* 60 */               return (AI.SUBS()).STAND.activateRndDir(a, d, 6);
/*    */             }
/* 62 */             return (AI.SUBS()).STAND.activate(a, d, (AI.STATES()).anima.box.activate(a, d, 3.0D));
/*    */           } 
/*    */           
/* 65 */           dir = dir.next((int)RND.rSign());
/* 66 */           return (AI.SUBS()).STAND.activateRndDir(a, d, 6);
/*    */         }
/*    */ 
/*    */ 
/*    */ 
/*    */         
/*    */         public boolean con(Humanoid a, AIManager d) {
/* 73 */           FSERVICE fSERVICE = M_PlanBarber.this.get(a, d);
/* 74 */           return (fSERVICE != null && fSERVICE.findableReservedIs());
/*    */         }
/*    */ 
/*    */         
/*    */         public void can(Humanoid a, AIManager d) {
/* 79 */           FSERVICE fSERVICE = M_PlanBarber.this.get(a, d);
/* 80 */           if (fSERVICE != null)
/* 81 */             fSERVICE.findableReserveCancel(); 
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


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\service\M_PlanBarber.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */