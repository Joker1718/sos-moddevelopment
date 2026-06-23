/*     */ package settlement.stats.colls;
/*     */ 
/*     */ import game.boosting.BOOSTING;
/*     */ import game.boosting.BSourceInfo;
/*     */ import game.boosting.BValue;
/*     */ import game.boosting.BoostSpec;
/*     */ import game.boosting.Booster;
/*     */ import game.boosting.BoosterValue;
/*     */ import init.race.Race;
/*     */ import init.type.HCLASS;
/*     */ import settlement.room.infra.monument.ROOM_MONUMENT;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.StatsInit;
/*     */ import settlement.stats.standing.StatStanding;
/*     */ import settlement.stats.stat.STAT;
/*     */ import settlement.stats.stat.STATData;
/*     */ import settlement.stats.stat.STATFake;
/*     */ import settlement.stats.stat.StatInfo;
/*     */ import settlement.stats.util.StatBooster;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.DataO;
/*     */ import util.gui.misc.GBox;
/*     */ import util.info.GFORMAT;
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
/*     */ public class StatMonument
/*     */   extends STATFake
/*     */ {
/*     */   public ROOM_MONUMENT m;
/*     */   public final STAT upgrade;
/*     */   public final STAT amount;
/*     */   public final STAT access;
/*     */   private final STAT degrade;
/*     */   
/*     */   StatMonument(final ROOM_MONUMENT m, StatsInit init, STAT degrade) {
/* 263 */     super(m.key, init, new StatInfo(m.info.name, m.info.names, StatsAccess.¤¤MonumentsD));
/* 264 */     this.access = (STAT)new STATData(null, init, (DataO.DataAbs)new DataO.DataBit(init.count, "ACCESS_" + m.key));
/* 265 */     this.amount = (STAT)new STATData(null, init, (DataO.DataAbs)new DataO.DataNibble(init.count, "AMOUNT_" + m.key));
/* 266 */     this.upgrade = (STAT)new STATData(null, init, (DataO.DataAbs)new DataO.DataCrumb(init.count, m.key + "dupgrade"), null);
/* 267 */     this.degrade = degrade;
/* 268 */     this.m = m;
/* 269 */     this.info.icon = (SPRITE)m.icon;
/* 270 */     this.info.setOpinion(m.opinion);
/* 271 */     this.standing = new StatStanding((STAT)this, 0.0D, m.defaultStanding);
/* 272 */     info().setMatters(true, false);
/* 273 */     BOOSTING.connecter(new ACTION()
/*     */         {
/*     */           public void exe()
/*     */           {
/* 277 */             for (BoostSpec t : m.boosts.all()) {
/*     */               
/* 279 */               StatBooster statBooster = StatBooster.make((STAT)StatsAccess.StatMonument.this);
/* 280 */               BSourceInfo in = new BSourceInfo(StatsAccess.StatMonument.this.info.names, m.icon.small);
/* 281 */               BoosterValue boosterValue = new BoosterValue((BValue)statBooster, in, t.booster.from(), t.booster.to(), t.booster.isMul);
/*     */               
/* 283 */               StatsAccess.StatMonument.this.boosters.push((Booster)boosterValue, t.boostable);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected double getDD(HCLASS s, Race r, int daysBack) {
/* 314 */     double acc = this.access.data(s).get(r, daysBack);
/* 315 */     if (acc == 0.0D) {
/* 316 */       return 0.0D;
/*     */     }
/*     */     
/* 319 */     double d = this.amount.data(s).get(r, daysBack) / acc * this.m.maxEnv();
/* 320 */     d = CLAMP.d(d, 0.0D, 1.0D);
/*     */ 
/*     */ 
/*     */     
/* 324 */     d *= 1.0D - this.degrade.data(s).get(r, daysBack) / acc;
/*     */     
/* 326 */     if (this.m.upgrades().max() > 0) {
/* 327 */       d *= (this.upgrade.data(s).get(r) + acc) / acc * (1 + this.m.upgrades().max());
/*     */     }
/*     */     
/* 330 */     return d * this.access.data(s).getD(r, daysBack);
/*     */   }
/*     */ 
/*     */   
/*     */   public double induGet(Induvidual t) {
/* 335 */     double a = this.amount.indu().get(t) / this.m.maxEnv();
/* 336 */     a = CLAMP.d(a, 0.0D, 1.0D);
/* 337 */     a *= (1 - this.degrade.indu().get(t));
/* 338 */     return a;
/*     */   }
/*     */ 
/*     */   
/*     */   public int dataDivider() {
/* 343 */     return 128;
/*     */   }
/*     */ 
/*     */   
/*     */   public void hover(GUI_BOX text, HCLASS cl, Race type) {
/* 348 */     GBox b = (GBox)text;
/* 349 */     b.text(this.m.info.desc);
/* 350 */     b.sep();
/* 351 */     double acc = this.access.data(cl).get(type);
/*     */     
/* 353 */     b.textL(Dic.¤¤Access);
/* 354 */     b.tab(6);
/* 355 */     double d = 0.0D;
/* 356 */     if (acc > 0.0D)
/* 357 */       d = this.amount.data(cl).get(type) / acc * this.m.maxEnv(); 
/* 358 */     b.add((SPRITE)GFORMAT.perc(b.text(), d));
/* 359 */     b.NL();
/*     */     
/* 361 */     b.textL(StatsAccess.¤¤MonumentsDeg);
/* 362 */     b.tab(6);
/* 363 */     d = 0.0D;
/* 364 */     if (acc > 0.0D)
/* 365 */       d = this.degrade.data(cl).get(type) / acc; 
/* 366 */     b.add((SPRITE)GFORMAT.percInv(b.text(), d));
/* 367 */     b.NL();
/*     */     
/* 369 */     if (this.m.upgrades().max() > 0) {
/* 370 */       b.textL(Dic.¤¤Upgrade);
/* 371 */       b.tab(6);
/* 372 */       b.add((SPRITE)GFORMAT.perc(b.text(), (this.upgrade.data(cl).get(type) + acc) / acc * (1 + this.m.upgrades().max())));
/* 373 */       b.NL(4);
/*     */     } 
/*     */     
/* 376 */     super.hover(text, cl, type);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void hover(GUI_BOX text, Induvidual indu) {
/* 382 */     GBox b = (GBox)text;
/* 383 */     b.text(this.m.info.desc);
/* 384 */     b.sep();
/*     */     
/* 386 */     b.textL(Dic.¤¤Access);
/* 387 */     b.tab(7);
/* 388 */     double d = this.amount.indu().get(indu) / this.m.maxEnv();
/* 389 */     b.add((SPRITE)GFORMAT.perc(b.text(), d));
/* 390 */     b.NL();
/*     */     
/* 392 */     b.textL(StatsAccess.¤¤MonumentsDeg);
/* 393 */     b.tab(7);
/* 394 */     b.add((SPRITE)GFORMAT.perc(b.text(), this.degrade.indu().getD(indu)));
/* 395 */     b.NL();
/*     */     
/* 397 */     if (this.m.upgrades().max() > 0) {
/* 398 */       b.textL(Dic.¤¤Upgrade);
/* 399 */       b.tab(6);
/* 400 */       b.add((SPRITE)GFORMAT.perc(b.text(), this.upgrade.indu().get(indu) / this.m.upgrades().max()));
/* 401 */       b.NL(4);
/*     */     } 
/*     */     
/* 404 */     super.hover(text, indu);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\colls\StatsAccess$StatMonument.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */