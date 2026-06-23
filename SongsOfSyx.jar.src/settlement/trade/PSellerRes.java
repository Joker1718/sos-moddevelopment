/*     */ package settlement.trade;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.FResources;
/*     */ import init.resources.RESOURCE;
/*     */ import init.trade.TRADABLE;
/*     */ import init.trade.TRADABLEO;
/*     */ import init.trade.TRADE_TYPE;
/*     */ import settlement.main.SETT;
/*     */ import settlement.thing.halfEntity.caravan.Caravan;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.INT;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.keymap.MAPPED;
/*     */ import util.text.D;
/*     */ 
/*     */ class PSellerRes extends PSeller {
/*  20 */   private static CharSequence ¤¤ExportProblem = "¤You don't have any export depots set to this resource. No exporting can be done.";
/*  21 */   private static CharSequence ¤¤ExportFull = "¤Our export depots are full. We must increase their space if we are to export at full capacity.";
/*  22 */   private static CharSequence ¤¤prio = "¤Priority Limit";
/*  23 */   private static CharSequence ¤¤prioDD = "¤Export workers will only fetch from warehouses when at least {0}% of our warehouse crates are filled (At least {1} items stored). {2} items can currently be fetched.";
/*  24 */   private static CharSequence ¤¤ImportCapacity = "¤Export Capacity";
/*  25 */   private static CharSequence ¤¤ImportCapacityUsed = "¤Export Capacity Used";
/*  26 */   private static CharSequence ¤¤ImportCanBe = "¤Exports available"; private final TRADABLEO<RESOURCE> res;
/*     */   
/*     */   static {
/*  29 */     D.ts(PSellerRes.class);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   PSellerRes(TRADABLEO<RESOURCE> type) {
/*  35 */     super((TRADABLE)type, new INT.IntImp(0, 100));
/*  36 */     this.res = type;
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/*  41 */     this.limit.set(25);
/*  42 */     super.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public int playerOwned() {
/*  47 */     return ((RESOURCE)this.res.t).owned();
/*     */   }
/*     */ 
/*     */   
/*     */   public double prio() {
/*  52 */     double cap = (SETT.ROOMS()).EXPORT.tally.capacity.get(this.res.t);
/*  53 */     if (cap <= 0.0D)
/*  54 */       return 0.0D; 
/*  55 */     double ava = ((SETT.ROOMS()).EXPORT.tally.amount.get(this.res.t) - this.promised.get((TRADE_TYPE)null));
/*  56 */     if (ava <= 0.0D) {
/*  57 */       return 0.0D;
/*     */     }
/*  59 */     return ava / cap;
/*     */   }
/*     */ 
/*     */   
/*     */   public int removeMax() {
/*  64 */     if (SETT.ENTRY().isClosed())
/*  65 */       return 0; 
/*  66 */     return (SETT.ROOMS()).EXPORT.tally.amount.get(this.res.t) - this.promised.get((TRADE_TYPE)null);
/*     */   }
/*     */ 
/*     */   
/*     */   public int attempting(TRADE_TYPE t) {
/*  71 */     return (SETT.HALFENTS()).caravans.withdrawals((RESOURCE)this.res.t, t);
/*     */   }
/*     */ 
/*     */   
/*     */   protected int extract(int amount, TRADE_TYPE t) {
/*  76 */     int am = 0;
/*     */     
/*  78 */     while (amount > 0) {
/*  79 */       int a = Math.min(amount, Caravan.MAX_LOAD);
/*  80 */       if (!(SETT.HALFENTS()).caravans.createFetcher((RESOURCE)this.res.t, a, t))
/*  81 */         return am; 
/*  82 */       am += a;
/*  83 */       amount -= a;
/*     */     } 
/*  85 */     return am;
/*     */   }
/*     */ 
/*     */   
/*     */   public void vanish(int amount, FResources.RTYPE t) {
/*  90 */     ((RESOURCE)this.res.t).remove(amount, t);
/*     */   }
/*     */ 
/*     */   
/*     */   public int storedHistorically(int daysBack) {
/*  95 */     return (SETT.ROOMS()).STOCKPILE.tally().amountsDay().get(((RESOURCE)this.res.t).index()).get(daysBack);
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence warning() {
/* 100 */     if ((SETT.ROOMS()).EXPORT.tally.amount.get(this.res.t) >= (SETT.ROOMS()).EXPORT.tally.capacity.get(this.res.t)) {
/* 101 */       return ¤¤ExportFull;
/*     */     }
/*     */     
/* 104 */     return super.warning();
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence exporting() {
/* 109 */     if ((SETT.ROOMS()).EXPORT.tally.capacity.get(this.res.t) > 0)
/* 110 */       return null; 
/* 111 */     return ¤¤ExportProblem;
/*     */   }
/*     */ 
/*     */   
/*     */   public double capacityValue() {
/* 116 */     double am = (SETT.ROOMS()).EXPORT.tally.capacity.get(this.res.t);
/* 117 */     if (am == 0.0D) {
/* 118 */       return 0.0D;
/*     */     }
/* 120 */     return (SETT.ROOMS()).EXPORT.tally.amount.get(this.res.t) / am;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int tradeCredits(int price) {
/* 127 */     double rate = (SETT.RECIPES()).player.rateTotal(this.type);
/* 128 */     return SETT.TRADE().tradeCredits(price, rate);
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverTradeValue(GUI_BOX box) {
/* 133 */     double price = (FACTIONS.player()).trade.pricesSell.get((MAPPED)this.type);
/* 134 */     hoverTradeValue(price, box);
/*     */   }
/*     */ 
/*     */   
/*     */   public double tradeValue(int price) {
/* 139 */     double p = tradeCredits(price);
/* 140 */     p /= 400.0D;
/* 141 */     return p;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void hoverCapacity(GUI_BOX bob) {
/* 147 */     super.hoverCapacity(bob);
/*     */     
/* 149 */     GBox b = (GBox)bob;
/*     */     
/* 151 */     b.textLL(¤¤ImportCapacity);
/* 152 */     b.tab(6);
/* 153 */     b.add((SPRITE)GFORMAT.i(b.text(), (SETT.ROOMS()).EXPORT.tally.capacity.get(this.res.t)));
/* 154 */     b.NL();
/*     */     
/* 156 */     b.textLL(¤¤ImportCapacityUsed);
/* 157 */     b.tab(6);
/* 158 */     b.add((SPRITE)GFORMAT.i(b.text(), (SETT.ROOMS()).EXPORT.tally.amount.get(this.res.t)));
/* 159 */     b.NL();
/*     */     
/* 161 */     b.textLL(¤¤ImportCanBe);
/* 162 */     b.tab(6);
/* 163 */     b.add((SPRITE)GFORMAT.i(b.text(), (
/* 164 */           (SETT.ROOMS()).EXPORT.tally.capacity.get(this.res.t) - (SETT.ROOMS()).EXPORT.tally.amount.get(this.res.t))));
/* 165 */     b.NL();
/*     */     
/* 167 */     b.textLL(¤¤prio);
/* 168 */     b.NL();
/* 169 */     GText t = b.text();
/* 170 */     t.add(¤¤prioDD);
/* 171 */     t.insert(0, 100 - this.limit.get());
/* 172 */     t.insert(1, (SETT.ROOMS()).EXPORT.prioFetchAmount((RESOURCE)this.res.t));
/* 173 */     t.insert(2, (SETT.ROOMS()).EXPORT.prioFetchAvailable((RESOURCE)this.res.t));
/* 174 */     b.add((SPRITE)t);
/* 175 */     b.NL();
/*     */     
/* 177 */     b.textLL((SETT.ROOMS()).STOCKPILE.info.names);
/* 178 */     b.NL();
/* 179 */     b.textL(((SETT.ROOMS()).STOCKPILE.tally()).space.name);
/* 180 */     b.tab(6);
/* 181 */     b.add((SPRITE)GFORMAT.i(b.text(), ((SETT.ROOMS()).STOCKPILE.tally()).space.total((RESOURCE)this.res.t)));
/* 182 */     b.NL();
/* 183 */     b.textL(((SETT.ROOMS()).STOCKPILE.tally()).amount.name);
/* 184 */     b.tab(6);
/* 185 */     b.add((SPRITE)GFORMAT.i(b.text(), ((SETT.ROOMS()).STOCKPILE.tally()).amount.total((RESOURCE)this.res.t)));
/* 186 */     b.NL();
/*     */     
/* 188 */     super.hoverCapacity(bob);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\trade\PSellerRes.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */