/*     */ package settlement.battle.invasion;
/*     */ import game.GAME;
/*     */ import game.battle.state.BattleStateExiter;
/*     */ import game.battle.state.BattleStateResult;
/*     */ import game.battle.state.BattleStateSpec;
/*     */ import game.battle.util.DivGeneration;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.FResources;
/*     */ import game.faction.Faction;
/*     */ import game.time.TIME;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.STOCKPILE;
/*     */ import init.sprite.UI.UI;
/*     */ import init.trade.TR;
/*     */ import init.trade.TRADABLE;
/*     */ import init.trade.TRADE_TYPE;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.equip.EquipBattle;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.Bitmap1D;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.GUTIL;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GRows;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import view.main.VIEW;
/*     */ import view.ui.message.MessageSection;
/*     */ import view.ui.message.MessageText;
/*     */ import world.WORLD;
/*     */ import world.army.AD;
/*     */ import world.army.WDIV;
/*     */ import world.battle.spec.BATTLE_RESULT;
/*     */ import world.entity.army.WArmy;
/*     */ import world.region.RD;
/*     */ 
/*     */ final class Attack extends BattleStateExiter {
/*  54 */   private static CharSequence ¤¤vTitle = "¤Victory";
/*  55 */   private static CharSequence ¤¤vBody = "¤The enemy is beaten. Rejoice! Spoils from the battlefield will soon arrive. Do you wish to accept the captives, or should we 'release' them my lord?.";
/*     */   
/*  57 */   private static CharSequence ¤¤dTitle = "¤Defeat";
/*  58 */   private static CharSequence ¤¤dBody = "¤You have lost! Our men have thrown away their lives in vain. The enemy will be be at our gates at any moment! We must pray for mercy."; private final int ref;
/*     */   
/*     */   static {
/*  61 */     D.ts(Attack.class);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Attack(InvasionSpec invasion) {
/*  67 */     this.ref = invasion.ref;
/*     */     
/*  69 */     BattleStateSpec s = new BattleStateSpec();
/*     */     
/*  71 */     s.player.wCoo.set(FACTIONS.player().capitolRegion().cx(), FACTIONS.player().capitolRegion().cy());
/*  72 */     s.player.moraleBase = 1.0D;
/*  73 */     for (WDIV d : RD.MILITARY().divisions(FACTIONS.player().capitolRegion())) {
/*  74 */       s.player.divs.add(d.generate());
/*     */     }
/*  76 */     for (WArmy a : armies()) {
/*  77 */       for (int di = 0; di < a.divs().size(); di++) {
/*  78 */         if (s.player.divs.hasRoom()) {
/*  79 */           s.player.divs.add(a.divs().get(di).generate());
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  84 */     for (DivGeneration g : invasion.divs) {
/*  85 */       s.enemy.divs.add(g);
/*     */     }
/*     */     
/*  88 */     for (int i = 0; i < invasion.artillery.length; i++) {
/*  89 */       s.enemy.artillery[i] = invasion.artillery[i];
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  95 */     BattleState.setGenerate(this, s);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void afterExit(BattleStateResult result) {
/* 104 */     InvasionSpec invasion = SETT.INVADOR().spec(this.ref);
/* 105 */     AD.stats().report((Faction)FACTIONS.player(), (result.result == BATTLE_RESULT.VICTORY), result.playerLosses, result.enemyLosses);
/*     */ 
/*     */     
/* 108 */     if (result.result == BATTLE_RESULT.VICTORY) {
/*     */       
/* 110 */       int di = 0;
/*     */ 
/*     */ 
/*     */       
/* 114 */       int[] ress = Alloc.ii(TR.ALL().size());
/*     */ 
/*     */       
/* 117 */       double tot = 0.0D;
/* 118 */       double death = 0.0D;
/*     */       
/* 120 */       for (DivGeneration s : invasion.divs) {
/* 121 */         tot += s.indus.length;
/* 122 */         death += (s.indus.length - result.enemySurvivors[di] - result.enemyCaptured[di]);
/*     */       } 
/* 124 */       double d = death / (1.0D + tot);
/* 125 */       d *= 0.25D;
/*     */       
/* 127 */       for (DivGeneration s : invasion.divs) {
/* 128 */         for (int i = 0; i < s.indus.length; i++) {
/* 129 */           for (int ei = 0; ei < STATS.EQUIP().BATTLE_ALL().size(); ei++) {
/* 130 */             EquipBattle e = (EquipBattle)STATS.EQUIP().BATTLE_ALL().get(ei);
/* 131 */             invasion.loot.add((TRADABLE)TR.get(e.resource), e.get(s.indus[i]));
/*     */           } 
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 142 */       for (TRADABLE res : TR.ALL()) {
/*     */         
/* 144 */         int am = (int)Math.ceil(d * invasion.loot.get(res));
/* 145 */         ress[res.index()] = am;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 150 */       for (Race r : RACES.all()) {
/* 151 */         int am = result.enemyCaptured[r.index()];
/* 152 */         ress[TR.get(r).index()] = am;
/*     */       } 
/* 154 */       invasion.canBeAttacked = false;
/*     */       
/* 156 */       (new MVictory2(ress)).send();
/*     */       
/* 158 */       for (InvasionListener ll : InvasionListener.all) {
/* 159 */         ll.victory(result.playerLosses, result.enemyLosses, invasion.ref);
/*     */       }
/*     */       
/* 162 */       (GAME.count()).INVASIONS_WON.inc(1);
/*     */     } else {
/*     */       
/* 165 */       STOCKPILE.StockpileImp stock = new STOCKPILE.StockpileImp();
/* 166 */       ArrayList<DivGeneration> nnew = new ArrayList(invasion.divs.size());
/*     */       
/* 168 */       int di = 0;
/* 169 */       for (DivGeneration s : invasion.divs) {
/* 170 */         s.setMen(result.enemySurvivors[di++]);
/* 171 */         if (s.indus.length > 0) {
/* 172 */           nnew.add(s);
/*     */         }
/*     */       } 
/* 175 */       di = 0;
/* 176 */       for (WDIV d : RD.MILITARY().divisions(FACTIONS.player().capitolRegion())) {
/* 177 */         for (EquipBattle e : STATS.EQUIP().BATTLE_ALL()) {
/* 178 */           double dd = (d.men() - (result.playerSurvivors[di]).length) / d.men();
/* 179 */           stock.inc(e.resource, (int)Math.ceil((d.equipI(e) * d.men()) * dd));
/*     */         } 
/* 181 */         di++;
/*     */       } 
/*     */       
/* 184 */       RESOURCE.remove(stock, FResources.RTYPE.SPOILS);
/*     */       
/* 186 */       (new MessageText(¤¤dTitle)).paragraph((CharSequence)Str.TMP.clear().add(¤¤dBody)).send();
/*     */       
/* 188 */       invasion.add((LIST<DivGeneration>)nnew);
/* 189 */       (GAME.count()).INVASIONS_LOST.inc(1);
/*     */     } 
/*     */ 
/*     */     
/* 193 */     int ddi = 0;
/* 194 */     for (WDIV d : RD.MILITARY().divisions(FACTIONS.player().capitolRegion())) {
/* 195 */       d.resolve(result.playerSurvivors[ddi++]);
/*     */     }
/* 197 */     for (WArmy a : armies()) {
/* 198 */       for (int di = 0; di < a.divs().size(); di++) {
/* 199 */         if (ddi < result.playerSurvivors.length) {
/* 200 */           a.divs().get(di).resolve(result.playerSurvivors[ddi++]);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private LIST<WArmy> armies() {
/* 209 */     LinkedList<WArmy> armies = new LinkedList();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 217 */     GUTIL.flooder().init(this);
/* 218 */     GUTIL.flooder().pushSloppy(FACTIONS.player().cx(), FACTIONS.player().cy(), 0.0D);
/*     */     
/* 220 */     while (GUTIL.flooder().hasMore()) {
/* 221 */       PathTile t = GUTIL.flooder().pollSmallest();
/*     */       
/* 223 */       if (t.getValue() > WArmy.reinforceTiles) {
/*     */         break;
/*     */       }
/* 226 */       for (WArmy ar : (WORLD.ENTITIES()).armies.fillTile(t.x(), t.y())) {
/* 227 */         if ((ar != null && AD.men(null).get(ar) == 0) || ar.faction() != FACTIONS.player())
/*     */           continue; 
/* 229 */         if (armies.contains(ar))
/*     */           continue; 
/* 231 */         armies.add(ar);
/*     */       } 
/*     */       
/* 234 */       for (int di = 0; di < DIR.ALL.size(); di++) {
/* 235 */         DIR d = (DIR)DIR.ALL.get(di);
/* 236 */         if ((WORLD.PATH()).map.can((COORDINATE)t, d))
/* 237 */           GUTIL.flooder().pushSmaller((COORDINATE)t, d, t.getValue() + d.tileDistance()); 
/*     */       } 
/*     */     } 
/* 240 */     GUTIL.flooder().done();
/* 241 */     return (LIST<WArmy>)armies;
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
/*     */   private static class MVictory2
/*     */     extends MessageSection
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final int[] res;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 301 */     private final double time = TIME.currentSecond();
/*     */     private boolean accepted = false;
/*     */     
/*     */     public MVictory2(int[] res) {
/* 305 */       super(Attack.¤¤vTitle);
/* 306 */       this.res = res;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void make(GuiSection section) {
/* 312 */       String st = String.valueOf(Str.TMP.clear().add(Attack.¤¤vBody));
/*     */       
/* 314 */       section.addDown(8, (SPRITE)(new GText((UI.FONT()).M, st)).setMaxWidth(900));
/*     */ 
/*     */ 
/*     */       
/* 318 */       final Bitmap1D selected = new Bitmap1D(TR.ALL().size(), false);
/* 319 */       selected.setAll(true);
/*     */       
/* 321 */       GRows rr = new GRows(4);
/*     */ 
/*     */       
/* 324 */       for (TRADABLE r : TR.ALL()) {
/* 325 */         if (r.index() >= this.res.length || this.res[r.index()] <= 0) {
/*     */           continue;
/*     */         }
/* 328 */         GuiSection ss = new GuiSection()
/*     */           {
/*     */             public void hoverInfoGet(GUI_BOX text)
/*     */             {
/* 332 */               text.title(r.name);
/*     */             }
/*     */           };
/*     */ 
/*     */         
/* 337 */         ss.add((RENDEROBJ)new GButt.Checkbox()
/*     */             {
/*     */               protected void clickA() {
/* 340 */                 selected.toggle(r.index());
/*     */               }
/*     */ 
/*     */               
/*     */               protected void renAction() {
/* 345 */                 selectedSet(selected.get(r.index()));
/*     */               }
/*     */             });
/*     */         
/* 349 */         ss.addRightC(2, r.icon());
/* 350 */         ss.addRightCAbs(40, (SPRITE)new GStat()
/*     */             {
/*     */               public void update(GText text)
/*     */               {
/* 354 */                 GFORMAT.i(text, Attack.MVictory2.this.res[r.index()]);
/*     */               }
/*     */             });
/*     */         
/* 358 */         ss.body().incrW(48.0D);
/* 359 */         rr.add((RENDEROBJ)ss);
/*     */       } 
/*     */       
/* 362 */       boolean f = true;
/* 363 */       for (RENDEROBJ o : rr.rows()) {
/* 364 */         section.addRelBody(f ? 16 : 2, DIR.S, o);
/* 365 */         f = false;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 370 */       section.addRelBody(8, DIR.S, (RENDEROBJ)new GButt.ButtPanel(Dic.¤¤Accept)
/*     */           {
/*     */             protected void clickA() {
/* 373 */               if (TIME.currentSecond() - Attack.MVictory2.this.time < TIME.secondsPerDay() && !Attack.MVictory2.this.accepted) {
/* 374 */                 Attack.MVictory2.this.accepted = true;
/* 375 */                 for (TRADABLE r : TR.ALL()) {
/* 376 */                   int am = Attack.MVictory2.this.res[r.index()];
/* 377 */                   if (am > 0 && selected.get(r.index())) {
/* 378 */                     FACTIONS.player().buyer(r).addReserveAndDeliver(am, TRADE_TYPE.spoils);
/*     */                   }
/*     */                 } 
/* 381 */                 (VIEW.inters()).messages.hide();
/*     */               } 
/* 383 */               super.clickA();
/*     */             }
/*     */ 
/*     */             
/*     */             protected void renAction() {
/* 388 */               activeSet((TIME.currentSecond() - Attack.MVictory2.this.time < TIME.secondsPerDay() && !Attack.MVictory2.this.accepted));
/*     */             }
/*     */           });
/*     */       
/* 392 */       section.addRelBody(8, DIR.S, (RENDEROBJ)new GButt.ButtPanel(Dic.¤¤Decline)
/*     */           {
/*     */             protected void clickA() {
/* 395 */               if (TIME.currentSecond() - Attack.MVictory2.this.time < TIME.secondsPerDay() && !Attack.MVictory2.this.accepted) {
/* 396 */                 Attack.MVictory2.this.accepted = true;
/* 397 */                 (VIEW.inters()).messages.hide();
/*     */               } 
/* 399 */               super.clickA();
/*     */             }
/*     */ 
/*     */             
/*     */             protected void renAction() {
/* 404 */               activeSet((TIME.currentSecond() - Attack.MVictory2.this.time < TIME.secondsPerDay() && !Attack.MVictory2.this.accepted));
/*     */             }
/*     */           });
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\battle\invasion\Attack.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */