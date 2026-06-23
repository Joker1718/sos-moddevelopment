/*     */ package game;
/*     */ 
/*     */ import game.audio.AUDIO;
/*     */ import game.battle.Armies;
/*     */ import game.battle.thread.BattleThreads;
/*     */ import game.battle.util.BattleUtil;
/*     */ import game.boosting.superb.SuperBoostables;
/*     */ import game.boosting.tmp.TmpBoosting;
/*     */ import game.debug.Profiler;
/*     */ import game.event.engine.EVENT_HANDLER;
/*     */ import game.events.EVENTS;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.player.Player;
/*     */ import game.nobility.NOBLES;
/*     */ import game.raiding.RAIDING;
/*     */ import game.save.GameSaver;
/*     */ import game.save.Savable;
/*     */ import game.time.Intervals;
/*     */ import game.values.GCOUNTS;
/*     */ import init.INIT;
/*     */ import init.paths.PATHS;
/*     */ import init.race.RACES;
/*     */ import init.settings.S;
/*     */ import java.io.IOException;
/*     */ import script.ScriptEngine;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.CORE;
/*     */ import snake2d.LOG;
/*     */ import snake2d.TextureHolder;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import util.spritecomposer.Initer;
/*     */ import view.interrupter.IDebugPanel;
/*     */ import view.main.VIEW;
/*     */ import world.WORLD;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GAME
/*     */ {
/*     */   private static TextureHolder texture;
/*     */   private static GAME game;
/*  51 */   public static final GameSpeed SPEED = new GameSpeed();
/*     */   
/*  53 */   private final ArrayListGrower<ACTION> onUpdateFinish = new ArrayListGrower();
/*  54 */   private final ArrayListGrower<ACTION> onGameInited = new ArrayListGrower();
/*  55 */   private final ArrayListGrower<ACTION> onViewInited = new ArrayListGrower();
/*  56 */   private final ArrayListGrower<ACTION> onBeforeGameStarts = new ArrayListGrower();
/*     */   
/*     */   private final GameSaver saver;
/*     */   
/*     */   private final Intervals intervals;
/*     */   
/*     */   private final AUDIO audio;
/*     */   
/*     */   private final TmpBoosting boostingTmp;
/*     */   
/*     */   private final SuperBoostables boostingSuper;
/*     */   
/*     */   private final Armies battle;
/*     */   private final BattleThreads battleThreads;
/*     */   private final BattleUtil battleutil;
/*     */   private final SETT settlement;
/*     */   private final WORLD world;
/*     */   private final FACTIONS factions;
/*     */   private final EVENTS events;
/*     */   private final EVENT_HANDLER event;
/*     */   private final RAIDING raiders;
/*     */   private final ScriptEngine script;
/*     */   private final NOBLES nobilities;
/*     */   private final GCOUNTS counts;
/*  80 */   private int updateI = 0;
/*     */   private final int version;
/*  82 */   private Profiler profiler = Profiler.DUMMY;
/*     */   
/*     */   private boolean achieving = true;
/*     */   private final VIEW view;
/*     */   
/*     */   private GAME(GameSpec spec) throws IOException {
/*  88 */     CORE.disposeClient();
/*  89 */     GameDisposable.disposeAll();
/*  90 */     this.version = spec.version;
/*  91 */     this.saver = new GameSaver(this);
/*  92 */     this.saver.add(new Savable("GAME")
/*     */         {
/*     */           
/*     */           protected void save(FilePutter file)
/*     */           {
/*  97 */             file.bool(GAME.game.achieving);
/*  98 */             GAME.SPEED.save(file);
/*  99 */             file.i(GAME.updateI());
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           protected void load(FileGetter file) throws IOException {
/* 106 */             GAME.this.achieving = file.bool();
/*     */ 
/*     */             
/* 109 */             GAME.SPEED.load(file);
/*     */             
/* 111 */             GAME.this.updateI = file.i();
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */     
/* 117 */     game = this;
/* 118 */     CORE.checkIn();
/* 119 */     this.script = new ScriptEngine(spec.scripts);
/* 120 */     CORE.checkIn();
/*     */     
/* 122 */     this.audio = new AUDIO(null);
/*     */     
/* 124 */     INIT init = new INIT();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 130 */     CORE.checkIn();
/*     */     
/* 132 */     CORE.checkIn();
/*     */     
/* 134 */     this.audio.init();
/*     */     
/* 136 */     this.intervals = new Intervals();
/* 137 */     CORE.checkIn();
/*     */     
/* 139 */     this.boostingTmp = new TmpBoosting(this);
/* 140 */     this.boostingSuper = new SuperBoostables(this);
/* 141 */     CORE.checkIn();
/*     */     
/* 143 */     this.settlement = new SETT();
/* 144 */     CORE.checkIn();
/*     */     
/* 146 */     this.battle = new Armies(this);
/* 147 */     this.battleThreads = new BattleThreads(game);
/*     */     
/* 149 */     this.battleutil = new BattleUtil(this);
/*     */ 
/*     */     
/* 152 */     CORE.checkIn();
/* 153 */     this.counts = new GCOUNTS();
/* 154 */     CORE.checkIn();
/*     */ 
/*     */ 
/*     */     
/* 158 */     RACES.expand();
/* 159 */     this.world = new WORLD(spec.wx, spec.wy);
/*     */     
/* 161 */     this.raiders = new RAIDING();
/*     */     
/* 163 */     CORE.checkIn();
/* 164 */     this.events = new EVENTS();
/*     */     
/* 166 */     CORE.checkIn();
/* 167 */     this.nobilities = new NOBLES();
/* 168 */     this.factions = new FACTIONS();
/* 169 */     CORE.checkIn();
/* 170 */     SPEED.clear();
/* 171 */     CORE.checkIn();
/*     */     
/* 173 */     this.script.init.initBeforeGameInited();
/*     */     
/* 175 */     this.event = new EVENT_HANDLER();
/*     */ 
/*     */     
/* 178 */     for (Savable s : init.finish()) {
/* 179 */       this.saver.addSpecialSaver(s);
/*     */     }
/*     */     
/* 182 */     for (ACTION a : this.onGameInited) {
/* 183 */       a.exe();
/*     */     }
/* 185 */     this.view = new VIEW(this);
/*     */     
/* 187 */     this.script.init(null);
/*     */     
/* 189 */     IDebugPanel.add("Profile", new ACTION()
/*     */         {
/*     */           public void exe()
/*     */           {
/* 193 */             if (GAME.this.profiler == Profiler.DUMMY) {
/* 194 */               GAME.this.profiler = Profiler.LIVE;
/*     */             } else {
/* 196 */               GAME.this.profiler = Profiler.DUMMY;
/*     */             } 
/*     */           }
/*     */         });
/* 200 */     for (ACTION a : this.onViewInited) {
/* 201 */       a.exe();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static VIEW create(String... scripts) {
/* 208 */     return create(GameSpec.get(scripts));
/*     */   }
/*     */   
/*     */   public static VIEW create(final GameSpec spec) {
/* 212 */     LOG.ln("NEW GAME Game version: " + VERSION.VERSION_STRING);
/* 213 */     (new CORE.GlJob()
/*     */       {
/*     */         public void doJob()
/*     */         {
/* 217 */           GAME.texture = (new Initer()
/*     */             {
/*     */               public void createAssets() throws IOException
/*     */               {
/* 221 */                 CORE.getSoundCore().stopAllSounds();
/* 222 */                 CORE.getSoundCore().disposeSounds();
/* 223 */                 CORE.checkIn();
/*     */                 
/* 225 */                 CORE.checkIn();
/*     */               }
/* 229 */             }).get("game", PATHS.textureSize(), SETT.THEIGHT);
/*     */         }
/* 231 */       }).perform();
/* 232 */     return game.view;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void update(double seconds) {
/* 237 */     SPEED.speedSet(1.0D);
/* 238 */     game.update(seconds, 0.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void update(double ds, double slowDown) {
/* 249 */     this.audio.update(ds);
/* 250 */     game.profiler.logStart(game);
/* 251 */     double ods = ds;
/*     */     
/* 253 */     float max = 0.0625F;
/*     */     
/* 255 */     double speed = SPEED.update(slowDown);
/*     */ 
/*     */     
/* 258 */     if (speed == 0.0D) {
/* 259 */       for (GameResource s : GameResource.all) {
/* 260 */         if (s.isBattle || !VIEW.b().isActive())
/* 261 */           s.update(0.0D, game.profiler); 
/*     */       } 
/* 263 */       game.updateI++;
/*     */     } else {
/* 265 */       ds *= speed;
/* 266 */       this.saver.autoSave(ds);
/* 267 */       int fulls = (int)(ds / max);
/* 268 */       double last = ds - (fulls * max);
/*     */       
/* 270 */       for (int i = 0; i < fulls; i++) {
/* 271 */         for (GameResource s : GameResource.all) {
/* 272 */           if (s.isBattle || !VIEW.b().isActive())
/* 273 */             s.update(max, game.profiler); 
/*     */         } 
/* 275 */         game.updateI++;
/*     */       } 
/*     */       
/* 278 */       if (last > 0.0D) {
/* 279 */         for (GameResource s : GameResource.all) {
/* 280 */           if (s.isBattle || !VIEW.b().isActive())
/* 281 */             s.update(last, game.profiler); 
/*     */         } 
/* 283 */         game.updateI++;
/*     */       } 
/*     */     } 
/*     */     
/* 287 */     for (ACTION a : this.onUpdateFinish) {
/* 288 */       a.exe();
/*     */     }
/* 290 */     game.profiler.logEnd(game);
/* 291 */     game.profiler.log();
/* 292 */     game.saver.autoSave(ods);
/*     */   }
/*     */ 
/*     */   
/*     */   public void afterTick() {
/* 297 */     for (GameResource s : GameResource.all) {
/* 298 */       s.afterTick();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static void setGameStart() {
/* 304 */     game.updateI = -1;
/* 305 */     for (ACTION a : game.onBeforeGameStarts)
/* 306 */       a.exe(); 
/*     */   }
/*     */   
/*     */   public static Armies ARMIES() {
/* 310 */     return game.battle;
/*     */   }
/*     */   
/*     */   public static BattleThreads BATTLE_THREADS() {
/* 314 */     return game.battleThreads;
/*     */   }
/*     */   
/*     */   public static WORLD world() {
/* 318 */     return game.world;
/*     */   }
/*     */   
/*     */   public static SETT s() {
/* 322 */     return game.settlement;
/*     */   }
/*     */   
/*     */   public static Intervals intervals() {
/* 326 */     return game.intervals;
/*     */   }
/*     */   
/*     */   public static FACTIONS factions() {
/* 330 */     return game.factions;
/*     */   }
/*     */   
/*     */   public static int updateI() {
/* 334 */     return game.updateI;
/*     */   }
/*     */   
/*     */   public static ScriptEngine script() {
/* 338 */     return game.script;
/*     */   }
/*     */   
/*     */   public static Player player() {
/* 342 */     return FACTIONS.player();
/*     */   }
/*     */   
/*     */   public static EVENTS events() {
/* 346 */     return game.events;
/*     */   }
/*     */   
/*     */   public static TextureHolder texture() {
/* 350 */     return texture;
/*     */   }
/*     */   
/*     */   public static NOBLES NOBLE() {
/* 354 */     return game.nobilities;
/*     */   }
/*     */   
/*     */   public static RAIDING raiders() {
/* 358 */     return game.raiders;
/*     */   }
/*     */   
/*     */   public static EVENT_HANDLER EVENT() {
/* 362 */     return game.event;
/*     */   }
/*     */   
/*     */   public static BattleUtil battle() {
/* 366 */     return game.battleutil;
/*     */   }
/*     */   
/*     */   public static TmpBoosting BOOST() {
/* 370 */     return game.boostingTmp;
/*     */   }
/*     */   
/*     */   public static SuperBoostables BOOSTS() {
/* 374 */     return game.boostingSuper;
/*     */   }
/*     */   
/*     */   public static GameSaver saver() {
/* 378 */     return game.saver;
/*     */   }
/*     */ 
/*     */   
/*     */   public static GCOUNTS count() {
/* 383 */     return game.counts;
/*     */   }
/*     */   
/*     */   public static void Notify(CharSequence s) {
/* 387 */     if ((S.get()).developer && (S.get()).debug) {
/* 388 */       SPEED.speedSet(0.0D);
/* 389 */       System.out.println();
/* 390 */       System.out.println("SYX NOTIFICATION: " + String.valueOf(s));
/* 391 */       StackTraceElement[] trace = (new RuntimeException()).getStackTrace();
/* 392 */       int l = trace.length - 1;
/* 393 */       for (; l >= 0; l--) {
/* 394 */         StackTraceElement e = trace[l];
/* 395 */         if (e.getClassName() == GAME.class.getName())
/*     */           break; 
/* 397 */         if (e.getClassName().startsWith("snake2d"))
/*     */           break; 
/*     */       } 
/* 400 */       for (int i = 1; i <= l; i++) {
/* 401 */         System.out.println("    " + String.valueOf(trace[i]));
/*     */       }
/*     */       
/* 404 */       System.out.println();
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void Notify(Object s) {
/* 409 */     Notify(String.valueOf(s));
/*     */   }
/*     */   
/*     */   public static void Error(String s) {
/* 413 */     if ((S.get()).developer || (S.get()).debug) {
/* 414 */       Warn(s);
/*     */     } else {
/* 416 */       throw new RuntimeException(s);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void Warn(String s) {
/* 422 */     if ((S.get()).developer || (S.get()).debug) {
/* 423 */       SPEED.speedSet(0.0D);
/* 424 */       LOG.err("SYX WARNING: " + s);
/* 425 */       StackTraceElement[] trace = (new RuntimeException()).getStackTrace(); byte b; int i; StackTraceElement[] arrayOfStackTraceElement1;
/* 426 */       for (i = (arrayOfStackTraceElement1 = trace).length, b = 0; b < i; ) { StackTraceElement e = arrayOfStackTraceElement1[b];
/* 427 */         if (e.getClassName() != GAME.class.getName())
/*     */         {
/* 429 */           if (!e.getClassName().startsWith("snake2d"))
/*     */           {
/* 431 */             LOG.err("    " + String.valueOf(e)); }  } 
/*     */         b++; }
/*     */     
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void WarnLight(String s) {
/* 438 */     if ((S.get()).developer || (S.get()).debug) {
/* 439 */       LOG.err("SYX WARNING: " + s);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void Error(CharSequence s) {
/* 444 */     Error(String.valueOf(s));
/*     */   }
/*     */ 
/*     */   
/*     */   public static int version() {
/* 449 */     return game.version;
/*     */   }
/*     */   
/*     */   public static abstract class GameResource
/*     */     extends Savable
/*     */   {
/*     */     protected final boolean isBattle;
/* 456 */     private static final ArrayList<GameResource> all = new ArrayList(16);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected GameResource(String key) {
/* 469 */       this(key, true);
/*     */     }
/*     */ 
/*     */     
/*     */     protected GameResource(String key, boolean isBattle) {
/* 474 */       super(key);
/* 475 */       GAME.saver().add(this);
/* 476 */       all.add(this);
/* 477 */       this.isBattle = isBattle;
/*     */     }
/*     */ 
/*     */     
/*     */     protected void afterTick() {}
/*     */ 
/*     */     
/*     */     protected abstract void update(double param1Double, Profiler param1Profiler);
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean achieving() {
/* 489 */     return game.achieving;
/*     */   }
/*     */   
/*     */   public static void achieve(boolean a) {
/* 493 */     game.achieving = a;
/*     */   }
/*     */   
/*     */   public static class Cache
/*     */   {
/*     */     int upI;
/*     */     private final int ticks;
/*     */     
/*     */     public Cache(int ticks) {
/* 502 */       this.upI = -ticks;
/* 503 */       this.ticks = ticks;
/*     */     }
/*     */     
/*     */     public boolean shouldAndReset() {
/* 507 */       if (Math.abs(GAME.updateI() - this.upI) > this.ticks) {
/* 508 */         this.upI = GAME.updateI();
/* 509 */         return true;
/*     */       } 
/* 511 */       return false;
/*     */     }
/*     */     
/*     */     public void reset() {
/* 515 */       this.upI = GAME.updateI() - this.ticks;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static void addAfterUpdate(ACTION action) {
/* 521 */     game.onUpdateFinish.add(action);
/*     */   }
/*     */   
/*     */   public static void addOnInit(ACTION action) {
/* 525 */     game.onGameInited.add(action);
/*     */   }
/*     */   
/*     */   public static void addOnViewInit(ACTION action) {
/* 529 */     game.onViewInited.add(action);
/*     */   }
/*     */   
/*     */   public static void addBeforeGameStarts(ACTION action) {
/* 533 */     game.onBeforeGameStarts.add(action);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\GAME.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */