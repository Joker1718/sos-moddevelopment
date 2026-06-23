/*     */ package settlement.entity.humanoid.ai.work;
/*     */ 
/*     */ import game.GAME;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.animal.AnimalSpecies;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIModules;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.food.hunter.ROOM_HUNTER;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.thing.ThingsCadavers;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ 
/*     */ final class WorkHunter extends PlanBlueprint {
/*     */   private final ROOM_HUNTER b;
/*     */   final AIPLAN.PLANRES.Resumer walk;
/*     */   final AIPLAN.PLANRES.Resumer leave;
/*     */   
/*     */   protected WorkHunter(ROOM_HUNTER b, AIModule_Work module, PlanBlueprint[] map) {
/*  30 */     super(module, (RoomBlueprintIns<?>)b, map);
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
/*     */     
/*  74 */     this.walk = new AIPLAN.PLANRES.Resumer(this)
/*     */       {
/*     */         public AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/*  78 */           STATS.WORK().proximityStart(a);
/*  79 */           return (AI.SUBS()).walkTo.coo(a, d, (COORDINATE)d.planTile);
/*     */         }
/*     */ 
/*     */         
/*     */         public AISUB.AISubActivation res(Humanoid a, AIManager d) {
/*  84 */           STATS.WORK().proximityEnd(a);
/*  85 */           return WorkHunter.this.butcher.set(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {
/*  90 */           WorkHunter.this.b.workFinish((COORDINATE)d.planTile);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/*  95 */           return (WorkHunter.work(a) != null && WorkHunter.work(a).blueprint() == WorkHunter.this.b);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 100 */     this.leave = new AIPLAN.PLANRES.Resumer(this)
/*     */       {
/*     */         public AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 104 */           if ((SETT.PATH()).finders.entryPoints.any(a.tc().x(), a.tc().y(), d.path, 2147483647)) {
/* 105 */             WorkHunter.this.b.reportSkill(WorkHunter.work(a), a);
/* 106 */             return (AI.SUBS()).walkTo.pathFull(a, d);
/*     */           } 
/* 108 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 113 */           return WorkHunter.this.hunt.set(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {
/* 118 */           WorkHunter.this.b.workFinish((COORDINATE)d.planTile);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 123 */           return (WorkHunter.work(a) != null && WorkHunter.work(a).blueprint() == WorkHunter.this.b);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 128 */     this.hunt = new AIPLAN.PLANRES.Resumer(this)
/*     */       {
/*     */         public AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 132 */           SETT.ENTITIES().moveIntoTheTheUnknown((ENTITY)a);
/* 133 */           a.speed.magnitudeInit(0.0D);
/* 134 */           return (AI.SUBS()).STAND.activate(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 139 */           WorkHunter.this.b.reportSkill(WorkHunter.work(a), a);
/* 140 */           if ((STATS.WORK()).WORK_TIME.indu().getD(a.indu()) > 0.5D || !AIModules.current(d).moduleCanContinue(a, d)) {
/* 141 */             can(a, d);
/* 142 */             return WorkHunter.this.drag.set(a, d);
/*     */           } 
/* 144 */           return (AI.SUBS()).STAND.activate(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {
/* 149 */           SETT.ENTITIES().returnFromTheTheUnknown((ENTITY)a);
/* 150 */           WorkHunter.this.b.workFinish((COORDINATE)d.planTile);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 155 */           return (WorkHunter.work(a) != null && WorkHunter.work(a).blueprint() == WorkHunter.this.b);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 160 */     this.drag = new AIPLAN.PLANRES.Resumer(this)
/*     */       {
/*     */         
/*     */         public AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 165 */           AnimalSpecies ss = spe();
/* 166 */           ThingsCadavers.Cadaver c = (SETT.THINGS()).cadavers.normal(a.tc().x(), a.tc().y(), ss.mass() * RND.rFloat1(1.1D), 1.0F, ss, 2);
/* 167 */           if (c == null) {
/* 168 */             return null;
/*     */           }
/* 170 */           d.planObject = c.index();
/* 171 */           RoomInstance in = WorkHunter.work(a);
/*     */           
/* 173 */           COORDINATE j = WorkHunter.this.b.reserveWork(in, a);
/*     */           
/* 175 */           if (j == null) {
/* 176 */             GAME.Notify("Weird " + in.mX() + " " + in.mY());
/* 177 */             return null;
/*     */           } 
/* 179 */           d.planTile.set(j);
/*     */           
/* 181 */           AISUB.AISubActivation ac = (AI.SUBS()).walkTo.drag(a, d, (SETT.THINGS()).cadavers.draggable, c.index(), (COORDINATE)d.planTile);
/* 182 */           if (ac != null) {
/* 183 */             return ac;
/*     */           }
/* 185 */           can(a, d);
/* 186 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         private ThingsCadavers.Cadaver getCadaver(Humanoid a, AIManager d) {
/* 191 */           if (d.planObject == -1)
/* 192 */             return null; 
/* 193 */           ThingsCadavers.Cadaver e = (SETT.THINGS()).cadavers.getByIndex(d.planObject);
/*     */           
/* 195 */           if (e == null || e.isRemoved() || !e.resHas()) {
/* 196 */             d.planObject = -1;
/* 197 */             return null;
/*     */           } 
/* 199 */           return e;
/*     */         }
/*     */ 
/*     */         
/*     */         public AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 204 */           ThingsCadavers.Cadaver old = (ThingsCadavers.Cadaver)(SETT.THINGS()).cadavers.tGet.get((COORDINATE)d.planTile);
/* 205 */           if (old != null)
/* 206 */             old.remove(); 
/* 207 */           ThingsCadavers.Cadaver c = getCadaver(a, d);
/* 208 */           c.drag((DIR)DIR.ORTHO.get(((FurnisherItem)(SETT.ROOMS()).fData.item.get((COORDINATE)d.planTile)).rotation), (d.planTile.x() << 6) + 32, (d.planTile.y() << 6) + 32, 0);
/* 209 */           return WorkHunter.this.butcher.set(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {
/* 214 */           WorkHunter.this.b.workFinish((COORDINATE)d.planTile);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 219 */           return (WorkHunter.work(a) != null && WorkHunter.work(a).blueprint() == WorkHunter.this.b && getCadaver(a, d) != null);
/*     */         }
/*     */         
/*     */         private AnimalSpecies spe() {
/* 223 */           double tot = 0.0D;
/* 224 */           for (AnimalSpecies s : SETT.ANIMALS().sett()) {
/* 225 */             tot += s.occurence(SETT.WORLD_AREA().climate());
/*     */           }
/* 227 */           tot *= RND.rFloat();
/* 228 */           for (AnimalSpecies s : SETT.ANIMALS().sett()) {
/* 229 */             tot -= s.occurence(SETT.WORLD_AREA().climate());
/* 230 */             if (tot <= 0.0D)
/* 231 */               return s; 
/*     */           } 
/* 233 */           return (AnimalSpecies)SETT.ANIMALS().sett().rnd();
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 238 */     this.butcher = new AIPLAN.PLANRES.Resumer(this)
/*     */       {
/*     */         
/*     */         public AISUB.AISubActivation res(Humanoid a, AIManager d)
/*     */         {
/* 243 */           if (AIModules.current(d).moduleCanContinue(a, d)) {
/* 244 */             ThingsCadavers.Cadaver prey = WorkHunter.this.getCadaver(a, d);
/* 245 */             if (prey != null) {
/* 246 */               WorkHunter.this.b.work(WorkHunter.work(a), (COORDINATE)d.planTile, a, true);
/* 247 */               can(a, d);
/* 248 */               if (prey.resHas())
/* 249 */                 prey.resRemove(); 
/* 250 */               WorkHunter.this.b.employment().sound().rnd(a);
/* 251 */               return (AI.SUBS()).WORK_HANDS.activate(a, d, 20.0D);
/*     */             } 
/* 253 */             WorkHunter.this.b.work(WorkHunter.work(a), (COORDINATE)d.planTile, a, false);
/* 254 */             return (AI.SUBS()).STAND.activateRndDir(a, d);
/*     */           } 
/*     */ 
/*     */           
/* 258 */           WorkHunter.this.b.workFinish((COORDINATE)d.planTile);
/* 259 */           return null;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 268 */           return (WorkHunter.work(a) != null && WorkHunter.work(a).blueprint() == WorkHunter.this.b);
/*     */         }
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {
/* 273 */           WorkHunter.this.b.workFinish((COORDINATE)d.planTile);
/*     */         }
/*     */         
/*     */         public AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 278 */           WorkHunter.this.b.reportSkill(WorkHunter.work(a), a);
/* 279 */           return (AI.SUBS()).STAND.activate(a, d);
/*     */         }
/*     */       };
/*     */     this.b = b;
/*     */   } final AIPLAN.PLANRES.Resumer hunt; final AIPLAN.PLANRES.Resumer drag; final AIPLAN.PLANRES.Resumer butcher; private ThingsCadavers.Cadaver getCadaver(Humanoid a, AIManager d) {
/* 284 */     return (ThingsCadavers.Cadaver)(SETT.THINGS()).cadavers.tGet.get((COORDINATE)d.planTile);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void name(Humanoid a, AIManager d, Str string) {
/* 289 */     string.add((this.b.employment()).verb);
/*     */   }
/*     */   
/*     */   public AISUB.AISubActivation init(Humanoid a, AIManager d) {
/*     */     RoomInstance in = work(a);
/*     */     if (!(SETT.PATH()).finders.entryPoints.anyHas(a.tc().x(), a.tc().y()))
/*     */       return null; 
/*     */     COORDINATE j = this.b.reserveWork(in, a);
/*     */     if (j == null) {
/*     */       GAME.Notify("Weird " + in.mX() + " " + in.mY());
/*     */       return null;
/*     */     } 
/*     */     d.planTile.set(j);
/*     */     if (getCadaver(a, d) != null) {
/*     */       AISUB.AISubActivation aISubActivation = this.walk.set(a, d);
/*     */       if (aISubActivation == null) {
/*     */         this.b.workFinish((COORDINATE)d.planTile);
/*     */       } else {
/*     */         return aISubActivation;
/*     */       } 
/*     */     } 
/*     */     if ((STATS.WORK()).WORK_TIME.indu().getD(a.indu()) < 0.5D) {
/*     */       AISUB.AISubActivation aISubActivation = this.leave.set(a, d);
/*     */       return aISubActivation;
/*     */     } 
/*     */     AISUB.AISubActivation s = this.walk.set(a, d);
/*     */     if (s == null)
/*     */       this.b.workFinish((COORDINATE)d.planTile); 
/*     */     return s;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\work\WorkHunter.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */