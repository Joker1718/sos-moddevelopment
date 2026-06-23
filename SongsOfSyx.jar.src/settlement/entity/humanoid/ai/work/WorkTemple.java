/*     */ package settlement.entity.humanoid.ai.work;
/*     */ 
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.entity.humanoid.ai.util.AIPlanResourceMany;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.spirit.temple.ROOM_TEMPLE;
/*     */ import settlement.room.spirit.temple.TempleInstance;
/*     */ import settlement.room.spirit.temple.TempleJob;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.rnd.RND;
/*     */ 
/*     */ final class WorkTemple extends PlanBlueprint {
/*     */   private final ROOM_TEMPLE temple;
/*     */   private final AIPlanResourceMany fetch;
/*     */   private final Res walkToJob;
/*     */   private final Res work;
/*     */   private final Res sacrifice;
/*     */   
/*  23 */   WorkTemple(AIModule_Work module, ROOM_TEMPLE blueprint, PlanBlueprint[] map) { super(module, (RoomBlueprintIns<?>)blueprint, map);
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
/*  63 */     this.fetch = new AIPlanResourceMany(this, 32)
/*     */       {
/*     */         public AISUB.AISubActivation next(Humanoid a, AIManager d)
/*     */         {
/*  67 */           return WorkTemple.this.walkToJob.set(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public void cancel(Humanoid a, AIManager d) {
/*  72 */           WorkTemple.this.unreserve(a, d);
/*     */         }
/*     */       };
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
/*  95 */     this.walkToJob = new Res(this)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/*  99 */           return (AI.SUBS()).walkTo.cooFull(a, d, (COORDINATE)d.planTile);
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 104 */           TempleInstance ins = (TempleInstance)WorkTemple.work(a);
/* 105 */           TempleJob j = ins.job(d.planTile.x(), d.planTile.y());
/* 106 */           a.speed.setDirCurrent(DIR.get(a.tc(), j.faceCoo()));
/* 107 */           return WorkTemple.this.work.set(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 112 */           return WorkTemple.this.reserved(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {
/* 117 */           WorkTemple.this.unreserve(a, d);
/*     */         }
/*     */       };
/*     */     
/* 121 */     this.work = new Res(this)
/*     */       {
/*     */         
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 126 */           TempleInstance ins = (TempleInstance)WorkTemple.work(a);
/* 127 */           TempleJob j = ins.job(d.planTile.x(), d.planTile.y());
/*     */           
/* 129 */           if (d.resourceCarried() != null) {
/* 130 */             j.jobPerform(a, d.resourceA());
/* 131 */             d.resourceCarriedSet(null);
/* 132 */             return null;
/* 133 */           }  if (j.shouldKill()) {
/* 134 */             return WorkTemple.this.sacrifice.set(a, d);
/*     */           }
/* 136 */           d.planByte1 = 10;
/* 137 */           return res(a, d);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 143 */           d.planByte1 = (byte)(d.planByte1 - 1);
/* 144 */           if (d.planByte1 <= 0) {
/* 145 */             WorkTemple.this.unreserve(a, d);
/* 146 */             return null;
/*     */           } 
/* 148 */           if (RND.oneIn(5))
/* 149 */             WorkTemple.this.temple.employment().sound().rnd(a); 
/* 150 */           a.speed.setDirCurrent(a.speed.dir().next(RND.rInt0(1)));
/* 151 */           return (AI.SUBS()).single.activate(a, d, WorkTemple.this.preach[RND.rInt(WorkTemple.this.preach.length)], (2.0F + RND.rFloat(4.0D)));
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 157 */           return WorkTemple.this.reserved(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {
/* 162 */           WorkTemple.this.unreserve(a, d);
/*     */         }
/*     */       };
/*     */     
/* 166 */     this.sacrifice = new Res(this)
/*     */       {
/*     */         
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 171 */           return (AI.SUBS()).single.activate(a, d, (AI.STATES()).anima.stab, 10.0D);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 177 */           TempleInstance ins = (TempleInstance)WorkTemple.work(a);
/* 178 */           TempleJob j = ins.job(d.planTile.x(), d.planTile.y());
/*     */           
/* 180 */           if (j.shouldKill()) {
/* 181 */             j.kill();
/*     */             
/* 183 */             if (j.shouldKill()) {
/* 184 */               return setAction(a, d);
/*     */             }
/* 186 */             WorkTemple.this.temple.employment().sound().rnd(a);
/* 187 */             return (AI.SUBS()).single.activate(a, d, (AI.STATES()).anima.armsOut, 4.0D);
/*     */           } 
/*     */           
/* 190 */           WorkTemple.this.unreserve(a, d);
/* 191 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 196 */           return WorkTemple.this.reserved(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {
/* 201 */           WorkTemple.this.unreserve(a, d);
/*     */         }
/*     */       };
/*     */     
/* 205 */     this.walkAround = new Res(this)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 209 */           return (AI.SUBS()).walkTo.room(a, d, WorkTemple.work(a));
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 214 */           return WorkTemple.this.standAround.set(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 219 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/* 228 */     this.standAround = new Res(this)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 232 */           d.planByte1 = 10;
/* 233 */           return res(a, d);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 239 */           d.planByte1 = (byte)(d.planByte1 - 1);
/* 240 */           if (d.planByte1 <= 0) {
/* 241 */             return null;
/*     */           }
/* 243 */           a.speed.setDirCurrent(a.speed.dir().next(RND.rInt0(1)));
/* 244 */           if (RND.oneIn(5))
/* 245 */             WorkTemple.this.temple.employment().sound().rnd(a); 
/* 246 */           return (AI.SUBS()).single.activate(a, d, WorkTemple.this.preach[RND.rInt(WorkTemple.this.preach.length)], (2.0F + RND.rFloat(4.0D)));
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 251 */           return (WorkTemple.work(a) != null);
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/* 261 */     this
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 268 */       .preach = new AISTATES.Animation[] { (AI.STATES()).anima.carry, (AI.STATES()).anima.armsOut, (AI.STATES()).anima.fist, (AI.STATES()).anima.wave, (AI.STATES()).anima.stand, (AI.STATES()).anima.stand, (AI.STATES()).anima.stand }; this.temple = blueprint; }
/*     */   private final Res walkAround; private final Res standAround; private final AISTATES.Animation[] preach; protected AISUB.AISubActivation init(Humanoid a, AIManager d) { if (RND.oneIn(8))
/*     */       return this.walkAround.set(a, d);  TempleInstance ins = (TempleInstance)work(a); TempleJob j = ins.jobReservable(a.tc().x(), a.tc().y()); if (j == null)
/*     */       return this.walkAround.set(a, d);  d.planTile.set(j.coo()); d.planByte1 = -1; if (j.jobResourceBitToFetch() != null) { AISUB.AISubActivation aISubActivation = this.fetch.activate(a, d, j.jobResourceBitToFetch(), maxCarry, 1000, true, true); if (aISubActivation != null) { j = ins.job(d.planTile.x(), d.planTile.y()); j.jobReserve(); return aISubActivation; }
/*     */        j = ins.job(d.planTile.x(), d.planTile.y()); j.reportMissingResource(); }
/*     */      AISUB.AISubActivation s = this.walkToJob.set(a, d); if (s != null) { j = ins.job(d.planTile.x(), d.planTile.y()); j.jobReserve(); return s; }
/*     */      return this.walkAround.set(a, d); } private boolean reserved(Humanoid a, AIManager d) { if (work(a) != null) { TempleInstance ins = (TempleInstance)work(a); TempleJob j = ins.job(d.planTile.x(), d.planTile.y()); return (j != null && j.jobReservedIs()); }
/*     */      return false; } private void unreserve(Humanoid a, AIManager d) { Room r = (Room)(SETT.ROOMS()).map.get((COORDINATE)d.planTile); if (r != null && r instanceof TempleInstance) { TempleInstance ins = (TempleInstance)r; TempleJob j = ins.job(d.planTile.x(), d.planTile.y()); if (j != null)
/*     */         j.jobReserveCancel();  }
/*     */      } private abstract class Res extends AIPLAN.PLANRES.Resumer
/*     */   {
/* 279 */     protected Res() { super(WorkTemple.this, ""); }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected void name(Humanoid a, AIManager d, Str string) {
/* 285 */       string.add((WorkTemple.this.temple.employment()).verb);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\work\WorkTemple.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */