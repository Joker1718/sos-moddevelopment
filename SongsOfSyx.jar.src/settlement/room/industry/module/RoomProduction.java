/*     */ package settlement.room.industry.module;
/*     */ import game.GAME;
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.BOOSTING;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.FResources;
/*     */ import game.faction.Faction;
/*     */ import game.time.TIME;
/*     */ import game.time.TIMECYCLE;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import init.resources.RES_AMOUNT;
/*     */ import init.resources.ResGDrink;
/*     */ import init.resources.ResGEat;
/*     */ import init.sprite.UI.UI;
/*     */ import init.trade.TR;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.HCLASS_RACE;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.industry.module.consumption.RoomConsumption;
/*     */ import settlement.room.main.ROOMS;
/*     */ import settlement.room.main.RoomBlueprint;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.employment.RoomEquip;
/*     */ import settlement.room.spirit.temple.ROOM_TEMPLE;
/*     */ import settlement.room.spirit.temple.TempleInstance;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.equip.Equip;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.text.Dic;
/*     */ import world.army.AD;
/*     */ import world.army.ADSupply;
/*     */ import world.region.RD;
/*     */ 
/*     */ public class RoomProduction {
/*  47 */   private final ArrayList<Res> producers = new ArrayList(RESOURCES.ALL().size());
/*  48 */   private final ArrayList<Res> consumers = new ArrayList(RESOURCES.ALL().size());
/*  49 */   private final ArrayList<Res> eaters = new ArrayList(RESOURCES.ALL().size());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int ui;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int upI;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void update(int ticks) {
/* 349 */     this.upI = GAME.updateI();
/* 350 */     ENTITY[] es = SETT.ENTITIES().getAllEnts();
/*     */     
/* 352 */     int tott = ticks * 200;
/* 353 */     if (tott < 0 || tott > es.length) {
/* 354 */       tott = es.length;
/*     */     }
/* 356 */     for (int i = 0; i < tott; i++) {
/*     */       
/* 358 */       if (this.ui >= es.length) {
/*     */         int ii;
/* 360 */         for (ii = 0; ii < this.producers.size(); ii++) {
/* 361 */           Res r = (Res)this.producers.get(ii);
/* 362 */           double tot = 0.0D;
/* 363 */           for (SourceR in : r.ins) {
/* 364 */             in.am = in.old;
/* 365 */             in.old = 0.0D;
/* 366 */             tot += in.am;
/*     */           } 
/* 368 */           for (Source in : r.all) {
/* 369 */             if (in instanceof SourceReg)
/* 370 */               tot += in.am(); 
/*     */           } 
/* 372 */           r.am = tot;
/*     */         } 
/* 374 */         for (ii = 0; ii < this.consumers.size(); ii++) {
/* 375 */           Res r = (Res)this.consumers.get(ii);
/* 376 */           double tot = 0.0D;
/* 377 */           for (SourceR in : r.ins) {
/* 378 */             in.am = in.old;
/* 379 */             in.old = 0.0D;
/* 380 */             tot += in.am;
/*     */           } 
/*     */           
/* 383 */           r.am = tot;
/*     */         } 
/*     */         
/* 386 */         this.ui = 0;
/*     */         
/*     */         break;
/*     */       } 
/* 390 */       ENTITY e = es[this.ui];
/* 391 */       this.ui++;
/* 392 */       if (e != null && e instanceof Humanoid) {
/* 393 */         Humanoid h = (Humanoid)e;
/* 394 */         RoomInstance ins = (RoomInstance)(STATS.WORK()).EMPLOYED.get(h);
/* 395 */         if (ins != null) {
/*     */ 
/*     */           
/* 398 */           if (ins instanceof ROOM_PRODUCER_INSTANCE) {
/* 399 */             ROOM_PRODUCER_INSTANCE p = (ROOM_PRODUCER_INSTANCE)ins;
/*     */             
/* 401 */             Industry in = p.industry();
/* 402 */             for (IndustryResource oo : in.outs()) {
/* 403 */               RESOURCE res = oo.resource;
/* 404 */               double d = p.productionRate(ins, h, in, oo);
/* 405 */               for (int ri = 0; ri < ((Res)this.producers.get(res.index())).ins.size(); ri++) {
/* 406 */                 SourceR ii = (SourceR)((Res)this.producers.get(res.index())).ins.get(ri);
/* 407 */                 if (ii.blue == in.blue && ii.ins == in) {
/* 408 */                   ii.old += d;
/*     */                 }
/*     */               } 
/*     */             } 
/* 412 */             for (IndustryResource oo : in.ins()) {
/* 413 */               RESOURCE res = oo.resource;
/* 414 */               double d = in.consumptionRate(ins, h, oo);
/* 415 */               for (int ri = 0; ri < ((Res)this.consumers.get(res.index())).ins.size(); ri++) {
/* 416 */                 SourceR ii = (SourceR)((Res)this.consumers.get(res.index())).ins.get(ri);
/* 417 */                 if (ii.blue == in.blue && ii.ins == in) {
/* 418 */                   ii.old += d;
/*     */                 }
/*     */               } 
/*     */             } 
/*     */           } 
/*     */           
/* 424 */           if (ins.blueprintI() instanceof RoomConsumption.ROOM_CONSUMPTION_HASER) {
/* 425 */             RoomConsumption roomConsumption = ((RoomConsumption.ROOM_CONSUMPTION_HASER)ins.blueprintI()).consumption();
/* 426 */             for (int rii = 0; rii < roomConsumption.ins().size(); rii++) {
/* 427 */               IndustryResource oo = (IndustryResource)roomConsumption.ins().get(rii);
/* 428 */               RESOURCE res = oo.resource;
/* 429 */               double d = roomConsumption.consumptionRate(ins, h, oo);
/* 430 */               for (int ri = 0; ri < ((Res)this.consumers.get(res.index())).ins.size(); ri++) {
/* 431 */                 SourceR ii = (SourceR)((Res)this.consumers.get(res.index())).ins.get(ri);
/* 432 */                 if (ii.blue == ((RoomConsumptionAbs)roomConsumption).blue) {
/* 433 */                   ii.old += d;
/*     */                 }
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public RoomProduction(ROOMS rooms) {
/* 446 */     this.ui = 0;
/* 447 */     this.upI = 0; for (RESOURCE res : RESOURCES.ALL()) { this.producers.add(new Res(res)); this.consumers.add(new Res(res)); this.eaters.add(new Res(res)); }  for (RoomBlueprint h : rooms.all()) { if (h instanceof INDUSTRY_HASER) { INDUSTRY_HASER ii = (INDUSTRY_HASER)h; for (Industry ins : ii.industries()) { for (IndustryResource oo : ins.outs()) { SourceR i = new SourceR(oo.resource, (RoomBlueprintImp)h, ins); ((Res)this.producers.get(i.res.index())).ins.add(i); ((Res)this.producers.get(i.res.index())).all.add(i); }  for (IndustryResource oo : ins.ins()) { SourceR i = new SourceR(oo.resource, (RoomBlueprintImp)h, ins); ((Res)this.consumers.get(i.res.index())).ins.add(i); ((Res)this.consumers.get(i.res.index())).all.add(i); }  }  continue; }  if (h instanceof RoomConsumption.ROOM_CONSUMPTION_HASER) { RoomConsumption roomConsumption = ((RoomConsumption.ROOM_CONSUMPTION_HASER)h).consumption(); for (IndustryResource oo : roomConsumption.ins()) { SourceRC i = new SourceRC(oo.resource, (RoomBlueprintImp)h); ((Res)this.consumers.get(i.res.index())).ins.add(i); ((Res)this.consumers.get(i.res.index())).all.add(i); }  }  }  for (ResGEat e : RESOURCES.EDI().all()) { Source s = new Source(e.resource) { public double am() { return FACTIONS.player().res().out(FResources.RTYPE.CONSUMED).history(TR.get(e.resource)).get(1); } public SPRITE icon() { return (SPRITE)(UI.icons()).s.human; } public CharSequence name() { return Dic.¤¤Consumed; } }
/*     */         ; ((Res)this.consumers.get(e.resource.index())).all.add(s); ((Res)this.eaters.get(e.resource.index())).all.add(s); }  for (ResGDrink e : RESOURCES.DRINKS().all()) { Source s = new Source(e.resource) { public double am() { return FACTIONS.player().res().out(FResources.RTYPE.CONSUMED).history(TR.get(e.resource)).get(1); } public SPRITE icon() { return (SPRITE)(UI.icons()).s.human; } public CharSequence name() { return Dic.¤¤Consumed; } }
/*     */         ; ((Res)this.consumers.get(e.resource.index())).all.add(s); ((Res)this.eaters.get(e.resource.index())).all.add(s); }  for (RESOURCE res : RESOURCES.ALL()) { ((Res)this.producers.get(res.index())).all.add(new SourceReg(res)); ((Res)this.consumers.get(res.index())).all.add(new Source(res) { public double am() { return SETT.MAINTENANCE().estimateGlobal(this.res); } public SPRITE icon() { return (SETT.MAINTENANCE()).icon; } public CharSequence name() { return Dic.¤¤Maintenance; } }); ((Res)this.consumers.get(res.index())).all.add(new Source(res) { public double am() { double d = this.res.degradeSpeed() / TIME.years().bitConversion((TIMECYCLE)TIME.days()) * (BOOSTABLES.CIVICS()).SPOILAGE.get((BOOSTABLE_O)HCLASS_RACE.clP(null, null)); double am = d * (SETT.ROOMS()).STOCKPILE.tally().amountTotal(this.res) * 0.5D; am += d * (SETT.ROOMS()).HAULER.tally.amountTotal(this.res); am += d * (SETT.ROOMS()).EXPORT.tally.amount.get(this.res); am += d * (SETT.ROOMS()).IMPORT.tally.amount.get(this.res); return am; } public SPRITE icon() { return (SETT.MAINTENANCE()).icon; } public CharSequence name() { return Dic.¤¤Spoilage; } }); }  for (RoomEquip e : rooms.employment.equip.ALL) { ((Res)this.consumers.get(e.resource.index())).all.add(new Source(e.resource) { public double am() { return e.currentTotal() * e.degradePerDay; } public SPRITE icon() { return (SPRITE)(UI.icons()).s.hammer; } public CharSequence name() { return Dic.¤¤Equipped; } }); }  BOOSTING.connecter(new ACTION() { public void exe() { for (Equip e : STATS.EQUIP().allE()) { ((RoomProduction.Res)RoomProduction.this.consumers.get(e.resource.index())).all.add(new RoomProduction.Source(e.resource) { public double am() { return e.stat().data().get(null) * e.wearPerYear / TIME.years().bitConversion((TIMECYCLE)TIME.days()); } public SPRITE icon() { return (SPRITE)(UI.icons()).s.citizen; } public CharSequence name() { return Dic.¤¤Equipped; } }); }  for (ADSupply sup : (AD.supplies()).all) { ((RoomProduction.Res)RoomProduction.this.consumers.get(sup.res.index())).all.add(new RoomProduction.Source(sup.res) { public double am() { if (!(SETT.ROOMS()).SUPPLY.has(sup.res)) return 0.0D;  return sup.consumedPerDayCurrent((Faction)FACTIONS.player()); } public SPRITE icon() { return (SPRITE)(UI.icons()).s.sword; } public CharSequence name() { return Dic.¤¤Supplies; } }); }  for (RES_AMOUNT e : RACES.res().homeResMax(null)) { final ArrayListGrower<HCLASS_RACE> con = new ArrayListGrower(); final ArrayListGrower<Integer> conRI = new ArrayListGrower(); for (HCLASS cl : HCLASSES.ALL()) { for (Race ra : RACES.all()) { int ri = 0; for (RES_AMOUNT rr : ra.home().clas(cl).resources()) { if (rr.resource() == e.resource()) { con.add(HCLASS_RACE.clP(ra, cl)); conRI.add(Integer.valueOf(ri)); }  ri++; }  }  }  ((RoomProduction.Res)RoomProduction.this.consumers.get(e.resource().index())).all.add(new RoomProduction.Source(e.resource()) { public double am() { double am = 0.0D; for (int i = 0; i < con.size(); i++) am += STATS.HOME().current(((HCLASS_RACE)con.getC(i)).cl, ((HCLASS_RACE)con.get(i)).race, ((Integer)conRI.get(i)).intValue()) * STATS.HOME().rate(((HCLASS_RACE)con.getC(i)).cl, ((HCLASS_RACE)con.get(i)).race);  return am / TIME.years().bitConversion((TIMECYCLE)TIME.days()); } public SPRITE icon() { return (SPRITE)(UI.icons()).s.house; } public CharSequence name() { return ((STATS.HOME()).materials.info()).name; } }); }  for (ROOM_TEMPLE t : (SETT.ROOMS()).TEMPLES.ALL) { if (t.resource != null) ((RoomProduction.Res)RoomProduction.this.consumers.get(t.resource.index())).all.add(new RoomProduction.Source(t.resource) { public double am() { double a = 0.0D; for (int i = 0; i < t.instancesSize(); i++) a += ((TempleInstance)t.getInstance(i)).sacrifices();  return a; } public SPRITE icon() { return (SPRITE)t.icon; } public CharSequence name() { return t.info.names; } });  }  for (RoomProduction.Res r : RoomProduction.this.producers) r.init();  for (RoomProduction.Res r : RoomProduction.this.consumers) r.init();  } });
/* 450 */   } public double produced(RESOURCE res) { if (Math.abs(this.upI - GAME.updateI()) > 1) {
/* 451 */       update(Math.abs(this.upI - GAME.updateI()));
/*     */     }
/* 453 */     return ((Res)this.producers.get(res.index())).am; }
/*     */ 
/*     */   
/*     */   public double consumed(RESOURCE res) {
/* 457 */     if (Math.abs(this.upI - GAME.updateI()) > 1) {
/* 458 */       update(Math.abs(this.upI - GAME.updateI()));
/*     */     }
/* 460 */     return ((Res)this.consumers.get(res.index())).am;
/*     */   }
/*     */   
/*     */   public LIST<Source> producers(RESOURCE res) {
/* 464 */     return (LIST<Source>)((Res)this.producers.get(res.index())).all;
/*     */   }
/*     */   
/*     */   public LIST<Source> consumers(RESOURCE res) {
/* 468 */     return (LIST<Source>)((Res)this.consumers.get(res.index())).all;
/*     */   }
/*     */   
/*     */   public LIST<Source> eaters(RESOURCE res) {
/* 472 */     return (LIST<Source>)((Res)this.eaters.get(res.index())).all;
/*     */   }
/*     */   
/*     */   private class Res
/*     */   {
/* 477 */     private final ArrayListGrower<RoomProduction.Source> all = new ArrayListGrower();
/* 478 */     private final ArrayListGrower<RoomProduction.SourceR> ins = new ArrayListGrower();
/*     */     
/*     */     private double am;
/*     */ 
/*     */     
/*     */     Res(RESOURCE res) {}
/*     */     
/*     */     private void init() {
/* 486 */       for (int i1 = 0; i1 < this.ins.size(); i1++) {
/* 487 */         for (int i2 = 0; i2 < this.ins.size(); i2++) {
/* 488 */           if (i2 != i1)
/*     */           {
/* 490 */             if (((RoomProduction.SourceR)this.ins.get(i1)).blue == ((RoomProduction.SourceR)this.ins.get(i2)).blue) {
/* 491 */               ((RoomProduction.SourceR)this.ins.get(i1)).multiple = true;
/* 492 */               ((RoomProduction.SourceR)this.ins.get(i2)).multiple = true;
/*     */             } 
/*     */           }
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static abstract class Source
/*     */   {
/*     */     public final RESOURCE res;
/*     */ 
/*     */ 
/*     */     
/*     */     Source(RESOURCE res) {
/* 510 */       this.res = res;
/*     */     }
/*     */     
/*     */     public abstract double am();
/*     */     
/*     */     public Industry thereAreMultipleIns() {
/* 516 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public abstract SPRITE icon();
/*     */     
/*     */     public abstract CharSequence name();
/*     */   }
/*     */   
/*     */   public class SourceReg
/*     */     extends Source
/*     */   {
/*     */     SourceReg(RESOURCE res) {
/* 529 */       super(res);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public double am() {
/* 535 */       int am = 0;
/* 536 */       for (int i = 0; i < FACTIONS.player().realm().regions(); i++) {
/* 537 */         int aa = RD.OUTPUT().get((TRADABLE)TR.get(this.res)).getDelivery(FACTIONS.player().realm().region(i));
/* 538 */         am += aa;
/*     */       } 
/*     */       
/* 541 */       return am;
/*     */     }
/*     */ 
/*     */     
/*     */     public Industry thereAreMultipleIns() {
/* 546 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public SPRITE icon() {
/* 551 */       return (SPRITE)(UI.icons()).s.money;
/*     */     }
/*     */ 
/*     */     
/*     */     public CharSequence name() {
/* 556 */       return Dic.¤¤Taxes;
/*     */     }
/*     */   }
/*     */   
/*     */   public class SourceR
/*     */     extends Source
/*     */   {
/*     */     private final RoomBlueprintImp blue;
/*     */     private final Industry ins;
/*     */     private double old;
/*     */     private double am;
/*     */     private boolean multiple = false;
/*     */     
/*     */     SourceR(RESOURCE res, RoomBlueprintImp blue, Industry ins) {
/* 570 */       super(res);
/* 571 */       this.blue = blue;
/* 572 */       this.ins = ins;
/*     */     }
/*     */ 
/*     */     
/*     */     public double am() {
/* 577 */       if (Math.abs(RoomProduction.this.upI - GAME.updateI()) > 1) {
/* 578 */         RoomProduction.this.update(Math.abs(RoomProduction.this.upI - GAME.updateI()));
/*     */       }
/*     */       
/* 581 */       return this.am;
/*     */     }
/*     */ 
/*     */     
/*     */     public Industry thereAreMultipleIns() {
/* 586 */       return this.multiple ? this.ins : null;
/*     */     }
/*     */ 
/*     */     
/*     */     public SPRITE icon() {
/* 591 */       return this.blue.icon.small;
/*     */     }
/*     */ 
/*     */     
/*     */     public CharSequence name() {
/* 596 */       return this.blue.info.names;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public class SourceRC
/*     */     extends SourceR
/*     */   {
/*     */     SourceRC(RESOURCE res, RoomBlueprintImp blue) {
/* 605 */       super(res, blue, null);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\industry\module\RoomProduction.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */