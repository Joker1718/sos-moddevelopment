/*     */ package settlement.battle.invasion;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.div.Div;
/*     */ import game.battle.util.DivGeneration;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.FCredits;
/*     */ import game.faction.FResources;
/*     */ import game.faction.Faction;
/*     */ import game.faction.diplomacy.DIP;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.royalty.opinion.ROPINION;
/*     */ import game.time.TIME;
/*     */ import init.constant.Config;
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import init.type.CAUSE_LEAVES;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.HTYPES;
/*     */ import java.io.IOException;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.throne.THRONE;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.colls.StatsPopulation;
/*     */ import settlement.stats.equip.Equip;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.misc.IntChecker;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayListShort;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import view.main.VIEW;
/*     */ import view.ui.message.MessageText;
/*     */ import world.army.AD;
/*     */ 
/*     */ final class Invasion
/*     */ {
/*  46 */   private static CharSequence ¤¤Bombardment = "¤Bombardment";
/*  47 */   private static CharSequence ¤¤BombardmentD = "¤The enemy has started bombarding us to clear a path. There is nothing we can do but take cover until they are done.";
/*     */   
/*  49 */   private static CharSequence ¤¤Deployment = "¤Deployment";
/*  50 */   private static CharSequence ¤¤DeploymentD = "¤The enemy are deploying their troops. May the gods help us! Quickly enable the battle view and counter them. They must not reach the throne!";
/*     */   
/*  52 */   private static CharSequence ¤¤Retreat = "¤Retreat!";
/*  53 */   private static CharSequence ¤¤RetreatD = "¤Enemy forces are weary of fighting and have retreated!";
/*     */   
/*  55 */   private static CharSequence ¤¤LooseD = "¤It's over! The enemy forces have reached the throne, and have taken control of the city. They have sacked your treasury for {0} {1}, and collected {2}% of your warehouse stock.";
/*  56 */   private static CharSequence ¤¤LooseDFaction = "¤The faction of {0} sends its regards. Now that you've bent the knee, they hope you've learned your lesson, and you are now at peace.";
/*  57 */   private static CharSequence ¤¤Victory = "¤Our men have prevailed and our foe is beaten. Rejoice! The {0} survivors can be turned into prisoners, and need a stockade to stay in. Do you accept them? Declining will have the remaining enemies chased down and killed."; public final InvasionSpec spec;
/*     */   
/*     */   static {
/*  60 */     D.ts(Invasion.class);
/*     */   }
/*     */ 
/*     */   
/*  64 */   private STATE state = null;
/*     */   private int artillery;
/*  66 */   private double timer = 0.0D;
/*     */   final SpotMaker.InvasionSpot spot;
/*  68 */   private ArrayListShort activeDivs = new ArrayListShort((Config.battle()).DIVISIONS_PER_ARMY);
/*     */   public boolean victory;
/*  70 */   private static final IntChecker check = new IntChecker((Config.battle()).DIVISIONS_PER_BATTLE);
/*     */   private final int eDeaths;
/*     */   private final int pLosses;
/*     */   
/*     */   private enum STATE
/*     */   {
/*  76 */     WARNING,
/*  77 */     BOMBARD_TEST,
/*  78 */     BOMBARD,
/*  79 */     PLACEART,
/*  80 */     DEPLOYING,
/*  81 */     FIGHTING,
/*  82 */     WAIT_FOR_REPLY,
/*  83 */     DONE;
/*     */   }
/*     */   
/*     */   Invasion(FileGetter f) throws IOException {
/*  87 */     this.spec = new InvasionSpec(f);
/*  88 */     this.artillery = f.i();
/*  89 */     this.state = STATE.values()[f.i()];
/*  90 */     this.timer = f.d();
/*  91 */     this.spot = new SpotMaker.InvasionSpot(f);
/*  92 */     this.activeDivs.load(f);
/*  93 */     this.victory = f.bool();
/*  94 */     this.eDeaths = f.i();
/*  95 */     this.pLosses = f.i();
/*     */   }
/*     */   
/*     */   public void save(FilePutter file) {
/*  99 */     this.spec.save(file);
/* 100 */     file.i(this.artillery);
/* 101 */     file.i(this.state.ordinal());
/* 102 */     file.d(this.timer);
/* 103 */     this.spot.save(file);
/* 104 */     this.activeDivs.save(file);
/* 105 */     file.bool(this.victory);
/* 106 */     file.i(this.eDeaths);
/* 107 */     file.i(this.pLosses);
/*     */   }
/*     */ 
/*     */   
/*     */   Invasion(InvasionSpec spec) {
/* 112 */     this.eDeaths = ((StatsPopulation.StatsDeath.PopData)(STATS.POP()).COUNT.leaves().get(CAUSE_LEAVES.SLAYED().index())).statistics(HCLASSES.OTHER()).get(null);
/* 113 */     this.pLosses = ((StatsPopulation.StatsDeath.PopData)(STATS.POP()).COUNT.leaves().get(CAUSE_LEAVES.SLAYED().index())).statistics(HCLASSES.CITIZEN()).get(null);
/* 114 */     this.spec = spec;
/*     */     
/* 116 */     FactionNPC f = (spec.fi < 0) ? null : (FactionNPC)FACTIONS.getByIndex(spec.fi);
/*     */     
/* 118 */     if (f != null) {
/* 119 */       FACTIONS.otherFactionSet(f);
/* 120 */     } else if (FACTIONS.NPCs().size() > 0) {
/* 121 */       FACTIONS.otherFactionSet((FactionNPC)FACTIONS.NPCs().rnd());
/*     */     } 
/*     */     
/* 124 */     int men = 0;
/*     */     
/* 126 */     for (DivGeneration d : spec.divs)
/* 127 */       men += d.indus.length; 
/* 128 */     if (men == 0) {
/* 129 */       GAME.Error("no men!");
/*     */     }
/* 131 */     this.artillery = (int)Math.ceil(men / 200.0D);
/*     */     
/* 133 */     this.spot = SpotMaker.get(men, spec.wx, spec.wy);
/*     */     
/* 135 */     this.state = STATE.WARNING;
/* 136 */     this.timer = 0.0D;
/*     */     
/* 138 */     (GAME.count()).INVASIONS.inc(1);
/*     */     
/* 140 */     (new Prompt(spec, this.spot.dir.perpendicular())).send();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean update(double ds) {
/* 147 */     this.timer += ds;
/*     */     
/* 149 */     if (this.spot.body.width() * this.spot.body.height() < 8) {
/* 150 */       GAME.Warn(String.valueOf(this.spot.body));
/* 151 */       for (InvasionListener li : InvasionListener.all)
/* 152 */         li.weirdness(this.spec.ref); 
/* 153 */       return false;
/*     */     } 
/* 155 */     switch (this.state) {
/*     */       case WARNING:
/* 157 */         if (!this.spec.canBeAttacked)
/* 158 */           return false; 
/* 159 */         if (this.timer > (TIME.secondsPerDay() / 8) && this.spot.launchProj()) {
/* 160 */           CharSequence title = ¤¤Bombardment;
/* 161 */           CharSequence text = ¤¤BombardmentD;
/* 162 */           (new MessageText(title, text)).send();
/* 163 */           (VIEW.s().getWindow()).centererTile.set(this.spot.body.cX(), this.spot.body.cY());
/* 164 */           this.state = STATE.BOMBARD;
/* 165 */           this.timer = 0.0D;
/* 166 */         } else if (this.timer > (TIME.secondsPerDay() / 2)) {
/* 167 */           launch();
/*     */         } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 231 */         return true;case null: if (!this.spec.canBeAttacked) return false;  this.timer += ds * this.artillery * 0.25D; while (this.timer >= 1.0D) { this.timer -= RND.rFloat(); if (!this.spot.launchProj()) { launch(); break; }  }  return true;case PLACEART: if (this.timer < 40.0D) return true;  deploy(); return true;case DEPLOYING: if (this.spec.divs.size() == 0) { this.timer = 0.0D; this.state = STATE.FIGHTING; } else { while (this.timer > 1.0D) { Div d = DivDeployer.deploy(this.spec.divs, this.spot); if (d != null) this.activeDivs.add(d.index());  this.timer--; if (this.spot.size < 8) this.activeDivs.clear();  }  }  return true;case FIGHTING: if (!fight()) { this.state = this.victory ? STATE.WAIT_FOR_REPLY : STATE.DONE; return true; }  if (this.timer > (TIME.secondsPerDay() * 5)) { this.state = STATE.DONE; remove(); CharSequence title = ¤¤Retreat; CharSequence text = ¤¤RetreatD; (new MessageText(title, text)).send(); for (InvasionListener ll : InvasionListener.all) ll.weirdness(this.spec.ref);  return false; }  return true;
/*     */       case WAIT_FOR_REPLY:
/*     */         return (STATS.POP().pop(HTYPES.ENEMY()) > 0);
/*     */     } 
/* 235 */     return false; } private void launch() { this.spec.canBeAttacked = false;
/* 236 */     deploy();
/* 237 */     this.timer = 0.0D;
/* 238 */     if (ArtilleryPlacer.placeArt((LIST<DivGeneration>)this.spec.divs, this.spot, this.artillery)) {
/* 239 */       this.state = STATE.PLACEART;
/*     */     }
/*     */     
/* 242 */     CharSequence title = ¤¤Deployment;
/* 243 */     CharSequence text = ¤¤DeploymentD;
/* 244 */     (VIEW.s().getWindow()).centererTile.set(this.spot.body.cX(), this.spot.body.cY());
/*     */     
/* 246 */     (new MessageText(title, text)).send(); }
/*     */ 
/*     */   
/*     */   private void deploy() {
/* 250 */     (GAME.ARMIES()).factors.init(GAME.ARMIES().enemy(), 1.0D);
/*     */     
/* 252 */     this.state = STATE.DEPLOYING;
/*     */   }
/*     */   void fastForward() {
/*     */     int ei;
/* 256 */     LOG.ln(this.state);
/*     */     
/* 258 */     switch (this.state) {
/*     */       case WARNING:
/* 260 */         if (!this.spec.canBeAttacked)
/*     */           return; 
/* 262 */         this.timer = (TIME.secondsPerDay() / 8);
/*     */       
/*     */       case null:
/* 265 */         launch();
/*     */       case PLACEART:
/* 267 */         this.timer = 40.0D;
/*     */       
/*     */       case DEPLOYING:
/*     */         return;
/*     */       case FIGHTING:
/* 272 */         for (ei = 0; ei < (SETT.ENTITIES().getAllEnts()).length; ei++) {
/* 273 */           ENTITY e = SETT.ENTITIES().getAllEnts()[ei];
/* 274 */           if (e instanceof Humanoid) {
/* 275 */             Humanoid h = (Humanoid)e;
/* 276 */             if (h.indu().hType().isHostile()) {
/* 277 */               h.kill(false, CAUSE_LEAVES.SLAYED());
/* 278 */               ei--;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       case WAIT_FOR_REPLY:
/*     */         return;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean fight() {
/* 294 */     for (int i = 0; i < this.activeDivs.size(); i++) {
/* 295 */       Div d = GAME.ARMIES().division((short)this.activeDivs.get(i));
/* 296 */       if (!d.active() && d.menNrOf() == 0) {
/* 297 */         this.activeDivs.remove(i);
/* 298 */         i--;
/*     */       } 
/*     */     } 
/*     */     
/* 302 */     if (this.activeDivs.size() == 0) {
/*     */       
/* 304 */       int am = 0; byte b; int j; ENTITY[] arrayOfENTITY;
/* 305 */       for (j = (arrayOfENTITY = SETT.ENTITIES().getAllEnts()).length, b = 0; b < j; ) { ENTITY e = arrayOfENTITY[b];
/* 306 */         if (e instanceof Humanoid) {
/* 307 */           Humanoid h = (Humanoid)e;
/* 308 */           if ((SETT.PATH()).reachability.is(h.tc()) && h.indu().hType() == HTYPES.ENEMY() && (STATS.BATTLE()).ROUTING.indu().get(h.indu()) != 0) {
/* 309 */             am++;
/* 310 */             for (Equip eq : STATS.EQUIP().allE()) {
/* 311 */               int eam = eq.get(h.indu());
/*     */               
/* 313 */               if (eam > 0) {
/* 314 */                 (SETT.THINGS()).resources.create(h.tc(), eq.resource, eam);
/* 315 */                 eq.set(h.indu(), 0);
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/*     */         b++; }
/*     */       
/* 322 */       String m = String.valueOf(Str.TMP.clear().add(¤¤Victory).insert(0, am));
/*     */       
/* 324 */       ACTION yes = new ACTION() { public void exe() {
/*     */             byte b;
/*     */             int i;
/*     */             ENTITY[] arrayOfENTITY;
/* 328 */             for (i = (arrayOfENTITY = SETT.ENTITIES().getAllEnts()).length, b = 0; b < i; ) { ENTITY e = arrayOfENTITY[b];
/* 329 */               if (e instanceof Humanoid) {
/* 330 */                 Humanoid h = (Humanoid)e;
/* 331 */                 if ((SETT.PATH()).reachability.is(h.tc()) && h.indu().hType() == HTYPES.ENEMY() && (STATS.BATTLE()).ROUTING.indu().get(h.indu()) != 0) {
/*     */ 
/*     */ 
/*     */                   
/* 335 */                   h.HTypeSet(HTYPES.PRISONER(), null, null);
/* 336 */                   (STATS.BATTLE()).ROUTING.indu().set(h.indu(), 0);
/*     */                 } 
/*     */               }  b++; }
/*     */             
/* 340 */             Invasion.this.state = Invasion.STATE.DONE;
/*     */           } }
/*     */         ;
/*     */       
/* 344 */       ACTION no = new ACTION()
/*     */         {
/*     */           
/*     */           public void exe()
/*     */           {
/* 349 */             Invasion.this.state = Invasion.STATE.DONE;
/*     */           }
/*     */         };
/* 352 */       (VIEW.inters()).yesNo.activate(m, yes, no, false);
/* 353 */       resolve(true);
/* 354 */       return false;
/* 355 */     }  if (GAME.ARMIES().enemy().men() > 0) {
/* 356 */       COORDINATE c = THRONE.coo();
/* 357 */       for (int x = c.x() - 1; x < c.x() + 2; x++) {
/* 358 */         for (int y = c.y() - 1; y < c.y() + 2; y++) {
/* 359 */           for (ENTITY e : SETT.ENTITIES().getAtTile(x, y)) {
/* 360 */             if (e instanceof Humanoid && (
/* 361 */               (Humanoid)e).indu().hType() == HTYPES.ENEMY() && ((Humanoid)e).division() != null) {
/* 362 */               this.victory = false;
/* 363 */               loose();
/* 364 */               resolve(false);
/* 365 */               return false;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 372 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private void resolve(boolean victory) {
/* 377 */     this.victory = victory;
/* 378 */     int eDeaths = ((StatsPopulation.StatsDeath.PopData)(STATS.POP()).COUNT.leaves().get(CAUSE_LEAVES.SLAYED().index())).statistics(HCLASSES.OTHER()).get(null) - this.eDeaths;
/* 379 */     int pLosses = ((StatsPopulation.StatsDeath.PopData)(STATS.POP()).COUNT.leaves().get(CAUSE_LEAVES.SLAYED().index())).statistics(HCLASSES.CITIZEN()).get(null) - this.pLosses;
/*     */     
/* 381 */     if (victory) {
/* 382 */       for (InvasionListener ll : InvasionListener.all) {
/* 383 */         ll.victory(pLosses, eDeaths, this.spec.ref);
/*     */       }
/* 385 */       (GAME.count()).INVASIONS_WON.inc(1);
/*     */     } else {
/* 387 */       for (InvasionListener ll : InvasionListener.all) {
/* 388 */         ll.defeat(pLosses, eDeaths, this.spec.ref);
/*     */       }
/* 390 */       (GAME.count()).INVASIONS_LOST.inc(1);
/*     */     } 
/*     */     
/* 393 */     AD.stats().report((Faction)FACTIONS.player(), victory, pLosses, eDeaths);
/*     */   }
/*     */ 
/*     */   
/*     */   private void remove() {
/* 398 */     check.init();
/* 399 */     for (int i = 0; i < this.activeDivs.size(); i++) {
/* 400 */       int di = this.activeDivs.get(i);
/* 401 */       check.isSetAndSet(di);
/*     */     }  byte b; int j;
/*     */     ENTITY[] arrayOfENTITY;
/* 404 */     for (j = (arrayOfENTITY = SETT.ENTITIES().getAllEnts()).length, b = 0; b < j; ) { ENTITY e = arrayOfENTITY[b];
/* 405 */       if (e instanceof Humanoid) {
/* 406 */         Humanoid h = (Humanoid)e;
/* 407 */         if (h.division() != null && check.isSet(h.division().index())) {
/* 408 */           h.helloMyNameIsInigoMontoyaYouKilledMyFatherPrepareToDie();
/*     */         }
/*     */       } 
/*     */       b++; }
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   private void loose() {
/* 417 */     double am = 0.25D + 0.05D * RND.rInt(6);
/*     */ 
/*     */     
/* 420 */     int creds = (FACTIONS.player().credits().credits() > 0.0D) ? (int)(FACTIONS.player().credits().credits() * 0.75D) : 0;
/* 421 */     FACTIONS.player().credits().inc(-creds, FCredits.CTYPE.MISC);
/*     */     
/* 423 */     CharSequence t1 = String.valueOf(Str.TMP.clear().add(¤¤LooseD).insert(0, creds).insert(1, Dic.¤¤Currs).insert(2, (int)Math.ceil(100.0D * am)));
/*     */     
/* 425 */     MessageText m = new MessageText(Dic.¤¤Defeat, t1);
/*     */     
/* 427 */     FactionNPC f = (this.spec.fi < 0) ? null : (FactionNPC)FACTIONS.getByIndex(this.spec.fi);
/*     */ 
/*     */     
/* 430 */     if (f != null && f.isActive()) {
/*     */ 
/*     */       
/* 433 */       m.paragraph((CharSequence)Str.TMP.clear().add(¤¤LooseDFaction).insert(0, (CharSequence)f.name));
/*     */       
/* 435 */       ROPINION.STANCE().setNewStance(f, DIP.VASSAL(), false);
/*     */     } 
/*     */ 
/*     */     
/* 439 */     remove();
/*     */     
/* 441 */     RESOURCE.remove(am, RBIT.ALL, FResources.RTYPE.SPOILS);
/*     */     
/* 443 */     m.send();
/*     */   }
/*     */   
/*     */   public Faction invador() {
/* 447 */     FactionNPC f = (this.spec.fi < 0) ? null : (FactionNPC)FACTIONS.getByIndex(this.spec.fi);
/*     */     
/* 449 */     if (f != null) {
/* 450 */       return (Faction)f;
/*     */     }
/* 452 */     return (Faction)FACTIONS.NPCs().get(1);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\battle\invasion\Invasion.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */