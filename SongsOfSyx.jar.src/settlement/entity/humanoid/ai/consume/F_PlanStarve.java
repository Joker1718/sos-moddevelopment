/*     */ package settlement.entity.humanoid.ai.consume;
/*     */ 
/*     */ import init.type.CAUSE_LEAVES;
/*     */ import init.type.NEEDS;
/*     */ import settlement.entity.animal.ANIMAL_ROOM_RUINER;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIData;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.finders.SFinderMisc;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.thing.THINGS;
/*     */ import settlement.thing.ThingsCorpses;
/*     */ import settlement.tilemap.terrain.TGrowable;
/*     */ import util.text.D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class F_PlanStarve
/*     */   extends AIPLAN.PLANRES
/*     */ {
/*     */   private final AISUB sub;
/*     */   private final AIData.AIDataSuspender suspender;
/*  29 */   private static CharSequence ¤¤cannibal = "Eating a corpse";
/*  30 */   private static CharSequence ¤¤starving = "Starving";
/*  31 */   private static CharSequence ¤¤eating = "Eating Dirt"; public final SFinderMisc.FinderMiscWithoutDest edible; public final SFinderMisc.FinderMiscWithoutDest corpses; private final AIPLAN.PLANRES.Resumer goEatCorpse;
/*     */   
/*     */   static {
/*  34 */     D.ts(F_PlanStarve.class);
/*     */   }
/*     */   private final AIPLAN.PLANRES.Resumer eatCorpse; private final AIPLAN.PLANRES.Resumer goEatTerrain; private final AIPLAN.PLANRES.Resumer eatTerrain; private final AIPLAN.PLANRES.Resumer actCrazy;
/*     */   
/*     */   public F_PlanStarve(AISUB sub, AIData.AIDataSuspender suspender) {
/*  39 */     super("dangerStarve");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  46 */     this.edible = new SFinderMisc.FinderMiscWithoutDest(32)
/*     */       {
/*     */         protected boolean has()
/*     */         {
/*  50 */           return (SETT.WEATHER()).growthRipe.cropsAreRipe();
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean isTile(int tx, int ty) {
/*  55 */           Room r = (SETT.ROOMS()).map.get(tx, ty);
/*  56 */           if (r != null && r instanceof ANIMAL_ROOM_RUINER) {
/*  57 */             return ((ANIMAL_ROOM_RUINER)r).canBeGraced(tx, ty);
/*     */           }
/*  59 */           return (SETT.TERRAIN().get(tx, ty) instanceof TGrowable && ((TGrowable)SETT.TERRAIN().get(tx, ty)).isEdible(tx, ty) && ((TGrowable)SETT.TERRAIN().get(tx, ty)).size.get(tx, ty) > 0);
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
/*  73 */     this.corpses = new SFinderMisc.FinderMiscWithoutDest(32)
/*     */       {
/*     */         protected boolean has()
/*     */         {
/*  77 */           return true;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean isTile(int tx, int ty) {
/*  82 */           return (F_PlanStarve.this.corpse(tx, ty) != null);
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
/*     */ 
/*     */ 
/*     */     
/* 108 */     this.goEatCorpse = new AIPLAN.PLANRES.Resumer(this, ¤¤cannibal)
/*     */       {
/*     */         public AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 112 */           return (AI.SUBS()).walkTo.pathRun(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 117 */           return F_PlanStarve.this.eatCorpse.set(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 122 */           return (F_PlanStarve.this.corpse(d.path.destX(), d.path.destY()) != null);
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/* 131 */     this.eatCorpse = new AIPLAN.PLANRES.Resumer(this, ¤¤cannibal)
/*     */       {
/*     */         public AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 135 */           return F_PlanStarve.this.sub.activate(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 140 */           ThingsCorpses.Corpse c = F_PlanStarve.this.corpse(d.path.destX(), d.path.destY());
/* 141 */           if (c != null) {
/* 142 */             (SETT.ROOMS()).CANNIBAL.reportCannibal(c.race());
/* 143 */             c.removeMeat();
/* 144 */             STATS.FOOD().eat(a, 0, 0.0D);
/* 145 */             (NEEDS.TYPES()).HUNGER.stat().fix(a.indu());
/* 146 */             return null;
/*     */           } 
/*     */           
/* 149 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 154 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/* 163 */     this.goEatTerrain = new AIPLAN.PLANRES.Resumer(this, ¤¤eating)
/*     */       {
/*     */         public AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 167 */           return (AI.SUBS()).walkTo.pathRun(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 172 */           return F_PlanStarve.this.eatTerrain.set(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 177 */           return F_PlanStarve.this.edible.isTile(d.path.destX(), d.path.destY());
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/* 186 */     this.eatTerrain = new AIPLAN.PLANRES.Resumer(this, ¤¤eating)
/*     */       {
/*     */         
/*     */         public AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 191 */           return F_PlanStarve.this.sub.activate(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 196 */           if (F_PlanStarve.this.edible.isTile(d.path.destX(), d.path.destY())) {
/* 197 */             STATS.FOOD().eat(a, 0, 0.0D);
/* 198 */             (NEEDS.TYPES()).HUNGER.stat().fix(a.indu());
/* 199 */             SETT.TERRAIN().get(d.path.destX(), d.path.destY()).clearing().clear1(d.path.destX(), d.path.destY());
/* 200 */             Room r = (SETT.ROOMS()).map.get(d.path.destX(), d.path.destY());
/* 201 */             if (r != null && r.destroyTileCan(d.path.destX(), d.path.destY())) {
/* 202 */               r.destroyTile(d.path.destX(), d.path.destY());
/*     */             }
/* 204 */             return null;
/*     */           } 
/*     */           
/* 207 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 212 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/* 221 */     this.actCrazy = new AIPLAN.PLANRES.Resumer(this, ¤¤starving)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 225 */           return (AI.SUBS()).desperate.activate(a, d);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 231 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 236 */           return true;
/*     */         }
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/*     */     this.sub = sub;
/*     */     this.suspender = suspender;
/*     */   }
/*     */   
/*     */   private ThingsCorpses.Corpse corpse(int tx, int ty) {
/*     */     for (THINGS.Thing t : SETT.THINGS().get(tx, ty)) {
/*     */       if (t instanceof ThingsCorpses.Corpse) {
/*     */         ThingsCorpses.Corpse c = (ThingsCorpses.Corpse)t;
/*     */         if (c.hasMeat())
/*     */           return c; 
/*     */       } 
/*     */     } 
/*     */     return null;
/*     */   }
/*     */   
/*     */   protected AISUB.AISubActivation init(Humanoid a, AIManager d) {
/*     */     if ((NEEDS.TYPES()).HUNGER.stat().stat().indu().isMax(a.indu()))
/*     */       AIManager.dead = CAUSE_LEAVES.STARVED(); 
/*     */     if (!this.suspender.is(d)) {
/*     */       if (this.edible.find(a.physics.tileC(), d.path))
/*     */         return this.goEatTerrain.set(a, d); 
/*     */       if (this.corpses.find(a.physics.tileC(), d.path))
/*     */         return this.goEatCorpse.set(a, d); 
/*     */       this.suspender.suspend(d);
/*     */     } 
/*     */     return this.actCrazy.set(a, d);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\consume\F_PlanStarve.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */