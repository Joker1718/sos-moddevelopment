/*     */ package settlement.stats.colls;
/*     */ 
/*     */ import init.race.Race;
/*     */ import init.religion.RELIGIONS;
/*     */ import init.religion.Religion;
/*     */ import init.type.HCLASS;
/*     */ import init.type.NEED;
/*     */ import init.type.NEEDS;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.service.module.ROOM_SERVICER;
/*     */ import settlement.room.spirit.shrine.ROOM_SHRINE;
/*     */ import settlement.room.spirit.temple.ROOM_TEMPLE;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.StatsInit;
/*     */ import settlement.stats.service.StatService;
/*     */ import settlement.stats.stat.SETT_STATISTICS;
/*     */ import settlement.stats.stat.STAT;
/*     */ import settlement.stats.stat.STATData;
/*     */ import settlement.stats.stat.STATFake;
/*     */ import settlement.stats.stat.StatInfo;
/*     */ import settlement.stats.util.StatHoverer;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.DataO;
/*     */ import util.data.INT_O;
/*     */ import util.gui.misc.GBox;
/*     */ import util.info.GFORMAT;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class ReligionTot
/*     */   extends StatService
/*     */ {
/*     */   public final STAT TOTAL;
/*     */   public final STAT ACCESS;
/*     */   public final STAT QUALITY;
/* 598 */   private final SETT_STATISTICS.SettStatistics[] accesses = new SETT_STATISTICS.SettStatistics[RELIGIONS.ALL().size()];
/* 599 */   private final SETT_STATISTICS.SettStatistics[] qualities = new SETT_STATISTICS.SettStatistics[RELIGIONS.ALL().size()];
/*     */   
/*     */   ReligionTot(StatsInit init, String key, CharSequence name, SPRITE icon, NEED need) {
/* 602 */     super(name, name, icon, need);
/*     */     
/* 604 */     this.TOTAL = (STAT)new STATFake(key, init)
/*     */       {
/*     */         protected double getDD(HCLASS s, Race r, int daysBack)
/*     */         {
/* 608 */           double a = StatsReligion.ReligionTot.this.ACCESS.data(s).getD(r, daysBack);
/* 609 */           double q = StatsReligion.ReligionTot.this.QUALITY.data(s).getD(r, daysBack);
/* 610 */           return a * (0.2D + 0.8D * q);
/*     */         }
/*     */ 
/*     */         
/*     */         protected double induGet(Induvidual t) {
/* 615 */           return StatsReligion.ReligionTot.this.ACCESS.indu().get(t) * StatsReligion.ReligionTot.this.QUALITY.indu().getD(t);
/*     */         }
/*     */ 
/*     */         
/*     */         public void hover(GUI_BOX text, HCLASS cl, Race type) {
/* 620 */           StatHoverer.hover(text, (STAT)this);
/* 621 */           GBox b = (GBox)text;
/* 622 */           b.sep();
/*     */           
/* 624 */           b.textL((StatsReligion.ReligionTot.this.ACCESS.info()).name);
/* 625 */           b.tab(6);
/* 626 */           b.add((SPRITE)GFORMAT.perc(b.text(), StatsReligion.ReligionTot.this.ACCESS.data(cl).getD(type)));
/* 627 */           b.NL();
/* 628 */           b.textL((StatsReligion.ReligionTot.this.QUALITY.info()).name);
/* 629 */           b.tab(6);
/* 630 */           b.add((SPRITE)GFORMAT.perc(b.text(), StatsReligion.ReligionTot.this.QUALITY.data(cl).getD(type)));
/* 631 */           b.sep();
/*     */           
/* 633 */           StatHoverer.hover(text, (STAT)this, cl, type);
/*     */         }
/*     */ 
/*     */         
/*     */         public void hover(GUI_BOX text, Induvidual indu) {
/* 638 */           StatHoverer.hover(text, (STAT)this);
/* 639 */           GBox b = (GBox)text;
/* 640 */           b.sep();
/*     */           
/* 642 */           b.textL((StatsReligion.ReligionTot.this.ACCESS.info()).name);
/* 643 */           b.tab(6);
/* 644 */           b.add((SPRITE)GFORMAT.perc(b.text(), StatsReligion.ReligionTot.this.ACCESS.indu().getD(indu)));
/* 645 */           b.NL();
/* 646 */           b.textL((StatsReligion.ReligionTot.this.QUALITY.info()).name);
/* 647 */           b.tab(6);
/* 648 */           b.add((SPRITE)GFORMAT.perc(b.text(), StatsReligion.ReligionTot.this.QUALITY.indu().getD(indu)));
/* 649 */           b.sep();
/*     */           
/* 651 */           StatHoverer.hover(text, (STAT)this, indu);
/*     */         }
/*     */       };
/*     */     
/* 655 */     (this.TOTAL.info()).icon = icon;
/*     */     
/* 657 */     this.ACCESS = (STAT)new STATData(null, init, (DataO.DataAbs)new DataO<Induvidual>.DataBit(init.count, key + "ACCESS")
/*     */         {
/*     */           public void set(Induvidual t, int s)
/*     */           {
/* 661 */             StatsReligion.StatReligion r = (StatsReligion.StatReligion)(STATS.RELIGION()).getter.get(t);
/* 662 */             StatsReligion.ReligionTot.this.accesses[r.index()].inc(t, -get(t));
/* 663 */             super.set(t, s);
/* 664 */             StatsReligion.ReligionTot.this.accesses[r.index()].inc(t, get(t));
/* 665 */             if (get(t) == 0) {
/* 666 */               StatsReligion.ReligionTot.this.QUALITY.indu().set(t, 0);
/*     */ 
/*     */             
/*     */             }
/*     */           }
/* 671 */         }new StatInfo(StatsReligion.¤¤access, StatsReligion.¤¤access, String.valueOf(StatsReligion.¤¤accessD) + " " + String.valueOf(StatsReligion.¤¤accessD)));
/*     */     
/* 673 */     this.QUALITY = (STAT)new STATData(null, key + "_QUALITY", init, (INT_O.INT_OE)new DataO<Induvidual>.DataNibble1(init.count, key + "_QUALITY")
/*     */         {
/*     */           public void set(Induvidual t, int s) {
/* 676 */             if (StatsReligion.ReligionTot.this.ACCESS.indu().get(t) == 0)
/* 677 */               s = 0; 
/* 678 */             StatsReligion.StatReligion r = (StatsReligion.StatReligion)(STATS.RELIGION()).getter.get(t);
/* 679 */             StatsReligion.ReligionTot.this.qualities[r.index()].inc(t, -get(t));
/* 680 */             super.set(t, s);
/* 681 */             StatsReligion.ReligionTot.this.qualities[r.index()].inc(t, get(t));
/*     */           }
/* 687 */         }new StatInfo(StatsReligion.¤¤value, StatsReligion.¤¤value, String.valueOf(StatsReligion.¤¤valueD) + " " + String.valueOf(StatsReligion.¤¤valueD)))
/*     */       {
/*     */         public int pdivider(HCLASS c, Race r, int daysback)
/*     */         {
/* 691 */           return StatsReligion.ReligionTot.this.ACCESS.data(c).get(r, daysback);
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/* 697 */     for (Religion t : RELIGIONS.ALL()) {
/* 698 */       this.accesses[t.index()] = new SETT_STATISTICS.SettStatistics(key + "_" + key + "_A", init, StatsReligion.¤¤access, String.valueOf(StatsReligion.¤¤accessD) + " " + String.valueOf(StatsReligion.¤¤accessD))
/*     */         {
/*     */           protected int popDivider(HCLASS c, Race r, int daysback) {
/* 701 */             return ((StatsReligion.StatReligion)(STATS.RELIGION()).ALL.get(t.index())).followers.data(c).get(r, daysback);
/*     */           }
/*     */         };
/* 704 */       this.qualities[t.index()] = new SETT_STATISTICS.SettStatistics(key + "_" + key + "_Q", init, StatsReligion.¤¤value, String.valueOf(StatsReligion.¤¤valueD) + " " + String.valueOf(StatsReligion.¤¤valueD))
/*     */         {
/*     */           protected int popDivider(HCLASS c, Race r, int daysback) {
/* 707 */             return StatsReligion.ReligionTot.this.accesses[t.index()].data(c).get(r, daysback);
/*     */           }
/*     */ 
/*     */           
/*     */           public int dataDivider() {
/* 712 */             return StatsReligion.ReligionTot.this.QUALITY.indu().max(null);
/*     */           }
/*     */         };
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public SETT_STATISTICS.SettStatistics access(Religion r) {
/* 721 */     return this.accesses[r.index()];
/*     */   }
/*     */   
/*     */   public SETT_STATISTICS.SettStatistics quality(Religion r) {
/* 725 */     return this.qualities[r.index()];
/*     */   }
/*     */   
/*     */   public void clearAccess(Humanoid h) {
/* 729 */     this.ACCESS.indu().set(h.indu(), 0);
/* 730 */     this.QUALITY.indu().set(h.indu(), 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void clearAccess(Induvidual h) {
/* 735 */     this.ACCESS.indu().set(h, 0);
/* 736 */     this.QUALITY.indu().set(h, 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setAccess(Humanoid h) {
/* 741 */     Room r = (Room)(SETT.ROOMS()).map.get(h.tc());
/* 742 */     if (r != null && r instanceof ROOM_SERVICER) {
/* 743 */       ROOM_SERVICER t = (ROOM_SERVICER)r;
/* 744 */       this.ACCESS.indu().set(h.indu(), 1);
/* 745 */       this.QUALITY.indu().setD(h.indu(), t.quality());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean access(Humanoid h) {
/* 751 */     return (this.ACCESS.indu().get(h.indu()) > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public STAT total() {
/* 756 */     return this.TOTAL;
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence name(Induvidual i) {
/* 761 */     StatsReligion.StatReligion r = (StatsReligion.StatReligion)(STATS.RELIGION()).getter.get(i);
/* 762 */     if (this.need == (NEEDS.TYPES()).TEMPLE) {
/* 763 */       if (((LIST)(SETT.ROOMS()).TEMPLES.perRel.get(r.index())).size() > 0) {
/* 764 */         return ((ROOM_TEMPLE)((LIST)(SETT.ROOMS()).TEMPLES.perRel.get(r.index())).get(0)).info.name;
/*     */       }
/*     */     }
/* 767 */     else if (((LIST)(SETT.ROOMS()).TEMPLES.perRelShrine.get(r.index())).size() > 0) {
/* 768 */       return ((ROOM_SHRINE)((LIST)(SETT.ROOMS()).TEMPLES.perRelShrine.get(r.index())).get(0)).info.name;
/*     */     } 
/*     */     
/* 771 */     return this.name;
/*     */   }
/*     */ 
/*     */   
/*     */   public SPRITE icon(Induvidual i) {
/* 776 */     return (SPRITE)((StatsReligion.StatReligion)(STATS.RELIGION()).getter.get(i)).religion.icon;
/*     */   }
/*     */ 
/*     */   
/*     */   public void cheatSetTotal(Induvidual i, double tot) {
/* 781 */     this.ACCESS.indu().set(i, (tot > 0.0D) ? 1 : 0);
/* 782 */     this.QUALITY.indu().setD(i, tot);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\colls\StatsReligion$ReligionTot.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */