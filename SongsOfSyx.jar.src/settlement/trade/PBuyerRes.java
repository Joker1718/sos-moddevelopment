/*     */ package settlement.trade;
/*     */ 
/*     */ import init.resources.RESOURCE;
/*     */ import init.settings.S;
/*     */ import init.trade.TRADABLE;
/*     */ import init.trade.TRADABLEO;
/*     */ import init.trade.TRADE_TYPE;
/*     */ import settlement.main.SETT;
/*     */ import settlement.thing.halfEntity.caravan.Caravan;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.INT;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ 
/*     */ class PBuyerRes extends PBuyer {
/*  20 */   private static CharSequence ¤¤ImportProblem = "¤You don't have any import depots set to this resource. No automated importing can be done.";
/*  21 */   private static CharSequence ¤¤ImportFull = "¤Our import depots are full. We must increase their space, or improve logistics, if we are to import more.";
/*  22 */   private static CharSequence ¤¤LevelEverything = "¤100% Imports maximum to fill both warehouses and import depots.";
/*  23 */   private static CharSequence ¤¤LevelNothing = "¤Never import.";
/*  24 */   private static CharSequence ¤¤LevelCurrent = "¤Import to maintain warehouse stock at {0}% of total capacity ({1} items). You will currently import {2} additional items.";
/*  25 */   private static CharSequence ¤¤LevelNothingW = "¤Your import level is set to 0%, meaning you will never import anything.";
/*  26 */   private static CharSequence ¤¤Profit = "¤Profit";
/*  27 */   private static CharSequence ¤¤ProfitD = "¤Your workers can currently produce this ware at the speed of {0} items per day per worker. If you buy such an amount at the price of {1} each, it will cost you {2} denarii.";
/*  28 */   private static CharSequence ¤¤probCapacityC = "¤You currently don't have import depot capacity to import this goods.";
/*     */   
/*     */   static {
/*  31 */     D.ts(PBuyerRes.class);
/*     */   }
/*     */   
/*     */   public final TRADABLEO<RESOURCE> res;
/*     */   
/*     */   PBuyerRes(TRADABLEO<RESOURCE> res) {
/*  37 */     super((TRADABLE)res, new INT.IntImp(0, 100));
/*  38 */     this.res = res;
/*  39 */     this.limit.setD(1.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   public int attempting(TRADE_TYPE t) {
/*  44 */     return (SETT.HALFENTS()).caravans.deliveries((RESOURCE)this.res.t, t);
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/*  49 */     this.limit.setD(1.0D);
/*  50 */     super.clear();
/*     */   }
/*     */   
/*     */   public int capacityTotal() {
/*  54 */     return (SETT.ROOMS()).IMPORT.tally.capacity.get(this.res.t);
/*     */   }
/*     */   
/*     */   public int capacityUsed() {
/*  58 */     return (SETT.ROOMS()).IMPORT.tally.capacity.get(this.res.t) - (SETT.ROOMS()).IMPORT.tally.spaceForTribute((RESOURCE)this.res.t);
/*     */   }
/*     */   
/*     */   public int capacityAvailable() {
/*  62 */     return capacityTotal() - capacityUsed();
/*     */   }
/*     */ 
/*     */   
/*     */   protected int deliver(TRADE_TYPE tt, int amount) {
/*  67 */     int am = 0;
/*  68 */     while (amount > 0) {
/*  69 */       int a = Math.min(amount, Caravan.MAX_LOAD);
/*     */       
/*  71 */       if (!(SETT.HALFENTS()).caravans.createDelivery((RESOURCE)this.res.t, a, tt))
/*  72 */         return am; 
/*  73 */       am += a;
/*  74 */       amount -= a;
/*     */     } 
/*  76 */     return am;
/*     */   }
/*     */   
/*     */   public int owned() {
/*  80 */     return ((SETT.ROOMS()).STOCKPILE.tally()).spaceReserved.total((RESOURCE)this.res.t) + ((SETT.ROOMS()).STOCKPILE.tally()).amount.total((RESOURCE)this.res.t) + capacityUsed() + this.incoming.get(null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public double buyPriority(int amount, double price) {
/*  86 */     if (super.buyPriority(amount, price) <= 0.0D) {
/*  87 */       return 0.0D;
/*     */     }
/*  89 */     if (capacityTotal() <= 0) {
/*  90 */       return 0.0D;
/*     */     }
/*  92 */     if (capacityAvailable() <= 0) {
/*  93 */       return 0.0D;
/*     */     }
/*  95 */     double p = 1.0D - this.incoming.get(null) / capacityTotal();
/*     */     
/*  97 */     double d = this.limit.getD();
/*  98 */     if (d == 1.0D)
/*  99 */       return p; 
/* 100 */     if (d == 0.0D) {
/* 101 */       return -1.0D;
/*     */     }
/* 103 */     if (capacityTotal() <= 0) {
/* 104 */       return -1.0D;
/*     */     }
/* 106 */     int sspace = ((SETT.ROOMS()).STOCKPILE.tally()).space.total((RESOURCE)this.res.t);
/* 107 */     int samount = owned();
/*     */     
/* 109 */     double dd = (samount + amount) / sspace;
/*     */     
/* 111 */     if (dd >= d) {
/* 112 */       return -1.0D;
/*     */     }
/*     */ 
/*     */     
/* 116 */     return super.buyPriority(amount, price);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CharSequence problem() {
/* 123 */     if (capacityTotal() <= 0) {
/* 124 */       return ¤¤ImportProblem;
/*     */     }
/* 126 */     return super.problem();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public CharSequence warning() {
/* 132 */     if (capacityTotal() > 0) {
/* 133 */       if (this.limit.getD() == 0.0D) {
/* 134 */         return ¤¤LevelNothingW;
/*     */       }
/* 136 */       if (capacityAvailable() <= 0) {
/* 137 */         return ¤¤ImportFull;
/*     */       }
/* 139 */       if (capacityAvailable() < 1) {
/* 140 */         return ¤¤probCapacityC;
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 146 */     return super.warning();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void hoverCapacity(GBox b) {
/* 154 */     int space = ((SETT.ROOMS()).STOCKPILE.tally()).space.total((RESOURCE)this.res.t);
/* 155 */     int amount = owned();
/*     */ 
/*     */     
/* 158 */     if (this.limit.getD() == 1.0D) {
/* 159 */       b.text(¤¤LevelEverything);
/* 160 */     } else if (this.limit.getD() == 0.0D) {
/* 161 */       b.text(¤¤LevelNothing);
/*     */     } else {
/*     */       
/* 164 */       double lim = this.limit.get() / (this.limit.max() - 1.0D);
/*     */ 
/*     */       
/* 167 */       int imp = (int)CLAMP.d(lim * space - amount, 0.0D, space);
/*     */       
/* 169 */       GText t = b.text();
/* 170 */       t.add(¤¤LevelCurrent);
/*     */       
/* 172 */       t.insert(0, (int)Math.round(100.0D * lim));
/* 173 */       t.insert(1, (int)(lim * space));
/* 174 */       t.insert(2, imp);
/* 175 */       b.text((CharSequence)t);
/*     */     } 
/*     */     
/* 178 */     b.textLL(¤¤Owned);
/* 179 */     b.tab(6);
/* 180 */     b.add((SPRITE)GFORMAT.i(b.text(), this.tradable.ps().playerOwned()));
/* 181 */     b.NL();
/*     */     
/* 183 */     b.textLL(¤¤Inbound);
/* 184 */     b.tab(6);
/* 185 */     b.add((SPRITE)GFORMAT.i(b.text(), this.incoming.get(null)));
/* 186 */     b.NL();
/* 187 */     for (TRADE_TYPE t : TRADE_TYPE.all) {
/* 188 */       int am = toBeAdded().get(t) + toBeStored().get(t);
/* 189 */       if (am > 0) {
/* 190 */         b.tab(1);
/* 191 */         b.textL(t.name);
/* 192 */         b.tab(6);
/* 193 */         b.add((SPRITE)GFORMAT.i(b.text(), am));
/* 194 */         if ((S.get()).developer) {
/* 195 */           b.text("" + toBeAdded().get(t) + " " + toBeAdded().get(t) + " " + toBeStored().get(t));
/*     */         }
/*     */       } 
/* 198 */       b.NL();
/*     */     } 
/*     */     
/* 201 */     b.textLL(¤¤ImportCapacity);
/* 202 */     b.tab(6);
/* 203 */     b.add((SPRITE)GFORMAT.i(b.text(), capacityTotal()));
/* 204 */     b.NL();
/*     */     
/* 206 */     b.textLL(¤¤ImportCapacityUsed);
/* 207 */     b.tab(6);
/* 208 */     b.add((SPRITE)GFORMAT.i(b.text(), capacityUsed()));
/* 209 */     b.NL();
/*     */     
/* 211 */     b.textLL(¤¤ImportCanBe);
/* 212 */     b.tab(6);
/* 213 */     b.add((SPRITE)GFORMAT.i(b.text(), capacityAvailable()));
/* 214 */     b.NL();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean importing() {
/* 219 */     return (capacityTotal() > 0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int tradeCredits(int price) {
/* 225 */     double rate = (SETT.RECIPES()).player.rateTotal(this.tradable);
/* 226 */     return SETT.TRADE().tradeCredits(price, rate);
/*     */   }
/*     */ 
/*     */   
/*     */   public double tradeValue(int price) {
/* 231 */     double p = tradeCredits(price);
/* 232 */     p /= 400.0D;
/* 233 */     return p;
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverTradeValue(double price, GUI_BOX box) {
/* 238 */     GBox b = (GBox)box;
/* 239 */     b.NL();
/* 240 */     double rate = (SETT.RECIPES()).player.rateTotal(this.tradable);
/* 241 */     double d = price / rate;
/* 242 */     b.textLL(¤¤Profit);
/* 243 */     b.tab(6);
/* 244 */     b.add((SPRITE)GFORMAT.iIncr(b.text(), -((int)d)));
/* 245 */     b.NL();
/* 246 */     GText t = b.text();
/* 247 */     t.add(¤¤ProfitD);
/* 248 */     t.insert(0, 1.0D / rate, 1);
/* 249 */     t.insert(1, (int)price);
/* 250 */     t.insert(2, (int)d);
/*     */     
/* 252 */     b.add((SPRITE)t);
/*     */     
/* 254 */     b.NL();
/*     */   }
/*     */ 
/*     */   
/*     */   public double capacityValue() {
/* 259 */     double cap = capacityTotal();
/* 260 */     if (cap <= 0.0D)
/* 261 */       return 0.0D; 
/* 262 */     double c = capacityUsed();
/* 263 */     double n = c + this.incoming.get(null);
/* 264 */     n /= cap;
/* 265 */     return n;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\trade\PBuyerRes.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */