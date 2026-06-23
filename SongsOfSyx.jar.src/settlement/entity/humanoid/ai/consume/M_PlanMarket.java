/*     */ package settlement.entity.humanoid.ai.consume;
/*     */ 
/*     */ import init.race.RACES;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.service.market.ROOM_MARKET;
/*     */ import settlement.stats.equip.WearableResource;
/*     */ import snake2d.util.rnd.RND;
/*     */ 
/*     */ final class M_PlanMarket
/*     */   extends SPlanAbs<ROOM_MARKET> {
/*     */   public M_PlanMarket(AIModule_Shop m) {
/*  18 */     super("Market", (SETT.ROOMS()).MARKET, false);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  27 */     this.first = new AIPLAN.PLANRES.Resumer(this, "")
/*     */       {
/*     */         
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/*  32 */           M_PlanMarket.this.get(a, d).findableReserveCancel();
/*  33 */           d.planByte1 = (byte)(5 + RND.rInt(5));
/*  34 */           return (AI.SUBS()).STAND.activateRndDir(a, d, 5);
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/*  39 */           return M_PlanMarket.this.shop.set(a, d);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/*  45 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/*  54 */     this.shop = new AIPLAN.PLANRES.Resumer(this, "")
/*     */       {
/*     */         
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/*  59 */           return (AI.SUBS()).STAND.activateRndDir(a, d, 5);
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/*  64 */           ROOM_MARKET m = M_PlanMarket.this.blue(d);
/*  65 */           if (m == null || !m.is(a.tc())) {
/*  66 */             return d.resumeOtherPlan(a, (AIPLAN)M_PlanMarket.this.mm.ground);
/*     */           }
/*  68 */           boolean bought = false;
/*     */           
/*  70 */           for (WearableResource e : RACES.res().all(a.indu().popCL())) {
/*  71 */             int needed = e.needed(a.indu());
/*  72 */             if (needed > 0) {
/*  73 */               int am = m.buy(RACES.res().get(e.resource(a.indu())), needed, a.tc().x(), a.tc().y());
/*  74 */               if (am > 0) {
/*  75 */                 bought = true;
/*  76 */                 e.wearOut(a.indu());
/*  77 */                 e.inc(a.indu(), am);
/*     */               } 
/*     */             } 
/*     */           } 
/*     */           
/*  82 */           d.planByte1 = (byte)(d.planByte1 - 1);
/*  83 */           if (bought || d.planByte1 > 0) {
/*  84 */             return M_PlanMarket.this.walk.set(a, d);
/*     */           }
/*  86 */           return d.resumeOtherPlan(a, (AIPLAN)M_PlanMarket.this.mm.ground);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/*  91 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/* 100 */     this.walk = new AIPLAN.PLANRES.Resumer(this, "")
/*     */       {
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 106 */           ROOM_MARKET m = M_PlanMarket.this.blue(d);
/* 107 */           if (m.is(a.tc()) && d.planByte1 > 0) {
/* 108 */             AISUB.AISubActivation s = (AI.SUBS()).walkTo.room(a, d, (RoomInstance)m.getter.get(a.tc()));
/* 109 */             if (s != null) {
/* 110 */               return s;
/*     */             }
/*     */           } 
/* 113 */           return d.resumeOtherPlan(a, (AIPLAN)M_PlanMarket.this.mm.ground);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 119 */           return M_PlanMarket.this.shop.set(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 124 */           return true;
/*     */         }
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/*     */     this.mm = m;
/*     */   }
/*     */   
/*     */   private final AIModule_Shop mm;
/*     */   final AIPLAN.PLANRES.Resumer first;
/*     */   final AIPLAN.PLANRES.Resumer shop;
/*     */   final AIPLAN.PLANRES.Resumer walk;
/*     */   
/*     */   protected AISUB.AISubActivation arrive(Humanoid a, AIManager d) {
/*     */     return this.first.set(a, d);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\consume\M_PlanMarket.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */