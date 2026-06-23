/*     */ package settlement.entity.humanoid.ai.types.guard;
/*     */ 
/*     */ import settlement.entity.humanoid.HPoll;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.law.execution.ExecutionStation;
/*     */ import settlement.room.law.guard.GuardInstance;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.rnd.RND;
/*     */ import util.text.D;
/*     */ 
/*     */ final class PlanExecute
/*     */   extends AIPLAN.PLANRES
/*     */ {
/*  22 */   private static CharSequence ¤¤name = "Executing Prisoners"; final AIPLAN.PLANRES.Resumer walk; private final AIPLAN.PLANRES.Resumer wait;
/*     */   static {
/*  24 */     D.ts(PlanExecute.class);
/*     */   }
/*     */   private final AIPLAN.PLANRES.Resumer execute; private final AIPLAN.PLANRES.Resumer after;
/*     */   protected PlanExecute() {
/*  28 */     super("GUARD_EXECUTE");
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
/*  51 */     this.walk = new AIPLAN.PLANRES.Resumer(this, ¤¤name)
/*     */       {
/*     */         
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/*  56 */           ExecutionStation.Guard g = (SETT.ROOMS()).GUARD.reporter.pollExecution(PlanExecute.work(a));
/*  57 */           if (g == null) {
/*  58 */             return null;
/*     */           }
/*  60 */           d.planTile.set(g.coo());
/*     */           
/*  62 */           AISUB.AISubActivation s = (AI.SUBS()).walkTo.coo(a, d, (COORDINATE)d.planTile);
/*     */           
/*  64 */           if (s == null) {
/*  65 */             (SETT.ROOMS()).GUARD.reporter.reportExecution(g.coo().x(), g.coo().y());
/*  66 */             return null;
/*     */           } 
/*  68 */           return s;
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/*  73 */           return PlanExecute.this.wait.set(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/*  78 */           ExecutionStation.Guard s = PlanExecute.this.s(d);
/*  79 */           if (s == null || !s.active())
/*  80 */             return false; 
/*  81 */           return true;
/*     */         }
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {
/*  86 */           ExecutionStation.Guard s = PlanExecute.this.s(d);
/*  87 */           if (s != null && s.active()) {
/*  88 */             (SETT.ROOMS()).GUARD.reporter.reportExecution(s.coo().x(), s.coo().y());
/*     */           }
/*     */         }
/*     */       };
/*     */     
/*  93 */     this.wait = new AIPLAN.PLANRES.Resumer(this, ¤¤name)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/*  97 */           d.planByte1 = (byte)(2 + RND.rInt(5));
/*  98 */           return (AI.SUBS()).single.activate(a, d, (AI.STATES()).STAND_SWORD.activate(a, d, (5 + RND.rInt(5))));
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 104 */           d.planByte1 = (byte)(d.planByte1 - 1); if (d.planByte1 <= 0) {
/* 105 */             return PlanExecute.this.execute.set(a, d);
/*     */           }
/* 107 */           a.speed.turn2(DIR.get(a.tc(), (COORDINATE)d.planTile).next(-1 + RND.rInt(3)));
/* 108 */           return (AI.SUBS()).single.activate(a, d, (AI.STATES()).STAND_SWORD.activate(a, d, (5 + RND.rInt(5))));
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 114 */           return PlanExecute.this.walk.con(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {
/* 119 */           PlanExecute.this.walk.can(a, d);
/*     */         }
/*     */       };
/*     */     
/* 123 */     this.execute = new AIPLAN.PLANRES.Resumer(this, ¤¤name)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 127 */           int code = PlanExecute.this.ss().type(d.planTile.x(), d.planTile.y());
/*     */           
/* 129 */           if (code == 1) {
/* 130 */             return (AI.SUBS()).single.activate(a, d, (AI.STATES()).anima.work.activate(a, d));
/*     */           }
/* 132 */           return (AI.SUBS()).single.activate(a, d, (AI.STATES()).anima.grab.activate(a, d));
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 138 */           ExecutionStation.Guard s = PlanExecute.this.s(d);
/* 139 */           if (s == null || !s.active()) {
/* 140 */             return PlanExecute.this.after.set(a, d);
/*     */           }
/* 142 */           if (s.workExecute()) {
/* 143 */             return set(a, d);
/*     */           }
/* 145 */           return PlanExecute.this.after.set(a, d);
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 152 */           return true;
/*     */         }
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {
/* 157 */           PlanExecute.this.walk.can(a, d);
/*     */         }
/*     */       };
/*     */     
/* 161 */     this.after = new AIPLAN.PLANRES.Resumer(this, ¤¤name)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 165 */           d.planByte1 = (byte)(2 + RND.rInt(5));
/* 166 */           return (AI.SUBS()).single.activate(a, d, (AI.STATES()).STAND_SWORD.activate(a, d, (5 + RND.rInt(5))));
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 171 */           d.planByte1 = (byte)(d.planByte1 - 1); if (d.planByte1 <= 0)
/* 172 */             return null; 
/* 173 */           a.speed.turn2(DIR.get(a.tc(), (COORDINATE)d.planTile).next(-1 + RND.rInt(3)));
/* 174 */           return (AI.SUBS()).single.activate(a, d, (AI.STATES()).STAND_SWORD.activate(a, d, (5 + RND.rInt(5))));
/*     */         }
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d)
/*     */         {
/* 179 */           return true;
/*     */         }
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/*     */   }
/*     */   
/*     */   protected AISUB.AISubActivation init(Humanoid a, AIManager d) {
/*     */     return this.walk.set(a, d);
/*     */   }
/*     */   
/*     */   public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/* 190 */     if (e.type == HPoll.WORKING)
/* 191 */       return 1.0D; 
/* 192 */     return super.poll(a, d, e);
/*     */   }
/*     */   
/*     */   static GuardInstance work(Humanoid a) {
/*     */     RoomInstance ins = (RoomInstance)(STATS.WORK()).EMPLOYED.get(a);
/*     */     if (ins != null && ins instanceof GuardInstance)
/*     */       return (GuardInstance)ins; 
/*     */     return null;
/*     */   }
/*     */   
/*     */   private ExecutionStation.Guard s(AIManager d) {
/*     */     return (SETT.ROOMS()).EXECUTION.stations.guard(d.planTile.x(), d.planTile.y());
/*     */   }
/*     */   
/*     */   private ExecutionStation ss() {
/*     */     return (SETT.ROOMS()).EXECUTION.stations;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\types\guard\PlanExecute.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */