/*     */ package world.region;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.GameDisposable;
/*     */ import game.debug.Profiler;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import init.race.Race;
/*     */ import init.sprite.UI.UI;
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.data.DataO;
/*     */ import util.text.D;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.ToolManager;
/*     */ import view.world.panel.IDebugPanelWorld;
/*     */ import world.WORLD;
/*     */ import world.map.regions.Region;
/*     */ import world.map.regions.WREGIONS;
/*     */ import world.region.building.RDBuildPoints;
/*     */ import world.region.building.RDBuilding;
/*     */ import world.region.building.RDBuildingLevel;
/*     */ import world.region.building.RDBuildings;
/*     */ import world.region.pop.RDRace;
/*     */ import world.region.pop.RDRaces;
/*     */ import world.region.updating.RDUpdater;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RD
/*     */   extends WORLD.WorldResource
/*     */ {
/*     */   public static RD self;
/*     */   private final RDBuildings buildings;
/*     */   private final RDOutputs resources;
/*     */   private final RDRandom random;
/*     */   private final RDRaces races;
/*     */   private final RDMilitary military;
/*     */   private final RDHealth health;
/*     */   private final RDDistance distance;
/*     */   private final RDReligions religion;
/*     */   private final RDOwner owner;
/*     */   private final RDDevastation deva;
/*     */   private final RDEvent event;
/*     */   private final RDProspects prospects;
/*     */   private final RDProblem problem;
/*     */   private RDUpdater updater;
/*     */   private final long[][] regionData;
/*     */   private final long[][] factionData;
/*  65 */   private final int[] factionI = Alloc.ii(1023);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  70 */   final Realm[] drea = new Realm[FACTIONS.MAX()];
/*  71 */   private final RDInit init = new RDInit();
/*     */   
/*  73 */   private static CharSequence ¤¤regChange = "{0} changes master from {1} to {2}."; private final WORLD.WorldResourceManager saver;
/*     */   
/*     */   static {
/*  76 */     D.ts(RD.class);
/*     */   }
/*     */   
/*     */   public RD(WREGIONS regions) throws IOException {
/*  80 */     super("region Data", "RD");
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
/* 155 */     this.saver = new WORLD.WorldResourceManager()
/*     */       {
/*     */         
/*     */         public void save(FilePutter file)
/*     */         {
/* 160 */           RD.this.init.count.saver().save(WORLD.REGIONS().all(), file);
/* 161 */           RD.this.init.rCount.saver().save(FACTIONS.all(), file);
/*     */           
/* 163 */           file.isE(RD.this.factionI); byte b; int i;
/*     */           Realm[] arrayOfRealm;
/* 165 */           for (i = (arrayOfRealm = RD.this.drea).length, b = 0; b < i; ) { Realm r = arrayOfRealm[b];
/* 166 */             r.saver.save(file); b++; }
/*     */           
/* 168 */           for (SAVABLE s : RD.this.init.savable) {
/* 169 */             s.save(file);
/*     */           }
/* 171 */           RD.this.updater.saver.save(file);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void load(FileGetter file) throws IOException {
/* 177 */           RD.this.init.count.loader().load(WORLD.REGIONS().all(), file);
/* 178 */           RD.this.init.rCount.loader().load(FACTIONS.all(), file);
/*     */           
/* 180 */           file.isE(RD.this.factionI); byte b; int i;
/*     */           Realm[] arrayOfRealm;
/* 182 */           for (i = (arrayOfRealm = RD.this.drea).length, b = 0; b < i; ) { Realm r = arrayOfRealm[b];
/* 183 */             r.saver.load(file);
/*     */             b++; }
/*     */           
/* 186 */           for (SAVABLE s : RD.this.init.savable) {
/* 187 */             s.load(file);
/*     */           }
/* 189 */           RD.this.updater.saver.load(file);
/* 190 */           (RD.BUILDINGS()).costs.setDirty();
/*     */         } public void clear() {
/*     */           byte b;
/*     */           int i;
/*     */           long[][] arrayOfLong;
/* 195 */           for (i = (arrayOfLong = RD.this.regionData).length, b = 0; b < i; ) { long[] r = arrayOfLong[b];
/* 196 */             Arrays.fill(r, 0L); b++; }
/*     */           
/* 198 */           for (i = (arrayOfLong = RD.this.factionData).length, b = 0; b < i; ) { long[] r = arrayOfLong[b];
/* 199 */             Arrays.fill(r, 0L); b++; }
/*     */           
/*     */           Realm[] arrayOfRealm;
/* 202 */           for (i = (arrayOfRealm = RD.this.drea).length, b = 0; b < i; ) { Realm r = arrayOfRealm[b];
/* 203 */             r.saver.clear();
/*     */             b++; }
/*     */           
/* 206 */           Arrays.fill(RD.this.factionI, -1);
/*     */           
/* 208 */           for (SAVABLE s : RD.this.init.savable)
/* 209 */             s.clear(); 
/* 210 */           RD.this.updater.saver.clear();
/* 211 */           WORLD.MINIMAP().repaint();
/*     */         }
/*     */ 
/*     */         
/*     */         public LIST<PLACABLE> makePlacers(ToolManager tm) {
/* 216 */           return (LIST<PLACABLE>)new Placers();
/*     */         }
/*     */ 
/*     */         
/*     */         public void generate(ACTION loadPrint) {
/* 221 */           clear();
/*     */ 
/*     */ 
/*     */           
/* 225 */           loadPrint.exe();
/* 226 */           RD.this.prime();
/* 227 */           loadPrint.exe(); } public void exe() { RD.this.buildings.init(RD.this.init); RD.this.updater = new RDUpdater(RD.this.init); RD.this.races.init(); } }); IDebugPanelWorld.add("INIT_REGIONS", new ACTION() {
/*     */         public void exe() { for (Region r : WORLD.REGIONS().active()) { for (int i = 0; i < 2; i++) { RD.UPDATER().BUILD(r); for (RD.RDUpdatable up : RD.this.init.upers)
/*     */                 up.init(r);  }  }
/*     */            }
/*     */       }; self = this; this.distance = new RDDistance(this.init); this.random = new RDRandom(this.init); this.health = new RDHealth(this.init); this.resources = new RDOutputs(this.init); this.military = new RDMilitary(this.init); this.races = new RDRaces(this.init); this.religion = new RDReligions(this.init); this.buildings = new RDBuildings(this.init); this.owner = new RDOwner(this.init); this.deva = new RDDevastation(this.init); this.event = new RDEvent(this.init); this.prospects = new RDProspects(this.init); this.problem = new RDProblem(); Arrays.fill(this.factionI, -1); this.regionData = new long[1023][this.init.count.longCount()]; this.factionData = new long[FACTIONS.MAX()][this.init.rCount.longCount()]; for (int i = 0; i < this.drea.length; i++)
/* 232 */       this.drea[i] = new Realm(i);  GAME.addOnInit(new ACTION() { public void validateInit(WORLD.WorldError error) { if (!(WORLD.REGIONS()).player.active()) {
/* 233 */               error.problem = "Player region is missing";
/* 234 */               error.coo.set(-1.0D, -1.0D);
/*     */               
/*     */               return;
/*     */             } 
/* 238 */             (WORLD.REGIONS()).player.fationSet((Faction)FACTIONS.player(), false);
/* 239 */             (WORLD.REGIONS()).player.setCapitol();
/* 240 */             (WORLD.REGIONS()).player.info.name().clear().add((CharSequence)(FACTIONS.player()).name);
/*     */             
/* 242 */             if (FACTIONS.NPCs().size() == 0)
/* 243 */               error.warning = "No factions have been set";  }
/*     */         });
/*     */     IDebugPanelWorld.add("RD CHECK POP", new ACTION() { public void exe() { double[] cas = new double[(RD.RACES()).all.size()];
/*     */             for (Region r : WORLD.REGIONS().active()) {
/*     */               for (RDRace ra : (RD.RACES()).all)
/*     */                 cas[ra.index()] = cas[ra.index()] + ra.pop.biome.get(r) * ra.pop.maxPopulation; 
/*     */             } 
/*     */             for (RDRace ra : (RD.RACES()).all)
/* 251 */               System.out.println(ra.race.key + " " + ra.race.key);  } }); } public void prime() { for (Region r : WORLD.REGIONS().active()) {
/* 252 */       this.random.randomize(r);
/* 253 */       for (int i = 0; i < 3; i++) {
/* 254 */         UPDATER().BUILD(r);
/* 255 */         for (RDUpdatable up : this.init.upers) {
/* 256 */           up.init(r);
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 262 */     for (FactionNPC ff : FACTIONS.NPCs()) {
/* 263 */       if (ff.realm().capitol() == null)
/*     */         continue; 
/* 265 */       RDRace race = null;
/* 266 */       double br = 0.0D;
/*     */       
/* 268 */       Region r = ff.capitolRegion();
/*     */       
/* 270 */       for (RDRace rrr : (RACES()).all) {
/* 271 */         if (rrr.pop.get(r) >= br) {
/* 272 */           br = rrr.pop.get(r);
/* 273 */           race = rrr;
/*     */         } 
/*     */       } 
/*     */       
/* 277 */       boolean sa = ff.sanctified;
/* 278 */       ff.generate(race, true);
/* 279 */       ff.sanctified = sa;
/*     */     } 
/*     */     
/* 282 */     for (Region r : WORLD.REGIONS().active()) {
/* 283 */       this.random.randomize(r);
/* 284 */       for (int i = 0; i < 2; i++) {
/* 285 */         UPDATER().BUILD(r);
/* 286 */         for (RDUpdatable up : this.init.upers) {
/* 287 */           up.init(r);
/*     */         }
/*     */       } 
/*     */     }  }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public WORLD.WorldResourceManager saver() {
/* 296 */     return this.saver;
/*     */   }
/*     */ 
/*     */   
/*     */   public void update(double ds, Profiler prof) {
/* 301 */     prof.logStart(this);
/*     */     
/* 303 */     this.updater.update(ds);
/* 304 */     prof.logEnd(this);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void afterTick() {
/* 309 */     this.buildings.update();
/*     */   }
/*     */   public final class RDInit { public final DataO<Region> count; public final DataO<Faction> rCount; public final LinkedList<RD.RDUpdatable> upers; public final LinkedList<SAVABLE> savable; public RDBuildPoints points;
/*     */     
/*     */     public RDInit() {
/* 314 */       this.count = new DataO<Region>("RDR")
/*     */         {
/*     */           protected long[] data(Region t)
/*     */           {
/* 318 */             return (RD.RDInit.access$0(RD.RDInit.this)).regionData[t.index()];
/*     */           }
/*     */         };
/*     */ 
/*     */       
/* 323 */       this.rCount = new DataO<Faction>("RDF")
/*     */         {
/*     */           protected long[] data(Faction t)
/*     */           {
/* 327 */             return (RD.RDInit.access$0(RD.RDInit.this)).factionData[t.index()];
/*     */           }
/*     */         };
/*     */ 
/*     */       
/* 332 */       this.upers = new LinkedList();
/*     */       
/* 334 */       this.savable = new LinkedList();
/*     */     } }
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
/*     */   public static RDBuildings BUILDINGS() {
/* 352 */     return self.buildings;
/*     */   }
/*     */   
/*     */   public static RDOutputs OUTPUT() {
/* 356 */     return self.resources;
/*     */   }
/*     */   
/*     */   public static RDRandom RAN() {
/* 360 */     return self.random;
/*     */   }
/*     */   
/*     */   public static RDRaces RACES() {
/* 364 */     return self.races;
/*     */   }
/*     */   
/*     */   public static RDMilitary MILITARY() {
/* 368 */     return self.military;
/*     */   }
/*     */ 
/*     */   
/*     */   public static RDHealth HEALTH() {
/* 373 */     return self.health;
/*     */   }
/*     */   
/*     */   public static RDDistance DIST() {
/* 377 */     return self.distance;
/*     */   }
/*     */   
/*     */   public static RDReligions RELIGION() {
/* 381 */     return self.religion;
/*     */   }
/*     */   
/*     */   public static RDOwner OWNER() {
/* 385 */     return self.owner;
/*     */   }
/*     */   
/*     */   public static RDUpdater UPDATER() {
/* 389 */     return self.updater;
/*     */   }
/*     */   
/*     */   public static RDDevastation DEVASTATION() {
/* 393 */     return self.deva;
/*     */   }
/*     */   
/*     */   public static RDProspects PROSPECT() {
/* 397 */     return self.prospects;
/*     */   }
/*     */   
/*     */   public static RDProblem PROBLEM() {
/* 401 */     return self.problem;
/*     */   }
/*     */ 
/*     */   
/*     */   public static RDEvent event() {
/* 406 */     return self.event;
/*     */   }
/*     */   
/*     */   public static Realm REALM(Region reg) {
/* 410 */     if (self.factionI[reg.index()] != -1)
/* 411 */       return self.drea[self.factionI[reg.index()]]; 
/* 412 */     return null;
/*     */   }
/*     */   
/*     */   public static Realm REALM(Faction f) {
/* 416 */     return self.drea[f.index()];
/*     */   }
/*     */ 
/*     */   
/*     */   private static void removeFaction(Region region) {
/* 421 */     Realm rr = REALM(region);
/*     */     
/* 423 */     if (rr == null) {
/*     */       return;
/*     */     }
/* 426 */     self.factionI[region.index()] = -1;
/*     */     
/* 428 */     rr.regions.removeShort((short)region.index());
/* 429 */     if (rr.capitolI == region.index()) {
/* 430 */       if (rr.regions.size() > 0) {
/* 431 */         rr.capitolI = (short)rr.regions.get(rr.regions.size() - 1);
/*     */       } else {
/* 433 */         rr.capitolI = -1;
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static void setFaction(Region region, Faction f, boolean log) {
/* 440 */     Realm oldRealm = REALM(region);
/*     */     
/* 442 */     if (f != null && REALM(f) == oldRealm) {
/*     */       return;
/*     */     }
/* 445 */     (OWNER()).ownerI.set(region, ((OWNER()).ownerI.get(region) + 1) % (OWNER()).ownerI.max(region));
/*     */     
/* 447 */     Faction fold = region.faction();
/*     */     
/* 449 */     removeFaction(region);
/*     */     
/* 451 */     if (f != null) {
/* 452 */       Realm rr = f.realm();
/* 453 */       if (rr.regions.hasRoom()) {
/* 454 */         self.factionI[region.index()] = f.index();
/*     */         
/* 456 */         rr.regions.add((short)region.index());
/*     */         
/* 458 */         if (rr.capitolI == -1) {
/* 459 */           rr.capitolI = (short)region.index();
/*     */         }
/*     */       } 
/* 462 */       (f.realm()).ferArea = 0.0D;
/* 463 */       for (int ri = 0; ri < f.realm().regions(); ri++) {
/* 464 */         Region r = (Region)WORLD.REGIONS().all().get(ri);
/* 465 */         (f.realm()).ferArea += r.info.area() * r.info.moisture();
/*     */       } 
/*     */     } 
/*     */     
/* 469 */     if (fold != null) {
/* 470 */       (fold.realm()).ferArea = 0.0D;
/* 471 */       for (int ri = 0; ri < fold.realm().regions(); ri++) {
/* 472 */         Region r = (Region)WORLD.REGIONS().all().get(ri);
/* 473 */         (fold.realm()).ferArea += r.info.area() * r.info.moisture();
/*     */       } 
/*     */     } 
/*     */     
/* 477 */     WORLD.MINIMAP().updateRegion(region);
/*     */ 
/*     */     
/* 480 */     RDOwnerChanger.changeI++;
/* 481 */     for (RDOwnerChanger ch : RDOwnerChanger.ownerChanges) {
/* 482 */       ch.change(region, fold, f);
/*     */     }
/*     */     
/* 485 */     Str.TMP.clear().add(¤¤regChange);
/* 486 */     Str.TMP.insert(0, (CharSequence)region.info.name());
/* 487 */     Str.TMP.insert(1, FACTIONS.name(fold));
/* 488 */     Str.TMP.insert(2, FACTIONS.name(f));
/* 489 */     WORLD.LOG().log(fold, f, (UI.icons()).s.crown, (CharSequence)Str.TMP, region.cx(), region.cy());
/*     */     
/* 491 */     if (f == FACTIONS.player()) {
/* 492 */       for (RDBuilding bu : (BUILDINGS()).all) {
/* 493 */         if (bu.level.get(region) > 0 && !((RDBuildingLevel)bu.levels.get(bu.level.get(region))).reqs.passes(region)) {
/* 494 */           bu.level.set(region, 0);
/*     */         }
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static void clearFaction(FactionNPC faction) {
/* 502 */     while (faction.realm().regions() > 0)
/* 503 */       setFaction(faction.realm().region(0), null, false); 
/*     */   }
/*     */   
/*     */   public static void setCapitol(Region region) {
/* 507 */     Realm rr = REALM(region);
/* 508 */     if (rr == null) {
/* 509 */       throw new RuntimeException("Can't set a rebel region as a capitol");
/*     */     }
/* 511 */     Region old = region.faction().capitolRegion();
/*     */     
/* 513 */     rr.capitolI = (short)region.index();
/*     */     
/* 515 */     for (RDOwnerChanger ch : RDOwnerChanger.ownerChanges) {
/* 516 */       ch.change(region, region.faction(), region.faction());
/*     */     }
/*     */     
/* 519 */     rr.regions.swap(0, rr.regions.indexOf((short)region.index()));
/* 520 */     WORLD.MINIMAP().updateRegion(region);
/* 521 */     if (old != null)
/* 522 */       WORLD.MINIMAP().updateRegion(old); 
/*     */   }
/*     */   
/*     */   public static RDRace RACE(Race r) {
/* 526 */     return RACES().get(r);
/*     */   }
/*     */   
/*     */   public static abstract class RDOwnerChanger
/*     */   {
/*     */     public static int changeI;
/* 532 */     static final ArrayListGrower<RDOwnerChanger> ownerChanges = new ArrayListGrower();
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
/*     */     public RDOwnerChanger() {
/* 545 */       ownerChanges.add(this);
/*     */     }
/*     */     
/*     */     public abstract void change(Region param1Region, Faction param1Faction1, Faction param1Faction2);
/*     */   }
/*     */   
/*     */   public static interface RDGeneratable {
/*     */     void generate(Region param1Region);
/*     */   }
/*     */   
/*     */   public static interface RDUpdatable {
/*     */     void update(Region param1Region, double param1Double);
/*     */     
/*     */     void init(Region param1Region);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\region\RD.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */