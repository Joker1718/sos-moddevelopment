/*     */ package settlement.main;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.debug.Profiler;
/*     */ import game.faction.FResources;
/*     */ import game.time.TIME;
/*     */ import game.time.TIMECYCLE;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import init.type.HCLASS_RACE;
/*     */ import java.io.IOException;
/*     */ import settlement.misc.util.RESOURCE_TILE;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.thing.THINGS;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import util.updating.TileUpdater;
/*     */ import view.sett.IDebugPanelSett;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.PLACER_TYPE;
/*     */ import view.tool.PlacableMulti;
/*     */ 
/*     */ 
/*     */ 
/*     */ class TUpdater
/*     */   extends SETT.SettResource
/*     */ {
/*  32 */   private final double[] counts = new double[RESOURCES.ALL().size()];
/*  33 */   private final double degradePerYear = 1.0D / TIME.years().bitConversion((TIMECYCLE)TIME.days());
/*     */   
/*  35 */   private final TileUpdater updater = new TileUpdater(SETT.TWIDTH, SETT.THEIGHT, TIME.secondsPerDay())
/*     */     {
/*     */       protected void update(int tx, int ty, int i, double timeSinceLast)
/*     */       {
/*  39 */         TUpdater.this.update(tx, ty, i);
/*     */       }
/*     */     };
/*     */   
/*     */   TUpdater() {
/*  44 */     super("TUPDATER", true);
/*  45 */     IDebugPanelSett.add(
/*  46 */         (PLACABLE)new PlacableMulti("update sett tile")
/*     */         {
/*     */           public void place(int tx, int ty, AREA area, PLACER_TYPE type)
/*     */           {
/*  50 */             TUpdater.this.update(tx, ty, tx + ty * SETT.TWIDTH);
/*     */           }
/*     */ 
/*     */           
/*     */           public CharSequence isPlacable(int tx, int ty, AREA area, PLACER_TYPE type) {
/*  55 */             return null;
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void update(int tx, int ty, int now) {
/*  63 */     SETT.TILE_MAP().updateTileDay(tx, ty, now);
/*  64 */     SETT.MAINTENANCE().updateTileDay(tx, ty, now);
/*  65 */     degrade(tx, ty, now);
/*     */   }
/*     */ 
/*     */   
/*     */   private void degrade(int tx, int ty, int now) {
/*  70 */     double base = this.degradePerYear;
/*     */ 
/*     */     
/*  73 */     double bonus = CLAMP.d(1.0D / (BOOSTABLES.CIVICS()).SPOILAGE.get((BOOSTABLE_O)HCLASS_RACE.clP(null, null)), 0.0D, 10.0D);
/*     */     
/*  75 */     for (THINGS.Thing t : SETT.THINGS().get(tx, ty)) {
/*  76 */       double b = base;
/*  77 */       if (SETT.TERRAIN().get(now).roofIs())
/*  78 */         b *= 0.75D; 
/*  79 */       if (t instanceof settlement.thing.ThingsResources.ScatteredResource) {
/*  80 */         degrade((RESOURCE_TILE)t, b * 2.0D);
/*     */       }
/*     */     } 
/*     */     
/*  84 */     Room r = (SETT.ROOMS()).map.get(tx, ty);
/*     */     
/*  86 */     if (r != null) {
/*  87 */       r.updateTileDay(tx, ty);
/*     */       
/*  89 */       RESOURCE_TILE t = r.resourceTile(tx, ty);
/*     */       
/*  91 */       if (t != null)
/*  92 */         degrade(t, bonus * base * t.spoilRate() * 0.75D); 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void degrade(RESOURCE_TILE t, double value) {
/*  97 */     int r = t.reservable();
/*  98 */     if (r == 0)
/*     */       return; 
/* 100 */     if (t.resource().degradeSpeed() == 0.0D) {
/*     */       return;
/*     */     }
/* 103 */     value *= t.resource().degradeSpeed();
/* 104 */     if (value == 0.0D) {
/*     */       return;
/*     */     }
/* 107 */     RESOURCE res = t.resource();
/*     */     
/* 109 */     this.counts[res.bIndex()] = this.counts[res.bIndex()] + value * t.reservable();
/* 110 */     int am = (int)this.counts[res.bIndex()];
/* 111 */     this.counts[res.bIndex()] = this.counts[res.bIndex()] - am;
/*     */ 
/*     */     
/* 114 */     int dec = 0;
/* 115 */     while (am > 0) {
/* 116 */       t.findableReserve();
/* 117 */       t.resourcePickup();
/* 118 */       dec++;
/* 119 */       am--;
/*     */     } 
/* 121 */     if (dec > 0) {
/* 122 */       GAME.player().res().inc(t.resource(), FResources.RTYPE.SPOILAGE, -dec);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void update(double ds, Profiler profiler) {
/* 129 */     this.updater.updateRandom(ds);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void save(FilePutter file) {
/* 134 */     this.updater.save(file);
/* 135 */     file.ds(this.counts);
/* 136 */     super.save(file);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void load(FileGetter file) throws IOException {
/* 141 */     this.updater.load(file);
/* 142 */     file.ds(this.counts);
/* 143 */     super.load(file);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clear() {
/* 148 */     this.updater.clear();
/* 149 */     for (int i = 0; i < this.counts.length; i++)
/* 150 */       this.counts[i] = 0.0D; 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\main\TUpdater.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */