/*     */ package world.region;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.DivisionBanners;
/*     */ import game.battle.div.Div;
/*     */ import game.battle.util.DIV_SETTING;
/*     */ import game.battle.util.DIV_SPEC;
/*     */ import game.battle.util.DivGeneration;
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.FResources;
/*     */ import game.faction.Faction;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import init.constant.Config;
/*     */ import init.race.Race;
/*     */ import init.resources.RESOURCES;
/*     */ import init.type.CAUSE_LEAVES;
/*     */ import java.io.IOException;
/*     */ import java.util.Iterator;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.util.RESOURCE_TILE;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.colls.StatsBattle;
/*     */ import settlement.stats.equip.EquipBattle;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ import snake2d.util.sets.LIST;
/*     */ import util.text.Dic;
/*     */ import world.army.AD;
/*     */ import world.army.WDIV;
/*     */ import world.entity.army.WArmy;
/*     */ import world.map.regions.Region;
/*     */ import world.region.pop.RDRace;
/*     */ 
/*     */ 
/*     */ 
/*     */ final class RDMilitaryGar
/*     */ {
/*  52 */   private final ArrayList<WDiv> divs = new ArrayList(128);
/*  53 */   private final ArrayList<WDIV> res = new ArrayList(128);
/*  54 */   private Region lReg = null;
/*  55 */   private int upI = -1;
/*  56 */   private final WDivsCapitol cap = new WDivsCapitol();
/*     */   
/*     */   public RDMilitaryGar() {
/*  59 */     while (this.divs.hasRoom())
/*  60 */       this.divs.add(new WDiv()); 
/*     */   }
/*     */   
/*     */   public LIST<WDIV> player() {
/*  64 */     this.cap.init();
/*  65 */     return this.cap;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void init() {}
/*     */ 
/*     */   
/*     */   public LIST<WDIV> divisions(Region r, int garrisonA, int garrisonT) {
/*  74 */     if (FACTIONS.player().capitolRegion() == r) {
/*  75 */       this.cap.init();
/*  76 */       return this.cap;
/*     */     } 
/*     */     
/*  79 */     if (this.lReg == r && GAME.updateI() == this.upI) {
/*  80 */       return (LIST<WDIV>)this.res;
/*     */     }
/*     */     
/*  83 */     this.lReg = r;
/*  84 */     this.upI = GAME.updateI();
/*     */     
/*  86 */     this.res.clear();
/*  87 */     int soldiers = Math.max(garrisonA, garrisonT);
/*     */ 
/*     */ 
/*     */     
/*  91 */     if (soldiers == 0) {
/*  92 */       return (LIST<WDIV>)this.res;
/*     */     }
/*  94 */     double dv = garrisonA / soldiers;
/*  95 */     dv = CLAMP.d(dv, 0.0D, 1.0D);
/*     */     
/*  97 */     int realSoldiers = garrisonA;
/*  98 */     int solRemaining = soldiers;
/*     */     
/* 100 */     double tot = ((RD.RACES()).population.get(r) + 1);
/* 101 */     int i = 0;
/* 102 */     int remain = 0;
/* 103 */     for (int ri = 0; ri < (RD.RACES()).all.size(); ri++) {
/* 104 */       RDRace ra = (RDRace)(RD.RACES()).all.get(ri);
/* 105 */       int sols = (int)Math.ceil((soldiers * ra.pop.get(r)) / tot);
/* 106 */       if (sols > 50) {
/* 107 */         sols += remain;
/*     */       }
/* 109 */       if (sols > solRemaining) {
/* 110 */         sols = solRemaining;
/*     */       }
/* 112 */       while (sols > 50 && solRemaining > 0) {
/*     */         
/* 114 */         int m = CLAMP.i(sols, 0, (Config.battle()).MEN_PER_DIVISION);
/* 115 */         solRemaining -= m;
/* 116 */         sols -= m;
/* 117 */         WDiv d = (WDiv)this.divs.get(i);
/* 118 */         d.index = i++;
/* 119 */         d.f = (r.faction() == null) ? null : r.faction();
/* 120 */         int rs = (int)Math.ceil(m * dv);
/* 121 */         rs = CLAMP.i(rs, 0, realSoldiers);
/* 122 */         realSoldiers -= rs;
/* 123 */         d.men = rs;
/* 124 */         d.menTarget = m;
/* 125 */         d.race = ra.race;
/* 126 */         d.r = r;
/* 127 */         this.res.add(d);
/*     */       } 
/* 129 */       remain += sols;
/*     */     } 
/*     */     
/* 132 */     if (solRemaining > 0) {
/* 133 */       Race big = FACTIONS.player().race();
/* 134 */       int bb = 0;
/* 135 */       for (int j = 0; j < (RD.RACES()).all.size(); j++) {
/* 136 */         RDRace ra = (RDRace)(RD.RACES()).all.get(j);
/* 137 */         if (ra.pop.get(r) > bb) {
/* 138 */           big = ra.race;
/* 139 */           bb = ra.pop.get(r);
/*     */         } 
/*     */       } 
/* 142 */       while (solRemaining > 0) {
/* 143 */         int m = CLAMP.i(solRemaining, 0, (Config.battle()).MEN_PER_DIVISION);
/*     */         
/* 145 */         WDiv d = (WDiv)this.divs.get(i);
/* 146 */         d.index = i++;
/* 147 */         d.f = (r.faction() == null) ? null : r.faction();
/* 148 */         d.r = r;
/* 149 */         int rs = (int)Math.ceil(m * dv);
/* 150 */         rs = CLAMP.i(rs, 0, realSoldiers);
/* 151 */         realSoldiers -= rs;
/* 152 */         d.men = rs;
/* 153 */         d.menTarget = m;
/* 154 */         solRemaining -= m;
/* 155 */         d.race = big;
/* 156 */         this.res.add(d);
/*     */       } 
/*     */     } 
/*     */     
/* 160 */     return (LIST<WDIV>)this.res;
/*     */   }
/* 162 */   private static COLOR colr = (COLOR)COLOR.ORANGE100.makeSaturated(0.5D).shade(0.75D);
/*     */   
/*     */   private static class WDiv
/*     */     implements WDIV
/*     */   {
/*     */     Race race;
/*     */     int men;
/*     */     int menTarget;
/*     */     int index;
/*     */     Faction f;
/*     */     Region r;
/*     */     
/*     */     public int men() {
/* 175 */       return this.men;
/*     */     }
/*     */ 
/*     */     
/*     */     public Race race() {
/* 180 */       return this.race;
/*     */     }
/*     */ 
/*     */     
/*     */     public int menTarget() {
/* 185 */       return this.menTarget;
/*     */     }
/*     */ 
/*     */     
/*     */     public double experience() {
/* 190 */       return 0.1D;
/*     */     }
/*     */ 
/*     */     
/*     */     public void resolve(Induvidual[] hs) {
/* 195 */       menSet(hs.length);
/*     */     }
/*     */     
/*     */     public void resolve(int surviviors, double experiencePerMan) {
/* 199 */       menSet(surviviors);
/*     */     }
/*     */     
/*     */     void menSet(int amount) {
/* 203 */       (RD.MILITARY()).garrison.inc(this.r, -this.men);
/* 204 */       (RD.MILITARY()).garrison.inc(this.r, amount);
/* 205 */       this.men = amount;
/*     */     }
/*     */ 
/*     */     
/*     */     public int daysUntilMenArrives() {
/* 210 */       return 0;
/*     */     }
/*     */ 
/*     */     
/*     */     public CharSequence name() {
/* 215 */       return Dic.¤¤Garrison;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean needSupplies() {
/* 221 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public double training(StatsBattle.StatTraining tr) {
/* 226 */       if (this.f != null && this.f.capitolRegion() == this.r && this.f instanceof FactionNPC) {
/* 227 */         double d = 0.15D * (BOOSTABLES.NOBLE()).AGRESSION.get((BOOSTABLE_O)(((FactionNPC)this.f).court().king().roy()).induvidual);
/* 228 */         d = CLAMP.d(d, 0.0D, 1.0D);
/* 229 */         return d;
/*     */       } 
/* 231 */       return 0.15D;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public DivisionBanners.DivisionBanner banner() {
/* 237 */       return (GAME.ARMIES()).banners.get(this.index);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void bannerSet(int bi) {}
/*     */ 
/*     */ 
/*     */     
/*     */     public Faction faction() {
/* 247 */       return this.f;
/*     */     }
/*     */ 
/*     */     
/*     */     public DivGeneration generate() {
/* 252 */       return new DivGeneration((DIV_SPEC)this, this.target);
/*     */     }
/*     */ 
/*     */     
/*     */     public double equip(EquipBattle e) {
/* 257 */       return e.garrisonAmount() / e.equipMax;
/*     */     }
/*     */ 
/*     */     
/*     */     public int bannerI() {
/* 262 */       return this.index;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public WArmy army() {
/* 268 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public COLOR color() {
/* 273 */       return RDMilitaryGar.colr;
/*     */     }
/*     */     
/* 276 */     public final DIV_SETTING target = new DIV_SETTING()
/*     */       {
/*     */         public double training(StatsBattle.StatTraining tr)
/*     */         {
/* 280 */           return RDMilitaryGar.WDiv.this.training(tr);
/*     */         }
/*     */ 
/*     */         
/*     */         public double equip(EquipBattle e) {
/* 285 */           return RDMilitaryGar.WDiv.this.equip(e);
/*     */         }
/*     */ 
/*     */         
/*     */         public int men() {
/* 290 */           return RDMilitaryGar.WDiv.this.menTarget;
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/*     */     public DIV_SETTING target() {
/* 297 */       return this.target;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void extractLostEquipment(int[] amounts) {
/* 304 */     this.upI = -1;
/* 305 */     for (COORDINATE c : SETT.TILE_BOUNDS) {
/* 306 */       RoomInstance roomInstance = (SETT.ROOMS()).STOCKPILE.get(c.x(), c.y());
/* 307 */       if (roomInstance == null)
/*     */         continue; 
/* 309 */       RESOURCE_TILE cr = (RESOURCE_TILE)roomInstance.storage(c.x(), c.y());
/* 310 */       if (cr != null)
/* 311 */         for (EquipBattle s : STATS.EQUIP().BATTLE_ALL()) {
/* 312 */           if (amounts[s.indexMilitary()] <= 0)
/*     */             continue; 
/* 314 */           if (cr.resource() == s.resource())
/* 315 */             while (amounts[s.indexMilitary()] > 0 && cr.reservable() > 0) {
/* 316 */               cr.findableReserve();
/* 317 */               cr.resourcePickup();
/* 318 */               amounts[s.index()] = amounts[s.index()] - 1;
/* 319 */               FACTIONS.player().res().inc(cr.resource(), FResources.RTYPE.SPOILS, -1);
/*     */             }  
/*     */         }  
/*     */     } 
/*     */     byte b;
/*     */     int i;
/*     */     ENTITY[] arrayOfENTITY;
/* 326 */     for (i = (arrayOfENTITY = SETT.ENTITIES().getAllEnts()).length, b = 0; b < i; ) { ENTITY e = arrayOfENTITY[b];
/* 327 */       if (e instanceof Humanoid) {
/* 328 */         Humanoid a = (Humanoid)e;
/* 329 */         Div d = (Div)(STATS.BATTLE()).DIV.get(a);
/* 330 */         if (d != null && d.army() == GAME.ARMIES().player()) {
/* 331 */           for (EquipBattle s : STATS.EQUIP().BATTLE_ALL()) {
/* 332 */             if (amounts[s.indexMilitary()] <= 0)
/*     */               continue; 
/* 334 */             if (s.stat().indu().get(a.indu()) > 0) {
/* 335 */               int am = CLAMP.i(s.stat().indu().get(a.indu()), 0, amounts[s.indexMilitary()]);
/* 336 */               s.stat().indu().inc(a.indu(), -am);
/* 337 */               amounts[s.indexMilitary()] = amounts[s.indexMilitary()] - am;
/*     */             } 
/*     */           } 
/*     */         }
/*     */       } 
/*     */       b++; }
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   static final class WDivsCapitol
/*     */     implements LIST<WDIV>, SAVABLE
/*     */   {
/* 350 */     private int updateTick = -1;
/* 351 */     private final ArrayList<WDivCity> list = new ArrayList((Config.battle()).DIVISIONS_PER_ARMY);
/* 352 */     private final WDivCity[] all = new WDivCity[(Config.battle()).DIVISIONS_PER_ARMY];
/* 353 */     private static COLOR cols = (COLOR)COLOR.BLUE100.makeSaturated(0.5D).shade(0.75D); private int ii;
/*     */     private final Iterator<WDIV> iterer;
/*     */     private static double[] supplies;
/*     */     private static int[] suppliesHave;
/*     */     private static int[] suppliesNeeded;
/*     */     
/*     */     public void save(FilePutter file) {}
/*     */     
/*     */     public void load(FileGetter file) throws IOException {
/* 362 */       this.updateTick = -1;
/*     */     }
/*     */ 
/*     */     
/*     */     public void clear() {
/* 367 */       this.updateTick = -1;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private void init() {
/* 379 */       if (this.updateTick == GAME.updateI()) {
/*     */         return;
/*     */       }
/* 382 */       this.updateTick = GAME.updateI();
/* 383 */       this.list.clear();
/*     */       
/* 385 */       for (int di = 0; di < GAME.ARMIES().player().divisions().size(); di++) {
/* 386 */         Div d = (Div)GAME.ARMIES().player().ordered().get(di);
/* 387 */         if (AD.cityDivs().attachedArmy(d) == null && (STATS.BATTLE()).DIV.stat().div().get(d) > 0) {
/* 388 */           this.list.add(this.all[d.indexArmy()]);
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public Iterator<WDIV> iterator() {
/* 395 */       init();
/* 396 */       this.ii = 0;
/* 397 */       return this.iterer;
/*     */     }
/*     */     
/*     */     WDivsCapitol() {
/* 401 */       this.iterer = new Iterator<WDIV>()
/*     */         {
/*     */           public boolean hasNext()
/*     */           {
/* 405 */             return (RDMilitaryGar.WDivsCapitol.this.ii < RDMilitaryGar.WDivsCapitol.this.size());
/*     */           }
/*     */ 
/*     */           
/*     */           public WDIV next() {
/* 410 */             WDIV d = (WDIV)RDMilitaryGar.WDivsCapitol.this.list.get(RDMilitaryGar.WDivsCapitol.this.ii);
/* 411 */             RDMilitaryGar.WDivsCapitol.this.ii++;
/* 412 */             return d;
/*     */           }
/*     */         };
/*     */       for (int di = 0; di < GAME.ARMIES().player().divisions().size(); di++)
/*     */         this.all[di] = new WDivCity((Div)GAME.ARMIES().player().divisions().get(di)); 
/*     */       upI = -1;
/*     */     }
/*     */     
/* 420 */     private static int upI = -1;
/*     */ 
/*     */ 
/*     */     
/*     */     private static void initSupplies() {
/* 425 */       if (supplies == null) {
/* 426 */         supplies = new double[STATS.EQUIP().BATTLE_ALL().size()];
/* 427 */         suppliesHave = Alloc.ii(RESOURCES.ALL().size());
/* 428 */         suppliesNeeded = Alloc.ii(RESOURCES.ALL().size());
/*     */       } 
/*     */       
/* 431 */       if (supplies == null || upI != GAME.updateI()) {
/* 432 */         upI = GAME.updateI(); byte b;
/*     */         int i;
/*     */         ENTITY[] arrayOfENTITY;
/* 435 */         for (i = (arrayOfENTITY = SETT.ENTITIES().getAllEnts()).length, b = 0; b < i; ) { ENTITY e = arrayOfENTITY[b];
/* 436 */           if (e instanceof Humanoid) {
/* 437 */             Humanoid a = (Humanoid)e;
/* 438 */             Div d = (Div)(STATS.BATTLE()).DIV.get(a);
/* 439 */             if (d != null && d.army() == GAME.ARMIES().player()) {
/* 440 */               for (EquipBattle s : STATS.EQUIP().BATTLE_ALL()) {
/* 441 */                 suppliesNeeded[s.resource().index()] = suppliesNeeded[s.resource().index()] + s.target(d);
/* 442 */                 suppliesHave[s.resource().index()] = suppliesHave[s.resource().index()] + s.stat().indu().get(a.indu());
/*     */               } 
/*     */             }
/*     */           } 
/*     */           
/*     */           b++; }
/*     */ 
/*     */         
/* 450 */         for (EquipBattle s : STATS.EQUIP().BATTLE_ALL()) {
/* 451 */           if (suppliesNeeded[s.resource().index()] != 0) {
/* 452 */             suppliesHave[s.resource().index()] = suppliesHave[s.resource().index()] + ((SETT.ROOMS()).STOCKPILE.tally()).amountReservable.get(s.resource());
/* 453 */             supplies[s.indexMilitary()] = suppliesHave[s.resource().index()] / suppliesNeeded[s.resource().index()];
/*     */           } else {
/* 455 */             supplies[s.indexMilitary()] = 0.0D;
/*     */           } 
/* 457 */           supplies[s.indexMilitary()] = CLAMP.d(supplies[s.indexMilitary()], 0.0D, 1.0D);
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public WDIV get(int index) {
/* 466 */       init();
/* 467 */       return (WDIV)this.list.get(index);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean contains(int i) {
/* 474 */       init();
/* 475 */       return this.list.contains(i);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean contains(WDIV object) {
/* 480 */       if (object instanceof WDivCity)
/* 481 */         return this.list.contains(object); 
/* 482 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public int size() {
/* 487 */       init();
/* 488 */       return this.list.size();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isEmpty() {
/* 493 */       init();
/* 494 */       return (this.list.size() == 0);
/*     */     }
/*     */     
/*     */     public class WDivCity
/*     */       implements WDIV
/*     */     {
/*     */       private final int di;
/*     */       
/*     */       WDivCity(Div div) {
/* 503 */         this.di = div.index();
/*     */       }
/*     */ 
/*     */       
/*     */       private Div div() {
/* 508 */         return GAME.ARMIES().division((short)this.di);
/*     */       }
/*     */ 
/*     */       
/*     */       public int men() {
/* 513 */         return div().menNrOf();
/*     */       }
/*     */ 
/*     */       
/*     */       public Race race() {
/* 518 */         return (div()).info.race();
/*     */       }
/*     */ 
/*     */       
/*     */       public int menTarget() {
/* 523 */         return div().menNrOf();
/*     */       }
/*     */ 
/*     */       
/*     */       public double training(StatsBattle.StatTraining tr) {
/* 528 */         return tr.stat.div().getD(div());
/*     */       }
/*     */ 
/*     */       
/*     */       public double equip(EquipBattle e) {
/* 533 */         RDMilitaryGar.WDivsCapitol.initSupplies();
/* 534 */         return e.target(div()) * RDMilitaryGar.WDivsCapitol.supplies[e.indexMilitary()] / e.max();
/*     */       }
/*     */ 
/*     */       
/*     */       public double experience() {
/* 539 */         return (STATS.BATTLE()).COMBAT_EXPERIENCE.div().getD(div());
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public DivGeneration generate() {
/* 545 */         ArrayList<Induvidual> inus = new ArrayList(men()); byte b; int i; ENTITY[] arrayOfENTITY;
/* 546 */         for (i = (arrayOfENTITY = SETT.ENTITIES().getAllEnts()).length, b = 0; b < i; ) { ENTITY e = arrayOfENTITY[b];
/* 547 */           if (e instanceof Humanoid) {
/* 548 */             Humanoid a = (Humanoid)e;
/* 549 */             Div d = (Div)(STATS.BATTLE()).DIV.get(a);
/* 550 */             if (d == div()) {
/* 551 */               Induvidual in = new Induvidual(a.indu().hType(), a.indu().race());
/* 552 */               in.copyFrom(a.indu());
/* 553 */               inus.add(in);
/*     */             } 
/*     */           } 
/*     */           b++; }
/*     */         
/* 558 */         DivGeneration res = new DivGeneration(this, (LIST)inus, target());
/* 559 */         return res;
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public void resolve(Induvidual[] hs) {
/* 565 */         KeyMap<Induvidual> map = new KeyMap(); byte b; int i; Induvidual[] arrayOfInduvidual;
/* 566 */         for (i = (arrayOfInduvidual = hs).length, b = 0; b < i; ) { Induvidual ii = arrayOfInduvidual[b];
/* 567 */           String k = "" + STATS.RAN().getL(ii, 0);
/* 568 */           if (!map.containsKey(k))
/* 569 */             map.put(k, ii);  b++; }
/*     */          ENTITY[] arrayOfENTITY;
/* 571 */         for (i = (arrayOfENTITY = SETT.ENTITIES().getAllEnts()).length, b = 0; b < i; ) { ENTITY e = arrayOfENTITY[b];
/* 572 */           if (e instanceof Humanoid) {
/* 573 */             Humanoid a = (Humanoid)e;
/* 574 */             if ((STATS.BATTLE()).DIV.get(a) == div()) {
/* 575 */               String k = "" + STATS.RAN().getL(a.indu(), 0);
/* 576 */               if (map.containsKey(k)) {
/* 577 */                 a.indu().copyFrom((Induvidual)map.get(k));
/*     */               } else {
/* 579 */                 (STATS.POP()).COUNT.reg(a.indu(), CAUSE_LEAVES.SLAYED());
/* 580 */                 a.helloMyNameIsInigoMontoyaYouKilledMyFatherPrepareToDie();
/*     */               } 
/*     */             } 
/*     */           } 
/*     */           b++; }
/*     */       
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public void resolve(int surviviors, double experiencePerMan) {
/* 594 */         double dExperience = experiencePerMan - experience();
/* 595 */         dExperience *= surviviors;
/*     */         
/* 597 */         int deaths = men() - surviviors; byte b;
/*     */         int i;
/*     */         ENTITY[] arrayOfENTITY;
/* 600 */         for (i = (arrayOfENTITY = SETT.ENTITIES().getAllEnts()).length, b = 0; b < i; ) { ENTITY e = arrayOfENTITY[b];
/*     */           
/* 602 */           if (e instanceof Humanoid) {
/* 603 */             Humanoid a = (Humanoid)e;
/*     */             
/* 605 */             if ((STATS.BATTLE()).DIV.get(a) == div()) {
/* 606 */               if (deaths <= 0) {
/* 607 */                 int am = (int)dExperience;
/* 608 */                 if (dExperience - am > RND.rFloat())
/* 609 */                   (STATS.BATTLE()).COMBAT_EXPERIENCE.indu().inc(a.indu(), am); 
/*     */               } else {
/* 611 */                 (STATS.POP()).COUNT.reg(a.indu(), CAUSE_LEAVES.SLAYED());
/* 612 */                 a.helloMyNameIsInigoMontoyaYouKilledMyFatherPrepareToDie();
/* 613 */                 deaths--;
/*     */               } 
/*     */             }
/*     */           } 
/*     */           b++; }
/*     */       
/*     */       }
/*     */ 
/*     */       
/*     */       public int daysUntilMenArrives() {
/* 623 */         return 0;
/*     */       }
/*     */ 
/*     */       
/*     */       public CharSequence name() {
/* 628 */         return (CharSequence)(div()).info.name();
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean needSupplies() {
/* 633 */         return true;
/*     */       }
/*     */ 
/*     */       
/*     */       public DivisionBanners.DivisionBanner banner() {
/* 638 */         return (GAME.ARMIES()).banners.get((div()).info.bannerI());
/*     */       }
/*     */ 
/*     */       
/*     */       public void bannerSet(int bi) {
/* 643 */         (div()).info.bannerISet(bi);
/*     */       }
/*     */ 
/*     */       
/*     */       public Faction faction() {
/* 648 */         return (Faction)FACTIONS.player();
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public int bannerI() {
/* 655 */         return (div()).info.bannerI();
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public WArmy army() {
/* 661 */         return null;
/*     */       }
/*     */ 
/*     */       
/*     */       public COLOR color() {
/* 666 */         return RDMilitaryGar.WDivsCapitol.cols;
/*     */       }
/*     */ 
/*     */       
/*     */       public DIV_SETTING target() {
/* 671 */         return (DIV_SETTING)(div()).info;
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\region\RDMilitaryGar.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */