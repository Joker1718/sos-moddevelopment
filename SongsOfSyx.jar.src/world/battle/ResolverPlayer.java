/*     */ package world.battle;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.state.BattleState;
/*     */ import game.battle.state.BattleStateExiter;
/*     */ import game.battle.state.BattleStateResult;
/*     */ import game.battle.state.BattleStateSpec;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.diplomacy.DIP;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.royalty.opinion.ROPINION;
/*     */ import init.constant.Config;
/*     */ import init.trade.TR;
/*     */ import init.trade.TRADABLE;
/*     */ import java.util.Arrays;
/*     */ import settlement.battle.invasion.InvasionSpec;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.file.Alloc;
/*     */ import view.main.VIEW;
/*     */ import world.army.AD;
/*     */ import world.army.ADSupplies;
/*     */ import world.army.ADSupply;
/*     */ import world.army.WDIV;
/*     */ import world.battle.spec.BATTLE_RESULT;
/*     */ import world.battle.spec.WBattleResult;
/*     */ import world.battle.spec.WBattleSiege;
/*     */ import world.battle.spec.WBattleSpec;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class ResolverPlayer
/*     */ {
/*  38 */   private final ResolverSide.RCount tmp = new ResolverSide.RCount();
/*  39 */   private final ResolverSide.RCount cEnemy = new ResolverSide.RCount();
/*  40 */   private final ResolverSide.RCount cPlayer = new ResolverSide.RCount();
/*  41 */   private final Spec spec = new Spec();
/*  42 */   private final Conquer conq = new Conquer();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void enemyWithdraws(final ResolverSide pp, final ResolverSide looser) {
/*  49 */     this.tmp.clear();
/*     */ 
/*     */     
/*  52 */     final double losses = Resolver.retreatValue(looser);
/*  53 */     looser.count(this.tmp, losses, false);
/*  54 */     Res rr = new Res(pp, looser, BATTLE_RESULT.VICTORY, this.tmp, 1.0D)
/*     */       {
/*     */         public void accept(int[] enslave, int[] resources)
/*     */         {
/*  58 */           BattleListener.notify(pp, looser);
/*  59 */           shipRetreat(enslave, resources);
/*  60 */           looser.extract(losses);
/*     */         }
/*     */       };
/*     */     
/*  64 */     (VIEW.world()).UI.battle.result(rr, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void battle(ResolverSide pp, ResolverSide ee) {
/*  71 */     this.spec.init(pp, ee);
/*  72 */     if (((ResolverSide.ResolverUnit)pp.us.get(0)).unit.faction() == FACTIONS.player()) {
/*  73 */       (VIEW.world()).UI.battle.battle(this.spec);
/*     */     } else {
/*  75 */       (VIEW.world()).UI.battle.assist(this.spec);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void sallyOut(final ResolverSide pp, final ResolverSide ee) {
/*  87 */     pp.count(this.cPlayer.clear(), 0.0D, true);
/*     */     
/*  89 */     WBattleSpec spec = new WBattleSpec()
/*     */       {
/*     */         public void retreat() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void engage() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void auto() {
/* 109 */           ResolverPlayer.this.tmp.clear();
/*     */           
/* 111 */           pp.count(ResolverPlayer.this.cPlayer.clear(), Resolver.autoValue(pp), false);
/* 112 */           ee.count(ResolverPlayer.this.cEnemy.clear(), Resolver.autoValue(ee), false);
/*     */           
/* 114 */           final BATTLE_RESULT res = (pp.powerBalance > ee.powerBalance) ? BATTLE_RESULT.VICTORY : BATTLE_RESULT.DEFEAT;
/*     */           
/* 116 */           if (res == BATTLE_RESULT.DEFEAT) {
/* 117 */             ((ResolverSide.ResolverUnit)pp.us.get(0)).count(ResolverPlayer.this.cPlayer.clear(), 1.0D, false);
/*     */           }
/*     */ 
/*     */           
/* 121 */           ResolverPlayer.Res rr = new ResolverPlayer.Res(pp, ee, res, (res == BATTLE_RESULT.VICTORY) ? ResolverPlayer.this.cEnemy : ResolverPlayer.this.cPlayer)
/*     */             {
/*     */               public void accept(int[] enslave, int[] resources)
/*     */               {
/* 125 */                 BattleListener.notify((res == BATTLE_RESULT.VICTORY) ? pp : ee, (res == BATTLE_RESULT.VICTORY) ? ee : pp);
/* 126 */                 shipRetreat(enslave, resources);
/* 127 */                 pp.extract(Resolver.autoValue(pp));
/* 128 */                 ee.extract(Resolver.autoValue(ee));
/*     */               }
/*     */             };
/*     */           
/* 132 */           (VIEW.world()).UI.battle.result(rr, false);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 137 */     spec.player = pp;
/* 138 */     spec.enemy = ee;
/*     */ 
/*     */ 
/*     */     
/* 142 */     (VIEW.world()).UI.battle.battleSally(spec);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void besige(final ResolverSide pp, final ResolverSide ee) {
/* 150 */     if (ee.men() == 0) {
/* 151 */       this.conq.init(((ResolverSide.ResolverUnit)ee.us.get(0)).unit.r(), pp.side, ee.side);
/* 152 */       (VIEW.world()).UI.battle.result(this.conq);
/*     */       
/*     */       return;
/*     */     } 
/* 156 */     WBattleSiege spec = new WBattleSiege()
/*     */       {
/*     */         public void auto()
/*     */         {
/* 160 */           ResolverPlayer.this.tmp.clear();
/* 161 */           pp.count(ResolverPlayer.this.cPlayer.clear(), Resolver.autoValue(pp), false);
/* 162 */           ee.count(ResolverPlayer.this.cEnemy.clear(), Resolver.autoValue(ee), false);
/* 163 */           final BATTLE_RESULT res = (pp.powerBalance > ee.powerBalance) ? BATTLE_RESULT.VICTORY : BATTLE_RESULT.DEFEAT;
/*     */           
/* 165 */           ResolverPlayer.Res rr = new ResolverPlayer.Res(pp, ee, res, (res == BATTLE_RESULT.VICTORY) ? ResolverPlayer.this.cEnemy : ResolverPlayer.this.cPlayer)
/*     */             {
/*     */               public void accept(int[] enslave, int[] resources)
/*     */               {
/* 169 */                 BattleListener.notify((res == BATTLE_RESULT.VICTORY) ? pp : ee, (res == BATTLE_RESULT.VICTORY) ? ee : pp);
/* 170 */                 shipRetreat(enslave, resources);
/* 171 */                 pp.extract(Resolver.autoValue(pp));
/* 172 */                 ee.extract(Resolver.autoValue(ee));
/*     */                 
/* 174 */                 if (res == BATTLE_RESULT.VICTORY) {
/* 175 */                   (ResolverPlayer.null.access$0(ResolverPlayer.null.this)).conq.init(((ResolverSide.ResolverUnit)ee.us.get(0)).unit.r(), pp.side, ee.side);
/* 176 */                   (VIEW.world()).UI.battle.result((ResolverPlayer.null.access$0(ResolverPlayer.null.this)).conq);
/*     */                 } 
/*     */               }
/*     */             };
/*     */           
/* 181 */           (VIEW.world()).UI.battle.result(rr, false);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void retreat() {
/* 187 */           for (Side.SideUnit u : pp.side.us) {
/* 188 */             if (u.a() != null && u.a().faction() == FACTIONS.player()) {
/* 189 */               u.a().stop();
/*     */             }
/*     */           } 
/*     */         }
/*     */       };
/* 194 */     spec.besiged = ((ResolverSide.ResolverUnit)ee.us.get(0)).unit.r();
/* 195 */     spec.fortifications = (RD.MILITARY()).fort.getD(spec.besiged);
/* 196 */     spec.victory = (pp.powerBalance > ee.powerBalance);
/* 197 */     spec.player = pp;
/* 198 */     spec.enemy = ee;
/* 199 */     (VIEW.world()).UI.battle.siege(spec);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void invadeCapitol(ResolverSide a) {
/* 206 */     Side winner = a.side;
/*     */     
/* 208 */     Faction f = ((Side.SideUnit)winner.us.get(0)).faction();
/*     */     
/* 210 */     InvasionSpec spec = new InvasionSpec();
/* 211 */     if (f != null) {
/* 212 */       spec.fi = f.index();
/*     */     }
/* 214 */     for (int i = 0; i < winner.divs(); i++) {
/* 215 */       spec.add(winner.div(i).generate());
/*     */     }
/*     */ 
/*     */     
/* 219 */     spec.wx = ((Side.SideUnit)winner.us.get(0)).x();
/* 220 */     spec.wy = ((Side.SideUnit)winner.us.get(0)).y();
/*     */     
/* 222 */     for (Side.SideUnit s : winner.us) {
/* 223 */       if (s.a() != null) {
/* 224 */         for (ADSupply su : (AD.supplies()).all) {
/* 225 */           spec.loot.add((TRADABLE)TR.get(su.res), su.current().get(s.a()));
/*     */         }
/* 227 */         for (ADSupplies.ADArtillery art : AD.supplies().arts()) {
/* 228 */           spec.artillery[art.index()] = spec.artillery[art.index()] + art.current(s.a());
/*     */         }
/*     */       } 
/*     */     } 
/* 232 */     SETT.INVADOR().invade(spec, ((Side.SideUnit)winner.us.get(0)).a());
/*     */     
/* 234 */     for (Side.SideUnit u : winner.us) {
/* 235 */       if (u.a() != null) {
/* 236 */         u.a().disband();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static int artillery(ADSupplies.ADArtillery a, Side s) {
/* 244 */     int am = 0;
/* 245 */     for (Side.SideUnit u : s.us) {
/* 246 */       if (u.a() != null) {
/* 247 */         am += a.current(u.a());
/*     */       }
/*     */     } 
/* 250 */     return am;
/*     */   }
/*     */   
/*     */   private static double morale(Side s) {
/* 254 */     double d = 0.0D;
/* 255 */     double pop = 0.0D;
/*     */     
/* 257 */     for (Side.SideUnit u : s.us) {
/* 258 */       if (u.a() != null) {
/* 259 */         pop = AD.men(null).get(u.a());
/* 260 */         d += AD.morale(u.a()) * AD.men(null).get(u.a());
/*     */       } 
/*     */     } 
/* 263 */     if (pop == 0.0D)
/* 264 */       return 1.0D; 
/* 265 */     return d / pop;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private class Spec
/*     */     extends WBattleSpec
/*     */   {
/*     */     private ResolverSide pp;
/*     */ 
/*     */     
/*     */     private ResolverSide ee;
/*     */ 
/*     */     
/*     */     void init(ResolverSide pp, ResolverSide ee) {
/* 280 */       this.pp = pp;
/* 281 */       this.ee = ee;
/* 282 */       this.player = pp;
/* 283 */       this.enemy = ee;
/* 284 */       this.victory = (pp.powerBalance > ee.powerBalance);
/*     */     }
/*     */ 
/*     */     
/*     */     public void retreat() {
/* 289 */       ResolverPlayer.this.tmp.clear();
/* 290 */       final double losses = Resolver.retreatValue(this.pp);
/* 291 */       ((ResolverSide.ResolverUnit)this.pp.us.get(0)).count(ResolverPlayer.this.tmp.clear(), losses, false);
/* 292 */       ResolverPlayer.Res rr = new ResolverPlayer.Res(this.pp, this.ee, BATTLE_RESULT.RETREAT, ResolverPlayer.this.tmp)
/*     */         {
/*     */           public void accept(int[] enslave, int[] resources)
/*     */           {
/* 296 */             BattleListener.notify(ResolverPlayer.Spec.this.ee, ResolverPlayer.Spec.this.pp);
/* 297 */             shipRetreat(enslave, resources);
/* 298 */             if (ResolverPlayer.Spec.this.pp.retreatCoo.x() >= 0 && ((Side.SideUnit)ResolverPlayer.Spec.this.pp.side.us.get(0)).a() != null) {
/* 299 */               ((Side.SideUnit)ResolverPlayer.Spec.this.pp.side.us.get(0)).a().teleport(ResolverPlayer.Spec.this.pp.retreatCoo.x(), ResolverPlayer.Spec.this.pp.retreatCoo.y());
/*     */             }
/* 301 */             ResolverPlayer.Spec.this.pp.extract(losses);
/*     */           }
/*     */         };
/*     */       
/* 305 */       (VIEW.world()).UI.battle.result(rr, false);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void engage() {}
/*     */ 
/*     */ 
/*     */     
/*     */     public void auto() {
/* 315 */       ResolverPlayer.this.tmp.clear();
/* 316 */       this.pp.clear().count(ResolverPlayer.this.cPlayer.clear(), Resolver.autoValue(this.pp), false);
/* 317 */       this.ee.clear().count(ResolverPlayer.this.cEnemy.clear(), Resolver.autoValue(this.ee), false);
/*     */       
/* 319 */       final BATTLE_RESULT res = (this.pp.powerBalance > this.ee.powerBalance) ? BATTLE_RESULT.VICTORY : BATTLE_RESULT.DEFEAT;
/*     */       
/* 321 */       ResolverPlayer.Res rr = new ResolverPlayer.Res(this.pp, this.ee, res, (res == BATTLE_RESULT.VICTORY) ? ResolverPlayer.this.cEnemy : ResolverPlayer.this.cPlayer)
/*     */         {
/*     */           public void accept(int[] enslave, int[] resources)
/*     */           {
/* 325 */             BattleListener.notify((res == BATTLE_RESULT.VICTORY) ? ResolverPlayer.Spec.this.pp : ResolverPlayer.Spec.this.ee, (res == BATTLE_RESULT.VICTORY) ? ResolverPlayer.Spec.this.ee : ResolverPlayer.Spec.this.pp);
/* 326 */             shipRetreat(enslave, resources);
/*     */             
/* 328 */             ResolverPlayer.Spec.this.pp.clear().extract(Resolver.autoValue(ResolverPlayer.Spec.this.pp));
/* 329 */             ResolverPlayer.Spec.this.ee.clear().extract(Resolver.autoValue(ResolverPlayer.Spec.this.ee));
/*     */           }
/*     */         };
/*     */       
/* 333 */       (VIEW.world()).UI.battle.result(rr, false);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static final class Manual
/*     */   {
/*     */     private final Side savedPlayer;
/*     */     
/*     */     private final Side savedEnemy;
/*     */ 
/*     */     
/*     */     Manual(Side player, Side enemy) {
/* 347 */       this.savedPlayer = player.copy();
/* 348 */       this.savedEnemy = enemy.copy();
/* 349 */       BattleStateExiter res = new BattleStateExiter()
/*     */         {
/*     */           public void afterExit(BattleStateResult res)
/*     */           {
/* 353 */             ResolverPlayer.Manual.this.afterBattle(res);
/*     */           }
/*     */         };
/*     */       
/* 357 */       BattleState.setGenerate(res, new BattleSpecc(player, enemy));
/*     */     }
/*     */ 
/*     */     
/*     */     void afterBattle(final BattleStateResult res) {
/* 362 */       ResolverSide.RCount ecount = new ResolverSide.RCount();
/* 363 */       ResolverSide.RCount pcount = new ResolverSide.RCount();
/*     */       
/* 365 */       final ResolverSide ee = new ResolverSide();
/* 366 */       ee.init(this.savedEnemy, 0.0D);
/* 367 */       final ResolverSide pp = new ResolverSide();
/* 368 */       pp.init(this.savedPlayer, 0.0D);
/*     */ 
/*     */ 
/*     */       
/* 372 */       if (res.result == BATTLE_RESULT.VICTORY && ((ResolverSide.ResolverUnit)ee.us.get(0)).unit.a() != null) {
/* 373 */         COORDINATE c = Util.retTile(((ResolverSide.ResolverUnit)ee.us.get(0)).unit.a());
/* 374 */         if (c != null) {
/* 375 */           ee.retreatCoo.set(c);
/*     */         } else {
/* 377 */           Arrays.fill(res.enemySurvivors, 0);
/*     */         } 
/* 379 */       } else if (res.result != BATTLE_RESULT.VICTORY && ((ResolverSide.ResolverUnit)pp.us.get(0)).unit.a() != null) {
/* 380 */         COORDINATE c = Util.retTile(((ResolverSide.ResolverUnit)pp.us.get(0)).unit.a());
/* 381 */         if (c != null) {
/* 382 */           ee.retreatCoo.set(c);
/*     */         } else {
/* 384 */           for (int k = 0; k < res.playerSurvivors.length; k++) {
/* 385 */             res.playerSurvivors[k] = new settlement.stats.Induvidual[0];
/*     */           }
/*     */         } 
/*     */       } 
/*     */       
/* 390 */       int[] losses = Alloc.ii((Config.battle()).DIVISIONS_PER_ARMY);
/* 391 */       for (int i = 0; i < this.savedEnemy.divs(); i++) {
/* 392 */         losses[this.savedEnemy.ui(i)] = losses[this.savedEnemy.ui(i)] + this.savedEnemy.div(i).men() - res.enemySurvivors[i];
/*     */       }
/*     */       
/* 395 */       for (int j = 0; j < this.savedEnemy.us.size(); j++) {
/* 396 */         ((ResolverSide.ResolverUnit)ee.us.get(j)).count(ecount, losses[j], false);
/*     */       }
/*     */ 
/*     */       
/* 400 */       Arrays.fill(losses, 0);
/* 401 */       for (int di = 0; di < this.savedPlayer.divs(); di++) {
/* 402 */         if (this.savedPlayer.div(di) != null) {
/* 403 */           losses[this.savedPlayer.ui(di)] = losses[this.savedPlayer.ui(di)] + this.savedPlayer.div(di).men() - (res.playerSurvivors[di]).length;
/*     */         }
/*     */       } 
/* 406 */       for (int ui = 0; ui < this.savedPlayer.us.size(); ui++) {
/* 407 */         ((ResolverSide.ResolverUnit)pp.us.get(ui)).count(pcount, losses[ui], false);
/*     */       }
/*     */ 
/*     */       
/* 411 */       WBattleResult rr = new ResolverPlayer.Res(pp, ee, res.result, (res.result == BATTLE_RESULT.VICTORY) ? ecount : pcount)
/*     */         {
/*     */           public void accept(int[] enslave, int[] resources)
/*     */           {
/* 415 */             BattleListener.notify((res.result == BATTLE_RESULT.VICTORY) ? pp : ee, (res.result == BATTLE_RESULT.VICTORY) ? ee : pp);
/* 416 */             shipRetreat(enslave, resources);
/*     */             int i;
/* 418 */             for (i = 0; i < ResolverPlayer.Manual.this.savedEnemy.divs(); i++) {
/* 419 */               WDIV d = ResolverPlayer.Manual.this.savedEnemy.div(i);
/* 420 */               d.resolve(res.enemySurvivors[i]);
/*     */             } 
/*     */             
/* 423 */             for (i = 0; i < ResolverPlayer.Manual.this.savedPlayer.divs(); i++) {
/* 424 */               WDIV d = ResolverPlayer.Manual.this.savedPlayer.div(i);
/* 425 */               if (d != null) {
/* 426 */                 d.resolve(res.playerSurvivors[i]);
/*     */               }
/*     */             } 
/*     */           }
/*     */         };
/*     */ 
/*     */ 
/*     */       
/* 434 */       (VIEW.world()).UI.battle.result(rr, false);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private class BattleSpecc
/*     */       extends BattleStateSpec
/*     */     {
/*     */       BattleSpecc(Side player, Side enemy) {
/* 443 */         set(player, this.player);
/* 444 */         set(enemy, this.enemy);
/*     */       }
/*     */       
/*     */       private void set(Side side, BattleStateSpec.SpecSide spec) {
/* 448 */         spec.wCoo.set(((Side.SideUnit)side.us.get(0)).x(), ((Side.SideUnit)side.us.get(0)).y());
/* 449 */         for (int i = 0; i < AD.supplies().arts().size(); i++) {
/* 450 */           spec.artillery[i] = ResolverPlayer.artillery((ADSupplies.ADArtillery)AD.supplies().arts().get(i), side);
/*     */         }
/* 452 */         spec.moraleBase = ResolverPlayer.morale(side);
/*     */         
/* 454 */         for (int di = 0; di < side.divs(); di++) {
/* 455 */           spec.divs.add(side.div(di).generate());
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static abstract class Res
/*     */     extends WBattleResult
/*     */   {
/*     */     private final ResolverSide pp;
/*     */     
/*     */     private final ResolverSide ee;
/*     */ 
/*     */     
/*     */     Res(ResolverSide pp, ResolverSide ee, BATTLE_RESULT res, ResolverSide.RCount ecount) {
/* 472 */       this(pp, ee, res, ecount, 1.0D);
/*     */     }
/*     */     
/*     */     Res(ResolverSide pp, ResolverSide ee, BATTLE_RESULT res, ResolverSide.RCount ecount, double spoilV) {
/* 476 */       this.pp = pp;
/* 477 */       this.ee = ee;
/* 478 */       this.player = pp;
/* 479 */       this.enemy = ee;
/* 480 */       this.result = res;
/* 481 */       this.capturedRaces = ecount.dead;
/* 482 */       this.lostResources = ecount.res; int i;
/* 483 */       for (i = 0; i < ecount.dead.length; i++) {
/* 484 */         this.capturedRaces[i] = (int)(ecount.dead[i] * 0.2D * spoilV);
/*     */       }
/* 486 */       for (i = 0; i < ecount.res.length; i++) {
/* 487 */         this.lostResources[i] = (int)(ecount.res[i] * 0.4D * spoilV);
/*     */       }
/*     */     }
/*     */     
/*     */     void shipRetreat(int[] enslave, int[] resources) {
/* 492 */       ResolverSide looser = this.ee;
/*     */       
/* 494 */       if (this.result == BATTLE_RESULT.VICTORY) {
/* 495 */         Util.ship(this.pp.side, this.ee.side, enslave, resources);
/*     */       } else {
/* 497 */         Util.ship(this.ee.side, this.pp.side, this.capturedRaces, this.lostResources);
/* 498 */         looser = this.pp;
/*     */       } 
/*     */       
/* 501 */       if (looser.retreatCoo.x() >= 0) {
/* 502 */         ((ResolverSide.ResolverUnit)looser.us.get(0)).unit.a().teleport(looser.retreatCoo.x(), looser.retreatCoo.y());
/*     */       }
/*     */       
/* 505 */       stop(this.pp.side);
/* 506 */       stop(this.ee.side);
/*     */     }
/*     */ 
/*     */     
/*     */     private void stop(Side toSide) {
/* 511 */       for (Side.SideUnit u : toSide.us) {
/* 512 */         if (u.a() != null && u.a().besieging() == null) {
/* 513 */           u.a().stop();
/*     */         }
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   private static class Conquer
/*     */     extends WBattleSiege.Result
/*     */   {
/*     */     Side player;
/*     */     Side enemy;
/*     */     
/*     */     void init(Region reg, Side player, Side enemy) {
/* 526 */       this.player = player;
/* 527 */       this.besiged = reg;
/* 528 */       this.enemy = enemy;
/*     */     }
/*     */ 
/*     */     
/*     */     public void occupy(double devastation, double death, int[] enslave, int[] resources) {
/* 533 */       Util.ship(this.player, this.enemy, enslave, resources);
/* 534 */       Util.conquer(this.player, devastation, death, this.besiged, (Faction)FACTIONS.player());
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void abandon(double devastation, double death, int[] enslave, int[] resources) {
/* 540 */       Util.ship(this.player, this.enemy, enslave, resources);
/* 541 */       Util.conquer(this.player, devastation, death, this.besiged, null);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void puppet(double devastation, double death, int[] enslave, int[] resources) {
/* 548 */       Util.ship(this.player, this.enemy, enslave, resources);
/* 549 */       Util.conquer(this.player, devastation, death, this.besiged, null);
/*     */       
/* 551 */       FactionNPC f = FACTIONS.activateNext(this.besiged, null, true);
/* 552 */       f.generate(RD.RACES().get(FACTIONS.player().race()), true);
/* 553 */       ROPINION.OTHER().liberate(f);
/* 554 */       DIP.VASSAL().set((Faction)f, (Faction)FACTIONS.player());
/* 555 */       (GAME.events()).world.dip.dismissWelcome(f);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\battle\ResolverPlayer.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */