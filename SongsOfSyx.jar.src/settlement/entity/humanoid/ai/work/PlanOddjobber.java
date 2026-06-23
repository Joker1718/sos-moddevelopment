/*      */ package settlement.entity.humanoid.ai.work;
/*      */ 
/*      */ import game.GAME;
/*      */ import game.faction.FACTIONS;
/*      */ import game.faction.FResources;
/*      */ import init.resources.RBIT;
/*      */ import init.resources.RESOURCE;
/*      */ import init.resources.RESOURCES;
/*      */ import settlement.entity.humanoid.HPoll;
/*      */ import settlement.entity.humanoid.Humanoid;
/*      */ import settlement.entity.humanoid.ai.main.AI;
/*      */ import settlement.entity.humanoid.ai.main.AIManager;
/*      */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*      */ import settlement.entity.humanoid.ai.main.AISUB;
/*      */ import settlement.entity.humanoid.ai.util.AIPlanResourceMany;
/*      */ import settlement.job.BlockedJobs;
/*      */ import settlement.job.Job;
/*      */ import settlement.main.SETT;
/*      */ import settlement.misc.job.SETT_JOB;
/*      */ import settlement.misc.util.TILE_STORAGE;
/*      */ import settlement.room.main.Room;
/*      */ import settlement.room.main.RoomInstance;
/*      */ import settlement.stats.STATS;
/*      */ import settlement.thing.THINGS;
/*      */ import settlement.thing.ThingsResources;
/*      */ import snake2d.LOG;
/*      */ import snake2d.util.datatypes.COORDINATE;
/*      */ import snake2d.util.datatypes.DIR;
/*      */ import snake2d.util.misc.CLAMP;
/*      */ import snake2d.util.rnd.RND;
/*      */ import snake2d.util.sprite.text.Str;
/*      */ import util.text.D;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ final class PlanOddjobber
/*      */   extends PlanWork
/*      */ {
/*   41 */   private static CharSequence ¤¤bringing = "bringing resource to stockpile";
/*   42 */   private static CharSequence ¤¤working = "Doing an odd job";
/*   43 */   private static CharSequence ¤¤dumping = "Dumping Resource";
/*      */   
/*      */   static {
/*   46 */     D.ts(PlanOddjobber.class);
/*      */   }
/*      */   
/*   49 */   private final Multi clear = new Multi();
/*   50 */   private final Regular regular = new Regular();
/*   51 */   private final Crate crate = new Crate(this, ¤¤bringing);
/*   52 */   private final Blocked blocked = new Blocked();
/*      */   
/*   54 */   private final PlanOddHunt hunt = new PlanOddHunt(this);
/*      */   private static boolean full; private static int crateX; private static int crateY; private static Job sjob; private final AIPLAN.PLANRES.Resumer dumpResource; private final AIPLAN.PLANRES.Resumer removeres;
/*      */   
/*   57 */   PlanOddjobber(String key) { super("workOddjobber" + key);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  933 */     this.dumpResource = new AIPLAN.PLANRES.Resumer(this, ¤¤dumping)
/*      */       {
/*      */         public AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*      */         {
/*  937 */           if (d.resourceCarried() == null)
/*  938 */             throw new RuntimeException("" + d.resourceA()); 
/*  939 */           if ((SETT.PATH()).finders.resourceDump.isTile(a.tc().x(), a.tc().y())) {
/*  940 */             (SETT.THINGS()).resources.create(a.tc(), d.resourceCarried(), 1);
/*  941 */             d.resourceCarriedSet(null);
/*  942 */             return null;
/*      */           } 
/*      */           
/*  945 */           if ((SETT.PATH()).finders.resourceDump.find(a.physics.tileC(), d.path)) {
/*  946 */             return (AI.SUBS()).walkTo.path(a, d);
/*      */           }
/*  948 */           FACTIONS.player().res().inc(d.resourceCarried(), FResources.RTYPE.SPOILAGE, -d.resourceA());
/*      */           
/*  950 */           d.resourceCarriedSet(null);
/*  951 */           return null;
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*      */         public AISUB.AISubActivation res(Humanoid a, AIManager d) {
/*  957 */           (SETT.THINGS()).resources.createPrecise(a.physics.tileC().x(), a.physics.tileC().y(), d.resourceCarried(), d.resourceA());
/*  958 */           d.resourceCarriedSet(null);
/*  959 */           return null;
/*      */         }
/*      */ 
/*      */         
/*      */         public boolean con(Humanoid a, AIManager d) {
/*  964 */           return true;
/*      */         }
/*      */ 
/*      */         
/*      */         public void can(Humanoid a, AIManager d) {
/*  969 */           d.resourceDrop(a);
/*      */         }
/*      */       };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1005 */     this.removeres = new AIPLAN.PLANRES.Resumer(this, ¤¤dumping)
/*      */       {
/*      */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*      */         {
/* 1009 */           return null;
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*      */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 1015 */           d.resourceDrop(a);
/* 1016 */           RESOURCE res = (RESOURCE)RESOURCES.ALL().get(d.planByte1);
/* 1017 */           for (THINGS.Thing t : SETT.THINGS().get(d.planTile.x(), d.planTile.y())) {
/* 1018 */             if (t instanceof ThingsResources.ScatteredResource) {
/* 1019 */               ThingsResources.ScatteredResource sc = (ThingsResources.ScatteredResource)t;
/* 1020 */               if (sc.resource() == res) {
/* 1021 */                 while (sc.findableReservedIs() && d.planByte2 > 0) {
/* 1022 */                   sc.resourcePickup();
/* 1023 */                   d.resourceCarriedSet(res);
/* 1024 */                   d.planByte2 = (byte)(d.planByte2 - 1);
/*      */                 } 
/*      */               }
/*      */             } 
/*      */           } 
/*      */           
/* 1030 */           if (d.resourceCarried() == null) {
/* 1031 */             return null;
/*      */           }
/* 1033 */           return PlanOddjobber.this.dumpResource.set(a, d);
/*      */         }
/*      */ 
/*      */         
/*      */         public boolean con(Humanoid a, AIManager d) {
/* 1038 */           return true;
/*      */         }
/*      */ 
/*      */         
/*      */         public void can(Humanoid a, AIManager d) {
/* 1043 */           RESOURCE res = (RESOURCE)RESOURCES.ALL().get(d.planByte1);
/* 1044 */           for (THINGS.Thing t : SETT.THINGS().get(d.planTile.x(), d.planTile.y()))
/* 1045 */           { if (t instanceof ThingsResources.ScatteredResource)
/* 1046 */             { ThingsResources.ScatteredResource sc = (ThingsResources.ScatteredResource)t;
/* 1047 */               if (sc.resource() == res)
/* 1048 */                 while (sc.findableReservedIs() && d.planByte2 > 0)
/* 1049 */                 { sc.findableReserveCancel();
/* 1050 */                   d.planByte2 = (byte)(d.planByte2 - 1); }   }  }  } }; } public static boolean hasOddjob(Humanoid a, boolean full) { if ((SETT.PATH()).finders.job.hasJobs(a.tc().x(), a.tc().y(), full)) return true;  if ((SETT.PATH()).finders.prey.has(a.tc())) return true;  if ((SETT.JOBS()).blocked.next() != null) return true;  if (shouldStore(a) && (SETT.PATH()).finders.jobStore.has(a.tc().x(), a.tc().y())) return true;  return false; } private static boolean shouldStore(Humanoid a) { RoomInstance ins = (RoomInstance)(STATS.WORK()).EMPLOYED.get(a); if (ins != null && ins instanceof settlement.room.infra.logistics.MoveJob.ROOM_MOVEJOBBER) return false;  return true; } protected AIPLAN.AiPlanActivation activateOddjobber(Humanoid a, AIManager d) { full = true; sjob = ajacent(a, d); if (sjob == null && (!RND.oneIn(4) || (!(SETT.PATH()).finders.prey.has(a.tc()) && (SETT.JOBS()).blocked.next() == null))) sjob = (SETT.PATH()).finders.job.find(a.tc().x(), a.tc().y(), d.path, full);  crateX = a.tc().x(); crateY = a.tc().y(); return super.activate(a, d); } protected AIPLAN.AiPlanActivation activateHelpOut(Humanoid a, AIManager d) { int wx = work(a).mX(); int wy = work(a).mY(); crateX = wx; crateY = wy; full = false; d.path.clear(); if ((SETT.PATH()).connectivity.is(wx, wy)) { sjob = (SETT.PATH()).finders.job.find(wx, wy, null, full); return super.activate(a, d); }  for (DIR dir : DIR.ORTHO) { if ((SETT.PATH()).connectivity.is(wx, wy, dir)) { sjob = (SETT.PATH()).finders.job.find(wx + dir.x(), wy + dir.y(), null, full); return super.activate(a, d); }  }  GAME.Notify("" + work(a).mX() + " " + work(a).mX()); return null; } private Job ajacent(Humanoid a, AIManager d) { if (d.planTile.tileDistanceTo(a.tc()) == 1.0D) return ajacentJob(d.planTile.x(), d.planTile.y());  for (DIR dd : DIR.ORTHO) { Job j = ajacentJob(a.tc().x() + dd.x(), a.tc().y() + dd.y()); if (j != null) return j;  }  return null; } private Job ajacentJob(int tx, int ty) { Job j = (Job)(SETT.JOBS()).getter.get(tx, ty); if (j == null) return null;  if ((SETT.JOBS()).tool_activate.isPlacable(tx, ty, null, null) == null) return null;  if (!j.jobReserveCanBe() || j.jobResourceBitToFetch() != null) return null;  if (j == (SETT.JOBS()).clearss.food && !(SETT.WEATHER()).growthRipe.cropsAreRipe()) return null;  return j; } protected AIPLAN.AiPlanActivation activateWorker(Humanoid a, AIManager d, int sx, int sy, int radius) { full = true; crateX = sx; crateY = sy; sjob = (SETT.PATH()).finders.job.findOnlyJobForced(sx, sy, radius); return super.activate(a, d); } public AIPLAN.AiPlanActivation activate(Humanoid a, AIManager d) { throw new RuntimeException(); } protected AISUB.AISubActivation init(Humanoid a, AIManager d) { Job j = sjob; if (j != null) { d.planTile.set(j.jobCoo()); AISUB.AISubActivation s = clearDump(a, d, j); if (s != null) return s;  s = this.clear.init(a, d, j); if (s != null) return s;  j = (Job)(SETT.JOBS()).getter.get((COORDINATE)d.planTile); if (j != null && j.jobReserveCanBe()) { s = this.regular.init(a, d, j); if (s != null) return s;  }  }  if (full) { AISUB.AISubActivation s = this.blocked.init(a, d); if (s != null) return s;  s = this.hunt.init(a, d); if (s != null) return s;  }  if (shouldStore(a)) { TILE_STORAGE c = (SETT.PATH()).finders.jobStore.find(crateX, crateY); if (c != null) return this.crate.init(a, d, c);  }  return null; } private boolean isClearJob(Job j, Humanoid a) { if (j == null) return false;  if (j == (SETT.JOBS()).clearss.food && !(SETT.WEATHER()).growthRipe.cropsAreRipe()) return false;  if (j.jobPerformTime(a) == 0.0D && j.jobResourceBitToFetch() == null) return false;  return (j.res() != null && j.jobResourcesNeeded(a) > 0); } private final class Multi {
/*      */     protected AISUB.AISubActivation init(Humanoid a, AIManager d, Job j) { int i; if (!PlanOddjobber.this.isClearJob(j, a)) return null;  d.planTile.set(j.jobCoo()); RESOURCE res = (j.jobResourcesNeeded(a) > 0) ? j.res() : null; boolean needsNow = true; d.planByte1 = 0; int extraRes = 0; for (int di = 0; di < this.dirs.length; di++) { DIR dir = this.dirs[di]; j = (Job)(SETT.JOBS()).getter.get((COORDINATE)d.planTile, dir); if (PlanOddjobber.this.isClearJob(j, a) && j.jobReserveCanBe() && j.res() == res) { d.planByte1 = (byte)(d.planByte1 | 1 << di); extraRes += j.jobResourcesNeeded(a); i = needsNow & ((j.jobResourceBitToFetch() != null) ? 1 : 0); j.jobReserve((j.jobResourceBitToFetch() != null) ? j.res() : null); if (extraRes >= WorkAbs.maxCarry) break;  }  }  if (res != null) { AISUB.AISubActivation s = this.fetch.activate(a, d, res.bit, CLAMP.i(extraRes, 0, WorkAbs.maxCarry), (i != 0) ? Integer.MAX_VALUE : 120, true, true); if (s != null) return s;  }  d.planByte2 = (res == null) ? -1 : res.bIndex(); if (i != 0) { cancel(a, d, res); return null; }  cancelResourceJobs(a, d); d.planByte2 = -1; return this.walk2Job.set(a, d); } private final DIR[] dirs = new DIR[] { DIR.C, DIR.N, DIR.W, DIR.S, DIR.E, DIR.SW, DIR.SE }; private final AIPlanResourceMany fetch = new AIPlanResourceMany(PlanOddjobber.this, 32) { public AISUB.AISubActivation next(Humanoid a, AIManager d) { d.planByte2 = d.resourceCarried().bIndex(); return PlanOddjobber.Multi.this.walk2Job.set(a, d); } public void cancel(Humanoid a, AIManager d) { d.planByte2 = resource(a, d).bIndex(); PlanOddjobber.Multi.this.cancel(a, d, resource(a, d)); } }
/*      */     ; private RESOURCE resource(AIManager d) { return (d.planByte2 >= 0) ? (RESOURCE)RESOURCES.ALL().get(d.planByte2) : null; } private Job nextJob(Humanoid a, AIManager d) { if (d.planByte1 == 0) return null;  for (int di = 0; di < this.dirs.length; di++) { DIR dir = this.dirs[di]; if ((d.planByte1 & 1 << di) != 0) { Job j = (Job)(SETT.JOBS()).getter.get((COORDINATE)d.planTile, dir); if (canDoJob(a, d, j)) return j;  cancelJob(a, d, j, resource(d)); j = (Job)(SETT.JOBS()).getter.get((COORDINATE)d.planTile, dir); d.planByte1 = (byte)(d.planByte1 & (1 << di ^ 0xFFFFFFFF)); }  }  return null; } private Job cancelResourceJobs(Humanoid a, AIManager d) { if (d.planByte1 == 0) return null;  for (int di = 0; di < this.dirs.length; di++) { DIR dir = this.dirs[di]; if ((d.planByte1 & 1 << di) != 0) { Job j = (Job)(SETT.JOBS()).getter.get((COORDINATE)d.planTile, dir); if (j != null && j.jobResourceBitToFetch() != null) { cancelJob(a, d, j, resource(d)); d.planByte1 = (byte)(d.planByte1 & (1 << di ^ 0xFFFFFFFF)); }  }  }  return null; } private boolean canDoJob(Humanoid a, AIManager d, Job j) { if (j == null) return false;  if (PlanOddjobber.this.isClearJob(j, a)) { if (j.jobReservedIs(resource(d)) && d.resourceCarried() == resource(d)) return true;  if (j.jobReservedIs(null)) return true;  }  return false; } private void cancelJob(Humanoid a, AIManager d, Job j, RESOURCE res) { if (j == null) return;  if (j.jobReservedIs(res)) { j.jobReserveCancel(res); } else if (j.jobReservedIs(null)) { j.jobReserveCancel(null); } else { j.jobReserveCancel(null); }  } private void cancel(Humanoid a, AIManager d, RESOURCE res) { Job j = nextJob(a, d); while (j != null) { cancelJob(a, d, j, res); j = nextJob(a, d); }  d.resourceDrop(a); } private final AIPLAN.PLANRES.Resumer walk2Job = new AIPLAN.PLANRES.Resumer(PlanOddjobber.this, PlanOddjobber.¤¤working) { public AISUB.AISubActivation setAction(Humanoid a, AIManager d) { AISUB.AISubActivation s; Job j = PlanOddjobber.Multi.this.nextJob(a, d); if (j == null) { PlanOddjobber.Multi.this.cancel(a, d, PlanOddjobber.Multi.this.resource(d)); return null; }  int dx = j.jobCoo().x(); int dy = j.jobCoo().y(); if (d.path.isSuccessful() && d.path.destX() == dx && d.path.destY() == dy && a.physics.tileC().isSameAs((COORDINATE)d.path)) { s = (AI.SUBS()).walkTo.path(a, d); } else { s = (AI.SUBS()).walkTo.coo(a, d, dx, dy); }  if (s == null) { PlanOddjobber.Multi.this.cancel(a, d, PlanOddjobber.Multi.this.resource(d)); return null; }  return s; } public AISUB.AISubActivation res(Humanoid a, AIManager d) { Job j = (Job)(SETT.JOBS()).getter.get(d.path.destX(), d.path.destY()); if (!PlanOddjobber.Multi.this.canDoJob(a, d, j)) { PlanOddjobber.Multi.this.cancel(a, d, PlanOddjobber.Multi.this.resource(d)); return null; }  if (j.jobPerformTime(a) == 0.0D) { int am = CLAMP.i(d.resourceA(), 0, j.jobResourcesNeeded(a)); RESOURCE res = j.jobPerform(a, d.resourceCarried(), am); d.resourceAInc(-am); if (res != null) { PlanOddjobber.Multi.this.cancel(a, d, PlanOddjobber.Multi.this.resource(d)); d.resourceDrop(a); d.resourceCarriedSet(res); return (PlanOddjobber.Multi.access$0(PlanOddjobber.Multi.this)).dumpResource.set(a, d); }  j = (Job)(SETT.JOBS()).getter.get(d.path.destX(), d.path.destY()); if (PlanOddjobber.Multi.access$0(PlanOddjobber.Multi.this).isClearJob(j, a) && j.jobReserveCanBe()) if (j.jobResourceBitToFetch() == null) { j.jobReserve(null); } else if (d.resourceCarried() == PlanOddjobber.Multi.this.resource(d) && PlanOddjobber.Multi.this.resource(d) != null && j.jobResourceBitToFetch().has(d.resourceCarried())) { j.jobReserve(d.resourceCarried()); }   return setAction(a, d); }  AISUB.AISubActivation s = PlanOddjobber.Multi.this.work.set(a, d); return s; } public boolean con(Humanoid a, AIManager d) { Job j = (Job)(SETT.JOBS()).getter.get(d.path.destX(), d.path.destY()); return (j != null); } public void can(Humanoid a, AIManager d) { PlanOddjobber.Multi.this.cancel(a, d, PlanOddjobber.Multi.this.resource(d)); } public void name(Humanoid a, AIManager d, Str string) { SETT_JOB j = (SETT_JOB)(SETT.JOBS()).getter.get(d.path.destX(), d.path.destY()); if (j == null || j.jobName() == null) { super.name(a, d, string); } else { string.add(j.jobName()); }  } }
/*      */     ; private final AIPLAN.PLANRES.Resumer work = new AIPLAN.PLANRES.Resumer(PlanOddjobber.this, PlanOddjobber.¤¤working) { private SubWork.SubWorkTool sub = new SubWork.SubWorkTool("oddjobtool") { public SETT_JOB getJob(Humanoid a, AIManager d) { return (SETT_JOB)(SETT.JOBS()).getter.get(d.path.destX(), d.path.destY()); } }
/*      */         ; public AISUB.AISubActivation setAction(Humanoid a, AIManager d) { Job j = (Job)(SETT.JOBS()).getter.get(d.path.destX(), d.path.destY()); j.jobStartPerforming(); PlanOddjobber.Multi.access$0(PlanOddjobber.Multi.this).debug(a, d); return this.sub.activate(a, d, (SETT_JOB)j); } public AISUB.AISubActivation res(Humanoid a, AIManager d) { Job j = (Job)(SETT.JOBS()).getter.get(d.path.destX(), d.path.destY()); RESOURCE produced = null; if (j.jobReservedIs(null)) { produced = j.jobPerform(a, null, 0); } else if (j.jobReservedIs(d.resourceCarried())) { int am = CLAMP.i(d.resourceA(), 0, j.jobResourcesNeeded(a)); produced = j.jobPerform(a, d.resourceCarried(), am); d.resourceAInc(-am); } else { PlanOddjobber.Multi.this.cancel(a, d, PlanOddjobber.Multi.this.resource(d)); return null; }  j = (Job)(SETT.JOBS()).getter.get(d.path.destX(), d.path.destY()); if (PlanOddjobber.Multi.access$0(PlanOddjobber.Multi.this).isClearJob(j, a) && j.jobReserveCanBe()) if (j.jobResourceBitToFetch() == null) { j.jobReserve(null); } else if (d.resourceCarried() != null && j.jobResourceBitToFetch().has(d.resourceCarried())) { j.jobReserve(d.resourceCarried()); }   if (produced != null) (SETT.THINGS()).resources.create(a.physics.tileC(), produced, 1);  return PlanOddjobber.Multi.this.walk2Job.set(a, d); } public boolean con(Humanoid a, AIManager d) { return PlanOddjobber.Multi.this.walk2Job.con(a, d); } public void can(Humanoid a, AIManager d) { PlanOddjobber.Multi.this.cancel(a, d, PlanOddjobber.Multi.this.resource(d)); } public void name(Humanoid a, AIManager d, Str string) { SETT_JOB j = (SETT_JOB)(SETT.JOBS()).getter.get(d.path.destX(), d.path.destY()); if (j == null || j.jobName() == null) { super.name(a, d, string); } else { string.add(j.jobName()); }  } }
/*      */     ; } private final class Regular {
/*      */     protected AISUB.AISubActivation init(Humanoid a, AIManager d, Job j) { d.planTile.set(j.jobCoo()); d.planByte1 = -1; d.resourceDrop(a); if (j.jobResourceBitToFetch() != null) { AISUB.AISubActivation s = this.fetch.activate(a, d, j.jobResourceBitToFetch(), CLAMP.i(j.jobResourcesNeeded(a), 0, WorkAbs.maxCarry), 2147483647, true, true); if (s != null) { j = (Job)(SETT.JOBS()).getter.get((COORDINATE)d.planTile); j.jobReserve(this.fetch.resource(a, d)); return s; }  return null; }  Job oj = j; j = (Job)(SETT.JOBS()).getter.get((COORDINATE)d.planTile); if (j == null) GAME.Notify(String.valueOf(oj) + " " + String.valueOf(oj));  j.jobReserve(null); return this.walk2Job.set(a, d); } private RESOURCE resource(AIManager d) { return (d.planByte1 >= 0) ? (RESOURCE)RESOURCES.ALL().get(d.planByte1) : null; } private final AIPlanResourceMany fetch = new AIPlanResourceMany(PlanOddjobber.this, 32) { public AISUB.AISubActivation next(Humanoid a, AIManager d) { return PlanOddjobber.Regular.this.walk2Job.set(a, d); } public void cancel(Humanoid a, AIManager d) { d.planByte1 = resource(a, d).bIndex(); PlanOddjobber.Regular.this.cancel(a, d, resource(a, d)); } }
/*      */     ; private final AIPLAN.PLANRES.Resumer walk2Job = new AIPLAN.PLANRES.Resumer(PlanOddjobber.this, PlanOddjobber.¤¤working) { public AISUB.AISubActivation setAction(Humanoid a, AIManager d) { AISUB.AISubActivation s; Job j = (Job)(SETT.JOBS()).getter.get((COORDINATE)d.planTile); if (j == null) { PlanOddjobber.Regular.this.cancel(a, d, PlanOddjobber.Regular.this.resource(d)); return null; }  int dx = j.jobCoo().x(); int dy = j.jobCoo().y(); if (d.path.isSuccessful() && d.path.destX() == dx && d.path.destY() == dy && a.physics.tileC().isSameAs((COORDINATE)d.path)) { s = (AI.SUBS()).walkTo.path(a, d); } else { s = (AI.SUBS()).walkTo.coo(a, d, dx, dy); }  if (s == null) { PlanOddjobber.Regular.this.cancel(a, d, PlanOddjobber.Regular.this.resource(d)); return null; }  return s; } public AISUB.AISubActivation res(Humanoid a, AIManager d) { Job j = (Job)(SETT.JOBS()).getter.get((COORDINATE)d.planTile); if (PlanOddjobber.Regular.access$0(PlanOddjobber.Regular.this).isDumpJob(a, d, j)) { if (PlanOddjobber.Regular.access$0(PlanOddjobber.Regular.this).handleDumpJob(a, d, j)) return (PlanOddjobber.Regular.access$0(PlanOddjobber.Regular.this)).dumpResource.set(a, d);  return null; }  if (j.jobPerformTime(a) == 0.0D) { int am = CLAMP.i(d.resourceA(), 0, j.jobResourcesNeeded(a)); RESOURCE res = j.jobPerform(a, d.resourceCarried(), am); d.resourceAInc(-am); if (res != null) { d.resourceDrop(a); d.resourceCarriedSet(res); return (PlanOddjobber.Regular.access$0(PlanOddjobber.Regular.this)).dumpResource.set(a, d); }  return null; }  return PlanOddjobber.Regular.this.work.set(a, d); } public boolean con(Humanoid a, AIManager d) { Job j = (Job)(SETT.JOBS()).getter.get((COORDINATE)d.planTile); if (j == null) return false;  if (!j.jobReservedIs(PlanOddjobber.Regular.this.resource(d))) { if (j.jobReserveCanBe()) { if (j.jobResourceBitToFetch() == null) { j.jobReserve(null); d.resourceDrop(a); d.planByte1 = -1; return true; }  if (d.resourceCarried() != null && j.jobResourceBitToFetch().has(d.resourceCarried())) { d.planByte1 = d.resourceCarried().bIndex(); j.jobReserve(d.resourceCarried()); return true; }  }  return false; }  return true; } public void can(Humanoid a, AIManager d) { PlanOddjobber.Regular.this.cancel(a, d, PlanOddjobber.Regular.this.resource(d)); } public void name(Humanoid a, AIManager d, Str string) { SETT_JOB j = (SETT_JOB)(SETT.JOBS()).getter.get(d.path.destX(), d.path.destY()); if (j == null || j.jobName() == null) { super.name(a, d, string); } else { string.add(j.jobName()); }  } }
/*      */     ; private final AIPLAN.PLANRES.Resumer work = new AIPLAN.PLANRES.Resumer(PlanOddjobber.this, PlanOddjobber.¤¤working) { private SubWork.SubWorkTool sub = new SubWork.SubWorkTool("regularOddjobtool") { public SETT_JOB getJob(Humanoid a, AIManager d) { return (SETT_JOB)(SETT.JOBS()).getter.get((COORDINATE)d.planTile); } }
/*      */         ; public AISUB.AISubActivation setAction(Humanoid a, AIManager d) { SETT_JOB j = (SETT_JOB)(SETT.JOBS()).getter.get((COORDINATE)d.planTile); j.jobStartPerforming(); return this.sub.activate(a, d, j); } public AISUB.AISubActivation res(Humanoid a, AIManager d) { Job j = (Job)(SETT.JOBS()).getter.get((COORDINATE)d.planTile); RESOURCE produced = null; if (j.jobReservedIs(null)) { produced = j.jobPerform(a, null, 0); } else if (j.jobReservedIs(d.resourceCarried())) { int am = CLAMP.i(d.resourceA(), 0, j.jobResourcesNeeded(a)); produced = j.jobPerform(a, d.resourceCarried(), am); d.resourceAInc(-am); } else { PlanOddjobber.Regular.this.cancel(a, d, PlanOddjobber.Regular.this.resource(d)); return null; }  if (produced != null) (SETT.THINGS()).resources.create(a.physics.tileC(), produced, 1);  if ((AI.modules()).work.moduleCanContinue(a, d)) { j = (Job)(SETT.JOBS()).getter.get((COORDINATE)d.planTile); if (j != null && j.jobReserveCanBe()) { if (j.jobResourcesNeeded(a) == 0) { j.jobReserve(null); } else if (d.resourceCarried() != null && (d.resourceCarried()).bit.has(j.jobResourceBitToFetch())) { j.jobReserve(d.resourceCarried()); } else { return null; }  return PlanOddjobber.Regular.this.walk2Job.set(a, d); }  }  j = (Job)(SETT.JOBS()).getter.get((COORDINATE)d.planTile); if (j != null && j.jobReserveCanBe()) (SETT.ROOMS()).BUILDER.reset((RoomInstance)(STATS.WORK()).EMPLOYED.get(a));  return null; } public boolean con(Humanoid a, AIManager d) { return PlanOddjobber.Regular.this.walk2Job.con(a, d); } public void can(Humanoid a, AIManager d) { PlanOddjobber.Regular.this.cancel(a, d, PlanOddjobber.Regular.this.resource(d)); } public void name(Humanoid a, AIManager d, Str string) { SETT_JOB j = (SETT_JOB)(SETT.JOBS()).getter.get(d.path.destX(), d.path.destY()); if (j == null || j.jobName() == null) { super.name(a, d, string); } else { string.add(j.jobName()); }  } }
/*      */     ; private void cancel(Humanoid a, AIManager d, RESOURCE res) { Job j = (Job)(SETT.JOBS()).getter.get((COORDINATE)d.planTile); if (j != null) { if (j.jobReservedIs(res)) j.jobReserveCancel(res);  if (j.jobReservedIs(null)) j.jobReserveCancel(null);  }  d.resourceDrop(a); } } static final class Crate {
/*      */     private final AIPlanResourceMany fetch; private final AIPLAN.PLANRES.Resumer stockpileReturn; Crate(AIPLAN.PLANRES plan, CharSequence verb) { this.fetch = new AIPlanResourceMany(plan, 32) { public AISUB.AISubActivation next(Humanoid a, AIManager d) { return PlanOddjobber.Crate.this.stockpileReturn.set(a, d); } public void cancel(Humanoid a, AIManager d) { PlanOddjobber.Crate.this.stockpileReturn.can(a, d); } }
/* 1062 */         ; plan.getClass(); this.stockpileReturn = new AIPLAN.PLANRES.Resumer(plan, verb) { public AISUB.AISubActivation setAction(Humanoid a, AIManager d) { return (AI.SUBS()).walkTo.coo(a, d, (COORDINATE)d.planTile); } public AISUB.AISubActivation res(Humanoid a, AIManager d) { TILE_STORAGE c = (TILE_STORAGE)(SETT.PATH()).finders.storage.getter.get((COORDINATE)d.planTile); int am = CLAMP.i(d.resourceA(), 0, c.storageReserved()); c.storageDeposit(am); d.resourceAInc(-am); d.resourceDrop(a); int extra = PlanOddjobber.Crate.this.fetch.target(a, d) - am; extra = CLAMP.i(extra, 0, c.storageReserved()); if (extra > 0) c.storageUnreserve(extra);  return null; } public boolean con(Humanoid a, AIManager d) { TILE_STORAGE c = (TILE_STORAGE)(SETT.PATH()).finders.storage.getter.get((COORDINATE)d.planTile); if (c == null) return false;  if (c.storageReserved() <= 0 || c.resource() != PlanOddjobber.Crate.this.fetch.resource(a, d)) return false;  return true; } public void can(Humanoid a, AIManager d) { TILE_STORAGE c = (TILE_STORAGE)(SETT.PATH()).finders.storage.getter.get((COORDINATE)d.planTile); if (c != null && c.resource() == PlanOddjobber.Crate.this.fetch.resource(a, d)) { int am = CLAMP.i(PlanOddjobber.Crate.this.fetch.target(a, d), 0, c.storageReserved()); c.storageUnreserve(am); }  d.resourceDrop(a); } }; } protected AISUB.AISubActivation init(Humanoid a, AIManager d, TILE_STORAGE crate) { d.planTile.set((COORDINATE)crate); RESOURCE r = crate.resource(); int am = CLAMP.i(WorkAbs.maxCarry, 0, crate.storageReservable()); AISUB.AISubActivation sub = this.fetch.activate(a, d, r.bit, am, 2147483647, false, false); if (sub != null) { crate = ((Room)(SETT.ROOMS()).map.get((COORDINATE)d.planTile)).storage(d.planTile.x(), d.planTile.y()); crate.storageReserve(am); return sub; }  return null; } } private boolean isDumpJob(Humanoid a, AIManager d, Job j) { if (j == null) return false;  if (j.jobPerformTime(a) != 0.0D) return false;  if (j.jobResourceBitToFetch() != null) return false;  return true; } private boolean handleDumpJob(Humanoid a, AIManager d, Job j) { if (!isDumpJob(a, d, j)) return false;  d.resourceDrop(a); int deadSwitch = 0; while (d.resourceA() < WorkAbs.maxCarry && isDumpJob(a, d, j)) { deadSwitch++; if (deadSwitch > 100) { LOG.ln(); if (!j.jobReservedIs(null) && j.jobReserveCanBe()) { LOG.ln("reserving"); j.jobReserve(null); }  if (j.jobReservedIs(null)) { LOG.ln("reserved"); RESOURCE r = j.jobPerform(a, null, 0); LOG.ln(String.valueOf(r) + " " + String.valueOf(r) + " " + String.valueOf(j)); if (d.resourceCarried() == null) { d.resourceCarriedSet(r); } else { if (d.resourceCarried() != r) { (SETT.THINGS()).resources.create(j.jobCoo(), r, 1); return (d.resourceA() > 0); }  d.resourceAInc(1); }  } else { return (d.resourceA() > 0); }  j = (Job)(SETT.JOBS()).getter.get(j.jobCoo()); continue; }  if (!j.jobReservedIs(null) && j.jobReserveCanBe()) { j.jobReserve(null); j = (Job)(SETT.JOBS()).getter.get(j.jobCoo()); }  if (j.jobReservedIs(null)) { RESOURCE r = j.jobPerform(a, null, 0); if (d.resourceCarried() == null) { d.resourceCarriedSet(r); } else { if (d.resourceCarried() != r) { (SETT.THINGS()).resources.create(j.jobCoo(), r, 1); return (d.resourceA() > 0); }  d.resourceAInc(1); }  } else { return (d.resourceA() > 0); }  j = (Job)(SETT.JOBS()).getter.get(j.jobCoo()); }  return (d.resourceA() > 0); } private AISUB.AISubActivation clearDump(Humanoid a, AIManager d, Job j) { if (!j.becomesSolid()) return null;  int x = j.jobCoo().x(); int y = j.jobCoo().y(); ThingsResources.ScatteredResource r = (SETT.THINGS()).resources.getReservable(x, y, RBIT.ALL); if (r == null) return null;  AISUB.AISubActivation s = (AI.SUBS()).walkTo.coo(a, d, (COORDINATE)d.planTile); if (s == null) return null;  d.planTile.set(x, y); d.planByte1 = r.resource().bIndex(); d.planByte2 = 0; while (d.planByte2 < WorkAbs.maxCarry && r.reservable() > 0) { r.findableReserve(); d.planByte2 = (byte)(d.planByte2 + 1); }  this.removeres.set(a, d); return s; } private final class Blocked { protected AISUB.AISubActivation init(Humanoid a, AIManager d) { BlockedJobs.BlockedJob j = (SETT.JOBS()).blocked.next();
/* 1063 */       if (j == null) {
/* 1064 */         return null;
/*      */       }
/* 1066 */       d.planTile.xSet(j.ID);
/* 1067 */       d.planByte1 = -1;
/* 1068 */       d.resourceDrop(a);
/* 1069 */       if (j.jobResourceBitToFetch() != null) {
/* 1070 */         AISUB.AISubActivation s = this.fetch.activate(a, d, j.jobResourceBitToFetch(), CLAMP.i(j.jobResourcesNeeded(a), 0, WorkAbs.maxCarry), 2147483647, true, true);
/* 1071 */         if (s != null) {
/* 1072 */           j.jobReserve(this.fetch.resource(a, d));
/* 1073 */           return s;
/*      */         } 
/* 1075 */         return null;
/*      */       } 
/* 1077 */       j.jobReserve(null);
/* 1078 */       return this.walk2Job.set(a, d); }
/*      */ 
/*      */ 
/*      */     
/*      */     private RESOURCE resource(AIManager d) {
/* 1083 */       return (d.planByte1 >= 0) ? (RESOURCE)RESOURCES.ALL().get(d.planByte1) : null;
/*      */     }
/*      */     
/* 1086 */     private final AIPlanResourceMany fetch = new AIPlanResourceMany(PlanOddjobber.this, 32)
/*      */       {
/*      */         public AISUB.AISubActivation next(Humanoid a, AIManager d)
/*      */         {
/* 1090 */           d.planByte1 = resource(a, d).bIndex();
/* 1091 */           return PlanOddjobber.Blocked.this.walk2Job.set(a, d);
/*      */         }
/*      */ 
/*      */         
/*      */         public void cancel(Humanoid a, AIManager d) {
/* 1096 */           d.planByte1 = resource(a, d).bIndex();
/* 1097 */           PlanOddjobber.Blocked.this.cancel(a, d, resource(a, d));
/*      */         }
/*      */       };
/*      */     
/* 1101 */     private final AIPLAN.PLANRES.Resumer walk2Job = new AIPLAN.PLANRES.Resumer(PlanOddjobber.this, PlanOddjobber.¤¤working)
/*      */       {
/*      */         public AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*      */         {
/*      */           AISUB.AISubActivation s;
/* 1106 */           BlockedJobs.BlockedJob j = (SETT.JOBS()).blocked.getByRef(d.planTile.x());
/* 1107 */           if (j == null) {
/* 1108 */             PlanOddjobber.Blocked.this.cancel(a, d, PlanOddjobber.Blocked.this.resource(d));
/* 1109 */             return null;
/*      */           } 
/*      */           
/* 1112 */           int dx = j.jobCoo().x();
/* 1113 */           int dy = j.jobCoo().y();
/*      */           
/* 1115 */           if (d.path.isSuccessful() && d.path.destX() == dx && d.path.destY() == dy && 
/* 1116 */             a.physics.tileC().isSameAs((COORDINATE)d.path)) {
/* 1117 */             s = (AI.SUBS()).walkTo.path(a, d);
/*      */           } else {
/* 1119 */             s = (AI.SUBS()).walkTo.coo(a, d, dx, dy);
/*      */           } 
/*      */           
/* 1122 */           if (s == null) {
/* 1123 */             PlanOddjobber.Blocked.this.cancel(a, d, PlanOddjobber.Blocked.this.resource(d));
/* 1124 */             return null;
/*      */           } 
/* 1126 */           return s;
/*      */         }
/*      */ 
/*      */         
/*      */         public AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 1131 */           return PlanOddjobber.Blocked.this.work.set(a, d);
/*      */         }
/*      */ 
/*      */         
/*      */         public boolean con(Humanoid a, AIManager d) {
/* 1136 */           BlockedJobs.BlockedJob j = (SETT.JOBS()).blocked.getByRef(d.planTile.x());
/* 1137 */           if (j == null || !j.jobReservedIs(PlanOddjobber.Blocked.this.resource(d))) {
/* 1138 */             return false;
/*      */           }
/* 1140 */           return true;
/*      */         }
/*      */ 
/*      */         
/*      */         public void can(Humanoid a, AIManager d) {
/* 1145 */           PlanOddjobber.Blocked.this.cancel(a, d, PlanOddjobber.Blocked.this.resource(d));
/*      */         }
/*      */ 
/*      */         
/*      */         public void name(Humanoid a, AIManager d, Str string) {
/* 1150 */           BlockedJobs.BlockedJob blockedJob = (SETT.JOBS()).blocked.getByRef(d.planTile.x());
/* 1151 */           if (blockedJob == null || blockedJob.jobName() == null) {
/* 1152 */             super.name(a, d, string);
/*      */           } else {
/* 1154 */             string.add(blockedJob.jobName());
/*      */           } 
/*      */         }
/*      */       };
/*      */ 
/*      */ 
/*      */     
/* 1161 */     private final AIPLAN.PLANRES.Resumer work = new AIPLAN.PLANRES.Resumer(PlanOddjobber.this, PlanOddjobber.¤¤working)
/*      */       {
/* 1163 */         private SubWork.SubWorkTool sub = new SubWork.SubWorkTool("regularOddjobtool2")
/*      */           {
/*      */             public SETT_JOB getJob(Humanoid a, AIManager d)
/*      */             {
/* 1167 */               return (SETT_JOB)(SETT.JOBS()).blocked.getByRef(d.planTile.x());
/*      */             }
/*      */           };
/*      */ 
/*      */         
/*      */         public AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 1173 */           BlockedJobs.BlockedJob j = (SETT.JOBS()).blocked.getByRef(d.planTile.x());
/* 1174 */           if (j.jobPerformTime(a) <= 0.0D) {
/* 1175 */             return res(a, d);
/*      */           }
/* 1177 */           j.jobStartPerforming();
/* 1178 */           return this.sub.activate(a, d, (SETT_JOB)j);
/*      */         }
/*      */ 
/*      */         
/*      */         public AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 1183 */           BlockedJobs.BlockedJob j = (SETT.JOBS()).blocked.getByRef(d.planTile.x());
/* 1184 */           RESOURCE produced = null;
/* 1185 */           if (j.jobReservedIs(null)) {
/* 1186 */             produced = j.jobPerform(a, null, 0);
/* 1187 */           } else if (j.jobReservedIs(d.resourceCarried())) {
/* 1188 */             int am = CLAMP.i(d.resourceA(), 0, j.jobResourcesNeeded(a));
/* 1189 */             produced = j.jobPerform(a, d.resourceCarried(), am);
/* 1190 */             d.resourceAInc(-am);
/* 1191 */             d.resourceDrop(a);
/* 1192 */             d.planByte1 = -1;
/*      */           } else {
/* 1194 */             PlanOddjobber.Blocked.this.cancel(a, d, PlanOddjobber.Blocked.this.resource(d));
/* 1195 */             return null;
/*      */           } 
/* 1197 */           if (produced != null) {
/* 1198 */             (SETT.THINGS()).resources.create(a.physics.tileC(), produced, 1);
/*      */           }
/*      */           
/* 1201 */           if ((AI.modules()).work.moduleCanContinue(a, d)) {
/* 1202 */             j = (SETT.JOBS()).blocked.getByRef(d.planTile.x());
/* 1203 */             if (j != null && j.jobReserveCanBe()) {
/* 1204 */               if (j.jobResourcesNeeded(a) == 0) {
/* 1205 */                 j.jobReserve(null);
/* 1206 */               } else if (d.resourceCarried() != null && (d.resourceCarried()).bit.has(j.jobResourceBitToFetch())) {
/* 1207 */                 j.jobReserve(d.resourceCarried());
/*      */               } else {
/* 1209 */                 return null;
/* 1210 */               }  return PlanOddjobber.Blocked.this.walk2Job.set(a, d);
/*      */             } 
/*      */           } 
/*      */           
/* 1214 */           return null;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public boolean con(Humanoid a, AIManager d) {
/* 1221 */           return PlanOddjobber.Blocked.this.walk2Job.con(a, d);
/*      */         }
/*      */ 
/*      */         
/*      */         public void can(Humanoid a, AIManager d) {
/* 1226 */           PlanOddjobber.Blocked.this.cancel(a, d, PlanOddjobber.Blocked.this.resource(d));
/*      */         }
/*      */ 
/*      */         
/*      */         public void name(Humanoid a, AIManager d, Str string) {
/* 1231 */           SETT_JOB j = (SETT_JOB)(SETT.JOBS()).getter.get(d.path.destX(), d.path.destY());
/* 1232 */           if (j == null || j.jobName() == null) {
/* 1233 */             super.name(a, d, string);
/*      */           } else {
/* 1235 */             string.add(j.jobName());
/*      */           } 
/*      */         }
/*      */       };
/*      */     
/*      */     private void cancel(Humanoid a, AIManager d, RESOURCE res) {
/* 1241 */       BlockedJobs.BlockedJob j = (SETT.JOBS()).blocked.getByRef(d.planTile.x());
/* 1242 */       if (j != null) {
/* 1243 */         if (j.jobReservedIs(res))
/* 1244 */           j.jobReserveCancel(res); 
/* 1245 */         if (j.jobReservedIs(null)) {
/* 1246 */           j.jobReserveCancel(null);
/*      */         }
/*      */       } 
/* 1249 */       d.resourceDrop(a);
/*      */     } }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/* 1258 */     if (e.type == HPoll.WORKING) {
/* 1259 */       return 1.0D;
/*      */     }
/* 1261 */     return super.poll(a, d, e);
/*      */   }
/*      */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\work\PlanOddjobber.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */