/*     */ package game.raiding;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.faction.FACTIONS;
/*     */ import init.sprite.UI.UI;
/*     */ import init.trade.TR;
/*     */ import init.trade.TRADABLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.Dic;
/*     */ import world.WORLD;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RaidRegion
/*     */ {
/*     */   public final int ri;
/*     */   private double probability;
/*     */   private double armyPower;
/* 526 */   private int points = 0;
/*     */   
/* 528 */   private int spoils = 0;
/* 529 */   private int spoilsI = 0;
/*     */ 
/*     */   
/*     */   private RaidRegion(int reg) {
/* 533 */     this.ri = reg;
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
/*     */   public double security() {
/* 545 */     double w = spoils() * this.probability;
/* 546 */     double pow = this.armyPower + (RD.MILITARY()).power.getD(r());
/* 547 */     return CLAMP.d((pow + 1.0D) / w, 0.0D, 10.0D);
/*     */   }
/*     */   
/*     */   public double probabilityRaw() {
/* 551 */     return this.probability;
/*     */   }
/*     */   
/*     */   public double army() {
/* 555 */     return this.armyPower;
/*     */   }
/*     */   
/*     */   public Region r() {
/* 559 */     return (Region)WORLD.REGIONS().all().get(this.ri);
/*     */   }
/*     */   
/*     */   public int points() {
/* 563 */     return this.points;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public double spoils() {
/* 569 */     if (this.spoilsI == GAME.updateI()) {
/* 570 */       return this.spoils;
/*     */     }
/* 572 */     this.spoils = 0;
/*     */     
/* 574 */     for (TRADABLE tr : TR.ALL()) {
/* 575 */       this.spoils = (int)(this.spoils + (FACTIONS.PRICE().get(tr) * RD.OUTPUT().get(tr).getDelivery(r())) / RD.DIST().distancePenalty(r()));
/*     */     }
/* 577 */     this.spoils = (int)(this.spoils + (RD.OUTPUT()).MONEY.getDelivery(r()) / RD.DIST().distancePenalty(r()));
/*     */     
/* 579 */     this.spoils /= 400;
/*     */     
/* 581 */     this.spoilsI = GAME.updateI();
/*     */     
/* 583 */     return this.spoils;
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX box) {
/* 588 */     GBox b = (GBox)box;
/*     */     
/* 590 */     b.title(RaidingMap.¤¤Name);
/* 591 */     b.text(RaidingMap.¤¤desc);
/* 592 */     b.NL();
/*     */     
/* 594 */     b.add((SPRITE)(UI.icons()).m.raider);
/* 595 */     b.textLL(RaidingMap.¤¤Attraction);
/* 596 */     b.tab(7);
/* 597 */     b.add((SPRITE)GFORMAT.i(b.text(), (int)(spoils() * probabilityRaw())));
/* 598 */     b.NL();
/*     */     
/* 600 */     b.tab(1);
/* 601 */     b.add((SPRITE)(UI.icons()).s.money);
/* 602 */     b.textLL(Dic.¤¤Riches);
/* 603 */     b.tab(7);
/* 604 */     b.add((SPRITE)GFORMAT.i(b.text(), (int)spoils()));
/* 605 */     b.NL();
/*     */     
/* 607 */     b.tab(1);
/* 608 */     b.add((SPRITE)(UI.icons()).s.minimap);
/* 609 */     b.textLL(RaidingMap.¤¤Exposure);
/* 610 */     b.tab(7);
/* 611 */     b.add((SPRITE)GFORMAT.mul(b.text(), probabilityRaw()));
/* 612 */     b.NL();
/*     */     
/* 614 */     b.NL(16);
/*     */     
/* 616 */     b.add((SPRITE)(UI.icons()).s.shield);
/* 617 */     b.textLL(RaidingMap.¤¤Protection);
/* 618 */     b.tab(7);
/* 619 */     b.add((SPRITE)GFORMAT.iIncr(b.text(), (1 + (int)(RD.MILITARY()).power.getD(r()) + (int)army())));
/* 620 */     b.NL();
/*     */     
/* 622 */     b.tab(1);
/* 623 */     b.textL(Dic.¤¤Garrison);
/* 624 */     b.tab(7);
/* 625 */     b.add((SPRITE)GFORMAT.i(b.text(), (int)(RD.MILITARY()).power.getD(r())));
/* 626 */     b.NL();
/*     */     
/* 628 */     b.tab(1);
/* 629 */     b.textL(Dic.¤¤Armies);
/* 630 */     b.tab(7);
/* 631 */     b.add((SPRITE)GFORMAT.i(b.text(), (int)army()));
/* 632 */     b.NL();
/*     */     
/* 634 */     b.sep();
/*     */     
/* 636 */     b.textLL(Dic.¤¤Total);
/* 637 */     b.tab(6);
/*     */     
/* 639 */     GText t = b.text();
/* 640 */     t.add((1 + (int)(RD.MILITARY()).power.getD(r()) + (int)army())).s().add('/').s().add((int)(spoils() * probabilityRaw())).s().add('=').s().add(security());
/* 641 */     b.add((SPRITE)t);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\raiding\RaidingMap$RaidRegion.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */