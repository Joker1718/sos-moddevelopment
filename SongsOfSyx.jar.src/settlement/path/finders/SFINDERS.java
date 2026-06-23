/*     */ package settlement.path.finders;
/*     */ 
/*     */ import game.battle.Army;
/*     */ import init.settings.S;
/*     */ import java.io.IOException;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.util.FINDABLE;
/*     */ import settlement.path.thread.SFinderRequest;
/*     */ import settlement.thing.THINGS;
/*     */ import settlement.thing.ThingFindable;
/*     */ import settlement.thing.ThingsCorpses;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import util.GUTIL;
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
/*     */ public class SFINDERS
/*     */ {
/*  29 */   public final SFinderResources resource = new SFinderResources();
/*  30 */   public final SFinderResourceStorage storage = new SFinderResourceStorage();
/*  31 */   public final SFinderWater water = new SFinderWater();
/*  32 */   public final SFinderUnreachable reachable = new SFinderUnreachable();
/*  33 */   public final SFinderIndoors indoor = new SFinderIndoors();
/*  34 */   public final SFinderJob job = new SFinderJob();
/*  35 */   public final SFinderEntry entryPoints = new SFinderEntry();
/*  36 */   public final SFinderRND randomDistanceAway = new SFinderRND();
/*  37 */   public final SFinderMisc.FinderArround arround = new SFinderMisc.FinderArround();
/*  38 */   public final SFinderResourceStore jobStore = new SFinderResourceStore();
/*  39 */   public final SFinderPrey prey = new SFinderPrey();
/*  40 */   public final SFinderHumanoid otherHumanoid = new SFinderHumanoid();
/*  41 */   public final SFinderEntity entity = new SFinderEntity();
/*  42 */   public final SFinderMisc.Rnd rndCoo = new SFinderMisc.Rnd();
/*  43 */   public final SFinderHumanTarget target = new SFinderHumanTarget();
/*  44 */   public final SFinderHome home = new SFinderHome();
/*  45 */   public final SFinderMaintenance maintenance = new SFinderMaintenance();
/*     */   private SPathFinder finder;
/*  47 */   private final SFindersUpdater uper = new SFindersUpdater();
/*     */   
/*  49 */   private final SFinderSoldierManning[] soldierManning = new SFinderSoldierManning[] {
/*  50 */       new SFinderSoldierManning(true), 
/*  51 */       new SFinderSoldierManning(false)
/*     */     };
/*     */   
/*     */   public final SFinderMisc resourceDump;
/*     */   public SAVABLE saver;
/*     */   public final SFinderRequest.FinderIdle getOutofWay;
/*     */   public final SFinderFindable.FinderThing<ThingsCorpses.Corpse> corpses;
/*     */   
/*     */   public SPathFinder finder() {
/*  60 */     if (this.finder == null)
/*  61 */       this.finder = new SPathFinder((SETT.PATH()).comps, GUTIL.pathTools(), 2); 
/*  62 */     return this.finder;
/*     */   }
/*     */   
/*     */   public SFINDERS() {
/*  66 */     this.resourceDump = new SFinderMisc(25)
/*     */       {
/*     */         public boolean isTile(int tx, int ty) {
/*  69 */           if ((SETT.ROOMS()).map.is(tx, ty))
/*  70 */             return false; 
/*  71 */           if ((SETT.JOBS()).getter.is(tx, ty))
/*  72 */             return false; 
/*  73 */           return true;
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  83 */     this.saver = new SAVABLE()
/*     */       {
/*     */         public void save(FilePutter file)
/*     */         {
/*  87 */           SFINDERS.this.uper.saver.save(file);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void load(FileGetter file) throws IOException {
/*  93 */           SFINDERS.this.uper.saver.load(file);
/*     */         }
/*     */ 
/*     */         
/*     */         public void clear() {
/*  98 */           SFINDERS.this.uper.saver.clear();
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 107 */     this.getOutofWay = new SFinderRequest.FinderIdle();
/*     */     
/* 109 */     this.corpses = new SFinderFindable.FinderThing<ThingsCorpses.Corpse>("corpse")
/*     */       {
/*     */         public ThingsCorpses.Corpse getReservable(int tx, int ty)
/*     */         {
/* 113 */           for (THINGS.Thing t : SETT.THINGS().get(tx, ty)) {
/* 114 */             if (t instanceof ThingsCorpses.Corpse) {
/* 115 */               ThingsCorpses.Corpse c = (ThingsCorpses.Corpse)t;
/* 116 */               if (c.findableReservedCanBe())
/* 117 */                 return c; 
/*     */             } 
/* 119 */           }  return null;
/*     */         }
/*     */         
/*     */         public ThingsCorpses.Corpse getReserved(int tx, int ty)
/*     */         {
/* 124 */           for (THINGS.Thing t : SETT.THINGS().get(tx, ty)) {
/* 125 */             if (t instanceof ThingsCorpses.Corpse) {
/* 126 */               ThingsCorpses.Corpse c = (ThingsCorpses.Corpse)t;
/* 127 */               if (c.findableReservedIs())
/* 128 */                 return c; 
/*     */             } 
/* 130 */           }  return null;
/*     */         }
/*     */       };
/*     */     if ((S.get()).developer);
/*     */   }
/*     */   
/*     */   public boolean isGoodTileToStandOn(int tx, int ty, ENTITY e) {
/* 137 */     if (((SETT.PATH()).availability.get(tx, ty)).player <= 0.0D)
/* 138 */       return false; 
/* 139 */     if (((SETT.PATH()).availability.get(tx, ty)).player >= 2.0D)
/* 140 */       return false; 
/* 141 */     if ((SETT.JOBS()).getter.is(tx, ty))
/* 142 */       return false; 
/* 143 */     if (SETT.THINGS().getFirst(tx, ty) != null)
/* 144 */       return false; 
/* 145 */     if (SETT.ENTITIES().hasAtTile(e, tx, ty))
/* 146 */       return false; 
/* 147 */     if ((SETT.PATH()).huristics.getter.get(tx, ty) > 0.2D)
/* 148 */       return false; 
/* 149 */     return true;
/*     */   }
/*     */   
/*     */   public void update(double ds) {
/*     */     this.jobStore.update(ds);
/*     */     this.job.update(ds);
/*     */     this.uper.update(ds);
/*     */   }
/*     */   
/*     */   public SFinderSoldierManning manning(Army a) {
/*     */     return this.soldierManning[a.index()];
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\finders\SFINDERS.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */