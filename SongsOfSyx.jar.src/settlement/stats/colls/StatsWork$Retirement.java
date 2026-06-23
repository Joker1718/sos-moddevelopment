/*     */ package settlement.stats.colls;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.HCLASS_RACE;
/*     */ import init.type.HTYPES;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.infra.elderly.ROOM_RESTHOME;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.StatsInit;
/*     */ import settlement.stats.standing.StatStanding;
/*     */ import settlement.stats.stat.STAT;
/*     */ import settlement.stats.stat.STATFake;
/*     */ import settlement.stats.stat.STATFakeData;
/*     */ import settlement.stats.stat.StatDecree;
/*     */ import settlement.stats.stat.StatInfo;
/*     */ import settlement.stats.util.StatHoverer;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.DataO;
/*     */ import util.gui.misc.GBox;
/*     */ import util.info.GFORMAT;
/*     */ import util.keymap.MAPPED;
/*     */ import util.keymap.RMapInt;
/*     */ import util.text.Dic;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class Retirement
/*     */ {
/*     */   public final STAT RETIREMENT_AGE;
/*     */   public final STAT RETIREMENT_HOME;
/*     */   private final STAT RETIREMENT_HOME_ACCESS;
/*     */   private final STAT RETIREMENT_HOME_QUALITY;
/*     */   private final STATFakeData RETIREMENT_HOME_TYPE;
/*     */   
/*     */   Retirement(StatsInit init, final long[] fValues) {
/* 680 */     int DD = 16384;
/* 681 */     double DEFAULT = 0.25D;
/*     */     
/* 683 */     final RMapInt.RMapIntTwo<HCLASS, Race> count = new RMapInt.RMapIntTwo(HCLASSES.MAP(), RACES.map(), -16384, 16384);
/* 684 */     final StatDecree dec = new StatDecree("RETIREMENT_AGE_DEC", init, 0, 100, 1, StatsWork.¤¤retTarget, 25);
/*     */     
/* 686 */     init.savers.put("WORK_RETIREMENT_AGE_COUNT", count);
/* 687 */     this.RETIREMENT_AGE = (STAT)new STATFake("RETIREMENT_AGE", init)
/*     */       {
/*     */         protected double getDD(HCLASS s, Race r, int daysBack)
/*     */         {
/* 691 */           if (s == null) {
/* 692 */             s = HCLASSES.CITIZEN();
/*     */           }
/* 694 */           if (r == null) {
/* 695 */             double tot = 0.0D;
/* 696 */             double tt = 0.0D;
/* 697 */             double pop = 0.0D;
/* 698 */             for (Race ra : RACES.all()) {
/* 699 */               double p = (STATS.POP()).POP.data(s).get(ra);
/* 700 */               tt += count.get((MAPPED)s).getD(ra);
/* 701 */               tot += count.get((MAPPED)s).getD(ra) * p;
/* 702 */               pop += p;
/*     */             } 
/* 704 */             if (pop == 0.0D)
/* 705 */               return tt / RACES.all().size(); 
/* 706 */             return 0.25D + tot / pop;
/*     */           } 
/* 708 */           return 0.25D + count.get((MAPPED)s).getD(r);
/*     */         }
/*     */ 
/*     */         
/*     */         public void hover(GUI_BOX text, HCLASS cl, Race type) {
/* 713 */           StatHoverer.hover(text, (STAT)this);
/* 714 */           GBox b = (GBox)text;
/* 715 */           b.sep();
/*     */           
/* 717 */           b.textLL(StatsWork.¤¤lim);
/* 718 */           b.add((SPRITE)GFORMAT.perc(b.text(), decree().getD(cl, type)));
/* 719 */           b.NL();
/*     */           
/* 721 */           b.textLL(StatsWork.¤¤estimated);
/*     */           
/* 723 */           b.add((SPRITE)GFORMAT.i(b.text(), StatsWork.Retirement.this.estimate(cl, type, decree().getD(cl, type))));
/* 724 */           b.NL();
/*     */ 
/*     */           
/* 727 */           b.sep();
/* 728 */           StatHoverer.hover(text, (STAT)this, cl, type);
/*     */         }
/*     */ 
/*     */         
/*     */         public void hover(GUI_BOX text, Induvidual indu) {
/* 733 */           hover(text, indu.clas(), indu.race());
/*     */         }
/*     */       };
/*     */     
/* 737 */     (this.RETIREMENT_AGE.info()).icon = (SPRITE)(UI.icons()).m.time;
/* 738 */     init.upers.add(new StatsInit.StatUpdatable()
/*     */         {
/* 740 */           int ri = 0;
/*     */           
/*     */           public void update(double ds) {
/* 743 */             ds *= (RACES.all().size() * 16384);
/* 744 */             ds /= TIME.secondsPerDay() * 4.0D;
/* 745 */             if (this.ri >= RACES.all().size()) {
/* 746 */               this.ri = 0;
/*     */             }
/* 748 */             int ids = (int)ds;
/* 749 */             if (RND.rFloat() < ds - ids) {
/* 750 */               ids++;
/*     */             }
/*     */             
/* 753 */             Race r = (Race)RACES.all().get(this.ri);
/* 754 */             this.ri++;
/*     */             
/* 756 */             for (HCLASS cl : HCLASSES.ALLP()) {
/* 757 */               double dd = dec.getD(cl, r);
/* 758 */               int current = count.get((MAPPED)cl).get((MAPPED)r);
/*     */               
/* 760 */               if (dd < 0.25D) {
/* 761 */                 dd = -(0.25D - dd);
/*     */               } else {
/* 763 */                 dd -= 0.25D;
/*     */               } 
/* 765 */               int target = (int)(16384.0D * dd);
/* 766 */               if (current < target) {
/* 767 */                 current += ids;
/* 768 */                 if (current > target)
/* 769 */                   current = target; 
/* 770 */               } else if (current > target) {
/* 771 */                 current -= ids;
/* 772 */                 if (current < target)
/* 773 */                   current = target; 
/*     */               } 
/* 775 */               count.get((MAPPED)cl).set((MAPPED)r, current);
/*     */             } 
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 781 */     this.RETIREMENT_AGE.standing = new StatStanding(this.RETIREMENT_AGE, 0.25D);
/* 782 */     this.RETIREMENT_AGE.addDecree(dec);
/*     */ 
/*     */ 
/*     */     
/* 786 */     this.RETIREMENT_HOME = (STAT)new STATFake("RETIREMENT", init)
/*     */       {
/*     */ 
/*     */         
/*     */         protected double getDD(HCLASS cl, Race r, int daysBack)
/*     */         {
/* 792 */           double am = STATS.POP().pop(r, HTYPES.RETIREE(), 0);
/* 793 */           double dRet = 5.0D * am / (STATS.POP()).POP.data().get(r);
/* 794 */           dRet = CLAMP.d(dRet, 0.0D, 1.0D);
/*     */ 
/*     */ 
/*     */           
/* 798 */           double access = StatsWork.Retirement.this.RETIREMENT_HOME_ACCESS.data(cl).getD(r, 0);
/* 799 */           double quality = StatsWork.Retirement.this.RETIREMENT_HOME_QUALITY.data(cl).getD(r, 0);
/* 800 */           double type = StatsWork.Retirement.this.RETIREMENT_HOME_TYPE.data(cl).getD(r, 0);
/*     */           
/* 802 */           double res = dRet * access * (0.5D + quality * 0.5D * type);
/*     */           
/* 804 */           return 0.2D * dRet + 0.8D * res;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public int pdivider(HCLASS c, Race r, int daysback) {
/* 810 */           return 1;
/*     */         }
/*     */ 
/*     */         
/*     */         public void hover(GUI_BOX text, HCLASS cl, Race r) {
/* 815 */           StatHoverer.hover(text, (STAT)this);
/*     */           
/* 817 */           GBox b = (GBox)text;
/* 818 */           b.sep();
/* 819 */           b.NL();
/* 820 */           double am = STATS.POP().pop(r, HTYPES.RETIREE(), 0);
/* 821 */           double dRet = Math.sqrt(5.0D * am / (STATS.POP()).POP.data().get(r));
/* 822 */           dRet = CLAMP.d(dRet, 0.0D, 1.0D);
/*     */           
/* 824 */           b.textL((HTYPES.RETIREE()).names);
/* 825 */           b.tab(6);
/* 826 */           b.add((SPRITE)GFORMAT.i(b.text(), (int)am));
/* 827 */           b.add((SPRITE)(UI.icons()).s.arrow_right);
/* 828 */           b.add((SPRITE)GFORMAT.i(b.text(), ((STATS.POP()).POP.data().get(r) / 5)));
/* 829 */           b.NL();
/*     */           
/* 831 */           double access = StatsWork.Retirement.this.RETIREMENT_HOME_ACCESS.data(cl).getD(r, 0);
/* 832 */           double quality = StatsWork.Retirement.this.RETIREMENT_HOME_QUALITY.data(cl).getD(r, 0);
/* 833 */           double type = StatsWork.Retirement.this.RETIREMENT_HOME_TYPE.data(cl).getD(r, 0);
/*     */           
/* 835 */           b.textL((StatsWork.Retirement.this.RETIREMENT_HOME_ACCESS.info()).name);
/* 836 */           b.tab(6);
/* 837 */           b.add((SPRITE)GFORMAT.perc(b.text(), access));
/* 838 */           b.NL();
/*     */           
/* 840 */           b.textL((StatsWork.Retirement.this.RETIREMENT_HOME_QUALITY.info()).name);
/* 841 */           b.tab(6);
/* 842 */           b.add((SPRITE)GFORMAT.perc(b.text(), quality));
/* 843 */           b.NL();
/*     */           
/* 845 */           b.textL((StatsWork.Retirement.this.RETIREMENT_HOME_TYPE.info()).name);
/* 846 */           b.tab(6);
/* 847 */           b.add((SPRITE)GFORMAT.perc(b.text(), type));
/* 848 */           b.NL();
/*     */           
/* 850 */           b.sep();
/* 851 */           StatHoverer.hover(text, (STAT)this, cl, r);
/*     */         }
/*     */       };
/*     */     
/* 855 */     (this.RETIREMENT_HOME.info()).icon = ((ROOM_RESTHOME)(SETT.ROOMS()).RESTHOMES.get(0)).icon.medium;
/*     */     
/* 857 */     init.count.getClass(); this.RETIREMENT_HOME_ACCESS = (STAT)new StatsWork.StatRet(init, (DataO<Induvidual>.DataAbs)new DataO.DataBit(init.count, "WORK_RA"), 
/* 858 */         Dic.¤¤Access, StatsWork.¤¤accessD);
/* 859 */     init.count.getClass(); this.RETIREMENT_HOME_QUALITY = (STAT)new StatsWork.StatRet(init, (DataO<Induvidual>.DataAbs)new DataO.DataNibble(init.count, "WORK_RQ"), 
/* 860 */         Dic.¤¤Quality, StatsWork.¤¤qualityD);
/* 861 */     this.RETIREMENT_HOME_TYPE = new STATFakeData(null, "WORK_RT", init, new StatInfo(StatsWork.¤¤Type, StatsWork.¤¤TypeD))
/*     */       {
/*     */         protected double getDD(HCLASS cl, Race race)
/*     */         {
/* 865 */           double v = fValues[(HCLASS_RACE.clP(race, cl)).index] / 256.0D;
/* 866 */           double pop = STATS.POP().pop(race, HTYPES.RETIREE());
/* 867 */           if (pop > 0.0D) {
/* 868 */             return v / pop;
/*     */           }
/* 870 */           return 0.0D;
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean shoudRetire(Induvidual i) {
/* 877 */     int oa = (STATS.POP()).age.lifespan(i);
/* 878 */     double oldAge = oa * (0.4D + 0.6D * (1.0D - this.RETIREMENT_AGE.decree().getD(i.clas(), i.race())));
/* 879 */     return ((STATS.POP()).age.DAYS.get(i) >= oldAge);
/*     */   }
/*     */   
/*     */   public int estimate(HCLASS cl, Race race, double dec) {
/* 883 */     double fromD = 1.0D - 0.6D * dec;
/* 884 */     fromD *= (STATS.POP().demography().historyRecords() - 1);
/* 885 */     double am = 0.0D;
/* 886 */     am += (1.0D - fromD - (int)fromD) * STATS.POP().demography().getD(race, (int)fromD);
/* 887 */     int fi = (int)fromD;
/* 888 */     fi++;
/* 889 */     for (; fi < STATS.POP().demography().historyRecords(); fi++) {
/* 890 */       am += STATS.POP().demography().getD(race, fi);
/*     */     }
/* 892 */     return (int)Math.ceil(am);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\colls\StatsWork$Retirement.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */