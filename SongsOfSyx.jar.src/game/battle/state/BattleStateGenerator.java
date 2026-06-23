/*     */ package game.battle.state;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.util.DivGeneration;
/*     */ import init.constant.Config;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.military.artillery.ROOM_ARTILLERY;
/*     */ import settlement.tilemap.generator.Generator;
/*     */ import snake2d.Errors;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import util.GUTIL;
/*     */ import world.WORLD;
/*     */ 
/*     */ 
/*     */ final class BattleStateGenerator
/*     */ {
/*     */   BattleStateSpec.SpecSide side1;
/*     */   BattleStateSpec.SpecSide side2;
/*  28 */   private final LinkedList<ROOM_ARTILLERY> a1 = new LinkedList();
/*  29 */   private final LinkedList<ROOM_ARTILLERY> a2 = new LinkedList();
/*     */   
/*     */   private Race r1;
/*     */   
/*     */   private Race r2;
/*     */ 
/*     */   
/*     */   void generate(BattleState s, BattleStateSpec spec, Rec deploymentTiles) {
/*  37 */     this.side1 = makeSide(spec.player, true);
/*  38 */     this.side2 = makeSide(spec.enemy, false);
/*     */     
/*  40 */     DIR d = DIR.N;
/*  41 */     d = DIR.get((COORDINATE)spec.player.wCoo, (COORDINATE)spec.enemy.wCoo);
/*     */     
/*  43 */     if (d == DIR.C) {
/*  44 */       d = DIR.N;
/*     */     }
/*  46 */     if (!d.isOrtho()) {
/*  47 */       d = d.next(1);
/*     */     }
/*  49 */     genMap(spec.player.wCoo.x(), spec.player.wCoo.y(), d);
/*  50 */     (SETT.ROOMS()).THRONE.init.place(SETT.TILE_BOUNDS.cX(), SETT.TILE_BOUNDS.cY(), 0);
/*  51 */     GAME.BATTLE_THREADS().pause();
/*  52 */     genArmies(s, spec.player, spec.enemy, deploymentTiles, d);
/*  53 */     SETT.init();
/*  54 */     Generator.paintMinimap();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private BattleStateSpec.SpecSide makeSide(BattleStateSpec.SpecSide side, boolean sideA) {
/*  64 */     Race race = getRace((LIST<DivGeneration>)side.divs);
/*  65 */     if (sideA) {
/*  66 */       for (ROOM_ARTILLERY aa : (SETT.ROOMS()).ARTILLERY) {
/*  67 */         for (int i = 0; i < side.artillery[aa.typeIndex()]; i++)
/*  68 */           this.a1.add(aa); 
/*     */       } 
/*  70 */       this.r1 = race;
/*     */     } else {
/*     */       
/*  73 */       for (ROOM_ARTILLERY aa : (SETT.ROOMS()).ARTILLERY) {
/*  74 */         for (int i = 0; i < side.artillery[aa.typeIndex()]; i++)
/*  75 */           this.a2.add(aa); 
/*     */       } 
/*  77 */       this.r2 = race;
/*     */     } 
/*  79 */     return side;
/*     */   }
/*     */   
/*     */   private static Race getRace(LIST<DivGeneration> divs) {
/*  83 */     int[] amount = Alloc.ii(RACES.all().size());
/*  84 */     for (DivGeneration d : divs) {
/*  85 */       amount[d.race] = amount[d.race] + d.indus.length;
/*     */     }
/*     */     
/*  88 */     int best = 0;
/*  89 */     int bestV = 0;
/*  90 */     for (Race r : RACES.all()) {
/*  91 */       if (amount[r.index] > bestV) {
/*  92 */         best = r.index;
/*  93 */         bestV = amount[r.index];
/*     */       } 
/*     */     } 
/*     */     
/*  97 */     return (Race)RACES.all().get(best);
/*     */   }
/*     */ 
/*     */   
/*     */   private void genMap(int cx, int cy, DIR eDir) {
/* 102 */     cx = CLAMP.i(cx, 0, WORLD.TWIDTH() - 1);
/* 103 */     cy = CLAMP.i(cy, 0, WORLD.THEIGHT() - 1);
/*     */     
/* 105 */     GUTIL.flooder().init(this);
/* 106 */     GUTIL.flooder().pushSloppy(cx, cy, 0.0D);
/* 107 */     int ts = 0;
/* 108 */     while (GUTIL.flooder().hasMore()) {
/* 109 */       PathTile c = GUTIL.flooder().pollSmallest();
/* 110 */       ts++;
/* 111 */       if (BattleState.okWorldTile(c.x(), c.y(), eDir)) {
/* 112 */         GUTIL.flooder().done();
/* 113 */         GAME.s().CreateFromWorldMap(c.x() - 1, c.y() - 1, true);
/*     */         return;
/*     */       } 
/* 116 */       for (int di = 0; di < DIR.ALL.size(); di++) {
/* 117 */         DIR d = (DIR)DIR.ALL.get(di);
/* 118 */         if (WORLD.IN_BOUNDS((COORDINATE)c, d)) {
/* 119 */           GUTIL.flooder().pushSmaller((COORDINATE)c, d, c.getValue() + d.tileDistance());
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 125 */     GUTIL.flooder().done();
/* 126 */     throw new Errors.GameError("Unable to find location for battle " + cx + " " + cy + " " + ts);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void genArmies(BattleState s, BattleStateSpec.SpecSide a, BattleStateSpec.SpecSide b, Rec tiles, DIR d) {
/* 133 */     for (int di = 0; di < (Config.battle()).DIVISIONS_PER_BATTLE; di++) {
/* 134 */       (GAME.ARMIES().division((short)di)).info.menSet(0);
/*     */     }
/* 136 */     tiles.set((
/* 137 */         SETT.TILE_BOUNDS.cX() + d.next(-2).x() * SETT.TWIDTH / 2), (SETT.TILE_BOUNDS.cX() + d.next(3).x() * SETT.TWIDTH / 2), (
/* 138 */         SETT.TILE_BOUNDS.cY() + d.next(-2).y() * SETT.TWIDTH / 2), (SETT.TILE_BOUNDS.cY() + d.next(3).y() * SETT.TWIDTH / 2));
/* 139 */     tiles.makePositive();
/*     */ 
/*     */ 
/*     */     
/* 143 */     BattleStateGenArmy.genArmy(this.side1.divs, true, d.perpendicular(), (LIST<ROOM_ARTILLERY>)this.a1, this.r1, this.side1.moraleBase);
/* 144 */     BattleStateGenArmy.genArmy(this.side2.divs, false, d, (LIST<ROOM_ARTILLERY>)this.a2, this.r2, this.side2.moraleBase);
/*     */     
/* 146 */     GAME.ARMIES().initAndTeleport(GAME.ARMIES().divisions());
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\state\BattleStateGenerator.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */