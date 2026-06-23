/*     */ package world.region;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.BOOSTING;
/*     */ import game.boosting.BSourceInfo;
/*     */ import game.boosting.Boostable;
/*     */ import game.boosting.BoostableCat;
/*     */ import game.faction.FCredits;
/*     */ import game.faction.Faction;
/*     */ import game.time.TIME;
/*     */ import game.time.TIMECYCLE;
/*     */ import init.resources.Growable;
/*     */ import init.resources.RESOURCES;
/*     */ import init.sprite.UI.UI;
/*     */ import init.trade.TR;
/*     */ import init.trade.TRADABLE;
/*     */ import init.trade.TRADE_TYPE;
/*     */ import snake2d.util.MATH;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.DataO;
/*     */ import util.data.INT_O;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import world.WORLD;
/*     */ import world.entity.caravan.Shipment;
/*     */ import world.map.regions.Region;
/*     */ import world.region.pop.RDRace;
/*     */ 
/*     */ public final class RDOutputs {
/*  33 */   private static CharSequence ¤¤taxes = "¤Taxes";
/*  34 */   public static CharSequence ¤¤Squeeze = "¤Squeeze";
/*  35 */   public static CharSequence ¤¤SqueezeD = "¤Squeeze this settlement for what it's got. Instantly delivering goods, but devastating the region, and upsetting the populace.";
/*  36 */   private static CharSequence ¤¤taxD = "¤Taxes are generated from your subjects. Higher tax rate increases taxes, but decreases loyalty."; private INT_O.INT_OE<Region> squeeze;
/*     */   
/*     */   static {
/*  39 */     D.ts(RDOutputs.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public final LIST<RDOutput> ALL;
/*     */   
/*     */   public final RDOutput MONEY;
/*     */   
/*     */   public final LIST<RDResource> RES;
/*  48 */   public final double sqeezeAmountDays = 4.0D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RDOutputs(RD.RDInit init) {
/*  63 */     ArrayList<RDResource> rr = new ArrayList(TR.ALL().size());
/*     */     
/*  65 */     for (TRADABLE res : TR.ALL()) {
/*  66 */       rr.add(new RDResource(init, res));
/*     */     }
/*  68 */     this.RES = (LIST<RDResource>)rr;
/*     */     
/*  70 */     init.count.getClass(); this.squeeze = (INT_O.INT_OE<Region>)new DataO.DataShort(init.count, "TAX_RATE", ¤¤Squeeze, ¤¤SqueezeD, 10);
/*  71 */     Boostable boost = BOOSTING.push("TAX_INCOME", 0.0D, ¤¤taxes, ¤¤taxD, (SPRITE)(UI.icons()).m.coins, (BoostableCat.ALL()).WORLD);
/*  72 */     this.MONEY = new RDOutput(boost, init);
/*     */     
/*  74 */     this.ALL = (new ArrayList(0)).join((Object[])new RDOutput[] { this.MONEY }).join((LIST)rr);
/*     */     
/*  76 */     ACTION a = new ACTION()
/*     */       {
/*     */         public void exe()
/*     */         {
/*  80 */           RBooster b = new RBooster(new BSourceInfo(RDOutputs.¤¤Squeeze, (SPRITE)(UI.icons()).s.money), 1.0D, 0.25D, true)
/*     */             {
/*     */               public double get(Region t)
/*     */               {
/*  84 */                 return (RDOutputs.null.access$0(RDOutputs.null.this)).squeeze.getD(t);
/*     */               }
/*     */             };
/*  87 */           for (RDRace r : (RD.RACES()).all) {
/*  88 */             b.add(r.loyalty.target);
/*     */           }
/*     */         }
/*     */       };
/*     */     
/*  93 */     BOOSTING.connecter(a);
/*     */     
/*  95 */     init.upers.add(new RD.RDUpdatable()
/*     */         {
/*     */           public void update(Region reg, double time)
/*     */           {
/*  99 */             time *= TIME.secondsPerDayI();
/* 100 */             int t = (int)time;
/* 101 */             if (RND.rFloat() < time - t)
/* 102 */               t++; 
/* 103 */             RDOutputs.this.squeeze.inc(reg, -t);
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public void init(Region reg) {}
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void init() {}
/*     */ 
/*     */   
/*     */   public static class RDOutput
/*     */   {
/*     */     public final Boostable boost;
/*     */     
/*     */     public final Boostable boostYearlyPart;
/*     */     
/*     */     public final INT_O.INT_OE<Region> yearlyAccumilation;
/*     */ 
/*     */     
/*     */     RDOutput(Boostable boost, RD.RDInit init) {
/* 127 */       this.boost = boost;
/* 128 */       this.boostYearlyPart = BOOSTING.push(boost.key.split("WORLD")[1] + "_YEARLY", 0.0D, boost.name, RDOutputs.¤¤taxD, (SPRITE)boost.icon, (BoostableCat.ALL()).WORLD_DUMP);
/* 129 */       this.yearlyAccumilation = (INT_O.INT_OE<Region>)new DataO.DataInt(init.count, boost.key + "_ACC");
/*     */     }
/*     */     
/*     */     public int getDelivery(Region reg) {
/* 133 */       return (int)(this.boost.get((BOOSTABLE_O)reg) + this.boostYearlyPart.get((BOOSTABLE_O)reg));
/*     */     }
/*     */     
/*     */     public int loot(Region reg) {
/* 137 */       double d = 1.0D - (RD.DEVASTATION()).current.getD(reg);
/*     */       
/* 139 */       return (int)(d * (this.boost.get((BOOSTABLE_O)reg) + this.yearlyAccumilation.get(reg)));
/*     */     }
/*     */     
/*     */     public int daysUntilDailydelivery() {
/* 143 */       int d = 0;
/* 144 */       int now = TIME.days().bitsSinceStart() % (int)TIME.years().bitConversion((TIMECYCLE)TIME.days());
/* 145 */       int remain = MATH.ETA(now, d, (int)TIME.years().bitConversion((TIMECYCLE)TIME.days()));
/* 146 */       return remain;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class RDResource
/*     */     extends RDOutput
/*     */   {
/*     */     public final TRADABLE res;
/*     */     private final Growable g;
/*     */     
/*     */     RDResource(RD.RDInit init, TRADABLE res) {
/* 157 */       super(BOOSTING.push("PRODUCTION_" + res.key(), 0.0D, String.valueOf(Dic.¤¤Production) + ": " + String.valueOf(Dic.¤¤Production), res.desc, res.icon(), (BoostableCat.ALL()).WORLD_PRODUCTION), init);
/* 158 */       this.res = res;
/*     */       
/* 160 */       this.g = g(res);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private Growable g(TRADABLE t) {
/* 166 */       for (Growable g : RESOURCES.growable().all()) {
/* 167 */         if (TR.get(g.resource) == t)
/* 168 */           return g; 
/*     */       } 
/* 170 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int daysUntilDailydelivery() {
/* 176 */       if (this.g != null) {
/* 177 */         int d = (int)(this.g.seasonalOffset * TIME.years().bitConversion((TIMECYCLE)TIME.days()));
/* 178 */         int now = TIME.days().bitsSinceStart() % (int)TIME.years().bitConversion((TIMECYCLE)TIME.days());
/* 179 */         int remain = MATH.ETA(now, d, (int)TIME.years().bitConversion((TIMECYCLE)TIME.days()));
/* 180 */         return remain;
/*     */       } 
/*     */ 
/*     */       
/* 184 */       return super.daysUntilDailydelivery();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public RDResource get(TRADABLE res) {
/* 190 */     return (RDResource)this.RES.get(res.index());
/*     */   }
/*     */   
/*     */   public TRADABLE fromBoost(Boostable bo) {
/* 194 */     if (bo.index() >= ((RDResource)this.RES.get(0)).boost.index() && bo.index() < ((RDResource)this.RES.get(this.RES.size() - 1)).boostYearlyPart.index())
/*     */     {
/* 196 */       return (TRADABLE)TR.ALL().get((bo.index() - ((RDResource)this.RES.get(0)).boost.index()) / 2);
/*     */     }
/* 198 */     return null;
/*     */   }
/*     */   
/*     */   public void squeze(Region reg) {
/* 202 */     Faction f = reg.faction();
/* 203 */     if (f == null) {
/*     */       return;
/*     */     }
/*     */     
/* 207 */     f.credits().inc((RD.OUTPUT()).MONEY.boost.get((BOOSTABLE_O)reg) * 4.0D, FCredits.CTYPE.TAX);
/*     */     
/* 209 */     int am = 0;
/* 210 */     for (RDResource res : (RD.OUTPUT()).RES) {
/* 211 */       am = (int)(am + res.boostYearlyPart.get((BOOSTABLE_O)reg) * 4.0D / TIME.years().bitConversion((TIMECYCLE)TIME.days()));
/* 212 */       am = (int)(am + res.boost.get((BOOSTABLE_O)reg) * 4.0D);
/*     */     } 
/*     */ 
/*     */     
/* 216 */     if (am <= 0) {
/* 217 */       (RD.DEVASTATION()).current.incD(reg, 0.5D);
/* 218 */       this.squeeze.incD(reg, 0.5D);
/*     */       return;
/*     */     } 
/* 221 */     Shipment c = (WORLD.ENTITIES()).caravans.create(reg, f.capitolRegion(), TRADE_TYPE.tax);
/* 222 */     if (c != null) {
/* 223 */       for (RDResource res : (RD.OUTPUT()).RES) {
/* 224 */         int a = (int)(res.boostYearlyPart.get((BOOSTABLE_O)reg) * 4.0D / TIME.years().bitConversion((TIMECYCLE)TIME.days()));
/* 225 */         a = (int)(a + res.boost.get((BOOSTABLE_O)reg) * 4.0D);
/* 226 */         if (a > 0) {
/* 227 */           c.loadAndReserve(res.res, a);
/*     */         }
/*     */       } 
/*     */     }
/* 231 */     (RD.DEVASTATION()).current.incD(reg, 0.5D);
/* 232 */     this.squeeze.incD(reg, 0.5D);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\region\RDOutputs.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */