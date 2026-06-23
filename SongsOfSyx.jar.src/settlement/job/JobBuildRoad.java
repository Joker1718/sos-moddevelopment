/*     */ package settlement.job;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.audio.AUDIO;
/*     */ import game.audio.SoundRace;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.FResources;
/*     */ import game.faction.Faction;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.resources.RESOURCE;
/*     */ import init.sprite.SPRITES;
/*     */ import init.value.Lock;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.environment.SettEnvMap;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.stats.standing.STANDINGS;
/*     */ import settlement.tilemap.floor.Floors;
/*     */ import settlement.tilemap.terrain.Terrain;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.info.GFORMAT;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.PlacableMessages;
/*     */ import view.tool.PlacableMulti;
/*     */ import view.tool.ToolConfig;
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class JobBuildRoad
/*     */   extends JobBuild
/*     */ {
/*  48 */   private static CharSequence ¤¤Convert = "Convert";
/*  49 */   private static CharSequence ¤¤ConvertD = "Convert existing roads into this type.";
/*  50 */   private static CharSequence ¤¤durability = "Durability"; private final Floors.Floor floor; private final Placer placer;
/*     */   static {
/*  52 */     D.ts(JobBuildRoad.class);
/*     */   }
/*     */   
/*     */   public static final class JobBuildRoads
/*     */   {
/*     */     public final LIST<JobBuildRoad> all;
/*     */     private final JobComboPlacer pla;
/*     */     private boolean convert = false;
/*     */     
/*     */     JobBuildRoads() {
/*  62 */       ArrayList<JobBuildRoad> all = new ArrayList((SETT.FLOOR()).roads.size());
/*  63 */       for (Floors.Floor f : (SETT.FLOOR()).roads) {
/*  64 */         all.add(new JobBuildRoad(f));
/*     */       }
/*  66 */       this.all = (LIST<JobBuildRoad>)all;
/*  67 */       this.pla = new JobComboPlacer((LIST)this.all, "ROAD_TYPE");
/*     */     }
/*     */     
/*     */     public Job getPlacable() {
/*  71 */       return this.pla.current();
/*     */     }
/*     */   }
/*     */   private boolean showRoads = true; private final SoundRace sound; public PlacableMulti placer() { return this.placer; } void renderAbove(SPRITE_RENDERER r, int x, int y, int mask, int tx, int ty) { for (DIR d : DIR.ORTHO) {
/*     */       if ((SETT.FLOOR()).getter.is(tx, ty, d) || (SETT.JOBS()).getter.get(tx, ty, d) == this)
/*     */         mask |= d.mask(); 
/*     */     }  (SPRITES.cons()).BIG.dashed.render(r, mask, x, y); } protected CharSequence problem(int tx, int ty, boolean overwrite) { if ((SETT.JOBS()).roads.convert) {
/*     */       if ((SETT.FLOOR()).getter.get(tx, ty) == this.floor)
/*     */         return PLACABLE.E;  if ((SETT.FLOOR()).getter.get(tx, ty) == null)
/*     */         return PLACABLE.E; 
/*     */     }  if ((SETT.ROOMS()).map.is(tx, ty))
/*     */       return PlacableMessages.¤¤ROOM_BLOCK;  if ((SETT.FLOOR()).getter.get(tx, ty) == this.floor)
/*     */       return PlacableMessages.¤¤ROAD_ALREADY;  if (!overwrite && (SETT.JOBS()).getter.is(tx, ty))
/*     */       return PlacableMessages.¤¤JOB_BLOCK; 
/*     */     if ((SETT.TERRAIN()).WATER.BRIDGE.is(tx, ty) || (SETT.TERRAIN()).WATER.DEEP.is(tx, ty))
/*     */       return lockText(); 
/*     */     if ((SETT.PATH()).solidity.is(tx, ty))
/*     */       return PlacableMessages.¤¤BLOCKED; 
/*     */     if (!SETT.TERRAIN().get(tx, ty).roofIs() && !SETT.TERRAIN().get(tx, ty).clearing().can())
/*     */       return PlacableMessages.¤¤BLOCKED; 
/*     */     if ((SETT.FLOOR()).getter.get(tx, ty) == this.floor)
/*     */       return PlacableMessages.¤¤ROAD_ALREADY; 
/*  93 */     return lockText(); } private JobBuildRoad(final Floors.Floor floor) { super("ROAD_" + floor.key, floor.resource, floor.resAmount, false, floor.name, floor.desc, (SPRITE)floor.getIcon());
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
/* 296 */     this.sound = AUDIO.race("BUILD_ROAD"); this.floor = floor; final LinkedList<CLICKABLE> bs = new LinkedList(); bs.add(new GButt.Panel((SPRITE)(SPRITES.icons()).m.cog) { protected void clickA() { JobBuildRoad.this.showRoads = !JobBuildRoad.this.showRoads; } protected void renAction() { selectedSet(JobBuildRoad.this.showRoads); if (JobBuildRoad.this.showRoads) (SETT.OVERLAY()).ROADING.add();  } public void hoverInfoGet(GUI_BOX text) { text.title((SETT.OVERLAY()).ROADING.name); text.text((SETT.OVERLAY()).ROADING.desc); } }
/*     */       ); bs.add(new GButt.Panel((SPRITE)(SPRITES.icons()).m.arrow_right) { protected void clickA() { (SETT.JOBS()).roads.convert = !(SETT.JOBS()).roads.convert; } protected void renAction() { selectedSet((SETT.JOBS()).roads.convert); } public void hoverInfoGet(GUI_BOX text) { text.title(JobBuildRoad.¤¤Convert); text.text(JobBuildRoad.¤¤ConvertD); } }
/*     */       ); this.placer = new Placer(this, floor.resource, floor.resAmount, floor.desc) {
/*     */         public void hoverDesc(GBox box) { super.hoverDesc(box); box.NL(4); box.textL(((STANDINGS.CITIZEN()).fullfillment.info()).name); box.NL(); int ta = 0; for (Race race : RACES.all()) { box.add((race.appearance()).icon.medium); box.add((SPRITE)GFORMAT.perc(box.text(), floor.pref(race))); box.space(); if (ta++ > 4) { box.NL(); ta = 0; }  }  box.NL(8); box.textL(Dic.¤¤Speed); box.tab(5); box.add((SPRITE)GFORMAT.percInc(box.text(), floor.speed.movementSpeed - AVAILABILITY.NORMAL.movementSpeed)); box.NL(); for (SettEnvMap.SettEnv e : (SETT.ENV()).map.all()) { if (floor.envValue(e) != 0.0D) { box.textL(e.info.name); box.tab(5); box.add((SPRITE)GFORMAT.perc(box.text(), floor.envValue(e))); box.NL(); }  }  box.NL(); box.textL(JobBuildRoad.¤¤durability); box.tab(5); box.add((SPRITE)GFORMAT.perc(box.text(), floor.durability)); } public LIST<CLICKABLE> getAdditionalButt() { return (LIST<CLICKABLE>)bs; }
/* 300 */       }; } protected SoundRace constructSound() { return this.sound; } public static CharSequence problem(int tx, int ty) { if ((SETT.ROOMS()).map.is(tx, ty)) return PlacableMessages.¤¤ROOM_BLOCK;  if ((SETT.FLOOR()).getter.get(tx, ty) != null) return PlacableMessages.¤¤ROAD_ALREADY;  if ((SETT.PATH()).solidity.is(tx, ty)) return PlacableMessages.¤¤BLOCKED;  if (!SETT.TERRAIN().get(tx, ty).roofIs() && !SETT.TERRAIN().get(tx, ty).clearing().can()) return PlacableMessages.¤¤BLOCKED;  return null; }
/*     */   public CharSequence lockText() { Str.TMP.clear().add(Dic.¤¤Requires); Str.TMP.NL(); boolean has = false; for (Lock<Faction> i : (Iterable<Lock<Faction>>)this.floor.reqs.all()) { if (!i.unlocker.inUnlocked(FACTIONS.player())) { Str.TMP.NL(); has = true; Str.TMP.add(i.unlocker.name); }  }  if (has) return (CharSequence)Str.TMP;  return null; }
/*     */   boolean terrainNeedsClear(int tx, int ty) { if (SETT.TERRAIN().get(tx, ty).roofIs())
/*     */       return false;  return super.terrainNeedsClear(tx, ty); }
/*     */   protected double constructionTime(Humanoid skill) { return 25.0D; }
/* 305 */   protected void renderBelow(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator i, int state) { if (!(SETT.FLOOR()).getter.is(i.tile())) {
/* 306 */       super.renderBelow(r, shadowBatch, i, state);
/*     */     } }
/*     */ 
/*     */   
/*     */   public void doSomethingExtraRender() {
/* 311 */     if (this.showRoads) {
/* 312 */       (SETT.OVERLAY()).ROADING.add();
/*     */     }
/*     */   }
/*     */   
/*     */   protected boolean construct(int tx, int ty) {
/* 317 */     if ((SETT.FLOOR()).getter.get(tx, ty) != this.floor) {
/* 318 */       if (this.floor.resource != null)
/* 319 */         GAME.player().res().inc(this.floor.resource, FResources.RTYPE.CONSTRUCTION, -this.floor.resAmount); 
/* 320 */       this.floor.placeFixed(tx, ty);
/* 321 */       (SETT.FLOOR()).degrade.set(tx, ty, 0.0D);
/*     */     } else {
/* 323 */       (SETT.FLOOR()).degrade.set(tx, ty, (SETT.FLOOR()).degrade.get(tx, ty) - 0.25D);
/* 324 */     }  return ((SETT.FLOOR()).degrade.get(tx, ty) != 0.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isConstruction() {
/* 329 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public Terrain.TerrainTile becomes(int tx, int ty) {
/* 334 */     return (SETT.TERRAIN()).NADA;
/*     */   }
/*     */ 
/*     */   
/*     */   public ToolConfig config() {
/* 339 */     return (SETT.JOBS()).roads.pla.get(this);
/*     */   }
/*     */   
/*     */   public static Job getPlacable() {
/* 343 */     return (SETT.JOBS()).roads.pla.current();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\job\JobBuildRoad.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */