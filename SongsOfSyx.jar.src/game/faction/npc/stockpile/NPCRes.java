/*     */ package game.faction.npc.stockpile;
/*     */ 
/*     */ import game.VERSION;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.royalty.opinion.ROPINION;
/*     */ import game.faction.trade.FBUYER;
/*     */ import game.faction.trade.FSELLER;
/*     */ import game.faction.trade.TradeManager;
/*     */ import init.trade.TRADABLE;
/*     */ import init.trade.TRADE_TYPE;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.recipe.Recipe;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import world.region.RD;
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class NPCRes
/*     */   implements SAVABLE
/*     */ {
/*     */   public final TRADABLE res;
/*     */   private final NPCStockpile s;
/*  30 */   private double offset = 0.0D;
/*     */   private double playerOffset;
/*  32 */   private double totRate = 1.0D;
/*  33 */   private double rate = 1.0D;
/*     */   
/*     */   private int ri;
/*     */   
/*     */   public final FBUYER buyer;
/*     */   
/*     */   public final FSELLER seller;
/*     */ 
/*     */   
/*     */   public void save(FilePutter file) {
/*  43 */     file.d(this.totRate);
/*  44 */     file.d(this.rate);
/*  45 */     file.d(this.offset);
/*  46 */     file.d(this.playerOffset);
/*  47 */     file.i(this.ri);
/*     */   }
/*     */ 
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/*  52 */     this.totRate = file.d();
/*  53 */     this.rate = file.d();
/*  54 */     this.offset = file.d();
/*  55 */     this.playerOffset = file.d();
/*  56 */     if (!VERSION.versionIsBefore(71, 5)) {
/*  57 */       this.ri = file.i();
/*     */     }
/*     */   }
/*     */   
/*     */   public void clear() {
/*  62 */     this.totRate = 1.0D;
/*  63 */     this.rate = 1.0D;
/*  64 */     this.offset = 0.0D;
/*  65 */     this.playerOffset = 0.0D;
/*     */   }
/*     */   
/*     */   void update(TRADABLE re, FactionNPC f) {
/*  69 */     Recipe r = (SETT.RECIPES()).rates.bestRecipe((BOOSTABLE_O)f, re);
/*  70 */     this.ri = r.index;
/*  71 */     this.rate = 1.0D / r.manpower((BOOSTABLE_O)f);
/*  72 */     this.totRate = 1.0D / r.manpowerTotal((BOOSTABLE_O)f);
/*     */   }
/*     */   
/*     */   public double amount() {
/*  76 */     return amountTarget() + this.offset;
/*     */   }
/*     */   
/*     */   public double amountTarget() {
/*  80 */     return 1.0D + this.rate * this.s.workforce();
/*     */   }
/*     */   
/*     */   public double rate() {
/*  84 */     return this.rate;
/*     */   }
/*     */   
/*     */   public double rateTot() {
/*  88 */     return this.totRate;
/*     */   }
/*     */   
/*     */   public Recipe recipe() {
/*  92 */     return (Recipe)SETT.RECIPES().all().get(this.ri);
/*     */   }
/*     */   
/*     */   public double priceBase() {
/*  96 */     double totRate = rateTot();
/*  97 */     if (totRate == 0.0D)
/*  98 */       return 4000000.0D; 
/*  99 */     return 400.0D / totRate + 20.0D;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int priceAt(int added) {
/* 105 */     double price = amMulAt(added);
/* 106 */     price *= this.s.creditScore() * priceBase() * this.s.f.race().pref().priceMul(this.res);
/*     */ 
/*     */     
/* 109 */     if (added > 0)
/* 110 */       return (int)price - 1; 
/* 111 */     if (added < 0) {
/* 112 */       return (int)(Math.ceil(price) + 1.0D);
/*     */     }
/* 114 */     return (int)price;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double dailyConsumption() {
/* 121 */     double overflow = offset();
/* 122 */     if (overflow == 0.0D)
/* 123 */       return 0.0D; 
/* 124 */     double target = amountTarget();
/*     */     
/* 126 */     double delta = overflow / target;
/* 127 */     delta = CLAMP.d(delta, -10.0D, 10.0D);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 132 */     double am = (recipe()).aiRecovery * Updater.recoveryRate * overflow;
/*     */     
/* 134 */     if (overflow > 0.0D) {
/*     */       
/* 136 */       am = Math.max(am, -overflow);
/*     */     } else {
/*     */       
/* 139 */       am = Math.min(am, -overflow);
/*     */     } 
/* 141 */     return am;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int priceSellP() {
/* 147 */     return priceAt(-1) + TradeManager.totalFee((Faction)this.s.f, (Faction)FACTIONS.player(), RD.DIST().distance((Faction)this.s.f), this.res, 1);
/*     */   }
/*     */   
/*     */   public int priceBuyP() {
/* 151 */     return priceAt(1) - TradeManager.totalFee((Faction)FACTIONS.player(), (Faction)this.s.f, RD.DIST().distance((Faction)this.s.f), this.res, 1);
/*     */   }
/*     */   
/*     */   public double amMulAt(int added) {
/* 155 */     double dd = amMul(amount() + added);
/*     */     
/* 157 */     if (added > 0) {
/* 158 */       if (dd < 1.0D)
/* 159 */         return dd; 
/* 160 */       return CLAMP.d(dd - 0.4D, 1.0D, 2.0D);
/* 161 */     }  if (added < 0) {
/* 162 */       if (dd > 1.0D)
/* 163 */         return dd; 
/* 164 */       return CLAMP.d(dd + 0.4D, 0.5D, 1.0D);
/*     */     } 
/* 166 */     return 1.0D;
/*     */   }
/*     */   
/*     */   private double amMul(double amount) {
/* 170 */     amount = Math.round(amount);
/* 171 */     double tar = amountTarget();
/* 172 */     if (amount <= 0.0D)
/* 173 */       return 10.0D; 
/* 174 */     tar /= amount;
/* 175 */     tar = CLAMP.d(tar, 0.1D, 10.0D);
/* 176 */     return tar;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double offset() {
/* 183 */     return this.offset;
/*     */   }
/*     */   
/*     */   public void inc(double am) {
/* 187 */     this.offset += am;
/*     */   }
/*     */   
/*     */   public void playerSet(double d) {
/* 191 */     this.playerOffset = d;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double playerTraded() {
/* 199 */     return this.playerOffset;
/*     */   }
/*     */ 
/*     */   
/*     */   public double playerTarif(int amount) {
/* 204 */     double off = playerTraded();
/* 205 */     double d = pPlayerTarif((int)(Math.abs(off) + Math.abs(amount)));
/* 206 */     d += pPlayerTarif((int)Math.abs(off));
/* 207 */     return d * 0.5D;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private double pPlayerTarif(int traded) {
/* 218 */     return 0.0D;
/*     */   }
/*     */   NPCRes(NPCStockpile f, TRADABLE tradable) {
/* 221 */     this.buyer = new FBUYER()
/*     */       {
/*     */         public int addPrice(int amount)
/*     */         {
/* 225 */           if (amount <= 0)
/* 226 */             return 0; 
/* 227 */           return amount * (NPCRes.this.priceAt(1) + NPCRes.this.priceAt(amount)) / 2;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void addDeliver(int amount, TRADE_TYPE type) {}
/*     */ 
/*     */ 
/*     */         
/*     */         public void addReserve(int amount, TRADE_TYPE type, int price, Faction seller) {
/* 237 */           NPCRes.this.s.f.credits().inc(-price, type.ctype, NPCRes.this.res, amount);
/* 238 */           NPCRes.this.s.f.res().inc(NPCRes.this.res, type.rtype, amount);
/* 239 */           NPCRes.this.offset += amount;
/* 240 */           if (seller == FACTIONS.player()) {
/* 241 */             NPCRes.this.playerOffset += amount;
/* 242 */             ROPINION.trade(NPCRes.this.s.f, price);
/*     */           } 
/*     */         }
/*     */ 
/*     */         
/*     */         public double buyPriority(int amount, double price) {
/* 248 */           if (2.147483647E9D - NPCRes.this.amount() < amount)
/* 249 */             return 0.0D; 
/* 250 */           return addPrice(amount) / price - 1.0D;
/*     */         }
/*     */       };
/*     */     
/* 254 */     this.seller = new FSELLER()
/*     */       {
/*     */         public int removePrice(int amount)
/*     */         {
/* 258 */           if (amount <= 0)
/* 259 */             return 0; 
/* 260 */           return amount * (NPCRes.this.priceAt(-1) + NPCRes.this.priceAt(-amount)) / 2;
/*     */         }
/*     */         
/*     */         public void remove(int amount, TRADE_TYPE type, int price, Faction buyer) {
/* 264 */           NPCRes.this.s.f.credits().inc(price, type.ctype, NPCRes.this.res, amount);
/* 265 */           NPCRes.this.s.f.res().inc(NPCRes.this.res, type.rtype, -amount);
/* 266 */           NPCRes.this.offset -= amount;
/* 267 */           if (buyer == FACTIONS.player()) {
/* 268 */             NPCRes.this.playerOffset -= amount;
/* 269 */             ROPINION.trade(NPCRes.this.s.f, price);
/*     */           } 
/*     */         }
/*     */ 
/*     */         
/*     */         public int removeMax() {
/* 275 */           return (int)NPCRes.this.amount();
/*     */         }
/*     */       };
/*     */     this.res = tradable;
/*     */     this.s = f;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\npc\stockpile\NPCRes.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */