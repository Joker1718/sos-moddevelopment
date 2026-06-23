/*     */ package world.region.building;
/*     */ 
/*     */ import game.boosting.BSourceInfo;
/*     */ import game.boosting.BoostSpec;
/*     */ import game.boosting.BoostSpecs;
/*     */ import game.boosting.Booster;
/*     */ import game.faction.FACTIONS;
/*     */ import init.paths.PATHS;
/*     */ import init.sprite.UI.Icon;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.tilemap.terrain.TFortification;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import snake2d.util.sets.Tree;
/*     */ import util.keymap.RMAP;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RBooster;
/*     */ import world.region.RD;
/*     */ import world.region.RDBoostCache;
/*     */ import world.region.pop.RDRace;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class RDBuildings
/*     */ {
/*     */   public final LIST<RDBuilding> all;
/*     */   public final LIST<RDBuilding> sorted;
/*     */   public final LIST<RDBuildingCat> cats;
/*     */   public final RDBoostCache levelRoad;
/*     */   public final RDBoostCache levelMine;
/*     */   public final RDBoostCache levelWall;
/*     */   private final RDLevelsTmp tmp;
/*  40 */   public final RDBuildPoints costs = new RDBuildPoints();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RDBuildings(RD.RDInit init) throws IOException {
/*  46 */     this.levelRoad = new RDBoostCache(init, "VISUAL_ROADS", "", "", null);
/*     */     
/*  48 */     this.levelMine = new RDBoostCache(init, "VISUAL_MINE", "", "", null);
/*  49 */     this.levelWall = new RDBoostCache(init, "VISUAL_WALL", "", "", null)
/*     */       {
/*     */         protected double pget(Region reg) {
/*  52 */           if (reg == FACTIONS.player().capitolRegion()) {
/*  53 */             double am = 0.0D;
/*  54 */             for (TFortification f : (SETT.TERRAIN()).FORTIFICATIONS.all()) {
/*  55 */               am += f.tile.count();
/*     */             }
/*  57 */             return CLAMP.d(am / SETT.TWIDTH * 4.0D, 0.0D, 1.0D);
/*     */           } 
/*  59 */           return super.pget(reg);
/*     */         }
/*     */       };
/*     */     
/*  63 */     PATHS.ResFolder f = PATHS.WORLD().folder("building");
/*     */     
/*  65 */     Tree<RDBuildingCat> sort = new Tree<RDBuildingCat>((f.init.folders()).length)
/*     */       {
/*     */         protected boolean isGreaterThan(RDBuildingCat current, RDBuildingCat cmp)
/*     */         {
/*  69 */           return (current.order > cmp.order);
/*     */         }
/*     */       };
/*     */     
/*  73 */     LinkedList<RDBuilding> all = new LinkedList();
/*     */     
/*  75 */     Creator creator = new Creator(this); byte b; int i; String[] arrayOfString;
/*  76 */     for (i = (arrayOfString = f.init.folders()).length, b = 0; b < i; ) { String k = arrayOfString[b];
/*  77 */       sort.add(new RDBuildingCat(creator, (LISTE<RDBuilding>)all, init, k, f.folder(k)));
/*     */       b++; }
/*     */     
/*  80 */     ArrayListGrower<RDBuildingCat> cats = new ArrayListGrower();
/*  81 */     while (sort.hasMore()) {
/*  82 */       cats.add(sort.pollSmallest());
/*     */     }
/*  84 */     this.cats = (LIST<RDBuildingCat>)cats;
/*     */     
/*  86 */     ArrayListGrower<RDBuilding> sorted = new ArrayListGrower();
/*     */     
/*  88 */     for (RDBuildingCat c : cats) {
/*  89 */       for (RDBuilding rDBuilding : c.all)
/*  90 */         sorted.add(rDBuilding); 
/*  91 */     }  this.sorted = (LIST<RDBuilding>)sorted;
/*     */ 
/*     */ 
/*     */     
/*  95 */     this.all = (LIST<RDBuilding>)new ArrayList((Iterable)all);
/*     */     
/*  97 */     this.tmp = new RDLevelsTmp(all.size());
/*     */     
/*  99 */     init.points = this.costs;
/*     */   }
/*     */   
/*     */   public void init(RD.RDInit init) {
/* 103 */     RMAP<RDBuilding> MAP = new RMAP("WORLD_BUILDING", this.all);
/*     */     
/* 105 */     for (RDRace rdrace : (RD.RACES()).all) {
/*     */       
/* 107 */       if ((rdrace.race.pref()).worldBuildingOverride == null) {
/*     */         continue;
/*     */       }
/* 110 */       Json json = (rdrace.race.pref()).worldBuildingOverride;
/* 111 */       (rdrace.race.pref()).worldBuildingOverride = null;
/*     */ 
/*     */       
/* 114 */       MAP.getClass();
/*     */     } 
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 166 */     for (RDBuilding b : this.all) {
/* 167 */       b.connect(init);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void update() {
/* 173 */     if (this.tmp.active > 0) {
/* 174 */       this.tmp.active--;
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean isTmp() {
/* 179 */     return (this.tmp.active > 0);
/*     */   }
/*     */   
/*     */   public RDLevelsTmp tmp(boolean init, Region reg) {
/* 183 */     this.costs.setDirty();
/* 184 */     this.tmp.active = 2;
/* 185 */     this.tmp.reg = reg;
/* 186 */     if (init)
/* 187 */       this.tmp.init(reg); 
/* 188 */     return this.tmp;
/*     */   }
/*     */   
/*     */   public RDLevelsTmp tmp() {
/* 192 */     return this.tmp;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\region\building\RDBuildings.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */