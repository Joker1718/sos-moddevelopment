/*     */ package settlement.trade;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.VERSION;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.diplomacy.DIP;
/*     */ import game.faction.trade.FBUYER;
/*     */ import init.trade.TRADABLE;
/*     */ import init.trade.TRADE_TYPE;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.data.INT;
/*     */ import util.data.INT_O;
/*     */ import util.gui.misc.GBox;
/*     */ import util.info.GFORMAT;
/*     */ import util.keymap.MAPPED;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import world.region.RD;
/*     */ 
/*     */ 
/*     */ public abstract class PBuyer
/*     */   implements FBUYER, SAVABLE
/*     */ {
/*  32 */   private static CharSequence ¤¤probPriceCap = "The current cheapest buy price exceeds your set price cap. To trade, you must disable or increase the price cap.";
/*  33 */   private static CharSequence ¤¤probCredits = "¤You don't have enough credits to purchase this resource.";
/*  34 */   private static CharSequence ¤¤probTreasury = "¤A purchase of a batch of 32 of this resource is not possible due to your treasury limit.";
/*  35 */   private static CharSequence ¤¤probClosed = "¤The city is unreachable, no trade can be done.";
/*     */   
/*  37 */   static CharSequence ¤¤Owned = "¤Owned";
/*  38 */   static CharSequence ¤¤Inbound = "¤Inbound";
/*  39 */   static CharSequence ¤¤ImportCapacity = "¤Import Capacity";
/*  40 */   static CharSequence ¤¤ImportCapacityUsed = "¤Import Capacity Used";
/*  41 */   static CharSequence ¤¤ImportCanBe = "¤Imports available";
/*     */   
/*  43 */   public static CharSequence ¤¤PriceCap = "¤Price Cap";
/*     */   
/*  45 */   public static CharSequence ¤¤TreasuryLim = "¤Treasury Limit";
/*  46 */   public static CharSequence ¤¤TradeQuota = "¤Trade Quota";
/*     */   
/*  48 */   private static CharSequence ¤¤BestPrice = "¤Best price.";
/*     */   
/*     */   public final TRADABLE tradable;
/*     */   
/*     */   static {
/*  53 */     D.ts(PBuyer.class);
/*     */   }
/*     */ 
/*     */   
/*  57 */   public final INT.IntImp priceCapsI = new INT.IntImp(0, 1000000);
/*  58 */   public final INT.IntImp minMoney = new INT.IntImp(1, 10000000);
/*     */   public final INT.IntImp limit;
/*  60 */   private TradableData toBeAdded = new TradableData();
/*  61 */   private TradableData toBeStored = new TradableData();
/*     */   
/*  63 */   public final INT_O<TRADE_TYPE> incoming = new INT_O<TRADE_TYPE>()
/*     */     {
/*     */       public int min(TRADE_TYPE t)
/*     */       {
/*  67 */         return 0;
/*     */       }
/*     */ 
/*     */       
/*     */       public int max(TRADE_TYPE t) {
/*  72 */         return Integer.MAX_VALUE;
/*     */       }
/*     */ 
/*     */       
/*     */       public int get(TRADE_TYPE t) {
/*  77 */         return PBuyer.this.toBeAdded.get(t) + PBuyer.this.toBeStored.get(t) + PBuyer.this.attempting(t);
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*     */   PBuyer(TRADABLE tradable, INT.IntImp buyLimit) {
/*  83 */     this.tradable = tradable;
/*  84 */     this.limit = buyLimit;
/*     */   }
/*     */ 
/*     */   
/*     */   public void save(FilePutter file) {
/*  89 */     this.toBeAdded.save(file);
/*  90 */     this.toBeStored.save(file);
/*  91 */     this.priceCapsI.save(file);
/*  92 */     this.minMoney.save(file);
/*  93 */     this.limit.save(file);
/*  94 */     file.bool(false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/* 100 */     this.toBeAdded.load(file);
/* 101 */     this.toBeStored.load(file);
/* 102 */     this.priceCapsI.load(file);
/* 103 */     this.minMoney.load(file);
/* 104 */     this.limit.load(file);
/* 105 */     file.bool();
/*     */     
/* 107 */     if (VERSION.versionIsBefore(71, 12)) {
/* 108 */       this.toBeAdded.clear();
/*     */     }
/*     */   }
/*     */   
/*     */   public void clear() {
/* 113 */     this.toBeAdded.clear();
/* 114 */     this.toBeStored.clear();
/* 115 */     this.priceCapsI.set(this.priceCapsI.max);
/* 116 */     this.minMoney.set(1);
/* 117 */     this.limit.clear();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract boolean importing();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract int attempting(TRADE_TYPE paramTRADE_TYPE);
/*     */ 
/*     */ 
/*     */   
/*     */   public void addReserve(int amount, TRADE_TYPE type, int price, Faction seller) {
/* 133 */     FACTIONS.player().credits().inc(-price, type.ctype, this.tradable, amount);
/* 134 */     (GAME.count()).TRADE_PURCHASES.inc(price);
/* 135 */     this.toBeAdded.inc(type, amount);
/*     */   }
/*     */ 
/*     */   
/*     */   public void addDeliver(int amount, TRADE_TYPE type) {
/* 140 */     this.toBeAdded.inc(type, -amount);
/* 141 */     this.toBeStored.inc(type, amount);
/*     */   }
/*     */   
/*     */   protected final void deliver() {
/* 145 */     if (SETT.ENTRY().isClosed()) {
/*     */       return;
/*     */     }
/* 148 */     if (this.toBeStored.get((TRADE_TYPE)null) <= 0) {
/*     */       return;
/*     */     }
/* 151 */     for (TRADE_TYPE tt : TRADE_TYPE.all) {
/* 152 */       int am = this.toBeStored.get(tt);
/*     */       
/* 154 */       if (am <= 0) {
/*     */         continue;
/*     */       }
/* 157 */       this.toBeStored.inc(tt, -deliver(tt, am));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract int deliver(TRADE_TYPE paramTRADE_TYPE, int paramInt);
/*     */ 
/*     */   
/*     */   public double buyPriority(int amount, double price) {
/* 167 */     if (SETT.ENTRY().isClosed()) {
/* 168 */       return 0.0D;
/*     */     }
/* 170 */     if (FACTIONS.player().credits().getD() - price < this.minMoney.get()) {
/* 171 */       return 0.0D;
/*     */     }
/* 173 */     if (price / amount >= this.priceCapsI.get())
/* 174 */       return 0.0D; 
/* 175 */     if (GAME.player().credits().credits() < price) {
/* 176 */       return 0.0D;
/*     */     }
/*     */     
/* 179 */     return 1.0D;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int addPrice(int amount) {
/* 185 */     return 0;
/*     */   }
/*     */   
/*     */   public INT_O<TRADE_TYPE> toBeAdded() {
/* 189 */     return (INT_O<TRADE_TYPE>)this.toBeAdded;
/*     */   }
/*     */   
/*     */   public INT_O<TRADE_TYPE> toBeStored() {
/* 193 */     return (INT_O<TRADE_TYPE>)this.toBeStored;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CharSequence problem() {
/* 201 */     if (SETT.ENTRY().isClosed()) {
/* 202 */       return ¤¤probClosed;
/*     */     }
/*     */     
/* 205 */     if (RD.DIST().neighs().size() == 0) {
/* 206 */       return Dic.¤¤noTrade;
/*     */     }
/* 208 */     if (DIP.traders().size() == 0) {
/* 209 */       return Dic.¤¤noTradePartners;
/*     */     }
/* 211 */     if ((FACTIONS.player()).trade.pricesBuy.get((MAPPED)this.tradable) == 0) {
/* 212 */       return Dic.¤¤noTrade;
/*     */     }
/* 214 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public CharSequence warning() {
/* 220 */     int pr = (FACTIONS.player()).trade.pricesBuy.get((MAPPED)this.tradable);
/*     */     
/* 222 */     if (pr > 0 && pr > FACTIONS.player().credits().getD()) {
/* 223 */       return (CharSequence)Str.TMP.clear().add(¤¤probCredits);
/*     */     }
/*     */     
/* 226 */     if (pr != Integer.MAX_VALUE && pr > this.priceCapsI.get()) {
/* 227 */       return ¤¤probPriceCap;
/*     */     }
/* 229 */     if (FACTIONS.player().credits().getD() - pr < this.minMoney.get()) {
/* 230 */       return ¤¤probTreasury;
/*     */     }
/* 232 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void hover(GUI_BOX box) {
/* 237 */     GBox b = (GBox)box;
/* 238 */     b.title(this.tradable.name);
/*     */     
/* 240 */     CharSequence p = problem();
/* 241 */     if (p != null) {
/* 242 */       b.error(p);
/*     */     } else {
/* 244 */       p = warning();
/* 245 */       if (p != null) {
/* 246 */         b.add((SPRITE)b.text().warnify().add(p));
/*     */       }
/*     */     } 
/*     */     
/* 250 */     b.NL(4);
/*     */     
/* 252 */     hoverCapacity(b);
/* 253 */     b.NL(8);
/*     */     
/* 255 */     b.textLL(¤¤PriceCap);
/* 256 */     b.tab(6);
/* 257 */     b.add((SPRITE)GFORMAT.i(b.text(), this.priceCapsI.get()));
/* 258 */     b.NL();
/*     */     
/* 260 */     b.textLL(¤¤TreasuryLim);
/* 261 */     b.tab(6);
/* 262 */     b.add((SPRITE)GFORMAT.i(b.text(), this.minMoney.get()));
/* 263 */     b.NL();
/*     */     
/* 265 */     b.textLL(¤¤BestPrice);
/* 266 */     b.tab(6);
/* 267 */     b.add((SPRITE)GFORMAT.i(b.text(), (FACTIONS.player()).trade.pricesBuy.get((MAPPED)this.tradable)));
/* 268 */     b.NL();
/*     */     
/* 270 */     hoverTradeValue(box);
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
/*     */   public abstract void hoverCapacity(GBox paramGBox);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int tradeCredits() {
/* 293 */     return tradeCredits((FACTIONS.player()).trade.pricesSell.get((MAPPED)this.tradable));
/*     */   }
/*     */   
/*     */   public abstract int tradeCredits(int paramInt);
/*     */   
/*     */   public abstract double tradeValue(int paramInt);
/*     */   
/*     */   public final double tradeValue() {
/* 301 */     double p = tradeCredits();
/* 302 */     p /= 400.0D;
/* 303 */     return p;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void hoverTradeValue(GUI_BOX box) {
/* 308 */     double price = (FACTIONS.player()).trade.pricesBuy.get((MAPPED)this.tradable);
/* 309 */     hoverTradeValue(price, box);
/*     */   }
/*     */   
/*     */   public abstract void hoverTradeValue(double paramDouble, GUI_BOX paramGUI_BOX);
/*     */   
/*     */   public abstract double capacityValue();
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\trade\PBuyer.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */