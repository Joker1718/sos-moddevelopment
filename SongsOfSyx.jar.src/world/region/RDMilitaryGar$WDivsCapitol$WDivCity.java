/*     */ package world.region;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.DivisionBanners;
/*     */ import game.battle.div.Div;
/*     */ import game.battle.util.DIV_SETTING;
/*     */ import game.battle.util.DivGeneration;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import init.race.Race;
/*     */ import init.type.CAUSE_LEAVES;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.colls.StatsBattle;
/*     */ import settlement.stats.equip.EquipBattle;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ import snake2d.util.sets.LIST;
/*     */ import world.army.WDIV;
/*     */ import world.entity.army.WArmy;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WDivCity
/*     */   implements WDIV
/*     */ {
/*     */   private final int di;
/*     */   
/*     */   WDivCity(Div div) {
/* 503 */     this.di = div.index();
/*     */   }
/*     */ 
/*     */   
/*     */   private Div div() {
/* 508 */     return GAME.ARMIES().division((short)this.di);
/*     */   }
/*     */ 
/*     */   
/*     */   public int men() {
/* 513 */     return div().menNrOf();
/*     */   }
/*     */ 
/*     */   
/*     */   public Race race() {
/* 518 */     return (div()).info.race();
/*     */   }
/*     */ 
/*     */   
/*     */   public int menTarget() {
/* 523 */     return div().menNrOf();
/*     */   }
/*     */ 
/*     */   
/*     */   public double training(StatsBattle.StatTraining tr) {
/* 528 */     return tr.stat.div().getD(div());
/*     */   }
/*     */ 
/*     */   
/*     */   public double equip(EquipBattle e) {
/* 533 */     RDMilitaryGar.WDivsCapitol.initSupplies();
/* 534 */     return e.target(div()) * RDMilitaryGar.WDivsCapitol.supplies[e.indexMilitary()] / e.max();
/*     */   }
/*     */ 
/*     */   
/*     */   public double experience() {
/* 539 */     return (STATS.BATTLE()).COMBAT_EXPERIENCE.div().getD(div());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public DivGeneration generate() {
/* 545 */     ArrayList<Induvidual> inus = new ArrayList(men()); byte b; int i; ENTITY[] arrayOfENTITY;
/* 546 */     for (i = (arrayOfENTITY = SETT.ENTITIES().getAllEnts()).length, b = 0; b < i; ) { ENTITY e = arrayOfENTITY[b];
/* 547 */       if (e instanceof Humanoid) {
/* 548 */         Humanoid a = (Humanoid)e;
/* 549 */         Div d = (Div)(STATS.BATTLE()).DIV.get(a);
/* 550 */         if (d == div()) {
/* 551 */           Induvidual in = new Induvidual(a.indu().hType(), a.indu().race());
/* 552 */           in.copyFrom(a.indu());
/* 553 */           inus.add(in);
/*     */         } 
/*     */       } 
/*     */       b++; }
/*     */     
/* 558 */     DivGeneration res = new DivGeneration(this, (LIST)inus, target());
/* 559 */     return res;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void resolve(Induvidual[] hs) {
/* 565 */     KeyMap<Induvidual> map = new KeyMap(); byte b; int i; Induvidual[] arrayOfInduvidual;
/* 566 */     for (i = (arrayOfInduvidual = hs).length, b = 0; b < i; ) { Induvidual ii = arrayOfInduvidual[b];
/* 567 */       String k = "" + STATS.RAN().getL(ii, 0);
/* 568 */       if (!map.containsKey(k))
/* 569 */         map.put(k, ii);  b++; }
/*     */      ENTITY[] arrayOfENTITY;
/* 571 */     for (i = (arrayOfENTITY = SETT.ENTITIES().getAllEnts()).length, b = 0; b < i; ) { ENTITY e = arrayOfENTITY[b];
/* 572 */       if (e instanceof Humanoid) {
/* 573 */         Humanoid a = (Humanoid)e;
/* 574 */         if ((STATS.BATTLE()).DIV.get(a) == div()) {
/* 575 */           String k = "" + STATS.RAN().getL(a.indu(), 0);
/* 576 */           if (map.containsKey(k)) {
/* 577 */             a.indu().copyFrom((Induvidual)map.get(k));
/*     */           } else {
/* 579 */             (STATS.POP()).COUNT.reg(a.indu(), CAUSE_LEAVES.SLAYED());
/* 580 */             a.helloMyNameIsInigoMontoyaYouKilledMyFatherPrepareToDie();
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       b++; }
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void resolve(int surviviors, double experiencePerMan) {
/* 594 */     double dExperience = experiencePerMan - experience();
/* 595 */     dExperience *= surviviors;
/*     */     
/* 597 */     int deaths = men() - surviviors; byte b;
/*     */     int i;
/*     */     ENTITY[] arrayOfENTITY;
/* 600 */     for (i = (arrayOfENTITY = SETT.ENTITIES().getAllEnts()).length, b = 0; b < i; ) { ENTITY e = arrayOfENTITY[b];
/*     */       
/* 602 */       if (e instanceof Humanoid) {
/* 603 */         Humanoid a = (Humanoid)e;
/*     */         
/* 605 */         if ((STATS.BATTLE()).DIV.get(a) == div()) {
/* 606 */           if (deaths <= 0) {
/* 607 */             int am = (int)dExperience;
/* 608 */             if (dExperience - am > RND.rFloat())
/* 609 */               (STATS.BATTLE()).COMBAT_EXPERIENCE.indu().inc(a.indu(), am); 
/*     */           } else {
/* 611 */             (STATS.POP()).COUNT.reg(a.indu(), CAUSE_LEAVES.SLAYED());
/* 612 */             a.helloMyNameIsInigoMontoyaYouKilledMyFatherPrepareToDie();
/* 613 */             deaths--;
/*     */           } 
/*     */         }
/*     */       } 
/*     */       b++; }
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   public int daysUntilMenArrives() {
/* 623 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence name() {
/* 628 */     return (CharSequence)(div()).info.name();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean needSupplies() {
/* 633 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public DivisionBanners.DivisionBanner banner() {
/* 638 */     return (GAME.ARMIES()).banners.get((div()).info.bannerI());
/*     */   }
/*     */ 
/*     */   
/*     */   public void bannerSet(int bi) {
/* 643 */     (div()).info.bannerISet(bi);
/*     */   }
/*     */ 
/*     */   
/*     */   public Faction faction() {
/* 648 */     return (Faction)FACTIONS.player();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int bannerI() {
/* 655 */     return (div()).info.bannerI();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public WArmy army() {
/* 661 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public COLOR color() {
/* 666 */     return RDMilitaryGar.WDivsCapitol.cols;
/*     */   }
/*     */ 
/*     */   
/*     */   public DIV_SETTING target() {
/* 671 */     return (DIV_SETTING)(div()).info;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\region\RDMilitaryGar$WDivsCapitol$WDivCity.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */