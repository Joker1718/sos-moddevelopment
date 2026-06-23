/*     */ package settlement.stats.colls;
/*     */ 
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.Boostable;
/*     */ import init.type.CAUSE_LEAVE;
/*     */ import init.type.CAUSE_LEAVES;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.HTYPES;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.StatsInit;
/*     */ import settlement.stats.stat.STAT;
/*     */ import settlement.stats.stat.STATData;
/*     */ import settlement.tilemap.terrain.Terrain;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import util.data.DataO;
/*     */ import util.data.INT_O;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class StatExposure
/*     */ {
/*     */   public final STAT DANGER;
/*     */   public final STAT COUNT;
/*     */   private final INT_O.INT_OE<Induvidual> count;
/*     */   private final INT_O.INT_OE<Induvidual> type;
/* 314 */   private final int hidden = 8;
/* 315 */   private final int critical = 26;
/*     */ 
/*     */   
/*     */   private StatExposure(StatsInit init) {
/* 319 */     init.count.getClass(); this.count = (INT_O.INT_OE<Induvidual>)new DataO<Induvidual>.DataNibble1(init.count, "NEED_EXPOSURE")
/*     */       {
/*     */         public void set(Induvidual t, int v) {
/* 322 */           super.set(t, v);
/* 323 */           StatsNeeds.StatExposure.this.DANGER.indu().set(t, StatsNeeds.StatExposure.this.critical(t) ? 1 : 0);
/*     */         }
/*     */       };
/* 326 */     init.count.getClass(); this.type = (INT_O.INT_OE<Induvidual>)new DataO.DataBit(init.count, "NEED_EXPOSURE_TYPE");
/*     */     
/* 328 */     INT_O.INT_OE<Induvidual> statCount = new INT_O.INT_OE<Induvidual>() {
/* 329 */         final int max = StatsNeeds.StatExposure.this.count.max(null) - 8;
/*     */ 
/*     */         
/*     */         public void set(Induvidual t, int s) {
/* 333 */           s += 8;
/* 334 */           s = CLAMP.i(s, 0, StatsNeeds.StatExposure.this.count.max(t));
/* 335 */           StatsNeeds.StatExposure.this.count.set(t, s);
/*     */         }
/*     */ 
/*     */         
/*     */         public int get(Induvidual t) {
/* 340 */           return CLAMP.i(StatsNeeds.StatExposure.this.count.get(t) - 8, 0, max(t));
/*     */         }
/*     */ 
/*     */         
/*     */         public int min(Induvidual t) {
/* 345 */           return 0;
/*     */         }
/*     */ 
/*     */         
/*     */         public int max(Induvidual t) {
/* 350 */           return this.max;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 355 */     this.COUNT = (STAT)new STATData("EXPOSURE", "NEED_EXPOSURE", init, statCount);
/* 356 */     init.count.getClass(); this.DANGER = (STAT)new STATData(null, init, (DataO.DataAbs)new DataO.DataBit(init.count, "NEED_DANGER_EXPOSURE"), this.COUNT.info());
/*     */   }
/*     */   
/*     */   public boolean critical(Induvidual i) {
/* 360 */     return (this.count.get(i) >= 26);
/*     */   }
/*     */   
/*     */   public void fix(Induvidual a) {
/* 364 */     this.count.set(a, 0);
/*     */   }
/*     */   
/*     */   public boolean isCold(Induvidual a) {
/* 368 */     return (this.type.get(a) == 0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void update(Humanoid a, double insaneRate) {
/* 374 */     Induvidual i = a.indu();
/*     */     
/* 376 */     if ((STATS.DISEASE().status(i)).active) {
/* 377 */       if (critical(i)) {
/* 378 */         this.count.set(i, 25);
/*     */       }
/*     */       
/*     */       return;
/*     */     } 
/* 383 */     double exposure = (SETT.WEATHER()).temp.getEntityTemp() * 4.0D;
/* 384 */     if (exposure == 0.0D) {
/* 385 */       if (this.count.get(i) > 25)
/* 386 */         this.count.set(i, 25); 
/*     */       return;
/*     */     } 
/* 389 */     int type = 1;
/* 390 */     Boostable b = (BOOSTABLES.PHYSICS()).RESISTANCE_HOT;
/* 391 */     CAUSE_LEAVE cause = CAUSE_LEAVES.HEAT();
/* 392 */     if (exposure < 0.0D) {
/* 393 */       b = (BOOSTABLES.PHYSICS()).RESISTANCE_COLD;
/* 394 */       cause = CAUSE_LEAVES.COLD();
/* 395 */       exposure = -exposure;
/* 396 */       type = 0;
/*     */     } 
/*     */     
/* 399 */     double protection = b.get((BOOSTABLE_O)i);
/* 400 */     if (((Terrain.TerrainTile)SETT.TERRAIN().get(a.tc())).roofIs()) {
/* 401 */       protection++;
/*     */     } else {
/* 403 */       protection = 0.5D + 0.5D * (SETT.GROUND()).MOISTURE_CURRENT.get(a.tc());
/*     */     } 
/*     */     
/* 406 */     exposure /= 1.0D + protection;
/* 407 */     exposure = CLAMP.d(exposure, 0.0D, 16.0D);
/* 408 */     int ex = (int)exposure;
/*     */     
/* 410 */     if (exposure - ex > RND.rFloat()) {
/* 411 */       ex++;
/*     */     }
/*     */     
/* 414 */     if (type != this.type.get(i)) {
/* 415 */       int cc = this.count.get(i);
/* 416 */       int c = Math.min(ex, cc);
/* 417 */       cc -= c;
/* 418 */       this.count.inc(i, -cc);
/* 419 */       ex -= c;
/*     */     } 
/*     */     
/* 422 */     if (ex > 0) {
/* 423 */       this.type.set(i, type);
/*     */     }
/* 425 */     this.count.inc(i, ex);
/* 426 */     if (i.clas() == HCLASSES.CITIZEN() && insaneRate > 0.0D && STATS.RAN().get(i, 22, 4) == 0 && critical(i))
/* 427 */       a.HTypeSet(HTYPES.DERANGED(), cause, null); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\colls\StatsNeeds$StatExposure.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */