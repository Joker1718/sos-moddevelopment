/*     */ package settlement.stats.service;
/*     */ 
/*     */ import init.race.Race;
/*     */ import init.type.HCLASS;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.StatsInit;
/*     */ import settlement.stats.stat.STAT;
/*     */ import settlement.stats.stat.STATData;
/*     */ import settlement.stats.stat.STATFake;
/*     */ import settlement.stats.stat.StatInfo;
/*     */ import settlement.stats.util.StatHoverer;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.DataO;
/*     */ import util.gui.misc.GBox;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.Dic;
/*     */ 
/*     */ public class StatServiceBench extends StatServiceImp {
/*     */   public final STAT access;
/*     */   public final STAT quality;
/*     */   public final STAT upgrade;
/*     */   public final STAT total;
/*     */   
/*     */   StatServiceBench(LISTE<StatServiceImp> all, StatsInit init) {
/*  29 */     super("BENCH", all, init, (SETT.ROOMS()).BENCH.info.name, (SETT.ROOMS()).BENCH.info.desc, (SPRITE)(SETT.ROOMS()).BENCH.icon, null);
/*     */     
/*  31 */     init.count.getClass(); this.access = (STAT)new STATData(null, init, (DataO.DataAbs)new DataO.DataBit(init.count, "ACCESS_BENCH"), new StatInfo(Dic.¤¤Access, Dic.¤¤Access, ¤¤AcessDesc));
/*  32 */     init.count.getClass(); this.quality = (STAT)new STATData(null, init, (DataO.DataAbs)new DataO.DataCrumb(init.count, "QUALITY_BENCH"), new StatInfo(Dic.¤¤Quality, Dic.¤¤Quality, ¤¤QualityDesc));
/*  33 */     init.count.getClass(); this.upgrade = (STAT)new STATData(null, init, (DataO.DataAbs)new DataO.DataNibble(init.count, "UPGRADE_BENCH"), new StatInfo(Dic.¤¤Upgrade, Dic.¤¤Upgrade, ¤¤UpDesc));
/*  34 */     this.upgrade.info().setMatters(false, true);
/*  35 */     this.access.info().setMatters(false, false);
/*  36 */     this.quality.info().setMatters(false, false);
/*     */ 
/*     */     
/*  39 */     init.onArrivalStats.add(this.access);
/*  40 */     init.onArrivalStats.add(this.quality);
/*     */     
/*  42 */     this.access.info().setMatters(false, true);
/*  43 */     this.quality.info().setMatters(false, true);
/*     */     
/*  45 */     init.onArrivalStats.add(this.access);
/*     */ 
/*     */     
/*  48 */     StatInfo info = new StatInfo((SETT.ROOMS()).BENCH.info.name, String.valueOf(Dic.¤¤Access) + ": " + String.valueOf(Dic.¤¤Access));
/*     */     
/*  50 */     this.total = (STAT)new STATFake("BENCH", init, info)
/*     */       {
/*     */         protected double getDD(HCLASS s, Race r, int daysBack)
/*     */         {
/*  54 */           double a = StatServiceBench.this.access.data(s).getD(r, daysBack);
/*  55 */           if (a == 0.0D)
/*  56 */             return 0.0D; 
/*  57 */           double q = StatServiceBench.this.quality.data(s).getD(r, daysBack) / a;
/*  58 */           double u = StatServiceBench.this.upgrade.data(s).getD(r, daysBack) / a;
/*  59 */           return a * (0.2D + 0.8D * u) * (0.5D + 0.5D * q);
/*     */         }
/*     */ 
/*     */         
/*     */         public void hover(GUI_BOX text, HCLASS cl, Race race) {
/*  64 */           GBox b = (GBox)text;
/*  65 */           StatHoverer.hover((GUI_BOX)b, (STAT)this);
/*  66 */           b.sep();
/*  67 */           b.textLL((StatServiceBench.this.access.info()).name);
/*  68 */           b.add((SPRITE)GFORMAT.perc(b.text(), StatServiceBench.this.access.data(cl).getD(race)));
/*  69 */           b.NL().text((StatServiceBench.this.access.info()).desc);
/*  70 */           b.NL(4);
/*  71 */           b.textLL((StatServiceBench.this.quality.info()).name);
/*  72 */           b.add((SPRITE)GFORMAT.perc(b.text(), StatServiceBench.this.quality.data(cl).getD(race) / StatServiceBench.this.access.data(cl).getD(race)));
/*  73 */           b.NL().text((StatServiceBench.this.quality.info()).desc);
/*  74 */           b.NL(4);
/*  75 */           b.textLL((StatServiceBench.this.upgrade.info()).name);
/*  76 */           b.add((SPRITE)GFORMAT.perc(b.text(), StatServiceBench.this.upgrade.data(cl).getD(race) / StatServiceBench.this.access.data(cl).getD(race)));
/*  77 */           b.NL().text((StatServiceBench.this.upgrade.info()).desc);
/*  78 */           b.NL(4);
/*  79 */           b.textLL(Dic.¤¤Total);
/*  80 */           b.add((SPRITE)GFORMAT.perc(b.text(), data(cl).getD(race)));
/*     */           
/*  82 */           b.sep();
/*  83 */           StatHoverer.hover(text, (STAT)this, cl, race);
/*     */         }
/*     */ 
/*     */         
/*     */         protected double induGet(Induvidual t) {
/*  88 */           double a = StatServiceBench.this.access.indu().getD(t);
/*  89 */           if (a == 0.0D)
/*  90 */             return 0.0D; 
/*  91 */           double q = StatServiceBench.this.quality.indu().getD(t);
/*  92 */           double u = StatServiceBench.this.upgrade.indu().getD(t);
/*     */           
/*  94 */           return a * (0.2D + 0.8D * u) * (0.5D + 0.5D * q);
/*     */         }
/*     */ 
/*     */         
/*     */         public void hover(GUI_BOX text, Induvidual indu) {
/*  99 */           GBox b = (GBox)text;
/* 100 */           StatHoverer.hover((GUI_BOX)b, (STAT)this);
/* 101 */           b.sep();
/* 102 */           b.textLL((StatServiceBench.this.access.info()).name);
/* 103 */           b.add((SPRITE)GFORMAT.perc(b.text(), StatServiceBench.this.access.indu().getD(indu)));
/* 104 */           b.NL().text((StatServiceBench.this.access.info()).desc);
/* 105 */           b.NL(4);
/* 106 */           b.textLL((StatServiceBench.this.quality.info()).name);
/* 107 */           b.add((SPRITE)GFORMAT.perc(b.text(), StatServiceBench.this.quality.indu().getD(indu) / StatServiceBench.this.access.indu().getD(indu)));
/* 108 */           b.NL().text((StatServiceBench.this.quality.info()).desc);
/* 109 */           b.NL(4);
/* 110 */           b.textLL((StatServiceBench.this.upgrade.info()).name);
/* 111 */           b.add((SPRITE)GFORMAT.perc(b.text(), StatServiceBench.this.upgrade.indu().getD(indu) / StatServiceBench.this.access.indu().getD(indu)));
/* 112 */           b.NL().text((StatServiceBench.this.upgrade.info()).desc);
/* 113 */           b.NL(4);
/* 114 */           b.textLL(Dic.¤¤Total);
/* 115 */           b.add((SPRITE)GFORMAT.perc(b.text(), indu().getD(indu)));
/*     */           
/* 117 */           b.sep();
/* 118 */           StatHoverer.hover(text, (STAT)this, indu);
/*     */         }
/*     */       };
/*     */     
/* 122 */     (this.total.info()).icon = (SETT.ROOMS()).BENCH.icon.resized(16);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAccess(Induvidual i, boolean access, double quality, int upgrade) {
/* 128 */     this.access.indu().set(i, access ? 1 : 0);
/* 129 */     if (!access) {
/* 130 */       quality = 0.0D;
/* 131 */       upgrade = -1;
/*     */     } 
/*     */     
/* 134 */     this.quality.indu().setD(i, quality);
/*     */     
/* 136 */     this.upgrade.indu().setD(i, (upgrade + 1.0D) / ((SETT.ROOMS()).BENCH.upgrades().max() + 1.0D));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean access(Humanoid h) {
/* 141 */     return (this.access.indu().get(h.indu()) == 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public STAT total() {
/* 146 */     return this.total;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void clearAccess(Induvidual i) {
/* 152 */     this.access.indu().set(i, 0);
/* 153 */     this.quality.indu().set(i, 0);
/* 154 */     this.upgrade.indu().set(i, 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void cheatSetTotal(Induvidual i, double tot) {
/* 159 */     this.access.indu().set(i, (tot > 0.0D) ? 1 : 0);
/* 160 */     this.quality.indu().setD(i, tot);
/* 161 */     this.upgrade.indu().set(i, 0);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\service\StatServiceBench.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */