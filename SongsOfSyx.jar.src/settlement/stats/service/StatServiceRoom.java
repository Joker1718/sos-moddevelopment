/*     */ package settlement.stats.service;
/*     */ 
/*     */ import game.boosting.BOOSTING;
/*     */ import game.boosting.BSourceInfo;
/*     */ import game.boosting.BValue;
/*     */ import game.boosting.BoostSpec;
/*     */ import game.boosting.Booster;
/*     */ import game.boosting.BoosterValue;
/*     */ import init.race.Race;
/*     */ import init.race.bio.Opinion;
/*     */ import init.type.HCLASS;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.room.service.module.RoomServiceAccess;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.StatsInit;
/*     */ import settlement.stats.standing.StatStanding;
/*     */ import settlement.stats.stat.STAT;
/*     */ import settlement.stats.stat.STATData;
/*     */ import settlement.stats.stat.STATFake;
/*     */ import settlement.stats.stat.StatInfo;
/*     */ import settlement.stats.util.StatBooster;
/*     */ import settlement.stats.util.StatHoverer;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.DataO;
/*     */ import util.gui.misc.GBox;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.Dic;
/*     */ 
/*     */ public final class StatServiceRoom extends StatServiceImp {
/*     */   public static final int TARGET_MAX = 16;
/*     */   private final STAT access;
/*     */   private final STAT quality;
/*     */   private final STAT proximity;
/*     */   private final STAT upgrade;
/*     */   private final STAT total;
/*     */   private final RoomServiceAccess room;
/*     */   
/*     */   StatServiceRoom(LISTE<StatServiceImp> all, final RoomServiceAccess service, StatsInit init) {
/*  44 */     super((service.room()).key, all, init, (service.room()).info.name, (service.room()).info.desc, (SPRITE)(service.room()).icon, service.need);
/*  45 */     this.room = service;
/*     */ 
/*     */     
/*  48 */     this.access = (STAT)new STATData(null, init, (DataO.DataAbs)new DataO.DataBit(init.count, "SERVICEA_" + (service().room()).key), new StatInfo(¤¤Access, ¤¤Access, ¤¤AcessDesc));
/*  49 */     this.access.info().setMatters(false, true);
/*  50 */     this.quality = (STAT)new STATData(null, init, (DataO.DataAbs)new DataO.DataNibble(init.count, "SERVICEQ_" + (service().room()).key), new StatInfo(¤¤Quality, ¤¤Quality, ¤¤QualityDesc));
/*  51 */     this.quality.info().setMatters(false, true);
/*  52 */     this.proximity = (STAT)new STATData(null, init, (DataO.DataAbs)new DataO.DataNibble(init.count, "SERVICEP_" + (service().room()).key), new StatInfo(¤¤Distance, ¤¤Distance, ¤¤DistanceDesc));
/*  53 */     this.proximity.info().setMatters(false, true);
/*  54 */     this.upgrade = (STAT)new STATData(null, init, (DataO.DataAbs)new DataO.DataNibble(init.count, "SERVICEUP_" + (service().room()).key), new StatInfo(Dic.¤¤Upgrade, Dic.¤¤Upgrade, ¤¤UpDesc));
/*  55 */     this.upgrade.info().setMatters(false, true);
/*     */     
/*  57 */     init.onArrivalStats.add(this.access);
/*  58 */     init.onArrivalStats.add(this.quality);
/*  59 */     init.onArrivalStats.add(this.proximity);
/*  60 */     init.onArrivalStats.add(this.upgrade);
/*     */     
/*  62 */     StatInfo info = new StatInfo((service.room()).info.names, ¤¤TotalDesc);
/*  63 */     info.setOpinion((new Opinion()).setMore((CharSequence[])service.induMore));
/*     */     
/*  65 */     this.total = (STAT)new STATFake((service().room()).key, init, info)
/*     */       {
/*     */         
/*     */         protected double getDD(HCLASS s, Race r, int daysBack)
/*     */         {
/*  70 */           double a = StatServiceRoom.this.access.data(s).getD(r, daysBack);
/*  71 */           if (a == 0.0D)
/*  72 */             return 0.0D; 
/*  73 */           double q = StatServiceRoom.this.quality.data(s).getD(r, daysBack) / a;
/*  74 */           double p = StatServiceRoom.this.proximity.data(s).getD(r, daysBack) / a;
/*  75 */           double u = StatServiceRoom.this.upgrade.data(s).getD(r, daysBack) / a;
/*  76 */           return a * (0.2D + 0.8D * u) * (0.2D + 0.8D * q) * (
/*  77 */             0.5D + 0.5D * p);
/*     */         }
/*     */ 
/*     */         
/*     */         public double induGet(Induvidual t) {
/*  82 */           double a = StatServiceRoom.this.access.indu().getD(t);
/*  83 */           if (a == 0.0D)
/*  84 */             return 0.0D; 
/*  85 */           double q = StatServiceRoom.this.quality.indu().getD(t);
/*  86 */           double p = StatServiceRoom.this.proximity.indu().getD(t);
/*  87 */           double u = StatServiceRoom.this.upgrade.indu().getD(t);
/*     */           
/*  89 */           return a * (0.2D + 0.8D * u) * (0.2D + 0.8D * q) * (
/*  90 */             0.5D + 0.5D * p);
/*     */         }
/*     */ 
/*     */         
/*     */         public void hover(GUI_BOX text, HCLASS cl, Race race) {
/*  95 */           GBox b = (GBox)text;
/*  96 */           StatHoverer.hover((GUI_BOX)b, (STAT)this);
/*  97 */           b.sep();
/*  98 */           b.textLL((StatServiceRoom.this.access().info()).name);
/*  99 */           b.add((SPRITE)GFORMAT.perc(b.text(), StatServiceRoom.this.access().data(cl).getD(race)));
/* 100 */           b.NL().text((StatServiceRoom.this.access().info()).desc);
/* 101 */           b.NL(4);
/* 102 */           b.textLL((StatServiceRoom.this.proximity().info()).name);
/* 103 */           double p = StatServiceRoom.this.proximity().data(cl).getD(race) / StatServiceRoom.this.access().data(cl).getD(race);
/*     */           
/* 105 */           b.add((SPRITE)GFORMAT.perc(b.text(), p));
/* 106 */           b.NL().text((StatServiceRoom.this.proximity().info()).desc);
/* 107 */           b.NL(4);
/* 108 */           b.textLL((StatServiceRoom.this.quality().info()).name);
/* 109 */           b.add((SPRITE)GFORMAT.perc(b.text(), CLAMP.d(StatServiceRoom.this.quality().data(cl).getD(race) / StatServiceRoom.this.access().data(cl).getD(race), 0.0D, 1.0D)));
/* 110 */           b.NL().text((StatServiceRoom.this.quality().info()).desc);
/* 111 */           b.NL(4);
/* 112 */           b.textLL((StatServiceRoom.this.upgrade().info()).name);
/* 113 */           b.add((SPRITE)GFORMAT.perc(b.text(), StatServiceRoom.this.upgrade().data(cl).getD(race) / StatServiceRoom.this.access().data(cl).getD(race)));
/* 114 */           b.NL().text((StatServiceRoom.this.upgrade().info()).desc);
/* 115 */           b.NL(4);
/* 116 */           b.textLL(Dic.¤¤Total);
/* 117 */           b.add((SPRITE)GFORMAT.perc(b.text(), data(cl).getD(race)));
/*     */           
/* 119 */           b.sep();
/* 120 */           StatHoverer.hover(text, (STAT)this, cl, race);
/*     */         }
/*     */ 
/*     */         
/*     */         public void hover(GUI_BOX text, Induvidual indu) {
/* 125 */           GBox b = (GBox)text;
/* 126 */           StatHoverer.hover((GUI_BOX)b, (STAT)this);
/* 127 */           b.sep();
/* 128 */           b.textLL((StatServiceRoom.this.access().info()).name);
/* 129 */           b.add((SPRITE)GFORMAT.perc(b.text(), StatServiceRoom.this.access().indu().getD(indu)));
/* 130 */           b.NL().text((StatServiceRoom.this.access().info()).desc);
/* 131 */           b.NL(4);
/* 132 */           b.textLL((StatServiceRoom.this.proximity().info()).name);
/*     */ 
/*     */           
/* 135 */           b.add((SPRITE)GFORMAT.perc(b.text(), StatServiceRoom.this.proximity().indu().getD(indu) / StatServiceRoom.this.access().indu().getD(indu)));
/* 136 */           b.NL().text((StatServiceRoom.this.proximity().info()).desc);
/* 137 */           b.NL(4);
/* 138 */           b.textLL((StatServiceRoom.this.quality().info()).name);
/* 139 */           b.add((SPRITE)GFORMAT.perc(b.text(), StatServiceRoom.this.quality().indu().getD(indu) / StatServiceRoom.this.access().indu().getD(indu)));
/* 140 */           b.NL().text((StatServiceRoom.this.quality().info()).desc);
/* 141 */           b.NL(4);
/* 142 */           b.textLL((StatServiceRoom.this.upgrade().info()).name);
/* 143 */           b.add((SPRITE)GFORMAT.perc(b.text(), StatServiceRoom.this.upgrade().indu().getD(indu) / StatServiceRoom.this.access().indu().getD(indu)));
/* 144 */           b.NL().text((StatServiceRoom.this.upgrade().info()).desc);
/* 145 */           b.NL(4);
/* 146 */           b.textLL(Dic.¤¤Total);
/* 147 */           b.add((SPRITE)GFORMAT.perc(b.text(), indu().getD(indu)));
/*     */           
/* 149 */           b.sep();
/* 150 */           StatHoverer.hover(text, (STAT)this, indu);
/*     */         }
/*     */       };
/*     */     
/* 154 */     this.total.standing = new StatStanding(this.total, 0.0D, (service()).standingDef);
/* 155 */     (this.total.info()).icon = (service.room()).icon.resized(16);
/* 156 */     BOOSTING.connecter(new ACTION()
/*     */         {
/*     */           public void exe()
/*     */           {
/* 160 */             for (BoostSpec t : service.boosts.all()) {
/*     */               
/* 162 */               StatBooster statBooster = StatBooster.make(StatServiceRoom.this.total);
/* 163 */               BSourceInfo in = new BSourceInfo((service.room()).info.names, (service.room()).icon.small);
/* 164 */               BoosterValue boosterValue = new BoosterValue((BValue)statBooster, in, t.booster.from(), t.booster.to(), t.booster.isMul);
/*     */               
/* 166 */               StatServiceRoom.this.total.boosters.push((Booster)boosterValue, t.boostable);
/*     */             } 
/*     */           }
/*     */         });
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
/*     */   public boolean access(Humanoid h) {
/* 182 */     return (this.access.indu().get(h.indu()) == 1);
/*     */   }
/*     */   
/*     */   public double quality(Humanoid h) {
/* 186 */     return this.quality.indu().getD(h.indu());
/*     */   }
/*     */   
/*     */   public double proximity(Humanoid h) {
/* 190 */     return this.proximity.indu().getD(h.indu());
/*     */   }
/*     */   
/*     */   public double total(Humanoid h) {
/* 194 */     return total(h.indu());
/*     */   }
/*     */   
/*     */   public double total(Induvidual a) {
/* 198 */     return this.access.indu().getD(a) * (0.2D + this.quality.indu().getD(a) * 0.8D) * (
/* 199 */       0.5D + this.proximity.indu().getD(a) * 0.5D) * (
/* 200 */       0.5D + this.upgrade.indu().getD(a) * 0.5D);
/*     */   }
/*     */   
/*     */   protected double pdivider(HCLASS c, Race r, int daysback) {
/* 204 */     return (STATS.POP()).POP.data(c).get(r, daysback);
/*     */   }
/*     */   
/*     */   public void setAccess(Humanoid h, boolean access, double quality, double proximity, int upgrade) {
/* 208 */     setAccess(h.indu(), access, quality, proximity, upgrade);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setAccess(Induvidual i, boolean access, double quality, double proximity, int upgrade) {
/* 213 */     this.access.indu().set(i, access ? 1 : 0);
/* 214 */     if (!access) {
/* 215 */       quality = 0.0D;
/* 216 */       proximity = 0.0D;
/* 217 */       upgrade = -1;
/*     */     } 
/*     */     
/* 220 */     this.quality.indu().setD(i, quality);
/* 221 */     this.proximity.indu().setD(i, proximity);
/*     */     
/* 223 */     this.upgrade.indu().setD(i, (upgrade + 1.0D) / (this.room.room().upgrades().max() + 1.0D));
/*     */   }
/*     */ 
/*     */   
/*     */   public void clearAccess(Induvidual i) {
/* 228 */     setAccess(i, false, 0.0D, 0.0D, 0);
/*     */   }
/*     */   
/*     */   public void setProximity(Humanoid h, double proximity) {
/* 232 */     Induvidual i = h.indu();
/* 233 */     this.proximity.indu().setD(i, proximity);
/*     */   }
/*     */   
/*     */   public RoomServiceAccess service() {
/* 237 */     return this.room;
/*     */   }
/*     */   
/*     */   public STAT access() {
/* 241 */     return this.access;
/*     */   }
/*     */   
/*     */   public STAT quality() {
/* 245 */     return this.quality;
/*     */   }
/*     */   
/*     */   public STAT upgrade() {
/* 249 */     return this.upgrade;
/*     */   }
/*     */   
/*     */   public STAT proximity() {
/* 253 */     return this.proximity;
/*     */   }
/*     */ 
/*     */   
/*     */   public STAT total() {
/* 258 */     return this.total;
/*     */   }
/*     */ 
/*     */   
/*     */   public void cheatSetTotal(Induvidual i, double tot) {
/* 263 */     this.access.indu().set(i, (tot > 0.0D) ? 1 : 0);
/* 264 */     this.quality.indu().setD(i, tot);
/* 265 */     this.upgrade.indu().setD(i, tot);
/* 266 */     this.proximity.indu().setD(i, tot);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\service\StatServiceRoom.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */