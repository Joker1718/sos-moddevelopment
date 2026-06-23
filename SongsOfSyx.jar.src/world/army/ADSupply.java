/*     */ package world.army;
/*     */ 
/*     */ import game.faction.Faction;
/*     */ import game.time.TIME;
/*     */ import game.time.TIMECYCLE;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.ResSupply;
/*     */ import settlement.stats.equip.EquipBattle;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.INDEXED;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.DataO;
/*     */ import util.data.INT_O;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import world.entity.army.WArmy;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class ADSupply
/*     */   implements INDEXED
/*     */ {
/*     */   public static final int STOCKPILE_DAYS = 6;
/*     */   public final CharSequence name;
/*     */   public final RESOURCE res;
/*     */   private final INT_O.INT_OE<WArmy> cached;
/*     */   private final INT_O.INT_OE<Faction> cachedF;
/*     */   protected final ADInt.ADIntImp current;
/*     */   protected final ADInt.ADIntImp consumers;
/*     */   protected final ADInt.ADIntImp consumersMax;
/*     */   protected final ADInt.ADIntImp amountNeeded;
/*     */   protected final ADInt.ADIntImp amountNeededMax;
/*     */   public final double baseMorale;
/*     */   public final double baseHealth;
/*     */   public final double consumptionPerItem;
/*     */   public final double consumptionPerUser;
/*     */   private final int index;
/*     */   
/*     */   ADSupply(int index, String KPrefix, ADInit init, RESOURCE res, CharSequence prefix, double consumptionPerUser, double consumptionPerItem, double morale, double health) {
/*  45 */     this.consumptionPerItem = consumptionPerItem;
/*  46 */     this.consumptionPerUser = consumptionPerUser;
/*  47 */     this.index = index;
/*  48 */     this.name = String.valueOf(prefix) + ": " + String.valueOf(prefix);
/*  49 */     this.current = new ADInt.ADIntImp(init, "SUPPLY_" + KPrefix + "_" + res.key, this.name, res.names)
/*     */       {
/*     */         public void set(WArmy t, int i)
/*     */         {
/*  53 */           AD.power().mor(t);
/*  54 */           super.set(t, i);
/*     */         }
/*     */ 
/*     */         
/*     */         public int min(WArmy t) {
/*  59 */           return 0;
/*     */         }
/*     */       };
/*     */     
/*  63 */     this.consumers = new ADInt.ADIntImp(init, "SUPPLY_NEEDED_" + KPrefix + "_" + res.key, this.name, res.names);
/*  64 */     this.consumersMax = new ADInt.ADIntImp(init, "SUPPLY_CONSUMERTS_TARGET_" + KPrefix + "_" + res.key, this.name, res.names);
/*  65 */     this.amountNeeded = new ADInt.ADIntImp(init, "SUPPLY_TARGET_" + KPrefix + "_" + res.key, this.name, res.names);
/*  66 */     this.amountNeededMax = new ADInt.ADIntImp(init, "SUPPLY_TARGET_MAX_" + KPrefix + "_" + res.key, this.name, res.names);
/*     */     
/*  68 */     this.cached = (INT_O.INT_OE<WArmy>)new DataO.DataBit(init.dataA, "SUPPLY_CACHE" + KPrefix + "_" + res.key);
/*  69 */     this.cachedF = (INT_O.INT_OE<Faction>)new DataO.DataBit(init.dataT, "SUPPLY_CACHE" + KPrefix + "_" + res.key);
/*     */     
/*  71 */     this.res = res;
/*  72 */     this.baseMorale = morale;
/*  73 */     this.baseHealth = health;
/*     */   }
/*     */   
/*     */   public void setChanged(WArmy a) {
/*  77 */     this.cached.set(a, 0);
/*  78 */     if (a.faction() != null) {
/*  79 */       this.cachedF.set(a.faction(), 0);
/*     */     }
/*     */   }
/*     */   
/*     */   public int index() {
/*  84 */     return this.index;
/*     */   }
/*     */   
/*     */   public ADInt.ADIntImp current() {
/*  88 */     return this.current;
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
/*     */   public double consumedPerDayCurrent(WArmy a) {
/* 103 */     cache(a);
/* 104 */     return this.consumers.get(a) * this.consumptionPerUser + Math.min(this.current.get(a), minimumAmount(a)) * this.consumptionPerItem;
/*     */   }
/*     */   
/*     */   public double consumedPerDayCurrent(Faction a) {
/* 108 */     cache(a);
/* 109 */     return this.consumers.faction(a) * this.consumptionPerUser + this.current.faction(a) * this.consumptionPerItem;
/*     */   }
/*     */   
/*     */   public double consumedPerDayTarget(WArmy a) {
/* 113 */     cache(a);
/* 114 */     return this.consumersMax.get(a) * this.consumptionPerUser + this.amountNeededMax.get(a) * this.consumptionPerItem;
/*     */   }
/*     */   
/*     */   public int targetAmount(WArmy a) {
/* 118 */     cache(a);
/* 119 */     double d = this.consumersMax.get(a) * this.consumptionPerUser * 7.0D;
/* 120 */     d += this.amountNeededMax.get(a) + this.amountNeededMax.get(a) * this.consumptionPerItem * 6.0D;
/* 121 */     return (int)Math.ceil(d);
/*     */   }
/*     */   
/*     */   public int targetAmount(Faction a) {
/* 125 */     cache(a);
/* 126 */     double d = this.consumersMax.faction(a) * this.consumptionPerUser * 7.0D;
/* 127 */     d += this.amountNeededMax.faction(a) + this.amountNeededMax.faction(a) * this.consumptionPerItem * 6.0D;
/* 128 */     return (int)Math.ceil(d);
/*     */   }
/*     */   
/*     */   public int minimumAmount(WArmy a) {
/* 132 */     cache(a);
/* 133 */     double d = this.consumers.get(a) * this.consumptionPerUser;
/* 134 */     d += this.amountNeeded.get(a);
/* 135 */     return (int)Math.ceil(d);
/*     */   }
/*     */   
/*     */   public int minimumTarget(WArmy a) {
/* 139 */     cache(a);
/* 140 */     double d = this.consumersMax.get(a) * this.consumptionPerUser;
/* 141 */     d += this.amountNeededMax.get(a);
/* 142 */     return (int)Math.ceil(d);
/*     */   }
/*     */   
/*     */   public int minimumAmount(Faction a) {
/* 146 */     cache(a);
/* 147 */     double d = this.consumers.faction(a) * this.consumptionPerUser;
/* 148 */     d += this.amountNeeded.faction(a);
/* 149 */     return (int)Math.ceil(d);
/*     */   }
/*     */   
/*     */   public double daysStored(WArmy a) {
/* 153 */     return (this.current.get(a) - minimumAmount(a)) / consumedPerDayCurrent(a);
/*     */   }
/*     */   
/*     */   public double amountValue(WArmy a) {
/* 157 */     return CLAMP.d(this.current.get(a) / minimumAmount(a), 0.0D, 1.0D);
/*     */   }
/*     */   
/*     */   public double needed(WArmy a) {
/* 161 */     return (targetAmount(a) - this.current.get(a));
/*     */   }
/*     */   
/*     */   public double needed(Faction a) {
/* 165 */     return (targetAmount(a) - this.current.faction(a));
/*     */   }
/*     */   
/*     */   public double moraleAdd(WArmy a) {
/* 169 */     cache(a);
/* 170 */     int men = AD.men(null).get(a);
/* 171 */     double d = (this.consumers.get(a) + 1.0D) / (men + 1.0D);
/* 172 */     return this.baseMorale * d * amountValue(a);
/*     */   }
/*     */   
/*     */   public double healthMul(WArmy a) {
/* 176 */     cache(a);
/* 177 */     int men = AD.men(null).get(a);
/* 178 */     double d = (this.consumers.get(a) + 1.0D) / (men + 1.0D);
/* 179 */     return 1.0D - this.baseHealth * d * (1.0D - amountValue(a));
/*     */   }
/*     */ 
/*     */   
/*     */   private void cache(WArmy a) {
/* 184 */     if (this.cached.get(a) == 1) {
/*     */       return;
/*     */     }
/* 187 */     this.cached.set(a, 1);
/* 188 */     this.consumers.set(a, 0);
/* 189 */     this.consumersMax.set(a, 0);
/* 190 */     this.amountNeeded.set(a, 0);
/* 191 */     this.amountNeededMax.set(a, 0);
/* 192 */     add(a);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void cache(Faction a) {
/* 198 */     if (this.cachedF.get(a) == 1) {
/*     */       return;
/*     */     }
/* 201 */     this.cachedF.set(a, 1);
/*     */     
/* 203 */     for (int ai = 0; ai < a.armies().all().size(); ai++) {
/* 204 */       cache((WArmy)a.armies().all().get(ai));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 212 */   private static CharSequence ¤¤affected = "consuming soldiers";
/* 213 */   private static CharSequence ¤¤ConsumtionRate = "Daily Consumption:";
/* 214 */   private static CharSequence ¤¤artD = "Needed to keep artillery functioning";
/* 215 */   private static CharSequence ¤¤days = "Days of Supply";
/*     */   
/*     */   static {
/* 218 */     D.ts(ADSupply.class);
/*     */   }
/*     */   
/*     */   protected abstract void add(WArmy paramWArmy);
/*     */   
/*     */   public abstract void transfer(WDIV paramWDIV, WArmy paramWArmy1, WArmy paramWArmy2);
/*     */   
/*     */   public abstract void hover(GBox paramGBox, WArmy paramWArmy);
/*     */   
/*     */   public static final class ADSupplyRes extends ADSupply {
/*     */     ADSupplyRes(int index, ADInit init, ResSupply rs) {
/* 229 */       super(index, "SUPPLY", init, rs.resource, Dic.¤¤Supplies, rs.consumptionPerPersonday, rs.consumptionPerItemPerDay, rs.morale, rs.health);
/* 230 */       this.res = rs;
/*     */     }
/*     */ 
/*     */     
/*     */     protected void add(WArmy a) {
/* 235 */       for (int di = 0; di < a.divs().size(); di++) {
/* 236 */         ADDiv d = a.divs().get(di);
/* 237 */         if (d.needSupplies()) {
/* 238 */           this.consumers.inc(a, this.res.consumedMulPerDay(d.race()) * d.men());
/* 239 */           this.consumersMax.inc(a, this.res.consumedMulPerDay(d.race()) * d.menTarget());
/* 240 */           this.amountNeeded.inc(a, this.res.consumedMulPerDay(d.race()) * this.res.wantedPerPerson * d.men());
/* 241 */           this.amountNeededMax.inc(a, this.res.consumedMulPerDay(d.race()) * this.res.wantedPerPerson * d.menTarget());
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/*     */     public final ResSupply res;
/*     */     
/*     */     public void transfer(WDIV div, WArmy old, WArmy current) {
/* 249 */       double divAmount = (this.res.consumedMulPerDay(div.race()) * div.menTarget());
/* 250 */       double armyAmount = this.consumersMax.get(old);
/* 251 */       if (armyAmount == 0.0D)
/*     */         return; 
/* 253 */       int am = (int)(current().get(old) * divAmount / armyAmount);
/* 254 */       if (am > 0) {
/* 255 */         current().inc(old, -am);
/* 256 */         current().inc(current, am);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void hover(GBox b, WArmy a) {
/* 263 */       this.res.hover(b);
/*     */       
/* 265 */       b.sep();
/*     */       
/* 267 */       int m = 6;
/*     */       
/* 269 */       b.textL(ADSupply.¤¤affected);
/* 270 */       b.tab(m);
/* 271 */       b.add((SPRITE)GFORMAT.i(b.text(), this.consumers.get(a)));
/* 272 */       b.NL();
/*     */       
/* 274 */       b.textL(Dic.¤¤Minimum);
/* 275 */       b.tab(m);
/* 276 */       b.add((SPRITE)GFORMAT.i(b.text(), minimumAmount(a)));
/* 277 */       b.NL();
/*     */       
/* 279 */       b.textL(Dic.¤¤Max);
/* 280 */       b.tab(m);
/* 281 */       b.add((SPRITE)GFORMAT.i(b.text(), targetAmount(a)));
/* 282 */       b.NL();
/*     */       
/* 284 */       b.textL(Dic.¤¤Stored);
/* 285 */       b.tab(m);
/* 286 */       b.add((SPRITE)GFORMAT.iofkInv(b.text(), current().get(a), targetAmount(a)));
/* 287 */       b.NL();
/*     */       
/* 289 */       b.textL(ADSupply.¤¤ConsumtionRate);
/* 290 */       b.tab(m);
/* 291 */       b.add((SPRITE)GFORMAT.f0(b.text(), -consumedPerDayCurrent(a)));
/* 292 */       b.NL();
/*     */       
/* 294 */       b.textL(ADSupply.¤¤days);
/* 295 */       b.tab(m);
/* 296 */       b.add((SPRITE)GFORMAT.f0(b.text(), daysStored(a)));
/* 297 */       b.NL();
/*     */       
/* 299 */       if (this.baseMorale > 0.0D) {
/* 300 */         b.textL(Dic.¤¤Morale);
/* 301 */         b.tab(m);
/* 302 */         b.add((SPRITE)GFORMAT.f0(b.text(), moraleAdd(a)));
/* 303 */         b.NL();
/*     */       } 
/* 305 */       if (this.baseHealth > 0.0D) {
/* 306 */         b.textL(Dic.¤¤Health);
/* 307 */         b.tab(m);
/* 308 */         GText t = b.text();
/* 309 */         t.add('*').s();
/* 310 */         b.add((SPRITE)GFORMAT.f1(t, healthMul(a)));
/* 311 */         b.NL();
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static final class ADSupplyEquip
/*     */     extends ADSupply
/*     */   {
/*     */     public final EquipBattle equip;
/*     */     
/*     */     ADSupplyEquip(int index, ADInit init, EquipBattle rs) {
/* 323 */       super(index, "EQUIPMENT", init, rs.resource, Dic.¤¤Equipment, 0.0D, rs.wearRate() / 16.0D, 0.0D, 0.0D);
/* 324 */       this.equip = rs;
/*     */     }
/*     */ 
/*     */     
/*     */     protected void add(WArmy a) {
/* 329 */       for (int di = 0; di < a.divs().size(); di++) {
/* 330 */         ADDiv div = a.divs().get(di);
/* 331 */         if (div.needSupplies()) {
/* 332 */           this.amountNeededMax.inc(div.army(), div.menTarget() * div.target().equipI(this.equip));
/* 333 */           this.amountNeeded.inc(div.army(), div.men() * div.target().equipI(this.equip));
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void transfer(WDIV div, WArmy old, WArmy current) {
/* 340 */       double divAmount = (div.menTarget() * div.target().equipI(this.equip));
/* 341 */       double armyAmount = this.amountNeededMax.get(old);
/* 342 */       int am = (int)(current().get(old) * divAmount / armyAmount);
/* 343 */       if (am > 0) {
/* 344 */         current().inc(old, -am);
/* 345 */         current().inc(current, am);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void hover(GBox b, WArmy a) {
/* 351 */       b.title(this.name);
/* 352 */       b.text(this.equip.resource.desc);
/*     */       
/* 354 */       b.sep();
/*     */       
/* 356 */       b.textL(Dic.¤¤Minimum);
/* 357 */       b.tab(6);
/* 358 */       b.add((SPRITE)GFORMAT.i(b.text(), minimumAmount(a)));
/* 359 */       b.NL();
/*     */       
/* 361 */       b.textL(Dic.¤¤Max);
/* 362 */       b.tab(6);
/* 363 */       b.add((SPRITE)GFORMAT.i(b.text(), targetAmount(a)));
/* 364 */       b.NL();
/*     */       
/* 366 */       b.textL(Dic.¤¤Stored);
/* 367 */       b.tab(6);
/* 368 */       b.add((SPRITE)GFORMAT.iofkInv(b.text(), current().get(a), targetAmount(a)));
/* 369 */       b.NL();
/*     */       
/* 371 */       b.textL(ADSupply.¤¤ConsumtionRate);
/* 372 */       b.tab(6);
/* 373 */       b.add((SPRITE)GFORMAT.f0(b.text(), -consumedPerDayCurrent(a)));
/* 374 */       b.NL();
/*     */       
/* 376 */       b.textL(ADSupply.¤¤days);
/* 377 */       b.tab(6);
/* 378 */       b.add((SPRITE)GFORMAT.f0(b.text(), daysStored(a)));
/* 379 */       b.NL();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static final class ADSupplyArt
/*     */     extends ADSupply
/*     */   {
/*     */     public final ADSupplies.ADArtillery art;
/*     */     
/*     */     public final int ri;
/*     */     
/*     */     ADSupplyArt(int index, ADInit init, ADSupplies.ADArtillery art, RESOURCE res, int ri) {
/* 392 */       super(index, "ART_" + art.art.key + "_" + res.key, init, res, art.art.info.name, 0.0D, 0.2D / TIME.years().bitConversion((TIMECYCLE)TIME.days()), 0.0D, 0.0D);
/* 393 */       this.art = art;
/* 394 */       this.ri = ri;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void add(WArmy a) {
/* 400 */       int am = (int)Math.ceil(this.art.target.get(a) * this.art.art.constructor().item(1).cost2(this.ri, this.art.art.upgrades().max()));
/* 401 */       this.amountNeeded.set(a, am);
/* 402 */       this.amountNeededMax.set(a, am);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void transfer(WDIV div, WArmy old, WArmy current) {}
/*     */ 
/*     */ 
/*     */     
/*     */     public void hover(GBox b, WArmy a) {
/* 413 */       b.title(this.name);
/* 414 */       b.text(ADSupply.¤¤artD);
/*     */       
/* 416 */       b.sep();
/*     */       
/* 418 */       b.textL(Dic.¤¤Minimum);
/* 419 */       b.tab(6);
/* 420 */       b.add((SPRITE)GFORMAT.i(b.text(), minimumAmount(a)));
/* 421 */       b.NL();
/*     */       
/* 423 */       b.textL(Dic.¤¤Max);
/* 424 */       b.tab(6);
/* 425 */       b.add((SPRITE)GFORMAT.i(b.text(), targetAmount(a)));
/* 426 */       b.NL();
/*     */       
/* 428 */       b.textL(Dic.¤¤Stored);
/* 429 */       b.tab(6);
/* 430 */       b.add((SPRITE)GFORMAT.iofkInv(b.text(), current().get(a), targetAmount(a)));
/* 431 */       b.NL();
/*     */       
/* 433 */       b.textL(ADSupply.¤¤ConsumtionRate);
/* 434 */       b.tab(6);
/* 435 */       b.add((SPRITE)GFORMAT.f0(b.text(), -consumedPerDayCurrent(a)));
/* 436 */       b.NL();
/*     */       
/* 438 */       b.textL(ADSupply.¤¤days);
/* 439 */       b.tab(6);
/* 440 */       b.add((SPRITE)GFORMAT.f0(b.text(), daysStored(a)));
/* 441 */       b.NL();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\army\ADSupply.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */