/*     */ package settlement.entity.humanoid.ai.work;
/*     */ 
/*     */ import game.GAME;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RES_AMOUNT;
/*     */ import init.type.CAUSE_LEAVES;
/*     */ import init.type.HTYPES;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import settlement.room.food.cannibal.Cage;
/*     */ import settlement.room.food.cannibal.CannibalInstance;
/*     */ import settlement.room.food.cannibal.ROOM_CANNIBAL;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.thing.ThingsCorpses;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ 
/*     */ final class WorkCannibal extends PlanBlueprint {
/*  27 */   private final ROOM_CANNIBAL b = (SETT.ROOMS()).CANNIBAL; final AIPLAN.PLANRES.Resumer fetch1;
/*     */   final AIPLAN.PLANRES.Resumer kill;
/*     */   
/*     */   protected WorkCannibal(AIModule_Work module, PlanBlueprint[] map) {
/*  31 */     super(module, (RoomBlueprintIns<?>)(SETT.ROOMS()).CANNIBAL, map);
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
/*     */ 
/*     */ 
/*     */     
/*  74 */     this.fetch1 = new AIPLAN.PLANRES.Resumer(this, (this.b.employment()).verb)
/*     */       {
/*     */         public AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/*  78 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public AISUB.AISubActivation res(Humanoid a, AIManager d) {
/*  83 */           return WorkCannibal.this.kill.set(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/*  88 */           if (WorkCannibal.this.job(a, d) == null || !WorkCannibal.this.job(a, d).jobReservedIs(null))
/*  89 */             return false; 
/*  90 */           Cage c = WorkCannibal.this.b.cage(d.path.destX(), d.path.destY());
/*  91 */           if (c == null)
/*  92 */             return false; 
/*  93 */           return true;
/*     */         }
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {
/*  98 */           if (WorkCannibal.this.job(a, d) != null && WorkCannibal.this.job(a, d).jobReservedIs(null))
/*  99 */             WorkCannibal.this.job(a, d).jobReserveCancel(null); 
/* 100 */           Cage c = WorkCannibal.this.b.cage(d.path.destX(), d.path.destY());
/* 101 */           if (c != null) {
/* 102 */             c.grabCancel();
/*     */           }
/*     */         }
/*     */       };
/*     */     
/* 107 */     this.kill = new AIPLAN.PLANRES.Resumer(this, (this.b.employment()).verb)
/*     */       {
/*     */         public AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 111 */           return (AI.SUBS()).WORK_HANDS.activate(a, d, 3.0D);
/*     */         }
/*     */ 
/*     */         
/*     */         public AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 116 */           WorkCannibal.this.b.cage(d.path.destX(), d.path.destY()).grabCancel();
/*     */           
/* 118 */           ThingsCorpses.Corpse c = victim(d);
/* 119 */           if (c == null) {
/* 120 */             can(a, d);
/* 121 */             return null;
/*     */           } 
/* 123 */           c.findableReserve();
/* 124 */           d.planObject = c.index();
/* 125 */           WorkCannibal.this.b.setRace(d.planTile.x(), d.planTile.y(), c.race());
/*     */ 
/*     */ 
/*     */           
/* 129 */           return WorkCannibal.this.drag_back2.set(a, d);
/*     */         }
/*     */         
/*     */         private ThingsCorpses.Corpse victim(AIManager d) {
/* 133 */           ENTITY e = SETT.ENTITIES().getAtTileSingle(d.path.destX(), d.path.destY());
/* 134 */           if (e == null) {
/* 135 */             return null;
/*     */           }
/* 137 */           if (e instanceof Humanoid) {
/* 138 */             Humanoid a = (Humanoid)e;
/* 139 */             if (a.indu().hType() != HTYPES.PRISONER()) {
/* 140 */               return null;
/*     */             }
/* 142 */             a.kill(false, CAUSE_LEAVES.EXECUTED());
/*     */             
/* 144 */             return (ThingsCorpses.Corpse)(SETT.PATH()).finders.corpses.getReservable(d.path.destX(), d.path.destY());
/*     */           } 
/* 146 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 151 */           return WorkCannibal.this.fetch1.con(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {
/* 156 */           WorkCannibal.this.fetch1.can(a, d);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 161 */     this.drag_back2 = new AIPLAN.PLANRES.Resumer(this, (this.b.employment()).verb)
/*     */       {
/*     */         public AISUB.AISubActivation res(Humanoid a, AIManager d)
/*     */         {
/* 165 */           return WorkCannibal.this.butcher2.set(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 170 */           ThingsCorpses.Corpse prey = (SETT.THINGS()).corpses.getByIndex((short)d.planObject);
/* 171 */           return (AI.SUBS()).walkTo.drag(a, d, (SETT.THINGS()).corpses.draggable, prey.index(), (COORDINATE)d.planTile);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 176 */           if (WorkCannibal.this.job(a, d) == null || !WorkCannibal.this.job(a, d).jobReservedIs(null))
/* 177 */             return false; 
/* 178 */           return ((SETT.THINGS()).corpses.getByIndex((short)d.planObject) != null);
/*     */         }
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {
/* 183 */           ThingsCorpses.Corpse prey = (SETT.THINGS()).corpses.getByIndex((short)d.planObject);
/* 184 */           if (prey != null) {
/* 185 */             prey.findableReserveCancel();
/* 186 */             d.planObject = -1;
/*     */           } 
/* 188 */           if (WorkCannibal.this.job(a, d) != null && WorkCannibal.this.job(a, d).jobReservedIs(null)) {
/* 189 */             WorkCannibal.this.job(a, d).jobReserveCancel(null);
/*     */           }
/*     */         }
/*     */       };
/* 193 */     this.butcher2 = new AIPLAN.PLANRES.Resumer(this, (this.b.employment()).verb)
/*     */       {
/*     */         
/*     */         public AISUB.AISubActivation res(Humanoid a, AIManager d)
/*     */         {
/* 198 */           ThingsCorpses.Corpse prey = (SETT.THINGS()).corpses.getByIndex((short)d.planObject);
/* 199 */           if (prey == null) {
/* 200 */             can(a, d);
/* 201 */             return null;
/*     */           } 
/*     */           
/* 204 */           produce(prey, a, d);
/*     */           
/* 206 */           if (prey.isRemoved()) {
/* 207 */             can(a, d);
/* 208 */             return null;
/*     */           } 
/* 210 */           WorkCannibal.this.b.employment().sound().rnd(a);
/* 211 */           return (AI.SUBS()).WORK_HANDS.activate(a, d, 5.0D);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         private void produce(ThingsCorpses.Corpse corpse, Humanoid a, AIManager d) {
/* 217 */           (SETT.ROOMS()).CANNIBAL.reportCannibal(corpse.race());
/*     */           
/* 219 */           if (corpse.resLeft() <= 0.0D) {
/* 220 */             if (corpse.indu().race().resources().size() > 0) {
/* 221 */               RES_AMOUNT rr = (RES_AMOUNT)corpse.indu().race().resources().rnd();
/* 222 */               produce(rr.resource(), 1, a, d);
/*     */             } 
/* 224 */             corpse.remove();
/*     */             
/*     */             return;
/*     */           } 
/* 228 */           double dd = corpse.resLeft();
/* 229 */           if (dd > 0.25D) {
/* 230 */             dd = 0.25D;
/*     */           }
/* 232 */           for (RES_AMOUNT rr : corpse.indu().race().resources()) {
/* 233 */             int am = (int)(1.0D + rr.amount() * dd);
/* 234 */             produce(rr.resource(), am, a, d);
/*     */           } 
/*     */           
/* 237 */           (STATS.NEEDS()).INJURIES.COUNT.indu().incD(corpse.indu(), 0.1D);
/* 238 */           corpse.resRemove();
/*     */           
/* 240 */           if (corpse.resLeft() <= 0.0D) {
/* 241 */             corpse.remove();
/*     */           }
/*     */         }
/*     */         
/*     */         private void produce(RESOURCE res, int am, Humanoid a, AIManager d) {
/* 246 */           CannibalInstance in = (CannibalInstance)WorkCannibal.work(a);
/* 247 */           int kk = in.produce(res, am);
/*     */           
/* 249 */           in.gore((COORDINATE)d.planTile);
/*     */           
/* 251 */           DIR dd = a.speed.dir().next((kk == 0) ? -1 : 1);
/* 252 */           (SETT.THINGS()).resources.create(a.tc().x() + dd.x(), a.tc().y() + dd.y(), res, am);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 258 */           CannibalInstance in = (CannibalInstance)WorkCannibal.work(a);
/* 259 */           if (in == null)
/* 260 */             return false; 
/* 261 */           if (in.getWork((COORDINATE)d.planTile) == null || !in.getWork((COORDINATE)d.planTile).jobReservedIs(null))
/* 262 */             return false; 
/* 263 */           return true;
/*     */         }
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {
/* 268 */           ThingsCorpses.Corpse prey = (SETT.THINGS()).corpses.getByIndex((short)d.planObject);
/* 269 */           if (prey != null) {
/* 270 */             prey.findableReserveCancel();
/* 271 */             d.planObject = -1;
/*     */           } 
/* 273 */           CannibalInstance in = (CannibalInstance)WorkCannibal.work(a);
/* 274 */           if (in == null)
/*     */             return; 
/* 276 */           if (in.getWork((COORDINATE)d.planTile) == null || !in.getWork((COORDINATE)d.planTile).jobReservedIs(null))
/*     */             return; 
/* 278 */           in.getWork((COORDINATE)d.planTile).jobReserveCancel(null);
/*     */         }
/*     */         
/*     */         public AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 283 */           ThingsCorpses.Corpse prey = (SETT.THINGS()).corpses.getByIndex((short)d.planObject);
/* 284 */           prey.drag(DIR.N, d.planTile.x() * 64 + 32, d.planTile.y() * 64 + 32, 0);
/* 285 */           CannibalInstance in = (CannibalInstance)WorkCannibal.work(a);
/* 286 */           in.resetGore((COORDINATE)d.planTile);
/* 287 */           return (AI.SUBS()).WORK_HANDS.activate(a, d, 12.0D);
/*     */         }
/*     */       };
/*     */   }
/*     */   final AIPLAN.PLANRES.Resumer drag_back2; final AIPLAN.PLANRES.Resumer butcher2;
/*     */   protected boolean shouldContinue(Humanoid a, AIManager d) {
/* 293 */     boolean be = super.shouldContinue(a, d);
/* 294 */     if (!be)
/* 295 */       GAME.Notify("here"); 
/* 296 */     return be;
/*     */   }
/*     */   
/*     */   public AISUB.AISubActivation init(Humanoid a, AIManager d) {
/*     */     CannibalInstance in = (CannibalInstance)work(a);
/*     */     SETT_JOB j = in.getWork();
/*     */     if (j == null) {
/*     */       GAME.Notify("Weird " + in.mX() + " " + in.mY());
/*     */       return null;
/*     */     } 
/*     */     d.planTile.set(j.jobCoo());
/*     */     Cage c = this.b.getWorkCage((RoomInstance)in);
/*     */     if (c == null)
/*     */       return null; 
/*     */     AISUB.AISubActivation s = (AI.SUBS()).walkTo.coo(a, d, c.coo());
/*     */     if (s != null) {
/*     */       in.getWork((COORDINATE)d.planTile).jobReserve(null);
/*     */       this.b.cage(d.path.destX(), d.path.destY()).grab();
/*     */       this.fetch1.set(a, d);
/*     */       return s;
/*     */     } 
/*     */     return null;
/*     */   }
/*     */   
/*     */   private SETT_JOB job(Humanoid a, AIManager d) {
/*     */     if (work(a) == null)
/*     */       return null; 
/*     */     CannibalInstance in = (CannibalInstance)work(a);
/*     */     return in.getWork((COORDINATE)d.planTile);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\work\WorkCannibal.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */