/*     */ package settlement.trade;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.VERSION;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.FResources;
/*     */ import game.faction.Faction;
/*     */ import game.faction.diplomacy.DIP;
/*     */ import game.faction.trade.FSELLER;
/*     */ import init.trade.TRADABLE;
/*     */ import init.trade.TRADE_TYPE;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.INT;
/*     */ import util.data.INT_O;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.keymap.MAPPED;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import world.region.RD;
/*     */ 
/*     */ 
/*     */ public abstract class PSeller
/*     */   implements FSELLER, SAVABLE
/*     */ {
/*  33 */   private static CharSequence ¤¤priceCapProblem = "The current price is below your price cap. To trade, you must disable or decrease the price cap.";
/*  34 */   private static CharSequence ¤¤NoPrice = "¤There is no one willing to buy this goods. You must decrease either the tariff or the toll.";
/*  35 */   private static CharSequence ¤¤NoGoods = "¤There are no goods available to sell.";
/*  36 */   private static CharSequence ¤¤Owned = "¤Owned";
/*  37 */   private static CharSequence ¤¤Inbound = "¤Outbound";
/*  38 */   private static CharSequence ¤¤Forsale = "¤For Sale";
/*  39 */   private static CharSequence ¤¤PriceCap = "¤Price Cap";
/*  40 */   private static CharSequence ¤¤BestPrice = "¤Best price.";
/*     */   
/*  42 */   private static CharSequence ¤¤Profit = "¤Profit";
/*  43 */   private static CharSequence ¤¤ProfitD = "¤Your workers can currently produce this ware at the speed of {0} items per day per worker. If you sell such an amount at the price of {1}, you will earn {2} denarii.";
/*     */   
/*     */   public final TRADABLE type;
/*     */   
/*     */   static {
/*  48 */     D.ts(PSeller.class);
/*     */   }
/*     */ 
/*     */   
/*  52 */   final TradableData promised = new TradableData();
/*  53 */   public INT.IntImp priceCapsI = new INT.IntImp(1, 10000000);
/*     */   public final INT.IntImp limit;
/*     */   
/*  56 */   public final INT_O<TRADE_TYPE> outbound = new INT_O<TRADE_TYPE>()
/*     */     {
/*     */       public int min(TRADE_TYPE t)
/*     */       {
/*  60 */         return 0;
/*     */       }
/*     */ 
/*     */       
/*     */       public int max(TRADE_TYPE t) {
/*  65 */         return Integer.MAX_VALUE;
/*     */       }
/*     */ 
/*     */       
/*     */       public int get(TRADE_TYPE t) {
/*  70 */         return PSeller.this.promised.get(t) + PSeller.this.attempting(t);
/*     */       }
/*     */     };
/*     */   
/*     */   PSeller(TRADABLE type, INT.IntImp limit) {
/*  75 */     this.type = type;
/*  76 */     this.limit = limit;
/*     */   }
/*     */ 
/*     */   
/*     */   public void save(FilePutter file) {
/*  81 */     this.promised.save(file);
/*  82 */     this.priceCapsI.save(file);
/*  83 */     this.limit.save(file);
/*     */   }
/*     */ 
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/*  88 */     this.promised.load(file);
/*  89 */     this.priceCapsI.load(file);
/*  90 */     if (!VERSION.versionIsBefore(71, 14)) {
/*  91 */       this.limit.load(file);
/*     */     }
/*     */   }
/*     */   
/*     */   public void clear() {
/*  96 */     this.promised.clear();
/*  97 */     this.priceCapsI.clear();
/*  98 */     this.limit.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public abstract int playerOwned();
/*     */ 
/*     */   
/*     */   public abstract CharSequence exporting();
/*     */ 
/*     */   
/*     */   public abstract int attempting(TRADE_TYPE paramTRADE_TYPE);
/*     */ 
/*     */   
/*     */   public abstract int storedHistorically(int paramInt);
/*     */   
/*     */   protected final void extract() {
/* 114 */     if (SETT.ENTRY().isClosed()) {
/*     */       return;
/*     */     }
/* 117 */     if (this.promised.get((TRADE_TYPE)null) <= 0) {
/*     */       return;
/*     */     }
/* 120 */     for (TRADE_TYPE tt : TRADE_TYPE.all) {
/* 121 */       int am = this.promised.get(tt);
/* 122 */       this.promised.inc(tt, -extract(am, tt));
/*     */     } 
/*     */   }
/*     */   
/*     */   public INT_O<TRADE_TYPE> promised() {
/* 127 */     return (INT_O<TRADE_TYPE>)this.promised;
/*     */   }
/*     */ 
/*     */   
/*     */   protected abstract int extract(int paramInt, TRADE_TYPE paramTRADE_TYPE);
/*     */   
/*     */   public abstract double prio();
/*     */   
/*     */   public int removePrice(int amount) {
/* 136 */     return this.priceCapsI.get() * amount;
/*     */   }
/*     */ 
/*     */   
/*     */   public void remove(int amount, TRADE_TYPE type, int price, Faction buyer) {
/* 141 */     FACTIONS.player().credits().inc(price, type.ctype, this.type, amount);
/* 142 */     this.promised.inc(type, amount);
/* 143 */     (GAME.count()).TRADE_SALES.inc(price);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract void vanish(int paramInt, FResources.RTYPE paramRTYPE);
/*     */ 
/*     */ 
/*     */   
/*     */   public CharSequence problem() {
/* 154 */     if (RD.DIST().neighs().size() == 0) {
/* 155 */       return Dic.¤¤noTrade;
/*     */     }
/*     */     
/* 158 */     if (DIP.traders().size() == 0) {
/* 159 */       return Dic.¤¤noTradePartners;
/*     */     }
/* 161 */     if ((FACTIONS.player()).trade.pricesSell.get((MAPPED)this.type) <= 0) {
/* 162 */       return ¤¤NoPrice;
/*     */     }
/*     */     
/* 165 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence warning() {
/* 170 */     if (playerOwned() <= 0) {
/* 171 */       return ¤¤NoGoods;
/*     */     }
/* 173 */     if ((FACTIONS.player()).trade.pricesSell.get((MAPPED)this.type) > 0 && (FACTIONS.player()).trade.pricesSell.get((MAPPED)this.type) < this.priceCapsI.get()) {
/* 174 */       return ¤¤priceCapProblem;
/*     */     }
/*     */ 
/*     */     
/* 178 */     return null;
/*     */   }
/*     */   
/*     */   public void hover(GUI_BOX bob) {
/* 182 */     GBox b = (GBox)bob;
/* 183 */     b.title(this.type.names);
/*     */     
/* 185 */     if (problem() != null) {
/* 186 */       b.error(problem());
/* 187 */       b.NL();
/* 188 */     } else if (warning() != null) {
/* 189 */       b.error(warning());
/* 190 */       b.NL();
/*     */     } 
/*     */     
/* 193 */     hoverCapacity((GUI_BOX)b);
/* 194 */     b.NL(8);
/*     */     
/* 196 */     b.textLL(¤¤PriceCap);
/* 197 */     b.tab(6);
/* 198 */     b.add((SPRITE)GFORMAT.i(b.text(), this.priceCapsI.get()));
/* 199 */     b.NL();
/*     */ 
/*     */     
/* 202 */     b.textLL(¤¤BestPrice);
/* 203 */     b.tab(6);
/* 204 */     b.add((SPRITE)GFORMAT.i(b.text(), (FACTIONS.player()).trade.pricesSell.get((MAPPED)this.type)));
/* 205 */     b.NL();
/* 206 */     hoverTradeValue(bob);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract double capacityValue();
/*     */ 
/*     */   
/*     */   public void hoverCapacity(GUI_BOX bob) {
/* 215 */     GBox b = (GBox)bob;
/* 216 */     b.textLL(¤¤Owned);
/* 217 */     b.tab(6);
/* 218 */     b.add((SPRITE)GFORMAT.i(b.text(), playerOwned()));
/* 219 */     b.NL();
/*     */     
/* 221 */     b.textLL(¤¤Inbound);
/* 222 */     b.tab(6);
/* 223 */     b.add((SPRITE)GFORMAT.i(b.text(), this.outbound.get(null)));
/* 224 */     b.NL();
/* 225 */     for (TRADE_TYPE t : TRADE_TYPE.all) {
/* 226 */       int am = this.outbound.get(t);
/* 227 */       if (am > 0) {
/* 228 */         b.tab(1);
/* 229 */         b.textL(t.name);
/* 230 */         b.tab(6);
/* 231 */         b.add((SPRITE)GFORMAT.i(b.text(), am));
/*     */       } 
/* 233 */       b.NL();
/*     */     } 
/* 235 */     b.textLL(¤¤Forsale);
/* 236 */     b.tab(6);
/* 237 */     b.add((SPRITE)GFORMAT.i(b.text(), removeMax()));
/* 238 */     b.NL();
/*     */   }
/*     */ 
/*     */   
/*     */   public final int tradeCredits() {
/* 243 */     return tradeCredits((FACTIONS.player()).trade.pricesBuy.get((MAPPED)this.type));
/*     */   }
/*     */   
/*     */   public final double tradeValue() {
/* 247 */     double p = tradeCredits();
/* 248 */     p /= 400.0D;
/* 249 */     return p;
/*     */   }
/*     */ 
/*     */   
/*     */   public abstract int tradeCredits(int paramInt);
/*     */ 
/*     */   
/*     */   public abstract double tradeValue(int paramInt);
/*     */   
/*     */   public abstract void hoverTradeValue(GUI_BOX paramGUI_BOX);
/*     */   
/*     */   public void hoverTradeValue(double price, GUI_BOX box) {
/* 261 */     GBox b = (GBox)box;
/* 262 */     b.NL();
/* 263 */     double rate = (SETT.RECIPES()).player.rateTotal(this.type);
/* 264 */     double d = price / rate;
/* 265 */     b.textLL(¤¤Profit);
/* 266 */     b.tab(6);
/* 267 */     b.add((SPRITE)GFORMAT.iIncr(b.text(), (int)d));
/* 268 */     b.NL();
/* 269 */     GText t = b.text();
/* 270 */     t.add(¤¤ProfitD);
/* 271 */     t.insert(0, 1.0D / rate, 1);
/* 272 */     t.insert(1, (int)price);
/* 273 */     t.insert(2, (int)d);
/* 274 */     b.add((SPRITE)t);
/*     */     
/* 276 */     b.NL();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\trade\PSeller.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */