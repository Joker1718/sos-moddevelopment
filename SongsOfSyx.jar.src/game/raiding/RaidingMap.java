/*     */ package game.raiding;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.diplomacy.DIP;
/*     */ import game.faction.diplomacy.DipStance;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.time.TIME;
/*     */ import init.sprite.UI.UI;
/*     */ import init.trade.TR;
/*     */ import init.trade.TRADABLE;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.PathUtilOnline;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.iterators.RECedgeIter;
/*     */ import snake2d.util.map.MAP_OBJECT;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.ArrayListResize;
/*     */ import snake2d.util.sets.Bitmap1D;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.GUTIL;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import world.WORLD;
/*     */ import world.army.AD;
/*     */ import world.battle.BattleListener;
/*     */ import world.entity.army.WArmy;
/*     */ import world.map.pathing.WRegFinder;
/*     */ import world.map.pathing.WRegSel;
/*     */ import world.map.regions.Region;
/*     */ import world.map.road.WTRAV;
/*     */ import world.region.RD;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RaidingMap
/*     */ {
/*  47 */   public static CharSequence ¤¤Name = "Raid Security";
/*  48 */   public static CharSequence ¤¤desc = "Rich border regions without proper garrisons or armies might become subject to lesser raiders sacking them. A security above 100% is completely safe.";
/*  49 */   public static CharSequence ¤¤Exposure = "Exposure";
/*  50 */   public static CharSequence ¤¤Protection = "Protection";
/*  51 */   public static CharSequence ¤¤Attraction = "Raider attraction";
/*     */   static {
/*  53 */     D.ts(RaidingMap.class);
/*     */   }
/*     */   
/*     */   private boolean dirty = true;
/*  57 */   private double AUp = -100.0D;
/*  58 */   private final ArrayList<RaidRegion> regsAll = new ArrayList(1023);
/*  59 */   private final ArrayList<RaidRegion> regsCurrent = new ArrayList(1023);
/*     */   
/*  61 */   private ArrayListResize<RaidEntryPoint> cooAll = new ArrayListResize(128, 16384);
/*  62 */   private ArrayListResize<RaidEntryPoint> coosCurrent = new ArrayListResize(128, 16384);
/*     */   
/*  64 */   private final Bitmap1D rtmp = new Bitmap1D(1024, false);
/*  65 */   private final RECedgeIter iter = new RECedgeIter();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final MAP_OBJECT<RaidRegion> MAP;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final WRegFinder.Treaty aTreaty;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LIST<RaidRegion> entryRegions() {
/* 123 */     process();
/* 124 */     return (LIST<RaidRegion>)this.regsCurrent;
/*     */   }
/*     */   
/*     */   public LIST<RaidEntryPoint> entrySpots() {
/* 128 */     process();
/* 129 */     return (LIST<RaidEntryPoint>)this.coosCurrent;
/*     */   }
/*     */   
/* 132 */   RaidingMap() { this.MAP = new MAP_OBJECT<RaidRegion>()
/*     */       {
/*     */         public RaidingMap.RaidRegion get(int tile)
/*     */         {
/* 136 */           Region reg = (Region)(WORLD.REGIONS()).map.get(tile);
/* 137 */           if (reg != null) {
/* 138 */             RaidingMap.this.process();
/* 139 */             return (RaidingMap.RaidRegion)RaidingMap.this.regsAll.get(reg.index());
/*     */           } 
/* 141 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public RaidingMap.RaidRegion get(int tx, int ty) {
/* 146 */           if (WORLD.IN_BOUNDS(tx, ty))
/* 147 */             return get(tx + ty * WORLD.TWIDTH()); 
/* 148 */           return null;
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 510 */     this.aTreaty = new WRegFinder.Treaty()
/*     */       {
/*     */         public boolean can(Region origin, Region prevReg, Region to, int tx, int ty, double dist)
/*     */         {
/* 514 */           if (dist > 128.0D)
/* 515 */             return false; 
/* 516 */           return true;
/*     */         }
/*     */       }; for (int ri = 0; ri < 1023; ri++) this.regsAll.add(new RaidRegion(ri));  }
/*     */   public RaidRegion get(Region reg) { process(); return (RaidRegion)this.regsAll.get(reg.index()); }
/*     */   private void process() { aProcess(); if (!this.dirty) return;  this.dirty = false; PathUtilOnline.Flooder f = GUTIL.flooder(); this.rtmp.clear(); this.regsCurrent.clearSloppy(); this.coosCurrent.clearSoft(); f.init(RaidingMap.class); this.iter.init(WORLD.TBOUNDS()); while (this.iter.hasNext()) { COORDINATE c = this.iter.next(); f.pushSloppy(c, 0.0D); }  while (f.hasMore()) { PathTile t = f.pollSmallest(); Region reg = (Region)(WORLD.PATH()).regMap.get((COORDINATE)t); if (reg != null && reg.faction() == FACTIONS.player()) { if (this.rtmp.get(reg.index())) continue;  if ((WORLD.PATH()).map.is.is((COORDINATE)t)) { this.rtmp.set(reg.index(), true); add(t); continue; }  }  if (t.getValue() > 32.0F) break;  for (DIR d : DIR.ALL) { if (WORLD.IN_BOUNDS((COORDINATE)t, d) && WTRAV.can(t.x(), t.y(), d, false)) f.pushSmaller((COORDINATE)t, d, t.getValue() + d.tileDistance());  }  }  f.done(); f.init(f); for (Region reg : WORLD.REGIONS().active()) { RaidRegion r = (RaidRegion)this.regsAll.get(reg.index()); r.probability = 0.0D; r.points = 0; if (reg.faction() == FACTIONS.player()) continue;  f.pushSloppy(reg.cx(), reg.cy(), 0.0D); }  while (f.hasMore()) { PathTile t = f.pollSmallest(); Region reg = (Region)(WORLD.PATH()).regMap.get((COORDINATE)t); if (reg != null && reg.faction() == FACTIONS.player()) { this.rtmp.set(reg.index(), false); add(t); continue; }  (WORLD.PATH()).map.pushSimple(t); }  f.done(); this.rtmp.clear(); this.regsCurrent.clearSloppy(); for (RaidEntryPoint c : this.coosCurrent) { RaidRegion reg = (RaidRegion)this.MAP.get((COORDINATE)c.coo); if (!this.rtmp.get(reg.ri)) { this.rtmp.set(reg.ri, true); this.regsCurrent.add(this.regsAll.get(reg.ri)); }  reg.points++; reg.probability += c.probability * 0.5D; }  } private void add(PathTile t) { PathTile c = t; double prob = 0.0D; while (t != null) { Region reg = (Region)(WORLD.REGIONS()).map.get((COORDINATE)t); t = t.getParent(); if (reg == null) { prob += 0.03125D; if (prob >= 1.0D || t == null) { add((COORDINATE)c, 1.0D, null); return; }  continue; }  prob = 0.0D; if (reg.faction() == null) { add((COORDINATE)c, 1.0D, reg); return; }  if (reg.faction() == FACTIONS.player()) { if (t == null) { add((COORDINATE)c, 1.0D, null); return; }  continue; }  add((COORDINATE)c, (DIP.get((FactionNPC)reg.faction())).tarif, reg); return; }  } public static FactionNPC passThroughFaction(COORDINATE c) { Faction fa = null; for (DIR d : DIR.ALL) { if ((WORLD.PATH()).map.can(c, d)) { Faction f = (Faction)(WORLD.REGIONS()).faction.get(c, d); if (f == null) return null;  if (f != FACTIONS.player() && (DIP.get((Faction)FACTIONS.player(), f)).trades) fa = f;  }  }  if (fa == null) return null;  return (FactionNPC)fa; } private void add(COORDINATE c, double probability, Region from) { while (this.coosCurrent.size() >= this.cooAll.size())
/*     */       this.cooAll.add(new RaidEntryPoint());  RaidEntryPoint e = (RaidEntryPoint)this.cooAll.get(this.coosCurrent.size()); e.coo.set(c); e.probability = probability; e.rFrom = (from == null) ? -1 : from.index(); this.coosCurrent.add(e); } private void aProcess() { if (Math.abs(this.AUp - TIME.currentSecond()) < 100.0D)
/*     */       return;  this.AUp = TIME.currentSecond(); for (RaidRegion r : this.regsAll)
/*     */       r.armyPower = 0.0D;  for (int ai = 0; ai < FACTIONS.player().armies().all().size(); ai++) { WArmy a = (WArmy)FACTIONS.player().armies().all().get(ai); double pow = AD.power().get(a); if (pow > 0.0D)
/*     */         for (WRegFinder.RegDist d : (WORLD.PATH()).regFinder.all(a.ctx(), a.cty(), this.aTreaty, WRegSel.DUMMY())) { double p = 1.0D - (d.distance - 32) / 96.0D; p = CLAMP.d(p, 0.0D, 1.0D); (get(d.reg)).armyPower += pow * p; }   }  } public static class RaidRegion
/*     */   {
/* 526 */     private int points = 0; public final int ri; private double probability;
/*     */     private double armyPower;
/* 528 */     private int spoils = 0;
/* 529 */     private int spoilsI = 0;
/*     */ 
/*     */     
/*     */     private RaidRegion(int reg) {
/* 533 */       this.ri = reg;
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
/*     */     public double security() {
/* 545 */       double w = spoils() * this.probability;
/* 546 */       double pow = this.armyPower + (RD.MILITARY()).power.getD(r());
/* 547 */       return CLAMP.d((pow + 1.0D) / w, 0.0D, 10.0D);
/*     */     }
/*     */     
/*     */     public double probabilityRaw() {
/* 551 */       return this.probability;
/*     */     }
/*     */     
/*     */     public double army() {
/* 555 */       return this.armyPower;
/*     */     }
/*     */     
/*     */     public Region r() {
/* 559 */       return (Region)WORLD.REGIONS().all().get(this.ri);
/*     */     }
/*     */     
/*     */     public int points() {
/* 563 */       return this.points;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public double spoils() {
/* 569 */       if (this.spoilsI == GAME.updateI()) {
/* 570 */         return this.spoils;
/*     */       }
/* 572 */       this.spoils = 0;
/*     */       
/* 574 */       for (TRADABLE tr : TR.ALL()) {
/* 575 */         this.spoils = (int)(this.spoils + (FACTIONS.PRICE().get(tr) * RD.OUTPUT().get(tr).getDelivery(r())) / RD.DIST().distancePenalty(r()));
/*     */       }
/* 577 */       this.spoils = (int)(this.spoils + (RD.OUTPUT()).MONEY.getDelivery(r()) / RD.DIST().distancePenalty(r()));
/*     */       
/* 579 */       this.spoils /= 400;
/*     */       
/* 581 */       this.spoilsI = GAME.updateI();
/*     */       
/* 583 */       return this.spoils;
/*     */     }
/*     */ 
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX box) {
/* 588 */       GBox b = (GBox)box;
/*     */       
/* 590 */       b.title(RaidingMap.¤¤Name);
/* 591 */       b.text(RaidingMap.¤¤desc);
/* 592 */       b.NL();
/*     */       
/* 594 */       b.add((SPRITE)(UI.icons()).m.raider);
/* 595 */       b.textLL(RaidingMap.¤¤Attraction);
/* 596 */       b.tab(7);
/* 597 */       b.add((SPRITE)GFORMAT.i(b.text(), (int)(spoils() * probabilityRaw())));
/* 598 */       b.NL();
/*     */       
/* 600 */       b.tab(1);
/* 601 */       b.add((SPRITE)(UI.icons()).s.money);
/* 602 */       b.textLL(Dic.¤¤Riches);
/* 603 */       b.tab(7);
/* 604 */       b.add((SPRITE)GFORMAT.i(b.text(), (int)spoils()));
/* 605 */       b.NL();
/*     */       
/* 607 */       b.tab(1);
/* 608 */       b.add((SPRITE)(UI.icons()).s.minimap);
/* 609 */       b.textLL(RaidingMap.¤¤Exposure);
/* 610 */       b.tab(7);
/* 611 */       b.add((SPRITE)GFORMAT.mul(b.text(), probabilityRaw()));
/* 612 */       b.NL();
/*     */       
/* 614 */       b.NL(16);
/*     */       
/* 616 */       b.add((SPRITE)(UI.icons()).s.shield);
/* 617 */       b.textLL(RaidingMap.¤¤Protection);
/* 618 */       b.tab(7);
/* 619 */       b.add((SPRITE)GFORMAT.iIncr(b.text(), (1 + (int)(RD.MILITARY()).power.getD(r()) + (int)army())));
/* 620 */       b.NL();
/*     */       
/* 622 */       b.tab(1);
/* 623 */       b.textL(Dic.¤¤Garrison);
/* 624 */       b.tab(7);
/* 625 */       b.add((SPRITE)GFORMAT.i(b.text(), (int)(RD.MILITARY()).power.getD(r())));
/* 626 */       b.NL();
/*     */       
/* 628 */       b.tab(1);
/* 629 */       b.textL(Dic.¤¤Armies);
/* 630 */       b.tab(7);
/* 631 */       b.add((SPRITE)GFORMAT.i(b.text(), (int)army()));
/* 632 */       b.NL();
/*     */       
/* 634 */       b.sep();
/*     */       
/* 636 */       b.textLL(Dic.¤¤Total);
/* 637 */       b.tab(6);
/*     */       
/* 639 */       GText t = b.text();
/* 640 */       t.add((1 + (int)(RD.MILITARY()).power.getD(r()) + (int)army())).s().add('/').s().add((int)(spoils() * probabilityRaw())).s().add('=').s().add(security());
/* 641 */       b.add((SPRITE)t);
/*     */     } }
/*     */   public static class RaidEntryPoint { private double probability;
/*     */     private final Coo coo;
/*     */     private int rFrom;
/*     */     
/*     */     public RaidEntryPoint() {
/* 648 */       this.probability = 0.0D;
/* 649 */       this.coo = new Coo();
/* 650 */       this.rFrom = -1;
/*     */     }
/*     */     public double probabilityRaw() {
/* 653 */       return this.probability;
/*     */     }
/*     */     
/*     */     public COORDINATE c() {
/* 657 */       return (COORDINATE)this.coo;
/*     */     }
/*     */     
/*     */     public Region from() {
/* 661 */       if (this.rFrom == -1)
/* 662 */         return null; 
/* 663 */       return (Region)WORLD.REGIONS().all().get(this.rFrom);
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\raiding\RaidingMap.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */