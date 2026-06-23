/*     */ package world.battle;
/*     */ 
/*     */ import game.battle.state.BattleState;
/*     */ import game.battle.state.BattleStateExiter;
/*     */ import game.battle.state.BattleStateResult;
/*     */ import game.battle.state.BattleStateSpec;
/*     */ import game.battle.util.DivGeneration;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.text.Dic;
/*     */ import view.main.VIEW;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.PlacableSimpleTile;
/*     */ import view.world.panel.IDebugPanelWorld;
/*     */ import world.WORLD;
/*     */ import world.army.AD;
/*     */ import world.army.ADSupplies;
/*     */ import world.battle.spec.BATTLE_RESULT;
/*     */ import world.battle.spec.WBattleResult;
/*     */ import world.battle.spec.WBattleSide;
/*     */ import world.battle.spec.WBattleSiege;
/*     */ import world.battle.spec.WBattleSpec;
/*     */ import world.battle.spec.WBattleUnit;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ 
/*     */ 
/*     */ class Tests
/*     */ {
/*     */   public Tests() {
/*  43 */     IDebugPanelWorld.add((PLACABLE)new PlacableSimpleTile("battle create")
/*     */         {
/*     */           public void place(int tx, int ty)
/*     */           {
/*  47 */             WBattleSpec s = Tests.this.spec(tx, ty, null, null);
/*  48 */             (VIEW.world()).UI.battle.battle(s);
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public CharSequence isPlacable(int tx, int ty) {
/*  54 */             return WORLD.IN_BOUNDS(tx, ty) ? null : E;
/*     */           }
/*     */         });
/*     */     
/*  58 */     IDebugPanelWorld.add((PLACABLE)new PlacableSimpleTile("battle assist")
/*     */         {
/*     */           public void place(int tx, int ty)
/*     */           {
/*  62 */             WBattleSpec s = Tests.this.spec(tx, ty, null, null);
/*  63 */             (VIEW.world()).UI.battle.assist(s);
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public CharSequence isPlacable(int tx, int ty) {
/*  69 */             return WORLD.IN_BOUNDS(tx, ty) ? null : E;
/*     */           }
/*     */         });
/*     */     
/*  73 */     IDebugPanelWorld.add((PLACABLE)new PlacableSimpleTile("battle lastStand")
/*     */         {
/*     */           
/*     */           public void place(int tx, int ty)
/*     */           {
/*  78 */             final Region reg = (Region)(WORLD.REGIONS()).map.get(tx, ty);
/*     */             
/*  80 */             WBattleUnit ss = new WBattleUnit()
/*     */               {
/*     */                 public CharSequence name()
/*     */                 {
/*  84 */                   return (CharSequence)reg.info.name();
/*     */                 }
/*     */ 
/*     */                 
/*     */                 public int men() {
/*  89 */                   return (RD.MILITARY()).garrison.get(reg);
/*     */                 }
/*     */ 
/*     */                 
/*     */                 public int lossesRetreat() {
/*  94 */                   return men();
/*     */                 }
/*     */ 
/*     */                 
/*     */                 public int losses() {
/*  99 */                   return men();
/*     */                 }
/*     */ 
/*     */                 
/*     */                 public SPRITE icon() {
/* 104 */                   return (SPRITE)(UI.icons()).m.building;
/*     */                 }
/*     */ 
/*     */                 
/*     */                 public void hover(GUI_BOX box) {
/* 109 */                   box.title(Dic.¤¤Region);
/*     */                 }
/*     */ 
/*     */                 
/*     */                 public double defences() {
/* 114 */                   return (RD.MILITARY()).fort.getD(reg);
/*     */                 }
/*     */               };
/*     */             
/* 118 */             WBattleSpec s = Tests.this.spec(tx, ty, ss, null);
/* 119 */             (VIEW.world()).UI.battle.lastStand(s);
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public CharSequence isPlacable(int tx, int ty) {
/* 125 */             return WORLD.REGIONS().centreTile().is(tx, ty) ? null : E;
/*     */           }
/*     */         });
/*     */     
/* 129 */     IDebugPanelWorld.add((PLACABLE)new PlacableSimpleTile("battle sally")
/*     */         {
/*     */           
/*     */           public void place(int tx, int ty)
/*     */           {
/* 134 */             final Region reg = (Region)(WORLD.REGIONS()).map.get(tx, ty);
/*     */             
/* 136 */             WBattleUnit ss = new WBattleUnit()
/*     */               {
/*     */                 public CharSequence name()
/*     */                 {
/* 140 */                   return (CharSequence)reg.info.name();
/*     */                 }
/*     */ 
/*     */                 
/*     */                 public int men() {
/* 145 */                   return (RD.MILITARY()).garrison.get(reg);
/*     */                 }
/*     */ 
/*     */                 
/*     */                 public int lossesRetreat() {
/* 150 */                   return 0;
/*     */                 }
/*     */ 
/*     */                 
/*     */                 public int losses() {
/* 155 */                   return (int)(men() * 0.5D);
/*     */                 }
/*     */ 
/*     */                 
/*     */                 public SPRITE icon() {
/* 160 */                   return (SPRITE)(UI.icons()).m.building;
/*     */                 }
/*     */ 
/*     */                 
/*     */                 public void hover(GUI_BOX box) {
/* 165 */                   box.title(Dic.¤¤Region);
/*     */                 }
/*     */ 
/*     */                 
/*     */                 public double defences() {
/* 170 */                   return 0.0D;
/*     */                 }
/*     */               };
/*     */             
/* 174 */             WBattleSpec s = Tests.this.spec(tx, ty, ss, null);
/* 175 */             (VIEW.world()).UI.battle.battleSally(s);
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public CharSequence isPlacable(int tx, int ty) {
/* 181 */             return WORLD.REGIONS().centreTile().is(tx, ty) ? null : E;
/*     */           }
/*     */         });
/*     */     
/* 185 */     IDebugPanelWorld.add((PLACABLE)new PlacableSimpleTile("battle siege")
/*     */         {
/*     */           
/*     */           public void place(int tx, int ty)
/*     */           {
/* 190 */             final Region reg = (Region)(WORLD.REGIONS()).map.get(tx, ty);
/*     */             
/* 192 */             WBattleUnit ss = new WBattleUnit()
/*     */               {
/*     */                 public CharSequence name()
/*     */                 {
/* 196 */                   return (CharSequence)reg.info.name();
/*     */                 }
/*     */ 
/*     */                 
/*     */                 public int men() {
/* 201 */                   return (RD.MILITARY()).garrison.get(reg);
/*     */                 }
/*     */ 
/*     */                 
/*     */                 public int lossesRetreat() {
/* 206 */                   return 0;
/*     */                 }
/*     */ 
/*     */                 
/*     */                 public int losses() {
/* 211 */                   return (int)(men() * 0.5D);
/*     */                 }
/*     */ 
/*     */                 
/*     */                 public SPRITE icon() {
/* 216 */                   return (SPRITE)(UI.icons()).m.building;
/*     */                 }
/*     */ 
/*     */                 
/*     */                 public void hover(GUI_BOX box) {
/* 221 */                   box.title(Dic.¤¤Region);
/*     */                 }
/*     */ 
/*     */                 
/*     */                 public double defences() {
/* 226 */                   return 20.0D;
/*     */                 }
/*     */               };
/*     */             
/* 230 */             WBattleSiege s = new WBattleSiege()
/*     */               {
/*     */                 public void retreat() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */                 
/*     */                 public void auto() {}
/*     */               };
/* 245 */             s.besiged = reg;
/* 246 */             s.victory = RND.rBoolean();
/* 247 */             s.player = Tests.this.side(RND.rFloat(), tx, ty, null);
/* 248 */             s.enemy = Tests.this.side(RND.rFloat(), tx, ty, ss);
/* 249 */             s.fortifications = 20.0D;
/* 250 */             (VIEW.world()).UI.battle.siege(s);
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public CharSequence isPlacable(int tx, int ty) {
/* 256 */             return WORLD.REGIONS().centreTile().is(tx, ty) ? null : E;
/*     */           }
/*     */         });
/*     */     
/* 260 */     IDebugPanelWorld.add((PLACABLE)new PlacableSimpleTile("battle conquer")
/*     */         {
/*     */           
/*     */           public void place(int tx, int ty)
/*     */           {
/* 265 */             Region reg = (Region)(WORLD.REGIONS()).map.get(tx, ty);
/*     */             
/* 267 */             WBattleSiege.Result res = new WBattleSiege.Result()
/*     */               {
/*     */                 public void puppet(double devastation, double death, int[] enslave, int[] resources) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */                 
/*     */                 public void occupy(double devastation, double death, int[] enslave, int[] resources) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */                 
/*     */                 public void abandon(double devastation, double death, int[] enslave, int[] resources) {}
/*     */               };
/* 287 */             res.besiged = reg;
/*     */             
/* 289 */             (VIEW.world()).UI.battle.result(res);
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public CharSequence isPlacable(int tx, int ty) {
/* 295 */             return WORLD.REGIONS().centreTile().is(tx, ty) ? null : E;
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private WBattleSpec spec(int tx, int ty, WBattleUnit p, WBattleUnit e) {
/* 303 */     WBattleSpec s = new WBattleSpec()
/*     */       {
/*     */         public void retreat()
/*     */         {
/* 307 */           WBattleResult res = new WBattleResult()
/*     */             {
/*     */               public void accept(int[] enslave, int[] resources) {}
/*     */             };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 317 */           res.player = this.player;
/* 318 */           res.enemy = this.enemy;
/* 319 */           res.result = BATTLE_RESULT.RETREAT;
/* 320 */           Tests.this.init(res, this.player, -1);
/* 321 */           (VIEW.world()).UI.battle.result(res, false);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void engage() {
/* 327 */           BattleStateSpec s = new BattleStateSpec();
/* 328 */           s.player = new BattleStateSpec.SpecSide();
/* 329 */           s.player.divs = new ArrayList(1 + RND.rInt(25)); int i;
/* 330 */           for (i = 0; i < s.player.artillery.length; i++) {
/* 331 */             s.player.artillery[i] = this.player.artillery((ADSupplies.ADArtillery)AD.supplies().arts().get(i));
/*     */           }
/*     */           
/* 334 */           s.player.moraleBase = 1.0D;
/* 335 */           s.player.wCoo.set(this.player.coo());
/* 336 */           for (i = 0; i < s.player.divs.max(); i++)
/* 337 */             s.player.divs.add(DivGeneration.rnd()); 
/* 338 */           s.enemy = new BattleStateSpec.SpecSide();
/* 339 */           s.enemy.divs = new ArrayList(1 + RND.rInt(25));
/* 340 */           for (i = 0; i < s.player.artillery.length; i++) {
/* 341 */             s.player.artillery[i] = this.player.artillery((ADSupplies.ADArtillery)AD.supplies().arts().get(i));
/*     */           }
/*     */           
/* 344 */           for (i = 0; i < s.player.artillery.length; i++) {
/* 345 */             s.enemy.artillery[i] = this.enemy.artillery((ADSupplies.ADArtillery)AD.supplies().arts().get(i));
/*     */           }
/*     */           
/* 348 */           s.enemy.moraleBase = 1.0D;
/* 349 */           s.enemy.wCoo.set(this.enemy.coo());
/* 350 */           while (s.enemy.divs.hasRoom()) {
/* 351 */             s.enemy.divs.add(DivGeneration.rnd());
/*     */           }
/* 353 */           BattleStateExiter res = new BattleStateExiter()
/*     */             {
/*     */               public void afterExit(BattleStateResult res) {}
/*     */             };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 362 */           BattleState.setGenerate(res, s);
/*     */         }
/*     */ 
/*     */         
/*     */         public void auto() {
/* 367 */           WBattleResult res = new WBattleResult()
/*     */             {
/*     */               public void accept(int[] enslave, int[] resources) {}
/*     */             };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 377 */           if (!this.victory) {
/* 378 */             Tests.this.init(res, this.player, -1);
/*     */           } else {
/* 380 */             Tests.this.init(res, this.enemy, 1);
/* 381 */           }  res.player = this.player;
/* 382 */           res.enemy = this.enemy;
/* 383 */           res.result = RND.rBoolean() ? BATTLE_RESULT.VICTORY : (RND.rBoolean() ? BATTLE_RESULT.DEFEAT : BATTLE_RESULT.RETREAT);
/* 384 */           (VIEW.world()).UI.battle.result(res, RND.rBoolean());
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 389 */     double power = RND.rFloat();
/* 390 */     s.player = side(power, tx, ty, p);
/* 391 */     s.enemy = side(1.0D - power, tx + 1, ty, e);
/* 392 */     s.victory = (power >= 0.5D);
/* 393 */     return s;
/*     */   }
/*     */ 
/*     */   
/*     */   private WBattleSide side(final double power, int tx, int ty, WBattleUnit first) {
/* 398 */     final ArrayList<WBattleUnit> us = new ArrayList(1 + RND.rInt(10) + 1);
/*     */     
/* 400 */     int tloss = 0;
/* 401 */     int tlossRet = 0;
/* 402 */     int tmen = 0;
/*     */     
/* 404 */     if (first != null) {
/* 405 */       us.add(first);
/*     */     }
/* 407 */     while (us.hasRoom()) {
/*     */       
/* 409 */       final CharSequence name = (String)((Race)RACES.all().rnd()).info.armyNames.rnd();
/* 410 */       final int men = 1 + RND.rInt(20000);
/* 411 */       final int losses = 1 + RND.rInt(i);
/* 412 */       final int lossesRetreat = RND.rInt(losses);
/* 413 */       int ri = RND.rInt();
/* 414 */       tloss += losses;
/* 415 */       tlossRet += lossesRetreat;
/* 416 */       tmen += i;
/*     */       
/* 418 */       final SPRITE icon = (((FactionNPC)FACTIONS.NPCs().getC(ri)).banner()).MEDIUM;
/* 419 */       WBattleUnit u = new WBattleUnit()
/*     */         {
/*     */           public void hover(GUI_BOX box)
/*     */           {
/* 423 */             box.text(Dic.¤¤Accept);
/* 424 */             box.NL();
/* 425 */             box.add((SPRITE)box.text().add(men));
/*     */           }
/*     */ 
/*     */           
/*     */           public CharSequence name() {
/* 430 */             return name;
/*     */           }
/*     */ 
/*     */           
/*     */           public int men() {
/* 435 */             return men;
/*     */           }
/*     */ 
/*     */           
/*     */           public int losses() {
/* 440 */             return losses;
/*     */           }
/*     */ 
/*     */           
/*     */           public int lossesRetreat() {
/* 445 */             return lossesRetreat;
/*     */           }
/*     */ 
/*     */           
/*     */           public SPRITE icon() {
/* 450 */             return icon;
/*     */           }
/*     */ 
/*     */           
/*     */           public double defences() {
/* 455 */             return 0.0D;
/*     */           }
/*     */         };
/* 458 */       us.add(u);
/*     */     } 
/*     */     
/* 461 */     final int men = tmen;
/* 462 */     final int loss = tloss;
/* 463 */     final int lossR = tlossRet;
/* 464 */     WBattleSide a = new WBattleSide(tx, ty)
/*     */       {
/*     */         Coo coo;
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public COORDINATE coo() {
/* 472 */           return (COORDINATE)this.coo;
/*     */         }
/*     */ 
/*     */         
/*     */         public int men() {
/* 477 */           return men;
/*     */         }
/*     */ 
/*     */         
/*     */         public int losses() {
/* 482 */           return loss;
/*     */         }
/*     */ 
/*     */         
/*     */         public int lossesRetreat() {
/* 487 */           return lossR;
/*     */         }
/*     */ 
/*     */         
/*     */         public LIST<WBattleUnit> units() {
/* 492 */           return (LIST<WBattleUnit>)us;
/*     */         }
/*     */ 
/*     */         
/*     */         public int artillery(ADSupplies.ADArtillery a) {
/* 497 */           return 2;
/*     */         }
/*     */ 
/*     */         
/*     */         public double powerBalance() {
/* 502 */           return power;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 507 */     return a;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void init(WBattleResult a, WBattleSide s, int i) {
/* 514 */     int captured = RND.rInt(1 + s.men());
/*     */     
/* 516 */     for (Race race : RACES.all()) {
/* 517 */       if (captured == 0)
/*     */         break; 
/* 519 */       a.capturedRaces[race.index()] = i * RND.rInt(captured);
/* 520 */       captured -= a.capturedRaces[race.index()];
/*     */     } 
/*     */     
/* 523 */     for (RESOURCE res : RESOURCES.ALL()) {
/* 524 */       if (RND.oneIn(5))
/* 525 */         a.lostResources[res.index()] = i * RND.rInt(5000); 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\battle\Tests.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */