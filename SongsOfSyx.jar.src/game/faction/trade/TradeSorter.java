/*     */ package game.faction.trade;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.player.Player;
/*     */ import init.trade.TR;
/*     */ import init.trade.TRADABLE;
/*     */ import init.trade.TRADE_TYPE;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.Tree;
/*     */ 
/*     */ 
/*     */ final class TradeSorter
/*     */ {
/*  19 */   private final ResTree[] resTrees = new ResTree[TR.ALL().size()];
/*  20 */   private final Tree<ResTree> tree = new Tree<ResTree>(TR.ALL().size())
/*     */     {
/*     */       protected boolean isGreaterThan(TradeSorter.ResTree current, TradeSorter.ResTree cmp)
/*     */       {
/*  24 */         return (current.value > cmp.value);
/*     */       }
/*     */     };
/*     */   
/*  28 */   private Holder[] holders = new Holder[FACTIONS.MAX() * TR.ALL().size()]; private boolean logPlayerSelling = false;
/*     */   private boolean logPlayerBuying = false;
/*     */   private boolean logAll = false;
/*     */   
/*     */   public TradeSorter() {
/*     */     int i;
/*  34 */     for (i = 0; i < this.resTrees.length; i++)
/*  35 */       this.resTrees[i] = new ResTree((TRADABLE)TR.ALL().get(i)); 
/*  36 */     for (i = 0; i < this.holders.length; i++)
/*  37 */       this.holders[i] = new Holder(); 
/*     */   }
/*     */   
/*     */   public void sellPlayer(TradeShipper shipper) {
/*  41 */     Player player = FACTIONS.player();
/*  42 */     this.tree.clear();
/*  43 */     int hI = 0;
/*  44 */     if (shipper.partners() <= 0) {
/*     */       return;
/*     */     }
/*  47 */     if (this.logPlayerSelling) {
/*  48 */       LOG.ln("player sell time");
/*     */     }
/*     */     
/*  51 */     for (int ri = 0; ri < TR.ALL().size(); ri++) {
/*  52 */       TRADABLE r = (TRADABLE)TR.ALL().get(ri);
/*  53 */       ResTree t = this.resTrees[r.index()];
/*  54 */       t.traders.clear();
/*     */       
/*  56 */       if (player.seller(r).removeMax() > 0) {
/*     */ 
/*     */         
/*  59 */         if (this.logPlayerSelling) {
/*  60 */           LOG.ln("player wants to sell " + String.valueOf(r) + " min: " + player.seller(r).removePrice(1) + " prio: " + player.seller(r).prio());
/*     */         }
/*     */         
/*  63 */         for (int i = 0; i < shipper.partners(); i++) {
/*     */           
/*  65 */           TradeShipper.Partner buyer = shipper.partner(i);
/*     */           
/*  67 */           int price = sellPriceItemPlayer(r, 1, buyer.faction(), buyer.distance());
/*  68 */           if (this.logPlayerSelling) {
/*  69 */             LOG.ln(String.valueOf((buyer.faction()).name) + " bids " + String.valueOf((buyer.faction()).name));
/*     */           }
/*  71 */           if (price >= 0)
/*     */           {
/*     */             
/*  74 */             if (price >= player.seller(r).removePrice(1)) {
/*     */ 
/*     */               
/*  77 */               Holder h = this.holders[hI++];
/*     */               
/*  79 */               h.p = buyer;
/*  80 */               h.value = price;
/*  81 */               h.price = price;
/*  82 */               t.traders.add(h);
/*     */             } 
/*     */           }
/*     */         } 
/*  86 */         if (this.logPlayerSelling) {
/*  87 */           LOG.ln("player has " + (this.resTrees[r.index()]).traders.size() + " bidders");
/*     */         }
/*     */         
/*  90 */         if ((this.resTrees[r.index()]).traders.size() > 0) {
/*  91 */           t.value = player.seller(r).prio();
/*  92 */           this.tree.add(t);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  98 */     while (this.tree.hasMore()) {
/*  99 */       ResTree t = (ResTree)this.tree.pollGreatest();
/* 100 */       Holder h = (Holder)t.traders.pollGreatest();
/*     */ 
/*     */       
/* 103 */       int forSale = player.seller(t.res).removeMax();
/*     */       
/* 105 */       if (this.logPlayerSelling) {
/* 106 */         LOG.ln("player auctions " + String.valueOf(t.res) + " has for sale: " + forSale + " to " + String.valueOf((h.p.faction()).name));
/*     */       }
/*     */       
/* 109 */       if (forSale <= 0) {
/*     */         continue;
/*     */       }
/* 112 */       int nextPrice = 0;
/* 113 */       if (t.traders.hasMore()) {
/* 114 */         Holder h2 = (Holder)t.traders.smallest();
/* 115 */         nextPrice = (int)(h2.price * 0.75D);
/*     */       } 
/*     */       
/* 118 */       int minPrice = player.seller(t.res).removePrice(1);
/*     */       
/* 120 */       if (this.logPlayerSelling) {
/* 121 */         LOG.ln("bid is " + player.seller(t.res).removePrice(1) + " player accepts minimum: " + nextPrice + "/ " + minPrice);
/*     */       }
/*     */ 
/*     */       
/* 125 */       int low = 1;
/* 126 */       int high = forSale;
/* 127 */       int am = 0;
/*     */       
/* 129 */       while (low <= high) {
/* 130 */         int mid = low + (high - low) / 2;
/*     */         
/* 132 */         int p = sellPriceItemPlayer(t.res, mid, h.p.faction(), h.p.distance());
/*     */         
/* 134 */         if (this.logPlayerSelling) {
/* 135 */           LOG.ln("selling " + mid + " pieces will net " + p + " / " + minPrice);
/*     */         }
/*     */         
/* 138 */         if (p >= minPrice && p >= nextPrice) {
/* 139 */           am = mid;
/* 140 */           low = mid + 1; continue;
/*     */         } 
/* 142 */         high = mid - 1;
/*     */       } 
/*     */ 
/*     */       
/* 146 */       if (this.logPlayerSelling) {
/* 147 */         LOG.ln("player decides to sell " + am + " pieces to " + String.valueOf((h.p.faction()).name));
/*     */       }
/*     */       
/* 150 */       if (am > 0) {
/*     */ 
/*     */         
/* 153 */         int price = h.p.faction().buyer(t.res).addPrice(am) - TradeManager.totalFee((Faction)FACTIONS.player(), h.p.faction(), h.p.distance(), t.res, am);
/*     */         
/* 155 */         if (this.logPlayerSelling) {
/* 156 */           LOG.ln("player sells " + am + " " + String.valueOf(t.res) + " at " + price + " " + price / am + " to " + String.valueOf((h.p.faction()).name));
/*     */         }
/*     */ 
/*     */         
/* 160 */         h.p.trade(t.res, am);
/*     */         
/* 162 */         h.p.faction().buyer(t.res).addReserve(am, TRADE_TYPE.trade, price, (Faction)player);
/* 163 */         player.seller(t.res).remove(am, TRADE_TYPE.trade, price, h.p.faction());
/*     */         
/* 165 */         if (player.seller(t.res).removeMax() > 0) {
/* 166 */           price = sellPriceItemPlayer(t.res, 1, h.p.faction(), h.p.distance());
/* 167 */           if (price > 0 && price > player.seller(t.res).removePrice(1)) {
/* 168 */             h.value = price;
/* 169 */             h.price = price;
/* 170 */             t.traders.add(h);
/*     */           } 
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/* 176 */         if (t.traders.size() > 0) {
/* 177 */           t.value = player.seller(t.res).prio();
/* 178 */           this.tree.add(t);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 185 */     if (this.logPlayerSelling) {
/* 186 */       LOG.ln();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private int minLoad(TRADABLE t) {
/* 192 */     return CLAMP.i((int)(1.0D / (SETT.RECIPES()).ratesV.vanillaRate(t) * 32.0D), 1, 512);
/*     */   }
/*     */ 
/*     */   
/*     */   private int sellPriceItemPlayer(TRADABLE res, int am, Faction buyer, double distance) {
/* 197 */     FactionNPC f = (FactionNPC)buyer;
/* 198 */     int price = f.res(res).priceAt(am);
/* 199 */     double toll = TradeManager.totalFee((Faction)FACTIONS.player(), buyer, distance, res, am) / am;
/* 200 */     price = (int)(price - toll);
/* 201 */     return price;
/*     */   }
/*     */ 
/*     */   
/*     */   void buy(Faction buyer, TradeShipper shipper) {
/* 206 */     this.tree.clear();
/* 207 */     int hI = 0;
/*     */     
/* 209 */     boolean plog = (buyer == FACTIONS.player() && this.logPlayerBuying);
/*     */     
/* 211 */     if (plog) {
/* 212 */       LOG.ln("player is buying");
/*     */     }
/* 214 */     for (TRADABLE resource : TR.ALL()) {
/*     */       
/* 216 */       ResTree resSort = this.resTrees[resource.index()];
/* 217 */       resSort.traders.clear();
/* 218 */       int batch = (buyer == FACTIONS.player()) ? 1 : minLoad(resource);
/* 219 */       if (buyer != GAME.player() && buyer.buyer(resource).addPrice(1) <= 0) {
/*     */         continue;
/*     */       }
/* 222 */       for (int i = 0; i < shipper.partners(); i++) {
/*     */         
/* 224 */         TradeShipper.Partner seller = shipper.partner(i);
/*     */         
/* 226 */         if (seller.faction() != buyer)
/*     */         {
/*     */           
/* 229 */           if (seller.faction() != FACTIONS.player())
/*     */           {
/*     */             
/* 232 */             if (seller.faction().seller(resource).removeMax() > batch) {
/*     */ 
/*     */               
/* 235 */               int price = seller.faction().seller(resource).removePrice(batch) + TradeManager.totalFee(seller.faction(), buyer, seller.distance(), resource, batch);
/* 236 */               double v = buyer.buyer(resource).buyPriority(batch, price);
/*     */ 
/*     */               
/* 239 */               if (v > 0.0D) {
/* 240 */                 if (plog) {
/* 241 */                   LOG.ln("player wants " + String.valueOf(resource) + " from " + String.valueOf((seller.faction()).name) + " " + v + " " + price);
/*     */                 }
/* 243 */                 Holder h = this.holders[hI++];
/* 244 */                 h.p = seller;
/* 245 */                 h.value = -price;
/* 246 */                 h.price = price;
/* 247 */                 resSort.traders.add(h);
/*     */               } 
/*     */             }  }  } 
/*     */       } 
/* 251 */       if (resSort.traders.hasMore()) {
/* 252 */         double v = buyer.buyer(resource).buyPriority(batch, ((Holder)resSort.traders.greatest()).price);
/* 253 */         resSort.value = v;
/* 254 */         this.tree.add(resSort);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 259 */     while (this.tree.hasMore()) {
/*     */       
/* 261 */       ResTree res = (ResTree)this.tree.pollGreatest();
/* 262 */       Holder seller = (Holder)res.traders.pollGreatest();
/* 263 */       int batch = (buyer == FACTIONS.player()) ? 1 : minLoad(res.res);
/* 264 */       int am = Math.min(batch, seller.p.faction().seller(res.res).removeMax());
/* 265 */       int sellPrice = seller.price;
/* 266 */       double v = buyer.buyer(res.res).buyPriority(batch, sellPrice);
/*     */ 
/*     */ 
/*     */       
/* 270 */       if (v <= 0.0D || am <= 0) {
/* 271 */         res.traders.clear();
/*     */         continue;
/*     */       } 
/* 274 */       if (plog) {
/* 275 */         LOG.ln("player buying " + String.valueOf(res.res));
/*     */       }
/*     */       
/* 278 */       if (buyer == FACTIONS.player()) {
/*     */         
/* 280 */         Holder h2 = res.traders.hasMore() ? (Holder)res.traders.smallest() : null;
/*     */         
/* 282 */         int low = 0;
/* 283 */         int high = minLoad(res.res);
/* 284 */         am = 0;
/*     */         
/* 286 */         while (low <= high) {
/* 287 */           int mid = low + (high - low) / 2;
/* 288 */           sellPrice = seller.p.faction().seller(res.res).removePrice(mid) + TradeManager.totalFee(seller.p.faction(), buyer, seller.p.distance(), res.res, mid);
/* 289 */           double p = buyer.buyer(res.res).buyPriority(mid, sellPrice);
/*     */           
/* 291 */           if (plog) {
/* 292 */             LOG.ln("buying " + mid + " pieces will cost " + sellPrice + " " + p);
/*     */           }
/*     */           
/* 295 */           if (p <= 0.0D || (h2 != null && p < h2.p.faction().buyer(res.res).buyPriority(am, (h2.p.faction().seller(res.res).removePrice(am) + TradeManager.totalFee(h2.p.faction(), buyer, h2.p.distance(), res.res, am))))) {
/* 296 */             high = mid - 1; continue;
/*     */           } 
/* 298 */           am = mid;
/* 299 */           low = mid + 1;
/*     */         } 
/*     */ 
/*     */         
/* 303 */         if (plog) {
/* 304 */           LOG.ln("player buys " + String.valueOf(res.res) + " " + am + " for " + sellPrice + " " + sellPrice / am + " from " + String.valueOf((seller.p.faction()).name));
/* 305 */           if (sellPrice > FACTIONS.player().credits().credits()) {
/* 306 */             LOG.ln("wtf " + sellPrice + "  " + buyer.buyer(res.res).buyPriority(am, sellPrice));
/*     */           }
/*     */         }
/*     */       
/*     */       }
/* 311 */       else if (this.logAll) {
/* 312 */         LOG.ln(String.valueOf(buyer.name) + " buys " + String.valueOf(buyer.name) + " " + String.valueOf(res.res) + " for " + am + " " + sellPrice + " from " + sellPrice / am);
/* 313 */         LOG.ln(String.valueOf(buyer.name) + " buys " + String.valueOf(buyer.name) + " bids " + String.valueOf(res.res) + " buys for " + buyer.buyer(res.res).addPrice(1) + " from " + sellPrice / am + " fee " + String.valueOf(seller.p.faction()));
/*     */       } 
/*     */       
/* 316 */       seller.p.trade(res.res, am);
/* 317 */       buyer.buyer(res.res).addReserve(am, TRADE_TYPE.trade, sellPrice, seller.p.faction());
/* 318 */       seller.p.faction().seller(res.res).remove(am, TRADE_TYPE.trade, sellPrice, buyer);
/*     */ 
/*     */       
/* 321 */       am = batch;
/*     */       
/* 323 */       if (seller.p.faction().seller(res.res).removeMax() > batch) {
/*     */         
/* 325 */         int price = seller.p.faction().seller(res.res).removePrice(batch) + TradeManager.totalFee(seller.p.faction(), buyer, seller.p.distance(), res.res, batch);
/* 326 */         v = buyer.buyer(res.res).buyPriority(batch, price);
/* 327 */         if (v > 0.0D) {
/* 328 */           seller.price = price;
/* 329 */           seller.value = -price;
/* 330 */           res.traders.add(seller);
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 335 */       if (res.traders.size() > 0) {
/*     */         
/* 337 */         Holder h = (Holder)res.traders.greatest();
/* 338 */         res.value = buyer.buyer(res.res).buyPriority(batch, h.price);
/* 339 */         if (res.value > 0.0D) {
/* 340 */           this.tree.add(res);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static class Holder
/*     */   {
/*     */     TradeShipper.Partner p;
/*     */     
/*     */     int price;
/*     */     
/*     */     private double value;
/*     */   }
/*     */ 
/*     */   
/*     */   private static class ResTree
/*     */   {
/*     */     double value;
/*     */     
/*     */     final TRADABLE res;
/*     */     final Tree<TradeSorter.Holder> traders;
/*     */     
/*     */     ResTree(TRADABLE res) {
/* 365 */       this.traders = new Tree<TradeSorter.Holder>(FACTIONS.MAX())
/*     */         {
/*     */           protected boolean isGreaterThan(TradeSorter.Holder current, TradeSorter.Holder cmp)
/*     */           {
/* 369 */             return (current.value > cmp.value);
/*     */           }
/*     */         };
/*     */       this.res = res;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\trade\TradeSorter.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */