/*     */ package settlement.main;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.GameDisposable;
/*     */ import game.audio.AUDIO;
/*     */ import game.audio.Ambiance;
/*     */ import game.battle.div.Div;
/*     */ import game.debug.Profiler;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.time.TIME;
/*     */ import init.constant.C;
/*     */ import init.constant.Config;
/*     */ import init.settings.S;
/*     */ import init.sprite.SPRITES;
/*     */ import java.io.IOException;
/*     */ import settlement.battle.SBattle;
/*     */ import settlement.battle.invasion.Invador;
/*     */ import settlement.entity.ENTETIES;
/*     */ import settlement.entity.animal.Animals;
/*     */ import settlement.entity.humanoid.Humanoids;
/*     */ import settlement.entry.SENTRY;
/*     */ import settlement.environment.ENVIRONMENT;
/*     */ import settlement.job.JOBS;
/*     */ import settlement.maintenance.MAINTENANCE;
/*     */ import settlement.misc.ParticleRenderer;
/*     */ import settlement.misc.SettPlacability;
/*     */ import settlement.misc.placers.ComplexPlacers;
/*     */ import settlement.overlay.SettOverlay;
/*     */ import settlement.path.AvailabilityListener;
/*     */ import settlement.path.PATHING;
/*     */ import settlement.recipe.Recipes;
/*     */ import settlement.room.main.ROOMS;
/*     */ import settlement.room.main.throne.THRONE;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.standing.STANDINGS;
/*     */ import settlement.thing.THINGS;
/*     */ import settlement.thing.halfEntity.HalfEnts;
/*     */ import settlement.thing.pointlight.POINTLIGHTS;
/*     */ import settlement.thing.projectiles.SProjectiles;
/*     */ import settlement.tilemap.TileMap;
/*     */ import settlement.tilemap.floor.Floors;
/*     */ import settlement.tilemap.floor.Grass;
/*     */ import settlement.tilemap.ground.Ground;
/*     */ import settlement.tilemap.ground.Minables;
/*     */ import settlement.tilemap.terrain.Terrain;
/*     */ import settlement.trade.SettTrade;
/*     */ import settlement.weather.SWEATHER;
/*     */ import snake2d.CORE;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.RGB;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SuperSaver;
/*     */ import snake2d.util.light.AmbientLight;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import util.rendering.Minimap;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import view.main.VIEW;
/*     */ import view.sett.IDebugPanelSett;
/*     */ import view.sett.ui.minimap.UIMinimapSettConfig;
/*     */ import view.subview.GameWindow;
/*     */ 
/*     */ public final class SETT
/*     */   extends GAME.GameResource
/*     */ {
/*  80 */   public static final int TWIDTH = (Config.sett()).DIMENSION;
/*  81 */   public static final int THEIGHT = TWIDTH;
/*  82 */   public static final int PWIDTH = TWIDTH * 64;
/*  83 */   public static final int PHEIGHT = THEIGHT * 64;
/*  84 */   public static final int TAREA = TWIDTH * THEIGHT;
/*  85 */   public static final RECTANGLE TILE_BOUNDS = (RECTANGLE)new Rec(0.0D, TWIDTH, 0.0D, THEIGHT);
/*  86 */   public static final RECTANGLE TILE_BOUNDS_I = (RECTANGLE)new Rec(1.0D, (TWIDTH - 1), 1.0D, (THEIGHT - 1));
/*  87 */   public static final RECTANGLE PIXEL_BOUNDS = (RECTANGLE)new Rec(0.0D, (TWIDTH * 64), 0.0D, (THEIGHT * 64));
/*  88 */   public static final SettlementGrid GRID = new SettlementGrid(); private static SETT i; private final SettMaps maps; private final SettPlacability placability; private final ParticleRenderer particles; private final ENVIRONMENT env; private final TileMap terrain; private final Animals animals; private final ROOMS rooms; private final JOBS jobs; private final SBattle battle; private final SENTRY entry; private boolean exists; private final ShadowBatch.Real shadowBatch; private final ShadowBatch shadowDummy; private final RenderData renData; private final CapitolArea worldArea;
/*     */   private final ENTETIES eHandler;
/*     */   
/*     */   public static boolean IN_BOUNDS(int tx, int ty) {
/*  92 */     return TILE_BOUNDS.holdsPoint(tx, ty);
/*     */   }
/*     */   private final THINGS things; private final SProjectiles projectiles; private final Humanoids creatures; private final MAINTENANCE maintenance; private final POINTLIGHTS lights; private final ComplexPlacers complexPlacers; private final HalfEnts halfEnts; private final PATHING path; private final Invador invador; private final Minimap minimap; private final SWEATHER weather; private final SettTrade trade; private final Recipes rescipes; private final SettOverlay details; private final SuperSaver<SettResource> saver; private final Rec tmpWin; private final ArrayList<ACTION> gHooks;
/*     */   public static boolean IN_BOUNDS(COORDINATE c) {
/*  96 */     return TILE_BOUNDS.holdsPoint(c.x(), c.y());
/*     */   }
/*     */   
/*     */   public static boolean IN_BOUNDS(COORDINATE c, DIR d) {
/* 100 */     return TILE_BOUNDS.holdsPoint((c.x() + d.x()), (c.y() + d.y()));
/*     */   }
/*     */   
/*     */   public static boolean IN_BOUNDS(int tx, int ty, DIR d) {
/* 104 */     return IN_BOUNDS(tx + d.x(), ty + d.y());
/*     */   }
/*     */   
/*     */   public static boolean PIXEL_IN_BOUNDS(int x, int y) {
/* 108 */     return PIXEL_BOUNDS.holdsPoint(x, y);
/*     */   }
/*     */   
/*     */   public static ENTETIES ENTITIES() {
/* 112 */     return i.eHandler;
/*     */   }
/*     */   
/*     */   public static Terrain TERRAIN() {
/* 116 */     return i.terrain.topology;
/*     */   }
/*     */   
/*     */   public static TileMap TILE_MAP() {
/* 120 */     return i.terrain;
/*     */   }
/*     */   
/*     */   public static Ground GROUND() {
/* 124 */     return i.terrain.ground;
/*     */   }
/*     */   
/*     */   public static Floors FLOOR() {
/* 128 */     return i.terrain.floors;
/*     */   }
/*     */   
/*     */   public static Grass GRASS() {
/* 132 */     return i.terrain.grass;
/*     */   }
/*     */   
/*     */   public static PATHING PATH() {
/* 136 */     return i.path;
/*     */   }
/*     */   
/*     */   public static JOBS JOBS() {
/* 140 */     return i.jobs;
/*     */   }
/*     */   
/*     */   public static THINGS THINGS() {
/* 144 */     return i.things;
/*     */   }
/*     */   
/*     */   public static ROOMS ROOMS() {
/* 148 */     return i.rooms;
/*     */   }
/*     */   
/*     */   public static CapitolArea WORLD_AREA() {
/* 152 */     return i.worldArea;
/*     */   }
/*     */   
/*     */   public static Animals ANIMALS() {
/* 156 */     return i.animals;
/*     */   }
/*     */   
/*     */   public static Humanoids HUMANOIDS() {
/* 160 */     return i.creatures;
/*     */   }
/*     */   
/*     */   public static Minables MINERALS() {
/* 164 */     return (GROUND()).minerals;
/*     */   }
/*     */   
/*     */   public static MAINTENANCE MAINTENANCE() {
/* 168 */     return i.maintenance;
/*     */   }
/*     */   
/*     */   public static SettPlacability PLACA() {
/* 172 */     return i.placability;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static SBattle BATTLE() {
/* 180 */     return i.battle;
/*     */   }
/*     */   
/*     */   public static ParticleRenderer PARTICLES() {
/* 184 */     return i.particles;
/*     */   }
/*     */   
/*     */   public static POINTLIGHTS LIGHTS() {
/* 188 */     return i.lights;
/*     */   }
/*     */   
/*     */   public static SETT CITY() {
/* 192 */     return i;
/*     */   }
/*     */   
/*     */   public static Faction FACTION() {
/* 196 */     return i.faction();
/*     */   }
/*     */   
/*     */   public static HalfEnts HALFENTS() {
/* 200 */     return i.halfEnts;
/*     */   }
/*     */   
/*     */   public static SProjectiles PROJS() {
/* 204 */     return i.projectiles;
/*     */   }
/*     */   
/*     */   public static ENVIRONMENT ENV() {
/* 208 */     return i.env;
/*     */   }
/*     */   
/*     */   public static SettMaps MAPS() {
/* 212 */     return i.maps;
/*     */   }
/*     */   
/*     */   public static SettOverlay OVERLAY() {
/* 216 */     return i.details;
/*     */   }
/*     */   
/*     */   public static ComplexPlacers PLACERS() {
/* 220 */     return i.complexPlacers;
/*     */   }
/*     */   
/*     */   public static Invador INVADOR() {
/* 224 */     return i.invador;
/*     */   }
/*     */   
/*     */   public static Minimap MINIMAP() {
/* 228 */     return i.minimap;
/*     */   }
/*     */   
/*     */   public static SWEATHER WEATHER() {
/* 232 */     return i.weather;
/*     */   }
/*     */   
/*     */   public static SENTRY ENTRY() {
/* 236 */     return i.entry;
/*     */   }
/*     */   
/*     */   public static SettTrade TRADE() {
/* 240 */     return i.trade;
/*     */   }
/*     */   
/*     */   public static Recipes RECIPES() {
/* 244 */     return i.rescipes;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SETT() throws IOException {
/* 301 */     super("SETT", true);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     i = this;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     this.maps = new SettMaps();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     this.placability = new SettPlacability();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     this.particles = new ParticleRenderer();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     this.env = new ENVIRONMENT();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     this.terrain = new TileMap();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     this.animals = new Animals();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     this.rooms = new ROOMS();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     this.jobs = new JOBS();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     this.battle = new SBattle(null);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     this.entry = new SENTRY();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     this.exists = false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     this.shadowBatch = new ShadowBatch.Real();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     this.shadowDummy = (ShadowBatch)new ShadowBatch.Dummy();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     this.renData = new RenderData(TWIDTH, THEIGHT);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     this.worldArea = new CapitolArea();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     STATS.create();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     STANDINGS.create();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     this.eHandler = new ENTETIES();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     this.things = new THINGS();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     this.projectiles = new SProjectiles();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     this.creatures = new Humanoids();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     this.maintenance = new MAINTENANCE();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     this.lights = new POINTLIGHTS();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     this.complexPlacers = new ComplexPlacers();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     this.halfEnts = new HalfEnts();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     this.path = new PATHING();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     this.invador = new Invador();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     this.minimap = new Minimap(TWIDTH);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     this.weather = new SWEATHER();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     this.trade = new SettTrade();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     this.rescipes = new Recipes();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     this.details = new SettOverlay();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 497 */     this.tmpWin = new Rec();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 815 */     this.gHooks = new ArrayList(16); IDebugPanelSett.add("Regenerate settlement", new ACTION() { public void exe() { SETT.reGenerate(); } }
/*     */       ); this.saver = new SuperSaver<SettResource>(getClass(), (LIST)SettResource.resources) { private CharSequence sSave; private CharSequence sLoad; protected void save(SETT.SettResource t, FilePutter f) { CharSequence debug = (S.get()).developer ? (" " + t.getClass().getSimpleName()) : ""; SPRITES.loader().print(String.valueOf(this.sSave) + ": " + String.valueOf(this.sSave) + "/" + t.i + SETT.SettResource.resources.size()); t.save(f); } protected void load(SETT.SettResource t, FileGetter f) throws IOException { CharSequence debug = (S.get()).developer ? (" " + t.getClass().getSimpleName()) : ""; SPRITES.loader().print(String.valueOf(this.sLoad) + ": " + String.valueOf(this.sLoad) + "/" + t.i + SETT.SettResource.resources.size()); t.load(f); } protected String key(SETT.SettResource t) { return t.key; } protected void clear(SETT.SettResource t) { t.clear(); } }
/*     */       ;
/* 818 */   } public static void addGeneratorHook(ACTION action) { i.gHooks.add(action); }
/*     */ 
/*     */   
/*     */   public void CreateFromWorldMap(int wx1, int wy1, boolean isBattle) {
/*     */     D.gInit(getClass());
/*     */     this.worldArea.init(wx1, wy1, isBattle);
/*     */     SPRITES.loader().init();
/*     */     SPRITES.loader().print(D.g("Clearing"));
/*     */     int i;
/*     */     for (i = 0; i < SettResource.resources.size(); i++) {
/*     */       SettResource r = (SettResource)SettResource.resources.get(i);
/*     */       r.clear();
/*     */     } 
/*     */     GAME.ARMIES().clear();
/*     */     for (i = 0; i < SettResource.resources.size(); i++) {
/*     */       SettResource r = (SettResource)SettResource.resources.get(i);
/*     */       SPRITES.loader().print(String.valueOf(D.g("Generating")) + ": " + String.valueOf(D.g("Generating")) + "/" + 1 + i);
/*     */       r.generate(this.worldArea);
/*     */     } 
/*     */     SettlementGrid.Tile t = GRID.tile(this.worldArea.arrivalTile());
/*     */     this.rooms.THRONE.init.markArround(t.coo(DIR.C).x(), t.coo(DIR.C).y());
/*     */     VIEW.s().getWindow().centerAt(THRONE.coo().x() * 64, THRONE.coo().y() * 64);
/*     */     VIEW.s().clear();
/*     */     setExists();
/*     */     for (int j = 0; j < SettResource.resources.size(); j++) {
/*     */       SettResource r = (SettResource)SettResource.resources.get(j);
/*     */       SPRITES.loader().print(String.valueOf(D.g("Initializing")) + ": " + String.valueOf(D.g("Initializing")) + "/" + 1 + j);
/*     */       r.init(false);
/*     */     } 
/*     */     AvailabilityListener.listenAll(true);
/*     */     update(0.0D, Profiler.DUMMY);
/*     */     System.gc();
/*     */     for (ACTION a : this.gHooks)
/*     */       a.exe(); 
/*     */     for (Div d : GAME.ARMIES().player().divisions())
/*     */       d.info.raceSet(GAME.player().race()); 
/*     */   }
/*     */   
/*     */   public static int tileRan(int tx, int ty) {
/*     */     return i.renData.random(tx, ty);
/*     */   }
/*     */   
/*     */   public static void reGenerate() {
/*     */     i.CreateFromWorldMap(i.worldArea.tiles().x1(), i.worldArea.tiles().y1(), i.worldArea.isBattle);
/*     */   }
/*     */   
/*     */   private void setExists() {
/*     */     if (GAME.SPEED.speedTarget() > 1.0D)
/*     */       GAME.SPEED.speedSet(1.0D); 
/*     */     this.exists = true;
/*     */   }
/*     */   
/*     */   protected void save(FilePutter saveFile) {
/*     */     saveFile.bool(this.exists);
/*     */     if (!this.exists)
/*     */       return; 
/*     */     D.gInit(getClass());
/*     */     this.worldArea.saver.save(saveFile);
/*     */     this.saver.save(saveFile);
/*     */   }
/*     */   
/*     */   protected void load(FileGetter saveFile) throws IOException {
/*     */     D.gInit(getClass());
/*     */     this.exists = saveFile.bool();
/*     */     if (!this.exists)
/*     */       return; 
/*     */     this.worldArea.saver.load(saveFile);
/*     */     int k = 0;
/*     */     int m = SettResource.resources.size();
/*     */     this.saver.load(saveFile);
/*     */     k = 0;
/*     */     for (int i = 0; i < SettResource.resources.size(); i++) {
/*     */       SettResource r = (SettResource)SettResource.resources.get(i);
/*     */       CharSequence s = (S.get()).debug ? String.valueOf(r) : Dic.empty;
/*     */       SPRITES.loader().print(String.valueOf(Dic.¤¤Generating) + ": " + String.valueOf(Dic.¤¤Generating) + "/" + k++ + m);
/*     */       r.init(true);
/*     */     } 
/*     */     setExists();
/*     */   }
/*     */   
/*     */   public static void init() {
/*     */     int k = 0;
/*     */     int m = SettResource.resources.size();
/*     */     for (int i = 0; i < SettResource.resources.size(); i++) {
/*     */       SettResource r = (SettResource)SettResource.resources.get(i);
/*     */       SPRITES.loader().print("Processing Settlement " + k++ + "/" + m);
/*     */       r.init(false);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void render(Renderer r, float ds, GameWindow window, UIMinimapSettConfig con) {
/*     */     render(r, ds, window.zoomout(), (RECTANGLE)window.pixels(), window.view().x1() << window.zoomout(), window.view().y1() << window.zoomout(), con);
/*     */   }
/*     */   
/*     */   public void render(Renderer r, float ds, int zoomout, int cx, int cy, RECTANGLE bounds, UIMinimapSettConfig con) {
/*     */     int offX = bounds.x1() << zoomout;
/*     */     int offY = bounds.y1() << zoomout;
/*     */     int w = bounds.width() << zoomout;
/*     */     int h = bounds.height() << zoomout;
/*     */     int x1 = cx - w / 2;
/*     */     int y1 = cy - h / 2;
/*     */     this.tmpWin.moveX1Y1(x1, y1);
/*     */     this.tmpWin.setWidth(w);
/*     */     this.tmpWin.setHeight(h);
/*     */     render(r, ds, zoomout, (RECTANGLE)this.tmpWin, offX, offY, con);
/*     */   }
/*     */   
/*     */   private void renderFrame(int zoomout, RECTANGLE renWindow, int offX, int offY) {
/*     */     CORE.renderer().newLayer(false, 0);
/*     */     COLOR c = COLOR.WHITE10;
/*     */     int x1 = offX;
/*     */     int y1 = offY;
/*     */     int x2 = offX + renWindow.width();
/*     */     int y2 = offY + renWindow.height();
/*     */     AmbientLight.full.register(C.DIM());
/*     */     if (renWindow.x1() < 0) {
/*     */       x1 = -renWindow.x1();
/*     */       x1 += offX;
/*     */     } 
/*     */     if (renWindow.x2() > PWIDTH) {
/*     */       x2 = renWindow.width();
/*     */       x2 -= renWindow.x2() - PWIDTH;
/*     */       x2 += offX;
/*     */     } 
/*     */     if (renWindow.y1() < 0) {
/*     */       y1 = -renWindow.y1();
/*     */       y1 += offY;
/*     */     } 
/*     */     if (renWindow.y2() > PHEIGHT) {
/*     */       y2 = renWindow.height();
/*     */       y2 -= renWindow.y2() - PHEIGHT;
/*     */       y2 += offY;
/*     */     } 
/*     */     x1 >>= zoomout;
/*     */     y1 >>= zoomout;
/*     */     x2 >>= zoomout;
/*     */     y2 >>= zoomout;
/*     */     c.render((SPRITE_RENDERER)CORE.renderer(), x1 - 32, x1, y1 - 32, y2 + 32);
/*     */     c.render((SPRITE_RENDERER)CORE.renderer(), x2, x2 + 32, y1 - 32, y2 + 32);
/*     */     c.render((SPRITE_RENDERER)CORE.renderer(), x1, x2, y1 - 32, y1);
/*     */     c.render((SPRITE_RENDERER)CORE.renderer(), x1, x2, y2, y2 + 32);
/*     */   }
/*     */   
/*     */   public void render(Renderer r, float ds, int zoomout, RECTANGLE renWindow, int offX, int offY, UIMinimapSettConfig con) {
/*     */     ShadowBatch.Real real;
/*     */     if (zoomout > 3)
/*     */       return; 
/*     */     renderFrame(zoomout, renWindow, offX, offY);
/*     */     ds = (float)(ds * GAME.SPEED.speedTarget());
/*     */     if (zoomout == 3) {
/*     */       renderSemiMap(r, ds, zoomout, renWindow, offX, offY, con);
/*     */       return;
/*     */     } 
/*     */     AUDIO.setSettGain(1.0D / (1.0D + zoomout * 1.5D));
/*     */     CORE.getSoundCore().set(renWindow.cX() + offX, renWindow.cY() + offY);
/*     */     ShadowBatch s = this.shadowDummy;
/*     */     if ((S.get()).shadows.get() > 0) {
/*     */       this.shadowBatch.init(zoomout, (TIME.light()).shadow.sx(), (TIME.light()).shadow.sy());
/*     */       real = this.shadowBatch;
/*     */     } 
/*     */     this.renData.init(renWindow, offX, offY);
/*     */     this.weather.renderDownfall(r, ds, this.renData, zoomout);
/*     */     this.projectiles.renderAbove(r, (ShadowBatch)real, ds, zoomout, this.renData);
/*     */     this.details.renderAbove(r, this.renData, zoomout);
/*     */     for (int i = ON_TOP_RENDERABLE.renderables.size() - 1; i >= 0; i--) {
/*     */       ON_TOP_RENDERABLE ren = (ON_TOP_RENDERABLE)ON_TOP_RENDERABLE.renderables.get(i);
/*     */       ren.render((ShadowBatch)real, this.renData, zoomout, ds);
/*     */     } 
/*     */     this.halfEnts.renderInit(renWindow);
/*     */     this.halfEnts.renderAbove(r, (ShadowBatch)real, ds, renWindow, offX, offY);
/*     */     r.newLayer(false, zoomout);
/*     */     this.terrain.renderAboveEnts(r, (ShadowBatch)real, ds, zoomout, this.renData);
/*     */     this.battle.bannerR.render(r, (ShadowBatch)real, ds, renWindow, offX, offY);
/*     */     r.newLayer(false, zoomout);
/*     */     this.eHandler.renderA(r, (ShadowBatch)real, ds, renWindow, offX, offY);
/*     */     r.newLayer(false, zoomout);
/*     */     this.halfEnts.render(r, (ShadowBatch)real, ds, renWindow, offX, offY);
/*     */     r.newLayer(false, zoomout);
/*     */     this.things.render(r, (ShadowBatch)real, ds, renWindow, offX, offY);
/*     */     r.newLayer(false, zoomout);
/*     */     this.lights.render(r, (ShadowBatch)real, ds, renWindow, offX, offY);
/*     */     r.newLayer(false, zoomout);
/*     */     VIEW.current().renderBelowTerrain(r, (ShadowBatch)real, this.renData);
/*     */     r.newLayer(false, zoomout);
/*     */     this.terrain.renderTheRest(r, (ShadowBatch)real, ds, zoomout, this.renData, renWindow, offX, offY);
/*     */     for (SettResource rs : SettResource.resources)
/*     */       rs.postRender(ds); 
/*     */     double dz = 1.0D / (zoomout + 1);
/*     */     for (Ambiance a : AUDIO.AMBI().all()) {
/*     */       a.prioritySet(a.priority() * dz);
/*     */       a.gainSet(dz * a.priority() / this.renData.area());
/*     */     } 
/*     */     double d = this.renData.waters();
/*     */     (AUDIO.AMBI()).water.prioritySet(d * dz).gainSet(d * dz / this.renData.area());
/*     */     d = this.renData.caves();
/*     */     (AUDIO.AMBI()).windhowl.prioritySet(d * dz).gainSet(d * dz / this.renData.area());
/*     */     double nature = this.renData.vegitations();
/*     */     if ((WEATHER()).rain.getD() > 0.0D && !(WEATHER()).snow.rainIsSnow() && !GAME.SPEED.isPaused()) {
/*     */       (AUDIO.AMBI()).rain.prioritySet(this.renData.area()).gainSet((WEATHER()).rain.getD());
/*     */     } else {
/*     */       if (TIME.light().nightIs()) {
/*     */         (AUDIO.AMBI()).night.prioritySet(nature * dz).gainSet(dz);
/*     */       } else {
/*     */         (AUDIO.AMBI()).nature.prioritySet(nature * dz).gainSet(dz);
/*     */       } 
/*     */       (AUDIO.AMBI()).windTrees.prioritySet(nature * dz).gainSet(CLAMP.d((WEATHER()).wind.getD(), 0.0D, 1.0D));
/*     */     } 
/*     */     this.weather.thunder.makeSounds(1.0D, ds);
/*     */     double wind = 1.0D - dz;
/*     */     (AUDIO.AMBI()).wind.prioritySet(wind * this.renData.area()).gainSet(wind * (WEATHER()).wind.getD());
/*     */   }
/*     */   
/*     */   public void renderSemiMap(Renderer r, float ds, int zoomout, RECTANGLE renWindow, int offX, int offY, UIMinimapSettConfig con) {
/*     */     this.renData.init(renWindow, offX, offY);
/*     */     r.newLayer(false, 3);
/*     */     AmbientLight.full.register(0, C.WIDTH() << zoomout, 0, C.HEIGHT() << zoomout);
/*     */     this.details.renderAbove(r, this.renData, zoomout);
/*     */     for (int i = ON_TOP_RENDERABLE.renderables.size() - 1; i >= 0; i--) {
/*     */       ON_TOP_RENDERABLE ren = (ON_TOP_RENDERABLE)ON_TOP_RENDERABLE.renderables.get(i);
/*     */       ren.render((ShadowBatch)this.shadowBatch, this.renData, zoomout, ds);
/*     */     } 
/*     */     r.newLayer(false, 3);
/*     */     TIME.light().apply(C.DIM().x1() << 3, C.DIM().x2() << 3, C.DIM().y1() << 3, C.DIM().y2() << 3, RGB.WHITE);
/*     */     boolean bat = !(GAME.ARMIES().enemy().men() <= 0 && !VIEW.b().isActive());
/*     */     if (!bat)
/*     */       THINGS().renderZoomed(r, renWindow, offX, offY); 
/*     */     ENTITIES().renderZoomed(r, (ShadowBatch)this.shadowBatch, ds, renWindow, offX, offY, con);
/*     */     HALFENTS().renderZoomed(r, (ShadowBatch)this.shadowBatch, ds, renWindow, offX, offY);
/*     */     r.newLayer(true, 3);
/*     */     VIEW.current().renderBelowTerrain(r, (ShadowBatch)this.shadowBatch, this.renData);
/*     */     TILE_MAP().renderSemiMap(r, ds, this.renData);
/*     */   }
/*     */   
/*     */   protected void update(double ds, Profiler prof) {
/*     */     prof.logStart(SETT.class);
/*     */     if (!this.exists)
/*     */       return; 
/*     */     for (SettResource r : SettResource.resources) {
/*     */       if (r.isBattle || !VIEW.b().isActive()) {
/*     */         prof.logStart(r);
/*     */         r.update(ds, prof);
/*     */         prof.logEnd(r);
/*     */       } 
/*     */     } 
/*     */     prof.logEnd(SETT.class);
/*     */   }
/*     */   
/*     */   protected void afterTick() {
/*     */     for (SettResource r : SettResource.resources)
/*     */       r.afterTick(); 
/*     */   }
/*     */   
/*     */   public static abstract class SettResource {
/*     */     private static final LinkedList<SettResource> resources = new LinkedList();
/*     */     private final String key;
/*     */     private final boolean isBattle;
/*     */     private final int i;
/*     */     
/*     */     protected SettResource(String key, boolean battle) {
/*     */       this.i = resources.add(this);
/*     */       this.key = key;
/*     */       this.isBattle = battle;
/*     */     }
/*     */     
/*     */     protected void save(FilePutter file) {}
/*     */     
/*     */     protected void load(FileGetter file) throws IOException {}
/*     */     
/*     */     protected void clear() {}
/*     */     
/*     */     protected void generate(CapitolArea area) {}
/*     */     
/*     */     protected void update(double ds, Profiler profiler) {}
/*     */     
/*     */     protected void postRender(float ds) {}
/*     */     
/*     */     protected void afterTick() {}
/*     */     
/*     */     protected void init(boolean loaded) {}
/*     */   }
/*     */   
/*     */   public static boolean exists() {
/*     */     return i.exists;
/*     */   }
/*     */   
/*     */   public Faction faction() {
/*     */     return (Faction)FACTIONS.player();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\main\SETT.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */